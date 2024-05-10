package com.huaibei.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huaibei.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author xiaolong
 * @date 2024/5/9
 */
@SpringBootTest
public class TeachersMapperTest {

    @Autowired
    private TeachersMapper teachersMapper;

    @Test
    public void testSelect(){
        System.out.println("------- selectAll method test -----");
        teachersMapper.selectList(null).forEach(System.out::println);
        assertEquals(teachersMapper.selectList(null).size(),24);
    }

    @Test
    public void testInsert(){
        //1、条件
        System.out.println("------- insert method test -----");
        assertNull(teachersMapper.selectById(25));
        //2、动作
        Teacher teacher = new Teacher();
        teacher.setTeacherName("test");
        teacher.setAge(22);
        teacher.setGender("male");
        teachersMapper.insert(teacher);
        //3、断言
        assertEquals(teachersMapper.selectList(null).size(),25);
        assertEquals(teachersMapper.selectById(25).getTeacherName(),"test");
    }

    @Test
    void deleteById() {
        Teacher teacher = new Teacher();
        teacher.setId(1);
        int count = teachersMapper.deleteById(teacher);
        assertEquals(count,1);

    }

    @Test
    void deleteByMap() {
        Map<String,Object> map = new HashMap<>();
        map.put("name","刘刚");
        map.put("gender","male");
        int count = teachersMapper.deleteByMap(map);
        assertEquals(count,1);
    }

    @Test
    void deleteBatchIds(){
        List<Integer> ids = Arrays.asList(1,2,10);
        int count = teachersMapper.deleteBatchIds(ids);
        assertEquals(count,3);
    }

    @Test
    void delete(){
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("gender","male")
                .like("name","刘");
        teachersMapper.delete(queryWrapper);
    }

    @Test
    void delete1(){
        Teacher teacher = new Teacher();
        teacher.setTeacherName("刘刚").setGender("male");
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>(teacher);
        int count = teachersMapper.delete(queryWrapper);
        assertEquals(count,1);
    }

    @Test
    void delete2(){
        LambdaQueryWrapper<Teacher> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Teacher::getTeacherName,"张")
                .eq(Teacher::getGender,"male");
        int count = teachersMapper.delete(queryWrapper);
        assertEquals(count,2);
    }

    // @Test
    // void delete3(){
    //     Teacher teacher = new Teacher();
    //     teacher.setTeacherName("刘");
    //     QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
    //     wrapper.eq(!StringUtils)
    // }

    @Test
    public void selectPage(){
        Page<Teacher> page = new Page<>(1,5);
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        teachersMapper.selectPage(page,wrapper);
        List<Teacher> records = page.getRecords();
        System.out.printf("总记录数:%d\t总页数%d\t当前页:%d\t每页显示 %d 条数据\t 是否有上一页:%s\t是否有下一页:%s%n",
                page.getTotal(),
                page.getPages(),
                page.getCurrent(),
                page.getSize(),
                page.hasPrevious(),
                page.hasNext());
    }

    @Test
    public void selectCustomer(){
        List<Teacher> list = teachersMapper.selectCustomer();
        list.forEach(System.out::println);
    }

    @Test
    public void selectCustomerPage(){
        Page<Teacher> page = new Page<>(1,5);
        teachersMapper.selectCustomerPage(page,50);
        List<Teacher> records = page.getRecords();
        System.out.printf("总记录数:%d\t总页数%d\t当前页:%d\t每页显示 %d 条数据\t 是否有上一页:%s\t是否有下一页:%s%n",
                page.getTotal(),
                page.getPages(),
                page.getCurrent(),
                page.getSize(),
                page.hasPrevious(),
                page.hasNext());
    }

    @Test
    public void testOptimisticLock(){
        Teacher teacher1 = teachersMapper.selectById(1);
        teacher1.setTeacherName("wind老师").setAge(33).setGender("male");
        Teacher teacher2 = teachersMapper.selectById(1);
        teacher2.setTeacherName("王老师").setAge(22).setGender("female");
        teachersMapper.updateById(teacher2);
        teachersMapper.updateById(teacher1);

    }
}
