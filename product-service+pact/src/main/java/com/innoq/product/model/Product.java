package com.innoq.product.model;

public class Product {

    private long id;

    private String name;
    private String description;

    public Product() {

    }

    public Product(final long id, final String name, final ProductDetails details) {
        this.id = id;
        this.name = name;
        this.description = details.getDescription();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
