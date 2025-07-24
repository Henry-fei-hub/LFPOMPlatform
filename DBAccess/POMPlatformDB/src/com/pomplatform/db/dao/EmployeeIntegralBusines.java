package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseEmployeeIntegralBusines;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class EmployeeIntegralBusines extends AbstractTable<BaseEmployeeIntegralBusines>
{

	public EmployeeIntegralBusines() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 11;

		initTables();

		__tableName            = "employee_integral_business";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEmployeeIntegralBusines.CS_EMPLOYEE_INTEGRAL_BUSINESS_ID;
		__column_names[1] = BaseEmployeeIntegralBusines.CS_BUSINESS_TYPE_ID;
		__column_names[2] = BaseEmployeeIntegralBusines.CS_BUSINESS_TYPE_NAME;
		__column_names[3] = BaseEmployeeIntegralBusines.CS_EMPLOYEE_ID;
		__column_names[4] = BaseEmployeeIntegralBusines.CS_INTEGRAL;
		__column_names[5] = BaseEmployeeIntegralBusines.CS_RECORD_DATE;
		__column_names[6] = BaseEmployeeIntegralBusines.CS_STATUS;
		__column_names[7] = BaseEmployeeIntegralBusines.CS_OPERATE_TIME;
		__column_names[8] = BaseEmployeeIntegralBusines.CS_OPERATE_EMPLOYEE_ID;
		__column_names[9] = BaseEmployeeIntegralBusines.CS_REMARK;
		__column_names[10] = BaseEmployeeIntegralBusines.CS_BUSINESS_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEmployeeIntegralBusines b) {
		clear();
		setEmployeeIntegralBusinessIdClear(b.getEmployeeIntegralBusinessId());
	}

	public boolean isPrimaryKeyNull() {
		return getEmployeeIntegralBusinessId() == null;
	}

	@Override
	public BaseEmployeeIntegralBusines generateBase(){
		BaseEmployeeIntegralBusines b = new BaseEmployeeIntegralBusines();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEmployeeIntegralBusines b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEmployeeIntegralBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessTypeName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBusinessId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseEmployeeIntegralBusines b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEmployeeIntegralBusinessId();
		buff[count++] = b.getBusinessTypeId();
		buff[count++] = b.getBusinessTypeName();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getIntegral();
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = b.getStatus();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = b.getRemark();
		buff[count++] = b.getBusinessId();
	}

	@Override
	public void setDataFromBase(BaseEmployeeIntegralBusines b){
		if(b.getEmployeeIntegralBusinessId() != null) setEmployeeIntegralBusinessIdClear(b.getEmployeeIntegralBusinessId());
		if(b.getBusinessTypeId() != null) setBusinessTypeId(b.getBusinessTypeId());
		if(b.getBusinessTypeName() != null) setBusinessTypeName(b.getBusinessTypeName());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getIntegral() != null) setIntegral(b.getIntegral());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getBusinessId() != null) setBusinessId(b.getBusinessId());
	}

	@Override
	public BaseEmployeeIntegralBusines generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEmployeeIntegralBusines b = new BaseEmployeeIntegralBusines();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEmployeeIntegralBusines __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeIntegralBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessTypeName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessId(GenericBase.__getInt(val));
	}

	public void setEmployeeIntegralBusinessId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEmployeeIntegralBusinessId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEmployeeIntegralBusinessIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setBusinessTypeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getBusinessTypeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setBusinessTypeName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getBusinessTypeName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setIntegral(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getIntegral() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setRecordDate(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordDate() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setBusinessId(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getBusinessId() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setConditionEmployeeIntegralBusinessId(String op, java.lang.Integer val) {
		setConditionEmployeeIntegralBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeIntegralBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEmployeeIntegralBusinessId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionBusinessTypeId(String op, java.lang.Integer val) {
		setConditionBusinessTypeId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectBusinessTypeId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionBusinessTypeName(String op, java.lang.String val) {
		setConditionBusinessTypeName(op, val, CONDITION_AND);
	}

	public void setConditionBusinessTypeName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectBusinessTypeName(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionIntegral(String op, java.math.BigDecimal val) {
		setConditionIntegral(op, val, CONDITION_AND);
	}

	public void setConditionIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectIntegral(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionRecordDate(String op, java.util.Date val) {
		setConditionRecordDate(op, val, CONDITION_AND);
	}

	public void setConditionRecordDate(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordDate(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
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

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionBusinessId(String op, java.lang.Integer val) {
		setConditionBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectBusinessId(boolean val) {
		__select_flags[10] = val;
	}


}

