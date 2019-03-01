package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTS_TABS")
public class Customer {
	@Id
	@Column(name="cust_id")
	private Integer custId;
	@Column(name="cust_name")
	private String custName;
	@Column(name="cust_email")
	private String custEmail;
	@Column(name="cust_type")
	private String custType;
	@Column(name="cust_addr")
	private String custAddr;
	@Column(name="password")
	private String password;
	@Column(name="acc_token")
	private String accToken;
	@Column(name="products")
	private String products;
	@Column(name="shipping_type")
	private String shippingtype;
	@Column(name="transport")
	private String  transport;

	
	public Customer() {
		super();
	}


	public Customer(Integer custId) {
		super();
		this.custId = custId;
	}


	public Integer getCustId() {
		return custId;
	}


	public void setCustId(Integer custId) {
		this.custId = custId;
	}


	public String getCustName() {
		return custName;
	}


	public void setCustName(String custName) {
		this.custName = custName;
	}


	public String getCustEmail() {
		return custEmail;
	}


	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}


	public String getCustType() {
		return custType;
	}


	public void setCustType(String custType) {
		this.custType = custType;
	}


	public String getCustAddr() {
		return custAddr;
	}


	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAccToken() {
		return accToken;
	}


	public void setAccToken(String accToken) {
		this.accToken = accToken;
	}


	public String getProducts() {
		return products;
	}


	public void setProducts(String products) {
		this.products = products;
	}


	public String getShippingtype() {
		return shippingtype;
	}


	public void setShippingtype(String shippingtype) {
		this.shippingtype = shippingtype;
	}


	public String getTransport() {
		return transport;
	}


	public void setTransport(String transport) {
		this.transport = transport;
	}


	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName
				+ ", custEmail=" + custEmail + ", custType=" + custType
				+ ", custAddr=" + custAddr + ", password=" + password
				+ ", accToken=" + accToken + ", products=" + products
				+ ", shippingtype=" + shippingtype + ", transport=" + transport
				+ "]";
	}
	
	
	
}
