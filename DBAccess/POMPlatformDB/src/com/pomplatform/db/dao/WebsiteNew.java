package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseWebsiteNew;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class WebsiteNew extends AbstractTable<BaseWebsiteNew>
{

	public WebsiteNew() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "website_news";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseWebsiteNew.CS_WEBSITE_NEW_ID;
		__column_names[1] = BaseWebsiteNew.CS_TITLE;
		__column_names[2] = BaseWebsiteNew.CS_FILE_URL;
		__column_names[3] = BaseWebsiteNew.CS_CONTENT;
		__column_names[4] = BaseWebsiteNew.CS_CREATE_TIME;
		__column_names[5] = BaseWebsiteNew.CS_NEW_TYPE;
		__column_names[6] = BaseWebsiteNew.CS_DELETE_FLAG;
		__column_names[7] = BaseWebsiteNew.CS_ORDER_NUM;
		__column_names[8] = BaseWebsiteNew.CS_ATTACHMENT_ID;
		__column_names[9] = BaseWebsiteNew.CS_ATTACHMENT_NAME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseWebsiteNew b) {
		clear();
		setWebsiteNewIdClear(b.getWebsiteNewId());
	}

	public boolean isPrimaryKeyNull() {
		return getWebsiteNewId() == null;
	}

	@Override
	public BaseWebsiteNew generateBase(){
		BaseWebsiteNew b = new BaseWebsiteNew();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseWebsiteNew b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setWebsiteNewId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTitle(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFileUrl(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContent(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setNewType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOrderNum(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAttachmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAttachmentName(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseWebsiteNew b, Object[] buff){
		int count = 0;
		buff[count++] = b.getWebsiteNewId();
		buff[count++] = b.getTitle();
		buff[count++] = b.getFileUrl();
		buff[count++] = b.getContent();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getNewType();
		buff[count++] = b.getDeleteFlag();
		buff[count++] = b.getOrderNum();
		buff[count++] = b.getAttachmentId();
		buff[count++] = b.getAttachmentName();
	}

	@Override
	public void setDataFromBase(BaseWebsiteNew b){
		if(b.getWebsiteNewId() != null) setWebsiteNewIdClear(b.getWebsiteNewId());
		if(b.getTitle() != null) setTitle(b.getTitle());
		if(b.getFileUrl() != null) setFileUrl(b.getFileUrl());
		if(b.getContent() != null) setContent(b.getContent());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getNewType() != null) setNewType(b.getNewType());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
		if(b.getOrderNum() != null) setOrderNum(b.getOrderNum());
		if(b.getAttachmentId() != null) setAttachmentId(b.getAttachmentId());
		if(b.getAttachmentName() != null) setAttachmentName(b.getAttachmentName());
	}

	@Override
	public BaseWebsiteNew generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseWebsiteNew b = new BaseWebsiteNew();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseWebsiteNew __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWebsiteNewId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTitle(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileUrl(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContent(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNewType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderNum(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentName(GenericBase.__getString(val));
	}

	public void setWebsiteNewId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getWebsiteNewId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setWebsiteNewIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setTitle(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getTitle() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setFileUrl(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getFileUrl() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setContent(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getContent() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setNewType(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getNewType() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setOrderNum(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getOrderNum() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setAttachmentId(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getAttachmentId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setAttachmentName(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getAttachmentName() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setConditionWebsiteNewId(String op, java.lang.Integer val) {
		setConditionWebsiteNewId(op, val, CONDITION_AND);
	}

	public void setConditionWebsiteNewId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectWebsiteNewId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionTitle(String op, java.lang.String val) {
		setConditionTitle(op, val, CONDITION_AND);
	}

	public void setConditionTitle(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectTitle(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionFileUrl(String op, java.lang.String val) {
		setConditionFileUrl(op, val, CONDITION_AND);
	}

	public void setConditionFileUrl(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectFileUrl(boolean val) {
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

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionNewType(String op, java.lang.Integer val) {
		setConditionNewType(op, val, CONDITION_AND);
	}

	public void setConditionNewType(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectNewType(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionOrderNum(String op, java.lang.Integer val) {
		setConditionOrderNum(op, val, CONDITION_AND);
	}

	public void setConditionOrderNum(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectOrderNum(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionAttachmentId(String op, java.lang.Integer val) {
		setConditionAttachmentId(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentId(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectAttachmentId(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionAttachmentName(String op, java.lang.String val) {
		setConditionAttachmentName(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentName(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectAttachmentName(boolean val) {
		__select_flags[9] = val;
	}


}

