package com.huaibei;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Types;
import java.util.Collections;

/**
 * @author xiaolong
 * @date 2024/5/9
 */
@SpringBootTest
public class FastAutoGen {
    @Test
    public void generate(){
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/testR?serverTimezone=GMT%2B8", "root", "password")
                .globalConfig(builder -> {
                    builder.author("xiaolong")
                            .outputDir("/Users/xiaolong/Desktop/R/HelloWorld/src/main/java");// 指定输出⽬录
                })
                .dataSourceConfig(builder -> {
                    builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                        int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                        if (typeCode == Types.SMALLINT) {
                            //自定义类型转换
                            return DbColumnType.INTEGER;
                        }
                        return typeRegistry.getColumnType(metaInfo);
                    });
                }).packageConfig(builder -> {
                    builder.parent("com.huaibei")//设置父包名
                            .moduleName("demo")//设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml,
                                    "/Users/xiaolong/Desktop/R/HelloWorld/src/main/resources/mapper")); // 设置mapperXml⽣成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("student") // 设置需要⽣成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine())// 使⽤Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}

