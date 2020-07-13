package com.jasper.service.implementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import com.jasper.domain.EmployeeTax;
import com.jasper.dto.EmployeetaxDto;
import com.jasper.repository.EmployeeTaxRepository;
import com.jasper.service.EmployeeTaxService;
import com.jasper.utils.ResponseHandler;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

@Service
public class EmployeeTaxServiceImpl implements EmployeeTaxService {

	@Autowired
	private EmployeeTaxRepository employeeTaxRepository;
	private Long count = 1L;

	@Override
	public ResponseEntity<Object> employeetax(EmployeetaxDto employeetaxDto) {
		EmployeeTax employeeTax = new EmployeeTax();
		employeeTax.setEmployeeName(employeetaxDto.getEmployeeName());
		employeeTax.setEmployeeAmount(employeetaxDto.getEmployeeAmount());
		employeeTax.setEmployeeTaxId("tax - " + count++);
		employeeTax.setTaxPercentage(employeetaxDto.getTaxPercentage());
		employeeTax.setAfterTaxAmount("2000");
		return ResponseHandler.generateResponse(HttpStatus.OK, true, "add employee detail",
				employeeTaxRepository.save(employeeTax));
	}

	@Override
	public ResponseEntity<Object> getEmployeetax(String reportFormat) throws FileNotFoundException, JRException {
		String path = "/home/krishna/Desktop/";
		List<EmployeeTax> tax = employeeTaxRepository.findAll();
		File file = ResourceUtils.getFile("classpath:employeeTax.jrxml");
		JasperDesign jasperDesing=JRXmlLoader.load(file.getAbsolutePath());
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesing);
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(tax);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("CollectionBeanParam", dataSource);
		JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
		if (reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(print, path + "employee.html");
		}
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(print, path + "employee.pdf");
		}
		JasperViewer.viewReport(print);
		return ResponseHandler.generateResponse(HttpStatus.OK, true, "fetch detail", path);
	}

}
