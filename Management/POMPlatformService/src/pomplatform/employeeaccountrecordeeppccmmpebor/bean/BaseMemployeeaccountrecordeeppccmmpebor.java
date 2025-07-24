package pomplatform.employeeaccountrecordeeppccmmpebor.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMemployeeaccountrecordeeppccmmpebor extends GenericBase implements BaseFactory<BaseMemployeeaccountrecordeeppccmmpebor>, Comparable<BaseMemployeeaccountrecordeeppccmmpebor> 
{


	public static BaseMemployeeaccountrecordeeppccmmpebor newInstance(){
		return new BaseMemployeeaccountrecordeeppccmmpebor();
	}

	@Override
	public BaseMemployeeaccountrecordeeppccmmpebor make(){
		BaseMemployeeaccountrecordeeppccmmpebor b = new BaseMemployeeaccountrecordeeppccmmpebor();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_SHEET_CODE = "sheet_code" ;
	public final static java.lang.String CS_SHEET_NAME = "sheet_name" ;
	public final static java.lang.String CS_INTEGRAL = "integral" ;
	public final static java.lang.String CS_PROJECT_FLAG = "project_flag" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_SHEET_AMOUNT = "sheet_amount" ;
	public final static java.lang.String CS_EMPLOYEE_ACCOUNT_RECORD_ID = "employee_account_record_id" ;
	public final static java.lang.String CS_MONEY = "money" ;
	public final static java.lang.String CS_PERCENTE = "percente" ;
	public final static java.lang.String CS_CONFIRM_INTEGRAL = "confirm_integral" ;

	public final static java.lang.String ALL_CAPTIONS = "职员编码,员工编号,员工姓名,项目编号,项目名称,积分,2研发项目),项目代码,订单金额,主键编码,回款总金额金额,回款百分比,真实积分";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.String getSheetCode() {
		return this.__sheet_code;
	}

	public void setSheetCode( java.lang.String value ) {
		this.__sheet_code = value;
	}

	public java.lang.String getSheetName() {
		return this.__sheet_name;
	}

	public void setSheetName( java.lang.String value ) {
		this.__sheet_name = value;
	}

	public java.math.BigDecimal getIntegral() {
		return this.__integral;
	}

	public void setIntegral( java.math.BigDecimal value ) {
		this.__integral = value;
	}

	public java.lang.Integer getProjectFlag() {
		return this.__project_flag;
	}

	public void setProjectFlag( java.lang.Integer value ) {
		this.__project_flag = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.math.BigDecimal getSheetAmount() {
		return this.__sheet_amount;
	}

	public void setSheetAmount( java.math.BigDecimal value ) {
		this.__sheet_amount = value;
	}

	public java.lang.Integer getEmployeeAccountRecordId() {
		return this.__employee_account_record_id;
	}

	public void setEmployeeAccountRecordId( java.lang.Integer value ) {
		this.__employee_account_record_id = value;
	}

	public java.math.BigDecimal getMoney() {
		return this.__money;
	}

	public void setMoney( java.math.BigDecimal value ) {
		this.__money = value;
	}

	public java.math.BigDecimal getPercente() {
		return this.__percente;
	}

	public void setPercente( java.math.BigDecimal value ) {
		this.__percente = value;
	}

	public java.math.BigDecimal getConfirmIntegral() {
		return this.__confirm_integral;
	}

	public void setConfirmIntegral( java.math.BigDecimal value ) {
		this.__confirm_integral = value;
	}

	public void cloneCopy(BaseMemployeeaccountrecordeeppccmmpebor __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setSheetCode(getSheetCode());
		__bean.setSheetName(getSheetName());
		__bean.setIntegral(getIntegral());
		__bean.setProjectFlag(getProjectFlag());
		__bean.setProjectId(getProjectId());
		__bean.setSheetAmount(getSheetAmount());
		__bean.setEmployeeAccountRecordId(getEmployeeAccountRecordId());
		__bean.setMoney(getMoney());
		__bean.setPercente(getPercente());
		__bean.setConfirmIntegral(getConfirmIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getSheetCode() == null ? "" : getSheetCode());
		sb.append(",");
		sb.append(getSheetName() == null ? "" : getSheetName());
		sb.append(",");
		sb.append(getIntegral() == null ? "" : getIntegral());
		sb.append(",");
		sb.append(getProjectFlag() == null ? "" : getProjectFlag());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getSheetAmount() == null ? "" : getSheetAmount());
		sb.append(",");
		sb.append(getEmployeeAccountRecordId() == null ? "" : getEmployeeAccountRecordId());
		sb.append(",");
		sb.append(getMoney() == null ? "" : getMoney());
		sb.append(",");
		sb.append(getPercente() == null ? "" : getPercente());
		sb.append(",");
		sb.append(getConfirmIntegral() == null ? "" : getConfirmIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMemployeeaccountrecordeeppccmmpebor o) {
		return __employee_account_record_id == null ? -1 : __employee_account_record_id.compareTo(o.getEmployeeAccountRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__sheet_code);
		hash = 97 * hash + Objects.hashCode(this.__sheet_name);
		hash = 97 * hash + Objects.hashCode(this.__integral);
		hash = 97 * hash + Objects.hashCode(this.__project_flag);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__sheet_amount);
		hash = 97 * hash + Objects.hashCode(this.__employee_account_record_id);
		hash = 97 * hash + Objects.hashCode(this.__money);
		hash = 97 * hash + Objects.hashCode(this.__percente);
		hash = 97 * hash + Objects.hashCode(this.__confirm_integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMemployeeaccountrecordeeppccmmpebor o = (BaseMemployeeaccountrecordeeppccmmpebor)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__sheet_code, o.getSheetCode())) return false;
		if(!Objects.equals(this.__sheet_name, o.getSheetName())) return false;
		if(!Objects.equals(this.__integral, o.getIntegral())) return false;
		if(!Objects.equals(this.__project_flag, o.getProjectFlag())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__sheet_amount, o.getSheetAmount())) return false;
		if(!Objects.equals(this.__employee_account_record_id, o.getEmployeeAccountRecordId())) return false;
		if(!Objects.equals(this.__money, o.getMoney())) return false;
		if(!Objects.equals(this.__percente, o.getPercente())) return false;
		if(!Objects.equals(this.__confirm_integral, o.getConfirmIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getSheetCode() != null) sb.append(__wrapString(count++, "sheetCode", getSheetCode()));
		if(getSheetName() != null) sb.append(__wrapString(count++, "sheetName", getSheetName()));
		if(getIntegral() != null) sb.append(__wrapDecimal(count++, "integral", getIntegral()));
		if(getProjectFlag() != null) sb.append(__wrapNumber(count++, "projectFlag", getProjectFlag()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getSheetAmount() != null) sb.append(__wrapDecimal(count++, "sheetAmount", getSheetAmount()));
		if(getEmployeeAccountRecordId() != null) sb.append(__wrapNumber(count++, "employeeAccountRecordId", getEmployeeAccountRecordId()));
		if(getMoney() != null) sb.append(__wrapDecimal(count++, "money", getMoney()));
		if(getPercente() != null) sb.append(__wrapDecimal(count++, "percente", getPercente()));
		if(getConfirmIntegral() != null) sb.append(__wrapDecimal(count++, "confirmIntegral", getConfirmIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("sheetCode")) != null) setSheetCode(__getString(val));
		if((val = values.get("sheetName")) != null) setSheetName(__getString(val));
		if((val = values.get("integral")) != null) setIntegral(__getDecimal(val));  
		if((val = values.get("projectFlag")) != null) setProjectFlag(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("sheetAmount")) != null) setSheetAmount(__getDecimal(val));  
		if((val = values.get("employeeAccountRecordId")) != null) setEmployeeAccountRecordId(__getInt(val)); 
		if((val = values.get("money")) != null) setMoney(__getDecimal(val));  
		if((val = values.get("percente")) != null) setPercente(__getDecimal(val));  
		if((val = values.get("confirmIntegral")) != null) setConfirmIntegral(__getDecimal(val));  
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.String  __sheet_code ;
	protected java.lang.String  __sheet_name ;
	protected java.math.BigDecimal  __integral ;
	protected java.lang.Integer  __project_flag ;
	protected java.lang.Integer  __project_id ;
	protected java.math.BigDecimal  __sheet_amount ;
	protected java.lang.Integer  __employee_account_record_id ;
	protected java.math.BigDecimal  __money ;
	protected java.math.BigDecimal  __percente ;
	protected java.math.BigDecimal  __confirm_integral ;
}
