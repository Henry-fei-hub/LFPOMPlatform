package pomplatform.ProjectStages.bean;

import java.util.*;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseProjectStagesProcessApplication extends GenericBase implements BaseFactory<BaseProjectStagesProcessApplication>, Comparable<BaseProjectStagesProcessApplication> 
{


	public static BaseProjectStagesProcessApplication newInstance(){
		return new BaseProjectStagesProcessApplication();
	}

	@Override
	public BaseProjectStagesProcessApplication make(){
		BaseProjectStagesProcessApplication b = new BaseProjectStagesProcessApplication();
		return b;
	}

	public final static String CS_PROJECT_STAGE_PROCESS_RECORD_ID = "project_stage_process_record_id" ;
	public final static String CS_CONTRACT_ID = "contract_id" ;
	public final static String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static String CS_PROJECT_NAME = "project_name" ;
	public final static String CS_PROJECT_CODE = "project_code" ;
	public final static String CS_PROJECT_AMOUNT_SUM = "project_amount_sum" ;
	public final static String CS_APPLY_AMOUNT = "apply_amount" ;
	public final static String CS_FILE_ID = "file_id" ;
	public final static String CS_FILE_URL = "file_url" ;
	public final static String CS_REMARK = "remark" ;
	public final static String CS_EMPLOYEE_ID = "employee_id" ;
	public final static String CS_EMPLOYEE_NO = "employee_no" ;
	public final static String CS_CREATE_TIME = "create_time" ;
	public final static String CS_CURRENT_APPLY_RATE = "current_apply_rate" ;
	public final static String CS_APPLY_RATE = "apply_rate" ;
	public final static String CS_REMAINING_RATE = "remaining_rate" ;
	public final static String CS_REMAINING_AMOUNT = "remaining_amount" ;

	public final static String NAME_PROJECT_STAGE_PROCESS_RECORD_ID = "projectStageProcessRecordId" ;
	public final static String NAME_CONTRACT_ID = "contractId" ;
	public final static String NAME_MAIN_PROJECT_ID = "mainProjectId" ;
	public final static String NAME_PROJECT_NAME = "projectName" ;
	public final static String NAME_PROJECT_CODE = "projectCode" ;
	public final static String NAME_PROJECT_AMOUNT_SUM = "projectAmountSum" ;
	public final static String NAME_APPLY_AMOUNT = "applyAmount" ;
	public final static String NAME_FILE_ID = "fileId" ;
	public final static String NAME_FILE_URL = "fileUrl" ;
	public final static String NAME_REMARK = "remark" ;
	public final static String NAME_EMPLOYEE_ID = "employeeId" ;
	public final static String NAME_EMPLOYEE_NO = "employeeNo" ;
	public final static String NAME_CREATE_TIME = "createTime" ;
	public final static String NAME_CURRENT_APPLY_RATE = "currentApplyRate" ;
	public final static String NAME_APPLY_RATE = "applyRate" ;
	public final static String NAME_REMAINING_RATE = "remainingRate" ;
	public final static String NAME_REMAINING_AMOUNT = "remainingAmount" ;

	public final static java.lang.String ALL_CAPTIONS = "id,contract_id,main_project_id,项目名称,项目编号,订单积分,本次申请的积分,file_id,file_url,备注,申请人编码,申请人工号,申请时间,本次申请比例,,,";

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

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.math.BigDecimal getProjectAmountSum() {
		return this.__project_amount_sum;
	}

	public void setProjectAmountSum( java.math.BigDecimal value ) {
		this.__project_amount_sum = value;
	}

	public java.math.BigDecimal getApplyAmount() {
		return this.__apply_amount;
	}

	public void setApplyAmount( java.math.BigDecimal value ) {
		this.__apply_amount = value;
	}

	public java.lang.Integer getFileId() {
		return this.__file_id;
	}

	public void setFileId( java.lang.Integer value ) {
		this.__file_id = value;
	}

	public java.lang.String getFileUrl() {
		return this.__file_url;
	}

	public void setFileUrl( java.lang.String value ) {
		this.__file_url = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.math.BigDecimal getCurrentApplyRate() {
		return this.__current_apply_rate;
	}

	public void setCurrentApplyRate( java.math.BigDecimal value ) {
		this.__current_apply_rate = value;
	}

	public java.math.BigDecimal getApplyRate() {
		return this.__apply_rate;
	}

	public void setApplyRate( java.math.BigDecimal value ) {
		this.__apply_rate = value;
	}

	public java.math.BigDecimal getRemainingRate() {
		return this.__remaining_rate;
	}

	public void setRemainingRate( java.math.BigDecimal value ) {
		this.__remaining_rate = value;
	}

	public java.math.BigDecimal getRemainingAmount() {
		return this.__remaining_amount;
	}

	public void setRemainingAmount( java.math.BigDecimal value ) {
		this.__remaining_amount = value;
	}

	public static String getKeyColumnName() {
		String name ="";
		name = CS_PROJECT_STAGE_PROCESS_RECORD_ID;
		return name;
	}

	public void cloneCopy(BaseProjectStagesProcessApplication __bean){
		__bean.setProjectStageProcessRecordId(getProjectStageProcessRecordId());
		__bean.setContractId(getContractId());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setProjectName(getProjectName());
		__bean.setProjectCode(getProjectCode());
		__bean.setProjectAmountSum(getProjectAmountSum());
		__bean.setApplyAmount(getApplyAmount());
		__bean.setFileId(getFileId());
		__bean.setFileUrl(getFileUrl());
		__bean.setRemark(getRemark());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setCreateTime(getCreateTime());
		__bean.setCurrentApplyRate(getCurrentApplyRate());
		__bean.setApplyRate(getApplyRate());
		__bean.setRemainingRate(getRemainingRate());
		__bean.setRemainingAmount(getRemainingAmount());
		__bean.setPageLines(getPageLines());
		__bean.setCurrentPage(getCurrentPage());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectStageProcessRecordId() == null ? "" : getProjectStageProcessRecordId());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getProjectAmountSum() == null ? "" : getProjectAmountSum());
		sb.append(",");
		sb.append(getApplyAmount() == null ? "" : getApplyAmount());
		sb.append(",");
		sb.append(getFileId() == null ? "" : getFileId());
		sb.append(",");
		sb.append(getFileUrl() == null ? "" : getFileUrl());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getCurrentApplyRate() == null ? "" : getCurrentApplyRate());
		sb.append(",");
		sb.append(getApplyRate() == null ? "" : getApplyRate());
		sb.append(",");
		sb.append(getRemainingRate() == null ? "" : getRemainingRate());
		sb.append(",");
		sb.append(getRemainingAmount() == null ? "" : getRemainingAmount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectStagesProcessApplication o) {
		return __project_stage_process_record_id == null || o.getProjectStageProcessRecordId() == null ? -1 : __project_stage_process_record_id.compareTo(o.getProjectStageProcessRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_stage_process_record_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__project_amount_sum);
		hash = 97 * hash + Objects.hashCode(this.__apply_amount);
		hash = 97 * hash + Objects.hashCode(this.__file_id);
		hash = 97 * hash + Objects.hashCode(this.__file_url);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__current_apply_rate);
		hash = 97 * hash + Objects.hashCode(this.__apply_rate);
		hash = 97 * hash + Objects.hashCode(this.__remaining_rate);
		hash = 97 * hash + Objects.hashCode(this.__remaining_amount);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectStagesProcessApplication o = (BaseProjectStagesProcessApplication)obj;
		if(!Objects.equals(this.__project_stage_process_record_id, o.getProjectStageProcessRecordId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__project_amount_sum, o.getProjectAmountSum())) return false;
		if(!Objects.equals(this.__apply_amount, o.getApplyAmount())) return false;
		if(!Objects.equals(this.__file_id, o.getFileId())) return false;
		if(!Objects.equals(this.__file_url, o.getFileUrl())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__current_apply_rate, o.getCurrentApplyRate())) return false;
		if(!Objects.equals(this.__apply_rate, o.getApplyRate())) return false;
		if(!Objects.equals(this.__remaining_rate, o.getRemainingRate())) return false;
		if(!Objects.equals(this.__remaining_amount, o.getRemainingAmount())) return false;
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
		if(getProjectStageProcessRecordId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_PROJECT_STAGE_PROCESS_RECORD_ID, getProjectStageProcessRecordId()));
		if(getContractId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_CONTRACT_ID, getContractId()));
		if(getMainProjectId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_MAIN_PROJECT_ID, getMainProjectId()));
		if(getProjectName() != null || outDefault) sb.append(__wrapString(count++, NAME_PROJECT_NAME, getProjectName()));
		if(getProjectCode() != null || outDefault) sb.append(__wrapString(count++, NAME_PROJECT_CODE, getProjectCode()));
		if(getProjectAmountSum() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_PROJECT_AMOUNT_SUM, getProjectAmountSum()));
		if(getApplyAmount() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_APPLY_AMOUNT, getApplyAmount()));
		if(getFileId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_FILE_ID, getFileId()));
		if(getFileUrl() != null || outDefault) sb.append(__wrapString(count++, NAME_FILE_URL, getFileUrl()));
		if(getRemark() != null || outDefault) sb.append(__wrapString(count++, NAME_REMARK, getRemark()));
		if(getEmployeeId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_EMPLOYEE_ID, getEmployeeId()));
		if(getEmployeeNo() != null || outDefault) sb.append(__wrapString(count++, NAME_EMPLOYEE_NO, getEmployeeNo()));
		if(getCreateTime() != null || outDefault) sb.append(__wrapDate(count++, NAME_CREATE_TIME, getCreateTime()));
		if(getCurrentApplyRate() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_CURRENT_APPLY_RATE, getCurrentApplyRate()));
		if(getApplyRate() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_APPLY_RATE, getApplyRate()));
		if(getRemainingRate() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_REMAINING_RATE, getRemainingRate()));
		if(getRemainingAmount() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_REMAINING_AMOUNT, getRemainingAmount()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProjectStageProcessRecordId() != null) res.put(NAME_PROJECT_STAGE_PROCESS_RECORD_ID, getProjectStageProcessRecordId());
		if(getContractId() != null) res.put(NAME_CONTRACT_ID, getContractId());
		if(getMainProjectId() != null) res.put(NAME_MAIN_PROJECT_ID, getMainProjectId());
		if(getProjectName() != null) res.put(NAME_PROJECT_NAME, getProjectName());
		if(getProjectCode() != null) res.put(NAME_PROJECT_CODE, getProjectCode());
		if(getProjectAmountSum() != null) res.put(NAME_PROJECT_AMOUNT_SUM, getProjectAmountSum());
		if(getApplyAmount() != null) res.put(NAME_APPLY_AMOUNT, getApplyAmount());
		if(getFileId() != null) res.put(NAME_FILE_ID, getFileId());
		if(getFileUrl() != null) res.put(NAME_FILE_URL, getFileUrl());
		if(getRemark() != null) res.put(NAME_REMARK, getRemark());
		if(getEmployeeId() != null) res.put(NAME_EMPLOYEE_ID, getEmployeeId());
		if(getEmployeeNo() != null) res.put(NAME_EMPLOYEE_NO, getEmployeeNo());
		if(getCreateTime() != null) res.put(NAME_CREATE_TIME, getCreateTime());
		if(getCurrentApplyRate() != null) res.put(NAME_CURRENT_APPLY_RATE, getCurrentApplyRate());
		if(getApplyRate() != null) res.put(NAME_APPLY_RATE, getApplyRate());
		if(getRemainingRate() != null) res.put(NAME_REMAINING_RATE, getRemainingRate());
		if(getRemainingAmount() != null) res.put(NAME_REMAINING_AMOUNT, getRemainingAmount());
		if(getCurrentPage() > 0) {
			res.put(NAME_CURRENT_PAGE, getCurrentPage());
			res.put(NAME_PAGE_LINES, getPageLines());
		}
		return res;
	}

	public static List<Map<String, Object>> GenerateMapList(List<BaseProjectStagesProcessApplication> ol) {
		List<Map<String, Object>> res = new ArrayList<>();
		for(BaseProjectStagesProcessApplication b : ol) res.add(b.toMap());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if(values.containsKey(NAME_CURRENT_PAGE) && (val = values.get(NAME_CURRENT_PAGE)) != null) setCurrentPage(__getInt(val));
		if(values.containsKey(NAME_PAGE_LINES) && (val = values.get(NAME_PAGE_LINES)) != null) setPageLines(__getInt(val));
		if(values.containsKey(NAME_PROJECT_STAGE_PROCESS_RECORD_ID) && (val = values.get(NAME_PROJECT_STAGE_PROCESS_RECORD_ID)) != null) setProjectStageProcessRecordId(__getInt(val)); 
		if(values.containsKey(NAME_CONTRACT_ID) && (val = values.get(NAME_CONTRACT_ID)) != null) setContractId(__getInt(val)); 
		if(values.containsKey(NAME_MAIN_PROJECT_ID) && (val = values.get(NAME_MAIN_PROJECT_ID)) != null) setMainProjectId(__getInt(val)); 
		if(values.containsKey(NAME_PROJECT_NAME) && (val = values.get(NAME_PROJECT_NAME)) != null) setProjectName(__getString(val));
		if(values.containsKey(NAME_PROJECT_CODE) && (val = values.get(NAME_PROJECT_CODE)) != null) setProjectCode(__getString(val));
		if(values.containsKey(NAME_PROJECT_AMOUNT_SUM) && (val = values.get(NAME_PROJECT_AMOUNT_SUM)) != null) setProjectAmountSum(__getDecimal(val));  
		if(values.containsKey(NAME_APPLY_AMOUNT) && (val = values.get(NAME_APPLY_AMOUNT)) != null) setApplyAmount(__getDecimal(val));  
		if(values.containsKey(NAME_FILE_ID) && (val = values.get(NAME_FILE_ID)) != null) setFileId(__getInt(val)); 
		if(values.containsKey(NAME_FILE_URL) && (val = values.get(NAME_FILE_URL)) != null) setFileUrl(__getString(val));
		if(values.containsKey(NAME_REMARK) && (val = values.get(NAME_REMARK)) != null) setRemark(__getString(val));
		if(values.containsKey(NAME_EMPLOYEE_ID) && (val = values.get(NAME_EMPLOYEE_ID)) != null) setEmployeeId(__getInt(val)); 
		if(values.containsKey(NAME_EMPLOYEE_NO) && (val = values.get(NAME_EMPLOYEE_NO)) != null) setEmployeeNo(__getString(val));
		if(values.containsKey(NAME_CREATE_TIME) && (val = values.get(NAME_CREATE_TIME)) != null) setCreateTime(__getDate(val)); 
		if(values.containsKey(NAME_CURRENT_APPLY_RATE) && (val = values.get(NAME_CURRENT_APPLY_RATE)) != null) setCurrentApplyRate(__getDecimal(val));  
		if(values.containsKey(NAME_APPLY_RATE) && (val = values.get(NAME_APPLY_RATE)) != null) setApplyRate(__getDecimal(val));  
		if(values.containsKey(NAME_REMAINING_RATE) && (val = values.get(NAME_REMAINING_RATE)) != null) setRemainingRate(__getDecimal(val));  
		if(values.containsKey(NAME_REMAINING_AMOUNT) && (val = values.get(NAME_REMAINING_AMOUNT)) != null) setRemainingAmount(__getDecimal(val));  
	}

	protected java.lang.Integer  __project_stage_process_record_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.String  __project_name ;
	protected java.lang.String  __project_code ;
	protected java.math.BigDecimal  __project_amount_sum ;
	protected java.math.BigDecimal  __apply_amount ;
	protected java.lang.Integer  __file_id ;
	protected java.lang.String  __file_url ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.util.Date  __create_time ;
	protected java.math.BigDecimal  __current_apply_rate ;
	protected java.math.BigDecimal  __apply_rate ;
	protected java.math.BigDecimal  __remaining_rate ;
	protected java.math.BigDecimal  __remaining_amount ;
}
