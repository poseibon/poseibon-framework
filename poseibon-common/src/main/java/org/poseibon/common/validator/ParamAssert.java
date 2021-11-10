package org.poseibon.common.validator;

/**
 * app 断言检测类
 *
 * @author qingchuan
 * @date 2020/5/13
 */
public enum ParamAssert implements ParamChecker {
    // 参数错误
    PARAM_EMPTY_ERROR("参数为空，请检查参数");

    ParamAssert(String msg) {
        this.msg = msg;
    }

    /**
     * 错误消息
     */
    private String msg;

    @Override
    public String getMsg() {
        return null;
    }
}