package pomplatform.reimbursement.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseCommonNormalRemarkAndAmount extends GenericBase implements BaseFactory<BaseCommonNormalRemarkAndAmount>, Comparable<BaseCommonNormalRemarkAndAmount> 
{


	public static BaseCommonNormalRemarkAndAmount newInstance(){
		return new BaseCommonNormalRemarkAndAmount();
	}

	@Override
	public BaseCommonNormalRemarkAndAmount make(){
		BaseCommonNormalRemarkAndAmount b = new BaseCommonNormalRemarkAndAmount();
		return b;
	}

	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_INPUT_TAX = "input_tax" ;
	public final static java.lang.String CS_FINAL_AMOUNT = "final_amount" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "报销部门,报销总金额,进项税,成本,备注";

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.math.BigDecimal getInputTax() {
		return this.__input_tax;
	}

	public void setInputTax( java.math.BigDecimal value ) {
		this.__input_tax = value;
	}

	public java.math.BigDecimal getFinalAmount() {
		return this.__final_amount;
	}

	public void setFinalAmount( java.math.BigDecimal value ) {
		this.__final_amount = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getMainItemId() {
		return __main_item_id;
	}

	public void setMainItemId(java.lang.Integer value) {
		this.__main_item_id = value;
	}

	public java.lang.Integer getSubItemId() {
		return __sub_item_id;
	}

	public void setSubItemId(java.lang.Integer value) {
		this.__sub_item_id = value;
	}

	public java.math.BigDecimal getInputTaxRebate() {
		return __input_tax_rebate;
	}

	public void setInputTaxRebate(java.math.BigDecimal value) {
		this.__input_tax_rebate = value;
	}

	public void cloneCopy(BaseCommonNormalRemarkAndAmount __bean){
		__bean.setDepartmentId(getDepartmentId());
		__bean.setAmount(getAmount());
		__bean.setInputTax(getInputTax());
		__bean.setFinalAmount(getFinalAmount());
		__bean.setRemark(getRemark());
		__bean.setMainItemId(getMainItemId());
		__bean.setSubItemId(getSubItemId());
		__bean.setInputTaxRebate(getInputTaxRebate());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getInputTax() == null ? "" : getInputTax());
		sb.append(",");
		sb.append(getFinalAmount() == null ? "" : getFinalAmount());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCommonNormalRemarkAndAmount o) {
		return __department_id == null ? -1 : __department_id.compareTo(o.getDepartmentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__input_tax);
		hash = 97 * hash + Objects.hashCode(this.__final_amount);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__main_item_id);
		hash = 97 * hash + Objects.hashCode(this.__sub_item_id);
		hash = 97 * hash + Objects.hashCode(this.__input_tax_rebate);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCommonNormalRemarkAndAmount o = (BaseCommonNormalRemarkAndAmount)obj;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__input_tax, o.getInputTax())) return false;
		if(!Objects.equals(this.__final_amount, o.getFinalAmount())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__main_item_id, o.getMainItemId())) return false;
		if(!Objects.equals(this.__sub_item_id, o.getSubItemId())) return false;
		if(!Objects.equals(this.__input_tax_rebate, o.getInputTaxRebate())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getInputTax() != null) sb.append(__wrapDecimal(count++, "inputTax", getInputTax()));
		if(getFinalAmount() != null) sb.append(__wrapDecimal(count++, "finalAmount", getFinalAmount()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getMainItemId() != null) sb.append(__wrapNumber(count++, "mainItemId", getMainItemId()));
		if(getSubItemId() != null) sb.append(__wrapNumber(count++, "subItemId", getSubItemId()));
		if(getInputTaxRebate() != null) sb.append(__wrapDecimal(count++, "inputTaxRebate", getInputTaxRebate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("inputTax")) != null) setInputTax(__getDecimal(val));  
		if((val = values.get("finalAmount")) != null) setFinalAmount(__getDecimal(val));  
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("mainItemId")) != null) setMainItemId(__getInt(val)); 
		if((val = values.get("subItemId")) != null) setSubItemId(__getInt(val)); 
		if((val = values.get("inputTaxRebate")) != null) setInputTaxRebate(__getDecimal(val));  
	}

	protected java.lang.Integer  __department_id ;
	protected java.math.BigDecimal  __amount ;
	protected java.math.BigDecimal  __input_tax ;
	protected java.math.BigDecimal  __final_amount ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __main_item_id ;
	protected java.lang.Integer  __sub_item_id ;
	protected java.math.BigDecimal  __input_tax_rebate ;
}
