package com.jasper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jasper.domain.EmployeeTax;

@Repository
public interface EmployeeTaxRepository extends JpaRepository<EmployeeTax, Long> {

}
