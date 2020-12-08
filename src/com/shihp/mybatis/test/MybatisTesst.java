package com.shihp.mybatis.test;

import com.shihp.mybatis.entity.User;
import com.shihp.mybatis.mapper.UserMapper;
import com.shihp.mybatis.session.SqlSession;

/**
 * @author shihuipeng
 * @date 2020/12/8
 */
public class MybatisTesst {
    public static void main(String[] args) {
        SqlSession sqlSession = new SqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectUserById(1);
        System.out.println("user = " + user);
    }

}
