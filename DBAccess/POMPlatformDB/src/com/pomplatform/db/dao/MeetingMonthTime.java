package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseMeetingMonthTime;


public class MeetingMonthTime extends AbstractTable<BaseMeetingMonthTime>
{

	public MeetingMonthTime() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 2;

		initTables();

		__tableName            = "meeting_month_time";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseMeetingMonthTime.CS_MEETING_MONTH_TIME_ID;
		__column_names[1] = BaseMeetingMonthTime.CS_MEETING_MONTH_DATE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseMeetingMonthTime b) {
		clear();
		setMeetingMonthTimeIdClear(b.getMeetingMonthTimeId());
	}

	public boolean isPrimaryKeyNull() {
		return getMeetingMonthTimeId() == null;
	}

	@Override
	public BaseMeetingMonthTime generateBase(){
		BaseMeetingMonthTime b = new BaseMeetingMonthTime();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseMeetingMonthTime b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setMeetingMonthTimeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMeetingMonthDate(GenericBase.__getDateFromSQL(val));
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
			if(val != null && !val.isEmpty()) setMeetingMonthTimeId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMeetingMonthDate(GenericBase.__getDate(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseMeetingMonthTime b, Object[] buff){
		int count = 0;
		buff[count++] = b.getMeetingMonthTimeId();
		buff[count++] = generateTimestampFromDate(b.getMeetingMonthDate());
	}

	@Override
	public void setDataFromBase(BaseMeetingMonthTime b){
		if(b.getMeetingMonthTimeId() != null) setMeetingMonthTimeIdClear(b.getMeetingMonthTimeId());
		if(b.getMeetingMonthDate() != null) setMeetingMonthDate(b.getMeetingMonthDate());
	}

	@Override
	public BaseMeetingMonthTime generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseMeetingMonthTime b = new BaseMeetingMonthTime();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseMeetingMonthTime __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingMonthTimeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingMonthDate(GenericBase.__getDateFromSQL(val));
	}

	public void setMeetingMonthTimeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getMeetingMonthTimeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setMeetingMonthTimeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setMeetingMonthDate(java.util.Date val) {
		setCurrentData(1, generateTimestampFromDate(val));
	}

	public java.util.Date getMeetingMonthDate() {
		return GenericBase.__getDateFromSQL(__current_data[1]);
	}

	public void setConditionMeetingMonthTimeId(String op, java.lang.Integer val) {
		setConditionMeetingMonthTimeId(op, val, CONDITION_AND);
	}

	public void setConditionMeetingMonthTimeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectMeetingMonthTimeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setMeetingMonthTimeIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionMeetingMonthDate(String op, java.util.Date val) {
		setConditionMeetingMonthDate(op, val, CONDITION_AND);
	}

	public void setConditionMeetingMonthDate(String op, java.util.Date val, String relation) {
		addCondition(1, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectMeetingMonthDate(boolean val) {
		__select_flags[1] = val;
	}

	public void setMeetingMonthDateExpression(String val) {
		__dataExpressions[1] = val;
	}


}

