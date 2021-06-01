package com.ycc.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true) // 链式写法
public class Dept implements Serializable {
    private Long dNo;
    private String dName;

    // 一个服务对应一个数据库，同一个信息可能存在不同的数据库
    private String db_source;   // 数据库标识

    /*
        链式写法：
        Dept dept = new Dept();
        dept.setDNo().setDeptName()
     */

}
