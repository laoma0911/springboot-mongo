package com.laoma.mongo;

import com.laoma.SpringbootMongoApplicationTests;
import com.laoma.base.Page;
import com.laoma.domain.User;
import com.laoma.mongodao.UserDao;
import com.laoma.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

/**
 * @Auther: laoma
 * @create: 2017-04-06 下午1:10
 */
@ActiveProfiles
public class UserTest extends SpringbootMongoApplicationTests {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRepository userRepository;


    //新增
    @Test
    public void test() {
        User user = new User("123456af6e6407195c0cd10a", "testmongo2", 34);


//        userRepository.findByName("testmongo");

//        outString(userDao.save(user));
//        outString(userRepository.findByAgeGreaterThan(21));
//        outString(userRepository.findTopByOrderByAgeDesc());
//        System.out.println("===============");
//        outString(userRepository.findTopByOrderByAgeAsc());
        Sort sort = new Sort(Sort.Direction.DESC, "age");
//        outString(userRepository.findAll(sort));

        PageRequest pageable = new PageRequest(0, 1, sort);
        outString(userRepository.findByAgeGreaterThan(1, pageable));

        PageRequest pageable2 = new PageRequest(1, 1, sort);
        outString(userRepository.findByAgeGreaterThan(1, pageable2));
        outString(pageable.getPageSize());
        outString(pageable.getPageNumber());
        outString(pageable.getOffset());
        outString(pageable.getSort());

        outString(pageable2.getPageSize());
        outString(pageable2.getPageNumber());
        outString(pageable2.getOffset());
        outString(pageable2.getSort());
    }


    //测试数据获取(all)
    @Test
    public void test1() {
        outString(userDao.findAll());
    }


    //测试数据获取(query);   注意请求参数属性与实体对象属性一一对应。
    @Test
    public void test2() {
        Query query = new Query(Criteria.where("age").gte(29));
        outString(userDao.find(query));
    }

    //测试数据获取(collectionName)
    @Test
    public void test3() {
        outString(userDao.findAll("testmongo"));
    }


    //测试数据获取(id)
    @Test
    public void test4() {
        User user = userDao.findById("582174af6e6407195c0cd10a");
        outString(user);
    }

    //条件查询(id、_id自动转换)
    @Test
    public void test5() {
        Query query = new Query(Criteria.where("id").is(4l));
        outString(userDao.find(query));
        outString(userDao.count(query));
    }


    //测试数据获取(query and);   注意请求参数属性与实体对象属性一一对应。
    @Test
    public void test6() {
        Query query = new Query(Criteria.where("id").is(4l).and("age").is(26));
        outString(userDao.find(query));
        outString(userDao.count(query));
    }

    //测试数据获取(page);
    @Test
    public void test7() {
        Query query = new Query();
        Page<User> page = new Page<User>();
        page.setPageSize(2); //设置分页记录数
        page.setCurrentPage(1); //设置当前页面
        Page<User> pages = userDao.findPage(page, query);
        outString(pages.getTotalCount());
        outString(pages.getTotalPage());
        List<User> list = pages.getRows();
        outString(list);
    }

}
