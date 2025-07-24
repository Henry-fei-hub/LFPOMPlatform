package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseAttachmentManageEmployee;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class AttachmentManageEmployee extends AbstractTable<BaseAttachmentManageEmployee>
{

	public AttachmentManageEmployee() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "attachment_manage_employee";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseAttachmentManageEmployee.CS_ATTACHMENT_MANAGE_EMPLOYEE_ID;
		__column_names[1] = BaseAttachmentManageEmployee.CS_ATTACHMENT_MANAGE_ID;
		__column_names[2] = BaseAttachmentManageEmployee.CS_EMPLOYEE_ID;
		__column_names[3] = BaseAttachmentManageEmployee.CS_EMPLOYEE_TYPE;
		__column_names[4] = BaseAttachmentManageEmployee.CS_OPERATOR;
		__column_names[5] = BaseAttachmentManageEmployee.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseAttachmentManageEmployee b) {
		clear();
		setAttachmentManageEmployeeIdClear(b.getAttachmentManageEmployeeId());
	}

	public boolean isPrimaryKeyNull() {
		return getAttachmentManageEmployeeId() == null;
	}

	@Override
	public BaseAttachmentManageEmployee generateBase(){
		BaseAttachmentManageEmployee b = new BaseAttachmentManageEmployee();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseAttachmentManageEmployee b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setAttachmentManageEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAttachmentManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseAttachmentManageEmployee b, Object[] buff){
		int count = 0;
		buff[count++] = b.getAttachmentManageEmployeeId();
		buff[count++] = b.getAttachmentManageId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getEmployeeType();
		buff[count++] = b.getOperator();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BaseAttachmentManageEmployee b){
		if(b.getAttachmentManageEmployeeId() != null) setAttachmentManageEmployeeIdClear(b.getAttachmentManageEmployeeId());
		if(b.getAttachmentManageId() != null) setAttachmentManageId(b.getAttachmentManageId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getEmployeeType() != null) setEmployeeType(b.getEmployeeType());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BaseAttachmentManageEmployee generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseAttachmentManageEmployee b = new BaseAttachmentManageEmployee();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseAttachmentManageEmployee __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentManageEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setAttachmentManageEmployeeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getAttachmentManageEmployeeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setAttachmentManageEmployeeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setAttachmentManageId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getAttachmentManageId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setEmployeeType(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getEmployeeType() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setConditionAttachmentManageEmployeeId(String op, java.lang.Integer val) {
		setConditionAttachmentManageEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentManageEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectAttachmentManageEmployeeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionAttachmentManageId(String op, java.lang.Integer val) {
		setConditionAttachmentManageId(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentManageId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectAttachmentManageId(boolean val) {
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

	public void setConditionEmployeeType(String op, java.lang.Integer val) {
		setConditionEmployeeType(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeType(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectEmployeeType(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[5] = val;
	}


}

