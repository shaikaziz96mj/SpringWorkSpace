package com.hospital.command;

import lombok.Data;

@Data
public class PatientDetailsCommand {

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
