package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectManagePerformanceTotal;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectManagePerformanceTotal extends AbstractTable<BaseProjectManagePerformanceTotal>
{

	public ProjectManagePerformanceTotal() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 9;

		initTables();

		__tableName            = "project_manage_performance_totals";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectManagePerformanceTotal.CS_PROJECT_MANAGE_PERFORMANCE_TOTAL_ID;
		__column_names[1] = BaseProjectManagePerformanceTotal.CS_BUSINESS_TYPE;
		__column_names[2] = BaseProjectManagePerformanceTotal.CS_BUSINESS_NAME;
		__column_names[3] = BaseProjectManagePerformanceTotal.CS_PERFORMANCE_MONEY;
		__column_names[4] = BaseProjectManagePerformanceTotal.CS_MAIN_PROJECT_ID;
		__column_names[5] = BaseProjectManagePerformanceTotal.CS_EMPLOYEE_ID;
		__column_names[6] = BaseProjectManagePerformanceTotal.CS_RECORD_DATE;
		__column_names[7] = BaseProjectManagePerformanceTotal.CS_RECORD_TIME;
		__column_names[8] = BaseProjectManagePerformanceTotal.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectManagePerformanceTotal b) {
		clear();
		setProjectManagePerformanceTotalIdClear(b.getProjectManagePerformanceTotalId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectManagePerformanceTotalId() == null;
	}

	@Override
	public BaseProjectManagePerformanceTotal generateBase(){
		BaseProjectManagePerformanceTotal b = new BaseProjectManagePerformanceTotal();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectManagePerformanceTotal b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectManagePerformanceTotalId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPerformanceMoney(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRecordTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectManagePerformanceTotal b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectManagePerformanceTotalId();
		buff[count++] = b.getBusinessType();
		buff[count++] = b.getBusinessName();
		buff[count++] = b.getPerformanceMoney();
		buff[count++] = b.getMainProjectId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = generateTimestampFromDate(b.getRecordTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseProjectManagePerformanceTotal b){
		if(b.getProjectManagePerformanceTotalId() != null) setProjectManagePerformanceTotalIdClear(b.getProjectManagePerformanceTotalId());
		if(b.getBusinessType() != null) setBusinessType(b.getBusinessType());
		if(b.getBusinessName() != null) setBusinessName(b.getBusinessName());
		if(b.getPerformanceMoney() != null) setPerformanceMoney(b.getPerformanceMoney());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getRecordTime() != null) setRecordTime(b.getRecordTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseProjectManagePerformanceTotal generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectManagePerformanceTotal b = new BaseProjectManagePerformanceTotal();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectManagePerformanceTotal __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectManagePerformanceTotalId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPerformanceMoney(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setProjectManagePerformanceTotalId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectManagePerformanceTotalId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectManagePerformanceTotalIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setBusinessType(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getBusinessType() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setBusinessName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getBusinessName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setPerformanceMoney(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getPerformanceMoney() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setRecordDate(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordDate() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setRecordTime(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordTime() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setConditionProjectManagePerformanceTotalId(String op, java.lang.Integer val) {
		setConditionProjectManagePerformanceTotalId(op, val, CONDITION_AND);
	}

	public void setConditionProjectManagePerformanceTotalId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectManagePerformanceTotalId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionBusinessType(String op, java.lang.Integer val) {
		setConditionBusinessType(op, val, CONDITION_AND);
	}

	public void setConditionBusinessType(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectBusinessType(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionBusinessName(String op, java.lang.String val) {
		setConditionBusinessName(op, val, CONDITION_AND);
	}

	public void setConditionBusinessName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectBusinessName(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionPerformanceMoney(String op, java.math.BigDecimal val) {
		setConditionPerformanceMoney(op, val, CONDITION_AND);
	}

	public void setConditionPerformanceMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectPerformanceMoney(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val) {
		setConditionMainProjectId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectMainProjectId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionRecordDate(String op, java.util.Date val) {
		setConditionRecordDate(op, val, CONDITION_AND);
	}

	public void setConditionRecordDate(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordDate(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionRecordTime(String op, java.util.Date val) {
		setConditionRecordTime(op, val, CONDITION_AND);
	}

	public void setConditionRecordTime(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordTime(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[8] = val;
	}


}

