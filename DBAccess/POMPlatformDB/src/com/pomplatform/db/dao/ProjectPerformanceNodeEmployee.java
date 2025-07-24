package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectPerformanceNodeEmployee;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectPerformanceNodeEmployee extends AbstractTable<BaseProjectPerformanceNodeEmployee>
{

	public ProjectPerformanceNodeEmployee() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "project_performance_node_employees";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectPerformanceNodeEmployee.CS_PROJECT_PERFORMANCE_NODE_EMPLOYEE_ID;
		__column_names[1] = BaseProjectPerformanceNodeEmployee.CS_EMPLOYEE_ID;
		__column_names[2] = BaseProjectPerformanceNodeEmployee.CS_EMPLOYEE_NO;
		__column_names[3] = BaseProjectPerformanceNodeEmployee.CS_EMPLOYEE_NAME;
		__column_names[4] = BaseProjectPerformanceNodeEmployee.CS_BUSINESS_TYPE;
		__column_names[5] = BaseProjectPerformanceNodeEmployee.CS_RECORD_TIME;
		__column_names[6] = BaseProjectPerformanceNodeEmployee.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectPerformanceNodeEmployee b) {
		clear();
		setProjectPerformanceNodeEmployeeIdClear(b.getProjectPerformanceNodeEmployeeId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectPerformanceNodeEmployeeId() == null;
	}

	@Override
	public BaseProjectPerformanceNodeEmployee generateBase(){
		BaseProjectPerformanceNodeEmployee b = new BaseProjectPerformanceNodeEmployee();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectPerformanceNodeEmployee b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectPerformanceNodeEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmployeeName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBusinessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRecordTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectPerformanceNodeEmployee b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectPerformanceNodeEmployeeId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getEmployeeNo();
		buff[count++] = b.getEmployeeName();
		buff[count++] = b.getBusinessType();
		buff[count++] = generateTimestampFromDate(b.getRecordTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseProjectPerformanceNodeEmployee b){
		if(b.getProjectPerformanceNodeEmployeeId() != null) setProjectPerformanceNodeEmployeeIdClear(b.getProjectPerformanceNodeEmployeeId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getEmployeeNo() != null) setEmployeeNo(b.getEmployeeNo());
		if(b.getEmployeeName() != null) setEmployeeName(b.getEmployeeName());
		if(b.getBusinessType() != null) setBusinessType(b.getBusinessType());
		if(b.getRecordTime() != null) setRecordTime(b.getRecordTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseProjectPerformanceNodeEmployee generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectPerformanceNodeEmployee b = new BaseProjectPerformanceNodeEmployee();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectPerformanceNodeEmployee __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectPerformanceNodeEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setProjectPerformanceNodeEmployeeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectPerformanceNodeEmployeeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectPerformanceNodeEmployeeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEmployeeNo(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getEmployeeNo() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setEmployeeName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getEmployeeName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setBusinessType(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getBusinessType() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setRecordTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setConditionProjectPerformanceNodeEmployeeId(String op, java.lang.Integer val) {
		setConditionProjectPerformanceNodeEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionProjectPerformanceNodeEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectPerformanceNodeEmployeeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionEmployeeNo(String op, java.lang.String val) {
		setConditionEmployeeNo(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeNo(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectEmployeeNo(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionEmployeeName(String op, java.lang.String val) {
		setConditionEmployeeName(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectEmployeeName(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionBusinessType(String op, java.lang.Integer val) {
		setConditionBusinessType(op, val, CONDITION_AND);
	}

	public void setConditionBusinessType(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectBusinessType(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionRecordTime(String op, java.util.Date val) {
		setConditionRecordTime(op, val, CONDITION_AND);
	}

	public void setConditionRecordTime(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordTime(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[6] = val;
	}


}

