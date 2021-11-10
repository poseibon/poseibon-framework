package org.poseibon.common.utils;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.poseibon.common.utils.Strings2.EMPTY_STRING_ARRAY;

/**
 * Collection 工具类
 *
 * @author qingchuan
 * @date 2020/12/11
 */
public class Collections2 {

    /**
     * 把集合中的对象 转换成Map
     *
     * @param <T>  需要解析的数据类型
     * @param <K>  key的数据类型
     * @param list 集合列表
     * @param key  获取key方法
     * @return map集合
     */
    public static <T, K> Map<K, T> toMap(Collection<T> list,
                                         Function<T, K> key) {
        if (isEmpty(list)) {
            return new HashMap<>();
        }
        Map<K, T> map = new HashMap<>();
        for (T t : list) {
            map.put(key.apply(t), t);
        }
        return map;
    }

    /**
     * Null-safe check if the specified collection is empty.
     * <p>
     * Null returns true.
     * </p>
     *
     * @param coll  the collection to check, may be null
     * @return true if empty or null
     * @since 3.2
     */
    public static boolean isEmpty(final Collection<?> coll) {
        return coll == null || coll.isEmpty();
    }

    /**
     * 把集合中的对象 转换成Map
     *
     * @param <T>   需要解析的数据类型
     * @param <K>   key的数据类型
     * @param <V>   value的数据类型
     * @param list  集合列表
     * @param key   获取key方法
     * @param value 获取值值
     * @return map集合
     */
    public static <T, K, V> Map<K, V> toMap(Collection<T> list,
                                            Function<T, K> key, Function<T, V> value) {
        if (isEmpty(list)) {
            return new HashMap<>();
        }
        Map<K, V> map = new HashMap<K, V>();
        for (T t : list) {
            map.put(key.apply(t), value.apply(t));
        }
        return map;
    }

    /**
     * 把查询出来的List<Map>转换成key-value形势的map
     *
     * @param <K>         key的数据类型
     * @param <V>         value的数据类型
     * @param dataList    查询出来的原始数据结构，每个map代表一行数据
     * @param keyColumn   代表key的数据column
     * @param valueColumn 代表value的数据column
     * @param keyClass    key的class类型
     * @param valueClass  value的class类型
     * @return 转换成key-value形势的map
     */
    @SuppressWarnings("unchecked")
    public static <K, V> Map<K, V> toMap(List<Map<String, Object>> dataList,
                                         String keyColumn, String valueColumn, Class<K> keyClass,
                                         Class<V> valueClass) {
        if (isEmpty(dataList)) {
            return new HashMap<>();
        }
        Map<K, V> resultMap = new HashMap<K, V>();
        if (dataList == null || dataList.size() == 0) {
            return resultMap;
        }
        for (Map<String, Object> item : dataList) {
            Object keyObject = item.get(keyColumn);
            Object valueObject = item.get(valueColumn);
            if (keyObject != null && valueObject != null) {
                resultMap.put((K) keyObject, (V) valueObject);
            }
        }
        return resultMap;
    }

    /**
     * 把集合中的对象 转换成Map
     *
     * @param <T>  需要解析的数据类型
     * @param <K>  key的数据类型
     * @param list 集合列表
     * @param key  获取key方法
     * @return map集合
     */
    public static <T, K> Map<K, T> toLinkedMap(Collection<T> list,
                                               Function<T, K> key) {
        if (isEmpty(list)) {
            return new LinkedHashMap<>();
        }
        Map<K, T> map = new LinkedHashMap<>();
        for (T t : list) {
            map.put(key.apply(t), t);
        }
        return map;
    }

    /**
     * 把集合中的对象 转换成Map
     *
     * @param <T>   需要解析的数据类型
     * @param <K>   key的数据类型
     * @param <V>   value的数据类型
     * @param list  集合列表
     * @param key   获取key方法
     * @param value 获取值值
     * @return map集合
     */
    public static <T, K, V> Map<K, V> toLinkedMap(Collection<T> list,
                                                  Function<T, K> key, Function<T, V> value) {
        if (isEmpty(list)) {
            return new LinkedHashMap<>();
        }
        Map<K, V> map = new LinkedHashMap<>();
        for (T t : list) {
            map.put(key.apply(t), value.apply(t));
        }
        return map;
    }

    /**
     * 把集合中的对象 转换成Map
     *
     * @param <T>   需要解析的数据类型
     * @param <K>   key的数据类型
     * @param <V>   value的数据类型
     * @param list  集合列表
     * @param key   获取key方法
     * @param value 获取值值
     * @return map集合
     */
    public static <T, K, V> Map<K, List<V>> toMapForListValue(
            Collection<T> list, Function<T, K> key, Function<T, V> value) {
        if (isEmpty(list)) {
            return new HashMap<>();
        }
        Map<K, List<V>> map = new HashMap<K, List<V>>();
        for (T input : list) {
            if (map.containsKey(key.apply(input))) {
                map.get(key.apply(input)).add(value.apply(input));
                continue;
            }
            List<V> values = new ArrayList<V>();
            values.add(value.apply(input));
            map.put(key.apply(input), values);
        }
        return map;
    }


    /**
     * 把集合中的对象 转换成Map
     *
     * @param <F>  需要解析的数据类型
     * @param <T>  结果类型
     * @param list 集合列表
     * @return map集合
     */
    public static <F, T> List<T> toList(List<F> list, Function<F, T> function) {
        if (isEmpty(list)) {
            return new ArrayList();
        }
        return list.stream().map(input -> function.apply(input)).collect(Collectors.toList());
    }

    /**
     * 把集合中的对象 转换成Map
     *
     * @param <F>  需要解析的数据类型
     * @param <T>  结果类型
     * @param list 集合列表
     * @return map集合
     */
    public static <F, T> Set<T> toSet(List<F> list, Function<F, T> function) {
        if (isEmpty(list)) {
            return new HashSet<>();
        }
        return list.stream().map(input -> function.apply(input)).collect(Collectors.toSet());
    }


    /**
     * 把集合中的对象 转换成Map
     *
     * @param <T>  需要解析的数据类型
     * @param <K>  key的数据类型
     * @param <K1> value的数据类型
     * @param list 集合列表
     * @param key  获取key方法
     * @param key1 第二个key
     * @return map集合
     */
    public static <T, K, K1> Map<K, Map<K1, T>> toValueMap(
            Collection<T> list, Function<T, K> key, Function<T, K1> key1) {
        if (isEmpty(list)) {
            return new HashMap<>();
        }
        Map<K, Map<K1, T>> map = new HashMap<K, Map<K1, T>>();
        for (T input : list) {
            if (map.containsKey(key.apply(input))) {
                map.get(key.apply(input)).put(key1.apply(input), input);
                continue;
            }
            Map<K1, T> values = new HashMap<>();
            values.put(key1.apply(input), input);
            map.put(key.apply(input), values);
        }
        return map;
    }

    /**
     * 列表收集
     *
     * @param collection 集合
     * @return 列表
     */
    public static <F, T> List<T> collect(Collection<F> collection, Function<F, Collection<T>> function) {
        if (isEmpty(collection)) {
            return new ArrayList();
        }
        List<T> retList = new ArrayList();
        Iterator<F> iterator = collection.iterator();
        while (iterator.hasNext()) {
            retList.addAll(function.apply(iterator.next()));
        }
        return retList;
    }

    /**
     * Copy the given {@link Collection} into a {@code String} array.
     * <p>The {@code Collection} must contain {@code String} elements only.
     * @param collection the {@code Collection} to copy
     * (potentially {@code null} or empty)
     * @return the resulting {@code String} array
     */
    public static String[] toStringArray(Collection<String> collection) {
        return (!isEmpty(collection) ? collection.toArray(EMPTY_STRING_ARRAY) : EMPTY_STRING_ARRAY);
    }

    /**
     * 转化空列表
     *
     * @param list 列表
     * @param <T>  类型
     * @return 结果
     */
    public static <T> Collection<T> trimNull(List<T> list) {
        return isEmpty(list) ? new ArrayList() : list;
    }

    /**
     * 转化空列表
     *
     * @param set 集合
     * @param <T> 类型
     * @return 集合
     */
    public static <T> Collection<T> trimNull(Set<T> set) {
        return isEmpty(set) ? new HashSet<>() : set;
    }


}
