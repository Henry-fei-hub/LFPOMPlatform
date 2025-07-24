package pomplatform.capitaldistribution.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetProjectInfoAndLeftAmount extends GenericBase implements BaseFactory<BaseGetProjectInfoAndLeftAmount>, Comparable<BaseGetProjectInfoAndLeftAmount> 
{


	public static BaseGetProjectInfoAndLeftAmount newInstance(){
		return new BaseGetProjectInfoAndLeftAmount();
	}

	@Override
	public BaseGetProjectInfoAndLeftAmount make(){
		BaseGetProjectInfoAndLeftAmount b = new BaseGetProjectInfoAndLeftAmount();
		return b;
	}

	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_LEFT_AMOUNT = "left_amount" ;

	public final static java.lang.String ALL_CAPTIONS = "项目编码,合同编号,合同编码,";

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

	public java.math.BigDecimal getLeftAmount() {
		return this.__left_amount;
	}

	public void setLeftAmount( java.math.BigDecimal value ) {
		this.__left_amount = value;
	}

	public java.lang.Integer getPlateId() {
		return __plate_id;
	}

	public void setPlateId(java.lang.Integer value) {
		this.__plate_id = value;
	}

	public java.math.BigDecimal getSheetAmount() {
		return sheet_amount;
	}

	public void setSheetAmount(java.math.BigDecimal value) {
		this.sheet_amount = value;
	}

	public java.math.BigDecimal getDistributedAmount() {
		return distributed_amount;
	}

	public void setDistributedAmount(java.math.BigDecimal value) {
		this.distributed_amount = value;
	}

	public java.math.BigDecimal getProjectIntegral() {
		return project_integral;
	}

	public void setProjectIntegral(java.math.BigDecimal value) {
		this.project_integral = value;
	}

	public java.math.BigDecimal getSureIntegral() {
		return sure_integral;
	}

	public void setSureIntegral(java.math.BigDecimal value) {
		this.sure_integral = value;
	}

	public void cloneCopy(BaseGetProjectInfoAndLeftAmount __bean){
		__bean.setProjectId(getProjectId());
		__bean.setContractCode(getContractCode());
		__bean.setContractId(getContractId());
		__bean.setLeftAmount(getLeftAmount());
		__bean.setPlateId(getPlateId());
		__bean.setSheetAmount(getSheetAmount());
		__bean.setDistributedAmount(getDistributedAmount());
		__bean.setProjectIntegral(getProjectIntegral());
		__bean.setSureIntegral(getSureIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		String strContractCode = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractCode()));
		sb.append(strContractCode == null ? "" : strContractCode);
		sb.append(",");
		String strContractId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractId()));
		sb.append(strContractId == null ? "" : strContractId);
		sb.append(",");
		sb.append(getLeftAmount() == null ? "" : getLeftAmount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetProjectInfoAndLeftAmount o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__left_amount);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.sheet_amount);
		hash = 97 * hash + Objects.hashCode(this.distributed_amount);
		hash = 97 * hash + Objects.hashCode(this.project_integral);
		hash = 97 * hash + Objects.hashCode(this.sure_integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetProjectInfoAndLeftAmount o = (BaseGetProjectInfoAndLeftAmount)obj;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__left_amount, o.getLeftAmount())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.sheet_amount, o.getSheetAmount())) return false;
		if(!Objects.equals(this.distributed_amount, o.getDistributedAmount())) return false;
		if(!Objects.equals(this.project_integral, o.getProjectIntegral())) return false;
		if(!Objects.equals(this.sure_integral, o.getSureIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getLeftAmount() != null) sb.append(__wrapDecimal(count++, "leftAmount", getLeftAmount()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getSheetAmount() != null) sb.append(__wrapDecimal(count++, "sheetAmount", getSheetAmount()));
		if(getDistributedAmount() != null) sb.append(__wrapDecimal(count++, "distributedAmount", getDistributedAmount()));
		if(getProjectIntegral() != null) sb.append(__wrapDecimal(count++, "projectIntegral", getProjectIntegral()));
		if(getSureIntegral() != null) sb.append(__wrapDecimal(count++, "sureIntegral", getSureIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("leftAmount")) != null) setLeftAmount(__getDecimal(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("sheetAmount")) != null) setSheetAmount(__getDecimal(val));
		if((val = values.get("distributedAmount")) != null) setDistributedAmount(__getDecimal(val));
		if((val = values.get("projectIntegral")) != null) setProjectIntegral(__getDecimal(val));
		if((val = values.get("sureIntegral")) != null) setSureIntegral(__getDecimal(val));
	}

	protected java.lang.Integer  __project_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.Integer  __contract_id ;
	protected java.math.BigDecimal  __left_amount ;
	protected java.lang.Integer  __plate_id ;
	protected java.math.BigDecimal sheet_amount;
	protected java.math.BigDecimal distributed_amount; 
	protected java.math.BigDecimal project_integral;
	protected java.math.BigDecimal sure_integral; 
}
