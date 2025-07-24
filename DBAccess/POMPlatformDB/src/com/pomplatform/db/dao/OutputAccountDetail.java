package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseOutputAccountDetail;


public class OutputAccountDetail extends AbstractTable<BaseOutputAccountDetail>
{

	public OutputAccountDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "output_account_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseOutputAccountDetail.CS_OUTPUT_ACCOUNT_DETAIL_ID;
		__column_names[1] = BaseOutputAccountDetail.CS_OUTPUT_ACCOUNT_RECORD_ID;
		__column_names[2] = BaseOutputAccountDetail.CS_EMPLOYEE_ID;
		__column_names[3] = BaseOutputAccountDetail.CS_ACCOUNT_INTEGRAL;
		__column_names[4] = BaseOutputAccountDetail.CS_START_DATE;
		__column_names[5] = BaseOutputAccountDetail.CS_END_DATE;
		__column_names[6] = BaseOutputAccountDetail.CS_ACCOUNT_DATE;
		__column_names[7] = BaseOutputAccountDetail.CS_YEAR;
		__column_names[8] = BaseOutputAccountDetail.CS_MONTH;
		__column_names[9] = BaseOutputAccountDetail.CS_IS_YEAR_FINAL_ACCOUNT;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseOutputAccountDetail b) {
		clear();
		setOutputAccountDetailIdClear(b.getOutputAccountDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getOutputAccountDetailId() == null;
	}

	@Override
	public BaseOutputAccountDetail generateBase(){
		BaseOutputAccountDetail b = new BaseOutputAccountDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseOutputAccountDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setOutputAccountDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOutputAccountRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAccountIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setAccountDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsYearFinalAccount(GenericBase.__getBoolean(val));
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
			if(val != null && !val.isEmpty()) setOutputAccountDetailId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOutputAccountRecordId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEmployeeId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setAccountIntegral(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStartDate(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEndDate(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setAccountDate(GenericBase.__getDate(val));
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
			if(val != null && !val.isEmpty()) setIsYearFinalAccount(GenericBase.__getBoolean(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseOutputAccountDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getOutputAccountDetailId();
		buff[count++] = b.getOutputAccountRecordId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getAccountIntegral();
		buff[count++] = generateTimestampFromDate(b.getStartDate());
		buff[count++] = generateTimestampFromDate(b.getEndDate());
		buff[count++] = generateTimestampFromDate(b.getAccountDate());
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getIsYearFinalAccount();
	}

	@Override
	public void setDataFromBase(BaseOutputAccountDetail b){
		if(b.getOutputAccountDetailId() != null) setOutputAccountDetailIdClear(b.getOutputAccountDetailId());
		if(b.getOutputAccountRecordId() != null) setOutputAccountRecordId(b.getOutputAccountRecordId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getAccountIntegral() != null) setAccountIntegral(b.getAccountIntegral());
		if(b.getStartDate() != null) setStartDate(b.getStartDate());
		if(b.getEndDate() != null) setEndDate(b.getEndDate());
		if(b.getAccountDate() != null) setAccountDate(b.getAccountDate());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getIsYearFinalAccount() != null) setIsYearFinalAccount(b.getIsYearFinalAccount());
	}

	@Override
	public BaseOutputAccountDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseOutputAccountDetail b = new BaseOutputAccountDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseOutputAccountDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOutputAccountDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOutputAccountRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsYearFinalAccount(GenericBase.__getBoolean(val));
	}

	public void setOutputAccountDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getOutputAccountDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setOutputAccountDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setOutputAccountRecordId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getOutputAccountRecordId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setAccountIntegral(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getAccountIntegral() {
		return GenericBase.__getDecimal(__current_data[3]);
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

	public void setAccountDate(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getAccountDate() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setIsYearFinalAccount(java.lang.Boolean val) {
		setCurrentData(9, val);
	}

	public java.lang.Boolean getIsYearFinalAccount() {
		return GenericBase.__getBoolean(__current_data[9]);
	}

	public void setConditionOutputAccountDetailId(String op, java.lang.Integer val) {
		setConditionOutputAccountDetailId(op, val, CONDITION_AND);
	}

	public void setConditionOutputAccountDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectOutputAccountDetailId(boolean val) {
		__select_flags[0] = val;
	}

	public void setOutputAccountDetailIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionOutputAccountRecordId(String op, java.lang.Integer val) {
		setConditionOutputAccountRecordId(op, val, CONDITION_AND);
	}

	public void setConditionOutputAccountRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectOutputAccountRecordId(boolean val) {
		__select_flags[1] = val;
	}

	public void setOutputAccountRecordIdExpression(String val) {
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

	public void setConditionAccountIntegral(String op, java.math.BigDecimal val) {
		setConditionAccountIntegral(op, val, CONDITION_AND);
	}

	public void setConditionAccountIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectAccountIntegral(boolean val) {
		__select_flags[3] = val;
	}

	public void setAccountIntegralExpression(String val) {
		__dataExpressions[3] = val;
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

	public void setStartDateExpression(String val) {
		__dataExpressions[4] = val;
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

	public void setEndDateExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionAccountDate(String op, java.util.Date val) {
		setConditionAccountDate(op, val, CONDITION_AND);
	}

	public void setConditionAccountDate(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectAccountDate(boolean val) {
		__select_flags[6] = val;
	}

	public void setAccountDateExpression(String val) {
		__dataExpressions[6] = val;
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

	public void setYearExpression(String val) {
		__dataExpressions[7] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[8] = val;
	}

	public void setMonthExpression(String val) {
		__dataExpressions[8] = val;
	}

	public void setConditionIsYearFinalAccount(String op, java.lang.Boolean val) {
		setConditionIsYearFinalAccount(op, val, CONDITION_AND);
	}

	public void setConditionIsYearFinalAccount(String op, java.lang.Boolean val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectIsYearFinalAccount(boolean val) {
		__select_flags[9] = val;
	}

	public void setIsYearFinalAccountExpression(String val) {
		__dataExpressions[9] = val;
	}


}

