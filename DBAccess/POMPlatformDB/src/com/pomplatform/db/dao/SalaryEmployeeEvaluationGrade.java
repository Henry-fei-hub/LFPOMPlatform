package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSalaryEmployeeEvaluationGrade;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SalaryEmployeeEvaluationGrade extends AbstractTable<BaseSalaryEmployeeEvaluationGrade>
{

	public SalaryEmployeeEvaluationGrade() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 9;

		initTables();

		__tableName            = "salary_employee_evaluation_grade";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSalaryEmployeeEvaluationGrade.CS_SALARY_EMPLOYEE_EVALUATION_GRADE_ID;
		__column_names[1] = BaseSalaryEmployeeEvaluationGrade.CS_GRADE;
		__column_names[2] = BaseSalaryEmployeeEvaluationGrade.CS_PROPORTION;
		__column_names[3] = BaseSalaryEmployeeEvaluationGrade.CS_START_DATE;
		__column_names[4] = BaseSalaryEmployeeEvaluationGrade.CS_END_DATE;
		__column_names[5] = BaseSalaryEmployeeEvaluationGrade.CS_CREATE_TIME;
		__column_names[6] = BaseSalaryEmployeeEvaluationGrade.CS_OPERATOR;
		__column_names[7] = BaseSalaryEmployeeEvaluationGrade.CS_YEAR;
		__column_names[8] = BaseSalaryEmployeeEvaluationGrade.CS_FLAG;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSalaryEmployeeEvaluationGrade b) {
		clear();
		setSalaryEmployeeEvaluationGradeIdClear(b.getSalaryEmployeeEvaluationGradeId());
	}

	public boolean isPrimaryKeyNull() {
		return getSalaryEmployeeEvaluationGradeId() == null;
	}

	@Override
	public BaseSalaryEmployeeEvaluationGrade generateBase(){
		BaseSalaryEmployeeEvaluationGrade b = new BaseSalaryEmployeeEvaluationGrade();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSalaryEmployeeEvaluationGrade b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSalaryEmployeeEvaluationGradeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setGrade(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProportion(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFlag(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseSalaryEmployeeEvaluationGrade b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSalaryEmployeeEvaluationGradeId();
		buff[count++] = b.getGrade();
		buff[count++] = b.getProportion();
		buff[count++] = generateTimestampFromDate(b.getStartDate());
		buff[count++] = generateTimestampFromDate(b.getEndDate());
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getOperator();
		buff[count++] = b.getYear();
		buff[count++] = b.getFlag();
	}

	@Override
	public void setDataFromBase(BaseSalaryEmployeeEvaluationGrade b){
		if(b.getSalaryEmployeeEvaluationGradeId() != null) setSalaryEmployeeEvaluationGradeIdClear(b.getSalaryEmployeeEvaluationGradeId());
		if(b.getGrade() != null) setGrade(b.getGrade());
		if(b.getProportion() != null) setProportion(b.getProportion());
		if(b.getStartDate() != null) setStartDate(b.getStartDate());
		if(b.getEndDate() != null) setEndDate(b.getEndDate());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getFlag() != null) setFlag(b.getFlag());
	}

	@Override
	public BaseSalaryEmployeeEvaluationGrade generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSalaryEmployeeEvaluationGrade b = new BaseSalaryEmployeeEvaluationGrade();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSalaryEmployeeEvaluationGrade __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalaryEmployeeEvaluationGradeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setGrade(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProportion(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFlag(GenericBase.__getInt(val));
	}

	public void setSalaryEmployeeEvaluationGradeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSalaryEmployeeEvaluationGradeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSalaryEmployeeEvaluationGradeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setGrade(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getGrade() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setProportion(java.math.BigDecimal val) {
		setCurrentData(2, val);
	}

	public java.math.BigDecimal getProportion() {
		return GenericBase.__getDecimal(__current_data[2]);
	}

	public void setStartDate(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getStartDate() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setEndDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getEndDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setFlag(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getFlag() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setConditionSalaryEmployeeEvaluationGradeId(String op, java.lang.Integer val) {
		setConditionSalaryEmployeeEvaluationGradeId(op, val, CONDITION_AND);
	}

	public void setConditionSalaryEmployeeEvaluationGradeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSalaryEmployeeEvaluationGradeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionGrade(String op, java.lang.String val) {
		setConditionGrade(op, val, CONDITION_AND);
	}

	public void setConditionGrade(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectGrade(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionProportion(String op, java.math.BigDecimal val) {
		setConditionProportion(op, val, CONDITION_AND);
	}

	public void setConditionProportion(String op, java.math.BigDecimal val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProportion(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionStartDate(String op, java.util.Date val) {
		setConditionStartDate(op, val, CONDITION_AND);
	}

	public void setConditionStartDate(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectStartDate(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionEndDate(String op, java.util.Date val) {
		setConditionEndDate(op, val, CONDITION_AND);
	}

	public void setConditionEndDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectEndDate(boolean val) {
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

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionFlag(String op, java.lang.Integer val) {
		setConditionFlag(op, val, CONDITION_AND);
	}

	public void setConditionFlag(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectFlag(boolean val) {
		__select_flags[8] = val;
	}


}

