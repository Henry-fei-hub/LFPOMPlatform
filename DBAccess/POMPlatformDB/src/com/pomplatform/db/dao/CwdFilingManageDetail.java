package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdFilingManageDetail;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdFilingManageDetail extends AbstractTable<BaseCwdFilingManageDetail>
{

	public CwdFilingManageDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "cwd_filing_manage_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdFilingManageDetail.CS_CWD_FILING_MANAGE_DETAIL_ID;
		__column_names[1] = BaseCwdFilingManageDetail.CS_FILE_NAME;
		__column_names[2] = BaseCwdFilingManageDetail.CS_PARENT_ID;
		__column_names[3] = BaseCwdFilingManageDetail.CS_CWD_FILING_MANAGE_ID;
		__column_names[4] = BaseCwdFilingManageDetail.CS_OPERATOR_ID;
		__column_names[5] = BaseCwdFilingManageDetail.CS_CREATE_TIME;
		__column_names[6] = BaseCwdFilingManageDetail.CS_MAIN_PROJECT_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdFilingManageDetail b) {
		clear();
		setCwdFilingManageDetailIdClear(b.getCwdFilingManageDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getCwdFilingManageDetailId() == null;
	}

	@Override
	public BaseCwdFilingManageDetail generateBase(){
		BaseCwdFilingManageDetail b = new BaseCwdFilingManageDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdFilingManageDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCwdFilingManageDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCwdFilingManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperatorId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdFilingManageDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCwdFilingManageDetailId();
		buff[count++] = b.getFileName();
		buff[count++] = b.getParentId();
		buff[count++] = b.getCwdFilingManageId();
		buff[count++] = b.getOperatorId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getMainProjectId();
	}

	@Override
	public void setDataFromBase(BaseCwdFilingManageDetail b){
		if(b.getCwdFilingManageDetailId() != null) setCwdFilingManageDetailIdClear(b.getCwdFilingManageDetailId());
		if(b.getFileName() != null) setFileName(b.getFileName());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getCwdFilingManageId() != null) setCwdFilingManageId(b.getCwdFilingManageId());
		if(b.getOperatorId() != null) setOperatorId(b.getOperatorId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
	}

	@Override
	public BaseCwdFilingManageDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdFilingManageDetail b = new BaseCwdFilingManageDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdFilingManageDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdFilingManageDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdFilingManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
	}

	public void setCwdFilingManageDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCwdFilingManageDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCwdFilingManageDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setFileName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getFileName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setCwdFilingManageId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getCwdFilingManageId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setOperatorId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getOperatorId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setConditionCwdFilingManageDetailId(String op, java.lang.Integer val) {
		setConditionCwdFilingManageDetailId(op, val, CONDITION_AND);
	}

	public void setConditionCwdFilingManageDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCwdFilingManageDetailId(boolean val) {
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

	public void setConditionParentId(String op, java.lang.Integer val) {
		setConditionParentId(op, val, CONDITION_AND);
	}

	public void setConditionParentId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectParentId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionCwdFilingManageId(String op, java.lang.Integer val) {
		setConditionCwdFilingManageId(op, val, CONDITION_AND);
	}

	public void setConditionCwdFilingManageId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectCwdFilingManageId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionOperatorId(String op, java.lang.Integer val) {
		setConditionOperatorId(op, val, CONDITION_AND);
	}

	public void setConditionOperatorId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectOperatorId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val) {
		setConditionMainProjectId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectMainProjectId(boolean val) {
		__select_flags[6] = val;
	}


}

