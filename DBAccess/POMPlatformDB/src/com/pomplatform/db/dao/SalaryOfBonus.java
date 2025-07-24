package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSalaryOfBonus;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SalaryOfBonus extends AbstractTable<BaseSalaryOfBonus>
{

	public SalaryOfBonus() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 19;

		initTables();

		__tableName            = "salary_of_bonus";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSalaryOfBonus.CS_SALARY_OF_BONUS_ID;
		__column_names[1] = BaseSalaryOfBonus.CS_EMPLOYEE_ID;
		__column_names[2] = BaseSalaryOfBonus.CS_RECORD_DATE;
		__column_names[3] = BaseSalaryOfBonus.CS_YEAR;
		__column_names[4] = BaseSalaryOfBonus.CS_MONTH;
		__column_names[5] = BaseSalaryOfBonus.CS_SHOULD_BONUS;
		__column_names[6] = BaseSalaryOfBonus.CS_SHOULD_TAX;
		__column_names[7] = BaseSalaryOfBonus.CS_FACT_BONUS;
		__column_names[8] = BaseSalaryOfBonus.CS_OTHER_BONUS;
		__column_names[9] = BaseSalaryOfBonus.CS_IS_SENDED;
		__column_names[10] = BaseSalaryOfBonus.CS_FLAG;
		__column_names[11] = BaseSalaryOfBonus.CS_REMARK;
		__column_names[12] = BaseSalaryOfBonus.CS_COMPANY_ID;
		__column_names[13] = BaseSalaryOfBonus.CS_DEPARTMENT_ID;
		__column_names[14] = BaseSalaryOfBonus.CS_PLATE_ID;
		__column_names[15] = BaseSalaryOfBonus.CS_SEND_TIME;
		__column_names[16] = BaseSalaryOfBonus.CS_END_TIME;
		__column_names[17] = BaseSalaryOfBonus.CS_PERSONNEL_BUSINESS_ID;
		__column_names[18] = BaseSalaryOfBonus.CS_FLOW_STATUS;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSalaryOfBonus b) {
		clear();
		setSalaryOfBonusIdClear(b.getSalaryOfBonusId());
	}

	public boolean isPrimaryKeyNull() {
		return getSalaryOfBonusId() == null;
	}

	@Override
	public BaseSalaryOfBonus generateBase(){
		BaseSalaryOfBonus b = new BaseSalaryOfBonus();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSalaryOfBonus b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSalaryOfBonusId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setShouldBonus(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setShouldTax(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFactBonus(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOtherBonus(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsSended(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSendTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEndTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFlowStatus(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseSalaryOfBonus b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSalaryOfBonusId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getShouldBonus();
		buff[count++] = b.getShouldTax();
		buff[count++] = b.getFactBonus();
		buff[count++] = b.getOtherBonus();
		buff[count++] = b.getIsSended();
		buff[count++] = b.getFlag();
		buff[count++] = b.getRemark();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getPlateId();
		buff[count++] = generateTimestampFromDate(b.getSendTime());
		buff[count++] = generateTimestampFromDate(b.getEndTime());
		buff[count++] = b.getPersonnelBusinessId();
		buff[count++] = b.getFlowStatus();
	}

	@Override
	public void setDataFromBase(BaseSalaryOfBonus b){
		if(b.getSalaryOfBonusId() != null) setSalaryOfBonusIdClear(b.getSalaryOfBonusId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getShouldBonus() != null) setShouldBonus(b.getShouldBonus());
		if(b.getShouldTax() != null) setShouldTax(b.getShouldTax());
		if(b.getFactBonus() != null) setFactBonus(b.getFactBonus());
		if(b.getOtherBonus() != null) setOtherBonus(b.getOtherBonus());
		if(b.getIsSended() != null) setIsSended(b.getIsSended());
		if(b.getFlag() != null) setFlag(b.getFlag());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getSendTime() != null) setSendTime(b.getSendTime());
		if(b.getEndTime() != null) setEndTime(b.getEndTime());
		if(b.getPersonnelBusinessId() != null) setPersonnelBusinessId(b.getPersonnelBusinessId());
		if(b.getFlowStatus() != null) setFlowStatus(b.getFlowStatus());
	}

	@Override
	public BaseSalaryOfBonus generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSalaryOfBonus b = new BaseSalaryOfBonus();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSalaryOfBonus __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalaryOfBonusId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setShouldBonus(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setShouldTax(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFactBonus(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOtherBonus(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsSended(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSendTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFlowStatus(GenericBase.__getInt(val));
	}

	public void setSalaryOfBonusId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSalaryOfBonusId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSalaryOfBonusIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setRecordDate(java.util.Date val) {
		setCurrentData(2, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordDate() {
		return GenericBase.__getDateFromSQL(__current_data[2]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setShouldBonus(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getShouldBonus() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setShouldTax(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getShouldTax() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setFactBonus(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getFactBonus() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setOtherBonus(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getOtherBonus() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setIsSended(java.lang.Boolean val) {
		setCurrentData(9, val);
	}

	public java.lang.Boolean getIsSended() {
		return GenericBase.__getBoolean(__current_data[9]);
	}

	public void setFlag(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getFlag() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setSendTime(java.util.Date val) {
		setCurrentData(15, generateTimestampFromDate(val));
	}

	public java.util.Date getSendTime() {
		return GenericBase.__getDateFromSQL(__current_data[15]);
	}

	public void setEndTime(java.util.Date val) {
		setCurrentData(16, generateTimestampFromDate(val));
	}

	public java.util.Date getEndTime() {
		return GenericBase.__getDateFromSQL(__current_data[16]);
	}

	public void setPersonnelBusinessId(java.lang.Integer val) {
		setCurrentData(17, val);
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return GenericBase.__getInt(__current_data[17]);
	}

	public void setFlowStatus(java.lang.Integer val) {
		setCurrentData(18, val);
	}

	public java.lang.Integer getFlowStatus() {
		return GenericBase.__getInt(__current_data[18]);
	}

	public void setConditionSalaryOfBonusId(String op, java.lang.Integer val) {
		setConditionSalaryOfBonusId(op, val, CONDITION_AND);
	}

	public void setConditionSalaryOfBonusId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSalaryOfBonusId(boolean val) {
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

	public void setConditionRecordDate(String op, java.util.Date val) {
		setConditionRecordDate(op, val, CONDITION_AND);
	}

	public void setConditionRecordDate(String op, java.util.Date val, String relation) {
		addCondition(2, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordDate(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionShouldBonus(String op, java.lang.String val) {
		setConditionShouldBonus(op, val, CONDITION_AND);
	}

	public void setConditionShouldBonus(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectShouldBonus(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionShouldTax(String op, java.lang.String val) {
		setConditionShouldTax(op, val, CONDITION_AND);
	}

	public void setConditionShouldTax(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectShouldTax(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionFactBonus(String op, java.lang.String val) {
		setConditionFactBonus(op, val, CONDITION_AND);
	}

	public void setConditionFactBonus(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectFactBonus(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionOtherBonus(String op, java.lang.String val) {
		setConditionOtherBonus(op, val, CONDITION_AND);
	}

	public void setConditionOtherBonus(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectOtherBonus(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionIsSended(String op, java.lang.Boolean val) {
		setConditionIsSended(op, val, CONDITION_AND);
	}

	public void setConditionIsSended(String op, java.lang.Boolean val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectIsSended(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionFlag(String op, java.lang.Integer val) {
		setConditionFlag(op, val, CONDITION_AND);
	}

	public void setConditionFlag(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectFlag(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionSendTime(String op, java.util.Date val) {
		setConditionSendTime(op, val, CONDITION_AND);
	}

	public void setConditionSendTime(String op, java.util.Date val, String relation) {
		addCondition(15, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectSendTime(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionEndTime(String op, java.util.Date val) {
		setConditionEndTime(op, val, CONDITION_AND);
	}

	public void setConditionEndTime(String op, java.util.Date val, String relation) {
		addCondition(16, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectEndTime(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val) {
		setConditionPersonnelBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectPersonnelBusinessId(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionFlowStatus(String op, java.lang.Integer val) {
		setConditionFlowStatus(op, val, CONDITION_AND);
	}

	public void setConditionFlowStatus(String op, java.lang.Integer val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectFlowStatus(boolean val) {
		__select_flags[18] = val;
	}


}

