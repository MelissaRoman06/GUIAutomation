/*
 * @(#) Product.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package ninjaStore.entities;

/**
 * Product class is used to save relevant attributes of a product offered on The Ninja Store page.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class Product {
    private String productName;
    private double price;

    /**
     * Allows to set the name of the product.
     *
     * @param productName - Name to be set.
     */
    public void setProductName(final String productName) {
        this.productName = productName;
    }

    /**
     * Allows to get the product's name.
     *
     * @return - productName.
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Allows to get the product's price.
     *
     * @param price - Price to be set.
     */
    public void setPrice(final double price) {
        this.price = price;
    }

    /**
     * Allows to get product's price.
     *
     * @return price.
     */
    public double getPrice() {
        return price;
    }
}
