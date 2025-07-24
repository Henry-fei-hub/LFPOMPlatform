package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSupplierDetail;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SupplierDetail extends AbstractTable<BaseSupplierDetail>
{

	public SupplierDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 5;

		initTables();

		__tableName            = "supplier_detail";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSupplierDetail.CS_SUPPLIER_DETAIL_ID;
		__column_names[1] = BaseSupplierDetail.CS_SUPPLIER_ID;
		__column_names[2] = BaseSupplierDetail.CS_PROJECT_NAME;
		__column_names[3] = BaseSupplierDetail.CS_PROJECT_ADDRESS;
		__column_names[4] = BaseSupplierDetail.CS_SUPPLIER_DUTY;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSupplierDetail b) {
		clear();
		setSupplierDetailIdClear(b.getSupplierDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getSupplierDetailId() == null;
	}

	@Override
	public BaseSupplierDetail generateBase(){
		BaseSupplierDetail b = new BaseSupplierDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSupplierDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSupplierDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSupplierId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSupplierDuty(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseSupplierDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSupplierDetailId();
		buff[count++] = b.getSupplierId();
		buff[count++] = b.getProjectName();
		buff[count++] = b.getProjectAddress();
		buff[count++] = b.getSupplierDuty();
	}

	@Override
	public void setDataFromBase(BaseSupplierDetail b){
		if(b.getSupplierDetailId() != null) setSupplierDetailIdClear(b.getSupplierDetailId());
		if(b.getSupplierId() != null) setSupplierId(b.getSupplierId());
		if(b.getProjectName() != null) setProjectName(b.getProjectName());
		if(b.getProjectAddress() != null) setProjectAddress(b.getProjectAddress());
		if(b.getSupplierDuty() != null) setSupplierDuty(b.getSupplierDuty());
	}

	@Override
	public BaseSupplierDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSupplierDetail b = new BaseSupplierDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSupplierDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierDuty(GenericBase.__getString(val));
	}

	public void setSupplierDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSupplierDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSupplierDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setSupplierId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getSupplierId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setProjectName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getProjectName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setProjectAddress(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getProjectAddress() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setSupplierDuty(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getSupplierDuty() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setConditionSupplierDetailId(String op, java.lang.Integer val) {
		setConditionSupplierDetailId(op, val, CONDITION_AND);
	}

	public void setConditionSupplierDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSupplierDetailId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionSupplierId(String op, java.lang.Integer val) {
		setConditionSupplierId(op, val, CONDITION_AND);
	}

	public void setConditionSupplierId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectSupplierId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionProjectName(String op, java.lang.String val) {
		setConditionProjectName(op, val, CONDITION_AND);
	}

	public void setConditionProjectName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProjectName(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionProjectAddress(String op, java.lang.String val) {
		setConditionProjectAddress(op, val, CONDITION_AND);
	}

	public void setConditionProjectAddress(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectProjectAddress(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionSupplierDuty(String op, java.lang.String val) {
		setConditionSupplierDuty(op, val, CONDITION_AND);
	}

	public void setConditionSupplierDuty(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectSupplierDuty(boolean val) {
		__select_flags[4] = val;
	}


}

