package pomplatform.projectintegralchangerecord.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMprojectintegralchangerecord extends GenericBase implements BaseFactory<BaseMprojectintegralchangerecord>, Comparable<BaseMprojectintegralchangerecord> 
{


	public static BaseMprojectintegralchangerecord newInstance(){
		return new BaseMprojectintegralchangerecord();
	}

	@Override
	public BaseMprojectintegralchangerecord make(){
		BaseMprojectintegralchangerecord b = new BaseMprojectintegralchangerecord();
		return b;
	}

	public final static java.lang.String CS_PHOTO = "photo" ;
	public final static java.lang.String CS_PROJECT_INTEGRAL_CHANGE_RECORD_ID = "project_integral_change_record_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_BEFORE_PROJECT_INTEGRAL = "before_project_integral" ;
	public final static java.lang.String CS_AFTER_PROJECT_INTEGRAL = "after_project_integral" ;
	public final static java.lang.String CS_BEFORE_RESERVE_INTEGRAL = "before_reserve_integral" ;
	public final static java.lang.String CS_AFTER_RESERVE_INTEGRAL = "after_reserve_integral" ;
	public final static java.lang.String CS_TRANSFER_INTEGRAL = "transfer_integral" ;
	public final static java.lang.String CS_TRANSFER_DATE = "transfer_date" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_PLATE_EMPLOYEE_ID = "plate_employee_id" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "头像,主键编码,项目,调整前项目积分,调整后项目积分,调整前预留积分,调整后预留积分,转移积分,转移日期,板块,板块负责人,备注";

	public java.lang.String getPhoto() {
		return this.__photo;
	}

	public void setPhoto( java.lang.String value ) {
		this.__photo = value;
	}

	public java.lang.Integer getProjectIntegralChangeRecordId() {
		return this.__project_integral_change_record_id;
	}

	public void setProjectIntegralChangeRecordId( java.lang.Integer value ) {
		this.__project_integral_change_record_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.math.BigDecimal getBeforeProjectIntegral() {
		return this.__before_project_integral;
	}

	public void setBeforeProjectIntegral( java.math.BigDecimal value ) {
		this.__before_project_integral = value;
	}

	public java.math.BigDecimal getAfterProjectIntegral() {
		return this.__after_project_integral;
	}

	public void setAfterProjectIntegral( java.math.BigDecimal value ) {
		this.__after_project_integral = value;
	}

	public java.math.BigDecimal getBeforeReserveIntegral() {
		return this.__before_reserve_integral;
	}

	public void setBeforeReserveIntegral( java.math.BigDecimal value ) {
		this.__before_reserve_integral = value;
	}

	public java.math.BigDecimal getAfterReserveIntegral() {
		return this.__after_reserve_integral;
	}

	public void setAfterReserveIntegral( java.math.BigDecimal value ) {
		this.__after_reserve_integral = value;
	}

	public java.math.BigDecimal getTransferIntegral() {
		return this.__transfer_integral;
	}

	public void setTransferIntegral( java.math.BigDecimal value ) {
		this.__transfer_integral = value;
	}

	public java.util.Date getTransferDate() {
		return this.__transfer_date;
	}

	public void setTransferDate( java.util.Date value ) {
		this.__transfer_date = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getPlateEmployeeId() {
		return this.__plate_employee_id;
	}

	public void setPlateEmployeeId( java.lang.Integer value ) {
		this.__plate_employee_id = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseMprojectintegralchangerecord __bean){
		__bean.setPhoto(getPhoto());
		__bean.setProjectIntegralChangeRecordId(getProjectIntegralChangeRecordId());
		__bean.setProjectId(getProjectId());
		__bean.setBeforeProjectIntegral(getBeforeProjectIntegral());
		__bean.setAfterProjectIntegral(getAfterProjectIntegral());
		__bean.setBeforeReserveIntegral(getBeforeReserveIntegral());
		__bean.setAfterReserveIntegral(getAfterReserveIntegral());
		__bean.setTransferIntegral(getTransferIntegral());
		__bean.setTransferDate(getTransferDate());
		__bean.setPlateId(getPlateId());
		__bean.setPlateEmployeeId(getPlateEmployeeId());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPhoto() == null ? "" : getPhoto());
		sb.append(",");
		sb.append(getProjectIntegralChangeRecordId() == null ? "" : getProjectIntegralChangeRecordId());
		sb.append(",");
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		sb.append(getBeforeProjectIntegral() == null ? "" : getBeforeProjectIntegral());
		sb.append(",");
		sb.append(getAfterProjectIntegral() == null ? "" : getAfterProjectIntegral());
		sb.append(",");
		sb.append(getBeforeReserveIntegral() == null ? "" : getBeforeReserveIntegral());
		sb.append(",");
		sb.append(getAfterReserveIntegral() == null ? "" : getAfterReserveIntegral());
		sb.append(",");
		sb.append(getTransferIntegral() == null ? "" : getTransferIntegral());
		sb.append(",");
		sb.append(getTransferDate() == null ? "" : sdf.format(getTransferDate()));
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		String strPlateEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getPlateEmployeeId()));
		sb.append(strPlateEmployeeId == null ? "" : strPlateEmployeeId);
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMprojectintegralchangerecord o) {
		return __project_integral_change_record_id == null ? -1 : __project_integral_change_record_id.compareTo(o.getProjectIntegralChangeRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__photo);
		hash = 97 * hash + Objects.hashCode(this.__project_integral_change_record_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__before_project_integral);
		hash = 97 * hash + Objects.hashCode(this.__after_project_integral);
		hash = 97 * hash + Objects.hashCode(this.__before_reserve_integral);
		hash = 97 * hash + Objects.hashCode(this.__after_reserve_integral);
		hash = 97 * hash + Objects.hashCode(this.__transfer_integral);
		hash = 97 * hash + Objects.hashCode(this.__transfer_date);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMprojectintegralchangerecord o = (BaseMprojectintegralchangerecord)obj;
		if(!Objects.equals(this.__photo, o.getPhoto())) return false;
		if(!Objects.equals(this.__project_integral_change_record_id, o.getProjectIntegralChangeRecordId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__before_project_integral, o.getBeforeProjectIntegral())) return false;
		if(!Objects.equals(this.__after_project_integral, o.getAfterProjectIntegral())) return false;
		if(!Objects.equals(this.__before_reserve_integral, o.getBeforeReserveIntegral())) return false;
		if(!Objects.equals(this.__after_reserve_integral, o.getAfterReserveIntegral())) return false;
		if(!Objects.equals(this.__transfer_integral, o.getTransferIntegral())) return false;
		if(!Objects.equals(this.__transfer_date, o.getTransferDate())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__plate_employee_id, o.getPlateEmployeeId())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPhoto() != null) sb.append(__wrapString(count++, "photo", getPhoto()));
		if(getProjectIntegralChangeRecordId() != null) sb.append(__wrapNumber(count++, "projectIntegralChangeRecordId", getProjectIntegralChangeRecordId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getBeforeProjectIntegral() != null) sb.append(__wrapDecimal(count++, "beforeProjectIntegral", getBeforeProjectIntegral()));
		if(getAfterProjectIntegral() != null) sb.append(__wrapDecimal(count++, "afterProjectIntegral", getAfterProjectIntegral()));
		if(getBeforeReserveIntegral() != null) sb.append(__wrapDecimal(count++, "beforeReserveIntegral", getBeforeReserveIntegral()));
		if(getAfterReserveIntegral() != null) sb.append(__wrapDecimal(count++, "afterReserveIntegral", getAfterReserveIntegral()));
		if(getTransferIntegral() != null) sb.append(__wrapDecimal(count++, "transferIntegral", getTransferIntegral()));
		if(getTransferDate() != null) sb.append(__wrapDate(count++, "transferDate", getTransferDate()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getPlateEmployeeId() != null) sb.append(__wrapNumber(count++, "plateEmployeeId", getPlateEmployeeId()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("photo")) != null) setPhoto(__getString(val));
		if((val = values.get("projectIntegralChangeRecordId")) != null) setProjectIntegralChangeRecordId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("beforeProjectIntegral")) != null) setBeforeProjectIntegral(__getDecimal(val));  
		if((val = values.get("afterProjectIntegral")) != null) setAfterProjectIntegral(__getDecimal(val));  
		if((val = values.get("beforeReserveIntegral")) != null) setBeforeReserveIntegral(__getDecimal(val));  
		if((val = values.get("afterReserveIntegral")) != null) setAfterReserveIntegral(__getDecimal(val));  
		if((val = values.get("transferIntegral")) != null) setTransferIntegral(__getDecimal(val));  
		if((val = values.get("transferDate")) != null) setTransferDate(__getDate(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("plateEmployeeId")) != null) setPlateEmployeeId(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.String  __photo ;
	protected java.lang.Integer  __project_integral_change_record_id ;
	protected java.lang.Integer  __project_id ;
	protected java.math.BigDecimal  __before_project_integral ;
	protected java.math.BigDecimal  __after_project_integral ;
	protected java.math.BigDecimal  __before_reserve_integral ;
	protected java.math.BigDecimal  __after_reserve_integral ;
	protected java.math.BigDecimal  __transfer_integral ;
	protected java.util.Date  __transfer_date ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __plate_employee_id ;
	protected java.lang.String  __remark ;
}
