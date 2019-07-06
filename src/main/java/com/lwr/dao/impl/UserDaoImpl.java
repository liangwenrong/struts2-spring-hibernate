package com.lwr.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lwr.dao.UserDao;
import com.lwr.pojo.entity.User;

/**
 * dao层执行sql的三种方式 
 * 1、使用spring-jdbc的JdbcTemplate（需要注入dataSource）
 * 2、推荐使用hibernate提供的sessionFactory（可以执行hql）
 * 3、继承HibernateDaoSupport，通过在方法上注入@Autowired sessionFactory，并调用super.setSessionFactory(sessionFactory)
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate JdbcTemplate;
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unused")
    @Override
    public User getLoginUser(User user) {
        User userByJDBC = getUserByJDBC(user);
        return getUserByHibernate(user);
    }
    
    @Override
    public void addUser(User user) {
        getSession().save(user);
    }

    private User getUserByJDBC(User user) {
        String sql = "select * from user where login_id=? and password=? ";
        List<Map<String, Object>> userList = JdbcTemplate.queryForList(sql, new Object[] { user.getLoginId(), user.getPassword() });
        if (userList != null && userList.size() > 0) {
            Map<String, Object> map = userList.get(0);
            User user1 = new User();
            user1.setId((String)map.get("id"));
            user1.setName((String)map.get("name"));
            user1.setLoginId((String)map.get("login_id"));
            user1.setPassword((String)map.get("password"));
            user1.setTel((String)map.get("tel"));
            user1.setCreateDate((Timestamp)map.get("create_date"));
            return user1;
        }
        return null;
    }

    private User getUserByHibernate(User user) {
        String hql = "from User where loginId=:loginId and password=:password ";
        Query<User> query = getSession().createQuery(hql, User.class);
        query.setParameter("loginId", user.getLoginId());
        query.setParameter("password", user.getPassword());
        List<User> userList = query.list();
        if (userList != null && userList.size() > 0) {
            User user1 = userList.get(0);
            return user1;
        }
        return null;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
