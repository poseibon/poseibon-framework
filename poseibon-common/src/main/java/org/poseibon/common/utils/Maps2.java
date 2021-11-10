package org.poseibon.common.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Collection 工具类
 *
 * @author qingchuan
 * @date 2020/12/11
 */
public class Maps2 {

    /**
     * Null-safe check if the specified map is empty.
     * <p>
     * Null returns true.
     *
     * @param map  the map to check, may be null
     * @return true if empty or null
     */
    public static boolean isEmpty(final Map<?,?> map) {
        return map == null || map.isEmpty();
    }

    /**
     * 根据KEY值升序排序
     *
     * @param <K> key的数据类型
     * @param <V> value的数据类型
     * @return map集合
     */
    public static <K extends Comparable<? super K>, V> Map<K, V> ascByKey(Map<K, V> map) {
        if (isEmpty(map)) {
            return new LinkedHashMap<>();
        }
        return map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey()).collect(
                Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));
    }

    /**
     * 根据KEY值降序排序
     *
     * @param <K> key的数据类型
     * @param <V> value的数据类型
     * @return map集合
     */
    public static <K extends Comparable<? super K>, V> Map<K, V> descByKey(Map<K, V> map) {
        if (isEmpty(map)) {
            return new LinkedHashMap<>();
        }
        return map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey().reversed()).collect(
                Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));
    }

    /**
     * 根据VALUE值降序排序
     *
     * @param <K> key的数据类型
     * @param <V> value的数据类型
     * @return map集合
     */
    public static <K, V extends Comparable<? super V>> Map<K, V> descByValue(Map<K, V> map) {
        if (isEmpty(map)) {
            return new LinkedHashMap<>();
        }
        return map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByValue().reversed()).collect(
                Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));
    }

    /**
     * 根据VALUE值升序排序
     *
     * @param <K> key的数据类型
     * @param <V> value的数据类型
     * @return map集合
     */
    public static <K, V extends Comparable<? super V>> Map<K, V> ascByValue(Map<K, V> map) {
        if (isEmpty(map)) {
            return new LinkedHashMap<>();
        }
        return map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(
                Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}
