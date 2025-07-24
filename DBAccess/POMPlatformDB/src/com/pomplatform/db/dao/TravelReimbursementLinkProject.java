package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseTravelReimbursementLinkProject;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class TravelReimbursementLinkProject extends AbstractTable<BaseTravelReimbursementLinkProject>
{

	public TravelReimbursementLinkProject() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 12;

		initTables();

		__tableName            = "travel_reimbursement_link_projects";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseTravelReimbursementLinkProject.CS_TRAVEL_REIMBURSEMENT_LINK_PROJECT_ID;
		__column_names[1] = BaseTravelReimbursementLinkProject.CS_TRAVEL_REIMBURSEMENT_ID;
		__column_names[2] = BaseTravelReimbursementLinkProject.CS_PROJECT_ID;
		__column_names[3] = BaseTravelReimbursementLinkProject.CS_CONTRACT_CODE;
		__column_names[4] = BaseTravelReimbursementLinkProject.CS_PLATE_ID;
		__column_names[5] = BaseTravelReimbursementLinkProject.CS_AMOUNT;
		__column_names[6] = BaseTravelReimbursementLinkProject.CS_INPUT_TAX;
		__column_names[7] = BaseTravelReimbursementLinkProject.CS_FINAL_AMOUNT;
		__column_names[8] = BaseTravelReimbursementLinkProject.CS_IS_PERSONAL_FEE;
		__column_names[9] = BaseTravelReimbursementLinkProject.CS_INPUT_TAX_REBATE;
		__column_names[10] = BaseTravelReimbursementLinkProject.CS_HAVE_ELECTRONIC_INVOICE;
		__column_names[11] = BaseTravelReimbursementLinkProject.CS_INVOICE_LINK_KEY;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseTravelReimbursementLinkProject b) {
		clear();
		setTravelReimbursementLinkProjectIdClear(b.getTravelReimbursementLinkProjectId());
	}

	public boolean isPrimaryKeyNull() {
		return getTravelReimbursementLinkProjectId() == null;
	}

	@Override
	public BaseTravelReimbursementLinkProject generateBase(){
		BaseTravelReimbursementLinkProject b = new BaseTravelReimbursementLinkProject();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseTravelReimbursementLinkProject b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setTravelReimbursementLinkProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTravelReimbursementId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setInputTax(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setFinalAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setIsPersonalFee(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setInputTaxRebate(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setHaveElectronicInvoice(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInvoiceLinkKey(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseTravelReimbursementLinkProject b, Object[] buff){
		int count = 0;
		buff[count++] = b.getTravelReimbursementLinkProjectId();
		buff[count++] = b.getTravelReimbursementId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getContractCode();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getAmount();
		buff[count++] = b.getInputTax();
		buff[count++] = b.getFinalAmount();
		buff[count++] = b.getIsPersonalFee();
		buff[count++] = b.getInputTaxRebate();
		buff[count++] = b.getHaveElectronicInvoice();
		buff[count++] = b.getInvoiceLinkKey();
	}

	@Override
	public void setDataFromBase(BaseTravelReimbursementLinkProject b){
		if(b.getTravelReimbursementLinkProjectId() != null) setTravelReimbursementLinkProjectIdClear(b.getTravelReimbursementLinkProjectId());
		if(b.getTravelReimbursementId() != null) setTravelReimbursementId(b.getTravelReimbursementId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getContractCode() != null) setContractCode(b.getContractCode());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getAmount() != null) setAmount(b.getAmount());
		if(b.getInputTax() != null) setInputTax(b.getInputTax());
		if(b.getFinalAmount() != null) setFinalAmount(b.getFinalAmount());
		if(b.getIsPersonalFee() != null) setIsPersonalFee(b.getIsPersonalFee());
		if(b.getInputTaxRebate() != null) setInputTaxRebate(b.getInputTaxRebate());
		if(b.getHaveElectronicInvoice() != null) setHaveElectronicInvoice(b.getHaveElectronicInvoice());
		if(b.getInvoiceLinkKey() != null) setInvoiceLinkKey(b.getInvoiceLinkKey());
	}

	@Override
	public BaseTravelReimbursementLinkProject generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseTravelReimbursementLinkProject b = new BaseTravelReimbursementLinkProject();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseTravelReimbursementLinkProject __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTravelReimbursementLinkProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTravelReimbursementId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInputTax(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinalAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsPersonalFee(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInputTaxRebate(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHaveElectronicInvoice(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceLinkKey(GenericBase.__getInt(val));
	}

	public void setTravelReimbursementLinkProjectId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getTravelReimbursementLinkProjectId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setTravelReimbursementLinkProjectIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setTravelReimbursementId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getTravelReimbursementId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setContractCode(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getContractCode() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setAmount(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getAmount() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setInputTax(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getInputTax() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setFinalAmount(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getFinalAmount() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setIsPersonalFee(java.lang.Boolean val) {
		setCurrentData(8, val);
	}

	public java.lang.Boolean getIsPersonalFee() {
		return GenericBase.__getBoolean(__current_data[8]);
	}

	public void setInputTaxRebate(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getInputTaxRebate() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setHaveElectronicInvoice(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getHaveElectronicInvoice() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setInvoiceLinkKey(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getInvoiceLinkKey() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setConditionTravelReimbursementLinkProjectId(String op, java.lang.Integer val) {
		setConditionTravelReimbursementLinkProjectId(op, val, CONDITION_AND);
	}

	public void setConditionTravelReimbursementLinkProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectTravelReimbursementLinkProjectId(boolean val) {
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

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionContractCode(String op, java.lang.String val) {
		setConditionContractCode(op, val, CONDITION_AND);
	}

	public void setConditionContractCode(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectContractCode(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionAmount(String op, java.math.BigDecimal val) {
		setConditionAmount(op, val, CONDITION_AND);
	}

	public void setConditionAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectAmount(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionInputTax(String op, java.math.BigDecimal val) {
		setConditionInputTax(op, val, CONDITION_AND);
	}

	public void setConditionInputTax(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectInputTax(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionFinalAmount(String op, java.math.BigDecimal val) {
		setConditionFinalAmount(op, val, CONDITION_AND);
	}

	public void setConditionFinalAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectFinalAmount(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionIsPersonalFee(String op, java.lang.Boolean val) {
		setConditionIsPersonalFee(op, val, CONDITION_AND);
	}

	public void setConditionIsPersonalFee(String op, java.lang.Boolean val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectIsPersonalFee(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionInputTaxRebate(String op, java.math.BigDecimal val) {
		setConditionInputTaxRebate(op, val, CONDITION_AND);
	}

	public void setConditionInputTaxRebate(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectInputTaxRebate(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionHaveElectronicInvoice(String op, java.lang.Integer val) {
		setConditionHaveElectronicInvoice(op, val, CONDITION_AND);
	}

	public void setConditionHaveElectronicInvoice(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectHaveElectronicInvoice(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionInvoiceLinkKey(String op, java.lang.Integer val) {
		setConditionInvoiceLinkKey(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceLinkKey(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectInvoiceLinkKey(boolean val) {
		__select_flags[11] = val;
	}


}

