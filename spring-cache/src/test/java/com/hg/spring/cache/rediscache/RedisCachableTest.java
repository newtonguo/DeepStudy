package com.hg.spring.cache.rediscache;

import com.hg.spring.cache.rediscache.cache.GetUserInfoC2s;
import com.hg.spring.cache.rediscache.entity.User;
import com.hg.spring.cache.rediscache.service.impl.RedisCacheService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:test-rediscache.xml")
@ContextConfiguration(classes = {RedisCacheConfig.class})
public class RedisCachableTest {
	
	@Autowired
	RedisCacheService redisCacheService;
	
	User tmp = null;



    @Test
    public void testFind(){

        redisCacheService.findById(1);

        User search = new User();
        search.setId(2);
        tmp = redisCacheService.findById(search);

    }
	
	@Test
	public void testFindById(){
		
		// 第一次需要查询数据库
		User tmp = redisCacheService.findById(1);
//		System.out.println("查询结果: "+JSON.toJSONString(tmp));
		
		User tmp2 = redisCacheService.findById(1);
//        System.out.println("查询结果: "+JSON.toJSONString(tmp2));

        redisCacheService.findById(2);
//		System.out.println("第一次查询结果: "+JSON.toJSONString(tmp));
		tmp = redisCacheService.findById(2);
//        System.out.println("第二次查询结果: "+JSON.toJSONString(tmp));
    }


	@Test
	public void testFindByController(){

		GetUserInfoC2s s = new GetUserInfoC2s();
		s.setId(1);
		// 第一次需要查询数据库
		User tmp = redisCacheService.findById(s);
        redisCacheService.findById(s);

        s.setId(2);

        redisCacheService.findById(s);
	}
	
	
	
	@Test
	public void findByObj() {

		User search = new User();
		search.setId(1);
		tmp = redisCacheService.findById(search);
		tmp = redisCacheService.findById(search);

	}
	
	@Test
	public void update() {

		User search = new User();
		search.setId(3);
		tmp = redisCacheService.findById(search);
		
		tmp = redisCacheService.findById(1);
		tmp = redisCacheService.findById(2);
		
		
//		redisCacheService.updateUser(tmp);
//		tmp = redisCacheService.findById(1);
		
		
//		System.out.println("修改后的效果 "+JSON.toJSONString(tmp));
	}
	

	
}
