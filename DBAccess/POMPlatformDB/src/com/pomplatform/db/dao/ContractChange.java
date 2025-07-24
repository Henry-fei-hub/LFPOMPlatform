package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseContractChange;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ContractChange extends AbstractTable<BaseContractChange>
{

	public ContractChange() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "contract_changes";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseContractChange.CS_CONTRACT_CHANGE_ID;
		__column_names[1] = BaseContractChange.CS_CONTRACT_ID;
		__column_names[2] = BaseContractChange.CS_CONTRACT_AMOUNT;
		__column_names[3] = BaseContractChange.CS_CONTRACT_CHANGE_AMOUNT;
		__column_names[4] = BaseContractChange.CS_CONTRACT_FINAL_AMOUNT;
		__column_names[5] = BaseContractChange.CS_CONTRACT_CHANGE_VIEW;
		__column_names[6] = BaseContractChange.CS_FLAG;
		__column_names[7] = BaseContractChange.CS_OPERATE_EMPLOYEE_ID;
		__column_names[8] = BaseContractChange.CS_OPERATE_TIME;
		__column_names[9] = BaseContractChange.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseContractChange b) {
		clear();
		setContractChangeIdClear(b.getContractChangeId());
	}

	public boolean isPrimaryKeyNull() {
		return getContractChangeId() == null;
	}

	@Override
	public BaseContractChange generateBase(){
		BaseContractChange b = new BaseContractChange();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseContractChange b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setContractChangeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setContractChangeAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setContractFinalAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setContractChangeView(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseContractChange b, Object[] buff){
		int count = 0;
		buff[count++] = b.getContractChangeId();
		buff[count++] = b.getContractId();
		buff[count++] = b.getContractAmount();
		buff[count++] = b.getContractChangeAmount();
		buff[count++] = b.getContractFinalAmount();
		buff[count++] = b.getContractChangeView();
		buff[count++] = b.getFlag();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseContractChange b){
		if(b.getContractChangeId() != null) setContractChangeIdClear(b.getContractChangeId());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getContractAmount() != null) setContractAmount(b.getContractAmount());
		if(b.getContractChangeAmount() != null) setContractChangeAmount(b.getContractChangeAmount());
		if(b.getContractFinalAmount() != null) setContractFinalAmount(b.getContractFinalAmount());
		if(b.getContractChangeView() != null) setContractChangeView(b.getContractChangeView());
		if(b.getFlag() != null) setFlag(b.getFlag());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseContractChange generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseContractChange b = new BaseContractChange();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseContractChange __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractChangeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractChangeAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractFinalAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractChangeView(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setContractChangeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getContractChangeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setContractChangeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setContractAmount(java.math.BigDecimal val) {
		setCurrentData(2, val);
	}

	public java.math.BigDecimal getContractAmount() {
		return GenericBase.__getDecimal(__current_data[2]);
	}

	public void setContractChangeAmount(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getContractChangeAmount() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setContractFinalAmount(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getContractFinalAmount() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setContractChangeView(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getContractChangeView() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setFlag(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getFlag() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setConditionContractChangeId(String op, java.lang.Integer val) {
		setConditionContractChangeId(op, val, CONDITION_AND);
	}

	public void setConditionContractChangeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectContractChangeId(boolean val) {
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

	public void setConditionContractAmount(String op, java.math.BigDecimal val) {
		setConditionContractAmount(op, val, CONDITION_AND);
	}

	public void setConditionContractAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectContractAmount(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionContractChangeAmount(String op, java.math.BigDecimal val) {
		setConditionContractChangeAmount(op, val, CONDITION_AND);
	}

	public void setConditionContractChangeAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectContractChangeAmount(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionContractFinalAmount(String op, java.math.BigDecimal val) {
		setConditionContractFinalAmount(op, val, CONDITION_AND);
	}

	public void setConditionContractFinalAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectContractFinalAmount(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionContractChangeView(String op, java.lang.String val) {
		setConditionContractChangeView(op, val, CONDITION_AND);
	}

	public void setConditionContractChangeView(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectContractChangeView(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionFlag(String op, java.lang.Integer val) {
		setConditionFlag(op, val, CONDITION_AND);
	}

	public void setConditionFlag(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectFlag(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[9] = val;
	}


}

