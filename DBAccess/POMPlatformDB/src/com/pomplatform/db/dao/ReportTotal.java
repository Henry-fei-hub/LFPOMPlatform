package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseReportTotal;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ReportTotal extends AbstractTable<BaseReportTotal>
{

	public ReportTotal() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 33;

		initTables();

		__tableName            = "report_totals";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseReportTotal.CS_REPORT_TOTAL_ID;
		__column_names[1] = BaseReportTotal.CS_PLATE_ID;
		__column_names[2] = BaseReportTotal.CS_YEAR;
		__column_names[3] = BaseReportTotal.CS_MONTH_REVENUE;
		__column_names[4] = BaseReportTotal.CS_TOTAL_REVENUE;
		__column_names[5] = BaseReportTotal.CS_MONTH_CAPITAL_PLATE;
		__column_names[6] = BaseReportTotal.CS_TOTAL_CAPITAL_PLATE;
		__column_names[7] = BaseReportTotal.CS_MONTH_CAPITAL_PROJECT;
		__column_names[8] = BaseReportTotal.CS_TOTAL_CAPITAL_PROJECT;
		__column_names[9] = BaseReportTotal.CS_MONTH_SURE_INTEGRAL_PLATE;
		__column_names[10] = BaseReportTotal.CS_TOTAL_SURE_INTEGRAL_PLATE;
		__column_names[11] = BaseReportTotal.CS_MONTH_SURE_INTEGRAL_PROJECT;
		__column_names[12] = BaseReportTotal.CS_TOTAL_SURE_INTEGRAL_PROJECT;
		__column_names[13] = BaseReportTotal.CS_MONTH_SALARY;
		__column_names[14] = BaseReportTotal.CS_TOTAL_SALARY;
		__column_names[15] = BaseReportTotal.CS_MONTH_COST_PLATE;
		__column_names[16] = BaseReportTotal.CS_TOTAL_COST_PLATE;
		__column_names[17] = BaseReportTotal.CS_MONTH_COST_PROJECT;
		__column_names[18] = BaseReportTotal.CS_TOTAL_COST_PROJECT;
		__column_names[19] = BaseReportTotal.CS_MONTH_COST_PROJECT_BEFORE;
		__column_names[20] = BaseReportTotal.CS_TOTAL_COST_PROJECT_BEFORE;
		__column_names[21] = BaseReportTotal.CS_MONTH_NEW_CONTRACT;
		__column_names[22] = BaseReportTotal.CS_TOTAL_NEW_CONTRACT;
		__column_names[23] = BaseReportTotal.CS_CONTRACT_TOTAL;
		__column_names[24] = BaseReportTotal.CS_AVERAGE_EMP_NUM;
		__column_names[25] = BaseReportTotal.CS_MIN_EMP_NUM;
		__column_names[26] = BaseReportTotal.CS_YEAR_AVERAGE_EMP_REVENUE;
		__column_names[27] = BaseReportTotal.CS_YEAR_CAPITAL;
		__column_names[28] = BaseReportTotal.CS_BENEFIT;
		__column_names[29] = BaseReportTotal.CS_YEAR_REVENUE;
		__column_names[30] = BaseReportTotal.CS_OPERATE_EMPLOYEE_ID;
		__column_names[31] = BaseReportTotal.CS_OPERATE_TIME;
		__column_names[32] = BaseReportTotal.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseReportTotal b) {
		clear();
		setReportTotalIdClear(b.getReportTotalId());
	}

	public boolean isPrimaryKeyNull() {
		return getReportTotalId() == null;
	}

	@Override
	public BaseReportTotal generateBase(){
		BaseReportTotal b = new BaseReportTotal();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseReportTotal b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setReportTotalId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonthRevenue(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalRevenue(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMonthCapitalPlate(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalCapitalPlate(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMonthCapitalProject(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalCapitalProject(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMonthSureIntegralPlate(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalSureIntegralPlate(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMonthSureIntegralProject(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalSureIntegralProject(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMonthSalary(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalSalary(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMonthCostPlate(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalCostPlate(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMonthCostProject(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalCostProject(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMonthCostProjectBefore(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalCostProjectBefore(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMonthNewContract(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalNewContract(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setContractTotal(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAverageEmpNum(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMinEmpNum(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYearAverageEmpRevenue(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setYearCapital(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setBenefit(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setYearRevenue(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseReportTotal b, Object[] buff){
		int count = 0;
		buff[count++] = b.getReportTotalId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonthRevenue();
		buff[count++] = b.getTotalRevenue();
		buff[count++] = b.getMonthCapitalPlate();
		buff[count++] = b.getTotalCapitalPlate();
		buff[count++] = b.getMonthCapitalProject();
		buff[count++] = b.getTotalCapitalProject();
		buff[count++] = b.getMonthSureIntegralPlate();
		buff[count++] = b.getTotalSureIntegralPlate();
		buff[count++] = b.getMonthSureIntegralProject();
		buff[count++] = b.getTotalSureIntegralProject();
		buff[count++] = b.getMonthSalary();
		buff[count++] = b.getTotalSalary();
		buff[count++] = b.getMonthCostPlate();
		buff[count++] = b.getTotalCostPlate();
		buff[count++] = b.getMonthCostProject();
		buff[count++] = b.getTotalCostProject();
		buff[count++] = b.getMonthCostProjectBefore();
		buff[count++] = b.getTotalCostProjectBefore();
		buff[count++] = b.getMonthNewContract();
		buff[count++] = b.getTotalNewContract();
		buff[count++] = b.getContractTotal();
		buff[count++] = b.getAverageEmpNum();
		buff[count++] = b.getMinEmpNum();
		buff[count++] = b.getYearAverageEmpRevenue();
		buff[count++] = b.getYearCapital();
		buff[count++] = b.getBenefit();
		buff[count++] = b.getYearRevenue();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseReportTotal b){
		if(b.getReportTotalId() != null) setReportTotalIdClear(b.getReportTotalId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonthRevenue() != null) setMonthRevenue(b.getMonthRevenue());
		if(b.getTotalRevenue() != null) setTotalRevenue(b.getTotalRevenue());
		if(b.getMonthCapitalPlate() != null) setMonthCapitalPlate(b.getMonthCapitalPlate());
		if(b.getTotalCapitalPlate() != null) setTotalCapitalPlate(b.getTotalCapitalPlate());
		if(b.getMonthCapitalProject() != null) setMonthCapitalProject(b.getMonthCapitalProject());
		if(b.getTotalCapitalProject() != null) setTotalCapitalProject(b.getTotalCapitalProject());
		if(b.getMonthSureIntegralPlate() != null) setMonthSureIntegralPlate(b.getMonthSureIntegralPlate());
		if(b.getTotalSureIntegralPlate() != null) setTotalSureIntegralPlate(b.getTotalSureIntegralPlate());
		if(b.getMonthSureIntegralProject() != null) setMonthSureIntegralProject(b.getMonthSureIntegralProject());
		if(b.getTotalSureIntegralProject() != null) setTotalSureIntegralProject(b.getTotalSureIntegralProject());
		if(b.getMonthSalary() != null) setMonthSalary(b.getMonthSalary());
		if(b.getTotalSalary() != null) setTotalSalary(b.getTotalSalary());
		if(b.getMonthCostPlate() != null) setMonthCostPlate(b.getMonthCostPlate());
		if(b.getTotalCostPlate() != null) setTotalCostPlate(b.getTotalCostPlate());
		if(b.getMonthCostProject() != null) setMonthCostProject(b.getMonthCostProject());
		if(b.getTotalCostProject() != null) setTotalCostProject(b.getTotalCostProject());
		if(b.getMonthCostProjectBefore() != null) setMonthCostProjectBefore(b.getMonthCostProjectBefore());
		if(b.getTotalCostProjectBefore() != null) setTotalCostProjectBefore(b.getTotalCostProjectBefore());
		if(b.getMonthNewContract() != null) setMonthNewContract(b.getMonthNewContract());
		if(b.getTotalNewContract() != null) setTotalNewContract(b.getTotalNewContract());
		if(b.getContractTotal() != null) setContractTotal(b.getContractTotal());
		if(b.getAverageEmpNum() != null) setAverageEmpNum(b.getAverageEmpNum());
		if(b.getMinEmpNum() != null) setMinEmpNum(b.getMinEmpNum());
		if(b.getYearAverageEmpRevenue() != null) setYearAverageEmpRevenue(b.getYearAverageEmpRevenue());
		if(b.getYearCapital() != null) setYearCapital(b.getYearCapital());
		if(b.getBenefit() != null) setBenefit(b.getBenefit());
		if(b.getYearRevenue() != null) setYearRevenue(b.getYearRevenue());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseReportTotal generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseReportTotal b = new BaseReportTotal();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseReportTotal __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReportTotalId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonthRevenue(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalRevenue(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonthCapitalPlate(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalCapitalPlate(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonthCapitalProject(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalCapitalProject(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonthSureIntegralPlate(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalSureIntegralPlate(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonthSureIntegralProject(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalSureIntegralProject(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonthSalary(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalSalary(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonthCostPlate(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalCostPlate(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonthCostProject(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalCostProject(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonthCostProjectBefore(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalCostProjectBefore(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonthNewContract(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalNewContract(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractTotal(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAverageEmpNum(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMinEmpNum(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYearAverageEmpRevenue(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYearCapital(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBenefit(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYearRevenue(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setReportTotalId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getReportTotalId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setReportTotalIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setMonthRevenue(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getMonthRevenue() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setTotalRevenue(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getTotalRevenue() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setMonthCapitalPlate(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getMonthCapitalPlate() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setTotalCapitalPlate(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getTotalCapitalPlate() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setMonthCapitalProject(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getMonthCapitalProject() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setTotalCapitalProject(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getTotalCapitalProject() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setMonthSureIntegralPlate(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getMonthSureIntegralPlate() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setTotalSureIntegralPlate(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getTotalSureIntegralPlate() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setMonthSureIntegralProject(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getMonthSureIntegralProject() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setTotalSureIntegralProject(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getTotalSureIntegralProject() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setMonthSalary(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getMonthSalary() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setTotalSalary(java.math.BigDecimal val) {
		setCurrentData(14, val);
	}

	public java.math.BigDecimal getTotalSalary() {
		return GenericBase.__getDecimal(__current_data[14]);
	}

	public void setMonthCostPlate(java.math.BigDecimal val) {
		setCurrentData(15, val);
	}

	public java.math.BigDecimal getMonthCostPlate() {
		return GenericBase.__getDecimal(__current_data[15]);
	}

	public void setTotalCostPlate(java.math.BigDecimal val) {
		setCurrentData(16, val);
	}

	public java.math.BigDecimal getTotalCostPlate() {
		return GenericBase.__getDecimal(__current_data[16]);
	}

	public void setMonthCostProject(java.math.BigDecimal val) {
		setCurrentData(17, val);
	}

	public java.math.BigDecimal getMonthCostProject() {
		return GenericBase.__getDecimal(__current_data[17]);
	}

	public void setTotalCostProject(java.math.BigDecimal val) {
		setCurrentData(18, val);
	}

	public java.math.BigDecimal getTotalCostProject() {
		return GenericBase.__getDecimal(__current_data[18]);
	}

	public void setMonthCostProjectBefore(java.math.BigDecimal val) {
		setCurrentData(19, val);
	}

	public java.math.BigDecimal getMonthCostProjectBefore() {
		return GenericBase.__getDecimal(__current_data[19]);
	}

	public void setTotalCostProjectBefore(java.math.BigDecimal val) {
		setCurrentData(20, val);
	}

	public java.math.BigDecimal getTotalCostProjectBefore() {
		return GenericBase.__getDecimal(__current_data[20]);
	}

	public void setMonthNewContract(java.math.BigDecimal val) {
		setCurrentData(21, val);
	}

	public java.math.BigDecimal getMonthNewContract() {
		return GenericBase.__getDecimal(__current_data[21]);
	}

	public void setTotalNewContract(java.math.BigDecimal val) {
		setCurrentData(22, val);
	}

	public java.math.BigDecimal getTotalNewContract() {
		return GenericBase.__getDecimal(__current_data[22]);
	}

	public void setContractTotal(java.math.BigDecimal val) {
		setCurrentData(23, val);
	}

	public java.math.BigDecimal getContractTotal() {
		return GenericBase.__getDecimal(__current_data[23]);
	}

	public void setAverageEmpNum(java.math.BigDecimal val) {
		setCurrentData(24, val);
	}

	public java.math.BigDecimal getAverageEmpNum() {
		return GenericBase.__getDecimal(__current_data[24]);
	}

	public void setMinEmpNum(java.lang.Integer val) {
		setCurrentData(25, val);
	}

	public java.lang.Integer getMinEmpNum() {
		return GenericBase.__getInt(__current_data[25]);
	}

	public void setYearAverageEmpRevenue(java.math.BigDecimal val) {
		setCurrentData(26, val);
	}

	public java.math.BigDecimal getYearAverageEmpRevenue() {
		return GenericBase.__getDecimal(__current_data[26]);
	}

	public void setYearCapital(java.math.BigDecimal val) {
		setCurrentData(27, val);
	}

	public java.math.BigDecimal getYearCapital() {
		return GenericBase.__getDecimal(__current_data[27]);
	}

	public void setBenefit(java.math.BigDecimal val) {
		setCurrentData(28, val);
	}

	public java.math.BigDecimal getBenefit() {
		return GenericBase.__getDecimal(__current_data[28]);
	}

	public void setYearRevenue(java.math.BigDecimal val) {
		setCurrentData(29, val);
	}

	public java.math.BigDecimal getYearRevenue() {
		return GenericBase.__getDecimal(__current_data[29]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(30, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[30]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(31, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[31]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(32, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[32]);
	}

	public void setConditionReportTotalId(String op, java.lang.Integer val) {
		setConditionReportTotalId(op, val, CONDITION_AND);
	}

	public void setConditionReportTotalId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectReportTotalId(boolean val) {
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

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionMonthRevenue(String op, java.math.BigDecimal val) {
		setConditionMonthRevenue(op, val, CONDITION_AND);
	}

	public void setConditionMonthRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectMonthRevenue(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionTotalRevenue(String op, java.math.BigDecimal val) {
		setConditionTotalRevenue(op, val, CONDITION_AND);
	}

	public void setConditionTotalRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectTotalRevenue(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionMonthCapitalPlate(String op, java.math.BigDecimal val) {
		setConditionMonthCapitalPlate(op, val, CONDITION_AND);
	}

	public void setConditionMonthCapitalPlate(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectMonthCapitalPlate(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionTotalCapitalPlate(String op, java.math.BigDecimal val) {
		setConditionTotalCapitalPlate(op, val, CONDITION_AND);
	}

	public void setConditionTotalCapitalPlate(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectTotalCapitalPlate(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionMonthCapitalProject(String op, java.math.BigDecimal val) {
		setConditionMonthCapitalProject(op, val, CONDITION_AND);
	}

	public void setConditionMonthCapitalProject(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectMonthCapitalProject(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionTotalCapitalProject(String op, java.math.BigDecimal val) {
		setConditionTotalCapitalProject(op, val, CONDITION_AND);
	}

	public void setConditionTotalCapitalProject(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectTotalCapitalProject(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionMonthSureIntegralPlate(String op, java.math.BigDecimal val) {
		setConditionMonthSureIntegralPlate(op, val, CONDITION_AND);
	}

	public void setConditionMonthSureIntegralPlate(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectMonthSureIntegralPlate(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionTotalSureIntegralPlate(String op, java.math.BigDecimal val) {
		setConditionTotalSureIntegralPlate(op, val, CONDITION_AND);
	}

	public void setConditionTotalSureIntegralPlate(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectTotalSureIntegralPlate(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionMonthSureIntegralProject(String op, java.math.BigDecimal val) {
		setConditionMonthSureIntegralProject(op, val, CONDITION_AND);
	}

	public void setConditionMonthSureIntegralProject(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectMonthSureIntegralProject(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionTotalSureIntegralProject(String op, java.math.BigDecimal val) {
		setConditionTotalSureIntegralProject(op, val, CONDITION_AND);
	}

	public void setConditionTotalSureIntegralProject(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectTotalSureIntegralProject(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionMonthSalary(String op, java.math.BigDecimal val) {
		setConditionMonthSalary(op, val, CONDITION_AND);
	}

	public void setConditionMonthSalary(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectMonthSalary(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionTotalSalary(String op, java.math.BigDecimal val) {
		setConditionTotalSalary(op, val, CONDITION_AND);
	}

	public void setConditionTotalSalary(String op, java.math.BigDecimal val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectTotalSalary(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionMonthCostPlate(String op, java.math.BigDecimal val) {
		setConditionMonthCostPlate(op, val, CONDITION_AND);
	}

	public void setConditionMonthCostPlate(String op, java.math.BigDecimal val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectMonthCostPlate(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionTotalCostPlate(String op, java.math.BigDecimal val) {
		setConditionTotalCostPlate(op, val, CONDITION_AND);
	}

	public void setConditionTotalCostPlate(String op, java.math.BigDecimal val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectTotalCostPlate(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionMonthCostProject(String op, java.math.BigDecimal val) {
		setConditionMonthCostProject(op, val, CONDITION_AND);
	}

	public void setConditionMonthCostProject(String op, java.math.BigDecimal val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectMonthCostProject(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionTotalCostProject(String op, java.math.BigDecimal val) {
		setConditionTotalCostProject(op, val, CONDITION_AND);
	}

	public void setConditionTotalCostProject(String op, java.math.BigDecimal val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectTotalCostProject(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionMonthCostProjectBefore(String op, java.math.BigDecimal val) {
		setConditionMonthCostProjectBefore(op, val, CONDITION_AND);
	}

	public void setConditionMonthCostProjectBefore(String op, java.math.BigDecimal val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectMonthCostProjectBefore(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionTotalCostProjectBefore(String op, java.math.BigDecimal val) {
		setConditionTotalCostProjectBefore(op, val, CONDITION_AND);
	}

	public void setConditionTotalCostProjectBefore(String op, java.math.BigDecimal val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectTotalCostProjectBefore(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionMonthNewContract(String op, java.math.BigDecimal val) {
		setConditionMonthNewContract(op, val, CONDITION_AND);
	}

	public void setConditionMonthNewContract(String op, java.math.BigDecimal val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectMonthNewContract(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionTotalNewContract(String op, java.math.BigDecimal val) {
		setConditionTotalNewContract(op, val, CONDITION_AND);
	}

	public void setConditionTotalNewContract(String op, java.math.BigDecimal val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectTotalNewContract(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionContractTotal(String op, java.math.BigDecimal val) {
		setConditionContractTotal(op, val, CONDITION_AND);
	}

	public void setConditionContractTotal(String op, java.math.BigDecimal val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectContractTotal(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionAverageEmpNum(String op, java.math.BigDecimal val) {
		setConditionAverageEmpNum(op, val, CONDITION_AND);
	}

	public void setConditionAverageEmpNum(String op, java.math.BigDecimal val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectAverageEmpNum(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionMinEmpNum(String op, java.lang.Integer val) {
		setConditionMinEmpNum(op, val, CONDITION_AND);
	}

	public void setConditionMinEmpNum(String op, java.lang.Integer val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectMinEmpNum(boolean val) {
		__select_flags[25] = val;
	}

	public void setConditionYearAverageEmpRevenue(String op, java.math.BigDecimal val) {
		setConditionYearAverageEmpRevenue(op, val, CONDITION_AND);
	}

	public void setConditionYearAverageEmpRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectYearAverageEmpRevenue(boolean val) {
		__select_flags[26] = val;
	}

	public void setConditionYearCapital(String op, java.math.BigDecimal val) {
		setConditionYearCapital(op, val, CONDITION_AND);
	}

	public void setConditionYearCapital(String op, java.math.BigDecimal val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectYearCapital(boolean val) {
		__select_flags[27] = val;
	}

	public void setConditionBenefit(String op, java.math.BigDecimal val) {
		setConditionBenefit(op, val, CONDITION_AND);
	}

	public void setConditionBenefit(String op, java.math.BigDecimal val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectBenefit(boolean val) {
		__select_flags[28] = val;
	}

	public void setConditionYearRevenue(String op, java.math.BigDecimal val) {
		setConditionYearRevenue(op, val, CONDITION_AND);
	}

	public void setConditionYearRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectYearRevenue(boolean val) {
		__select_flags[29] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(30, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[30] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(31, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[31] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(32, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[32] = val;
	}


}

