package pomplatform.reimbursement.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BasePreProjectTravelRemarkAndAmount extends GenericBase implements BaseFactory<BasePreProjectTravelRemarkAndAmount>, Comparable<BasePreProjectTravelRemarkAndAmount> 
{


	public static BasePreProjectTravelRemarkAndAmount newInstance(){
		return new BasePreProjectTravelRemarkAndAmount();
	}

	@Override
	public BasePreProjectTravelRemarkAndAmount make(){
		BasePreProjectTravelRemarkAndAmount b = new BasePreProjectTravelRemarkAndAmount();
		return b;
	}

	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_FINAL_AMOUNT = "final_amount" ;
	public final static java.lang.String CS_INPUT_TAX = "input_tax" ;
	public final static java.lang.String CS_INPUT_TAX_REBATE = "input_tax_rebate" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "项目,成本,进项税,进项税转出金额,备注";

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.math.BigDecimal getFinalAmount() {
		return this.__final_amount;
	}

	public void setFinalAmount( java.math.BigDecimal value ) {
		this.__final_amount = value;
	}

	public java.math.BigDecimal getInputTax() {
		return this.__input_tax;
	}

	public void setInputTax( java.math.BigDecimal value ) {
		this.__input_tax = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.math.BigDecimal getInputTaxRebate() {
		return __input_tax_rebate;
	}

	public void setInputTaxRebate(java.math.BigDecimal value) {
		this.__input_tax_rebate = value;
	}

	public void cloneCopy(BasePreProjectTravelRemarkAndAmount __bean){
		__bean.setMainProjectId(getMainProjectId());
		__bean.setFinalAmount(getFinalAmount());
		__bean.setInputTax(getInputTax());
		__bean.setInputTaxRebate(getInputTaxRebate());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getFinalAmount() == null ? "" : getFinalAmount());
		sb.append(",");
		sb.append(getInputTax() == null ? "" : getInputTax());
		sb.append(",");
		sb.append(getInputTaxRebate() == null ? "" : getInputTaxRebate());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePreProjectTravelRemarkAndAmount o) {
		return __main_project_id == null ? -1 : __main_project_id.compareTo(o.getMainProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__final_amount);
		hash = 97 * hash + Objects.hashCode(this.__input_tax);
		hash = 97 * hash + Objects.hashCode(this.__input_tax_rebate);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePreProjectTravelRemarkAndAmount o = (BasePreProjectTravelRemarkAndAmount)obj;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__final_amount, o.getFinalAmount())) return false;
		if(!Objects.equals(this.__input_tax, o.getInputTax())) return false;
		if(!Objects.equals(this.__input_tax_rebate, o.getInputTaxRebate())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getFinalAmount() != null) sb.append(__wrapDecimal(count++, "finalAmount", getFinalAmount()));
		if(getInputTax() != null) sb.append(__wrapDecimal(count++, "inputTax", getInputTax()));
		if(getInputTaxRebate() != null) sb.append(__wrapDecimal(count++, "inputTaxRebate", getInputTaxRebate()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("finalAmount")) != null) setFinalAmount(__getDecimal(val));  
		if((val = values.get("inputTax")) != null) setInputTax(__getDecimal(val));  
		if((val = values.get("inputTaxRebate")) != null) setInputTaxRebate(__getDecimal(val));  
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __main_project_id ;
	protected java.math.BigDecimal  __final_amount ;
	protected java.math.BigDecimal  __input_tax ;
	protected java.math.BigDecimal  __input_tax_rebate ;
	protected java.lang.String  __remark ;
}
