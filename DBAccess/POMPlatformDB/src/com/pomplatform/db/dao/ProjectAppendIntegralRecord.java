package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectAppendIntegralRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectAppendIntegralRecord extends AbstractTable<BaseProjectAppendIntegralRecord>
{

	public ProjectAppendIntegralRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "project_append_integral_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectAppendIntegralRecord.CS_PROJECT_APPEND_INTEGRAL_RECORD_ID;
		__column_names[1] = BaseProjectAppendIntegralRecord.CS_PROJECT_ID;
		__column_names[2] = BaseProjectAppendIntegralRecord.CS_APPEND_INTEGRAL;
		__column_names[3] = BaseProjectAppendIntegralRecord.CS_PERCENTAGE;
		__column_names[4] = BaseProjectAppendIntegralRecord.CS_APPEND_TIME;
		__column_names[5] = BaseProjectAppendIntegralRecord.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectAppendIntegralRecord b) {
		clear();
		setProjectAppendIntegralRecordIdClear(b.getProjectAppendIntegralRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectAppendIntegralRecordId() == null;
	}

	@Override
	public BaseProjectAppendIntegralRecord generateBase(){
		BaseProjectAppendIntegralRecord b = new BaseProjectAppendIntegralRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectAppendIntegralRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectAppendIntegralRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAppendIntegral(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPercentage(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAppendTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectAppendIntegralRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectAppendIntegralRecordId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getAppendIntegral();
		buff[count++] = b.getPercentage();
		buff[count++] = generateTimestampFromDate(b.getAppendTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseProjectAppendIntegralRecord b){
		if(b.getProjectAppendIntegralRecordId() != null) setProjectAppendIntegralRecordIdClear(b.getProjectAppendIntegralRecordId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getAppendIntegral() != null) setAppendIntegral(b.getAppendIntegral());
		if(b.getPercentage() != null) setPercentage(b.getPercentage());
		if(b.getAppendTime() != null) setAppendTime(b.getAppendTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseProjectAppendIntegralRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectAppendIntegralRecord b = new BaseProjectAppendIntegralRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectAppendIntegralRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectAppendIntegralRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAppendIntegral(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPercentage(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAppendTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setProjectAppendIntegralRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectAppendIntegralRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectAppendIntegralRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setAppendIntegral(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getAppendIntegral() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setPercentage(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getPercentage() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setAppendTime(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getAppendTime() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setConditionProjectAppendIntegralRecordId(String op, java.lang.Integer val) {
		setConditionProjectAppendIntegralRecordId(op, val, CONDITION_AND);
	}

	public void setConditionProjectAppendIntegralRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectAppendIntegralRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionAppendIntegral(String op, java.lang.Integer val) {
		setConditionAppendIntegral(op, val, CONDITION_AND);
	}

	public void setConditionAppendIntegral(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectAppendIntegral(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionPercentage(String op, java.math.BigDecimal val) {
		setConditionPercentage(op, val, CONDITION_AND);
	}

	public void setConditionPercentage(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectPercentage(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionAppendTime(String op, java.util.Date val) {
		setConditionAppendTime(op, val, CONDITION_AND);
	}

	public void setConditionAppendTime(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectAppendTime(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[5] = val;
	}


}

