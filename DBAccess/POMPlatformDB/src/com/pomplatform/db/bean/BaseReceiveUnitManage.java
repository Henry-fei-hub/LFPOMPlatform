package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseReceiveUnitManage extends GenericBase implements BaseFactory<BaseReceiveUnitManage>, Comparable<BaseReceiveUnitManage> 
{


	public static BaseReceiveUnitManage newInstance(){
		return new BaseReceiveUnitManage();
	}

	@Override
	public BaseReceiveUnitManage make(){
		BaseReceiveUnitManage b = new BaseReceiveUnitManage();
		return b;
	}

	public final static java.lang.String CS_RECEIVE_UNIT_MANAGE_ID = "receive_unit_manage_id" ;
	public final static java.lang.String CS_RECEIVE_UNIT = "receive_unit" ;
	public final static java.lang.String CS_BANK_ACCOUNT = "bank_account" ;
	public final static java.lang.String CS_BANK_NAME = "bank_name" ;
	public final static java.lang.String CS_RECEIVE_UNIT_ADDRESS = "receive_unit_address" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_ORIGIN = "origin" ;
	public final static java.lang.String CS_RECEIVE_UNIT_TYPE = "receive_unit_type" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_SALARY_TYPE = "salary_type" ;
	public final static java.lang.String CS_PROVINCE = "province" ;
	public final static java.lang.String CS_CITY = "city" ;
	public final static java.lang.String CS_BANK_ADDRESS = "bank_address" ;
	public final static java.lang.String CS_RECEIVE_UNIT_PHONE = "receive_unit_phone" ;
	public final static java.lang.String CS_SWIFT_CODE = "swift_code" ;
	public final static java.lang.String CS_COUNTRY_ID = "country_id" ;
	public final static java.lang.String CS_COUNTRY_CODE = "country_code" ;
	public final static java.lang.String CS_PASSPORT = "passport" ;
	public final static java.lang.String CS_BANK_ID = "bank_id" ;
	public final static java.lang.String CS_ACCOUNT_TYPE = "account_type" ;
	public final static java.lang.String CS_IS_USE = "is_use" ;
	public final static java.lang.String CS_SUPPLIER_ID = "supplier_id" ;
	public final static java.lang.String CS_VOUCHER_TYPE = "voucher_type" ;
	public final static java.lang.String CS_FUNDRAISING_PROJECT_TYPE_ID = "fundraising_project_type_id" ;
	public final static java.lang.String CS_SUPPLIER_TYPE = "supplier_type" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,收款单位,银行账号,开户行,收款单位所在地,操作人,操作时间,来源,收款单位类型 1 人资发起薪资流程报销使用,归属公司 逗号拼接,薪资发放类型  1实付工资 2个人社保 3个人公积金 4个税,省,市,收款人开户行地址,收款单位电话,SWIFT CODE,收款人常驻国家（地区）,收款人常驻国家（地区）代码,护照,银行,收款方银行类型 1境内收款方 2境外收款方,收款单位是否有效(0无效，1有效),供应商主键, 3其他应收,募投项目主键,";

	public java.lang.Integer getReceiveUnitManageId() {
		return this.__receive_unit_manage_id;
	}

	public void setReceiveUnitManageId( java.lang.Integer value ) {
		this.__receive_unit_manage_id = value;
	}

	public java.lang.String getReceiveUnit() {
		return this.__receive_unit;
	}

	public void setReceiveUnit( java.lang.String value ) {
		this.__receive_unit = value;
	}

	public java.lang.String getBankAccount() {
		return this.__bank_account;
	}

	public void setBankAccount( java.lang.String value ) {
		this.__bank_account = value;
	}

	public java.lang.String getBankName() {
		return this.__bank_name;
	}

	public void setBankName( java.lang.String value ) {
		this.__bank_name = value;
	}

	public java.lang.String getReceiveUnitAddress() {
		return this.__receive_unit_address;
	}

	public void setReceiveUnitAddress( java.lang.String value ) {
		this.__receive_unit_address = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.Integer getOrigin() {
		return this.__origin;
	}

	public void setOrigin( java.lang.Integer value ) {
		this.__origin = value;
	}

	public java.lang.Integer getReceiveUnitType() {
		return this.__receive_unit_type;
	}

	public void setReceiveUnitType( java.lang.Integer value ) {
		this.__receive_unit_type = value;
	}

	public java.lang.String getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.String value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getSalaryType() {
		return this.__salary_type;
	}

	public void setSalaryType( java.lang.Integer value ) {
		this.__salary_type = value;
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

	public java.lang.String getBankAddress() {
		return this.__bank_address;
	}

	public void setBankAddress( java.lang.String value ) {
		this.__bank_address = value;
	}

	public java.lang.String getReceiveUnitPhone() {
		return this.__receive_unit_phone;
	}

	public void setReceiveUnitPhone( java.lang.String value ) {
		this.__receive_unit_phone = value;
	}

	public java.lang.String getSwiftCode() {
		return this.__swift_code;
	}

	public void setSwiftCode( java.lang.String value ) {
		this.__swift_code = value;
	}

	public java.lang.Integer getCountryId() {
		return this.__country_id;
	}

	public void setCountryId( java.lang.Integer value ) {
		this.__country_id = value;
	}

	public java.lang.String getCountryCode() {
		return this.__country_code;
	}

	public void setCountryCode( java.lang.String value ) {
		this.__country_code = value;
	}

	public java.lang.String getPassport() {
		return this.__passport;
	}

	public void setPassport( java.lang.String value ) {
		this.__passport = value;
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

	public java.lang.Integer getIsUse() {
		return this.__is_use;
	}

	public void setIsUse( java.lang.Integer value ) {
		this.__is_use = value;
	}

	public java.lang.Integer getSupplierId() {
		return this.__supplier_id;
	}

	public void setSupplierId( java.lang.Integer value ) {
		this.__supplier_id = value;
	}

	public java.lang.Integer getVoucherType() {
		return this.__voucher_type;
	}

	public void setVoucherType( java.lang.Integer value ) {
		this.__voucher_type = value;
	}

	public java.lang.Integer getFundraisingProjectTypeId() {
		return this.__fundraising_project_type_id;
	}

	public void setFundraisingProjectTypeId( java.lang.Integer value ) {
		this.__fundraising_project_type_id = value;
	}

	public java.lang.Integer getSupplierType() {
		return this.__supplier_type;
	}

	public void setSupplierType( java.lang.Integer value ) {
		this.__supplier_type = value;
	}

	public void cloneCopy(BaseReceiveUnitManage __bean){
		__bean.setReceiveUnitManageId(getReceiveUnitManageId());
		__bean.setReceiveUnit(getReceiveUnit());
		__bean.setBankAccount(getBankAccount());
		__bean.setBankName(getBankName());
		__bean.setReceiveUnitAddress(getReceiveUnitAddress());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setOrigin(getOrigin());
		__bean.setReceiveUnitType(getReceiveUnitType());
		__bean.setCompanyId(getCompanyId());
		__bean.setSalaryType(getSalaryType());
		__bean.setProvince(getProvince());
		__bean.setCity(getCity());
		__bean.setBankAddress(getBankAddress());
		__bean.setReceiveUnitPhone(getReceiveUnitPhone());
		__bean.setSwiftCode(getSwiftCode());
		__bean.setCountryId(getCountryId());
		__bean.setCountryCode(getCountryCode());
		__bean.setPassport(getPassport());
		__bean.setBankId(getBankId());
		__bean.setAccountType(getAccountType());
		__bean.setIsUse(getIsUse());
		__bean.setSupplierId(getSupplierId());
		__bean.setVoucherType(getVoucherType());
		__bean.setFundraisingProjectTypeId(getFundraisingProjectTypeId());
		__bean.setSupplierType(getSupplierType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getReceiveUnitManageId() == null ? "" : getReceiveUnitManageId());
		sb.append(",");
		sb.append(getReceiveUnit() == null ? "" : getReceiveUnit());
		sb.append(",");
		sb.append(getBankAccount() == null ? "" : getBankAccount());
		sb.append(",");
		sb.append(getBankName() == null ? "" : getBankName());
		sb.append(",");
		sb.append(getReceiveUnitAddress() == null ? "" : getReceiveUnitAddress());
		sb.append(",");
		String strOperateEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getOperateEmployeeId()));
		sb.append(strOperateEmployeeId == null ? "" : strOperateEmployeeId);
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getOrigin() == null ? "" : getOrigin());
		sb.append(",");
		sb.append(getReceiveUnitType() == null ? "" : getReceiveUnitType());
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		sb.append(getSalaryType() == null ? "" : getSalaryType());
		sb.append(",");
		sb.append(getProvince() == null ? "" : getProvince());
		sb.append(",");
		sb.append(getCity() == null ? "" : getCity());
		sb.append(",");
		sb.append(getBankAddress() == null ? "" : getBankAddress());
		sb.append(",");
		sb.append(getReceiveUnitPhone() == null ? "" : getReceiveUnitPhone());
		sb.append(",");
		sb.append(getSwiftCode() == null ? "" : getSwiftCode());
		sb.append(",");
		sb.append(getCountryId() == null ? "" : getCountryId());
		sb.append(",");
		sb.append(getCountryCode() == null ? "" : getCountryCode());
		sb.append(",");
		sb.append(getPassport() == null ? "" : getPassport());
		sb.append(",");
		sb.append(getBankId() == null ? "" : getBankId());
		sb.append(",");
		String strAccountType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_230", String.valueOf(getAccountType()));
		sb.append(strAccountType == null ? "" : strAccountType);
		sb.append(",");
		sb.append(getIsUse() == null ? "" : getIsUse());
		sb.append(",");
		sb.append(getSupplierId() == null ? "" : getSupplierId());
		sb.append(",");
		String strVoucherType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_117", String.valueOf(getVoucherType()));
		sb.append(strVoucherType == null ? "" : strVoucherType);
		sb.append(",");
		sb.append(getFundraisingProjectTypeId() == null ? "" : getFundraisingProjectTypeId());
		sb.append(",");
		sb.append(getSupplierType() == null ? "" : getSupplierType());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseReceiveUnitManage o) {
		return __receive_unit_manage_id == null ? -1 : __receive_unit_manage_id.compareTo(o.getReceiveUnitManageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__receive_unit_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__receive_unit);
		hash = 97 * hash + Objects.hashCode(this.__bank_account);
		hash = 97 * hash + Objects.hashCode(this.__bank_name);
		hash = 97 * hash + Objects.hashCode(this.__receive_unit_address);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__origin);
		hash = 97 * hash + Objects.hashCode(this.__receive_unit_type);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__salary_type);
		hash = 97 * hash + Objects.hashCode(this.__province);
		hash = 97 * hash + Objects.hashCode(this.__city);
		hash = 97 * hash + Objects.hashCode(this.__bank_address);
		hash = 97 * hash + Objects.hashCode(this.__receive_unit_phone);
		hash = 97 * hash + Objects.hashCode(this.__swift_code);
		hash = 97 * hash + Objects.hashCode(this.__country_id);
		hash = 97 * hash + Objects.hashCode(this.__country_code);
		hash = 97 * hash + Objects.hashCode(this.__passport);
		hash = 97 * hash + Objects.hashCode(this.__bank_id);
		hash = 97 * hash + Objects.hashCode(this.__account_type);
		hash = 97 * hash + Objects.hashCode(this.__is_use);
		hash = 97 * hash + Objects.hashCode(this.__supplier_id);
		hash = 97 * hash + Objects.hashCode(this.__voucher_type);
		hash = 97 * hash + Objects.hashCode(this.__fundraising_project_type_id);
		hash = 97 * hash + Objects.hashCode(this.__supplier_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseReceiveUnitManage o = (BaseReceiveUnitManage)obj;
		if(!Objects.equals(this.__receive_unit_manage_id, o.getReceiveUnitManageId())) return false;
		if(!Objects.equals(this.__receive_unit, o.getReceiveUnit())) return false;
		if(!Objects.equals(this.__bank_account, o.getBankAccount())) return false;
		if(!Objects.equals(this.__bank_name, o.getBankName())) return false;
		if(!Objects.equals(this.__receive_unit_address, o.getReceiveUnitAddress())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__origin, o.getOrigin())) return false;
		if(!Objects.equals(this.__receive_unit_type, o.getReceiveUnitType())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__salary_type, o.getSalaryType())) return false;
		if(!Objects.equals(this.__province, o.getProvince())) return false;
		if(!Objects.equals(this.__city, o.getCity())) return false;
		if(!Objects.equals(this.__bank_address, o.getBankAddress())) return false;
		if(!Objects.equals(this.__receive_unit_phone, o.getReceiveUnitPhone())) return false;
		if(!Objects.equals(this.__swift_code, o.getSwiftCode())) return false;
		if(!Objects.equals(this.__country_id, o.getCountryId())) return false;
		if(!Objects.equals(this.__country_code, o.getCountryCode())) return false;
		if(!Objects.equals(this.__passport, o.getPassport())) return false;
		if(!Objects.equals(this.__bank_id, o.getBankId())) return false;
		if(!Objects.equals(this.__account_type, o.getAccountType())) return false;
		if(!Objects.equals(this.__is_use, o.getIsUse())) return false;
		if(!Objects.equals(this.__supplier_id, o.getSupplierId())) return false;
		if(!Objects.equals(this.__voucher_type, o.getVoucherType())) return false;
		if(!Objects.equals(this.__fundraising_project_type_id, o.getFundraisingProjectTypeId())) return false;
		if(!Objects.equals(this.__supplier_type, o.getSupplierType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getReceiveUnitManageId() != null) sb.append(__wrapNumber(count++, "receiveUnitManageId", getReceiveUnitManageId()));
		if(getReceiveUnit() != null) sb.append(__wrapString(count++, "receiveUnit", getReceiveUnit()));
		if(getBankAccount() != null) sb.append(__wrapString(count++, "bankAccount", getBankAccount()));
		if(getBankName() != null) sb.append(__wrapString(count++, "bankName", getBankName()));
		if(getReceiveUnitAddress() != null) sb.append(__wrapString(count++, "receiveUnitAddress", getReceiveUnitAddress()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getOrigin() != null) sb.append(__wrapNumber(count++, "origin", getOrigin()));
		if(getReceiveUnitType() != null) sb.append(__wrapNumber(count++, "receiveUnitType", getReceiveUnitType()));
		if(getCompanyId() != null) sb.append(__wrapString(count++, "companyId", getCompanyId()));
		if(getSalaryType() != null) sb.append(__wrapNumber(count++, "salaryType", getSalaryType()));
		if(getProvince() != null) sb.append(__wrapNumber(count++, "province", getProvince()));
		if(getCity() != null) sb.append(__wrapNumber(count++, "city", getCity()));
		if(getBankAddress() != null) sb.append(__wrapString(count++, "bankAddress", getBankAddress()));
		if(getReceiveUnitPhone() != null) sb.append(__wrapString(count++, "receiveUnitPhone", getReceiveUnitPhone()));
		if(getSwiftCode() != null) sb.append(__wrapString(count++, "swiftCode", getSwiftCode()));
		if(getCountryId() != null) sb.append(__wrapNumber(count++, "countryId", getCountryId()));
		if(getCountryCode() != null) sb.append(__wrapString(count++, "countryCode", getCountryCode()));
		if(getPassport() != null) sb.append(__wrapString(count++, "passport", getPassport()));
		if(getBankId() != null) sb.append(__wrapNumber(count++, "bankId", getBankId()));
		if(getAccountType() != null) sb.append(__wrapNumber(count++, "accountType", getAccountType()));
		if(getIsUse() != null) sb.append(__wrapNumber(count++, "isUse", getIsUse()));
		if(getSupplierId() != null) sb.append(__wrapNumber(count++, "supplierId", getSupplierId()));
		if(getVoucherType() != null) sb.append(__wrapNumber(count++, "voucherType", getVoucherType()));
		if(getFundraisingProjectTypeId() != null) sb.append(__wrapNumber(count++, "fundraisingProjectTypeId", getFundraisingProjectTypeId()));
		if(getSupplierType() != null) sb.append(__wrapNumber(count++, "supplierType", getSupplierType()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getReceiveUnitManageId() != null) res.put("receiveUnitManageId", getReceiveUnitManageId());
		if(getReceiveUnit() != null) res.put("receiveUnit", getReceiveUnit());
		if(getBankAccount() != null) res.put("bankAccount", getBankAccount());
		if(getBankName() != null) res.put("bankName", getBankName());
		if(getReceiveUnitAddress() != null) res.put("receiveUnitAddress", getReceiveUnitAddress());
		if(getOperateEmployeeId() != null) res.put("operateEmployeeId", getOperateEmployeeId());
		if(getOperateTime() != null) res.put("operateTime", getOperateTime());
		if(getOrigin() != null) res.put("origin", getOrigin());
		if(getReceiveUnitType() != null) res.put("receiveUnitType", getReceiveUnitType());
		if(getCompanyId() != null) res.put("companyId", getCompanyId());
		if(getSalaryType() != null) res.put("salaryType", getSalaryType());
		if(getProvince() != null) res.put("province", getProvince());
		if(getCity() != null) res.put("city", getCity());
		if(getBankAddress() != null) res.put("bankAddress", getBankAddress());
		if(getReceiveUnitPhone() != null) res.put("receiveUnitPhone", getReceiveUnitPhone());
		if(getSwiftCode() != null) res.put("swiftCode", getSwiftCode());
		if(getCountryId() != null) res.put("countryId", getCountryId());
		if(getCountryCode() != null) res.put("countryCode", getCountryCode());
		if(getPassport() != null) res.put("passport", getPassport());
		if(getBankId() != null) res.put("bankId", getBankId());
		if(getAccountType() != null) res.put("accountType", getAccountType());
		if(getIsUse() != null) res.put("isUse", getIsUse());
		if(getSupplierId() != null) res.put("supplierId", getSupplierId());
		if(getVoucherType() != null) res.put("voucherType", getVoucherType());
		if(getFundraisingProjectTypeId() != null) res.put("fundraisingProjectTypeId", getFundraisingProjectTypeId());
		if(getSupplierType() != null) res.put("supplierType", getSupplierType());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("receiveUnitManageId")) != null) setReceiveUnitManageId(__getInt(val)); 
		if((val = values.get("receiveUnit")) != null) setReceiveUnit(__getString(val));
		if((val = values.get("bankAccount")) != null) setBankAccount(__getString(val));
		if((val = values.get("bankName")) != null) setBankName(__getString(val));
		if((val = values.get("receiveUnitAddress")) != null) setReceiveUnitAddress(__getString(val));
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("origin")) != null) setOrigin(__getInt(val)); 
		if((val = values.get("receiveUnitType")) != null) setReceiveUnitType(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getString(val));
		if((val = values.get("salaryType")) != null) setSalaryType(__getInt(val)); 
		if((val = values.get("province")) != null) setProvince(__getInt(val)); 
		if((val = values.get("city")) != null) setCity(__getInt(val)); 
		if((val = values.get("bankAddress")) != null) setBankAddress(__getString(val));
		if((val = values.get("receiveUnitPhone")) != null) setReceiveUnitPhone(__getString(val));
		if((val = values.get("swiftCode")) != null) setSwiftCode(__getString(val));
		if((val = values.get("countryId")) != null) setCountryId(__getInt(val)); 
		if((val = values.get("countryCode")) != null) setCountryCode(__getString(val));
		if((val = values.get("passport")) != null) setPassport(__getString(val));
		if((val = values.get("bankId")) != null) setBankId(__getInt(val)); 
		if((val = values.get("accountType")) != null) setAccountType(__getInt(val)); 
		if((val = values.get("isUse")) != null) setIsUse(__getInt(val)); 
		if((val = values.get("supplierId")) != null) setSupplierId(__getInt(val)); 
		if((val = values.get("voucherType")) != null) setVoucherType(__getInt(val)); 
		if((val = values.get("fundraisingProjectTypeId")) != null) setFundraisingProjectTypeId(__getInt(val)); 
		if((val = values.get("supplierType")) != null) setSupplierType(__getInt(val)); 
	}

	protected java.lang.Integer  __receive_unit_manage_id ;
	protected java.lang.String  __receive_unit ;
	protected java.lang.String  __bank_account ;
	protected java.lang.String  __bank_name ;
	protected java.lang.String  __receive_unit_address ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.Integer  __origin ;
	protected java.lang.Integer  __receive_unit_type ;
	protected java.lang.String  __company_id ;
	protected java.lang.Integer  __salary_type ;
	protected java.lang.Integer  __province ;
	protected java.lang.Integer  __city ;
	protected java.lang.String  __bank_address ;
	protected java.lang.String  __receive_unit_phone ;
	protected java.lang.String  __swift_code ;
	protected java.lang.Integer  __country_id ;
	protected java.lang.String  __country_code ;
	protected java.lang.String  __passport ;
	protected java.lang.Integer  __bank_id ;
	protected java.lang.Integer  __account_type ;
	protected java.lang.Integer  __is_use ;
	protected java.lang.Integer  __supplier_id ;
	protected java.lang.Integer  __voucher_type ;
	protected java.lang.Integer  __fundraising_project_type_id ;
	protected java.lang.Integer  __supplier_type ;
}
