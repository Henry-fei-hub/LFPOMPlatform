package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseEmployeeTechnicalTitle;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class EmployeeTechnicalTitle extends AbstractTable<BaseEmployeeTechnicalTitle>
{

	public EmployeeTechnicalTitle() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "employee_technical_titles";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEmployeeTechnicalTitle.CS_EMPLOYEE_TECHNICAL_TITLE_ID;
		__column_names[1] = BaseEmployeeTechnicalTitle.CS_EMPLOYEE_ID;
		__column_names[2] = BaseEmployeeTechnicalTitle.CS_TECHNICAL_TITLES;
		__column_names[3] = BaseEmployeeTechnicalTitle.CS_TECHNICAL_SPECIALTY;
		__column_names[4] = BaseEmployeeTechnicalTitle.CS_TECHNICAL_LEVEL;
		__column_names[5] = BaseEmployeeTechnicalTitle.CS_ASSESSMENT_TIME;
		__column_names[6] = BaseEmployeeTechnicalTitle.CS_ATTACHMENT;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEmployeeTechnicalTitle b) {
		clear();
		setEmployeeTechnicalTitleIdClear(b.getEmployeeTechnicalTitleId());
	}

	public boolean isPrimaryKeyNull() {
		return getEmployeeTechnicalTitleId() == null;
	}

	@Override
	public BaseEmployeeTechnicalTitle generateBase(){
		BaseEmployeeTechnicalTitle b = new BaseEmployeeTechnicalTitle();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEmployeeTechnicalTitle b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEmployeeTechnicalTitleId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTechnicalTitles(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTechnicalSpecialty(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTechnicalLevel(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAssessmentTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setAttachment(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseEmployeeTechnicalTitle b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEmployeeTechnicalTitleId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getTechnicalTitles();
		buff[count++] = b.getTechnicalSpecialty();
		buff[count++] = b.getTechnicalLevel();
		buff[count++] = generateTimestampFromDate(b.getAssessmentTime());
		buff[count++] = b.getAttachment();
	}

	@Override
	public void setDataFromBase(BaseEmployeeTechnicalTitle b){
		if(b.getEmployeeTechnicalTitleId() != null) setEmployeeTechnicalTitleIdClear(b.getEmployeeTechnicalTitleId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getTechnicalTitles() != null) setTechnicalTitles(b.getTechnicalTitles());
		if(b.getTechnicalSpecialty() != null) setTechnicalSpecialty(b.getTechnicalSpecialty());
		if(b.getTechnicalLevel() != null) setTechnicalLevel(b.getTechnicalLevel());
		if(b.getAssessmentTime() != null) setAssessmentTime(b.getAssessmentTime());
		if(b.getAttachment() != null) setAttachment(b.getAttachment());
	}

	@Override
	public BaseEmployeeTechnicalTitle generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEmployeeTechnicalTitle b = new BaseEmployeeTechnicalTitle();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEmployeeTechnicalTitle __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeTechnicalTitleId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTechnicalTitles(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTechnicalSpecialty(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTechnicalLevel(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAssessmentTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachment(GenericBase.__getString(val));
	}

	public void setEmployeeTechnicalTitleId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEmployeeTechnicalTitleId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEmployeeTechnicalTitleIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setTechnicalTitles(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getTechnicalTitles() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setTechnicalSpecialty(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getTechnicalSpecialty() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setTechnicalLevel(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getTechnicalLevel() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setAssessmentTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getAssessmentTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setAttachment(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getAttachment() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setConditionEmployeeTechnicalTitleId(String op, java.lang.Integer val) {
		setConditionEmployeeTechnicalTitleId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeTechnicalTitleId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEmployeeTechnicalTitleId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionTechnicalTitles(String op, java.lang.String val) {
		setConditionTechnicalTitles(op, val, CONDITION_AND);
	}

	public void setConditionTechnicalTitles(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectTechnicalTitles(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionTechnicalSpecialty(String op, java.lang.String val) {
		setConditionTechnicalSpecialty(op, val, CONDITION_AND);
	}

	public void setConditionTechnicalSpecialty(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectTechnicalSpecialty(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionTechnicalLevel(String op, java.lang.String val) {
		setConditionTechnicalLevel(op, val, CONDITION_AND);
	}

	public void setConditionTechnicalLevel(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectTechnicalLevel(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionAssessmentTime(String op, java.util.Date val) {
		setConditionAssessmentTime(op, val, CONDITION_AND);
	}

	public void setConditionAssessmentTime(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectAssessmentTime(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionAttachment(String op, java.lang.String val) {
		setConditionAttachment(op, val, CONDITION_AND);
	}

	public void setConditionAttachment(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectAttachment(boolean val) {
		__select_flags[6] = val;
	}


}

