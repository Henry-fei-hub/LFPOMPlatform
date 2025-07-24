package pomplatform.workflow.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseonLoadPurchaseProductBySupplier extends GenericBase implements BaseFactory<BaseonLoadPurchaseProductBySupplier>, Comparable<BaseonLoadPurchaseProductBySupplier> 
{


	public static BaseonLoadPurchaseProductBySupplier newInstance(){
		return new BaseonLoadPurchaseProductBySupplier();
	}

	@Override
	public BaseonLoadPurchaseProductBySupplier make(){
		BaseonLoadPurchaseProductBySupplier b = new BaseonLoadPurchaseProductBySupplier();
		return b;
	}

	public final static java.lang.String CS_PERSONNEL_BUSINESS_ID = "personnel_business_id" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_SUPPLIER_ID = "supplier_id" ;
	public final static java.lang.String CS_PURCHASE_AMOUNT = "purchase_amount" ;
	public final static java.lang.String CS_TAX_AMOUNT = "tax_amount" ;
	public final static java.lang.String CS_PERSON_IN_CHARGE = "person_in_charge" ;
	public final static java.lang.String CS_PURCHASE_DATE = "purchase_date" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "人事业务编码,项目,项目编号,项目名称,供应商,采购金额,含税总金额,负责人,采购日期,备注";

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
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

	public java.lang.Integer getSupplierId() {
		return this.__supplier_id;
	}

	public void setSupplierId( java.lang.Integer value ) {
		this.__supplier_id = value;
	}

	public java.math.BigDecimal getPurchaseAmount() {
		return this.__purchase_amount;
	}

	public void setPurchaseAmount( java.math.BigDecimal value ) {
		this.__purchase_amount = value;
	}

	public java.math.BigDecimal getTaxAmount() {
		return this.__tax_amount;
	}

	public void setTaxAmount( java.math.BigDecimal value ) {
		this.__tax_amount = value;
	}

	public java.lang.Integer getPersonInCharge() {
		return this.__person_in_charge;
	}

	public void setPersonInCharge( java.lang.Integer value ) {
		this.__person_in_charge = value;
	}

	public java.util.Date getPurchaseDate() {
		return this.__purchase_date;
	}

	public void setPurchaseDate( java.util.Date value ) {
		this.__purchase_date = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseonLoadPurchaseProductBySupplier __bean){
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setProjectCode(getProjectCode());
		__bean.setProjectName(getProjectName());
		__bean.setSupplierId(getSupplierId());
		__bean.setPurchaseAmount(getPurchaseAmount());
		__bean.setTaxAmount(getTaxAmount());
		__bean.setPersonInCharge(getPersonInCharge());
		__bean.setPurchaseDate(getPurchaseDate());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPersonnelBusinessId() == null ? "" : getPersonnelBusinessId());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getSupplierId() == null ? "" : getSupplierId());
		sb.append(",");
		sb.append(getPurchaseAmount() == null ? "" : getPurchaseAmount());
		sb.append(",");
		sb.append(getTaxAmount() == null ? "" : getTaxAmount());
		sb.append(",");
		sb.append(getPersonInCharge() == null ? "" : getPersonInCharge());
		sb.append(",");
		sb.append(getPurchaseDate() == null ? "" : sdf.format(getPurchaseDate()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseonLoadPurchaseProductBySupplier o) {
		return __personnel_business_id == null ? -1 : __personnel_business_id.compareTo(o.getPersonnelBusinessId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__supplier_id);
		hash = 97 * hash + Objects.hashCode(this.__purchase_amount);
		hash = 97 * hash + Objects.hashCode(this.__tax_amount);
		hash = 97 * hash + Objects.hashCode(this.__person_in_charge);
		hash = 97 * hash + Objects.hashCode(this.__purchase_date);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseonLoadPurchaseProductBySupplier o = (BaseonLoadPurchaseProductBySupplier)obj;
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__supplier_id, o.getSupplierId())) return false;
		if(!Objects.equals(this.__purchase_amount, o.getPurchaseAmount())) return false;
		if(!Objects.equals(this.__tax_amount, o.getTaxAmount())) return false;
		if(!Objects.equals(this.__person_in_charge, o.getPersonInCharge())) return false;
		if(!Objects.equals(this.__purchase_date, o.getPurchaseDate())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "personnelBusinessId", getPersonnelBusinessId()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getSupplierId() != null) sb.append(__wrapNumber(count++, "supplierId", getSupplierId()));
		if(getPurchaseAmount() != null) sb.append(__wrapDecimal(count++, "purchaseAmount", getPurchaseAmount()));
		if(getTaxAmount() != null) sb.append(__wrapDecimal(count++, "taxAmount", getTaxAmount()));
		if(getPersonInCharge() != null) sb.append(__wrapNumber(count++, "personInCharge", getPersonInCharge()));
		if(getPurchaseDate() != null) sb.append(__wrapDate(count++, "purchaseDate", getPurchaseDate()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("supplierId")) != null) setSupplierId(__getInt(val)); 
		if((val = values.get("purchaseAmount")) != null) setPurchaseAmount(__getDecimal(val));  
		if((val = values.get("taxAmount")) != null) setTaxAmount(__getDecimal(val));  
		if((val = values.get("personInCharge")) != null) setPersonInCharge(__getInt(val)); 
		if((val = values.get("purchaseDate")) != null) setPurchaseDate(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __personnel_business_id ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.Integer  __supplier_id ;
	protected java.math.BigDecimal  __purchase_amount ;
	protected java.math.BigDecimal  __tax_amount ;
	protected java.lang.Integer  __person_in_charge ;
	protected java.util.Date  __purchase_date ;
	protected java.lang.String  __remark ;
}
