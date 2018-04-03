package com.kodilla.hibernate.manytomany.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ValidateFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateFacade.class);

    public String validate(String partLastName) throws ExceptionFacade {
        if(partLastName.length() < 3) {
            LOGGER.error(ExceptionFacade.ERR_VALIDATE);
            throw new ExceptionFacade(ExceptionFacade.ERR_VALIDATE);
        }
        return ("%" + partLastName + "%");
    }
}
