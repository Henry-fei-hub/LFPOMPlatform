package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCapitalDistributionLinkSubContract;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CapitalDistributionLinkSubContract extends AbstractTable<BaseCapitalDistributionLinkSubContract>
{

	public CapitalDistributionLinkSubContract() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "capital_distribution_link_sub_contracts";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCapitalDistributionLinkSubContract.CS_CAPITAL_DISTRIBUTION_LINK_SUB_CONTRACT_ID;
		__column_names[1] = BaseCapitalDistributionLinkSubContract.CS_CAPITAL_DISTRIBUTION_ID;
		__column_names[2] = BaseCapitalDistributionLinkSubContract.CS_SUB_CONTRACT_ID;
		__column_names[3] = BaseCapitalDistributionLinkSubContract.CS_MONEY;
		__column_names[4] = BaseCapitalDistributionLinkSubContract.CS_CAPITAL_ID;
		__column_names[5] = BaseCapitalDistributionLinkSubContract.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCapitalDistributionLinkSubContract b) {
		clear();
		setCapitalDistributionLinkSubContractIdClear(b.getCapitalDistributionLinkSubContractId());
	}

	public boolean isPrimaryKeyNull() {
		return getCapitalDistributionLinkSubContractId() == null;
	}

	@Override
	public BaseCapitalDistributionLinkSubContract generateBase(){
		BaseCapitalDistributionLinkSubContract b = new BaseCapitalDistributionLinkSubContract();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCapitalDistributionLinkSubContract b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCapitalDistributionLinkSubContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCapitalDistributionId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSubContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMoney(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCapitalId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseCapitalDistributionLinkSubContract b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCapitalDistributionLinkSubContractId();
		buff[count++] = b.getCapitalDistributionId();
		buff[count++] = b.getSubContractId();
		buff[count++] = b.getMoney();
		buff[count++] = b.getCapitalId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BaseCapitalDistributionLinkSubContract b){
		if(b.getCapitalDistributionLinkSubContractId() != null) setCapitalDistributionLinkSubContractIdClear(b.getCapitalDistributionLinkSubContractId());
		if(b.getCapitalDistributionId() != null) setCapitalDistributionId(b.getCapitalDistributionId());
		if(b.getSubContractId() != null) setSubContractId(b.getSubContractId());
		if(b.getMoney() != null) setMoney(b.getMoney());
		if(b.getCapitalId() != null) setCapitalId(b.getCapitalId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BaseCapitalDistributionLinkSubContract generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCapitalDistributionLinkSubContract b = new BaseCapitalDistributionLinkSubContract();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCapitalDistributionLinkSubContract __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCapitalDistributionLinkSubContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCapitalDistributionId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMoney(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCapitalId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setCapitalDistributionLinkSubContractId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCapitalDistributionLinkSubContractId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCapitalDistributionLinkSubContractIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCapitalDistributionId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getCapitalDistributionId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setSubContractId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getSubContractId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setMoney(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getMoney() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setCapitalId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getCapitalId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setConditionCapitalDistributionLinkSubContractId(String op, java.lang.Integer val) {
		setConditionCapitalDistributionLinkSubContractId(op, val, CONDITION_AND);
	}

	public void setConditionCapitalDistributionLinkSubContractId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCapitalDistributionLinkSubContractId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCapitalDistributionId(String op, java.lang.Integer val) {
		setConditionCapitalDistributionId(op, val, CONDITION_AND);
	}

	public void setConditionCapitalDistributionId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCapitalDistributionId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionSubContractId(String op, java.lang.Integer val) {
		setConditionSubContractId(op, val, CONDITION_AND);
	}

	public void setConditionSubContractId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectSubContractId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionMoney(String op, java.math.BigDecimal val) {
		setConditionMoney(op, val, CONDITION_AND);
	}

	public void setConditionMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectMoney(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCapitalId(String op, java.lang.Integer val) {
		setConditionCapitalId(op, val, CONDITION_AND);
	}

	public void setConditionCapitalId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCapitalId(boolean val) {
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

