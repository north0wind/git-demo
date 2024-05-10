package com.huaibei.dao;

import com.huaibei.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author xiaolong
 * @date 2024/5/10
 */
public interface UserRepository extends JpaRepository<User,String>{
    List<User> findUserByUsernameAndPassword(String username,String password);

    @Query(value = "from User u where u.username = ?1 and u.password = ?2")
    List<User> findUserByUsernameAndPassword2(String username,String password);

    @Query(nativeQuery = true,value = "from User u where u.username = ?1 and u.password = ?2")
    List<User> findUserByUsernameAndPassword3(String username,String password);


}
