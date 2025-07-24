package pomplatform.OnRevenue.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseAllSheetDataOfRevenue extends GenericBase implements BaseFactory<BaseAllSheetDataOfRevenue>, Comparable<BaseAllSheetDataOfRevenue> 
{


	public static BaseAllSheetDataOfRevenue newInstance(){
		return new BaseAllSheetDataOfRevenue();
	}

	@Override
	public BaseAllSheetDataOfRevenue make(){
		BaseAllSheetDataOfRevenue b = new BaseAllSheetDataOfRevenue();
		return b;
	}

	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_SUB_CONTRACT_CODE = "sub_contract_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_SUB_CONTRACT_ID = "sub_contract_id" ;
	public final static java.lang.String CS_BUSINESS_STATE_RECORD_ID = "business_state_record_id" ;
	public final static java.lang.String CS_ACCOUNT_WEIGHT_RECORD_ID = "account_weight_record_id" ;
	public final static java.lang.String CS_BUSINESS_CODE = "business_code" ;
	public final static java.lang.String CS_BUSINESS_INTEGRAL = "business_integral" ;
	public final static java.lang.String CS_BEFORE_CONTRACT_TOTAL = "before_contract_total" ;
	public final static java.lang.String CS_BUSINESS_NAME = "business_name" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_SIGNING_MONEY_SUM = "signing_money_sum" ;

	public final static java.lang.String ALL_CAPTIONS = "项目编码,板块,项目编号,子合同编号,项目名称,子合同编码,业态编码,业态类型,业态编号,总金额,修改前合同总价,业态名称,合同编码,合同编号,签约总金额";

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getSubContractCode() {
		return this.__sub_contract_code;
	}

	public void setSubContractCode( java.lang.String value ) {
		this.__sub_contract_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.Integer getSubContractId() {
		return this.__sub_contract_id;
	}

	public void setSubContractId( java.lang.Integer value ) {
		this.__sub_contract_id = value;
	}

	public java.lang.Integer getBusinessStateRecordId() {
		return this.__business_state_record_id;
	}

	public void setBusinessStateRecordId( java.lang.Integer value ) {
		this.__business_state_record_id = value;
	}

	public java.lang.Integer getAccountWeightRecordId() {
		return this.__account_weight_record_id;
	}

	public void setAccountWeightRecordId( java.lang.Integer value ) {
		this.__account_weight_record_id = value;
	}

	public java.lang.String getBusinessCode() {
		return this.__business_code;
	}

	public void setBusinessCode( java.lang.String value ) {
		this.__business_code = value;
	}

	public java.math.BigDecimal getBusinessIntegral() {
		return this.__business_integral;
	}

	public void setBusinessIntegral( java.math.BigDecimal value ) {
		this.__business_integral = value;
	}

	public java.math.BigDecimal getBeforeContractTotal() {
		return this.__before_contract_total;
	}

	public void setBeforeContractTotal( java.math.BigDecimal value ) {
		this.__before_contract_total = value;
	}

	public java.lang.String getBusinessName() {
		return this.__business_name;
	}

	public void setBusinessName( java.lang.String value ) {
		this.__business_name = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.math.BigDecimal getSigningMoneySum() {
		return this.__signing_money_sum;
	}

	public void setSigningMoneySum( java.math.BigDecimal value ) {
		this.__signing_money_sum = value;
	}

	public void cloneCopy(BaseAllSheetDataOfRevenue __bean){
		__bean.setProjectId(getProjectId());
		__bean.setPlateId(getPlateId());
		__bean.setProjectCode(getProjectCode());
		__bean.setSubContractCode(getSubContractCode());
		__bean.setProjectName(getProjectName());
		__bean.setSubContractId(getSubContractId());
		__bean.setBusinessStateRecordId(getBusinessStateRecordId());
		__bean.setAccountWeightRecordId(getAccountWeightRecordId());
		__bean.setBusinessCode(getBusinessCode());
		__bean.setBusinessIntegral(getBusinessIntegral());
		__bean.setBeforeContractTotal(getBeforeContractTotal());
		__bean.setBusinessName(getBusinessName());
		__bean.setContractId(getContractId());
		__bean.setContractCode(getContractCode());
		__bean.setSigningMoneySum(getSigningMoneySum());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getSubContractCode() == null ? "" : getSubContractCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getSubContractId() == null ? "" : getSubContractId());
		sb.append(",");
		sb.append(getBusinessStateRecordId() == null ? "" : getBusinessStateRecordId());
		sb.append(",");
		sb.append(getAccountWeightRecordId() == null ? "" : getAccountWeightRecordId());
		sb.append(",");
		sb.append(getBusinessCode() == null ? "" : getBusinessCode());
		sb.append(",");
		sb.append(getBusinessIntegral() == null ? "" : getBusinessIntegral());
		sb.append(",");
		sb.append(getBeforeContractTotal() == null ? "" : getBeforeContractTotal());
		sb.append(",");
		sb.append(getBusinessName() == null ? "" : getBusinessName());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		String strContractCode = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractCode()));
		sb.append(strContractCode == null ? "" : strContractCode);
		sb.append(",");
		sb.append(getSigningMoneySum() == null ? "" : getSigningMoneySum());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAllSheetDataOfRevenue o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__sub_contract_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__sub_contract_id);
		hash = 97 * hash + Objects.hashCode(this.__business_state_record_id);
		hash = 97 * hash + Objects.hashCode(this.__account_weight_record_id);
		hash = 97 * hash + Objects.hashCode(this.__business_code);
		hash = 97 * hash + Objects.hashCode(this.__business_integral);
		hash = 97 * hash + Objects.hashCode(this.__before_contract_total);
		hash = 97 * hash + Objects.hashCode(this.__business_name);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__signing_money_sum);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAllSheetDataOfRevenue o = (BaseAllSheetDataOfRevenue)obj;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__sub_contract_code, o.getSubContractCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__sub_contract_id, o.getSubContractId())) return false;
		if(!Objects.equals(this.__business_state_record_id, o.getBusinessStateRecordId())) return false;
		if(!Objects.equals(this.__account_weight_record_id, o.getAccountWeightRecordId())) return false;
		if(!Objects.equals(this.__business_code, o.getBusinessCode())) return false;
		if(!Objects.equals(this.__business_integral, o.getBusinessIntegral())) return false;
		if(!Objects.equals(this.__before_contract_total, o.getBeforeContractTotal())) return false;
		if(!Objects.equals(this.__business_name, o.getBusinessName())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__signing_money_sum, o.getSigningMoneySum())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getSubContractCode() != null) sb.append(__wrapString(count++, "subContractCode", getSubContractCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getSubContractId() != null) sb.append(__wrapNumber(count++, "subContractId", getSubContractId()));
		if(getBusinessStateRecordId() != null) sb.append(__wrapNumber(count++, "businessStateRecordId", getBusinessStateRecordId()));
		if(getAccountWeightRecordId() != null) sb.append(__wrapNumber(count++, "accountWeightRecordId", getAccountWeightRecordId()));
		if(getBusinessCode() != null) sb.append(__wrapString(count++, "businessCode", getBusinessCode()));
		if(getBusinessIntegral() != null) sb.append(__wrapDecimal(count++, "businessIntegral", getBusinessIntegral()));
		if(getBeforeContractTotal() != null) sb.append(__wrapDecimal(count++, "beforeContractTotal", getBeforeContractTotal()));
		if(getBusinessName() != null) sb.append(__wrapString(count++, "businessName", getBusinessName()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getSigningMoneySum() != null) sb.append(__wrapDecimal(count++, "signingMoneySum", getSigningMoneySum()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("subContractCode")) != null) setSubContractCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("subContractId")) != null) setSubContractId(__getInt(val)); 
		if((val = values.get("businessStateRecordId")) != null) setBusinessStateRecordId(__getInt(val)); 
		if((val = values.get("accountWeightRecordId")) != null) setAccountWeightRecordId(__getInt(val)); 
		if((val = values.get("businessCode")) != null) setBusinessCode(__getString(val));
		if((val = values.get("businessIntegral")) != null) setBusinessIntegral(__getDecimal(val));  
		if((val = values.get("beforeContractTotal")) != null) setBeforeContractTotal(__getDecimal(val));  
		if((val = values.get("businessName")) != null) setBusinessName(__getString(val));
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("signingMoneySum")) != null) setSigningMoneySum(__getDecimal(val));  
	}

	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __sub_contract_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.Integer  __sub_contract_id ;
	protected java.lang.Integer  __business_state_record_id ;
	protected java.lang.Integer  __account_weight_record_id ;
	protected java.lang.String  __business_code ;
	protected java.math.BigDecimal  __business_integral ;
	protected java.math.BigDecimal  __before_contract_total ;
	protected java.lang.String  __business_name ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __contract_code ;
	protected java.math.BigDecimal  __signing_money_sum ;
}
