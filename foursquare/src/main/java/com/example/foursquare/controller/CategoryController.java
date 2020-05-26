package com.example.foursquare.controller;

public class CategoryController {

   public void getCategory(){

       RestTemplate restTemplate = new RestTemplate();

        User entityResp = restTemplate.getForObject("http://localhost:8081/users/getUser/{userId}", User.class, params);
        ResponseEntity<String> sendEmailResp = restTemplate.postForEntity("http://localhost:8082/email/sendEmail", entityResp, String.class);

    }

}
