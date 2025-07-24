package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCarCostAllocation;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CarCostAllocation extends AbstractTable<BaseCarCostAllocation>
{

	public CarCostAllocation() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 9;

		initTables();

		__tableName            = "car_cost_allocations";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCarCostAllocation.CS_CAR_COST_ALLOCATION_ID;
		__column_names[1] = BaseCarCostAllocation.CS_TYPE;
		__column_names[2] = BaseCarCostAllocation.CS_PERSONNEL_BUSINESS_ID;
		__column_names[3] = BaseCarCostAllocation.CS_ID;
		__column_names[4] = BaseCarCostAllocation.CS_CODE;
		__column_names[5] = BaseCarCostAllocation.CS_NAME;
		__column_names[6] = BaseCarCostAllocation.CS_COST;
		__column_names[7] = BaseCarCostAllocation.CS_PERCENT;
		__column_names[8] = BaseCarCostAllocation.CS_COST_ALLOCATION;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCarCostAllocation b) {
		clear();
		setCarCostAllocationIdClear(b.getCarCostAllocationId());
	}

	public boolean isPrimaryKeyNull() {
		return getCarCostAllocationId() == null;
	}

	@Override
	public BaseCarCostAllocation generateBase(){
		BaseCarCostAllocation b = new BaseCarCostAllocation();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCarCostAllocation b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCarCostAllocationId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCost(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCostAllocation(GenericBase.__getDecimal(val));
	}

	@Override
	public void setBaseToBuffer(BaseCarCostAllocation b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCarCostAllocationId();
		buff[count++] = b.getType();
		buff[count++] = b.getPersonnelBusinessId();
		buff[count++] = b.getId();
		buff[count++] = b.getCode();
		buff[count++] = b.getName();
		buff[count++] = b.getCost();
		buff[count++] = b.getPercent();
		buff[count++] = b.getCostAllocation();
	}

	@Override
	public void setDataFromBase(BaseCarCostAllocation b){
		if(b.getCarCostAllocationId() != null) setCarCostAllocationIdClear(b.getCarCostAllocationId());
		if(b.getType() != null) setType(b.getType());
		if(b.getPersonnelBusinessId() != null) setPersonnelBusinessId(b.getPersonnelBusinessId());
		if(b.getId() != null) setId(b.getId());
		if(b.getCode() != null) setCode(b.getCode());
		if(b.getName() != null) setName(b.getName());
		if(b.getCost() != null) setCost(b.getCost());
		if(b.getPercent() != null) setPercent(b.getPercent());
		if(b.getCostAllocation() != null) setCostAllocation(b.getCostAllocation());
	}

	@Override
	public BaseCarCostAllocation generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCarCostAllocation b = new BaseCarCostAllocation();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCarCostAllocation __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCarCostAllocationId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCost(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCostAllocation(GenericBase.__getDecimal(val));
	}

	public void setCarCostAllocationId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCarCostAllocationId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCarCostAllocationIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setType(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getType() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setPersonnelBusinessId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getPersonnelBusinessId() {
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

	public void setPercent(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getPercent() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setCostAllocation(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getCostAllocation() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setConditionCarCostAllocationId(String op, java.lang.Integer val) {
		setConditionCarCostAllocationId(op, val, CONDITION_AND);
	}

	public void setConditionCarCostAllocationId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCarCostAllocationId(boolean val) {
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

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val) {
		setConditionPersonnelBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectPersonnelBusinessId(boolean val) {
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

	public void setConditionPercent(String op, java.math.BigDecimal val) {
		setConditionPercent(op, val, CONDITION_AND);
	}

	public void setConditionPercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectPercent(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionCostAllocation(String op, java.math.BigDecimal val) {
		setConditionCostAllocation(op, val, CONDITION_AND);
	}

	public void setConditionCostAllocation(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectCostAllocation(boolean val) {
		__select_flags[8] = val;
	}


}

