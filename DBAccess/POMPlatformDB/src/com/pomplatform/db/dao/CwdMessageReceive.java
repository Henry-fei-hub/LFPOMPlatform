package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdMessageReceive;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdMessageReceive extends AbstractTable<BaseCwdMessageReceive>
{

	public CwdMessageReceive() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "cwd_message_receives";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdMessageReceive.CS_MESSAGE_RECEIVE_ID;
		__column_names[1] = BaseCwdMessageReceive.CS_MESSAGE_ID;
		__column_names[2] = BaseCwdMessageReceive.CS_RECEIVER_ID;
		__column_names[3] = BaseCwdMessageReceive.CS_RECEIVER_TYPE;
		__column_names[4] = BaseCwdMessageReceive.CS_READ_STATUS;
		__column_names[5] = BaseCwdMessageReceive.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdMessageReceive b) {
		clear();
		setMessageReceiveIdClear(b.getMessageReceiveId());
	}

	public boolean isPrimaryKeyNull() {
		return getMessageReceiveId() == null;
	}

	@Override
	public BaseCwdMessageReceive generateBase(){
		BaseCwdMessageReceive b = new BaseCwdMessageReceive();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdMessageReceive b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setMessageReceiveId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMessageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReceiverId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReceiverType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReadStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdMessageReceive b, Object[] buff){
		int count = 0;
		buff[count++] = b.getMessageReceiveId();
		buff[count++] = b.getMessageId();
		buff[count++] = b.getReceiverId();
		buff[count++] = b.getReceiverType();
		buff[count++] = b.getReadStatus();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BaseCwdMessageReceive b){
		if(b.getMessageReceiveId() != null) setMessageReceiveIdClear(b.getMessageReceiveId());
		if(b.getMessageId() != null) setMessageId(b.getMessageId());
		if(b.getReceiverId() != null) setReceiverId(b.getReceiverId());
		if(b.getReceiverType() != null) setReceiverType(b.getReceiverType());
		if(b.getReadStatus() != null) setReadStatus(b.getReadStatus());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BaseCwdMessageReceive generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdMessageReceive b = new BaseCwdMessageReceive();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdMessageReceive __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMessageReceiveId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMessageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceiverId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceiverType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReadStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setMessageReceiveId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getMessageReceiveId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setMessageReceiveIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setMessageId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getMessageId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setReceiverId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getReceiverId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setReceiverType(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getReceiverType() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setReadStatus(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getReadStatus() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setConditionMessageReceiveId(String op, java.lang.Integer val) {
		setConditionMessageReceiveId(op, val, CONDITION_AND);
	}

	public void setConditionMessageReceiveId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectMessageReceiveId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionMessageId(String op, java.lang.Integer val) {
		setConditionMessageId(op, val, CONDITION_AND);
	}

	public void setConditionMessageId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectMessageId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionReceiverId(String op, java.lang.Integer val) {
		setConditionReceiverId(op, val, CONDITION_AND);
	}

	public void setConditionReceiverId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectReceiverId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionReceiverType(String op, java.lang.Integer val) {
		setConditionReceiverType(op, val, CONDITION_AND);
	}

	public void setConditionReceiverType(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectReceiverType(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionReadStatus(String op, java.lang.Integer val) {
		setConditionReadStatus(op, val, CONDITION_AND);
	}

	public void setConditionReadStatus(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectReadStatus(boolean val) {
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


}

