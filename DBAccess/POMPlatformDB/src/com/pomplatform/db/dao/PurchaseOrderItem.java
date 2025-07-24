package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePurchaseOrderItem;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PurchaseOrderItem extends AbstractTable<BasePurchaseOrderItem>
{

	public PurchaseOrderItem() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 14;

		initTables();

		__tableName            = "purchase_order_items";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePurchaseOrderItem.CS_PURCHASE_ORDER_ITEM_ID;
		__column_names[1] = BasePurchaseOrderItem.CS_PERSONNEL_BUSINESS_ID;
		__column_names[2] = BasePurchaseOrderItem.CS_MAIN_PROJECT_ID;
		__column_names[3] = BasePurchaseOrderItem.CS_SUPPLIER_ID;
		__column_names[4] = BasePurchaseOrderItem.CS_PRODUCT_ID;
		__column_names[5] = BasePurchaseOrderItem.CS_PRODUCT_NUMBER;
		__column_names[6] = BasePurchaseOrderItem.CS_PRODUCT_UNIT;
		__column_names[7] = BasePurchaseOrderItem.CS_PRODUCT_PRICE;
		__column_names[8] = BasePurchaseOrderItem.CS_TOTAL_PRICE;
		__column_names[9] = BasePurchaseOrderItem.CS_TAX_POINTS;
		__column_names[10] = BasePurchaseOrderItem.CS_TAX_PRICE;
		__column_names[11] = BasePurchaseOrderItem.CS_FINAL_PRICE;
		__column_names[12] = BasePurchaseOrderItem.CS_PLAN_ARRIVAL_DATE;
		__column_names[13] = BasePurchaseOrderItem.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePurchaseOrderItem b) {
		clear();
		setPurchaseOrderItemIdClear(b.getPurchaseOrderItemId());
	}

	public boolean isPrimaryKeyNull() {
		return getPurchaseOrderItemId() == null;
	}

	@Override
	public BasePurchaseOrderItem generateBase(){
		BasePurchaseOrderItem b = new BasePurchaseOrderItem();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePurchaseOrderItem b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPurchaseOrderItemId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSupplierId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProductId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProductNumber(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProductUnit(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProductPrice(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalPrice(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTaxPoints(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTaxPrice(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setFinalPrice(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPlanArrivalDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BasePurchaseOrderItem b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPurchaseOrderItemId();
		buff[count++] = b.getPersonnelBusinessId();
		buff[count++] = b.getMainProjectId();
		buff[count++] = b.getSupplierId();
		buff[count++] = b.getProductId();
		buff[count++] = b.getProductNumber();
		buff[count++] = b.getProductUnit();
		buff[count++] = b.getProductPrice();
		buff[count++] = b.getTotalPrice();
		buff[count++] = b.getTaxPoints();
		buff[count++] = b.getTaxPrice();
		buff[count++] = b.getFinalPrice();
		buff[count++] = generateTimestampFromDate(b.getPlanArrivalDate());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BasePurchaseOrderItem b){
		if(b.getPurchaseOrderItemId() != null) setPurchaseOrderItemIdClear(b.getPurchaseOrderItemId());
		if(b.getPersonnelBusinessId() != null) setPersonnelBusinessId(b.getPersonnelBusinessId());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
		if(b.getSupplierId() != null) setSupplierId(b.getSupplierId());
		if(b.getProductId() != null) setProductId(b.getProductId());
		if(b.getProductNumber() != null) setProductNumber(b.getProductNumber());
		if(b.getProductUnit() != null) setProductUnit(b.getProductUnit());
		if(b.getProductPrice() != null) setProductPrice(b.getProductPrice());
		if(b.getTotalPrice() != null) setTotalPrice(b.getTotalPrice());
		if(b.getTaxPoints() != null) setTaxPoints(b.getTaxPoints());
		if(b.getTaxPrice() != null) setTaxPrice(b.getTaxPrice());
		if(b.getFinalPrice() != null) setFinalPrice(b.getFinalPrice());
		if(b.getPlanArrivalDate() != null) setPlanArrivalDate(b.getPlanArrivalDate());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BasePurchaseOrderItem generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePurchaseOrderItem b = new BasePurchaseOrderItem();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePurchaseOrderItem __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPurchaseOrderItemId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductNumber(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductUnit(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductPrice(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalPrice(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaxPoints(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaxPrice(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinalPrice(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlanArrivalDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setPurchaseOrderItemId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPurchaseOrderItemId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPurchaseOrderItemIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPersonnelBusinessId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setSupplierId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getSupplierId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setProductId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getProductId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setProductNumber(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getProductNumber() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setProductUnit(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getProductUnit() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setProductPrice(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getProductPrice() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setTotalPrice(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getTotalPrice() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setTaxPoints(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getTaxPoints() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setTaxPrice(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getTaxPrice() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setFinalPrice(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getFinalPrice() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setPlanArrivalDate(java.util.Date val) {
		setCurrentData(12, generateTimestampFromDate(val));
	}

	public java.util.Date getPlanArrivalDate() {
		return GenericBase.__getDateFromSQL(__current_data[12]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setConditionPurchaseOrderItemId(String op, java.lang.Integer val) {
		setConditionPurchaseOrderItemId(op, val, CONDITION_AND);
	}

	public void setConditionPurchaseOrderItemId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPurchaseOrderItemId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val) {
		setConditionPersonnelBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectPersonnelBusinessId(boolean val) {
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

	public void setConditionSupplierId(String op, java.lang.Integer val) {
		setConditionSupplierId(op, val, CONDITION_AND);
	}

	public void setConditionSupplierId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectSupplierId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionProductId(String op, java.lang.Integer val) {
		setConditionProductId(op, val, CONDITION_AND);
	}

	public void setConditionProductId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectProductId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionProductNumber(String op, java.lang.Integer val) {
		setConditionProductNumber(op, val, CONDITION_AND);
	}

	public void setConditionProductNumber(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectProductNumber(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionProductUnit(String op, java.lang.String val) {
		setConditionProductUnit(op, val, CONDITION_AND);
	}

	public void setConditionProductUnit(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectProductUnit(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionProductPrice(String op, java.math.BigDecimal val) {
		setConditionProductPrice(op, val, CONDITION_AND);
	}

	public void setConditionProductPrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectProductPrice(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionTotalPrice(String op, java.math.BigDecimal val) {
		setConditionTotalPrice(op, val, CONDITION_AND);
	}

	public void setConditionTotalPrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectTotalPrice(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionTaxPoints(String op, java.math.BigDecimal val) {
		setConditionTaxPoints(op, val, CONDITION_AND);
	}

	public void setConditionTaxPoints(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectTaxPoints(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionTaxPrice(String op, java.math.BigDecimal val) {
		setConditionTaxPrice(op, val, CONDITION_AND);
	}

	public void setConditionTaxPrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectTaxPrice(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionFinalPrice(String op, java.math.BigDecimal val) {
		setConditionFinalPrice(op, val, CONDITION_AND);
	}

	public void setConditionFinalPrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectFinalPrice(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionPlanArrivalDate(String op, java.util.Date val) {
		setConditionPlanArrivalDate(op, val, CONDITION_AND);
	}

	public void setConditionPlanArrivalDate(String op, java.util.Date val, String relation) {
		addCondition(12, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectPlanArrivalDate(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[13] = val;
	}


}

