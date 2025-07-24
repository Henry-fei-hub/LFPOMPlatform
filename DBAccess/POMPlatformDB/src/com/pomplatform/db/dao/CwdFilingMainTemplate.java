package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdFilingMainTemplate;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdFilingMainTemplate extends AbstractTable<BaseCwdFilingMainTemplate>
{

	public CwdFilingMainTemplate() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "cwd_filing_main_templates";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdFilingMainTemplate.CS_CWD_FILING_MAIN_TEMPLATE_ID;
		__column_names[1] = BaseCwdFilingMainTemplate.CS_TEMPLATE_NAME;
		__column_names[2] = BaseCwdFilingMainTemplate.CS_PROJECT_TYPE;
		__column_names[3] = BaseCwdFilingMainTemplate.CS_OPERATOR_ID;
		__column_names[4] = BaseCwdFilingMainTemplate.CS_DEPARTMENT_ID;
		__column_names[5] = BaseCwdFilingMainTemplate.CS_REMARK;
		__column_names[6] = BaseCwdFilingMainTemplate.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdFilingMainTemplate b) {
		clear();
		setCwdFilingMainTemplateIdClear(b.getCwdFilingMainTemplateId());
	}

	public boolean isPrimaryKeyNull() {
		return getCwdFilingMainTemplateId() == null;
	}

	@Override
	public BaseCwdFilingMainTemplate generateBase(){
		BaseCwdFilingMainTemplate b = new BaseCwdFilingMainTemplate();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdFilingMainTemplate b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCwdFilingMainTemplateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTemplateName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperatorId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdFilingMainTemplate b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCwdFilingMainTemplateId();
		buff[count++] = b.getTemplateName();
		buff[count++] = b.getProjectType();
		buff[count++] = b.getOperatorId();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getRemark();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BaseCwdFilingMainTemplate b){
		if(b.getCwdFilingMainTemplateId() != null) setCwdFilingMainTemplateIdClear(b.getCwdFilingMainTemplateId());
		if(b.getTemplateName() != null) setTemplateName(b.getTemplateName());
		if(b.getProjectType() != null) setProjectType(b.getProjectType());
		if(b.getOperatorId() != null) setOperatorId(b.getOperatorId());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BaseCwdFilingMainTemplate generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdFilingMainTemplate b = new BaseCwdFilingMainTemplate();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdFilingMainTemplate __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdFilingMainTemplateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTemplateName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setCwdFilingMainTemplateId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCwdFilingMainTemplateId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCwdFilingMainTemplateIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setTemplateName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getTemplateName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setProjectType(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getProjectType() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setOperatorId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getOperatorId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setConditionCwdFilingMainTemplateId(String op, java.lang.Integer val) {
		setConditionCwdFilingMainTemplateId(op, val, CONDITION_AND);
	}

	public void setConditionCwdFilingMainTemplateId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCwdFilingMainTemplateId(boolean val) {
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

	public void setConditionProjectType(String op, java.lang.Integer val) {
		setConditionProjectType(op, val, CONDITION_AND);
	}

	public void setConditionProjectType(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProjectType(boolean val) {
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

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[6] = val;
	}


}

