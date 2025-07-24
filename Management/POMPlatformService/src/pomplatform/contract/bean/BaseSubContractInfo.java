package pomplatform.contract.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSubContractInfo extends GenericBase implements BaseFactory<BaseSubContractInfo>, Comparable<BaseSubContractInfo> 
{
	public final static java.lang.String CS_HT_PERCENTAGE = "ht_percentage" ;
	public final static java.lang.String CS_DD_PERCENTAGE = "dd_percentage" ;
	public final static java.lang.String CS_PERCENTAGE = "__percentage" ;
	
	protected java.math.BigDecimal  __ht_percentage ;
	protected java.math.BigDecimal  __dd_percentage ;
	protected java.math.BigDecimal  __percentage ;
	
	public java.math.BigDecimal getHtPercentage() {
		return __ht_percentage;
	}
	public void setHtPercentage(java.math.BigDecimal __ht_percentage) {
		this.__ht_percentage = __ht_percentage;
	}
	public java.math.BigDecimal getDdPercentage() {
		return __dd_percentage;
	}
	public void setDdPercentage(java.math.BigDecimal __dd_percentage) {
		this.__dd_percentage = __dd_percentage;
	}
	
	public java.math.BigDecimal getPercentage() {
		return __percentage;
	}
	public void setPercentage(java.math.BigDecimal __percentage) {
		this.__percentage = __percentage;
	}

	public static BaseSubContractInfo newInstance(){
		return new BaseSubContractInfo();
	}

	@Override
	public BaseSubContractInfo make(){
		BaseSubContractInfo b = new BaseSubContractInfo();
		return b;
	}

	public final static java.lang.String CS_SUB_CONTRACT_ID = "sub_contract_id" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_SUB_CONTRACT_CODE = "sub_contract_code" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_PROJECT_TYPE = "project_type" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_COMMON_AREA = "common_area" ;
	public final static java.lang.String CS_LOGISTICS_AREA = "logistics_area" ;
	public final static java.lang.String CS_MONEY_SUM = "money_sum" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_SUB_CONTRACT_NAME = "sub_contract_name" ;
	public final static java.lang.String CS_UPDATE_TIME = "update_time" ;
	public final static java.lang.String CS_DESIGN_AREA = "design_area" ;
	public final static java.lang.String CS_ORDER_NO = "order_no" ;
	public final static java.lang.String CS_SHEET_TOTAL_INTEGRAL = "sheet_total_integral" ;
	public final static java.lang.String CS_COMPLAINT_INTEGRAL = "complaint_integral" ;
	public final static java.lang.String CS_SHEET_INTEGRAL = "sheet_integral" ;
	public final static java.lang.String CS_COMPLAINT_PERCENTAGE = "complaint_percentage" ;
	public final static java.lang.String CS_AGREE_DATE = "agree_date" ;
	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_BUSINESS_STATE_RECORD_ID = "business_state_record_id" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_PROJECT_MANAGE_ID = "project_manage_id" ;
	public final static java.lang.String CS_IS_HISTORY = "is_history" ;
	public final static java.lang.String CS_BUSINESS_LINE = "business_line" ;
	public final static java.lang.String ALL_CAPTIONS = "子合同编码,主合同编码,子合同编号,项目编号,业务类型,项目类型,承接部门,公区面积,后勤面积,小计 子订单总金额,创建时间,子合同名称  充当了区域,修改时间,设计面积,标记补充协议字段；除0之外，其他都表示第n个补充协议,项目总积分,投诉保证金,订单积分,投诉保证金比例,价格审核同意的时间,信息编号,业态编码,备注,项目经理,业务条线";

	public java.lang.Integer getSubContractId() {
		return this.__sub_contract_id;
	}

	public void setSubContractId( java.lang.Integer value ) {
		this.__sub_contract_id = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.String getSubContractCode() {
		return this.__sub_contract_code;
	}

	public void setSubContractCode( java.lang.String value ) {
		this.__sub_contract_code = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.Integer getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.Integer value ) {
		this.__business_type = value;
	}

	public java.lang.Integer getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.Integer value ) {
		this.__project_type = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.math.BigDecimal getCommonArea() {
		return this.__common_area;
	}

	public void setCommonArea( java.math.BigDecimal value ) {
		this.__common_area = value;
	}

	public java.math.BigDecimal getLogisticsArea() {
		return this.__logistics_area;
	}

	public void setLogisticsArea( java.math.BigDecimal value ) {
		this.__logistics_area = value;
	}

	public java.math.BigDecimal getMoneySum() {
		return this.__money_sum;
	}

	public void setMoneySum( java.math.BigDecimal value ) {
		this.__money_sum = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.String getSubContractName() {
		return this.__sub_contract_name;
	}

	public void setSubContractName( java.lang.String value ) {
		this.__sub_contract_name = value;
	}

	public java.util.Date getUpdateTime() {
		return this.__update_time;
	}

	public void setUpdateTime( java.util.Date value ) {
		this.__update_time = value;
	}

	public java.math.BigDecimal getDesignArea() {
		return this.__design_area;
	}

	public void setDesignArea( java.math.BigDecimal value ) {
		this.__design_area = value;
	}

	public java.lang.Integer getOrderNo() {
		return this.__order_no;
	}

	public void setOrderNo( java.lang.Integer value ) {
		this.__order_no = value;
	}

	public java.math.BigDecimal getSheetTotalIntegral() {
		return this.__sheet_total_integral;
	}

	public void setSheetTotalIntegral( java.math.BigDecimal value ) {
		this.__sheet_total_integral = value;
	}

	public java.math.BigDecimal getComplaintIntegral() {
		return this.__complaint_integral;
	}

	public void setComplaintIntegral( java.math.BigDecimal value ) {
		this.__complaint_integral = value;
	}

	public java.math.BigDecimal getSheetIntegral() {
		return this.__sheet_integral;
	}

	public void setSheetIntegral( java.math.BigDecimal value ) {
		this.__sheet_integral = value;
	}

	public java.math.BigDecimal getComplaintPercentage() {
		return this.__complaint_percentage;
	}

	public void setComplaintPercentage( java.math.BigDecimal value ) {
		this.__complaint_percentage = value;
	}

	public java.util.Date getAgreeDate() {
		return this.__agree_date;
	}

	public void setAgreeDate( java.util.Date value ) {
		this.__agree_date = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.Integer getBusinessStateRecordId() {
		return this.__business_state_record_id;
	}

	public void setBusinessStateRecordId( java.lang.Integer value ) {
		this.__business_state_record_id = value;
	}
	
	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}
	public java.lang.Integer getProjectManageId() {
		return this.__project_manage_id;
	}

	public void setProjectManageId( java.lang.Integer value ) {
		this.__project_manage_id = value;
	}
	
	public java.lang.Boolean getIsHistory() {
		return this.__is_history;
	}

	public void setIsHistory( java.lang.Boolean value ) {
		this.__is_history = value;
	}
	public java.lang.Integer getBusinessLine() {
		return this.__business_line;
	}

	public void setBusinessLine( java.lang.Integer value ) {
		this.__business_line = value;
	}
	
	public void cloneCopy(BaseSubContractInfo __bean){
		__bean.setSubContractId(getSubContractId());
		__bean.setParentId(getParentId());
		__bean.setSubContractCode(getSubContractCode());
		__bean.setProjectCode(getProjectCode());
		__bean.setBusinessType(getBusinessType());
		__bean.setProjectType(getProjectType());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setCommonArea(getCommonArea());
		__bean.setLogisticsArea(getLogisticsArea());
		__bean.setMoneySum(getMoneySum());
		__bean.setCreateTime(getCreateTime());
		__bean.setSubContractName(getSubContractName());
		__bean.setUpdateTime(getUpdateTime());
		__bean.setDesignArea(getDesignArea());
		__bean.setOrderNo(getOrderNo());
		__bean.setSheetTotalIntegral(getSheetTotalIntegral());
		__bean.setComplaintIntegral(getComplaintIntegral());
		__bean.setSheetIntegral(getSheetIntegral());
		__bean.setComplaintPercentage(getComplaintPercentage());
		__bean.setAgreeDate(getAgreeDate());
		__bean.setInfoCode(getInfoCode());
		__bean.setBusinessStateRecordId(getBusinessStateRecordId());
		__bean.setHtPercentage(getHtPercentage());
		__bean.setDdPercentage(getDdPercentage());
		__bean.setRemark(getRemark());
		__bean.setProjectManageId(getProjectManageId());
		__bean.setIsHistory(getIsHistory());
		__bean.setBusinessLine(getBusinessLine());
		__bean.setPercentage(getPercentage());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSubContractId() == null ? "" : getSubContractId());
		sb.append(",");
		sb.append(getParentId() == null ? "" : getParentId());
		sb.append(",");
		sb.append(getSubContractCode() == null ? "" : getSubContractCode());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getBusinessType() == null ? "" : getBusinessType());
		sb.append(",");
		String strProjectType = delicacy.system.executor.SelectValueCache.getSelectValue("project_types", String.valueOf(getProjectType()));
		sb.append(strProjectType == null ? "" : strProjectType);
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getCommonArea() == null ? "" : getCommonArea());
		sb.append(",");
		sb.append(getLogisticsArea() == null ? "" : getLogisticsArea());
		sb.append(",");
		sb.append(getMoneySum() == null ? "" : getMoneySum());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getSubContractName() == null ? "" : getSubContractName());
		sb.append(",");
		sb.append(getUpdateTime() == null ? "" : sdf.format(getUpdateTime()));
		sb.append(",");
		sb.append(getDesignArea() == null ? "" : getDesignArea());
		sb.append(",");
		sb.append(getOrderNo() == null ? "" : getOrderNo());
		sb.append(",");
		sb.append(getSheetTotalIntegral() == null ? "" : getSheetTotalIntegral());
		sb.append(",");
		sb.append(getComplaintIntegral() == null ? "" : getComplaintIntegral());
		sb.append(",");
		sb.append(getSheetIntegral() == null ? "" : getSheetIntegral());
		sb.append(",");
		sb.append(getComplaintPercentage() == null ? "" : getComplaintPercentage());
		sb.append(",");
		sb.append(getAgreeDate() == null ? "" : sdf.format(getAgreeDate()));
		sb.append(",");
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getBusinessStateRecordId() == null ? "" : getBusinessStateRecordId());
		sb.append(",");
		sb.append(getHtPercentage() == null ? "" : getHtPercentage());
		sb.append(",");
		sb.append(getDdPercentage() == null ? "" : getDdPercentage());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getProjectManageId() == null ? "" : getProjectManageId());
		sb.append(",");
		sb.append(getBusinessLine() == null ? "" : getBusinessLine());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSubContractInfo o) {
		return __sub_contract_id == null ? -1 : __sub_contract_id.compareTo(o.getSubContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__sub_contract_id);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__sub_contract_code);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__project_type);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__common_area);
		hash = 97 * hash + Objects.hashCode(this.__logistics_area);
		hash = 97 * hash + Objects.hashCode(this.__money_sum);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__sub_contract_name);
		hash = 97 * hash + Objects.hashCode(this.__update_time);
		hash = 97 * hash + Objects.hashCode(this.__design_area);
		hash = 97 * hash + Objects.hashCode(this.__order_no);
		hash = 97 * hash + Objects.hashCode(this.__sheet_total_integral);
		hash = 97 * hash + Objects.hashCode(this.__complaint_integral);
		hash = 97 * hash + Objects.hashCode(this.__sheet_integral);
		hash = 97 * hash + Objects.hashCode(this.__complaint_percentage);
		hash = 97 * hash + Objects.hashCode(this.__agree_date);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__business_state_record_id);
		hash = 97 * hash + Objects.hashCode(this.__ht_percentage);
		hash = 97 * hash + Objects.hashCode(this.__dd_percentage);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__project_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__is_history);
		hash = 97 * hash + Objects.hashCode(this.__business_line);
		hash = 97 * hash + Objects.hashCode(this.__percentage);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSubContractInfo o = (BaseSubContractInfo)obj;
		if(!Objects.equals(this.__sub_contract_id, o.getSubContractId())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__sub_contract_code, o.getSubContractCode())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__project_type, o.getProjectType())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__common_area, o.getCommonArea())) return false;
		if(!Objects.equals(this.__logistics_area, o.getLogisticsArea())) return false;
		if(!Objects.equals(this.__money_sum, o.getMoneySum())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__sub_contract_name, o.getSubContractName())) return false;
		if(!Objects.equals(this.__update_time, o.getUpdateTime())) return false;
		if(!Objects.equals(this.__design_area, o.getDesignArea())) return false;
		if(!Objects.equals(this.__order_no, o.getOrderNo())) return false;
		if(!Objects.equals(this.__sheet_total_integral, o.getSheetTotalIntegral())) return false;
		if(!Objects.equals(this.__complaint_integral, o.getComplaintIntegral())) return false;
		if(!Objects.equals(this.__sheet_integral, o.getSheetIntegral())) return false;
		if(!Objects.equals(this.__complaint_percentage, o.getComplaintPercentage())) return false;
		if(!Objects.equals(this.__agree_date, o.getAgreeDate())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__business_state_record_id, o.getBusinessStateRecordId())) return false;
		if(!Objects.equals(this.__ht_percentage, o.getHtPercentage())) return false;
		if(!Objects.equals(this.__dd_percentage, o.getDdPercentage())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__project_manage_id, o.getProjectManageId())) return false;
		if(!Objects.equals(this.__is_history, o.getIsHistory())) return false;
		if(!Objects.equals(this.__business_line, o.getBusinessLine())) return false;
		if(!Objects.equals(this.__percentage, o.getPercentage())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSubContractId() != null) sb.append(__wrapNumber(count++, "subContractId", getSubContractId()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getSubContractCode() != null) sb.append(__wrapString(count++, "subContractCode", getSubContractCode()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getBusinessType() != null) sb.append(__wrapNumber(count++, "businessType", getBusinessType()));
		if(getProjectType() != null) sb.append(__wrapNumber(count++, "projectType", getProjectType()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getCommonArea() != null) sb.append(__wrapDecimal(count++, "commonArea", getCommonArea()));
		if(getLogisticsArea() != null) sb.append(__wrapDecimal(count++, "logisticsArea", getLogisticsArea()));
		if(getMoneySum() != null) sb.append(__wrapDecimal(count++, "moneySum", getMoneySum()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getSubContractName() != null) sb.append(__wrapString(count++, "subContractName", getSubContractName()));
		if(getUpdateTime() != null) sb.append(__wrapDate(count++, "updateTime", getUpdateTime()));
		if(getDesignArea() != null) sb.append(__wrapDecimal(count++, "designArea", getDesignArea()));
		if(getOrderNo() != null) sb.append(__wrapNumber(count++, "orderNo", getOrderNo()));
		if(getSheetTotalIntegral() != null) sb.append(__wrapDecimal(count++, "sheetTotalIntegral", getSheetTotalIntegral()));
		if(getComplaintIntegral() != null) sb.append(__wrapDecimal(count++, "complaintIntegral", getComplaintIntegral()));
		if(getSheetIntegral() != null) sb.append(__wrapDecimal(count++, "sheetIntegral", getSheetIntegral()));
		if(getComplaintPercentage() != null) sb.append(__wrapDecimal(count++, "complaintPercentage", getComplaintPercentage()));
		if(getAgreeDate() != null) sb.append(__wrapDate(count++, "agreeDate", getAgreeDate()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getBusinessStateRecordId() != null) sb.append(__wrapNumber(count++, "businessStateRecordId", getBusinessStateRecordId()));
		
		if(getHtPercentage() != null) sb.append(__wrapDecimal(count++, "ht_percentage", getHtPercentage()));
		if(getDdPercentage() != null) sb.append(__wrapDecimal(count++, "dd_percentage", getDdPercentage()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getProjectManageId() != null) sb.append(__wrapNumber(count++, "projectManageId", getProjectManageId()));
		if(getIsHistory() != null) sb.append(__wrapBoolean(count++, "isHistory", getIsHistory()));
		if(getBusinessLine() != null) sb.append(__wrapNumber(count++, "businessLine", getBusinessLine()));
		if(getPercentage() != null) sb.append(__wrapDecimal(count++, "percentage", getPercentage()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("subContractId")) != null) setSubContractId(__getInt(val)); 
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("subContractCode")) != null) setSubContractCode(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("commonArea")) != null) setCommonArea(__getDecimal(val));  
		if((val = values.get("logisticsArea")) != null) setLogisticsArea(__getDecimal(val));  
		if((val = values.get("moneySum")) != null) setMoneySum(__getDecimal(val));  
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("subContractName")) != null) setSubContractName(__getString(val));
		if((val = values.get("updateTime")) != null) setUpdateTime(__getDate(val)); 
		if((val = values.get("designArea")) != null) setDesignArea(__getDecimal(val));  
		if((val = values.get("orderNo")) != null) setOrderNo(__getInt(val)); 
		if((val = values.get("sheetTotalIntegral")) != null) setSheetTotalIntegral(__getDecimal(val));  
		if((val = values.get("complaintIntegral")) != null) setComplaintIntegral(__getDecimal(val));  
		if((val = values.get("sheetIntegral")) != null) setSheetIntegral(__getDecimal(val));  
		if((val = values.get("complaintPercentage")) != null) setComplaintPercentage(__getDecimal(val));  
		if((val = values.get("agreeDate")) != null) setAgreeDate(__getDate(val)); 
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("businessStateRecordId")) != null) setBusinessStateRecordId(__getInt(val)); 
		
		if((val = values.get("htPercentage")) != null) setHtPercentage(__getDecimal(val));  
		if((val = values.get("ddPercentage")) != null) setDdPercentage(__getDecimal(val));  
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("projectManageId")) != null) setProjectManageId(__getInt(val)); 
		if((val = values.get("isHistory")) != null) setIsHistory(__getBoolean(val));
		if((val = values.get("businessLine")) != null) setBusinessLine(__getInt(val));
		if((val = values.get("percentage")) != null) setPercentage(__getDecimal(val));  
	}
	protected java.lang.Integer  __sub_contract_id ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.String  __sub_contract_code ;
	protected java.lang.String  __project_code ;
	protected java.lang.Integer  __business_type ;
	protected java.lang.Integer  __project_type ;
	protected java.lang.Integer  __department_id ;
	protected java.math.BigDecimal  __common_area ;
	protected java.math.BigDecimal  __logistics_area ;
	protected java.math.BigDecimal  __money_sum ;
	protected java.util.Date  __create_time ;
	protected java.lang.String  __sub_contract_name ;
	protected java.util.Date  __update_time ;
	protected java.math.BigDecimal  __design_area ;
	protected java.lang.Integer  __order_no ;
	protected java.math.BigDecimal  __sheet_total_integral ;
	protected java.math.BigDecimal  __complaint_integral ;
	protected java.math.BigDecimal  __sheet_integral ;
	protected java.math.BigDecimal  __complaint_percentage ;
	protected java.util.Date  __agree_date ;
	protected java.lang.String  __info_code ;
	protected java.lang.Integer  __business_state_record_id ;
	protected java.lang.String __remark;
	protected java.lang.Integer  __project_manage_id ;
	protected java.lang.Boolean  __is_history ;
	protected java.lang.Integer  __business_line ;
}
