package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdFileVersion;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdFileVersion extends AbstractTable<BaseCwdFileVersion>
{

	public CwdFileVersion() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 21;

		initTables();

		__tableName            = "cwd_file_versions";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdFileVersion.CS_CWD_FILE_VERSION_ID;
		__column_names[1] = BaseCwdFileVersion.CS_CWD_FILE_ID;
		__column_names[2] = BaseCwdFileVersion.CS_FILE_NAME;
		__column_names[3] = BaseCwdFileVersion.CS_FILE_EXTENSION;
		__column_names[4] = BaseCwdFileVersion.CS_IS_FOLDER;
		__column_names[5] = BaseCwdFileVersion.CS_FILE_TYPE;
		__column_names[6] = BaseCwdFileVersion.CS_PARENT_ID;
		__column_names[7] = BaseCwdFileVersion.CS_FILE_SIZE;
		__column_names[8] = BaseCwdFileVersion.CS_CREATE_PERSON;
		__column_names[9] = BaseCwdFileVersion.CS_CREATE_TIME;
		__column_names[10] = BaseCwdFileVersion.CS_UPLOADER;
		__column_names[11] = BaseCwdFileVersion.CS_UPLOAD_START_TIME;
		__column_names[12] = BaseCwdFileVersion.CS_UPLOAD_COMPLETED_TIME;
		__column_names[13] = BaseCwdFileVersion.CS_UPLOAD_STATUS;
		__column_names[14] = BaseCwdFileVersion.CS_FILE_PATH;
		__column_names[15] = BaseCwdFileVersion.CS_BUCKET;
		__column_names[16] = BaseCwdFileVersion.CS_OSS_KEY;
		__column_names[17] = BaseCwdFileVersion.CS_CAD_VERSION;
		__column_names[18] = BaseCwdFileVersion.CS_REMARK;
		__column_names[19] = BaseCwdFileVersion.CS_ACTION;
		__column_names[20] = BaseCwdFileVersion.CS_MAC_ADDRESS;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdFileVersion b) {
		clear();
		setCwdFileVersionIdClear(b.getCwdFileVersionId());
	}

	public boolean isPrimaryKeyNull() {
		return getCwdFileVersionId() == null;
	}

	@Override
	public BaseCwdFileVersion generateBase(){
		BaseCwdFileVersion b = new BaseCwdFileVersion();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdFileVersion b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCwdFileVersionId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCwdFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFileExtension(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsFolder(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setFileType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileSize(GenericBase.__getLong(val));
		if((val = __current_data[count++]) != null) b.setCreatePerson(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setUploader(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setUploadStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setUploadCompletedTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setUploadStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFilePath(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBucket(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOssKey(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCadVersion(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAction(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMacAddress(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdFileVersion b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCwdFileVersionId();
		buff[count++] = b.getCwdFileId();
		buff[count++] = b.getFileName();
		buff[count++] = b.getFileExtension();
		buff[count++] = b.getIsFolder();
		buff[count++] = b.getFileType();
		buff[count++] = b.getParentId();
		buff[count++] = b.getFileSize();
		buff[count++] = b.getCreatePerson();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getUploader();
		buff[count++] = generateTimestampFromDate(b.getUploadStartTime());
		buff[count++] = generateTimestampFromDate(b.getUploadCompletedTime());
		buff[count++] = b.getUploadStatus();
		buff[count++] = b.getFilePath();
		buff[count++] = b.getBucket();
		buff[count++] = b.getOssKey();
		buff[count++] = b.getCadVersion();
		buff[count++] = b.getRemark();
		buff[count++] = b.getAction();
		buff[count++] = b.getMacAddress();
	}

	@Override
	public void setDataFromBase(BaseCwdFileVersion b){
		if(b.getCwdFileVersionId() != null) setCwdFileVersionIdClear(b.getCwdFileVersionId());
		if(b.getCwdFileId() != null) setCwdFileId(b.getCwdFileId());
		if(b.getFileName() != null) setFileName(b.getFileName());
		if(b.getFileExtension() != null) setFileExtension(b.getFileExtension());
		if(b.getIsFolder() != null) setIsFolder(b.getIsFolder());
		if(b.getFileType() != null) setFileType(b.getFileType());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getFileSize() != null) setFileSize(b.getFileSize());
		if(b.getCreatePerson() != null) setCreatePerson(b.getCreatePerson());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getUploader() != null) setUploader(b.getUploader());
		if(b.getUploadStartTime() != null) setUploadStartTime(b.getUploadStartTime());
		if(b.getUploadCompletedTime() != null) setUploadCompletedTime(b.getUploadCompletedTime());
		if(b.getUploadStatus() != null) setUploadStatus(b.getUploadStatus());
		if(b.getFilePath() != null) setFilePath(b.getFilePath());
		if(b.getBucket() != null) setBucket(b.getBucket());
		if(b.getOssKey() != null) setOssKey(b.getOssKey());
		if(b.getCadVersion() != null) setCadVersion(b.getCadVersion());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getAction() != null) setAction(b.getAction());
		if(b.getMacAddress() != null) setMacAddress(b.getMacAddress());
	}

	@Override
	public BaseCwdFileVersion generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdFileVersion b = new BaseCwdFileVersion();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdFileVersion __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdFileVersionId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileExtension(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsFolder(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileSize(GenericBase.__getLong(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreatePerson(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUploader(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUploadStartTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUploadCompletedTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUploadStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFilePath(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBucket(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOssKey(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCadVersion(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAction(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMacAddress(GenericBase.__getString(val));
	}

	public void setCwdFileVersionId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCwdFileVersionId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCwdFileVersionIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCwdFileId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getCwdFileId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setFileName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getFileName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setFileExtension(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getFileExtension() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setIsFolder(java.lang.Boolean val) {
		setCurrentData(4, val);
	}

	public java.lang.Boolean getIsFolder() {
		return GenericBase.__getBoolean(__current_data[4]);
	}

	public void setFileType(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getFileType() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setFileSize(java.lang.Long val) {
		setCurrentData(7, val);
	}

	public java.lang.Long getFileSize() {
		return GenericBase.__getLong(__current_data[7]);
	}

	public void setCreatePerson(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getCreatePerson() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setUploader(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getUploader() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setUploadStartTime(java.util.Date val) {
		setCurrentData(11, generateTimestampFromDate(val));
	}

	public java.util.Date getUploadStartTime() {
		return GenericBase.__getDateFromSQL(__current_data[11]);
	}

	public void setUploadCompletedTime(java.util.Date val) {
		setCurrentData(12, generateTimestampFromDate(val));
	}

	public java.util.Date getUploadCompletedTime() {
		return GenericBase.__getDateFromSQL(__current_data[12]);
	}

	public void setUploadStatus(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getUploadStatus() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setFilePath(java.lang.String val) {
		setCurrentData(14, val);
	}

	public java.lang.String getFilePath() {
		return GenericBase.__getString(__current_data[14]);
	}

	public void setBucket(java.lang.String val) {
		setCurrentData(15, val);
	}

	public java.lang.String getBucket() {
		return GenericBase.__getString(__current_data[15]);
	}

	public void setOssKey(java.lang.String val) {
		setCurrentData(16, val);
	}

	public java.lang.String getOssKey() {
		return GenericBase.__getString(__current_data[16]);
	}

	public void setCadVersion(java.lang.String val) {
		setCurrentData(17, val);
	}

	public java.lang.String getCadVersion() {
		return GenericBase.__getString(__current_data[17]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(18, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[18]);
	}

	public void setAction(java.lang.Integer val) {
		setCurrentData(19, val);
	}

	public java.lang.Integer getAction() {
		return GenericBase.__getInt(__current_data[19]);
	}

	public void setMacAddress(java.lang.String val) {
		setCurrentData(20, val);
	}

	public java.lang.String getMacAddress() {
		return GenericBase.__getString(__current_data[20]);
	}

	public void setConditionCwdFileVersionId(String op, java.lang.Integer val) {
		setConditionCwdFileVersionId(op, val, CONDITION_AND);
	}

	public void setConditionCwdFileVersionId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCwdFileVersionId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCwdFileId(String op, java.lang.Integer val) {
		setConditionCwdFileId(op, val, CONDITION_AND);
	}

	public void setConditionCwdFileId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCwdFileId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionFileName(String op, java.lang.String val) {
		setConditionFileName(op, val, CONDITION_AND);
	}

	public void setConditionFileName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectFileName(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionFileExtension(String op, java.lang.String val) {
		setConditionFileExtension(op, val, CONDITION_AND);
	}

	public void setConditionFileExtension(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectFileExtension(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionIsFolder(String op, java.lang.Boolean val) {
		setConditionIsFolder(op, val, CONDITION_AND);
	}

	public void setConditionIsFolder(String op, java.lang.Boolean val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectIsFolder(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionFileType(String op, java.lang.Integer val) {
		setConditionFileType(op, val, CONDITION_AND);
	}

	public void setConditionFileType(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectFileType(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionParentId(String op, java.lang.Integer val) {
		setConditionParentId(op, val, CONDITION_AND);
	}

	public void setConditionParentId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectParentId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionFileSize(String op, java.lang.Long val) {
		setConditionFileSize(op, val, CONDITION_AND);
	}

	public void setConditionFileSize(String op, java.lang.Long val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectFileSize(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionCreatePerson(String op, java.lang.Integer val) {
		setConditionCreatePerson(op, val, CONDITION_AND);
	}

	public void setConditionCreatePerson(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectCreatePerson(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(9, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionUploader(String op, java.lang.Integer val) {
		setConditionUploader(op, val, CONDITION_AND);
	}

	public void setConditionUploader(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectUploader(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionUploadStartTime(String op, java.util.Date val) {
		setConditionUploadStartTime(op, val, CONDITION_AND);
	}

	public void setConditionUploadStartTime(String op, java.util.Date val, String relation) {
		addCondition(11, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUploadStartTime(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionUploadCompletedTime(String op, java.util.Date val) {
		setConditionUploadCompletedTime(op, val, CONDITION_AND);
	}

	public void setConditionUploadCompletedTime(String op, java.util.Date val, String relation) {
		addCondition(12, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUploadCompletedTime(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionUploadStatus(String op, java.lang.Integer val) {
		setConditionUploadStatus(op, val, CONDITION_AND);
	}

	public void setConditionUploadStatus(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectUploadStatus(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionFilePath(String op, java.lang.String val) {
		setConditionFilePath(op, val, CONDITION_AND);
	}

	public void setConditionFilePath(String op, java.lang.String val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectFilePath(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionBucket(String op, java.lang.String val) {
		setConditionBucket(op, val, CONDITION_AND);
	}

	public void setConditionBucket(String op, java.lang.String val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectBucket(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionOssKey(String op, java.lang.String val) {
		setConditionOssKey(op, val, CONDITION_AND);
	}

	public void setConditionOssKey(String op, java.lang.String val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectOssKey(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionCadVersion(String op, java.lang.String val) {
		setConditionCadVersion(op, val, CONDITION_AND);
	}

	public void setConditionCadVersion(String op, java.lang.String val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectCadVersion(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionAction(String op, java.lang.Integer val) {
		setConditionAction(op, val, CONDITION_AND);
	}

	public void setConditionAction(String op, java.lang.Integer val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectAction(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionMacAddress(String op, java.lang.String val) {
		setConditionMacAddress(op, val, CONDITION_AND);
	}

	public void setConditionMacAddress(String op, java.lang.String val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectMacAddress(boolean val) {
		__select_flags[20] = val;
	}


}

