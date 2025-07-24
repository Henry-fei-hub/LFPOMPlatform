package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseAttendanceRule;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class AttendanceRule extends AbstractTable<BaseAttendanceRule>
{

	public AttendanceRule() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 5;

		initTables();

		__tableName            = "attendance_rules";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseAttendanceRule.CS_ATTENDANCE_RULE_ID;
		__column_names[1] = BaseAttendanceRule.CS_RULE_NAME;
		__column_names[2] = BaseAttendanceRule.CS_RULE_TYPE;
		__column_names[3] = BaseAttendanceRule.CS_IS_ENABLE;
		__column_names[4] = BaseAttendanceRule.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseAttendanceRule b) {
		clear();
		setAttendanceRuleIdClear(b.getAttendanceRuleId());
	}

	public boolean isPrimaryKeyNull() {
		return getAttendanceRuleId() == null;
	}

	@Override
	public BaseAttendanceRule generateBase(){
		BaseAttendanceRule b = new BaseAttendanceRule();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseAttendanceRule b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setAttendanceRuleId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRuleName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRuleType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsEnable(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseAttendanceRule b, Object[] buff){
		int count = 0;
		buff[count++] = b.getAttendanceRuleId();
		buff[count++] = b.getRuleName();
		buff[count++] = b.getRuleType();
		buff[count++] = b.getIsEnable();
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseAttendanceRule b){
		if(b.getAttendanceRuleId() != null) setAttendanceRuleIdClear(b.getAttendanceRuleId());
		if(b.getRuleName() != null) setRuleName(b.getRuleName());
		if(b.getRuleType() != null) setRuleType(b.getRuleType());
		if(b.getIsEnable() != null) setIsEnable(b.getIsEnable());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseAttendanceRule generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseAttendanceRule b = new BaseAttendanceRule();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseAttendanceRule __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttendanceRuleId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRuleName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRuleType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsEnable(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setAttendanceRuleId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getAttendanceRuleId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setAttendanceRuleIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setRuleName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getRuleName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setRuleType(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getRuleType() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setIsEnable(java.lang.Boolean val) {
		setCurrentData(3, val);
	}

	public java.lang.Boolean getIsEnable() {
		return GenericBase.__getBoolean(__current_data[3]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setConditionAttendanceRuleId(String op, java.lang.Integer val) {
		setConditionAttendanceRuleId(op, val, CONDITION_AND);
	}

	public void setConditionAttendanceRuleId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectAttendanceRuleId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionRuleName(String op, java.lang.String val) {
		setConditionRuleName(op, val, CONDITION_AND);
	}

	public void setConditionRuleName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectRuleName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionRuleType(String op, java.lang.Integer val) {
		setConditionRuleType(op, val, CONDITION_AND);
	}

	public void setConditionRuleType(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectRuleType(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionIsEnable(String op, java.lang.Boolean val) {
		setConditionIsEnable(op, val, CONDITION_AND);
	}

	public void setConditionIsEnable(String op, java.lang.Boolean val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectIsEnable(boolean val) {
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


}

