package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectManagePerformanceRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectManagePerformanceRecord extends AbstractTable<BaseProjectManagePerformanceRecord>
{

	public ProjectManagePerformanceRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 13;

		initTables();

		__tableName            = "project_manage_performance_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectManagePerformanceRecord.CS_PROJECT_MANAGE_PERFORMANCE_RECORD_ID;
		__column_names[1] = BaseProjectManagePerformanceRecord.CS_PROJECT_MANAGE_PERFORMANCE_TOTAL_ID;
		__column_names[2] = BaseProjectManagePerformanceRecord.CS_OBJECT_ID;
		__column_names[3] = BaseProjectManagePerformanceRecord.CS_OBJECT_NO;
		__column_names[4] = BaseProjectManagePerformanceRecord.CS_OBJECT_NAME;
		__column_names[5] = BaseProjectManagePerformanceRecord.CS_OBJECT_TYPE;
		__column_names[6] = BaseProjectManagePerformanceRecord.CS_PERFORMANCE_MONEY;
		__column_names[7] = BaseProjectManagePerformanceRecord.CS_PERFORMANCE_STATUS;
		__column_names[8] = BaseProjectManagePerformanceRecord.CS_BUSINESS_TYPE;
		__column_names[9] = BaseProjectManagePerformanceRecord.CS_BUSINESS_NAME;
		__column_names[10] = BaseProjectManagePerformanceRecord.CS_RECORD_DATE;
		__column_names[11] = BaseProjectManagePerformanceRecord.CS_RECORD_TIME;
		__column_names[12] = BaseProjectManagePerformanceRecord.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectManagePerformanceRecord b) {
		clear();
		setProjectManagePerformanceRecordIdClear(b.getProjectManagePerformanceRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectManagePerformanceRecordId() == null;
	}

	@Override
	public BaseProjectManagePerformanceRecord generateBase(){
		BaseProjectManagePerformanceRecord b = new BaseProjectManagePerformanceRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectManagePerformanceRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectManagePerformanceRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectManagePerformanceTotalId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setObjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setObjectNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setObjectName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setObjectType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPerformanceMoney(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPerformanceStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRecordTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectManagePerformanceRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectManagePerformanceRecordId();
		buff[count++] = b.getProjectManagePerformanceTotalId();
		buff[count++] = b.getObjectId();
		buff[count++] = b.getObjectNo();
		buff[count++] = b.getObjectName();
		buff[count++] = b.getObjectType();
		buff[count++] = b.getPerformanceMoney();
		buff[count++] = b.getPerformanceStatus();
		buff[count++] = b.getBusinessType();
		buff[count++] = b.getBusinessName();
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = generateTimestampFromDate(b.getRecordTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseProjectManagePerformanceRecord b){
		if(b.getProjectManagePerformanceRecordId() != null) setProjectManagePerformanceRecordIdClear(b.getProjectManagePerformanceRecordId());
		if(b.getProjectManagePerformanceTotalId() != null) setProjectManagePerformanceTotalId(b.getProjectManagePerformanceTotalId());
		if(b.getObjectId() != null) setObjectId(b.getObjectId());
		if(b.getObjectNo() != null) setObjectNo(b.getObjectNo());
		if(b.getObjectName() != null) setObjectName(b.getObjectName());
		if(b.getObjectType() != null) setObjectType(b.getObjectType());
		if(b.getPerformanceMoney() != null) setPerformanceMoney(b.getPerformanceMoney());
		if(b.getPerformanceStatus() != null) setPerformanceStatus(b.getPerformanceStatus());
		if(b.getBusinessType() != null) setBusinessType(b.getBusinessType());
		if(b.getBusinessName() != null) setBusinessName(b.getBusinessName());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getRecordTime() != null) setRecordTime(b.getRecordTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseProjectManagePerformanceRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectManagePerformanceRecord b = new BaseProjectManagePerformanceRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectManagePerformanceRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectManagePerformanceRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectManagePerformanceTotalId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setObjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setObjectNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setObjectName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setObjectType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPerformanceMoney(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPerformanceStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setProjectManagePerformanceRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectManagePerformanceRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectManagePerformanceRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectManagePerformanceTotalId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProjectManagePerformanceTotalId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setObjectId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getObjectId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setObjectNo(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getObjectNo() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setObjectName(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getObjectName() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setObjectType(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getObjectType() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setPerformanceMoney(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getPerformanceMoney() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setPerformanceStatus(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getPerformanceStatus() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setBusinessType(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getBusinessType() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setBusinessName(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getBusinessName() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setRecordDate(java.util.Date val) {
		setCurrentData(10, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordDate() {
		return GenericBase.__getDateFromSQL(__current_data[10]);
	}

	public void setRecordTime(java.util.Date val) {
		setCurrentData(11, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordTime() {
		return GenericBase.__getDateFromSQL(__current_data[11]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setConditionProjectManagePerformanceRecordId(String op, java.lang.Integer val) {
		setConditionProjectManagePerformanceRecordId(op, val, CONDITION_AND);
	}

	public void setConditionProjectManagePerformanceRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectManagePerformanceRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionProjectManagePerformanceTotalId(String op, java.lang.Integer val) {
		setConditionProjectManagePerformanceTotalId(op, val, CONDITION_AND);
	}

	public void setConditionProjectManagePerformanceTotalId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProjectManagePerformanceTotalId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionObjectId(String op, java.lang.Integer val) {
		setConditionObjectId(op, val, CONDITION_AND);
	}

	public void setConditionObjectId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectObjectId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionObjectNo(String op, java.lang.String val) {
		setConditionObjectNo(op, val, CONDITION_AND);
	}

	public void setConditionObjectNo(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectObjectNo(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionObjectName(String op, java.lang.String val) {
		setConditionObjectName(op, val, CONDITION_AND);
	}

	public void setConditionObjectName(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectObjectName(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionObjectType(String op, java.lang.Integer val) {
		setConditionObjectType(op, val, CONDITION_AND);
	}

	public void setConditionObjectType(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectObjectType(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionPerformanceMoney(String op, java.math.BigDecimal val) {
		setConditionPerformanceMoney(op, val, CONDITION_AND);
	}

	public void setConditionPerformanceMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectPerformanceMoney(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionPerformanceStatus(String op, java.lang.Integer val) {
		setConditionPerformanceStatus(op, val, CONDITION_AND);
	}

	public void setConditionPerformanceStatus(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectPerformanceStatus(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionBusinessType(String op, java.lang.Integer val) {
		setConditionBusinessType(op, val, CONDITION_AND);
	}

	public void setConditionBusinessType(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectBusinessType(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionBusinessName(String op, java.lang.String val) {
		setConditionBusinessName(op, val, CONDITION_AND);
	}

	public void setConditionBusinessName(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectBusinessName(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionRecordDate(String op, java.util.Date val) {
		setConditionRecordDate(op, val, CONDITION_AND);
	}

	public void setConditionRecordDate(String op, java.util.Date val, String relation) {
		addCondition(10, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordDate(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionRecordTime(String op, java.util.Date val) {
		setConditionRecordTime(op, val, CONDITION_AND);
	}

	public void setConditionRecordTime(String op, java.util.Date val, String relation) {
		addCondition(11, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordTime(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[12] = val;
	}


}

