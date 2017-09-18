package com.diegomalone.neontest;

import com.diegomalone.neontest.model.Contact;
import com.diegomalone.neontest.model.TotalTransfer;

import org.junit.Before;
import org.junit.Test;

import static com.diegomalone.neontest.model.TotalTransfer.MINIMUM_CHART_LINE_HEIGHT;
import static junit.framework.Assert.assertEquals;

/**
 * Created by Diego Malone on 18/09/17.
 */

public class TotalTransferUnitTest {

    private TotalTransfer totalTransfer;

    @Before
    public void setupTotalTransfer() {
        totalTransfer = new TotalTransfer(new Contact(1, "Test Contact", "", ""), 100);
    }

    @Test
    public void testTotalTransferValue() {
        assertEquals(100d, totalTransfer.getValue());

        totalTransfer.addValue(0d);

        assertEquals(100d, totalTransfer.getValue());

        totalTransfer.addValue(100d);

        assertEquals(200d, totalTransfer.getValue());

        totalTransfer.setValue(100d);

        assertEquals(100d, totalTransfer.getValue());
    }

    @Test
    public void testChartHeight() {
        assertEquals(MINIMUM_CHART_LINE_HEIGHT, totalTransfer.getChartHeight());

        totalTransfer.setChartHeight(MINIMUM_CHART_LINE_HEIGHT + 10);

        assertEquals(MINIMUM_CHART_LINE_HEIGHT + 10, totalTransfer.getChartHeight());

        totalTransfer.setChartHeight(100);

        assertEquals(50, totalTransfer.getChartLineHeight(50));
    }
}
