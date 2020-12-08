package com.shihp.mybatis.mapper;

import com.shihp.mybatis.entity.User;

/**
 * @author shihuipeng
 * @date 2020/12/8
 */
public interface UserMapper {
    User selectUserById(int i);
}
