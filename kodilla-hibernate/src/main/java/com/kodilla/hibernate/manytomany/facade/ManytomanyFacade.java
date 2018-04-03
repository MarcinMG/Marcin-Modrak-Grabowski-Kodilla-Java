package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ManytomanyFacade {
    @Autowired
    private ValidateFacade validateFacade;
    private static final Logger LOGGER = LoggerFactory.getLogger(ManytomanyFacade.class);

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private CompanyDao companyDao;

    public List<Employee> searchEmployeeByPartLastName(String partLastName) throws ExceptionFacade {
        List<Employee> matchesEmployees = new ArrayList<>();
        String validatedPartName = validateFacade.validate(partLastName);
        matchesEmployees = employeeDao.retrieveByPartLastName(validatedPartName);
        if(matchesEmployees.isEmpty()) {
            LOGGER.info("Failed to find employees");
        }
        LOGGER.info("Searching finished.");
        return matchesEmployees;
    }

    public List<Company> searchCompanyByPartName(String partName) throws ExceptionFacade {
        List<Company> matchesCompanies = new ArrayList<>();
        String validatedName = validateFacade.validate(partName);
        matchesCompanies = companyDao.retrieveCompaniesByPartName(validatedName);
        if(matchesCompanies.isEmpty()) {
            LOGGER.info("Failed to find company");
        }
        LOGGER.info("Searching finished.");
        return matchesCompanies;
    }
}
