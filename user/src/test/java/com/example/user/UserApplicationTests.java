package com.example.user;

import com.example.user.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class UserApplicationTests {

	@Test
	void contextLoads() {
	}

	/**
	 * this method will fetch without adding so it will get nothing
	 */
	@Test
	public void getUser(){

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		Map<String, String> params = new HashMap<String, String>();
		params.put("userId", "1");

		User entityResp = restTemplate.getForObject("http://localhost:8081/users/getUser/{userId}",User.class,params);
		Assert.assertNull(entityResp);
	}

	/**
	 * this method will add user and after that fetch the user
	 */
	@Test
	public void addUser(){

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		User user = new User();
		user.setName("tayfun");
		user.setLastName("celik");
		user.setEmail("deneme@gmail.com");

		String entityResp = restTemplate.postForObject("http://localhost:8081/users/addUser",user,String.class);
		Assert.assertNotNull(entityResp);


		Map<String, String> params = new HashMap<String, String>();
		params.put("userId", "1");

		User userResp = restTemplate.getForObject("http://localhost:8081/users/getUser/{userId}",User.class,params);
		Assert.assertNotNull(userResp);
	}

}
