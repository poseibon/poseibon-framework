package org.poseibon.common.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Collection 工具类
 *
 * @author qingchuan
 * @date 2020/12/11
 */
public interface Args2 {
    /**
     * 解析参数
     *
     * @param argNames  参数对象
     * @param argValues 值对象
     * @return 参数集合
     */
    default Map<String, Object> parseArgs(String[] argNames, Object[] argValues) throws IllegalAccessException {

        Map<String, Object> argMap = new HashMap<>();
        if (argNames != null && argNames.length > 0) {
            for (int i = 0; i < argNames.length; i++) {
                String argName = argNames[i];
                Object argValue = argValues[i];
                argMap.put(argName, argValue);
                Map<String, Object> propertyMap = parseObj(argValue);
                if (Maps2.isNotEmpty(propertyMap)) {
                    argMap.putAll(propertyMap);
                }
            }
        }
        return argMap;
    }

    /**
     * 解析对象属性值
     *
     * @param obj 对象
     * @return 属性名称和值键值对map
     * @throws IllegalAccessException
     */
    default Map<String, Object> parseObj(Object obj) throws IllegalAccessException {
        Map<String, Object> retMap = new HashMap<>();
        if (obj == null) {
            return retMap;
        }
        Class clazz = obj.getClass();
        while (clazz != null) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(obj);
                if (value != null) {
                    retMap.put(field.getName(), value);
                }
            }
            clazz = clazz.getSuperclass();
        }
        return retMap;
    }
}
