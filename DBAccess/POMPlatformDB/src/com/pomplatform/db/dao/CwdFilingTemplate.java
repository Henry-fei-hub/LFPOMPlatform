package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdFilingTemplate;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdFilingTemplate extends AbstractTable<BaseCwdFilingTemplate>
{

	public CwdFilingTemplate() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "cwd_filing_templates";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdFilingTemplate.CS_CWD_FILING_TEMPLATE_ID;
		__column_names[1] = BaseCwdFilingTemplate.CS_TEMPLATE_NAME;
		__column_names[2] = BaseCwdFilingTemplate.CS_FILING_TYPE;
		__column_names[3] = BaseCwdFilingTemplate.CS_OPERATOR_ID;
		__column_names[4] = BaseCwdFilingTemplate.CS_REMARK;
		__column_names[5] = BaseCwdFilingTemplate.CS_CREATE_TIME;
		__column_names[6] = BaseCwdFilingTemplate.CS_CWD_FILING_MAIN_TEMPLATE_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdFilingTemplate b) {
		clear();
		setCwdFilingTemplateIdClear(b.getCwdFilingTemplateId());
	}

	public boolean isPrimaryKeyNull() {
		return getCwdFilingTemplateId() == null;
	}

	@Override
	public BaseCwdFilingTemplate generateBase(){
		BaseCwdFilingTemplate b = new BaseCwdFilingTemplate();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdFilingTemplate b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCwdFilingTemplateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTemplateName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFilingType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperatorId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCwdFilingMainTemplateId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdFilingTemplate b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCwdFilingTemplateId();
		buff[count++] = b.getTemplateName();
		buff[count++] = b.getFilingType();
		buff[count++] = b.getOperatorId();
		buff[count++] = b.getRemark();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getCwdFilingMainTemplateId();
	}

	@Override
	public void setDataFromBase(BaseCwdFilingTemplate b){
		if(b.getCwdFilingTemplateId() != null) setCwdFilingTemplateIdClear(b.getCwdFilingTemplateId());
		if(b.getTemplateName() != null) setTemplateName(b.getTemplateName());
		if(b.getFilingType() != null) setFilingType(b.getFilingType());
		if(b.getOperatorId() != null) setOperatorId(b.getOperatorId());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getCwdFilingMainTemplateId() != null) setCwdFilingMainTemplateId(b.getCwdFilingMainTemplateId());
	}

	@Override
	public BaseCwdFilingTemplate generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdFilingTemplate b = new BaseCwdFilingTemplate();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdFilingTemplate __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdFilingTemplateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTemplateName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFilingType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdFilingMainTemplateId(GenericBase.__getInt(val));
	}

	public void setCwdFilingTemplateId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCwdFilingTemplateId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCwdFilingTemplateIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setTemplateName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getTemplateName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setFilingType(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getFilingType() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setOperatorId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getOperatorId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setCwdFilingMainTemplateId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getCwdFilingMainTemplateId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setConditionCwdFilingTemplateId(String op, java.lang.Integer val) {
		setConditionCwdFilingTemplateId(op, val, CONDITION_AND);
	}

	public void setConditionCwdFilingTemplateId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCwdFilingTemplateId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionTemplateName(String op, java.lang.String val) {
		setConditionTemplateName(op, val, CONDITION_AND);
	}

	public void setConditionTemplateName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectTemplateName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionFilingType(String op, java.lang.Integer val) {
		setConditionFilingType(op, val, CONDITION_AND);
	}

	public void setConditionFilingType(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectFilingType(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionOperatorId(String op, java.lang.Integer val) {
		setConditionOperatorId(op, val, CONDITION_AND);
	}

	public void setConditionOperatorId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectOperatorId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
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

	public void setConditionCwdFilingMainTemplateId(String op, java.lang.Integer val) {
		setConditionCwdFilingMainTemplateId(op, val, CONDITION_AND);
	}

	public void setConditionCwdFilingMainTemplateId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectCwdFilingMainTemplateId(boolean val) {
		__select_flags[6] = val;
	}


}

