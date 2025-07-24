package pomplatform.ProjectStages.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSprojectstagecor extends GenericBase implements BaseFactory<BaseSprojectstagecor>, Comparable<BaseSprojectstagecor> 
{


	public static BaseSprojectstagecor newInstance(){
		return new BaseSprojectstagecor();
	}

	@Override
	public BaseSprojectstagecor make(){
		BaseSprojectstagecor b = new BaseSprojectstagecor();
		return b;
	}

	public final static java.lang.String CS_PROJECT_STAGE_ID = "project_stage_id" ;
	public final static java.lang.String CS_STAGE_ID = "stage_id" ;
	public final static java.lang.String CS_PERCENT = "percent" ;
	public final static java.lang.String CS_STAGE_NAME = "stage_name" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_PROJECT_AMOUNT = "project_amount" ;
	public final static java.lang.String CS_PROJECT_AMOUNT_ED = "project_amount_ed" ;

	public final static java.lang.String ALL_CAPTIONS = "项目阶段代码,阶段代码,占比(%),阶段名称,备注,main_project_id,合同id,状态,项目积分,";

	public java.lang.Integer getProjectStageId() {
		return this.__project_stage_id;
	}

	public void setProjectStageId( java.lang.Integer value ) {
		this.__project_stage_id = value;
	}

	public java.lang.Integer getStageId() {
		return this.__stage_id;
	}

	public void setStageId( java.lang.Integer value ) {
		this.__stage_id = value;
	}

	public java.math.BigDecimal getPercent() {
		return this.__percent;
	}

	public void setPercent( java.math.BigDecimal value ) {
		this.__percent = value;
	}

	public java.lang.String getStageName() {
		return this.__stage_name;
	}

	public void setStageName( java.lang.String value ) {
		this.__stage_name = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.math.BigDecimal getProjectAmount() {
		return this.__project_amount;
	}

	public void setProjectAmount( java.math.BigDecimal value ) {
		this.__project_amount = value;
	}

	public java.math.BigDecimal getProjectAmountEd() {
		return this.__project_amount_ed;
	}

	public void setProjectAmountEd( java.math.BigDecimal value ) {
		this.__project_amount_ed = value;
	}

	public void cloneCopy(BaseSprojectstagecor __bean){
		__bean.setProjectStageId(getProjectStageId());
		__bean.setStageId(getStageId());
		__bean.setPercent(getPercent());
		__bean.setStageName(getStageName());
		__bean.setRemark(getRemark());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setContractId(getContractId());
		__bean.setStatus(getStatus());
		__bean.setProjectAmount(getProjectAmount());
		__bean.setProjectAmountEd(getProjectAmountEd());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectStageId() == null ? "" : getProjectStageId());
		sb.append(",");
		sb.append(getStageId() == null ? "" : getStageId());
		sb.append(",");
		sb.append(getPercent() == null ? "" : getPercent());
		sb.append(",");
		sb.append(getStageName() == null ? "" : getStageName());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getProjectAmount() == null ? "" : getProjectAmount());
		sb.append(",");
		sb.append(getProjectAmountEd() == null ? "" : getProjectAmountEd());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSprojectstagecor o) {
		return __project_stage_id == null ? -1 : __project_stage_id.compareTo(o.getProjectStageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_stage_id);
		hash = 97 * hash + Objects.hashCode(this.__stage_id);
		hash = 97 * hash + Objects.hashCode(this.__percent);
		hash = 97 * hash + Objects.hashCode(this.__stage_name);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__project_amount);
		hash = 97 * hash + Objects.hashCode(this.__project_amount_ed);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSprojectstagecor o = (BaseSprojectstagecor)obj;
		if(!Objects.equals(this.__project_stage_id, o.getProjectStageId())) return false;
		if(!Objects.equals(this.__stage_id, o.getStageId())) return false;
		if(!Objects.equals(this.__percent, o.getPercent())) return false;
		if(!Objects.equals(this.__stage_name, o.getStageName())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__project_amount, o.getProjectAmount())) return false;
		if(!Objects.equals(this.__project_amount_ed, o.getProjectAmountEd())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectStageId() != null) sb.append(__wrapNumber(count++, "projectStageId", getProjectStageId()));
		if(getStageId() != null) sb.append(__wrapNumber(count++, "stageId", getStageId()));
		if(getPercent() != null) sb.append(__wrapDecimal(count++, "percent", getPercent()));
		if(getStageName() != null) sb.append(__wrapString(count++, "stageName", getStageName()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getProjectAmount() != null) sb.append(__wrapDecimal(count++, "projectAmount", getProjectAmount()));
		if(getProjectAmountEd() != null) sb.append(__wrapDecimal(count++, "projectAmountEd", getProjectAmountEd()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProjectStageId() != null) res.put("projectStageId", getProjectStageId());
		if(getStageId() != null) res.put("stageId", getStageId());
		if(getPercent() != null) res.put("percent", getPercent());
		if(getStageName() != null) res.put("stageName", getStageName());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getMainProjectId() != null) res.put("mainProjectId", getMainProjectId());
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getStatus() != null) res.put("status", getStatus());
		if(getProjectAmount() != null) res.put("projectAmount", getProjectAmount());
		if(getProjectAmountEd() != null) res.put("projectAmountEd", getProjectAmountEd());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectStageId")) != null) setProjectStageId(__getInt(val)); 
		if((val = values.get("stageId")) != null) setStageId(__getInt(val)); 
		if((val = values.get("percent")) != null) setPercent(__getDecimal(val));  
		if((val = values.get("stageName")) != null) setStageName(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("projectAmount")) != null) setProjectAmount(__getDecimal(val));  
		if((val = values.get("projectAmountEd")) != null) setProjectAmountEd(__getDecimal(val));  
	}

	protected java.lang.Integer  __project_stage_id ;
	protected java.lang.Integer  __stage_id ;
	protected java.math.BigDecimal  __percent ;
	protected java.lang.String  __stage_name ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __status ;
	protected java.math.BigDecimal  __project_amount ;
	protected java.math.BigDecimal  __project_amount_ed ;
}
