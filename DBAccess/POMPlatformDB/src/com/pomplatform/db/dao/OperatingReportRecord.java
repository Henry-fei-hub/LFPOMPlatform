package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseOperatingReportRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class OperatingReportRecord extends AbstractTable<BaseOperatingReportRecord>
{

	public OperatingReportRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 13;

		initTables();

		__tableName            = "operating_report_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseOperatingReportRecord.CS_OPERATING_REPORT_RECORD_ID;
		__column_names[1] = BaseOperatingReportRecord.CS_PLATE_ID;
		__column_names[2] = BaseOperatingReportRecord.CS_SURE_INTEGRAL;
		__column_names[3] = BaseOperatingReportRecord.CS_COMPANY_SUBSIDY;
		__column_names[4] = BaseOperatingReportRecord.CS_ACHIEVE_OTHER_PLATE_INTEGRAL;
		__column_names[5] = BaseOperatingReportRecord.CS_SALARY_COST;
		__column_names[6] = BaseOperatingReportRecord.CS_PLATE_COST;
		__column_names[7] = BaseOperatingReportRecord.CS_PROJECT_COST;
		__column_names[8] = BaseOperatingReportRecord.CS_PAY_COMMON_PLATE_INTEGRAL;
		__column_names[9] = BaseOperatingReportRecord.CS_PAY_OTHER_PLATE_INTEGRAL;
		__column_names[10] = BaseOperatingReportRecord.CS_ACHIEVE_INTEGRAL;
		__column_names[11] = BaseOperatingReportRecord.CS_AWARD_SEND;
		__column_names[12] = BaseOperatingReportRecord.CS_LEFT_ACHIEVE_INTEGRAL;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseOperatingReportRecord b) {
		clear();
		setOperatingReportRecordIdClear(b.getOperatingReportRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getOperatingReportRecordId() == null;
	}

	@Override
	public BaseOperatingReportRecord generateBase(){
		BaseOperatingReportRecord b = new BaseOperatingReportRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseOperatingReportRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setOperatingReportRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSureIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCompanySubsidy(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAchieveOtherPlateIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSalaryCost(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPlateCost(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectCost(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPayCommonPlateIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPayOtherPlateIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAchieveIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAwardSend(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setLeftAchieveIntegral(GenericBase.__getDecimal(val));
	}

	@Override
	public void setBaseToBuffer(BaseOperatingReportRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getOperatingReportRecordId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getSureIntegral();
		buff[count++] = b.getCompanySubsidy();
		buff[count++] = b.getAchieveOtherPlateIntegral();
		buff[count++] = b.getSalaryCost();
		buff[count++] = b.getPlateCost();
		buff[count++] = b.getProjectCost();
		buff[count++] = b.getPayCommonPlateIntegral();
		buff[count++] = b.getPayOtherPlateIntegral();
		buff[count++] = b.getAchieveIntegral();
		buff[count++] = b.getAwardSend();
		buff[count++] = b.getLeftAchieveIntegral();
	}

	@Override
	public void setDataFromBase(BaseOperatingReportRecord b){
		if(b.getOperatingReportRecordId() != null) setOperatingReportRecordIdClear(b.getOperatingReportRecordId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getSureIntegral() != null) setSureIntegral(b.getSureIntegral());
		if(b.getCompanySubsidy() != null) setCompanySubsidy(b.getCompanySubsidy());
		if(b.getAchieveOtherPlateIntegral() != null) setAchieveOtherPlateIntegral(b.getAchieveOtherPlateIntegral());
		if(b.getSalaryCost() != null) setSalaryCost(b.getSalaryCost());
		if(b.getPlateCost() != null) setPlateCost(b.getPlateCost());
		if(b.getProjectCost() != null) setProjectCost(b.getProjectCost());
		if(b.getPayCommonPlateIntegral() != null) setPayCommonPlateIntegral(b.getPayCommonPlateIntegral());
		if(b.getPayOtherPlateIntegral() != null) setPayOtherPlateIntegral(b.getPayOtherPlateIntegral());
		if(b.getAchieveIntegral() != null) setAchieveIntegral(b.getAchieveIntegral());
		if(b.getAwardSend() != null) setAwardSend(b.getAwardSend());
		if(b.getLeftAchieveIntegral() != null) setLeftAchieveIntegral(b.getLeftAchieveIntegral());
	}

	@Override
	public BaseOperatingReportRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseOperatingReportRecord b = new BaseOperatingReportRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseOperatingReportRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperatingReportRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanySubsidy(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAchieveOtherPlateIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalaryCost(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateCost(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCost(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayCommonPlateIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayOtherPlateIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAchieveIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAwardSend(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLeftAchieveIntegral(GenericBase.__getDecimal(val));
	}

	public void setOperatingReportRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getOperatingReportRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setOperatingReportRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setSureIntegral(java.math.BigDecimal val) {
		setCurrentData(2, val);
	}

	public java.math.BigDecimal getSureIntegral() {
		return GenericBase.__getDecimal(__current_data[2]);
	}

	public void setCompanySubsidy(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getCompanySubsidy() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setAchieveOtherPlateIntegral(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getAchieveOtherPlateIntegral() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setSalaryCost(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getSalaryCost() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setPlateCost(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getPlateCost() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setProjectCost(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getProjectCost() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setPayCommonPlateIntegral(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getPayCommonPlateIntegral() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setPayOtherPlateIntegral(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getPayOtherPlateIntegral() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setAchieveIntegral(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getAchieveIntegral() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setAwardSend(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getAwardSend() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setLeftAchieveIntegral(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getLeftAchieveIntegral() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setConditionOperatingReportRecordId(String op, java.lang.Integer val) {
		setConditionOperatingReportRecordId(op, val, CONDITION_AND);
	}

	public void setConditionOperatingReportRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectOperatingReportRecordId(boolean val) {
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

	public void setConditionSureIntegral(String op, java.math.BigDecimal val) {
		setConditionSureIntegral(op, val, CONDITION_AND);
	}

	public void setConditionSureIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectSureIntegral(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionCompanySubsidy(String op, java.math.BigDecimal val) {
		setConditionCompanySubsidy(op, val, CONDITION_AND);
	}

	public void setConditionCompanySubsidy(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectCompanySubsidy(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionAchieveOtherPlateIntegral(String op, java.math.BigDecimal val) {
		setConditionAchieveOtherPlateIntegral(op, val, CONDITION_AND);
	}

	public void setConditionAchieveOtherPlateIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectAchieveOtherPlateIntegral(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionSalaryCost(String op, java.math.BigDecimal val) {
		setConditionSalaryCost(op, val, CONDITION_AND);
	}

	public void setConditionSalaryCost(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectSalaryCost(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionPlateCost(String op, java.math.BigDecimal val) {
		setConditionPlateCost(op, val, CONDITION_AND);
	}

	public void setConditionPlateCost(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectPlateCost(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionProjectCost(String op, java.math.BigDecimal val) {
		setConditionProjectCost(op, val, CONDITION_AND);
	}

	public void setConditionProjectCost(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectProjectCost(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionPayCommonPlateIntegral(String op, java.math.BigDecimal val) {
		setConditionPayCommonPlateIntegral(op, val, CONDITION_AND);
	}

	public void setConditionPayCommonPlateIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectPayCommonPlateIntegral(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionPayOtherPlateIntegral(String op, java.math.BigDecimal val) {
		setConditionPayOtherPlateIntegral(op, val, CONDITION_AND);
	}

	public void setConditionPayOtherPlateIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectPayOtherPlateIntegral(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionAchieveIntegral(String op, java.math.BigDecimal val) {
		setConditionAchieveIntegral(op, val, CONDITION_AND);
	}

	public void setConditionAchieveIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectAchieveIntegral(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionAwardSend(String op, java.math.BigDecimal val) {
		setConditionAwardSend(op, val, CONDITION_AND);
	}

	public void setConditionAwardSend(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectAwardSend(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionLeftAchieveIntegral(String op, java.math.BigDecimal val) {
		setConditionLeftAchieveIntegral(op, val, CONDITION_AND);
	}

	public void setConditionLeftAchieveIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectLeftAchieveIntegral(boolean val) {
		__select_flags[12] = val;
	}


}

