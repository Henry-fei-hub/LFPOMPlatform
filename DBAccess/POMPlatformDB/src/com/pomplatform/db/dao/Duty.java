package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseDuty;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class Duty extends AbstractTable<BaseDuty>
{

	public Duty() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "duties";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseDuty.CS_DUTY_ID;
		__column_names[1] = BaseDuty.CS_DUTY_NAME;
		__column_names[2] = BaseDuty.CS_DESCRIPTION;
		__column_names[3] = BaseDuty.CS_REMARK;
		__column_names[4] = BaseDuty.CS_ORIGINAL_ID;
		__column_names[5] = BaseDuty.CS_PARENT_DUTY_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseDuty b) {
		clear();
		setDutyIdClear(b.getDutyId());
	}

	public boolean isPrimaryKeyNull() {
		return getDutyId() == null;
	}

	@Override
	public BaseDuty generateBase(){
		BaseDuty b = new BaseDuty();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseDuty b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setDutyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDutyName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDescription(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOriginalId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setParentDutyId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseDuty b, Object[] buff){
		int count = 0;
		buff[count++] = b.getDutyId();
		buff[count++] = b.getDutyName();
		buff[count++] = b.getDescription();
		buff[count++] = b.getRemark();
		buff[count++] = b.getOriginalId();
		buff[count++] = b.getParentDutyId();
	}

	@Override
	public void setDataFromBase(BaseDuty b){
		if(b.getDutyId() != null) setDutyIdClear(b.getDutyId());
		if(b.getDutyName() != null) setDutyName(b.getDutyName());
		if(b.getDescription() != null) setDescription(b.getDescription());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getOriginalId() != null) setOriginalId(b.getOriginalId());
		if(b.getParentDutyId() != null) setParentDutyId(b.getParentDutyId());
	}

	@Override
	public BaseDuty generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseDuty b = new BaseDuty();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseDuty __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDutyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDutyName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDescription(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOriginalId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentDutyId(GenericBase.__getInt(val));
	}

	public void setDutyId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getDutyId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setDutyIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setDutyName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getDutyName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setDescription(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getDescription() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setOriginalId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getOriginalId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setParentDutyId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getParentDutyId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setConditionDutyId(String op, java.lang.Integer val) {
		setConditionDutyId(op, val, CONDITION_AND);
	}

	public void setConditionDutyId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectDutyId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionDutyName(String op, java.lang.String val) {
		setConditionDutyName(op, val, CONDITION_AND);
	}

	public void setConditionDutyName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectDutyName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionDescription(String op, java.lang.String val) {
		setConditionDescription(op, val, CONDITION_AND);
	}

	public void setConditionDescription(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectDescription(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionOriginalId(String op, java.lang.Integer val) {
		setConditionOriginalId(op, val, CONDITION_AND);
	}

	public void setConditionOriginalId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectOriginalId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionParentDutyId(String op, java.lang.Integer val) {
		setConditionParentDutyId(op, val, CONDITION_AND);
	}

	public void setConditionParentDutyId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectParentDutyId(boolean val) {
		__select_flags[5] = val;
	}


}

