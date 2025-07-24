package pomplatform.k3voucher.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetRevenueByCompany extends GenericBase implements BaseFactory<BaseGetRevenueByCompany>, Comparable<BaseGetRevenueByCompany> 
{


	public static BaseGetRevenueByCompany newInstance(){
		return new BaseGetRevenueByCompany();
	}

	@Override
	public BaseGetRevenueByCompany make(){
		BaseGetRevenueByCompany b = new BaseGetRevenueByCompany();
		return b;
	}

	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_CURRENT_REVENUE = "current_revenue" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CUSTOMER_ID = "customer_id" ;

	public final static java.lang.String ALL_CAPTIONS = "项目编码,本月营收,合同编码,客户编码";

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.math.BigDecimal getCurrentRevenue() {
		return this.__current_revenue;
	}

	public void setCurrentRevenue( java.math.BigDecimal value ) {
		this.__current_revenue = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getCustomerId() {
		return this.__customer_id;
	}

	public void setCustomerId( java.lang.Integer value ) {
		this.__customer_id = value;
	}

	public void cloneCopy(BaseGetRevenueByCompany __bean){
		__bean.setProjectId(getProjectId());
		__bean.setCurrentRevenue(getCurrentRevenue());
		__bean.setContractId(getContractId());
		__bean.setCustomerId(getCustomerId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		sb.append(getCurrentRevenue() == null ? "" : getCurrentRevenue());
		sb.append(",");
		String strContractId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractId()));
		sb.append(strContractId == null ? "" : strContractId);
		sb.append(",");
		sb.append(getCustomerId() == null ? "" : getCustomerId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetRevenueByCompany o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__current_revenue);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__customer_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetRevenueByCompany o = (BaseGetRevenueByCompany)obj;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__current_revenue, o.getCurrentRevenue())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__customer_id, o.getCustomerId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getCurrentRevenue() != null) sb.append(__wrapDecimal(count++, "currentRevenue", getCurrentRevenue()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getCustomerId() != null) sb.append(__wrapNumber(count++, "customerId", getCustomerId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProjectId() != null) res.put("projectId", getProjectId());
		if(getCurrentRevenue() != null) res.put("currentRevenue", getCurrentRevenue());
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getCustomerId() != null) res.put("customerId", getCustomerId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("currentRevenue")) != null) setCurrentRevenue(__getDecimal(val));  
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("customerId")) != null) setCustomerId(__getInt(val)); 
	}

	protected java.lang.Integer  __project_id ;
	protected java.math.BigDecimal  __current_revenue ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __customer_id ;
}
