package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdMessage;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdMessage extends AbstractTable<BaseCwdMessage>
{

	public CwdMessage() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "cwd_messages";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdMessage.CS_MESSAGE_ID;
		__column_names[1] = BaseCwdMessage.CS_SENDER_ID;
		__column_names[2] = BaseCwdMessage.CS_SENDER_TYPE;
		__column_names[3] = BaseCwdMessage.CS_CONTENT;
		__column_names[4] = BaseCwdMessage.CS_MESSAGE_TYPE;
		__column_names[5] = BaseCwdMessage.CS_CREATE_TIME;
		__column_names[6] = BaseCwdMessage.CS_PRIVACY_TYPE;
		__column_names[7] = BaseCwdMessage.CS_MAIN_PROJECT_ID;
		__column_names[8] = BaseCwdMessage.CS_CWD_TASK_MANAGE_ID;
		__column_names[9] = BaseCwdMessage.CS_CWD_TASK_PROCESS_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdMessage b) {
		clear();
		setMessageIdClear(b.getMessageId());
	}

	public boolean isPrimaryKeyNull() {
		return getMessageId() == null;
	}

	@Override
	public BaseCwdMessage generateBase(){
		BaseCwdMessage b = new BaseCwdMessage();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdMessage b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setMessageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSenderId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSenderType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContent(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMessageType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setPrivacyType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCwdTaskManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCwdTaskProcessId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdMessage b, Object[] buff){
		int count = 0;
		buff[count++] = b.getMessageId();
		buff[count++] = b.getSenderId();
		buff[count++] = b.getSenderType();
		buff[count++] = b.getContent();
		buff[count++] = b.getMessageType();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getPrivacyType();
		buff[count++] = b.getMainProjectId();
		buff[count++] = b.getCwdTaskManageId();
		buff[count++] = b.getCwdTaskProcessId();
	}

	@Override
	public void setDataFromBase(BaseCwdMessage b){
		if(b.getMessageId() != null) setMessageIdClear(b.getMessageId());
		if(b.getSenderId() != null) setSenderId(b.getSenderId());
		if(b.getSenderType() != null) setSenderType(b.getSenderType());
		if(b.getContent() != null) setContent(b.getContent());
		if(b.getMessageType() != null) setMessageType(b.getMessageType());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getPrivacyType() != null) setPrivacyType(b.getPrivacyType());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
		if(b.getCwdTaskManageId() != null) setCwdTaskManageId(b.getCwdTaskManageId());
		if(b.getCwdTaskProcessId() != null) setCwdTaskProcessId(b.getCwdTaskProcessId());
	}

	@Override
	public BaseCwdMessage generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdMessage b = new BaseCwdMessage();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdMessage __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMessageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSenderId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSenderType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContent(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMessageType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPrivacyType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdTaskManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdTaskProcessId(GenericBase.__getInt(val));
	}

	public void setMessageId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getMessageId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setMessageIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setSenderId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getSenderId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setSenderType(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getSenderType() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setContent(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getContent() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setMessageType(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getMessageType() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setPrivacyType(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getPrivacyType() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setCwdTaskManageId(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getCwdTaskManageId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setCwdTaskProcessId(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getCwdTaskProcessId() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setConditionMessageId(String op, java.lang.Integer val) {
		setConditionMessageId(op, val, CONDITION_AND);
	}

	public void setConditionMessageId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectMessageId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionSenderId(String op, java.lang.Integer val) {
		setConditionSenderId(op, val, CONDITION_AND);
	}

	public void setConditionSenderId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectSenderId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionSenderType(String op, java.lang.Integer val) {
		setConditionSenderType(op, val, CONDITION_AND);
	}

	public void setConditionSenderType(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectSenderType(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionContent(String op, java.lang.String val) {
		setConditionContent(op, val, CONDITION_AND);
	}

	public void setConditionContent(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectContent(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionMessageType(String op, java.lang.Integer val) {
		setConditionMessageType(op, val, CONDITION_AND);
	}

	public void setConditionMessageType(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectMessageType(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionPrivacyType(String op, java.lang.Integer val) {
		setConditionPrivacyType(op, val, CONDITION_AND);
	}

	public void setConditionPrivacyType(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectPrivacyType(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val) {
		setConditionMainProjectId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectMainProjectId(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionCwdTaskManageId(String op, java.lang.Integer val) {
		setConditionCwdTaskManageId(op, val, CONDITION_AND);
	}

	public void setConditionCwdTaskManageId(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectCwdTaskManageId(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionCwdTaskProcessId(String op, java.lang.Integer val) {
		setConditionCwdTaskProcessId(op, val, CONDITION_AND);
	}

	public void setConditionCwdTaskProcessId(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectCwdTaskProcessId(boolean val) {
		__select_flags[9] = val;
	}


}

