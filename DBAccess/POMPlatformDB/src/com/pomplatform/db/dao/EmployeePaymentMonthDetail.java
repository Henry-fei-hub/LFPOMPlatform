package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseEmployeePaymentMonthDetail;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class EmployeePaymentMonthDetail extends AbstractTable<BaseEmployeePaymentMonthDetail>
{

	public EmployeePaymentMonthDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 15;

		initTables();

		__tableName            = "employee_payment_month_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEmployeePaymentMonthDetail.CS_EMPLOYEE_PAYMENT_MONTH_DETAIL_ID;
		__column_names[1] = BaseEmployeePaymentMonthDetail.CS_EMPLOYEE_ID;
		__column_names[2] = BaseEmployeePaymentMonthDetail.CS_YEAR;
		__column_names[3] = BaseEmployeePaymentMonthDetail.CS_MONTH;
		__column_names[4] = BaseEmployeePaymentMonthDetail.CS_MONTH_PAY;
		__column_names[5] = BaseEmployeePaymentMonthDetail.CS_BASIC_PROPORTION_STR;
		__column_names[6] = BaseEmployeePaymentMonthDetail.CS_BASIC_PROPORTION;
		__column_names[7] = BaseEmployeePaymentMonthDetail.CS_MONTH_BASIC_PAY;
		__column_names[8] = BaseEmployeePaymentMonthDetail.CS_MONTH_PERFORMANCE_PAY;
		__column_names[9] = BaseEmployeePaymentMonthDetail.CS_FOREMAN_PAY;
		__column_names[10] = BaseEmployeePaymentMonthDetail.CS_OTHER_SUBSIDY;
		__column_names[11] = BaseEmployeePaymentMonthDetail.CS_TOTAL_PAY;
		__column_names[12] = BaseEmployeePaymentMonthDetail.CS_ANNUAL_PERFORMANCE;
		__column_names[13] = BaseEmployeePaymentMonthDetail.CS_COST_ATTRIBUTION;
		__column_names[14] = BaseEmployeePaymentMonthDetail.CS_ENABLED;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEmployeePaymentMonthDetail b) {
		clear();
		setEmployeePaymentMonthDetailIdClear(b.getEmployeePaymentMonthDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getEmployeePaymentMonthDetailId() == null;
	}

	@Override
	public BaseEmployeePaymentMonthDetail generateBase(){
		BaseEmployeePaymentMonthDetail b = new BaseEmployeePaymentMonthDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEmployeePaymentMonthDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEmployeePaymentMonthDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonthPay(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBasicProportionStr(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBasicProportion(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMonthBasicPay(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMonthPerformancePay(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setForemanPay(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOtherSubsidy(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTotalPay(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAnnualPerformance(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCostAttribution(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEnabled(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseEmployeePaymentMonthDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEmployeePaymentMonthDetailId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getMonthPay();
		buff[count++] = b.getBasicProportionStr();
		buff[count++] = b.getBasicProportion();
		buff[count++] = b.getMonthBasicPay();
		buff[count++] = b.getMonthPerformancePay();
		buff[count++] = b.getForemanPay();
		buff[count++] = b.getOtherSubsidy();
		buff[count++] = b.getTotalPay();
		buff[count++] = b.getAnnualPerformance();
		buff[count++] = b.getCostAttribution();
		buff[count++] = b.getEnabled();
	}

	@Override
	public void setDataFromBase(BaseEmployeePaymentMonthDetail b){
		if(b.getEmployeePaymentMonthDetailId() != null) setEmployeePaymentMonthDetailIdClear(b.getEmployeePaymentMonthDetailId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getMonthPay() != null) setMonthPay(b.getMonthPay());
		if(b.getBasicProportionStr() != null) setBasicProportionStr(b.getBasicProportionStr());
		if(b.getBasicProportion() != null) setBasicProportion(b.getBasicProportion());
		if(b.getMonthBasicPay() != null) setMonthBasicPay(b.getMonthBasicPay());
		if(b.getMonthPerformancePay() != null) setMonthPerformancePay(b.getMonthPerformancePay());
		if(b.getForemanPay() != null) setForemanPay(b.getForemanPay());
		if(b.getOtherSubsidy() != null) setOtherSubsidy(b.getOtherSubsidy());
		if(b.getTotalPay() != null) setTotalPay(b.getTotalPay());
		if(b.getAnnualPerformance() != null) setAnnualPerformance(b.getAnnualPerformance());
		if(b.getCostAttribution() != null) setCostAttribution(b.getCostAttribution());
		if(b.getEnabled() != null) setEnabled(b.getEnabled());
	}

	@Override
	public BaseEmployeePaymentMonthDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEmployeePaymentMonthDetail b = new BaseEmployeePaymentMonthDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEmployeePaymentMonthDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeePaymentMonthDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonthPay(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBasicProportionStr(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBasicProportion(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonthBasicPay(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonthPerformancePay(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setForemanPay(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOtherSubsidy(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalPay(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAnnualPerformance(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCostAttribution(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEnabled(GenericBase.__getBoolean(val));
	}

	public void setEmployeePaymentMonthDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEmployeePaymentMonthDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEmployeePaymentMonthDetailIdClear(java.lang.Integer val) {
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

	public void setMonthPay(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getMonthPay() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setBasicProportionStr(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getBasicProportionStr() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setBasicProportion(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getBasicProportion() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setMonthBasicPay(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getMonthBasicPay() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setMonthPerformancePay(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getMonthPerformancePay() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setForemanPay(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getForemanPay() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setOtherSubsidy(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getOtherSubsidy() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setTotalPay(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getTotalPay() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setAnnualPerformance(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getAnnualPerformance() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setCostAttribution(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getCostAttribution() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setEnabled(java.lang.Boolean val) {
		setCurrentData(14, val);
	}

	public java.lang.Boolean getEnabled() {
		return GenericBase.__getBoolean(__current_data[14]);
	}

	public void setConditionEmployeePaymentMonthDetailId(String op, java.lang.Integer val) {
		setConditionEmployeePaymentMonthDetailId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeePaymentMonthDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEmployeePaymentMonthDetailId(boolean val) {
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

	public void setConditionMonthPay(String op, java.lang.String val) {
		setConditionMonthPay(op, val, CONDITION_AND);
	}

	public void setConditionMonthPay(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectMonthPay(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionBasicProportionStr(String op, java.lang.String val) {
		setConditionBasicProportionStr(op, val, CONDITION_AND);
	}

	public void setConditionBasicProportionStr(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectBasicProportionStr(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionBasicProportion(String op, java.math.BigDecimal val) {
		setConditionBasicProportion(op, val, CONDITION_AND);
	}

	public void setConditionBasicProportion(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectBasicProportion(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionMonthBasicPay(String op, java.lang.String val) {
		setConditionMonthBasicPay(op, val, CONDITION_AND);
	}

	public void setConditionMonthBasicPay(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectMonthBasicPay(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionMonthPerformancePay(String op, java.lang.String val) {
		setConditionMonthPerformancePay(op, val, CONDITION_AND);
	}

	public void setConditionMonthPerformancePay(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectMonthPerformancePay(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionForemanPay(String op, java.lang.String val) {
		setConditionForemanPay(op, val, CONDITION_AND);
	}

	public void setConditionForemanPay(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectForemanPay(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionOtherSubsidy(String op, java.lang.String val) {
		setConditionOtherSubsidy(op, val, CONDITION_AND);
	}

	public void setConditionOtherSubsidy(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectOtherSubsidy(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionTotalPay(String op, java.lang.String val) {
		setConditionTotalPay(op, val, CONDITION_AND);
	}

	public void setConditionTotalPay(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectTotalPay(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionAnnualPerformance(String op, java.lang.String val) {
		setConditionAnnualPerformance(op, val, CONDITION_AND);
	}

	public void setConditionAnnualPerformance(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectAnnualPerformance(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionCostAttribution(String op, java.lang.Integer val) {
		setConditionCostAttribution(op, val, CONDITION_AND);
	}

	public void setConditionCostAttribution(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectCostAttribution(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionEnabled(String op, java.lang.Boolean val) {
		setConditionEnabled(op, val, CONDITION_AND);
	}

	public void setConditionEnabled(String op, java.lang.Boolean val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectEnabled(boolean val) {
		__select_flags[14] = val;
	}


}

