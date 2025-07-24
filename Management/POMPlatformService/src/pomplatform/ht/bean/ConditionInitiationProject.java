package pomplatform.ht.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionInitiationProject extends GenericCondition{

	public ConditionInitiationProject(){
		setParameterCount(10);
	}

	public String getProjectCode() {
		return this.__project_code == null ? null : (this.__project_code.indexOf("%") >= 0 ? this.__project_code : "%"+this.__project_code+"%");
	}

	public void setProjectCode( String value ) {
		this.__project_code = value;
	}

	public String getProjectName() {
		return this.__project_name == null ? null : (this.__project_name.indexOf("%") >= 0 ? this.__project_name : "%"+this.__project_name+"%");
	}

	public void setProjectName( String value ) {
		this.__project_name = value;
	}

	public Boolean getHasContract() {
		return this.__has_contract;
	}

	public void setHasContract( Boolean value ) {
		this.__has_contract = value;
	}

	public Integer getProjectBaseOn() {
		return this.__project_base_on;
	}

	public void setProjectBaseOn( Integer value ) {
		this.__project_base_on = value;
	}

	public String getInfoCode() {
		return this.__info_code == null ? null : (this.__info_code.indexOf("%") >= 0 ? this.__info_code : "%"+this.__info_code+"%");
	}

	public void setInfoCode( String value ) {
		this.__info_code = value;
	}

	public String getDesignTeam() {
		return this.__design_team == null ? null : (this.__design_team.indexOf("%") >= 0 ? this.__design_team : "%"+this.__design_team+"%");
	}

	public void setDesignTeam( String value ) {
		this.__design_team = value;
	}

	public String getLeader() {
		return this.__leader == null ? null : (this.__leader.indexOf("%") >= 0 ? this.__leader : "%"+this.__leader+"%");
	}

	public void setLeader( String value ) {
		this.__leader = value;
	}

	public String getSecretary() {
		return this.__secretary == null ? null : (this.__secretary.indexOf("%") >= 0 ? this.__secretary : "%"+this.__secretary+"%");
	}

	public void setSecretary( String value ) {
		this.__secretary = value;
	}

	public String getManager() {
		return this.__manager == null ? null : (this.__manager.indexOf("%") >= 0 ? this.__manager : "%"+this.__manager+"%");
	}

	public void setManager( String value ) {
		this.__manager = value;
	}

	public String getChargePerson() {
		return this.__charge_person == null ? null : (this.__charge_person.indexOf("%") >= 0 ? this.__charge_person : "%"+this.__charge_person+"%");
	}

	public void setChargePerson( String value ) {
		this.__charge_person = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectCode() != null) sb.append(__wrapString(1, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(1, "projectName", getProjectName()));
		if(getHasContract() != null) sb.append(__wrapBoolean(1, "hasContract", getHasContract()));
		if(getProjectBaseOn() != null) sb.append(__wrapNumber(1, "projectBaseOn", getProjectBaseOn()));
		if(getInfoCode() != null) sb.append(__wrapString(1, "infoCode", getInfoCode()));
		if(getDesignTeam() != null) sb.append(__wrapString(1, "designTeam", getDesignTeam()));
		if(getLeader() != null) sb.append(__wrapString(1, "leader", getLeader()));
		if(getSecretary() != null) sb.append(__wrapString(1, "secretary", getSecretary()));
		if(getManager() != null) sb.append(__wrapString(1, "manager", getManager()));
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
		if((val = values.get("designTeam")) != null) setDesignTeam(__getString(val));
		if((val = values.get("leader")) != null) setLeader(__getString(val));
		if((val = values.get("secretary")) != null) setSecretary(__getString(val));
		if((val = values.get("manager")) != null) setManager(__getString(val));
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
		if(getManager() != null) res.add("manager");
		if(getChargePerson() != null) res.add("chargePerson");
		return res;
	}

	private String __project_code = null;
	private String __project_name = null;
	private Boolean __has_contract = null;
	private Integer __project_base_on = null;
	private String __info_code = null;
	private String __design_team = null;
	private String __leader = null;
	private String __secretary = null;
	private String __manager = null;
	private String __charge_person = null;
}

