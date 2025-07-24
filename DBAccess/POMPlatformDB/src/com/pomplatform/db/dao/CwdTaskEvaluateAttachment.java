package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdTaskEvaluateAttachment;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdTaskEvaluateAttachment extends AbstractTable<BaseCwdTaskEvaluateAttachment>
{

	public CwdTaskEvaluateAttachment() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 4;

		initTables();

		__tableName            = "cwd_task_evaluate_attachments";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdTaskEvaluateAttachment.CS_CWD_TASK_EVALUATE_ATTACHMENT_ID;
		__column_names[1] = BaseCwdTaskEvaluateAttachment.CS_CWD_TASK_EVALUATE_ID;
		__column_names[2] = BaseCwdTaskEvaluateAttachment.CS_FILE_ID;
		__column_names[3] = BaseCwdTaskEvaluateAttachment.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdTaskEvaluateAttachment b) {
		clear();
		setCwdTaskEvaluateAttachmentIdClear(b.getCwdTaskEvaluateAttachmentId());
	}

	public boolean isPrimaryKeyNull() {
		return getCwdTaskEvaluateAttachmentId() == null;
	}

	@Override
	public BaseCwdTaskEvaluateAttachment generateBase(){
		BaseCwdTaskEvaluateAttachment b = new BaseCwdTaskEvaluateAttachment();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdTaskEvaluateAttachment b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCwdTaskEvaluateAttachmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCwdTaskEvaluateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdTaskEvaluateAttachment b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCwdTaskEvaluateAttachmentId();
		buff[count++] = b.getCwdTaskEvaluateId();
		buff[count++] = b.getFileId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BaseCwdTaskEvaluateAttachment b){
		if(b.getCwdTaskEvaluateAttachmentId() != null) setCwdTaskEvaluateAttachmentIdClear(b.getCwdTaskEvaluateAttachmentId());
		if(b.getCwdTaskEvaluateId() != null) setCwdTaskEvaluateId(b.getCwdTaskEvaluateId());
		if(b.getFileId() != null) setFileId(b.getFileId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BaseCwdTaskEvaluateAttachment generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdTaskEvaluateAttachment b = new BaseCwdTaskEvaluateAttachment();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdTaskEvaluateAttachment __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdTaskEvaluateAttachmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdTaskEvaluateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setCwdTaskEvaluateAttachmentId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCwdTaskEvaluateAttachmentId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCwdTaskEvaluateAttachmentIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCwdTaskEvaluateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getCwdTaskEvaluateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setFileId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getFileId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setConditionCwdTaskEvaluateAttachmentId(String op, java.lang.Integer val) {
		setConditionCwdTaskEvaluateAttachmentId(op, val, CONDITION_AND);
	}

	public void setConditionCwdTaskEvaluateAttachmentId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCwdTaskEvaluateAttachmentId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCwdTaskEvaluateId(String op, java.lang.Integer val) {
		setConditionCwdTaskEvaluateId(op, val, CONDITION_AND);
	}

	public void setConditionCwdTaskEvaluateId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCwdTaskEvaluateId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionFileId(String op, java.lang.Integer val) {
		setConditionFileId(op, val, CONDITION_AND);
	}

	public void setConditionFileId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectFileId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[3] = val;
	}


}

