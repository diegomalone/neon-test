package com.diegomalone.neontest;

import com.diegomalone.neontest.model.Contact;
import com.diegomalone.neontest.model.TotalTransfer;
import com.diegomalone.neontest.model.TotalTransferList;

import org.junit.Before;
import org.junit.Test;

import static com.diegomalone.neontest.model.TotalTransfer.MINIMUM_CHART_LINE_HEIGHT;
import static junit.framework.Assert.assertEquals;

/**
 * Created by Diego Malone on 18/09/17.
 */

public class TotalTransferListUnitTest {

    private TotalTransferList totalTransferList;
    private TotalTransfer totalTransfer1, totalTransfer2, totalTransfer3;
    private Contact contact1, contact2, contact3;


    @Before
    public void setupTotalTransferList() {
        totalTransferList = new TotalTransferList();

        contact1 = new Contact(1, "", "", "");
        contact2 = new Contact(2, "", "", "");
        contact3 = new Contact(3, "", "", "");

        totalTransfer1 = new TotalTransfer(contact1, 100d);
        totalTransfer2 = new TotalTransfer(contact2, 20d);
        totalTransfer3 = new TotalTransfer(contact3, 10d);

        totalTransferList.add(totalTransfer1);
        totalTransferList.add(totalTransfer2);
        totalTransferList.add(totalTransfer3);
    }

    @Test
    public void testSize() {
        assertEquals(3, totalTransferList.size());

        totalTransferList.add(new TotalTransfer(null, 0d));

        assertEquals(4, totalTransferList.size());
    }

    @Test
    public void testContact() {
        assertEquals(totalTransfer1, totalTransferList.get(contact1));
        assertEquals(null, totalTransferList.get(null));
        assertEquals(true, totalTransferList.has(contact3));
        assertEquals(false, totalTransferList.has(null));
    }

    @Test
    public void testChartHeight() {
        assertEquals(100d, totalTransferList.getHighestValue());

        assertEquals(Math.max(20, MINIMUM_CHART_LINE_HEIGHT),
                Math.max(totalTransferList.get(contact2).getChartHeight(), MINIMUM_CHART_LINE_HEIGHT));
        assertEquals(Math.max(10, MINIMUM_CHART_LINE_HEIGHT),
                Math.max(totalTransferList.get(contact3).getChartHeight(), MINIMUM_CHART_LINE_HEIGHT));
    }
}
