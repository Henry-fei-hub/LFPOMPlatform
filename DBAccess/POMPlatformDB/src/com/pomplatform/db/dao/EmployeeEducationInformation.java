package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseEmployeeEducationInformation;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class EmployeeEducationInformation extends AbstractTable<BaseEmployeeEducationInformation>
{

	public EmployeeEducationInformation() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "employee_education_informations";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEmployeeEducationInformation.CS_EMPLOYEE_EDUCATION_INFORMATION_ID;
		__column_names[1] = BaseEmployeeEducationInformation.CS_EMPLOYEE_ID;
		__column_names[2] = BaseEmployeeEducationInformation.CS_GRADUATED_SCHOOL;
		__column_names[3] = BaseEmployeeEducationInformation.CS_SPECIALTY;
		__column_names[4] = BaseEmployeeEducationInformation.CS_START_DATE;
		__column_names[5] = BaseEmployeeEducationInformation.CS_END_DATE;
		__column_names[6] = BaseEmployeeEducationInformation.CS_EDUCATION;
		__column_names[7] = BaseEmployeeEducationInformation.CS_DEGREE;
		__column_names[8] = BaseEmployeeEducationInformation.CS_LEARNING_WAY;
		__column_names[9] = BaseEmployeeEducationInformation.CS_ATTACHMENT;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEmployeeEducationInformation b) {
		clear();
		setEmployeeEducationInformationIdClear(b.getEmployeeEducationInformationId());
	}

	public boolean isPrimaryKeyNull() {
		return getEmployeeEducationInformationId() == null;
	}

	@Override
	public BaseEmployeeEducationInformation generateBase(){
		BaseEmployeeEducationInformation b = new BaseEmployeeEducationInformation();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEmployeeEducationInformation b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEmployeeEducationInformationId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setGraduatedSchool(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSpecialty(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEducation(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDegree(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLearningWay(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAttachment(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseEmployeeEducationInformation b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEmployeeEducationInformationId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getGraduatedSchool();
		buff[count++] = b.getSpecialty();
		buff[count++] = generateTimestampFromDate(b.getStartDate());
		buff[count++] = generateTimestampFromDate(b.getEndDate());
		buff[count++] = b.getEducation();
		buff[count++] = b.getDegree();
		buff[count++] = b.getLearningWay();
		buff[count++] = b.getAttachment();
	}

	@Override
	public void setDataFromBase(BaseEmployeeEducationInformation b){
		if(b.getEmployeeEducationInformationId() != null) setEmployeeEducationInformationIdClear(b.getEmployeeEducationInformationId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getGraduatedSchool() != null) setGraduatedSchool(b.getGraduatedSchool());
		if(b.getSpecialty() != null) setSpecialty(b.getSpecialty());
		if(b.getStartDate() != null) setStartDate(b.getStartDate());
		if(b.getEndDate() != null) setEndDate(b.getEndDate());
		if(b.getEducation() != null) setEducation(b.getEducation());
		if(b.getDegree() != null) setDegree(b.getDegree());
		if(b.getLearningWay() != null) setLearningWay(b.getLearningWay());
		if(b.getAttachment() != null) setAttachment(b.getAttachment());
	}

	@Override
	public BaseEmployeeEducationInformation generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEmployeeEducationInformation b = new BaseEmployeeEducationInformation();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEmployeeEducationInformation __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeEducationInformationId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setGraduatedSchool(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialty(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEducation(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDegree(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLearningWay(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachment(GenericBase.__getString(val));
	}

	public void setEmployeeEducationInformationId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEmployeeEducationInformationId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEmployeeEducationInformationIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setGraduatedSchool(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getGraduatedSchool() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setSpecialty(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getSpecialty() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setStartDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getStartDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setEndDate(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getEndDate() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setEducation(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getEducation() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setDegree(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getDegree() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setLearningWay(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getLearningWay() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setAttachment(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getAttachment() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setConditionEmployeeEducationInformationId(String op, java.lang.Integer val) {
		setConditionEmployeeEducationInformationId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeEducationInformationId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEmployeeEducationInformationId(boolean val) {
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

	public void setConditionGraduatedSchool(String op, java.lang.String val) {
		setConditionGraduatedSchool(op, val, CONDITION_AND);
	}

	public void setConditionGraduatedSchool(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectGraduatedSchool(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionSpecialty(String op, java.lang.String val) {
		setConditionSpecialty(op, val, CONDITION_AND);
	}

	public void setConditionSpecialty(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectSpecialty(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionStartDate(String op, java.util.Date val) {
		setConditionStartDate(op, val, CONDITION_AND);
	}

	public void setConditionStartDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectStartDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionEndDate(String op, java.util.Date val) {
		setConditionEndDate(op, val, CONDITION_AND);
	}

	public void setConditionEndDate(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectEndDate(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionEducation(String op, java.lang.Integer val) {
		setConditionEducation(op, val, CONDITION_AND);
	}

	public void setConditionEducation(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectEducation(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionDegree(String op, java.lang.Integer val) {
		setConditionDegree(op, val, CONDITION_AND);
	}

	public void setConditionDegree(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectDegree(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionLearningWay(String op, java.lang.Integer val) {
		setConditionLearningWay(op, val, CONDITION_AND);
	}

	public void setConditionLearningWay(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectLearningWay(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionAttachment(String op, java.lang.String val) {
		setConditionAttachment(op, val, CONDITION_AND);
	}

	public void setConditionAttachment(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectAttachment(boolean val) {
		__select_flags[9] = val;
	}


}

