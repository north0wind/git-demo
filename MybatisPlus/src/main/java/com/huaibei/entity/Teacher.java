package com.huaibei.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author xiaolong
 * @date 2024/5/9
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("teacher")
public class Teacher {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(value = "name")
    private String teacherName;
    private String gender;
    @TableField(select = false)//这个字段查询不返回值
    private Integer age;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedTime;
    @Version
    // @TableField(value = "version")
    private Long version;
}
