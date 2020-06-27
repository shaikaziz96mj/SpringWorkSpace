package com.hospital.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hospital.command.PatientDetailsCommand;
import com.hospital.dto.PatientDetailsDTO;
import com.hospital.service.HospitalMgmtService;

@Controller
public class HospitalCURDOperationsMainController {

	@Autowired
	private HospitalMgmtService service;

	@RequestMapping("/home.cpp")
	public String showWelcomePage() {
		return "homepage";
	}

	@RequestMapping("/getdetails.cpp")
	public String displayRecordsPage(Map<String,Object> map){

		List<PatientDetailsDTO> listDTO=null;

		//use service
		listDTO=service.fetchPatientDetails();

		map.put("sysDate",new Date());
		map.put("listDTO",listDTO);
		return "list_patients";
	}

	@GetMapping("/edit_form.cpp")
	public String displayEditFormPage(@ModelAttribute(name = "patientCmd")PatientDetailsCommand cmd,HttpServletRequest req){
	
		int id=0;
		PatientDetailsDTO dto=null;
		
		//get pid from submitted request
		id=Integer.parseInt(req.getParameter("id"));
		//use service
		dto=service.fetchDetailsById(id);
		//copy properties
		BeanUtils.copyProperties(dto, cmd);
	
		return "update_patient";
	}
	
	@PostMapping("/edit_form.cpp")
	public String submitUpdatedForm(Map<String,Object> map,@ModelAttribute(name="patientCmd") PatientDetailsCommand cmd,BindingResult errors){
		
		PatientDetailsDTO dto=null;
		String resultMsg=null;
		List<PatientDetailsDTO> listDTO=null;
		
		//copy command class to dto
		dto=new PatientDetailsDTO();
		BeanUtils.copyProperties(cmd, dto);
		
		//use service
		resultMsg=service.editPatientDetails(dto);
		listDTO=service.fetchPatientDetails();
		
		//return MAV object object
		map.put("listDTO",listDTO);
		map.put("result",resultMsg);
		
		return "list_patients";
	}
	
	@GetMapping("/insert_patient.cpp")
	public String showInsertForm(@ModelAttribute(name="patientCmd") PatientDetailsCommand cmd) {
		return "insert_form";
	}
	
	@PostMapping("/insert_patient.cpp")
	public String insertPatientRecord(RedirectAttributes attributes,@ModelAttribute(name="patientCmd") PatientDetailsCommand cmd,BindingResult errors){
		
		PatientDetailsDTO dto=null;
		String resultMsg=null;
		List<PatientDetailsDTO> listDTO=null;
		
		//copy command class obj to dto
		dto=new PatientDetailsDTO();
		BeanUtils.copyProperties(cmd,dto);
		
		//use service
		resultMsg=service.insertPatient(dto);
		listDTO=service.fetchPatientDetails();
		
		attributes.addFlashAttribute("result",resultMsg);
		attributes.addFlashAttribute("listDTO",listDTO);
		
		return "redirect:/post_insert_patient.cpp";
	}
	
	@GetMapping("/post_insert_patient.cpp")
	public String avoidDoublePost() {
		return "list_patients";
	}
	
	@RequestMapping("/remove_record.cpp")
	public String deletePatientRecord(Map<String,Object> map,HttpServletRequest req)
			throws Exception {
		
		int id=0;
		String resultMsg=null;
		List<PatientDetailsDTO> listDTO=null;
		
		//get request param value
		id=Integer.parseInt(req.getParameter("id"));
		
		//use service
		resultMsg=service.deletePatient(id);
		listDTO=service.fetchPatientDetails();
		
		//return mav object
		map.put("result",resultMsg);
		map.put("listDTO",listDTO);
		
		return "list_patients";
	}
	
}//class