package com.tws.refactoring.extract_method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OwingPrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void printOwing() {
        final double amount = 10;
        final String orderName = "McDonalds Order";
        final Order order1 = new Order(amount);
        final Order order2 = new Order(amount);
        final Order order3 = new Order(amount);
        final Order order4 = new Order(amount);
        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        orderList.add(order4);

        final OwingPrinter printer = new OwingPrinter();
        final String expected =
                "*****************************\r\n" +
                "****** Customer totals ******\r\n" +
                        "*****************************\r\n" +
                        "name: McDonalds Order\r\n" +
                        "amount: 40.0\r\n";

        printer.printOwing(orderName, orderList);

        assertEquals(expected, outContent.toString());
    }
}