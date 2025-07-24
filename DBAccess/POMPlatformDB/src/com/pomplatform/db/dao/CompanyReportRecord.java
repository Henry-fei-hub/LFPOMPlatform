package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCompanyReportRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CompanyReportRecord extends AbstractTable<BaseCompanyReportRecord>
{

	public CompanyReportRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "company_report_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCompanyReportRecord.CS_COMPANY_REPORT_RECORD_ID;
		__column_names[1] = BaseCompanyReportRecord.CS_PERCENT;
		__column_names[2] = BaseCompanyReportRecord.CS_ACHIEVE_INTEGRAL;
		__column_names[3] = BaseCompanyReportRecord.CS_SIGNING_MONEY_SUM;
		__column_names[4] = BaseCompanyReportRecord.CS_SHEET_TOTAL_INTEGRAL;
		__column_names[5] = BaseCompanyReportRecord.CS_COMPANY_SUBSIDY;
		__column_names[6] = BaseCompanyReportRecord.CS_WIN_INTEGRAL;
		__column_names[7] = BaseCompanyReportRecord.CS_COMPLAINT_INTEGRAL;
		__column_names[8] = BaseCompanyReportRecord.CS_PROJECT_INTEGRAL_EXTRACT;
		__column_names[9] = BaseCompanyReportRecord.CS_AWARD_SEND;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCompanyReportRecord b) {
		clear();
		setCompanyReportRecordIdClear(b.getCompanyReportRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getCompanyReportRecordId() == null;
	}

	@Override
	public BaseCompanyReportRecord generateBase(){
		BaseCompanyReportRecord b = new BaseCompanyReportRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCompanyReportRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCompanyReportRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPercent(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAchieveIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSigningMoneySum(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSheetTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCompanySubsidy(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setWinIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setComplaintIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectIntegralExtract(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAwardSend(GenericBase.__getDecimal(val));
	}

	@Override
	public void setBaseToBuffer(BaseCompanyReportRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCompanyReportRecordId();
		buff[count++] = b.getPercent();
		buff[count++] = b.getAchieveIntegral();
		buff[count++] = b.getSigningMoneySum();
		buff[count++] = b.getSheetTotalIntegral();
		buff[count++] = b.getCompanySubsidy();
		buff[count++] = b.getWinIntegral();
		buff[count++] = b.getComplaintIntegral();
		buff[count++] = b.getProjectIntegralExtract();
		buff[count++] = b.getAwardSend();
	}

	@Override
	public void setDataFromBase(BaseCompanyReportRecord b){
		if(b.getCompanyReportRecordId() != null) setCompanyReportRecordIdClear(b.getCompanyReportRecordId());
		if(b.getPercent() != null) setPercent(b.getPercent());
		if(b.getAchieveIntegral() != null) setAchieveIntegral(b.getAchieveIntegral());
		if(b.getSigningMoneySum() != null) setSigningMoneySum(b.getSigningMoneySum());
		if(b.getSheetTotalIntegral() != null) setSheetTotalIntegral(b.getSheetTotalIntegral());
		if(b.getCompanySubsidy() != null) setCompanySubsidy(b.getCompanySubsidy());
		if(b.getWinIntegral() != null) setWinIntegral(b.getWinIntegral());
		if(b.getComplaintIntegral() != null) setComplaintIntegral(b.getComplaintIntegral());
		if(b.getProjectIntegralExtract() != null) setProjectIntegralExtract(b.getProjectIntegralExtract());
		if(b.getAwardSend() != null) setAwardSend(b.getAwardSend());
	}

	@Override
	public BaseCompanyReportRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCompanyReportRecord b = new BaseCompanyReportRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCompanyReportRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyReportRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPercent(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAchieveIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSheetTotalIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanySubsidy(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWinIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setComplaintIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectIntegralExtract(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAwardSend(GenericBase.__getDecimal(val));
	}

	public void setCompanyReportRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCompanyReportRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCompanyReportRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPercent(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getPercent() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setAchieveIntegral(java.math.BigDecimal val) {
		setCurrentData(2, val);
	}

	public java.math.BigDecimal getAchieveIntegral() {
		return GenericBase.__getDecimal(__current_data[2]);
	}

	public void setSigningMoneySum(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getSigningMoneySum() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setSheetTotalIntegral(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getSheetTotalIntegral() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setCompanySubsidy(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getCompanySubsidy() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setWinIntegral(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getWinIntegral() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setComplaintIntegral(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getComplaintIntegral() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setProjectIntegralExtract(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getProjectIntegralExtract() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setAwardSend(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getAwardSend() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setConditionCompanyReportRecordId(String op, java.lang.Integer val) {
		setConditionCompanyReportRecordId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyReportRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCompanyReportRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionPercent(String op, java.lang.String val) {
		setConditionPercent(op, val, CONDITION_AND);
	}

	public void setConditionPercent(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectPercent(boolean val) {
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

	public void setConditionSigningMoneySum(String op, java.math.BigDecimal val) {
		setConditionSigningMoneySum(op, val, CONDITION_AND);
	}

	public void setConditionSigningMoneySum(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectSigningMoneySum(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionSheetTotalIntegral(String op, java.math.BigDecimal val) {
		setConditionSheetTotalIntegral(op, val, CONDITION_AND);
	}

	public void setConditionSheetTotalIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectSheetTotalIntegral(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCompanySubsidy(String op, java.math.BigDecimal val) {
		setConditionCompanySubsidy(op, val, CONDITION_AND);
	}

	public void setConditionCompanySubsidy(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectCompanySubsidy(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionWinIntegral(String op, java.math.BigDecimal val) {
		setConditionWinIntegral(op, val, CONDITION_AND);
	}

	public void setConditionWinIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectWinIntegral(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionComplaintIntegral(String op, java.math.BigDecimal val) {
		setConditionComplaintIntegral(op, val, CONDITION_AND);
	}

	public void setConditionComplaintIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectComplaintIntegral(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionProjectIntegralExtract(String op, java.math.BigDecimal val) {
		setConditionProjectIntegralExtract(op, val, CONDITION_AND);
	}

	public void setConditionProjectIntegralExtract(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectProjectIntegralExtract(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionAwardSend(String op, java.math.BigDecimal val) {
		setConditionAwardSend(op, val, CONDITION_AND);
	}

	public void setConditionAwardSend(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectAwardSend(boolean val) {
		__select_flags[9] = val;
	}


}

