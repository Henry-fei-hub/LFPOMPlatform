package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseInvoice;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class Invoice extends AbstractTable<BaseInvoice>
{

	public Invoice() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 32;

		initTables();

		__tableName            = "invoices";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseInvoice.CS_INVOICE_ID;
		__column_names[1] = BaseInvoice.CS_TICKETING_COMPANY;
		__column_names[2] = BaseInvoice.CS_INVOICE_TYPE;
		__column_names[3] = BaseInvoice.CS_INVOICE_CODE;
		__column_names[4] = BaseInvoice.CS_INVOICE_NUMBER;
		__column_names[5] = BaseInvoice.CS_IN_STOCK_DATE;
		__column_names[6] = BaseInvoice.CS_INVALID_REMARK;
		__column_names[7] = BaseInvoice.CS_IS_INVALID_OPERATOR;
		__column_names[8] = BaseInvoice.CS_STORAGE_OPERATOR;
		__column_names[9] = BaseInvoice.CS_INFO_CODE;
		__column_names[10] = BaseInvoice.CS_PROJECT_CODE;
		__column_names[11] = BaseInvoice.CS_CONTRACT_ID;
		__column_names[12] = BaseInvoice.CS_CONTRACT_CODE;
		__column_names[13] = BaseInvoice.CS_INVOICE_AMOUNT;
		__column_names[14] = BaseInvoice.CS_TAX_RATE;
		__column_names[15] = BaseInvoice.CS_NO_TAX_AMOUNT;
		__column_names[16] = BaseInvoice.CS_OUTPUT_TAX;
		__column_names[17] = BaseInvoice.CS_BILLING_OPERATION;
		__column_names[18] = BaseInvoice.CS_INVOICE_DATE;
		__column_names[19] = BaseInvoice.CS_REGISTRATION_DATE;
		__column_names[20] = BaseInvoice.CS_SIGN;
		__column_names[21] = BaseInvoice.CS_PRIMARY_INVOICE_CODE;
		__column_names[22] = BaseInvoice.CS_PRIMARY_INVOICE_NUMBER;
		__column_names[23] = BaseInvoice.CS_CONTRACT_RECEIVABLE_ID;
		__column_names[24] = BaseInvoice.CS_ACKNOWLEDGE_LETTER_ID;
		__column_names[25] = BaseInvoice.CS_INVOICE_EXPRESS_ID;
		__column_names[26] = BaseInvoice.CS_DISABLE_TYPE;
		__column_names[27] = BaseInvoice.CS_HAVE_VOUCHER;
		__column_names[28] = BaseInvoice.CS_IS_CAPITAL;
		__column_names[29] = BaseInvoice.CS_CAPITAL_AMOUNT;
		__column_names[30] = BaseInvoice.CS_PROJECT_MANAGER_ID;
		__column_names[31] = BaseInvoice.CS_CUSTOMER_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseInvoice b) {
		clear();
		setInvoiceIdClear(b.getInvoiceId());
	}

	public boolean isPrimaryKeyNull() {
		return getInvoiceId() == null;
	}

	@Override
	public BaseInvoice generateBase(){
		BaseInvoice b = new BaseInvoice();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseInvoice b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setInvoiceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTicketingCompany(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInvoiceType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInvoiceCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setInvoiceNumber(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setInStockDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setInvalidRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsInvalidOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStorageOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInfoCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setInvoiceAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTaxRate(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setNoTaxAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOutputTax(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setBillingOperation(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInvoiceDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRegistrationDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setSign(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPrimaryInvoiceCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPrimaryInvoiceNumber(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractReceivableId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAcknowledgeLetterId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInvoiceExpressId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDisableType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setHaveVoucher(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setIsCapital(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCapitalAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectManagerId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCustomerId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseInvoice b, Object[] buff){
		int count = 0;
		buff[count++] = b.getInvoiceId();
		buff[count++] = b.getTicketingCompany();
		buff[count++] = b.getInvoiceType();
		buff[count++] = b.getInvoiceCode();
		buff[count++] = b.getInvoiceNumber();
		buff[count++] = generateTimestampFromDate(b.getInStockDate());
		buff[count++] = b.getInvalidRemark();
		buff[count++] = b.getIsInvalidOperator();
		buff[count++] = b.getStorageOperator();
		buff[count++] = b.getInfoCode();
		buff[count++] = b.getProjectCode();
		buff[count++] = b.getContractId();
		buff[count++] = b.getContractCode();
		buff[count++] = b.getInvoiceAmount();
		buff[count++] = b.getTaxRate();
		buff[count++] = b.getNoTaxAmount();
		buff[count++] = b.getOutputTax();
		buff[count++] = b.getBillingOperation();
		buff[count++] = generateTimestampFromDate(b.getInvoiceDate());
		buff[count++] = generateTimestampFromDate(b.getRegistrationDate());
		buff[count++] = b.getSign();
		buff[count++] = b.getPrimaryInvoiceCode();
		buff[count++] = b.getPrimaryInvoiceNumber();
		buff[count++] = b.getContractReceivableId();
		buff[count++] = b.getAcknowledgeLetterId();
		buff[count++] = b.getInvoiceExpressId();
		buff[count++] = b.getDisableType();
		buff[count++] = b.getHaveVoucher();
		buff[count++] = b.getIsCapital();
		buff[count++] = b.getCapitalAmount();
		buff[count++] = b.getProjectManagerId();
		buff[count++] = b.getCustomerId();
	}

	@Override
	public void setDataFromBase(BaseInvoice b){
		if(b.getInvoiceId() != null) setInvoiceIdClear(b.getInvoiceId());
		if(b.getTicketingCompany() != null) setTicketingCompany(b.getTicketingCompany());
		if(b.getInvoiceType() != null) setInvoiceType(b.getInvoiceType());
		if(b.getInvoiceCode() != null) setInvoiceCode(b.getInvoiceCode());
		if(b.getInvoiceNumber() != null) setInvoiceNumber(b.getInvoiceNumber());
		if(b.getInStockDate() != null) setInStockDate(b.getInStockDate());
		if(b.getInvalidRemark() != null) setInvalidRemark(b.getInvalidRemark());
		if(b.getIsInvalidOperator() != null) setIsInvalidOperator(b.getIsInvalidOperator());
		if(b.getStorageOperator() != null) setStorageOperator(b.getStorageOperator());
		if(b.getInfoCode() != null) setInfoCode(b.getInfoCode());
		if(b.getProjectCode() != null) setProjectCode(b.getProjectCode());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getContractCode() != null) setContractCode(b.getContractCode());
		if(b.getInvoiceAmount() != null) setInvoiceAmount(b.getInvoiceAmount());
		if(b.getTaxRate() != null) setTaxRate(b.getTaxRate());
		if(b.getNoTaxAmount() != null) setNoTaxAmount(b.getNoTaxAmount());
		if(b.getOutputTax() != null) setOutputTax(b.getOutputTax());
		if(b.getBillingOperation() != null) setBillingOperation(b.getBillingOperation());
		if(b.getInvoiceDate() != null) setInvoiceDate(b.getInvoiceDate());
		if(b.getRegistrationDate() != null) setRegistrationDate(b.getRegistrationDate());
		if(b.getSign() != null) setSign(b.getSign());
		if(b.getPrimaryInvoiceCode() != null) setPrimaryInvoiceCode(b.getPrimaryInvoiceCode());
		if(b.getPrimaryInvoiceNumber() != null) setPrimaryInvoiceNumber(b.getPrimaryInvoiceNumber());
		if(b.getContractReceivableId() != null) setContractReceivableId(b.getContractReceivableId());
		if(b.getAcknowledgeLetterId() != null) setAcknowledgeLetterId(b.getAcknowledgeLetterId());
		if(b.getInvoiceExpressId() != null) setInvoiceExpressId(b.getInvoiceExpressId());
		if(b.getDisableType() != null) setDisableType(b.getDisableType());
		if(b.getHaveVoucher() != null) setHaveVoucher(b.getHaveVoucher());
		if(b.getIsCapital() != null) setIsCapital(b.getIsCapital());
		if(b.getCapitalAmount() != null) setCapitalAmount(b.getCapitalAmount());
		if(b.getProjectManagerId() != null) setProjectManagerId(b.getProjectManagerId());
		if(b.getCustomerId() != null) setCustomerId(b.getCustomerId());
	}

	@Override
	public BaseInvoice generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseInvoice b = new BaseInvoice();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseInvoice __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTicketingCompany(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceNumber(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInStockDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvalidRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsInvalidOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStorageOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInfoCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaxRate(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNoTaxAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOutputTax(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBillingOperation(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRegistrationDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSign(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPrimaryInvoiceCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPrimaryInvoiceNumber(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractReceivableId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAcknowledgeLetterId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceExpressId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDisableType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHaveVoucher(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsCapital(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCapitalAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectManagerId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCustomerId(GenericBase.__getInt(val));
	}

	public void setInvoiceId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getInvoiceId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setInvoiceIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setTicketingCompany(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getTicketingCompany() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setInvoiceType(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getInvoiceType() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setInvoiceCode(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getInvoiceCode() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setInvoiceNumber(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getInvoiceNumber() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setInStockDate(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getInStockDate() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setInvalidRemark(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getInvalidRemark() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setIsInvalidOperator(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getIsInvalidOperator() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setStorageOperator(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getStorageOperator() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setInfoCode(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getInfoCode() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setProjectCode(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getProjectCode() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setContractCode(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getContractCode() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setInvoiceAmount(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getInvoiceAmount() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setTaxRate(java.math.BigDecimal val) {
		setCurrentData(14, val);
	}

	public java.math.BigDecimal getTaxRate() {
		return GenericBase.__getDecimal(__current_data[14]);
	}

	public void setNoTaxAmount(java.math.BigDecimal val) {
		setCurrentData(15, val);
	}

	public java.math.BigDecimal getNoTaxAmount() {
		return GenericBase.__getDecimal(__current_data[15]);
	}

	public void setOutputTax(java.math.BigDecimal val) {
		setCurrentData(16, val);
	}

	public java.math.BigDecimal getOutputTax() {
		return GenericBase.__getDecimal(__current_data[16]);
	}

	public void setBillingOperation(java.lang.Integer val) {
		setCurrentData(17, val);
	}

	public java.lang.Integer getBillingOperation() {
		return GenericBase.__getInt(__current_data[17]);
	}

	public void setInvoiceDate(java.util.Date val) {
		setCurrentData(18, generateTimestampFromDate(val));
	}

	public java.util.Date getInvoiceDate() {
		return GenericBase.__getDateFromSQL(__current_data[18]);
	}

	public void setRegistrationDate(java.util.Date val) {
		setCurrentData(19, generateTimestampFromDate(val));
	}

	public java.util.Date getRegistrationDate() {
		return GenericBase.__getDateFromSQL(__current_data[19]);
	}

	public void setSign(java.lang.Integer val) {
		setCurrentData(20, val);
	}

	public java.lang.Integer getSign() {
		return GenericBase.__getInt(__current_data[20]);
	}

	public void setPrimaryInvoiceCode(java.lang.String val) {
		setCurrentData(21, val);
	}

	public java.lang.String getPrimaryInvoiceCode() {
		return GenericBase.__getString(__current_data[21]);
	}

	public void setPrimaryInvoiceNumber(java.lang.String val) {
		setCurrentData(22, val);
	}

	public java.lang.String getPrimaryInvoiceNumber() {
		return GenericBase.__getString(__current_data[22]);
	}

	public void setContractReceivableId(java.lang.Integer val) {
		setCurrentData(23, val);
	}

	public java.lang.Integer getContractReceivableId() {
		return GenericBase.__getInt(__current_data[23]);
	}

	public void setAcknowledgeLetterId(java.lang.Integer val) {
		setCurrentData(24, val);
	}

	public java.lang.Integer getAcknowledgeLetterId() {
		return GenericBase.__getInt(__current_data[24]);
	}

	public void setInvoiceExpressId(java.lang.Integer val) {
		setCurrentData(25, val);
	}

	public java.lang.Integer getInvoiceExpressId() {
		return GenericBase.__getInt(__current_data[25]);
	}

	public void setDisableType(java.lang.Integer val) {
		setCurrentData(26, val);
	}

	public java.lang.Integer getDisableType() {
		return GenericBase.__getInt(__current_data[26]);
	}

	public void setHaveVoucher(java.lang.Boolean val) {
		setCurrentData(27, val);
	}

	public java.lang.Boolean getHaveVoucher() {
		return GenericBase.__getBoolean(__current_data[27]);
	}

	public void setIsCapital(java.lang.Integer val) {
		setCurrentData(28, val);
	}

	public java.lang.Integer getIsCapital() {
		return GenericBase.__getInt(__current_data[28]);
	}

	public void setCapitalAmount(java.math.BigDecimal val) {
		setCurrentData(29, val);
	}

	public java.math.BigDecimal getCapitalAmount() {
		return GenericBase.__getDecimal(__current_data[29]);
	}

	public void setProjectManagerId(java.lang.Integer val) {
		setCurrentData(30, val);
	}

	public java.lang.Integer getProjectManagerId() {
		return GenericBase.__getInt(__current_data[30]);
	}

	public void setCustomerId(java.lang.Integer val) {
		setCurrentData(31, val);
	}

	public java.lang.Integer getCustomerId() {
		return GenericBase.__getInt(__current_data[31]);
	}

	public void setConditionInvoiceId(String op, java.lang.Integer val) {
		setConditionInvoiceId(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectInvoiceId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionTicketingCompany(String op, java.lang.Integer val) {
		setConditionTicketingCompany(op, val, CONDITION_AND);
	}

	public void setConditionTicketingCompany(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectTicketingCompany(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionInvoiceType(String op, java.lang.Integer val) {
		setConditionInvoiceType(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceType(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectInvoiceType(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionInvoiceCode(String op, java.lang.String val) {
		setConditionInvoiceCode(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceCode(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectInvoiceCode(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionInvoiceNumber(String op, java.lang.String val) {
		setConditionInvoiceNumber(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceNumber(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectInvoiceNumber(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionInStockDate(String op, java.util.Date val) {
		setConditionInStockDate(op, val, CONDITION_AND);
	}

	public void setConditionInStockDate(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectInStockDate(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionInvalidRemark(String op, java.lang.String val) {
		setConditionInvalidRemark(op, val, CONDITION_AND);
	}

	public void setConditionInvalidRemark(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectInvalidRemark(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionIsInvalidOperator(String op, java.lang.Integer val) {
		setConditionIsInvalidOperator(op, val, CONDITION_AND);
	}

	public void setConditionIsInvalidOperator(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectIsInvalidOperator(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionStorageOperator(String op, java.lang.Integer val) {
		setConditionStorageOperator(op, val, CONDITION_AND);
	}

	public void setConditionStorageOperator(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectStorageOperator(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionInfoCode(String op, java.lang.String val) {
		setConditionInfoCode(op, val, CONDITION_AND);
	}

	public void setConditionInfoCode(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectInfoCode(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionProjectCode(String op, java.lang.String val) {
		setConditionProjectCode(op, val, CONDITION_AND);
	}

	public void setConditionProjectCode(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectProjectCode(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionContractCode(String op, java.lang.String val) {
		setConditionContractCode(op, val, CONDITION_AND);
	}

	public void setConditionContractCode(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectContractCode(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionInvoiceAmount(String op, java.math.BigDecimal val) {
		setConditionInvoiceAmount(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectInvoiceAmount(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionTaxRate(String op, java.math.BigDecimal val) {
		setConditionTaxRate(op, val, CONDITION_AND);
	}

	public void setConditionTaxRate(String op, java.math.BigDecimal val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectTaxRate(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionNoTaxAmount(String op, java.math.BigDecimal val) {
		setConditionNoTaxAmount(op, val, CONDITION_AND);
	}

	public void setConditionNoTaxAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectNoTaxAmount(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionOutputTax(String op, java.math.BigDecimal val) {
		setConditionOutputTax(op, val, CONDITION_AND);
	}

	public void setConditionOutputTax(String op, java.math.BigDecimal val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectOutputTax(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionBillingOperation(String op, java.lang.Integer val) {
		setConditionBillingOperation(op, val, CONDITION_AND);
	}

	public void setConditionBillingOperation(String op, java.lang.Integer val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectBillingOperation(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionInvoiceDate(String op, java.util.Date val) {
		setConditionInvoiceDate(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceDate(String op, java.util.Date val, String relation) {
		addCondition(18, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectInvoiceDate(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionRegistrationDate(String op, java.util.Date val) {
		setConditionRegistrationDate(op, val, CONDITION_AND);
	}

	public void setConditionRegistrationDate(String op, java.util.Date val, String relation) {
		addCondition(19, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRegistrationDate(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionSign(String op, java.lang.Integer val) {
		setConditionSign(op, val, CONDITION_AND);
	}

	public void setConditionSign(String op, java.lang.Integer val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectSign(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionPrimaryInvoiceCode(String op, java.lang.String val) {
		setConditionPrimaryInvoiceCode(op, val, CONDITION_AND);
	}

	public void setConditionPrimaryInvoiceCode(String op, java.lang.String val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectPrimaryInvoiceCode(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionPrimaryInvoiceNumber(String op, java.lang.String val) {
		setConditionPrimaryInvoiceNumber(op, val, CONDITION_AND);
	}

	public void setConditionPrimaryInvoiceNumber(String op, java.lang.String val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectPrimaryInvoiceNumber(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionContractReceivableId(String op, java.lang.Integer val) {
		setConditionContractReceivableId(op, val, CONDITION_AND);
	}

	public void setConditionContractReceivableId(String op, java.lang.Integer val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectContractReceivableId(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionAcknowledgeLetterId(String op, java.lang.Integer val) {
		setConditionAcknowledgeLetterId(op, val, CONDITION_AND);
	}

	public void setConditionAcknowledgeLetterId(String op, java.lang.Integer val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectAcknowledgeLetterId(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionInvoiceExpressId(String op, java.lang.Integer val) {
		setConditionInvoiceExpressId(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceExpressId(String op, java.lang.Integer val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectInvoiceExpressId(boolean val) {
		__select_flags[25] = val;
	}

	public void setConditionDisableType(String op, java.lang.Integer val) {
		setConditionDisableType(op, val, CONDITION_AND);
	}

	public void setConditionDisableType(String op, java.lang.Integer val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectDisableType(boolean val) {
		__select_flags[26] = val;
	}

	public void setConditionHaveVoucher(String op, java.lang.Boolean val) {
		setConditionHaveVoucher(op, val, CONDITION_AND);
	}

	public void setConditionHaveVoucher(String op, java.lang.Boolean val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectHaveVoucher(boolean val) {
		__select_flags[27] = val;
	}

	public void setConditionIsCapital(String op, java.lang.Integer val) {
		setConditionIsCapital(op, val, CONDITION_AND);
	}

	public void setConditionIsCapital(String op, java.lang.Integer val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectIsCapital(boolean val) {
		__select_flags[28] = val;
	}

	public void setConditionCapitalAmount(String op, java.math.BigDecimal val) {
		setConditionCapitalAmount(op, val, CONDITION_AND);
	}

	public void setConditionCapitalAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectCapitalAmount(boolean val) {
		__select_flags[29] = val;
	}

	public void setConditionProjectManagerId(String op, java.lang.Integer val) {
		setConditionProjectManagerId(op, val, CONDITION_AND);
	}

	public void setConditionProjectManagerId(String op, java.lang.Integer val, String relation) {
		addCondition(30, op, relation, val);
	}

	public void setSelectProjectManagerId(boolean val) {
		__select_flags[30] = val;
	}

	public void setConditionCustomerId(String op, java.lang.Integer val) {
		setConditionCustomerId(op, val, CONDITION_AND);
	}

	public void setConditionCustomerId(String op, java.lang.Integer val, String relation) {
		addCondition(31, op, relation, val);
	}

	public void setSelectCustomerId(boolean val) {
		__select_flags[31] = val;
	}


}

