package com.main.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="sales_order")
public class SalesOrder implements Serializable{

	/**
	 * @author Amol Suryavanshi
	 */
	private static final long serialVersionUID = 1242602927708204133L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id")
	private Long id;
	
	@Column(name="order_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	
	@Column(name="cust_id")
	private Long custId;
	
	@Column(name="order_desc")
	private String orderDesc;
	
	@Column(name="total_price")
	private Double totalPrice;
	
	/*@OneToMany
	@JoinColumn(name = "order_id")*/
	//@OneToMany(mappedBy = "salesOrder", cascade = CascadeType.ALL)
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "order_id")
	private List<OrderLineItem> orderLineItem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<OrderLineItem> getOrderLineItem() {
		return orderLineItem;
	}

	public void setOrderLineItem(List<OrderLineItem> orderLineItem) {
		this.orderLineItem = orderLineItem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((custId == null) ? 0 : custId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((orderDesc == null) ? 0 : orderDesc.hashCode());
		result = prime * result + ((orderLineItem == null) ? 0 : orderLineItem.hashCode());
		result = prime * result + ((totalPrice == null) ? 0 : totalPrice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalesOrder other = (SalesOrder) obj;
		if (custId == null) {
			if (other.custId != null)
				return false;
		} else if (!custId.equals(other.custId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderDesc == null) {
			if (other.orderDesc != null)
				return false;
		} else if (!orderDesc.equals(other.orderDesc))
			return false;
		if (orderLineItem == null) {
			if (other.orderLineItem != null)
				return false;
		} else if (!orderLineItem.equals(other.orderLineItem))
			return false;
		if (totalPrice == null) {
			if (other.totalPrice != null)
				return false;
		} else if (!totalPrice.equals(other.totalPrice))
			return false;
		return true;
	}
	
}
