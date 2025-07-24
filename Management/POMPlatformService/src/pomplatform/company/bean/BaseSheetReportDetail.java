package pomplatform.company.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSheetReportDetail extends GenericBase implements BaseFactory<BaseSheetReportDetail>, Comparable<BaseSheetReportDetail> 
{


	public static BaseSheetReportDetail newInstance(){
		return new BaseSheetReportDetail();
	}

	@Override
	public BaseSheetReportDetail make(){
		BaseSheetReportDetail b = new BaseSheetReportDetail();
		return b;
	}

	public final static java.lang.String CS_SUB_CONTRACT_CODE = "sub_contract_code" ;
	public final static java.lang.String CS_SUB_CONTRACT_NAME = "sub_contract_name" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_PROJECT_TYPE = "project_type" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_SHEET_TOTAL_INTEGRAL = "sheet_total_integral" ;
	public final static java.lang.String CS_COMPLAINT_PERCENTAGE = "complaint_percentage" ;
	public final static java.lang.String CS_COMPLAINT_INTEGRAL = "complaint_integral" ;
	public final static java.lang.String CS_SHEET_INTEGRAL = "sheet_integral" ;
	public final static java.lang.String CS_MONEY_SUM = "money_sum" ;
	public final static java.lang.String CS_COMMON_AREA = "common_area" ;
	public final static java.lang.String CS_LOGISTICS_AREA = "logistics_area" ;
	public final static java.lang.String CS_DESIGN_AREA = "design_area" ;
	public final static java.lang.String CS_AGREE_DATE = "agree_date" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;

	public final static java.lang.String ALL_CAPTIONS = "子合同编号,子合同名称  充当了区域,业务类型,项目类型,承接部门,sheet_total_integral,投诉保证金比例,投诉保证金,订单积分,小计 子订单总金额,公区面积,后勤面积,设计面积,价格审核同意的时间,项目编号";

	public java.lang.String getSubContractCode() {
		return this.__sub_contract_code;
	}

	public void setSubContractCode( java.lang.String value ) {
		this.__sub_contract_code = value;
	}

	public java.lang.String getSubContractName() {
		return this.__sub_contract_name;
	}

	public void setSubContractName( java.lang.String value ) {
		this.__sub_contract_name = value;
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

	public java.math.BigDecimal getSheetTotalIntegral() {
		return this.__sheet_total_integral;
	}

	public void setSheetTotalIntegral( java.math.BigDecimal value ) {
		this.__sheet_total_integral = value;
	}

	public java.math.BigDecimal getComplaintPercentage() {
		return this.__complaint_percentage;
	}

	public void setComplaintPercentage( java.math.BigDecimal value ) {
		this.__complaint_percentage = value;
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

	public java.math.BigDecimal getMoneySum() {
		return this.__money_sum;
	}

	public void setMoneySum( java.math.BigDecimal value ) {
		this.__money_sum = value;
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

	public java.math.BigDecimal getDesignArea() {
		return this.__design_area;
	}

	public void setDesignArea( java.math.BigDecimal value ) {
		this.__design_area = value;
	}

	public java.util.Date getAgreeDate() {
		return this.__agree_date;
	}

	public void setAgreeDate( java.util.Date value ) {
		this.__agree_date = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public void cloneCopy(BaseSheetReportDetail __bean){
		__bean.setSubContractCode(getSubContractCode());
		__bean.setSubContractName(getSubContractName());
		__bean.setBusinessType(getBusinessType());
		__bean.setProjectType(getProjectType());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setSheetTotalIntegral(getSheetTotalIntegral());
		__bean.setComplaintPercentage(getComplaintPercentage());
		__bean.setComplaintIntegral(getComplaintIntegral());
		__bean.setSheetIntegral(getSheetIntegral());
		__bean.setMoneySum(getMoneySum());
		__bean.setCommonArea(getCommonArea());
		__bean.setLogisticsArea(getLogisticsArea());
		__bean.setDesignArea(getDesignArea());
		__bean.setAgreeDate(getAgreeDate());
		__bean.setProjectCode(getProjectCode());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSubContractCode() == null ? "" : getSubContractCode());
		sb.append(",");
		sb.append(getSubContractName() == null ? "" : getSubContractName());
		sb.append(",");
		sb.append(getBusinessType() == null ? "" : getBusinessType());
		sb.append(",");
		String strProjectType = delicacy.system.executor.SelectValueCache.getSelectValue("project_types", String.valueOf(getProjectType()));
		sb.append(strProjectType == null ? "" : strProjectType);
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getSheetTotalIntegral() == null ? "" : getSheetTotalIntegral());
		sb.append(",");
		sb.append(getComplaintPercentage() == null ? "" : getComplaintPercentage());
		sb.append(",");
		sb.append(getComplaintIntegral() == null ? "" : getComplaintIntegral());
		sb.append(",");
		sb.append(getSheetIntegral() == null ? "" : getSheetIntegral());
		sb.append(",");
		sb.append(getMoneySum() == null ? "" : getMoneySum());
		sb.append(",");
		sb.append(getCommonArea() == null ? "" : getCommonArea());
		sb.append(",");
		sb.append(getLogisticsArea() == null ? "" : getLogisticsArea());
		sb.append(",");
		sb.append(getDesignArea() == null ? "" : getDesignArea());
		sb.append(",");
		sb.append(getAgreeDate() == null ? "" : sdf.format(getAgreeDate()));
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSheetReportDetail o) {
		return __sub_contract_code == null ? -1 : __sub_contract_code.compareTo(o.getSubContractCode());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__sub_contract_code);
		hash = 97 * hash + Objects.hashCode(this.__sub_contract_name);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__project_type);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__sheet_total_integral);
		hash = 97 * hash + Objects.hashCode(this.__complaint_percentage);
		hash = 97 * hash + Objects.hashCode(this.__complaint_integral);
		hash = 97 * hash + Objects.hashCode(this.__sheet_integral);
		hash = 97 * hash + Objects.hashCode(this.__money_sum);
		hash = 97 * hash + Objects.hashCode(this.__common_area);
		hash = 97 * hash + Objects.hashCode(this.__logistics_area);
		hash = 97 * hash + Objects.hashCode(this.__design_area);
		hash = 97 * hash + Objects.hashCode(this.__agree_date);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSheetReportDetail o = (BaseSheetReportDetail)obj;
		if(!Objects.equals(this.__sub_contract_code, o.getSubContractCode())) return false;
		if(!Objects.equals(this.__sub_contract_name, o.getSubContractName())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__project_type, o.getProjectType())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__sheet_total_integral, o.getSheetTotalIntegral())) return false;
		if(!Objects.equals(this.__complaint_percentage, o.getComplaintPercentage())) return false;
		if(!Objects.equals(this.__complaint_integral, o.getComplaintIntegral())) return false;
		if(!Objects.equals(this.__sheet_integral, o.getSheetIntegral())) return false;
		if(!Objects.equals(this.__money_sum, o.getMoneySum())) return false;
		if(!Objects.equals(this.__common_area, o.getCommonArea())) return false;
		if(!Objects.equals(this.__logistics_area, o.getLogisticsArea())) return false;
		if(!Objects.equals(this.__design_area, o.getDesignArea())) return false;
		if(!Objects.equals(this.__agree_date, o.getAgreeDate())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSubContractCode() != null) sb.append(__wrapString(count++, "subContractCode", getSubContractCode()));
		if(getSubContractName() != null) sb.append(__wrapString(count++, "subContractName", getSubContractName()));
		if(getBusinessType() != null) sb.append(__wrapNumber(count++, "businessType", getBusinessType()));
		if(getProjectType() != null) sb.append(__wrapNumber(count++, "projectType", getProjectType()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getSheetTotalIntegral() != null) sb.append(__wrapDecimal(count++, "sheetTotalIntegral", getSheetTotalIntegral()));
		if(getComplaintPercentage() != null) sb.append(__wrapDecimal(count++, "complaintPercentage", getComplaintPercentage()));
		if(getComplaintIntegral() != null) sb.append(__wrapDecimal(count++, "complaintIntegral", getComplaintIntegral()));
		if(getSheetIntegral() != null) sb.append(__wrapDecimal(count++, "sheetIntegral", getSheetIntegral()));
		if(getMoneySum() != null) sb.append(__wrapDecimal(count++, "moneySum", getMoneySum()));
		if(getCommonArea() != null) sb.append(__wrapDecimal(count++, "commonArea", getCommonArea()));
		if(getLogisticsArea() != null) sb.append(__wrapDecimal(count++, "logisticsArea", getLogisticsArea()));
		if(getDesignArea() != null) sb.append(__wrapDecimal(count++, "designArea", getDesignArea()));
		if(getAgreeDate() != null) sb.append(__wrapDate(count++, "agreeDate", getAgreeDate()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("subContractCode")) != null) setSubContractCode(__getString(val));
		if((val = values.get("subContractName")) != null) setSubContractName(__getString(val));
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("sheetTotalIntegral")) != null) setSheetTotalIntegral(__getDecimal(val));  
		if((val = values.get("complaintPercentage")) != null) setComplaintPercentage(__getDecimal(val));  
		if((val = values.get("complaintIntegral")) != null) setComplaintIntegral(__getDecimal(val));  
		if((val = values.get("sheetIntegral")) != null) setSheetIntegral(__getDecimal(val));  
		if((val = values.get("moneySum")) != null) setMoneySum(__getDecimal(val));  
		if((val = values.get("commonArea")) != null) setCommonArea(__getDecimal(val));  
		if((val = values.get("logisticsArea")) != null) setLogisticsArea(__getDecimal(val));  
		if((val = values.get("designArea")) != null) setDesignArea(__getDecimal(val));  
		if((val = values.get("agreeDate")) != null) setAgreeDate(__getDate(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
	}

	protected java.lang.String  __sub_contract_code ;
	protected java.lang.String  __sub_contract_name ;
	protected java.lang.Integer  __business_type ;
	protected java.lang.Integer  __project_type ;
	protected java.lang.Integer  __department_id ;
	protected java.math.BigDecimal  __sheet_total_integral ;
	protected java.math.BigDecimal  __complaint_percentage ;
	protected java.math.BigDecimal  __complaint_integral ;
	protected java.math.BigDecimal  __sheet_integral ;
	protected java.math.BigDecimal  __money_sum ;
	protected java.math.BigDecimal  __common_area ;
	protected java.math.BigDecimal  __logistics_area ;
	protected java.math.BigDecimal  __design_area ;
	protected java.util.Date  __agree_date ;
	protected java.lang.String  __project_code ;
}
