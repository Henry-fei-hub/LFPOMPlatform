package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseCnResourceAttachment;


public class CnResourceAttachment extends AbstractTable<BaseCnResourceAttachment>
{

	public CnResourceAttachment() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "cn_resource_attachments";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCnResourceAttachment.CS_RESOURCE_ATTACHMENT_ID;
		__column_names[1] = BaseCnResourceAttachment.CS_ATTACHMENT_TYPE;
		__column_names[2] = BaseCnResourceAttachment.CS_RESOURCE_ID;
		__column_names[3] = BaseCnResourceAttachment.CS_FILE_MANAGE_ID;
		__column_names[4] = BaseCnResourceAttachment.CS_CREATE_TIME;
		__column_names[5] = BaseCnResourceAttachment.CS_DELETE_FLAG;
		__column_names[6] = BaseCnResourceAttachment.CS_ORGANIZATION_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCnResourceAttachment b) {
		clear();
		setResourceAttachmentIdClear(b.getResourceAttachmentId());
	}

	public boolean isPrimaryKeyNull() {
		return getResourceAttachmentId() == null;
	}

	@Override
	public BaseCnResourceAttachment generateBase(){
		BaseCnResourceAttachment b = new BaseCnResourceAttachment();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCnResourceAttachment b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setResourceAttachmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAttachmentType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setResourceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOrganizationId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCnResourceAttachment b, Object[] buff){
		int count = 0;
		buff[count++] = b.getResourceAttachmentId();
		buff[count++] = b.getAttachmentType();
		buff[count++] = b.getResourceId();
		buff[count++] = b.getFileManageId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getDeleteFlag();
		buff[count++] = b.getOrganizationId();
	}

	@Override
	public void setDataFromBase(BaseCnResourceAttachment b){
		if(b.getResourceAttachmentId() != null) setResourceAttachmentIdClear(b.getResourceAttachmentId());
		if(b.getAttachmentType() != null) setAttachmentType(b.getAttachmentType());
		if(b.getResourceId() != null) setResourceId(b.getResourceId());
		if(b.getFileManageId() != null) setFileManageId(b.getFileManageId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
		if(b.getOrganizationId() != null) setOrganizationId(b.getOrganizationId());
	}

	@Override
	public BaseCnResourceAttachment generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCnResourceAttachment b = new BaseCnResourceAttachment();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCnResourceAttachment __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setResourceAttachmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setResourceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrganizationId(GenericBase.__getInt(val));
	}

	public void setResourceAttachmentId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getResourceAttachmentId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setResourceAttachmentIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setAttachmentType(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getAttachmentType() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setResourceId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getResourceId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setFileManageId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getFileManageId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setOrganizationId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getOrganizationId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setConditionResourceAttachmentId(String op, java.lang.Integer val) {
		setConditionResourceAttachmentId(op, val, CONDITION_AND);
	}

	public void setConditionResourceAttachmentId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectResourceAttachmentId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionAttachmentType(String op, java.lang.Integer val) {
		setConditionAttachmentType(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentType(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectAttachmentType(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionResourceId(String op, java.lang.Integer val) {
		setConditionResourceId(op, val, CONDITION_AND);
	}

	public void setConditionResourceId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectResourceId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionFileManageId(String op, java.lang.Integer val) {
		setConditionFileManageId(op, val, CONDITION_AND);
	}

	public void setConditionFileManageId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectFileManageId(boolean val) {
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

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionOrganizationId(String op, java.lang.Integer val) {
		setConditionOrganizationId(op, val, CONDITION_AND);
	}

	public void setConditionOrganizationId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectOrganizationId(boolean val) {
		__select_flags[6] = val;
	}


}

