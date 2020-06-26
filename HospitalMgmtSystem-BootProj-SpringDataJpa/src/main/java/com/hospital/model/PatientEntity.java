package com.hospital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table(name = "hospitalenquiry")
public class PatientEntity {

	@Id
	@Column(length = 30)
	@Type(type = "int")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	@Column(length = 50)
	@Type(type = "string")
	private String pname;
	@Column(length = 10)
	@Type(type = "int")
	private int age;
	@Column(length = 10)
	@Type(type = "string")
	private String gender;
	@Column(length = 50)
	@Type(type = "string")
	private String address;
	@Column(length = 50)
	@Type(type = "string")
	private String problem;
	@Column(length = 50)
	@Type(type = "string")
	private String doctor;
	@Column(length = 15)
	@Type(type = "long")
	private long contactNumber;
	@Column(length = 10)
	@Type(type = "int")
	private int wardNumber;
	
}
