package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSalaryFillSendDeduct;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SalaryFillSendDeduct extends AbstractTable<BaseSalaryFillSendDeduct>
{

	public SalaryFillSendDeduct() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 13;

		initTables();

		__tableName            = "salary_fill_send_deducts";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSalaryFillSendDeduct.CS_SALARY_FILL_SEND_DEDUCT_ID;
		__column_names[1] = BaseSalaryFillSendDeduct.CS_EMPLOYEE_ID;
		__column_names[2] = BaseSalaryFillSendDeduct.CS_YEAR;
		__column_names[3] = BaseSalaryFillSendDeduct.CS_MONTH;
		__column_names[4] = BaseSalaryFillSendDeduct.CS_RECORD_DATE;
		__column_names[5] = BaseSalaryFillSendDeduct.CS_FILL_FIVE_INSURANCE_ONE_GOLDS;
		__column_names[6] = BaseSalaryFillSendDeduct.CS_MORE_DEDUCT_TAX;
		__column_names[7] = BaseSalaryFillSendDeduct.CS_FILL_TAX;
		__column_names[8] = BaseSalaryFillSendDeduct.CS_TOTAL_AMOUNT;
		__column_names[9] = BaseSalaryFillSendDeduct.CS_IS_SENDED;
		__column_names[10] = BaseSalaryFillSendDeduct.CS_OPERATE_EMPLOYEE_ID;
		__column_names[11] = BaseSalaryFillSendDeduct.CS_OPERATE_TIME;
		__column_names[12] = BaseSalaryFillSendDeduct.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSalaryFillSendDeduct b) {
		clear();
		setSalaryFillSendDeductIdClear(b.getSalaryFillSendDeductId());
	}

	public boolean isPrimaryKeyNull() {
		return getSalaryFillSendDeductId() == null;
	}

	@Override
	public BaseSalaryFillSendDeduct generateBase(){
		BaseSalaryFillSendDeduct b = new BaseSalaryFillSendDeduct();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSalaryFillSendDeduct b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSalaryFillSendDeductId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setFillFiveInsuranceOneGolds(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMoreDeductTax(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFillTax(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTotalAmount(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsSended(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseSalaryFillSendDeduct b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSalaryFillSendDeductId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = b.getFillFiveInsuranceOneGolds();
		buff[count++] = b.getMoreDeductTax();
		buff[count++] = b.getFillTax();
		buff[count++] = b.getTotalAmount();
		buff[count++] = b.getIsSended();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseSalaryFillSendDeduct b){
		if(b.getSalaryFillSendDeductId() != null) setSalaryFillSendDeductIdClear(b.getSalaryFillSendDeductId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getFillFiveInsuranceOneGolds() != null) setFillFiveInsuranceOneGolds(b.getFillFiveInsuranceOneGolds());
		if(b.getMoreDeductTax() != null) setMoreDeductTax(b.getMoreDeductTax());
		if(b.getFillTax() != null) setFillTax(b.getFillTax());
		if(b.getTotalAmount() != null) setTotalAmount(b.getTotalAmount());
		if(b.getIsSended() != null) setIsSended(b.getIsSended());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseSalaryFillSendDeduct generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSalaryFillSendDeduct b = new BaseSalaryFillSendDeduct();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSalaryFillSendDeduct __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalaryFillSendDeductId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFillFiveInsuranceOneGolds(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMoreDeductTax(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFillTax(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalAmount(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsSended(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setSalaryFillSendDeductId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSalaryFillSendDeductId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSalaryFillSendDeductIdClear(java.lang.Integer val) {
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

	public void setFillFiveInsuranceOneGolds(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getFillFiveInsuranceOneGolds() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setMoreDeductTax(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getMoreDeductTax() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setFillTax(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getFillTax() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setTotalAmount(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getTotalAmount() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setIsSended(java.lang.Boolean val) {
		setCurrentData(9, val);
	}

	public java.lang.Boolean getIsSended() {
		return GenericBase.__getBoolean(__current_data[9]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(11, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[11]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setConditionSalaryFillSendDeductId(String op, java.lang.Integer val) {
		setConditionSalaryFillSendDeductId(op, val, CONDITION_AND);
	}

	public void setConditionSalaryFillSendDeductId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSalaryFillSendDeductId(boolean val) {
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

	public void setConditionFillFiveInsuranceOneGolds(String op, java.lang.String val) {
		setConditionFillFiveInsuranceOneGolds(op, val, CONDITION_AND);
	}

	public void setConditionFillFiveInsuranceOneGolds(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectFillFiveInsuranceOneGolds(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionMoreDeductTax(String op, java.lang.String val) {
		setConditionMoreDeductTax(op, val, CONDITION_AND);
	}

	public void setConditionMoreDeductTax(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectMoreDeductTax(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionFillTax(String op, java.lang.String val) {
		setConditionFillTax(op, val, CONDITION_AND);
	}

	public void setConditionFillTax(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectFillTax(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionTotalAmount(String op, java.lang.String val) {
		setConditionTotalAmount(op, val, CONDITION_AND);
	}

	public void setConditionTotalAmount(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectTotalAmount(boolean val) {
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

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(11, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[11] = val;
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


}

