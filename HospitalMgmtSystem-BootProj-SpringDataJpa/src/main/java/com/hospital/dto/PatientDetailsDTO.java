package com.hospital.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PatientDetailsDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int srNum;
	private int pid;
	private String pname;
	private int age;
	private String gender;
	private String address;
	private String problem;
	private String doctor;
	private long contactNumber;
	private int wardNumber;
	
}
