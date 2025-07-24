package pomplatform.capitaldistribution.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseAutoFitInfo extends GenericBase implements BaseFactory<BaseAutoFitInfo>, Comparable<BaseAutoFitInfo> 
{


	public static BaseAutoFitInfo newInstance(){
		return new BaseAutoFitInfo();
	}

	@Override
	public BaseAutoFitInfo make(){
		BaseAutoFitInfo b = new BaseAutoFitInfo();
		return b;
	}

	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_SURE_INTEGRAL = "sure_integral" ;
	public final static java.lang.String CS_DISTRIBUTION_AMOUNT = "distribution_amount" ;
	public final static java.lang.String CS_PROJECT_INTEGRAL = "project_integral" ;
	public final static java.lang.String CS_SHEET_AMOUNT = "sheet_amount" ;
	public final static java.lang.String CS_CALCULATION_RESULT = "calculation_result" ;

	public final static java.lang.String ALL_CAPTIONS = "项目ID,业务部门,合同ID,确认积分,回款分配金额,项目积分,订单合同金额,计算结果";

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

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.math.BigDecimal getSureIntegral() {
		return this.__sure_integral;
	}

	public void setSureIntegral( java.math.BigDecimal value ) {
		this.__sure_integral = value;
	}

	public java.math.BigDecimal getDistributionAmount() {
		return this.__distribution_amount;
	}

	public void setDistributionAmount( java.math.BigDecimal value ) {
		this.__distribution_amount = value;
	}

	public java.math.BigDecimal getProjectIntegral() {
		return this.__project_integral;
	}

	public void setProjectIntegral( java.math.BigDecimal value ) {
		this.__project_integral = value;
	}

	public java.math.BigDecimal getSheetAmount() {
		return this.__sheet_amount;
	}

	public void setSheetAmount( java.math.BigDecimal value ) {
		this.__sheet_amount = value;
	}

	public java.math.BigDecimal getCalculationResult() {
		return this.__calculation_result;
	}

	public void setCalculationResult( java.math.BigDecimal value ) {
		this.__calculation_result = value;
	}

	public void cloneCopy(BaseAutoFitInfo __bean){
		__bean.setProjectId(getProjectId());
		__bean.setPlateId(getPlateId());
		__bean.setContractId(getContractId());
		__bean.setSureIntegral(getSureIntegral());
		__bean.setDistributionAmount(getDistributionAmount());
		__bean.setProjectIntegral(getProjectIntegral());
		__bean.setSheetAmount(getSheetAmount());
		__bean.setCalculationResult(getCalculationResult());
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
		String strContractId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractId()));
		sb.append(strContractId == null ? "" : strContractId);
		sb.append(",");
		sb.append(getSureIntegral() == null ? "" : getSureIntegral());
		sb.append(",");
		sb.append(getDistributionAmount() == null ? "" : getDistributionAmount());
		sb.append(",");
		sb.append(getProjectIntegral() == null ? "" : getProjectIntegral());
		sb.append(",");
		sb.append(getSheetAmount() == null ? "" : getSheetAmount());
		sb.append(",");
		sb.append(getCalculationResult() == null ? "" : getCalculationResult());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAutoFitInfo o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__distribution_amount);
		hash = 97 * hash + Objects.hashCode(this.__project_integral);
		hash = 97 * hash + Objects.hashCode(this.__sheet_amount);
		hash = 97 * hash + Objects.hashCode(this.__calculation_result);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAutoFitInfo o = (BaseAutoFitInfo)obj;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__sure_integral, o.getSureIntegral())) return false;
		if(!Objects.equals(this.__distribution_amount, o.getDistributionAmount())) return false;
		if(!Objects.equals(this.__project_integral, o.getProjectIntegral())) return false;
		if(!Objects.equals(this.__sheet_amount, o.getSheetAmount())) return false;
		if(!Objects.equals(this.__calculation_result, o.getCalculationResult())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getSureIntegral() != null) sb.append(__wrapDecimal(count++, "sureIntegral", getSureIntegral()));
		if(getDistributionAmount() != null) sb.append(__wrapDecimal(count++, "distributionAmount", getDistributionAmount()));
		if(getProjectIntegral() != null) sb.append(__wrapDecimal(count++, "projectIntegral", getProjectIntegral()));
		if(getSheetAmount() != null) sb.append(__wrapDecimal(count++, "sheetAmount", getSheetAmount()));
		if(getCalculationResult() != null) sb.append(__wrapDecimal(count++, "calculationResult", getCalculationResult()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("sureIntegral")) != null) setSureIntegral(__getDecimal(val));  
		if((val = values.get("distributionAmount")) != null) setDistributionAmount(__getDecimal(val));  
		if((val = values.get("projectIntegral")) != null) setProjectIntegral(__getDecimal(val));  
		if((val = values.get("sheetAmount")) != null) setSheetAmount(__getDecimal(val));  
		if((val = values.get("calculationResult")) != null) setCalculationResult(__getDecimal(val));  
	}

	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.math.BigDecimal  __sure_integral ;
	protected java.math.BigDecimal  __distribution_amount ;
	protected java.math.BigDecimal  __project_integral ;
	protected java.math.BigDecimal  __sheet_amount ;
	protected java.math.BigDecimal  __calculation_result ;
}
