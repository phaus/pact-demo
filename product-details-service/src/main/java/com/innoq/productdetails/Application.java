package com.innoq.productdetails;

import java.util.logging.Logger;

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

    Logger Log = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping(value = "/productdetails/{id}", method = RequestMethod.GET)
    public ProductDetails fetchProductDetails(@PathVariable final long id) {
        Log.info("got fetchProductDetails request for id " + id);
        return new ProductDetails(id, "This is the description for product " + id);
    }

}