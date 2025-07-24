package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseMeetingRoom;


public class MeetingRoom extends AbstractTable<BaseMeetingRoom>
{

	public MeetingRoom() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "meeting_rooms";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseMeetingRoom.CS_MEETING_ROOM_ID;
		__column_names[1] = BaseMeetingRoom.CS_MEETING_ROOM_NAME;
		__column_names[2] = BaseMeetingRoom.CS_SITE;
		__column_names[3] = BaseMeetingRoom.CS_CONTAIN_NUM;
		__column_names[4] = BaseMeetingRoom.CS_COMPANY_RECORD_ID;
		__column_names[5] = BaseMeetingRoom.CS_REMARK;
		__column_names[6] = BaseMeetingRoom.CS_MEETING_ROOM_MASTER;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseMeetingRoom b) {
		clear();
		setMeetingRoomIdClear(b.getMeetingRoomId());
	}

	public boolean isPrimaryKeyNull() {
		return getMeetingRoomId() == null;
	}

	@Override
	public BaseMeetingRoom generateBase(){
		BaseMeetingRoom b = new BaseMeetingRoom();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseMeetingRoom b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setMeetingRoomId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMeetingRoomName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSite(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContainNum(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMeetingRoomMaster(GenericBase.__getString(val));
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
			if(val != null && !val.isEmpty()) setMeetingRoomId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMeetingRoomName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setSite(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setContainNum(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCompanyRecordId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRemark(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMeetingRoomMaster(GenericBase.__getString(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseMeetingRoom b, Object[] buff){
		int count = 0;
		buff[count++] = b.getMeetingRoomId();
		buff[count++] = b.getMeetingRoomName();
		buff[count++] = b.getSite();
		buff[count++] = b.getContainNum();
		buff[count++] = b.getCompanyRecordId();
		buff[count++] = b.getRemark();
		buff[count++] = b.getMeetingRoomMaster();
	}

	@Override
	public void setDataFromBase(BaseMeetingRoom b){
		if(b.getMeetingRoomId() != null) setMeetingRoomIdClear(b.getMeetingRoomId());
		if(b.getMeetingRoomName() != null) setMeetingRoomName(b.getMeetingRoomName());
		if(b.getSite() != null) setSite(b.getSite());
		if(b.getContainNum() != null) setContainNum(b.getContainNum());
		if(b.getCompanyRecordId() != null) setCompanyRecordId(b.getCompanyRecordId());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getMeetingRoomMaster() != null) setMeetingRoomMaster(b.getMeetingRoomMaster());
	}

	@Override
	public BaseMeetingRoom generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseMeetingRoom b = new BaseMeetingRoom();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseMeetingRoom __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingRoomId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingRoomName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSite(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContainNum(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingRoomMaster(GenericBase.__getString(val));
	}

	public void setMeetingRoomId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getMeetingRoomId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setMeetingRoomIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setMeetingRoomName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getMeetingRoomName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setSite(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getSite() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setContainNum(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getContainNum() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setCompanyRecordId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getCompanyRecordId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setMeetingRoomMaster(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getMeetingRoomMaster() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setConditionMeetingRoomId(String op, java.lang.Integer val) {
		setConditionMeetingRoomId(op, val, CONDITION_AND);
	}

	public void setConditionMeetingRoomId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectMeetingRoomId(boolean val) {
		__select_flags[0] = val;
	}

	public void setMeetingRoomIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionMeetingRoomName(String op, java.lang.String val) {
		setConditionMeetingRoomName(op, val, CONDITION_AND);
	}

	public void setConditionMeetingRoomName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectMeetingRoomName(boolean val) {
		__select_flags[1] = val;
	}

	public void setMeetingRoomNameExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionSite(String op, java.lang.String val) {
		setConditionSite(op, val, CONDITION_AND);
	}

	public void setConditionSite(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectSite(boolean val) {
		__select_flags[2] = val;
	}

	public void setSiteExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionContainNum(String op, java.lang.Integer val) {
		setConditionContainNum(op, val, CONDITION_AND);
	}

	public void setConditionContainNum(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectContainNum(boolean val) {
		__select_flags[3] = val;
	}

	public void setContainNumExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionCompanyRecordId(String op, java.lang.Integer val) {
		setConditionCompanyRecordId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCompanyRecordId(boolean val) {
		__select_flags[4] = val;
	}

	public void setCompanyRecordIdExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[5] = val;
	}

	public void setRemarkExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionMeetingRoomMaster(String op, java.lang.String val) {
		setConditionMeetingRoomMaster(op, val, CONDITION_AND);
	}

	public void setConditionMeetingRoomMaster(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectMeetingRoomMaster(boolean val) {
		__select_flags[6] = val;
	}

	public void setMeetingRoomMasterExpression(String val) {
		__dataExpressions[6] = val;
	}


}

