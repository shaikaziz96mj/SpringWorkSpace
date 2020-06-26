package com.hospital.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hospital.dto.PatientDetailsDTO;
import com.hospital.model.PatientEntity;
import com.hospital.repository.HospitalRepo;
import com.hospital.service.HospitalMgmtService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class HospitalMgmtServiceImpl implements HospitalMgmtService {

	@Autowired
	private HospitalRepo repo;

	@Override
	public List<PatientDetailsDTO> fetchPatientDetails() {

		Iterable<PatientEntity> it=null;
		List<PatientDetailsDTO> listDTO=new ArrayList<PatientDetailsDTO>();
		//use repository
		it=repo.findAll();
		//copy all entity to dto
		it.forEach(entity->{
			PatientDetailsDTO dto=new PatientDetailsDTO();
			//copying each entity to dto
			BeanUtils.copyProperties(entity, dto);
			//adding serial number in list
			dto.setSrNum(listDTO.size()+1);
			//adding dto to list
			listDTO.add(dto);
		});
		return listDTO;
	}//method

	@Override
	public PatientDetailsDTO fetchDetailsById(int id) {
		Optional<PatientEntity> opt=null;
		PatientEntity entity=null;
		PatientDetailsDTO dto=null;
		//use repository
		opt=repo.findById(id);
		//copy to entity 
		entity=new PatientEntity();
		if(opt.isPresent())
			entity=opt.get();
		//copy entity to dto
		dto=new PatientDetailsDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/*@Override
	public String editPatientDetails(PatientDetailsDTO dto) {
		PatientEntity entity=null;
		int count=0;
		//copy dto to entity
		entity=new PatientEntity();
		BeanUtils.copyProperties(dto, entity);
		//use repository
		count=repo.updatePatientRecord(entity.getPatientName(), entity.getAge(), entity.getGender(), entity.getPatientAddress(),entity.getPatientProblem() , entity.getDoctorName(),entity.getContactNumber(),entity.getWardNumber(),entity.getPatientId());
		return (count==0)?"Record not updated":"Record Updated";
	}*/

	@Override
	public String insertPatient(PatientDetailsDTO dto) {
		PatientEntity entity=null;
		//copy dto to entity
		entity=new PatientEntity();
		BeanUtils.copyProperties(dto, entity);
		//use repository
		entity=repo.save(entity);
		return (entity==null)?"Insertion failed":"Record Inserted Successfully";
	}

	@Override
	public String deletePatient(int pid) {
		//use repository
		repo.deleteById(pid);
		return String.format("Record is Deleted with ID %d", pid);
	}

}//class