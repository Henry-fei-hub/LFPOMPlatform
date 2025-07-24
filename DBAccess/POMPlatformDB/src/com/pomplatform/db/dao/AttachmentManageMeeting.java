package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseAttachmentManageMeeting;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class AttachmentManageMeeting extends AbstractTable<BaseAttachmentManageMeeting>
{

	public AttachmentManageMeeting() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 17;

		initTables();

		__tableName            = "attachment_manage_meeting";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseAttachmentManageMeeting.CS_ATTACHMENT_MANAGE_MEETING_ID;
		__column_names[1] = BaseAttachmentManageMeeting.CS_CONTRACT_ID;
		__column_names[2] = BaseAttachmentManageMeeting.CS_EXPECT_RETURN_DATE;
		__column_names[3] = BaseAttachmentManageMeeting.CS_NEED_RETURN_AMOUNT;
		__column_names[4] = BaseAttachmentManageMeeting.CS_REMARK;
		__column_names[5] = BaseAttachmentManageMeeting.CS_PUBLISH_DATE;
		__column_names[6] = BaseAttachmentManageMeeting.CS_SUBMIT_DATE;
		__column_names[7] = BaseAttachmentManageMeeting.CS_END_DATE;
		__column_names[8] = BaseAttachmentManageMeeting.CS_METTING_STATUS;
		__column_names[9] = BaseAttachmentManageMeeting.CS_OPERATOR_STATUS;
		__column_names[10] = BaseAttachmentManageMeeting.CS_YEAR;
		__column_names[11] = BaseAttachmentManageMeeting.CS_WORK_NUM;
		__column_names[12] = BaseAttachmentManageMeeting.CS_OPERATOR;
		__column_names[13] = BaseAttachmentManageMeeting.CS_CREATE_TIME;
		__column_names[14] = BaseAttachmentManageMeeting.CS_ATTACHMENT_MANAGE_ID;
		__column_names[15] = BaseAttachmentManageMeeting.CS_PROJECT_MANAGE_ID;
		__column_names[16] = BaseAttachmentManageMeeting.CS_START_DATE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseAttachmentManageMeeting b) {
		clear();
		setAttachmentManageMeetingIdClear(b.getAttachmentManageMeetingId());
	}

	public boolean isPrimaryKeyNull() {
		return getAttachmentManageMeetingId() == null;
	}

	@Override
	public BaseAttachmentManageMeeting generateBase(){
		BaseAttachmentManageMeeting b = new BaseAttachmentManageMeeting();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseAttachmentManageMeeting b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setAttachmentManageMeetingId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setExpectReturnDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setNeedReturnAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPublishDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setSubmitDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setMettingStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperatorStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setWorkNum(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setAttachmentManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStartDate(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseAttachmentManageMeeting b, Object[] buff){
		int count = 0;
		buff[count++] = b.getAttachmentManageMeetingId();
		buff[count++] = b.getContractId();
		buff[count++] = generateTimestampFromDate(b.getExpectReturnDate());
		buff[count++] = b.getNeedReturnAmount();
		buff[count++] = b.getRemark();
		buff[count++] = generateTimestampFromDate(b.getPublishDate());
		buff[count++] = generateTimestampFromDate(b.getSubmitDate());
		buff[count++] = generateTimestampFromDate(b.getEndDate());
		buff[count++] = b.getMettingStatus();
		buff[count++] = b.getOperatorStatus();
		buff[count++] = b.getYear();
		buff[count++] = b.getWorkNum();
		buff[count++] = b.getOperator();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getAttachmentManageId();
		buff[count++] = b.getProjectManageId();
		buff[count++] = generateTimestampFromDate(b.getStartDate());
	}

	@Override
	public void setDataFromBase(BaseAttachmentManageMeeting b){
		if(b.getAttachmentManageMeetingId() != null) setAttachmentManageMeetingIdClear(b.getAttachmentManageMeetingId());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getExpectReturnDate() != null) setExpectReturnDate(b.getExpectReturnDate());
		if(b.getNeedReturnAmount() != null) setNeedReturnAmount(b.getNeedReturnAmount());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getPublishDate() != null) setPublishDate(b.getPublishDate());
		if(b.getSubmitDate() != null) setSubmitDate(b.getSubmitDate());
		if(b.getEndDate() != null) setEndDate(b.getEndDate());
		if(b.getMettingStatus() != null) setMettingStatus(b.getMettingStatus());
		if(b.getOperatorStatus() != null) setOperatorStatus(b.getOperatorStatus());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getWorkNum() != null) setWorkNum(b.getWorkNum());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getAttachmentManageId() != null) setAttachmentManageId(b.getAttachmentManageId());
		if(b.getProjectManageId() != null) setProjectManageId(b.getProjectManageId());
		if(b.getStartDate() != null) setStartDate(b.getStartDate());
	}

	@Override
	public BaseAttachmentManageMeeting generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseAttachmentManageMeeting b = new BaseAttachmentManageMeeting();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseAttachmentManageMeeting __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentManageMeetingId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setExpectReturnDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNeedReturnAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPublishDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubmitDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMettingStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperatorStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkNum(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
	}

	public void setAttachmentManageMeetingId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getAttachmentManageMeetingId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setAttachmentManageMeetingIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setExpectReturnDate(java.util.Date val) {
		setCurrentData(2, generateTimestampFromDate(val));
	}

	public java.util.Date getExpectReturnDate() {
		return GenericBase.__getDateFromSQL(__current_data[2]);
	}

	public void setNeedReturnAmount(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getNeedReturnAmount() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setPublishDate(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getPublishDate() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setSubmitDate(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getSubmitDate() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setEndDate(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getEndDate() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setMettingStatus(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getMettingStatus() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setOperatorStatus(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getOperatorStatus() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setWorkNum(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getWorkNum() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(13, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[13]);
	}

	public void setAttachmentManageId(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getAttachmentManageId() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setProjectManageId(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getProjectManageId() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setStartDate(java.util.Date val) {
		setCurrentData(16, generateTimestampFromDate(val));
	}

	public java.util.Date getStartDate() {
		return GenericBase.__getDateFromSQL(__current_data[16]);
	}

	public void setConditionAttachmentManageMeetingId(String op, java.lang.Integer val) {
		setConditionAttachmentManageMeetingId(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentManageMeetingId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectAttachmentManageMeetingId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionExpectReturnDate(String op, java.util.Date val) {
		setConditionExpectReturnDate(op, val, CONDITION_AND);
	}

	public void setConditionExpectReturnDate(String op, java.util.Date val, String relation) {
		addCondition(2, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectExpectReturnDate(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionNeedReturnAmount(String op, java.math.BigDecimal val) {
		setConditionNeedReturnAmount(op, val, CONDITION_AND);
	}

	public void setConditionNeedReturnAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectNeedReturnAmount(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionPublishDate(String op, java.util.Date val) {
		setConditionPublishDate(op, val, CONDITION_AND);
	}

	public void setConditionPublishDate(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectPublishDate(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionSubmitDate(String op, java.util.Date val) {
		setConditionSubmitDate(op, val, CONDITION_AND);
	}

	public void setConditionSubmitDate(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectSubmitDate(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionEndDate(String op, java.util.Date val) {
		setConditionEndDate(op, val, CONDITION_AND);
	}

	public void setConditionEndDate(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectEndDate(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionMettingStatus(String op, java.lang.Integer val) {
		setConditionMettingStatus(op, val, CONDITION_AND);
	}

	public void setConditionMettingStatus(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectMettingStatus(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionOperatorStatus(String op, java.lang.Integer val) {
		setConditionOperatorStatus(op, val, CONDITION_AND);
	}

	public void setConditionOperatorStatus(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectOperatorStatus(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionWorkNum(String op, java.lang.Integer val) {
		setConditionWorkNum(op, val, CONDITION_AND);
	}

	public void setConditionWorkNum(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectWorkNum(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(13, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionAttachmentManageId(String op, java.lang.Integer val) {
		setConditionAttachmentManageId(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentManageId(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectAttachmentManageId(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionProjectManageId(String op, java.lang.Integer val) {
		setConditionProjectManageId(op, val, CONDITION_AND);
	}

	public void setConditionProjectManageId(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectProjectManageId(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionStartDate(String op, java.util.Date val) {
		setConditionStartDate(op, val, CONDITION_AND);
	}

	public void setConditionStartDate(String op, java.util.Date val, String relation) {
		addCondition(16, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectStartDate(boolean val) {
		__select_flags[16] = val;
	}


}

