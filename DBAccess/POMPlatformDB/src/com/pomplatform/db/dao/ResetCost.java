package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseResetCost;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ResetCost extends AbstractTable<BaseResetCost>
{

	public ResetCost() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 18;

		initTables();

		__tableName            = "reset_costs";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseResetCost.CS_RESET_COST_ID;
		__column_names[1] = BaseResetCost.CS_ID;
		__column_names[2] = BaseResetCost.CS_CODE;
		__column_names[3] = BaseResetCost.CS_NAME;
		__column_names[4] = BaseResetCost.CS_COST;
		__column_names[5] = BaseResetCost.CS_COST_TYPE;
		__column_names[6] = BaseResetCost.CS_LINK_ID;
		__column_names[7] = BaseResetCost.CS_PROCESS_TYPE;
		__column_names[8] = BaseResetCost.CS_BUSINESS_ID;
		__column_names[9] = BaseResetCost.CS_PROCESS_ID;
		__column_names[10] = BaseResetCost.CS_PROCESS_INSTANCE_ID;
		__column_names[11] = BaseResetCost.CS_DRAFTER;
		__column_names[12] = BaseResetCost.CS_REASON;
		__column_names[13] = BaseResetCost.CS_CREATE_TIME;
		__column_names[14] = BaseResetCost.CS_DELETE_FLAG;
		__column_names[15] = BaseResetCost.CS_PLATE_ID;
		__column_names[16] = BaseResetCost.CS_CURRENCY;
		__column_names[17] = BaseResetCost.CS_EXCHANGE_RATE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseResetCost b) {
		clear();
		setResetCostIdClear(b.getResetCostId());
	}

	public boolean isPrimaryKeyNull() {
		return getResetCostId() == null;
	}

	@Override
	public BaseResetCost generateBase(){
		BaseResetCost b = new BaseResetCost();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseResetCost b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setResetCostId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCost(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCostType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLinkId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDrafter(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReason(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCurrency(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setExchangeRate(GenericBase.__getDecimal(val));
	}

	@Override
	public void setBaseToBuffer(BaseResetCost b, Object[] buff){
		int count = 0;
		buff[count++] = b.getResetCostId();
		buff[count++] = b.getId();
		buff[count++] = b.getCode();
		buff[count++] = b.getName();
		buff[count++] = b.getCost();
		buff[count++] = b.getCostType();
		buff[count++] = b.getLinkId();
		buff[count++] = b.getProcessType();
		buff[count++] = b.getBusinessId();
		buff[count++] = b.getProcessId();
		buff[count++] = b.getProcessInstanceId();
		buff[count++] = b.getDrafter();
		buff[count++] = b.getReason();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getDeleteFlag();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getCurrency();
		buff[count++] = b.getExchangeRate();
	}

	@Override
	public void setDataFromBase(BaseResetCost b){
		if(b.getResetCostId() != null) setResetCostIdClear(b.getResetCostId());
		if(b.getId() != null) setId(b.getId());
		if(b.getCode() != null) setCode(b.getCode());
		if(b.getName() != null) setName(b.getName());
		if(b.getCost() != null) setCost(b.getCost());
		if(b.getCostType() != null) setCostType(b.getCostType());
		if(b.getLinkId() != null) setLinkId(b.getLinkId());
		if(b.getProcessType() != null) setProcessType(b.getProcessType());
		if(b.getBusinessId() != null) setBusinessId(b.getBusinessId());
		if(b.getProcessId() != null) setProcessId(b.getProcessId());
		if(b.getProcessInstanceId() != null) setProcessInstanceId(b.getProcessInstanceId());
		if(b.getDrafter() != null) setDrafter(b.getDrafter());
		if(b.getReason() != null) setReason(b.getReason());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getCurrency() != null) setCurrency(b.getCurrency());
		if(b.getExchangeRate() != null) setExchangeRate(b.getExchangeRate());
	}

	@Override
	public BaseResetCost generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseResetCost b = new BaseResetCost();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseResetCost __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setResetCostId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCost(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCostType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLinkId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDrafter(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReason(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCurrency(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setExchangeRate(GenericBase.__getDecimal(val));
	}

	public void setResetCostId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getResetCostId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setResetCostIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setCost(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getCost() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setCostType(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getCostType() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setLinkId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getLinkId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setProcessType(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getProcessType() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setBusinessId(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getBusinessId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setProcessId(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getProcessId() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setProcessInstanceId(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getProcessInstanceId() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setDrafter(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getDrafter() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setReason(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getReason() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(13, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[13]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setCurrency(java.lang.Integer val) {
		setCurrentData(16, val);
	}

	public java.lang.Integer getCurrency() {
		return GenericBase.__getInt(__current_data[16]);
	}

	public void setExchangeRate(java.math.BigDecimal val) {
		setCurrentData(17, val);
	}

	public java.math.BigDecimal getExchangeRate() {
		return GenericBase.__getDecimal(__current_data[17]);
	}

	public void setConditionResetCostId(String op, java.lang.Integer val) {
		setConditionResetCostId(op, val, CONDITION_AND);
	}

	public void setConditionResetCostId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectResetCostId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionId(String op, java.lang.Integer val) {
		setConditionId(op, val, CONDITION_AND);
	}

	public void setConditionId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionCode(String op, java.lang.String val) {
		setConditionCode(op, val, CONDITION_AND);
	}

	public void setConditionCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionName(String op, java.lang.String val) {
		setConditionName(op, val, CONDITION_AND);
	}

	public void setConditionName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectName(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCost(String op, java.math.BigDecimal val) {
		setConditionCost(op, val, CONDITION_AND);
	}

	public void setConditionCost(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCost(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCostType(String op, java.lang.Integer val) {
		setConditionCostType(op, val, CONDITION_AND);
	}

	public void setConditionCostType(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectCostType(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionLinkId(String op, java.lang.Integer val) {
		setConditionLinkId(op, val, CONDITION_AND);
	}

	public void setConditionLinkId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectLinkId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionProcessType(String op, java.lang.Integer val) {
		setConditionProcessType(op, val, CONDITION_AND);
	}

	public void setConditionProcessType(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectProcessType(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionBusinessId(String op, java.lang.Integer val) {
		setConditionBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectBusinessId(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionProcessId(String op, java.lang.Integer val) {
		setConditionProcessId(op, val, CONDITION_AND);
	}

	public void setConditionProcessId(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectProcessId(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionProcessInstanceId(String op, java.lang.Integer val) {
		setConditionProcessInstanceId(op, val, CONDITION_AND);
	}

	public void setConditionProcessInstanceId(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectProcessInstanceId(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionDrafter(String op, java.lang.Integer val) {
		setConditionDrafter(op, val, CONDITION_AND);
	}

	public void setConditionDrafter(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectDrafter(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionReason(String op, java.lang.String val) {
		setConditionReason(op, val, CONDITION_AND);
	}

	public void setConditionReason(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectReason(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(13, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionCurrency(String op, java.lang.Integer val) {
		setConditionCurrency(op, val, CONDITION_AND);
	}

	public void setConditionCurrency(String op, java.lang.Integer val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectCurrency(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionExchangeRate(String op, java.math.BigDecimal val) {
		setConditionExchangeRate(op, val, CONDITION_AND);
	}

	public void setConditionExchangeRate(String op, java.math.BigDecimal val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectExchangeRate(boolean val) {
		__select_flags[17] = val;
	}


}

