package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePlateIncomeAndExpenditure;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PlateIncomeAndExpenditure extends AbstractTable<BasePlateIncomeAndExpenditure>
{

	public PlateIncomeAndExpenditure() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 11;

		initTables();

		__tableName            = "plate_income_and_expenditures";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePlateIncomeAndExpenditure.CS_PLATE_INCOME_AND_EXPENDITURE_ID;
		__column_names[1] = BasePlateIncomeAndExpenditure.CS_YEAR;
		__column_names[2] = BasePlateIncomeAndExpenditure.CS_MONTH;
		__column_names[3] = BasePlateIncomeAndExpenditure.CS_PLATE_ID;
		__column_names[4] = BasePlateIncomeAndExpenditure.CS_CONTRACT_STOCK;
		__column_names[5] = BasePlateIncomeAndExpenditure.CS_REVENUE;
		__column_names[6] = BasePlateIncomeAndExpenditure.CS_DEPARTMENT_CONFIRMATION_POINTS;
		__column_names[7] = BasePlateIncomeAndExpenditure.CS_EMPLOYEE_CONFIRMATION_POINTS;
		__column_names[8] = BasePlateIncomeAndExpenditure.CS_EMPLOYEE_COST;
		__column_names[9] = BasePlateIncomeAndExpenditure.CS_PROJECT_COST;
		__column_names[10] = BasePlateIncomeAndExpenditure.CS_PLATE_COST;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePlateIncomeAndExpenditure b) {
		clear();
		setPlateIncomeAndExpenditureIdClear(b.getPlateIncomeAndExpenditureId());
	}

	public boolean isPrimaryKeyNull() {
		return getPlateIncomeAndExpenditureId() == null;
	}

	@Override
	public BasePlateIncomeAndExpenditure generateBase(){
		BasePlateIncomeAndExpenditure b = new BasePlateIncomeAndExpenditure();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePlateIncomeAndExpenditure b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPlateIncomeAndExpenditureId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractStock(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRevenue(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setDepartmentConfirmationPoints(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setEmployeeConfirmationPoints(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setEmployeeCost(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectCost(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPlateCost(GenericBase.__getDecimal(val));
	}

	@Override
	public void setBaseToBuffer(BasePlateIncomeAndExpenditure b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPlateIncomeAndExpenditureId();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getContractStock();
		buff[count++] = b.getRevenue();
		buff[count++] = b.getDepartmentConfirmationPoints();
		buff[count++] = b.getEmployeeConfirmationPoints();
		buff[count++] = b.getEmployeeCost();
		buff[count++] = b.getProjectCost();
		buff[count++] = b.getPlateCost();
	}

	@Override
	public void setDataFromBase(BasePlateIncomeAndExpenditure b){
		if(b.getPlateIncomeAndExpenditureId() != null) setPlateIncomeAndExpenditureIdClear(b.getPlateIncomeAndExpenditureId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getContractStock() != null) setContractStock(b.getContractStock());
		if(b.getRevenue() != null) setRevenue(b.getRevenue());
		if(b.getDepartmentConfirmationPoints() != null) setDepartmentConfirmationPoints(b.getDepartmentConfirmationPoints());
		if(b.getEmployeeConfirmationPoints() != null) setEmployeeConfirmationPoints(b.getEmployeeConfirmationPoints());
		if(b.getEmployeeCost() != null) setEmployeeCost(b.getEmployeeCost());
		if(b.getProjectCost() != null) setProjectCost(b.getProjectCost());
		if(b.getPlateCost() != null) setPlateCost(b.getPlateCost());
	}

	@Override
	public BasePlateIncomeAndExpenditure generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePlateIncomeAndExpenditure b = new BasePlateIncomeAndExpenditure();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePlateIncomeAndExpenditure __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateIncomeAndExpenditureId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractStock(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRevenue(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentConfirmationPoints(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeConfirmationPoints(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeCost(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCost(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateCost(GenericBase.__getDecimal(val));
	}

	public void setPlateIncomeAndExpenditureId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPlateIncomeAndExpenditureId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPlateIncomeAndExpenditureIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setContractStock(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getContractStock() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setRevenue(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getRevenue() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setDepartmentConfirmationPoints(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getDepartmentConfirmationPoints() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setEmployeeConfirmationPoints(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getEmployeeConfirmationPoints() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setEmployeeCost(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getEmployeeCost() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setProjectCost(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getProjectCost() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setPlateCost(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getPlateCost() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setConditionPlateIncomeAndExpenditureId(String op, java.lang.Integer val) {
		setConditionPlateIncomeAndExpenditureId(op, val, CONDITION_AND);
	}

	public void setConditionPlateIncomeAndExpenditureId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPlateIncomeAndExpenditureId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionContractStock(String op, java.math.BigDecimal val) {
		setConditionContractStock(op, val, CONDITION_AND);
	}

	public void setConditionContractStock(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectContractStock(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionRevenue(String op, java.math.BigDecimal val) {
		setConditionRevenue(op, val, CONDITION_AND);
	}

	public void setConditionRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectRevenue(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionDepartmentConfirmationPoints(String op, java.math.BigDecimal val) {
		setConditionDepartmentConfirmationPoints(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentConfirmationPoints(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectDepartmentConfirmationPoints(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionEmployeeConfirmationPoints(String op, java.math.BigDecimal val) {
		setConditionEmployeeConfirmationPoints(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeConfirmationPoints(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectEmployeeConfirmationPoints(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionEmployeeCost(String op, java.math.BigDecimal val) {
		setConditionEmployeeCost(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeCost(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectEmployeeCost(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionProjectCost(String op, java.math.BigDecimal val) {
		setConditionProjectCost(op, val, CONDITION_AND);
	}

	public void setConditionProjectCost(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectProjectCost(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionPlateCost(String op, java.math.BigDecimal val) {
		setConditionPlateCost(op, val, CONDITION_AND);
	}

	public void setConditionPlateCost(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectPlateCost(boolean val) {
		__select_flags[10] = val;
	}


}

