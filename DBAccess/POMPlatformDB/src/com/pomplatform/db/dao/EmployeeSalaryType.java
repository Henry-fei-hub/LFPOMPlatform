package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseEmployeeSalaryType;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class EmployeeSalaryType extends AbstractTable<BaseEmployeeSalaryType>
{

	public EmployeeSalaryType() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 11;

		initTables();

		__tableName            = "employee_salary_types";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEmployeeSalaryType.CS_EMPLOYEE_SALARY_TYPE_ID;
		__column_names[1] = BaseEmployeeSalaryType.CS_EMPLOYEE_ID;
		__column_names[2] = BaseEmployeeSalaryType.CS_EMPLOYEE_NAME;
		__column_names[3] = BaseEmployeeSalaryType.CS_EMPLOYEE_NO;
		__column_names[4] = BaseEmployeeSalaryType.CS_PLATE_ID;
		__column_names[5] = BaseEmployeeSalaryType.CS_YEAR;
		__column_names[6] = BaseEmployeeSalaryType.CS_MONTH;
		__column_names[7] = BaseEmployeeSalaryType.CS_SALARY_TYPE;
		__column_names[8] = BaseEmployeeSalaryType.CS_FUNDRAISING_PROJECT_TYPE;
		__column_names[9] = BaseEmployeeSalaryType.CS_FUNDRAISING_PROJECT_RATE;
		__column_names[10] = BaseEmployeeSalaryType.CS_COMPANY_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEmployeeSalaryType b) {
		clear();
		setEmployeeSalaryTypeIdClear(b.getEmployeeSalaryTypeId());
	}

	public boolean isPrimaryKeyNull() {
		return getEmployeeSalaryTypeId() == null;
	}

	@Override
	public BaseEmployeeSalaryType generateBase(){
		BaseEmployeeSalaryType b = new BaseEmployeeSalaryType();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEmployeeSalaryType b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEmployeeSalaryTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmployeeNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSalaryType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFundraisingProjectType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFundraisingProjectRate(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseEmployeeSalaryType b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEmployeeSalaryTypeId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getEmployeeName();
		buff[count++] = b.getEmployeeNo();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getSalaryType();
		buff[count++] = b.getFundraisingProjectType();
		buff[count++] = b.getFundraisingProjectRate();
		buff[count++] = b.getCompanyId();
	}

	@Override
	public void setDataFromBase(BaseEmployeeSalaryType b){
		if(b.getEmployeeSalaryTypeId() != null) setEmployeeSalaryTypeIdClear(b.getEmployeeSalaryTypeId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getEmployeeName() != null) setEmployeeName(b.getEmployeeName());
		if(b.getEmployeeNo() != null) setEmployeeNo(b.getEmployeeNo());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getSalaryType() != null) setSalaryType(b.getSalaryType());
		if(b.getFundraisingProjectType() != null) setFundraisingProjectType(b.getFundraisingProjectType());
		if(b.getFundraisingProjectRate() != null) setFundraisingProjectRate(b.getFundraisingProjectRate());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
	}

	@Override
	public BaseEmployeeSalaryType generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEmployeeSalaryType b = new BaseEmployeeSalaryType();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEmployeeSalaryType __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeSalaryTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalaryType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFundraisingProjectType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFundraisingProjectRate(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
	}

	public void setEmployeeSalaryTypeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEmployeeSalaryTypeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEmployeeSalaryTypeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEmployeeName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getEmployeeName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setEmployeeNo(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getEmployeeNo() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setSalaryType(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getSalaryType() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setFundraisingProjectType(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getFundraisingProjectType() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setFundraisingProjectRate(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getFundraisingProjectRate() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setConditionEmployeeSalaryTypeId(String op, java.lang.Integer val) {
		setConditionEmployeeSalaryTypeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeSalaryTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEmployeeSalaryTypeId(boolean val) {
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

	public void setConditionEmployeeName(String op, java.lang.String val) {
		setConditionEmployeeName(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectEmployeeName(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionEmployeeNo(String op, java.lang.String val) {
		setConditionEmployeeNo(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeNo(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectEmployeeNo(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionSalaryType(String op, java.lang.Integer val) {
		setConditionSalaryType(op, val, CONDITION_AND);
	}

	public void setConditionSalaryType(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectSalaryType(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionFundraisingProjectType(String op, java.lang.Integer val) {
		setConditionFundraisingProjectType(op, val, CONDITION_AND);
	}

	public void setConditionFundraisingProjectType(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectFundraisingProjectType(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionFundraisingProjectRate(String op, java.math.BigDecimal val) {
		setConditionFundraisingProjectRate(op, val, CONDITION_AND);
	}

	public void setConditionFundraisingProjectRate(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectFundraisingProjectRate(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[10] = val;
	}


}

