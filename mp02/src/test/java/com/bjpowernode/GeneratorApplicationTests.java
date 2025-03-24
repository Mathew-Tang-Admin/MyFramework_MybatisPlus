package com.bjpowernode;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Paths;
import java.util.Collections;

/**
 * 代码生成器测试
 * @author MathewTang
 */
@SpringBootTest
public class GeneratorApplicationTests {
    @Test
    void testPath() {
        String s = Paths.get(System.getProperty("user.dir")) + "\\src\\main\\java";
        System.out.println(s);
        System.out.println("D:\\Workspaces\\MyFramework_MybatisPlus\\mp02\\src\\main\\java\\com\\bjpowernode\\mapper\\UserMapper.java");
        System.out.println("D:\\Workspaces\\MyFramework_MybatisPlus\\mp02\\src\\main\\resources\\application.yml");
    }

    public static void main(String[] args) {
        // officialWebsiteVersion();
        teacherVersion();
    }

    private static void teacherVersion() {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/dljd_mybatisplus?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false", "root", "root")
                        .globalConfig(builder->{
                            builder.author("powernode") //设置作者
                                    // .enableSwagger() //开启swagger模式
                                    .fileOverride() //覆盖已生成文件
                                    .outputDir("D://"); //指定输出目录
                        })
                        .packageConfig(builder->{
                            builder.parent("com.bjpowernode") //设置父包名
                                    .moduleName("mybatisplus")//设置父包模块名
                                    .pathInfo(Collections.singletonMap(OutputFile.xml,"D://"));//设置mapperXml生成路径
                        })
                        .strategyConfig(builder->{
                            builder.addInclude("powershop_user")//设置需要生成的表名
                                    .addTablePrefix("powershop"); //设置过滤表前缀
                        })
                        .templateEngine(new FreemarkerTemplateEngine()) //使用Freemarker引擎模板，默认的是Velocity引擎模板
                        .execute();
    }

    private static void officialWebsiteVersion() {
        // 使用 FastAutoGenerator 快速配置代码生成器
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/dljd_mybatisplus?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&autoReconnect=true&useSSL=false", "root", "root")
                .globalConfig(builder -> {
                    builder.author("MathewTang") // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(Paths.get(System.getProperty("user.dir")) + "/src/main/java"); // 输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.bjpowernode") // 设置父包名
                            .moduleName("mybatisplus")// 设置父包模块名
                            .entity("domain") // 设置实体类包名
                            .mapper("mapper") // 设置 Mapper 接口包名
                            .service("service") // 设置 Service 接口包名
                            .serviceImpl("service.impl") // 设置 Service 实现类包名
                            .xml("mapper") // 设置 Mapper XML 文件包名
                            .pathInfo(Collections.singletonMap(OutputFile.xml,Paths.get(System.getProperty("user.dir")) + "/src/main/java")); // 设置mapperxml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("powershop_user") // 设置需要生成的表名
                            .addTablePrefix("powershop_")// 设置过滤表前缀
                            .entityBuilder()
                            .enableLombok() // 启用 Lombok
                            .enableTableFieldAnnotation() // 启用字段注解
                            .controllerBuilder()
                            .enableRestStyle(); // 启用 REST 风格
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用 Freemarker 模板引擎
                .execute(); // 执行生成
    }
}
