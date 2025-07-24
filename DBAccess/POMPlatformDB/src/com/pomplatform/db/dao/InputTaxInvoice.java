package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseInputTaxInvoice;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class InputTaxInvoice extends AbstractTable<BaseInputTaxInvoice>
{

	public InputTaxInvoice() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 17;

		initTables();

		__tableName            = "input_tax_invoices";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseInputTaxInvoice.CS_INPUT_TAX_INVOICE_ID;
		__column_names[1] = BaseInputTaxInvoice.CS_INVOICE_TYPE;
		__column_names[2] = BaseInputTaxInvoice.CS_INVOICE_CODE;
		__column_names[3] = BaseInputTaxInvoice.CS_INVOICE_NUMBER;
		__column_names[4] = BaseInputTaxInvoice.CS_INVOICE_DATE;
		__column_names[5] = BaseInputTaxInvoice.CS_INVOICE_AMOUNT;
		__column_names[6] = BaseInputTaxInvoice.CS_TAX_RATE;
		__column_names[7] = BaseInputTaxInvoice.CS_OPERATOR;
		__column_names[8] = BaseInputTaxInvoice.CS_CREATE_TIME;
		__column_names[9] = BaseInputTaxInvoice.CS_REMARK;
		__column_names[10] = BaseInputTaxInvoice.CS_OTHER_REMARK;
		__column_names[11] = BaseInputTaxInvoice.CS_SALES_CODE;
		__column_names[12] = BaseInputTaxInvoice.CS_TAX_AMOUNT;
		__column_names[13] = BaseInputTaxInvoice.CS_SALES_NAME;
		__column_names[14] = BaseInputTaxInvoice.CS_YEAR;
		__column_names[15] = BaseInputTaxInvoice.CS_MONTH;
		__column_names[16] = BaseInputTaxInvoice.CS_HAVE_CHECK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseInputTaxInvoice b) {
		clear();
		setInputTaxInvoiceIdClear(b.getInputTaxInvoiceId());
	}

	public boolean isPrimaryKeyNull() {
		return getInputTaxInvoiceId() == null;
	}

	@Override
	public BaseInputTaxInvoice generateBase(){
		BaseInputTaxInvoice b = new BaseInputTaxInvoice();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseInputTaxInvoice b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setInputTaxInvoiceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInvoiceType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInvoiceCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setInvoiceNumber(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setInvoiceDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setInvoiceAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTaxRate(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOtherRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSalesCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTaxAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSalesName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setHaveCheck(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseInputTaxInvoice b, Object[] buff){
		int count = 0;
		buff[count++] = b.getInputTaxInvoiceId();
		buff[count++] = b.getInvoiceType();
		buff[count++] = b.getInvoiceCode();
		buff[count++] = b.getInvoiceNumber();
		buff[count++] = generateTimestampFromDate(b.getInvoiceDate());
		buff[count++] = b.getInvoiceAmount();
		buff[count++] = b.getTaxRate();
		buff[count++] = b.getOperator();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getRemark();
		buff[count++] = b.getOtherRemark();
		buff[count++] = b.getSalesCode();
		buff[count++] = b.getTaxAmount();
		buff[count++] = b.getSalesName();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getHaveCheck();
	}

	@Override
	public void setDataFromBase(BaseInputTaxInvoice b){
		if(b.getInputTaxInvoiceId() != null) setInputTaxInvoiceIdClear(b.getInputTaxInvoiceId());
		if(b.getInvoiceType() != null) setInvoiceType(b.getInvoiceType());
		if(b.getInvoiceCode() != null) setInvoiceCode(b.getInvoiceCode());
		if(b.getInvoiceNumber() != null) setInvoiceNumber(b.getInvoiceNumber());
		if(b.getInvoiceDate() != null) setInvoiceDate(b.getInvoiceDate());
		if(b.getInvoiceAmount() != null) setInvoiceAmount(b.getInvoiceAmount());
		if(b.getTaxRate() != null) setTaxRate(b.getTaxRate());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getOtherRemark() != null) setOtherRemark(b.getOtherRemark());
		if(b.getSalesCode() != null) setSalesCode(b.getSalesCode());
		if(b.getTaxAmount() != null) setTaxAmount(b.getTaxAmount());
		if(b.getSalesName() != null) setSalesName(b.getSalesName());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getHaveCheck() != null) setHaveCheck(b.getHaveCheck());
	}

	@Override
	public BaseInputTaxInvoice generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseInputTaxInvoice b = new BaseInputTaxInvoice();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseInputTaxInvoice __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInputTaxInvoiceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceNumber(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaxRate(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOtherRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalesCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaxAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalesName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHaveCheck(GenericBase.__getBoolean(val));
	}

	public void setInputTaxInvoiceId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getInputTaxInvoiceId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setInputTaxInvoiceIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setInvoiceType(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getInvoiceType() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setInvoiceCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getInvoiceCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setInvoiceNumber(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getInvoiceNumber() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setInvoiceDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getInvoiceDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setInvoiceAmount(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getInvoiceAmount() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setTaxRate(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getTaxRate() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setOtherRemark(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getOtherRemark() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setSalesCode(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getSalesCode() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setTaxAmount(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getTaxAmount() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setSalesName(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getSalesName() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setHaveCheck(java.lang.Boolean val) {
		setCurrentData(16, val);
	}

	public java.lang.Boolean getHaveCheck() {
		return GenericBase.__getBoolean(__current_data[16]);
	}

	public void setConditionInputTaxInvoiceId(String op, java.lang.Integer val) {
		setConditionInputTaxInvoiceId(op, val, CONDITION_AND);
	}

	public void setConditionInputTaxInvoiceId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectInputTaxInvoiceId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionInvoiceType(String op, java.lang.Integer val) {
		setConditionInvoiceType(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceType(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectInvoiceType(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionInvoiceCode(String op, java.lang.String val) {
		setConditionInvoiceCode(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectInvoiceCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionInvoiceNumber(String op, java.lang.String val) {
		setConditionInvoiceNumber(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceNumber(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectInvoiceNumber(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionInvoiceDate(String op, java.util.Date val) {
		setConditionInvoiceDate(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectInvoiceDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionInvoiceAmount(String op, java.math.BigDecimal val) {
		setConditionInvoiceAmount(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectInvoiceAmount(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionTaxRate(String op, java.math.BigDecimal val) {
		setConditionTaxRate(op, val, CONDITION_AND);
	}

	public void setConditionTaxRate(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectTaxRate(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionOtherRemark(String op, java.lang.String val) {
		setConditionOtherRemark(op, val, CONDITION_AND);
	}

	public void setConditionOtherRemark(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectOtherRemark(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionSalesCode(String op, java.lang.String val) {
		setConditionSalesCode(op, val, CONDITION_AND);
	}

	public void setConditionSalesCode(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectSalesCode(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionTaxAmount(String op, java.math.BigDecimal val) {
		setConditionTaxAmount(op, val, CONDITION_AND);
	}

	public void setConditionTaxAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectTaxAmount(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionSalesName(String op, java.lang.String val) {
		setConditionSalesName(op, val, CONDITION_AND);
	}

	public void setConditionSalesName(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectSalesName(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionHaveCheck(String op, java.lang.Boolean val) {
		setConditionHaveCheck(op, val, CONDITION_AND);
	}

	public void setConditionHaveCheck(String op, java.lang.Boolean val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectHaveCheck(boolean val) {
		__select_flags[16] = val;
	}


}

