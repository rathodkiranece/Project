package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_TAB1")
public class User {
	@Id
	@GeneratedValue
	@Column(name="u_id")
	private int userId;
	@Column(name="u_name")
	private String userName;
	@Column(name="u_status")
	private Integer status;
	@Column(name="u_email")
	private String userEmail;
	@Column(name="u_mobile")
	private String userContact;
	@Column(name="u_pwd")
	private String userPwd;
	@Column(name="u_addr")
	private String userAddr;
	@Column(name="u_type")
	private String userType;
	public User() {
			}
	public User(int userId) {
		this.userId = userId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserContact() {
		return userContact;
	}
	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", status=" + status + ", userEmail=" + userEmail
				+ ", userContact=" + userContact + ", userPwd=" + userPwd
				+ ", userAddr=" + userAddr + ", userType=" + userType + "]";
	}
	}
