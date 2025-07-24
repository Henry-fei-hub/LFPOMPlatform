package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseMeeting;


public class Meeting extends AbstractTable<BaseMeeting>
{

	public Meeting() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 16;

		initTables();

		__tableName            = "meetings";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseMeeting.CS_MEETING_RECORD_CHART_ID;
		__column_names[1] = BaseMeeting.CS_MEETING_ROOM_ID;
		__column_names[2] = BaseMeeting.CS_EMPLOYEE_ID;
		__column_names[3] = BaseMeeting.CS_STATUS;
		__column_names[4] = BaseMeeting.CS_MEETING_THEME;
		__column_names[5] = BaseMeeting.CS_RECORD_DATE;
		__column_names[6] = BaseMeeting.CS_MEETING_ROOM_TIME_ID;
		__column_names[7] = BaseMeeting.CS_MEETING_ROOM_TIME;
		__column_names[8] = BaseMeeting.CS_MEETING_RELEVANCE_ID;
		__column_names[9] = BaseMeeting.CS_END_TIME_TWO;
		__column_names[10] = BaseMeeting.CS_MEETING_TIME;
		__column_names[11] = BaseMeeting.CS_MEETING_STATUS;
		__column_names[12] = BaseMeeting.CS_START_TIME;
		__column_names[13] = BaseMeeting.CS_END_TIME;
		__column_names[14] = BaseMeeting.CS_START_TIMES;
		__column_names[15] = BaseMeeting.CS_END_TIMES;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseMeeting b) {
		clear();
		setMeetingRecordChartIdClear(b.getMeetingRecordChartId());
	}

	public boolean isPrimaryKeyNull() {
		return getMeetingRecordChartId() == null;
	}

	@Override
	public BaseMeeting generateBase(){
		BaseMeeting b = new BaseMeeting();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseMeeting b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setMeetingRecordChartId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMeetingRoomId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMeetingTheme(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setMeetingRoomTimeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMeetingRoomTime(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMeetingRelevanceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEndTimeTwo(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMeetingTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setMeetingStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEndTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setStartTimes(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEndTimes(GenericBase.__getInt(val));
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
			if(val != null && !val.isEmpty()) setMeetingRecordChartId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMeetingRoomId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEmployeeId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStatus(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMeetingTheme(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRecordDate(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMeetingRoomTimeId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMeetingRoomTime(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMeetingRelevanceId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEndTimeTwo(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMeetingTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMeetingStatus(GenericBase.__getInt(val));
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
			if(val != null && !val.isEmpty()) setStartTimes(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEndTimes(GenericBase.__getInt(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseMeeting b, Object[] buff){
		int count = 0;
		buff[count++] = b.getMeetingRecordChartId();
		buff[count++] = b.getMeetingRoomId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getStatus();
		buff[count++] = b.getMeetingTheme();
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = b.getMeetingRoomTimeId();
		buff[count++] = b.getMeetingRoomTime();
		buff[count++] = b.getMeetingRelevanceId();
		buff[count++] = b.getEndTimeTwo();
		buff[count++] = generateTimestampFromDate(b.getMeetingTime());
		buff[count++] = b.getMeetingStatus();
		buff[count++] = generateTimestampFromDate(b.getStartTime());
		buff[count++] = generateTimestampFromDate(b.getEndTime());
		buff[count++] = b.getStartTimes();
		buff[count++] = b.getEndTimes();
	}

	@Override
	public void setDataFromBase(BaseMeeting b){
		if(b.getMeetingRecordChartId() != null) setMeetingRecordChartIdClear(b.getMeetingRecordChartId());
		if(b.getMeetingRoomId() != null) setMeetingRoomId(b.getMeetingRoomId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getMeetingTheme() != null) setMeetingTheme(b.getMeetingTheme());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getMeetingRoomTimeId() != null) setMeetingRoomTimeId(b.getMeetingRoomTimeId());
		if(b.getMeetingRoomTime() != null) setMeetingRoomTime(b.getMeetingRoomTime());
		if(b.getMeetingRelevanceId() != null) setMeetingRelevanceId(b.getMeetingRelevanceId());
		if(b.getEndTimeTwo() != null) setEndTimeTwo(b.getEndTimeTwo());
		if(b.getMeetingTime() != null) setMeetingTime(b.getMeetingTime());
		if(b.getMeetingStatus() != null) setMeetingStatus(b.getMeetingStatus());
		if(b.getStartTime() != null) setStartTime(b.getStartTime());
		if(b.getEndTime() != null) setEndTime(b.getEndTime());
		if(b.getStartTimes() != null) setStartTimes(b.getStartTimes());
		if(b.getEndTimes() != null) setEndTimes(b.getEndTimes());
	}

	@Override
	public BaseMeeting generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseMeeting b = new BaseMeeting();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseMeeting __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingRecordChartId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingRoomId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingTheme(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingRoomTimeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingRoomTime(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingRelevanceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndTimeTwo(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStartTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStartTimes(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndTimes(GenericBase.__getInt(val));
	}

	public void setMeetingRecordChartId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getMeetingRecordChartId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setMeetingRecordChartIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setMeetingRoomId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getMeetingRoomId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setMeetingTheme(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getMeetingTheme() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setRecordDate(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordDate() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setMeetingRoomTimeId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getMeetingRoomTimeId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setMeetingRoomTime(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getMeetingRoomTime() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setMeetingRelevanceId(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getMeetingRelevanceId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setEndTimeTwo(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getEndTimeTwo() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setMeetingTime(java.util.Date val) {
		setCurrentData(10, generateTimestampFromDate(val));
	}

	public java.util.Date getMeetingTime() {
		return GenericBase.__getDateFromSQL(__current_data[10]);
	}

	public void setMeetingStatus(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getMeetingStatus() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setStartTime(java.util.Date val) {
		setCurrentData(12, generateTimestampFromDate(val));
	}

	public java.util.Date getStartTime() {
		return GenericBase.__getDateFromSQL(__current_data[12]);
	}

	public void setEndTime(java.util.Date val) {
		setCurrentData(13, generateTimestampFromDate(val));
	}

	public java.util.Date getEndTime() {
		return GenericBase.__getDateFromSQL(__current_data[13]);
	}

	public void setStartTimes(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getStartTimes() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setEndTimes(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getEndTimes() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setConditionMeetingRecordChartId(String op, java.lang.Integer val) {
		setConditionMeetingRecordChartId(op, val, CONDITION_AND);
	}

	public void setConditionMeetingRecordChartId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectMeetingRecordChartId(boolean val) {
		__select_flags[0] = val;
	}

	public void setMeetingRecordChartIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionMeetingRoomId(String op, java.lang.Integer val) {
		setConditionMeetingRoomId(op, val, CONDITION_AND);
	}

	public void setConditionMeetingRoomId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectMeetingRoomId(boolean val) {
		__select_flags[1] = val;
	}

	public void setMeetingRoomIdExpression(String val) {
		__dataExpressions[1] = val;
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

	public void setEmployeeIdExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[3] = val;
	}

	public void setStatusExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionMeetingTheme(String op, java.lang.String val) {
		setConditionMeetingTheme(op, val, CONDITION_AND);
	}

	public void setConditionMeetingTheme(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectMeetingTheme(boolean val) {
		__select_flags[4] = val;
	}

	public void setMeetingThemeExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionRecordDate(String op, java.util.Date val) {
		setConditionRecordDate(op, val, CONDITION_AND);
	}

	public void setConditionRecordDate(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordDate(boolean val) {
		__select_flags[5] = val;
	}

	public void setRecordDateExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionMeetingRoomTimeId(String op, java.lang.Integer val) {
		setConditionMeetingRoomTimeId(op, val, CONDITION_AND);
	}

	public void setConditionMeetingRoomTimeId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectMeetingRoomTimeId(boolean val) {
		__select_flags[6] = val;
	}

	public void setMeetingRoomTimeIdExpression(String val) {
		__dataExpressions[6] = val;
	}

	public void setConditionMeetingRoomTime(String op, java.lang.String val) {
		setConditionMeetingRoomTime(op, val, CONDITION_AND);
	}

	public void setConditionMeetingRoomTime(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectMeetingRoomTime(boolean val) {
		__select_flags[7] = val;
	}

	public void setMeetingRoomTimeExpression(String val) {
		__dataExpressions[7] = val;
	}

	public void setConditionMeetingRelevanceId(String op, java.lang.Integer val) {
		setConditionMeetingRelevanceId(op, val, CONDITION_AND);
	}

	public void setConditionMeetingRelevanceId(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectMeetingRelevanceId(boolean val) {
		__select_flags[8] = val;
	}

	public void setMeetingRelevanceIdExpression(String val) {
		__dataExpressions[8] = val;
	}

	public void setConditionEndTimeTwo(String op, java.lang.Integer val) {
		setConditionEndTimeTwo(op, val, CONDITION_AND);
	}

	public void setConditionEndTimeTwo(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectEndTimeTwo(boolean val) {
		__select_flags[9] = val;
	}

	public void setEndTimeTwoExpression(String val) {
		__dataExpressions[9] = val;
	}

	public void setConditionMeetingTime(String op, java.util.Date val) {
		setConditionMeetingTime(op, val, CONDITION_AND);
	}

	public void setConditionMeetingTime(String op, java.util.Date val, String relation) {
		addCondition(10, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectMeetingTime(boolean val) {
		__select_flags[10] = val;
	}

	public void setMeetingTimeExpression(String val) {
		__dataExpressions[10] = val;
	}

	public void setConditionMeetingStatus(String op, java.lang.Integer val) {
		setConditionMeetingStatus(op, val, CONDITION_AND);
	}

	public void setConditionMeetingStatus(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectMeetingStatus(boolean val) {
		__select_flags[11] = val;
	}

	public void setMeetingStatusExpression(String val) {
		__dataExpressions[11] = val;
	}

	public void setConditionStartTime(String op, java.util.Date val) {
		setConditionStartTime(op, val, CONDITION_AND);
	}

	public void setConditionStartTime(String op, java.util.Date val, String relation) {
		addCondition(12, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectStartTime(boolean val) {
		__select_flags[12] = val;
	}

	public void setStartTimeExpression(String val) {
		__dataExpressions[12] = val;
	}

	public void setConditionEndTime(String op, java.util.Date val) {
		setConditionEndTime(op, val, CONDITION_AND);
	}

	public void setConditionEndTime(String op, java.util.Date val, String relation) {
		addCondition(13, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectEndTime(boolean val) {
		__select_flags[13] = val;
	}

	public void setEndTimeExpression(String val) {
		__dataExpressions[13] = val;
	}

	public void setConditionStartTimes(String op, java.lang.Integer val) {
		setConditionStartTimes(op, val, CONDITION_AND);
	}

	public void setConditionStartTimes(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectStartTimes(boolean val) {
		__select_flags[14] = val;
	}

	public void setStartTimesExpression(String val) {
		__dataExpressions[14] = val;
	}

	public void setConditionEndTimes(String op, java.lang.Integer val) {
		setConditionEndTimes(op, val, CONDITION_AND);
	}

	public void setConditionEndTimes(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectEndTimes(boolean val) {
		__select_flags[15] = val;
	}

	public void setEndTimesExpression(String val) {
		__dataExpressions[15] = val;
	}


}

