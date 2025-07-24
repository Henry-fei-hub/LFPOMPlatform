package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseMarketingCommission extends GenericBase implements BaseFactory<BaseMarketingCommission>, Comparable<BaseMarketingCommission> 
{


	public static BaseMarketingCommission newInstance(){
		return new BaseMarketingCommission();
	}

	@Override
	public BaseMarketingCommission make(){
		BaseMarketingCommission b = new BaseMarketingCommission();
		return b;
	}

	public final static java.lang.String CS_MARKETING_COMMISSION_ID = "marketing_commission_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_COMMISSIONS = "commissions" ;
	public final static java.lang.String CS_COMMISSIONS_RATE = "commissions_rate" ;
	public final static java.lang.String CS_CUMULATIVE_REVENUE = "cumulative_revenue" ;
	public final static java.lang.String CS_DAY_REVENUE = "day_revenue" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_SETTLEMENT_IDENTIFIER = "settlement_identifier" ;
	public final static java.lang.String CS_REAL_PROGRESS = "real_progress" ;
	public final static java.lang.String CS_RELATIVELY_PROGRESS = "relatively_progress" ;
	public final static java.lang.String CS_INCOME = "income" ;
	public final static java.lang.String CS_PROJECT_AMOUNT = "project_amount" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_TOTAL_INCOME = "total_income" ;

	public final static java.lang.String ALL_CAPTIONS = "营销提成主表,合同编码,订单编码,提成的时间,提成的系数,累计提成,当天提成,归属部门,结算标识,项目的真实进度,相对进度,当天营收,订单的金额,业态,总的营收";

	public java.lang.Short getMarketingCommissionId() {
		return this.__marketing_commission_id;
	}

	public void setMarketingCommissionId( java.lang.Short value ) {
		this.__marketing_commission_id = value;
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

	public java.util.Date getCommissions() {
		return this.__commissions;
	}

	public void setCommissions( java.util.Date value ) {
		this.__commissions = value;
	}

	public java.math.BigDecimal getCommissionsRate() {
		return this.__commissions_rate;
	}

	public void setCommissionsRate( java.math.BigDecimal value ) {
		this.__commissions_rate = value;
	}

	public java.math.BigDecimal getCumulativeRevenue() {
		return this.__cumulative_revenue;
	}

	public void setCumulativeRevenue( java.math.BigDecimal value ) {
		this.__cumulative_revenue = value;
	}

	public java.math.BigDecimal getDayRevenue() {
		return this.__day_revenue;
	}

	public void setDayRevenue( java.math.BigDecimal value ) {
		this.__day_revenue = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getSettlementIdentifier() {
		return this.__settlement_identifier;
	}

	public void setSettlementIdentifier( java.lang.Integer value ) {
		this.__settlement_identifier = value;
	}

	public java.math.BigDecimal getRealProgress() {
		return this.__real_progress;
	}

	public void setRealProgress( java.math.BigDecimal value ) {
		this.__real_progress = value;
	}

	public java.math.BigDecimal getRelativelyProgress() {
		return this.__relatively_progress;
	}

	public void setRelativelyProgress( java.math.BigDecimal value ) {
		this.__relatively_progress = value;
	}

	public java.math.BigDecimal getIncome() {
		return this.__income;
	}

	public void setIncome( java.math.BigDecimal value ) {
		this.__income = value;
	}

	public java.math.BigDecimal getProjectAmount() {
		return this.__project_amount;
	}

	public void setProjectAmount( java.math.BigDecimal value ) {
		this.__project_amount = value;
	}

	public java.lang.String getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.String value ) {
		this.__business_type = value;
	}

	public java.math.BigDecimal getTotalIncome() {
		return this.__total_income;
	}

	public void setTotalIncome( java.math.BigDecimal value ) {
		this.__total_income = value;
	}

	public void cloneCopy(BaseMarketingCommission __bean){
		__bean.setMarketingCommissionId(getMarketingCommissionId());
		__bean.setContractId(getContractId());
		__bean.setProjectId(getProjectId());
		__bean.setCommissions(getCommissions());
		__bean.setCommissionsRate(getCommissionsRate());
		__bean.setCumulativeRevenue(getCumulativeRevenue());
		__bean.setDayRevenue(getDayRevenue());
		__bean.setPlateId(getPlateId());
		__bean.setSettlementIdentifier(getSettlementIdentifier());
		__bean.setRealProgress(getRealProgress());
		__bean.setRelativelyProgress(getRelativelyProgress());
		__bean.setIncome(getIncome());
		__bean.setProjectAmount(getProjectAmount());
		__bean.setBusinessType(getBusinessType());
		__bean.setTotalIncome(getTotalIncome());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMarketingCommissionId() == null ? "" : getMarketingCommissionId());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getCommissions() == null ? "" : sdf.format(getCommissions()));
		sb.append(",");
		sb.append(getCommissionsRate() == null ? "" : getCommissionsRate());
		sb.append(",");
		sb.append(getCumulativeRevenue() == null ? "" : getCumulativeRevenue());
		sb.append(",");
		sb.append(getDayRevenue() == null ? "" : getDayRevenue());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getSettlementIdentifier() == null ? "" : getSettlementIdentifier());
		sb.append(",");
		sb.append(getRealProgress() == null ? "" : getRealProgress());
		sb.append(",");
		sb.append(getRelativelyProgress() == null ? "" : getRelativelyProgress());
		sb.append(",");
		sb.append(getIncome() == null ? "" : getIncome());
		sb.append(",");
		sb.append(getProjectAmount() == null ? "" : getProjectAmount());
		sb.append(",");
		sb.append(getBusinessType() == null ? "" : getBusinessType());
		sb.append(",");
		sb.append(getTotalIncome() == null ? "" : getTotalIncome());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMarketingCommission o) {
		return __marketing_commission_id == null ? -1 : __marketing_commission_id.compareTo(o.getMarketingCommissionId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__marketing_commission_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__commissions);
		hash = 97 * hash + Objects.hashCode(this.__commissions_rate);
		hash = 97 * hash + Objects.hashCode(this.__cumulative_revenue);
		hash = 97 * hash + Objects.hashCode(this.__day_revenue);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__settlement_identifier);
		hash = 97 * hash + Objects.hashCode(this.__real_progress);
		hash = 97 * hash + Objects.hashCode(this.__relatively_progress);
		hash = 97 * hash + Objects.hashCode(this.__income);
		hash = 97 * hash + Objects.hashCode(this.__project_amount);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__total_income);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMarketingCommission o = (BaseMarketingCommission)obj;
		if(!Objects.equals(this.__marketing_commission_id, o.getMarketingCommissionId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__commissions, o.getCommissions())) return false;
		if(!Objects.equals(this.__commissions_rate, o.getCommissionsRate())) return false;
		if(!Objects.equals(this.__cumulative_revenue, o.getCumulativeRevenue())) return false;
		if(!Objects.equals(this.__day_revenue, o.getDayRevenue())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__settlement_identifier, o.getSettlementIdentifier())) return false;
		if(!Objects.equals(this.__real_progress, o.getRealProgress())) return false;
		if(!Objects.equals(this.__relatively_progress, o.getRelativelyProgress())) return false;
		if(!Objects.equals(this.__income, o.getIncome())) return false;
		if(!Objects.equals(this.__project_amount, o.getProjectAmount())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__total_income, o.getTotalIncome())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMarketingCommissionId() != null) sb.append(__wrapNumber(count++, "marketingCommissionId", getMarketingCommissionId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getCommissions() != null) sb.append(__wrapDate(count++, "commissions", getCommissions()));
		if(getCommissionsRate() != null) sb.append(__wrapDecimal(count++, "commissionsRate", getCommissionsRate()));
		if(getCumulativeRevenue() != null) sb.append(__wrapDecimal(count++, "cumulativeRevenue", getCumulativeRevenue()));
		if(getDayRevenue() != null) sb.append(__wrapDecimal(count++, "dayRevenue", getDayRevenue()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getSettlementIdentifier() != null) sb.append(__wrapNumber(count++, "settlementIdentifier", getSettlementIdentifier()));
		if(getRealProgress() != null) sb.append(__wrapDecimal(count++, "realProgress", getRealProgress()));
		if(getRelativelyProgress() != null) sb.append(__wrapDecimal(count++, "relativelyProgress", getRelativelyProgress()));
		if(getIncome() != null) sb.append(__wrapDecimal(count++, "income", getIncome()));
		if(getProjectAmount() != null) sb.append(__wrapDecimal(count++, "projectAmount", getProjectAmount()));
		if(getBusinessType() != null) sb.append(__wrapString(count++, "businessType", getBusinessType()));
		if(getTotalIncome() != null) sb.append(__wrapDecimal(count++, "totalIncome", getTotalIncome()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getMarketingCommissionId() != null) res.put("marketingCommissionId", getMarketingCommissionId());
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getProjectId() != null) res.put("projectId", getProjectId());
		if(getCommissions() != null) res.put("commissions", getCommissions());
		if(getCommissionsRate() != null) res.put("commissionsRate", getCommissionsRate());
		if(getCumulativeRevenue() != null) res.put("cumulativeRevenue", getCumulativeRevenue());
		if(getDayRevenue() != null) res.put("dayRevenue", getDayRevenue());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getSettlementIdentifier() != null) res.put("settlementIdentifier", getSettlementIdentifier());
		if(getRealProgress() != null) res.put("realProgress", getRealProgress());
		if(getRelativelyProgress() != null) res.put("relativelyProgress", getRelativelyProgress());
		if(getIncome() != null) res.put("income", getIncome());
		if(getProjectAmount() != null) res.put("projectAmount", getProjectAmount());
		if(getBusinessType() != null) res.put("businessType", getBusinessType());
		if(getTotalIncome() != null) res.put("totalIncome", getTotalIncome());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("marketingCommissionId")) != null) setMarketingCommissionId(__getShort(val));
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("commissions")) != null) setCommissions(__getDate(val)); 
		if((val = values.get("commissionsRate")) != null) setCommissionsRate(__getDecimal(val));  
		if((val = values.get("cumulativeRevenue")) != null) setCumulativeRevenue(__getDecimal(val));  
		if((val = values.get("dayRevenue")) != null) setDayRevenue(__getDecimal(val));  
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("settlementIdentifier")) != null) setSettlementIdentifier(__getInt(val)); 
		if((val = values.get("realProgress")) != null) setRealProgress(__getDecimal(val));  
		if((val = values.get("relativelyProgress")) != null) setRelativelyProgress(__getDecimal(val));  
		if((val = values.get("income")) != null) setIncome(__getDecimal(val));  
		if((val = values.get("projectAmount")) != null) setProjectAmount(__getDecimal(val));  
		if((val = values.get("businessType")) != null) setBusinessType(__getString(val));
		if((val = values.get("totalIncome")) != null) setTotalIncome(__getDecimal(val));  
	}

	protected java.lang.Short  __marketing_commission_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __project_id ;
	protected java.util.Date  __commissions ;
	protected java.math.BigDecimal  __commissions_rate ;
	protected java.math.BigDecimal  __cumulative_revenue ;
	protected java.math.BigDecimal  __day_revenue ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __settlement_identifier ;
	protected java.math.BigDecimal  __real_progress ;
	protected java.math.BigDecimal  __relatively_progress ;
	protected java.math.BigDecimal  __income ;
	protected java.math.BigDecimal  __project_amount ;
	protected java.lang.String  __business_type ;
	protected java.math.BigDecimal  __total_income ;
}
