package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseGenderProportion;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class GenderProportion extends AbstractTable<BaseGenderProportion>
{

	public GenderProportion() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "gender_proportion";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseGenderProportion.CS_GENDER_PROPORTION_ID;
		__column_names[1] = BaseGenderProportion.CS_PLATE_ID;
		__column_names[2] = BaseGenderProportion.CS_MALE_PROPORTION_STR;
		__column_names[3] = BaseGenderProportion.CS_FEMALE_PROPORTION_STR;
		__column_names[4] = BaseGenderProportion.CS_MALE_PROPORTION;
		__column_names[5] = BaseGenderProportion.CS_FEMALE_PROPORTION;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseGenderProportion b) {
		clear();
		setGenderProportionIdClear(b.getGenderProportionId());
	}

	public boolean isPrimaryKeyNull() {
		return getGenderProportionId() == null;
	}

	@Override
	public BaseGenderProportion generateBase(){
		BaseGenderProportion b = new BaseGenderProportion();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseGenderProportion b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setGenderProportionId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMaleProportionStr(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFemaleProportionStr(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMaleProportion(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setFemaleProportion(GenericBase.__getDecimal(val));
	}

	@Override
	public void setBaseToBuffer(BaseGenderProportion b, Object[] buff){
		int count = 0;
		buff[count++] = b.getGenderProportionId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getMaleProportionStr();
		buff[count++] = b.getFemaleProportionStr();
		buff[count++] = b.getMaleProportion();
		buff[count++] = b.getFemaleProportion();
	}

	@Override
	public void setDataFromBase(BaseGenderProportion b){
		if(b.getGenderProportionId() != null) setGenderProportionIdClear(b.getGenderProportionId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getMaleProportionStr() != null) setMaleProportionStr(b.getMaleProportionStr());
		if(b.getFemaleProportionStr() != null) setFemaleProportionStr(b.getFemaleProportionStr());
		if(b.getMaleProportion() != null) setMaleProportion(b.getMaleProportion());
		if(b.getFemaleProportion() != null) setFemaleProportion(b.getFemaleProportion());
	}

	@Override
	public BaseGenderProportion generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseGenderProportion b = new BaseGenderProportion();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseGenderProportion __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setGenderProportionId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMaleProportionStr(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFemaleProportionStr(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMaleProportion(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFemaleProportion(GenericBase.__getDecimal(val));
	}

	public void setGenderProportionId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getGenderProportionId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setGenderProportionIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setMaleProportionStr(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getMaleProportionStr() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setFemaleProportionStr(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getFemaleProportionStr() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setMaleProportion(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getMaleProportion() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setFemaleProportion(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getFemaleProportion() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setConditionGenderProportionId(String op, java.lang.Integer val) {
		setConditionGenderProportionId(op, val, CONDITION_AND);
	}

	public void setConditionGenderProportionId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectGenderProportionId(boolean val) {
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

	public void setConditionMaleProportionStr(String op, java.lang.String val) {
		setConditionMaleProportionStr(op, val, CONDITION_AND);
	}

	public void setConditionMaleProportionStr(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectMaleProportionStr(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionFemaleProportionStr(String op, java.lang.String val) {
		setConditionFemaleProportionStr(op, val, CONDITION_AND);
	}

	public void setConditionFemaleProportionStr(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectFemaleProportionStr(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionMaleProportion(String op, java.math.BigDecimal val) {
		setConditionMaleProportion(op, val, CONDITION_AND);
	}

	public void setConditionMaleProportion(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectMaleProportion(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionFemaleProportion(String op, java.math.BigDecimal val) {
		setConditionFemaleProportion(op, val, CONDITION_AND);
	}

	public void setConditionFemaleProportion(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectFemaleProportion(boolean val) {
		__select_flags[5] = val;
	}


}

