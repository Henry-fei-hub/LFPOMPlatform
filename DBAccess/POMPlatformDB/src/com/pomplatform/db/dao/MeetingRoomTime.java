package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseMeetingRoomTime;


public class MeetingRoomTime extends AbstractTable<BaseMeetingRoomTime>
{

	public MeetingRoomTime() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 4;

		initTables();

		__tableName            = "meeting_room_times";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseMeetingRoomTime.CS_MEETING_ROOM_TIME_ID;
		__column_names[1] = BaseMeetingRoomTime.CS_MEETING_ROOM_TIME;
		__column_names[2] = BaseMeetingRoomTime.CS_STATUS;
		__column_names[3] = BaseMeetingRoomTime.CS_DELETE_FLAG;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseMeetingRoomTime b) {
		clear();
		setMeetingRoomTimeIdClear(b.getMeetingRoomTimeId());
	}

	public boolean isPrimaryKeyNull() {
		return getMeetingRoomTimeId() == null;
	}

	@Override
	public BaseMeetingRoomTime generateBase(){
		BaseMeetingRoomTime b = new BaseMeetingRoomTime();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseMeetingRoomTime b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setMeetingRoomTimeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMeetingRoomTime(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
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
			if(val != null && !val.isEmpty()) setMeetingRoomTimeId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMeetingRoomTime(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStatus(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDeleteFlag(GenericBase.__getInt(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseMeetingRoomTime b, Object[] buff){
		int count = 0;
		buff[count++] = b.getMeetingRoomTimeId();
		buff[count++] = b.getMeetingRoomTime();
		buff[count++] = b.getStatus();
		buff[count++] = b.getDeleteFlag();
	}

	@Override
	public void setDataFromBase(BaseMeetingRoomTime b){
		if(b.getMeetingRoomTimeId() != null) setMeetingRoomTimeIdClear(b.getMeetingRoomTimeId());
		if(b.getMeetingRoomTime() != null) setMeetingRoomTime(b.getMeetingRoomTime());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
	}

	@Override
	public BaseMeetingRoomTime generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseMeetingRoomTime b = new BaseMeetingRoomTime();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseMeetingRoomTime __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingRoomTimeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingRoomTime(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
	}

	public void setMeetingRoomTimeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getMeetingRoomTimeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setMeetingRoomTimeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setMeetingRoomTime(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getMeetingRoomTime() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setConditionMeetingRoomTimeId(String op, java.lang.Integer val) {
		setConditionMeetingRoomTimeId(op, val, CONDITION_AND);
	}

	public void setConditionMeetingRoomTimeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectMeetingRoomTimeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setMeetingRoomTimeIdExpression(String val) {
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

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[2] = val;
	}

	public void setStatusExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[3] = val;
	}

	public void setDeleteFlagExpression(String val) {
		__dataExpressions[3] = val;
	}


}

