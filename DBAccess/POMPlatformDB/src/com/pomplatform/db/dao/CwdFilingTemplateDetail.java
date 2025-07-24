package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdFilingTemplateDetail;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdFilingTemplateDetail extends AbstractTable<BaseCwdFilingTemplateDetail>
{

	public CwdFilingTemplateDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "cwd_filing_template_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdFilingTemplateDetail.CS_CWD_FILING_TEMPLATE_DETAIL_ID;
		__column_names[1] = BaseCwdFilingTemplateDetail.CS_FILE_NAME;
		__column_names[2] = BaseCwdFilingTemplateDetail.CS_PARENT_ID;
		__column_names[3] = BaseCwdFilingTemplateDetail.CS_CWD_FILING_TEMPLATE_ID;
		__column_names[4] = BaseCwdFilingTemplateDetail.CS_OPERATOR_ID;
		__column_names[5] = BaseCwdFilingTemplateDetail.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdFilingTemplateDetail b) {
		clear();
		setCwdFilingTemplateDetailIdClear(b.getCwdFilingTemplateDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getCwdFilingTemplateDetailId() == null;
	}

	@Override
	public BaseCwdFilingTemplateDetail generateBase(){
		BaseCwdFilingTemplateDetail b = new BaseCwdFilingTemplateDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdFilingTemplateDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCwdFilingTemplateDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCwdFilingTemplateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperatorId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdFilingTemplateDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCwdFilingTemplateDetailId();
		buff[count++] = b.getFileName();
		buff[count++] = b.getParentId();
		buff[count++] = b.getCwdFilingTemplateId();
		buff[count++] = b.getOperatorId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BaseCwdFilingTemplateDetail b){
		if(b.getCwdFilingTemplateDetailId() != null) setCwdFilingTemplateDetailIdClear(b.getCwdFilingTemplateDetailId());
		if(b.getFileName() != null) setFileName(b.getFileName());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getCwdFilingTemplateId() != null) setCwdFilingTemplateId(b.getCwdFilingTemplateId());
		if(b.getOperatorId() != null) setOperatorId(b.getOperatorId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BaseCwdFilingTemplateDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdFilingTemplateDetail b = new BaseCwdFilingTemplateDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdFilingTemplateDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdFilingTemplateDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdFilingTemplateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setCwdFilingTemplateDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCwdFilingTemplateDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCwdFilingTemplateDetailIdClear(java.lang.Integer val) {
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

	public void setCwdFilingTemplateId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getCwdFilingTemplateId() {
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

	public void setConditionCwdFilingTemplateDetailId(String op, java.lang.Integer val) {
		setConditionCwdFilingTemplateDetailId(op, val, CONDITION_AND);
	}

	public void setConditionCwdFilingTemplateDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCwdFilingTemplateDetailId(boolean val) {
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

	public void setConditionCwdFilingTemplateId(String op, java.lang.Integer val) {
		setConditionCwdFilingTemplateId(op, val, CONDITION_AND);
	}

	public void setConditionCwdFilingTemplateId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectCwdFilingTemplateId(boolean val) {
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


}

