package com.huaibei.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huaibei.entity.Teacher;
import com.huaibei.mapper.TeachersMapper;
import com.huaibei.service.TeacherService;
import org.springframework.stereotype.Service;

/**
 * @author xiaolong
 * @date 2024/5/9
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeachersMapper, Teacher> implements TeacherService {
}
