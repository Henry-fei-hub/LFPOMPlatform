package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseHolidayBlessManage;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class HolidayBlessManage extends AbstractTable<BaseHolidayBlessManage>
{

	public HolidayBlessManage() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "holiday_bless_manages";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseHolidayBlessManage.CS_HOLIDAY_BLESS_MANAGE_ID;
		__column_names[1] = BaseHolidayBlessManage.CS_HOLIDAY_NAME;
		__column_names[2] = BaseHolidayBlessManage.CS_HOLIDAY_DATE;
		__column_names[3] = BaseHolidayBlessManage.CS_HOLIDAY_TYPE;
		__column_names[4] = BaseHolidayBlessManage.CS_SEND_OBJECT;
		__column_names[5] = BaseHolidayBlessManage.CS_OBJECT_TYPE;
		__column_names[6] = BaseHolidayBlessManage.CS_BLESS_WORDS;
		__column_names[7] = BaseHolidayBlessManage.CS_OPERATE_EMPLOYEE_ID;
		__column_names[8] = BaseHolidayBlessManage.CS_OPERATE_TIME;
		__column_names[9] = BaseHolidayBlessManage.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseHolidayBlessManage b) {
		clear();
		setHolidayBlessManageIdClear(b.getHolidayBlessManageId());
	}

	public boolean isPrimaryKeyNull() {
		return getHolidayBlessManageId() == null;
	}

	@Override
	public BaseHolidayBlessManage generateBase(){
		BaseHolidayBlessManage b = new BaseHolidayBlessManage();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseHolidayBlessManage b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setHolidayBlessManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setHolidayName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setHolidayDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setHolidayType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSendObject(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setObjectType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBlessWords(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseHolidayBlessManage b, Object[] buff){
		int count = 0;
		buff[count++] = b.getHolidayBlessManageId();
		buff[count++] = b.getHolidayName();
		buff[count++] = generateTimestampFromDate(b.getHolidayDate());
		buff[count++] = b.getHolidayType();
		buff[count++] = b.getSendObject();
		buff[count++] = b.getObjectType();
		buff[count++] = b.getBlessWords();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseHolidayBlessManage b){
		if(b.getHolidayBlessManageId() != null) setHolidayBlessManageIdClear(b.getHolidayBlessManageId());
		if(b.getHolidayName() != null) setHolidayName(b.getHolidayName());
		if(b.getHolidayDate() != null) setHolidayDate(b.getHolidayDate());
		if(b.getHolidayType() != null) setHolidayType(b.getHolidayType());
		if(b.getSendObject() != null) setSendObject(b.getSendObject());
		if(b.getObjectType() != null) setObjectType(b.getObjectType());
		if(b.getBlessWords() != null) setBlessWords(b.getBlessWords());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseHolidayBlessManage generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseHolidayBlessManage b = new BaseHolidayBlessManage();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseHolidayBlessManage __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHolidayBlessManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHolidayName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHolidayDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHolidayType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSendObject(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setObjectType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBlessWords(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setHolidayBlessManageId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getHolidayBlessManageId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setHolidayBlessManageIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setHolidayName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getHolidayName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setHolidayDate(java.util.Date val) {
		setCurrentData(2, generateTimestampFromDate(val));
	}

	public java.util.Date getHolidayDate() {
		return GenericBase.__getDateFromSQL(__current_data[2]);
	}

	public void setHolidayType(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getHolidayType() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setSendObject(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getSendObject() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setObjectType(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getObjectType() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setBlessWords(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getBlessWords() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setConditionHolidayBlessManageId(String op, java.lang.Integer val) {
		setConditionHolidayBlessManageId(op, val, CONDITION_AND);
	}

	public void setConditionHolidayBlessManageId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectHolidayBlessManageId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionHolidayName(String op, java.lang.String val) {
		setConditionHolidayName(op, val, CONDITION_AND);
	}

	public void setConditionHolidayName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectHolidayName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionHolidayDate(String op, java.util.Date val) {
		setConditionHolidayDate(op, val, CONDITION_AND);
	}

	public void setConditionHolidayDate(String op, java.util.Date val, String relation) {
		addCondition(2, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectHolidayDate(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionHolidayType(String op, java.lang.Integer val) {
		setConditionHolidayType(op, val, CONDITION_AND);
	}

	public void setConditionHolidayType(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectHolidayType(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionSendObject(String op, java.lang.Integer val) {
		setConditionSendObject(op, val, CONDITION_AND);
	}

	public void setConditionSendObject(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectSendObject(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionObjectType(String op, java.lang.Integer val) {
		setConditionObjectType(op, val, CONDITION_AND);
	}

	public void setConditionObjectType(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectObjectType(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionBlessWords(String op, java.lang.String val) {
		setConditionBlessWords(op, val, CONDITION_AND);
	}

	public void setConditionBlessWords(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectBlessWords(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[9] = val;
	}


}

