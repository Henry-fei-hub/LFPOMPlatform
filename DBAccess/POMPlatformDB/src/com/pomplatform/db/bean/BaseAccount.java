package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseAccount extends GenericBase implements BaseFactory<BaseAccount>, Comparable<BaseAccount>
{


    public static BaseAccount newInstance(){
        return new BaseAccount();
    }

    @Override
    public BaseAccount make(){
        BaseAccount b = new BaseAccount();
        return b;
    }

    public final static java.lang.String CS_ACCOUNT_ID = "account_id" ;
    public final static java.lang.String CS_ACCOUNT_TYPE = "account_type" ;
    public final static java.lang.String CS_ACCOUNT_CODE = "account_code" ;
    public final static java.lang.String CS_ACCOUNT_NAME = "account_name" ;
    public final static java.lang.String CS_LEAVEL = "leavel" ;
    public final static java.lang.String CS_OWNER_ID = "owner_id" ;
    public final static java.lang.String CS_STATUS = "status" ;
    public final static java.lang.String CS_BALANCE = "balance" ;
    public final static java.lang.String CS_FROZEN_AMOUNT = "frozen_amount" ;
    public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
    public final static java.lang.String CS_CREATE_TIME = "create_time" ;
    public final static java.lang.String CS_DESTORY_TIME = "destory_time" ;
    public final static java.lang.String CS_IS_DEFAULT = "is_default" ;
    public final static java.lang.String CS_CAN_SUM = "can_sum" ;
    public final static java.lang.String CS_DESTORY_EMPLOYEE_ID = "destory_employee_id" ;

    public final static java.lang.String ALL_CAPTIONS = "主键编码,账户类型,账户编号,账户名称, 22级账户,拥有者编码, 3销户,余额,冻结金额,开户人或操作人,开户时间,销户时间,是否是默认账户,该账号数据是否汇总到ownerId,销户操作人";

    public java.lang.Integer getAccountId() {
        return this.__account_id;
    }

    public void setAccountId( java.lang.Integer value ) {
        this.__account_id = value;
    }

    public java.lang.Integer getAccountType() {
        return this.__account_type;
    }

    public void setAccountType( java.lang.Integer value ) {
        this.__account_type = value;
    }

    public java.lang.String getAccountCode() {
        return this.__account_code;
    }

    public void setAccountCode( java.lang.String value ) {
        this.__account_code = value;
    }

    public java.lang.String getAccountName() {
        return this.__account_name;
    }

    public void setAccountName( java.lang.String value ) {
        this.__account_name = value;
    }

    public java.lang.Integer getLeavel() {
        return this.__leavel;
    }

    public void setLeavel( java.lang.Integer value ) {
        this.__leavel = value;
    }

    public java.lang.Integer getOwnerId() {
        return this.__owner_id;
    }

    public void setOwnerId( java.lang.Integer value ) {
        this.__owner_id = value;
    }

    public java.lang.Integer getStatus() {
        return this.__status;
    }

    public void setStatus( java.lang.Integer value ) {
        this.__status = value;
    }

    public java.math.BigDecimal getBalance() {
        return this.__balance;
    }

    public void setBalance( java.math.BigDecimal value ) {
        this.__balance = value;
    }

    public java.math.BigDecimal getFrozenAmount() {
        return this.__frozen_amount;
    }

    public void setFrozenAmount( java.math.BigDecimal value ) {
        this.__frozen_amount = value;
    }

    public java.lang.Integer getOperateEmployeeId() {
        return this.__operate_employee_id;
    }

    public void setOperateEmployeeId( java.lang.Integer value ) {
        this.__operate_employee_id = value;
    }

    public java.util.Date getCreateTime() {
        return this.__create_time;
    }

    public void setCreateTime( java.util.Date value ) {
        this.__create_time = value;
    }

    public java.util.Date getDestoryTime() {
        return this.__destory_time;
    }

    public void setDestoryTime( java.util.Date value ) {
        this.__destory_time = value;
    }

    public java.lang.Boolean getIsDefault() {
        return this.__is_default;
    }

    public void setIsDefault( java.lang.Boolean value ) {
        this.__is_default = value;
    }

    public java.lang.Boolean getCanSum() {
        return this.__can_sum;
    }

    public void setCanSum( java.lang.Boolean value ) {
        this.__can_sum = value;
    }

    public java.lang.Integer getDestoryEmployeeId() {
        return this.__destory_employee_id;
    }

    public void setDestoryEmployeeId( java.lang.Integer value ) {
        this.__destory_employee_id = value;
    }

    public void cloneCopy(BaseAccount __bean){
        __bean.setAccountId(getAccountId());
        __bean.setAccountType(getAccountType());
        __bean.setAccountCode(getAccountCode());
        __bean.setAccountName(getAccountName());
        __bean.setLeavel(getLeavel());
        __bean.setOwnerId(getOwnerId());
        __bean.setStatus(getStatus());
        __bean.setBalance(getBalance());
        __bean.setFrozenAmount(getFrozenAmount());
        __bean.setOperateEmployeeId(getOperateEmployeeId());
        __bean.setCreateTime(getCreateTime());
        __bean.setDestoryTime(getDestoryTime());
        __bean.setIsDefault(getIsDefault());
        __bean.setCanSum(getCanSum());
        __bean.setDestoryEmployeeId(getDestoryEmployeeId());
    }

    public java.lang.String toCSVString() {

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
        StringBuilder sb = new StringBuilder();
        sb.append(getAccountId() == null ? "" : getAccountId());
        sb.append(",");
        sb.append(getAccountType() == null ? "" : getAccountType());
        sb.append(",");
        sb.append(getAccountCode() == null ? "" : getAccountCode());
        sb.append(",");
        sb.append(getAccountName() == null ? "" : getAccountName());
        sb.append(",");
        sb.append(getLeavel() == null ? "" : getLeavel());
        sb.append(",");
        sb.append(getOwnerId() == null ? "" : getOwnerId());
        sb.append(",");
        String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_16", String.valueOf(getStatus()));
        sb.append(strStatus == null ? "" : strStatus);
        sb.append(",");
        sb.append(getBalance() == null ? "" : getBalance());
        sb.append(",");
        sb.append(getFrozenAmount() == null ? "" : getFrozenAmount());
        sb.append(",");
        sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
        sb.append(",");
        sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
        sb.append(",");
        sb.append(getDestoryTime() == null ? "" : sdf.format(getDestoryTime()));
        sb.append(",");
        sb.append(getIsDefault() == null ? "" : getIsDefault());
        sb.append(",");
        sb.append(getCanSum() == null ? "" : getCanSum());
        sb.append(",");
        sb.append(getDestoryEmployeeId() == null ? "" : getDestoryEmployeeId());
        return sb.toString();
    }

    @Override
    public int compareTo(BaseAccount o) {
        return __account_id == null ? -1 : __account_id.compareTo(o.getAccountId());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.__account_id);
        hash = 97 * hash + Objects.hashCode(this.__account_type);
        hash = 97 * hash + Objects.hashCode(this.__account_code);
        hash = 97 * hash + Objects.hashCode(this.__account_name);
        hash = 97 * hash + Objects.hashCode(this.__leavel);
        hash = 97 * hash + Objects.hashCode(this.__owner_id);
        hash = 97 * hash + Objects.hashCode(this.__status);
        hash = 97 * hash + Objects.hashCode(this.__balance);
        hash = 97 * hash + Objects.hashCode(this.__frozen_amount);
        hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
        hash = 97 * hash + Objects.hashCode(this.__create_time);
        hash = 97 * hash + Objects.hashCode(this.__destory_time);
        hash = 97 * hash + Objects.hashCode(this.__is_default);
        hash = 97 * hash + Objects.hashCode(this.__can_sum);
        hash = 97 * hash + Objects.hashCode(this.__destory_employee_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        final BaseAccount o = (BaseAccount)obj;
        if(!Objects.equals(this.__account_id, o.getAccountId())) return false;
        if(!Objects.equals(this.__account_type, o.getAccountType())) return false;
        if(!Objects.equals(this.__account_code, o.getAccountCode())) return false;
        if(!Objects.equals(this.__account_name, o.getAccountName())) return false;
        if(!Objects.equals(this.__leavel, o.getLeavel())) return false;
        if(!Objects.equals(this.__owner_id, o.getOwnerId())) return false;
        if(!Objects.equals(this.__status, o.getStatus())) return false;
        if(!Objects.equals(this.__balance, o.getBalance())) return false;
        if(!Objects.equals(this.__frozen_amount, o.getFrozenAmount())) return false;
        if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
        if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
        if(!Objects.equals(this.__destory_time, o.getDestoryTime())) return false;
        if(!Objects.equals(this.__is_default, o.getIsDefault())) return false;
        if(!Objects.equals(this.__can_sum, o.getCanSum())) return false;
        if(!Objects.equals(this.__destory_employee_id, o.getDestoryEmployeeId())) return false;
        return true;
    }

    @Override
    public java.lang.String toJSONString() {

        StringBuilder sb = new StringBuilder();
        int count = 0;
        if(getAccountId() != null) sb.append(__wrapNumber(count++, "accountId", getAccountId()));
        if(getAccountType() != null) sb.append(__wrapNumber(count++, "accountType", getAccountType()));
        if(getAccountCode() != null) sb.append(__wrapString(count++, "accountCode", getAccountCode()));
        if(getAccountName() != null) sb.append(__wrapString(count++, "accountName", getAccountName()));
        if(getLeavel() != null) sb.append(__wrapNumber(count++, "leavel", getLeavel()));
        if(getOwnerId() != null) sb.append(__wrapNumber(count++, "ownerId", getOwnerId()));
        if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
        if(getBalance() != null) sb.append(__wrapDecimal(count++, "balance", getBalance()));
        if(getFrozenAmount() != null) sb.append(__wrapDecimal(count++, "frozenAmount", getFrozenAmount()));
        if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
        if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
        if(getDestoryTime() != null) sb.append(__wrapDate(count++, "destoryTime", getDestoryTime()));
        if(getIsDefault() != null) sb.append(__wrapBoolean(count++, "isDefault", getIsDefault()));
        if(getCanSum() != null) sb.append(__wrapBoolean(count++, "canSum", getCanSum()));
        if(getDestoryEmployeeId() != null) sb.append(__wrapNumber(count++, "destoryEmployeeId", getDestoryEmployeeId()));
        return sb.toString();
    }

    @Override
    public void setDataFromMap(Map<String, Object> values){
        Object val;
        if((val = values.get("accountId")) != null) setAccountId(__getInt(val));
        if((val = values.get("accountType")) != null) setAccountType(__getInt(val));
        if((val = values.get("accountCode")) != null) setAccountCode(__getString(val));
        if((val = values.get("accountName")) != null) setAccountName(__getString(val));
        if((val = values.get("leavel")) != null) setLeavel(__getInt(val));
        if((val = values.get("ownerId")) != null) setOwnerId(__getInt(val));
        if((val = values.get("status")) != null) setStatus(__getInt(val));
        if((val = values.get("balance")) != null) setBalance(__getDecimal(val));
        if((val = values.get("frozenAmount")) != null) setFrozenAmount(__getDecimal(val));
        if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val));
        if((val = values.get("createTime")) != null) setCreateTime(__getDate(val));
        if((val = values.get("destoryTime")) != null) setDestoryTime(__getDate(val));
        if((val = values.get("isDefault")) != null) setIsDefault(__getBoolean(val));
        if((val = values.get("canSum")) != null) setCanSum(__getBoolean(val));
        if((val = values.get("destoryEmployeeId")) != null) setDestoryEmployeeId(__getInt(val));
    }

    protected java.lang.Integer  __account_id ;
    protected java.lang.Integer  __account_type ;
    protected java.lang.String  __account_code ;
    protected java.lang.String  __account_name ;
    protected java.lang.Integer  __leavel ;
    protected java.lang.Integer  __owner_id ;
    protected java.lang.Integer  __status ;
    protected java.math.BigDecimal  __balance ;
    protected java.math.BigDecimal  __frozen_amount ;
    protected java.lang.Integer  __operate_employee_id ;
    protected java.util.Date  __create_time ;
    protected java.util.Date  __destory_time ;
    protected java.lang.Boolean  __is_default ;
    protected java.lang.Boolean  __can_sum ;
    protected java.lang.Integer  __destory_employee_id ;
}
