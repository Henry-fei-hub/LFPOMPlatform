package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdMessageDetail;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdMessageDetail extends AbstractTable<BaseCwdMessageDetail>
{

	public CwdMessageDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "cwd_message_detail";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdMessageDetail.CS_MESSAGE_DETAIL_ID;
		__column_names[1] = BaseCwdMessageDetail.CS_MESSAGE_ID;
		__column_names[2] = BaseCwdMessageDetail.CS_CONTENT;
		__column_names[3] = BaseCwdMessageDetail.CS_SENDER_ID;
		__column_names[4] = BaseCwdMessageDetail.CS_RECEIVER_ID;
		__column_names[5] = BaseCwdMessageDetail.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdMessageDetail b) {
		clear();
		setMessageDetailIdClear(b.getMessageDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getMessageDetailId() == null;
	}

	@Override
	public BaseCwdMessageDetail generateBase(){
		BaseCwdMessageDetail b = new BaseCwdMessageDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdMessageDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setMessageDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMessageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContent(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSenderId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReceiverId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdMessageDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getMessageDetailId();
		buff[count++] = b.getMessageId();
		buff[count++] = b.getContent();
		buff[count++] = b.getSenderId();
		buff[count++] = b.getReceiverId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BaseCwdMessageDetail b){
		if(b.getMessageDetailId() != null) setMessageDetailIdClear(b.getMessageDetailId());
		if(b.getMessageId() != null) setMessageId(b.getMessageId());
		if(b.getContent() != null) setContent(b.getContent());
		if(b.getSenderId() != null) setSenderId(b.getSenderId());
		if(b.getReceiverId() != null) setReceiverId(b.getReceiverId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BaseCwdMessageDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdMessageDetail b = new BaseCwdMessageDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdMessageDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMessageDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMessageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContent(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSenderId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceiverId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setMessageDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getMessageDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setMessageDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setMessageId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getMessageId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setContent(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getContent() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setSenderId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getSenderId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setReceiverId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getReceiverId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setConditionMessageDetailId(String op, java.lang.Integer val) {
		setConditionMessageDetailId(op, val, CONDITION_AND);
	}

	public void setConditionMessageDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectMessageDetailId(boolean val) {
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

	public void setConditionContent(String op, java.lang.String val) {
		setConditionContent(op, val, CONDITION_AND);
	}

	public void setConditionContent(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectContent(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionSenderId(String op, java.lang.Integer val) {
		setConditionSenderId(op, val, CONDITION_AND);
	}

	public void setConditionSenderId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectSenderId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionReceiverId(String op, java.lang.Integer val) {
		setConditionReceiverId(op, val, CONDITION_AND);
	}

	public void setConditionReceiverId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectReceiverId(boolean val) {
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

