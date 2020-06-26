package com.hospital.dao;

import java.util.List;

import com.hospital.bo.PatientDetailsBO;

public interface PatientDAO {

	public List<PatientDetailsBO> getPatientDetails();
	public PatientDetailsBO getPatientById(int id);
	public int updatePatientRecord(PatientDetailsBO bo);
	public int patientInsert(PatientDetailsBO bo);
	public int removePatient(int pid);
	
}