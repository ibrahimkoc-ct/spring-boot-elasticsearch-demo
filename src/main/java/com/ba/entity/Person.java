package com.ba.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "person")
public class Person {
	@Id
	private String id;
	
	@Field(name = "ad",type = FieldType.Text)
	private String name;
	
	@Field(name = "lastname",type = FieldType.Text)
	private String lastname;
	
	@Field(name = "address",type = FieldType.Text)
	private String address;
	
	@Field(name = "birthday_date",type = FieldType.Date)
	private Date birthday_date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDate() {
		return birthday_date;
	}

	public void setDate(Date date) {
		this.birthday_date = date;
	}

}
