/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kgottis.mserv.misc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kgottis.mserv.config.KinoProperties;
import com.kgottis.mserv.domain.KinoDraw;
import com.kgottis.mserv.domain.dto.KinoDrawDTO;
import com.kgottis.mserv.service.KinoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author kostas
 */
@Component
public class ScheduledTasks {

    @Autowired
    KinoProperties kinoProps;

    @Autowired
    KinoService kinoService;
    
    @Autowired
    ObjectMapper mapper;

    private final Logger logger = LogManager.getLogger(ScheduledTasks.class.getName());

    // 4.5 minutes
    private static final long FIXED_RATE = 1000 * 60 * (4 + (1 / 2));

    /**
     * url example: http://applications.opap.gr/DrawsRestServices/kino/last.json
     */
    @Scheduled(fixedRate = FIXED_RATE)
    public void reportKinoLastDraw() {
        RestTemplate restTemplate = new RestTemplate();
        KinoDraw kinoDraw = new KinoDraw();

        logger.info("KINO url: " + getCompleteUrl(kinoProps.getUrl(), kinoProps.getFormat()));

        KinoDrawDTO kinoDrawDTO = restTemplate.getForObject(getCompleteUrl(kinoProps.getUrl(), kinoProps.getFormat()), KinoDrawDTO.class);
                
        logger.info(kinoDrawDTO);
        
        kinoService.kinoDrawDTOtokinoDraw(kinoDrawDTO, kinoDraw);

        kinoService.saveDraw(kinoDraw);
    }

    private String getCompleteUrl(String url, String format) {
        return isAcceptableFormat(format) ? url.concat(".").concat(format) : "";
    }

    private Boolean isAcceptableFormat(String format) {
        return format != null && (format.equals("xml") || format.equals("json"));
    }
}
