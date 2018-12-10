package com.example.demo;

import com.example.demo.untils.TimeConvertUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DetectionApplicationTests {

	@Test
	public void contextLoads() {
		Date date = new Date();
		Date date1 = TimeConvertUtil.getDelayByEndTime(date, 24);
		System.out.println(date1);
	}


}
