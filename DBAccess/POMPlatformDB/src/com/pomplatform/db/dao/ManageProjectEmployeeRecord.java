package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseManageProjectEmployeeRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ManageProjectEmployeeRecord extends AbstractTable<BaseManageProjectEmployeeRecord>
{

	public ManageProjectEmployeeRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 9;

		initTables();

		__tableName            = "manage_project_employee_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseManageProjectEmployeeRecord.CS_MANAGE_PROJECT_EMPLOYEE_RECORD_ID;
		__column_names[1] = BaseManageProjectEmployeeRecord.CS_MANAGE_PROJECT_ID;
		__column_names[2] = BaseManageProjectEmployeeRecord.CS_EMPLOYEE_ID;
		__column_names[3] = BaseManageProjectEmployeeRecord.CS_ASSIGN_INTEGRAL;
		__column_names[4] = BaseManageProjectEmployeeRecord.CS_ASSIGNED_INTEGRAL;
		__column_names[5] = BaseManageProjectEmployeeRecord.CS_ASSIGN_DATE;
		__column_names[6] = BaseManageProjectEmployeeRecord.CS_OPERATE_EMPLOYEE_ID;
		__column_names[7] = BaseManageProjectEmployeeRecord.CS_REMARK;
		__column_names[8] = BaseManageProjectEmployeeRecord.CS_IS_RETURN;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseManageProjectEmployeeRecord b) {
		clear();
		setManageProjectEmployeeRecordIdClear(b.getManageProjectEmployeeRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getManageProjectEmployeeRecordId() == null;
	}

	@Override
	public BaseManageProjectEmployeeRecord generateBase(){
		BaseManageProjectEmployeeRecord b = new BaseManageProjectEmployeeRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseManageProjectEmployeeRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setManageProjectEmployeeRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setManageProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAssignIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAssignedIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAssignDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsReturn(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseManageProjectEmployeeRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getManageProjectEmployeeRecordId();
		buff[count++] = b.getManageProjectId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getAssignIntegral();
		buff[count++] = b.getAssignedIntegral();
		buff[count++] = generateTimestampFromDate(b.getAssignDate());
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = b.getRemark();
		buff[count++] = b.getIsReturn();
	}

	@Override
	public void setDataFromBase(BaseManageProjectEmployeeRecord b){
		if(b.getManageProjectEmployeeRecordId() != null) setManageProjectEmployeeRecordIdClear(b.getManageProjectEmployeeRecordId());
		if(b.getManageProjectId() != null) setManageProjectId(b.getManageProjectId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getAssignIntegral() != null) setAssignIntegral(b.getAssignIntegral());
		if(b.getAssignedIntegral() != null) setAssignedIntegral(b.getAssignedIntegral());
		if(b.getAssignDate() != null) setAssignDate(b.getAssignDate());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getIsReturn() != null) setIsReturn(b.getIsReturn());
	}

	@Override
	public BaseManageProjectEmployeeRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseManageProjectEmployeeRecord b = new BaseManageProjectEmployeeRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseManageProjectEmployeeRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setManageProjectEmployeeRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setManageProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAssignIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAssignedIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAssignDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsReturn(GenericBase.__getBoolean(val));
	}

	public void setManageProjectEmployeeRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getManageProjectEmployeeRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setManageProjectEmployeeRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setManageProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getManageProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setAssignIntegral(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getAssignIntegral() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setAssignedIntegral(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getAssignedIntegral() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setAssignDate(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getAssignDate() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setIsReturn(java.lang.Boolean val) {
		setCurrentData(8, val);
	}

	public java.lang.Boolean getIsReturn() {
		return GenericBase.__getBoolean(__current_data[8]);
	}

	public void setConditionManageProjectEmployeeRecordId(String op, java.lang.Integer val) {
		setConditionManageProjectEmployeeRecordId(op, val, CONDITION_AND);
	}

	public void setConditionManageProjectEmployeeRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectManageProjectEmployeeRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionManageProjectId(String op, java.lang.Integer val) {
		setConditionManageProjectId(op, val, CONDITION_AND);
	}

	public void setConditionManageProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectManageProjectId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionAssignIntegral(String op, java.math.BigDecimal val) {
		setConditionAssignIntegral(op, val, CONDITION_AND);
	}

	public void setConditionAssignIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectAssignIntegral(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionAssignedIntegral(String op, java.math.BigDecimal val) {
		setConditionAssignedIntegral(op, val, CONDITION_AND);
	}

	public void setConditionAssignedIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectAssignedIntegral(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionAssignDate(String op, java.util.Date val) {
		setConditionAssignDate(op, val, CONDITION_AND);
	}

	public void setConditionAssignDate(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectAssignDate(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionIsReturn(String op, java.lang.Boolean val) {
		setConditionIsReturn(op, val, CONDITION_AND);
	}

	public void setConditionIsReturn(String op, java.lang.Boolean val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectIsReturn(boolean val) {
		__select_flags[8] = val;
	}


}

