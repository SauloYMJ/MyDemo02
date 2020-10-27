package com.example.demo02.controller;

import com.example.demo02.model.JpaUser;
import com.example.demo02.service.JpaUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/anotherUser")
public class JpaUserController {

    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    // 用户Servic对象
    @Autowired
    private JpaUserService userService;

    /**
     * 所有用户信息取得
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object getAllUser() {
        Map<String, Object> result = new HashMap<String, Object>();
        List<JpaUser> list = userService.listAllUser();

        try {
            list = this.userService.listAllUser();
            result.put("status", "ok");
            result.put("list", list);
        } catch (Exception ex) {
            result.put("status", "failure");
            result.put("errMsg", ex.getMessage());
            logger.error(ex.getMessage(), ex);
        } finally {
        }
        return result;
    }

    /**
     * 指定用户信息取得
     */
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public Object getUserDetail(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            JpaUser user = userService.getUser(id);
            if (user != null) {
                result.put("status", "ok");
                result.put("user", user);
            } else {
                result.put("status", "failure");
                result.put("errMsg", "用户不存在");
            }
        } catch (Exception ex) {
            result.put("status", "failure");
            result.put("errMsg", ex.getMessage());
            logger.error(ex.getMessage(), ex);
        } finally {
        }
        return result;
    }

    /**
     * 创建用户信息
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Object createUser(@RequestParam(value = "id", required = true) Integer id,
                             @RequestParam(value = "name", required = true) String name,
                             @RequestParam(value = "mobile", required = false) String mobile,
                             @RequestParam(value = "email", required = false) String email) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            JpaUser user = new JpaUser();
            user.setId(id);
            user.setName(name);
            user.setMobile(mobile);
            user.setEmail(email);
            JpaUser cnt = userService.createUser(user);
            if (cnt != null) {
                result.put("status", "ok");
                result.put("user", user);
            } else {
                result.put("status", "failure");
                result.put("errMsg", "用户创建失败");
            }
        } catch (Exception ex) {
            result.put("status", "failure");
            result.put("errMsg", ex.getMessage());
            logger.error(ex.getMessage(), ex);
        } finally {
        }
        return result;
    }

    /**
     * 指定用户信息删除
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public Object deleteUser(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<String, Object>();
        userService.deleteUser(id);
        return "";
    }
}
