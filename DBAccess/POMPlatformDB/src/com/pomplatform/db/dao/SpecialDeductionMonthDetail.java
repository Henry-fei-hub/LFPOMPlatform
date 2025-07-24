package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseSpecialDeductionMonthDetail;


public class SpecialDeductionMonthDetail extends AbstractTable<BaseSpecialDeductionMonthDetail>
{

	public SpecialDeductionMonthDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 17;

		initTables();

		__tableName            = "special_deduction_month_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSpecialDeductionMonthDetail.CS_SPECIAL_DEDUCTION_MONTH_DETAIL_ID;
		__column_names[1] = BaseSpecialDeductionMonthDetail.CS_EMPLOYEE_ID;
		__column_names[2] = BaseSpecialDeductionMonthDetail.CS_EMPLOYEE_NO;
		__column_names[3] = BaseSpecialDeductionMonthDetail.CS_DEPARTMENT_ID;
		__column_names[4] = BaseSpecialDeductionMonthDetail.CS_PLATE_ID;
		__column_names[5] = BaseSpecialDeductionMonthDetail.CS_YEAR;
		__column_names[6] = BaseSpecialDeductionMonthDetail.CS_MONTH;
		__column_names[7] = BaseSpecialDeductionMonthDetail.CS_AMOUNT;
		__column_names[8] = BaseSpecialDeductionMonthDetail.CS_CREATE_TIME;
		__column_names[9] = BaseSpecialDeductionMonthDetail.CS_SPECIAL_DEDUCTION_TYPE_IDS;
		__column_names[10] = BaseSpecialDeductionMonthDetail.CS_SPECIAL_DEDUCTION_DETAIL_IDS;
		__column_names[11] = BaseSpecialDeductionMonthDetail.CS_SPECIAL_DUDUCT_1;
		__column_names[12] = BaseSpecialDeductionMonthDetail.CS_SPECIAL_DUDUCT_2;
		__column_names[13] = BaseSpecialDeductionMonthDetail.CS_SPECIAL_DUDUCT_3;
		__column_names[14] = BaseSpecialDeductionMonthDetail.CS_SPECIAL_DUDUCT_4;
		__column_names[15] = BaseSpecialDeductionMonthDetail.CS_SPECIAL_DUDUCT_5;
		__column_names[16] = BaseSpecialDeductionMonthDetail.CS_SPECIAL_DUDUCT_6;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSpecialDeductionMonthDetail b) {
		clear();
		setSpecialDeductionMonthDetailIdClear(b.getSpecialDeductionMonthDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getSpecialDeductionMonthDetailId() == null;
	}

	@Override
	public BaseSpecialDeductionMonthDetail generateBase(){
		BaseSpecialDeductionMonthDetail b = new BaseSpecialDeductionMonthDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSpecialDeductionMonthDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSpecialDeductionMonthDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setSpecialDeductionTypeIds(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSpecialDeductionDetailIds(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSpecialDuduct1(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSpecialDuduct2(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSpecialDuduct3(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSpecialDuduct4(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSpecialDuduct5(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSpecialDuduct6(GenericBase.__getDecimal(val));
	}

	@Override
	public void setBaseToBuffer(BaseSpecialDeductionMonthDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSpecialDeductionMonthDetailId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getEmployeeNo();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getAmount();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getSpecialDeductionTypeIds();
		buff[count++] = b.getSpecialDeductionDetailIds();
		buff[count++] = b.getSpecialDuduct1();
		buff[count++] = b.getSpecialDuduct2();
		buff[count++] = b.getSpecialDuduct3();
		buff[count++] = b.getSpecialDuduct4();
		buff[count++] = b.getSpecialDuduct5();
		buff[count++] = b.getSpecialDuduct6();
	}

	@Override
	public void setDataFromBase(BaseSpecialDeductionMonthDetail b){
		if(b.getSpecialDeductionMonthDetailId() != null) setSpecialDeductionMonthDetailIdClear(b.getSpecialDeductionMonthDetailId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getEmployeeNo() != null) setEmployeeNo(b.getEmployeeNo());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getAmount() != null) setAmount(b.getAmount());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getSpecialDeductionTypeIds() != null) setSpecialDeductionTypeIds(b.getSpecialDeductionTypeIds());
		if(b.getSpecialDeductionDetailIds() != null) setSpecialDeductionDetailIds(b.getSpecialDeductionDetailIds());
		if(b.getSpecialDuduct1() != null) setSpecialDuduct1(b.getSpecialDuduct1());
		if(b.getSpecialDuduct2() != null) setSpecialDuduct2(b.getSpecialDuduct2());
		if(b.getSpecialDuduct3() != null) setSpecialDuduct3(b.getSpecialDuduct3());
		if(b.getSpecialDuduct4() != null) setSpecialDuduct4(b.getSpecialDuduct4());
		if(b.getSpecialDuduct5() != null) setSpecialDuduct5(b.getSpecialDuduct5());
		if(b.getSpecialDuduct6() != null) setSpecialDuduct6(b.getSpecialDuduct6());
	}

	@Override
	public BaseSpecialDeductionMonthDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSpecialDeductionMonthDetail b = new BaseSpecialDeductionMonthDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSpecialDeductionMonthDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialDeductionMonthDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialDeductionTypeIds(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialDeductionDetailIds(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialDuduct1(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialDuduct2(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialDuduct3(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialDuduct4(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialDuduct5(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialDuduct6(GenericBase.__getDecimal(val));
	}

	public void setSpecialDeductionMonthDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSpecialDeductionMonthDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSpecialDeductionMonthDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEmployeeNo(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getEmployeeNo() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setYear(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getYear() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setMonth(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getMonth() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setAmount(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getAmount() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setSpecialDeductionTypeIds(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getSpecialDeductionTypeIds() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setSpecialDeductionDetailIds(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getSpecialDeductionDetailIds() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setSpecialDuduct1(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getSpecialDuduct1() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setSpecialDuduct2(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getSpecialDuduct2() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setSpecialDuduct3(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getSpecialDuduct3() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setSpecialDuduct4(java.math.BigDecimal val) {
		setCurrentData(14, val);
	}

	public java.math.BigDecimal getSpecialDuduct4() {
		return GenericBase.__getDecimal(__current_data[14]);
	}

	public void setSpecialDuduct5(java.math.BigDecimal val) {
		setCurrentData(15, val);
	}

	public java.math.BigDecimal getSpecialDuduct5() {
		return GenericBase.__getDecimal(__current_data[15]);
	}

	public void setSpecialDuduct6(java.math.BigDecimal val) {
		setCurrentData(16, val);
	}

	public java.math.BigDecimal getSpecialDuduct6() {
		return GenericBase.__getDecimal(__current_data[16]);
	}

	public void setConditionSpecialDeductionMonthDetailId(String op, java.lang.Integer val) {
		setConditionSpecialDeductionMonthDetailId(op, val, CONDITION_AND);
	}

	public void setConditionSpecialDeductionMonthDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSpecialDeductionMonthDetailId(boolean val) {
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

	public void setConditionEmployeeNo(String op, java.lang.String val) {
		setConditionEmployeeNo(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeNo(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectEmployeeNo(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionYear(String op, java.lang.String val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionMonth(String op, java.lang.String val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionAmount(String op, java.math.BigDecimal val) {
		setConditionAmount(op, val, CONDITION_AND);
	}

	public void setConditionAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectAmount(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionSpecialDeductionTypeIds(String op, java.lang.String val) {
		setConditionSpecialDeductionTypeIds(op, val, CONDITION_AND);
	}

	public void setConditionSpecialDeductionTypeIds(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectSpecialDeductionTypeIds(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionSpecialDeductionDetailIds(String op, java.lang.String val) {
		setConditionSpecialDeductionDetailIds(op, val, CONDITION_AND);
	}

	public void setConditionSpecialDeductionDetailIds(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectSpecialDeductionDetailIds(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionSpecialDuduct1(String op, java.math.BigDecimal val) {
		setConditionSpecialDuduct1(op, val, CONDITION_AND);
	}

	public void setConditionSpecialDuduct1(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectSpecialDuduct1(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionSpecialDuduct2(String op, java.math.BigDecimal val) {
		setConditionSpecialDuduct2(op, val, CONDITION_AND);
	}

	public void setConditionSpecialDuduct2(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectSpecialDuduct2(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionSpecialDuduct3(String op, java.math.BigDecimal val) {
		setConditionSpecialDuduct3(op, val, CONDITION_AND);
	}

	public void setConditionSpecialDuduct3(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectSpecialDuduct3(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionSpecialDuduct4(String op, java.math.BigDecimal val) {
		setConditionSpecialDuduct4(op, val, CONDITION_AND);
	}

	public void setConditionSpecialDuduct4(String op, java.math.BigDecimal val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectSpecialDuduct4(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionSpecialDuduct5(String op, java.math.BigDecimal val) {
		setConditionSpecialDuduct5(op, val, CONDITION_AND);
	}

	public void setConditionSpecialDuduct5(String op, java.math.BigDecimal val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectSpecialDuduct5(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionSpecialDuduct6(String op, java.math.BigDecimal val) {
		setConditionSpecialDuduct6(op, val, CONDITION_AND);
	}

	public void setConditionSpecialDuduct6(String op, java.math.BigDecimal val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectSpecialDuduct6(boolean val) {
		__select_flags[16] = val;
	}


}

