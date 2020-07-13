package com.jasper.domain;

import java.io.Serializable;
import javax.persistence.Entity;



@Entity
public class EmployeeTax extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 420999972977552215L;

	private String employeeTaxId;
	private String employeeName;
	private String taxPercentage;
	private String employeeAmount;
	private String afterTaxAmount;

	
	public String getEmployeeTaxId() {
		return employeeTaxId;
	}


	public void setEmployeeTaxId(String employeeTaxId) {
		this.employeeTaxId = employeeTaxId;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public String getTaxPercentage() {
		return taxPercentage;
	}


	public void setTaxPercentage(String taxPercentage) {
		this.taxPercentage = taxPercentage;
	}


	public String getEmployeeAmount() {
		return employeeAmount;
	}


	public void setEmployeeAmount(String employeeAmount) {
		this.employeeAmount = employeeAmount;
	}


	public String getAfterTaxAmount() {
		return afterTaxAmount;
	}


	public void setAfterTaxAmount(String afterTaxAmount) {
		this.afterTaxAmount = afterTaxAmount;
	}


	@Override
	public String toString() {
		return "EmployeeTax [employeeTaxId=" + employeeTaxId + ", employeeName=" + employeeName + ", taxPercentage="
				+ taxPercentage + ", employeeAmount=" + employeeAmount + ", afterTaxAmount=" + afterTaxAmount + "]";
	}

}
