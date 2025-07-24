package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdTaskEmployee;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdTaskEmployee extends AbstractTable<BaseCwdTaskEmployee>
{

	public CwdTaskEmployee() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 9;

		initTables();

		__tableName            = "cwd_task_employees";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdTaskEmployee.CS_CWD_TASK_EMPLOYEE_ID;
		__column_names[1] = BaseCwdTaskEmployee.CS_CWD_TASK_MANAGE_ID;
		__column_names[2] = BaseCwdTaskEmployee.CS_TASK_ROLE;
		__column_names[3] = BaseCwdTaskEmployee.CS_DEPARTMENT_ID;
		__column_names[4] = BaseCwdTaskEmployee.CS_EMPLOYEE_ID;
		__column_names[5] = BaseCwdTaskEmployee.CS_REMARK;
		__column_names[6] = BaseCwdTaskEmployee.CS_OPERATOR;
		__column_names[7] = BaseCwdTaskEmployee.CS_CREATE_TIME;
		__column_names[8] = BaseCwdTaskEmployee.CS_MAIN_PROJECT_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdTaskEmployee b) {
		clear();
		setCwdTaskEmployeeIdClear(b.getCwdTaskEmployeeId());
	}

	public boolean isPrimaryKeyNull() {
		return getCwdTaskEmployeeId() == null;
	}

	@Override
	public BaseCwdTaskEmployee generateBase(){
		BaseCwdTaskEmployee b = new BaseCwdTaskEmployee();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdTaskEmployee b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCwdTaskEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCwdTaskManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTaskRole(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdTaskEmployee b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCwdTaskEmployeeId();
		buff[count++] = b.getCwdTaskManageId();
		buff[count++] = b.getTaskRole();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getRemark();
		buff[count++] = b.getOperator();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getMainProjectId();
	}

	@Override
	public void setDataFromBase(BaseCwdTaskEmployee b){
		if(b.getCwdTaskEmployeeId() != null) setCwdTaskEmployeeIdClear(b.getCwdTaskEmployeeId());
		if(b.getCwdTaskManageId() != null) setCwdTaskManageId(b.getCwdTaskManageId());
		if(b.getTaskRole() != null) setTaskRole(b.getTaskRole());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
	}

	@Override
	public BaseCwdTaskEmployee generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdTaskEmployee b = new BaseCwdTaskEmployee();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdTaskEmployee __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdTaskEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdTaskManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaskRole(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
	}

	public void setCwdTaskEmployeeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCwdTaskEmployeeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCwdTaskEmployeeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCwdTaskManageId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getCwdTaskManageId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setTaskRole(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getTaskRole() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setConditionCwdTaskEmployeeId(String op, java.lang.Integer val) {
		setConditionCwdTaskEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionCwdTaskEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCwdTaskEmployeeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCwdTaskManageId(String op, java.lang.Integer val) {
		setConditionCwdTaskManageId(op, val, CONDITION_AND);
	}

	public void setConditionCwdTaskManageId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCwdTaskManageId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionTaskRole(String op, java.lang.Integer val) {
		setConditionTaskRole(op, val, CONDITION_AND);
	}

	public void setConditionTaskRole(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectTaskRole(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
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

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val) {
		setConditionMainProjectId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectMainProjectId(boolean val) {
		__select_flags[8] = val;
	}


}

