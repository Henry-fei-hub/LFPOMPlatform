package pomplatform.sreceiveunitmanagemmror.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSreceiveunitmanagemmror extends GenericCondition{

	public ConditionSreceiveunitmanagemmror(){
		setParameterCount(18);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.lang.String getReceiveUnit() {
		return this.__receive_unit == null ? null : (this.__receive_unit.indexOf("%") >= 0 ? this.__receive_unit : "%"+this.__receive_unit+"%");
	}

	public void setReceiveUnit( java.lang.String value ) {
		this.__receive_unit = value;
	}

	public java.lang.String getBankAccount() {
		return this.__bank_account == null ? null : (this.__bank_account.indexOf("%") >= 0 ? this.__bank_account : "%"+this.__bank_account+"%");
	}

	public void setBankAccount( java.lang.String value ) {
		this.__bank_account = value;
	}

	public java.lang.String getBankName() {
		return this.__bank_name == null ? null : (this.__bank_name.indexOf("%") >= 0 ? this.__bank_name : "%"+this.__bank_name+"%");
	}

	public void setBankName( java.lang.String value ) {
		this.__bank_name = value;
	}

	public java.lang.String getReceiveUnitAddress() {
		return this.__receive_unit_address == null ? null : (this.__receive_unit_address.indexOf("%") >= 0 ? this.__receive_unit_address : "%"+this.__receive_unit_address+"%");
	}

	public void setReceiveUnitAddress( java.lang.String value ) {
		this.__receive_unit_address = value;
	}

	public java.lang.String getBankAddress() {
		return this.__bank_address == null ? null : (this.__bank_address.indexOf("%") >= 0 ? this.__bank_address : "%"+this.__bank_address+"%");
	}

	public void setBankAddress( java.lang.String value ) {
		this.__bank_address = value;
	}

	public java.lang.String getReceiveUnitPhone() {
		return this.__receive_unit_phone == null ? null : (this.__receive_unit_phone.indexOf("%") >= 0 ? this.__receive_unit_phone : "%"+this.__receive_unit_phone+"%");
	}

	public void setReceiveUnitPhone( java.lang.String value ) {
		this.__receive_unit_phone = value;
	}

	public java.lang.String getSwiftCode() {
		return this.__swift_code == null ? null : (this.__swift_code.indexOf("%") >= 0 ? this.__swift_code : "%"+this.__swift_code+"%");
	}

	public void setSwiftCode( java.lang.String value ) {
		this.__swift_code = value;
	}

	public java.util.Date getMinOperateTime() {
		return this.__min_operate_time;
	}

	public void setMinOperateTime( java.util.Date value ) {
		this.__min_operate_time = value;
	}

	public java.util.Date getMaxOperateTime() {
		return this.__max_operate_time;
	}

	public void setMaxOperateTime( java.util.Date value ) {
		this.__max_operate_time = value;
	}

	public java.lang.Integer getReceiveUnitManageId() {
		return this.__receive_unit_manage_id;
	}

	public void setReceiveUnitManageId( java.lang.Integer value ) {
		this.__receive_unit_manage_id = value;
	}

	public java.lang.Integer getOrigin() {
		return this.__origin;
	}

	public void setOrigin( java.lang.Integer value ) {
		this.__origin = value;
	}

	public java.lang.String getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.String value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getProvince() {
		return this.__province;
	}

	public void setProvince( java.lang.Integer value ) {
		this.__province = value;
	}

	public java.lang.Integer getCity() {
		return this.__city;
	}

	public void setCity( java.lang.Integer value ) {
		this.__city = value;
	}

	public java.lang.Integer getBankId() {
		return this.__bank_id;
	}

	public void setBankId( java.lang.Integer value ) {
		this.__bank_id = value;
	}

	public java.lang.Integer getAccountType() {
		return this.__account_type;
	}

	public void setAccountType( java.lang.Integer value ) {
		this.__account_type = value;
	}

	public java.lang.Integer getVoucherType() {
		return __voucher_type;
	}

	public void setVoucherType(java.lang.Integer value) {
		this.__voucher_type = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(1, "operateEmployeeId", getOperateEmployeeId()));
		if(getReceiveUnit() != null) sb.append(__wrapString(1, "receiveUnit", getReceiveUnit()));
		if(getBankAccount() != null) sb.append(__wrapString(1, "bankAccount", getBankAccount()));
		if(getBankName() != null) sb.append(__wrapString(1, "bankName", getBankName()));
		if(getReceiveUnitAddress() != null) sb.append(__wrapString(1, "receiveUnitAddress", getReceiveUnitAddress()));
		if(getBankAddress() != null) sb.append(__wrapString(1, "bankAddress", getBankAddress()));
		if(getReceiveUnitPhone() != null) sb.append(__wrapString(1, "receiveUnitPhone", getReceiveUnitPhone()));
		if(getSwiftCode() != null) sb.append(__wrapString(1, "swiftCode", getSwiftCode()));
		if(getMinOperateTime() != null) sb.append(__wrapDate(1, "minOperateTime", getMinOperateTime()));
		if(getMaxOperateTime() != null) sb.append(__wrapDate(1, "maxOperateTime", getMaxOperateTime()));
		if(getReceiveUnitManageId() != null) sb.append(__wrapNumber(1, "receiveUnitManageId", getReceiveUnitManageId()));
		if(getOrigin() != null) sb.append(__wrapNumber(1, "origin", getOrigin()));
		if(getCompanyId() != null) sb.append(__wrapString(1, "companyId", getCompanyId()));
		if(getProvince() != null) sb.append(__wrapNumber(1, "province", getProvince()));
		if(getCity() != null) sb.append(__wrapNumber(1, "city", getCity()));
		if(getBankId() != null) sb.append(__wrapNumber(1, "bankId", getBankId()));
		if(getAccountType() != null) sb.append(__wrapNumber(1, "accountType", getAccountType()));
		if(getVoucherType() != null) sb.append(__wrapNumber(1, "voucherType", getVoucherType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("receiveUnit")) != null) setReceiveUnit(__getString(val));
		if((val = values.get("bankAccount")) != null) setBankAccount(__getString(val));
		if((val = values.get("bankName")) != null) setBankName(__getString(val));
		if((val = values.get("receiveUnitAddress")) != null) setReceiveUnitAddress(__getString(val));
		if((val = values.get("bankAddress")) != null) setBankAddress(__getString(val));
		if((val = values.get("receiveUnitPhone")) != null) setReceiveUnitPhone(__getString(val));
		if((val = values.get("swiftCode")) != null) setSwiftCode(__getString(val));
		if((val = values.get("minOperateTime")) != null) setMinOperateTime(__getDate(val)); 
		if((val = values.get("maxOperateTime")) != null) setMaxOperateTime(__getDate(val)); 
		if((val = values.get("receiveUnitManageId")) != null) setReceiveUnitManageId(__getInt(val)); 
		if((val = values.get("origin")) != null) setOrigin(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getString(val));
		if((val = values.get("province")) != null) setProvince(__getInt(val)); 
		if((val = values.get("city")) != null) setCity(__getInt(val)); 
		if((val = values.get("bankId")) != null) setBankId(__getInt(val)); 
		if((val = values.get("accountType")) != null) setAccountType(__getInt(val)); 
		if((val = values.get("voucherType")) != null) setVoucherType(__getInt(val)); 
	}

	private java.lang.Integer __operate_employee_id = null;
	private java.lang.String __receive_unit = null;
	private java.lang.String __bank_account = null;
	private java.lang.String __bank_name = null;
	private java.lang.String __receive_unit_address = null;
	private java.lang.String __bank_address = null;
	private java.lang.String __receive_unit_phone = null;
	private java.lang.String __swift_code = null;
	private java.util.Date __min_operate_time = null;
	private java.util.Date __max_operate_time = null;
	private java.lang.Integer __receive_unit_manage_id = null;
	private java.lang.Integer __origin = null;
	private java.lang.String __company_id = null;
	private java.lang.Integer __province = null;
	private java.lang.Integer __city = null;
	private java.lang.Integer __bank_id = null;
	private java.lang.Integer __account_type = null;
	private java.lang.Integer __voucher_type = null;
}

