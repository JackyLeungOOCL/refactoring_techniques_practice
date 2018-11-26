package com.tws.refactoring.extract_variable;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PriceCalculatorTest {
    @Test
    public void should_get_price() {
        final int quantity = 20;
        final int itemPrice = 30;
        final PriceCalculator priceCalculator = new PriceCalculator();

        final double expected = quantity * itemPrice -
                Math.max(0, quantity - 500) * itemPrice * 0.05 +
                Math.min(quantity * itemPrice * 0.1, 100.0);
        final double price = priceCalculator.getPrice(quantity, itemPrice);
        final double delta = 0.00002;

        assertEquals(expected, price, delta);
    }
}
