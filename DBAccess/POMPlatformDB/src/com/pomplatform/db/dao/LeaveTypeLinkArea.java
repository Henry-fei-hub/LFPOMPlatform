package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseLeaveTypeLinkArea;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class LeaveTypeLinkArea extends AbstractTable<BaseLeaveTypeLinkArea>
{

	public LeaveTypeLinkArea() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "leave_type_link_areas";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseLeaveTypeLinkArea.CS_LEAVE_TYPE_LINK_AREA_ID;
		__column_names[1] = BaseLeaveTypeLinkArea.CS_LEAVE_TYPE_ID;
		__column_names[2] = BaseLeaveTypeLinkArea.CS_AREA_ID;
		__column_names[3] = BaseLeaveTypeLinkArea.CS_DAYS;
		__column_names[4] = BaseLeaveTypeLinkArea.CS_REMARK;
		__column_names[5] = BaseLeaveTypeLinkArea.CS_IS_ENABLE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseLeaveTypeLinkArea b) {
		clear();
		setLeaveTypeLinkAreaIdClear(b.getLeaveTypeLinkAreaId());
	}

	public boolean isPrimaryKeyNull() {
		return getLeaveTypeLinkAreaId() == null;
	}

	@Override
	public BaseLeaveTypeLinkArea generateBase(){
		BaseLeaveTypeLinkArea b = new BaseLeaveTypeLinkArea();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseLeaveTypeLinkArea b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setLeaveTypeLinkAreaId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLeaveTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAreaId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDays(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsEnable(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseLeaveTypeLinkArea b, Object[] buff){
		int count = 0;
		buff[count++] = b.getLeaveTypeLinkAreaId();
		buff[count++] = b.getLeaveTypeId();
		buff[count++] = b.getAreaId();
		buff[count++] = b.getDays();
		buff[count++] = b.getRemark();
		buff[count++] = b.getIsEnable();
	}

	@Override
	public void setDataFromBase(BaseLeaveTypeLinkArea b){
		if(b.getLeaveTypeLinkAreaId() != null) setLeaveTypeLinkAreaIdClear(b.getLeaveTypeLinkAreaId());
		if(b.getLeaveTypeId() != null) setLeaveTypeId(b.getLeaveTypeId());
		if(b.getAreaId() != null) setAreaId(b.getAreaId());
		if(b.getDays() != null) setDays(b.getDays());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getIsEnable() != null) setIsEnable(b.getIsEnable());
	}

	@Override
	public BaseLeaveTypeLinkArea generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseLeaveTypeLinkArea b = new BaseLeaveTypeLinkArea();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseLeaveTypeLinkArea __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLeaveTypeLinkAreaId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLeaveTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAreaId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDays(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsEnable(GenericBase.__getBoolean(val));
	}

	public void setLeaveTypeLinkAreaId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getLeaveTypeLinkAreaId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setLeaveTypeLinkAreaIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setLeaveTypeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getLeaveTypeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setAreaId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getAreaId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setDays(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getDays() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setIsEnable(java.lang.Boolean val) {
		setCurrentData(5, val);
	}

	public java.lang.Boolean getIsEnable() {
		return GenericBase.__getBoolean(__current_data[5]);
	}

	public void setConditionLeaveTypeLinkAreaId(String op, java.lang.Integer val) {
		setConditionLeaveTypeLinkAreaId(op, val, CONDITION_AND);
	}

	public void setConditionLeaveTypeLinkAreaId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectLeaveTypeLinkAreaId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionLeaveTypeId(String op, java.lang.Integer val) {
		setConditionLeaveTypeId(op, val, CONDITION_AND);
	}

	public void setConditionLeaveTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectLeaveTypeId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionAreaId(String op, java.lang.Integer val) {
		setConditionAreaId(op, val, CONDITION_AND);
	}

	public void setConditionAreaId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectAreaId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionDays(String op, java.math.BigDecimal val) {
		setConditionDays(op, val, CONDITION_AND);
	}

	public void setConditionDays(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectDays(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionIsEnable(String op, java.lang.Boolean val) {
		setConditionIsEnable(op, val, CONDITION_AND);
	}

	public void setConditionIsEnable(String op, java.lang.Boolean val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectIsEnable(boolean val) {
		__select_flags[5] = val;
	}


}

