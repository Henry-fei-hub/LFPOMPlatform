package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSalaryInsteadDeductIll;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SalaryInsteadDeductIll extends AbstractTable<BaseSalaryInsteadDeductIll>
{

	public SalaryInsteadDeductIll() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "salary_instead_deduct_ills";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSalaryInsteadDeductIll.CS_SALARY_INSTEAD_DEDUCT_ILL_ID;
		__column_names[1] = BaseSalaryInsteadDeductIll.CS_EMPLOYEE_ID;
		__column_names[2] = BaseSalaryInsteadDeductIll.CS_YEAR;
		__column_names[3] = BaseSalaryInsteadDeductIll.CS_MONTH;
		__column_names[4] = BaseSalaryInsteadDeductIll.CS_RECORD_DATE;
		__column_names[5] = BaseSalaryInsteadDeductIll.CS_INSTEAD_DEDUCT_ILL;
		__column_names[6] = BaseSalaryInsteadDeductIll.CS_IS_SENDED;
		__column_names[7] = BaseSalaryInsteadDeductIll.CS_OPERATE_EMPLOYEE_ID;
		__column_names[8] = BaseSalaryInsteadDeductIll.CS_OPERATE_TIME;
		__column_names[9] = BaseSalaryInsteadDeductIll.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSalaryInsteadDeductIll b) {
		clear();
		setSalaryInsteadDeductIllIdClear(b.getSalaryInsteadDeductIllId());
	}

	public boolean isPrimaryKeyNull() {
		return getSalaryInsteadDeductIllId() == null;
	}

	@Override
	public BaseSalaryInsteadDeductIll generateBase(){
		BaseSalaryInsteadDeductIll b = new BaseSalaryInsteadDeductIll();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSalaryInsteadDeductIll b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSalaryInsteadDeductIllId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setInsteadDeductIll(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsSended(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseSalaryInsteadDeductIll b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSalaryInsteadDeductIllId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = b.getInsteadDeductIll();
		buff[count++] = b.getIsSended();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseSalaryInsteadDeductIll b){
		if(b.getSalaryInsteadDeductIllId() != null) setSalaryInsteadDeductIllIdClear(b.getSalaryInsteadDeductIllId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getInsteadDeductIll() != null) setInsteadDeductIll(b.getInsteadDeductIll());
		if(b.getIsSended() != null) setIsSended(b.getIsSended());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseSalaryInsteadDeductIll generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSalaryInsteadDeductIll b = new BaseSalaryInsteadDeductIll();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSalaryInsteadDeductIll __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalaryInsteadDeductIllId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInsteadDeductIll(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsSended(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setSalaryInsteadDeductIllId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSalaryInsteadDeductIllId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSalaryInsteadDeductIllIdClear(java.lang.Integer val) {
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

	public void setRecordDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setInsteadDeductIll(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getInsteadDeductIll() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setIsSended(java.lang.Boolean val) {
		setCurrentData(6, val);
	}

	public java.lang.Boolean getIsSended() {
		return GenericBase.__getBoolean(__current_data[6]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setConditionSalaryInsteadDeductIllId(String op, java.lang.Integer val) {
		setConditionSalaryInsteadDeductIllId(op, val, CONDITION_AND);
	}

	public void setConditionSalaryInsteadDeductIllId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSalaryInsteadDeductIllId(boolean val) {
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

	public void setConditionRecordDate(String op, java.util.Date val) {
		setConditionRecordDate(op, val, CONDITION_AND);
	}

	public void setConditionRecordDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionInsteadDeductIll(String op, java.lang.String val) {
		setConditionInsteadDeductIll(op, val, CONDITION_AND);
	}

	public void setConditionInsteadDeductIll(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectInsteadDeductIll(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionIsSended(String op, java.lang.Boolean val) {
		setConditionIsSended(op, val, CONDITION_AND);
	}

	public void setConditionIsSended(String op, java.lang.Boolean val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectIsSended(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[9] = val;
	}


}

