package com.hg.spring.cache.rediscache;

import com.hg.spring.cache.rediscache.entity.User;
import com.hg.spring.cache.rediscache.service.impl.CacheNameFactory;
import com.hg.spring.cache.rediscache.service.impl.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
//@ContextConfiguration(classes = {RedisCacheConfig.class})
public class RedisCachableTest {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    UserInfoService userInfoService;

    @Test
    public void testFind() {

        User selFromService = userInfoService.findById(2L);
        assertThat(selFromService).isNotNull();

        Cache cache = cacheManager.getCache("userCache");
        assertThat(cache).isNotNull();

        User selFromCache = (User) cache.get("userinfo_id_2").get();
        assertThat(selFromCache.getName()).isEqualTo(selFromService.getName());

    }

    @Test
    public void testEmb() {
        userInfoService.findByIdNoCache(2L);
    }


    @Test
    public void selectAll() {

        userInfoService.selectAll();

    }

    @Test
    public void testUpdate() throws InterruptedException {

        userInfoService.selectAll();
        Cache cache = cacheManager.getCache(CacheNameFactory.UserSelAll);
        assertThat(cache).isNotNull();

        userInfoService.findById(2L);

        userInfoService.findById(3L);
        userInfoService.updateUser(3L, "hhhhh");

        cache = cacheManager.getCache(CacheNameFactory.UserSelAll);
        Cache.ValueWrapper selAll = cache.get("com.hg.spring.cache.rediscache.service.impl.UserInfoService.selectAll");
        assertThat(selAll).isNull();


//        Cache cache = cacheManager.getCache("userCache");
//        assertThat(cache).isNotNull();
//
//        User selFromCache = (User) cache.get("userinfo_id_2").get();
//        assertThat( selFromCache.getName() ).isEqualTo( selFromService.getName() );

    }


}
