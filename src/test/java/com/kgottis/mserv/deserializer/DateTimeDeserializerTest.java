package com.kgottis.mserv.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * DateTimeDeserializer test class.
 * <p>
 * Created by kostas on 13/12/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class DateTimeDeserializerTest {

    @Mock
    private JsonParser jsonparser;

    @Mock
    private DeserializationContext deserializationcontext;

    private DateTimeDeserializer dtd;
    private SimpleDateFormat sdf;

    @Before
    public void init() {
        dtd = new DateTimeDeserializer();
        sdf = new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss");
    }

    @Test
    public void validFormattedString() throws IOException, ParseException {
        Date date = sdf.parse("01-01-2001T01:01:01");
        when(jsonparser.getText()).thenReturn("01-01-2001T01:01:01");

        assertEquals(dtd.deserialize(jsonparser, deserializationcontext), date);
    }

    @Test(expected = RuntimeException.class)
    public void invalidFormattedString() throws IOException, ParseException {
        when(jsonparser.getText()).thenReturn("01-01-2001");

        dtd.deserialize(jsonparser, deserializationcontext);
    }

    @Test(expected = RuntimeException.class)
    public void nullString() throws IOException, ParseException {
        when(jsonparser.getText()).thenReturn(null);

        dtd.deserialize(jsonparser, deserializationcontext);
    }

}
