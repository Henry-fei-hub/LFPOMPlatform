package pomplatform.mainProjectInfo.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMmainprojectclientccmor extends GenericCondition{

	public ConditionMmainprojectclientccmor(){
		setParameterCount(3);
	}

	public java.lang.Integer getClientRole() {
		return this.__client_role;
	}

	public void setClientRole( java.lang.Integer value ) {
		this.__client_role = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}
        
        public java.lang.String getClientName() {
		return this.__client_name == null ? null : (this.__client_name.indexOf("%") >= 0 ? this.__client_name : "%"+this.__client_name+"%");
	}

	public void setClientName( java.lang.String value ) {
		this.__client_name = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getClientRole() != null) sb.append(__wrapNumber(1, "clientRole", getClientRole()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(1, "mainProjectId", getMainProjectId()));
                if(getClientName() != null) sb.append(__wrapString(1, "clientName", getClientName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("clientRole")) != null) setClientRole(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
                if((val = values.get("clientName")) != null) setClientName(__getString(val));
	}

	private java.lang.Integer __client_role = null;
	private java.lang.Integer __main_project_id = null;
        private java.lang.String __client_name = null;
}

