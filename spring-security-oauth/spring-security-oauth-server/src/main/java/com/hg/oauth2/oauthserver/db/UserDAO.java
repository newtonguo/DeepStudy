package com.hg.oauth2.oauthserver.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {


    private JdbcTemplate jdbcTemplate;

//    @Resource(name="userInfoDataSource")
//    private DataSource userInfoDataSource;

    @Autowired
    public void setUserInfoDataSource( @Qualifier("userInfoDataSource") DataSource userInfoDataSource) {
        this.jdbcTemplate = new JdbcTemplate(userInfoDataSource);
    }
    public UserInfo getUserInfo(String username){
		String sql = "SELECT u.username name, u.password pass, a.authority role FROM "+
    			     "comp_users u INNER JOIN comp_authorities a on u.username=a.username WHERE "+
    			     "u.enabled =1 and u.username = ?";
    	UserInfo userInfo = (UserInfo)jdbcTemplate.queryForObject(sql, new Object[]{username},
    		new RowMapper<UserInfo>() {
	            public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
	                UserInfo user = new UserInfo();
	                user.setUsername(rs.getString("name"));
	                user.setPassword(rs.getString("pass"));
	                user.setRole(rs.getString("role"));
	                return user;
	            }
        });
    	return userInfo;
    }
} 