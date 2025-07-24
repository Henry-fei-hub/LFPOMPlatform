package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSalaryEmployeeEvaluation;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SalaryEmployeeEvaluation extends AbstractTable<BaseSalaryEmployeeEvaluation>
{

	public SalaryEmployeeEvaluation() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 9;

		initTables();

		__tableName            = "salary_employee_evaluation";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSalaryEmployeeEvaluation.CS_SALARY_EMPLOYEE_EVALUATION_ID;
		__column_names[1] = BaseSalaryEmployeeEvaluation.CS_EMPLOYEE_ID;
		__column_names[2] = BaseSalaryEmployeeEvaluation.CS_YEAR;
		__column_names[3] = BaseSalaryEmployeeEvaluation.CS_MONTH;
		__column_names[4] = BaseSalaryEmployeeEvaluation.CS_GRADE;
		__column_names[5] = BaseSalaryEmployeeEvaluation.CS_HAPPEN_DATE;
		__column_names[6] = BaseSalaryEmployeeEvaluation.CS_OPERATE_EMPLOYEE_ID;
		__column_names[7] = BaseSalaryEmployeeEvaluation.CS_OPERATE_TIME;
		__column_names[8] = BaseSalaryEmployeeEvaluation.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSalaryEmployeeEvaluation b) {
		clear();
		setSalaryEmployeeEvaluationIdClear(b.getSalaryEmployeeEvaluationId());
	}

	public boolean isPrimaryKeyNull() {
		return getSalaryEmployeeEvaluationId() == null;
	}

	@Override
	public BaseSalaryEmployeeEvaluation generateBase(){
		BaseSalaryEmployeeEvaluation b = new BaseSalaryEmployeeEvaluation();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSalaryEmployeeEvaluation b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSalaryEmployeeEvaluationId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setGrade(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setHappenDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseSalaryEmployeeEvaluation b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSalaryEmployeeEvaluationId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getGrade();
		buff[count++] = generateTimestampFromDate(b.getHappenDate());
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseSalaryEmployeeEvaluation b){
		if(b.getSalaryEmployeeEvaluationId() != null) setSalaryEmployeeEvaluationIdClear(b.getSalaryEmployeeEvaluationId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getGrade() != null) setGrade(b.getGrade());
		if(b.getHappenDate() != null) setHappenDate(b.getHappenDate());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseSalaryEmployeeEvaluation generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSalaryEmployeeEvaluation b = new BaseSalaryEmployeeEvaluation();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSalaryEmployeeEvaluation __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalaryEmployeeEvaluationId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setGrade(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHappenDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setSalaryEmployeeEvaluationId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSalaryEmployeeEvaluationId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSalaryEmployeeEvaluationIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setGrade(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getGrade() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setHappenDate(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getHappenDate() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setConditionSalaryEmployeeEvaluationId(String op, java.lang.Integer val) {
		setConditionSalaryEmployeeEvaluationId(op, val, CONDITION_AND);
	}

	public void setConditionSalaryEmployeeEvaluationId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSalaryEmployeeEvaluationId(boolean val) {
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

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionGrade(String op, java.lang.String val) {
		setConditionGrade(op, val, CONDITION_AND);
	}

	public void setConditionGrade(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectGrade(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionHappenDate(String op, java.util.Date val) {
		setConditionHappenDate(op, val, CONDITION_AND);
	}

	public void setConditionHappenDate(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectHappenDate(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[8] = val;
	}


}

