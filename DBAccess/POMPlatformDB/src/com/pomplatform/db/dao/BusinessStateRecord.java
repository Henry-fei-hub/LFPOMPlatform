package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseBusinessStateRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class BusinessStateRecord extends AbstractTable<BaseBusinessStateRecord>
{

	public BusinessStateRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "business_state_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseBusinessStateRecord.CS_BUSINESS_STATE_RECORD_ID;
		__column_names[1] = BaseBusinessStateRecord.CS_CONTRACT_ID;
		__column_names[2] = BaseBusinessStateRecord.CS_BUSINESS_CODE;
		__column_names[3] = BaseBusinessStateRecord.CS_BUSINESS_NAME;
		__column_names[4] = BaseBusinessStateRecord.CS_BEFORE_CONTRACT_TOTAL;
		__column_names[5] = BaseBusinessStateRecord.CS_BUSINESS_INTEGRAL;
		__column_names[6] = BaseBusinessStateRecord.CS_ACCOUNT_WEIGHT_RECORD_ID;
		__column_names[7] = BaseBusinessStateRecord.CS_SIGNING_COMPANY;
		__column_names[8] = BaseBusinessStateRecord.CS_OPERATE_EMPLOYEE_ID;
		__column_names[9] = BaseBusinessStateRecord.CS_OPERATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseBusinessStateRecord b) {
		clear();
		setBusinessStateRecordIdClear(b.getBusinessStateRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getBusinessStateRecordId() == null;
	}

	@Override
	public BaseBusinessStateRecord generateBase(){
		BaseBusinessStateRecord b = new BaseBusinessStateRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseBusinessStateRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setBusinessStateRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBusinessName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBeforeContractTotal(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setBusinessIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAccountWeightRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSigningCompany(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseBusinessStateRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getBusinessStateRecordId();
		buff[count++] = b.getContractId();
		buff[count++] = b.getBusinessCode();
		buff[count++] = b.getBusinessName();
		buff[count++] = b.getBeforeContractTotal();
		buff[count++] = b.getBusinessIntegral();
		buff[count++] = b.getAccountWeightRecordId();
		buff[count++] = b.getSigningCompany();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
	}

	@Override
	public void setDataFromBase(BaseBusinessStateRecord b){
		if(b.getBusinessStateRecordId() != null) setBusinessStateRecordIdClear(b.getBusinessStateRecordId());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getBusinessCode() != null) setBusinessCode(b.getBusinessCode());
		if(b.getBusinessName() != null) setBusinessName(b.getBusinessName());
		if(b.getBeforeContractTotal() != null) setBeforeContractTotal(b.getBeforeContractTotal());
		if(b.getBusinessIntegral() != null) setBusinessIntegral(b.getBusinessIntegral());
		if(b.getAccountWeightRecordId() != null) setAccountWeightRecordId(b.getAccountWeightRecordId());
		if(b.getSigningCompany() != null) setSigningCompany(b.getSigningCompany());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
	}

	@Override
	public BaseBusinessStateRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseBusinessStateRecord b = new BaseBusinessStateRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseBusinessStateRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessStateRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBeforeContractTotal(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountWeightRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSigningCompany(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setBusinessStateRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getBusinessStateRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setBusinessStateRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setBusinessCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getBusinessCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setBusinessName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getBusinessName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setBeforeContractTotal(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getBeforeContractTotal() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setBusinessIntegral(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getBusinessIntegral() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setAccountWeightRecordId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getAccountWeightRecordId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setSigningCompany(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getSigningCompany() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setConditionBusinessStateRecordId(String op, java.lang.Integer val) {
		setConditionBusinessStateRecordId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessStateRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectBusinessStateRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionBusinessCode(String op, java.lang.String val) {
		setConditionBusinessCode(op, val, CONDITION_AND);
	}

	public void setConditionBusinessCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectBusinessCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionBusinessName(String op, java.lang.String val) {
		setConditionBusinessName(op, val, CONDITION_AND);
	}

	public void setConditionBusinessName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectBusinessName(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionBeforeContractTotal(String op, java.math.BigDecimal val) {
		setConditionBeforeContractTotal(op, val, CONDITION_AND);
	}

	public void setConditionBeforeContractTotal(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectBeforeContractTotal(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionBusinessIntegral(String op, java.math.BigDecimal val) {
		setConditionBusinessIntegral(op, val, CONDITION_AND);
	}

	public void setConditionBusinessIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectBusinessIntegral(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionAccountWeightRecordId(String op, java.lang.Integer val) {
		setConditionAccountWeightRecordId(op, val, CONDITION_AND);
	}

	public void setConditionAccountWeightRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectAccountWeightRecordId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionSigningCompany(String op, java.lang.Integer val) {
		setConditionSigningCompany(op, val, CONDITION_AND);
	}

	public void setConditionSigningCompany(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectSigningCompany(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(9, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[9] = val;
	}


}

