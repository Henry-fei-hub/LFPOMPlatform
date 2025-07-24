package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseMarketingCommission;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class MarketingCommission extends AbstractTable<BaseMarketingCommission>
{

	public MarketingCommission() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 15;

		initTables();

		__tableName            = "marketing_commissions";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseMarketingCommission.CS_MARKETING_COMMISSION_ID;
		__column_names[1] = BaseMarketingCommission.CS_CONTRACT_ID;
		__column_names[2] = BaseMarketingCommission.CS_PROJECT_ID;
		__column_names[3] = BaseMarketingCommission.CS_COMMISSIONS;
		__column_names[4] = BaseMarketingCommission.CS_COMMISSIONS_RATE;
		__column_names[5] = BaseMarketingCommission.CS_CUMULATIVE_REVENUE;
		__column_names[6] = BaseMarketingCommission.CS_DAY_REVENUE;
		__column_names[7] = BaseMarketingCommission.CS_PLATE_ID;
		__column_names[8] = BaseMarketingCommission.CS_SETTLEMENT_IDENTIFIER;
		__column_names[9] = BaseMarketingCommission.CS_REAL_PROGRESS;
		__column_names[10] = BaseMarketingCommission.CS_RELATIVELY_PROGRESS;
		__column_names[11] = BaseMarketingCommission.CS_INCOME;
		__column_names[12] = BaseMarketingCommission.CS_PROJECT_AMOUNT;
		__column_names[13] = BaseMarketingCommission.CS_BUSINESS_TYPE;
		__column_names[14] = BaseMarketingCommission.CS_TOTAL_INCOME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseMarketingCommission b) {
		clear();
		setMarketingCommissionIdClear(b.getMarketingCommissionId());
	}

	public boolean isPrimaryKeyNull() {
		return getMarketingCommissionId() == null;
	}

	@Override
	public BaseMarketingCommission generateBase(){
		BaseMarketingCommission b = new BaseMarketingCommission();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseMarketingCommission b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setMarketingCommissionId(GenericBase.__getShort(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCommissions(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCommissionsRate(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCumulativeRevenue(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setDayRevenue(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSettlementIdentifier(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRealProgress(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRelativelyProgress(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setIncome(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setBusinessType(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTotalIncome(GenericBase.__getDecimal(val));
	}

	@Override
	public void setBaseToBuffer(BaseMarketingCommission b, Object[] buff){
		int count = 0;
		buff[count++] = b.getMarketingCommissionId();
		buff[count++] = b.getContractId();
		buff[count++] = b.getProjectId();
		buff[count++] = generateTimestampFromDate(b.getCommissions());
		buff[count++] = b.getCommissionsRate();
		buff[count++] = b.getCumulativeRevenue();
		buff[count++] = b.getDayRevenue();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getSettlementIdentifier();
		buff[count++] = b.getRealProgress();
		buff[count++] = b.getRelativelyProgress();
		buff[count++] = b.getIncome();
		buff[count++] = b.getProjectAmount();
		buff[count++] = b.getBusinessType();
		buff[count++] = b.getTotalIncome();
	}

	@Override
	public void setDataFromBase(BaseMarketingCommission b){
		if(b.getMarketingCommissionId() != null) setMarketingCommissionIdClear(b.getMarketingCommissionId());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getCommissions() != null) setCommissions(b.getCommissions());
		if(b.getCommissionsRate() != null) setCommissionsRate(b.getCommissionsRate());
		if(b.getCumulativeRevenue() != null) setCumulativeRevenue(b.getCumulativeRevenue());
		if(b.getDayRevenue() != null) setDayRevenue(b.getDayRevenue());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getSettlementIdentifier() != null) setSettlementIdentifier(b.getSettlementIdentifier());
		if(b.getRealProgress() != null) setRealProgress(b.getRealProgress());
		if(b.getRelativelyProgress() != null) setRelativelyProgress(b.getRelativelyProgress());
		if(b.getIncome() != null) setIncome(b.getIncome());
		if(b.getProjectAmount() != null) setProjectAmount(b.getProjectAmount());
		if(b.getBusinessType() != null) setBusinessType(b.getBusinessType());
		if(b.getTotalIncome() != null) setTotalIncome(b.getTotalIncome());
	}

	@Override
	public BaseMarketingCommission generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseMarketingCommission b = new BaseMarketingCommission();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseMarketingCommission __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMarketingCommissionId(GenericBase.__getShort(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCommissions(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCommissionsRate(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCumulativeRevenue(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDayRevenue(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSettlementIdentifier(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRealProgress(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRelativelyProgress(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIncome(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessType(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalIncome(GenericBase.__getDecimal(val));
	}

	public void setMarketingCommissionId(java.lang.Short val) {
		setCurrentData(0, val);
	}

	public java.lang.Short getMarketingCommissionId() {
		return GenericBase.__getShort(__current_data[0]);
	}

	public void setMarketingCommissionIdClear(java.lang.Short val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setCommissions(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getCommissions() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setCommissionsRate(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getCommissionsRate() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setCumulativeRevenue(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getCumulativeRevenue() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setDayRevenue(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getDayRevenue() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setSettlementIdentifier(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getSettlementIdentifier() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setRealProgress(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getRealProgress() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setRelativelyProgress(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getRelativelyProgress() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setIncome(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getIncome() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setProjectAmount(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getProjectAmount() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setBusinessType(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getBusinessType() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setTotalIncome(java.math.BigDecimal val) {
		setCurrentData(14, val);
	}

	public java.math.BigDecimal getTotalIncome() {
		return GenericBase.__getDecimal(__current_data[14]);
	}

	public void setConditionMarketingCommissionId(String op, java.lang.Short val) {
		setConditionMarketingCommissionId(op, val, CONDITION_AND);
	}

	public void setConditionMarketingCommissionId(String op, java.lang.Short val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectMarketingCommissionId(boolean val) {
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

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionCommissions(String op, java.util.Date val) {
		setConditionCommissions(op, val, CONDITION_AND);
	}

	public void setConditionCommissions(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCommissions(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCommissionsRate(String op, java.math.BigDecimal val) {
		setConditionCommissionsRate(op, val, CONDITION_AND);
	}

	public void setConditionCommissionsRate(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCommissionsRate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCumulativeRevenue(String op, java.math.BigDecimal val) {
		setConditionCumulativeRevenue(op, val, CONDITION_AND);
	}

	public void setConditionCumulativeRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectCumulativeRevenue(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionDayRevenue(String op, java.math.BigDecimal val) {
		setConditionDayRevenue(op, val, CONDITION_AND);
	}

	public void setConditionDayRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectDayRevenue(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionSettlementIdentifier(String op, java.lang.Integer val) {
		setConditionSettlementIdentifier(op, val, CONDITION_AND);
	}

	public void setConditionSettlementIdentifier(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectSettlementIdentifier(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionRealProgress(String op, java.math.BigDecimal val) {
		setConditionRealProgress(op, val, CONDITION_AND);
	}

	public void setConditionRealProgress(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectRealProgress(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionRelativelyProgress(String op, java.math.BigDecimal val) {
		setConditionRelativelyProgress(op, val, CONDITION_AND);
	}

	public void setConditionRelativelyProgress(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectRelativelyProgress(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionIncome(String op, java.math.BigDecimal val) {
		setConditionIncome(op, val, CONDITION_AND);
	}

	public void setConditionIncome(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectIncome(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionProjectAmount(String op, java.math.BigDecimal val) {
		setConditionProjectAmount(op, val, CONDITION_AND);
	}

	public void setConditionProjectAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectProjectAmount(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionBusinessType(String op, java.lang.String val) {
		setConditionBusinessType(op, val, CONDITION_AND);
	}

	public void setConditionBusinessType(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectBusinessType(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionTotalIncome(String op, java.math.BigDecimal val) {
		setConditionTotalIncome(op, val, CONDITION_AND);
	}

	public void setConditionTotalIncome(String op, java.math.BigDecimal val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectTotalIncome(boolean val) {
		__select_flags[14] = val;
	}


}

