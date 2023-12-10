package com.riteship.crs.faq.microservice.controller;

import com.riteship.crs.faq.microservice.convertor.FAQDataBeanConvertor;
import com.riteship.crs.faq.microservice.dtos.FAQDataBeanDTO;
import com.riteship.crs.faq.microservice.entities.FAQDataBean;
import com.riteship.crs.faq.microservice.impl.RiteShipFAQServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/riteship/faqs")
public class RiteShipFAQRestController {

    /*@Autowired
    private RiteShipFAQDBOperationsBean FAQDBOperationsBean;*/

    @Autowired
    private RiteShipFAQServiceBean<FAQDataBean, Integer> faqServiceBean;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/getAll")
    public @ResponseBody List<FAQDataBeanDTO> getAllCompanies() {
        return FAQDataBeanConvertor.convertFAQDataListToFAQDataBean(faqServiceBean.getAllFaq());
    }

    @PutMapping("/save-faq")
    public @ResponseBody String saveFAQ(FAQDataBeanDTO faqData) {
        faqServiceBean.saveFaq((HashMap)FAQDataBeanConvertor.getMapOfFAQDataFromFAQDataBean(faqData));
        return "Success";
    }

    @GetMapping("/get-faq")
    public @ResponseBody FAQDataBeanDTO getFAQDetails(int faq_id) {
        return FAQDataBeanConvertor.getFAQDataBeanDTOFromDataMap(faqServiceBean.getFaqDetails(faq_id));
    }

    @PatchMapping("/update-faq")
    public @ResponseBody String updateFAQ(FAQDataBeanDTO faqData) {
        return faqServiceBean.updateFaq((HashMap)FAQDataBeanConvertor.getMapOfFAQDataFromFAQDataBean(faqData));
    }
}
