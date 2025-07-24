package pomplatform.contractchange.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseProjectChangeRecord extends GenericBase implements BaseFactory<BaseProjectChangeRecord>, Comparable<BaseProjectChangeRecord> 
{


	public static BaseProjectChangeRecord newInstance(){
		return new BaseProjectChangeRecord();
	}

	@Override
	public BaseProjectChangeRecord make(){
		BaseProjectChangeRecord b = new BaseProjectChangeRecord();
		return b;
	}

	public final static java.lang.String CS_PROJECT_CHANGE_ID = "project_change_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_SHEET_AMOUNT = "sheet_amount" ;
	public final static java.lang.String CS_SHEET_CHANGE_AMOUNT = "sheet_change_amount" ;
	public final static java.lang.String CS_SHEET_FINAL_AMOUNT = "sheet_final_amount" ;
	public final static java.lang.String CS_SHEET_CHANGE_VIEW = "sheet_change_view" ;
	public final static java.lang.String CS_TOTAL_INTEGRAL = "total_integral" ;
	public final static java.lang.String CS_TOTAL_CHANGE_INTEGRAL = "total_change_integral" ;
	public final static java.lang.String CS_TOTAL_FINAL_INTEGRAL = "total_final_integral" ;
	public final static java.lang.String CS_TOTAL_CHANGE_VIEW = "total_change_view" ;
	public final static java.lang.String CS_COMMON_AREA = "common_area" ;
	public final static java.lang.String CS_LOGISTICS_AREA = "logistics_area" ;
	public final static java.lang.String CS_DESIGN_AREA = "design_area" ;
	public final static java.lang.String CS_COMPLAINT_PERCENTAGE = "complaint_percentage" ;
	public final static java.lang.String CS_COMPLAINT_INTEGRAL = "complaint_integral" ;
	public final static java.lang.String CS_FLAG = "flag" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,项目编码,订单合同金额,订单合同变更金额,订单合同变更后金额,订单合同金额变更显示,订单总积分,订单变更积分,订单变更后总积分,订单总积分变更显示,公区面积,后勤面积,设计面积,投诉保证金比例,投诉保证金,4已审核),操作人,操作时间,备注";

	public java.lang.Integer getProjectChangeId() {
		return this.__project_change_id;
	}

	public void setProjectChangeId( java.lang.Integer value ) {
		this.__project_change_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.math.BigDecimal getSheetAmount() {
		return this.__sheet_amount;
	}

	public void setSheetAmount( java.math.BigDecimal value ) {
		this.__sheet_amount = value;
	}

	public java.math.BigDecimal getSheetChangeAmount() {
		return this.__sheet_change_amount;
	}

	public void setSheetChangeAmount( java.math.BigDecimal value ) {
		this.__sheet_change_amount = value;
	}

	public java.math.BigDecimal getSheetFinalAmount() {
		return this.__sheet_final_amount;
	}

	public void setSheetFinalAmount( java.math.BigDecimal value ) {
		this.__sheet_final_amount = value;
	}

	public java.lang.String getSheetChangeView() {
		return this.__sheet_change_view;
	}

	public void setSheetChangeView( java.lang.String value ) {
		this.__sheet_change_view = value;
	}

	public java.math.BigDecimal getTotalIntegral() {
		return this.__total_integral;
	}

	public void setTotalIntegral( java.math.BigDecimal value ) {
		this.__total_integral = value;
	}

	public java.math.BigDecimal getTotalChangeIntegral() {
		return this.__total_change_integral;
	}

	public void setTotalChangeIntegral( java.math.BigDecimal value ) {
		this.__total_change_integral = value;
	}

	public java.math.BigDecimal getTotalFinalIntegral() {
		return this.__total_final_integral;
	}

	public void setTotalFinalIntegral( java.math.BigDecimal value ) {
		this.__total_final_integral = value;
	}

	public java.lang.String getTotalChangeView() {
		return this.__total_change_view;
	}

	public void setTotalChangeView( java.lang.String value ) {
		this.__total_change_view = value;
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

	public java.lang.Integer getFlag() {
		return this.__flag;
	}

	public void setFlag( java.lang.Integer value ) {
		this.__flag = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseProjectChangeRecord __bean){
		__bean.setProjectChangeId(getProjectChangeId());
		__bean.setProjectId(getProjectId());
		__bean.setSheetAmount(getSheetAmount());
		__bean.setSheetChangeAmount(getSheetChangeAmount());
		__bean.setSheetFinalAmount(getSheetFinalAmount());
		__bean.setSheetChangeView(getSheetChangeView());
		__bean.setTotalIntegral(getTotalIntegral());
		__bean.setTotalChangeIntegral(getTotalChangeIntegral());
		__bean.setTotalFinalIntegral(getTotalFinalIntegral());
		__bean.setTotalChangeView(getTotalChangeView());
		__bean.setCommonArea(getCommonArea());
		__bean.setLogisticsArea(getLogisticsArea());
		__bean.setDesignArea(getDesignArea());
		__bean.setComplaintPercentage(getComplaintPercentage());
		__bean.setComplaintIntegral(getComplaintIntegral());
		__bean.setFlag(getFlag());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectChangeId() == null ? "" : getProjectChangeId());
		sb.append(",");
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		sb.append(getSheetAmount() == null ? "" : getSheetAmount());
		sb.append(",");
		sb.append(getSheetChangeAmount() == null ? "" : getSheetChangeAmount());
		sb.append(",");
		sb.append(getSheetFinalAmount() == null ? "" : getSheetFinalAmount());
		sb.append(",");
		sb.append(getSheetChangeView() == null ? "" : getSheetChangeView());
		sb.append(",");
		sb.append(getTotalIntegral() == null ? "" : getTotalIntegral());
		sb.append(",");
		sb.append(getTotalChangeIntegral() == null ? "" : getTotalChangeIntegral());
		sb.append(",");
		sb.append(getTotalFinalIntegral() == null ? "" : getTotalFinalIntegral());
		sb.append(",");
		sb.append(getTotalChangeView() == null ? "" : getTotalChangeView());
		sb.append(",");
		sb.append(getCommonArea() == null ? "" : getCommonArea());
		sb.append(",");
		sb.append(getLogisticsArea() == null ? "" : getLogisticsArea());
		sb.append(",");
		sb.append(getDesignArea() == null ? "" : getDesignArea());
		sb.append(",");
		sb.append(getComplaintPercentage() == null ? "" : getComplaintPercentage());
		sb.append(",");
		sb.append(getComplaintIntegral() == null ? "" : getComplaintIntegral());
		sb.append(",");
		sb.append(getFlag() == null ? "" : getFlag());
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectChangeRecord o) {
		return __project_change_id == null ? -1 : __project_change_id.compareTo(o.getProjectChangeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_change_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__sheet_amount);
		hash = 97 * hash + Objects.hashCode(this.__sheet_change_amount);
		hash = 97 * hash + Objects.hashCode(this.__sheet_final_amount);
		hash = 97 * hash + Objects.hashCode(this.__sheet_change_view);
		hash = 97 * hash + Objects.hashCode(this.__total_integral);
		hash = 97 * hash + Objects.hashCode(this.__total_change_integral);
		hash = 97 * hash + Objects.hashCode(this.__total_final_integral);
		hash = 97 * hash + Objects.hashCode(this.__total_change_view);
		hash = 97 * hash + Objects.hashCode(this.__common_area);
		hash = 97 * hash + Objects.hashCode(this.__logistics_area);
		hash = 97 * hash + Objects.hashCode(this.__design_area);
		hash = 97 * hash + Objects.hashCode(this.__complaint_percentage);
		hash = 97 * hash + Objects.hashCode(this.__complaint_integral);
		hash = 97 * hash + Objects.hashCode(this.__flag);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectChangeRecord o = (BaseProjectChangeRecord)obj;
		if(!Objects.equals(this.__project_change_id, o.getProjectChangeId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__sheet_amount, o.getSheetAmount())) return false;
		if(!Objects.equals(this.__sheet_change_amount, o.getSheetChangeAmount())) return false;
		if(!Objects.equals(this.__sheet_final_amount, o.getSheetFinalAmount())) return false;
		if(!Objects.equals(this.__sheet_change_view, o.getSheetChangeView())) return false;
		if(!Objects.equals(this.__total_integral, o.getTotalIntegral())) return false;
		if(!Objects.equals(this.__total_change_integral, o.getTotalChangeIntegral())) return false;
		if(!Objects.equals(this.__total_final_integral, o.getTotalFinalIntegral())) return false;
		if(!Objects.equals(this.__total_change_view, o.getTotalChangeView())) return false;
		if(!Objects.equals(this.__common_area, o.getCommonArea())) return false;
		if(!Objects.equals(this.__logistics_area, o.getLogisticsArea())) return false;
		if(!Objects.equals(this.__design_area, o.getDesignArea())) return false;
		if(!Objects.equals(this.__complaint_percentage, o.getComplaintPercentage())) return false;
		if(!Objects.equals(this.__complaint_integral, o.getComplaintIntegral())) return false;
		if(!Objects.equals(this.__flag, o.getFlag())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectChangeId() != null) sb.append(__wrapNumber(count++, "projectChangeId", getProjectChangeId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getSheetAmount() != null) sb.append(__wrapDecimal(count++, "sheetAmount", getSheetAmount()));
		if(getSheetChangeAmount() != null) sb.append(__wrapDecimal(count++, "sheetChangeAmount", getSheetChangeAmount()));
		if(getSheetFinalAmount() != null) sb.append(__wrapDecimal(count++, "sheetFinalAmount", getSheetFinalAmount()));
		if(getSheetChangeView() != null) sb.append(__wrapString(count++, "sheetChangeView", getSheetChangeView()));
		if(getTotalIntegral() != null) sb.append(__wrapDecimal(count++, "totalIntegral", getTotalIntegral()));
		if(getTotalChangeIntegral() != null) sb.append(__wrapDecimal(count++, "totalChangeIntegral", getTotalChangeIntegral()));
		if(getTotalFinalIntegral() != null) sb.append(__wrapDecimal(count++, "totalFinalIntegral", getTotalFinalIntegral()));
		if(getTotalChangeView() != null) sb.append(__wrapString(count++, "totalChangeView", getTotalChangeView()));
		if(getCommonArea() != null) sb.append(__wrapDecimal(count++, "commonArea", getCommonArea()));
		if(getLogisticsArea() != null) sb.append(__wrapDecimal(count++, "logisticsArea", getLogisticsArea()));
		if(getDesignArea() != null) sb.append(__wrapDecimal(count++, "designArea", getDesignArea()));
		if(getComplaintPercentage() != null) sb.append(__wrapDecimal(count++, "complaintPercentage", getComplaintPercentage()));
		if(getComplaintIntegral() != null) sb.append(__wrapDecimal(count++, "complaintIntegral", getComplaintIntegral()));
		if(getFlag() != null) sb.append(__wrapNumber(count++, "flag", getFlag()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectChangeId")) != null) setProjectChangeId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("sheetAmount")) != null) setSheetAmount(__getDecimal(val));  
		if((val = values.get("sheetChangeAmount")) != null) setSheetChangeAmount(__getDecimal(val));  
		if((val = values.get("sheetFinalAmount")) != null) setSheetFinalAmount(__getDecimal(val));  
		if((val = values.get("sheetChangeView")) != null) setSheetChangeView(__getString(val));
		if((val = values.get("totalIntegral")) != null) setTotalIntegral(__getDecimal(val));  
		if((val = values.get("totalChangeIntegral")) != null) setTotalChangeIntegral(__getDecimal(val));  
		if((val = values.get("totalFinalIntegral")) != null) setTotalFinalIntegral(__getDecimal(val));  
		if((val = values.get("totalChangeView")) != null) setTotalChangeView(__getString(val));
		if((val = values.get("commonArea")) != null) setCommonArea(__getDecimal(val));  
		if((val = values.get("logisticsArea")) != null) setLogisticsArea(__getDecimal(val));  
		if((val = values.get("designArea")) != null) setDesignArea(__getDecimal(val));  
		if((val = values.get("complaintPercentage")) != null) setComplaintPercentage(__getDecimal(val));  
		if((val = values.get("complaintIntegral")) != null) setComplaintIntegral(__getDecimal(val));  
		if((val = values.get("flag")) != null) setFlag(__getInt(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __project_change_id ;
	protected java.lang.Integer  __project_id ;
	protected java.math.BigDecimal  __sheet_amount ;
	protected java.math.BigDecimal  __sheet_change_amount ;
	protected java.math.BigDecimal  __sheet_final_amount ;
	protected java.lang.String  __sheet_change_view ;
	protected java.math.BigDecimal  __total_integral ;
	protected java.math.BigDecimal  __total_change_integral ;
	protected java.math.BigDecimal  __total_final_integral ;
	protected java.lang.String  __total_change_view ;
	protected java.math.BigDecimal  __common_area ;
	protected java.math.BigDecimal  __logistics_area ;
	protected java.math.BigDecimal  __design_area ;
	protected java.math.BigDecimal  __complaint_percentage ;
	protected java.math.BigDecimal  __complaint_integral ;
	protected java.lang.Integer  __flag ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
}
