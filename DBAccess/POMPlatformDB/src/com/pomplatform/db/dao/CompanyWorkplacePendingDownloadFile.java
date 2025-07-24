package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCompanyWorkplacePendingDownloadFile;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CompanyWorkplacePendingDownloadFile extends AbstractTable<BaseCompanyWorkplacePendingDownloadFile>
{

	public CompanyWorkplacePendingDownloadFile() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "company_workplace_pending_download_files";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCompanyWorkplacePendingDownloadFile.CS_COMPANY_WORKPLACE_PENDING_DOWNLOAD_FILE_ID;
		__column_names[1] = BaseCompanyWorkplacePendingDownloadFile.CS_WORKPLACE_ID;
		__column_names[2] = BaseCompanyWorkplacePendingDownloadFile.CS_CREATE_TIME;
		__column_names[3] = BaseCompanyWorkplacePendingDownloadFile.CS_LAST_MODIFY_TIME;
		__column_names[4] = BaseCompanyWorkplacePendingDownloadFile.CS_CWD_FILE_ID;
		__column_names[5] = BaseCompanyWorkplacePendingDownloadFile.CS_DELETE_FLAG;
		__column_names[6] = BaseCompanyWorkplacePendingDownloadFile.CS_STATUS;
		__column_names[7] = BaseCompanyWorkplacePendingDownloadFile.CS_SRC_WORKPLACE_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCompanyWorkplacePendingDownloadFile b) {
		clear();
		setCompanyWorkplacePendingDownloadFileIdClear(b.getCompanyWorkplacePendingDownloadFileId());
	}

	public boolean isPrimaryKeyNull() {
		return getCompanyWorkplacePendingDownloadFileId() == null;
	}

	@Override
	public BaseCompanyWorkplacePendingDownloadFile generateBase(){
		BaseCompanyWorkplacePendingDownloadFile b = new BaseCompanyWorkplacePendingDownloadFile();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCompanyWorkplacePendingDownloadFile b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCompanyWorkplacePendingDownloadFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setWorkplaceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setLastModifyTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCwdFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSrcWorkplaceId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCompanyWorkplacePendingDownloadFile b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCompanyWorkplacePendingDownloadFileId();
		buff[count++] = b.getWorkplaceId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = generateTimestampFromDate(b.getLastModifyTime());
		buff[count++] = b.getCwdFileId();
		buff[count++] = b.getDeleteFlag();
		buff[count++] = b.getStatus();
		buff[count++] = b.getSrcWorkplaceId();
	}

	@Override
	public void setDataFromBase(BaseCompanyWorkplacePendingDownloadFile b){
		if(b.getCompanyWorkplacePendingDownloadFileId() != null) setCompanyWorkplacePendingDownloadFileIdClear(b.getCompanyWorkplacePendingDownloadFileId());
		if(b.getWorkplaceId() != null) setWorkplaceId(b.getWorkplaceId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getLastModifyTime() != null) setLastModifyTime(b.getLastModifyTime());
		if(b.getCwdFileId() != null) setCwdFileId(b.getCwdFileId());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getSrcWorkplaceId() != null) setSrcWorkplaceId(b.getSrcWorkplaceId());
	}

	@Override
	public BaseCompanyWorkplacePendingDownloadFile generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCompanyWorkplacePendingDownloadFile b = new BaseCompanyWorkplacePendingDownloadFile();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCompanyWorkplacePendingDownloadFile __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyWorkplacePendingDownloadFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkplaceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLastModifyTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSrcWorkplaceId(GenericBase.__getInt(val));
	}

	public void setCompanyWorkplacePendingDownloadFileId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCompanyWorkplacePendingDownloadFileId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCompanyWorkplacePendingDownloadFileIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setWorkplaceId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getWorkplaceId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(2, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[2]);
	}

	public void setLastModifyTime(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getLastModifyTime() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setCwdFileId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getCwdFileId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setSrcWorkplaceId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getSrcWorkplaceId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setConditionCompanyWorkplacePendingDownloadFileId(String op, java.lang.Integer val) {
		setConditionCompanyWorkplacePendingDownloadFileId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyWorkplacePendingDownloadFileId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCompanyWorkplacePendingDownloadFileId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionWorkplaceId(String op, java.lang.Integer val) {
		setConditionWorkplaceId(op, val, CONDITION_AND);
	}

	public void setConditionWorkplaceId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectWorkplaceId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(2, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionLastModifyTime(String op, java.util.Date val) {
		setConditionLastModifyTime(op, val, CONDITION_AND);
	}

	public void setConditionLastModifyTime(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectLastModifyTime(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCwdFileId(String op, java.lang.Integer val) {
		setConditionCwdFileId(op, val, CONDITION_AND);
	}

	public void setConditionCwdFileId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCwdFileId(boolean val) {
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

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionSrcWorkplaceId(String op, java.lang.Integer val) {
		setConditionSrcWorkplaceId(op, val, CONDITION_AND);
	}

	public void setConditionSrcWorkplaceId(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectSrcWorkplaceId(boolean val) {
		__select_flags[7] = val;
	}


}

