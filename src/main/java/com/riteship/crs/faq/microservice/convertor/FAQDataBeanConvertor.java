package com.riteship.crs.faq.microservice.convertor;

import com.riteship.crs.faq.microservice.dtos.FAQDataBeanDTO;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FAQDataBeanConvertor {

    public static List<FAQDataBeanDTO> convertFAQDataListToFAQDataBean(ArrayList FAQDataList) {
        List<FAQDataBeanDTO> faqDataBeanDTOS = new ArrayList<>();
        if(!CollectionUtils.isEmpty(FAQDataList)) {
            FAQDataList.stream().forEach(data -> {
                if(data != null) {
                    HashMap faqData = (HashMap) data;
                    if(!CollectionUtils.isEmpty(faqData)) {
                        FAQDataBeanDTO faqDataBeanDTO = getFAQDataBeanDTOFromDataMap(faqData);
                        if(faqDataBeanDTO != null) {
                            faqDataBeanDTOS.add(faqDataBeanDTO);
                        }
                    }
                }
            });
        }
        return faqDataBeanDTOS;
    }

    public static FAQDataBeanDTO getFAQDataBeanDTOFromDataMap(HashMap FAQData) {
        FAQDataBeanDTO faqDataBeanDTO = null;
        if(!CollectionUtils.isEmpty(FAQData)) {
            faqDataBeanDTO = new FAQDataBeanDTO();
            faqDataBeanDTO.setFaqId(Integer.valueOf((String)FAQData.get("faq_id")));
            faqDataBeanDTO.setFaqQuestion((String)FAQData.get("faq_question"));
            faqDataBeanDTO.setFaqAnswer((String)FAQData.get("faq_answer"));
        }
        return faqDataBeanDTO;
    }

    public static Map<String, String> getMapOfFAQDataFromFAQDataBean(FAQDataBeanDTO faqDataBeanDTO) {
        Map<String, String> result = new HashMap<>();
        if(faqDataBeanDTO != null) {
            result.put("faq_id", String.valueOf(faqDataBeanDTO.getFaqId()));
            result.put("faq_question", faqDataBeanDTO.getFaqQuestion());
        }
        return result;
    }
}
