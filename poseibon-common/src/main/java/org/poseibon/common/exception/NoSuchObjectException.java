package org.poseibon.common.exception;


import org.poseibon.common.enums.ResponseCodeEnum;
import org.poseibon.common.utils.MessageFormatter;

/**
 * exception for business
 *
 * @author qingchuan
 * @date 2020/12/9
 */
public class NoSuchObjectException extends BaseException {
    
    /**
     * 构造方法
     *
     * @param msg  错误信息
     * @param args 参数
     */
    public NoSuchObjectException(String msg, Object... args) {
        super(ResponseCodeEnum.BIZ_EXCEPTION.getValue(), MessageFormatter.arrayFormat(msg, args).getMessage());
    }
}
