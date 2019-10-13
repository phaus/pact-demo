package com.innoq.product;

import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import com.innoq.product.adapter.ProductDetailsFetcher;
import com.innoq.product.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.innoq.product"})
@RestController
public class ProductsController {

    @Autowired
    private ProductDetailsFetcher detailsFetcher;

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public Product fetchProductPrice(@PathVariable final long id) {
        URI productDetailsUri = URI.create("http://localhost:10100/productdetails/1");
        return new Product(id, "Foo Product", detailsFetcher.fetchDetails(productDetailsUri));

    }

}