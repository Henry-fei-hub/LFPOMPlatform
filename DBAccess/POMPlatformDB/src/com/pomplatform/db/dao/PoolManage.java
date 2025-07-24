package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePoolManage;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PoolManage extends AbstractTable<BasePoolManage>
{

	public PoolManage() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "pool_manages";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePoolManage.CS_POOL_MANAGE_ID;
		__column_names[1] = BasePoolManage.CS_POOL_NAME;
		__column_names[2] = BasePoolManage.CS_REGION;
		__column_names[3] = BasePoolManage.CS_BUSINESS_TYPE;
		__column_names[4] = BasePoolManage.CS_POOL_TYPE;
		__column_names[5] = BasePoolManage.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePoolManage b) {
		clear();
		setPoolManageIdClear(b.getPoolManageId());
	}

	public boolean isPrimaryKeyNull() {
		return getPoolManageId() == null;
	}

	@Override
	public BasePoolManage generateBase(){
		BasePoolManage b = new BasePoolManage();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePoolManage b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPoolManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPoolName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRegion(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPoolType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BasePoolManage b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPoolManageId();
		buff[count++] = b.getPoolName();
		buff[count++] = b.getRegion();
		buff[count++] = b.getBusinessType();
		buff[count++] = b.getPoolType();
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BasePoolManage b){
		if(b.getPoolManageId() != null) setPoolManageIdClear(b.getPoolManageId());
		if(b.getPoolName() != null) setPoolName(b.getPoolName());
		if(b.getRegion() != null) setRegion(b.getRegion());
		if(b.getBusinessType() != null) setBusinessType(b.getBusinessType());
		if(b.getPoolType() != null) setPoolType(b.getPoolType());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BasePoolManage generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePoolManage b = new BasePoolManage();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePoolManage __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPoolManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPoolName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRegion(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPoolType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setPoolManageId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPoolManageId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPoolManageIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPoolName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getPoolName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setRegion(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getRegion() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setBusinessType(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getBusinessType() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setPoolType(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getPoolType() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setConditionPoolManageId(String op, java.lang.Integer val) {
		setConditionPoolManageId(op, val, CONDITION_AND);
	}

	public void setConditionPoolManageId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPoolManageId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionPoolName(String op, java.lang.String val) {
		setConditionPoolName(op, val, CONDITION_AND);
	}

	public void setConditionPoolName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectPoolName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionRegion(String op, java.lang.Integer val) {
		setConditionRegion(op, val, CONDITION_AND);
	}

	public void setConditionRegion(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectRegion(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionBusinessType(String op, java.lang.Integer val) {
		setConditionBusinessType(op, val, CONDITION_AND);
	}

	public void setConditionBusinessType(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectBusinessType(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionPoolType(String op, java.lang.Integer val) {
		setConditionPoolType(op, val, CONDITION_AND);
	}

	public void setConditionPoolType(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectPoolType(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[5] = val;
	}


}

