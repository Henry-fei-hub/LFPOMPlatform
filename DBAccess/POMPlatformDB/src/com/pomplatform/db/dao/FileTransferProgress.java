package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseFileTransferProgress;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class FileTransferProgress extends AbstractTable<BaseFileTransferProgress>
{

	public FileTransferProgress() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 16;

		initTables();

		__tableName            = "file_transfer_progresses";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseFileTransferProgress.CS_FILE_TRANSFER_PROGRESS_ID;
		__column_names[1] = BaseFileTransferProgress.CS_FILE_TRANSFER_KEY;
		__column_names[2] = BaseFileTransferProgress.CS_FULL_FILE_NAME;
		__column_names[3] = BaseFileTransferProgress.CS_FILE_KEY;
		__column_names[4] = BaseFileTransferProgress.CS_FILE_SIZE;
		__column_names[5] = BaseFileTransferProgress.CS_TRANSFERED_SIZE;
		__column_names[6] = BaseFileTransferProgress.CS_TRANSFER_PERCENT;
		__column_names[7] = BaseFileTransferProgress.CS_REQUEST_USER_ID;
		__column_names[8] = BaseFileTransferProgress.CS_REQUEST_COMPANY_ID;
		__column_names[9] = BaseFileTransferProgress.CS_REQUEST_WORKPLACE_ID;
		__column_names[10] = BaseFileTransferProgress.CS_REQUEST_MAC_ADDRESS;
		__column_names[11] = BaseFileTransferProgress.CS_REQUEST_IP_ADDRESS;
		__column_names[12] = BaseFileTransferProgress.CS_REQUEST_MACHINE_NAME;
		__column_names[13] = BaseFileTransferProgress.CS_START_TRANSFER_TIME;
		__column_names[14] = BaseFileTransferProgress.CS_END_TRANSFER_TIME;
		__column_names[15] = BaseFileTransferProgress.CS_STATUS;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseFileTransferProgress b) {
		clear();
		setFileTransferProgressIdClear(b.getFileTransferProgressId());
	}

	public boolean isPrimaryKeyNull() {
		return getFileTransferProgressId() == null;
	}

	@Override
	public BaseFileTransferProgress generateBase(){
		BaseFileTransferProgress b = new BaseFileTransferProgress();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseFileTransferProgress b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setFileTransferProgressId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileTransferKey(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFullFileName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFileKey(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFileSize(GenericBase.__getLong(val));
		if((val = __current_data[count++]) != null) b.setTransferedSize(GenericBase.__getLong(val));
		if((val = __current_data[count++]) != null) b.setTransferPercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRequestUserId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRequestCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRequestWorkplaceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRequestMacAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRequestIpAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRequestMachineName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setStartTransferTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEndTransferTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseFileTransferProgress b, Object[] buff){
		int count = 0;
		buff[count++] = b.getFileTransferProgressId();
		buff[count++] = b.getFileTransferKey();
		buff[count++] = b.getFullFileName();
		buff[count++] = b.getFileKey();
		buff[count++] = b.getFileSize();
		buff[count++] = b.getTransferedSize();
		buff[count++] = b.getTransferPercent();
		buff[count++] = b.getRequestUserId();
		buff[count++] = b.getRequestCompanyId();
		buff[count++] = b.getRequestWorkplaceId();
		buff[count++] = b.getRequestMacAddress();
		buff[count++] = b.getRequestIpAddress();
		buff[count++] = b.getRequestMachineName();
		buff[count++] = generateTimestampFromDate(b.getStartTransferTime());
		buff[count++] = generateTimestampFromDate(b.getEndTransferTime());
		buff[count++] = b.getStatus();
	}

	@Override
	public void setDataFromBase(BaseFileTransferProgress b){
		if(b.getFileTransferProgressId() != null) setFileTransferProgressIdClear(b.getFileTransferProgressId());
		if(b.getFileTransferKey() != null) setFileTransferKey(b.getFileTransferKey());
		if(b.getFullFileName() != null) setFullFileName(b.getFullFileName());
		if(b.getFileKey() != null) setFileKey(b.getFileKey());
		if(b.getFileSize() != null) setFileSize(b.getFileSize());
		if(b.getTransferedSize() != null) setTransferedSize(b.getTransferedSize());
		if(b.getTransferPercent() != null) setTransferPercent(b.getTransferPercent());
		if(b.getRequestUserId() != null) setRequestUserId(b.getRequestUserId());
		if(b.getRequestCompanyId() != null) setRequestCompanyId(b.getRequestCompanyId());
		if(b.getRequestWorkplaceId() != null) setRequestWorkplaceId(b.getRequestWorkplaceId());
		if(b.getRequestMacAddress() != null) setRequestMacAddress(b.getRequestMacAddress());
		if(b.getRequestIpAddress() != null) setRequestIpAddress(b.getRequestIpAddress());
		if(b.getRequestMachineName() != null) setRequestMachineName(b.getRequestMachineName());
		if(b.getStartTransferTime() != null) setStartTransferTime(b.getStartTransferTime());
		if(b.getEndTransferTime() != null) setEndTransferTime(b.getEndTransferTime());
		if(b.getStatus() != null) setStatus(b.getStatus());
	}

	@Override
	public BaseFileTransferProgress generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseFileTransferProgress b = new BaseFileTransferProgress();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseFileTransferProgress __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileTransferProgressId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileTransferKey(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFullFileName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileKey(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileSize(GenericBase.__getLong(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTransferedSize(GenericBase.__getLong(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTransferPercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRequestUserId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRequestCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRequestWorkplaceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRequestMacAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRequestIpAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRequestMachineName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStartTransferTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndTransferTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
	}

	public void setFileTransferProgressId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getFileTransferProgressId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setFileTransferProgressIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setFileTransferKey(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getFileTransferKey() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setFullFileName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getFullFileName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setFileKey(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getFileKey() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setFileSize(java.lang.Long val) {
		setCurrentData(4, val);
	}

	public java.lang.Long getFileSize() {
		return GenericBase.__getLong(__current_data[4]);
	}

	public void setTransferedSize(java.lang.Long val) {
		setCurrentData(5, val);
	}

	public java.lang.Long getTransferedSize() {
		return GenericBase.__getLong(__current_data[5]);
	}

	public void setTransferPercent(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getTransferPercent() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setRequestUserId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getRequestUserId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setRequestCompanyId(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getRequestCompanyId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setRequestWorkplaceId(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getRequestWorkplaceId() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setRequestMacAddress(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getRequestMacAddress() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setRequestIpAddress(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getRequestIpAddress() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setRequestMachineName(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getRequestMachineName() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setStartTransferTime(java.util.Date val) {
		setCurrentData(13, generateTimestampFromDate(val));
	}

	public java.util.Date getStartTransferTime() {
		return GenericBase.__getDateFromSQL(__current_data[13]);
	}

	public void setEndTransferTime(java.util.Date val) {
		setCurrentData(14, generateTimestampFromDate(val));
	}

	public java.util.Date getEndTransferTime() {
		return GenericBase.__getDateFromSQL(__current_data[14]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setConditionFileTransferProgressId(String op, java.lang.Integer val) {
		setConditionFileTransferProgressId(op, val, CONDITION_AND);
	}

	public void setConditionFileTransferProgressId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectFileTransferProgressId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionFileTransferKey(String op, java.lang.String val) {
		setConditionFileTransferKey(op, val, CONDITION_AND);
	}

	public void setConditionFileTransferKey(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectFileTransferKey(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionFullFileName(String op, java.lang.String val) {
		setConditionFullFileName(op, val, CONDITION_AND);
	}

	public void setConditionFullFileName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectFullFileName(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionFileKey(String op, java.lang.String val) {
		setConditionFileKey(op, val, CONDITION_AND);
	}

	public void setConditionFileKey(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectFileKey(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionFileSize(String op, java.lang.Long val) {
		setConditionFileSize(op, val, CONDITION_AND);
	}

	public void setConditionFileSize(String op, java.lang.Long val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectFileSize(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionTransferedSize(String op, java.lang.Long val) {
		setConditionTransferedSize(op, val, CONDITION_AND);
	}

	public void setConditionTransferedSize(String op, java.lang.Long val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectTransferedSize(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionTransferPercent(String op, java.math.BigDecimal val) {
		setConditionTransferPercent(op, val, CONDITION_AND);
	}

	public void setConditionTransferPercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectTransferPercent(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionRequestUserId(String op, java.lang.Integer val) {
		setConditionRequestUserId(op, val, CONDITION_AND);
	}

	public void setConditionRequestUserId(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectRequestUserId(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionRequestCompanyId(String op, java.lang.Integer val) {
		setConditionRequestCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionRequestCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectRequestCompanyId(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionRequestWorkplaceId(String op, java.lang.Integer val) {
		setConditionRequestWorkplaceId(op, val, CONDITION_AND);
	}

	public void setConditionRequestWorkplaceId(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectRequestWorkplaceId(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionRequestMacAddress(String op, java.lang.String val) {
		setConditionRequestMacAddress(op, val, CONDITION_AND);
	}

	public void setConditionRequestMacAddress(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectRequestMacAddress(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionRequestIpAddress(String op, java.lang.String val) {
		setConditionRequestIpAddress(op, val, CONDITION_AND);
	}

	public void setConditionRequestIpAddress(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectRequestIpAddress(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionRequestMachineName(String op, java.lang.String val) {
		setConditionRequestMachineName(op, val, CONDITION_AND);
	}

	public void setConditionRequestMachineName(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectRequestMachineName(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionStartTransferTime(String op, java.util.Date val) {
		setConditionStartTransferTime(op, val, CONDITION_AND);
	}

	public void setConditionStartTransferTime(String op, java.util.Date val, String relation) {
		addCondition(13, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectStartTransferTime(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionEndTransferTime(String op, java.util.Date val) {
		setConditionEndTransferTime(op, val, CONDITION_AND);
	}

	public void setConditionEndTransferTime(String op, java.util.Date val, String relation) {
		addCondition(14, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectEndTransferTime(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[15] = val;
	}


}

