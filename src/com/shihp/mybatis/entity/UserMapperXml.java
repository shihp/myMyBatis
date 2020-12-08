package com.shihp.mybatis.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * 映射sql的存储
 *
 * @author shihuipeng
 * @date 2020/12/8
 */
public class UserMapperXml {
    public static final String namespace = "com.shihp.mybatis.mapper.UserMapper";
    public static Map<String, String> map = new HashMap<>();

    static {
        map.put("selectUserById", "SELECT ID, NAME, AGE FROM TB_USER WHERE ID = ?");
    }
}
