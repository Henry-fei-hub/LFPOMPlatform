package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseEmployeeFundIssuance;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class EmployeeFundIssuance extends AbstractTable<BaseEmployeeFundIssuance>
{

	public EmployeeFundIssuance() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 16;

		initTables();

		__tableName            = "employee_fund_issuances";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEmployeeFundIssuance.CS_EMPLOYEE_FUND_ISSUANCE_ID;
		__column_names[1] = BaseEmployeeFundIssuance.CS_FUNDRASING_TYPE_ID;
		__column_names[2] = BaseEmployeeFundIssuance.CS_COMPANY_ID;
		__column_names[3] = BaseEmployeeFundIssuance.CS_YEAR;
		__column_names[4] = BaseEmployeeFundIssuance.CS_MONTH;
		__column_names[5] = BaseEmployeeFundIssuance.CS_PAY_NUMBER;
		__column_names[6] = BaseEmployeeFundIssuance.CS_PAY_MONEY;
		__column_names[7] = BaseEmployeeFundIssuance.CS_FUND_TYPE;
		__column_names[8] = BaseEmployeeFundIssuance.CS_RELEASE_TYPE;
		__column_names[9] = BaseEmployeeFundIssuance.CS_AMOUNT_OF_CREDIT;
		__column_names[10] = BaseEmployeeFundIssuance.CS_NUMBER_OF_CREDIT;
		__column_names[11] = BaseEmployeeFundIssuance.CS_TOTAL_SUM;
		__column_names[12] = BaseEmployeeFundIssuance.CS_CREATE_TIME;
		__column_names[13] = BaseEmployeeFundIssuance.CS_ACCOUNTING_NUMBER;
		__column_names[14] = BaseEmployeeFundIssuance.CS_PERSONEL_BUSINESS_ID;
		__column_names[15] = BaseEmployeeFundIssuance.CS_PROCESS_STATUS;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEmployeeFundIssuance b) {
		clear();
		setEmployeeFundIssuanceIdClear(b.getEmployeeFundIssuanceId());
	}

	public boolean isPrimaryKeyNull() {
		return getEmployeeFundIssuanceId() == null;
	}

	@Override
	public BaseEmployeeFundIssuance generateBase(){
		BaseEmployeeFundIssuance b = new BaseEmployeeFundIssuance();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEmployeeFundIssuance b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEmployeeFundIssuanceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFundrasingTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPayNumber(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPayMoney(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setFundType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReleaseType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAmountOfCredit(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setNumberOfCredit(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTotalSum(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setAccountingNumber(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPersonelBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessStatus(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseEmployeeFundIssuance b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEmployeeFundIssuanceId();
		buff[count++] = b.getFundrasingTypeId();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getPayNumber();
		buff[count++] = b.getPayMoney();
		buff[count++] = b.getFundType();
		buff[count++] = b.getReleaseType();
		buff[count++] = b.getAmountOfCredit();
		buff[count++] = b.getNumberOfCredit();
		buff[count++] = b.getTotalSum();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getAccountingNumber();
		buff[count++] = b.getPersonelBusinessId();
		buff[count++] = b.getProcessStatus();
	}

	@Override
	public void setDataFromBase(BaseEmployeeFundIssuance b){
		if(b.getEmployeeFundIssuanceId() != null) setEmployeeFundIssuanceIdClear(b.getEmployeeFundIssuanceId());
		if(b.getFundrasingTypeId() != null) setFundrasingTypeId(b.getFundrasingTypeId());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getPayNumber() != null) setPayNumber(b.getPayNumber());
		if(b.getPayMoney() != null) setPayMoney(b.getPayMoney());
		if(b.getFundType() != null) setFundType(b.getFundType());
		if(b.getReleaseType() != null) setReleaseType(b.getReleaseType());
		if(b.getAmountOfCredit() != null) setAmountOfCredit(b.getAmountOfCredit());
		if(b.getNumberOfCredit() != null) setNumberOfCredit(b.getNumberOfCredit());
		if(b.getTotalSum() != null) setTotalSum(b.getTotalSum());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getAccountingNumber() != null) setAccountingNumber(b.getAccountingNumber());
		if(b.getPersonelBusinessId() != null) setPersonelBusinessId(b.getPersonelBusinessId());
		if(b.getProcessStatus() != null) setProcessStatus(b.getProcessStatus());
	}

	@Override
	public BaseEmployeeFundIssuance generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEmployeeFundIssuance b = new BaseEmployeeFundIssuance();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEmployeeFundIssuance __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeFundIssuanceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFundrasingTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayNumber(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayMoney(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFundType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReleaseType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAmountOfCredit(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNumberOfCredit(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalSum(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountingNumber(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonelBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessStatus(GenericBase.__getInt(val));
	}

	public void setEmployeeFundIssuanceId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEmployeeFundIssuanceId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEmployeeFundIssuanceIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setFundrasingTypeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getFundrasingTypeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[2]);
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

	public void setPayNumber(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getPayNumber() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setPayMoney(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getPayMoney() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setFundType(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getFundType() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setReleaseType(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getReleaseType() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setAmountOfCredit(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getAmountOfCredit() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setNumberOfCredit(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getNumberOfCredit() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setTotalSum(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getTotalSum() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(12, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[12]);
	}

	public void setAccountingNumber(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getAccountingNumber() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setPersonelBusinessId(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getPersonelBusinessId() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setProcessStatus(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getProcessStatus() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setConditionEmployeeFundIssuanceId(String op, java.lang.Integer val) {
		setConditionEmployeeFundIssuanceId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeFundIssuanceId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEmployeeFundIssuanceId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionFundrasingTypeId(String op, java.lang.Integer val) {
		setConditionFundrasingTypeId(op, val, CONDITION_AND);
	}

	public void setConditionFundrasingTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectFundrasingTypeId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
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

	public void setConditionPayNumber(String op, java.lang.Integer val) {
		setConditionPayNumber(op, val, CONDITION_AND);
	}

	public void setConditionPayNumber(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectPayNumber(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionPayMoney(String op, java.math.BigDecimal val) {
		setConditionPayMoney(op, val, CONDITION_AND);
	}

	public void setConditionPayMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectPayMoney(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionFundType(String op, java.lang.Integer val) {
		setConditionFundType(op, val, CONDITION_AND);
	}

	public void setConditionFundType(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectFundType(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionReleaseType(String op, java.lang.Integer val) {
		setConditionReleaseType(op, val, CONDITION_AND);
	}

	public void setConditionReleaseType(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectReleaseType(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionAmountOfCredit(String op, java.math.BigDecimal val) {
		setConditionAmountOfCredit(op, val, CONDITION_AND);
	}

	public void setConditionAmountOfCredit(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectAmountOfCredit(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionNumberOfCredit(String op, java.lang.Integer val) {
		setConditionNumberOfCredit(op, val, CONDITION_AND);
	}

	public void setConditionNumberOfCredit(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectNumberOfCredit(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionTotalSum(String op, java.math.BigDecimal val) {
		setConditionTotalSum(op, val, CONDITION_AND);
	}

	public void setConditionTotalSum(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectTotalSum(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(12, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionAccountingNumber(String op, java.lang.Integer val) {
		setConditionAccountingNumber(op, val, CONDITION_AND);
	}

	public void setConditionAccountingNumber(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectAccountingNumber(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionPersonelBusinessId(String op, java.lang.Integer val) {
		setConditionPersonelBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionPersonelBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectPersonelBusinessId(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionProcessStatus(String op, java.lang.Integer val) {
		setConditionProcessStatus(op, val, CONDITION_AND);
	}

	public void setConditionProcessStatus(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectProcessStatus(boolean val) {
		__select_flags[15] = val;
	}


}

