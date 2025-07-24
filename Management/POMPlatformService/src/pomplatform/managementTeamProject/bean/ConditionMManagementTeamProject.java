package pomplatform.managementTeamProject.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMManagementTeamProject extends GenericCondition {

    public ConditionMManagementTeamProject() {
        setParameterCount(6);
    }

    public java.lang.Integer getProjectId() {
        return this.__project_id;
    }

    public void setProjectId(java.lang.Integer value) {
        this.__project_id = value;
    }

    public java.lang.Integer getDepartmentId() {
        return this.__department_id;
    }

    public void setDepartmentId(java.lang.Integer value) {
        this.__department_id = value;
    }

    public java.lang.Integer getProjectType() {
        return this.__project_type;
    }

    public void setProjectType(java.lang.Integer value) {
        this.__project_type = value;
    }

    public java.lang.Integer getStatus() {
        return this.__status;
    }

    public void setStatus(java.lang.Integer value) {
        this.__status = value;
    }

    public java.lang.String getProjectName() {
        return this.__project_name == null ? null : (this.__project_name.indexOf("%") >= 0 ? this.__project_name : "%"+this.__project_name+"%");
    }

    public void setProjectName(java.lang.String value) {
        this.__project_name = value;
    }
    
    public java.lang.String getContractCode() {
        return this.__contract_code == null ? null : this.__contract_code;
    }

    public void setContractCode(java.lang.String value) {
        this.__contract_code = value;
    }

    @Override
    public java.lang.String toJSONString() {

        StringBuilder sb = new StringBuilder();
        sb.append(super.toJSONString());
        if (getProjectId() != null) {
            sb.append(__wrapNumber(1, "projectId", getProjectId()));
        }
        if (getDepartmentId() != null) {
            sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
        }
        if (getProjectType() != null) {
            sb.append(__wrapNumber(1, "projectType", getProjectType()));
        }
        if (getStatus() != null) {
            sb.append(__wrapNumber(1, "status", getStatus()));
        }
        if (getProjectName() != null) {
            sb.append(__wrapString(1, "projectName", getProjectName()));
        }
        if(getContractCode() != null) {
            sb.append(__wrapString(1, "contractCode", getContractCode()));
        }
        return sb.toString();
    }

    @Override
    public void setDataFromMap(Map<String, Object> values) {
        super.setDataFromMap(values);
        Object val;
        if ((val = values.get("projectId")) != null) {
            setProjectId(__getInt(val));
        }
        if ((val = values.get("departmentId")) != null) {
            setDepartmentId(__getInt(val));
        }
        if ((val = values.get("projectType")) != null) {
            setProjectType(__getInt(val));
        }
        if ((val = values.get("status")) != null) {
            setStatus(__getInt(val));
        }
        if ((val = values.get("projectName")) != null) {
            setProjectName(__getString(val));
        }
        if((val = values.get("contractCode")) != null){
            setContractCode(__getString(val));
        }
    }

    private java.lang.Integer __project_id = null;
    private java.lang.Integer __department_id = null;
    private java.lang.Integer __project_type = null;
    private java.lang.Integer __status = null;
    private java.lang.String __project_name = null;
    private java.lang.String __contract_code = null;

}
