package com.hospital.service;

import java.util.List;

import com.hospital.dto.PatientDetailsDTO;

public interface HospitalMgmtService {

	public List<PatientDetailsDTO> fetchPatientDetails();
	public PatientDetailsDTO fetchDetailsById(int id);
	public String editPatientDetails(PatientDetailsDTO dto);
	public String insertPatient(PatientDetailsDTO dto);
	public String deletePatient(int pid);
	
}
