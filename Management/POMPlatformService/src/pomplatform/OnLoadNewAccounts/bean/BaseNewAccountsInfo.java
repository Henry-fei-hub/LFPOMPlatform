package pomplatform.OnLoadNewAccounts.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseNewAccountsInfo extends GenericBase implements BaseFactory<BaseNewAccountsInfo>, Comparable<BaseNewAccountsInfo> 
{


	public static BaseNewAccountsInfo newInstance(){
		return new BaseNewAccountsInfo();
	}

	@Override
	public BaseNewAccountsInfo make(){
		BaseNewAccountsInfo b = new BaseNewAccountsInfo();
		return b;
	}

	public final static java.lang.String CS_ACCOUNT_ID = "account_id" ;
	public final static java.lang.String CS_ACCOUNT_TYPE = "account_type" ;
	public final static java.lang.String CS_ACCOUNT_CODE = "account_code" ;
	public final static java.lang.String CS_ACCOUNT_NAME = "account_name" ;
	public final static java.lang.String CS_OWNER_ID = "owner_id" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_BALANCE = "balance" ;
	public final static java.lang.String CS_FREEZING_BALANCE = "freezing_balance" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_ORDER_ID = "order_id" ;

	public final static java.lang.String ALL_CAPTIONS = "账户表主键,账户类型(1个人 ,2项目组，3部门，4公司，5供应商),账户编号（唯一）,账户名称,拥有者编码,状态（1活动，2冻结，3关户）,,,operator,开户人活着操作人,订单编码";

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

	public java.lang.Long getBalance() {
		return this.__balance;
	}

	public void setBalance( java.lang.Long value ) {
		this.__balance = value;
	}

	public java.lang.Long getFreezingBalance() {
		return this.__freezing_balance;
	}

	public void setFreezingBalance( java.lang.Long value ) {
		this.__freezing_balance = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.String getOrderId() {
		return this.__order_id;
	}

	public void setOrderId( java.lang.String value ) {
		this.__order_id = value;
	}

	public void cloneCopy(BaseNewAccountsInfo __bean){
		__bean.setAccountId(getAccountId());
		__bean.setAccountType(getAccountType());
		__bean.setAccountCode(getAccountCode());
		__bean.setAccountName(getAccountName());
		__bean.setOwnerId(getOwnerId());
		__bean.setStatus(getStatus());
		__bean.setBalance(getBalance());
		__bean.setFreezingBalance(getFreezingBalance());
		__bean.setOperator(getOperator());
		__bean.setCreateTime(getCreateTime());
		__bean.setOrderId(getOrderId());
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
		sb.append(getOwnerId() == null ? "" : getOwnerId());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getBalance() == null ? "" : getBalance());
		sb.append(",");
		sb.append(getFreezingBalance() == null ? "" : getFreezingBalance());
		sb.append(",");
		sb.append(getOperator() == null ? "" : getOperator());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getOrderId() == null ? "" : getOrderId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseNewAccountsInfo o) {
		return __account_id == null ? -1 : __account_id.compareTo(o.getAccountId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__account_id);
		hash = 97 * hash + Objects.hashCode(this.__account_type);
		hash = 97 * hash + Objects.hashCode(this.__account_code);
		hash = 97 * hash + Objects.hashCode(this.__account_name);
		hash = 97 * hash + Objects.hashCode(this.__owner_id);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__balance);
		hash = 97 * hash + Objects.hashCode(this.__freezing_balance);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__order_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseNewAccountsInfo o = (BaseNewAccountsInfo)obj;
		if(!Objects.equals(this.__account_id, o.getAccountId())) return false;
		if(!Objects.equals(this.__account_type, o.getAccountType())) return false;
		if(!Objects.equals(this.__account_code, o.getAccountCode())) return false;
		if(!Objects.equals(this.__account_name, o.getAccountName())) return false;
		if(!Objects.equals(this.__owner_id, o.getOwnerId())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__balance, o.getBalance())) return false;
		if(!Objects.equals(this.__freezing_balance, o.getFreezingBalance())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__order_id, o.getOrderId())) return false;
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
		if(getOwnerId() != null) sb.append(__wrapNumber(count++, "ownerId", getOwnerId()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getBalance() != null) sb.append(__wrapNumber(count++, "balance", getBalance()));
		if(getFreezingBalance() != null) sb.append(__wrapNumber(count++, "freezingBalance", getFreezingBalance()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getOrderId() != null) sb.append(__wrapString(count++, "orderId", getOrderId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("accountId")) != null) setAccountId(__getInt(val)); 
		if((val = values.get("accountType")) != null) setAccountType(__getInt(val)); 
		if((val = values.get("accountCode")) != null) setAccountCode(__getString(val));
		if((val = values.get("accountName")) != null) setAccountName(__getString(val));
		if((val = values.get("ownerId")) != null) setOwnerId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("balance")) != null) setBalance(__getLong(val)); 
		if((val = values.get("freezingBalance")) != null) setFreezingBalance(__getLong(val)); 
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("orderId")) != null) setOrderId(__getString(val));
	}

	protected java.lang.Integer  __account_id ;
	protected java.lang.Integer  __account_type ;
	protected java.lang.String  __account_code ;
	protected java.lang.String  __account_name ;
	protected java.lang.Integer  __owner_id ;
	protected java.lang.Integer  __status ;
	protected java.lang.Long  __balance ;
	protected java.lang.Long  __freezing_balance ;
	protected java.lang.Integer  __operator ;
	protected java.util.Date  __create_time ;
	protected java.lang.String  __order_id ;
}
