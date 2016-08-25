package com.lip.springnetty.data;

import com.lip.demo.data.UsersRepository;
import com.lip.demo.model.Users;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author lipeng32768@163.com
 * @version v1.0.0
 * @ClassName: UsersRespositoryTest
 * @Description: TODO
 * @date 2016/8/25 11:34
 */
/**
 * Created by Computer on 2016/8/17.
 */

/*
* Created by Computer on 2016/6/12.
* 配置Spring和junit 整合 ，junit 启动时加载springIOC 容器
* spring-test,junit
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-test.xml"})
public class UsersRespositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UsersRepository usersRespository;

    private final  String userPhone = "12345678901";
    private final  String name = "lipeng";
    @Before
    public void setUp() throws Exception {
        Users user = new Users();
        user.setName(name);
        user.setEmail("lipeng32768@163.com");
        user.setPhoneNumber(userPhone);
        usersRespository.addEntity(user);
        System.out.println("Before");
    }

    @After
    public void tearDown() throws Exception {
        Users user = usersRespository.findUserByPhoneNumber(userPhone);
        usersRespository.deleteEntity(user);
        System.out.println("After");
    }

    @Test
    public void findUserByPhoneNumber() throws Exception {
        Users user =  usersRespository.findUserByPhoneNumber(userPhone);

        logger.info(user.toString());
        System.out.println("findUserByPhoneNumber");

    }

    @Test
    public void findPointByName() throws Exception {
        Users user =  usersRespository.findUserByName(name);
        logger.info(user.toString());
       System.out.println("findPointByName");
    }


}