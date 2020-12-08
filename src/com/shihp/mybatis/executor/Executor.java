package com.shihp.mybatis.executor;

/**
 * @author shihuipeng
 * @date 2020/12/8
 */
public interface Executor {
    public <T> T query(String statement, Object parameter);
}
