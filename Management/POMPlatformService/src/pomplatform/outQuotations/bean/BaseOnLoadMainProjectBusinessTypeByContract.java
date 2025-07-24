package pomplatform.outQuotations.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadMainProjectBusinessTypeByContract extends GenericBase implements BaseFactory<BaseOnLoadMainProjectBusinessTypeByContract>, Comparable<BaseOnLoadMainProjectBusinessTypeByContract> 
{


	public static BaseOnLoadMainProjectBusinessTypeByContract newInstance(){
		return new BaseOnLoadMainProjectBusinessTypeByContract();
	}

	@Override
	public BaseOnLoadMainProjectBusinessTypeByContract make(){
		BaseOnLoadMainProjectBusinessTypeByContract b = new BaseOnLoadMainProjectBusinessTypeByContract();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_OUT_QUOTATION_ID = "out_quotation_id" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_SIGNING_MONEY_SUM = "signing_money_sum" ;
	public final static java.lang.String CS_OUTPUT_VALUE_SUM = "output_value_sum" ;

	public final static java.lang.String ALL_CAPTIONS = "主订单编码,主键编码,报价单编码,项目编号,项目名称,签约总金额,";

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.Integer getOutQuotationId() {
		return this.__out_quotation_id;
	}

	public void setOutQuotationId( java.lang.Integer value ) {
		this.__out_quotation_id = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.math.BigDecimal getSigningMoneySum() {
		return this.__signing_money_sum;
	}

	public void setSigningMoneySum( java.math.BigDecimal value ) {
		this.__signing_money_sum = value;
	}

	public java.math.BigDecimal getOutputValueSum() {
		return this.__output_value_sum;
	}

	public void setOutputValueSum( java.math.BigDecimal value ) {
		this.__output_value_sum = value;
	}

	public void cloneCopy(BaseOnLoadMainProjectBusinessTypeByContract __bean){
		__bean.setContractId(getContractId());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setOutQuotationId(getOutQuotationId());
		__bean.setProjectCode(getProjectCode());
		__bean.setProjectName(getProjectName());
		__bean.setSigningMoneySum(getSigningMoneySum());
		__bean.setOutputValueSum(getOutputValueSum());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getOutQuotationId() == null ? "" : getOutQuotationId());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getSigningMoneySum() == null ? "" : getSigningMoneySum());
		sb.append(",");
		sb.append(getOutputValueSum() == null ? "" : getOutputValueSum());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadMainProjectBusinessTypeByContract o) {
		return __contract_id == null ? -1 : __contract_id.compareTo(o.getContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__out_quotation_id);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__signing_money_sum);
		hash = 97 * hash + Objects.hashCode(this.__output_value_sum);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadMainProjectBusinessTypeByContract o = (BaseOnLoadMainProjectBusinessTypeByContract)obj;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__out_quotation_id, o.getOutQuotationId())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__signing_money_sum, o.getSigningMoneySum())) return false;
		if(!Objects.equals(this.__output_value_sum, o.getOutputValueSum())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getOutQuotationId() != null) sb.append(__wrapNumber(count++, "outQuotationId", getOutQuotationId()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getSigningMoneySum() != null) sb.append(__wrapDecimal(count++, "signingMoneySum", getSigningMoneySum()));
		if(getOutputValueSum() != null) sb.append(__wrapDecimal(count++, "outputValueSum", getOutputValueSum()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getMainProjectId() != null) res.put("mainProjectId", getMainProjectId());
		if(getOutQuotationId() != null) res.put("outQuotationId", getOutQuotationId());
		if(getProjectCode() != null) res.put("projectCode", getProjectCode());
		if(getProjectName() != null) res.put("projectName", getProjectName());
		if(getSigningMoneySum() != null) res.put("signingMoneySum", getSigningMoneySum());
		if(getOutputValueSum() != null) res.put("outputValueSum", getOutputValueSum());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("outQuotationId")) != null) setOutQuotationId(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("signingMoneySum")) != null) setSigningMoneySum(__getDecimal(val));  
		if((val = values.get("outputValueSum")) != null) setOutputValueSum(__getDecimal(val));  
	}

	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.Integer  __out_quotation_id ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __project_name ;
	protected java.math.BigDecimal  __signing_money_sum ;
	protected java.math.BigDecimal  __output_value_sum ;
}
