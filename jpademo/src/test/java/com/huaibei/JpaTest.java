package com.huaibei;

import com.huaibei.dao.UserRepository;
import com.huaibei.entity.User;
import com.huaibei.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author xiaolong
 * @date 2024/5/10
 */
@SpringBootTest
public class JpaTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    @Test
    public void testJpa(){
        User user = new User();
        user.setUsername("xiaolong");
        user.setPassword("123456");
        user.setEmail("xiaolong@163.com");
        userRepository.save(user);
    }

    @Test
    public void testJpa1(){
        List<User> users = userRepository.findUserByUsernameAndPassword("toony","123456");
        assertThat(users.size()).isEqualTo(1);
        users.forEach(System.out::println);
    }

    @Test
    public void testJpa2(){
        List<User> users = userRepository.findUserByUsernameAndPassword2("toony","123456");
        assertThat(users.size()).isEqualTo(1);
        users.forEach(System.out::println);
    }

    @Test
    public void testJpa3(){
        List<User> users = userRepository.findUserByUsernameAndPassword3("toony","123456");
        assertThat(users.size()).isEqualTo(1);
        users.forEach(System.out::println);
    }

    @Test
    public void testQueryByDSL(){
        List<User> users = userService.findLikeUserByDSL("xiaolong");
        assertThat(users.size()).isEqualTo(1);
        users.forEach(System.out::println);
    }

    @Test
    public void testQueryByDSLMultiCondition(){
        List<User> users = userService.findUserByDSLMultiple("xiaolong");
        assertThat(users.size()).isEqualTo(1);
        users.forEach(System.out::println);
    }
}
