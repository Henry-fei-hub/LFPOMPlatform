package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseMeetingDefinition;


public class MeetingDefinition extends AbstractTable<BaseMeetingDefinition>
{

	public MeetingDefinition() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 11;

		initTables();

		__tableName            = "meeting_definitions";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseMeetingDefinition.CS_MEETING_DEFINE_ID;
		__column_names[1] = BaseMeetingDefinition.CS_MEETING_ROOM_NAME;
		__column_names[2] = BaseMeetingDefinition.CS_SITE;
		__column_names[3] = BaseMeetingDefinition.CS_CONTAIN_NUM;
		__column_names[4] = BaseMeetingDefinition.CS_STATUS;
		__column_names[5] = BaseMeetingDefinition.CS_COMPANY_RECORD_ID;
		__column_names[6] = BaseMeetingDefinition.CS_MEETING_ROOM_MASTER;
		__column_names[7] = BaseMeetingDefinition.CS_MIN_APPOINTMENT_TIME;
		__column_names[8] = BaseMeetingDefinition.CS_OVERTIME;
		__column_names[9] = BaseMeetingDefinition.CS_REMIND_TIME;
		__column_names[10] = BaseMeetingDefinition.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
	}

	public void setPrimaryKeyFromBase(BaseMeetingDefinition b) {
		clear();
		setMeetingDefineIdClear(b.getMeetingDefineId());
	}

	public boolean isPrimaryKeyNull() {
		return getMeetingDefineId() == null;
	}

	@Override
	public BaseMeetingDefinition generateBase(){
		BaseMeetingDefinition b = new BaseMeetingDefinition();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseMeetingDefinition b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setMeetingDefineId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMeetingRoomName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSite(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContainNum(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMeetingRoomMaster(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMinAppointmentTime(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOvertime(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemindTime(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
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
			if(val != null && !val.isEmpty()) setMeetingDefineId(GenericBase.__getInt(val));
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
			if(val != null && !val.isEmpty()) setStatus(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCompanyRecordId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMeetingRoomMaster(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMinAppointmentTime(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOvertime(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRemindTime(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRemark(GenericBase.__getString(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseMeetingDefinition b, Object[] buff){
		int count = 0;
		buff[count++] = b.getMeetingDefineId();
		buff[count++] = b.getMeetingRoomName();
		buff[count++] = b.getSite();
		buff[count++] = b.getContainNum();
		buff[count++] = b.getStatus();
		buff[count++] = b.getCompanyRecordId();
		buff[count++] = b.getMeetingRoomMaster();
		buff[count++] = b.getMinAppointmentTime();
		buff[count++] = b.getOvertime();
		buff[count++] = b.getRemindTime();
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseMeetingDefinition b){
		if(b.getMeetingDefineId() != null) setMeetingDefineIdClear(b.getMeetingDefineId());
		if(b.getMeetingRoomName() != null) setMeetingRoomName(b.getMeetingRoomName());
		if(b.getSite() != null) setSite(b.getSite());
		if(b.getContainNum() != null) setContainNum(b.getContainNum());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getCompanyRecordId() != null) setCompanyRecordId(b.getCompanyRecordId());
		if(b.getMeetingRoomMaster() != null) setMeetingRoomMaster(b.getMeetingRoomMaster());
		if(b.getMinAppointmentTime() != null) setMinAppointmentTime(b.getMinAppointmentTime());
		if(b.getOvertime() != null) setOvertime(b.getOvertime());
		if(b.getRemindTime() != null) setRemindTime(b.getRemindTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseMeetingDefinition generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseMeetingDefinition b = new BaseMeetingDefinition();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseMeetingDefinition __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingDefineId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingRoomName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSite(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContainNum(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingRoomMaster(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMinAppointmentTime(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOvertime(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemindTime(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setMeetingDefineId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getMeetingDefineId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setMeetingDefineIdClear(java.lang.Integer val) {
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

	public void setStatus(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCompanyRecordId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getCompanyRecordId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setMeetingRoomMaster(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getMeetingRoomMaster() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setMinAppointmentTime(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getMinAppointmentTime() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setOvertime(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getOvertime() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setRemindTime(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getRemindTime() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setConditionMeetingDefineId(String op, java.lang.Integer val) {
		setConditionMeetingDefineId(op, val, CONDITION_AND);
	}

	public void setConditionMeetingDefineId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectMeetingDefineId(boolean val) {
		__select_flags[0] = val;
	}

	public void setMeetingDefineIdExpression(String val) {
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

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[4] = val;
	}

	public void setStatusExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionCompanyRecordId(String op, java.lang.Integer val) {
		setConditionCompanyRecordId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectCompanyRecordId(boolean val) {
		__select_flags[5] = val;
	}

	public void setCompanyRecordIdExpression(String val) {
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

	public void setConditionMinAppointmentTime(String op, java.lang.Integer val) {
		setConditionMinAppointmentTime(op, val, CONDITION_AND);
	}

	public void setConditionMinAppointmentTime(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectMinAppointmentTime(boolean val) {
		__select_flags[7] = val;
	}

	public void setMinAppointmentTimeExpression(String val) {
		__dataExpressions[7] = val;
	}

	public void setConditionOvertime(String op, java.lang.Integer val) {
		setConditionOvertime(op, val, CONDITION_AND);
	}

	public void setConditionOvertime(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectOvertime(boolean val) {
		__select_flags[8] = val;
	}

	public void setOvertimeExpression(String val) {
		__dataExpressions[8] = val;
	}

	public void setConditionRemindTime(String op, java.lang.Integer val) {
		setConditionRemindTime(op, val, CONDITION_AND);
	}

	public void setConditionRemindTime(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectRemindTime(boolean val) {
		__select_flags[9] = val;
	}

	public void setRemindTimeExpression(String val) {
		__dataExpressions[9] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[10] = val;
	}

	public void setRemarkExpression(String val) {
		__dataExpressions[10] = val;
	}


}

