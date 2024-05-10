package com.huaibei.ControllerTest;

import com.huaibei.controller.HelloController;
import com.huaibei.dto.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHello() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World!"));
    }

    @Test
    public void testCorsActualRequest() throws Exception{
        mockMvc.perform(get("/cors")
                .header(HttpHeaders.ORIGIN, "http://example.com"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello CORS!"))

                .andExpect(header().exists(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN))
                .andExpect(header().string(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN,"http://example.com"));
    }

    @Test
    public void testCorsPreflightRequest() throws Exception{
        mockMvc.perform(options("/cors")
                .header(HttpHeaders.ORIGIN, "http://example.com")
                .header(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD,"GET")
                .header(HttpHeaders.ACCESS_CONTROL_REQUEST_HEADERS,"Content-Type"))
                .andExpect(status().isOk())
                .andExpect(header().exists(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN))
                .andExpect(header().string(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN,"http://example.com"))
                .andExpect(header().exists(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS))
                .andExpect(header().string(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS,containsString("GET")));

    }

    @Test
    public void testGetUserByIdBindByServletRequest() throws Exception{
        long testId = 123L;
        String expectedResponse = "Hello" + testId;

        mockMvc.perform(get("/user/by/servlet/request?id=" + testId))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));
    }


    @Test
    public void testGetUserByPathVariable() throws Exception{
        long testId = 123L;
        String expectedResponse = "Hello " + testId;
        mockMvc.perform(get("/user/by/path/variable/" + testId))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));
    }

    @Test
    public void testCreateUser() throws Exception{
        User user = new User();
        user.setName("Test name");

        mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Test User\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Test User"));
    }


}
