package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectUnitPrice;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectUnitPrice extends AbstractTable<BaseProjectUnitPrice>
{

	public ProjectUnitPrice() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "project_unit_prices";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectUnitPrice.CS_PROJECT_UNIT_PRICE_ID;
		__column_names[1] = BaseProjectUnitPrice.CS_PLATE_ID;
		__column_names[2] = BaseProjectUnitPrice.CS_AREA_ID;
		__column_names[3] = BaseProjectUnitPrice.CS_GRADE_ID;
		__column_names[4] = BaseProjectUnitPrice.CS_SQUARE_ID;
		__column_names[5] = BaseProjectUnitPrice.CS_MIN_SQUARE;
		__column_names[6] = BaseProjectUnitPrice.CS_MAX_SQUARE;
		__column_names[7] = BaseProjectUnitPrice.CS_UNIT_PRICE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectUnitPrice b) {
		clear();
		setProjectUnitPriceIdClear(b.getProjectUnitPriceId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectUnitPriceId() == null;
	}

	@Override
	public BaseProjectUnitPrice generateBase(){
		BaseProjectUnitPrice b = new BaseProjectUnitPrice();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectUnitPrice b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectUnitPriceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAreaId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setGradeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSquareId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMinSquare(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMaxSquare(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUnitPrice(GenericBase.__getDecimal(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectUnitPrice b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectUnitPriceId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getAreaId();
		buff[count++] = b.getGradeId();
		buff[count++] = b.getSquareId();
		buff[count++] = b.getMinSquare();
		buff[count++] = b.getMaxSquare();
		buff[count++] = b.getUnitPrice();
	}

	@Override
	public void setDataFromBase(BaseProjectUnitPrice b){
		if(b.getProjectUnitPriceId() != null) setProjectUnitPriceIdClear(b.getProjectUnitPriceId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getAreaId() != null) setAreaId(b.getAreaId());
		if(b.getGradeId() != null) setGradeId(b.getGradeId());
		if(b.getSquareId() != null) setSquareId(b.getSquareId());
		if(b.getMinSquare() != null) setMinSquare(b.getMinSquare());
		if(b.getMaxSquare() != null) setMaxSquare(b.getMaxSquare());
		if(b.getUnitPrice() != null) setUnitPrice(b.getUnitPrice());
	}

	@Override
	public BaseProjectUnitPrice generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectUnitPrice b = new BaseProjectUnitPrice();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectUnitPrice __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectUnitPriceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAreaId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setGradeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSquareId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMinSquare(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMaxSquare(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUnitPrice(GenericBase.__getDecimal(val));
	}

	public void setProjectUnitPriceId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectUnitPriceId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectUnitPriceIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setAreaId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getAreaId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setGradeId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getGradeId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setSquareId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getSquareId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setMinSquare(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getMinSquare() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setMaxSquare(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getMaxSquare() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setUnitPrice(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getUnitPrice() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setConditionProjectUnitPriceId(String op, java.lang.Integer val) {
		setConditionProjectUnitPriceId(op, val, CONDITION_AND);
	}

	public void setConditionProjectUnitPriceId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectUnitPriceId(boolean val) {
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

	public void setConditionAreaId(String op, java.lang.Integer val) {
		setConditionAreaId(op, val, CONDITION_AND);
	}

	public void setConditionAreaId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectAreaId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionGradeId(String op, java.lang.Integer val) {
		setConditionGradeId(op, val, CONDITION_AND);
	}

	public void setConditionGradeId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectGradeId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionSquareId(String op, java.lang.Integer val) {
		setConditionSquareId(op, val, CONDITION_AND);
	}

	public void setConditionSquareId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectSquareId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionMinSquare(String op, java.math.BigDecimal val) {
		setConditionMinSquare(op, val, CONDITION_AND);
	}

	public void setConditionMinSquare(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectMinSquare(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionMaxSquare(String op, java.math.BigDecimal val) {
		setConditionMaxSquare(op, val, CONDITION_AND);
	}

	public void setConditionMaxSquare(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectMaxSquare(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionUnitPrice(String op, java.math.BigDecimal val) {
		setConditionUnitPrice(op, val, CONDITION_AND);
	}

	public void setConditionUnitPrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectUnitPrice(boolean val) {
		__select_flags[7] = val;
	}


}

