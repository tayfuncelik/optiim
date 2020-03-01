package com.example.email;

import com.example.email.model.EmailEntity;
import com.example.email.service.EmailService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class EmailApplicationTests {

	@Autowired
	private EmailService emailService;

	@Test
	void contextLoads() {}

	@Test
	public void sendEmail() {
		EmailEntity e= new EmailEntity();
		e.setFrom("from@gmail");
		e.setTo("to@gmail.com");
		e.setMessageBody("this is body");
		boolean isSend =emailService.sendEmail(e);
		Assert.isTrue(isSend);
	}

	@Test
	public void sendEmailMissingField() {
		EmailEntity e= new EmailEntity();
		e.setMessageBody("this is body");
		boolean isSend =emailService.sendEmail(e);
		Assert.isTrue(!isSend);
	}

}