package pomplatform.ht.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionMainProject extends GenericCondition{

	public ConditionMainProject(){
		setParameterCount(9);
	}

	public java.lang.String getProjectCode() {
		return this.__project_code == null ? null : (this.__project_code.indexOf("%") >= 0 ? this.__project_code : "%"+this.__project_code+"%");
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name == null ? null : (this.__project_name.indexOf("%") >= 0 ? this.__project_name : "%"+this.__project_name+"%");
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.Boolean getHasContract() {
		return this.__has_contract;
	}

	public void setHasContract( java.lang.Boolean value ) {
		this.__has_contract = value;
	}

	public java.lang.Integer getProjectBaseOn() {
		return this.__project_base_on;
	}

	public void setProjectBaseOn( java.lang.Integer value ) {
		this.__project_base_on = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code == null ? null : (this.__info_code.indexOf("%") >= 0 ? this.__info_code : "%"+this.__info_code+"%");
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.Integer getDesignTeam() {
		return this.__design_team;
	}

	public void setDesignTeam( java.lang.Integer value ) {
		this.__design_team = value;
	}

	public java.lang.String getLeader() {
		return this.__leader == null ? null : (this.__leader.indexOf("%") >= 0 ? this.__leader : "%"+this.__leader+"%");
	}

	public void setLeader( java.lang.String value ) {
		this.__leader = value;
	}

	public java.lang.String getSecretary() {
		return this.__secretary == null ? null : (this.__secretary.indexOf("%") >= 0 ? this.__secretary : "%"+this.__secretary+"%");
	}

	public void setSecretary( java.lang.String value ) {
		this.__secretary = value;
	}

	public java.lang.String getChargePerson() {
		return this.__charge_person == null ? null : (this.__charge_person.indexOf("%") >= 0 ? this.__charge_person : "%"+this.__charge_person+"%");
	}

	public void setChargePerson( java.lang.String value ) {
		this.__charge_person = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectCode() != null) sb.append(__wrapString(1, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(1, "projectName", getProjectName()));
		if(getHasContract() != null) sb.append(__wrapBoolean(1, "hasContract", getHasContract()));
		if(getProjectBaseOn() != null) sb.append(__wrapNumber(1, "projectBaseOn", getProjectBaseOn()));
		if(getInfoCode() != null) sb.append(__wrapString(1, "infoCode", getInfoCode()));
		if(getDesignTeam() != null) sb.append(__wrapNumber(1, "designTeam", getDesignTeam()));
		if(getLeader() != null) sb.append(__wrapString(1, "leader", getLeader()));
		if(getSecretary() != null) sb.append(__wrapString(1, "secretary", getSecretary()));
		if(getChargePerson() != null) sb.append(__wrapString(1, "chargePerson", getChargePerson()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("hasContract")) != null) setHasContract(__getBoolean(val));
		if((val = values.get("projectBaseOn")) != null) setProjectBaseOn(__getInt(val));
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("designTeam")) != null) setDesignTeam(__getInt(val));
		if((val = values.get("leader")) != null) setLeader(__getString(val));
		if((val = values.get("secretary")) != null) setSecretary(__getString(val));
		if((val = values.get("chargePerson")) != null) setChargePerson(__getString(val));
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getProjectCode() != null) res.add("projectCode");
		if(getProjectName() != null) res.add("projectName");
		if(getHasContract() != null) res.add("hasContract");
		if(getProjectBaseOn() != null) res.add("projectBaseOn");
		if(getInfoCode() != null) res.add("infoCode");
		if(getDesignTeam() != null) res.add("designTeam");
		if(getLeader() != null) res.add("leader");
		if(getSecretary() != null) res.add("secretary");
		if(getChargePerson() != null) res.add("chargePerson");
		return res;
	}

	private java.lang.String __project_code = null;
	private java.lang.String __project_name = null;
	private java.lang.Boolean __has_contract = null;
	private java.lang.Integer __project_base_on = null;
	private java.lang.String __info_code = null;
	private java.lang.Integer __design_team = null;
	private java.lang.String __leader = null;
	private java.lang.String __secretary = null;
	private java.lang.String __charge_person = null;
}

