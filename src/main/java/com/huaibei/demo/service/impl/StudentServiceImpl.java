package com.huaibei.demo.service.impl;

import com.huaibei.demo.entity.Student;
import com.huaibei.demo.mapper.StudentMapper;
import com.huaibei.demo.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaolong
 * @since 2024-05-09
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
