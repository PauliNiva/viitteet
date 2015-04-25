/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viitehallinta;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sonja
 */
public class InproceedingsTest {
    Inproceedings inpro;
    Inproceedings inpro2;
    
    public InproceedingsTest() {
    }
    
    @Before
    public void setUp() {
        inpro = new Inproceedings("Aku", "Kissat", "Eläimet", 2014);        
    }
    
    @Test public void luoTyhjaKonstruktoriTest() {   
        inpro2 = new Inproceedings();
        assertEquals(null, inpro2.getID());
    }
    
    @Test public void luoKonstruktoriTest() {        
        assertEquals("Aku", inpro.getAuthor());
        assertEquals("Kissat", inpro.getTitle());
        assertEquals("Eläimet", inpro.getBooktitle());
        assertEquals(2014, inpro.getYear());
    }
    
    @Test public void setAndGetPagesTest() {
        inpro.setPages("24");
        assertEquals("24", inpro.getPages());
    }
    
    @Test public void setAndGetPublisherTest() {
        inpro.setPublisher("Roope");
        assertEquals("Roope", inpro.getPublisher());
    }
    
    @Test public void setAndGetVolumeTest() {
        inpro.setVolume(1);
        assertEquals(1, inpro.getVolume());
    }
    
    @Test public void setAndGetEditorTest() {
        inpro.setEditor("Matti");
        assertEquals("Matti", inpro.getEditor());
    }
    
    @Test public void setAndGetSeriesTest() {
        inpro.setSeries("series");
        assertEquals("series", inpro.getSeries());
    }
    
    @Test public void setAndGetAddressTest() {
        inpro.setAddress("Kumpulan kampus");
        assertEquals("Kumpulan kampus", inpro.getAddress());
    }
    
    @Test public void setAndGetOrganizationTest() {
        inpro.setOrganization("Helsingin yliopisto");
        assertEquals("Helsingin yliopisto", inpro.getOrganization());
    }
     
}
