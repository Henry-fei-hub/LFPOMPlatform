package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProductAttribute;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProductAttribute extends AbstractTable<BaseProductAttribute>
{

	public ProductAttribute() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "product_attributes";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProductAttribute.CS_PRODUCT_ATTRIBUTE_ID;
		__column_names[1] = BaseProductAttribute.CS_PRODUCT_ID;
		__column_names[2] = BaseProductAttribute.CS_ATTRIBUTE_TYPE;
		__column_names[3] = BaseProductAttribute.CS_ATTRIBUTE_NAME;
		__column_names[4] = BaseProductAttribute.CS_ATTRIBUTE_VALUE;
		__column_names[5] = BaseProductAttribute.CS_CREATE_EMPLOYEE_ID;
		__column_names[6] = BaseProductAttribute.CS_CREATE_TIME;
		__column_names[7] = BaseProductAttribute.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProductAttribute b) {
		clear();
		setProductAttributeIdClear(b.getProductAttributeId());
	}

	public boolean isPrimaryKeyNull() {
		return getProductAttributeId() == null;
	}

	@Override
	public BaseProductAttribute generateBase(){
		BaseProductAttribute b = new BaseProductAttribute();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProductAttribute b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProductAttributeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProductId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAttributeType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAttributeName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAttributeValue(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseProductAttribute b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProductAttributeId();
		buff[count++] = b.getProductId();
		buff[count++] = b.getAttributeType();
		buff[count++] = b.getAttributeName();
		buff[count++] = b.getAttributeValue();
		buff[count++] = b.getCreateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseProductAttribute b){
		if(b.getProductAttributeId() != null) setProductAttributeIdClear(b.getProductAttributeId());
		if(b.getProductId() != null) setProductId(b.getProductId());
		if(b.getAttributeType() != null) setAttributeType(b.getAttributeType());
		if(b.getAttributeName() != null) setAttributeName(b.getAttributeName());
		if(b.getAttributeValue() != null) setAttributeValue(b.getAttributeValue());
		if(b.getCreateEmployeeId() != null) setCreateEmployeeId(b.getCreateEmployeeId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseProductAttribute generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProductAttribute b = new BaseProductAttribute();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProductAttribute __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductAttributeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttributeType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttributeName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttributeValue(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setProductAttributeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProductAttributeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProductAttributeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProductId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProductId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setAttributeType(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getAttributeType() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setAttributeName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getAttributeName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setAttributeValue(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getAttributeValue() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setCreateEmployeeId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getCreateEmployeeId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setConditionProductAttributeId(String op, java.lang.Integer val) {
		setConditionProductAttributeId(op, val, CONDITION_AND);
	}

	public void setConditionProductAttributeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProductAttributeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionProductId(String op, java.lang.Integer val) {
		setConditionProductId(op, val, CONDITION_AND);
	}

	public void setConditionProductId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProductId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionAttributeType(String op, java.lang.Integer val) {
		setConditionAttributeType(op, val, CONDITION_AND);
	}

	public void setConditionAttributeType(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectAttributeType(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionAttributeName(String op, java.lang.String val) {
		setConditionAttributeName(op, val, CONDITION_AND);
	}

	public void setConditionAttributeName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectAttributeName(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionAttributeValue(String op, java.lang.String val) {
		setConditionAttributeValue(op, val, CONDITION_AND);
	}

	public void setConditionAttributeValue(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectAttributeValue(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val) {
		setConditionCreateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectCreateEmployeeId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[7] = val;
	}


}

