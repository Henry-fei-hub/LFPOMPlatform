package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseDesignConsiderationHistory;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class DesignConsiderationHistory extends AbstractTable<BaseDesignConsiderationHistory>
{

	public DesignConsiderationHistory() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 22;

		initTables();

		__tableName            = "design_consideration_historys";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseDesignConsiderationHistory.CS_DESIGN_CONSIDERATION_HISTORY_ID;
		__column_names[1] = BaseDesignConsiderationHistory.CS_HISTORY_STATUS;
		__column_names[2] = BaseDesignConsiderationHistory.CS_INFO_CODE;
		__column_names[3] = BaseDesignConsiderationHistory.CS_PROJECT_CODE;
		__column_names[4] = BaseDesignConsiderationHistory.CS_BUSINESS_TYPE;
		__column_names[5] = BaseDesignConsiderationHistory.CS_PROJECT_TYPE;
		__column_names[6] = BaseDesignConsiderationHistory.CS_MAIN_DESIGN_AREA_NAME;
		__column_names[7] = BaseDesignConsiderationHistory.CS_DECORATION_STATUS;
		__column_names[8] = BaseDesignConsiderationHistory.CS_DESIGN_AREA;
		__column_names[9] = BaseDesignConsiderationHistory.CS_DESIGN_UNIT_PRICE;
		__column_names[10] = BaseDesignConsiderationHistory.CS_MONEY_SUM;
		__column_names[11] = BaseDesignConsiderationHistory.CS_SUB_CONTRACT_ID;
		__column_names[12] = BaseDesignConsiderationHistory.CS_JOB_MIX;
		__column_names[13] = BaseDesignConsiderationHistory.CS_SERVICE_AREA;
		__column_names[14] = BaseDesignConsiderationHistory.CS_WITH_THE_AMOUNT;
		__column_names[15] = BaseDesignConsiderationHistory.CS_ON_SITE_TIME;
		__column_names[16] = BaseDesignConsiderationHistory.CS_ON_SITE_PRICE;
		__column_names[17] = BaseDesignConsiderationHistory.CS_ON_SITE_TOTAL_MONEY;
		__column_names[18] = BaseDesignConsiderationHistory.CS_CREATE_TIME;
		__column_names[19] = BaseDesignConsiderationHistory.CS_MOVE_TIME;
		__column_names[20] = BaseDesignConsiderationHistory.CS_ORDER_NO;
		__column_names[21] = BaseDesignConsiderationHistory.CS_HISTORY_VERSION;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseDesignConsiderationHistory b) {
		clear();
		setDesignConsiderationHistoryIdClear(b.getDesignConsiderationHistoryId());
	}

	public boolean isPrimaryKeyNull() {
		return getDesignConsiderationHistoryId() == null;
	}

	@Override
	public BaseDesignConsiderationHistory generateBase(){
		BaseDesignConsiderationHistory b = new BaseDesignConsiderationHistory();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseDesignConsiderationHistory b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setDesignConsiderationHistoryId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setHistoryStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInfoCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBusinessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMainDesignAreaName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDecorationStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDesignArea(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setDesignUnitPrice(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMoneySum(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSubContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setJobMix(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setServiceArea(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setWithTheAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOnSiteTime(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOnSitePrice(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOnSiteTotalMoney(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setMoveTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOrderNo(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setHistoryVersion(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseDesignConsiderationHistory b, Object[] buff){
		int count = 0;
		buff[count++] = b.getDesignConsiderationHistoryId();
		buff[count++] = b.getHistoryStatus();
		buff[count++] = b.getInfoCode();
		buff[count++] = b.getProjectCode();
		buff[count++] = b.getBusinessType();
		buff[count++] = b.getProjectType();
		buff[count++] = b.getMainDesignAreaName();
		buff[count++] = b.getDecorationStatus();
		buff[count++] = b.getDesignArea();
		buff[count++] = b.getDesignUnitPrice();
		buff[count++] = b.getMoneySum();
		buff[count++] = b.getSubContractId();
		buff[count++] = b.getJobMix();
		buff[count++] = b.getServiceArea();
		buff[count++] = b.getWithTheAmount();
		buff[count++] = b.getOnSiteTime();
		buff[count++] = b.getOnSitePrice();
		buff[count++] = b.getOnSiteTotalMoney();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = generateTimestampFromDate(b.getMoveTime());
		buff[count++] = b.getOrderNo();
		buff[count++] = b.getHistoryVersion();
	}

	@Override
	public void setDataFromBase(BaseDesignConsiderationHistory b){
		if(b.getDesignConsiderationHistoryId() != null) setDesignConsiderationHistoryIdClear(b.getDesignConsiderationHistoryId());
		if(b.getHistoryStatus() != null) setHistoryStatus(b.getHistoryStatus());
		if(b.getInfoCode() != null) setInfoCode(b.getInfoCode());
		if(b.getProjectCode() != null) setProjectCode(b.getProjectCode());
		if(b.getBusinessType() != null) setBusinessType(b.getBusinessType());
		if(b.getProjectType() != null) setProjectType(b.getProjectType());
		if(b.getMainDesignAreaName() != null) setMainDesignAreaName(b.getMainDesignAreaName());
		if(b.getDecorationStatus() != null) setDecorationStatus(b.getDecorationStatus());
		if(b.getDesignArea() != null) setDesignArea(b.getDesignArea());
		if(b.getDesignUnitPrice() != null) setDesignUnitPrice(b.getDesignUnitPrice());
		if(b.getMoneySum() != null) setMoneySum(b.getMoneySum());
		if(b.getSubContractId() != null) setSubContractId(b.getSubContractId());
		if(b.getJobMix() != null) setJobMix(b.getJobMix());
		if(b.getServiceArea() != null) setServiceArea(b.getServiceArea());
		if(b.getWithTheAmount() != null) setWithTheAmount(b.getWithTheAmount());
		if(b.getOnSiteTime() != null) setOnSiteTime(b.getOnSiteTime());
		if(b.getOnSitePrice() != null) setOnSitePrice(b.getOnSitePrice());
		if(b.getOnSiteTotalMoney() != null) setOnSiteTotalMoney(b.getOnSiteTotalMoney());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getMoveTime() != null) setMoveTime(b.getMoveTime());
		if(b.getOrderNo() != null) setOrderNo(b.getOrderNo());
		if(b.getHistoryVersion() != null) setHistoryVersion(b.getHistoryVersion());
	}

	@Override
	public BaseDesignConsiderationHistory generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseDesignConsiderationHistory b = new BaseDesignConsiderationHistory();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseDesignConsiderationHistory __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignConsiderationHistoryId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHistoryStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInfoCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainDesignAreaName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDecorationStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignArea(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignUnitPrice(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMoneySum(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setJobMix(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setServiceArea(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWithTheAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOnSiteTime(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOnSitePrice(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOnSiteTotalMoney(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMoveTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderNo(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHistoryVersion(GenericBase.__getInt(val));
	}

	public void setDesignConsiderationHistoryId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getDesignConsiderationHistoryId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setDesignConsiderationHistoryIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setHistoryStatus(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getHistoryStatus() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setInfoCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getInfoCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setProjectCode(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getProjectCode() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setBusinessType(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getBusinessType() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setProjectType(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getProjectType() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setMainDesignAreaName(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getMainDesignAreaName() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setDecorationStatus(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getDecorationStatus() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setDesignArea(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getDesignArea() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setDesignUnitPrice(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getDesignUnitPrice() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setMoneySum(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getMoneySum() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setSubContractId(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getSubContractId() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setJobMix(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getJobMix() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setServiceArea(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getServiceArea() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setWithTheAmount(java.math.BigDecimal val) {
		setCurrentData(14, val);
	}

	public java.math.BigDecimal getWithTheAmount() {
		return GenericBase.__getDecimal(__current_data[14]);
	}

	public void setOnSiteTime(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getOnSiteTime() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setOnSitePrice(java.math.BigDecimal val) {
		setCurrentData(16, val);
	}

	public java.math.BigDecimal getOnSitePrice() {
		return GenericBase.__getDecimal(__current_data[16]);
	}

	public void setOnSiteTotalMoney(java.math.BigDecimal val) {
		setCurrentData(17, val);
	}

	public java.math.BigDecimal getOnSiteTotalMoney() {
		return GenericBase.__getDecimal(__current_data[17]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(18, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[18]);
	}

	public void setMoveTime(java.util.Date val) {
		setCurrentData(19, generateTimestampFromDate(val));
	}

	public java.util.Date getMoveTime() {
		return GenericBase.__getDateFromSQL(__current_data[19]);
	}

	public void setOrderNo(java.lang.Integer val) {
		setCurrentData(20, val);
	}

	public java.lang.Integer getOrderNo() {
		return GenericBase.__getInt(__current_data[20]);
	}

	public void setHistoryVersion(java.lang.Integer val) {
		setCurrentData(21, val);
	}

	public java.lang.Integer getHistoryVersion() {
		return GenericBase.__getInt(__current_data[21]);
	}

	public void setConditionDesignConsiderationHistoryId(String op, java.lang.Integer val) {
		setConditionDesignConsiderationHistoryId(op, val, CONDITION_AND);
	}

	public void setConditionDesignConsiderationHistoryId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectDesignConsiderationHistoryId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionHistoryStatus(String op, java.lang.Integer val) {
		setConditionHistoryStatus(op, val, CONDITION_AND);
	}

	public void setConditionHistoryStatus(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectHistoryStatus(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionInfoCode(String op, java.lang.String val) {
		setConditionInfoCode(op, val, CONDITION_AND);
	}

	public void setConditionInfoCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectInfoCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionProjectCode(String op, java.lang.String val) {
		setConditionProjectCode(op, val, CONDITION_AND);
	}

	public void setConditionProjectCode(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectProjectCode(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionBusinessType(String op, java.lang.Integer val) {
		setConditionBusinessType(op, val, CONDITION_AND);
	}

	public void setConditionBusinessType(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectBusinessType(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionProjectType(String op, java.lang.Integer val) {
		setConditionProjectType(op, val, CONDITION_AND);
	}

	public void setConditionProjectType(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectProjectType(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionMainDesignAreaName(String op, java.lang.String val) {
		setConditionMainDesignAreaName(op, val, CONDITION_AND);
	}

	public void setConditionMainDesignAreaName(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectMainDesignAreaName(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionDecorationStatus(String op, java.lang.Integer val) {
		setConditionDecorationStatus(op, val, CONDITION_AND);
	}

	public void setConditionDecorationStatus(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectDecorationStatus(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionDesignArea(String op, java.math.BigDecimal val) {
		setConditionDesignArea(op, val, CONDITION_AND);
	}

	public void setConditionDesignArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectDesignArea(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionDesignUnitPrice(String op, java.math.BigDecimal val) {
		setConditionDesignUnitPrice(op, val, CONDITION_AND);
	}

	public void setConditionDesignUnitPrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectDesignUnitPrice(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionMoneySum(String op, java.math.BigDecimal val) {
		setConditionMoneySum(op, val, CONDITION_AND);
	}

	public void setConditionMoneySum(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectMoneySum(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionSubContractId(String op, java.lang.Integer val) {
		setConditionSubContractId(op, val, CONDITION_AND);
	}

	public void setConditionSubContractId(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectSubContractId(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionJobMix(String op, java.lang.Integer val) {
		setConditionJobMix(op, val, CONDITION_AND);
	}

	public void setConditionJobMix(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectJobMix(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionServiceArea(String op, java.math.BigDecimal val) {
		setConditionServiceArea(op, val, CONDITION_AND);
	}

	public void setConditionServiceArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectServiceArea(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionWithTheAmount(String op, java.math.BigDecimal val) {
		setConditionWithTheAmount(op, val, CONDITION_AND);
	}

	public void setConditionWithTheAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectWithTheAmount(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionOnSiteTime(String op, java.lang.Integer val) {
		setConditionOnSiteTime(op, val, CONDITION_AND);
	}

	public void setConditionOnSiteTime(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectOnSiteTime(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionOnSitePrice(String op, java.math.BigDecimal val) {
		setConditionOnSitePrice(op, val, CONDITION_AND);
	}

	public void setConditionOnSitePrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectOnSitePrice(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionOnSiteTotalMoney(String op, java.math.BigDecimal val) {
		setConditionOnSiteTotalMoney(op, val, CONDITION_AND);
	}

	public void setConditionOnSiteTotalMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectOnSiteTotalMoney(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(18, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionMoveTime(String op, java.util.Date val) {
		setConditionMoveTime(op, val, CONDITION_AND);
	}

	public void setConditionMoveTime(String op, java.util.Date val, String relation) {
		addCondition(19, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectMoveTime(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionOrderNo(String op, java.lang.Integer val) {
		setConditionOrderNo(op, val, CONDITION_AND);
	}

	public void setConditionOrderNo(String op, java.lang.Integer val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectOrderNo(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionHistoryVersion(String op, java.lang.Integer val) {
		setConditionHistoryVersion(op, val, CONDITION_AND);
	}

	public void setConditionHistoryVersion(String op, java.lang.Integer val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectHistoryVersion(boolean val) {
		__select_flags[21] = val;
	}


}

