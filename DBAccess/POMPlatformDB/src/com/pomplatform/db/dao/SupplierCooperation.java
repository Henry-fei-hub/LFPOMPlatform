package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSupplierCooperation;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SupplierCooperation extends AbstractTable<BaseSupplierCooperation>
{

	public SupplierCooperation() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 5;

		initTables();

		__tableName            = "supplier_cooperation";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSupplierCooperation.CS_SUPPLIER_COOPERATION_ID;
		__column_names[1] = BaseSupplierCooperation.CS_SUPPLIER_ID;
		__column_names[2] = BaseSupplierCooperation.CS_PROJECT_NAME;
		__column_names[3] = BaseSupplierCooperation.CS_PROJECT_LEADER;
		__column_names[4] = BaseSupplierCooperation.CS_SUPPLIER_EVALUATE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSupplierCooperation b) {
		clear();
		setSupplierCooperationIdClear(b.getSupplierCooperationId());
	}

	public boolean isPrimaryKeyNull() {
		return getSupplierCooperationId() == null;
	}

	@Override
	public BaseSupplierCooperation generateBase(){
		BaseSupplierCooperation b = new BaseSupplierCooperation();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSupplierCooperation b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSupplierCooperationId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSupplierId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectLeader(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSupplierEvaluate(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseSupplierCooperation b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSupplierCooperationId();
		buff[count++] = b.getSupplierId();
		buff[count++] = b.getProjectName();
		buff[count++] = b.getProjectLeader();
		buff[count++] = b.getSupplierEvaluate();
	}

	@Override
	public void setDataFromBase(BaseSupplierCooperation b){
		if(b.getSupplierCooperationId() != null) setSupplierCooperationIdClear(b.getSupplierCooperationId());
		if(b.getSupplierId() != null) setSupplierId(b.getSupplierId());
		if(b.getProjectName() != null) setProjectName(b.getProjectName());
		if(b.getProjectLeader() != null) setProjectLeader(b.getProjectLeader());
		if(b.getSupplierEvaluate() != null) setSupplierEvaluate(b.getSupplierEvaluate());
	}

	@Override
	public BaseSupplierCooperation generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSupplierCooperation b = new BaseSupplierCooperation();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSupplierCooperation __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierCooperationId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectLeader(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierEvaluate(GenericBase.__getString(val));
	}

	public void setSupplierCooperationId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSupplierCooperationId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSupplierCooperationIdClear(java.lang.Integer val) {
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

	public void setProjectLeader(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getProjectLeader() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setSupplierEvaluate(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getSupplierEvaluate() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setConditionSupplierCooperationId(String op, java.lang.Integer val) {
		setConditionSupplierCooperationId(op, val, CONDITION_AND);
	}

	public void setConditionSupplierCooperationId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSupplierCooperationId(boolean val) {
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

	public void setConditionProjectLeader(String op, java.lang.String val) {
		setConditionProjectLeader(op, val, CONDITION_AND);
	}

	public void setConditionProjectLeader(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectProjectLeader(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionSupplierEvaluate(String op, java.lang.String val) {
		setConditionSupplierEvaluate(op, val, CONDITION_AND);
	}

	public void setConditionSupplierEvaluate(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectSupplierEvaluate(boolean val) {
		__select_flags[4] = val;
	}


}

