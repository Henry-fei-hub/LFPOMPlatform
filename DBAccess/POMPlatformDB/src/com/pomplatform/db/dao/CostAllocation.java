package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCostAllocation;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CostAllocation extends AbstractTable<BaseCostAllocation>
{

	public CostAllocation() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "cost_allocations";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCostAllocation.CS_COST_ALLOCATION_ID;
		__column_names[1] = BaseCostAllocation.CS_TYPE;
		__column_names[2] = BaseCostAllocation.CS_RESET_COST_ID;
		__column_names[3] = BaseCostAllocation.CS_ID;
		__column_names[4] = BaseCostAllocation.CS_CODE;
		__column_names[5] = BaseCostAllocation.CS_NAME;
		__column_names[6] = BaseCostAllocation.CS_COST;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCostAllocation b) {
		clear();
		setCostAllocationIdClear(b.getCostAllocationId());
	}

	public boolean isPrimaryKeyNull() {
		return getCostAllocationId() == null;
	}

	@Override
	public BaseCostAllocation generateBase(){
		BaseCostAllocation b = new BaseCostAllocation();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCostAllocation b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCostAllocationId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setResetCostId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCost(GenericBase.__getDecimal(val));
	}

	@Override
	public void setBaseToBuffer(BaseCostAllocation b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCostAllocationId();
		buff[count++] = b.getType();
		buff[count++] = b.getResetCostId();
		buff[count++] = b.getId();
		buff[count++] = b.getCode();
		buff[count++] = b.getName();
		buff[count++] = b.getCost();
	}

	@Override
	public void setDataFromBase(BaseCostAllocation b){
		if(b.getCostAllocationId() != null) setCostAllocationIdClear(b.getCostAllocationId());
		if(b.getType() != null) setType(b.getType());
		if(b.getResetCostId() != null) setResetCostId(b.getResetCostId());
		if(b.getId() != null) setId(b.getId());
		if(b.getCode() != null) setCode(b.getCode());
		if(b.getName() != null) setName(b.getName());
		if(b.getCost() != null) setCost(b.getCost());
	}

	@Override
	public BaseCostAllocation generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCostAllocation b = new BaseCostAllocation();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCostAllocation __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCostAllocationId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setResetCostId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCost(GenericBase.__getDecimal(val));
	}

	public void setCostAllocationId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCostAllocationId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCostAllocationIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setType(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getType() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setResetCostId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getResetCostId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setCode(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getCode() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setName(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getName() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setCost(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getCost() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setConditionCostAllocationId(String op, java.lang.Integer val) {
		setConditionCostAllocationId(op, val, CONDITION_AND);
	}

	public void setConditionCostAllocationId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCostAllocationId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionType(String op, java.lang.Integer val) {
		setConditionType(op, val, CONDITION_AND);
	}

	public void setConditionType(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectType(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionResetCostId(String op, java.lang.Integer val) {
		setConditionResetCostId(op, val, CONDITION_AND);
	}

	public void setConditionResetCostId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectResetCostId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionId(String op, java.lang.Integer val) {
		setConditionId(op, val, CONDITION_AND);
	}

	public void setConditionId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCode(String op, java.lang.String val) {
		setConditionCode(op, val, CONDITION_AND);
	}

	public void setConditionCode(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCode(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionName(String op, java.lang.String val) {
		setConditionName(op, val, CONDITION_AND);
	}

	public void setConditionName(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectName(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionCost(String op, java.math.BigDecimal val) {
		setConditionCost(op, val, CONDITION_AND);
	}

	public void setConditionCost(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectCost(boolean val) {
		__select_flags[6] = val;
	}


}

