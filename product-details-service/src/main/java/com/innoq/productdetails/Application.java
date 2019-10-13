package com.innoq.productdetails;

import com.innoq.productdetails.model.ProductDetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping(value = "/productdetails/{id}", method = RequestMethod.GET)
    public ProductDetails fetchProductDetails(@PathVariable final long id) {
        return new ProductDetails(id, "This is the description for product " + id);
    }

}