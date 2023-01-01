package com.udacity.pricing;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PricingServiceApplicationTests {

    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void contextLoads() {}

    @Test
    public void testGetPrices() {
        ResponseEntity<?> response = restTemplate.getForEntity("http://localhost:" + port + "/prices/", Object.class);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testGetNonExistentPrice() {
        ResponseEntity<?> response =
                restTemplate.getForEntity("http://localhost:" + port + "/prices/100", Object.class);
        Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testDeletePrice() {
        restTemplate.delete("http://localhost:" + port + "/prices/1");
       ResponseEntity<?> response = restTemplate.getForEntity("http://localhost:" + port + "/prices/1", Object.class);
        Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
