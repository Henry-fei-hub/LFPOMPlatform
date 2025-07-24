package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseEmployeeFundIssuanceDetail;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class EmployeeFundIssuanceDetail extends AbstractTable<BaseEmployeeFundIssuanceDetail>
{

	public EmployeeFundIssuanceDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 16;

		initTables();

		__tableName            = "employee_fund_issuance_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEmployeeFundIssuanceDetail.CS_EMPLOYEE_FUND_ISSUANCE_DETAIL_ID;
		__column_names[1] = BaseEmployeeFundIssuanceDetail.CS_FUNDRAISING_TYPE_ID;
		__column_names[2] = BaseEmployeeFundIssuanceDetail.CS_FUND_TYPE;
		__column_names[3] = BaseEmployeeFundIssuanceDetail.CS_EMPLOYEE_FUND_ISSUANCE_ID;
		__column_names[4] = BaseEmployeeFundIssuanceDetail.CS_EMPLOYEE_ID;
		__column_names[5] = BaseEmployeeFundIssuanceDetail.CS_EMPLOYEE_NO;
		__column_names[6] = BaseEmployeeFundIssuanceDetail.CS_PLATE_ID;
		__column_names[7] = BaseEmployeeFundIssuanceDetail.CS_YEAR;
		__column_names[8] = BaseEmployeeFundIssuanceDetail.CS_MONTH;
		__column_names[9] = BaseEmployeeFundIssuanceDetail.CS_ISSUE_MONEY;
		__column_names[10] = BaseEmployeeFundIssuanceDetail.CS_RATIO;
		__column_names[11] = BaseEmployeeFundIssuanceDetail.CS_AMOUNT_OF_CREDIT;
		__column_names[12] = BaseEmployeeFundIssuanceDetail.CS_TOTAL_MONEY;
		__column_names[13] = BaseEmployeeFundIssuanceDetail.CS_CREATE_TIME;
		__column_names[14] = BaseEmployeeFundIssuanceDetail.CS_PROCESS_STATUS;
		__column_names[15] = BaseEmployeeFundIssuanceDetail.CS_PERSONEL_BUSINESS_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEmployeeFundIssuanceDetail b) {
		clear();
		setEmployeeFundIssuanceDetailIdClear(b.getEmployeeFundIssuanceDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getEmployeeFundIssuanceDetailId() == null;
	}

	@Override
	public BaseEmployeeFundIssuanceDetail generateBase(){
		BaseEmployeeFundIssuanceDetail b = new BaseEmployeeFundIssuanceDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEmployeeFundIssuanceDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEmployeeFundIssuanceDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFundraisingTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFundType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeFundIssuanceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIssueMoney(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRatio(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAmountOfCredit(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalMoney(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setProcessStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPersonelBusinessId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseEmployeeFundIssuanceDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEmployeeFundIssuanceDetailId();
		buff[count++] = b.getFundraisingTypeId();
		buff[count++] = b.getFundType();
		buff[count++] = b.getEmployeeFundIssuanceId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getEmployeeNo();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getIssueMoney();
		buff[count++] = b.getRatio();
		buff[count++] = b.getAmountOfCredit();
		buff[count++] = b.getTotalMoney();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getProcessStatus();
		buff[count++] = b.getPersonelBusinessId();
	}

	@Override
	public void setDataFromBase(BaseEmployeeFundIssuanceDetail b){
		if(b.getEmployeeFundIssuanceDetailId() != null) setEmployeeFundIssuanceDetailIdClear(b.getEmployeeFundIssuanceDetailId());
		if(b.getFundraisingTypeId() != null) setFundraisingTypeId(b.getFundraisingTypeId());
		if(b.getFundType() != null) setFundType(b.getFundType());
		if(b.getEmployeeFundIssuanceId() != null) setEmployeeFundIssuanceId(b.getEmployeeFundIssuanceId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getEmployeeNo() != null) setEmployeeNo(b.getEmployeeNo());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getIssueMoney() != null) setIssueMoney(b.getIssueMoney());
		if(b.getRatio() != null) setRatio(b.getRatio());
		if(b.getAmountOfCredit() != null) setAmountOfCredit(b.getAmountOfCredit());
		if(b.getTotalMoney() != null) setTotalMoney(b.getTotalMoney());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getProcessStatus() != null) setProcessStatus(b.getProcessStatus());
		if(b.getPersonelBusinessId() != null) setPersonelBusinessId(b.getPersonelBusinessId());
	}

	@Override
	public BaseEmployeeFundIssuanceDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEmployeeFundIssuanceDetail b = new BaseEmployeeFundIssuanceDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEmployeeFundIssuanceDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeFundIssuanceDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFundraisingTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFundType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeFundIssuanceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIssueMoney(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRatio(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAmountOfCredit(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalMoney(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonelBusinessId(GenericBase.__getInt(val));
	}

	public void setEmployeeFundIssuanceDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEmployeeFundIssuanceDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEmployeeFundIssuanceDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setFundraisingTypeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getFundraisingTypeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setFundType(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getFundType() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setEmployeeFundIssuanceId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getEmployeeFundIssuanceId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setEmployeeNo(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getEmployeeNo() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setIssueMoney(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getIssueMoney() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setRatio(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getRatio() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setAmountOfCredit(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getAmountOfCredit() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setTotalMoney(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getTotalMoney() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(13, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[13]);
	}

	public void setProcessStatus(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getProcessStatus() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setPersonelBusinessId(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getPersonelBusinessId() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setConditionEmployeeFundIssuanceDetailId(String op, java.lang.Integer val) {
		setConditionEmployeeFundIssuanceDetailId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeFundIssuanceDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEmployeeFundIssuanceDetailId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionFundraisingTypeId(String op, java.lang.Integer val) {
		setConditionFundraisingTypeId(op, val, CONDITION_AND);
	}

	public void setConditionFundraisingTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectFundraisingTypeId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionFundType(String op, java.lang.Integer val) {
		setConditionFundType(op, val, CONDITION_AND);
	}

	public void setConditionFundType(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectFundType(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionEmployeeFundIssuanceId(String op, java.lang.Integer val) {
		setConditionEmployeeFundIssuanceId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeFundIssuanceId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectEmployeeFundIssuanceId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionEmployeeNo(String op, java.lang.String val) {
		setConditionEmployeeNo(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeNo(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectEmployeeNo(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionIssueMoney(String op, java.math.BigDecimal val) {
		setConditionIssueMoney(op, val, CONDITION_AND);
	}

	public void setConditionIssueMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectIssueMoney(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionRatio(String op, java.math.BigDecimal val) {
		setConditionRatio(op, val, CONDITION_AND);
	}

	public void setConditionRatio(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectRatio(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionAmountOfCredit(String op, java.math.BigDecimal val) {
		setConditionAmountOfCredit(op, val, CONDITION_AND);
	}

	public void setConditionAmountOfCredit(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectAmountOfCredit(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionTotalMoney(String op, java.math.BigDecimal val) {
		setConditionTotalMoney(op, val, CONDITION_AND);
	}

	public void setConditionTotalMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectTotalMoney(boolean val) {
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

	public void setConditionProcessStatus(String op, java.lang.Integer val) {
		setConditionProcessStatus(op, val, CONDITION_AND);
	}

	public void setConditionProcessStatus(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectProcessStatus(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionPersonelBusinessId(String op, java.lang.Integer val) {
		setConditionPersonelBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionPersonelBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectPersonelBusinessId(boolean val) {
		__select_flags[15] = val;
	}


}

