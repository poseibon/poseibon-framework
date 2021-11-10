package org.poseibon.common.auth;


/**
 * 有权限的业务线ID列表 threadLocal
 *
 * @author qingchuan
 * @date 2020/12/25
 */
public interface AuthInfoThreadLocal {
    /**
     * 有权限的业务线ID列表
     */
    ThreadLocal<AuthInfo> AUTH_INFO = new ThreadLocal<>();
}
