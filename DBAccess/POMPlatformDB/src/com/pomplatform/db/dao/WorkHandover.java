package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseWorkHandover;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class WorkHandover extends AbstractTable<BaseWorkHandover>
{

	public WorkHandover() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "work_handovers";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseWorkHandover.CS_WORK_HANDOVER_ID;
		__column_names[1] = BaseWorkHandover.CS_TYPE;
		__column_names[2] = BaseWorkHandover.CS_LINK_ID;
		__column_names[3] = BaseWorkHandover.CS_NAME;
		__column_names[4] = BaseWorkHandover.CS_CONTENT;
		__column_names[5] = BaseWorkHandover.CS_FROM_EMPLOYEE_ID;
		__column_names[6] = BaseWorkHandover.CS_TO_EMPLOYEE_ID;
		__column_names[7] = BaseWorkHandover.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseWorkHandover b) {
		clear();
		setWorkHandoverIdClear(b.getWorkHandoverId());
	}

	public boolean isPrimaryKeyNull() {
		return getWorkHandoverId() == null;
	}

	@Override
	public BaseWorkHandover generateBase(){
		BaseWorkHandover b = new BaseWorkHandover();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseWorkHandover b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setWorkHandoverId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLinkId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContent(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFromEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setToEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseWorkHandover b, Object[] buff){
		int count = 0;
		buff[count++] = b.getWorkHandoverId();
		buff[count++] = b.getType();
		buff[count++] = b.getLinkId();
		buff[count++] = b.getName();
		buff[count++] = b.getContent();
		buff[count++] = b.getFromEmployeeId();
		buff[count++] = b.getToEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BaseWorkHandover b){
		if(b.getWorkHandoverId() != null) setWorkHandoverIdClear(b.getWorkHandoverId());
		if(b.getType() != null) setType(b.getType());
		if(b.getLinkId() != null) setLinkId(b.getLinkId());
		if(b.getName() != null) setName(b.getName());
		if(b.getContent() != null) setContent(b.getContent());
		if(b.getFromEmployeeId() != null) setFromEmployeeId(b.getFromEmployeeId());
		if(b.getToEmployeeId() != null) setToEmployeeId(b.getToEmployeeId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BaseWorkHandover generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseWorkHandover b = new BaseWorkHandover();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseWorkHandover __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkHandoverId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLinkId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContent(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFromEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setToEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setWorkHandoverId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getWorkHandoverId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setWorkHandoverIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setType(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getType() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setLinkId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getLinkId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setContent(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getContent() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setFromEmployeeId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getFromEmployeeId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setToEmployeeId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getToEmployeeId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setConditionWorkHandoverId(String op, java.lang.Integer val) {
		setConditionWorkHandoverId(op, val, CONDITION_AND);
	}

	public void setConditionWorkHandoverId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectWorkHandoverId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionType(String op, java.lang.Integer val) {
		setConditionType(op, val, CONDITION_AND);
	}

	public void setConditionType(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectType(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionLinkId(String op, java.lang.Integer val) {
		setConditionLinkId(op, val, CONDITION_AND);
	}

	public void setConditionLinkId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectLinkId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionName(String op, java.lang.String val) {
		setConditionName(op, val, CONDITION_AND);
	}

	public void setConditionName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectName(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionContent(String op, java.lang.String val) {
		setConditionContent(op, val, CONDITION_AND);
	}

	public void setConditionContent(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectContent(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionFromEmployeeId(String op, java.lang.Integer val) {
		setConditionFromEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionFromEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectFromEmployeeId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionToEmployeeId(String op, java.lang.Integer val) {
		setConditionToEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionToEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectToEmployeeId(boolean val) {
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


}

