package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseCompensatoryLeave;


public class CompensatoryLeave extends AbstractTable<BaseCompensatoryLeave>
{

	public CompensatoryLeave() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "compensatory_leaves";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCompensatoryLeave.CS_COMPENSATORY_LEAVE_ID;
		__column_names[1] = BaseCompensatoryLeave.CS_EMPLOYEE_ID;
		__column_names[2] = BaseCompensatoryLeave.CS_YEAR;
		__column_names[3] = BaseCompensatoryLeave.CS_MONTH;
		__column_names[4] = BaseCompensatoryLeave.CS_STATUS;
		__column_names[5] = BaseCompensatoryLeave.CS_BUSINESS_ID;
		__column_names[6] = BaseCompensatoryLeave.CS_TOTAL_COMPENSATORY_LEAVE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCompensatoryLeave b) {
		clear();
		setCompensatoryLeaveIdClear(b.getCompensatoryLeaveId());
	}

	public boolean isPrimaryKeyNull() {
		return getCompensatoryLeaveId() == null;
	}

	@Override
	public BaseCompensatoryLeave generateBase(){
		BaseCompensatoryLeave b = new BaseCompensatoryLeave();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCompensatoryLeave b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCompensatoryLeaveId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTotalCompensatoryLeave(GenericBase.__getDecimal(val));
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
			if(val != null && !val.isEmpty()) setCompensatoryLeaveId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEmployeeId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setYear(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMonth(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStatus(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBusinessId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setTotalCompensatoryLeave(GenericBase.__getDecimal(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseCompensatoryLeave b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCompensatoryLeaveId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getStatus();
		buff[count++] = b.getBusinessId();
		buff[count++] = b.getTotalCompensatoryLeave();
	}

	@Override
	public void setDataFromBase(BaseCompensatoryLeave b){
		if(b.getCompensatoryLeaveId() != null) setCompensatoryLeaveIdClear(b.getCompensatoryLeaveId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getBusinessId() != null) setBusinessId(b.getBusinessId());
		if(b.getTotalCompensatoryLeave() != null) setTotalCompensatoryLeave(b.getTotalCompensatoryLeave());
	}

	@Override
	public BaseCompensatoryLeave generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCompensatoryLeave b = new BaseCompensatoryLeave();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCompensatoryLeave __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompensatoryLeaveId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalCompensatoryLeave(GenericBase.__getDecimal(val));
	}

	public void setCompensatoryLeaveId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCompensatoryLeaveId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCompensatoryLeaveIdClear(java.lang.Integer val) {
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

	public void setStatus(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setBusinessId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getBusinessId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setTotalCompensatoryLeave(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getTotalCompensatoryLeave() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setConditionCompensatoryLeaveId(String op, java.lang.Integer val) {
		setConditionCompensatoryLeaveId(op, val, CONDITION_AND);
	}

	public void setConditionCompensatoryLeaveId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCompensatoryLeaveId(boolean val) {
		__select_flags[0] = val;
	}

	public void setCompensatoryLeaveIdExpression(String val) {
		__dataExpressions[0] = val;
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

	public void setEmployeeIdExpression(String val) {
		__dataExpressions[1] = val;
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

	public void setYearExpression(String val) {
		__dataExpressions[2] = val;
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

	public void setMonthExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[4] = val;
	}

	public void setStatusExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionBusinessId(String op, java.lang.Integer val) {
		setConditionBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectBusinessId(boolean val) {
		__select_flags[5] = val;
	}

	public void setBusinessIdExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionTotalCompensatoryLeave(String op, java.math.BigDecimal val) {
		setConditionTotalCompensatoryLeave(op, val, CONDITION_AND);
	}

	public void setConditionTotalCompensatoryLeave(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectTotalCompensatoryLeave(boolean val) {
		__select_flags[6] = val;
	}

	public void setTotalCompensatoryLeaveExpression(String val) {
		__dataExpressions[6] = val;
	}


}

