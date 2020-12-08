package com.shihp.mybatis.session;

import com.shihp.mybatis.binding.MapperProxy;
import com.shihp.mybatis.executor.Executor;
import com.shihp.mybatis.executor.SimpleExecutor;

import java.lang.reflect.Proxy;

/**
 * 加载代理对象执行sql
 *
 * @author shihuipeng
 * @date 2020/12/8
 */
public class SqlSession {
    private Executor executor = new SimpleExecutor();

    public <T> T selectOne(String statement, Object parameter) {
        return executor.query(statement, parameter);
    }

    public <T> T getMapper(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new MapperProxy<T>(this));
    }
}

