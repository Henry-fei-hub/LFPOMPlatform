package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseAnnualLeave;


public class AnnualLeave extends AbstractTable<BaseAnnualLeave>
{

	public AnnualLeave() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 13;

		initTables();

		__tableName            = "annual_leaves";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseAnnualLeave.CS_ANNUAL_LEAVE_ID;
		__column_names[1] = BaseAnnualLeave.CS_EMPLOYEE_NO;
		__column_names[2] = BaseAnnualLeave.CS_EMPLOYEE_ID;
		__column_names[3] = BaseAnnualLeave.CS_DEPARTMENT_ID;
		__column_names[4] = BaseAnnualLeave.CS_SECRETARY_YEAR;
		__column_names[5] = BaseAnnualLeave.CS_LENGTH_OF_SERVICE;
		__column_names[6] = BaseAnnualLeave.CS_TOTAL_ANNUAL_LEAVE;
		__column_names[7] = BaseAnnualLeave.CS_USAGE_AMOUNT_ANNUAL;
		__column_names[8] = BaseAnnualLeave.CS_REMAINING_AMOUNT_ANNUAL;
		__column_names[9] = BaseAnnualLeave.CS_YEAR;
		__column_names[10] = BaseAnnualLeave.CS_TOTAL_WEALFARE_LEAVE;
		__column_names[11] = BaseAnnualLeave.CS_USAGE_AMOUNT_WEALFARE;
		__column_names[12] = BaseAnnualLeave.CS_REMAINING_AMOUNT_WEALFARE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseAnnualLeave b) {
		clear();
		setAnnualLeaveIdClear(b.getAnnualLeaveId());
	}

	public boolean isPrimaryKeyNull() {
		return getAnnualLeaveId() == null;
	}

	@Override
	public BaseAnnualLeave generateBase(){
		BaseAnnualLeave b = new BaseAnnualLeave();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseAnnualLeave b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setAnnualLeaveId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSecretaryYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLengthOfService(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTotalAnnualLeave(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUsageAmountAnnual(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRemainingAmountAnnual(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTotalWealfareLeave(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUsageAmountWealfare(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRemainingAmountWealfare(GenericBase.__getDecimal(val));
	}

	public void setDataFromCSV(String csvLine){
		setDataFromCSV(csvLine, null);
	}

	public void setDataFromCSV(String csvLine, String names){
		int count = 0; String val;
		Integer num = null;
		setInputNames(names);
		String[] values = JsonParser.csvLine(csvLine, ',');
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setAnnualLeaveId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEmployeeNo(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEmployeeId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDepartmentId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setSecretaryYear(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setLengthOfService(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setTotalAnnualLeave(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setUsageAmountAnnual(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRemainingAmountAnnual(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setYear(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setTotalWealfareLeave(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setUsageAmountWealfare(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRemainingAmountWealfare(GenericBase.__getDecimal(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseAnnualLeave b, Object[] buff){
		int count = 0;
		buff[count++] = b.getAnnualLeaveId();
		buff[count++] = b.getEmployeeNo();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getSecretaryYear();
		buff[count++] = b.getLengthOfService();
		buff[count++] = b.getTotalAnnualLeave();
		buff[count++] = b.getUsageAmountAnnual();
		buff[count++] = b.getRemainingAmountAnnual();
		buff[count++] = b.getYear();
		buff[count++] = b.getTotalWealfareLeave();
		buff[count++] = b.getUsageAmountWealfare();
		buff[count++] = b.getRemainingAmountWealfare();
	}

	@Override
	public void setDataFromBase(BaseAnnualLeave b){
		if(b.getAnnualLeaveId() != null) setAnnualLeaveIdClear(b.getAnnualLeaveId());
		if(b.getEmployeeNo() != null) setEmployeeNo(b.getEmployeeNo());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getSecretaryYear() != null) setSecretaryYear(b.getSecretaryYear());
		if(b.getLengthOfService() != null) setLengthOfService(b.getLengthOfService());
		if(b.getTotalAnnualLeave() != null) setTotalAnnualLeave(b.getTotalAnnualLeave());
		if(b.getUsageAmountAnnual() != null) setUsageAmountAnnual(b.getUsageAmountAnnual());
		if(b.getRemainingAmountAnnual() != null) setRemainingAmountAnnual(b.getRemainingAmountAnnual());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getTotalWealfareLeave() != null) setTotalWealfareLeave(b.getTotalWealfareLeave());
		if(b.getUsageAmountWealfare() != null) setUsageAmountWealfare(b.getUsageAmountWealfare());
		if(b.getRemainingAmountWealfare() != null) setRemainingAmountWealfare(b.getRemainingAmountWealfare());
	}

	@Override
	public BaseAnnualLeave generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseAnnualLeave b = new BaseAnnualLeave();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseAnnualLeave __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAnnualLeaveId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSecretaryYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLengthOfService(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalAnnualLeave(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUsageAmountAnnual(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemainingAmountAnnual(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalWealfareLeave(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUsageAmountWealfare(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemainingAmountWealfare(GenericBase.__getDecimal(val));
	}

	public void setAnnualLeaveId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getAnnualLeaveId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setAnnualLeaveIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeNo(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getEmployeeNo() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setSecretaryYear(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getSecretaryYear() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setLengthOfService(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getLengthOfService() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setTotalAnnualLeave(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getTotalAnnualLeave() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setUsageAmountAnnual(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getUsageAmountAnnual() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setRemainingAmountAnnual(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getRemainingAmountAnnual() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setTotalWealfareLeave(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getTotalWealfareLeave() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setUsageAmountWealfare(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getUsageAmountWealfare() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setRemainingAmountWealfare(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getRemainingAmountWealfare() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setConditionAnnualLeaveId(String op, java.lang.Integer val) {
		setConditionAnnualLeaveId(op, val, CONDITION_AND);
	}

	public void setConditionAnnualLeaveId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectAnnualLeaveId(boolean val) {
		__select_flags[0] = val;
	}

	public void setAnnualLeaveIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionEmployeeNo(String op, java.lang.String val) {
		setConditionEmployeeNo(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeNo(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectEmployeeNo(boolean val) {
		__select_flags[1] = val;
	}

	public void setEmployeeNoExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[2] = val;
	}

	public void setEmployeeIdExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[3] = val;
	}

	public void setDepartmentIdExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionSecretaryYear(String op, java.lang.Integer val) {
		setConditionSecretaryYear(op, val, CONDITION_AND);
	}

	public void setConditionSecretaryYear(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectSecretaryYear(boolean val) {
		__select_flags[4] = val;
	}

	public void setSecretaryYearExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionLengthOfService(String op, java.lang.Integer val) {
		setConditionLengthOfService(op, val, CONDITION_AND);
	}

	public void setConditionLengthOfService(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectLengthOfService(boolean val) {
		__select_flags[5] = val;
	}

	public void setLengthOfServiceExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionTotalAnnualLeave(String op, java.math.BigDecimal val) {
		setConditionTotalAnnualLeave(op, val, CONDITION_AND);
	}

	public void setConditionTotalAnnualLeave(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectTotalAnnualLeave(boolean val) {
		__select_flags[6] = val;
	}

	public void setTotalAnnualLeaveExpression(String val) {
		__dataExpressions[6] = val;
	}

	public void setConditionUsageAmountAnnual(String op, java.math.BigDecimal val) {
		setConditionUsageAmountAnnual(op, val, CONDITION_AND);
	}

	public void setConditionUsageAmountAnnual(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectUsageAmountAnnual(boolean val) {
		__select_flags[7] = val;
	}

	public void setUsageAmountAnnualExpression(String val) {
		__dataExpressions[7] = val;
	}

	public void setConditionRemainingAmountAnnual(String op, java.math.BigDecimal val) {
		setConditionRemainingAmountAnnual(op, val, CONDITION_AND);
	}

	public void setConditionRemainingAmountAnnual(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectRemainingAmountAnnual(boolean val) {
		__select_flags[8] = val;
	}

	public void setRemainingAmountAnnualExpression(String val) {
		__dataExpressions[8] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[9] = val;
	}

	public void setYearExpression(String val) {
		__dataExpressions[9] = val;
	}

	public void setConditionTotalWealfareLeave(String op, java.math.BigDecimal val) {
		setConditionTotalWealfareLeave(op, val, CONDITION_AND);
	}

	public void setConditionTotalWealfareLeave(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectTotalWealfareLeave(boolean val) {
		__select_flags[10] = val;
	}

	public void setTotalWealfareLeaveExpression(String val) {
		__dataExpressions[10] = val;
	}

	public void setConditionUsageAmountWealfare(String op, java.math.BigDecimal val) {
		setConditionUsageAmountWealfare(op, val, CONDITION_AND);
	}

	public void setConditionUsageAmountWealfare(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectUsageAmountWealfare(boolean val) {
		__select_flags[11] = val;
	}

	public void setUsageAmountWealfareExpression(String val) {
		__dataExpressions[11] = val;
	}

	public void setConditionRemainingAmountWealfare(String op, java.math.BigDecimal val) {
		setConditionRemainingAmountWealfare(op, val, CONDITION_AND);
	}

	public void setConditionRemainingAmountWealfare(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectRemainingAmountWealfare(boolean val) {
		__select_flags[12] = val;
	}

	public void setRemainingAmountWealfareExpression(String val) {
		__dataExpressions[12] = val;
	}


}

