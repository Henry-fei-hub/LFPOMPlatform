package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePoolManageEmployee;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PoolManageEmployee extends AbstractTable<BasePoolManageEmployee>
{

	public PoolManageEmployee() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "pool_manage_employees";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePoolManageEmployee.CS_POOL_MANAGE_EMPLOYEE_ID;
		__column_names[1] = BasePoolManageEmployee.CS_POOL_MANAGE_ID;
		__column_names[2] = BasePoolManageEmployee.CS_EMPLOYEE_ID;
		__column_names[3] = BasePoolManageEmployee.CS_BUSINESS_IDS;
		__column_names[4] = BasePoolManageEmployee.CS_BUSINESS_NAMES;
		__column_names[5] = BasePoolManageEmployee.CS_PROFESSIONAL_IDS;
		__column_names[6] = BasePoolManageEmployee.CS_PROFESSIONAL_NAMES;
		__column_names[7] = BasePoolManageEmployee.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePoolManageEmployee b) {
		clear();
		setPoolManageEmployeeIdClear(b.getPoolManageEmployeeId());
	}

	public boolean isPrimaryKeyNull() {
		return getPoolManageEmployeeId() == null;
	}

	@Override
	public BasePoolManageEmployee generateBase(){
		BasePoolManageEmployee b = new BasePoolManageEmployee();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePoolManageEmployee b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPoolManageEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPoolManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessIds(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBusinessNames(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProfessionalIds(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProfessionalNames(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BasePoolManageEmployee b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPoolManageEmployeeId();
		buff[count++] = b.getPoolManageId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getBusinessIds();
		buff[count++] = b.getBusinessNames();
		buff[count++] = b.getProfessionalIds();
		buff[count++] = b.getProfessionalNames();
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BasePoolManageEmployee b){
		if(b.getPoolManageEmployeeId() != null) setPoolManageEmployeeIdClear(b.getPoolManageEmployeeId());
		if(b.getPoolManageId() != null) setPoolManageId(b.getPoolManageId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getBusinessIds() != null) setBusinessIds(b.getBusinessIds());
		if(b.getBusinessNames() != null) setBusinessNames(b.getBusinessNames());
		if(b.getProfessionalIds() != null) setProfessionalIds(b.getProfessionalIds());
		if(b.getProfessionalNames() != null) setProfessionalNames(b.getProfessionalNames());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BasePoolManageEmployee generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePoolManageEmployee b = new BasePoolManageEmployee();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePoolManageEmployee __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPoolManageEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPoolManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessIds(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessNames(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProfessionalIds(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProfessionalNames(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setPoolManageEmployeeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPoolManageEmployeeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPoolManageEmployeeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPoolManageId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPoolManageId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setBusinessIds(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getBusinessIds() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setBusinessNames(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getBusinessNames() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setProfessionalIds(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getProfessionalIds() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setProfessionalNames(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getProfessionalNames() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setConditionPoolManageEmployeeId(String op, java.lang.Integer val) {
		setConditionPoolManageEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionPoolManageEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPoolManageEmployeeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionPoolManageId(String op, java.lang.Integer val) {
		setConditionPoolManageId(op, val, CONDITION_AND);
	}

	public void setConditionPoolManageId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectPoolManageId(boolean val) {
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

	public void setConditionBusinessIds(String op, java.lang.String val) {
		setConditionBusinessIds(op, val, CONDITION_AND);
	}

	public void setConditionBusinessIds(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectBusinessIds(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionBusinessNames(String op, java.lang.String val) {
		setConditionBusinessNames(op, val, CONDITION_AND);
	}

	public void setConditionBusinessNames(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectBusinessNames(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionProfessionalIds(String op, java.lang.String val) {
		setConditionProfessionalIds(op, val, CONDITION_AND);
	}

	public void setConditionProfessionalIds(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectProfessionalIds(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionProfessionalNames(String op, java.lang.String val) {
		setConditionProfessionalNames(op, val, CONDITION_AND);
	}

	public void setConditionProfessionalNames(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectProfessionalNames(boolean val) {
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

