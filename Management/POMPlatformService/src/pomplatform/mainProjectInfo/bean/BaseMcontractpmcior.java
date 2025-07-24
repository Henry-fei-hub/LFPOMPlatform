package pomplatform.mainProjectInfo.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMcontractpmcior extends GenericBase implements BaseFactory<BaseMcontractpmcior>, Comparable<BaseMcontractpmcior> 
{


	public static BaseMcontractpmcior newInstance(){
		return new BaseMcontractpmcior();
	}

	@Override
	public BaseMcontractpmcior make(){
		BaseMcontractpmcior b = new BaseMcontractpmcior();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_DESIGN_TEAM = "design_team" ;
	public final static java.lang.String CS_CUSTOMER_NAME = "customer_name" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主订单编码,信息编号,项目编码,项目编号,项目名称,主办设计团队,客户名称,主键编码";

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.Integer getDesignTeam() {
		return this.__design_team;
	}

	public void setDesignTeam( java.lang.Integer value ) {
		this.__design_team = value;
	}

	public java.lang.String getCustomerName() {
		return this.__customer_name;
	}

	public void setCustomerName( java.lang.String value ) {
		this.__customer_name = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public void cloneCopy(BaseMcontractpmcior __bean){
		__bean.setContractId(getContractId());
		__bean.setInfoCode(getInfoCode());
		__bean.setProjectId(getProjectId());
		__bean.setProjectCode(getProjectCode());
		__bean.setProjectName(getProjectName());
		__bean.setDesignTeam(getDesignTeam());
		__bean.setCustomerName(getCustomerName());
		__bean.setMainProjectId(getMainProjectId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getDesignTeam() == null ? "" : getDesignTeam());
		sb.append(",");
		sb.append(getCustomerName() == null ? "" : getCustomerName());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMcontractpmcior o) {
		return __contract_id == null ? -1 : __contract_id.compareTo(o.getContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__design_team);
		hash = 97 * hash + Objects.hashCode(this.__customer_name);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMcontractpmcior o = (BaseMcontractpmcior)obj;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__design_team, o.getDesignTeam())) return false;
		if(!Objects.equals(this.__customer_name, o.getCustomerName())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getDesignTeam() != null) sb.append(__wrapNumber(count++, "designTeam", getDesignTeam()));
		if(getCustomerName() != null) sb.append(__wrapString(count++, "customerName", getCustomerName()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getInfoCode() != null) res.put("infoCode", getInfoCode());
		if(getProjectId() != null) res.put("projectId", getProjectId());
		if(getProjectCode() != null) res.put("projectCode", getProjectCode());
		if(getProjectName() != null) res.put("projectName", getProjectName());
		if(getDesignTeam() != null) res.put("designTeam", getDesignTeam());
		if(getCustomerName() != null) res.put("customerName", getCustomerName());
		if(getMainProjectId() != null) res.put("mainProjectId", getMainProjectId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("designTeam")) != null) setDesignTeam(__getInt(val)); 
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
	}

	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __info_code ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.Integer  __design_team ;
	protected java.lang.String  __customer_name ;
	protected java.lang.Integer  __main_project_id ;
}
