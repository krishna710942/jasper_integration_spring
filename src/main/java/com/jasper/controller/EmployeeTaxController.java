package com.jasper.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jasper.dto.EmployeetaxDto;
import com.jasper.service.EmployeeTaxService;

import net.sf.jasperreports.engine.JRException;

@RestController
public class EmployeeTaxController {

	@Autowired
	private EmployeeTaxService employeeTaxService;
	
	@PostMapping("/employee/tax")
	public ResponseEntity<Object>employeetax(@RequestBody EmployeetaxDto employeetaxDto){
		return employeeTaxService.employeetax(employeetaxDto);
	}
	
	@GetMapping("/employee/tax")
	public ResponseEntity<Object>getEmployeetax(@RequestParam String reportFormat) throws FileNotFoundException, JRException{
		return employeeTaxService.getEmployeetax(reportFormat);
	}
}
