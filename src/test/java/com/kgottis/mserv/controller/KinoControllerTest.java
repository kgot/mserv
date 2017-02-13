package com.kgottis.mserv.controller;

import com.kgottis.mserv.domain.dto.DrawDTO;
import com.kgottis.mserv.domain.dto.KinoDrawDTO;
import com.kgottis.mserv.service.KinoService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author kostas
 */
@RunWith(MockitoJUnitRunner.class)
public class KinoControllerTest {

    @InjectMocks
    private KinoController kinoController;

    @Mock
    private KinoService kinoService;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        mockMvc = MockMvcBuilders
            .standaloneSetup(kinoController)
            .build();
    }

    @Test
    public void getLast_Call_ReturnsEmptyDTO() throws Exception {
        when(kinoService.getLastDraw()).thenReturn(new KinoDrawDTO());

        mockMvc.perform(get("/kinodraws/last"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("$.id", is(nullValue())))
            .andExpect(jsonPath("$.draw", is(nullValue())));
    }

    @Test
    public void getLast_Call_ReturnsDTO() throws Exception {
        when(kinoService.getLastDraw()).thenReturn(new KinoDrawDTO(1L, new DrawDTO()));

        mockMvc.perform(get("/kinodraws/last"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("$.id", is(1)))
            .andExpect(jsonPath("$.draw", is(notNullValue())));
    }

    @Test
    public void getLast_Call_ReturnsEmptyBody() throws Exception {
        when(kinoService.getLastDraw()).thenReturn(null);

        MvcResult result = mockMvc.perform(get("/kinodraws/last"))
            .andExpect(status().isOk())
            .andReturn();

        String content = result.getResponse().getContentAsString();

        assertEquals("", content);
    }

}
