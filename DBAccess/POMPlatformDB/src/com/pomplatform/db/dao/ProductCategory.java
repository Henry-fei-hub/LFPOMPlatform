package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProductCategory;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProductCategory extends AbstractTable<BaseProductCategory>
{

	public ProductCategory() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "product_categories";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProductCategory.CS_CATEGORY_ID;
		__column_names[1] = BaseProductCategory.CS_CATEGORY_NAME;
		__column_names[2] = BaseProductCategory.CS_PARENT_ID;
		__column_names[3] = BaseProductCategory.CS_IS_ENABLED;
		__column_names[4] = BaseProductCategory.CS_CREATE_EMPLOYEE_ID;
		__column_names[5] = BaseProductCategory.CS_CREATE_TIME;
		__column_names[6] = BaseProductCategory.CS_DELETE_FLAG;
		__column_names[7] = BaseProductCategory.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProductCategory b) {
		clear();
		setCategoryIdClear(b.getCategoryId());
	}

	public boolean isPrimaryKeyNull() {
		return getCategoryId() == null;
	}

	@Override
	public BaseProductCategory generateBase(){
		BaseProductCategory b = new BaseProductCategory();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProductCategory b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCategoryId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCategoryName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsEnabled(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setCreateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseProductCategory b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCategoryId();
		buff[count++] = b.getCategoryName();
		buff[count++] = b.getParentId();
		buff[count++] = b.getIsEnabled();
		buff[count++] = b.getCreateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getDeleteFlag();
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseProductCategory b){
		if(b.getCategoryId() != null) setCategoryIdClear(b.getCategoryId());
		if(b.getCategoryName() != null) setCategoryName(b.getCategoryName());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getIsEnabled() != null) setIsEnabled(b.getIsEnabled());
		if(b.getCreateEmployeeId() != null) setCreateEmployeeId(b.getCreateEmployeeId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseProductCategory generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProductCategory b = new BaseProductCategory();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProductCategory __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCategoryId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCategoryName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsEnabled(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setCategoryId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCategoryId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCategoryIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCategoryName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getCategoryName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setIsEnabled(java.lang.Boolean val) {
		setCurrentData(3, val);
	}

	public java.lang.Boolean getIsEnabled() {
		return GenericBase.__getBoolean(__current_data[3]);
	}

	public void setCreateEmployeeId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getCreateEmployeeId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setConditionCategoryId(String op, java.lang.Integer val) {
		setConditionCategoryId(op, val, CONDITION_AND);
	}

	public void setConditionCategoryId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCategoryId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCategoryName(String op, java.lang.String val) {
		setConditionCategoryName(op, val, CONDITION_AND);
	}

	public void setConditionCategoryName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCategoryName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionParentId(String op, java.lang.Integer val) {
		setConditionParentId(op, val, CONDITION_AND);
	}

	public void setConditionParentId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectParentId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionIsEnabled(String op, java.lang.Boolean val) {
		setConditionIsEnabled(op, val, CONDITION_AND);
	}

	public void setConditionIsEnabled(String op, java.lang.Boolean val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectIsEnabled(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val) {
		setConditionCreateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCreateEmployeeId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
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

