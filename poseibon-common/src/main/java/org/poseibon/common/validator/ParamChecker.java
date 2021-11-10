package org.poseibon.common.validator;

import org.poseibon.common.exception.ValidationException;
import org.poseibon.common.utils.MessageFormatter;


/***
 * 校验断言器
 *
 * @author qingchuan
 * @date 2020/5/13
 */
public interface ParamChecker extends IChecker {

    @Override
    default ValidationException newException(Object... args) {
        String msg = MessageFormatter.arrayFormat(this.getMsg(), args).getMessage();
        return new ValidationException(msg);
    }
}