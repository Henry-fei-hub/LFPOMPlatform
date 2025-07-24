package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseRevenueStatisticalRecord;


public class RevenueStatisticalRecord extends AbstractTable<BaseRevenueStatisticalRecord>
{

	public RevenueStatisticalRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 30;

		initTables();

		__tableName            = "revenue_statistical_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseRevenueStatisticalRecord.CS_REVENUE_STATISTICAL_RECORD_ID;
		__column_names[1] = BaseRevenueStatisticalRecord.CS_PROJECT_ID;
		__column_names[2] = BaseRevenueStatisticalRecord.CS_YEAR;
		__column_names[3] = BaseRevenueStatisticalRecord.CS_MONTH;
		__column_names[4] = BaseRevenueStatisticalRecord.CS_SHEET_PERCENT;
		__column_names[5] = BaseRevenueStatisticalRecord.CS_MODIFY_PERCENT;
		__column_names[6] = BaseRevenueStatisticalRecord.CS_TOTAL_PERCENT;
		__column_names[7] = BaseRevenueStatisticalRecord.CS_TOTAL_TAX_REVENUE;
		__column_names[8] = BaseRevenueStatisticalRecord.CS_TOTAL_REVENUE;
		__column_names[9] = BaseRevenueStatisticalRecord.CS_CURRENT_REVENUE;
		__column_names[10] = BaseRevenueStatisticalRecord.CS_OPERATE_EMPLOYEE_ID;
		__column_names[11] = BaseRevenueStatisticalRecord.CS_OPERATE_TIME;
		__column_names[12] = BaseRevenueStatisticalRecord.CS_REMARK;
		__column_names[13] = BaseRevenueStatisticalRecord.CS_SHEET_AMOUNT;
		__column_names[14] = BaseRevenueStatisticalRecord.CS_RATE_PERCENT;
		__column_names[15] = BaseRevenueStatisticalRecord.CS_RATE_PERCENT_STR;
		__column_names[16] = BaseRevenueStatisticalRecord.CS_SHEET_PERCENT_STR;
		__column_names[17] = BaseRevenueStatisticalRecord.CS_MODIFY_PERCENT_STR;
		__column_names[18] = BaseRevenueStatisticalRecord.CS_TOTAL_PERCENT_STR;
		__column_names[19] = BaseRevenueStatisticalRecord.CS_TOTAL_SURE_PERCENT;
		__column_names[20] = BaseRevenueStatisticalRecord.CS_TOTAL_SURE_PERCENT_STR;
		__column_names[21] = BaseRevenueStatisticalRecord.CS_TOTAL_SURE_REVENUE;
		__column_names[22] = BaseRevenueStatisticalRecord.CS_CONTRACT_SAVE;
		__column_names[23] = BaseRevenueStatisticalRecord.CS_IS_LOCKED;
		__column_names[24] = BaseRevenueStatisticalRecord.CS_PROJECT_INTEGRAL;
		__column_names[25] = BaseRevenueStatisticalRecord.CS_CONTRACT_SAVE_ACTIVE;
		__column_names[26] = BaseRevenueStatisticalRecord.CS_CONTRACT_SAVE_ACTIVE_UN;
		__column_names[27] = BaseRevenueStatisticalRecord.CS_CONTRACT_SAVE_ACTIVE_PAUSE;
		__column_names[28] = BaseRevenueStatisticalRecord.CS_CONTRACT_SAVE_ACTIVE_NEVER;
		__column_names[29] = BaseRevenueStatisticalRecord.CS_CONTRACT_SAVE_OTHER;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseRevenueStatisticalRecord b) {
		clear();
		setRevenueStatisticalRecordIdClear(b.getRevenueStatisticalRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getRevenueStatisticalRecordId() == null;
	}

	@Override
	public BaseRevenueStatisticalRecord generateBase(){
		BaseRevenueStatisticalRecord b = new BaseRevenueStatisticalRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseRevenueStatisticalRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setRevenueStatisticalRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSheetPercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setModifyPercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalPercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalTaxRevenue(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalRevenue(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCurrentRevenue(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSheetAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRatePercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRatePercentStr(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSheetPercentStr(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setModifyPercentStr(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTotalPercentStr(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTotalSurePercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalSurePercentStr(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTotalSureRevenue(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setContractSave(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setIsLocked(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setContractSaveActive(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setContractSaveActiveUn(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setContractSaveActivePause(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setContractSaveActiveNever(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setContractSaveOther(GenericBase.__getDecimal(val));
	}

	@Override
	public void setBaseToBuffer(BaseRevenueStatisticalRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getRevenueStatisticalRecordId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getSheetPercent();
		buff[count++] = b.getModifyPercent();
		buff[count++] = b.getTotalPercent();
		buff[count++] = b.getTotalTaxRevenue();
		buff[count++] = b.getTotalRevenue();
		buff[count++] = b.getCurrentRevenue();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
		buff[count++] = b.getSheetAmount();
		buff[count++] = b.getRatePercent();
		buff[count++] = b.getRatePercentStr();
		buff[count++] = b.getSheetPercentStr();
		buff[count++] = b.getModifyPercentStr();
		buff[count++] = b.getTotalPercentStr();
		buff[count++] = b.getTotalSurePercent();
		buff[count++] = b.getTotalSurePercentStr();
		buff[count++] = b.getTotalSureRevenue();
		buff[count++] = b.getContractSave();
		buff[count++] = b.getIsLocked();
		buff[count++] = b.getProjectIntegral();
		buff[count++] = b.getContractSaveActive();
		buff[count++] = b.getContractSaveActiveUn();
		buff[count++] = b.getContractSaveActivePause();
		buff[count++] = b.getContractSaveActiveNever();
		buff[count++] = b.getContractSaveOther();
	}

	@Override
	public void setDataFromBase(BaseRevenueStatisticalRecord b){
		if(b.getRevenueStatisticalRecordId() != null) setRevenueStatisticalRecordIdClear(b.getRevenueStatisticalRecordId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getSheetPercent() != null) setSheetPercent(b.getSheetPercent());
		if(b.getModifyPercent() != null) setModifyPercent(b.getModifyPercent());
		if(b.getTotalPercent() != null) setTotalPercent(b.getTotalPercent());
		if(b.getTotalTaxRevenue() != null) setTotalTaxRevenue(b.getTotalTaxRevenue());
		if(b.getTotalRevenue() != null) setTotalRevenue(b.getTotalRevenue());
		if(b.getCurrentRevenue() != null) setCurrentRevenue(b.getCurrentRevenue());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getSheetAmount() != null) setSheetAmount(b.getSheetAmount());
		if(b.getRatePercent() != null) setRatePercent(b.getRatePercent());
		if(b.getRatePercentStr() != null) setRatePercentStr(b.getRatePercentStr());
		if(b.getSheetPercentStr() != null) setSheetPercentStr(b.getSheetPercentStr());
		if(b.getModifyPercentStr() != null) setModifyPercentStr(b.getModifyPercentStr());
		if(b.getTotalPercentStr() != null) setTotalPercentStr(b.getTotalPercentStr());
		if(b.getTotalSurePercent() != null) setTotalSurePercent(b.getTotalSurePercent());
		if(b.getTotalSurePercentStr() != null) setTotalSurePercentStr(b.getTotalSurePercentStr());
		if(b.getTotalSureRevenue() != null) setTotalSureRevenue(b.getTotalSureRevenue());
		if(b.getContractSave() != null) setContractSave(b.getContractSave());
		if(b.getIsLocked() != null) setIsLocked(b.getIsLocked());
		if(b.getProjectIntegral() != null) setProjectIntegral(b.getProjectIntegral());
		if(b.getContractSaveActive() != null) setContractSaveActive(b.getContractSaveActive());
		if(b.getContractSaveActiveUn() != null) setContractSaveActiveUn(b.getContractSaveActiveUn());
		if(b.getContractSaveActivePause() != null) setContractSaveActivePause(b.getContractSaveActivePause());
		if(b.getContractSaveActiveNever() != null) setContractSaveActiveNever(b.getContractSaveActiveNever());
		if(b.getContractSaveOther() != null) setContractSaveOther(b.getContractSaveOther());
	}

	@Override
	public BaseRevenueStatisticalRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseRevenueStatisticalRecord b = new BaseRevenueStatisticalRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseRevenueStatisticalRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRevenueStatisticalRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSheetPercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setModifyPercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalPercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalTaxRevenue(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalRevenue(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCurrentRevenue(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSheetAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRatePercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRatePercentStr(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSheetPercentStr(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setModifyPercentStr(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalPercentStr(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalSurePercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalSurePercentStr(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalSureRevenue(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractSave(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsLocked(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractSaveActive(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractSaveActiveUn(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractSaveActivePause(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractSaveActiveNever(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractSaveOther(GenericBase.__getDecimal(val));
	}

	public void setRevenueStatisticalRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getRevenueStatisticalRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setRevenueStatisticalRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setSheetPercent(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getSheetPercent() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setModifyPercent(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getModifyPercent() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setTotalPercent(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getTotalPercent() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setTotalTaxRevenue(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getTotalTaxRevenue() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setTotalRevenue(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getTotalRevenue() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setCurrentRevenue(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getCurrentRevenue() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(11, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[11]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setSheetAmount(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getSheetAmount() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setRatePercent(java.math.BigDecimal val) {
		setCurrentData(14, val);
	}

	public java.math.BigDecimal getRatePercent() {
		return GenericBase.__getDecimal(__current_data[14]);
	}

	public void setRatePercentStr(java.lang.String val) {
		setCurrentData(15, val);
	}

	public java.lang.String getRatePercentStr() {
		return GenericBase.__getString(__current_data[15]);
	}

	public void setSheetPercentStr(java.lang.String val) {
		setCurrentData(16, val);
	}

	public java.lang.String getSheetPercentStr() {
		return GenericBase.__getString(__current_data[16]);
	}

	public void setModifyPercentStr(java.lang.String val) {
		setCurrentData(17, val);
	}

	public java.lang.String getModifyPercentStr() {
		return GenericBase.__getString(__current_data[17]);
	}

	public void setTotalPercentStr(java.lang.String val) {
		setCurrentData(18, val);
	}

	public java.lang.String getTotalPercentStr() {
		return GenericBase.__getString(__current_data[18]);
	}

	public void setTotalSurePercent(java.math.BigDecimal val) {
		setCurrentData(19, val);
	}

	public java.math.BigDecimal getTotalSurePercent() {
		return GenericBase.__getDecimal(__current_data[19]);
	}

	public void setTotalSurePercentStr(java.lang.String val) {
		setCurrentData(20, val);
	}

	public java.lang.String getTotalSurePercentStr() {
		return GenericBase.__getString(__current_data[20]);
	}

	public void setTotalSureRevenue(java.math.BigDecimal val) {
		setCurrentData(21, val);
	}

	public java.math.BigDecimal getTotalSureRevenue() {
		return GenericBase.__getDecimal(__current_data[21]);
	}

	public void setContractSave(java.math.BigDecimal val) {
		setCurrentData(22, val);
	}

	public java.math.BigDecimal getContractSave() {
		return GenericBase.__getDecimal(__current_data[22]);
	}

	public void setIsLocked(java.lang.Boolean val) {
		setCurrentData(23, val);
	}

	public java.lang.Boolean getIsLocked() {
		return GenericBase.__getBoolean(__current_data[23]);
	}

	public void setProjectIntegral(java.math.BigDecimal val) {
		setCurrentData(24, val);
	}

	public java.math.BigDecimal getProjectIntegral() {
		return GenericBase.__getDecimal(__current_data[24]);
	}

	public void setContractSaveActive(java.math.BigDecimal val) {
		setCurrentData(25, val);
	}

	public java.math.BigDecimal getContractSaveActive() {
		return GenericBase.__getDecimal(__current_data[25]);
	}

	public void setContractSaveActiveUn(java.math.BigDecimal val) {
		setCurrentData(26, val);
	}

	public java.math.BigDecimal getContractSaveActiveUn() {
		return GenericBase.__getDecimal(__current_data[26]);
	}

	public void setContractSaveActivePause(java.math.BigDecimal val) {
		setCurrentData(27, val);
	}

	public java.math.BigDecimal getContractSaveActivePause() {
		return GenericBase.__getDecimal(__current_data[27]);
	}

	public void setContractSaveActiveNever(java.math.BigDecimal val) {
		setCurrentData(28, val);
	}

	public java.math.BigDecimal getContractSaveActiveNever() {
		return GenericBase.__getDecimal(__current_data[28]);
	}

	public void setContractSaveOther(java.math.BigDecimal val) {
		setCurrentData(29, val);
	}

	public java.math.BigDecimal getContractSaveOther() {
		return GenericBase.__getDecimal(__current_data[29]);
	}

	public void setConditionRevenueStatisticalRecordId(String op, java.lang.Integer val) {
		setConditionRevenueStatisticalRecordId(op, val, CONDITION_AND);
	}

	public void setConditionRevenueStatisticalRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectRevenueStatisticalRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionSheetPercent(String op, java.math.BigDecimal val) {
		setConditionSheetPercent(op, val, CONDITION_AND);
	}

	public void setConditionSheetPercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectSheetPercent(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionModifyPercent(String op, java.math.BigDecimal val) {
		setConditionModifyPercent(op, val, CONDITION_AND);
	}

	public void setConditionModifyPercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectModifyPercent(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionTotalPercent(String op, java.math.BigDecimal val) {
		setConditionTotalPercent(op, val, CONDITION_AND);
	}

	public void setConditionTotalPercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectTotalPercent(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionTotalTaxRevenue(String op, java.math.BigDecimal val) {
		setConditionTotalTaxRevenue(op, val, CONDITION_AND);
	}

	public void setConditionTotalTaxRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectTotalTaxRevenue(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionTotalRevenue(String op, java.math.BigDecimal val) {
		setConditionTotalRevenue(op, val, CONDITION_AND);
	}

	public void setConditionTotalRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectTotalRevenue(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionCurrentRevenue(String op, java.math.BigDecimal val) {
		setConditionCurrentRevenue(op, val, CONDITION_AND);
	}

	public void setConditionCurrentRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectCurrentRevenue(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(11, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionSheetAmount(String op, java.math.BigDecimal val) {
		setConditionSheetAmount(op, val, CONDITION_AND);
	}

	public void setConditionSheetAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectSheetAmount(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionRatePercent(String op, java.math.BigDecimal val) {
		setConditionRatePercent(op, val, CONDITION_AND);
	}

	public void setConditionRatePercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectRatePercent(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionRatePercentStr(String op, java.lang.String val) {
		setConditionRatePercentStr(op, val, CONDITION_AND);
	}

	public void setConditionRatePercentStr(String op, java.lang.String val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectRatePercentStr(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionSheetPercentStr(String op, java.lang.String val) {
		setConditionSheetPercentStr(op, val, CONDITION_AND);
	}

	public void setConditionSheetPercentStr(String op, java.lang.String val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectSheetPercentStr(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionModifyPercentStr(String op, java.lang.String val) {
		setConditionModifyPercentStr(op, val, CONDITION_AND);
	}

	public void setConditionModifyPercentStr(String op, java.lang.String val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectModifyPercentStr(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionTotalPercentStr(String op, java.lang.String val) {
		setConditionTotalPercentStr(op, val, CONDITION_AND);
	}

	public void setConditionTotalPercentStr(String op, java.lang.String val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectTotalPercentStr(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionTotalSurePercent(String op, java.math.BigDecimal val) {
		setConditionTotalSurePercent(op, val, CONDITION_AND);
	}

	public void setConditionTotalSurePercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectTotalSurePercent(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionTotalSurePercentStr(String op, java.lang.String val) {
		setConditionTotalSurePercentStr(op, val, CONDITION_AND);
	}

	public void setConditionTotalSurePercentStr(String op, java.lang.String val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectTotalSurePercentStr(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionTotalSureRevenue(String op, java.math.BigDecimal val) {
		setConditionTotalSureRevenue(op, val, CONDITION_AND);
	}

	public void setConditionTotalSureRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectTotalSureRevenue(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionContractSave(String op, java.math.BigDecimal val) {
		setConditionContractSave(op, val, CONDITION_AND);
	}

	public void setConditionContractSave(String op, java.math.BigDecimal val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectContractSave(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionIsLocked(String op, java.lang.Boolean val) {
		setConditionIsLocked(op, val, CONDITION_AND);
	}

	public void setConditionIsLocked(String op, java.lang.Boolean val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectIsLocked(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionProjectIntegral(String op, java.math.BigDecimal val) {
		setConditionProjectIntegral(op, val, CONDITION_AND);
	}

	public void setConditionProjectIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectProjectIntegral(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionContractSaveActive(String op, java.math.BigDecimal val) {
		setConditionContractSaveActive(op, val, CONDITION_AND);
	}

	public void setConditionContractSaveActive(String op, java.math.BigDecimal val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectContractSaveActive(boolean val) {
		__select_flags[25] = val;
	}

	public void setConditionContractSaveActiveUn(String op, java.math.BigDecimal val) {
		setConditionContractSaveActiveUn(op, val, CONDITION_AND);
	}

	public void setConditionContractSaveActiveUn(String op, java.math.BigDecimal val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectContractSaveActiveUn(boolean val) {
		__select_flags[26] = val;
	}

	public void setConditionContractSaveActivePause(String op, java.math.BigDecimal val) {
		setConditionContractSaveActivePause(op, val, CONDITION_AND);
	}

	public void setConditionContractSaveActivePause(String op, java.math.BigDecimal val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectContractSaveActivePause(boolean val) {
		__select_flags[27] = val;
	}

	public void setConditionContractSaveActiveNever(String op, java.math.BigDecimal val) {
		setConditionContractSaveActiveNever(op, val, CONDITION_AND);
	}

	public void setConditionContractSaveActiveNever(String op, java.math.BigDecimal val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectContractSaveActiveNever(boolean val) {
		__select_flags[28] = val;
	}

	public void setConditionContractSaveOther(String op, java.math.BigDecimal val) {
		setConditionContractSaveOther(op, val, CONDITION_AND);
	}

	public void setConditionContractSaveOther(String op, java.math.BigDecimal val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectContractSaveOther(boolean val) {
		__select_flags[29] = val;
	}


}

