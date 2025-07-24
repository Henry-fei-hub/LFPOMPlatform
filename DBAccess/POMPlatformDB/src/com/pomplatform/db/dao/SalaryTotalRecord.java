package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSalaryTotalRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SalaryTotalRecord extends AbstractTable<BaseSalaryTotalRecord>
{

	public SalaryTotalRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 25;

		initTables();

		__tableName            = "salary_total_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSalaryTotalRecord.CS_SALARY_TOTAL_RECORD_ID;
		__column_names[1] = BaseSalaryTotalRecord.CS_COMPANY_ID;
		__column_names[2] = BaseSalaryTotalRecord.CS_PLATE_ID;
		__column_names[3] = BaseSalaryTotalRecord.CS_YEAR;
		__column_names[4] = BaseSalaryTotalRecord.CS_MONTH;
		__column_names[5] = BaseSalaryTotalRecord.CS_TYPE;
		__column_names[6] = BaseSalaryTotalRecord.CS_SHOULD_SALARY;
		__column_names[7] = BaseSalaryTotalRecord.CS_LEAVE_ADVANCE;
		__column_names[8] = BaseSalaryTotalRecord.CS_SHOULD_BONUS;
		__column_names[9] = BaseSalaryTotalRecord.CS_SHOULD_TOTAL;
		__column_names[10] = BaseSalaryTotalRecord.CS_SHOULD_TAX;
		__column_names[11] = BaseSalaryTotalRecord.CS_TOTAL_INSURANCE;
		__column_names[12] = BaseSalaryTotalRecord.CS_PERSONAL_PENSION;
		__column_names[13] = BaseSalaryTotalRecord.CS_PERSONAL_MEDICAL_INSURANCE;
		__column_names[14] = BaseSalaryTotalRecord.CS_PERSONAL_UNEMPLOYMENT_INSURANCE;
		__column_names[15] = BaseSalaryTotalRecord.CS_PERSONAL_LARGE_MEDICAL_INSURANCE;
		__column_names[16] = BaseSalaryTotalRecord.CS_PERSONAL_HEATING;
		__column_names[17] = BaseSalaryTotalRecord.CS_TOTAL_FUND;
		__column_names[18] = BaseSalaryTotalRecord.CS_INSTEAD_DEDUCT;
		__column_names[19] = BaseSalaryTotalRecord.CS_INSTEAD_DEDUCT_ILL;
		__column_names[20] = BaseSalaryTotalRecord.CS_FACT_SALARY;
		__column_names[21] = BaseSalaryTotalRecord.CS_NUM;
		__column_names[22] = BaseSalaryTotalRecord.CS_OPERATE_EMPLOYEE_ID;
		__column_names[23] = BaseSalaryTotalRecord.CS_OPERATE_TIME;
		__column_names[24] = BaseSalaryTotalRecord.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSalaryTotalRecord b) {
		clear();
		setSalaryTotalRecordIdClear(b.getSalaryTotalRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getSalaryTotalRecordId() == null;
	}

	@Override
	public BaseSalaryTotalRecord generateBase(){
		BaseSalaryTotalRecord b = new BaseSalaryTotalRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSalaryTotalRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSalaryTotalRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setShouldSalary(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setLeaveAdvance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setShouldBonus(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setShouldTotal(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setShouldTax(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalInsurance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPersonalPension(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPersonalMedicalInsurance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPersonalUnemploymentInsurance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPersonalLargeMedicalInsurance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPersonalHeating(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalFund(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setInsteadDeduct(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setInsteadDeductIll(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setFactSalary(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setNum(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseSalaryTotalRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSalaryTotalRecordId();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getType();
		buff[count++] = b.getShouldSalary();
		buff[count++] = b.getLeaveAdvance();
		buff[count++] = b.getShouldBonus();
		buff[count++] = b.getShouldTotal();
		buff[count++] = b.getShouldTax();
		buff[count++] = b.getTotalInsurance();
		buff[count++] = b.getPersonalPension();
		buff[count++] = b.getPersonalMedicalInsurance();
		buff[count++] = b.getPersonalUnemploymentInsurance();
		buff[count++] = b.getPersonalLargeMedicalInsurance();
		buff[count++] = b.getPersonalHeating();
		buff[count++] = b.getTotalFund();
		buff[count++] = b.getInsteadDeduct();
		buff[count++] = b.getInsteadDeductIll();
		buff[count++] = b.getFactSalary();
		buff[count++] = b.getNum();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseSalaryTotalRecord b){
		if(b.getSalaryTotalRecordId() != null) setSalaryTotalRecordIdClear(b.getSalaryTotalRecordId());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getType() != null) setType(b.getType());
		if(b.getShouldSalary() != null) setShouldSalary(b.getShouldSalary());
		if(b.getLeaveAdvance() != null) setLeaveAdvance(b.getLeaveAdvance());
		if(b.getShouldBonus() != null) setShouldBonus(b.getShouldBonus());
		if(b.getShouldTotal() != null) setShouldTotal(b.getShouldTotal());
		if(b.getShouldTax() != null) setShouldTax(b.getShouldTax());
		if(b.getTotalInsurance() != null) setTotalInsurance(b.getTotalInsurance());
		if(b.getPersonalPension() != null) setPersonalPension(b.getPersonalPension());
		if(b.getPersonalMedicalInsurance() != null) setPersonalMedicalInsurance(b.getPersonalMedicalInsurance());
		if(b.getPersonalUnemploymentInsurance() != null) setPersonalUnemploymentInsurance(b.getPersonalUnemploymentInsurance());
		if(b.getPersonalLargeMedicalInsurance() != null) setPersonalLargeMedicalInsurance(b.getPersonalLargeMedicalInsurance());
		if(b.getPersonalHeating() != null) setPersonalHeating(b.getPersonalHeating());
		if(b.getTotalFund() != null) setTotalFund(b.getTotalFund());
		if(b.getInsteadDeduct() != null) setInsteadDeduct(b.getInsteadDeduct());
		if(b.getInsteadDeductIll() != null) setInsteadDeductIll(b.getInsteadDeductIll());
		if(b.getFactSalary() != null) setFactSalary(b.getFactSalary());
		if(b.getNum() != null) setNum(b.getNum());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseSalaryTotalRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSalaryTotalRecord b = new BaseSalaryTotalRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSalaryTotalRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalaryTotalRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setShouldSalary(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLeaveAdvance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setShouldBonus(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setShouldTotal(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setShouldTax(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalInsurance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonalPension(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonalMedicalInsurance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonalUnemploymentInsurance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonalLargeMedicalInsurance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonalHeating(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalFund(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInsteadDeduct(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInsteadDeductIll(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFactSalary(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNum(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setSalaryTotalRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSalaryTotalRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSalaryTotalRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setType(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getType() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setShouldSalary(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getShouldSalary() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setLeaveAdvance(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getLeaveAdvance() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setShouldBonus(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getShouldBonus() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setShouldTotal(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getShouldTotal() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setShouldTax(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getShouldTax() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setTotalInsurance(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getTotalInsurance() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setPersonalPension(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getPersonalPension() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setPersonalMedicalInsurance(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getPersonalMedicalInsurance() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setPersonalUnemploymentInsurance(java.math.BigDecimal val) {
		setCurrentData(14, val);
	}

	public java.math.BigDecimal getPersonalUnemploymentInsurance() {
		return GenericBase.__getDecimal(__current_data[14]);
	}

	public void setPersonalLargeMedicalInsurance(java.math.BigDecimal val) {
		setCurrentData(15, val);
	}

	public java.math.BigDecimal getPersonalLargeMedicalInsurance() {
		return GenericBase.__getDecimal(__current_data[15]);
	}

	public void setPersonalHeating(java.math.BigDecimal val) {
		setCurrentData(16, val);
	}

	public java.math.BigDecimal getPersonalHeating() {
		return GenericBase.__getDecimal(__current_data[16]);
	}

	public void setTotalFund(java.math.BigDecimal val) {
		setCurrentData(17, val);
	}

	public java.math.BigDecimal getTotalFund() {
		return GenericBase.__getDecimal(__current_data[17]);
	}

	public void setInsteadDeduct(java.math.BigDecimal val) {
		setCurrentData(18, val);
	}

	public java.math.BigDecimal getInsteadDeduct() {
		return GenericBase.__getDecimal(__current_data[18]);
	}

	public void setInsteadDeductIll(java.math.BigDecimal val) {
		setCurrentData(19, val);
	}

	public java.math.BigDecimal getInsteadDeductIll() {
		return GenericBase.__getDecimal(__current_data[19]);
	}

	public void setFactSalary(java.math.BigDecimal val) {
		setCurrentData(20, val);
	}

	public java.math.BigDecimal getFactSalary() {
		return GenericBase.__getDecimal(__current_data[20]);
	}

	public void setNum(java.lang.Integer val) {
		setCurrentData(21, val);
	}

	public java.lang.Integer getNum() {
		return GenericBase.__getInt(__current_data[21]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(22, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[22]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(23, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[23]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(24, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[24]);
	}

	public void setConditionSalaryTotalRecordId(String op, java.lang.Integer val) {
		setConditionSalaryTotalRecordId(op, val, CONDITION_AND);
	}

	public void setConditionSalaryTotalRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSalaryTotalRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionType(String op, java.lang.Integer val) {
		setConditionType(op, val, CONDITION_AND);
	}

	public void setConditionType(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectType(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionShouldSalary(String op, java.math.BigDecimal val) {
		setConditionShouldSalary(op, val, CONDITION_AND);
	}

	public void setConditionShouldSalary(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectShouldSalary(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionLeaveAdvance(String op, java.math.BigDecimal val) {
		setConditionLeaveAdvance(op, val, CONDITION_AND);
	}

	public void setConditionLeaveAdvance(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectLeaveAdvance(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionShouldBonus(String op, java.math.BigDecimal val) {
		setConditionShouldBonus(op, val, CONDITION_AND);
	}

	public void setConditionShouldBonus(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectShouldBonus(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionShouldTotal(String op, java.math.BigDecimal val) {
		setConditionShouldTotal(op, val, CONDITION_AND);
	}

	public void setConditionShouldTotal(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectShouldTotal(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionShouldTax(String op, java.math.BigDecimal val) {
		setConditionShouldTax(op, val, CONDITION_AND);
	}

	public void setConditionShouldTax(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectShouldTax(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionTotalInsurance(String op, java.math.BigDecimal val) {
		setConditionTotalInsurance(op, val, CONDITION_AND);
	}

	public void setConditionTotalInsurance(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectTotalInsurance(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionPersonalPension(String op, java.math.BigDecimal val) {
		setConditionPersonalPension(op, val, CONDITION_AND);
	}

	public void setConditionPersonalPension(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectPersonalPension(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionPersonalMedicalInsurance(String op, java.math.BigDecimal val) {
		setConditionPersonalMedicalInsurance(op, val, CONDITION_AND);
	}

	public void setConditionPersonalMedicalInsurance(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectPersonalMedicalInsurance(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionPersonalUnemploymentInsurance(String op, java.math.BigDecimal val) {
		setConditionPersonalUnemploymentInsurance(op, val, CONDITION_AND);
	}

	public void setConditionPersonalUnemploymentInsurance(String op, java.math.BigDecimal val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectPersonalUnemploymentInsurance(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionPersonalLargeMedicalInsurance(String op, java.math.BigDecimal val) {
		setConditionPersonalLargeMedicalInsurance(op, val, CONDITION_AND);
	}

	public void setConditionPersonalLargeMedicalInsurance(String op, java.math.BigDecimal val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectPersonalLargeMedicalInsurance(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionPersonalHeating(String op, java.math.BigDecimal val) {
		setConditionPersonalHeating(op, val, CONDITION_AND);
	}

	public void setConditionPersonalHeating(String op, java.math.BigDecimal val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectPersonalHeating(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionTotalFund(String op, java.math.BigDecimal val) {
		setConditionTotalFund(op, val, CONDITION_AND);
	}

	public void setConditionTotalFund(String op, java.math.BigDecimal val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectTotalFund(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionInsteadDeduct(String op, java.math.BigDecimal val) {
		setConditionInsteadDeduct(op, val, CONDITION_AND);
	}

	public void setConditionInsteadDeduct(String op, java.math.BigDecimal val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectInsteadDeduct(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionInsteadDeductIll(String op, java.math.BigDecimal val) {
		setConditionInsteadDeductIll(op, val, CONDITION_AND);
	}

	public void setConditionInsteadDeductIll(String op, java.math.BigDecimal val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectInsteadDeductIll(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionFactSalary(String op, java.math.BigDecimal val) {
		setConditionFactSalary(op, val, CONDITION_AND);
	}

	public void setConditionFactSalary(String op, java.math.BigDecimal val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectFactSalary(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionNum(String op, java.lang.Integer val) {
		setConditionNum(op, val, CONDITION_AND);
	}

	public void setConditionNum(String op, java.lang.Integer val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectNum(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(23, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[24] = val;
	}


}

