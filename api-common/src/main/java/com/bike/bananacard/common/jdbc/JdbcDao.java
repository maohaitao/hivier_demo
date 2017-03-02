package com.bike.bananacard.common.jdbc;

import com.sf.common.database.dao.BaseDaoImpl;
import com.sf.common.exception.AppException;
import com.sf.common.exception.ErrorCode;
import com.sf.common.reflection.Reflector;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：通用service，封装基本操作 创建时间：15/4/15 作者：yanghui
 */
@Service
public class JdbcDao {
    @Resource(name = "dao")
    private BaseDaoImpl baseDao;
    private String key = "id";

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    private Field getDeclaredField(Class classz, String field) {
        if (StringUtils.isEmpty(field) || classz == null) {
            return null;
        }
        try {
            return classz.getDeclaredField(field);
        } catch (NoSuchFieldException e) {
            if (classz.getSuperclass() != null) {
                return getDeclaredField(classz.getSuperclass(), field);
            }
            return null;
        }
    }

    private <T> List<String> getParamNames(T t) throws AppException {
        try {
            Reflector e = Reflector.forClass(t.getClass());
            List<String> paramNames = new ArrayList<String>();
            for (String propertyName : e.getGetablePropertyNames()) {
                Object value = e.getGetInvoker(propertyName).invoke(t, null);
                if (value == null) {
                    continue;
                }
                if (value instanceof String) {
                    if (!StringUtils.hasLength(value.toString())) {
                        continue;
                    }
                }
                paramNames.add(propertyName);
            }
            return paramNames;
        } catch (Exception e) {
            throw new AppException(1, e.getMessage());
        }
    }

    @SuppressWarnings({"unchecked"})
    public <T> List<T> queryBySQL(String sql, Class<T> tClass, List<Object> params) throws AppException {
        return baseDao.list(sql, tClass, params);
    }

    @SuppressWarnings({"unchecked"})
    public <T> List<T> queryByEntity(T t, List<String> params) throws AppException {
        return baseDao.list(t, params);
    }

    @SuppressWarnings({"unchecked"})
    public <T> List<T> queryByEntity(T t) throws AppException {
        return baseDao.list(t, getParamNames(t));
    }


    @SuppressWarnings({"unchecked"})
    public <T> List<T> queryAll(String sql, Class<T> tClass) throws AppException {
        return baseDao.list(sql, tClass);
    }

    public <T> List<T> queryAll(Class<T> tClass) throws AppException {
        try {
            return queryByEntity(tClass.newInstance());
        } catch (InstantiationException e) {
            throw new AppException(1, e.getMessage());
        } catch (IllegalAccessException e) {
            throw new AppException(1, e.getMessage());
        }
    }

    public <T> void saveEntity(T t, String key) throws AppException {
        try {
            if (t != null) {
                Reflector e = Reflector.forClass(t.getClass());
                Field idField = getDeclaredField(t.getClass(), key);
                if (idField == null) {
                    baseDao.add(t);
                } else {
                    Integer id = (Integer) e.getGetInvoker(key).invoke(t, null);
                    if (id == null || id <= 0) {
                        Integer keyValue = baseDao.addReturnkey(t);
                        idField.setAccessible(true);
                        idField.set(t, keyValue);
                    } else {
                        baseDao.update(t, getKey());
                    }
                }

            }
        } catch (Exception e) {
            throw new AppException(1, e.getMessage());
        }
    }

    public <T> void saveEntity(T t) throws AppException {
        saveEntity(t, getKey());
    }

    public <T> void addEntity(T t) throws AppException {
        baseDao.add(t);
    }

    public <T> int count(T t) {
        try {
            return baseDao.count(t, getParamNames(t));
        } catch (Exception e) {
            return 0;
        }
    }

    public <T> int getInt(String sql, Object... params) {
        try {
            return baseDao.getInt(sql, params);
        } catch (Exception e) {
            return 0;
        }
    }

    @SuppressWarnings({"unchecked"})
    public <T> T findByEntity(T t) {
        try {
            Object o = baseDao.get(t, getParamNames(t));
            return (T) o;
        } catch (Exception e) {
            return null;
        }
    }

    @SuppressWarnings({"unchecked"})
    public <T> T findBySQL(String sql, Class<T> tClass, Object... params) {
        try {
            Object o = baseDao.get(sql, tClass, params);
            return (T) o;
        } catch (AppException e) {
            return null;
        }
    }

    @SuppressWarnings({"unchecked"})
    public <T> T findById(Object id, Class<T> tClass) {
        try {
            Field idField = getDeclaredField(tClass, getKey());
            if (idField != null) {
                T t = tClass.newInstance();
                idField.setAccessible(true);
                idField.set(t, id);
                return (T) baseDao.get(t, getKey());
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public <T> boolean delete(T t) throws AppException {
        List<String> paramNames = getParamNames(t);
        if (paramNames.isEmpty()) {
            throw new AppException(1, "delete param is null");
        }
        return baseDao.delete(t, getParamNames(t)) > 0;
    }

    public <T> boolean delete(Object id, Class classz) throws Exception {
        return baseDao.delete(id, classz) > 0;
    }

    public <T> boolean update(T t) throws AppException {
        Field id = getDeclaredField(t.getClass(), getKey());
        if (id == null) {
            throw new AppException(ErrorCode.CODE_DB, "id is null");
        }
        return baseDao.update(t, getKey()) > 0;
    }


    /**
     * @param sql    查询的sql语句 ?通配
     * @param params 具体参数
     * @return List
     */
    public List<Map<String, Object>> getRowSet(String sql, Object... params) throws AppException {
        List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
        SqlRowSet sqlRowSet = baseDao.listRowSetSql(sql, params);
        if (sqlRowSet == null) {
            return maps;
        }
        SqlRowSetMetaData rsmd = sqlRowSet.getMetaData();
        int iColumnNumber = rsmd.getColumnCount();
        while (sqlRowSet.next()) {
            Map<String, Object> rowMap = new HashMap<String, Object>();
            for (int i = 1; i <= iColumnNumber; i++) {
                rowMap.put(rsmd.getColumnLabel(i), sqlRowSet.getObject(i));
            }
            maps.add(rowMap);
        }

        return maps;
    }

    public <T> boolean update(T t, String... whereproperties) throws AppException {

        return baseDao.update(t, whereproperties) > 0;
    }

    public boolean update(String sql, Object... whereproperties) throws AppException {
        return baseDao.updateReturnResult(sql, whereproperties);
    }

    public int[] updateBatch(String sql, List<Object[]> paramslist) throws AppException {

        return baseDao.excuteBatch(sql, paramslist);
    }
}
