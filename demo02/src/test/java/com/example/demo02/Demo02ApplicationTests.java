package com.example.demo02;

import com.example.demo02.model.User;
import com.example.demo02.service.UserService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class Demo02ApplicationTests {

    @Autowired
    private UserService userService;

    /**
     * 取得所有用户信息
     */
    @Test
    void findAllUser() {
        try {
            List<User> list = userService.listAllUser();
            Iterator<User> iterator = list.listIterator();
            while (iterator.hasNext()){
                User user = iterator.next();
                System.out.println("用户名为：" + user.getName() + "用户邮箱为：" + user.getEmail());
            }
        } catch (Exception ex) {
            System.out.println("执行错误");
        }
    }

    /**
     * 取得编号为 1 的用户信息
     */
    @Test
    void findOneUser() {
        try {
            long a = 1;
            User user = userService.getUser( a);
            System.out.println("用户名为：" + user.getName() + "用户邮箱为：" + user.getEmail());

        } catch (Exception ex) {
            System.out.println("执行错误");
        }
    }

}