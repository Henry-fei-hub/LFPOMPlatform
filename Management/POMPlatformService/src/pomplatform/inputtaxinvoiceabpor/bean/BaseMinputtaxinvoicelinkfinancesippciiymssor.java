package pomplatform.inputtaxinvoiceabpor.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMinputtaxinvoicelinkfinancesippciiymssor extends GenericBase implements BaseFactory<BaseMinputtaxinvoicelinkfinancesippciiymssor>, Comparable<BaseMinputtaxinvoicelinkfinancesippciiymssor> 
{


	public static BaseMinputtaxinvoicelinkfinancesippciiymssor newInstance(){
		return new BaseMinputtaxinvoicelinkfinancesippciiymssor();
	}

	@Override
	public BaseMinputtaxinvoicelinkfinancesippciiymssor make(){
		BaseMinputtaxinvoicelinkfinancesippciiymssor b = new BaseMinputtaxinvoicelinkfinancesippciiymssor();
		return b;
	}

	public final static java.lang.String CS_INPUT_TAX_INVOICE_ID = "input_tax_invoice_id" ;
	public final static java.lang.String CS_INVOICE_TYPE = "invoice_type" ;
	public final static java.lang.String CS_INVOICE_CODE = "invoice_code" ;
	public final static java.lang.String CS_INVOICE_NUMBER = "invoice_number" ;
	public final static java.lang.String CS_INVOICE_DATE = "invoice_date" ;
	public final static java.lang.String CS_INVOICE_AMOUNT = "invoice_amount" ;
	public final static java.lang.String CS_TAX_RATE = "tax_rate" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_OTHER_REMARK = "other_remark" ;
	public final static java.lang.String CS_SALES_CODE = "sales_code" ;
	public final static java.lang.String CS_TAX_AMOUNT = "tax_amount" ;
	public final static java.lang.String CS_SALES_NAME = "sales_name" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_HAVE_CHECK = "have_check" ;
	public final static java.lang.String CS_RCODE = "rcode" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_TAX_AMOUNT_CL = "tax_amount_cl" ;
	public final static java.lang.String CS_INVOICE_AMOUNT_CL = "invoice_amount_cl" ;
	public final static java.lang.String CS_IS_COMPLETE = "is_complete" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,发票类型 1专票，2普票 ，3代开,发票代码(10位 每次批量录入是一样),发票号码(8位),开票日期,开票金额(如 100),税率(如 6%),operator,创建时间,备注,其他备注,销方税号,税额,销方名称,年,月,是否勾选,,归属公司,,,";

	public java.lang.Integer getInputTaxInvoiceId() {
		return this.__input_tax_invoice_id;
	}

	public void setInputTaxInvoiceId( java.lang.Integer value ) {
		this.__input_tax_invoice_id = value;
	}

	public java.lang.Integer getInvoiceType() {
		return this.__invoice_type;
	}

	public void setInvoiceType( java.lang.Integer value ) {
		this.__invoice_type = value;
	}

	public java.lang.String getInvoiceCode() {
		return this.__invoice_code;
	}

	public void setInvoiceCode( java.lang.String value ) {
		this.__invoice_code = value;
	}

	public java.lang.String getInvoiceNumber() {
		return this.__invoice_number;
	}

	public void setInvoiceNumber( java.lang.String value ) {
		this.__invoice_number = value;
	}

	public java.util.Date getInvoiceDate() {
		return this.__invoice_date;
	}

	public void setInvoiceDate( java.util.Date value ) {
		this.__invoice_date = value;
	}

	public java.math.BigDecimal getInvoiceAmount() {
		return this.__invoice_amount;
	}

	public void setInvoiceAmount( java.math.BigDecimal value ) {
		this.__invoice_amount = value;
	}

	public java.math.BigDecimal getTaxRate() {
		return this.__tax_rate;
	}

	public void setTaxRate( java.math.BigDecimal value ) {
		this.__tax_rate = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.String getOtherRemark() {
		return this.__other_remark;
	}

	public void setOtherRemark( java.lang.String value ) {
		this.__other_remark = value;
	}

	public java.lang.String getSalesCode() {
		return this.__sales_code;
	}

	public void setSalesCode( java.lang.String value ) {
		this.__sales_code = value;
	}

	public java.math.BigDecimal getTaxAmount() {
		return this.__tax_amount;
	}

	public void setTaxAmount( java.math.BigDecimal value ) {
		this.__tax_amount = value;
	}

	public java.lang.String getSalesName() {
		return this.__sales_name;
	}

	public void setSalesName( java.lang.String value ) {
		this.__sales_name = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	public java.lang.Boolean getHaveCheck() {
		return this.__have_check;
	}

	public void setHaveCheck( java.lang.Boolean value ) {
		this.__have_check = value;
	}

	public java.lang.String getRcode() {
		return this.__rcode;
	}

	public void setRcode( java.lang.String value ) {
		this.__rcode = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.math.BigDecimal getTaxAmountCl() {
		return this.__tax_amount_cl;
	}

	public void setTaxAmountCl( java.math.BigDecimal value ) {
		this.__tax_amount_cl = value;
	}

	public java.math.BigDecimal getInvoiceAmountCl() {
		return this.__invoice_amount_cl;
	}

	public void setInvoiceAmountCl( java.math.BigDecimal value ) {
		this.__invoice_amount_cl = value;
	}

	public java.lang.Boolean getIsComplete() {
		return this.__is_complete;
	}

	public void setIsComplete( java.lang.Boolean value ) {
		this.__is_complete = value;
	}

	public void cloneCopy(BaseMinputtaxinvoicelinkfinancesippciiymssor __bean){
		__bean.setInputTaxInvoiceId(getInputTaxInvoiceId());
		__bean.setInvoiceType(getInvoiceType());
		__bean.setInvoiceCode(getInvoiceCode());
		__bean.setInvoiceNumber(getInvoiceNumber());
		__bean.setInvoiceDate(getInvoiceDate());
		__bean.setInvoiceAmount(getInvoiceAmount());
		__bean.setTaxRate(getTaxRate());
		__bean.setOperator(getOperator());
		__bean.setCreateTime(getCreateTime());
		__bean.setRemark(getRemark());
		__bean.setOtherRemark(getOtherRemark());
		__bean.setSalesCode(getSalesCode());
		__bean.setTaxAmount(getTaxAmount());
		__bean.setSalesName(getSalesName());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setHaveCheck(getHaveCheck());
		__bean.setRcode(getRcode());
		__bean.setCompanyId(getCompanyId());
		__bean.setTaxAmountCl(getTaxAmountCl());
		__bean.setInvoiceAmountCl(getInvoiceAmountCl());
		__bean.setIsComplete(getIsComplete());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getInputTaxInvoiceId() == null ? "" : getInputTaxInvoiceId());
		sb.append(",");
		sb.append(getInvoiceType() == null ? "" : getInvoiceType());
		sb.append(",");
		sb.append(getInvoiceCode() == null ? "" : getInvoiceCode());
		sb.append(",");
		sb.append(getInvoiceNumber() == null ? "" : getInvoiceNumber());
		sb.append(",");
		sb.append(getInvoiceDate() == null ? "" : sdf.format(getInvoiceDate()));
		sb.append(",");
		sb.append(getInvoiceAmount() == null ? "" : getInvoiceAmount());
		sb.append(",");
		sb.append(getTaxRate() == null ? "" : getTaxRate());
		sb.append(",");
		sb.append(getOperator() == null ? "" : getOperator());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getOtherRemark() == null ? "" : getOtherRemark());
		sb.append(",");
		sb.append(getSalesCode() == null ? "" : getSalesCode());
		sb.append(",");
		sb.append(getTaxAmount() == null ? "" : getTaxAmount());
		sb.append(",");
		sb.append(getSalesName() == null ? "" : getSalesName());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getHaveCheck() == null ? "" : getHaveCheck());
		sb.append(",");
		sb.append(getRcode() == null ? "" : getRcode());
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		sb.append(getTaxAmountCl() == null ? "" : getTaxAmountCl());
		sb.append(",");
		sb.append(getInvoiceAmountCl() == null ? "" : getInvoiceAmountCl());
		sb.append(",");
		sb.append(getIsComplete() == null ? "" : getIsComplete());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMinputtaxinvoicelinkfinancesippciiymssor o) {
		return __input_tax_invoice_id == null ? -1 : __input_tax_invoice_id.compareTo(o.getInputTaxInvoiceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__input_tax_invoice_id);
		hash = 97 * hash + Objects.hashCode(this.__invoice_type);
		hash = 97 * hash + Objects.hashCode(this.__invoice_code);
		hash = 97 * hash + Objects.hashCode(this.__invoice_number);
		hash = 97 * hash + Objects.hashCode(this.__invoice_date);
		hash = 97 * hash + Objects.hashCode(this.__invoice_amount);
		hash = 97 * hash + Objects.hashCode(this.__tax_rate);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__other_remark);
		hash = 97 * hash + Objects.hashCode(this.__sales_code);
		hash = 97 * hash + Objects.hashCode(this.__tax_amount);
		hash = 97 * hash + Objects.hashCode(this.__sales_name);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__have_check);
		hash = 97 * hash + Objects.hashCode(this.__rcode);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__tax_amount_cl);
		hash = 97 * hash + Objects.hashCode(this.__invoice_amount_cl);
		hash = 97 * hash + Objects.hashCode(this.__is_complete);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMinputtaxinvoicelinkfinancesippciiymssor o = (BaseMinputtaxinvoicelinkfinancesippciiymssor)obj;
		if(!Objects.equals(this.__input_tax_invoice_id, o.getInputTaxInvoiceId())) return false;
		if(!Objects.equals(this.__invoice_type, o.getInvoiceType())) return false;
		if(!Objects.equals(this.__invoice_code, o.getInvoiceCode())) return false;
		if(!Objects.equals(this.__invoice_number, o.getInvoiceNumber())) return false;
		if(!Objects.equals(this.__invoice_date, o.getInvoiceDate())) return false;
		if(!Objects.equals(this.__invoice_amount, o.getInvoiceAmount())) return false;
		if(!Objects.equals(this.__tax_rate, o.getTaxRate())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__other_remark, o.getOtherRemark())) return false;
		if(!Objects.equals(this.__sales_code, o.getSalesCode())) return false;
		if(!Objects.equals(this.__tax_amount, o.getTaxAmount())) return false;
		if(!Objects.equals(this.__sales_name, o.getSalesName())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__have_check, o.getHaveCheck())) return false;
		if(!Objects.equals(this.__rcode, o.getRcode())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__tax_amount_cl, o.getTaxAmountCl())) return false;
		if(!Objects.equals(this.__invoice_amount_cl, o.getInvoiceAmountCl())) return false;
		if(!Objects.equals(this.__is_complete, o.getIsComplete())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getInputTaxInvoiceId() != null) sb.append(__wrapNumber(count++, "inputTaxInvoiceId", getInputTaxInvoiceId()));
		if(getInvoiceType() != null) sb.append(__wrapNumber(count++, "invoiceType", getInvoiceType()));
		if(getInvoiceCode() != null) sb.append(__wrapString(count++, "invoiceCode", getInvoiceCode()));
		if(getInvoiceNumber() != null) sb.append(__wrapString(count++, "invoiceNumber", getInvoiceNumber()));
		if(getInvoiceDate() != null) sb.append(__wrapDate(count++, "invoiceDate", getInvoiceDate()));
		if(getInvoiceAmount() != null) sb.append(__wrapDecimal(count++, "invoiceAmount", getInvoiceAmount()));
		if(getTaxRate() != null) sb.append(__wrapDecimal(count++, "taxRate", getTaxRate()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getOtherRemark() != null) sb.append(__wrapString(count++, "otherRemark", getOtherRemark()));
		if(getSalesCode() != null) sb.append(__wrapString(count++, "salesCode", getSalesCode()));
		if(getTaxAmount() != null) sb.append(__wrapDecimal(count++, "taxAmount", getTaxAmount()));
		if(getSalesName() != null) sb.append(__wrapString(count++, "salesName", getSalesName()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getHaveCheck() != null) sb.append(__wrapBoolean(count++, "haveCheck", getHaveCheck()));
		if(getRcode() != null) sb.append(__wrapString(count++, "rcode", getRcode()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getTaxAmountCl() != null) sb.append(__wrapDecimal(count++, "taxAmountCl", getTaxAmountCl()));
		if(getInvoiceAmountCl() != null) sb.append(__wrapDecimal(count++, "invoiceAmountCl", getInvoiceAmountCl()));
		if(getIsComplete() != null) sb.append(__wrapBoolean(count++, "isComplete", getIsComplete()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("inputTaxInvoiceId")) != null) setInputTaxInvoiceId(__getInt(val)); 
		if((val = values.get("invoiceType")) != null) setInvoiceType(__getInt(val)); 
		if((val = values.get("invoiceCode")) != null) setInvoiceCode(__getString(val));
		if((val = values.get("invoiceNumber")) != null) setInvoiceNumber(__getString(val));
		if((val = values.get("invoiceDate")) != null) setInvoiceDate(__getDate(val)); 
		if((val = values.get("invoiceAmount")) != null) setInvoiceAmount(__getDecimal(val));  
		if((val = values.get("taxRate")) != null) setTaxRate(__getDecimal(val));  
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("otherRemark")) != null) setOtherRemark(__getString(val));
		if((val = values.get("salesCode")) != null) setSalesCode(__getString(val));
		if((val = values.get("taxAmount")) != null) setTaxAmount(__getDecimal(val));  
		if((val = values.get("salesName")) != null) setSalesName(__getString(val));
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("haveCheck")) != null) setHaveCheck(__getBoolean(val));
		if((val = values.get("rcode")) != null) setRcode(__getString(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("taxAmountCl")) != null) setTaxAmountCl(__getDecimal(val));  
		if((val = values.get("invoiceAmountCl")) != null) setInvoiceAmountCl(__getDecimal(val));  
		if((val = values.get("isComplete")) != null) setIsComplete(__getBoolean(val));
	}

	protected java.lang.Integer  __input_tax_invoice_id ;
	protected java.lang.Integer  __invoice_type ;
	protected java.lang.String  __invoice_code ;
	protected java.lang.String  __invoice_number ;
	protected java.util.Date  __invoice_date ;
	protected java.math.BigDecimal  __invoice_amount ;
	protected java.math.BigDecimal  __tax_rate ;
	protected java.lang.Integer  __operator ;
	protected java.util.Date  __create_time ;
	protected java.lang.String  __remark ;
	protected java.lang.String  __other_remark ;
	protected java.lang.String  __sales_code ;
	protected java.math.BigDecimal  __tax_amount ;
	protected java.lang.String  __sales_name ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.lang.Boolean  __have_check ;
	protected java.lang.String  __rcode ;
	protected java.lang.Integer  __company_id ;
	protected java.math.BigDecimal  __tax_amount_cl ;
	protected java.math.BigDecimal  __invoice_amount_cl ;
	protected java.lang.Boolean  __is_complete ;
}
