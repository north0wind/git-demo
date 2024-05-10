package com.huaibei.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huaibei.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xiaolong
 * @date 2024/5/9
 */
public interface TeachersMapper extends BaseMapper<Teacher> {
    List<Teacher> selectCustomer();

    Page<Teacher> selectCustomerPage(@Param("page") Page page,@Param("age") int age);

}
