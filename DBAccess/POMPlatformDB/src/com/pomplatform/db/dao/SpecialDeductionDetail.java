package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSpecialDeductionDetail;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SpecialDeductionDetail extends AbstractTable<BaseSpecialDeductionDetail>
{

	public SpecialDeductionDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 16;

		initTables();

		__tableName            = "special_deduction_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSpecialDeductionDetail.CS_SPECIAL_DEDUCTION_DETAIL_ID;
		__column_names[1] = BaseSpecialDeductionDetail.CS_PARENT_ID;
		__column_names[2] = BaseSpecialDeductionDetail.CS_SCHOOLING;
		__column_names[3] = BaseSpecialDeductionDetail.CS_START_DATE;
		__column_names[4] = BaseSpecialDeductionDetail.CS_END_DATE;
		__column_names[5] = BaseSpecialDeductionDetail.CS_DEDUCTION_PERCENTAGE;
		__column_names[6] = BaseSpecialDeductionDetail.CS_AMOUNT;
		__column_names[7] = BaseSpecialDeductionDetail.CS_NUM;
		__column_names[8] = BaseSpecialDeductionDetail.CS_EDUCATION_TYPE;
		__column_names[9] = BaseSpecialDeductionDetail.CS_EDUCATION_STAGE;
		__column_names[10] = BaseSpecialDeductionDetail.CS_HOUSE_FIRST;
		__column_names[11] = BaseSpecialDeductionDetail.CS_SINGLE_CHILD;
		__column_names[12] = BaseSpecialDeductionDetail.CS_YEAR;
		__column_names[13] = BaseSpecialDeductionDetail.CS_SPECIAL_DEDUCTION_TYPE_ID;
		__column_names[14] = BaseSpecialDeductionDetail.CS_CREATE_DATE;
		__column_names[15] = BaseSpecialDeductionDetail.CS_CITY;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSpecialDeductionDetail b) {
		clear();
		setSpecialDeductionDetailIdClear(b.getSpecialDeductionDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getSpecialDeductionDetailId() == null;
	}

	@Override
	public BaseSpecialDeductionDetail generateBase(){
		BaseSpecialDeductionDetail b = new BaseSpecialDeductionDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSpecialDeductionDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSpecialDeductionDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSchooling(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDeductionPercentage(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setNum(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEducationType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEducationStage(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setHouseFirst(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSingleChild(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSpecialDeductionTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCity(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseSpecialDeductionDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSpecialDeductionDetailId();
		buff[count++] = b.getParentId();
		buff[count++] = b.getSchooling();
		buff[count++] = generateTimestampFromDate(b.getStartDate());
		buff[count++] = generateTimestampFromDate(b.getEndDate());
		buff[count++] = b.getDeductionPercentage();
		buff[count++] = b.getAmount();
		buff[count++] = b.getNum();
		buff[count++] = b.getEducationType();
		buff[count++] = b.getEducationStage();
		buff[count++] = b.getHouseFirst();
		buff[count++] = b.getSingleChild();
		buff[count++] = b.getYear();
		buff[count++] = b.getSpecialDeductionTypeId();
		buff[count++] = generateTimestampFromDate(b.getCreateDate());
		buff[count++] = b.getCity();
	}

	@Override
	public void setDataFromBase(BaseSpecialDeductionDetail b){
		if(b.getSpecialDeductionDetailId() != null) setSpecialDeductionDetailIdClear(b.getSpecialDeductionDetailId());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getSchooling() != null) setSchooling(b.getSchooling());
		if(b.getStartDate() != null) setStartDate(b.getStartDate());
		if(b.getEndDate() != null) setEndDate(b.getEndDate());
		if(b.getDeductionPercentage() != null) setDeductionPercentage(b.getDeductionPercentage());
		if(b.getAmount() != null) setAmount(b.getAmount());
		if(b.getNum() != null) setNum(b.getNum());
		if(b.getEducationType() != null) setEducationType(b.getEducationType());
		if(b.getEducationStage() != null) setEducationStage(b.getEducationStage());
		if(b.getHouseFirst() != null) setHouseFirst(b.getHouseFirst());
		if(b.getSingleChild() != null) setSingleChild(b.getSingleChild());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getSpecialDeductionTypeId() != null) setSpecialDeductionTypeId(b.getSpecialDeductionTypeId());
		if(b.getCreateDate() != null) setCreateDate(b.getCreateDate());
		if(b.getCity() != null) setCity(b.getCity());
	}

	@Override
	public BaseSpecialDeductionDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSpecialDeductionDetail b = new BaseSpecialDeductionDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSpecialDeductionDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialDeductionDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSchooling(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeductionPercentage(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNum(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEducationType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEducationStage(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHouseFirst(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSingleChild(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialDeductionTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCity(GenericBase.__getString(val));
	}

	public void setSpecialDeductionDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSpecialDeductionDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSpecialDeductionDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setSchooling(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getSchooling() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setStartDate(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getStartDate() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setEndDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getEndDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setDeductionPercentage(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getDeductionPercentage() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setAmount(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getAmount() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setNum(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getNum() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setEducationType(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getEducationType() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setEducationStage(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getEducationStage() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setHouseFirst(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getHouseFirst() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setSingleChild(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getSingleChild() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setYear(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getYear() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setSpecialDeductionTypeId(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getSpecialDeductionTypeId() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setCreateDate(java.util.Date val) {
		setCurrentData(14, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateDate() {
		return GenericBase.__getDateFromSQL(__current_data[14]);
	}

	public void setCity(java.lang.String val) {
		setCurrentData(15, val);
	}

	public java.lang.String getCity() {
		return GenericBase.__getString(__current_data[15]);
	}

	public void setConditionSpecialDeductionDetailId(String op, java.lang.Integer val) {
		setConditionSpecialDeductionDetailId(op, val, CONDITION_AND);
	}

	public void setConditionSpecialDeductionDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSpecialDeductionDetailId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionParentId(String op, java.lang.Integer val) {
		setConditionParentId(op, val, CONDITION_AND);
	}

	public void setConditionParentId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectParentId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionSchooling(String op, java.lang.Integer val) {
		setConditionSchooling(op, val, CONDITION_AND);
	}

	public void setConditionSchooling(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectSchooling(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionStartDate(String op, java.util.Date val) {
		setConditionStartDate(op, val, CONDITION_AND);
	}

	public void setConditionStartDate(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectStartDate(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionEndDate(String op, java.util.Date val) {
		setConditionEndDate(op, val, CONDITION_AND);
	}

	public void setConditionEndDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectEndDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionDeductionPercentage(String op, java.math.BigDecimal val) {
		setConditionDeductionPercentage(op, val, CONDITION_AND);
	}

	public void setConditionDeductionPercentage(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectDeductionPercentage(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionAmount(String op, java.math.BigDecimal val) {
		setConditionAmount(op, val, CONDITION_AND);
	}

	public void setConditionAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectAmount(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionNum(String op, java.lang.Integer val) {
		setConditionNum(op, val, CONDITION_AND);
	}

	public void setConditionNum(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectNum(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionEducationType(String op, java.lang.Integer val) {
		setConditionEducationType(op, val, CONDITION_AND);
	}

	public void setConditionEducationType(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectEducationType(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionEducationStage(String op, java.lang.Integer val) {
		setConditionEducationStage(op, val, CONDITION_AND);
	}

	public void setConditionEducationStage(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectEducationStage(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionHouseFirst(String op, java.lang.Integer val) {
		setConditionHouseFirst(op, val, CONDITION_AND);
	}

	public void setConditionHouseFirst(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectHouseFirst(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionSingleChild(String op, java.lang.Integer val) {
		setConditionSingleChild(op, val, CONDITION_AND);
	}

	public void setConditionSingleChild(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectSingleChild(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionYear(String op, java.lang.String val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionSpecialDeductionTypeId(String op, java.lang.Integer val) {
		setConditionSpecialDeductionTypeId(op, val, CONDITION_AND);
	}

	public void setConditionSpecialDeductionTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectSpecialDeductionTypeId(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionCreateDate(String op, java.util.Date val) {
		setConditionCreateDate(op, val, CONDITION_AND);
	}

	public void setConditionCreateDate(String op, java.util.Date val, String relation) {
		addCondition(14, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateDate(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionCity(String op, java.lang.String val) {
		setConditionCity(op, val, CONDITION_AND);
	}

	public void setConditionCity(String op, java.lang.String val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectCity(boolean val) {
		__select_flags[15] = val;
	}


}

