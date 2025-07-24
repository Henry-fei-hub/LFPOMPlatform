package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProduct;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class Product extends AbstractTable<BaseProduct>
{

	public Product() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 13;

		initTables();

		__tableName            = "products";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProduct.CS_PRODUCT_ID;
		__column_names[1] = BaseProduct.CS_CATEGORY_ID;
		__column_names[2] = BaseProduct.CS_PRODUCT_NAME;
		__column_names[3] = BaseProduct.CS_PRODUCT_TYPE;
		__column_names[4] = BaseProduct.CS_PRODUCT_MODEL;
		__column_names[5] = BaseProduct.CS_PRODUCT_UNIT;
		__column_names[6] = BaseProduct.CS_PRODUCT_SPECIFICATION;
		__column_names[7] = BaseProduct.CS_PRODUCT_SKINS_SIZE;
		__column_names[8] = BaseProduct.CS_IS_ENABLED;
		__column_names[9] = BaseProduct.CS_CREATE_EMPLOYEE_ID;
		__column_names[10] = BaseProduct.CS_CREATE_TIME;
		__column_names[11] = BaseProduct.CS_DELETE_FLAG;
		__column_names[12] = BaseProduct.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProduct b) {
		clear();
		setProductIdClear(b.getProductId());
	}

	public boolean isPrimaryKeyNull() {
		return getProductId() == null;
	}

	@Override
	public BaseProduct generateBase(){
		BaseProduct b = new BaseProduct();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProduct b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProductId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCategoryId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProductName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProductType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProductModel(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProductUnit(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProductSpecification(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProductSkinsSize(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsEnabled(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setCreateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseProduct b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProductId();
		buff[count++] = b.getCategoryId();
		buff[count++] = b.getProductName();
		buff[count++] = b.getProductType();
		buff[count++] = b.getProductModel();
		buff[count++] = b.getProductUnit();
		buff[count++] = b.getProductSpecification();
		buff[count++] = b.getProductSkinsSize();
		buff[count++] = b.getIsEnabled();
		buff[count++] = b.getCreateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getDeleteFlag();
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseProduct b){
		if(b.getProductId() != null) setProductIdClear(b.getProductId());
		if(b.getCategoryId() != null) setCategoryId(b.getCategoryId());
		if(b.getProductName() != null) setProductName(b.getProductName());
		if(b.getProductType() != null) setProductType(b.getProductType());
		if(b.getProductModel() != null) setProductModel(b.getProductModel());
		if(b.getProductUnit() != null) setProductUnit(b.getProductUnit());
		if(b.getProductSpecification() != null) setProductSpecification(b.getProductSpecification());
		if(b.getProductSkinsSize() != null) setProductSkinsSize(b.getProductSkinsSize());
		if(b.getIsEnabled() != null) setIsEnabled(b.getIsEnabled());
		if(b.getCreateEmployeeId() != null) setCreateEmployeeId(b.getCreateEmployeeId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseProduct generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProduct b = new BaseProduct();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProduct __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCategoryId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductModel(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductUnit(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductSpecification(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductSkinsSize(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsEnabled(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setProductId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProductId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProductIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCategoryId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getCategoryId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setProductName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getProductName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setProductType(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getProductType() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setProductModel(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getProductModel() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setProductUnit(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getProductUnit() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setProductSpecification(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getProductSpecification() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setProductSkinsSize(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getProductSkinsSize() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setIsEnabled(java.lang.Boolean val) {
		setCurrentData(8, val);
	}

	public java.lang.Boolean getIsEnabled() {
		return GenericBase.__getBoolean(__current_data[8]);
	}

	public void setCreateEmployeeId(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getCreateEmployeeId() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(10, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[10]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setConditionProductId(String op, java.lang.Integer val) {
		setConditionProductId(op, val, CONDITION_AND);
	}

	public void setConditionProductId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProductId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCategoryId(String op, java.lang.Integer val) {
		setConditionCategoryId(op, val, CONDITION_AND);
	}

	public void setConditionCategoryId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCategoryId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionProductName(String op, java.lang.String val) {
		setConditionProductName(op, val, CONDITION_AND);
	}

	public void setConditionProductName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProductName(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionProductType(String op, java.lang.Integer val) {
		setConditionProductType(op, val, CONDITION_AND);
	}

	public void setConditionProductType(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectProductType(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionProductModel(String op, java.lang.String val) {
		setConditionProductModel(op, val, CONDITION_AND);
	}

	public void setConditionProductModel(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectProductModel(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionProductUnit(String op, java.lang.String val) {
		setConditionProductUnit(op, val, CONDITION_AND);
	}

	public void setConditionProductUnit(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectProductUnit(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionProductSpecification(String op, java.lang.String val) {
		setConditionProductSpecification(op, val, CONDITION_AND);
	}

	public void setConditionProductSpecification(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectProductSpecification(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionProductSkinsSize(String op, java.lang.String val) {
		setConditionProductSkinsSize(op, val, CONDITION_AND);
	}

	public void setConditionProductSkinsSize(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectProductSkinsSize(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionIsEnabled(String op, java.lang.Boolean val) {
		setConditionIsEnabled(op, val, CONDITION_AND);
	}

	public void setConditionIsEnabled(String op, java.lang.Boolean val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectIsEnabled(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val) {
		setConditionCreateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectCreateEmployeeId(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(10, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[12] = val;
	}


}

