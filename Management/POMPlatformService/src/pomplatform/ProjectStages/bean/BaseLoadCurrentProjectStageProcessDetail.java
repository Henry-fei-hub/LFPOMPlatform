package pomplatform.ProjectStages.bean;

import java.util.*;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseLoadCurrentProjectStageProcessDetail extends GenericBase implements BaseFactory<BaseLoadCurrentProjectStageProcessDetail>, Comparable<BaseLoadCurrentProjectStageProcessDetail> 
{


	public static BaseLoadCurrentProjectStageProcessDetail newInstance(){
		return new BaseLoadCurrentProjectStageProcessDetail();
	}

	@Override
	public BaseLoadCurrentProjectStageProcessDetail make(){
		BaseLoadCurrentProjectStageProcessDetail b = new BaseLoadCurrentProjectStageProcessDetail();
		return b;
	}

	public final static String CS_PROJECT_STAGE_ID = "project_stage_id" ;
	public final static String CS_STAGE_ID = "stage_id" ;
	public final static String CS_PERCENT = "percent" ;
	public final static String CS_STAGE_NAME = "stage_name" ;
	public final static String CS_REMARK = "remark" ;
	public final static String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static String CS_CONTRACT_ID = "contract_id" ;
	public final static String CS_STATUS = "status" ;
	public final static String CS_PROJECT_AMOUNT = "project_amount" ;
	public final static String CS_PROJECT_AMOUNT_ED = "project_amount_ed" ;
	public final static String CS_IS_SURE = "is_sure" ;

	public final static String NAME_PROJECT_STAGE_ID = "projectStageId" ;
	public final static String NAME_STAGE_ID = "stageId" ;
	public final static String NAME_PERCENT = "percent" ;
	public final static String NAME_STAGE_NAME = "stageName" ;
	public final static String NAME_REMARK = "remark" ;
	public final static String NAME_MAIN_PROJECT_ID = "mainProjectId" ;
	public final static String NAME_CONTRACT_ID = "contractId" ;
	public final static String NAME_STATUS = "status" ;
	public final static String NAME_PROJECT_AMOUNT = "projectAmount" ;
	public final static String NAME_PROJECT_AMOUNT_ED = "projectAmountEd" ;
	public final static String NAME_IS_SURE = "isSure" ;

	public final static java.lang.String ALL_CAPTIONS = "项目阶段代码,阶段代码,占比(%),阶段名称,备注,main_project_id,contract_id,状态,项目积分,,";

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

	public java.lang.Integer getIsSure() {
		return this.__is_sure;
	}

	public void setIsSure( java.lang.Integer value ) {
		this.__is_sure = value;
	}

	public static String getKeyColumnName() {
		String name ="";
		name = CS_PROJECT_STAGE_ID;
		return name;
	}

	public void cloneCopy(BaseLoadCurrentProjectStageProcessDetail __bean){
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
		__bean.setIsSure(getIsSure());
		__bean.setPageLines(getPageLines());
		__bean.setCurrentPage(getCurrentPage());
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
		sb.append(",");
		sb.append(getIsSure() == null ? "" : getIsSure());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseLoadCurrentProjectStageProcessDetail o) {
		return __project_stage_id == null || o.getProjectStageId() == null ? -1 : __project_stage_id.compareTo(o.getProjectStageId());
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
		hash = 97 * hash + Objects.hashCode(this.__is_sure);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseLoadCurrentProjectStageProcessDetail o = (BaseLoadCurrentProjectStageProcessDetail)obj;
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
		if(!Objects.equals(this.__is_sure, o.getIsSure())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		return toJSONString(false);
	}

	@Override
	public java.lang.String toJSONString(boolean outDefault) {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectStageId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_PROJECT_STAGE_ID, getProjectStageId()));
		if(getStageId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_STAGE_ID, getStageId()));
		if(getPercent() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_PERCENT, getPercent()));
		if(getStageName() != null || outDefault) sb.append(__wrapString(count++, NAME_STAGE_NAME, getStageName()));
		if(getRemark() != null || outDefault) sb.append(__wrapString(count++, NAME_REMARK, getRemark()));
		if(getMainProjectId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_MAIN_PROJECT_ID, getMainProjectId()));
		if(getContractId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_CONTRACT_ID, getContractId()));
		if(getStatus() != null || outDefault) sb.append(__wrapNumber(count++, NAME_STATUS, getStatus()));
		if(getProjectAmount() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_PROJECT_AMOUNT, getProjectAmount()));
		if(getProjectAmountEd() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_PROJECT_AMOUNT_ED, getProjectAmountEd()));
		if(getIsSure() != null || outDefault) sb.append(__wrapNumber(count++, NAME_IS_SURE, getIsSure()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProjectStageId() != null) res.put(NAME_PROJECT_STAGE_ID, getProjectStageId());
		if(getStageId() != null) res.put(NAME_STAGE_ID, getStageId());
		if(getPercent() != null) res.put(NAME_PERCENT, getPercent());
		if(getStageName() != null) res.put(NAME_STAGE_NAME, getStageName());
		if(getRemark() != null) res.put(NAME_REMARK, getRemark());
		if(getMainProjectId() != null) res.put(NAME_MAIN_PROJECT_ID, getMainProjectId());
		if(getContractId() != null) res.put(NAME_CONTRACT_ID, getContractId());
		if(getStatus() != null) res.put(NAME_STATUS, getStatus());
		if(getProjectAmount() != null) res.put(NAME_PROJECT_AMOUNT, getProjectAmount());
		if(getProjectAmountEd() != null) res.put(NAME_PROJECT_AMOUNT_ED, getProjectAmountEd());
		if(getIsSure() != null) res.put(NAME_IS_SURE, getIsSure());
		if(getCurrentPage() > 0) {
			res.put(NAME_CURRENT_PAGE, getCurrentPage());
			res.put(NAME_PAGE_LINES, getPageLines());
		}
		return res;
	}

	public static List<Map<String, Object>> GenerateMapList(List<BaseLoadCurrentProjectStageProcessDetail> ol) {
		List<Map<String, Object>> res = new ArrayList<>();
		for(BaseLoadCurrentProjectStageProcessDetail b : ol) res.add(b.toMap());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if(values.containsKey(NAME_CURRENT_PAGE) && (val = values.get(NAME_CURRENT_PAGE)) != null) setCurrentPage(__getInt(val));
		if(values.containsKey(NAME_PAGE_LINES) && (val = values.get(NAME_PAGE_LINES)) != null) setPageLines(__getInt(val));
		if(values.containsKey(NAME_PROJECT_STAGE_ID) && (val = values.get(NAME_PROJECT_STAGE_ID)) != null) setProjectStageId(__getInt(val)); 
		if(values.containsKey(NAME_STAGE_ID) && (val = values.get(NAME_STAGE_ID)) != null) setStageId(__getInt(val)); 
		if(values.containsKey(NAME_PERCENT) && (val = values.get(NAME_PERCENT)) != null) setPercent(__getDecimal(val));  
		if(values.containsKey(NAME_STAGE_NAME) && (val = values.get(NAME_STAGE_NAME)) != null) setStageName(__getString(val));
		if(values.containsKey(NAME_REMARK) && (val = values.get(NAME_REMARK)) != null) setRemark(__getString(val));
		if(values.containsKey(NAME_MAIN_PROJECT_ID) && (val = values.get(NAME_MAIN_PROJECT_ID)) != null) setMainProjectId(__getInt(val)); 
		if(values.containsKey(NAME_CONTRACT_ID) && (val = values.get(NAME_CONTRACT_ID)) != null) setContractId(__getInt(val)); 
		if(values.containsKey(NAME_STATUS) && (val = values.get(NAME_STATUS)) != null) setStatus(__getInt(val)); 
		if(values.containsKey(NAME_PROJECT_AMOUNT) && (val = values.get(NAME_PROJECT_AMOUNT)) != null) setProjectAmount(__getDecimal(val));  
		if(values.containsKey(NAME_PROJECT_AMOUNT_ED) && (val = values.get(NAME_PROJECT_AMOUNT_ED)) != null) setProjectAmountEd(__getDecimal(val));  
		if(values.containsKey(NAME_IS_SURE) && (val = values.get(NAME_IS_SURE)) != null) setIsSure(__getInt(val)); 
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
	protected java.lang.Integer  __is_sure ;
}
