package com.huaibei.service;


import com.huaibei.entity.QUser;
import com.huaibei.entity.User;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaolong
 * @date 2024/5/10
 */
@Service
public class UserService {

    @Autowired
    private JPAQueryFactory jpaQuery;

    public List<User> findLikeUserByDSL(String username){
        QUser user = QUser.user;
        return jpaQuery.selectFrom(user).where(user.username.like("%"+username+"%")).orderBy(user.email.asc()).fetch();
    }

    public List<User> findUserByDSLMultiple(String username){
        QUser user = QUser.user;
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(user.username.eq(username));
        booleanBuilder.or(user.email.eq("username"));
        return jpaQuery.selectFrom(user).where(booleanBuilder).fetch();
    }


}
