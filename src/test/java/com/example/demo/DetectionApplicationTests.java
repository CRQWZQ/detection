package com.example.demo;

import com.example.demo.dao.ActivityMapper;
import com.example.demo.model.entity.Activity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DetectionApplicationTests {

	@Autowired
	private ActivityMapper activityMapper;

	@Test
	public void contextLoads() {
		Activity activity = new Activity();
		activity.setIsDelete(0);
		activity.setName("ssssssss");
		activity.setShopId(1234567L);
		activity.setStatus("NORMAL");
		activity.setUuid("ajkadhalxnqwnamxnuwqqsasdqewq");
		activity.setCreateTime(new Date());
		activity.setModifyTime(new Date());
		activityMapper.insertActivity(activity);
	}


}
