package com.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hospital.model.PatientEntity;

public interface HospitalRepo extends JpaRepository<PatientEntity, Integer> {

	/*@Modifying
	@Query("Update PatientEntity set patientName=:name,age=:age,gender=:gen,"
			+ "patientAddress=:address,patientProblem=:problem,doctorName=:doc,"
			+ "contactNumber:=contact,wardNumber:=ward WHERE patientId=:id")
	public int updatePatientRecord(@Param("name")String patientName,
			@Param("age")int age,@Param("gen")String gender,
			@Param("address")String patientAddress,@Param("problem")String patientProblem,
			@Param("doc")String doctorName,@Param("contact")int contactNumber,
			@Param("ward")int wardNumber,@Param("id")int id);*/
	
}