package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseMarketingCommissionDetail;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class MarketingCommissionDetail extends AbstractTable<BaseMarketingCommissionDetail>
{

	public MarketingCommissionDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "marketing_commission_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseMarketingCommissionDetail.CS_MARKETING_COMMISSION_DETAIL_ID;
		__column_names[1] = BaseMarketingCommissionDetail.CS_MARKETING_COMMISSION_ID;
		__column_names[2] = BaseMarketingCommissionDetail.CS_USER_ID;
		__column_names[3] = BaseMarketingCommissionDetail.CS_CONTRACT_ID;
		__column_names[4] = BaseMarketingCommissionDetail.CS_PROJECT_ID;
		__column_names[5] = BaseMarketingCommissionDetail.CS_REVENUE;
		__column_names[6] = BaseMarketingCommissionDetail.CS_COMMISSION_DATE;
		__column_names[7] = BaseMarketingCommissionDetail.CS_TYPE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseMarketingCommissionDetail b) {
		clear();
		setMarketingCommissionDetailIdClear(b.getMarketingCommissionDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getMarketingCommissionDetailId() == null;
	}

	@Override
	public BaseMarketingCommissionDetail generateBase(){
		BaseMarketingCommissionDetail b = new BaseMarketingCommissionDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseMarketingCommissionDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setMarketingCommissionDetailId(GenericBase.__getShort(val));
		if((val = __current_data[count++]) != null) b.setMarketingCommissionId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setUserId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRevenue(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCommissionDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setType(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseMarketingCommissionDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getMarketingCommissionDetailId();
		buff[count++] = b.getMarketingCommissionId();
		buff[count++] = b.getUserId();
		buff[count++] = b.getContractId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getRevenue();
		buff[count++] = generateTimestampFromDate(b.getCommissionDate());
		buff[count++] = b.getType();
	}

	@Override
	public void setDataFromBase(BaseMarketingCommissionDetail b){
		if(b.getMarketingCommissionDetailId() != null) setMarketingCommissionDetailIdClear(b.getMarketingCommissionDetailId());
		if(b.getMarketingCommissionId() != null) setMarketingCommissionId(b.getMarketingCommissionId());
		if(b.getUserId() != null) setUserId(b.getUserId());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getRevenue() != null) setRevenue(b.getRevenue());
		if(b.getCommissionDate() != null) setCommissionDate(b.getCommissionDate());
		if(b.getType() != null) setType(b.getType());
	}

	@Override
	public BaseMarketingCommissionDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseMarketingCommissionDetail b = new BaseMarketingCommissionDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseMarketingCommissionDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMarketingCommissionDetailId(GenericBase.__getShort(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMarketingCommissionId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUserId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRevenue(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCommissionDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setType(GenericBase.__getInt(val));
	}

	public void setMarketingCommissionDetailId(java.lang.Short val) {
		setCurrentData(0, val);
	}

	public java.lang.Short getMarketingCommissionDetailId() {
		return GenericBase.__getShort(__current_data[0]);
	}

	public void setMarketingCommissionDetailIdClear(java.lang.Short val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setMarketingCommissionId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getMarketingCommissionId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setUserId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getUserId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setRevenue(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getRevenue() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setCommissionDate(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getCommissionDate() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setType(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getType() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setConditionMarketingCommissionDetailId(String op, java.lang.Short val) {
		setConditionMarketingCommissionDetailId(op, val, CONDITION_AND);
	}

	public void setConditionMarketingCommissionDetailId(String op, java.lang.Short val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectMarketingCommissionDetailId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionMarketingCommissionId(String op, java.lang.Integer val) {
		setConditionMarketingCommissionId(op, val, CONDITION_AND);
	}

	public void setConditionMarketingCommissionId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectMarketingCommissionId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionUserId(String op, java.lang.Integer val) {
		setConditionUserId(op, val, CONDITION_AND);
	}

	public void setConditionUserId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectUserId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionRevenue(String op, java.math.BigDecimal val) {
		setConditionRevenue(op, val, CONDITION_AND);
	}

	public void setConditionRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectRevenue(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionCommissionDate(String op, java.util.Date val) {
		setConditionCommissionDate(op, val, CONDITION_AND);
	}

	public void setConditionCommissionDate(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCommissionDate(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionType(String op, java.lang.Integer val) {
		setConditionType(op, val, CONDITION_AND);
	}

	public void setConditionType(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectType(boolean val) {
		__select_flags[7] = val;
	}


}

