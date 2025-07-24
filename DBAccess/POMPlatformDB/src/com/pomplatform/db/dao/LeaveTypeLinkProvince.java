package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseLeaveTypeLinkProvince;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class LeaveTypeLinkProvince extends AbstractTable<BaseLeaveTypeLinkProvince>
{

	public LeaveTypeLinkProvince() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "leave_type_link_provinces";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseLeaveTypeLinkProvince.CS_LEAVE_TYPE_LINK_PROVINCE_ID;
		__column_names[1] = BaseLeaveTypeLinkProvince.CS_LEAVE_TYPE_ID;
		__column_names[2] = BaseLeaveTypeLinkProvince.CS_PROVINCE_ID;
		__column_names[3] = BaseLeaveTypeLinkProvince.CS_DAYS;
		__column_names[4] = BaseLeaveTypeLinkProvince.CS_REMARK;
		__column_names[5] = BaseLeaveTypeLinkProvince.CS_IS_ENABLE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseLeaveTypeLinkProvince b) {
		clear();
		setLeaveTypeLinkProvinceIdClear(b.getLeaveTypeLinkProvinceId());
	}

	public boolean isPrimaryKeyNull() {
		return getLeaveTypeLinkProvinceId() == null;
	}

	@Override
	public BaseLeaveTypeLinkProvince generateBase(){
		BaseLeaveTypeLinkProvince b = new BaseLeaveTypeLinkProvince();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseLeaveTypeLinkProvince b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setLeaveTypeLinkProvinceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLeaveTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProvinceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDays(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsEnable(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseLeaveTypeLinkProvince b, Object[] buff){
		int count = 0;
		buff[count++] = b.getLeaveTypeLinkProvinceId();
		buff[count++] = b.getLeaveTypeId();
		buff[count++] = b.getProvinceId();
		buff[count++] = b.getDays();
		buff[count++] = b.getRemark();
		buff[count++] = b.getIsEnable();
	}

	@Override
	public void setDataFromBase(BaseLeaveTypeLinkProvince b){
		if(b.getLeaveTypeLinkProvinceId() != null) setLeaveTypeLinkProvinceIdClear(b.getLeaveTypeLinkProvinceId());
		if(b.getLeaveTypeId() != null) setLeaveTypeId(b.getLeaveTypeId());
		if(b.getProvinceId() != null) setProvinceId(b.getProvinceId());
		if(b.getDays() != null) setDays(b.getDays());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getIsEnable() != null) setIsEnable(b.getIsEnable());
	}

	@Override
	public BaseLeaveTypeLinkProvince generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseLeaveTypeLinkProvince b = new BaseLeaveTypeLinkProvince();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseLeaveTypeLinkProvince __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLeaveTypeLinkProvinceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLeaveTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProvinceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDays(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsEnable(GenericBase.__getBoolean(val));
	}

	public void setLeaveTypeLinkProvinceId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getLeaveTypeLinkProvinceId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setLeaveTypeLinkProvinceIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setLeaveTypeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getLeaveTypeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setProvinceId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getProvinceId() {
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

	public void setConditionLeaveTypeLinkProvinceId(String op, java.lang.Integer val) {
		setConditionLeaveTypeLinkProvinceId(op, val, CONDITION_AND);
	}

	public void setConditionLeaveTypeLinkProvinceId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectLeaveTypeLinkProvinceId(boolean val) {
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

	public void setConditionProvinceId(String op, java.lang.Integer val) {
		setConditionProvinceId(op, val, CONDITION_AND);
	}

	public void setConditionProvinceId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProvinceId(boolean val) {
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

