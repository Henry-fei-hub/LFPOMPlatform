package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSalaryJobSubsidy;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SalaryJobSubsidy extends AbstractTable<BaseSalaryJobSubsidy>
{

	public SalaryJobSubsidy() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 17;

		initTables();

		__tableName            = "salary_job_subsidys";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSalaryJobSubsidy.CS_SALARY_JOB_SUBSIDY_ID;
		__column_names[1] = BaseSalaryJobSubsidy.CS_EMPLOYEE_ID;
		__column_names[2] = BaseSalaryJobSubsidy.CS_YEAR;
		__column_names[3] = BaseSalaryJobSubsidy.CS_MONTH;
		__column_names[4] = BaseSalaryJobSubsidy.CS_RECORD_DATE;
		__column_names[5] = BaseSalaryJobSubsidy.CS_MILEAGE_SUBSIDY;
		__column_names[6] = BaseSalaryJobSubsidy.CS_ATTENTION_SUBSIDY;
		__column_names[7] = BaseSalaryJobSubsidy.CS_SALARY_SUBSIDY;
		__column_names[8] = BaseSalaryJobSubsidy.CS_LEAVE_SUBSIDY;
		__column_names[9] = BaseSalaryJobSubsidy.CS_PERFORMANCE_SUBSIDY;
		__column_names[10] = BaseSalaryJobSubsidy.CS_WORK_SITE_SUBSIDY;
		__column_names[11] = BaseSalaryJobSubsidy.CS_POSITIVE_ACCOUNT;
		__column_names[12] = BaseSalaryJobSubsidy.CS_TOTAL_AMOUNT;
		__column_names[13] = BaseSalaryJobSubsidy.CS_IS_SENDED;
		__column_names[14] = BaseSalaryJobSubsidy.CS_OPERATE_EMPLOYEE_ID;
		__column_names[15] = BaseSalaryJobSubsidy.CS_OPERATE_TIME;
		__column_names[16] = BaseSalaryJobSubsidy.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSalaryJobSubsidy b) {
		clear();
		setSalaryJobSubsidyIdClear(b.getSalaryJobSubsidyId());
	}

	public boolean isPrimaryKeyNull() {
		return getSalaryJobSubsidyId() == null;
	}

	@Override
	public BaseSalaryJobSubsidy generateBase(){
		BaseSalaryJobSubsidy b = new BaseSalaryJobSubsidy();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSalaryJobSubsidy b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSalaryJobSubsidyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setMileageSubsidy(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAttentionSubsidy(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSalarySubsidy(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setLeaveSubsidy(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPerformanceSubsidy(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setWorkSiteSubsidy(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPositiveAccount(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTotalAmount(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsSended(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseSalaryJobSubsidy b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSalaryJobSubsidyId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = b.getMileageSubsidy();
		buff[count++] = b.getAttentionSubsidy();
		buff[count++] = b.getSalarySubsidy();
		buff[count++] = b.getLeaveSubsidy();
		buff[count++] = b.getPerformanceSubsidy();
		buff[count++] = b.getWorkSiteSubsidy();
		buff[count++] = b.getPositiveAccount();
		buff[count++] = b.getTotalAmount();
		buff[count++] = b.getIsSended();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseSalaryJobSubsidy b){
		if(b.getSalaryJobSubsidyId() != null) setSalaryJobSubsidyIdClear(b.getSalaryJobSubsidyId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getMileageSubsidy() != null) setMileageSubsidy(b.getMileageSubsidy());
		if(b.getAttentionSubsidy() != null) setAttentionSubsidy(b.getAttentionSubsidy());
		if(b.getSalarySubsidy() != null) setSalarySubsidy(b.getSalarySubsidy());
		if(b.getLeaveSubsidy() != null) setLeaveSubsidy(b.getLeaveSubsidy());
		if(b.getPerformanceSubsidy() != null) setPerformanceSubsidy(b.getPerformanceSubsidy());
		if(b.getWorkSiteSubsidy() != null) setWorkSiteSubsidy(b.getWorkSiteSubsidy());
		if(b.getPositiveAccount() != null) setPositiveAccount(b.getPositiveAccount());
		if(b.getTotalAmount() != null) setTotalAmount(b.getTotalAmount());
		if(b.getIsSended() != null) setIsSended(b.getIsSended());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseSalaryJobSubsidy generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSalaryJobSubsidy b = new BaseSalaryJobSubsidy();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSalaryJobSubsidy __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalaryJobSubsidyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMileageSubsidy(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttentionSubsidy(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalarySubsidy(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLeaveSubsidy(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPerformanceSubsidy(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkSiteSubsidy(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPositiveAccount(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalAmount(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsSended(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setSalaryJobSubsidyId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSalaryJobSubsidyId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSalaryJobSubsidyIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
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

	public void setRecordDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setMileageSubsidy(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getMileageSubsidy() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setAttentionSubsidy(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getAttentionSubsidy() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setSalarySubsidy(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getSalarySubsidy() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setLeaveSubsidy(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getLeaveSubsidy() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setPerformanceSubsidy(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getPerformanceSubsidy() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setWorkSiteSubsidy(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getWorkSiteSubsidy() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setPositiveAccount(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getPositiveAccount() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setTotalAmount(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getTotalAmount() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setIsSended(java.lang.Boolean val) {
		setCurrentData(13, val);
	}

	public java.lang.Boolean getIsSended() {
		return GenericBase.__getBoolean(__current_data[13]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(15, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[15]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(16, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[16]);
	}

	public void setConditionSalaryJobSubsidyId(String op, java.lang.Integer val) {
		setConditionSalaryJobSubsidyId(op, val, CONDITION_AND);
	}

	public void setConditionSalaryJobSubsidyId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSalaryJobSubsidyId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
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

	public void setConditionRecordDate(String op, java.util.Date val) {
		setConditionRecordDate(op, val, CONDITION_AND);
	}

	public void setConditionRecordDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionMileageSubsidy(String op, java.lang.String val) {
		setConditionMileageSubsidy(op, val, CONDITION_AND);
	}

	public void setConditionMileageSubsidy(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectMileageSubsidy(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionAttentionSubsidy(String op, java.lang.String val) {
		setConditionAttentionSubsidy(op, val, CONDITION_AND);
	}

	public void setConditionAttentionSubsidy(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectAttentionSubsidy(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionSalarySubsidy(String op, java.lang.String val) {
		setConditionSalarySubsidy(op, val, CONDITION_AND);
	}

	public void setConditionSalarySubsidy(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectSalarySubsidy(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionLeaveSubsidy(String op, java.lang.String val) {
		setConditionLeaveSubsidy(op, val, CONDITION_AND);
	}

	public void setConditionLeaveSubsidy(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectLeaveSubsidy(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionPerformanceSubsidy(String op, java.lang.String val) {
		setConditionPerformanceSubsidy(op, val, CONDITION_AND);
	}

	public void setConditionPerformanceSubsidy(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectPerformanceSubsidy(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionWorkSiteSubsidy(String op, java.lang.String val) {
		setConditionWorkSiteSubsidy(op, val, CONDITION_AND);
	}

	public void setConditionWorkSiteSubsidy(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectWorkSiteSubsidy(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionPositiveAccount(String op, java.lang.String val) {
		setConditionPositiveAccount(op, val, CONDITION_AND);
	}

	public void setConditionPositiveAccount(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectPositiveAccount(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionTotalAmount(String op, java.lang.String val) {
		setConditionTotalAmount(op, val, CONDITION_AND);
	}

	public void setConditionTotalAmount(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectTotalAmount(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionIsSended(String op, java.lang.Boolean val) {
		setConditionIsSended(op, val, CONDITION_AND);
	}

	public void setConditionIsSended(String op, java.lang.Boolean val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectIsSended(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(15, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[16] = val;
	}


}

