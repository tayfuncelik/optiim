package com.example.noteapp;

import com.example.noteapp.model.Note;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
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
class NoteappApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void addNotes(){

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		Note note =  new Note();
		note.setNote("this is a note 1");
		note.setUserId(1L);

		ResponseEntity<String> noteResp = restTemplate.postForEntity("http://localhost:8083/note/addNote", note, String.class);
		Assert.assertNotNull(noteResp);
		//Assert.assertEquals(noteResp,"SUCCESS");
	}

	/**
	 * non existing note update will fail
	 */
	@Test
	public void updateNonExistNotes(){

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		Note note =  new Note();
		note.setNote("this is a note 2");
		note.setUserId(1L);

		ResponseEntity<String> noteResp = restTemplate.postForEntity("http://localhost:8083/note/updateNote", note, String.class);
		Assert.assertNull(noteResp);
	}


	@Test
	public void updateNotes(){

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		Note note =  new Note();
		note.setNote("this is a note 1");
		note.setUserId(1L);

		ResponseEntity<String> noteResp = restTemplate.postForEntity("http://localhost:8083/note/addNote", note, String.class);

		note.setId(1L);
		note.setNote("this is a note 2");
		note.setUserId(1L);

		ResponseEntity<String> updatenoteResp = restTemplate.postForEntity("http://localhost:8083/note/updateNote", note, String.class);
		Assert.assertNotNull(updatenoteResp);
		Assert.assertEquals(updatenoteResp,"SUCCESS");
	}
}
