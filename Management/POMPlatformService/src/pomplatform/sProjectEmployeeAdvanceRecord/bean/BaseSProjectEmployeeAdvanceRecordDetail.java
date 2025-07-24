package pomplatform.sProjectEmployeeAdvanceRecord.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSProjectEmployeeAdvanceRecordDetail extends GenericBase implements BaseFactory<BaseSProjectEmployeeAdvanceRecordDetail>, Comparable<BaseSProjectEmployeeAdvanceRecordDetail> 
{


	public static BaseSProjectEmployeeAdvanceRecordDetail newInstance(){
		return new BaseSProjectEmployeeAdvanceRecordDetail();
	}

	@Override
	public BaseSProjectEmployeeAdvanceRecordDetail make(){
		BaseSProjectEmployeeAdvanceRecordDetail b = new BaseSProjectEmployeeAdvanceRecordDetail();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_ADVANCED_INTEGRAL = "advanced_integral" ;
	public final static java.lang.String CS_ADVANCE_DATE = "advance_date" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "补贴员工,补贴项目,补贴积分,补贴日期,操作人,备注";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.math.BigDecimal getAdvancedIntegral() {
		return this.__advanced_integral;
	}

	public void setAdvancedIntegral( java.math.BigDecimal value ) {
		this.__advanced_integral = value;
	}

	public java.util.Date getAdvanceDate() {
		return this.__advance_date;
	}

	public void setAdvanceDate( java.util.Date value ) {
		this.__advance_date = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseSProjectEmployeeAdvanceRecordDetail __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setProjectId(getProjectId());
		__bean.setAdvancedIntegral(getAdvancedIntegral());
		__bean.setAdvanceDate(getAdvanceDate());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		sb.append(getAdvancedIntegral() == null ? "" : getAdvancedIntegral());
		sb.append(",");
		sb.append(getAdvanceDate() == null ? "" : sdf.format(getAdvanceDate()));
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSProjectEmployeeAdvanceRecordDetail o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__advanced_integral);
		hash = 97 * hash + Objects.hashCode(this.__advance_date);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSProjectEmployeeAdvanceRecordDetail o = (BaseSProjectEmployeeAdvanceRecordDetail)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__advanced_integral, o.getAdvancedIntegral())) return false;
		if(!Objects.equals(this.__advance_date, o.getAdvanceDate())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getAdvancedIntegral() != null) sb.append(__wrapDecimal(count++, "advancedIntegral", getAdvancedIntegral()));
		if(getAdvanceDate() != null) sb.append(__wrapDate(count++, "advanceDate", getAdvanceDate()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("advancedIntegral")) != null) setAdvancedIntegral(__getDecimal(val));  
		if((val = values.get("advanceDate")) != null) setAdvanceDate(__getDate(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __project_id ;
	protected java.math.BigDecimal  __advanced_integral ;
	protected java.util.Date  __advance_date ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.lang.String  __remark ;
}
