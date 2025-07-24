package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseContractDistribution extends GenericBase implements BaseFactory<BaseContractDistribution>, Comparable<BaseContractDistribution> 
{


	public static BaseContractDistribution newInstance(){
		return new BaseContractDistribution();
	}

	@Override
	public BaseContractDistribution make(){
		BaseContractDistribution b = new BaseContractDistribution();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_DISTRIBUTION_ID = "contract_distribution_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_UPDATE_TIME = "update_time" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;
	public final static java.lang.String CS_CONTRACT_DATE = "contract_date" ;
	public final static java.lang.String CS_ACTUAL_MONEY = "actual_money" ;
	public final static java.lang.String CS_ORDER_ID = "order_id" ;
	public final static java.lang.String CS_OPERATION_MANAGER_ID = "operation_manager_id" ;
	public final static java.lang.String CS_RATE_OF_PROGRESS = "rate_of_progress" ;
	public final static java.lang.String CS_ORDER_STATUS = "order_status" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,合同,业务部门,业务类别,提成,操作人,创建时间,修改时间,删除状态,合同签订日期,实际参与分配的金额,订单号,部门经理,进度（%）,状态为1则代表为已经组建了团队的";

	public java.lang.Integer getContractDistributionId() {
		return this.__contract_distribution_id;
	}

	public void setContractDistributionId( java.lang.Integer value ) {
		this.__contract_distribution_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.Integer value ) {
		this.__business_type = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.util.Date getUpdateTime() {
		return this.__update_time;
	}

	public void setUpdateTime( java.util.Date value ) {
		this.__update_time = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public java.util.Date getContractDate() {
		return this.__contract_date;
	}

	public void setContractDate( java.util.Date value ) {
		this.__contract_date = value;
	}

	public java.math.BigDecimal getActualMoney() {
		return this.__actual_money;
	}

	public void setActualMoney( java.math.BigDecimal value ) {
		this.__actual_money = value;
	}

	public java.lang.String getOrderId() {
		return this.__order_id;
	}

	public void setOrderId( java.lang.String value ) {
		this.__order_id = value;
	}

	public java.lang.Integer getOperationManagerId() {
		return this.__operation_manager_id;
	}

	public void setOperationManagerId( java.lang.Integer value ) {
		this.__operation_manager_id = value;
	}

	public java.math.BigDecimal getRateOfProgress() {
		return this.__rate_of_progress;
	}

	public void setRateOfProgress( java.math.BigDecimal value ) {
		this.__rate_of_progress = value;
	}

	public java.lang.Integer getOrderStatus() {
		return this.__order_status;
	}

	public void setOrderStatus( java.lang.Integer value ) {
		this.__order_status = value;
	}

	public void cloneCopy(BaseContractDistribution __bean){
		__bean.setContractDistributionId(getContractDistributionId());
		__bean.setContractId(getContractId());
		__bean.setPlateId(getPlateId());
		__bean.setBusinessType(getBusinessType());
		__bean.setAmount(getAmount());
		__bean.setOperator(getOperator());
		__bean.setCreateTime(getCreateTime());
		__bean.setUpdateTime(getUpdateTime());
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setContractDate(getContractDate());
		__bean.setActualMoney(getActualMoney());
		__bean.setOrderId(getOrderId());
		__bean.setOperationManagerId(getOperationManagerId());
		__bean.setRateOfProgress(getRateOfProgress());
		__bean.setOrderStatus(getOrderStatus());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractDistributionId() == null ? "" : getContractDistributionId());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getBusinessType() == null ? "" : getBusinessType());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getOperator() == null ? "" : getOperator());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getUpdateTime() == null ? "" : sdf.format(getUpdateTime()));
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		sb.append(",");
		sb.append(getContractDate() == null ? "" : sdf.format(getContractDate()));
		sb.append(",");
		sb.append(getActualMoney() == null ? "" : getActualMoney());
		sb.append(",");
		sb.append(getOrderId() == null ? "" : getOrderId());
		sb.append(",");
		sb.append(getOperationManagerId() == null ? "" : getOperationManagerId());
		sb.append(",");
		sb.append(getRateOfProgress() == null ? "" : getRateOfProgress());
		sb.append(",");
		sb.append(getOrderStatus() == null ? "" : getOrderStatus());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseContractDistribution o) {
		return __contract_distribution_id == null ? -1 : __contract_distribution_id.compareTo(o.getContractDistributionId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_distribution_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__update_time);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		hash = 97 * hash + Objects.hashCode(this.__contract_date);
		hash = 97 * hash + Objects.hashCode(this.__actual_money);
		hash = 97 * hash + Objects.hashCode(this.__order_id);
		hash = 97 * hash + Objects.hashCode(this.__operation_manager_id);
		hash = 97 * hash + Objects.hashCode(this.__rate_of_progress);
		hash = 97 * hash + Objects.hashCode(this.__order_status);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseContractDistribution o = (BaseContractDistribution)obj;
		if(!Objects.equals(this.__contract_distribution_id, o.getContractDistributionId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__update_time, o.getUpdateTime())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		if(!Objects.equals(this.__contract_date, o.getContractDate())) return false;
		if(!Objects.equals(this.__actual_money, o.getActualMoney())) return false;
		if(!Objects.equals(this.__order_id, o.getOrderId())) return false;
		if(!Objects.equals(this.__operation_manager_id, o.getOperationManagerId())) return false;
		if(!Objects.equals(this.__rate_of_progress, o.getRateOfProgress())) return false;
		if(!Objects.equals(this.__order_status, o.getOrderStatus())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractDistributionId() != null) sb.append(__wrapNumber(count++, "contractDistributionId", getContractDistributionId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getBusinessType() != null) sb.append(__wrapNumber(count++, "businessType", getBusinessType()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getUpdateTime() != null) sb.append(__wrapDate(count++, "updateTime", getUpdateTime()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		if(getContractDate() != null) sb.append(__wrapDate(count++, "contractDate", getContractDate()));
		if(getActualMoney() != null) sb.append(__wrapDecimal(count++, "actualMoney", getActualMoney()));
		if(getOrderId() != null) sb.append(__wrapString(count++, "orderId", getOrderId()));
		if(getOperationManagerId() != null) sb.append(__wrapNumber(count++, "operationManagerId", getOperationManagerId()));
		if(getRateOfProgress() != null) sb.append(__wrapDecimal(count++, "rateOfProgress", getRateOfProgress()));
		if(getOrderStatus() != null) sb.append(__wrapNumber(count++, "orderStatus", getOrderStatus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractDistributionId")) != null) setContractDistributionId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("updateTime")) != null) setUpdateTime(__getDate(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("contractDate")) != null) setContractDate(__getDate(val)); 
		if((val = values.get("actualMoney")) != null) setActualMoney(__getDecimal(val));  
		if((val = values.get("orderId")) != null) setOrderId(__getString(val));
		if((val = values.get("operationManagerId")) != null) setOperationManagerId(__getInt(val)); 
		if((val = values.get("rateOfProgress")) != null) setRateOfProgress(__getDecimal(val));  
		if((val = values.get("orderStatus")) != null) setOrderStatus(__getInt(val)); 
	}

	protected java.lang.Integer  __contract_distribution_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __business_type ;
	protected java.math.BigDecimal  __amount ;
	protected java.lang.Integer  __operator ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __update_time ;
	protected java.lang.Integer  __delete_flag ;
	protected java.util.Date  __contract_date ;
	protected java.math.BigDecimal  __actual_money ;
	protected java.lang.String  __order_id ;
	protected java.lang.Integer  __operation_manager_id ;
	protected java.math.BigDecimal  __rate_of_progress ;
	protected java.lang.Integer  __order_status ;
}
