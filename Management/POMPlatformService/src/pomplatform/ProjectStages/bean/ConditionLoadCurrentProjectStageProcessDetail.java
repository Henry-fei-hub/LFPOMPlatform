package pomplatform.ProjectStages.bean;

import delicacy.common.GenericCondition;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class ConditionLoadCurrentProjectStageProcessDetail extends GenericCondition{

	public final static String NAME_PROJECT_STAGE_PROCESS_RECORD_ID = "projectStageProcessRecordId" ;
	public final static String NAME_CONTRACT_ID = "contractId" ;

	public ConditionLoadCurrentProjectStageProcessDetail(){
		setParameterCount(2);
	}

	public java.lang.Integer getProjectStageProcessRecordId() {
		return this.__project_stage_process_record_id;
	}

	public void setProjectStageProcessRecordId( java.lang.Integer value ) {
		this.__project_stage_process_record_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProjectStageProcessRecordId() != null) res.put(NAME_PROJECT_STAGE_PROCESS_RECORD_ID, getProjectStageProcessRecordId());
		if(getContractId() != null) res.put(NAME_CONTRACT_ID, getContractId());
		if(getCurrentPage() > 0) {
			res.put(NAME_CURRENT_PAGE, getCurrentPage());
			res.put(NAME_PAGE_LINES, getPageLines());
		}
		return res;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectStageProcessRecordId() != null) sb.append(__wrapNumber(1, NAME_PROJECT_STAGE_PROCESS_RECORD_ID, getProjectStageProcessRecordId()));
		if(getContractId() != null) sb.append(__wrapNumber(1, NAME_CONTRACT_ID, getContractId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if(values.containsKey(NAME_CURRENT_PAGE) && (val = values.get(NAME_CURRENT_PAGE)) != null) setCurrentPage(__getInt(val));
		if(values.containsKey(NAME_PAGE_LINES) && (val = values.get(NAME_PAGE_LINES)) != null) setPageLines(__getInt(val));
		if(values.containsKey(NAME_PROJECT_STAGE_PROCESS_RECORD_ID) && (val = values.get(NAME_PROJECT_STAGE_PROCESS_RECORD_ID)) != null) setProjectStageProcessRecordId(__getInt(val)); 
		if(values.containsKey(NAME_CONTRACT_ID) && (val = values.get(NAME_CONTRACT_ID)) != null) setContractId(__getInt(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getProjectStageProcessRecordId() != null) res.add(NAME_PROJECT_STAGE_PROCESS_RECORD_ID);
		if(getContractId() != null) res.add(NAME_CONTRACT_ID);
		return res;
	}

	private java.lang.Integer __project_stage_process_record_id = null;
	private java.lang.Integer __contract_id = null;
}

