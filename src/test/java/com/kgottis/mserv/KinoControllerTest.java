///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.kgottis.mserv;
//
//import com.kgottis.mserv.controller.KinoController;
//import com.kgottis.mserv.domain.KinoDraw;
//import com.kgottis.mserv.domain.dto.KinoDrawDTO;
//import com.kgottis.mserv.service.KinoService;
//import java.nio.charset.Charset;
//import java.util.Arrays;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.mock.web.MockServletContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.ContextHierarchy;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
// *
// * @author kostas
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = MockServletContext.class)
//@WebAppConfiguration
//public class KinoControllerTest {
//
//    private final MediaType contentType = new MediaType(
//            MediaType.APPLICATION_JSON.getType(),
//            MediaType.APPLICATION_JSON.getSubtype(),
//            Charset.forName("utf8")
//    );
//
//    private MockMvc mockMvc;
//
//    private KinoDrawDTO kinoDrawDTO;
//
//    private HttpMessageConverter mappingJackson2HttpMessageConverter;
//
//    @Autowired
//    KinoService kinoService;
//
//    @Autowired
//    private WebApplicationContext webApplicationContext;
//
//    @Autowired
//    void setConverters(HttpMessageConverter<?>[] converters) {
//
//        mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
//                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
//                .findAny()
//                .get();
//
//        Assert.assertNotNull("the JSON message converter must not be null", this.mappingJackson2HttpMessageConverter);
//    }
//
//    @Before
//    public void setup() throws Exception {
//        this.mockMvc = webAppContextSetup(webApplicationContext).build();
//
//        kinoDrawDTO = kinoService.getLastDraw();
//        kinoService.saveDraw(new KinoDraw());
//    }
//
//     @Test
//    public void readBookmarks() throws Exception {
//        mockMvc.perform(get( "/kinodraws/last"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(contentType));
//    }
//
//}
