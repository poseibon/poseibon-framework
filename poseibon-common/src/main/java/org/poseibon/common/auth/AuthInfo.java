package org.poseibon.common.auth;


import org.poseibon.common.enums.DataAccessEnum;

import java.util.List;

/**
 * 授权信息
 *
 * @author qingchuan
 * @date 2020/12/24
 */
public class AuthInfo {
    /**
     * 授权类型
     */
    private DataAccessEnum dataAccess;
    /**
     * 字段名
     */
    private String fieldName;
    /**
     * 数据库字段名
     */
    private String dbFieldName;
    /**
     * 授权列表数据
     */
    private List<String> authList;

    public static AuthInfo of() {
        AuthInfo authInfo = new AuthInfo();
        return authInfo;
    }

    public DataAccessEnum getDataAccess() {
        return dataAccess;
    }

    public AuthInfo dataAccess(DataAccessEnum dataAccess) {
        this.dataAccess = dataAccess;
        return this;
    }

    public String getFieldName() {
        return fieldName;
    }

    public AuthInfo fieldName(String fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    public String getDbFieldName() {
        return dbFieldName;
    }

    public AuthInfo dbFieldName(String dbFieldName) {
        this.dbFieldName = dbFieldName;
        return this;
    }

    public List<String> getAuthList() {
        return authList;
    }

    public AuthInfo authList(List<String> authList) {
        this.authList = authList;
        return this;
    }
}
