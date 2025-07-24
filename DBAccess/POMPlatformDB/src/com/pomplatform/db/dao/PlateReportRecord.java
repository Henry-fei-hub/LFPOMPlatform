package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePlateReportRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PlateReportRecord extends AbstractTable<BasePlateReportRecord>
{

	public PlateReportRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 16;

		initTables();

		__tableName            = "plate_report_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePlateReportRecord.CS_PLATE_REPORT_RECORD_ID;
		__column_names[1] = BasePlateReportRecord.CS_PLATE_ID;
		__column_names[2] = BasePlateReportRecord.CS_ACHIEVE_INTEGRAL;
		__column_names[3] = BasePlateReportRecord.CS_PROJECT_SETTLEMENT;
		__column_names[4] = BasePlateReportRecord.CS_COMPANY_SUBSIDY;
		__column_names[5] = BasePlateReportRecord.CS_EMPLOYEE_ACHIEVE_INTEGRAL_RETURN;
		__column_names[6] = BasePlateReportRecord.CS_SALARY_RETURN;
		__column_names[7] = BasePlateReportRecord.CS_SALARY_ADVANCE;
		__column_names[8] = BasePlateReportRecord.CS_MANAGER_PROJECT_INTEGRAL;
		__column_names[9] = BasePlateReportRecord.CS_PLATE_COST;
		__column_names[10] = BasePlateReportRecord.CS_RECORD_DATE;
		__column_names[11] = BasePlateReportRecord.CS_IS_LOCK;
		__column_names[12] = BasePlateReportRecord.CS_PROJECT_ADVANCE;
		__column_names[13] = BasePlateReportRecord.CS_QUALITY_FEE;
		__column_names[14] = BasePlateReportRecord.CS_COMPANY_FEE;
		__column_names[15] = BasePlateReportRecord.CS_VIOLATION_CHARGES;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePlateReportRecord b) {
		clear();
		setPlateReportRecordIdClear(b.getPlateReportRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getPlateReportRecordId() == null;
	}

	@Override
	public BasePlateReportRecord generateBase(){
		BasePlateReportRecord b = new BasePlateReportRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePlateReportRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPlateReportRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAchieveIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectSettlement(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCompanySubsidy(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setEmployeeAchieveIntegralReturn(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSalaryReturn(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSalaryAdvance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setManagerProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPlateCost(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setIsLock(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setProjectAdvance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setQualityFee(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCompanyFee(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setViolationCharges(GenericBase.__getDecimal(val));
	}

	@Override
	public void setBaseToBuffer(BasePlateReportRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPlateReportRecordId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getAchieveIntegral();
		buff[count++] = b.getProjectSettlement();
		buff[count++] = b.getCompanySubsidy();
		buff[count++] = b.getEmployeeAchieveIntegralReturn();
		buff[count++] = b.getSalaryReturn();
		buff[count++] = b.getSalaryAdvance();
		buff[count++] = b.getManagerProjectIntegral();
		buff[count++] = b.getPlateCost();
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = b.getIsLock();
		buff[count++] = b.getProjectAdvance();
		buff[count++] = b.getQualityFee();
		buff[count++] = b.getCompanyFee();
		buff[count++] = b.getViolationCharges();
	}

	@Override
	public void setDataFromBase(BasePlateReportRecord b){
		if(b.getPlateReportRecordId() != null) setPlateReportRecordIdClear(b.getPlateReportRecordId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getAchieveIntegral() != null) setAchieveIntegral(b.getAchieveIntegral());
		if(b.getProjectSettlement() != null) setProjectSettlement(b.getProjectSettlement());
		if(b.getCompanySubsidy() != null) setCompanySubsidy(b.getCompanySubsidy());
		if(b.getEmployeeAchieveIntegralReturn() != null) setEmployeeAchieveIntegralReturn(b.getEmployeeAchieveIntegralReturn());
		if(b.getSalaryReturn() != null) setSalaryReturn(b.getSalaryReturn());
		if(b.getSalaryAdvance() != null) setSalaryAdvance(b.getSalaryAdvance());
		if(b.getManagerProjectIntegral() != null) setManagerProjectIntegral(b.getManagerProjectIntegral());
		if(b.getPlateCost() != null) setPlateCost(b.getPlateCost());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getIsLock() != null) setIsLock(b.getIsLock());
		if(b.getProjectAdvance() != null) setProjectAdvance(b.getProjectAdvance());
		if(b.getQualityFee() != null) setQualityFee(b.getQualityFee());
		if(b.getCompanyFee() != null) setCompanyFee(b.getCompanyFee());
		if(b.getViolationCharges() != null) setViolationCharges(b.getViolationCharges());
	}

	@Override
	public BasePlateReportRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePlateReportRecord b = new BasePlateReportRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePlateReportRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateReportRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAchieveIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectSettlement(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanySubsidy(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeAchieveIntegralReturn(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalaryReturn(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalaryAdvance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setManagerProjectIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateCost(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsLock(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectAdvance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setQualityFee(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyFee(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setViolationCharges(GenericBase.__getDecimal(val));
	}

	public void setPlateReportRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPlateReportRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPlateReportRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setAchieveIntegral(java.math.BigDecimal val) {
		setCurrentData(2, val);
	}

	public java.math.BigDecimal getAchieveIntegral() {
		return GenericBase.__getDecimal(__current_data[2]);
	}

	public void setProjectSettlement(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getProjectSettlement() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setCompanySubsidy(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getCompanySubsidy() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setEmployeeAchieveIntegralReturn(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getEmployeeAchieveIntegralReturn() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setSalaryReturn(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getSalaryReturn() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setSalaryAdvance(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getSalaryAdvance() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setManagerProjectIntegral(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getManagerProjectIntegral() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setPlateCost(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getPlateCost() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setRecordDate(java.util.Date val) {
		setCurrentData(10, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordDate() {
		return GenericBase.__getDateFromSQL(__current_data[10]);
	}

	public void setIsLock(java.lang.Boolean val) {
		setCurrentData(11, val);
	}

	public java.lang.Boolean getIsLock() {
		return GenericBase.__getBoolean(__current_data[11]);
	}

	public void setProjectAdvance(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getProjectAdvance() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setQualityFee(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getQualityFee() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setCompanyFee(java.math.BigDecimal val) {
		setCurrentData(14, val);
	}

	public java.math.BigDecimal getCompanyFee() {
		return GenericBase.__getDecimal(__current_data[14]);
	}

	public void setViolationCharges(java.math.BigDecimal val) {
		setCurrentData(15, val);
	}

	public java.math.BigDecimal getViolationCharges() {
		return GenericBase.__getDecimal(__current_data[15]);
	}

	public void setConditionPlateReportRecordId(String op, java.lang.Integer val) {
		setConditionPlateReportRecordId(op, val, CONDITION_AND);
	}

	public void setConditionPlateReportRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPlateReportRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionAchieveIntegral(String op, java.math.BigDecimal val) {
		setConditionAchieveIntegral(op, val, CONDITION_AND);
	}

	public void setConditionAchieveIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectAchieveIntegral(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionProjectSettlement(String op, java.math.BigDecimal val) {
		setConditionProjectSettlement(op, val, CONDITION_AND);
	}

	public void setConditionProjectSettlement(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectProjectSettlement(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCompanySubsidy(String op, java.math.BigDecimal val) {
		setConditionCompanySubsidy(op, val, CONDITION_AND);
	}

	public void setConditionCompanySubsidy(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCompanySubsidy(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionEmployeeAchieveIntegralReturn(String op, java.math.BigDecimal val) {
		setConditionEmployeeAchieveIntegralReturn(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeAchieveIntegralReturn(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectEmployeeAchieveIntegralReturn(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionSalaryReturn(String op, java.math.BigDecimal val) {
		setConditionSalaryReturn(op, val, CONDITION_AND);
	}

	public void setConditionSalaryReturn(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectSalaryReturn(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionSalaryAdvance(String op, java.math.BigDecimal val) {
		setConditionSalaryAdvance(op, val, CONDITION_AND);
	}

	public void setConditionSalaryAdvance(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectSalaryAdvance(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionManagerProjectIntegral(String op, java.math.BigDecimal val) {
		setConditionManagerProjectIntegral(op, val, CONDITION_AND);
	}

	public void setConditionManagerProjectIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectManagerProjectIntegral(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionPlateCost(String op, java.math.BigDecimal val) {
		setConditionPlateCost(op, val, CONDITION_AND);
	}

	public void setConditionPlateCost(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectPlateCost(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionRecordDate(String op, java.util.Date val) {
		setConditionRecordDate(op, val, CONDITION_AND);
	}

	public void setConditionRecordDate(String op, java.util.Date val, String relation) {
		addCondition(10, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordDate(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionIsLock(String op, java.lang.Boolean val) {
		setConditionIsLock(op, val, CONDITION_AND);
	}

	public void setConditionIsLock(String op, java.lang.Boolean val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectIsLock(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionProjectAdvance(String op, java.math.BigDecimal val) {
		setConditionProjectAdvance(op, val, CONDITION_AND);
	}

	public void setConditionProjectAdvance(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectProjectAdvance(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionQualityFee(String op, java.math.BigDecimal val) {
		setConditionQualityFee(op, val, CONDITION_AND);
	}

	public void setConditionQualityFee(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectQualityFee(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionCompanyFee(String op, java.math.BigDecimal val) {
		setConditionCompanyFee(op, val, CONDITION_AND);
	}

	public void setConditionCompanyFee(String op, java.math.BigDecimal val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectCompanyFee(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionViolationCharges(String op, java.math.BigDecimal val) {
		setConditionViolationCharges(op, val, CONDITION_AND);
	}

	public void setConditionViolationCharges(String op, java.math.BigDecimal val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectViolationCharges(boolean val) {
		__select_flags[15] = val;
	}


}

