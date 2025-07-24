package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdTaskTemplate;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdTaskTemplate extends AbstractTable<BaseCwdTaskTemplate>
{

	public CwdTaskTemplate() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 12;

		initTables();

		__tableName            = "cwd_task_templates";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdTaskTemplate.CS_CWD_TASK_TEMPLATE_ID;
		__column_names[1] = BaseCwdTaskTemplate.CS_TEMPLATE_NAME;
		__column_names[2] = BaseCwdTaskTemplate.CS_PROJECT_AREA;
		__column_names[3] = BaseCwdTaskTemplate.CS_OPERATOR;
		__column_names[4] = BaseCwdTaskTemplate.CS_CREATE_TIME;
		__column_names[5] = BaseCwdTaskTemplate.CS_DEPARTMENT_ID;
		__column_names[6] = BaseCwdTaskTemplate.CS_COMPANY_ID;
		__column_names[7] = BaseCwdTaskTemplate.CS_COMPANY_NO;
		__column_names[8] = BaseCwdTaskTemplate.CS_NUMBER_OF_DAY;
		__column_names[9] = BaseCwdTaskTemplate.CS_PROJECT_LEVEL;
		__column_names[10] = BaseCwdTaskTemplate.CS_NUMBER_OF_PARTICIPANT;
		__column_names[11] = BaseCwdTaskTemplate.CS_MAIN_PROJECT_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdTaskTemplate b) {
		clear();
		setCwdTaskTemplateIdClear(b.getCwdTaskTemplateId());
	}

	public boolean isPrimaryKeyNull() {
		return getCwdTaskTemplateId() == null;
	}

	@Override
	public BaseCwdTaskTemplate generateBase(){
		BaseCwdTaskTemplate b = new BaseCwdTaskTemplate();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdTaskTemplate b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCwdTaskTemplateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTemplateName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectArea(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setNumberOfDay(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectLevel(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setNumberOfParticipant(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdTaskTemplate b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCwdTaskTemplateId();
		buff[count++] = b.getTemplateName();
		buff[count++] = b.getProjectArea();
		buff[count++] = b.getOperator();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getCompanyNo();
		buff[count++] = b.getNumberOfDay();
		buff[count++] = b.getProjectLevel();
		buff[count++] = b.getNumberOfParticipant();
		buff[count++] = b.getMainProjectId();
	}

	@Override
	public void setDataFromBase(BaseCwdTaskTemplate b){
		if(b.getCwdTaskTemplateId() != null) setCwdTaskTemplateIdClear(b.getCwdTaskTemplateId());
		if(b.getTemplateName() != null) setTemplateName(b.getTemplateName());
		if(b.getProjectArea() != null) setProjectArea(b.getProjectArea());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getCompanyNo() != null) setCompanyNo(b.getCompanyNo());
		if(b.getNumberOfDay() != null) setNumberOfDay(b.getNumberOfDay());
		if(b.getProjectLevel() != null) setProjectLevel(b.getProjectLevel());
		if(b.getNumberOfParticipant() != null) setNumberOfParticipant(b.getNumberOfParticipant());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
	}

	@Override
	public BaseCwdTaskTemplate generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdTaskTemplate b = new BaseCwdTaskTemplate();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdTaskTemplate __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdTaskTemplateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTemplateName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectArea(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNumberOfDay(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectLevel(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNumberOfParticipant(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
	}

	public void setCwdTaskTemplateId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCwdTaskTemplateId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCwdTaskTemplateIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setTemplateName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getTemplateName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setProjectArea(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getProjectArea() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setCompanyNo(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getCompanyNo() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setNumberOfDay(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getNumberOfDay() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setProjectLevel(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getProjectLevel() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setNumberOfParticipant(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getNumberOfParticipant() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setConditionCwdTaskTemplateId(String op, java.lang.Integer val) {
		setConditionCwdTaskTemplateId(op, val, CONDITION_AND);
	}

	public void setConditionCwdTaskTemplateId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCwdTaskTemplateId(boolean val) {
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

	public void setConditionProjectArea(String op, java.lang.Integer val) {
		setConditionProjectArea(op, val, CONDITION_AND);
	}

	public void setConditionProjectArea(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProjectArea(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
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

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionCompanyNo(String op, java.lang.String val) {
		setConditionCompanyNo(op, val, CONDITION_AND);
	}

	public void setConditionCompanyNo(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectCompanyNo(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionNumberOfDay(String op, java.lang.Integer val) {
		setConditionNumberOfDay(op, val, CONDITION_AND);
	}

	public void setConditionNumberOfDay(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectNumberOfDay(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionProjectLevel(String op, java.lang.Integer val) {
		setConditionProjectLevel(op, val, CONDITION_AND);
	}

	public void setConditionProjectLevel(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectProjectLevel(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionNumberOfParticipant(String op, java.lang.Integer val) {
		setConditionNumberOfParticipant(op, val, CONDITION_AND);
	}

	public void setConditionNumberOfParticipant(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectNumberOfParticipant(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val) {
		setConditionMainProjectId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectMainProjectId(boolean val) {
		__select_flags[11] = val;
	}


}

