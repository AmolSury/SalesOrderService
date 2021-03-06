package com.main.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.main.controller.RemoteCallItemService;
import com.main.entity.CustomerSOS;
import com.main.entity.SalesOrder;
import com.main.repository.CreateOrderRepository;
import com.main.repository.SalesOrderCustomerRepository;
import com.main.util.ProductNotValidException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class SalesOrderServiceImpl {

	private CreateOrderRepository createOrderRepository;

	private SalesOrderCustomerRepository salesOrderCustomerRepository;

	@Value("${itemservices.chkname}")
	String resourceUrl;

	/*@Autowired
	RestTemplate restTemplate;*/
	
	@Autowired
	RemoteCallItemService remoteCallItemService;
	
	@Autowired
    private JavaMailSender sender;

	@SuppressWarnings("unchecked")
	@HystrixCommand(fallbackMethod = "callItemServiceAndGetDataFallback") //Using Hystrix for Circuit Breaker
	public Long createSalesOrder(SalesOrder salesOrder) {

		//validate customer by verifying the table “customer_sos” with cust_id
		Optional<List<CustomerSOS>> customerSOS = getSalesOrderCustomerRepository()
				.findByCustId(salesOrder.getCustId());

		// validate items by calling item service with item name
		SalesOrder salesOrderStatus = null;
		String Url = resourceUrl + salesOrder.getOrderLineItem().get(0).getItemName();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Boolean> entity = new HttpEntity<Boolean>(headers);
		// Item Service Call
		//Optional<Boolean> isValid = restTemplate.exchange(Url, HttpMethod.GET, entity, Optional.class).getBody();

		Optional<Boolean> isValid = remoteCallItemService.getProductName(salesOrder.getOrderLineItem().get(0).getItemName());
		if (customerSOS.isPresent() && isValid.get().equals(Boolean.TRUE)) {
			salesOrderStatus = getCreateOrderRepository().saveAndFlush(salesOrder);
			
			//order confirmation mail
			/* MimeMessage message = sender.createMimeMessage();
		        MimeMessageHelper helper = new MimeMessageHelper(message);

		        try {
		            helper.setTo(customerSOS.get().get(0).getEmailId());
		            helper.setText("Greetings :)");
		            helper.setSubject("Mail From Spring Boot");
		        } catch (MessagingException e) {
		            //e.printStackTrace();
		            System.out.println("Error while sending mail ..");
		            //return "Error while sending mail ..";
		        }
		        sender.send(message);*/
			
			/*this.mailSender.send(mimeMessage -> {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(customerSOS.get().get(0).getEmailId()));
				mimeMessage.setFrom(new InternetAddress("asuryavanshi21@gmail.com"));
				StringBuilder messageBodyBldr = new StringBuilder();
				messageBodyBldr.append("Dear").append(customerSOS.get().get(0).getFirstName()).append(", ").append(customerSOS.get().get(0).getLastName()).append(", Thank you for your order.").append(salesOrder.getId()).append(", ");
				mimeMessage.setText(messageBodyBldr.toString());
			});*/
			
		} else {
			throw new ProductNotValidException("Product name otherwise customer Id is not valid");
		}
		return salesOrderStatus.getId();
	}
	
	@SuppressWarnings("unused")
    private Long callItemServiceAndGetDataFallback(SalesOrder salesOrder) {
        System.out.println("Item Service is down!!! fallback route enabled...");
        return new Long(0);
    }

	public List<SalesOrder> getSalesOrder() {
		return (List<SalesOrder>) getCreateOrderRepository().findAll();
	}

	public CreateOrderRepository getCreateOrderRepository() {
		return createOrderRepository;
	}

	@Autowired
	public void setCreateOrderRepository(CreateOrderRepository createOrderRepository) {
		this.createOrderRepository = createOrderRepository;
	}

	public SalesOrderCustomerRepository getSalesOrderCustomerRepository() {
		return salesOrderCustomerRepository;
	}

	@Autowired
	public void setSalesOrderCustomerRepository(SalesOrderCustomerRepository salesOrderCustomerRepository) {
		this.salesOrderCustomerRepository = salesOrderCustomerRepository;
	}

}
