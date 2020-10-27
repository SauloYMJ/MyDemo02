package com.example.demo02.service.impl;

import com.example.demo02.dao.JpaUserDao;
import com.example.demo02.model.JpaUser;
import com.example.demo02.service.JpaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaUserServiceImpl implements JpaUserService {
    @Autowired
    JpaUserDao jpaUserDao;

    @Override
    public List<JpaUser> listAllUser() {
        /*return jpaUserDao.findAll();*/
        return jpaUserDao.findAll();
    }

    @Override
    public JpaUser getUser (Integer id) {
        return jpaUserDao.findById(id).get();
    }

    @Override
    public JpaUser createUser(JpaUser user) {
        return jpaUserDao.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        jpaUserDao.deleteById(id);
    }
}
