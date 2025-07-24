package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseTravelReimbursementDetail;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class TravelReimbursementDetail extends AbstractTable<BaseTravelReimbursementDetail>
{

	public TravelReimbursementDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 16;

		initTables();

		__tableName            = "travel_reimbursement_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseTravelReimbursementDetail.CS_TRAVEL_REIMBURSEMENT_DETAIL_ID;
		__column_names[1] = BaseTravelReimbursementDetail.CS_TRAVEL_REIMBURSEMENT_ID;
		__column_names[2] = BaseTravelReimbursementDetail.CS_START_DATE;
		__column_names[3] = BaseTravelReimbursementDetail.CS_END_DATE;
		__column_names[4] = BaseTravelReimbursementDetail.CS_START_ADDRESS;
		__column_names[5] = BaseTravelReimbursementDetail.CS_ARRIVING_ADDRESS;
		__column_names[6] = BaseTravelReimbursementDetail.CS_TRAVEL_DAYS;
		__column_names[7] = BaseTravelReimbursementDetail.CS_AIRFARE;
		__column_names[8] = BaseTravelReimbursementDetail.CS_CAR_BOAT_FEE;
		__column_names[9] = BaseTravelReimbursementDetail.CS_CITY_TRANSPORTATION;
		__column_names[10] = BaseTravelReimbursementDetail.CS_SHIPPING_FEE;
		__column_names[11] = BaseTravelReimbursementDetail.CS_ACCOMMODATION_FEE;
		__column_names[12] = BaseTravelReimbursementDetail.CS_DRIVING_FEE;
		__column_names[13] = BaseTravelReimbursementDetail.CS_TRAVEL_ALLOWANCE;
		__column_names[14] = BaseTravelReimbursementDetail.CS_SUM;
		__column_names[15] = BaseTravelReimbursementDetail.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseTravelReimbursementDetail b) {
		clear();
		setTravelReimbursementDetailIdClear(b.getTravelReimbursementDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getTravelReimbursementDetailId() == null;
	}

	@Override
	public BaseTravelReimbursementDetail generateBase(){
		BaseTravelReimbursementDetail b = new BaseTravelReimbursementDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseTravelReimbursementDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setTravelReimbursementDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTravelReimbursementId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setStartAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setArrivingAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTravelDays(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAirfare(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCarBoatFee(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCityTransportation(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setShippingFee(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAccommodationFee(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setDrivingFee(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTravelAllowance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSum(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseTravelReimbursementDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getTravelReimbursementDetailId();
		buff[count++] = b.getTravelReimbursementId();
		buff[count++] = generateTimestampFromDate(b.getStartDate());
		buff[count++] = generateTimestampFromDate(b.getEndDate());
		buff[count++] = b.getStartAddress();
		buff[count++] = b.getArrivingAddress();
		buff[count++] = b.getTravelDays();
		buff[count++] = b.getAirfare();
		buff[count++] = b.getCarBoatFee();
		buff[count++] = b.getCityTransportation();
		buff[count++] = b.getShippingFee();
		buff[count++] = b.getAccommodationFee();
		buff[count++] = b.getDrivingFee();
		buff[count++] = b.getTravelAllowance();
		buff[count++] = b.getSum();
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseTravelReimbursementDetail b){
		if(b.getTravelReimbursementDetailId() != null) setTravelReimbursementDetailIdClear(b.getTravelReimbursementDetailId());
		if(b.getTravelReimbursementId() != null) setTravelReimbursementId(b.getTravelReimbursementId());
		if(b.getStartDate() != null) setStartDate(b.getStartDate());
		if(b.getEndDate() != null) setEndDate(b.getEndDate());
		if(b.getStartAddress() != null) setStartAddress(b.getStartAddress());
		if(b.getArrivingAddress() != null) setArrivingAddress(b.getArrivingAddress());
		if(b.getTravelDays() != null) setTravelDays(b.getTravelDays());
		if(b.getAirfare() != null) setAirfare(b.getAirfare());
		if(b.getCarBoatFee() != null) setCarBoatFee(b.getCarBoatFee());
		if(b.getCityTransportation() != null) setCityTransportation(b.getCityTransportation());
		if(b.getShippingFee() != null) setShippingFee(b.getShippingFee());
		if(b.getAccommodationFee() != null) setAccommodationFee(b.getAccommodationFee());
		if(b.getDrivingFee() != null) setDrivingFee(b.getDrivingFee());
		if(b.getTravelAllowance() != null) setTravelAllowance(b.getTravelAllowance());
		if(b.getSum() != null) setSum(b.getSum());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseTravelReimbursementDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseTravelReimbursementDetail b = new BaseTravelReimbursementDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseTravelReimbursementDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTravelReimbursementDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTravelReimbursementId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStartAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setArrivingAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTravelDays(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAirfare(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCarBoatFee(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCityTransportation(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setShippingFee(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccommodationFee(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDrivingFee(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTravelAllowance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSum(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setTravelReimbursementDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getTravelReimbursementDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setTravelReimbursementDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setTravelReimbursementId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getTravelReimbursementId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setStartDate(java.util.Date val) {
		setCurrentData(2, generateTimestampFromDate(val));
	}

	public java.util.Date getStartDate() {
		return GenericBase.__getDateFromSQL(__current_data[2]);
	}

	public void setEndDate(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getEndDate() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setStartAddress(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getStartAddress() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setArrivingAddress(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getArrivingAddress() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setTravelDays(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getTravelDays() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setAirfare(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getAirfare() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setCarBoatFee(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getCarBoatFee() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setCityTransportation(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getCityTransportation() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setShippingFee(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getShippingFee() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setAccommodationFee(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getAccommodationFee() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setDrivingFee(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getDrivingFee() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setTravelAllowance(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getTravelAllowance() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setSum(java.math.BigDecimal val) {
		setCurrentData(14, val);
	}

	public java.math.BigDecimal getSum() {
		return GenericBase.__getDecimal(__current_data[14]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(15, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[15]);
	}

	public void setConditionTravelReimbursementDetailId(String op, java.lang.Integer val) {
		setConditionTravelReimbursementDetailId(op, val, CONDITION_AND);
	}

	public void setConditionTravelReimbursementDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectTravelReimbursementDetailId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionTravelReimbursementId(String op, java.lang.Integer val) {
		setConditionTravelReimbursementId(op, val, CONDITION_AND);
	}

	public void setConditionTravelReimbursementId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectTravelReimbursementId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionStartDate(String op, java.util.Date val) {
		setConditionStartDate(op, val, CONDITION_AND);
	}

	public void setConditionStartDate(String op, java.util.Date val, String relation) {
		addCondition(2, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectStartDate(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionEndDate(String op, java.util.Date val) {
		setConditionEndDate(op, val, CONDITION_AND);
	}

	public void setConditionEndDate(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectEndDate(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionStartAddress(String op, java.lang.String val) {
		setConditionStartAddress(op, val, CONDITION_AND);
	}

	public void setConditionStartAddress(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectStartAddress(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionArrivingAddress(String op, java.lang.String val) {
		setConditionArrivingAddress(op, val, CONDITION_AND);
	}

	public void setConditionArrivingAddress(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectArrivingAddress(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionTravelDays(String op, java.lang.Integer val) {
		setConditionTravelDays(op, val, CONDITION_AND);
	}

	public void setConditionTravelDays(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectTravelDays(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionAirfare(String op, java.math.BigDecimal val) {
		setConditionAirfare(op, val, CONDITION_AND);
	}

	public void setConditionAirfare(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectAirfare(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionCarBoatFee(String op, java.math.BigDecimal val) {
		setConditionCarBoatFee(op, val, CONDITION_AND);
	}

	public void setConditionCarBoatFee(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectCarBoatFee(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionCityTransportation(String op, java.math.BigDecimal val) {
		setConditionCityTransportation(op, val, CONDITION_AND);
	}

	public void setConditionCityTransportation(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectCityTransportation(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionShippingFee(String op, java.math.BigDecimal val) {
		setConditionShippingFee(op, val, CONDITION_AND);
	}

	public void setConditionShippingFee(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectShippingFee(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionAccommodationFee(String op, java.math.BigDecimal val) {
		setConditionAccommodationFee(op, val, CONDITION_AND);
	}

	public void setConditionAccommodationFee(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectAccommodationFee(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionDrivingFee(String op, java.math.BigDecimal val) {
		setConditionDrivingFee(op, val, CONDITION_AND);
	}

	public void setConditionDrivingFee(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectDrivingFee(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionTravelAllowance(String op, java.math.BigDecimal val) {
		setConditionTravelAllowance(op, val, CONDITION_AND);
	}

	public void setConditionTravelAllowance(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectTravelAllowance(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionSum(String op, java.math.BigDecimal val) {
		setConditionSum(op, val, CONDITION_AND);
	}

	public void setConditionSum(String op, java.math.BigDecimal val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectSum(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[15] = val;
	}


}

