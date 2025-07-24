package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseReceiveUnitManage;


public class ReceiveUnitManage extends AbstractTable<BaseReceiveUnitManage>
{

	public ReceiveUnitManage() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 26;

		initTables();

		__tableName            = "receive_unit_manages";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseReceiveUnitManage.CS_RECEIVE_UNIT_MANAGE_ID;
		__column_names[1] = BaseReceiveUnitManage.CS_RECEIVE_UNIT;
		__column_names[2] = BaseReceiveUnitManage.CS_BANK_ACCOUNT;
		__column_names[3] = BaseReceiveUnitManage.CS_BANK_NAME;
		__column_names[4] = BaseReceiveUnitManage.CS_RECEIVE_UNIT_ADDRESS;
		__column_names[5] = BaseReceiveUnitManage.CS_OPERATE_EMPLOYEE_ID;
		__column_names[6] = BaseReceiveUnitManage.CS_OPERATE_TIME;
		__column_names[7] = BaseReceiveUnitManage.CS_ORIGIN;
		__column_names[8] = BaseReceiveUnitManage.CS_RECEIVE_UNIT_TYPE;
		__column_names[9] = BaseReceiveUnitManage.CS_COMPANY_ID;
		__column_names[10] = BaseReceiveUnitManage.CS_SALARY_TYPE;
		__column_names[11] = BaseReceiveUnitManage.CS_PROVINCE;
		__column_names[12] = BaseReceiveUnitManage.CS_CITY;
		__column_names[13] = BaseReceiveUnitManage.CS_BANK_ADDRESS;
		__column_names[14] = BaseReceiveUnitManage.CS_RECEIVE_UNIT_PHONE;
		__column_names[15] = BaseReceiveUnitManage.CS_SWIFT_CODE;
		__column_names[16] = BaseReceiveUnitManage.CS_COUNTRY_ID;
		__column_names[17] = BaseReceiveUnitManage.CS_COUNTRY_CODE;
		__column_names[18] = BaseReceiveUnitManage.CS_PASSPORT;
		__column_names[19] = BaseReceiveUnitManage.CS_BANK_ID;
		__column_names[20] = BaseReceiveUnitManage.CS_ACCOUNT_TYPE;
		__column_names[21] = BaseReceiveUnitManage.CS_IS_USE;
		__column_names[22] = BaseReceiveUnitManage.CS_SUPPLIER_ID;
		__column_names[23] = BaseReceiveUnitManage.CS_VOUCHER_TYPE;
		__column_names[24] = BaseReceiveUnitManage.CS_FUNDRAISING_PROJECT_TYPE_ID;
		__column_names[25] = BaseReceiveUnitManage.CS_SUPPLIER_TYPE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseReceiveUnitManage b) {
		clear();
		setReceiveUnitManageIdClear(b.getReceiveUnitManageId());
	}

	public boolean isPrimaryKeyNull() {
		return getReceiveUnitManageId() == null;
	}

	@Override
	public BaseReceiveUnitManage generateBase(){
		BaseReceiveUnitManage b = new BaseReceiveUnitManage();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseReceiveUnitManage b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setReceiveUnitManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReceiveUnit(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBankAccount(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBankName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setReceiveUnitAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOrigin(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReceiveUnitType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSalaryType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProvince(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCity(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBankAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setReceiveUnitPhone(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSwiftCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCountryId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCountryCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPassport(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBankId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAccountType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsUse(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSupplierId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setVoucherType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFundraisingProjectTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSupplierType(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseReceiveUnitManage b, Object[] buff){
		int count = 0;
		buff[count++] = b.getReceiveUnitManageId();
		buff[count++] = b.getReceiveUnit();
		buff[count++] = b.getBankAccount();
		buff[count++] = b.getBankName();
		buff[count++] = b.getReceiveUnitAddress();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getOrigin();
		buff[count++] = b.getReceiveUnitType();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getSalaryType();
		buff[count++] = b.getProvince();
		buff[count++] = b.getCity();
		buff[count++] = b.getBankAddress();
		buff[count++] = b.getReceiveUnitPhone();
		buff[count++] = b.getSwiftCode();
		buff[count++] = b.getCountryId();
		buff[count++] = b.getCountryCode();
		buff[count++] = b.getPassport();
		buff[count++] = b.getBankId();
		buff[count++] = b.getAccountType();
		buff[count++] = b.getIsUse();
		buff[count++] = b.getSupplierId();
		buff[count++] = b.getVoucherType();
		buff[count++] = b.getFundraisingProjectTypeId();
		buff[count++] = b.getSupplierType();
	}

	@Override
	public void setDataFromBase(BaseReceiveUnitManage b){
		if(b.getReceiveUnitManageId() != null) setReceiveUnitManageIdClear(b.getReceiveUnitManageId());
		if(b.getReceiveUnit() != null) setReceiveUnit(b.getReceiveUnit());
		if(b.getBankAccount() != null) setBankAccount(b.getBankAccount());
		if(b.getBankName() != null) setBankName(b.getBankName());
		if(b.getReceiveUnitAddress() != null) setReceiveUnitAddress(b.getReceiveUnitAddress());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getOrigin() != null) setOrigin(b.getOrigin());
		if(b.getReceiveUnitType() != null) setReceiveUnitType(b.getReceiveUnitType());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getSalaryType() != null) setSalaryType(b.getSalaryType());
		if(b.getProvince() != null) setProvince(b.getProvince());
		if(b.getCity() != null) setCity(b.getCity());
		if(b.getBankAddress() != null) setBankAddress(b.getBankAddress());
		if(b.getReceiveUnitPhone() != null) setReceiveUnitPhone(b.getReceiveUnitPhone());
		if(b.getSwiftCode() != null) setSwiftCode(b.getSwiftCode());
		if(b.getCountryId() != null) setCountryId(b.getCountryId());
		if(b.getCountryCode() != null) setCountryCode(b.getCountryCode());
		if(b.getPassport() != null) setPassport(b.getPassport());
		if(b.getBankId() != null) setBankId(b.getBankId());
		if(b.getAccountType() != null) setAccountType(b.getAccountType());
		if(b.getIsUse() != null) setIsUse(b.getIsUse());
		if(b.getSupplierId() != null) setSupplierId(b.getSupplierId());
		if(b.getVoucherType() != null) setVoucherType(b.getVoucherType());
		if(b.getFundraisingProjectTypeId() != null) setFundraisingProjectTypeId(b.getFundraisingProjectTypeId());
		if(b.getSupplierType() != null) setSupplierType(b.getSupplierType());
	}

	@Override
	public BaseReceiveUnitManage generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseReceiveUnitManage b = new BaseReceiveUnitManage();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseReceiveUnitManage __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceiveUnitManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceiveUnit(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBankAccount(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBankName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceiveUnitAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrigin(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceiveUnitType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalaryType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProvince(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCity(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBankAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceiveUnitPhone(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSwiftCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCountryId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCountryCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPassport(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBankId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsUse(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setVoucherType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFundraisingProjectTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierType(GenericBase.__getInt(val));
	}

	public void setReceiveUnitManageId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getReceiveUnitManageId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setReceiveUnitManageIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setReceiveUnit(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getReceiveUnit() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setBankAccount(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getBankAccount() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setBankName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getBankName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setReceiveUnitAddress(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getReceiveUnitAddress() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setOrigin(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getOrigin() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setReceiveUnitType(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getReceiveUnitType() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setCompanyId(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getCompanyId() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setSalaryType(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getSalaryType() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setProvince(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getProvince() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setCity(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getCity() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setBankAddress(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getBankAddress() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setReceiveUnitPhone(java.lang.String val) {
		setCurrentData(14, val);
	}

	public java.lang.String getReceiveUnitPhone() {
		return GenericBase.__getString(__current_data[14]);
	}

	public void setSwiftCode(java.lang.String val) {
		setCurrentData(15, val);
	}

	public java.lang.String getSwiftCode() {
		return GenericBase.__getString(__current_data[15]);
	}

	public void setCountryId(java.lang.Integer val) {
		setCurrentData(16, val);
	}

	public java.lang.Integer getCountryId() {
		return GenericBase.__getInt(__current_data[16]);
	}

	public void setCountryCode(java.lang.String val) {
		setCurrentData(17, val);
	}

	public java.lang.String getCountryCode() {
		return GenericBase.__getString(__current_data[17]);
	}

	public void setPassport(java.lang.String val) {
		setCurrentData(18, val);
	}

	public java.lang.String getPassport() {
		return GenericBase.__getString(__current_data[18]);
	}

	public void setBankId(java.lang.Integer val) {
		setCurrentData(19, val);
	}

	public java.lang.Integer getBankId() {
		return GenericBase.__getInt(__current_data[19]);
	}

	public void setAccountType(java.lang.Integer val) {
		setCurrentData(20, val);
	}

	public java.lang.Integer getAccountType() {
		return GenericBase.__getInt(__current_data[20]);
	}

	public void setIsUse(java.lang.Integer val) {
		setCurrentData(21, val);
	}

	public java.lang.Integer getIsUse() {
		return GenericBase.__getInt(__current_data[21]);
	}

	public void setSupplierId(java.lang.Integer val) {
		setCurrentData(22, val);
	}

	public java.lang.Integer getSupplierId() {
		return GenericBase.__getInt(__current_data[22]);
	}

	public void setVoucherType(java.lang.Integer val) {
		setCurrentData(23, val);
	}

	public java.lang.Integer getVoucherType() {
		return GenericBase.__getInt(__current_data[23]);
	}

	public void setFundraisingProjectTypeId(java.lang.Integer val) {
		setCurrentData(24, val);
	}

	public java.lang.Integer getFundraisingProjectTypeId() {
		return GenericBase.__getInt(__current_data[24]);
	}

	public void setSupplierType(java.lang.Integer val) {
		setCurrentData(25, val);
	}

	public java.lang.Integer getSupplierType() {
		return GenericBase.__getInt(__current_data[25]);
	}

	public void setConditionReceiveUnitManageId(String op, java.lang.Integer val) {
		setConditionReceiveUnitManageId(op, val, CONDITION_AND);
	}

	public void setConditionReceiveUnitManageId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectReceiveUnitManageId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionReceiveUnit(String op, java.lang.String val) {
		setConditionReceiveUnit(op, val, CONDITION_AND);
	}

	public void setConditionReceiveUnit(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectReceiveUnit(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionBankAccount(String op, java.lang.String val) {
		setConditionBankAccount(op, val, CONDITION_AND);
	}

	public void setConditionBankAccount(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectBankAccount(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionBankName(String op, java.lang.String val) {
		setConditionBankName(op, val, CONDITION_AND);
	}

	public void setConditionBankName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectBankName(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionReceiveUnitAddress(String op, java.lang.String val) {
		setConditionReceiveUnitAddress(op, val, CONDITION_AND);
	}

	public void setConditionReceiveUnitAddress(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectReceiveUnitAddress(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionOrigin(String op, java.lang.Integer val) {
		setConditionOrigin(op, val, CONDITION_AND);
	}

	public void setConditionOrigin(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectOrigin(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionReceiveUnitType(String op, java.lang.Integer val) {
		setConditionReceiveUnitType(op, val, CONDITION_AND);
	}

	public void setConditionReceiveUnitType(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectReceiveUnitType(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionCompanyId(String op, java.lang.String val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionSalaryType(String op, java.lang.Integer val) {
		setConditionSalaryType(op, val, CONDITION_AND);
	}

	public void setConditionSalaryType(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectSalaryType(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionProvince(String op, java.lang.Integer val) {
		setConditionProvince(op, val, CONDITION_AND);
	}

	public void setConditionProvince(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectProvince(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionCity(String op, java.lang.Integer val) {
		setConditionCity(op, val, CONDITION_AND);
	}

	public void setConditionCity(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectCity(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionBankAddress(String op, java.lang.String val) {
		setConditionBankAddress(op, val, CONDITION_AND);
	}

	public void setConditionBankAddress(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectBankAddress(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionReceiveUnitPhone(String op, java.lang.String val) {
		setConditionReceiveUnitPhone(op, val, CONDITION_AND);
	}

	public void setConditionReceiveUnitPhone(String op, java.lang.String val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectReceiveUnitPhone(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionSwiftCode(String op, java.lang.String val) {
		setConditionSwiftCode(op, val, CONDITION_AND);
	}

	public void setConditionSwiftCode(String op, java.lang.String val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectSwiftCode(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionCountryId(String op, java.lang.Integer val) {
		setConditionCountryId(op, val, CONDITION_AND);
	}

	public void setConditionCountryId(String op, java.lang.Integer val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectCountryId(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionCountryCode(String op, java.lang.String val) {
		setConditionCountryCode(op, val, CONDITION_AND);
	}

	public void setConditionCountryCode(String op, java.lang.String val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectCountryCode(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionPassport(String op, java.lang.String val) {
		setConditionPassport(op, val, CONDITION_AND);
	}

	public void setConditionPassport(String op, java.lang.String val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectPassport(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionBankId(String op, java.lang.Integer val) {
		setConditionBankId(op, val, CONDITION_AND);
	}

	public void setConditionBankId(String op, java.lang.Integer val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectBankId(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionAccountType(String op, java.lang.Integer val) {
		setConditionAccountType(op, val, CONDITION_AND);
	}

	public void setConditionAccountType(String op, java.lang.Integer val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectAccountType(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionIsUse(String op, java.lang.Integer val) {
		setConditionIsUse(op, val, CONDITION_AND);
	}

	public void setConditionIsUse(String op, java.lang.Integer val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectIsUse(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionSupplierId(String op, java.lang.Integer val) {
		setConditionSupplierId(op, val, CONDITION_AND);
	}

	public void setConditionSupplierId(String op, java.lang.Integer val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectSupplierId(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionVoucherType(String op, java.lang.Integer val) {
		setConditionVoucherType(op, val, CONDITION_AND);
	}

	public void setConditionVoucherType(String op, java.lang.Integer val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectVoucherType(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionFundraisingProjectTypeId(String op, java.lang.Integer val) {
		setConditionFundraisingProjectTypeId(op, val, CONDITION_AND);
	}

	public void setConditionFundraisingProjectTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectFundraisingProjectTypeId(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionSupplierType(String op, java.lang.Integer val) {
		setConditionSupplierType(op, val, CONDITION_AND);
	}

	public void setConditionSupplierType(String op, java.lang.Integer val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectSupplierType(boolean val) {
		__select_flags[25] = val;
	}


}

