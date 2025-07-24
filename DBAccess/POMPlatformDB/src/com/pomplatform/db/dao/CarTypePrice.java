package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCarTypePrice;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CarTypePrice extends AbstractTable<BaseCarTypePrice>
{

	public CarTypePrice() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "car_type_prices";

		__key_columns          = new int[0];

		__column_names[0] = BaseCarTypePrice.CS_CAR_TYPE_PRICE_ID;
		__column_names[1] = BaseCarTypePrice.CS_FROM_AREA;
		__column_names[2] = BaseCarTypePrice.CS_TO_AREA;
		__column_names[3] = BaseCarTypePrice.CS_PRICE;
		__column_names[4] = BaseCarTypePrice.CS_CAR_TYPE;
		__column_names[5] = BaseCarTypePrice.CS_USE_CAR_PRICE_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
		__insert_flags[5] = false;
		__serial_column = 5;
	}

	public void setPrimaryKeyFromBase(BaseCarTypePrice b) {
		clear();
	}

	public boolean isPrimaryKeyNull() {
		return true;
	}

	@Override
	public BaseCarTypePrice generateBase(){
		BaseCarTypePrice b = new BaseCarTypePrice();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCarTypePrice b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCarTypePriceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFromArea(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setToArea(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPrice(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCarType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setUseCarPriceId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCarTypePrice b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCarTypePriceId();
		buff[count++] = b.getFromArea();
		buff[count++] = b.getToArea();
		buff[count++] = b.getPrice();
		buff[count++] = b.getCarType();
		buff[count++] = b.getUseCarPriceId();
	}

	@Override
	public void setDataFromBase(BaseCarTypePrice b){
		if(b.getCarTypePriceId() != null) setCarTypePriceId(b.getCarTypePriceId());
		if(b.getFromArea() != null) setFromArea(b.getFromArea());
		if(b.getToArea() != null) setToArea(b.getToArea());
		if(b.getPrice() != null) setPrice(b.getPrice());
		if(b.getCarType() != null) setCarType(b.getCarType());
		if(b.getUseCarPriceId() != null) setUseCarPriceId(b.getUseCarPriceId());
	}

	@Override
	public BaseCarTypePrice generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCarTypePrice b = new BaseCarTypePrice();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCarTypePrice __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCarTypePriceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFromArea(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setToArea(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPrice(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCarType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUseCarPriceId(GenericBase.__getInt(val));
	}

	public void setCarTypePriceId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCarTypePriceId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setFromArea(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getFromArea() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setToArea(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getToArea() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setPrice(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getPrice() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setCarType(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getCarType() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setUseCarPriceId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getUseCarPriceId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setConditionCarTypePriceId(String op, java.lang.Integer val) {
		setConditionCarTypePriceId(op, val, CONDITION_AND);
	}

	public void setConditionCarTypePriceId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCarTypePriceId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionFromArea(String op, java.lang.String val) {
		setConditionFromArea(op, val, CONDITION_AND);
	}

	public void setConditionFromArea(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectFromArea(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionToArea(String op, java.lang.String val) {
		setConditionToArea(op, val, CONDITION_AND);
	}

	public void setConditionToArea(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectToArea(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionPrice(String op, java.math.BigDecimal val) {
		setConditionPrice(op, val, CONDITION_AND);
	}

	public void setConditionPrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectPrice(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCarType(String op, java.lang.Integer val) {
		setConditionCarType(op, val, CONDITION_AND);
	}

	public void setConditionCarType(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCarType(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionUseCarPriceId(String op, java.lang.Integer val) {
		setConditionUseCarPriceId(op, val, CONDITION_AND);
	}

	public void setConditionUseCarPriceId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectUseCarPriceId(boolean val) {
		__select_flags[5] = val;
	}


}

