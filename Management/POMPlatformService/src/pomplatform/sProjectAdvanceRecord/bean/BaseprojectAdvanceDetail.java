package pomplatform.sProjectAdvanceRecord.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseprojectAdvanceDetail extends GenericBase implements BaseFactory<BaseprojectAdvanceDetail>, Comparable<BaseprojectAdvanceDetail> 
{


	public static BaseprojectAdvanceDetail newInstance(){
		return new BaseprojectAdvanceDetail();
	}

	@Override
	public BaseprojectAdvanceDetail make(){
		BaseprojectAdvanceDetail b = new BaseprojectAdvanceDetail();
		return b;
	}

	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_PLATE_NAME = "plate_name" ;
	public final static java.lang.String CS_ADVANCE_INTEGRAL = "advance_integral" ;
	public final static java.lang.String CS_REMAINING_INTEGRAL = "remaining_integral" ;
	public final static java.lang.String CS_ASSIGNED_INTEGRAL = "assigned_integral" ;
	public final static java.lang.String CS_FLAG = "flag" ;

	public final static java.lang.String ALL_CAPTIONS = "补贴项目,业务部门,合同编号,项目名称,业务部门名称,补贴积分,,,1部门补贴到项目，2公司补贴到项目";

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getPlateName() {
		return this.__plate_name;
	}

	public void setPlateName( java.lang.String value ) {
		this.__plate_name = value;
	}

	public java.math.BigDecimal getAdvanceIntegral() {
		return this.__advance_integral;
	}

	public void setAdvanceIntegral( java.math.BigDecimal value ) {
		this.__advance_integral = value;
	}

	public java.math.BigDecimal getRemainingIntegral() {
		return this.__remaining_integral;
	}

	public void setRemainingIntegral( java.math.BigDecimal value ) {
		this.__remaining_integral = value;
	}

	public java.math.BigDecimal getAssignedIntegral() {
		return this.__assigned_integral;
	}

	public void setAssignedIntegral( java.math.BigDecimal value ) {
		this.__assigned_integral = value;
	}

	public java.lang.Integer getFlag() {
		return this.__flag;
	}

	public void setFlag( java.lang.Integer value ) {
		this.__flag = value;
	}

	public void cloneCopy(BaseprojectAdvanceDetail __bean){
		__bean.setProjectId(getProjectId());
		__bean.setPlateId(getPlateId());
		__bean.setContractCode(getContractCode());
		__bean.setProjectName(getProjectName());
		__bean.setPlateName(getPlateName());
		__bean.setAdvanceIntegral(getAdvanceIntegral());
		__bean.setRemainingIntegral(getRemainingIntegral());
		__bean.setAssignedIntegral(getAssignedIntegral());
		__bean.setFlag(getFlag());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getPlateName() == null ? "" : getPlateName());
		sb.append(",");
		sb.append(getAdvanceIntegral() == null ? "" : getAdvanceIntegral());
		sb.append(",");
		sb.append(getRemainingIntegral() == null ? "" : getRemainingIntegral());
		sb.append(",");
		sb.append(getAssignedIntegral() == null ? "" : getAssignedIntegral());
		sb.append(",");
		sb.append(getFlag() == null ? "" : getFlag());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseprojectAdvanceDetail o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__plate_name);
		hash = 97 * hash + Objects.hashCode(this.__advance_integral);
		hash = 97 * hash + Objects.hashCode(this.__remaining_integral);
		hash = 97 * hash + Objects.hashCode(this.__assigned_integral);
		hash = 97 * hash + Objects.hashCode(this.__flag);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseprojectAdvanceDetail o = (BaseprojectAdvanceDetail)obj;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__plate_name, o.getPlateName())) return false;
		if(!Objects.equals(this.__advance_integral, o.getAdvanceIntegral())) return false;
		if(!Objects.equals(this.__remaining_integral, o.getRemainingIntegral())) return false;
		if(!Objects.equals(this.__assigned_integral, o.getAssignedIntegral())) return false;
		if(!Objects.equals(this.__flag, o.getFlag())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getPlateName() != null) sb.append(__wrapString(count++, "plateName", getPlateName()));
		if(getAdvanceIntegral() != null) sb.append(__wrapDecimal(count++, "advanceIntegral", getAdvanceIntegral()));
		if(getRemainingIntegral() != null) sb.append(__wrapDecimal(count++, "remainingIntegral", getRemainingIntegral()));
		if(getAssignedIntegral() != null) sb.append(__wrapDecimal(count++, "assignedIntegral", getAssignedIntegral()));
		if(getFlag() != null) sb.append(__wrapNumber(count++, "flag", getFlag()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("plateName")) != null) setPlateName(__getString(val));
		if((val = values.get("advanceIntegral")) != null) setAdvanceIntegral(__getDecimal(val));  
		if((val = values.get("remainingIntegral")) != null) setRemainingIntegral(__getDecimal(val));  
		if((val = values.get("assignedIntegral")) != null) setAssignedIntegral(__getDecimal(val));  
		if((val = values.get("flag")) != null) setFlag(__getInt(val)); 
	}

	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.String  __plate_name ;
	protected java.math.BigDecimal  __advance_integral ;
	protected java.math.BigDecimal  __remaining_integral ;
	protected java.math.BigDecimal  __assigned_integral ;
	protected java.lang.Integer  __flag ;
}
