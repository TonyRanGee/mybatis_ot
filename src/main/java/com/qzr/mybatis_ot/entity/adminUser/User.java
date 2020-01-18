package com.qzr.mybatis_ot.entity.adminUser;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Tolerate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@Document("user")
public class User {
    @ExcelProperty(value = {"用户id"},index = 0)
    @Id
    private Long id;
    @ExcelProperty(value = {"用户名字"},index = 1)
    private String name;
    @ExcelProperty(value = {"用户年龄"},index = 2)
    private int age;
    @ExcelProperty(value = {"用户性别"},index = 3)
    private int sex;
    @ExcelProperty(value = {"用户简介"},index = 4)
    private String content;
    @ExcelProperty(value = {"用户住址"},index = 5)
    private String address;

    @Tolerate
    public User() {

    }
}
