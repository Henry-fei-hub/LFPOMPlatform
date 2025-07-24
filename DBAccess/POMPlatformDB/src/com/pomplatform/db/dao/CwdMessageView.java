package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdMessageView;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdMessageView extends AbstractTable<BaseCwdMessageView>
{

	public CwdMessageView() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 5;

		initTables();

		__tableName            = "cwd_message_views";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdMessageView.CS_MESSAGE_VIEW_ID;
		__column_names[1] = BaseCwdMessageView.CS_MESSAGE_ID;
		__column_names[2] = BaseCwdMessageView.CS_OBSERVER_ID;
		__column_names[3] = BaseCwdMessageView.CS_OBSERVER_TYPE;
		__column_names[4] = BaseCwdMessageView.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdMessageView b) {
		clear();
		setMessageViewIdClear(b.getMessageViewId());
	}

	public boolean isPrimaryKeyNull() {
		return getMessageViewId() == null;
	}

	@Override
	public BaseCwdMessageView generateBase(){
		BaseCwdMessageView b = new BaseCwdMessageView();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdMessageView b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setMessageViewId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMessageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setObserverId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setObserverType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdMessageView b, Object[] buff){
		int count = 0;
		buff[count++] = b.getMessageViewId();
		buff[count++] = b.getMessageId();
		buff[count++] = b.getObserverId();
		buff[count++] = b.getObserverType();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BaseCwdMessageView b){
		if(b.getMessageViewId() != null) setMessageViewIdClear(b.getMessageViewId());
		if(b.getMessageId() != null) setMessageId(b.getMessageId());
		if(b.getObserverId() != null) setObserverId(b.getObserverId());
		if(b.getObserverType() != null) setObserverType(b.getObserverType());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BaseCwdMessageView generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdMessageView b = new BaseCwdMessageView();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdMessageView __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMessageViewId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMessageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setObserverId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setObserverType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setMessageViewId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getMessageViewId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setMessageViewIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setMessageId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getMessageId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setObserverId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getObserverId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setObserverType(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getObserverType() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setConditionMessageViewId(String op, java.lang.Integer val) {
		setConditionMessageViewId(op, val, CONDITION_AND);
	}

	public void setConditionMessageViewId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectMessageViewId(boolean val) {
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

	public void setConditionObserverId(String op, java.lang.Integer val) {
		setConditionObserverId(op, val, CONDITION_AND);
	}

	public void setConditionObserverId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectObserverId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionObserverType(String op, java.lang.Integer val) {
		setConditionObserverType(op, val, CONDITION_AND);
	}

	public void setConditionObserverType(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectObserverType(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[4] = val;
	}


}

