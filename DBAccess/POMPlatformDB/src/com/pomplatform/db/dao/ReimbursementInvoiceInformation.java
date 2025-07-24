package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseReimbursementInvoiceInformation;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ReimbursementInvoiceInformation extends AbstractTable<BaseReimbursementInvoiceInformation>
{

	public ReimbursementInvoiceInformation() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 15;

		initTables();

		__tableName            = "reimbursement_invoice_informations";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseReimbursementInvoiceInformation.CS_REIMBURSEMENT_INVOICE_INFORMATION_ID;
		__column_names[1] = BaseReimbursementInvoiceInformation.CS_PROCESS_TYPE;
		__column_names[2] = BaseReimbursementInvoiceInformation.CS_BUSINESS_ID;
		__column_names[3] = BaseReimbursementInvoiceInformation.CS_DETAIL_ID;
		__column_names[4] = BaseReimbursementInvoiceInformation.CS_INVOICE_TYPE;
		__column_names[5] = BaseReimbursementInvoiceInformation.CS_INVOICE_CODE;
		__column_names[6] = BaseReimbursementInvoiceInformation.CS_INVOICE_NUMBER;
		__column_names[7] = BaseReimbursementInvoiceInformation.CS_TOTAL_AMOUNT;
		__column_names[8] = BaseReimbursementInvoiceInformation.CS_TAX_RATE;
		__column_names[9] = BaseReimbursementInvoiceInformation.CS_TAX_AMOUNT;
		__column_names[10] = BaseReimbursementInvoiceInformation.CS_SUBTRACT_AMOUNT;
		__column_names[11] = BaseReimbursementInvoiceInformation.CS_SUBTRACT_REMARK;
		__column_names[12] = BaseReimbursementInvoiceInformation.CS_CREATOR;
		__column_names[13] = BaseReimbursementInvoiceInformation.CS_CREATE_TIME;
		__column_names[14] = BaseReimbursementInvoiceInformation.CS_INVOICE_QUANTITY;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseReimbursementInvoiceInformation b) {
		clear();
		setReimbursementInvoiceInformationIdClear(b.getReimbursementInvoiceInformationId());
	}

	public boolean isPrimaryKeyNull() {
		return getReimbursementInvoiceInformationId() == null;
	}

	@Override
	public BaseReimbursementInvoiceInformation generateBase(){
		BaseReimbursementInvoiceInformation b = new BaseReimbursementInvoiceInformation();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseReimbursementInvoiceInformation b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setReimbursementInvoiceInformationId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInvoiceType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInvoiceCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setInvoiceNumber(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTaxRate(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTaxAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSubtractAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSubtractRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setInvoiceQuantity(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseReimbursementInvoiceInformation b, Object[] buff){
		int count = 0;
		buff[count++] = b.getReimbursementInvoiceInformationId();
		buff[count++] = b.getProcessType();
		buff[count++] = b.getBusinessId();
		buff[count++] = b.getDetailId();
		buff[count++] = b.getInvoiceType();
		buff[count++] = b.getInvoiceCode();
		buff[count++] = b.getInvoiceNumber();
		buff[count++] = b.getTotalAmount();
		buff[count++] = b.getTaxRate();
		buff[count++] = b.getTaxAmount();
		buff[count++] = b.getSubtractAmount();
		buff[count++] = b.getSubtractRemark();
		buff[count++] = b.getCreator();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getInvoiceQuantity();
	}

	@Override
	public void setDataFromBase(BaseReimbursementInvoiceInformation b){
		if(b.getReimbursementInvoiceInformationId() != null) setReimbursementInvoiceInformationIdClear(b.getReimbursementInvoiceInformationId());
		if(b.getProcessType() != null) setProcessType(b.getProcessType());
		if(b.getBusinessId() != null) setBusinessId(b.getBusinessId());
		if(b.getDetailId() != null) setDetailId(b.getDetailId());
		if(b.getInvoiceType() != null) setInvoiceType(b.getInvoiceType());
		if(b.getInvoiceCode() != null) setInvoiceCode(b.getInvoiceCode());
		if(b.getInvoiceNumber() != null) setInvoiceNumber(b.getInvoiceNumber());
		if(b.getTotalAmount() != null) setTotalAmount(b.getTotalAmount());
		if(b.getTaxRate() != null) setTaxRate(b.getTaxRate());
		if(b.getTaxAmount() != null) setTaxAmount(b.getTaxAmount());
		if(b.getSubtractAmount() != null) setSubtractAmount(b.getSubtractAmount());
		if(b.getSubtractRemark() != null) setSubtractRemark(b.getSubtractRemark());
		if(b.getCreator() != null) setCreator(b.getCreator());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getInvoiceQuantity() != null) setInvoiceQuantity(b.getInvoiceQuantity());
	}

	@Override
	public BaseReimbursementInvoiceInformation generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseReimbursementInvoiceInformation b = new BaseReimbursementInvoiceInformation();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseReimbursementInvoiceInformation __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReimbursementInvoiceInformationId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceNumber(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaxRate(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaxAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubtractAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubtractRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceQuantity(GenericBase.__getInt(val));
	}

	public void setReimbursementInvoiceInformationId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getReimbursementInvoiceInformationId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setReimbursementInvoiceInformationIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProcessType(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProcessType() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setBusinessId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getBusinessId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setDetailId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getDetailId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setInvoiceType(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getInvoiceType() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setInvoiceCode(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getInvoiceCode() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setInvoiceNumber(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getInvoiceNumber() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setTotalAmount(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getTotalAmount() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setTaxRate(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getTaxRate() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setTaxAmount(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getTaxAmount() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setSubtractAmount(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getSubtractAmount() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setSubtractRemark(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getSubtractRemark() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setCreator(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getCreator() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(13, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[13]);
	}

	public void setInvoiceQuantity(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getInvoiceQuantity() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setConditionReimbursementInvoiceInformationId(String op, java.lang.Integer val) {
		setConditionReimbursementInvoiceInformationId(op, val, CONDITION_AND);
	}

	public void setConditionReimbursementInvoiceInformationId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectReimbursementInvoiceInformationId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionProcessType(String op, java.lang.Integer val) {
		setConditionProcessType(op, val, CONDITION_AND);
	}

	public void setConditionProcessType(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProcessType(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionBusinessId(String op, java.lang.Integer val) {
		setConditionBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectBusinessId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionDetailId(String op, java.lang.Integer val) {
		setConditionDetailId(op, val, CONDITION_AND);
	}

	public void setConditionDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectDetailId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionInvoiceType(String op, java.lang.Integer val) {
		setConditionInvoiceType(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceType(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectInvoiceType(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionInvoiceCode(String op, java.lang.String val) {
		setConditionInvoiceCode(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceCode(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectInvoiceCode(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionInvoiceNumber(String op, java.lang.String val) {
		setConditionInvoiceNumber(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceNumber(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectInvoiceNumber(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionTotalAmount(String op, java.math.BigDecimal val) {
		setConditionTotalAmount(op, val, CONDITION_AND);
	}

	public void setConditionTotalAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectTotalAmount(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionTaxRate(String op, java.lang.Integer val) {
		setConditionTaxRate(op, val, CONDITION_AND);
	}

	public void setConditionTaxRate(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectTaxRate(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionTaxAmount(String op, java.math.BigDecimal val) {
		setConditionTaxAmount(op, val, CONDITION_AND);
	}

	public void setConditionTaxAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectTaxAmount(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionSubtractAmount(String op, java.math.BigDecimal val) {
		setConditionSubtractAmount(op, val, CONDITION_AND);
	}

	public void setConditionSubtractAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectSubtractAmount(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionSubtractRemark(String op, java.lang.String val) {
		setConditionSubtractRemark(op, val, CONDITION_AND);
	}

	public void setConditionSubtractRemark(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectSubtractRemark(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionCreator(String op, java.lang.Integer val) {
		setConditionCreator(op, val, CONDITION_AND);
	}

	public void setConditionCreator(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectCreator(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(13, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionInvoiceQuantity(String op, java.lang.Integer val) {
		setConditionInvoiceQuantity(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceQuantity(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectInvoiceQuantity(boolean val) {
		__select_flags[14] = val;
	}


}

