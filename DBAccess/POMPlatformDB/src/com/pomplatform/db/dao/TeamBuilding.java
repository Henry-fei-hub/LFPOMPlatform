package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseTeamBuilding;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class TeamBuilding extends AbstractTable<BaseTeamBuilding>
{

	public TeamBuilding() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "team_buildings";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseTeamBuilding.CS_TEAM_BUILDING_ID;
		__column_names[1] = BaseTeamBuilding.CS_ORDER_ID;
		__column_names[2] = BaseTeamBuilding.CS_EMPLOYEE_ID;
		__column_names[3] = BaseTeamBuilding.CS_DEPARTMENT_ID;
		__column_names[4] = BaseTeamBuilding.CS_RATE;
		__column_names[5] = BaseTeamBuilding.CS_SETTLEMENT;
		__column_names[6] = BaseTeamBuilding.CS_CONTRACT_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseTeamBuilding b) {
		clear();
		setTeamBuildingIdClear(b.getTeamBuildingId());
	}

	public boolean isPrimaryKeyNull() {
		return getTeamBuildingId() == null;
	}

	@Override
	public BaseTeamBuilding generateBase(){
		BaseTeamBuilding b = new BaseTeamBuilding();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseTeamBuilding b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setTeamBuildingId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOrderId(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRate(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSettlement(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseTeamBuilding b, Object[] buff){
		int count = 0;
		buff[count++] = b.getTeamBuildingId();
		buff[count++] = b.getOrderId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getRate();
		buff[count++] = b.getSettlement();
		buff[count++] = b.getContractId();
	}

	@Override
	public void setDataFromBase(BaseTeamBuilding b){
		if(b.getTeamBuildingId() != null) setTeamBuildingIdClear(b.getTeamBuildingId());
		if(b.getOrderId() != null) setOrderId(b.getOrderId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getRate() != null) setRate(b.getRate());
		if(b.getSettlement() != null) setSettlement(b.getSettlement());
		if(b.getContractId() != null) setContractId(b.getContractId());
	}

	@Override
	public BaseTeamBuilding generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseTeamBuilding b = new BaseTeamBuilding();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseTeamBuilding __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTeamBuildingId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderId(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRate(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSettlement(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
	}

	public void setTeamBuildingId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getTeamBuildingId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setTeamBuildingIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setOrderId(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getOrderId() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setRate(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getRate() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setSettlement(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getSettlement() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setConditionTeamBuildingId(String op, java.lang.Integer val) {
		setConditionTeamBuildingId(op, val, CONDITION_AND);
	}

	public void setConditionTeamBuildingId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectTeamBuildingId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionOrderId(String op, java.lang.String val) {
		setConditionOrderId(op, val, CONDITION_AND);
	}

	public void setConditionOrderId(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectOrderId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionRate(String op, java.lang.Integer val) {
		setConditionRate(op, val, CONDITION_AND);
	}

	public void setConditionRate(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectRate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionSettlement(String op, java.math.BigDecimal val) {
		setConditionSettlement(op, val, CONDITION_AND);
	}

	public void setConditionSettlement(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectSettlement(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
		__select_flags[6] = val;
	}


}

