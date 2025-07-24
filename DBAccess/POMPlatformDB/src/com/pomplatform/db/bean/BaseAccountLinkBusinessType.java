package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseAccountLinkBusinessType extends GenericBase implements BaseFactory<BaseAccountLinkBusinessType>, Comparable<BaseAccountLinkBusinessType>
{


    public static BaseAccountLinkBusinessType newInstance(){
        return new BaseAccountLinkBusinessType();
    }

    @Override
    public BaseAccountLinkBusinessType make(){
        BaseAccountLinkBusinessType b = new BaseAccountLinkBusinessType();
        return b;
    }

    public final static java.lang.String CS_ACCOUNT_LINK_BUSINESS_TYPE_ID = "account_link_business_type_id" ;
    public final static java.lang.String CS_ACCOUNT_TYPE = "account_type" ;
    public final static java.lang.String CS_BUSINESS_TYPE_ID = "business_type_id" ;
    public final static java.lang.String CS_IS_DEBIT = "is_debit" ;

    public final static java.lang.String ALL_CAPTIONS = "主键编码,账户类型,业务类型,是否是借方";

    public java.lang.Integer getAccountLinkBusinessTypeId() {
        return this.__account_link_business_type_id;
    }

    public void setAccountLinkBusinessTypeId( java.lang.Integer value ) {
        this.__account_link_business_type_id = value;
    }

    public java.lang.Integer getAccountType() {
        return this.__account_type;
    }

    public void setAccountType( java.lang.Integer value ) {
        this.__account_type = value;
    }

    public java.lang.Integer getBusinessTypeId() {
        return this.__business_type_id;
    }

    public void setBusinessTypeId( java.lang.Integer value ) {
        this.__business_type_id = value;
    }

    public java.lang.Boolean getIsDebit() {
        return this.__is_debit;
    }

    public void setIsDebit( java.lang.Boolean value ) {
        this.__is_debit = value;
    }

    public void cloneCopy(BaseAccountLinkBusinessType __bean){
        __bean.setAccountLinkBusinessTypeId(getAccountLinkBusinessTypeId());
        __bean.setAccountType(getAccountType());
        __bean.setBusinessTypeId(getBusinessTypeId());
        __bean.setIsDebit(getIsDebit());
    }

    public java.lang.String toCSVString() {

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
        StringBuilder sb = new StringBuilder();
        sb.append(getAccountLinkBusinessTypeId() == null ? "" : getAccountLinkBusinessTypeId());
        sb.append(",");
        sb.append(getAccountType() == null ? "" : getAccountType());
        sb.append(",");
        sb.append(getBusinessTypeId() == null ? "" : getBusinessTypeId());
        sb.append(",");
        sb.append(getIsDebit() == null ? "" : getIsDebit());
        return sb.toString();
    }

    @Override
    public int compareTo(BaseAccountLinkBusinessType o) {
        return __account_link_business_type_id == null ? -1 : __account_link_business_type_id.compareTo(o.getAccountLinkBusinessTypeId());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.__account_link_business_type_id);
        hash = 97 * hash + Objects.hashCode(this.__account_type);
        hash = 97 * hash + Objects.hashCode(this.__business_type_id);
        hash = 97 * hash + Objects.hashCode(this.__is_debit);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        final BaseAccountLinkBusinessType o = (BaseAccountLinkBusinessType)obj;
        if(!Objects.equals(this.__account_link_business_type_id, o.getAccountLinkBusinessTypeId())) return false;
        if(!Objects.equals(this.__account_type, o.getAccountType())) return false;
        if(!Objects.equals(this.__business_type_id, o.getBusinessTypeId())) return false;
        if(!Objects.equals(this.__is_debit, o.getIsDebit())) return false;
        return true;
    }

    @Override
    public java.lang.String toJSONString() {

        StringBuilder sb = new StringBuilder();
        int count = 0;
        if(getAccountLinkBusinessTypeId() != null) sb.append(__wrapNumber(count++, "accountLinkBusinessTypeId", getAccountLinkBusinessTypeId()));
        if(getAccountType() != null) sb.append(__wrapNumber(count++, "accountType", getAccountType()));
        if(getBusinessTypeId() != null) sb.append(__wrapNumber(count++, "businessTypeId", getBusinessTypeId()));
        if(getIsDebit() != null) sb.append(__wrapBoolean(count++, "isDebit", getIsDebit()));
        return sb.toString();
    }

    @Override
    public void setDataFromMap(Map<String, Object> values){
        Object val;
        if((val = values.get("accountLinkBusinessTypeId")) != null) setAccountLinkBusinessTypeId(__getInt(val));
        if((val = values.get("accountType")) != null) setAccountType(__getInt(val));
        if((val = values.get("businessTypeId")) != null) setBusinessTypeId(__getInt(val));
        if((val = values.get("isDebit")) != null) setIsDebit(__getBoolean(val));
    }

    protected java.lang.Integer  __account_link_business_type_id ;
    protected java.lang.Integer  __account_type ;
    protected java.lang.Integer  __business_type_id ;
    protected java.lang.Boolean  __is_debit ;
}
