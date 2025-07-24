package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseContractCode;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ContractCode extends AbstractTable<BaseContractCode>
{

	public ContractCode() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "contract_code";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseContractCode.CS_CONTRACT_CODE_ID;
		__column_names[1] = BaseContractCode.CS_SIGN_COMPANY;
		__column_names[2] = BaseContractCode.CS_CONTRACT_CODE;
		__column_names[3] = BaseContractCode.CS_REMARK;
		__column_names[4] = BaseContractCode.CS_EMPLOYEE_ID;
		__column_names[5] = BaseContractCode.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseContractCode b) {
		clear();
		setContractCodeIdClear(b.getContractCodeId());
	}

	public boolean isPrimaryKeyNull() {
		return getContractCodeId() == null;
	}

	@Override
	public BaseContractCode generateBase(){
		BaseContractCode b = new BaseContractCode();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseContractCode b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setContractCodeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSignCompany(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseContractCode b, Object[] buff){
		int count = 0;
		buff[count++] = b.getContractCodeId();
		buff[count++] = b.getSignCompany();
		buff[count++] = b.getContractCode();
		buff[count++] = b.getRemark();
		buff[count++] = b.getEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BaseContractCode b){
		if(b.getContractCodeId() != null) setContractCodeIdClear(b.getContractCodeId());
		if(b.getSignCompany() != null) setSignCompany(b.getSignCompany());
		if(b.getContractCode() != null) setContractCode(b.getContractCode());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BaseContractCode generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseContractCode b = new BaseContractCode();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseContractCode __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractCodeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSignCompany(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setContractCodeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getContractCodeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setContractCodeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setSignCompany(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getSignCompany() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setContractCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getContractCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setConditionContractCodeId(String op, java.lang.Integer val) {
		setConditionContractCodeId(op, val, CONDITION_AND);
	}

	public void setConditionContractCodeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectContractCodeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionSignCompany(String op, java.lang.Integer val) {
		setConditionSignCompany(op, val, CONDITION_AND);
	}

	public void setConditionSignCompany(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectSignCompany(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionContractCode(String op, java.lang.String val) {
		setConditionContractCode(op, val, CONDITION_AND);
	}

	public void setConditionContractCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectContractCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
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


}

