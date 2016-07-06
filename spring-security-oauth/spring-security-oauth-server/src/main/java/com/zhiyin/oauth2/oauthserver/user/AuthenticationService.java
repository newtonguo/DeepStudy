package com.zhiyin.oauth2.oauthserver.user;

import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.zhiyin.oauth.core.ZyUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private UserInfoRepo userInfoRepo;

//	@Autowired
//	private UserRoleRepo userRoleRepo;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserInfo userInfo = userInfoRepo.getUserInfo(username);

//        List<UserRole> roles = userRoleRepo.findByUsername(username);
        List<UserRole> roles =Lists.newArrayList();
        roles.add(new UserRole("ROLE_ADMIN"));

        List<SimpleGrantedAuthority> auhorities = Lists.newArrayList();

        for (UserRole role : roles ) {
            auhorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }

        log.info(JSON.toJSONString(userInfo));
        log.info(JSON.toJSONString(roles));

//		ZyUserDetails userDetails = new ZyUserDetails(userInfo.getId(),userInfo.getUsername(),
//				userInfo.getPassword(), userInfo.getEnabled(),auhorities );

        GrantedAuthority authority = new SimpleGrantedAuthority( "ROLE_ADMIN" );
        UserDetails userDetails = new User(userInfo.getUsername(),
                userInfo.getPassword(), auhorities );

		return userDetails;
	}
} 