package com.tws.refactoring.extract_variable;

public class PriceCalculator {
    double getPrice(int quantity, int itemPrice) {
        // Price consists of: base price - discount + shipping cost
        int discountFromQuantity = 500;
        double discountRate = 0.05;
        double maxShippingCost = 100.0;
        double shippingCostRate = 0.1;

        int basePrice = getBasePrice(quantity, itemPrice);
        double discount = getDiscount(quantity, itemPrice, discountFromQuantity, discountRate);
        double shippingCost = getShippingCost(quantity, itemPrice, maxShippingCost, shippingCostRate);
        return basePrice - discount + shippingCost;
    }

    private double getShippingCost(int quantity, int itemPrice, double maxShippingCost, double shippingCostRate) {
        return Math.min(quantity * itemPrice * shippingCostRate, maxShippingCost);
    }

    private double getDiscount(int quantity, int itemPrice, int discountFromQuantity, double discountRate) {
        return Math.max(0, quantity - discountFromQuantity) * itemPrice * discountRate;
    }

    private int getBasePrice(int quantity, int itemPrice) {
        return quantity * itemPrice;
    }


}
