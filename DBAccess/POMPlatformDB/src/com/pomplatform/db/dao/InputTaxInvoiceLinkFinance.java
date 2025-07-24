package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseInputTaxInvoiceLinkFinance;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class InputTaxInvoiceLinkFinance extends AbstractTable<BaseInputTaxInvoiceLinkFinance>
{

	public InputTaxInvoiceLinkFinance() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 20;

		initTables();

		__tableName            = "input_tax_invoice_link_finances";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseInputTaxInvoiceLinkFinance.CS_INPUT_TAX_INVOICE_LINK_FINANCE_ID;
		__column_names[1] = BaseInputTaxInvoiceLinkFinance.CS_ADD_TYPE;
		__column_names[2] = BaseInputTaxInvoiceLinkFinance.CS_INVOICE_TYPE;
		__column_names[3] = BaseInputTaxInvoiceLinkFinance.CS_INVOICE_CODE;
		__column_names[4] = BaseInputTaxInvoiceLinkFinance.CS_INVOICE_NUMBER;
		__column_names[5] = BaseInputTaxInvoiceLinkFinance.CS_INVOICE_DATE;
		__column_names[6] = BaseInputTaxInvoiceLinkFinance.CS_INVOICE_AMOUNT;
		__column_names[7] = BaseInputTaxInvoiceLinkFinance.CS_TAX_RATE;
		__column_names[8] = BaseInputTaxInvoiceLinkFinance.CS_BUSINESS_ID;
		__column_names[9] = BaseInputTaxInvoiceLinkFinance.CS_PROCESS_TYPE;
		__column_names[10] = BaseInputTaxInvoiceLinkFinance.CS_PROCESS_INSTANCE_ID;
		__column_names[11] = BaseInputTaxInvoiceLinkFinance.CS_OPERATOR;
		__column_names[12] = BaseInputTaxInvoiceLinkFinance.CS_CREATE_TIME;
		__column_names[13] = BaseInputTaxInvoiceLinkFinance.CS_DELETE_FLAG;
		__column_names[14] = BaseInputTaxInvoiceLinkFinance.CS_REMARK;
		__column_names[15] = BaseInputTaxInvoiceLinkFinance.CS_OTHER_REMARK;
		__column_names[16] = BaseInputTaxInvoiceLinkFinance.CS_RANDOM_CODE;
		__column_names[17] = BaseInputTaxInvoiceLinkFinance.CS_TAX_AMOUNT;
		__column_names[18] = BaseInputTaxInvoiceLinkFinance.CS_CODE;
		__column_names[19] = BaseInputTaxInvoiceLinkFinance.CS_COMPANY_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseInputTaxInvoiceLinkFinance b) {
		clear();
		setInputTaxInvoiceLinkFinanceIdClear(b.getInputTaxInvoiceLinkFinanceId());
	}

	public boolean isPrimaryKeyNull() {
		return getInputTaxInvoiceLinkFinanceId() == null;
	}

	@Override
	public BaseInputTaxInvoiceLinkFinance generateBase(){
		BaseInputTaxInvoiceLinkFinance b = new BaseInputTaxInvoiceLinkFinance();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseInputTaxInvoiceLinkFinance b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setInputTaxInvoiceLinkFinanceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAddType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInvoiceType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInvoiceCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setInvoiceNumber(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setInvoiceDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setInvoiceAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTaxRate(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOtherRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRandomCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTaxAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseInputTaxInvoiceLinkFinance b, Object[] buff){
		int count = 0;
		buff[count++] = b.getInputTaxInvoiceLinkFinanceId();
		buff[count++] = b.getAddType();
		buff[count++] = b.getInvoiceType();
		buff[count++] = b.getInvoiceCode();
		buff[count++] = b.getInvoiceNumber();
		buff[count++] = generateTimestampFromDate(b.getInvoiceDate());
		buff[count++] = b.getInvoiceAmount();
		buff[count++] = b.getTaxRate();
		buff[count++] = b.getBusinessId();
		buff[count++] = b.getProcessType();
		buff[count++] = b.getProcessInstanceId();
		buff[count++] = b.getOperator();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getDeleteFlag();
		buff[count++] = b.getRemark();
		buff[count++] = b.getOtherRemark();
		buff[count++] = b.getRandomCode();
		buff[count++] = b.getTaxAmount();
		buff[count++] = b.getCode();
		buff[count++] = b.getCompanyId();
	}

	@Override
	public void setDataFromBase(BaseInputTaxInvoiceLinkFinance b){
		if(b.getInputTaxInvoiceLinkFinanceId() != null) setInputTaxInvoiceLinkFinanceIdClear(b.getInputTaxInvoiceLinkFinanceId());
		if(b.getAddType() != null) setAddType(b.getAddType());
		if(b.getInvoiceType() != null) setInvoiceType(b.getInvoiceType());
		if(b.getInvoiceCode() != null) setInvoiceCode(b.getInvoiceCode());
		if(b.getInvoiceNumber() != null) setInvoiceNumber(b.getInvoiceNumber());
		if(b.getInvoiceDate() != null) setInvoiceDate(b.getInvoiceDate());
		if(b.getInvoiceAmount() != null) setInvoiceAmount(b.getInvoiceAmount());
		if(b.getTaxRate() != null) setTaxRate(b.getTaxRate());
		if(b.getBusinessId() != null) setBusinessId(b.getBusinessId());
		if(b.getProcessType() != null) setProcessType(b.getProcessType());
		if(b.getProcessInstanceId() != null) setProcessInstanceId(b.getProcessInstanceId());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getOtherRemark() != null) setOtherRemark(b.getOtherRemark());
		if(b.getRandomCode() != null) setRandomCode(b.getRandomCode());
		if(b.getTaxAmount() != null) setTaxAmount(b.getTaxAmount());
		if(b.getCode() != null) setCode(b.getCode());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
	}

	@Override
	public BaseInputTaxInvoiceLinkFinance generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseInputTaxInvoiceLinkFinance b = new BaseInputTaxInvoiceLinkFinance();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseInputTaxInvoiceLinkFinance __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInputTaxInvoiceLinkFinanceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAddType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceNumber(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaxRate(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOtherRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRandomCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaxAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
	}

	public void setInputTaxInvoiceLinkFinanceId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getInputTaxInvoiceLinkFinanceId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setInputTaxInvoiceLinkFinanceIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setAddType(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getAddType() {
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

	public void setInvoiceDate(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getInvoiceDate() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setInvoiceAmount(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getInvoiceAmount() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setTaxRate(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getTaxRate() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setBusinessId(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getBusinessId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setProcessType(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getProcessType() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setProcessInstanceId(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getProcessInstanceId() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(12, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[12]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(14, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[14]);
	}

	public void setOtherRemark(java.lang.String val) {
		setCurrentData(15, val);
	}

	public java.lang.String getOtherRemark() {
		return GenericBase.__getString(__current_data[15]);
	}

	public void setRandomCode(java.lang.String val) {
		setCurrentData(16, val);
	}

	public java.lang.String getRandomCode() {
		return GenericBase.__getString(__current_data[16]);
	}

	public void setTaxAmount(java.math.BigDecimal val) {
		setCurrentData(17, val);
	}

	public java.math.BigDecimal getTaxAmount() {
		return GenericBase.__getDecimal(__current_data[17]);
	}

	public void setCode(java.lang.String val) {
		setCurrentData(18, val);
	}

	public java.lang.String getCode() {
		return GenericBase.__getString(__current_data[18]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(19, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[19]);
	}

	public void setConditionInputTaxInvoiceLinkFinanceId(String op, java.lang.Integer val) {
		setConditionInputTaxInvoiceLinkFinanceId(op, val, CONDITION_AND);
	}

	public void setConditionInputTaxInvoiceLinkFinanceId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectInputTaxInvoiceLinkFinanceId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionAddType(String op, java.lang.Integer val) {
		setConditionAddType(op, val, CONDITION_AND);
	}

	public void setConditionAddType(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectAddType(boolean val) {
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

	public void setConditionInvoiceDate(String op, java.util.Date val) {
		setConditionInvoiceDate(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceDate(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectInvoiceDate(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionInvoiceAmount(String op, java.math.BigDecimal val) {
		setConditionInvoiceAmount(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectInvoiceAmount(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionTaxRate(String op, java.math.BigDecimal val) {
		setConditionTaxRate(op, val, CONDITION_AND);
	}

	public void setConditionTaxRate(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectTaxRate(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionBusinessId(String op, java.lang.Integer val) {
		setConditionBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectBusinessId(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionProcessType(String op, java.lang.Integer val) {
		setConditionProcessType(op, val, CONDITION_AND);
	}

	public void setConditionProcessType(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectProcessType(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionProcessInstanceId(String op, java.lang.Integer val) {
		setConditionProcessInstanceId(op, val, CONDITION_AND);
	}

	public void setConditionProcessInstanceId(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectProcessInstanceId(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
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

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionOtherRemark(String op, java.lang.String val) {
		setConditionOtherRemark(op, val, CONDITION_AND);
	}

	public void setConditionOtherRemark(String op, java.lang.String val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectOtherRemark(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionRandomCode(String op, java.lang.String val) {
		setConditionRandomCode(op, val, CONDITION_AND);
	}

	public void setConditionRandomCode(String op, java.lang.String val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectRandomCode(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionTaxAmount(String op, java.math.BigDecimal val) {
		setConditionTaxAmount(op, val, CONDITION_AND);
	}

	public void setConditionTaxAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectTaxAmount(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionCode(String op, java.lang.String val) {
		setConditionCode(op, val, CONDITION_AND);
	}

	public void setConditionCode(String op, java.lang.String val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectCode(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[19] = val;
	}


}

