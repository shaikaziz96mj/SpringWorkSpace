package com.hospital.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hospital.bo.PatientDetailsBO;
import com.hospital.dao.PatientDAO;
import com.hospital.dto.PatientDetailsDTO;
import com.hospital.service.HospitalMgmtService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public final class HospitalMgmtServiceImpl implements HospitalMgmtService {

	@Autowired
	private PatientDAO dao;
	
	@Override
	public List<PatientDetailsDTO> fetchPatientDetails() {
		
		List<PatientDetailsBO> listBO=null;
		final List<PatientDetailsDTO> listDTO=new ArrayList<PatientDetailsDTO>();
		
		//use DAO
		listBO=dao.getPatientDetails();
		//copy listBO to listDTO
		listBO.forEach(bo->{
			PatientDetailsDTO dto=new PatientDetailsDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSrNum(listDTO.size()+1);
			listDTO.add(dto);
		});
		return listDTO;
	}//method

	@Override
	public PatientDetailsDTO fetchDetailsById(int id) {
		
		PatientDetailsBO bo=null;
		PatientDetailsDTO dto=null;
		
		//use DAO
		bo=dao.getPatientById(id);
		
		//copy bo objects to dto
		dto=new PatientDetailsDTO();
		BeanUtils.copyProperties(bo, dto);
		
		return dto;
	}

	@Override
	public String editPatientDetails(PatientDetailsDTO dto) {
		
		int cnt=0;
		PatientDetailsBO bo=null;
		
		//convert dto to bo
		bo=new PatientDetailsBO();
		BeanUtils.copyProperties(dto, bo);
		
		//use DAO
		cnt=dao.updatePatientRecord(bo);
		
		return (cnt==0)?"RECORD UPDATION FAILED":"RECORD UPDATED SUCCESSFULLY";
	}

	@Override
	public String insertPatient(PatientDetailsDTO dto) {
		
		int cnt=0;
		PatientDetailsBO bo=null;
		
		//copy dto to bo
		bo=new PatientDetailsBO();
		BeanUtils.copyProperties(dto, bo);
		
		//use DAO
		cnt=dao.patientInsert(bo);
		
		return (cnt==0)?"PATIENT INSERTION FAILED":"PATIENT RECORD INSERTED SUCCESSFULLY";
	}

	@Override
	public String deletePatient(int pid) {
		
		int count=0;
		
		//use DAO
		count=dao.removePatient(pid);
		if(count==0) {
			return String.format("Record deletion failed having id %d ", pid);
		}
		
		return String.format("Record deleted successfully having id %d ", pid);
	}
	
}//class