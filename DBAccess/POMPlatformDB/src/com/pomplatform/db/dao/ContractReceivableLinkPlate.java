package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseContractReceivableLinkPlate;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ContractReceivableLinkPlate extends AbstractTable<BaseContractReceivableLinkPlate>
{

	public ContractReceivableLinkPlate() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "contract_receivable_link_plate";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseContractReceivableLinkPlate.CS_CONTRACT_RECEIVABLE_LINK_PLATE_ID;
		__column_names[1] = BaseContractReceivableLinkPlate.CS_CONTRACT_RECEIVABLE_ID;
		__column_names[2] = BaseContractReceivableLinkPlate.CS_PLATE_ID;
		__column_names[3] = BaseContractReceivableLinkPlate.CS_TOTAL_AMOUNT;
		__column_names[4] = BaseContractReceivableLinkPlate.CS_DISTRIBUTION_AMOUNT;
		__column_names[5] = BaseContractReceivableLinkPlate.CS_OPERATOR;
		__column_names[6] = BaseContractReceivableLinkPlate.CS_CREATE_TIME;
		__column_names[7] = BaseContractReceivableLinkPlate.CS_UPDATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseContractReceivableLinkPlate b) {
		clear();
		setContractReceivableLinkPlateIdClear(b.getContractReceivableLinkPlateId());
	}

	public boolean isPrimaryKeyNull() {
		return getContractReceivableLinkPlateId() == null;
	}

	@Override
	public BaseContractReceivableLinkPlate generateBase(){
		BaseContractReceivableLinkPlate b = new BaseContractReceivableLinkPlate();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseContractReceivableLinkPlate b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setContractReceivableLinkPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractReceivableId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setDistributionAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setUpdateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseContractReceivableLinkPlate b, Object[] buff){
		int count = 0;
		buff[count++] = b.getContractReceivableLinkPlateId();
		buff[count++] = b.getContractReceivableId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getTotalAmount();
		buff[count++] = b.getDistributionAmount();
		buff[count++] = b.getOperator();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = generateTimestampFromDate(b.getUpdateTime());
	}

	@Override
	public void setDataFromBase(BaseContractReceivableLinkPlate b){
		if(b.getContractReceivableLinkPlateId() != null) setContractReceivableLinkPlateIdClear(b.getContractReceivableLinkPlateId());
		if(b.getContractReceivableId() != null) setContractReceivableId(b.getContractReceivableId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getTotalAmount() != null) setTotalAmount(b.getTotalAmount());
		if(b.getDistributionAmount() != null) setDistributionAmount(b.getDistributionAmount());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getUpdateTime() != null) setUpdateTime(b.getUpdateTime());
	}

	@Override
	public BaseContractReceivableLinkPlate generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseContractReceivableLinkPlate b = new BaseContractReceivableLinkPlate();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseContractReceivableLinkPlate __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractReceivableLinkPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractReceivableId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDistributionAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setContractReceivableLinkPlateId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getContractReceivableLinkPlateId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setContractReceivableLinkPlateIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setContractReceivableId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getContractReceivableId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setTotalAmount(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getTotalAmount() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setDistributionAmount(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getDistributionAmount() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setUpdateTime(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateTime() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setConditionContractReceivableLinkPlateId(String op, java.lang.Integer val) {
		setConditionContractReceivableLinkPlateId(op, val, CONDITION_AND);
	}

	public void setConditionContractReceivableLinkPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectContractReceivableLinkPlateId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionContractReceivableId(String op, java.lang.Integer val) {
		setConditionContractReceivableId(op, val, CONDITION_AND);
	}

	public void setConditionContractReceivableId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectContractReceivableId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionTotalAmount(String op, java.math.BigDecimal val) {
		setConditionTotalAmount(op, val, CONDITION_AND);
	}

	public void setConditionTotalAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectTotalAmount(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionDistributionAmount(String op, java.math.BigDecimal val) {
		setConditionDistributionAmount(op, val, CONDITION_AND);
	}

	public void setConditionDistributionAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectDistributionAmount(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionUpdateTime(String op, java.util.Date val) {
		setConditionUpdateTime(op, val, CONDITION_AND);
	}

	public void setConditionUpdateTime(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUpdateTime(boolean val) {
		__select_flags[7] = val;
	}


}

