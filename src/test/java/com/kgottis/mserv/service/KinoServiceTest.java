package com.kgottis.mserv.service;

import com.kgottis.mserv.domain.KinoDraw;
import com.kgottis.mserv.domain.dto.DrawDTO;
import com.kgottis.mserv.domain.dto.KinoDrawDTO;
import com.kgottis.mserv.service.imp.KinoServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * KinoService test class.
 * <p>
 * Created by kostas on 13/12/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class KinoServiceTest {

    @InjectMocks
    private KinoService kinoService = new KinoServiceImpl();

    private Date date;
    private Short[] res;

    @Before
    public void setUp() {
        date = new Date();
        res = new Short[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    }

    @Test
    public void tokinoDraw_Null_ReturnsNull() {
        assertEquals("Return null for null object", null, kinoService.tokinoDraw(null));
    }

    @Test
    public void tokinoDraw_Object_ReturnsDTO() {
        KinoDrawDTO dto = new KinoDrawDTO(1L, new DrawDTO(date, 1L, res));
        KinoDraw expected = new KinoDraw();
        expected.setId(1L);
        expected.setDrawTime(date);
        expected.setDrawNo(1L);
        expected.setResults(Arrays.asList(res));

        KinoDraw kinoDraw = kinoService.tokinoDraw(dto);

        assertEquals("Return KinoDraw from dto", expected, kinoDraw);
        assertEquals("Draw numbers are equal", expected.getDrawNo(), kinoDraw.getDrawNo());
        assertEquals("Draw dates are equal", expected.getDrawTime(), kinoDraw.getDrawTime());
        assertEquals("Draw results are equal", expected.getResults(), kinoDraw.getResults());
    }

    @Test
    public void toKinoDrawDTO_Null_ReturnsNull() {
        assertEquals("Return null for null object", null, kinoService.toKinoDrawDTO(null));
    }

    @Test
    public void toKinoDrawDTO_Object_ReturnsDTO() {
        KinoDrawDTO expected = new KinoDrawDTO(1L, new DrawDTO(date, 1L, res));
        KinoDraw kinoDraw = new KinoDraw();
        kinoDraw.setId(1L);
        kinoDraw.setDrawTime(date);
        kinoDraw.setDrawNo(1L);
        kinoDraw.setResults(Arrays.asList(res));

        KinoDrawDTO dto = kinoService.toKinoDrawDTO(kinoDraw);

        assertEquals("Return dto from KinoDraw", expected, dto);
        assertEquals("Draw numbers are equal", expected.getDraw().getDrawNo(), dto.getDraw().getDrawNo());
        assertEquals("Draw dates are equal", expected.getDraw().getDrawTime(), dto.getDraw().getDrawTime());
        assertEquals("Draw results are equal", expected.getDraw().getResults(), dto.getDraw().getResults());
    }

}
