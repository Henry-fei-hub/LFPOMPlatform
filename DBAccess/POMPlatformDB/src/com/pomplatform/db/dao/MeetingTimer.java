package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseMeetingTimer;


public class MeetingTimer extends AbstractTable<BaseMeetingTimer>
{

	public MeetingTimer() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 3;

		initTables();

		__tableName            = "meeting_timers";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseMeetingTimer.CS_MEETING_TIMER_ID;
		__column_names[1] = BaseMeetingTimer.CS_MEETING_ROOM_TIME;
		__column_names[2] = BaseMeetingTimer.CS_TIME_FLAG;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseMeetingTimer b) {
		clear();
		setMeetingTimerIdClear(b.getMeetingTimerId());
	}

	public boolean isPrimaryKeyNull() {
		return getMeetingTimerId() == null;
	}

	@Override
	public BaseMeetingTimer generateBase(){
		BaseMeetingTimer b = new BaseMeetingTimer();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseMeetingTimer b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setMeetingTimerId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMeetingRoomTime(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTimeFlag(GenericBase.__getInt(val));
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
			if(val != null && !val.isEmpty()) setMeetingTimerId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMeetingRoomTime(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setTimeFlag(GenericBase.__getInt(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseMeetingTimer b, Object[] buff){
		int count = 0;
		buff[count++] = b.getMeetingTimerId();
		buff[count++] = b.getMeetingRoomTime();
		buff[count++] = b.getTimeFlag();
	}

	@Override
	public void setDataFromBase(BaseMeetingTimer b){
		if(b.getMeetingTimerId() != null) setMeetingTimerIdClear(b.getMeetingTimerId());
		if(b.getMeetingRoomTime() != null) setMeetingRoomTime(b.getMeetingRoomTime());
		if(b.getTimeFlag() != null) setTimeFlag(b.getTimeFlag());
	}

	@Override
	public BaseMeetingTimer generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseMeetingTimer b = new BaseMeetingTimer();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseMeetingTimer __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingTimerId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingRoomTime(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTimeFlag(GenericBase.__getInt(val));
	}

	public void setMeetingTimerId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getMeetingTimerId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setMeetingTimerIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setMeetingRoomTime(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getMeetingRoomTime() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setTimeFlag(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getTimeFlag() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setConditionMeetingTimerId(String op, java.lang.Integer val) {
		setConditionMeetingTimerId(op, val, CONDITION_AND);
	}

	public void setConditionMeetingTimerId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectMeetingTimerId(boolean val) {
		__select_flags[0] = val;
	}

	public void setMeetingTimerIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionMeetingRoomTime(String op, java.lang.String val) {
		setConditionMeetingRoomTime(op, val, CONDITION_AND);
	}

	public void setConditionMeetingRoomTime(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectMeetingRoomTime(boolean val) {
		__select_flags[1] = val;
	}

	public void setMeetingRoomTimeExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionTimeFlag(String op, java.lang.Integer val) {
		setConditionTimeFlag(op, val, CONDITION_AND);
	}

	public void setConditionTimeFlag(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectTimeFlag(boolean val) {
		__select_flags[2] = val;
	}

	public void setTimeFlagExpression(String val) {
		__dataExpressions[2] = val;
	}


}

