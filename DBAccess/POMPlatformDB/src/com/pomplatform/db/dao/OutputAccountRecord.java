package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseOutputAccountRecord;


public class OutputAccountRecord extends AbstractTable<BaseOutputAccountRecord>
{

	public OutputAccountRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 13;

		initTables();

		__tableName            = "output_account_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseOutputAccountRecord.CS_OUTPUT_ACCOUNT_RECORD_ID;
		__column_names[1] = BaseOutputAccountRecord.CS_PLATE_ID;
		__column_names[2] = BaseOutputAccountRecord.CS_DEP_ACCOUNT_INTEGRAL;
		__column_names[3] = BaseOutputAccountRecord.CS_EMP_ACCOUNT_INTEGRAL;
		__column_names[4] = BaseOutputAccountRecord.CS_START_DATE;
		__column_names[5] = BaseOutputAccountRecord.CS_END_DATE;
		__column_names[6] = BaseOutputAccountRecord.CS_ACCOUNT_DATE;
		__column_names[7] = BaseOutputAccountRecord.CS_YEAR;
		__column_names[8] = BaseOutputAccountRecord.CS_MONTH;
		__column_names[9] = BaseOutputAccountRecord.CS_IS_YEAR_FINAL_ACCOUNT;
		__column_names[10] = BaseOutputAccountRecord.CS_OPERATE_TIME;
		__column_names[11] = BaseOutputAccountRecord.CS_OPERATE_EMPLOYEE_ID;
		__column_names[12] = BaseOutputAccountRecord.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseOutputAccountRecord b) {
		clear();
		setOutputAccountRecordIdClear(b.getOutputAccountRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getOutputAccountRecordId() == null;
	}

	@Override
	public BaseOutputAccountRecord generateBase(){
		BaseOutputAccountRecord b = new BaseOutputAccountRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseOutputAccountRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setOutputAccountRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepAccountIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setEmpAccountIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setAccountDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsYearFinalAccount(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
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
			if(val != null && !val.isEmpty()) setOutputAccountRecordId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPlateId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDepAccountIntegral(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEmpAccountIntegral(GenericBase.__getDecimal(val));
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
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOperateTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOperateEmployeeId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRemark(GenericBase.__getString(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseOutputAccountRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getOutputAccountRecordId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getDepAccountIntegral();
		buff[count++] = b.getEmpAccountIntegral();
		buff[count++] = generateTimestampFromDate(b.getStartDate());
		buff[count++] = generateTimestampFromDate(b.getEndDate());
		buff[count++] = generateTimestampFromDate(b.getAccountDate());
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getIsYearFinalAccount();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseOutputAccountRecord b){
		if(b.getOutputAccountRecordId() != null) setOutputAccountRecordIdClear(b.getOutputAccountRecordId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getDepAccountIntegral() != null) setDepAccountIntegral(b.getDepAccountIntegral());
		if(b.getEmpAccountIntegral() != null) setEmpAccountIntegral(b.getEmpAccountIntegral());
		if(b.getStartDate() != null) setStartDate(b.getStartDate());
		if(b.getEndDate() != null) setEndDate(b.getEndDate());
		if(b.getAccountDate() != null) setAccountDate(b.getAccountDate());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getIsYearFinalAccount() != null) setIsYearFinalAccount(b.getIsYearFinalAccount());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseOutputAccountRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseOutputAccountRecord b = new BaseOutputAccountRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseOutputAccountRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOutputAccountRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepAccountIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmpAccountIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsYearFinalAccount(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setOutputAccountRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getOutputAccountRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setOutputAccountRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setDepAccountIntegral(java.math.BigDecimal val) {
		setCurrentData(2, val);
	}

	public java.math.BigDecimal getDepAccountIntegral() {
		return GenericBase.__getDecimal(__current_data[2]);
	}

	public void setEmpAccountIntegral(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getEmpAccountIntegral() {
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

	public void setOperateTime(java.util.Date val) {
		setCurrentData(10, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[10]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setConditionOutputAccountRecordId(String op, java.lang.Integer val) {
		setConditionOutputAccountRecordId(op, val, CONDITION_AND);
	}

	public void setConditionOutputAccountRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectOutputAccountRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setOutputAccountRecordIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[1] = val;
	}

	public void setPlateIdExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionDepAccountIntegral(String op, java.math.BigDecimal val) {
		setConditionDepAccountIntegral(op, val, CONDITION_AND);
	}

	public void setConditionDepAccountIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectDepAccountIntegral(boolean val) {
		__select_flags[2] = val;
	}

	public void setDepAccountIntegralExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionEmpAccountIntegral(String op, java.math.BigDecimal val) {
		setConditionEmpAccountIntegral(op, val, CONDITION_AND);
	}

	public void setConditionEmpAccountIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectEmpAccountIntegral(boolean val) {
		__select_flags[3] = val;
	}

	public void setEmpAccountIntegralExpression(String val) {
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

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(10, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[10] = val;
	}

	public void setOperateTimeExpression(String val) {
		__dataExpressions[10] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[11] = val;
	}

	public void setOperateEmployeeIdExpression(String val) {
		__dataExpressions[11] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[12] = val;
	}

	public void setRemarkExpression(String val) {
		__dataExpressions[12] = val;
	}


}

