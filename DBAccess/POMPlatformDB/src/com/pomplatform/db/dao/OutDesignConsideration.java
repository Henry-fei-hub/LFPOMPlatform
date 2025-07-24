package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseOutDesignConsideration;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class OutDesignConsideration extends AbstractTable<BaseOutDesignConsideration>
{

	public OutDesignConsideration() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 33;

		initTables();

		__tableName            = "out_design_considerations";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseOutDesignConsideration.CS_OUT_DESIGN_CONSIDERATION_ID;
		__column_names[1] = BaseOutDesignConsideration.CS_INFO_CODE;
		__column_names[2] = BaseOutDesignConsideration.CS_PROJECT_CODE;
		__column_names[3] = BaseOutDesignConsideration.CS_BUSINESS_TYPE;
		__column_names[4] = BaseOutDesignConsideration.CS_PROJECT_TYPE;
		__column_names[5] = BaseOutDesignConsideration.CS_MAIN_DESIGN_AREA_NAME;
		__column_names[6] = BaseOutDesignConsideration.CS_DECORATION_STATUS;
		__column_names[7] = BaseOutDesignConsideration.CS_DESIGN_AREA;
		__column_names[8] = BaseOutDesignConsideration.CS_DESIGN_UNIT_PRICE;
		__column_names[9] = BaseOutDesignConsideration.CS_MONEY_SUM;
		__column_names[10] = BaseOutDesignConsideration.CS_SUB_CONTRACT_ID;
		__column_names[11] = BaseOutDesignConsideration.CS_JOB_MIX;
		__column_names[12] = BaseOutDesignConsideration.CS_SERVICE_AREA;
		__column_names[13] = BaseOutDesignConsideration.CS_WITH_THE_AMOUNT;
		__column_names[14] = BaseOutDesignConsideration.CS_ON_SITE_TIME;
		__column_names[15] = BaseOutDesignConsideration.CS_ON_SITE_PRICE;
		__column_names[16] = BaseOutDesignConsideration.CS_ON_SITE_TOTAL_MONEY;
		__column_names[17] = BaseOutDesignConsideration.CS_CREATE_TIME;
		__column_names[18] = BaseOutDesignConsideration.CS_UPDATE_TIME;
		__column_names[19] = BaseOutDesignConsideration.CS_ORDER_NO;
		__column_names[20] = BaseOutDesignConsideration.CS_DISABLE_TYPE;
		__column_names[21] = BaseOutDesignConsideration.CS_OUT_QUOTATION_ID;
		__column_names[22] = BaseOutDesignConsideration.CS_REMARK;
		__column_names[23] = BaseOutDesignConsideration.CS_INTERIOR_PRICE;
		__column_names[24] = BaseOutDesignConsideration.CS_INTERIOR_MONEY_SUM;
		__column_names[25] = BaseOutDesignConsideration.CS_OPTION_TYPE;
		__column_names[26] = BaseOutDesignConsideration.CS_EMPLOYEE_ID;
		__column_names[27] = BaseOutDesignConsideration.CS_ORDER_NUM;
		__column_names[28] = BaseOutDesignConsideration.CS_OUT_TEMPLET_ID;
		__column_names[29] = BaseOutDesignConsideration.CS_NEW_CREATE_QUOTATION_NAME;
		__column_names[30] = BaseOutDesignConsideration.CS_FINALIZED_MONEY;
		__column_names[31] = BaseOutDesignConsideration.CS_TYPE;
		__column_names[32] = BaseOutDesignConsideration.CS_INTERIOR_AREA;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseOutDesignConsideration b) {
		clear();
		setOutDesignConsiderationIdClear(b.getOutDesignConsiderationId());
	}

	public boolean isPrimaryKeyNull() {
		return getOutDesignConsiderationId() == null;
	}

	@Override
	public BaseOutDesignConsideration generateBase(){
		BaseOutDesignConsideration b = new BaseOutDesignConsideration();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseOutDesignConsideration b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setOutDesignConsiderationId(GenericBase.__getInt(val));
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
		if((val = __current_data[count++]) != null) b.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOrderNo(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDisableType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOutQuotationId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setInteriorPrice(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setInteriorMoneySum(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOptionType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOrderNum(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOutTempletId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setNewCreateQuotationName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFinalizedMoney(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInteriorArea(GenericBase.__getDecimal(val));
	}

	@Override
	public void setBaseToBuffer(BaseOutDesignConsideration b, Object[] buff){
		int count = 0;
		buff[count++] = b.getOutDesignConsiderationId();
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
		buff[count++] = generateTimestampFromDate(b.getUpdateTime());
		buff[count++] = b.getOrderNo();
		buff[count++] = b.getDisableType();
		buff[count++] = b.getOutQuotationId();
		buff[count++] = b.getRemark();
		buff[count++] = b.getInteriorPrice();
		buff[count++] = b.getInteriorMoneySum();
		buff[count++] = b.getOptionType();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getOrderNum();
		buff[count++] = b.getOutTempletId();
		buff[count++] = b.getNewCreateQuotationName();
		buff[count++] = b.getFinalizedMoney();
		buff[count++] = b.getType();
		buff[count++] = b.getInteriorArea();
	}

	@Override
	public void setDataFromBase(BaseOutDesignConsideration b){
		if(b.getOutDesignConsiderationId() != null) setOutDesignConsiderationIdClear(b.getOutDesignConsiderationId());
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
		if(b.getUpdateTime() != null) setUpdateTime(b.getUpdateTime());
		if(b.getOrderNo() != null) setOrderNo(b.getOrderNo());
		if(b.getDisableType() != null) setDisableType(b.getDisableType());
		if(b.getOutQuotationId() != null) setOutQuotationId(b.getOutQuotationId());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getInteriorPrice() != null) setInteriorPrice(b.getInteriorPrice());
		if(b.getInteriorMoneySum() != null) setInteriorMoneySum(b.getInteriorMoneySum());
		if(b.getOptionType() != null) setOptionType(b.getOptionType());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getOrderNum() != null) setOrderNum(b.getOrderNum());
		if(b.getOutTempletId() != null) setOutTempletId(b.getOutTempletId());
		if(b.getNewCreateQuotationName() != null) setNewCreateQuotationName(b.getNewCreateQuotationName());
		if(b.getFinalizedMoney() != null) setFinalizedMoney(b.getFinalizedMoney());
		if(b.getType() != null) setType(b.getType());
		if(b.getInteriorArea() != null) setInteriorArea(b.getInteriorArea());
	}

	@Override
	public BaseOutDesignConsideration generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseOutDesignConsideration b = new BaseOutDesignConsideration();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseOutDesignConsideration __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOutDesignConsiderationId(GenericBase.__getInt(val));
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
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderNo(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDisableType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOutQuotationId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInteriorPrice(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInteriorMoneySum(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOptionType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderNum(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOutTempletId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNewCreateQuotationName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinalizedMoney(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInteriorArea(GenericBase.__getDecimal(val));
	}

	public void setOutDesignConsiderationId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getOutDesignConsiderationId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setOutDesignConsiderationIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setInfoCode(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getInfoCode() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setProjectCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getProjectCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setBusinessType(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getBusinessType() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setProjectType(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getProjectType() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setMainDesignAreaName(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getMainDesignAreaName() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setDecorationStatus(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getDecorationStatus() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setDesignArea(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getDesignArea() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setDesignUnitPrice(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getDesignUnitPrice() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setMoneySum(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getMoneySum() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setSubContractId(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getSubContractId() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setJobMix(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getJobMix() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setServiceArea(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getServiceArea() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setWithTheAmount(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getWithTheAmount() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setOnSiteTime(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getOnSiteTime() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setOnSitePrice(java.math.BigDecimal val) {
		setCurrentData(15, val);
	}

	public java.math.BigDecimal getOnSitePrice() {
		return GenericBase.__getDecimal(__current_data[15]);
	}

	public void setOnSiteTotalMoney(java.math.BigDecimal val) {
		setCurrentData(16, val);
	}

	public java.math.BigDecimal getOnSiteTotalMoney() {
		return GenericBase.__getDecimal(__current_data[16]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(17, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[17]);
	}

	public void setUpdateTime(java.util.Date val) {
		setCurrentData(18, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateTime() {
		return GenericBase.__getDateFromSQL(__current_data[18]);
	}

	public void setOrderNo(java.lang.Integer val) {
		setCurrentData(19, val);
	}

	public java.lang.Integer getOrderNo() {
		return GenericBase.__getInt(__current_data[19]);
	}

	public void setDisableType(java.lang.Integer val) {
		setCurrentData(20, val);
	}

	public java.lang.Integer getDisableType() {
		return GenericBase.__getInt(__current_data[20]);
	}

	public void setOutQuotationId(java.lang.Integer val) {
		setCurrentData(21, val);
	}

	public java.lang.Integer getOutQuotationId() {
		return GenericBase.__getInt(__current_data[21]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(22, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[22]);
	}

	public void setInteriorPrice(java.math.BigDecimal val) {
		setCurrentData(23, val);
	}

	public java.math.BigDecimal getInteriorPrice() {
		return GenericBase.__getDecimal(__current_data[23]);
	}

	public void setInteriorMoneySum(java.math.BigDecimal val) {
		setCurrentData(24, val);
	}

	public java.math.BigDecimal getInteriorMoneySum() {
		return GenericBase.__getDecimal(__current_data[24]);
	}

	public void setOptionType(java.lang.Integer val) {
		setCurrentData(25, val);
	}

	public java.lang.Integer getOptionType() {
		return GenericBase.__getInt(__current_data[25]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(26, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[26]);
	}

	public void setOrderNum(java.lang.Integer val) {
		setCurrentData(27, val);
	}

	public java.lang.Integer getOrderNum() {
		return GenericBase.__getInt(__current_data[27]);
	}

	public void setOutTempletId(java.lang.Integer val) {
		setCurrentData(28, val);
	}

	public java.lang.Integer getOutTempletId() {
		return GenericBase.__getInt(__current_data[28]);
	}

	public void setNewCreateQuotationName(java.lang.String val) {
		setCurrentData(29, val);
	}

	public java.lang.String getNewCreateQuotationName() {
		return GenericBase.__getString(__current_data[29]);
	}

	public void setFinalizedMoney(java.math.BigDecimal val) {
		setCurrentData(30, val);
	}

	public java.math.BigDecimal getFinalizedMoney() {
		return GenericBase.__getDecimal(__current_data[30]);
	}

	public void setType(java.lang.Integer val) {
		setCurrentData(31, val);
	}

	public java.lang.Integer getType() {
		return GenericBase.__getInt(__current_data[31]);
	}

	public void setInteriorArea(java.math.BigDecimal val) {
		setCurrentData(32, val);
	}

	public java.math.BigDecimal getInteriorArea() {
		return GenericBase.__getDecimal(__current_data[32]);
	}

	public void setConditionOutDesignConsiderationId(String op, java.lang.Integer val) {
		setConditionOutDesignConsiderationId(op, val, CONDITION_AND);
	}

	public void setConditionOutDesignConsiderationId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectOutDesignConsiderationId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionInfoCode(String op, java.lang.String val) {
		setConditionInfoCode(op, val, CONDITION_AND);
	}

	public void setConditionInfoCode(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectInfoCode(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionProjectCode(String op, java.lang.String val) {
		setConditionProjectCode(op, val, CONDITION_AND);
	}

	public void setConditionProjectCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProjectCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionBusinessType(String op, java.lang.Integer val) {
		setConditionBusinessType(op, val, CONDITION_AND);
	}

	public void setConditionBusinessType(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectBusinessType(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionProjectType(String op, java.lang.Integer val) {
		setConditionProjectType(op, val, CONDITION_AND);
	}

	public void setConditionProjectType(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectProjectType(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionMainDesignAreaName(String op, java.lang.String val) {
		setConditionMainDesignAreaName(op, val, CONDITION_AND);
	}

	public void setConditionMainDesignAreaName(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectMainDesignAreaName(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionDecorationStatus(String op, java.lang.Integer val) {
		setConditionDecorationStatus(op, val, CONDITION_AND);
	}

	public void setConditionDecorationStatus(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectDecorationStatus(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionDesignArea(String op, java.math.BigDecimal val) {
		setConditionDesignArea(op, val, CONDITION_AND);
	}

	public void setConditionDesignArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectDesignArea(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionDesignUnitPrice(String op, java.math.BigDecimal val) {
		setConditionDesignUnitPrice(op, val, CONDITION_AND);
	}

	public void setConditionDesignUnitPrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectDesignUnitPrice(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionMoneySum(String op, java.math.BigDecimal val) {
		setConditionMoneySum(op, val, CONDITION_AND);
	}

	public void setConditionMoneySum(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectMoneySum(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionSubContractId(String op, java.lang.Integer val) {
		setConditionSubContractId(op, val, CONDITION_AND);
	}

	public void setConditionSubContractId(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectSubContractId(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionJobMix(String op, java.lang.Integer val) {
		setConditionJobMix(op, val, CONDITION_AND);
	}

	public void setConditionJobMix(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectJobMix(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionServiceArea(String op, java.math.BigDecimal val) {
		setConditionServiceArea(op, val, CONDITION_AND);
	}

	public void setConditionServiceArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectServiceArea(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionWithTheAmount(String op, java.math.BigDecimal val) {
		setConditionWithTheAmount(op, val, CONDITION_AND);
	}

	public void setConditionWithTheAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectWithTheAmount(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionOnSiteTime(String op, java.lang.Integer val) {
		setConditionOnSiteTime(op, val, CONDITION_AND);
	}

	public void setConditionOnSiteTime(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectOnSiteTime(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionOnSitePrice(String op, java.math.BigDecimal val) {
		setConditionOnSitePrice(op, val, CONDITION_AND);
	}

	public void setConditionOnSitePrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectOnSitePrice(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionOnSiteTotalMoney(String op, java.math.BigDecimal val) {
		setConditionOnSiteTotalMoney(op, val, CONDITION_AND);
	}

	public void setConditionOnSiteTotalMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectOnSiteTotalMoney(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(17, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionUpdateTime(String op, java.util.Date val) {
		setConditionUpdateTime(op, val, CONDITION_AND);
	}

	public void setConditionUpdateTime(String op, java.util.Date val, String relation) {
		addCondition(18, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUpdateTime(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionOrderNo(String op, java.lang.Integer val) {
		setConditionOrderNo(op, val, CONDITION_AND);
	}

	public void setConditionOrderNo(String op, java.lang.Integer val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectOrderNo(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionDisableType(String op, java.lang.Integer val) {
		setConditionDisableType(op, val, CONDITION_AND);
	}

	public void setConditionDisableType(String op, java.lang.Integer val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectDisableType(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionOutQuotationId(String op, java.lang.Integer val) {
		setConditionOutQuotationId(op, val, CONDITION_AND);
	}

	public void setConditionOutQuotationId(String op, java.lang.Integer val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectOutQuotationId(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionInteriorPrice(String op, java.math.BigDecimal val) {
		setConditionInteriorPrice(op, val, CONDITION_AND);
	}

	public void setConditionInteriorPrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectInteriorPrice(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionInteriorMoneySum(String op, java.math.BigDecimal val) {
		setConditionInteriorMoneySum(op, val, CONDITION_AND);
	}

	public void setConditionInteriorMoneySum(String op, java.math.BigDecimal val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectInteriorMoneySum(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionOptionType(String op, java.lang.Integer val) {
		setConditionOptionType(op, val, CONDITION_AND);
	}

	public void setConditionOptionType(String op, java.lang.Integer val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectOptionType(boolean val) {
		__select_flags[25] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[26] = val;
	}

	public void setConditionOrderNum(String op, java.lang.Integer val) {
		setConditionOrderNum(op, val, CONDITION_AND);
	}

	public void setConditionOrderNum(String op, java.lang.Integer val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectOrderNum(boolean val) {
		__select_flags[27] = val;
	}

	public void setConditionOutTempletId(String op, java.lang.Integer val) {
		setConditionOutTempletId(op, val, CONDITION_AND);
	}

	public void setConditionOutTempletId(String op, java.lang.Integer val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectOutTempletId(boolean val) {
		__select_flags[28] = val;
	}

	public void setConditionNewCreateQuotationName(String op, java.lang.String val) {
		setConditionNewCreateQuotationName(op, val, CONDITION_AND);
	}

	public void setConditionNewCreateQuotationName(String op, java.lang.String val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectNewCreateQuotationName(boolean val) {
		__select_flags[29] = val;
	}

	public void setConditionFinalizedMoney(String op, java.math.BigDecimal val) {
		setConditionFinalizedMoney(op, val, CONDITION_AND);
	}

	public void setConditionFinalizedMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(30, op, relation, val);
	}

	public void setSelectFinalizedMoney(boolean val) {
		__select_flags[30] = val;
	}

	public void setConditionType(String op, java.lang.Integer val) {
		setConditionType(op, val, CONDITION_AND);
	}

	public void setConditionType(String op, java.lang.Integer val, String relation) {
		addCondition(31, op, relation, val);
	}

	public void setSelectType(boolean val) {
		__select_flags[31] = val;
	}

	public void setConditionInteriorArea(String op, java.math.BigDecimal val) {
		setConditionInteriorArea(op, val, CONDITION_AND);
	}

	public void setConditionInteriorArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(32, op, relation, val);
	}

	public void setSelectInteriorArea(boolean val) {
		__select_flags[32] = val;
	}


}

