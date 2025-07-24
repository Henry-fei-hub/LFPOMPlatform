package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseMeetingRoomOrder;


public class MeetingRoomOrder extends AbstractTable<BaseMeetingRoomOrder>
{

	public MeetingRoomOrder() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 13;

		initTables();

		__tableName            = "meeting_room_orders";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseMeetingRoomOrder.CS_MEETING_ROOM_ORDER_ID;
		__column_names[1] = BaseMeetingRoomOrder.CS_MEETING_ROOM_ID;
		__column_names[2] = BaseMeetingRoomOrder.CS_EMPLOYEE_ID;
		__column_names[3] = BaseMeetingRoomOrder.CS_PLATE_ID;
		__column_names[4] = BaseMeetingRoomOrder.CS_DEPARTMENT_ID;
		__column_names[5] = BaseMeetingRoomOrder.CS_RECORD_DATE;
		__column_names[6] = BaseMeetingRoomOrder.CS_MOBILE;
		__column_names[7] = BaseMeetingRoomOrder.CS_MEETING_TITLE;
		__column_names[8] = BaseMeetingRoomOrder.CS_MEETING_MEMBER;
		__column_names[9] = BaseMeetingRoomOrder.CS_MEETING_NUM;
		__column_names[10] = BaseMeetingRoomOrder.CS_STATUS;
		__column_names[11] = BaseMeetingRoomOrder.CS_REMARK;
		__column_names[12] = BaseMeetingRoomOrder.CS_DELETE_FLAG;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseMeetingRoomOrder b) {
		clear();
		setMeetingRoomOrderIdClear(b.getMeetingRoomOrderId());
	}

	public boolean isPrimaryKeyNull() {
		return getMeetingRoomOrderId() == null;
	}

	@Override
	public BaseMeetingRoomOrder generateBase(){
		BaseMeetingRoomOrder b = new BaseMeetingRoomOrder();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseMeetingRoomOrder b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setMeetingRoomOrderId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMeetingRoomId(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setMobile(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMeetingTitle(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMeetingMember(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMeetingNum(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
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
			if(val != null && !val.isEmpty()) setMeetingRoomOrderId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMeetingRoomId(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEmployeeId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPlateId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDepartmentId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRecordDate(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMobile(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMeetingTitle(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMeetingMember(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMeetingNum(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStatus(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRemark(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDeleteFlag(GenericBase.__getInt(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseMeetingRoomOrder b, Object[] buff){
		int count = 0;
		buff[count++] = b.getMeetingRoomOrderId();
		buff[count++] = b.getMeetingRoomId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getDepartmentId();
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = b.getMobile();
		buff[count++] = b.getMeetingTitle();
		buff[count++] = b.getMeetingMember();
		buff[count++] = b.getMeetingNum();
		buff[count++] = b.getStatus();
		buff[count++] = b.getRemark();
		buff[count++] = b.getDeleteFlag();
	}

	@Override
	public void setDataFromBase(BaseMeetingRoomOrder b){
		if(b.getMeetingRoomOrderId() != null) setMeetingRoomOrderIdClear(b.getMeetingRoomOrderId());
		if(b.getMeetingRoomId() != null) setMeetingRoomId(b.getMeetingRoomId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getMobile() != null) setMobile(b.getMobile());
		if(b.getMeetingTitle() != null) setMeetingTitle(b.getMeetingTitle());
		if(b.getMeetingMember() != null) setMeetingMember(b.getMeetingMember());
		if(b.getMeetingNum() != null) setMeetingNum(b.getMeetingNum());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
	}

	@Override
	public BaseMeetingRoomOrder generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseMeetingRoomOrder b = new BaseMeetingRoomOrder();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseMeetingRoomOrder __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingRoomOrderId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingRoomId(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMobile(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingTitle(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingMember(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMeetingNum(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
	}

	public void setMeetingRoomOrderId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getMeetingRoomOrderId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setMeetingRoomOrderIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setMeetingRoomId(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getMeetingRoomId() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setRecordDate(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordDate() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setMobile(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getMobile() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setMeetingTitle(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getMeetingTitle() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setMeetingMember(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getMeetingMember() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setMeetingNum(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getMeetingNum() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setConditionMeetingRoomOrderId(String op, java.lang.Integer val) {
		setConditionMeetingRoomOrderId(op, val, CONDITION_AND);
	}

	public void setConditionMeetingRoomOrderId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectMeetingRoomOrderId(boolean val) {
		__select_flags[0] = val;
	}

	public void setMeetingRoomOrderIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionMeetingRoomId(String op, java.lang.String val) {
		setConditionMeetingRoomId(op, val, CONDITION_AND);
	}

	public void setConditionMeetingRoomId(String op, java.lang.String val, String relation) {
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

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[3] = val;
	}

	public void setPlateIdExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[4] = val;
	}

	public void setDepartmentIdExpression(String val) {
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

	public void setConditionMobile(String op, java.lang.String val) {
		setConditionMobile(op, val, CONDITION_AND);
	}

	public void setConditionMobile(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectMobile(boolean val) {
		__select_flags[6] = val;
	}

	public void setMobileExpression(String val) {
		__dataExpressions[6] = val;
	}

	public void setConditionMeetingTitle(String op, java.lang.String val) {
		setConditionMeetingTitle(op, val, CONDITION_AND);
	}

	public void setConditionMeetingTitle(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectMeetingTitle(boolean val) {
		__select_flags[7] = val;
	}

	public void setMeetingTitleExpression(String val) {
		__dataExpressions[7] = val;
	}

	public void setConditionMeetingMember(String op, java.lang.String val) {
		setConditionMeetingMember(op, val, CONDITION_AND);
	}

	public void setConditionMeetingMember(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectMeetingMember(boolean val) {
		__select_flags[8] = val;
	}

	public void setMeetingMemberExpression(String val) {
		__dataExpressions[8] = val;
	}

	public void setConditionMeetingNum(String op, java.lang.Integer val) {
		setConditionMeetingNum(op, val, CONDITION_AND);
	}

	public void setConditionMeetingNum(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectMeetingNum(boolean val) {
		__select_flags[9] = val;
	}

	public void setMeetingNumExpression(String val) {
		__dataExpressions[9] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[10] = val;
	}

	public void setStatusExpression(String val) {
		__dataExpressions[10] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[11] = val;
	}

	public void setRemarkExpression(String val) {
		__dataExpressions[11] = val;
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[12] = val;
	}

	public void setDeleteFlagExpression(String val) {
		__dataExpressions[12] = val;
	}


}

