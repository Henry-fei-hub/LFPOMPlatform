package pomplatform.workflow.personnelbusiness.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseGetProcessComment extends GenericBase implements BaseFactory<BaseGetProcessComment>, Comparable<BaseGetProcessComment> 
{


	public static BaseGetProcessComment newInstance(){
		return new BaseGetProcessComment();
	}

	@Override
	public BaseGetProcessComment make(){
		BaseGetProcessComment b = new BaseGetProcessComment();
		return b;
	}

	public final static java.lang.String CS_BACK_VIEW_NAME = "back_view_name" ;
	public final static java.lang.String CS_PROCESS_COMMENT = "process_comment" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;

	public final static java.lang.String ALL_CAPTIONS = "返回数据集,提交意见,员工姓名,操作时间";

	public java.lang.String getBackViewName() {
		return this.__back_view_name;
	}

	public void setBackViewName( java.lang.String value ) {
		this.__back_view_name = value;
	}

	public java.lang.String getProcessComment() {
		return this.__process_comment;
	}

	public void setProcessComment( java.lang.String value ) {
		this.__process_comment = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.util.Date getOperateTime() {
		return __operate_time;
	}

	public void setOperateTime(java.util.Date value) {
		this.__operate_time = value;
	}

	public void cloneCopy(BaseGetProcessComment __bean){
		__bean.setBackViewName(getBackViewName());
		__bean.setProcessComment(getProcessComment());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setOperateTime(getOperateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getBackViewName() == null ? "" : getBackViewName());
		sb.append(",");
		sb.append(getProcessComment() == null ? "" : getProcessComment());
		sb.append(",");
		String strEmployeeName = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeName()));
		sb.append(strEmployeeName == null ? "" : strEmployeeName);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetProcessComment o) {
		return __back_view_name == null ? -1 : __back_view_name.compareTo(o.getBackViewName());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__back_view_name);
		hash = 97 * hash + Objects.hashCode(this.__process_comment);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetProcessComment o = (BaseGetProcessComment)obj;
		if(!Objects.equals(this.__back_view_name, o.getBackViewName())) return false;
		if(!Objects.equals(this.__process_comment, o.getProcessComment())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__operate_time, o.getEmployeeName())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getBackViewName() != null) sb.append(__wrapString(count++, "backViewName", getBackViewName()));
		if(getProcessComment() != null) sb.append(__wrapString(count++, "processComment", getProcessComment()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("backViewName")) != null) setBackViewName(__getString(val));
		if((val = values.get("processComment")) != null) setProcessComment(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val));
	}

	protected java.lang.String  __back_view_name ;
	protected java.lang.String  __process_comment ;
	protected java.lang.String  __employee_name ;
	protected java.util.Date  __operate_time;
}
