package com.jasper.service;

import java.io.FileNotFoundException;

import org.springframework.http.ResponseEntity;

import com.jasper.dto.EmployeetaxDto;

import net.sf.jasperreports.engine.JRException;

public interface EmployeeTaxService {

	ResponseEntity<Object> employeetax(EmployeetaxDto employeetaxDto);

	ResponseEntity<Object> getEmployeetax(String reportFormat) throws FileNotFoundException, JRException;

}
