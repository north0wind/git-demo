package com.huaibei.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huaibei.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author xiaolong
 * @date 2024/5/9
 */
@SpringBootTest
public class TeacherServiceTest {

    @Autowired
    private TeacherService teacherService;

    @Test
    public void testSelect(){
        teacherService.list().forEach(System.out::println);
    }

    @Test
    public void testSelectCondition(){
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.like("name","张");
        teacherService.list(wrapper).forEach(System.out::println);
    }

    @Test
    public void testSave(){
        Teacher teacher = new Teacher();
        teacher.setTeacherName("周老师").setAge(33).setGender("male");
        boolean b = teacherService.save(teacher);
        System.out.println(b);
    }

}
