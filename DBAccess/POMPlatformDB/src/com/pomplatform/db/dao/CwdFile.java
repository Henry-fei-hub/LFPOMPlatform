package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdFile;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdFile extends AbstractTable<BaseCwdFile>
{

	public CwdFile() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 32;

		initTables();

		__tableName            = "cwd_files";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdFile.CS_CWD_FILE_ID;
		__column_names[1] = BaseCwdFile.CS_FILE_NAME;
		__column_names[2] = BaseCwdFile.CS_FILE_EXTENSION;
		__column_names[3] = BaseCwdFile.CS_IS_FOLDER;
		__column_names[4] = BaseCwdFile.CS_FILE_TYPE;
		__column_names[5] = BaseCwdFile.CS_PARENT_ID;
		__column_names[6] = BaseCwdFile.CS_FILE_SIZE;
		__column_names[7] = BaseCwdFile.CS_CREATE_PERSON;
		__column_names[8] = BaseCwdFile.CS_CREATE_TIME;
		__column_names[9] = BaseCwdFile.CS_MODIFICATION_PERSON;
		__column_names[10] = BaseCwdFile.CS_MODIFICATION_TIME;
		__column_names[11] = BaseCwdFile.CS_FILE_PATH;
		__column_names[12] = BaseCwdFile.CS_BUCKET;
		__column_names[13] = BaseCwdFile.CS_OSS_KEY;
		__column_names[14] = BaseCwdFile.CS_FILE_VERSION_ID;
		__column_names[15] = BaseCwdFile.CS_FILE_OWNER;
		__column_names[16] = BaseCwdFile.CS_CAD_VERSION;
		__column_names[17] = BaseCwdFile.CS_UPLOAD_LOCK;
		__column_names[18] = BaseCwdFile.CS_DELETE_FLAG;
		__column_names[19] = BaseCwdFile.CS_COMPANY_ID;
		__column_names[20] = BaseCwdFile.CS_COMPANY_NO;
		__column_names[21] = BaseCwdFile.CS_PROJECT_ID;
		__column_names[22] = BaseCwdFile.CS_FILE_ATTRIBUTION;
		__column_names[23] = BaseCwdFile.CS_MD5;
		__column_names[24] = BaseCwdFile.CS_FILE_URL;
		__column_names[25] = BaseCwdFile.CS_ORIGINAL_FILE_ID;
		__column_names[26] = BaseCwdFile.CS_ORIGINAL_FILE_PATH;
		__column_names[27] = BaseCwdFile.CS_FOLDER_TYPE;
		__column_names[28] = BaseCwdFile.CS_BASIC_FILE_TYPE;
		__column_names[29] = BaseCwdFile.CS_INIT_FILE_PATH;
		__column_names[30] = BaseCwdFile.CS_DELETE_PERSON;
		__column_names[31] = BaseCwdFile.CS_DELETE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdFile b) {
		clear();
		setCwdFileIdClear(b.getCwdFileId());
	}

	public boolean isPrimaryKeyNull() {
		return getCwdFileId() == null;
	}

	@Override
	public BaseCwdFile generateBase(){
		BaseCwdFile b = new BaseCwdFile();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdFile b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCwdFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFileExtension(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsFolder(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setFileType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileSize(GenericBase.__getLong(val));
		if((val = __current_data[count++]) != null) b.setCreatePerson(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setModificationPerson(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setModificationTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setFilePath(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBucket(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOssKey(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFileVersionId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileOwner(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCadVersion(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setUploadLock(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileAttribution(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMd5(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFileUrl(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOriginalFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOriginalFilePath(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFolderType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBasicFileType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInitFilePath(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDeletePerson(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDeleteTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdFile b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCwdFileId();
		buff[count++] = b.getFileName();
		buff[count++] = b.getFileExtension();
		buff[count++] = b.getIsFolder();
		buff[count++] = b.getFileType();
		buff[count++] = b.getParentId();
		buff[count++] = b.getFileSize();
		buff[count++] = b.getCreatePerson();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getModificationPerson();
		buff[count++] = generateTimestampFromDate(b.getModificationTime());
		buff[count++] = b.getFilePath();
		buff[count++] = b.getBucket();
		buff[count++] = b.getOssKey();
		buff[count++] = b.getFileVersionId();
		buff[count++] = b.getFileOwner();
		buff[count++] = b.getCadVersion();
		buff[count++] = b.getUploadLock();
		buff[count++] = b.getDeleteFlag();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getCompanyNo();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getFileAttribution();
		buff[count++] = b.getMd5();
		buff[count++] = b.getFileUrl();
		buff[count++] = b.getOriginalFileId();
		buff[count++] = b.getOriginalFilePath();
		buff[count++] = b.getFolderType();
		buff[count++] = b.getBasicFileType();
		buff[count++] = b.getInitFilePath();
		buff[count++] = b.getDeletePerson();
		buff[count++] = generateTimestampFromDate(b.getDeleteTime());
	}

	@Override
	public void setDataFromBase(BaseCwdFile b){
		if(b.getCwdFileId() != null) setCwdFileIdClear(b.getCwdFileId());
		if(b.getFileName() != null) setFileName(b.getFileName());
		if(b.getFileExtension() != null) setFileExtension(b.getFileExtension());
		if(b.getIsFolder() != null) setIsFolder(b.getIsFolder());
		if(b.getFileType() != null) setFileType(b.getFileType());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getFileSize() != null) setFileSize(b.getFileSize());
		if(b.getCreatePerson() != null) setCreatePerson(b.getCreatePerson());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getModificationPerson() != null) setModificationPerson(b.getModificationPerson());
		if(b.getModificationTime() != null) setModificationTime(b.getModificationTime());
		if(b.getFilePath() != null) setFilePath(b.getFilePath());
		if(b.getBucket() != null) setBucket(b.getBucket());
		if(b.getOssKey() != null) setOssKey(b.getOssKey());
		if(b.getFileVersionId() != null) setFileVersionId(b.getFileVersionId());
		if(b.getFileOwner() != null) setFileOwner(b.getFileOwner());
		if(b.getCadVersion() != null) setCadVersion(b.getCadVersion());
		if(b.getUploadLock() != null) setUploadLock(b.getUploadLock());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getCompanyNo() != null) setCompanyNo(b.getCompanyNo());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getFileAttribution() != null) setFileAttribution(b.getFileAttribution());
		if(b.getMd5() != null) setMd5(b.getMd5());
		if(b.getFileUrl() != null) setFileUrl(b.getFileUrl());
		if(b.getOriginalFileId() != null) setOriginalFileId(b.getOriginalFileId());
		if(b.getOriginalFilePath() != null) setOriginalFilePath(b.getOriginalFilePath());
		if(b.getFolderType() != null) setFolderType(b.getFolderType());
		if(b.getBasicFileType() != null) setBasicFileType(b.getBasicFileType());
		if(b.getInitFilePath() != null) setInitFilePath(b.getInitFilePath());
		if(b.getDeletePerson() != null) setDeletePerson(b.getDeletePerson());
		if(b.getDeleteTime() != null) setDeleteTime(b.getDeleteTime());
	}

	@Override
	public BaseCwdFile generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdFile b = new BaseCwdFile();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdFile __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileExtension(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsFolder(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileSize(GenericBase.__getLong(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreatePerson(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setModificationPerson(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setModificationTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFilePath(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBucket(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOssKey(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileVersionId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileOwner(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCadVersion(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUploadLock(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileAttribution(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMd5(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileUrl(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOriginalFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOriginalFilePath(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFolderType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBasicFileType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInitFilePath(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeletePerson(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteTime(GenericBase.__getDateFromSQL(val));
	}

	public void setCwdFileId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCwdFileId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCwdFileIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setFileName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getFileName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setFileExtension(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getFileExtension() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setIsFolder(java.lang.Boolean val) {
		setCurrentData(3, val);
	}

	public java.lang.Boolean getIsFolder() {
		return GenericBase.__getBoolean(__current_data[3]);
	}

	public void setFileType(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getFileType() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setFileSize(java.lang.Long val) {
		setCurrentData(6, val);
	}

	public java.lang.Long getFileSize() {
		return GenericBase.__getLong(__current_data[6]);
	}

	public void setCreatePerson(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getCreatePerson() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setModificationPerson(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getModificationPerson() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setModificationTime(java.util.Date val) {
		setCurrentData(10, generateTimestampFromDate(val));
	}

	public java.util.Date getModificationTime() {
		return GenericBase.__getDateFromSQL(__current_data[10]);
	}

	public void setFilePath(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getFilePath() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setBucket(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getBucket() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setOssKey(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getOssKey() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setFileVersionId(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getFileVersionId() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setFileOwner(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getFileOwner() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setCadVersion(java.lang.String val) {
		setCurrentData(16, val);
	}

	public java.lang.String getCadVersion() {
		return GenericBase.__getString(__current_data[16]);
	}

	public void setUploadLock(java.lang.Boolean val) {
		setCurrentData(17, val);
	}

	public java.lang.Boolean getUploadLock() {
		return GenericBase.__getBoolean(__current_data[17]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(18, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[18]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(19, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[19]);
	}

	public void setCompanyNo(java.lang.String val) {
		setCurrentData(20, val);
	}

	public java.lang.String getCompanyNo() {
		return GenericBase.__getString(__current_data[20]);
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(21, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[21]);
	}

	public void setFileAttribution(java.lang.Integer val) {
		setCurrentData(22, val);
	}

	public java.lang.Integer getFileAttribution() {
		return GenericBase.__getInt(__current_data[22]);
	}

	public void setMd5(java.lang.String val) {
		setCurrentData(23, val);
	}

	public java.lang.String getMd5() {
		return GenericBase.__getString(__current_data[23]);
	}

	public void setFileUrl(java.lang.String val) {
		setCurrentData(24, val);
	}

	public java.lang.String getFileUrl() {
		return GenericBase.__getString(__current_data[24]);
	}

	public void setOriginalFileId(java.lang.Integer val) {
		setCurrentData(25, val);
	}

	public java.lang.Integer getOriginalFileId() {
		return GenericBase.__getInt(__current_data[25]);
	}

	public void setOriginalFilePath(java.lang.String val) {
		setCurrentData(26, val);
	}

	public java.lang.String getOriginalFilePath() {
		return GenericBase.__getString(__current_data[26]);
	}

	public void setFolderType(java.lang.Integer val) {
		setCurrentData(27, val);
	}

	public java.lang.Integer getFolderType() {
		return GenericBase.__getInt(__current_data[27]);
	}

	public void setBasicFileType(java.lang.Integer val) {
		setCurrentData(28, val);
	}

	public java.lang.Integer getBasicFileType() {
		return GenericBase.__getInt(__current_data[28]);
	}

	public void setInitFilePath(java.lang.String val) {
		setCurrentData(29, val);
	}

	public java.lang.String getInitFilePath() {
		return GenericBase.__getString(__current_data[29]);
	}

	public void setDeletePerson(java.lang.Integer val) {
		setCurrentData(30, val);
	}

	public java.lang.Integer getDeletePerson() {
		return GenericBase.__getInt(__current_data[30]);
	}

	public void setDeleteTime(java.util.Date val) {
		setCurrentData(31, generateTimestampFromDate(val));
	}

	public java.util.Date getDeleteTime() {
		return GenericBase.__getDateFromSQL(__current_data[31]);
	}

	public void setConditionCwdFileId(String op, java.lang.Integer val) {
		setConditionCwdFileId(op, val, CONDITION_AND);
	}

	public void setConditionCwdFileId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCwdFileId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionFileName(String op, java.lang.String val) {
		setConditionFileName(op, val, CONDITION_AND);
	}

	public void setConditionFileName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectFileName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionFileExtension(String op, java.lang.String val) {
		setConditionFileExtension(op, val, CONDITION_AND);
	}

	public void setConditionFileExtension(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectFileExtension(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionIsFolder(String op, java.lang.Boolean val) {
		setConditionIsFolder(op, val, CONDITION_AND);
	}

	public void setConditionIsFolder(String op, java.lang.Boolean val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectIsFolder(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionFileType(String op, java.lang.Integer val) {
		setConditionFileType(op, val, CONDITION_AND);
	}

	public void setConditionFileType(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectFileType(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionParentId(String op, java.lang.Integer val) {
		setConditionParentId(op, val, CONDITION_AND);
	}

	public void setConditionParentId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectParentId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionFileSize(String op, java.lang.Long val) {
		setConditionFileSize(op, val, CONDITION_AND);
	}

	public void setConditionFileSize(String op, java.lang.Long val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectFileSize(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionCreatePerson(String op, java.lang.Integer val) {
		setConditionCreatePerson(op, val, CONDITION_AND);
	}

	public void setConditionCreatePerson(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectCreatePerson(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionModificationPerson(String op, java.lang.Integer val) {
		setConditionModificationPerson(op, val, CONDITION_AND);
	}

	public void setConditionModificationPerson(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectModificationPerson(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionModificationTime(String op, java.util.Date val) {
		setConditionModificationTime(op, val, CONDITION_AND);
	}

	public void setConditionModificationTime(String op, java.util.Date val, String relation) {
		addCondition(10, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectModificationTime(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionFilePath(String op, java.lang.String val) {
		setConditionFilePath(op, val, CONDITION_AND);
	}

	public void setConditionFilePath(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectFilePath(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionBucket(String op, java.lang.String val) {
		setConditionBucket(op, val, CONDITION_AND);
	}

	public void setConditionBucket(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectBucket(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionOssKey(String op, java.lang.String val) {
		setConditionOssKey(op, val, CONDITION_AND);
	}

	public void setConditionOssKey(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectOssKey(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionFileVersionId(String op, java.lang.Integer val) {
		setConditionFileVersionId(op, val, CONDITION_AND);
	}

	public void setConditionFileVersionId(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectFileVersionId(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionFileOwner(String op, java.lang.Integer val) {
		setConditionFileOwner(op, val, CONDITION_AND);
	}

	public void setConditionFileOwner(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectFileOwner(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionCadVersion(String op, java.lang.String val) {
		setConditionCadVersion(op, val, CONDITION_AND);
	}

	public void setConditionCadVersion(String op, java.lang.String val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectCadVersion(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionUploadLock(String op, java.lang.Boolean val) {
		setConditionUploadLock(op, val, CONDITION_AND);
	}

	public void setConditionUploadLock(String op, java.lang.Boolean val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectUploadLock(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionCompanyNo(String op, java.lang.String val) {
		setConditionCompanyNo(op, val, CONDITION_AND);
	}

	public void setConditionCompanyNo(String op, java.lang.String val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectCompanyNo(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionFileAttribution(String op, java.lang.Integer val) {
		setConditionFileAttribution(op, val, CONDITION_AND);
	}

	public void setConditionFileAttribution(String op, java.lang.Integer val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectFileAttribution(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionMd5(String op, java.lang.String val) {
		setConditionMd5(op, val, CONDITION_AND);
	}

	public void setConditionMd5(String op, java.lang.String val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectMd5(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionFileUrl(String op, java.lang.String val) {
		setConditionFileUrl(op, val, CONDITION_AND);
	}

	public void setConditionFileUrl(String op, java.lang.String val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectFileUrl(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionOriginalFileId(String op, java.lang.Integer val) {
		setConditionOriginalFileId(op, val, CONDITION_AND);
	}

	public void setConditionOriginalFileId(String op, java.lang.Integer val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectOriginalFileId(boolean val) {
		__select_flags[25] = val;
	}

	public void setConditionOriginalFilePath(String op, java.lang.String val) {
		setConditionOriginalFilePath(op, val, CONDITION_AND);
	}

	public void setConditionOriginalFilePath(String op, java.lang.String val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectOriginalFilePath(boolean val) {
		__select_flags[26] = val;
	}

	public void setConditionFolderType(String op, java.lang.Integer val) {
		setConditionFolderType(op, val, CONDITION_AND);
	}

	public void setConditionFolderType(String op, java.lang.Integer val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectFolderType(boolean val) {
		__select_flags[27] = val;
	}

	public void setConditionBasicFileType(String op, java.lang.Integer val) {
		setConditionBasicFileType(op, val, CONDITION_AND);
	}

	public void setConditionBasicFileType(String op, java.lang.Integer val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectBasicFileType(boolean val) {
		__select_flags[28] = val;
	}

	public void setConditionInitFilePath(String op, java.lang.String val) {
		setConditionInitFilePath(op, val, CONDITION_AND);
	}

	public void setConditionInitFilePath(String op, java.lang.String val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectInitFilePath(boolean val) {
		__select_flags[29] = val;
	}

	public void setConditionDeletePerson(String op, java.lang.Integer val) {
		setConditionDeletePerson(op, val, CONDITION_AND);
	}

	public void setConditionDeletePerson(String op, java.lang.Integer val, String relation) {
		addCondition(30, op, relation, val);
	}

	public void setSelectDeletePerson(boolean val) {
		__select_flags[30] = val;
	}

	public void setConditionDeleteTime(String op, java.util.Date val) {
		setConditionDeleteTime(op, val, CONDITION_AND);
	}

	public void setConditionDeleteTime(String op, java.util.Date val, String relation) {
		addCondition(31, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectDeleteTime(boolean val) {
		__select_flags[31] = val;
	}


}

