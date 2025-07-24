package pomplatform.sealKeepers.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BasesealKeepersWorkflow extends GenericBase implements BaseFactory<BasesealKeepersWorkflow>, Comparable<BasesealKeepersWorkflow> 
{


	public static BasesealKeepersWorkflow newInstance(){
		return new BasesealKeepersWorkflow();
	}

	@Override
	public BasesealKeepersWorkflow make(){
		BasesealKeepersWorkflow b = new BasesealKeepersWorkflow();
		return b;
	}

	public final static java.lang.String CS_SEAL_KEEPER_ID = "seal_keeper_id" ;
	public final static java.lang.String CS_SEAL_NAME = "seal_name" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_CREAT_TIME = "creat_time" ;
	public final static java.lang.String CS_OPERATOR_ID = "operator_id" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_NUMBER = "number" ;
	public final static java.lang.String CS_SEAL_TYPE = "seal_type" ;
	public final static java.lang.String CS_REMARKS = "remarks" ;

	public final static java.lang.String ALL_CAPTIONS = "id,印章名称,保管员,创建时间,操作人,删除标志 0未删除 1已删除,归属公司,数量,印章类型,备注";

	public java.lang.Integer getSealKeeperId() {
		return this.__seal_keeper_id;
	}

	public void setSealKeeperId( java.lang.Integer value ) {
		this.__seal_keeper_id = value;
	}

	public java.lang.String getSealName() {
		return this.__seal_name;
	}

	public void setSealName( java.lang.String value ) {
		this.__seal_name = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.util.Date getCreatTime() {
		return this.__creat_time;
	}

	public void setCreatTime( java.util.Date value ) {
		this.__creat_time = value;
	}

	public java.lang.Integer getOperatorId() {
		return this.__operator_id;
	}

	public void setOperatorId( java.lang.Integer value ) {
		this.__operator_id = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getNumber() {
		return this.__number;
	}

	public void setNumber( java.lang.Integer value ) {
		this.__number = value;
	}

	public java.lang.Integer getSealType() {
		return this.__seal_type;
	}

	public void setSealType( java.lang.Integer value ) {
		this.__seal_type = value;
	}

	public java.lang.String getRemarks() {
		return this.__remarks;
	}

	public void setRemarks( java.lang.String value ) {
		this.__remarks = value;
	}

	public void cloneCopy(BasesealKeepersWorkflow __bean){
		__bean.setSealKeeperId(getSealKeeperId());
		__bean.setSealName(getSealName());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setCreatTime(getCreatTime());
		__bean.setOperatorId(getOperatorId());
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setCompanyId(getCompanyId());
		__bean.setNumber(getNumber());
		__bean.setSealType(getSealType());
		__bean.setRemarks(getRemarks());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSealKeeperId() == null ? "" : getSealKeeperId());
		sb.append(",");
		sb.append(getSealName() == null ? "" : getSealName());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getCreatTime() == null ? "" : sdf.format(getCreatTime()));
		sb.append(",");
		sb.append(getOperatorId() == null ? "" : getOperatorId());
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		sb.append(",");
		sb.append(getNumber() == null ? "" : getNumber());
		sb.append(",");
		sb.append(getSealType() == null ? "" : getSealType());
		sb.append(",");
		sb.append(getRemarks() == null ? "" : getRemarks());
		return sb.toString();
	}

	@Override
	public int compareTo(BasesealKeepersWorkflow o) {
		return __seal_keeper_id == null ? -1 : __seal_keeper_id.compareTo(o.getSealKeeperId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__seal_keeper_id);
		hash = 97 * hash + Objects.hashCode(this.__seal_name);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__creat_time);
		hash = 97 * hash + Objects.hashCode(this.__operator_id);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__number);
		hash = 97 * hash + Objects.hashCode(this.__seal_type);
		hash = 97 * hash + Objects.hashCode(this.__remarks);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasesealKeepersWorkflow o = (BasesealKeepersWorkflow)obj;
		if(!Objects.equals(this.__seal_keeper_id, o.getSealKeeperId())) return false;
		if(!Objects.equals(this.__seal_name, o.getSealName())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__creat_time, o.getCreatTime())) return false;
		if(!Objects.equals(this.__operator_id, o.getOperatorId())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__number, o.getNumber())) return false;
		if(!Objects.equals(this.__seal_type, o.getSealType())) return false;
		if(!Objects.equals(this.__remarks, o.getRemarks())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSealKeeperId() != null) sb.append(__wrapNumber(count++, "sealKeeperId", getSealKeeperId()));
		if(getSealName() != null) sb.append(__wrapString(count++, "sealName", getSealName()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getCreatTime() != null) sb.append(__wrapDate(count++, "creatTime", getCreatTime()));
		if(getOperatorId() != null) sb.append(__wrapNumber(count++, "operatorId", getOperatorId()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getNumber() != null) sb.append(__wrapNumber(count++, "number", getNumber()));
		if(getSealType() != null) sb.append(__wrapNumber(count++, "sealType", getSealType()));
		if(getRemarks() != null) sb.append(__wrapString(count++, "remarks", getRemarks()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getSealKeeperId() != null) res.put("sealKeeperId", getSealKeeperId());
		if(getSealName() != null) res.put("sealName", getSealName());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getCreatTime() != null) res.put("creatTime", getCreatTime());
		if(getOperatorId() != null) res.put("operatorId", getOperatorId());
		if(getDeleteFlag() != null) res.put("deleteFlag", getDeleteFlag());
		if(getCompanyId() != null) res.put("companyId", getCompanyId());
		if(getNumber() != null) res.put("number", getNumber());
		if(getSealType() != null) res.put("sealType", getSealType());
		if(getRemarks() != null) res.put("remarks", getRemarks());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("sealKeeperId")) != null) setSealKeeperId(__getInt(val)); 
		if((val = values.get("sealName")) != null) setSealName(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("creatTime")) != null) setCreatTime(__getDate(val)); 
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("number")) != null) setNumber(__getInt(val)); 
		if((val = values.get("sealType")) != null) setSealType(__getInt(val)); 
		if((val = values.get("remarks")) != null) setRemarks(__getString(val));
	}

	protected java.lang.Integer  __seal_keeper_id ;
	protected java.lang.String  __seal_name ;
	protected java.lang.Integer  __employee_id ;
	protected java.util.Date  __creat_time ;
	protected java.lang.Integer  __operator_id ;
	protected java.lang.Integer  __delete_flag ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __number ;
	protected java.lang.Integer  __seal_type ;
	protected java.lang.String  __remarks ;
}
