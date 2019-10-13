package com.innoq.product;

import static junit.framework.TestCase.assertEquals;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import com.innoq.product.adapter.ProductDetailsFetcher;
import com.innoq.product.model.ProductDetails;

import au.com.dius.pact.consumer.ConsumerPactTestMk2;
import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.PactTestExecutionContext;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;

public class ProductDetailsServiceConsumerTest extends ConsumerPactTestMk2 {

    @Override
    protected String providerName() {
        return "Product_Details_Service";
    }

    @Override
    protected String consumerName() {
        return "Product_Service";
    }

    @Override
    protected RequestResponsePact createPact(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json;charset=UTF-8");
        return builder
            .uponReceiving("a request for product details")
            .path("/productdetails/1")
            .method("GET")
            .willRespondWith().headers(headers)
            .status(200)
            .body("{\"id\":1,\"description\":\"This is the description for product 1\"}")
            .toPact();
    }

    @Override
    protected void runTest(MockServer mockServer, PactTestExecutionContext context) throws IOException {
        URI productDetailsUri = URI.create(String.format("%s/%s/%s", mockServer.getUrl(), "productdetails", 1));

        ProductDetailsFetcher productDetailsFetcher = new ProductDetailsFetcher();
        ProductDetails productDetails = productDetailsFetcher.fetchDetails(productDetailsUri);
        assertEquals(productDetails.getId(), 1);

    }
}
