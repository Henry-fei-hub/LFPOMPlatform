package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePmSpecial;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PmSpecial extends AbstractTable<BasePmSpecial>
{

	public PmSpecial() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "pm_specials";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePmSpecial.CS_PM_SPECIAL_ID;
		__column_names[1] = BasePmSpecial.CS_SPECIAL_CODE;
		__column_names[2] = BasePmSpecial.CS_SPECIAL_NAME;
		__column_names[3] = BasePmSpecial.CS_IS_DEL;
		__column_names[4] = BasePmSpecial.CS_OPERATE_EMPLOYEE_ID;
		__column_names[5] = BasePmSpecial.CS_OPERATE_TIME;
		__column_names[6] = BasePmSpecial.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePmSpecial b) {
		clear();
		setPmSpecialIdClear(b.getPmSpecialId());
	}

	public boolean isPrimaryKeyNull() {
		return getPmSpecialId() == null;
	}

	@Override
	public BasePmSpecial generateBase(){
		BasePmSpecial b = new BasePmSpecial();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePmSpecial b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPmSpecialId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSpecialCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSpecialName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsDel(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BasePmSpecial b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPmSpecialId();
		buff[count++] = b.getSpecialCode();
		buff[count++] = b.getSpecialName();
		buff[count++] = b.getIsDel();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BasePmSpecial b){
		if(b.getPmSpecialId() != null) setPmSpecialIdClear(b.getPmSpecialId());
		if(b.getSpecialCode() != null) setSpecialCode(b.getSpecialCode());
		if(b.getSpecialName() != null) setSpecialName(b.getSpecialName());
		if(b.getIsDel() != null) setIsDel(b.getIsDel());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BasePmSpecial generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePmSpecial b = new BasePmSpecial();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePmSpecial __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPmSpecialId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsDel(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setPmSpecialId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPmSpecialId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPmSpecialIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setSpecialCode(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getSpecialCode() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setSpecialName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getSpecialName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setIsDel(java.lang.Boolean val) {
		setCurrentData(3, val);
	}

	public java.lang.Boolean getIsDel() {
		return GenericBase.__getBoolean(__current_data[3]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setConditionPmSpecialId(String op, java.lang.Integer val) {
		setConditionPmSpecialId(op, val, CONDITION_AND);
	}

	public void setConditionPmSpecialId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPmSpecialId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionSpecialCode(String op, java.lang.String val) {
		setConditionSpecialCode(op, val, CONDITION_AND);
	}

	public void setConditionSpecialCode(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectSpecialCode(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionSpecialName(String op, java.lang.String val) {
		setConditionSpecialName(op, val, CONDITION_AND);
	}

	public void setConditionSpecialName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectSpecialName(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionIsDel(String op, java.lang.Boolean val) {
		setConditionIsDel(op, val, CONDITION_AND);
	}

	public void setConditionIsDel(String op, java.lang.Boolean val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectIsDel(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
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

