package com.company.controller;

import com.post.api.dto.BoardDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {com.post.api.config.DataSourceConfig.class, com.post.api.config.DBConfiguration.class})
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
