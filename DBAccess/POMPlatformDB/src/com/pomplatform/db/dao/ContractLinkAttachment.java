package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseContractLinkAttachment;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ContractLinkAttachment extends AbstractTable<BaseContractLinkAttachment>
{

	public ContractLinkAttachment() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "contract_link_attachments";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseContractLinkAttachment.CS_CONTRACT_LINK_ATTACHMENT_ID;
		__column_names[1] = BaseContractLinkAttachment.CS_CONTRACT_ATTACHMENT_ID;
		__column_names[2] = BaseContractLinkAttachment.CS_CONTRACT_ID;
		__column_names[3] = BaseContractLinkAttachment.CS_FILE_ID;
		__column_names[4] = BaseContractLinkAttachment.CS_OPERATE_EMPLOYEE_ID;
		__column_names[5] = BaseContractLinkAttachment.CS_OPERATE_TIME;
		__column_names[6] = BaseContractLinkAttachment.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseContractLinkAttachment b) {
		clear();
		setContractLinkAttachmentIdClear(b.getContractLinkAttachmentId());
	}

	public boolean isPrimaryKeyNull() {
		return getContractLinkAttachmentId() == null;
	}

	@Override
	public BaseContractLinkAttachment generateBase(){
		BaseContractLinkAttachment b = new BaseContractLinkAttachment();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseContractLinkAttachment b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setContractLinkAttachmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractAttachmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseContractLinkAttachment b, Object[] buff){
		int count = 0;
		buff[count++] = b.getContractLinkAttachmentId();
		buff[count++] = b.getContractAttachmentId();
		buff[count++] = b.getContractId();
		buff[count++] = b.getFileId();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseContractLinkAttachment b){
		if(b.getContractLinkAttachmentId() != null) setContractLinkAttachmentIdClear(b.getContractLinkAttachmentId());
		if(b.getContractAttachmentId() != null) setContractAttachmentId(b.getContractAttachmentId());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getFileId() != null) setFileId(b.getFileId());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseContractLinkAttachment generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseContractLinkAttachment b = new BaseContractLinkAttachment();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseContractLinkAttachment __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractLinkAttachmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractAttachmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setContractLinkAttachmentId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getContractLinkAttachmentId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setContractLinkAttachmentIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setContractAttachmentId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getContractAttachmentId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setFileId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getFileId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setConditionContractLinkAttachmentId(String op, java.lang.Integer val) {
		setConditionContractLinkAttachmentId(op, val, CONDITION_AND);
	}

	public void setConditionContractLinkAttachmentId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectContractLinkAttachmentId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionContractAttachmentId(String op, java.lang.Integer val) {
		setConditionContractAttachmentId(op, val, CONDITION_AND);
	}

	public void setConditionContractAttachmentId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectContractAttachmentId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionFileId(String op, java.lang.Integer val) {
		setConditionFileId(op, val, CONDITION_AND);
	}

	public void setConditionFileId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectFileId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[6] = val;
	}


}

