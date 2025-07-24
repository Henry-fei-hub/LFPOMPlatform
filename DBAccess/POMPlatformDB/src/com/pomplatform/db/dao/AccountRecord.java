package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseAccountRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class AccountRecord extends AbstractTable<BaseAccountRecord>
{

	public AccountRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 12;

		initTables();

		__tableName            = "account_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseAccountRecord.CS_ACCOUNT_RECORD_ID;
		__column_names[1] = BaseAccountRecord.CS_ACCOUNT_ID;
		__column_names[2] = BaseAccountRecord.CS_BUSINESS_ID;
		__column_names[3] = BaseAccountRecord.CS_BUSINESS_TYPE_ID;
		__column_names[4] = BaseAccountRecord.CS_ACCOUNT_TYPE_ID;
		__column_names[5] = BaseAccountRecord.CS_ACHIEVE_INTEGRAL;
		__column_names[6] = BaseAccountRecord.CS_PAY_INTEGRAL;
		__column_names[7] = BaseAccountRecord.CS_RECORD_DATE;
		__column_names[8] = BaseAccountRecord.CS_RECORD_TIME;
		__column_names[9] = BaseAccountRecord.CS_OPERATE_EMPLOYEE_ID;
		__column_names[10] = BaseAccountRecord.CS_OPERATE_TIME;
		__column_names[11] = BaseAccountRecord.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseAccountRecord b) {
		clear();
		setAccountRecordIdClear(b.getAccountRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getAccountRecordId() == null;
	}

	@Override
	public BaseAccountRecord generateBase(){
		BaseAccountRecord b = new BaseAccountRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseAccountRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setAccountRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAccountId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAccountTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAchieveIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPayIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRecordTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseAccountRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getAccountRecordId();
		buff[count++] = b.getAccountId();
		buff[count++] = b.getBusinessId();
		buff[count++] = b.getBusinessTypeId();
		buff[count++] = b.getAccountTypeId();
		buff[count++] = b.getAchieveIntegral();
		buff[count++] = b.getPayIntegral();
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = generateTimestampFromDate(b.getRecordTime());
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseAccountRecord b){
		if(b.getAccountRecordId() != null) setAccountRecordIdClear(b.getAccountRecordId());
		if(b.getAccountId() != null) setAccountId(b.getAccountId());
		if(b.getBusinessId() != null) setBusinessId(b.getBusinessId());
		if(b.getBusinessTypeId() != null) setBusinessTypeId(b.getBusinessTypeId());
		if(b.getAccountTypeId() != null) setAccountTypeId(b.getAccountTypeId());
		if(b.getAchieveIntegral() != null) setAchieveIntegral(b.getAchieveIntegral());
		if(b.getPayIntegral() != null) setPayIntegral(b.getPayIntegral());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getRecordTime() != null) setRecordTime(b.getRecordTime());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseAccountRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseAccountRecord b = new BaseAccountRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseAccountRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAchieveIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setAccountRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getAccountRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setAccountRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setAccountId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getAccountId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setBusinessId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getBusinessId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setBusinessTypeId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getBusinessTypeId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setAccountTypeId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getAccountTypeId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setAchieveIntegral(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getAchieveIntegral() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setPayIntegral(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getPayIntegral() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setRecordDate(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordDate() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setRecordTime(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordTime() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(10, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[10]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setConditionAccountRecordId(String op, java.lang.Integer val) {
		setConditionAccountRecordId(op, val, CONDITION_AND);
	}

	public void setConditionAccountRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectAccountRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionAccountId(String op, java.lang.Integer val) {
		setConditionAccountId(op, val, CONDITION_AND);
	}

	public void setConditionAccountId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectAccountId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionBusinessId(String op, java.lang.Integer val) {
		setConditionBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectBusinessId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionBusinessTypeId(String op, java.lang.Integer val) {
		setConditionBusinessTypeId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectBusinessTypeId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionAccountTypeId(String op, java.lang.Integer val) {
		setConditionAccountTypeId(op, val, CONDITION_AND);
	}

	public void setConditionAccountTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectAccountTypeId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionAchieveIntegral(String op, java.math.BigDecimal val) {
		setConditionAchieveIntegral(op, val, CONDITION_AND);
	}

	public void setConditionAchieveIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectAchieveIntegral(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionPayIntegral(String op, java.math.BigDecimal val) {
		setConditionPayIntegral(op, val, CONDITION_AND);
	}

	public void setConditionPayIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectPayIntegral(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionRecordDate(String op, java.util.Date val) {
		setConditionRecordDate(op, val, CONDITION_AND);
	}

	public void setConditionRecordDate(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordDate(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionRecordTime(String op, java.util.Date val) {
		setConditionRecordTime(op, val, CONDITION_AND);
	}

	public void setConditionRecordTime(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordTime(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(10, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[11] = val;
	}


}

