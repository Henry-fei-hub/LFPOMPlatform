package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseTravelReimbursementLinkDepartment;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class TravelReimbursementLinkDepartment extends AbstractTable<BaseTravelReimbursementLinkDepartment>
{

	public TravelReimbursementLinkDepartment() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 9;

		initTables();

		__tableName            = "travel_reimbursement_link_departments";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseTravelReimbursementLinkDepartment.CS_TRAVEL_REIMBURSEMENT_LINK_DEPARTMENT_ID;
		__column_names[1] = BaseTravelReimbursementLinkDepartment.CS_TRAVEL_REIMBURSEMENT_ID;
		__column_names[2] = BaseTravelReimbursementLinkDepartment.CS_DEPARTMENT_ID;
		__column_names[3] = BaseTravelReimbursementLinkDepartment.CS_AMOUNT;
		__column_names[4] = BaseTravelReimbursementLinkDepartment.CS_INPUT_TAX;
		__column_names[5] = BaseTravelReimbursementLinkDepartment.CS_FINAL_AMOUNT;
		__column_names[6] = BaseTravelReimbursementLinkDepartment.CS_INPUT_TAX_REBATE;
		__column_names[7] = BaseTravelReimbursementLinkDepartment.CS_HAVE_ELECTRONIC_INVOICE;
		__column_names[8] = BaseTravelReimbursementLinkDepartment.CS_INVOICE_LINK_KEY;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseTravelReimbursementLinkDepartment b) {
		clear();
		setTravelReimbursementLinkDepartmentIdClear(b.getTravelReimbursementLinkDepartmentId());
	}

	public boolean isPrimaryKeyNull() {
		return getTravelReimbursementLinkDepartmentId() == null;
	}

	@Override
	public BaseTravelReimbursementLinkDepartment generateBase(){
		BaseTravelReimbursementLinkDepartment b = new BaseTravelReimbursementLinkDepartment();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseTravelReimbursementLinkDepartment b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setTravelReimbursementLinkDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTravelReimbursementId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setInputTax(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setFinalAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setInputTaxRebate(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setHaveElectronicInvoice(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInvoiceLinkKey(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseTravelReimbursementLinkDepartment b, Object[] buff){
		int count = 0;
		buff[count++] = b.getTravelReimbursementLinkDepartmentId();
		buff[count++] = b.getTravelReimbursementId();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getAmount();
		buff[count++] = b.getInputTax();
		buff[count++] = b.getFinalAmount();
		buff[count++] = b.getInputTaxRebate();
		buff[count++] = b.getHaveElectronicInvoice();
		buff[count++] = b.getInvoiceLinkKey();
	}

	@Override
	public void setDataFromBase(BaseTravelReimbursementLinkDepartment b){
		if(b.getTravelReimbursementLinkDepartmentId() != null) setTravelReimbursementLinkDepartmentIdClear(b.getTravelReimbursementLinkDepartmentId());
		if(b.getTravelReimbursementId() != null) setTravelReimbursementId(b.getTravelReimbursementId());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getAmount() != null) setAmount(b.getAmount());
		if(b.getInputTax() != null) setInputTax(b.getInputTax());
		if(b.getFinalAmount() != null) setFinalAmount(b.getFinalAmount());
		if(b.getInputTaxRebate() != null) setInputTaxRebate(b.getInputTaxRebate());
		if(b.getHaveElectronicInvoice() != null) setHaveElectronicInvoice(b.getHaveElectronicInvoice());
		if(b.getInvoiceLinkKey() != null) setInvoiceLinkKey(b.getInvoiceLinkKey());
	}

	@Override
	public BaseTravelReimbursementLinkDepartment generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseTravelReimbursementLinkDepartment b = new BaseTravelReimbursementLinkDepartment();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseTravelReimbursementLinkDepartment __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTravelReimbursementLinkDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTravelReimbursementId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInputTax(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinalAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInputTaxRebate(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHaveElectronicInvoice(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceLinkKey(GenericBase.__getInt(val));
	}

	public void setTravelReimbursementLinkDepartmentId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getTravelReimbursementLinkDepartmentId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setTravelReimbursementLinkDepartmentIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setTravelReimbursementId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getTravelReimbursementId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setAmount(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getAmount() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setInputTax(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getInputTax() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setFinalAmount(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getFinalAmount() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setInputTaxRebate(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getInputTaxRebate() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setHaveElectronicInvoice(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getHaveElectronicInvoice() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setInvoiceLinkKey(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getInvoiceLinkKey() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setConditionTravelReimbursementLinkDepartmentId(String op, java.lang.Integer val) {
		setConditionTravelReimbursementLinkDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionTravelReimbursementLinkDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectTravelReimbursementLinkDepartmentId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionTravelReimbursementId(String op, java.lang.Integer val) {
		setConditionTravelReimbursementId(op, val, CONDITION_AND);
	}

	public void setConditionTravelReimbursementId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectTravelReimbursementId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionAmount(String op, java.math.BigDecimal val) {
		setConditionAmount(op, val, CONDITION_AND);
	}

	public void setConditionAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectAmount(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionInputTax(String op, java.math.BigDecimal val) {
		setConditionInputTax(op, val, CONDITION_AND);
	}

	public void setConditionInputTax(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectInputTax(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionFinalAmount(String op, java.math.BigDecimal val) {
		setConditionFinalAmount(op, val, CONDITION_AND);
	}

	public void setConditionFinalAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectFinalAmount(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionInputTaxRebate(String op, java.math.BigDecimal val) {
		setConditionInputTaxRebate(op, val, CONDITION_AND);
	}

	public void setConditionInputTaxRebate(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectInputTaxRebate(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionHaveElectronicInvoice(String op, java.lang.Integer val) {
		setConditionHaveElectronicInvoice(op, val, CONDITION_AND);
	}

	public void setConditionHaveElectronicInvoice(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectHaveElectronicInvoice(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionInvoiceLinkKey(String op, java.lang.Integer val) {
		setConditionInvoiceLinkKey(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceLinkKey(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectInvoiceLinkKey(boolean val) {
		__select_flags[8] = val;
	}


}

