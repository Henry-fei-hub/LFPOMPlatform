package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectLinkAttachmentRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectLinkAttachmentRecord extends AbstractTable<BaseProjectLinkAttachmentRecord>
{

	public ProjectLinkAttachmentRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 17;

		initTables();

		__tableName            = "project_link_attachment_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectLinkAttachmentRecord.CS_PROJECT_LINK_ATTACHMENT_RECORD_ID;
		__column_names[1] = BaseProjectLinkAttachmentRecord.CS_CONTRACT_ID;
		__column_names[2] = BaseProjectLinkAttachmentRecord.CS_PROJECT_ID;
		__column_names[3] = BaseProjectLinkAttachmentRecord.CS_STAGE_ID;
		__column_names[4] = BaseProjectLinkAttachmentRecord.CS_ATTACHMENT_MANAGE_ID;
		__column_names[5] = BaseProjectLinkAttachmentRecord.CS_CONTRACT_CODE;
		__column_names[6] = BaseProjectLinkAttachmentRecord.CS_CONTRACT_NAME;
		__column_names[7] = BaseProjectLinkAttachmentRecord.CS_SHEET_CODE;
		__column_names[8] = BaseProjectLinkAttachmentRecord.CS_SHEET_NAME;
		__column_names[9] = BaseProjectLinkAttachmentRecord.CS_ATTACHMENT_CODE;
		__column_names[10] = BaseProjectLinkAttachmentRecord.CS_ATTACHMENT_NAME;
		__column_names[11] = BaseProjectLinkAttachmentRecord.CS_ATTACHMENT_ADDRESS;
		__column_names[12] = BaseProjectLinkAttachmentRecord.CS_UPLOAD_TIME;
		__column_names[13] = BaseProjectLinkAttachmentRecord.CS_STATUS;
		__column_names[14] = BaseProjectLinkAttachmentRecord.CS_OPERATE_EMPLOYEE_ID;
		__column_names[15] = BaseProjectLinkAttachmentRecord.CS_OPERATE_TIME;
		__column_names[16] = BaseProjectLinkAttachmentRecord.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectLinkAttachmentRecord b) {
		clear();
		setProjectLinkAttachmentRecordIdClear(b.getProjectLinkAttachmentRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectLinkAttachmentRecordId() == null;
	}

	@Override
	public BaseProjectLinkAttachmentRecord generateBase(){
		BaseProjectLinkAttachmentRecord b = new BaseProjectLinkAttachmentRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectLinkAttachmentRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectLinkAttachmentRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAttachmentManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSheetCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSheetName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAttachmentCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAttachmentName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAttachmentAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setUploadTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectLinkAttachmentRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectLinkAttachmentRecordId();
		buff[count++] = b.getContractId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getStageId();
		buff[count++] = b.getAttachmentManageId();
		buff[count++] = b.getContractCode();
		buff[count++] = b.getContractName();
		buff[count++] = b.getSheetCode();
		buff[count++] = b.getSheetName();
		buff[count++] = b.getAttachmentCode();
		buff[count++] = b.getAttachmentName();
		buff[count++] = b.getAttachmentAddress();
		buff[count++] = generateTimestampFromDate(b.getUploadTime());
		buff[count++] = b.getStatus();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseProjectLinkAttachmentRecord b){
		if(b.getProjectLinkAttachmentRecordId() != null) setProjectLinkAttachmentRecordIdClear(b.getProjectLinkAttachmentRecordId());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getStageId() != null) setStageId(b.getStageId());
		if(b.getAttachmentManageId() != null) setAttachmentManageId(b.getAttachmentManageId());
		if(b.getContractCode() != null) setContractCode(b.getContractCode());
		if(b.getContractName() != null) setContractName(b.getContractName());
		if(b.getSheetCode() != null) setSheetCode(b.getSheetCode());
		if(b.getSheetName() != null) setSheetName(b.getSheetName());
		if(b.getAttachmentCode() != null) setAttachmentCode(b.getAttachmentCode());
		if(b.getAttachmentName() != null) setAttachmentName(b.getAttachmentName());
		if(b.getAttachmentAddress() != null) setAttachmentAddress(b.getAttachmentAddress());
		if(b.getUploadTime() != null) setUploadTime(b.getUploadTime());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseProjectLinkAttachmentRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectLinkAttachmentRecord b = new BaseProjectLinkAttachmentRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectLinkAttachmentRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectLinkAttachmentRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSheetCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSheetName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUploadTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setProjectLinkAttachmentRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectLinkAttachmentRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectLinkAttachmentRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setStageId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getStageId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setAttachmentManageId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getAttachmentManageId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setContractCode(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getContractCode() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setContractName(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getContractName() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setSheetCode(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getSheetCode() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setSheetName(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getSheetName() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setAttachmentCode(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getAttachmentCode() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setAttachmentName(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getAttachmentName() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setAttachmentAddress(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getAttachmentAddress() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setUploadTime(java.util.Date val) {
		setCurrentData(12, generateTimestampFromDate(val));
	}

	public java.util.Date getUploadTime() {
		return GenericBase.__getDateFromSQL(__current_data[12]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(15, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[15]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(16, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[16]);
	}

	public void setConditionProjectLinkAttachmentRecordId(String op, java.lang.Integer val) {
		setConditionProjectLinkAttachmentRecordId(op, val, CONDITION_AND);
	}

	public void setConditionProjectLinkAttachmentRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectLinkAttachmentRecordId(boolean val) {
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

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionStageId(String op, java.lang.Integer val) {
		setConditionStageId(op, val, CONDITION_AND);
	}

	public void setConditionStageId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectStageId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionAttachmentManageId(String op, java.lang.Integer val) {
		setConditionAttachmentManageId(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentManageId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectAttachmentManageId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionContractCode(String op, java.lang.String val) {
		setConditionContractCode(op, val, CONDITION_AND);
	}

	public void setConditionContractCode(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectContractCode(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionContractName(String op, java.lang.String val) {
		setConditionContractName(op, val, CONDITION_AND);
	}

	public void setConditionContractName(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectContractName(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionSheetCode(String op, java.lang.String val) {
		setConditionSheetCode(op, val, CONDITION_AND);
	}

	public void setConditionSheetCode(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectSheetCode(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionSheetName(String op, java.lang.String val) {
		setConditionSheetName(op, val, CONDITION_AND);
	}

	public void setConditionSheetName(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectSheetName(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionAttachmentCode(String op, java.lang.String val) {
		setConditionAttachmentCode(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentCode(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectAttachmentCode(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionAttachmentName(String op, java.lang.String val) {
		setConditionAttachmentName(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentName(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectAttachmentName(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionAttachmentAddress(String op, java.lang.String val) {
		setConditionAttachmentAddress(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentAddress(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectAttachmentAddress(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionUploadTime(String op, java.util.Date val) {
		setConditionUploadTime(op, val, CONDITION_AND);
	}

	public void setConditionUploadTime(String op, java.util.Date val, String relation) {
		addCondition(12, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUploadTime(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(15, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[16] = val;
	}


}

