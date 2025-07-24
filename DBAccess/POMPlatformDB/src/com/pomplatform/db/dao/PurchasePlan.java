package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePurchasePlan;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PurchasePlan extends AbstractTable<BasePurchasePlan>
{

	public PurchasePlan() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 15;

		initTables();

		__tableName            = "purchase_plans";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePurchasePlan.CS_PURCHASE_PLAN_ID;
		__column_names[1] = BasePurchasePlan.CS_PERSON_IN_CHARGE;
		__column_names[2] = BasePurchasePlan.CS_MAIN_PROJECT_ID;
		__column_names[3] = BasePurchasePlan.CS_ORI_PERSONNEL_BUSINESS_ID;
		__column_names[4] = BasePurchasePlan.CS_PURCHASE_DATE;
		__column_names[5] = BasePurchasePlan.CS_PURCHASE_AMOUNT;
		__column_names[6] = BasePurchasePlan.CS_SUPPLIER_ID;
		__column_names[7] = BasePurchasePlan.CS_TAX_AMOUNT;
		__column_names[8] = BasePurchasePlan.CS_REMARK;
		__column_names[9] = BasePurchasePlan.CS_CREATE_TIME;
		__column_names[10] = BasePurchasePlan.CS_IS_COMPLETE;
		__column_names[11] = BasePurchasePlan.CS_OPERATOR_ID;
		__column_names[12] = BasePurchasePlan.CS_DEAL_STATUS;
		__column_names[13] = BasePurchasePlan.CS_PURCHASE_CONTRACT_ID;
		__column_names[14] = BasePurchasePlan.CS_TO_PERSONNEL_BUSINESS_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePurchasePlan b) {
		clear();
		setPurchasePlanIdClear(b.getPurchasePlanId());
	}

	public boolean isPrimaryKeyNull() {
		return getPurchasePlanId() == null;
	}

	@Override
	public BasePurchasePlan generateBase(){
		BasePurchasePlan b = new BasePurchasePlan();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePurchasePlan b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPurchasePlanId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPersonInCharge(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOriPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPurchaseDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setPurchaseAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSupplierId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTaxAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setIsComplete(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setOperatorId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDealStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPurchaseContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setToPersonnelBusinessId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BasePurchasePlan b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPurchasePlanId();
		buff[count++] = b.getPersonInCharge();
		buff[count++] = b.getMainProjectId();
		buff[count++] = b.getOriPersonnelBusinessId();
		buff[count++] = generateTimestampFromDate(b.getPurchaseDate());
		buff[count++] = b.getPurchaseAmount();
		buff[count++] = b.getSupplierId();
		buff[count++] = b.getTaxAmount();
		buff[count++] = b.getRemark();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getIsComplete();
		buff[count++] = b.getOperatorId();
		buff[count++] = b.getDealStatus();
		buff[count++] = b.getPurchaseContractId();
		buff[count++] = b.getToPersonnelBusinessId();
	}

	@Override
	public void setDataFromBase(BasePurchasePlan b){
		if(b.getPurchasePlanId() != null) setPurchasePlanIdClear(b.getPurchasePlanId());
		if(b.getPersonInCharge() != null) setPersonInCharge(b.getPersonInCharge());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
		if(b.getOriPersonnelBusinessId() != null) setOriPersonnelBusinessId(b.getOriPersonnelBusinessId());
		if(b.getPurchaseDate() != null) setPurchaseDate(b.getPurchaseDate());
		if(b.getPurchaseAmount() != null) setPurchaseAmount(b.getPurchaseAmount());
		if(b.getSupplierId() != null) setSupplierId(b.getSupplierId());
		if(b.getTaxAmount() != null) setTaxAmount(b.getTaxAmount());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getIsComplete() != null) setIsComplete(b.getIsComplete());
		if(b.getOperatorId() != null) setOperatorId(b.getOperatorId());
		if(b.getDealStatus() != null) setDealStatus(b.getDealStatus());
		if(b.getPurchaseContractId() != null) setPurchaseContractId(b.getPurchaseContractId());
		if(b.getToPersonnelBusinessId() != null) setToPersonnelBusinessId(b.getToPersonnelBusinessId());
	}

	@Override
	public BasePurchasePlan generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePurchasePlan b = new BasePurchasePlan();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePurchasePlan __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPurchasePlanId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonInCharge(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOriPersonnelBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPurchaseDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPurchaseAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaxAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsComplete(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDealStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPurchaseContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setToPersonnelBusinessId(GenericBase.__getInt(val));
	}

	public void setPurchasePlanId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPurchasePlanId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPurchasePlanIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPersonInCharge(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPersonInCharge() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setOriPersonnelBusinessId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getOriPersonnelBusinessId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setPurchaseDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getPurchaseDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setPurchaseAmount(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getPurchaseAmount() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setSupplierId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getSupplierId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setTaxAmount(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getTaxAmount() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setIsComplete(java.lang.Boolean val) {
		setCurrentData(10, val);
	}

	public java.lang.Boolean getIsComplete() {
		return GenericBase.__getBoolean(__current_data[10]);
	}

	public void setOperatorId(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getOperatorId() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setDealStatus(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getDealStatus() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setPurchaseContractId(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getPurchaseContractId() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setToPersonnelBusinessId(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getToPersonnelBusinessId() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setConditionPurchasePlanId(String op, java.lang.Integer val) {
		setConditionPurchasePlanId(op, val, CONDITION_AND);
	}

	public void setConditionPurchasePlanId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPurchasePlanId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionPersonInCharge(String op, java.lang.Integer val) {
		setConditionPersonInCharge(op, val, CONDITION_AND);
	}

	public void setConditionPersonInCharge(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectPersonInCharge(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val) {
		setConditionMainProjectId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectMainProjectId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionOriPersonnelBusinessId(String op, java.lang.Integer val) {
		setConditionOriPersonnelBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionOriPersonnelBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectOriPersonnelBusinessId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionPurchaseDate(String op, java.util.Date val) {
		setConditionPurchaseDate(op, val, CONDITION_AND);
	}

	public void setConditionPurchaseDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectPurchaseDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionPurchaseAmount(String op, java.math.BigDecimal val) {
		setConditionPurchaseAmount(op, val, CONDITION_AND);
	}

	public void setConditionPurchaseAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectPurchaseAmount(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionSupplierId(String op, java.lang.Integer val) {
		setConditionSupplierId(op, val, CONDITION_AND);
	}

	public void setConditionSupplierId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectSupplierId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionTaxAmount(String op, java.math.BigDecimal val) {
		setConditionTaxAmount(op, val, CONDITION_AND);
	}

	public void setConditionTaxAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectTaxAmount(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(9, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionIsComplete(String op, java.lang.Boolean val) {
		setConditionIsComplete(op, val, CONDITION_AND);
	}

	public void setConditionIsComplete(String op, java.lang.Boolean val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectIsComplete(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionOperatorId(String op, java.lang.Integer val) {
		setConditionOperatorId(op, val, CONDITION_AND);
	}

	public void setConditionOperatorId(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectOperatorId(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionDealStatus(String op, java.lang.Integer val) {
		setConditionDealStatus(op, val, CONDITION_AND);
	}

	public void setConditionDealStatus(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectDealStatus(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionPurchaseContractId(String op, java.lang.Integer val) {
		setConditionPurchaseContractId(op, val, CONDITION_AND);
	}

	public void setConditionPurchaseContractId(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectPurchaseContractId(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionToPersonnelBusinessId(String op, java.lang.Integer val) {
		setConditionToPersonnelBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionToPersonnelBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectToPersonnelBusinessId(boolean val) {
		__select_flags[14] = val;
	}


}

