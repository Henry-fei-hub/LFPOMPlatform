package pomplatform.sProjectEmployeeAdvanceRecordpor.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseProjectEmployeeAdvanceEachPersonDetail extends GenericBase implements BaseFactory<BaseProjectEmployeeAdvanceEachPersonDetail>, Comparable<BaseProjectEmployeeAdvanceEachPersonDetail> 
{


	public static BaseProjectEmployeeAdvanceEachPersonDetail newInstance(){
		return new BaseProjectEmployeeAdvanceEachPersonDetail();
	}

	@Override
	public BaseProjectEmployeeAdvanceEachPersonDetail make(){
		BaseProjectEmployeeAdvanceEachPersonDetail b = new BaseProjectEmployeeAdvanceEachPersonDetail();
		return b;
	}

	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_ADVANCE_INTEGRAL = "advance_integral" ;
	public final static java.lang.String CS_ADVANCE_DATE = "advance_date" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "项目名称,员工姓名,补贴积分,补贴日期,操作人,备注";

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.math.BigDecimal getAdvanceIntegral() {
		return this.__advance_integral;
	}

	public void setAdvanceIntegral( java.math.BigDecimal value ) {
		this.__advance_integral = value;
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

	public void cloneCopy(BaseProjectEmployeeAdvanceEachPersonDetail __bean){
		__bean.setProjectId(getProjectId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setAdvanceIntegral(getAdvanceIntegral());
		__bean.setAdvanceDate(getAdvanceDate());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getAdvanceIntegral() == null ? "" : getAdvanceIntegral());
		sb.append(",");
		sb.append(getAdvanceDate() == null ? "" : sdf.format(getAdvanceDate()));
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectEmployeeAdvanceEachPersonDetail o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__advance_integral);
		hash = 97 * hash + Objects.hashCode(this.__advance_date);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectEmployeeAdvanceEachPersonDetail o = (BaseProjectEmployeeAdvanceEachPersonDetail)obj;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__advance_integral, o.getAdvanceIntegral())) return false;
		if(!Objects.equals(this.__advance_date, o.getAdvanceDate())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getAdvanceIntegral() != null) sb.append(__wrapDecimal(count++, "advanceIntegral", getAdvanceIntegral()));
		if(getAdvanceDate() != null) sb.append(__wrapDate(count++, "advanceDate", getAdvanceDate()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("advanceIntegral")) != null) setAdvanceIntegral(__getDecimal(val));  
		if((val = values.get("advanceDate")) != null) setAdvanceDate(__getDate(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.math.BigDecimal  __advance_integral ;
	protected java.util.Date  __advance_date ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.lang.String  __remark ;
}
