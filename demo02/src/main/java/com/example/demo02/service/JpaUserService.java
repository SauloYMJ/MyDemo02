package com.example.demo02.service;

import com.example.demo02.model.JpaUser;

import java.util.List;

/**
 * Jpa框架实现demo02的service接口
 *  * create by 尹明君
 */

public interface JpaUserService {
    List<JpaUser> listAllUser();

    JpaUser getUser(Integer id);

    JpaUser createUser(JpaUser user);

    void deleteUser(Integer id);
}
