package pomplatform.account.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BasePlateDeployDetails extends GenericBase implements BaseFactory<BasePlateDeployDetails>, Comparable<BasePlateDeployDetails> 
{


	public static BasePlateDeployDetails newInstance(){
		return new BasePlateDeployDetails();
	}

	@Override
	public BasePlateDeployDetails make(){
		BasePlateDeployDetails b = new BasePlateDeployDetails();
		return b;
	}

	public final static String CS_PLATE_DEPLOY_DETAIL_ID = "plate_deploy_detail_id" ;
	public final static String CS_PLATE_DEPLOY_RECORD_ID = "plate_deploy_record_id" ;
	public final static String CS_EMPLOYEE_ID = "employee_id" ;
	public final static String CS_PLATE_NAME = "plate_name" ;
	public final static String CS_ADVANCE_INTEGRAL = "advance_integral" ;
	public final static String CS_ADVANCE_DATE = "advance_date" ;
	public final static String CS_OPERATE_TIME = "operate_time" ;
	public final static String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static String CS_REMARK = "remark" ;

	public final static String ALL_CAPTIONS = "主键编码,总表id,调配成员,业务部门名称,调配积分,调配日期,操作时间,操作人,备注";

	public Integer getPlateDeployDetailId() {
		return this.__plate_deploy_detail_id;
	}

	public void setPlateDeployDetailId( Integer value ) {
		this.__plate_deploy_detail_id = value;
	}

	public Integer getPlateDeployRecordId() {
		return this.__plate_deploy_record_id;
	}

	public void setPlateDeployRecordId( Integer value ) {
		this.__plate_deploy_record_id = value;
	}

	public Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( Integer value ) {
		this.__employee_id = value;
	}

	public String getPlateName() {
		return this.__plate_name;
	}

	public void setPlateName( String value ) {
		this.__plate_name = value;
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

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( Integer value ) {
		this.__operate_employee_id = value;
	}

	public String getRemark() {
		return this.__remark;
	}

	public void setRemark( String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BasePlateDeployDetails __bean){
		__bean.setPlateDeployDetailId(getPlateDeployDetailId());
		__bean.setPlateDeployRecordId(getPlateDeployRecordId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setPlateName(getPlateName());
		__bean.setAdvanceIntegral(getAdvanceIntegral());
		__bean.setAdvanceDate(getAdvanceDate());
		__bean.setOperateTime(getOperateTime());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setRemark(getRemark());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPlateDeployDetailId() == null ? "" : getPlateDeployDetailId());
		sb.append(",");
		sb.append(getPlateDeployRecordId() == null ? "" : getPlateDeployRecordId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getPlateName() == null ? "" : getPlateName());
		sb.append(",");
		sb.append(getAdvanceIntegral() == null ? "" : getAdvanceIntegral());
		sb.append(",");
		sb.append(getAdvanceDate() == null ? "" : sdf.format(getAdvanceDate()));
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePlateDeployDetails o) {
		return __plate_deploy_detail_id == null ? -1 : __plate_deploy_detail_id.compareTo(o.getPlateDeployDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_deploy_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_deploy_record_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_name);
		hash = 97 * hash + Objects.hashCode(this.__advance_integral);
		hash = 97 * hash + Objects.hashCode(this.__advance_date);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePlateDeployDetails o = (BasePlateDeployDetails)obj;
		if(!Objects.equals(this.__plate_deploy_detail_id, o.getPlateDeployDetailId())) return false;
		if(!Objects.equals(this.__plate_deploy_record_id, o.getPlateDeployRecordId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__plate_name, o.getPlateName())) return false;
		if(!Objects.equals(this.__advance_integral, o.getAdvanceIntegral())) return false;
		if(!Objects.equals(this.__advance_date, o.getAdvanceDate())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateDeployDetailId() != null) sb.append(__wrapNumber(count++, "plateDeployDetailId", getPlateDeployDetailId()));
		if(getPlateDeployRecordId() != null) sb.append(__wrapNumber(count++, "plateDeployRecordId", getPlateDeployRecordId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getPlateName() != null) sb.append(__wrapString(count++, "plateName", getPlateName()));
		if(getAdvanceIntegral() != null) sb.append(__wrapDecimal(count++, "advanceIntegral", getAdvanceIntegral()));
		if(getAdvanceDate() != null) sb.append(__wrapDate(count++, "advanceDate", getAdvanceDate()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getPlateDeployDetailId() != null) res.put("plateDeployDetailId", getPlateDeployDetailId());
		if(getPlateDeployRecordId() != null) res.put("plateDeployRecordId", getPlateDeployRecordId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getPlateName() != null) res.put("plateName", getPlateName());
		if(getAdvanceIntegral() != null) res.put("advanceIntegral", getAdvanceIntegral());
		if(getAdvanceDate() != null) res.put("advanceDate", getAdvanceDate());
		if(getOperateTime() != null) res.put("operateTime", getOperateTime());
		if(getOperateEmployeeId() != null) res.put("operateEmployeeId", getOperateEmployeeId());
		if(getRemark() != null) res.put("remark", getRemark());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateDeployDetailId")) != null) setPlateDeployDetailId(__getInt(val)); 
		if((val = values.get("plateDeployRecordId")) != null) setPlateDeployRecordId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("plateName")) != null) setPlateName(__getString(val));
		if((val = values.get("advanceIntegral")) != null) setAdvanceIntegral(__getDecimal(val));  
		if((val = values.get("advanceDate")) != null) setAdvanceDate(__getDate(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected Integer  __plate_deploy_detail_id ;
	protected Integer  __plate_deploy_record_id ;
	protected Integer  __employee_id ;
	protected String  __plate_name ;
	protected java.math.BigDecimal  __advance_integral ;
	protected java.util.Date  __advance_date ;
	protected java.util.Date  __operate_time ;
	protected Integer  __operate_employee_id ;
	protected String  __remark ;
}
