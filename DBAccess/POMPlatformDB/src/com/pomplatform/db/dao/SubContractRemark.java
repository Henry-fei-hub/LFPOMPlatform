package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSubContractRemark;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SubContractRemark extends AbstractTable<BaseSubContractRemark>
{

	public SubContractRemark() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 5;

		initTables();

		__tableName            = "sub_contract_remarks";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSubContractRemark.CS_SUB_CONTRACT_REMARK_ID;
		__column_names[1] = BaseSubContractRemark.CS_CONTRACT_ID;
		__column_names[2] = BaseSubContractRemark.CS_EMPLOYEE_ID;
		__column_names[3] = BaseSubContractRemark.CS_CREATE_DATE;
		__column_names[4] = BaseSubContractRemark.CS_CONTENT_INFO;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSubContractRemark b) {
		clear();
		setSubContractRemarkIdClear(b.getSubContractRemarkId());
	}

	public boolean isPrimaryKeyNull() {
		return getSubContractRemarkId() == null;
	}

	@Override
	public BaseSubContractRemark generateBase(){
		BaseSubContractRemark b = new BaseSubContractRemark();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSubContractRemark b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSubContractRemarkId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setContentInfo(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseSubContractRemark b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSubContractRemarkId();
		buff[count++] = b.getContractId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getCreateDate());
		buff[count++] = b.getContentInfo();
	}

	@Override
	public void setDataFromBase(BaseSubContractRemark b){
		if(b.getSubContractRemarkId() != null) setSubContractRemarkIdClear(b.getSubContractRemarkId());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getCreateDate() != null) setCreateDate(b.getCreateDate());
		if(b.getContentInfo() != null) setContentInfo(b.getContentInfo());
	}

	@Override
	public BaseSubContractRemark generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSubContractRemark b = new BaseSubContractRemark();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSubContractRemark __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubContractRemarkId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContentInfo(GenericBase.__getString(val));
	}

	public void setSubContractRemarkId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSubContractRemarkId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSubContractRemarkIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setCreateDate(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateDate() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setContentInfo(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getContentInfo() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setConditionSubContractRemarkId(String op, java.lang.Integer val) {
		setConditionSubContractRemarkId(op, val, CONDITION_AND);
	}

	public void setConditionSubContractRemarkId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSubContractRemarkId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
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

	public void setConditionCreateDate(String op, java.util.Date val) {
		setConditionCreateDate(op, val, CONDITION_AND);
	}

	public void setConditionCreateDate(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateDate(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionContentInfo(String op, java.lang.String val) {
		setConditionContentInfo(op, val, CONDITION_AND);
	}

	public void setConditionContentInfo(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectContentInfo(boolean val) {
		__select_flags[4] = val;
	}


}

