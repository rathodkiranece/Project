package com.app.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="mail_Tab")
public class Email {
@Id
@Column(name="email_id")
private String emailId;
@Column(name="From Addr")
private String fromAddr;
@Column(name="Subject")
private String Subject;
@Column(name="text")
private String text;
@Column(name="attachment")
@Lob
private byte[] attachment;

public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getFromAddr() {
	return fromAddr;
}
public void setFromAddr(String fromAddr) {
	this.fromAddr = fromAddr;
}
public String getSubject() {
	return Subject;
}
public void setSubject(String subject) {
	Subject = subject;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public byte[] getAttachment() {
	return attachment;
}
public void setAttachment(byte[] attachment) {
	this.attachment = attachment;
}
@Override
public String toString() {
	return "Email [EmailId=" + emailId + ", fromAddr=" + fromAddr
			+ ", Subject=" + Subject + ", text=" + text + ", attachment="
			+ Arrays.toString(attachment) + "]";
}



}
