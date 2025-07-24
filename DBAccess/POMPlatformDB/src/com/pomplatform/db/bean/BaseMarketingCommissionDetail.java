package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseMarketingCommissionDetail extends GenericBase implements BaseFactory<BaseMarketingCommissionDetail>, Comparable<BaseMarketingCommissionDetail> 
{


	public static BaseMarketingCommissionDetail newInstance(){
		return new BaseMarketingCommissionDetail();
	}

	@Override
	public BaseMarketingCommissionDetail make(){
		BaseMarketingCommissionDetail b = new BaseMarketingCommissionDetail();
		return b;
	}

	public final static java.lang.String CS_MARKETING_COMMISSION_DETAIL_ID = "marketing_commission_detail_id" ;
	public final static java.lang.String CS_MARKETING_COMMISSION_ID = "marketing_commission_id" ;
	public final static java.lang.String CS_USER_ID = "user_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_REVENUE = "revenue" ;
	public final static java.lang.String CS_COMMISSION_DATE = "commission_date" ;
	public final static java.lang.String CS_TYPE = "type" ;

	public final static java.lang.String ALL_CAPTIONS = "营销提成详情表,营销提成表主键,分配对象的编码,合同编码,订单编码,提成,时间,结算类型(1,收入 2支出)";

	public java.lang.Short getMarketingCommissionDetailId() {
		return this.__marketing_commission_detail_id;
	}

	public void setMarketingCommissionDetailId( java.lang.Short value ) {
		this.__marketing_commission_detail_id = value;
	}

	public java.lang.Integer getMarketingCommissionId() {
		return this.__marketing_commission_id;
	}

	public void setMarketingCommissionId( java.lang.Integer value ) {
		this.__marketing_commission_id = value;
	}

	public java.lang.Integer getUserId() {
		return this.__user_id;
	}

	public void setUserId( java.lang.Integer value ) {
		this.__user_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.math.BigDecimal getRevenue() {
		return this.__revenue;
	}

	public void setRevenue( java.math.BigDecimal value ) {
		this.__revenue = value;
	}

	public java.util.Date getCommissionDate() {
		return this.__commission_date;
	}

	public void setCommissionDate( java.util.Date value ) {
		this.__commission_date = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public void cloneCopy(BaseMarketingCommissionDetail __bean){
		__bean.setMarketingCommissionDetailId(getMarketingCommissionDetailId());
		__bean.setMarketingCommissionId(getMarketingCommissionId());
		__bean.setUserId(getUserId());
		__bean.setContractId(getContractId());
		__bean.setProjectId(getProjectId());
		__bean.setRevenue(getRevenue());
		__bean.setCommissionDate(getCommissionDate());
		__bean.setType(getType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMarketingCommissionDetailId() == null ? "" : getMarketingCommissionDetailId());
		sb.append(",");
		sb.append(getMarketingCommissionId() == null ? "" : getMarketingCommissionId());
		sb.append(",");
		sb.append(getUserId() == null ? "" : getUserId());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getRevenue() == null ? "" : getRevenue());
		sb.append(",");
		sb.append(getCommissionDate() == null ? "" : sdf.format(getCommissionDate()));
		sb.append(",");
		sb.append(getType() == null ? "" : getType());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMarketingCommissionDetail o) {
		return __marketing_commission_detail_id == null ? -1 : __marketing_commission_detail_id.compareTo(o.getMarketingCommissionDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__marketing_commission_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__marketing_commission_id);
		hash = 97 * hash + Objects.hashCode(this.__user_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__revenue);
		hash = 97 * hash + Objects.hashCode(this.__commission_date);
		hash = 97 * hash + Objects.hashCode(this.__type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMarketingCommissionDetail o = (BaseMarketingCommissionDetail)obj;
		if(!Objects.equals(this.__marketing_commission_detail_id, o.getMarketingCommissionDetailId())) return false;
		if(!Objects.equals(this.__marketing_commission_id, o.getMarketingCommissionId())) return false;
		if(!Objects.equals(this.__user_id, o.getUserId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__revenue, o.getRevenue())) return false;
		if(!Objects.equals(this.__commission_date, o.getCommissionDate())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMarketingCommissionDetailId() != null) sb.append(__wrapNumber(count++, "marketingCommissionDetailId", getMarketingCommissionDetailId()));
		if(getMarketingCommissionId() != null) sb.append(__wrapNumber(count++, "marketingCommissionId", getMarketingCommissionId()));
		if(getUserId() != null) sb.append(__wrapNumber(count++, "userId", getUserId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getRevenue() != null) sb.append(__wrapDecimal(count++, "revenue", getRevenue()));
		if(getCommissionDate() != null) sb.append(__wrapDate(count++, "commissionDate", getCommissionDate()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getMarketingCommissionDetailId() != null) res.put("marketingCommissionDetailId", getMarketingCommissionDetailId());
		if(getMarketingCommissionId() != null) res.put("marketingCommissionId", getMarketingCommissionId());
		if(getUserId() != null) res.put("userId", getUserId());
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getProjectId() != null) res.put("projectId", getProjectId());
		if(getRevenue() != null) res.put("revenue", getRevenue());
		if(getCommissionDate() != null) res.put("commissionDate", getCommissionDate());
		if(getType() != null) res.put("type", getType());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("marketingCommissionDetailId")) != null) setMarketingCommissionDetailId(__getShort(val));
		if((val = values.get("marketingCommissionId")) != null) setMarketingCommissionId(__getInt(val)); 
		if((val = values.get("userId")) != null) setUserId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("revenue")) != null) setRevenue(__getDecimal(val));  
		if((val = values.get("commissionDate")) != null) setCommissionDate(__getDate(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
	}

	protected java.lang.Short  __marketing_commission_detail_id ;
	protected java.lang.Integer  __marketing_commission_id ;
	protected java.lang.Integer  __user_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __project_id ;
	protected java.math.BigDecimal  __revenue ;
	protected java.util.Date  __commission_date ;
	protected java.lang.Integer  __type ;
}
