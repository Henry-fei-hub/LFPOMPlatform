package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseHolidayManage;


public class HolidayManage extends AbstractTable<BaseHolidayManage>
{

	public HolidayManage() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 12;

		initTables();

		__tableName            = "holiday_manages";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseHolidayManage.CS_HOLIDAY_MANAGE_ID;
		__column_names[1] = BaseHolidayManage.CS_NAME;
		__column_names[2] = BaseHolidayManage.CS_YEAR;
		__column_names[3] = BaseHolidayManage.CS_MONTH;
		__column_names[4] = BaseHolidayManage.CS_START_TIME;
		__column_names[5] = BaseHolidayManage.CS_END_TIME;
		__column_names[6] = BaseHolidayManage.CS_RECORD_DATE;
		__column_names[7] = BaseHolidayManage.CS_OPERATE_EMPLOYEE_ID;
		__column_names[8] = BaseHolidayManage.CS_OPERATE_TIME;
		__column_names[9] = BaseHolidayManage.CS_DESCRIPTION;
		__column_names[10] = BaseHolidayManage.CS_IS_WORK_DAY;
		__column_names[11] = BaseHolidayManage.CS_IS_COUNT_OVERTIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseHolidayManage b) {
		clear();
		setHolidayManageIdClear(b.getHolidayManageId());
	}

	public boolean isPrimaryKeyNull() {
		return getHolidayManageId() == null;
	}

	@Override
	public BaseHolidayManage generateBase(){
		BaseHolidayManage b = new BaseHolidayManage();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseHolidayManage b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setHolidayManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEndTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDescription(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsWorkDay(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setIsCountOvertime(GenericBase.__getBoolean(val));
	}

	public void setDataFromCSV(String csvLine){
		setDataFromCSV(csvLine, null);
	}

	public void setDataFromCSV(String csvLine, String names){
		int count = 0; String val;
		Integer num = null;
		setInputNames(names);
		String[] values = JsonParser.csvLine(csvLine, ',');
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setHolidayManageId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setYear(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMonth(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStartTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEndTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRecordDate(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOperateEmployeeId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOperateTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDescription(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIsWorkDay(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIsCountOvertime(GenericBase.__getBoolean(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseHolidayManage b, Object[] buff){
		int count = 0;
		buff[count++] = b.getHolidayManageId();
		buff[count++] = b.getName();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = generateTimestampFromDate(b.getStartTime());
		buff[count++] = generateTimestampFromDate(b.getEndTime());
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getDescription();
		buff[count++] = b.getIsWorkDay();
		buff[count++] = b.getIsCountOvertime();
	}

	@Override
	public void setDataFromBase(BaseHolidayManage b){
		if(b.getHolidayManageId() != null) setHolidayManageIdClear(b.getHolidayManageId());
		if(b.getName() != null) setName(b.getName());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getStartTime() != null) setStartTime(b.getStartTime());
		if(b.getEndTime() != null) setEndTime(b.getEndTime());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getDescription() != null) setDescription(b.getDescription());
		if(b.getIsWorkDay() != null) setIsWorkDay(b.getIsWorkDay());
		if(b.getIsCountOvertime() != null) setIsCountOvertime(b.getIsCountOvertime());
	}

	@Override
	public BaseHolidayManage generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseHolidayManage b = new BaseHolidayManage();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseHolidayManage __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHolidayManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStartTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDescription(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsWorkDay(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsCountOvertime(GenericBase.__getBoolean(val));
	}

	public void setHolidayManageId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getHolidayManageId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setHolidayManageIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setStartTime(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getStartTime() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setEndTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getEndTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setRecordDate(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordDate() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
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

	public void setDescription(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getDescription() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setIsWorkDay(java.lang.Boolean val) {
		setCurrentData(10, val);
	}

	public java.lang.Boolean getIsWorkDay() {
		return GenericBase.__getBoolean(__current_data[10]);
	}

	public void setIsCountOvertime(java.lang.Boolean val) {
		setCurrentData(11, val);
	}

	public java.lang.Boolean getIsCountOvertime() {
		return GenericBase.__getBoolean(__current_data[11]);
	}

	public void setConditionHolidayManageId(String op, java.lang.Integer val) {
		setConditionHolidayManageId(op, val, CONDITION_AND);
	}

	public void setConditionHolidayManageId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectHolidayManageId(boolean val) {
		__select_flags[0] = val;
	}

	public void setHolidayManageIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionName(String op, java.lang.String val) {
		setConditionName(op, val, CONDITION_AND);
	}

	public void setConditionName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectName(boolean val) {
		__select_flags[1] = val;
	}

	public void setNameExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[2] = val;
	}

	public void setYearExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[3] = val;
	}

	public void setMonthExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionStartTime(String op, java.util.Date val) {
		setConditionStartTime(op, val, CONDITION_AND);
	}

	public void setConditionStartTime(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectStartTime(boolean val) {
		__select_flags[4] = val;
	}

	public void setStartTimeExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionEndTime(String op, java.util.Date val) {
		setConditionEndTime(op, val, CONDITION_AND);
	}

	public void setConditionEndTime(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectEndTime(boolean val) {
		__select_flags[5] = val;
	}

	public void setEndTimeExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionRecordDate(String op, java.util.Date val) {
		setConditionRecordDate(op, val, CONDITION_AND);
	}

	public void setConditionRecordDate(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordDate(boolean val) {
		__select_flags[6] = val;
	}

	public void setRecordDateExpression(String val) {
		__dataExpressions[6] = val;
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

	public void setOperateEmployeeIdExpression(String val) {
		__dataExpressions[7] = val;
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

	public void setOperateTimeExpression(String val) {
		__dataExpressions[8] = val;
	}

	public void setConditionDescription(String op, java.lang.String val) {
		setConditionDescription(op, val, CONDITION_AND);
	}

	public void setConditionDescription(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectDescription(boolean val) {
		__select_flags[9] = val;
	}

	public void setDescriptionExpression(String val) {
		__dataExpressions[9] = val;
	}

	public void setConditionIsWorkDay(String op, java.lang.Boolean val) {
		setConditionIsWorkDay(op, val, CONDITION_AND);
	}

	public void setConditionIsWorkDay(String op, java.lang.Boolean val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectIsWorkDay(boolean val) {
		__select_flags[10] = val;
	}

	public void setIsWorkDayExpression(String val) {
		__dataExpressions[10] = val;
	}

	public void setConditionIsCountOvertime(String op, java.lang.Boolean val) {
		setConditionIsCountOvertime(op, val, CONDITION_AND);
	}

	public void setConditionIsCountOvertime(String op, java.lang.Boolean val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectIsCountOvertime(boolean val) {
		__select_flags[11] = val;
	}

	public void setIsCountOvertimeExpression(String val) {
		__dataExpressions[11] = val;
	}


}

