package com.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hospital.model.PatientEntity;

public interface HospitalRepo extends JpaRepository<PatientEntity, Integer> {

	@Modifying
	@Query("Update PatientEntity set pname=:name,age=:age,gender=:gen,"
			+ "address=:addrs,problem=:prob,doctor=:doc,"
			+ "contactNumber=:con,wardNumber=:ward WHERE pid=:id")
	public int updatePatientRecord(@Param("name")String pname,
			@Param("age")int age,@Param("gen")String gender,
			@Param("addrs")String address,@Param("prob")String problem,
			@Param("doc")String doctor,@Param("con")long contactNumber,
			@Param("ward")int wardNumber,@Param("id")int id);
	
}