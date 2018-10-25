package io.rapha.spring.reactive.security;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SecuredRestApplicationTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    private WebTestClient rest;

    @Test
    public void messageWhenNotAuthenticated() throws Exception {
        this.rest
                .get()
                .uri("/api/admin")
                .exchange()
                .expectStatus().isUnauthorized();
    }


}