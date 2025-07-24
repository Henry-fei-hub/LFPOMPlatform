package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseMeetingRoomReservationRecord;


public class MeetingRoomReservationRecord extends AbstractTable<BaseMeetingRoomReservationRecord>
{

	public MeetingRoomReservationRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "meeting_room_reservation_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseMeetingRoomReservationRecord.CS_MEETING_ROOM_RESERVATION_RECORD_ID;
		__column_names[1] = BaseMeetingRoomReservationRecord.CS_MEETING_ROOM_ID;
		__column_names[2] = BaseMeetingRoomReservationRecord.CS_MEETING_ROOM_TIME_ID;
		__column_names[3] = BaseMeetingRoomReservationRecord.CS_MEETING_ROOM_TIME;
		__column_names[4] = BaseMeetingRoomReservationRecord.CS_MEETING_DATE;
		__column_names[5] = BaseMeetingRoomReservationRecord.CS_EMPLOYEE_ID;
		__column_names[6] = BaseMeetingRoomReservationRecord.CS_STATUS;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseMeetingRoomReservationRecord b) {
		clear();
		setMeetingRoomReservationRecordIdClear(b.getMeetingRoomReservationRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getMeetingRoomReservationRecordId() == null;
	}

	@Override
	public BaseMeetingRoomReservationRecord generateBase(){
		BaseMeetingRoomReservationRecord b = new BaseMeetingRoomReservationRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseMeetingRoomReservationRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setMeetingRoomReservationRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMeetingRoomId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMeetingRoomTimeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMeetingRoomTime(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMeetingDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
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
			if(val != null && !val.isEmpty()) setMeetingRoomReservationRecordId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMeetingRoomId(GenericBase.__getInt(val));
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
			if(val != null && !val.isEmpty()) setMeetingDate(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEmployeeId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStatus(GenericBase.__getInt(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseMeetingRoomReservationRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getMeetingRoomReservationRecordId();
		buff[count++] = b.getMeetingRoomId();
		buff[count++] = b.getMeetingRoomTimeId();
		buff[count++] = b.getMeetingRoomTime();
		buff[count++] = generateTimestampFromDate(b.getMeetingDate());
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getStatus();
	}

	@Override
	public void setDataFromBase(BaseMeetingRoomReservationRecord b){
		if(b.getMeetingRoomReservationRecordId() != null) setMeetingRoomReservationRecordIdClear(b.getMeetingRoomReservationRecordId());
		if(b.getMeetingRoomId() != null) setMeetingRoomId(b.getMeetingRoomId());
		if(b.getMeetingRoomTimeId() != null) setMeetingRoomTimeId(b.getMeetingRoomTimeId());
		if(b.getMeetingRoomTime() != null) setMeetingRoomTime(b.getMeetingRoomTime());
		if(b.getMeetingDate() != null) setMeetingDate(b.getMeetingDate());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getStatus() != null) setStatus(b.getStatus());
	}

	@Override
	public BaseMeetingRoomReservationRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseMeetingRoomReservationRecord b = new BaseMeetingRoomReservationRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseMeetingRoomReservationRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingRoomReservationRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingRoomId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingRoomTimeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingRoomTime(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
	}

	public void setMeetingRoomReservationRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getMeetingRoomReservationRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setMeetingRoomReservationRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setMeetingRoomId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getMeetingRoomId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setMeetingRoomTimeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getMeetingRoomTimeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setMeetingRoomTime(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getMeetingRoomTime() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setMeetingDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getMeetingDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setConditionMeetingRoomReservationRecordId(String op, java.lang.Integer val) {
		setConditionMeetingRoomReservationRecordId(op, val, CONDITION_AND);
	}

	public void setConditionMeetingRoomReservationRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectMeetingRoomReservationRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setMeetingRoomReservationRecordIdExpression(String val) {
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

	public void setConditionMeetingRoomTimeId(String op, java.lang.Integer val) {
		setConditionMeetingRoomTimeId(op, val, CONDITION_AND);
	}

	public void setConditionMeetingRoomTimeId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectMeetingRoomTimeId(boolean val) {
		__select_flags[2] = val;
	}

	public void setMeetingRoomTimeIdExpression(String val) {
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

	public void setConditionMeetingDate(String op, java.util.Date val) {
		setConditionMeetingDate(op, val, CONDITION_AND);
	}

	public void setConditionMeetingDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectMeetingDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setMeetingDateExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[5] = val;
	}

	public void setEmployeeIdExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[6] = val;
	}

	public void setStatusExpression(String val) {
		__dataExpressions[6] = val;
	}


}

