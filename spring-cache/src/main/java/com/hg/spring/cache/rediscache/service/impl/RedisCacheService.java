package com.hg.spring.cache.rediscache.service.impl;

import java.util.List;

import com.hg.spring.cache.rediscache.cache.GetUserInfoC2s;
import com.hg.spring.cache.rediscache.dao.UserDao;
import com.hg.spring.cache.rediscache.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


/**
 * Created by wisely on 2015/5/25.
 */
@Service("redisCacheService")
public class RedisCacheService {
	

	@Autowired
	private UserDao userDao;



	
	// 查询所有，不要key,默认以方法名+参数值+内容 作为key
	@Cacheable(value = "userCache")
	public List<User> getAll(){
		printInfo("getAll");
		return userDao.users;
	}


	// 根据ID查询，ID 我们默认是唯一的
	@Cacheable(value = "userCache")
	public User findById(Integer id){
		printInfo(id);
		User user = userDao.findById(Integer.valueOf(id));
		return user;
	}
    // 重写keygenerator
	@Cacheable(value = "userCache" , key=" 'userinfo' + '.' + #user.id")
	public User findById(User user){
		printInfo(user);
		return userDao.findById(user.getId());
	}



	@Cacheable(value = "userCache")
    public User findById(GetUserInfoC2s id){
        printInfo(id);
        User user = userDao.findById(Integer.valueOf(id.getId()));
        return user;
    }
	
	@Cacheable(value = "userCache")
	public User findById(String id){
		printInfo(id);
		return userDao.findById(Integer.valueOf(id));
	}

	
	// 通过ID删除
	@CacheEvict(value = "userCache")
	public void removeById(Integer id){
		userDao.removeById(id);
	}
	
	public void addUser(User u){
		if(u != null && u.getId() != null){
			userDao.addUser(u);
		}
	}
	// key 支持条件，包括 属性condition ，可以 id < 10 等等类似操作
	// 更多介绍，请看参考的spring 地址
	@CacheEvict(value="userCache" , allEntries = true)  
	public void updateUser(User u){
		removeById(u.getId());
		userDao.updateUser(u);
	}
	
	
	public void removeByIdNoCache(Integer id){
		userDao.removeById(id);
	}
	
	// 修改，缓存无关
	public void updateUserNoCache(User u){
		removeByIdNoCache(u.getId());
		userDao.updateUser(u);
	}
	
	// allEntries 表示调用之后，清空缓存，默认false,
	// 还有个beforeInvocation 属性，表示先清空缓存，再进行查询
	@CacheEvict(value="userCache",allEntries=true)
	public void removeAll(){
		System.out.println("清除所有缓存");
	}
	
	private void printInfo(Object str){
		System.out.println("非缓存查询----------"+str);
	}
	
	
}
