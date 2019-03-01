package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Admin_tab")
public class Admin {
	@Id
	@Column(name="admin_id")
	@GeneratedValue
	private int adminId;
	@Column(name="admin_name")
	private String adminName;
	@Column (name="admin_email")
	private String adminEmail;
	@Column(name="admin_pwd")
	private String adminPwd;
	@Column(name="admin_addr")
	private String adminAddr;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public String getAdminAddr() {
		return adminAddr;
	}
	public void setAdminAddr(String adminAddr) {
		this.adminAddr = adminAddr;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName
				+ ", adminEmail=" + adminEmail + ", adminPwd=" + adminPwd
				+ ", adminAddr=" + adminAddr + "]";
	}
	

}
