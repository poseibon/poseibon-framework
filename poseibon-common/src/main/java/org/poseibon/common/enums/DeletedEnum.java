package org.poseibon.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 删除类型枚举
 *
 * @author qingchuan
 * @date 2020/12/11
 */
public enum DeletedEnum {

    NO(0, "未删除"), YES(1, "已删除");

    DeletedEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    /**
     * 类型
     */
    private Integer value;
    /**
     * 描述
     */
    private String text;
    /**
     * 枚举map
     */
    public static final Map<Integer, DeletedEnum> VALUE_TEXT = new HashMap<>();

    /**
     * 静态初始化
     */
    static {
        for (DeletedEnum item : values()) {
            VALUE_TEXT.put(item.getValue(), item);
        }
    }

    /**
     * 根据值获取对应的枚举信息
     *
     * @param value 枚举值
     * @return 枚举信息
     * @throws IllegalArgumentException 枚举值不存在抛出异常
     */
    public static DeletedEnum of(Integer value) {
        if (!VALUE_TEXT.containsKey(value)) {
            throw new IllegalArgumentException(String
                    .format("can't parse enum value %s, because it doesn't existed", value));
        }
        return VALUE_TEXT.get(value);
    }

    /**
     * 枚举值是否存在
     *
     * @param value 枚举值
     * @return true 存在 ，false 不存在
     */
    public static boolean hasEnum(Integer value) {
        return VALUE_TEXT.containsKey(value);
    }
}
