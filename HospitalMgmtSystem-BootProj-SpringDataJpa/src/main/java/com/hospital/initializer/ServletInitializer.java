package com.hospital.initializer;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.hospital.HospitalMgmtSystemBootProjSpringDataJpaApplication;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HospitalMgmtSystemBootProjSpringDataJpaApplication.class);
	}

}
