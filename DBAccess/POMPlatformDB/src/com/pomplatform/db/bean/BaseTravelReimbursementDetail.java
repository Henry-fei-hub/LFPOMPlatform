package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseTravelReimbursementDetail extends GenericBase implements BaseFactory<BaseTravelReimbursementDetail>, Comparable<BaseTravelReimbursementDetail> 
{


	public static BaseTravelReimbursementDetail newInstance(){
		return new BaseTravelReimbursementDetail();
	}

	@Override
	public BaseTravelReimbursementDetail make(){
		BaseTravelReimbursementDetail b = new BaseTravelReimbursementDetail();
		return b;
	}

	public final static java.lang.String CS_TRAVEL_REIMBURSEMENT_DETAIL_ID = "travel_reimbursement_detail_id" ;
	public final static java.lang.String CS_TRAVEL_REIMBURSEMENT_ID = "travel_reimbursement_id" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_START_ADDRESS = "start_address" ;
	public final static java.lang.String CS_ARRIVING_ADDRESS = "arriving_address" ;
	public final static java.lang.String CS_TRAVEL_DAYS = "travel_days" ;
	public final static java.lang.String CS_AIRFARE = "airfare" ;
	public final static java.lang.String CS_CAR_BOAT_FEE = "car_boat_fee" ;
	public final static java.lang.String CS_CITY_TRANSPORTATION = "city_transportation" ;
	public final static java.lang.String CS_SHIPPING_FEE = "shipping_fee" ;
	public final static java.lang.String CS_ACCOMMODATION_FEE = "accommodation_fee" ;
	public final static java.lang.String CS_DRIVING_FEE = "driving_fee" ;
	public final static java.lang.String CS_TRAVEL_ALLOWANCE = "travel_allowance" ;
	public final static java.lang.String CS_SUM = "sum" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "差旅报销明细编码,差旅主表编码,开始日期,结束日期,启程地点,抵达地点,出差天数,机票,车船费,市内交通费,托运费,住宿费,自驾车费,出差补助,小计,备注";

	public java.lang.Integer getTravelReimbursementDetailId() {
		return this.__travel_reimbursement_detail_id;
	}

	public void setTravelReimbursementDetailId( java.lang.Integer value ) {
		this.__travel_reimbursement_detail_id = value;
	}

	public java.lang.Integer getTravelReimbursementId() {
		return this.__travel_reimbursement_id;
	}

	public void setTravelReimbursementId( java.lang.Integer value ) {
		this.__travel_reimbursement_id = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public java.lang.String getStartAddress() {
		return this.__start_address;
	}

	public void setStartAddress( java.lang.String value ) {
		this.__start_address = value;
	}

	public java.lang.String getArrivingAddress() {
		return this.__arriving_address;
	}

	public void setArrivingAddress( java.lang.String value ) {
		this.__arriving_address = value;
	}

	public java.lang.Integer getTravelDays() {
		return this.__travel_days;
	}

	public void setTravelDays( java.lang.Integer value ) {
		this.__travel_days = value;
	}

	public java.math.BigDecimal getAirfare() {
		return this.__airfare;
	}

	public void setAirfare( java.math.BigDecimal value ) {
		this.__airfare = value;
	}

	public java.math.BigDecimal getCarBoatFee() {
		return this.__car_boat_fee;
	}

	public void setCarBoatFee( java.math.BigDecimal value ) {
		this.__car_boat_fee = value;
	}

	public java.math.BigDecimal getCityTransportation() {
		return this.__city_transportation;
	}

	public void setCityTransportation( java.math.BigDecimal value ) {
		this.__city_transportation = value;
	}

	public java.math.BigDecimal getShippingFee() {
		return this.__shipping_fee;
	}

	public void setShippingFee( java.math.BigDecimal value ) {
		this.__shipping_fee = value;
	}

	public java.math.BigDecimal getAccommodationFee() {
		return this.__accommodation_fee;
	}

	public void setAccommodationFee( java.math.BigDecimal value ) {
		this.__accommodation_fee = value;
	}

	public java.math.BigDecimal getDrivingFee() {
		return this.__driving_fee;
	}

	public void setDrivingFee( java.math.BigDecimal value ) {
		this.__driving_fee = value;
	}

	public java.math.BigDecimal getTravelAllowance() {
		return this.__travel_allowance;
	}

	public void setTravelAllowance( java.math.BigDecimal value ) {
		this.__travel_allowance = value;
	}

	public java.math.BigDecimal getSum() {
		return this.__sum;
	}

	public void setSum( java.math.BigDecimal value ) {
		this.__sum = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseTravelReimbursementDetail __bean){
		__bean.setTravelReimbursementDetailId(getTravelReimbursementDetailId());
		__bean.setTravelReimbursementId(getTravelReimbursementId());
		__bean.setStartDate(getStartDate());
		__bean.setEndDate(getEndDate());
		__bean.setStartAddress(getStartAddress());
		__bean.setArrivingAddress(getArrivingAddress());
		__bean.setTravelDays(getTravelDays());
		__bean.setAirfare(getAirfare());
		__bean.setCarBoatFee(getCarBoatFee());
		__bean.setCityTransportation(getCityTransportation());
		__bean.setShippingFee(getShippingFee());
		__bean.setAccommodationFee(getAccommodationFee());
		__bean.setDrivingFee(getDrivingFee());
		__bean.setTravelAllowance(getTravelAllowance());
		__bean.setSum(getSum());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getTravelReimbursementDetailId() == null ? "" : getTravelReimbursementDetailId());
		sb.append(",");
		sb.append(getTravelReimbursementId() == null ? "" : getTravelReimbursementId());
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		sb.append(",");
		sb.append(getStartAddress() == null ? "" : getStartAddress());
		sb.append(",");
		sb.append(getArrivingAddress() == null ? "" : getArrivingAddress());
		sb.append(",");
		sb.append(getTravelDays() == null ? "" : getTravelDays());
		sb.append(",");
		sb.append(getAirfare() == null ? "" : getAirfare());
		sb.append(",");
		sb.append(getCarBoatFee() == null ? "" : getCarBoatFee());
		sb.append(",");
		sb.append(getCityTransportation() == null ? "" : getCityTransportation());
		sb.append(",");
		sb.append(getShippingFee() == null ? "" : getShippingFee());
		sb.append(",");
		sb.append(getAccommodationFee() == null ? "" : getAccommodationFee());
		sb.append(",");
		sb.append(getDrivingFee() == null ? "" : getDrivingFee());
		sb.append(",");
		sb.append(getTravelAllowance() == null ? "" : getTravelAllowance());
		sb.append(",");
		sb.append(getSum() == null ? "" : getSum());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseTravelReimbursementDetail o) {
		return __travel_reimbursement_detail_id == null ? -1 : __travel_reimbursement_detail_id.compareTo(o.getTravelReimbursementDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__travel_reimbursement_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__travel_reimbursement_id);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__start_address);
		hash = 97 * hash + Objects.hashCode(this.__arriving_address);
		hash = 97 * hash + Objects.hashCode(this.__travel_days);
		hash = 97 * hash + Objects.hashCode(this.__airfare);
		hash = 97 * hash + Objects.hashCode(this.__car_boat_fee);
		hash = 97 * hash + Objects.hashCode(this.__city_transportation);
		hash = 97 * hash + Objects.hashCode(this.__shipping_fee);
		hash = 97 * hash + Objects.hashCode(this.__accommodation_fee);
		hash = 97 * hash + Objects.hashCode(this.__driving_fee);
		hash = 97 * hash + Objects.hashCode(this.__travel_allowance);
		hash = 97 * hash + Objects.hashCode(this.__sum);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseTravelReimbursementDetail o = (BaseTravelReimbursementDetail)obj;
		if(!Objects.equals(this.__travel_reimbursement_detail_id, o.getTravelReimbursementDetailId())) return false;
		if(!Objects.equals(this.__travel_reimbursement_id, o.getTravelReimbursementId())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__start_address, o.getStartAddress())) return false;
		if(!Objects.equals(this.__arriving_address, o.getArrivingAddress())) return false;
		if(!Objects.equals(this.__travel_days, o.getTravelDays())) return false;
		if(!Objects.equals(this.__airfare, o.getAirfare())) return false;
		if(!Objects.equals(this.__car_boat_fee, o.getCarBoatFee())) return false;
		if(!Objects.equals(this.__city_transportation, o.getCityTransportation())) return false;
		if(!Objects.equals(this.__shipping_fee, o.getShippingFee())) return false;
		if(!Objects.equals(this.__accommodation_fee, o.getAccommodationFee())) return false;
		if(!Objects.equals(this.__driving_fee, o.getDrivingFee())) return false;
		if(!Objects.equals(this.__travel_allowance, o.getTravelAllowance())) return false;
		if(!Objects.equals(this.__sum, o.getSum())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getTravelReimbursementDetailId() != null) sb.append(__wrapNumber(count++, "travelReimbursementDetailId", getTravelReimbursementDetailId()));
		if(getTravelReimbursementId() != null) sb.append(__wrapNumber(count++, "travelReimbursementId", getTravelReimbursementId()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getStartAddress() != null) sb.append(__wrapString(count++, "startAddress", getStartAddress()));
		if(getArrivingAddress() != null) sb.append(__wrapString(count++, "arrivingAddress", getArrivingAddress()));
		if(getTravelDays() != null) sb.append(__wrapNumber(count++, "travelDays", getTravelDays()));
		if(getAirfare() != null) sb.append(__wrapDecimal(count++, "airfare", getAirfare()));
		if(getCarBoatFee() != null) sb.append(__wrapDecimal(count++, "carBoatFee", getCarBoatFee()));
		if(getCityTransportation() != null) sb.append(__wrapDecimal(count++, "cityTransportation", getCityTransportation()));
		if(getShippingFee() != null) sb.append(__wrapDecimal(count++, "shippingFee", getShippingFee()));
		if(getAccommodationFee() != null) sb.append(__wrapDecimal(count++, "accommodationFee", getAccommodationFee()));
		if(getDrivingFee() != null) sb.append(__wrapDecimal(count++, "drivingFee", getDrivingFee()));
		if(getTravelAllowance() != null) sb.append(__wrapDecimal(count++, "travelAllowance", getTravelAllowance()));
		if(getSum() != null) sb.append(__wrapDecimal(count++, "sum", getSum()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("travelReimbursementDetailId")) != null) setTravelReimbursementDetailId(__getInt(val)); 
		if((val = values.get("travelReimbursementId")) != null) setTravelReimbursementId(__getInt(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("startAddress")) != null) setStartAddress(__getString(val));
		if((val = values.get("arrivingAddress")) != null) setArrivingAddress(__getString(val));
		if((val = values.get("travelDays")) != null) setTravelDays(__getInt(val)); 
		if((val = values.get("airfare")) != null) setAirfare(__getDecimal(val));  
		if((val = values.get("carBoatFee")) != null) setCarBoatFee(__getDecimal(val));  
		if((val = values.get("cityTransportation")) != null) setCityTransportation(__getDecimal(val));  
		if((val = values.get("shippingFee")) != null) setShippingFee(__getDecimal(val));  
		if((val = values.get("accommodationFee")) != null) setAccommodationFee(__getDecimal(val));  
		if((val = values.get("drivingFee")) != null) setDrivingFee(__getDecimal(val));  
		if((val = values.get("travelAllowance")) != null) setTravelAllowance(__getDecimal(val));  
		if((val = values.get("sum")) != null) setSum(__getDecimal(val));  
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __travel_reimbursement_detail_id ;
	protected java.lang.Integer  __travel_reimbursement_id ;
	protected java.util.Date  __start_date ;
	protected java.util.Date  __end_date ;
	protected java.lang.String  __start_address ;
	protected java.lang.String  __arriving_address ;
	protected java.lang.Integer  __travel_days ;
	protected java.math.BigDecimal  __airfare ;
	protected java.math.BigDecimal  __car_boat_fee ;
	protected java.math.BigDecimal  __city_transportation ;
	protected java.math.BigDecimal  __shipping_fee ;
	protected java.math.BigDecimal  __accommodation_fee ;
	protected java.math.BigDecimal  __driving_fee ;
	protected java.math.BigDecimal  __travel_allowance ;
	protected java.math.BigDecimal  __sum ;
	protected java.lang.String  __remark ;
}
