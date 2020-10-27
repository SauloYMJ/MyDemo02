package com.example.demo02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo02.model.User;

@Mapper
public interface UserMapper {

    /**
     * 查询指定ID的数据
     *
     * @param id
     * @return
     */
    /*@Select("select * from user where id = #{id}")*/
    public User findOne(Long id);

    /**
     * 查询所有数据
     *
     * @return
     */
    /*@Select("select * from user")*/
    public List<User> findAll();

    /**
     * 插入数据
     *
     * @param data
     * @return
     */
    /*@Select("insert into user (id, name, mobile, email) values (#{id}, #{name}, #{mobile}, #{email})")*/
    public int insert(User data);

    /**
     * 删除指定ID的数据
     *
     * @param id
     * @return
     */
    /*@Select("delete from user where id = #{id}")*/
    public int delete(Long id);

}