package com.riteship.crs.faq.microservice.impl;

import com.riteship.common.apis.services.impls.RiteShipGeneralServiceImpl;
import com.riteship.crs.faq.microservice.RiteShipFAQDBOperationsBean;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class RiteShipFAQServiceBean<CollegeDataBean, Integer> extends RiteShipGeneralServiceImpl<CollegeDataBean, Integer> {

        @PostConstruct
        public void initializeBean() {
            setRiteShipDatabaseOperationsBean(new RiteShipFAQDBOperationsBean().getDatabaseOperationsBean());
        }

}
