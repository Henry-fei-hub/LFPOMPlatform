package pomplatform.attachment.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMprojectccpor extends GenericBase implements BaseFactory<BaseMprojectccpor>, Comparable<BaseMprojectccpor> 
{


	public static BaseMprojectccpor newInstance(){
		return new BaseMprojectccpor();
	}

	@Override
	public BaseMprojectccpor make(){
		BaseMprojectccpor b = new BaseMprojectccpor();
		return b;
	}

	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_PROJECT_INTEGRAL = "project_integral" ;
	public final static java.lang.String CS_MONEY = "money" ;
	public final static java.lang.String CS_SHEET_AMOUNT = "sheet_amount" ;
	public final static java.lang.String CS_CONFIRM_PROJECT_INTEGRAL = "confirm_project_integral" ;

	public final static java.lang.String ALL_CAPTIONS = "项目编码,项目积分,金额,订单合同金额,订单可分配积分";

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.math.BigDecimal getProjectIntegral() {
		return this.__project_integral;
	}

	public void setProjectIntegral( java.math.BigDecimal value ) {
		this.__project_integral = value;
	}

	public java.math.BigDecimal getMoney() {
		return this.__money;
	}

	public void setMoney( java.math.BigDecimal value ) {
		this.__money = value;
	}

	public java.math.BigDecimal getSheetAmount() {
		return this.__sheet_amount;
	}

	public void setSheetAmount( java.math.BigDecimal value ) {
		this.__sheet_amount = value;
	}

	public java.math.BigDecimal getConfirmProjectIntegral() {
		return this.__confirm_project_integral;
	}

	public void setConfirmProjectIntegral( java.math.BigDecimal value ) {
		this.__confirm_project_integral = value;
	}

	public void cloneCopy(BaseMprojectccpor __bean){
		__bean.setProjectId(getProjectId());
		__bean.setProjectIntegral(getProjectIntegral());
		__bean.setMoney(getMoney());
		__bean.setSheetAmount(getSheetAmount());
		__bean.setConfirmProjectIntegral(getConfirmProjectIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getProjectIntegral() == null ? "" : getProjectIntegral());
		sb.append(",");
		sb.append(getMoney() == null ? "" : getMoney());
		sb.append(",");
		sb.append(getSheetAmount() == null ? "" : getSheetAmount());
		sb.append(",");
		sb.append(getConfirmProjectIntegral() == null ? "" : getConfirmProjectIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMprojectccpor o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__project_integral);
		hash = 97 * hash + Objects.hashCode(this.__money);
		hash = 97 * hash + Objects.hashCode(this.__sheet_amount);
		hash = 97 * hash + Objects.hashCode(this.__confirm_project_integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMprojectccpor o = (BaseMprojectccpor)obj;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__project_integral, o.getProjectIntegral())) return false;
		if(!Objects.equals(this.__money, o.getMoney())) return false;
		if(!Objects.equals(this.__sheet_amount, o.getSheetAmount())) return false;
		if(!Objects.equals(this.__confirm_project_integral, o.getConfirmProjectIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getProjectIntegral() != null) sb.append(__wrapDecimal(count++, "projectIntegral", getProjectIntegral()));
		if(getMoney() != null) sb.append(__wrapDecimal(count++, "money", getMoney()));
		if(getSheetAmount() != null) sb.append(__wrapDecimal(count++, "sheetAmount", getSheetAmount()));
		if(getConfirmProjectIntegral() != null) sb.append(__wrapDecimal(count++, "confirmProjectIntegral", getConfirmProjectIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("projectIntegral")) != null) setProjectIntegral(__getDecimal(val));  
		if((val = values.get("money")) != null) setMoney(__getDecimal(val));  
		if((val = values.get("sheetAmount")) != null) setSheetAmount(__getDecimal(val));  
		if((val = values.get("confirmProjectIntegral")) != null) setConfirmProjectIntegral(__getDecimal(val));  
	}

	protected java.lang.Integer  __project_id ;
	protected java.math.BigDecimal  __project_integral ;
	protected java.math.BigDecimal  __money ;
	protected java.math.BigDecimal  __sheet_amount ;
	protected java.math.BigDecimal  __confirm_project_integral ;
}
