package com.onur.todo;

import com.onur.todo.requestModel.CreationModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TodoControllerShould {
    TestRestTemplate testTemplate = new TestRestTemplate();
    @LocalServerPort private int port;


    @Test
    public void addActionItem(){
        HttpEntity<CreationModel> entity = new HttpEntity<>(new CreationModel("Onno", null, "Yeni mesaj"));

        ResponseEntity<String> response = testTemplate.exchange(createURLWithPort("/list/add"), HttpMethod.POST, entity, String.class);

        assertTrue(response.getStatusCode() == HttpStatus.CREATED);
     }


    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
