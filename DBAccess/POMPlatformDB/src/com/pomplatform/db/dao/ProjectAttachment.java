package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectAttachment;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectAttachment extends AbstractTable<BaseProjectAttachment>
{

	public ProjectAttachment() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 17;

		initTables();

		__tableName            = "project_attachments";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectAttachment.CS_PROJECT_ATTACHMENT_ID;
		__column_names[1] = BaseProjectAttachment.CS_PROJECT_ID;
		__column_names[2] = BaseProjectAttachment.CS_STAGE_ID;
		__column_names[3] = BaseProjectAttachment.CS_UPLOAD_TIME;
		__column_names[4] = BaseProjectAttachment.CS_ATTACHMENT_FILE;
		__column_names[5] = BaseProjectAttachment.CS_REMARK;
		__column_names[6] = BaseProjectAttachment.CS_IS_HANDLE;
		__column_names[7] = BaseProjectAttachment.CS_IS_SAME_CONTRACT;
		__column_names[8] = BaseProjectAttachment.CS_IS_SAME_STAGE;
		__column_names[9] = BaseProjectAttachment.CS_IS_HAS_SIGN;
		__column_names[10] = BaseProjectAttachment.CS_IS_HAS_SEAL;
		__column_names[11] = BaseProjectAttachment.CS_IS_SURE;
		__column_names[12] = BaseProjectAttachment.CS_IS_QUALIFIED;
		__column_names[13] = BaseProjectAttachment.CS_OPERATE_EMPLOYEE_ID;
		__column_names[14] = BaseProjectAttachment.CS_OPERATE_TIME;
		__column_names[15] = BaseProjectAttachment.CS_IS_EMAIL_SURE;
		__column_names[16] = BaseProjectAttachment.CS_IS_OTHER_SURE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectAttachment b) {
		clear();
		setProjectAttachmentIdClear(b.getProjectAttachmentId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectAttachmentId() == null;
	}

	@Override
	public BaseProjectAttachment generateBase(){
		BaseProjectAttachment b = new BaseProjectAttachment();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectAttachment b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectAttachmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setUploadTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setAttachmentFile(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsHandle(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setIsSameContract(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setIsSameStage(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setIsHasSign(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setIsHasSeal(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setIsSure(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setIsQualified(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setIsEmailSure(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setIsOtherSure(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectAttachment b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectAttachmentId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getStageId();
		buff[count++] = generateTimestampFromDate(b.getUploadTime());
		buff[count++] = b.getAttachmentFile();
		buff[count++] = b.getRemark();
		buff[count++] = b.getIsHandle();
		buff[count++] = b.getIsSameContract();
		buff[count++] = b.getIsSameStage();
		buff[count++] = b.getIsHasSign();
		buff[count++] = b.getIsHasSeal();
		buff[count++] = b.getIsSure();
		buff[count++] = b.getIsQualified();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getIsEmailSure();
		buff[count++] = b.getIsOtherSure();
	}

	@Override
	public void setDataFromBase(BaseProjectAttachment b){
		if(b.getProjectAttachmentId() != null) setProjectAttachmentIdClear(b.getProjectAttachmentId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getStageId() != null) setStageId(b.getStageId());
		if(b.getUploadTime() != null) setUploadTime(b.getUploadTime());
		if(b.getAttachmentFile() != null) setAttachmentFile(b.getAttachmentFile());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getIsHandle() != null) setIsHandle(b.getIsHandle());
		if(b.getIsSameContract() != null) setIsSameContract(b.getIsSameContract());
		if(b.getIsSameStage() != null) setIsSameStage(b.getIsSameStage());
		if(b.getIsHasSign() != null) setIsHasSign(b.getIsHasSign());
		if(b.getIsHasSeal() != null) setIsHasSeal(b.getIsHasSeal());
		if(b.getIsSure() != null) setIsSure(b.getIsSure());
		if(b.getIsQualified() != null) setIsQualified(b.getIsQualified());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getIsEmailSure() != null) setIsEmailSure(b.getIsEmailSure());
		if(b.getIsOtherSure() != null) setIsOtherSure(b.getIsOtherSure());
	}

	@Override
	public BaseProjectAttachment generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectAttachment b = new BaseProjectAttachment();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectAttachment __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectAttachmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUploadTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentFile(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsHandle(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsSameContract(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsSameStage(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsHasSign(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsHasSeal(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsSure(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsQualified(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsEmailSure(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsOtherSure(GenericBase.__getBoolean(val));
	}

	public void setProjectAttachmentId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectAttachmentId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectAttachmentIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setStageId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getStageId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setUploadTime(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getUploadTime() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setAttachmentFile(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getAttachmentFile() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setIsHandle(java.lang.Boolean val) {
		setCurrentData(6, val);
	}

	public java.lang.Boolean getIsHandle() {
		return GenericBase.__getBoolean(__current_data[6]);
	}

	public void setIsSameContract(java.lang.Boolean val) {
		setCurrentData(7, val);
	}

	public java.lang.Boolean getIsSameContract() {
		return GenericBase.__getBoolean(__current_data[7]);
	}

	public void setIsSameStage(java.lang.Boolean val) {
		setCurrentData(8, val);
	}

	public java.lang.Boolean getIsSameStage() {
		return GenericBase.__getBoolean(__current_data[8]);
	}

	public void setIsHasSign(java.lang.Boolean val) {
		setCurrentData(9, val);
	}

	public java.lang.Boolean getIsHasSign() {
		return GenericBase.__getBoolean(__current_data[9]);
	}

	public void setIsHasSeal(java.lang.Boolean val) {
		setCurrentData(10, val);
	}

	public java.lang.Boolean getIsHasSeal() {
		return GenericBase.__getBoolean(__current_data[10]);
	}

	public void setIsSure(java.lang.Boolean val) {
		setCurrentData(11, val);
	}

	public java.lang.Boolean getIsSure() {
		return GenericBase.__getBoolean(__current_data[11]);
	}

	public void setIsQualified(java.lang.Boolean val) {
		setCurrentData(12, val);
	}

	public java.lang.Boolean getIsQualified() {
		return GenericBase.__getBoolean(__current_data[12]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(14, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[14]);
	}

	public void setIsEmailSure(java.lang.Boolean val) {
		setCurrentData(15, val);
	}

	public java.lang.Boolean getIsEmailSure() {
		return GenericBase.__getBoolean(__current_data[15]);
	}

	public void setIsOtherSure(java.lang.Boolean val) {
		setCurrentData(16, val);
	}

	public java.lang.Boolean getIsOtherSure() {
		return GenericBase.__getBoolean(__current_data[16]);
	}

	public void setConditionProjectAttachmentId(String op, java.lang.Integer val) {
		setConditionProjectAttachmentId(op, val, CONDITION_AND);
	}

	public void setConditionProjectAttachmentId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectAttachmentId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionStageId(String op, java.lang.Integer val) {
		setConditionStageId(op, val, CONDITION_AND);
	}

	public void setConditionStageId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectStageId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionUploadTime(String op, java.util.Date val) {
		setConditionUploadTime(op, val, CONDITION_AND);
	}

	public void setConditionUploadTime(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUploadTime(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionAttachmentFile(String op, java.lang.String val) {
		setConditionAttachmentFile(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentFile(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectAttachmentFile(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionIsHandle(String op, java.lang.Boolean val) {
		setConditionIsHandle(op, val, CONDITION_AND);
	}

	public void setConditionIsHandle(String op, java.lang.Boolean val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectIsHandle(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionIsSameContract(String op, java.lang.Boolean val) {
		setConditionIsSameContract(op, val, CONDITION_AND);
	}

	public void setConditionIsSameContract(String op, java.lang.Boolean val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectIsSameContract(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionIsSameStage(String op, java.lang.Boolean val) {
		setConditionIsSameStage(op, val, CONDITION_AND);
	}

	public void setConditionIsSameStage(String op, java.lang.Boolean val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectIsSameStage(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionIsHasSign(String op, java.lang.Boolean val) {
		setConditionIsHasSign(op, val, CONDITION_AND);
	}

	public void setConditionIsHasSign(String op, java.lang.Boolean val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectIsHasSign(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionIsHasSeal(String op, java.lang.Boolean val) {
		setConditionIsHasSeal(op, val, CONDITION_AND);
	}

	public void setConditionIsHasSeal(String op, java.lang.Boolean val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectIsHasSeal(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionIsSure(String op, java.lang.Boolean val) {
		setConditionIsSure(op, val, CONDITION_AND);
	}

	public void setConditionIsSure(String op, java.lang.Boolean val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectIsSure(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionIsQualified(String op, java.lang.Boolean val) {
		setConditionIsQualified(op, val, CONDITION_AND);
	}

	public void setConditionIsQualified(String op, java.lang.Boolean val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectIsQualified(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(14, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionIsEmailSure(String op, java.lang.Boolean val) {
		setConditionIsEmailSure(op, val, CONDITION_AND);
	}

	public void setConditionIsEmailSure(String op, java.lang.Boolean val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectIsEmailSure(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionIsOtherSure(String op, java.lang.Boolean val) {
		setConditionIsOtherSure(op, val, CONDITION_AND);
	}

	public void setConditionIsOtherSure(String op, java.lang.Boolean val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectIsOtherSure(boolean val) {
		__select_flags[16] = val;
	}


}

