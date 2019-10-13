package com.innoq.product;

import static junit.framework.TestCase.assertEquals;

import java.net.URI;

import com.innoq.product.model.Product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductServiceConsumerTest {

    @LocalServerPort
    int port;

    @Test
    public void getProduct1() {
        Long id = 1L;
        URI producUri = URI.create("http://localhost:" + port + "/products/" + id);
        Product product = new RestTemplate().getForObject(producUri, Product.class);
        assertEquals("This is the description for product 1", product.getDescription());
    }
}
