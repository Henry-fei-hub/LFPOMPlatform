package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseCwdProjectPermission;


public class CwdProjectPermission extends AbstractTable<BaseCwdProjectPermission>
{

	public CwdProjectPermission() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "cwd_project_permissions";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdProjectPermission.CS_CWD_PROJECT_PERMISSION_ID;
		__column_names[1] = BaseCwdProjectPermission.CS_EMPLOYEE_ID;
		__column_names[2] = BaseCwdProjectPermission.CS_PERMISSION_TYPE;
		__column_names[3] = BaseCwdProjectPermission.CS_OPERATE_PERSON;
		__column_names[4] = BaseCwdProjectPermission.CS_CREATE_TIME;
		__column_names[5] = BaseCwdProjectPermission.CS_DELETE_FLAG;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdProjectPermission b) {
		clear();
		setCwdProjectPermissionIdClear(b.getCwdProjectPermissionId());
	}

	public boolean isPrimaryKeyNull() {
		return getCwdProjectPermissionId() == null;
	}

	@Override
	public BaseCwdProjectPermission generateBase(){
		BaseCwdProjectPermission b = new BaseCwdProjectPermission();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdProjectPermission b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCwdProjectPermissionId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPermissionType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperatePerson(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdProjectPermission b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCwdProjectPermissionId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getPermissionType();
		buff[count++] = b.getOperatePerson();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getDeleteFlag();
	}

	@Override
	public void setDataFromBase(BaseCwdProjectPermission b){
		if(b.getCwdProjectPermissionId() != null) setCwdProjectPermissionIdClear(b.getCwdProjectPermissionId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getPermissionType() != null) setPermissionType(b.getPermissionType());
		if(b.getOperatePerson() != null) setOperatePerson(b.getOperatePerson());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
	}

	@Override
	public BaseCwdProjectPermission generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdProjectPermission b = new BaseCwdProjectPermission();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdProjectPermission __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdProjectPermissionId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPermissionType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperatePerson(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
	}

	public void setCwdProjectPermissionId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCwdProjectPermissionId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCwdProjectPermissionIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setPermissionType(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getPermissionType() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setOperatePerson(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getOperatePerson() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setConditionCwdProjectPermissionId(String op, java.lang.Integer val) {
		setConditionCwdProjectPermissionId(op, val, CONDITION_AND);
	}

	public void setConditionCwdProjectPermissionId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCwdProjectPermissionId(boolean val) {
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

	public void setConditionPermissionType(String op, java.lang.Integer val) {
		setConditionPermissionType(op, val, CONDITION_AND);
	}

	public void setConditionPermissionType(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectPermissionType(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionOperatePerson(String op, java.lang.Integer val) {
		setConditionOperatePerson(op, val, CONDITION_AND);
	}

	public void setConditionOperatePerson(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectOperatePerson(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[5] = val;
	}


}

