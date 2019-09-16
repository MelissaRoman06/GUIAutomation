/*
 * @(#) Context.java Copyright (c) 2019 Jala Foundation.
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
 * Context class is used to share objects between steps.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class Context {
    private Product product;
    private Address address;

    /**
     * Constructs all elements in the context.
     */
    public Context() {
        this.product = new Product();
        this.address = new Address();
    }

    /**
     * Allows to get context's product.
     *
     * @return - Product.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Allows to get context's address.
     *
     * @return - Address.
     */
    public Address getAddress() {
        return address;
    }
}
