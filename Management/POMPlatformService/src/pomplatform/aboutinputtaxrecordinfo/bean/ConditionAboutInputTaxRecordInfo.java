package pomplatform.aboutinputtaxrecordinfo.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionAboutInputTaxRecordInfo extends GenericCondition{

	public ConditionAboutInputTaxRecordInfo(){
		setParameterCount(5);
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.String getCode() {
		return this.__code == null ? null : (this.__code.indexOf("%") >= 0 ? this.__code : "%"+this.__code+"%");
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.lang.String getInvoiceEndNumber() {
		return this.__invoice_end_number == null ? null : (this.__invoice_end_number.indexOf("%") >= 0 ? this.__invoice_end_number : "%"+this.__invoice_end_number+"%");
	}

	public void setInvoiceEndNumber( java.lang.String value ) {
		this.__invoice_end_number = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.util.Date getOverTime() {
		return this.__over_time;
	}

	public void setOverTime( java.util.Date value ) {
		this.__over_time = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProcessType() != null) sb.append(__wrapNumber(1, "processType", getProcessType()));
		if(getCode() != null) sb.append(__wrapString(1, "code", getCode()));
		if(getInvoiceEndNumber() != null) sb.append(__wrapString(1, "invoiceEndNumber", getInvoiceEndNumber()));
		if(getOperateTime() != null) sb.append(__wrapDate(1, "operateTime", getOperateTime()));
		if(getOverTime() != null) sb.append(__wrapDate(1, "overTime", getOverTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("invoiceEndNumber")) != null) setInvoiceEndNumber(__getString(val));
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("overTime")) != null) setOverTime(__getDate(val)); 
	}

	private java.lang.Integer __process_type = null;
	private java.lang.String __code = null;
	private java.lang.String __invoice_end_number = null;
	private java.util.Date __operate_time = null;
	private java.util.Date __over_time = null;
}

