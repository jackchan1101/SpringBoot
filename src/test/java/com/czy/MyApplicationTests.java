package com.czy;

import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void test() {
		//加密配置文件中的敏感信息
		BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
		basicTextEncryptor.setPassword("key-czy");
		String encrypt = basicTextEncryptor.encrypt("123456");
		System.out.println("password:" + encrypt);
	}

}
