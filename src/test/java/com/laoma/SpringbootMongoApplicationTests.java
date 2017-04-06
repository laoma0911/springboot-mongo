package com.laoma;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringbootMongoApplication.class)
public class SpringbootMongoApplicationTests {

	public void outString(Object object) {
		System.out.println(JSONObject.toJSON(object));
	}
}
