package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePurchaseOrder;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PurchaseOrder extends AbstractTable<BasePurchaseOrder>
{

	public PurchaseOrder() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 12;

		initTables();

		__tableName            = "purchase_orders";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePurchaseOrder.CS_PURCHASE_ORDER_ID;
		__column_names[1] = BasePurchaseOrder.CS_ORDER_CODE;
		__column_names[2] = BasePurchaseOrder.CS_ORDER_NAME;
		__column_names[3] = BasePurchaseOrder.CS_SUPPLIER_ID;
		__column_names[4] = BasePurchaseOrder.CS_ORDER_REQUIREMENT;
		__column_names[5] = BasePurchaseOrder.CS_CONTACT_NAME;
		__column_names[6] = BasePurchaseOrder.CS_CONTACT_PHONE;
		__column_names[7] = BasePurchaseOrder.CS_CONTACT_GENDER;
		__column_names[8] = BasePurchaseOrder.CS_STATUS;
		__column_names[9] = BasePurchaseOrder.CS_ORDER_EMPLOYEE_ID;
		__column_names[10] = BasePurchaseOrder.CS_ORDER_TIME;
		__column_names[11] = BasePurchaseOrder.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePurchaseOrder b) {
		clear();
		setPurchaseOrderIdClear(b.getPurchaseOrderId());
	}

	public boolean isPrimaryKeyNull() {
		return getPurchaseOrderId() == null;
	}

	@Override
	public BasePurchaseOrder generateBase(){
		BasePurchaseOrder b = new BasePurchaseOrder();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePurchaseOrder b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPurchaseOrderId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOrderCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOrderName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSupplierId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOrderRequirement(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContactName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContactPhone(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContactGender(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOrderEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOrderTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BasePurchaseOrder b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPurchaseOrderId();
		buff[count++] = b.getOrderCode();
		buff[count++] = b.getOrderName();
		buff[count++] = b.getSupplierId();
		buff[count++] = b.getOrderRequirement();
		buff[count++] = b.getContactName();
		buff[count++] = b.getContactPhone();
		buff[count++] = b.getContactGender();
		buff[count++] = b.getStatus();
		buff[count++] = b.getOrderEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOrderTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BasePurchaseOrder b){
		if(b.getPurchaseOrderId() != null) setPurchaseOrderIdClear(b.getPurchaseOrderId());
		if(b.getOrderCode() != null) setOrderCode(b.getOrderCode());
		if(b.getOrderName() != null) setOrderName(b.getOrderName());
		if(b.getSupplierId() != null) setSupplierId(b.getSupplierId());
		if(b.getOrderRequirement() != null) setOrderRequirement(b.getOrderRequirement());
		if(b.getContactName() != null) setContactName(b.getContactName());
		if(b.getContactPhone() != null) setContactPhone(b.getContactPhone());
		if(b.getContactGender() != null) setContactGender(b.getContactGender());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getOrderEmployeeId() != null) setOrderEmployeeId(b.getOrderEmployeeId());
		if(b.getOrderTime() != null) setOrderTime(b.getOrderTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BasePurchaseOrder generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePurchaseOrder b = new BasePurchaseOrder();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePurchaseOrder __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPurchaseOrderId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderRequirement(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContactName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContactPhone(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContactGender(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setPurchaseOrderId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPurchaseOrderId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPurchaseOrderIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setOrderCode(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getOrderCode() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setOrderName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getOrderName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setSupplierId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getSupplierId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setOrderRequirement(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getOrderRequirement() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setContactName(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getContactName() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setContactPhone(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getContactPhone() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setContactGender(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getContactGender() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setOrderEmployeeId(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getOrderEmployeeId() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setOrderTime(java.util.Date val) {
		setCurrentData(10, generateTimestampFromDate(val));
	}

	public java.util.Date getOrderTime() {
		return GenericBase.__getDateFromSQL(__current_data[10]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setConditionPurchaseOrderId(String op, java.lang.Integer val) {
		setConditionPurchaseOrderId(op, val, CONDITION_AND);
	}

	public void setConditionPurchaseOrderId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPurchaseOrderId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionOrderCode(String op, java.lang.String val) {
		setConditionOrderCode(op, val, CONDITION_AND);
	}

	public void setConditionOrderCode(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectOrderCode(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionOrderName(String op, java.lang.String val) {
		setConditionOrderName(op, val, CONDITION_AND);
	}

	public void setConditionOrderName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectOrderName(boolean val) {
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

	public void setConditionOrderRequirement(String op, java.lang.String val) {
		setConditionOrderRequirement(op, val, CONDITION_AND);
	}

	public void setConditionOrderRequirement(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectOrderRequirement(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionContactName(String op, java.lang.String val) {
		setConditionContactName(op, val, CONDITION_AND);
	}

	public void setConditionContactName(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectContactName(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionContactPhone(String op, java.lang.String val) {
		setConditionContactPhone(op, val, CONDITION_AND);
	}

	public void setConditionContactPhone(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectContactPhone(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionContactGender(String op, java.lang.Integer val) {
		setConditionContactGender(op, val, CONDITION_AND);
	}

	public void setConditionContactGender(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectContactGender(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionOrderEmployeeId(String op, java.lang.Integer val) {
		setConditionOrderEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOrderEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectOrderEmployeeId(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionOrderTime(String op, java.util.Date val) {
		setConditionOrderTime(op, val, CONDITION_AND);
	}

	public void setConditionOrderTime(String op, java.util.Date val, String relation) {
		addCondition(10, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOrderTime(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[11] = val;
	}


}

