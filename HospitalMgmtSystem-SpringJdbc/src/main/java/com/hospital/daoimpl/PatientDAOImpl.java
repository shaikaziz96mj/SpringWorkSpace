package com.hospital.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.hospital.bo.PatientDetailsBO;
import com.hospital.dao.PatientDAO;

@Repository
public final class PatientDAOImpl implements PatientDAO {

	private static final String GET_PATIENT_DETAILS_QUERY="SELECT PID,PNAME,AGE,GENDER,ADDRESS,PROBLEM,DOCTOR,CONTACTNUMBER,WARDNUMBER FROM HOSPITALENQUIRY ORDER BY PID ASC";
	private static final String GET_PATIENT_BY_ID="SELECT PID,PNAME,AGE,GENDER,ADDRESS,PROBLEM,DOCTOR,CONTACTNUMBER,WARDNUMBER FROM HOSPITALENQUIRY WHERE PID=?";
	private static final String UPDATE_PATIENT_DETAILS_QUERY="UPDATE HOSPITALENQUIRY SET PNAME=?,AGE=?,GENDER=?,ADDRESS=?,CONTACTNUMBER=?,PROBLEM=?,DOCTOR=?,WARDNUMBER=? WHERE PID=?";
	private static final String INSERT_PATIENT_QUERY="INSERT INTO HOSPITALENQUIRY VALUES (PATIENT_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
	private static final String DELETE_PATIENT_QUERY="DELETE FROM HOSPITALENQUIRY WHERE PID=?";
	
	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<PatientDetailsBO> getPatientDetails() {
		
		List<PatientDetailsBO> listBO=null;
		
		//get details in listBO
		listBO=(List<PatientDetailsBO>) jt.query(GET_PATIENT_DETAILS_QUERY,new RowMapperResultSetExtractor<PatientDetailsBO>(new BeanPropertyRowMapper<PatientDetailsBO>(PatientDetailsBO.class)));
		return listBO;
	}

	@Override
	public PatientDetailsBO getPatientById(int id) {
	
		PatientDetailsBO bo=null;
		
		//get patient details by id
		bo=(PatientDetailsBO) jt.queryForObject(GET_PATIENT_BY_ID,new BeanPropertyRowMapper<PatientDetailsBO>(PatientDetailsBO.class),id);
		return bo;
	}

	@Override
	public int updatePatientRecord(PatientDetailsBO bo) {
		
		int count=0;
		
		count=jt.update(UPDATE_PATIENT_DETAILS_QUERY,bo.getPname(),bo.getAge(),bo.getGender(),bo.getAddress(),bo.getContactNumber(),bo.getProblem(),bo.getDoctor(),bo.getWardNumber(),bo.getPid());
		return count;
	}

	@Override
	public int patientInsert(PatientDetailsBO bo) {
		
		int insert=0;
		
		insert=jt.update(INSERT_PATIENT_QUERY,bo.getPname(),bo.getAge(),bo.getGender(),bo.getAddress(),bo.getProblem(),bo.getDoctor(),bo.getContactNumber(),bo.getWardNumber());
		return insert;
	}

	@Override
	public int removePatient(int pid) {
		
		int count=0;
		
		count=jt.update(DELETE_PATIENT_QUERY,pid);
		return count;
		
	}

}//class