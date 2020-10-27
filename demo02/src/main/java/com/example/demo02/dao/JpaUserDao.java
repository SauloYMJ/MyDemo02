package com.example.demo02.dao;

import com.example.demo02.model.JpaUser;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Jpa框架实现demo02的dao接口
 * create by 尹明君
 */
@Transactional
public interface JpaUserDao extends JpaRepository<JpaUser, Integer> {
    /**
     * 查询指定ID的数据
     *
     * @param id
     * @return
     */



    /**
     * 查询所有数据
     *
     * @return
     */
    /*@Modifying
    @Query(value = "select '*' from user")*/
    public List<JpaUser> findAll();

    /**
     * 插入数据
     *
     * @param data
     * @return
     */
    /*public int insert(JpaUser data);*/

    /**
     * 删除指定ID的数据
     *
     * @param id
     * @return
     */
    /*public int delete(Long id);*/
}
