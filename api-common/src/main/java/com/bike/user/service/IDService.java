package com.bike.user.service;

/**
 * ID生成器接口
 *
 * @author hesin
 */
public interface IDService {

    public long generate(String tableName, String columnName);
}
