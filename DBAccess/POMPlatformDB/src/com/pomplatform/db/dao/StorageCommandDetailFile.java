package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseStorageCommandDetailFile;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class StorageCommandDetailFile extends AbstractTable<BaseStorageCommandDetailFile>
{

	public StorageCommandDetailFile() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 12;

		initTables();

		__tableName            = "storage_command_detail_files";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseStorageCommandDetailFile.CS_STORAGE_COMMAND_DETAIL_ID;
		__column_names[1] = BaseStorageCommandDetailFile.CS_STORAGE_COMMAND_ID;
		__column_names[2] = BaseStorageCommandDetailFile.CS_CWD_TASK_PROCESS_ID;
		__column_names[3] = BaseStorageCommandDetailFile.CS_OPERATION_TYPE;
		__column_names[4] = BaseStorageCommandDetailFile.CS_ORIGINAL_FILE_ID;
		__column_names[5] = BaseStorageCommandDetailFile.CS_ORIGINAL_FILE_PATH;
		__column_names[6] = BaseStorageCommandDetailFile.CS_NEW_FILE_ID;
		__column_names[7] = BaseStorageCommandDetailFile.CS_NEW_FILE_PATH;
		__column_names[8] = BaseStorageCommandDetailFile.CS_DEAL_STATUS;
		__column_names[9] = BaseStorageCommandDetailFile.CS_CREATE_TIME;
		__column_names[10] = BaseStorageCommandDetailFile.CS_COMPLETE_TIME;
		__column_names[11] = BaseStorageCommandDetailFile.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseStorageCommandDetailFile b) {
		clear();
		setStorageCommandDetailIdClear(b.getStorageCommandDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getStorageCommandDetailId() == null;
	}

	@Override
	public BaseStorageCommandDetailFile generateBase(){
		BaseStorageCommandDetailFile b = new BaseStorageCommandDetailFile();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseStorageCommandDetailFile b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setStorageCommandDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStorageCommandId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCwdTaskProcessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperationType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOriginalFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOriginalFilePath(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setNewFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setNewFilePath(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDealStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseStorageCommandDetailFile b, Object[] buff){
		int count = 0;
		buff[count++] = b.getStorageCommandDetailId();
		buff[count++] = b.getStorageCommandId();
		buff[count++] = b.getCwdTaskProcessId();
		buff[count++] = b.getOperationType();
		buff[count++] = b.getOriginalFileId();
		buff[count++] = b.getOriginalFilePath();
		buff[count++] = b.getNewFileId();
		buff[count++] = b.getNewFilePath();
		buff[count++] = b.getDealStatus();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = generateTimestampFromDate(b.getCompleteTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseStorageCommandDetailFile b){
		if(b.getStorageCommandDetailId() != null) setStorageCommandDetailIdClear(b.getStorageCommandDetailId());
		if(b.getStorageCommandId() != null) setStorageCommandId(b.getStorageCommandId());
		if(b.getCwdTaskProcessId() != null) setCwdTaskProcessId(b.getCwdTaskProcessId());
		if(b.getOperationType() != null) setOperationType(b.getOperationType());
		if(b.getOriginalFileId() != null) setOriginalFileId(b.getOriginalFileId());
		if(b.getOriginalFilePath() != null) setOriginalFilePath(b.getOriginalFilePath());
		if(b.getNewFileId() != null) setNewFileId(b.getNewFileId());
		if(b.getNewFilePath() != null) setNewFilePath(b.getNewFilePath());
		if(b.getDealStatus() != null) setDealStatus(b.getDealStatus());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getCompleteTime() != null) setCompleteTime(b.getCompleteTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseStorageCommandDetailFile generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseStorageCommandDetailFile b = new BaseStorageCommandDetailFile();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseStorageCommandDetailFile __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStorageCommandDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStorageCommandId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdTaskProcessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperationType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOriginalFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOriginalFilePath(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNewFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNewFilePath(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDealStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setStorageCommandDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getStorageCommandDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setStorageCommandDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setStorageCommandId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getStorageCommandId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setCwdTaskProcessId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getCwdTaskProcessId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setOperationType(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getOperationType() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setOriginalFileId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getOriginalFileId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setOriginalFilePath(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getOriginalFilePath() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setNewFileId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getNewFileId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setNewFilePath(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getNewFilePath() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setDealStatus(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getDealStatus() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setCompleteTime(java.util.Date val) {
		setCurrentData(10, generateTimestampFromDate(val));
	}

	public java.util.Date getCompleteTime() {
		return GenericBase.__getDateFromSQL(__current_data[10]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setConditionStorageCommandDetailId(String op, java.lang.Integer val) {
		setConditionStorageCommandDetailId(op, val, CONDITION_AND);
	}

	public void setConditionStorageCommandDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectStorageCommandDetailId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionStorageCommandId(String op, java.lang.Integer val) {
		setConditionStorageCommandId(op, val, CONDITION_AND);
	}

	public void setConditionStorageCommandId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectStorageCommandId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionCwdTaskProcessId(String op, java.lang.Integer val) {
		setConditionCwdTaskProcessId(op, val, CONDITION_AND);
	}

	public void setConditionCwdTaskProcessId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCwdTaskProcessId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionOperationType(String op, java.lang.Integer val) {
		setConditionOperationType(op, val, CONDITION_AND);
	}

	public void setConditionOperationType(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectOperationType(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionOriginalFileId(String op, java.lang.Integer val) {
		setConditionOriginalFileId(op, val, CONDITION_AND);
	}

	public void setConditionOriginalFileId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectOriginalFileId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionOriginalFilePath(String op, java.lang.String val) {
		setConditionOriginalFilePath(op, val, CONDITION_AND);
	}

	public void setConditionOriginalFilePath(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectOriginalFilePath(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionNewFileId(String op, java.lang.Integer val) {
		setConditionNewFileId(op, val, CONDITION_AND);
	}

	public void setConditionNewFileId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectNewFileId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionNewFilePath(String op, java.lang.String val) {
		setConditionNewFilePath(op, val, CONDITION_AND);
	}

	public void setConditionNewFilePath(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectNewFilePath(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionDealStatus(String op, java.lang.Integer val) {
		setConditionDealStatus(op, val, CONDITION_AND);
	}

	public void setConditionDealStatus(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectDealStatus(boolean val) {
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

	public void setConditionCompleteTime(String op, java.util.Date val) {
		setConditionCompleteTime(op, val, CONDITION_AND);
	}

	public void setConditionCompleteTime(String op, java.util.Date val, String relation) {
		addCondition(10, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCompleteTime(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[11] = val;
	}


}

