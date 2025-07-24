package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseFinancialAccountInitAmount;


public class FinancialAccountInitAmount extends AbstractTable<BaseFinancialAccountInitAmount>
{

	public FinancialAccountInitAmount() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 14;

		initTables();

		__tableName            = "financial_account_init_amount";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseFinancialAccountInitAmount.CS_FINANCIAL_ACCOUNT_INIT_AMOUNT_ID;
		__column_names[1] = BaseFinancialAccountInitAmount.CS_FINANCIAL_TRANSACTION_ACCOUNT_ID;
		__column_names[2] = BaseFinancialAccountInitAmount.CS_CURRENCY_TYPE;
		__column_names[3] = BaseFinancialAccountInitAmount.CS_ORIGINAL_DEBIT;
		__column_names[4] = BaseFinancialAccountInitAmount.CS_ORIGINAL_CREDIT;
		__column_names[5] = BaseFinancialAccountInitAmount.CS_EXCHANGE_RATE;
		__column_names[6] = BaseFinancialAccountInitAmount.CS_STANDARD_DEBIT;
		__column_names[7] = BaseFinancialAccountInitAmount.CS_STANDARD_CREDIT;
		__column_names[8] = BaseFinancialAccountInitAmount.CS_SUMMARY;
		__column_names[9] = BaseFinancialAccountInitAmount.CS_ATTACHMENT_ID;
		__column_names[10] = BaseFinancialAccountInitAmount.CS_OPERATOR_ID;
		__column_names[11] = BaseFinancialAccountInitAmount.CS_CREATE_TIME;
		__column_names[12] = BaseFinancialAccountInitAmount.CS_DELETE_FLAG;
		__column_names[13] = BaseFinancialAccountInitAmount.CS_COMPANY_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseFinancialAccountInitAmount b) {
		clear();
		setFinancialAccountInitAmountIdClear(b.getFinancialAccountInitAmountId());
	}

	public boolean isPrimaryKeyNull() {
		return getFinancialAccountInitAmountId() == null;
	}

	@Override
	public BaseFinancialAccountInitAmount generateBase(){
		BaseFinancialAccountInitAmount b = new BaseFinancialAccountInitAmount();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseFinancialAccountInitAmount b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setFinancialAccountInitAmountId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFinancialTransactionAccountId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCurrencyType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOriginalDebit(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOriginalCredit(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setExchangeRate(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setStandardDebit(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setStandardCredit(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSummary(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAttachmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperatorId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseFinancialAccountInitAmount b, Object[] buff){
		int count = 0;
		buff[count++] = b.getFinancialAccountInitAmountId();
		buff[count++] = b.getFinancialTransactionAccountId();
		buff[count++] = b.getCurrencyType();
		buff[count++] = b.getOriginalDebit();
		buff[count++] = b.getOriginalCredit();
		buff[count++] = b.getExchangeRate();
		buff[count++] = b.getStandardDebit();
		buff[count++] = b.getStandardCredit();
		buff[count++] = b.getSummary();
		buff[count++] = b.getAttachmentId();
		buff[count++] = b.getOperatorId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getDeleteFlag();
		buff[count++] = b.getCompanyId();
	}

	@Override
	public void setDataFromBase(BaseFinancialAccountInitAmount b){
		if(b.getFinancialAccountInitAmountId() != null) setFinancialAccountInitAmountIdClear(b.getFinancialAccountInitAmountId());
		if(b.getFinancialTransactionAccountId() != null) setFinancialTransactionAccountId(b.getFinancialTransactionAccountId());
		if(b.getCurrencyType() != null) setCurrencyType(b.getCurrencyType());
		if(b.getOriginalDebit() != null) setOriginalDebit(b.getOriginalDebit());
		if(b.getOriginalCredit() != null) setOriginalCredit(b.getOriginalCredit());
		if(b.getExchangeRate() != null) setExchangeRate(b.getExchangeRate());
		if(b.getStandardDebit() != null) setStandardDebit(b.getStandardDebit());
		if(b.getStandardCredit() != null) setStandardCredit(b.getStandardCredit());
		if(b.getSummary() != null) setSummary(b.getSummary());
		if(b.getAttachmentId() != null) setAttachmentId(b.getAttachmentId());
		if(b.getOperatorId() != null) setOperatorId(b.getOperatorId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
	}

	@Override
	public BaseFinancialAccountInitAmount generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseFinancialAccountInitAmount b = new BaseFinancialAccountInitAmount();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseFinancialAccountInitAmount __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinancialAccountInitAmountId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinancialTransactionAccountId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCurrencyType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOriginalDebit(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOriginalCredit(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setExchangeRate(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStandardDebit(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStandardCredit(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSummary(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
	}

	public void setFinancialAccountInitAmountId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getFinancialAccountInitAmountId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setFinancialAccountInitAmountIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setFinancialTransactionAccountId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getFinancialTransactionAccountId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setCurrencyType(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getCurrencyType() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setOriginalDebit(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getOriginalDebit() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setOriginalCredit(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getOriginalCredit() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setExchangeRate(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getExchangeRate() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setStandardDebit(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getStandardDebit() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setStandardCredit(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getStandardCredit() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setSummary(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getSummary() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setAttachmentId(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getAttachmentId() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setOperatorId(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getOperatorId() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(11, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[11]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setConditionFinancialAccountInitAmountId(String op, java.lang.Integer val) {
		setConditionFinancialAccountInitAmountId(op, val, CONDITION_AND);
	}

	public void setConditionFinancialAccountInitAmountId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectFinancialAccountInitAmountId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionFinancialTransactionAccountId(String op, java.lang.Integer val) {
		setConditionFinancialTransactionAccountId(op, val, CONDITION_AND);
	}

	public void setConditionFinancialTransactionAccountId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectFinancialTransactionAccountId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionCurrencyType(String op, java.lang.Integer val) {
		setConditionCurrencyType(op, val, CONDITION_AND);
	}

	public void setConditionCurrencyType(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCurrencyType(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionOriginalDebit(String op, java.math.BigDecimal val) {
		setConditionOriginalDebit(op, val, CONDITION_AND);
	}

	public void setConditionOriginalDebit(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectOriginalDebit(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionOriginalCredit(String op, java.math.BigDecimal val) {
		setConditionOriginalCredit(op, val, CONDITION_AND);
	}

	public void setConditionOriginalCredit(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectOriginalCredit(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionExchangeRate(String op, java.math.BigDecimal val) {
		setConditionExchangeRate(op, val, CONDITION_AND);
	}

	public void setConditionExchangeRate(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectExchangeRate(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionStandardDebit(String op, java.math.BigDecimal val) {
		setConditionStandardDebit(op, val, CONDITION_AND);
	}

	public void setConditionStandardDebit(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectStandardDebit(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionStandardCredit(String op, java.math.BigDecimal val) {
		setConditionStandardCredit(op, val, CONDITION_AND);
	}

	public void setConditionStandardCredit(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectStandardCredit(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionSummary(String op, java.lang.String val) {
		setConditionSummary(op, val, CONDITION_AND);
	}

	public void setConditionSummary(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectSummary(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionAttachmentId(String op, java.lang.Integer val) {
		setConditionAttachmentId(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentId(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectAttachmentId(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionOperatorId(String op, java.lang.Integer val) {
		setConditionOperatorId(op, val, CONDITION_AND);
	}

	public void setConditionOperatorId(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectOperatorId(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(11, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[13] = val;
	}


}

