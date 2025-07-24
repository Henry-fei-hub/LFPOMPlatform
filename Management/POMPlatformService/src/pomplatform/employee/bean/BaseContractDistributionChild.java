package pomplatform.employee.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseContractDistributionChild extends GenericBase implements BaseFactory<BaseContractDistributionChild>, Comparable<BaseContractDistributionChild> 
{


	public static BaseContractDistributionChild newInstance(){
		return new BaseContractDistributionChild();
	}

	@Override
	public BaseContractDistributionChild make(){
		BaseContractDistributionChild b = new BaseContractDistributionChild();
		return b;
	}

	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_PROJECT_AMOUNT = "project_amount" ;
	public final static java.lang.String CS_COMMISSIONS_RATE = "commissions_rate" ;
	public final static java.lang.String CS_REVENUE_INTEGRAL = "revenue_integral" ;
	public final static java.lang.String CS_RELATIVELY_PROGRESS = "relatively_progress" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;

	public final static java.lang.String ALL_CAPTIONS = "订单编码,主订单编号,合同编码,项目名称,业态,订单的金额,提成的系数,,相对进度,";

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.String value ) {
		this.__business_type = value;
	}

	public java.math.BigDecimal getProjectAmount() {
		return this.__project_amount;
	}

	public void setProjectAmount( java.math.BigDecimal value ) {
		this.__project_amount = value;
	}

	public java.math.BigDecimal getCommissionsRate() {
		return this.__commissions_rate;
	}

	public void setCommissionsRate( java.math.BigDecimal value ) {
		this.__commissions_rate = value;
	}

	public java.math.BigDecimal getRevenueIntegral() {
		return this.__revenue_integral;
	}

	public void setRevenueIntegral( java.math.BigDecimal value ) {
		this.__revenue_integral = value;
	}

	public java.math.BigDecimal getRelativelyProgress() {
		return this.__relatively_progress;
	}

	public void setRelativelyProgress( java.math.BigDecimal value ) {
		this.__relatively_progress = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public void cloneCopy(BaseContractDistributionChild __bean){
		__bean.setProjectId(getProjectId());
		__bean.setContractCode(getContractCode());
		__bean.setContractId(getContractId());
		__bean.setProjectName(getProjectName());
		__bean.setBusinessType(getBusinessType());
		__bean.setProjectAmount(getProjectAmount());
		__bean.setCommissionsRate(getCommissionsRate());
		__bean.setRevenueIntegral(getRevenueIntegral());
		__bean.setRelativelyProgress(getRelativelyProgress());
		__bean.setAmount(getAmount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getBusinessType() == null ? "" : getBusinessType());
		sb.append(",");
		sb.append(getProjectAmount() == null ? "" : getProjectAmount());
		sb.append(",");
		sb.append(getCommissionsRate() == null ? "" : getCommissionsRate());
		sb.append(",");
		sb.append(getRevenueIntegral() == null ? "" : getRevenueIntegral());
		sb.append(",");
		sb.append(getRelativelyProgress() == null ? "" : getRelativelyProgress());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseContractDistributionChild o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__project_amount);
		hash = 97 * hash + Objects.hashCode(this.__commissions_rate);
		hash = 97 * hash + Objects.hashCode(this.__revenue_integral);
		hash = 97 * hash + Objects.hashCode(this.__relatively_progress);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseContractDistributionChild o = (BaseContractDistributionChild)obj;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__project_amount, o.getProjectAmount())) return false;
		if(!Objects.equals(this.__commissions_rate, o.getCommissionsRate())) return false;
		if(!Objects.equals(this.__revenue_integral, o.getRevenueIntegral())) return false;
		if(!Objects.equals(this.__relatively_progress, o.getRelativelyProgress())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getBusinessType() != null) sb.append(__wrapString(count++, "businessType", getBusinessType()));
		if(getProjectAmount() != null) sb.append(__wrapDecimal(count++, "projectAmount", getProjectAmount()));
		if(getCommissionsRate() != null) sb.append(__wrapDecimal(count++, "commissionsRate", getCommissionsRate()));
		if(getRevenueIntegral() != null) sb.append(__wrapDecimal(count++, "revenueIntegral", getRevenueIntegral()));
		if(getRelativelyProgress() != null) sb.append(__wrapDecimal(count++, "relativelyProgress", getRelativelyProgress()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProjectId() != null) res.put("projectId", getProjectId());
		if(getContractCode() != null) res.put("contractCode", getContractCode());
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getProjectName() != null) res.put("projectName", getProjectName());
		if(getBusinessType() != null) res.put("businessType", getBusinessType());
		if(getProjectAmount() != null) res.put("projectAmount", getProjectAmount());
		if(getCommissionsRate() != null) res.put("commissionsRate", getCommissionsRate());
		if(getRevenueIntegral() != null) res.put("revenueIntegral", getRevenueIntegral());
		if(getRelativelyProgress() != null) res.put("relativelyProgress", getRelativelyProgress());
		if(getAmount() != null) res.put("amount", getAmount());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("businessType")) != null) setBusinessType(__getString(val));
		if((val = values.get("projectAmount")) != null) setProjectAmount(__getDecimal(val));  
		if((val = values.get("commissionsRate")) != null) setCommissionsRate(__getDecimal(val));  
		if((val = values.get("revenueIntegral")) != null) setRevenueIntegral(__getDecimal(val));  
		if((val = values.get("relativelyProgress")) != null) setRelativelyProgress(__getDecimal(val));  
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
	}

	protected java.lang.Integer  __project_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __project_name ;
	protected java.lang.String  __business_type ;
	protected java.math.BigDecimal  __project_amount ;
	protected java.math.BigDecimal  __commissions_rate ;
	protected java.math.BigDecimal  __revenue_integral ;
	protected java.math.BigDecimal  __relatively_progress ;
	protected java.math.BigDecimal  __amount ;
}
