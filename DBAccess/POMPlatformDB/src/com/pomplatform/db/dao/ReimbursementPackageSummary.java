package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseReimbursementPackageSummary;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ReimbursementPackageSummary extends AbstractTable<BaseReimbursementPackageSummary>
{

	public ReimbursementPackageSummary() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 24;

		initTables();

		__tableName            = "reimbursement_package_summarys";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseReimbursementPackageSummary.CS_REIMBURSEMENT_PACKAGE_SUMMARY_ID;
		__column_names[1] = BaseReimbursementPackageSummary.CS_REIMBURSEMENT_PACKAGE_ID;
		__column_names[2] = BaseReimbursementPackageSummary.CS_MONEY_ATTRIBUTE;
		__column_names[3] = BaseReimbursementPackageSummary.CS_PAY_FOR;
		__column_names[4] = BaseReimbursementPackageSummary.CS_EMPLOYEE_OR_COMPANY_ID;
		__column_names[5] = BaseReimbursementPackageSummary.CS_PAYEE_NAME;
		__column_names[6] = BaseReimbursementPackageSummary.CS_SELF_BANK_NAME;
		__column_names[7] = BaseReimbursementPackageSummary.CS_SELF_BANK_ACCOUNT;
		__column_names[8] = BaseReimbursementPackageSummary.CS_OTHER_NAME;
		__column_names[9] = BaseReimbursementPackageSummary.CS_OTHER_BANK_NAME;
		__column_names[10] = BaseReimbursementPackageSummary.CS_OTHER_BANK_ACCOUNT;
		__column_names[11] = BaseReimbursementPackageSummary.CS_AMOUNT;
		__column_names[12] = BaseReimbursementPackageSummary.CS_PAYMENT_AMOUNT;
		__column_names[13] = BaseReimbursementPackageSummary.CS_STRIKE_A_BALANCE_AMOUNT;
		__column_names[14] = BaseReimbursementPackageSummary.CS_CREATE_TIME;
		__column_names[15] = BaseReimbursementPackageSummary.CS_UPDATE_TIME;
		__column_names[16] = BaseReimbursementPackageSummary.CS_IS_COMPLETED;
		__column_names[17] = BaseReimbursementPackageSummary.CS_COMPANY_ID;
		__column_names[18] = BaseReimbursementPackageSummary.CS_YEAR;
		__column_names[19] = BaseReimbursementPackageSummary.CS_MONTH;
		__column_names[20] = BaseReimbursementPackageSummary.CS_PAY_TYPE;
		__column_names[21] = BaseReimbursementPackageSummary.CS_CMBC_PAYMENT_ID;
		__column_names[22] = BaseReimbursementPackageSummary.CS_PERSONNEL_BUSINESS_ID;
		__column_names[23] = BaseReimbursementPackageSummary.CS_EMPLOYEE_FUND_ISSUANCE_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseReimbursementPackageSummary b) {
		clear();
		setReimbursementPackageSummaryIdClear(b.getReimbursementPackageSummaryId());
	}

	public boolean isPrimaryKeyNull() {
		return getReimbursementPackageSummaryId() == null;
	}

	@Override
	public BaseReimbursementPackageSummary generateBase(){
		BaseReimbursementPackageSummary b = new BaseReimbursementPackageSummary();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseReimbursementPackageSummary b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setReimbursementPackageSummaryId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReimbursementPackageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMoneyAttribute(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPayFor(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeOrCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPayeeName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSelfBankName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSelfBankAccount(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOtherName(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOtherBankName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOtherBankAccount(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPaymentAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setStrikeABalanceAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setIsCompleted(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPayType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCmbcPaymentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeFundIssuanceId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseReimbursementPackageSummary b, Object[] buff){
		int count = 0;
		buff[count++] = b.getReimbursementPackageSummaryId();
		buff[count++] = b.getReimbursementPackageId();
		buff[count++] = b.getMoneyAttribute();
		buff[count++] = b.getPayFor();
		buff[count++] = b.getEmployeeOrCompanyId();
		buff[count++] = b.getPayeeName();
		buff[count++] = b.getSelfBankName();
		buff[count++] = b.getSelfBankAccount();
		buff[count++] = b.getOtherName();
		buff[count++] = b.getOtherBankName();
		buff[count++] = b.getOtherBankAccount();
		buff[count++] = b.getAmount();
		buff[count++] = b.getPaymentAmount();
		buff[count++] = b.getStrikeABalanceAmount();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = generateTimestampFromDate(b.getUpdateTime());
		buff[count++] = b.getIsCompleted();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getPayType();
		buff[count++] = b.getCmbcPaymentId();
		buff[count++] = b.getPersonnelBusinessId();
		buff[count++] = b.getEmployeeFundIssuanceId();
	}

	@Override
	public void setDataFromBase(BaseReimbursementPackageSummary b){
		if(b.getReimbursementPackageSummaryId() != null) setReimbursementPackageSummaryIdClear(b.getReimbursementPackageSummaryId());
		if(b.getReimbursementPackageId() != null) setReimbursementPackageId(b.getReimbursementPackageId());
		if(b.getMoneyAttribute() != null) setMoneyAttribute(b.getMoneyAttribute());
		if(b.getPayFor() != null) setPayFor(b.getPayFor());
		if(b.getEmployeeOrCompanyId() != null) setEmployeeOrCompanyId(b.getEmployeeOrCompanyId());
		if(b.getPayeeName() != null) setPayeeName(b.getPayeeName());
		if(b.getSelfBankName() != null) setSelfBankName(b.getSelfBankName());
		if(b.getSelfBankAccount() != null) setSelfBankAccount(b.getSelfBankAccount());
		if(b.getOtherName() != null) setOtherName(b.getOtherName());
		if(b.getOtherBankName() != null) setOtherBankName(b.getOtherBankName());
		if(b.getOtherBankAccount() != null) setOtherBankAccount(b.getOtherBankAccount());
		if(b.getAmount() != null) setAmount(b.getAmount());
		if(b.getPaymentAmount() != null) setPaymentAmount(b.getPaymentAmount());
		if(b.getStrikeABalanceAmount() != null) setStrikeABalanceAmount(b.getStrikeABalanceAmount());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getUpdateTime() != null) setUpdateTime(b.getUpdateTime());
		if(b.getIsCompleted() != null) setIsCompleted(b.getIsCompleted());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getPayType() != null) setPayType(b.getPayType());
		if(b.getCmbcPaymentId() != null) setCmbcPaymentId(b.getCmbcPaymentId());
		if(b.getPersonnelBusinessId() != null) setPersonnelBusinessId(b.getPersonnelBusinessId());
		if(b.getEmployeeFundIssuanceId() != null) setEmployeeFundIssuanceId(b.getEmployeeFundIssuanceId());
	}

	@Override
	public BaseReimbursementPackageSummary generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseReimbursementPackageSummary b = new BaseReimbursementPackageSummary();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseReimbursementPackageSummary __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReimbursementPackageSummaryId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReimbursementPackageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMoneyAttribute(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayFor(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeOrCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayeeName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSelfBankName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSelfBankAccount(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOtherName(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOtherBankName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOtherBankAccount(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPaymentAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStrikeABalanceAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsCompleted(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCmbcPaymentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeFundIssuanceId(GenericBase.__getInt(val));
	}

	public void setReimbursementPackageSummaryId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getReimbursementPackageSummaryId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setReimbursementPackageSummaryIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setReimbursementPackageId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getReimbursementPackageId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setMoneyAttribute(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getMoneyAttribute() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setPayFor(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getPayFor() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setEmployeeOrCompanyId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getEmployeeOrCompanyId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setPayeeName(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getPayeeName() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setSelfBankName(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getSelfBankName() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setSelfBankAccount(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getSelfBankAccount() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setOtherName(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getOtherName() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setOtherBankName(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getOtherBankName() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setOtherBankAccount(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getOtherBankAccount() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setAmount(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getAmount() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setPaymentAmount(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getPaymentAmount() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setStrikeABalanceAmount(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getStrikeABalanceAmount() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(14, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[14]);
	}

	public void setUpdateTime(java.util.Date val) {
		setCurrentData(15, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateTime() {
		return GenericBase.__getDateFromSQL(__current_data[15]);
	}

	public void setIsCompleted(java.lang.Boolean val) {
		setCurrentData(16, val);
	}

	public java.lang.Boolean getIsCompleted() {
		return GenericBase.__getBoolean(__current_data[16]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(17, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[17]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(18, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[18]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(19, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[19]);
	}

	public void setPayType(java.lang.Integer val) {
		setCurrentData(20, val);
	}

	public java.lang.Integer getPayType() {
		return GenericBase.__getInt(__current_data[20]);
	}

	public void setCmbcPaymentId(java.lang.Integer val) {
		setCurrentData(21, val);
	}

	public java.lang.Integer getCmbcPaymentId() {
		return GenericBase.__getInt(__current_data[21]);
	}

	public void setPersonnelBusinessId(java.lang.Integer val) {
		setCurrentData(22, val);
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return GenericBase.__getInt(__current_data[22]);
	}

	public void setEmployeeFundIssuanceId(java.lang.Integer val) {
		setCurrentData(23, val);
	}

	public java.lang.Integer getEmployeeFundIssuanceId() {
		return GenericBase.__getInt(__current_data[23]);
	}

	public void setConditionReimbursementPackageSummaryId(String op, java.lang.Integer val) {
		setConditionReimbursementPackageSummaryId(op, val, CONDITION_AND);
	}

	public void setConditionReimbursementPackageSummaryId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectReimbursementPackageSummaryId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionReimbursementPackageId(String op, java.lang.Integer val) {
		setConditionReimbursementPackageId(op, val, CONDITION_AND);
	}

	public void setConditionReimbursementPackageId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectReimbursementPackageId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionMoneyAttribute(String op, java.lang.Integer val) {
		setConditionMoneyAttribute(op, val, CONDITION_AND);
	}

	public void setConditionMoneyAttribute(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectMoneyAttribute(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionPayFor(String op, java.lang.Integer val) {
		setConditionPayFor(op, val, CONDITION_AND);
	}

	public void setConditionPayFor(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectPayFor(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionEmployeeOrCompanyId(String op, java.lang.Integer val) {
		setConditionEmployeeOrCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeOrCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectEmployeeOrCompanyId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionPayeeName(String op, java.lang.String val) {
		setConditionPayeeName(op, val, CONDITION_AND);
	}

	public void setConditionPayeeName(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectPayeeName(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionSelfBankName(String op, java.lang.String val) {
		setConditionSelfBankName(op, val, CONDITION_AND);
	}

	public void setConditionSelfBankName(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectSelfBankName(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionSelfBankAccount(String op, java.lang.String val) {
		setConditionSelfBankAccount(op, val, CONDITION_AND);
	}

	public void setConditionSelfBankAccount(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectSelfBankAccount(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionOtherName(String op, java.lang.Integer val) {
		setConditionOtherName(op, val, CONDITION_AND);
	}

	public void setConditionOtherName(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectOtherName(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionOtherBankName(String op, java.lang.String val) {
		setConditionOtherBankName(op, val, CONDITION_AND);
	}

	public void setConditionOtherBankName(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectOtherBankName(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionOtherBankAccount(String op, java.lang.String val) {
		setConditionOtherBankAccount(op, val, CONDITION_AND);
	}

	public void setConditionOtherBankAccount(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectOtherBankAccount(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionAmount(String op, java.math.BigDecimal val) {
		setConditionAmount(op, val, CONDITION_AND);
	}

	public void setConditionAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectAmount(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionPaymentAmount(String op, java.math.BigDecimal val) {
		setConditionPaymentAmount(op, val, CONDITION_AND);
	}

	public void setConditionPaymentAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectPaymentAmount(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionStrikeABalanceAmount(String op, java.math.BigDecimal val) {
		setConditionStrikeABalanceAmount(op, val, CONDITION_AND);
	}

	public void setConditionStrikeABalanceAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectStrikeABalanceAmount(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(14, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionUpdateTime(String op, java.util.Date val) {
		setConditionUpdateTime(op, val, CONDITION_AND);
	}

	public void setConditionUpdateTime(String op, java.util.Date val, String relation) {
		addCondition(15, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUpdateTime(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionIsCompleted(String op, java.lang.Boolean val) {
		setConditionIsCompleted(op, val, CONDITION_AND);
	}

	public void setConditionIsCompleted(String op, java.lang.Boolean val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectIsCompleted(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionPayType(String op, java.lang.Integer val) {
		setConditionPayType(op, val, CONDITION_AND);
	}

	public void setConditionPayType(String op, java.lang.Integer val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectPayType(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionCmbcPaymentId(String op, java.lang.Integer val) {
		setConditionCmbcPaymentId(op, val, CONDITION_AND);
	}

	public void setConditionCmbcPaymentId(String op, java.lang.Integer val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectCmbcPaymentId(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val) {
		setConditionPersonnelBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectPersonnelBusinessId(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionEmployeeFundIssuanceId(String op, java.lang.Integer val) {
		setConditionEmployeeFundIssuanceId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeFundIssuanceId(String op, java.lang.Integer val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectEmployeeFundIssuanceId(boolean val) {
		__select_flags[23] = val;
	}


}

