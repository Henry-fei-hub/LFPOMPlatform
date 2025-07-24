package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdFileFilter;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdFileFilter extends AbstractTable<BaseCwdFileFilter>
{

	public CwdFileFilter() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "cwd_file_filters";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdFileFilter.CS_FILE_FILTER_ID;
		__column_names[1] = BaseCwdFileFilter.CS_TYPE;
		__column_names[2] = BaseCwdFileFilter.CS_FILTER_FILE_EXTENSION;
		__column_names[3] = BaseCwdFileFilter.CS_REMARK;
		__column_names[4] = BaseCwdFileFilter.CS_CREATE_TIME;
		__column_names[5] = BaseCwdFileFilter.CS_DELETE_FLAG;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdFileFilter b) {
		clear();
		setFileFilterIdClear(b.getFileFilterId());
	}

	public boolean isPrimaryKeyNull() {
		return getFileFilterId() == null;
	}

	@Override
	public BaseCwdFileFilter generateBase(){
		BaseCwdFileFilter b = new BaseCwdFileFilter();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdFileFilter b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setFileFilterId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFilterFileExtension(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdFileFilter b, Object[] buff){
		int count = 0;
		buff[count++] = b.getFileFilterId();
		buff[count++] = b.getType();
		buff[count++] = b.getFilterFileExtension();
		buff[count++] = b.getRemark();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getDeleteFlag();
	}

	@Override
	public void setDataFromBase(BaseCwdFileFilter b){
		if(b.getFileFilterId() != null) setFileFilterIdClear(b.getFileFilterId());
		if(b.getType() != null) setType(b.getType());
		if(b.getFilterFileExtension() != null) setFilterFileExtension(b.getFilterFileExtension());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
	}

	@Override
	public BaseCwdFileFilter generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdFileFilter b = new BaseCwdFileFilter();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdFileFilter __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileFilterId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFilterFileExtension(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
	}

	public void setFileFilterId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getFileFilterId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setFileFilterIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setType(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getType() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setFilterFileExtension(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getFilterFileExtension() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[3]);
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

	public void setConditionFileFilterId(String op, java.lang.Integer val) {
		setConditionFileFilterId(op, val, CONDITION_AND);
	}

	public void setConditionFileFilterId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectFileFilterId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionType(String op, java.lang.Integer val) {
		setConditionType(op, val, CONDITION_AND);
	}

	public void setConditionType(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectType(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionFilterFileExtension(String op, java.lang.String val) {
		setConditionFilterFileExtension(op, val, CONDITION_AND);
	}

	public void setConditionFilterFileExtension(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectFilterFileExtension(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
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


}

