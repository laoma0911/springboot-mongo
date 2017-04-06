package com.laoma.controller;

import com.alibaba.fastjson.JSON;
import com.laoma.domain.User;
import com.laoma.mongodao.UserDao;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Auther: laoma
 * @create: 2017-04-05 下午2:09
 */
@RestController
@RequestMapping("/mongo")
public class UserController {

    @Resource
    private UserDao userDao;


    @RequestMapping("/test")
    public String  test()  {

//        // 创建三个User，并验证User总数
//        userRepository.save(new User(1L, "didi", 30));
//        userRepository.save(new User(2L, "mama", 40));
//        userRepository.save(new User(3L, "kaka", 50));
//        Assert.assertEquals(3, userRepository.findAll().size());
//
//        // 删除一个User，再验证User总数
//        User u = userRepository.findOne(1L);
//        userRepository.delete(u);
//        Assert.assertEquals(2, userRepository.findAll().size());
//
//        // 删除一个User，再验证User总数
////        u = userRepository.findByUsername("mama");
//        userRepository.delete(u);
//        Assert.assertEquals(2, userRepository.findAll().size());
//
//
//        List<User> userList = mongoTemplate.findAll(User.class);
//
//
//        System.out.println(JSON.toJSON(userList));
//
//




//        User user1 = new User(4L,"laoma",26);
//        User user2 = new User(5L,"boss",45);
//        User user3 = new User(6L,"huha",32);
//        User user4 = new User(7L,"heihie",29);
//
//
//        userDao.save(user1);
//        userDao.save(user2);
//        userDao.save(user3);
//        userDao.save(user4);



        List<User> userList = userDao.findAll();

        System.out.println(JSON.toJSON(userList));


        return "success";

    }
}
