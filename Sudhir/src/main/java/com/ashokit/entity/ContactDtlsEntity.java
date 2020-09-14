package com.ashokit.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "Contact_DTL_TB")
public class ContactDtlsEntity{
     @Id
     @Column(name = "contact_id")
     @GeneratedValue
     private Integer contactId;
     @Column(name = "contact_name")	
     private String contactName;
     @Column(name = "contact_num")	
     private String contactNum;
     @Column(name = "contact_email")	
     private String contactEmail;
	public Integer getContactId() {
		return contactId;
	}
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactNum() {
		return contactNum;
	}
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	
     
}