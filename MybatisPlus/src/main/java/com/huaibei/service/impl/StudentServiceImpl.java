package com.huaibei.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huaibei.entity.Student;
import com.huaibei.mapper.StudentMapper;
import com.huaibei.service.IStudentService;
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
