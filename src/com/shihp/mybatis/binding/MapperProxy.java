package com.shihp.mybatis.binding;

import com.shihp.mybatis.entity.UserMapperXml;
import com.shihp.mybatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 实现动态代理类
 * @author shihuipeng
 * @date 2020/12/8
 */
public class MapperProxy<T> implements InvocationHandler {
    private SqlSession sqlSession;

    public MapperProxy(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass().getName().equals(UserMapperXml.namespace)) {
            String sql = UserMapperXml.map.get(method.getName());
            return sqlSession.selectOne(sql, args[0]);
        }
        return null;
    }
}
