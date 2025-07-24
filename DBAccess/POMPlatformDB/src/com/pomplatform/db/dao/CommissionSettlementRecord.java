package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCommissionSettlementRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CommissionSettlementRecord extends AbstractTable<BaseCommissionSettlementRecord>
{

	public CommissionSettlementRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 9;

		initTables();

		__tableName            = "commission_settlement_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCommissionSettlementRecord.CS_COMMISSION_SETTLEMENT_RECORD_ID;
		__column_names[1] = BaseCommissionSettlementRecord.CS_ORDER_ID;
		__column_names[2] = BaseCommissionSettlementRecord.CS_PROJECT_NAME;
		__column_names[3] = BaseCommissionSettlementRecord.CS_COUNT_TYPE;
		__column_names[4] = BaseCommissionSettlementRecord.CS_EMPLOYEE_ID;
		__column_names[5] = BaseCommissionSettlementRecord.CS_DEPARTMENT_ID;
		__column_names[6] = BaseCommissionSettlementRecord.CS_SETTLEMENT_TYPE;
		__column_names[7] = BaseCommissionSettlementRecord.CS_AMOUNT;
		__column_names[8] = BaseCommissionSettlementRecord.CS_SETTLEMENT_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCommissionSettlementRecord b) {
		clear();
		setCommissionSettlementRecordIdClear(b.getCommissionSettlementRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getCommissionSettlementRecordId() == null;
	}

	@Override
	public BaseCommissionSettlementRecord generateBase(){
		BaseCommissionSettlementRecord b = new BaseCommissionSettlementRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCommissionSettlementRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCommissionSettlementRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOrderId(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCountType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSettlementType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSettlementTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseCommissionSettlementRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCommissionSettlementRecordId();
		buff[count++] = b.getOrderId();
		buff[count++] = b.getProjectName();
		buff[count++] = b.getCountType();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getSettlementType();
		buff[count++] = b.getAmount();
		buff[count++] = generateTimestampFromDate(b.getSettlementTime());
	}

	@Override
	public void setDataFromBase(BaseCommissionSettlementRecord b){
		if(b.getCommissionSettlementRecordId() != null) setCommissionSettlementRecordIdClear(b.getCommissionSettlementRecordId());
		if(b.getOrderId() != null) setOrderId(b.getOrderId());
		if(b.getProjectName() != null) setProjectName(b.getProjectName());
		if(b.getCountType() != null) setCountType(b.getCountType());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getSettlementType() != null) setSettlementType(b.getSettlementType());
		if(b.getAmount() != null) setAmount(b.getAmount());
		if(b.getSettlementTime() != null) setSettlementTime(b.getSettlementTime());
	}

	@Override
	public BaseCommissionSettlementRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCommissionSettlementRecord b = new BaseCommissionSettlementRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCommissionSettlementRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCommissionSettlementRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderId(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCountType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSettlementType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSettlementTime(GenericBase.__getDateFromSQL(val));
	}

	public void setCommissionSettlementRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCommissionSettlementRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCommissionSettlementRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setOrderId(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getOrderId() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setProjectName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getProjectName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setCountType(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getCountType() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setSettlementType(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getSettlementType() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setAmount(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getAmount() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setSettlementTime(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getSettlementTime() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setConditionCommissionSettlementRecordId(String op, java.lang.Integer val) {
		setConditionCommissionSettlementRecordId(op, val, CONDITION_AND);
	}

	public void setConditionCommissionSettlementRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCommissionSettlementRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionOrderId(String op, java.lang.String val) {
		setConditionOrderId(op, val, CONDITION_AND);
	}

	public void setConditionOrderId(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectOrderId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionProjectName(String op, java.lang.String val) {
		setConditionProjectName(op, val, CONDITION_AND);
	}

	public void setConditionProjectName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProjectName(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionCountType(String op, java.lang.Integer val) {
		setConditionCountType(op, val, CONDITION_AND);
	}

	public void setConditionCountType(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectCountType(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionSettlementType(String op, java.lang.Integer val) {
		setConditionSettlementType(op, val, CONDITION_AND);
	}

	public void setConditionSettlementType(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectSettlementType(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionAmount(String op, java.math.BigDecimal val) {
		setConditionAmount(op, val, CONDITION_AND);
	}

	public void setConditionAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectAmount(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionSettlementTime(String op, java.util.Date val) {
		setConditionSettlementTime(op, val, CONDITION_AND);
	}

	public void setConditionSettlementTime(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectSettlementTime(boolean val) {
		__select_flags[8] = val;
	}


}

