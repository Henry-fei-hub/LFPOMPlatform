package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseMeetingRelevance;


public class MeetingRelevance extends AbstractTable<BaseMeetingRelevance>
{

	public MeetingRelevance() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 15;

		initTables();

		__tableName            = "meeting_relevance";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseMeetingRelevance.CS_MEETING_RELEVANCE_ID;
		__column_names[1] = BaseMeetingRelevance.CS_MEETING_ROOM_ID;
		__column_names[2] = BaseMeetingRelevance.CS_EMPLOYEE_ID;
		__column_names[3] = BaseMeetingRelevance.CS_MEETING_ROOM_TIME;
		__column_names[4] = BaseMeetingRelevance.CS_RECORD_DATE;
		__column_names[5] = BaseMeetingRelevance.CS_STATUS;
		__column_names[6] = BaseMeetingRelevance.CS_MEETING_THEME;
		__column_names[7] = BaseMeetingRelevance.CS_START_TIME;
		__column_names[8] = BaseMeetingRelevance.CS_END_TIME;
		__column_names[9] = BaseMeetingRelevance.CS_MEETING_ROOM_NAME;
		__column_names[10] = BaseMeetingRelevance.CS_MEETING_STATUS;
		__column_names[11] = BaseMeetingRelevance.CS_WEEK_TIME;
		__column_names[12] = BaseMeetingRelevance.CS_HOW_MANY_WEEKS;
		__column_names[13] = BaseMeetingRelevance.CS_MEETING_INFO;
		__column_names[14] = BaseMeetingRelevance.CS_MEETING_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseMeetingRelevance b) {
		clear();
		setMeetingRelevanceIdClear(b.getMeetingRelevanceId());
	}

	public boolean isPrimaryKeyNull() {
		return getMeetingRelevanceId() == null;
	}

	@Override
	public BaseMeetingRelevance generateBase(){
		BaseMeetingRelevance b = new BaseMeetingRelevance();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseMeetingRelevance b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setMeetingRelevanceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMeetingRoomId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMeetingRoomTime(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMeetingTheme(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setStartTime(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEndTime(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMeetingRoomName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMeetingStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setWeekTime(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setHowManyWeeks(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMeetingInfo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMeetingTime(GenericBase.__getDateFromSQL(val));
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
			if(val != null && !val.isEmpty()) setMeetingRelevanceId(GenericBase.__getInt(val));
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
			if(val != null && !val.isEmpty()) setMeetingRoomTime(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRecordDate(GenericBase.__getDate(val));
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
			if(val != null && !val.isEmpty()) setStartTime(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEndTime(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMeetingRoomName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMeetingStatus(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setWeekTime(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setHowManyWeeks(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMeetingInfo(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMeetingTime(GenericBase.__getDate(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseMeetingRelevance b, Object[] buff){
		int count = 0;
		buff[count++] = b.getMeetingRelevanceId();
		buff[count++] = b.getMeetingRoomId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getMeetingRoomTime();
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = b.getStatus();
		buff[count++] = b.getMeetingTheme();
		buff[count++] = b.getStartTime();
		buff[count++] = b.getEndTime();
		buff[count++] = b.getMeetingRoomName();
		buff[count++] = b.getMeetingStatus();
		buff[count++] = b.getWeekTime();
		buff[count++] = b.getHowManyWeeks();
		buff[count++] = b.getMeetingInfo();
		buff[count++] = generateTimestampFromDate(b.getMeetingTime());
	}

	@Override
	public void setDataFromBase(BaseMeetingRelevance b){
		if(b.getMeetingRelevanceId() != null) setMeetingRelevanceIdClear(b.getMeetingRelevanceId());
		if(b.getMeetingRoomId() != null) setMeetingRoomId(b.getMeetingRoomId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getMeetingRoomTime() != null) setMeetingRoomTime(b.getMeetingRoomTime());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getMeetingTheme() != null) setMeetingTheme(b.getMeetingTheme());
		if(b.getStartTime() != null) setStartTime(b.getStartTime());
		if(b.getEndTime() != null) setEndTime(b.getEndTime());
		if(b.getMeetingRoomName() != null) setMeetingRoomName(b.getMeetingRoomName());
		if(b.getMeetingStatus() != null) setMeetingStatus(b.getMeetingStatus());
		if(b.getWeekTime() != null) setWeekTime(b.getWeekTime());
		if(b.getHowManyWeeks() != null) setHowManyWeeks(b.getHowManyWeeks());
		if(b.getMeetingInfo() != null) setMeetingInfo(b.getMeetingInfo());
		if(b.getMeetingTime() != null) setMeetingTime(b.getMeetingTime());
	}

	@Override
	public BaseMeetingRelevance generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseMeetingRelevance b = new BaseMeetingRelevance();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseMeetingRelevance __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingRelevanceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingRoomId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingRoomTime(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingTheme(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStartTime(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndTime(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingRoomName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWeekTime(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHowManyWeeks(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingInfo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingTime(GenericBase.__getDateFromSQL(val));
	}

	public void setMeetingRelevanceId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getMeetingRelevanceId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setMeetingRelevanceIdClear(java.lang.Integer val) {
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

	public void setMeetingRoomTime(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getMeetingRoomTime() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setRecordDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setMeetingTheme(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getMeetingTheme() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setStartTime(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getStartTime() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setEndTime(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getEndTime() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setMeetingRoomName(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getMeetingRoomName() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setMeetingStatus(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getMeetingStatus() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setWeekTime(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getWeekTime() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setHowManyWeeks(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getHowManyWeeks() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setMeetingInfo(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getMeetingInfo() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setMeetingTime(java.util.Date val) {
		setCurrentData(14, generateTimestampFromDate(val));
	}

	public java.util.Date getMeetingTime() {
		return GenericBase.__getDateFromSQL(__current_data[14]);
	}

	public void setConditionMeetingRelevanceId(String op, java.lang.Integer val) {
		setConditionMeetingRelevanceId(op, val, CONDITION_AND);
	}

	public void setConditionMeetingRelevanceId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectMeetingRelevanceId(boolean val) {
		__select_flags[0] = val;
	}

	public void setMeetingRelevanceIdExpression(String val) {
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

	public void setConditionMeetingRoomTime(String op, java.lang.String val) {
		setConditionMeetingRoomTime(op, val, CONDITION_AND);
	}

	public void setConditionMeetingRoomTime(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectMeetingRoomTime(boolean val) {
		__select_flags[3] = val;
	}

	public void setMeetingRoomTimeExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionRecordDate(String op, java.util.Date val) {
		setConditionRecordDate(op, val, CONDITION_AND);
	}

	public void setConditionRecordDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setRecordDateExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[5] = val;
	}

	public void setStatusExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionMeetingTheme(String op, java.lang.String val) {
		setConditionMeetingTheme(op, val, CONDITION_AND);
	}

	public void setConditionMeetingTheme(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectMeetingTheme(boolean val) {
		__select_flags[6] = val;
	}

	public void setMeetingThemeExpression(String val) {
		__dataExpressions[6] = val;
	}

	public void setConditionStartTime(String op, java.lang.Integer val) {
		setConditionStartTime(op, val, CONDITION_AND);
	}

	public void setConditionStartTime(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectStartTime(boolean val) {
		__select_flags[7] = val;
	}

	public void setStartTimeExpression(String val) {
		__dataExpressions[7] = val;
	}

	public void setConditionEndTime(String op, java.lang.Integer val) {
		setConditionEndTime(op, val, CONDITION_AND);
	}

	public void setConditionEndTime(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectEndTime(boolean val) {
		__select_flags[8] = val;
	}

	public void setEndTimeExpression(String val) {
		__dataExpressions[8] = val;
	}

	public void setConditionMeetingRoomName(String op, java.lang.String val) {
		setConditionMeetingRoomName(op, val, CONDITION_AND);
	}

	public void setConditionMeetingRoomName(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectMeetingRoomName(boolean val) {
		__select_flags[9] = val;
	}

	public void setMeetingRoomNameExpression(String val) {
		__dataExpressions[9] = val;
	}

	public void setConditionMeetingStatus(String op, java.lang.Integer val) {
		setConditionMeetingStatus(op, val, CONDITION_AND);
	}

	public void setConditionMeetingStatus(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectMeetingStatus(boolean val) {
		__select_flags[10] = val;
	}

	public void setMeetingStatusExpression(String val) {
		__dataExpressions[10] = val;
	}

	public void setConditionWeekTime(String op, java.lang.Integer val) {
		setConditionWeekTime(op, val, CONDITION_AND);
	}

	public void setConditionWeekTime(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectWeekTime(boolean val) {
		__select_flags[11] = val;
	}

	public void setWeekTimeExpression(String val) {
		__dataExpressions[11] = val;
	}

	public void setConditionHowManyWeeks(String op, java.lang.Integer val) {
		setConditionHowManyWeeks(op, val, CONDITION_AND);
	}

	public void setConditionHowManyWeeks(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectHowManyWeeks(boolean val) {
		__select_flags[12] = val;
	}

	public void setHowManyWeeksExpression(String val) {
		__dataExpressions[12] = val;
	}

	public void setConditionMeetingInfo(String op, java.lang.String val) {
		setConditionMeetingInfo(op, val, CONDITION_AND);
	}

	public void setConditionMeetingInfo(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectMeetingInfo(boolean val) {
		__select_flags[13] = val;
	}

	public void setMeetingInfoExpression(String val) {
		__dataExpressions[13] = val;
	}

	public void setConditionMeetingTime(String op, java.util.Date val) {
		setConditionMeetingTime(op, val, CONDITION_AND);
	}

	public void setConditionMeetingTime(String op, java.util.Date val, String relation) {
		addCondition(14, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectMeetingTime(boolean val) {
		__select_flags[14] = val;
	}

	public void setMeetingTimeExpression(String val) {
		__dataExpressions[14] = val;
	}


}

