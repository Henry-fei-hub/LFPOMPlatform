package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCompanyWorkplaceFile;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CompanyWorkplaceFile extends AbstractTable<BaseCompanyWorkplaceFile>
{

	public CompanyWorkplaceFile() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "company_workplace_files";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCompanyWorkplaceFile.CS_COMPANY_WORKPLACE_FILE;
		__column_names[1] = BaseCompanyWorkplaceFile.CS_WORKPLACE_ID;
		__column_names[2] = BaseCompanyWorkplaceFile.CS_CWD_FILE_ID;
		__column_names[3] = BaseCompanyWorkplaceFile.CS_CREATE_TIME;
		__column_names[4] = BaseCompanyWorkplaceFile.CS_LAST_MODIFY_TIME;
		__column_names[5] = BaseCompanyWorkplaceFile.CS_DELETE_FLAG;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCompanyWorkplaceFile b) {
		clear();
		setCompanyWorkplaceFileClear(b.getCompanyWorkplaceFile());
	}

	public boolean isPrimaryKeyNull() {
		return getCompanyWorkplaceFile() == null;
	}

	@Override
	public BaseCompanyWorkplaceFile generateBase(){
		BaseCompanyWorkplaceFile b = new BaseCompanyWorkplaceFile();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCompanyWorkplaceFile b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCompanyWorkplaceFile(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setWorkplaceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCwdFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setLastModifyTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCompanyWorkplaceFile b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCompanyWorkplaceFile();
		buff[count++] = b.getWorkplaceId();
		buff[count++] = b.getCwdFileId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = generateTimestampFromDate(b.getLastModifyTime());
		buff[count++] = b.getDeleteFlag();
	}

	@Override
	public void setDataFromBase(BaseCompanyWorkplaceFile b){
		if(b.getCompanyWorkplaceFile() != null) setCompanyWorkplaceFileClear(b.getCompanyWorkplaceFile());
		if(b.getWorkplaceId() != null) setWorkplaceId(b.getWorkplaceId());
		if(b.getCwdFileId() != null) setCwdFileId(b.getCwdFileId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getLastModifyTime() != null) setLastModifyTime(b.getLastModifyTime());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
	}

	@Override
	public BaseCompanyWorkplaceFile generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCompanyWorkplaceFile b = new BaseCompanyWorkplaceFile();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCompanyWorkplaceFile __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyWorkplaceFile(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkplaceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLastModifyTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
	}

	public void setCompanyWorkplaceFile(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCompanyWorkplaceFile() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCompanyWorkplaceFileClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setWorkplaceId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getWorkplaceId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setCwdFileId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getCwdFileId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setLastModifyTime(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getLastModifyTime() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setConditionCompanyWorkplaceFile(String op, java.lang.Integer val) {
		setConditionCompanyWorkplaceFile(op, val, CONDITION_AND);
	}

	public void setConditionCompanyWorkplaceFile(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCompanyWorkplaceFile(boolean val) {
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

	public void setConditionCwdFileId(String op, java.lang.Integer val) {
		setConditionCwdFileId(op, val, CONDITION_AND);
	}

	public void setConditionCwdFileId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCwdFileId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionLastModifyTime(String op, java.util.Date val) {
		setConditionLastModifyTime(op, val, CONDITION_AND);
	}

	public void setConditionLastModifyTime(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectLastModifyTime(boolean val) {
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


}

