package org.poseibon.common.validator;


import org.poseibon.common.exception.BizException;
import org.poseibon.common.utils.MessageFormatter;


/***
 * 领域校验断言器
 *
 * @author qingchuan
 * @date 2020/5/13
 */
public interface BizChecker extends IChecker {

    @Override
    default BizException newException(Object... args) {
        String msg = MessageFormatter.arrayFormat(this.getMsg(), args).getMessage();
        return new BizException(this.getCode(), msg);
    }
}