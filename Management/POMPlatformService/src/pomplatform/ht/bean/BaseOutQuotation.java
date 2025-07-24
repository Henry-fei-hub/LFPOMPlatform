package pomplatform.ht.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;
import com.pomplatform.db.bean.BaseOutDesignConsideration;

public class BaseOutQuotation extends GenericBase implements BaseFactory<BaseOutQuotation>, Comparable<BaseOutQuotation> 
{


	public static BaseOutQuotation newInstance(){
		return new BaseOutQuotation();
	}

	@Override
	public BaseOutQuotation make(){
		BaseOutQuotation b = new BaseOutQuotation();
		return b;
	}

	public final static java.lang.String CS_OUT_QUOTATION_ID = "out_quotation_id" ;
	public final static java.lang.String CS_QUOTATION_NUMBER = "quotation_number" ;
	public final static java.lang.String CS_QUOTATION_NAME = "quotation_name" ;
	public final static java.lang.String CS_MONEY_SUM = "money_sum" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_PROJECT_TYPE = "project_type" ;
	public final static java.lang.String CS_QUOTATION_FILES = "quotation_files" ;
	public final static java.lang.String CS_QUOTATION_STATUS = "quotation_status" ;
	public final static java.lang.String CS_DISABLE_TYPE = "disable_type" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_UPDATE_TIME = "update_time" ;

	public final static java.lang.String ALL_CAPTIONS = "报价单编码,报价单编号(年月日-1),报价单名称,报价单总金额,起草时间,信息编号,项目编号,业务类型,项目类型 1项目 2前期项目,报价单(原附件),报价单的状态 1成功 2不成功 3报价中...,可操作状态 0可操作,1禁止操作,申请人,contract_id,修改时间";

	public java.lang.Integer getOutQuotationId() {
		return this.__out_quotation_id;
	}

	public void setOutQuotationId( java.lang.Integer value ) {
		this.__out_quotation_id = value;
	}

	public java.lang.String getQuotationNumber() {
		return this.__quotation_number;
	}

	public void setQuotationNumber( java.lang.String value ) {
		this.__quotation_number = value;
	}

	public java.lang.String getQuotationName() {
		return this.__quotation_name;
	}

	public void setQuotationName( java.lang.String value ) {
		this.__quotation_name = value;
	}

	public java.math.BigDecimal getMoneySum() {
		return this.__money_sum;
	}

	public void setMoneySum( java.math.BigDecimal value ) {
		this.__money_sum = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.Integer getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.Integer value ) {
		this.__business_type = value;
	}

	public java.lang.Integer getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.Integer value ) {
		this.__project_type = value;
	}

	public java.lang.String getQuotationFiles() {
		return this.__quotation_files;
	}

	public void setQuotationFiles( java.lang.String value ) {
		this.__quotation_files = value;
	}

	public java.lang.Integer getQuotationStatus() {
		return this.__quotation_status;
	}

	public void setQuotationStatus( java.lang.Integer value ) {
		this.__quotation_status = value;
	}

	public java.lang.Integer getDisableType() {
		return this.__disable_type;
	}

	public void setDisableType( java.lang.Integer value ) {
		this.__disable_type = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.util.Date getUpdateTime() {
		return this.__update_time;
	}

	public void setUpdateTime( java.util.Date value ) {
		this.__update_time = value;
	}

	public java.util.List<BaseOutDesignConsideration> getDetailOutDesignConsideration() {
		return this.__detailOutDesignConsideration;
	}

	public void setDetailOutDesignConsideration( java.util.List<BaseOutDesignConsideration> value ) {
		this.__detailOutDesignConsideration = value;
	}

	public void cloneCopy(BaseOutQuotation __bean){
		__bean.setOutQuotationId(getOutQuotationId());
		__bean.setQuotationNumber(getQuotationNumber());
		__bean.setQuotationName(getQuotationName());
		__bean.setMoneySum(getMoneySum());
		__bean.setCreateTime(getCreateTime());
		__bean.setInfoCode(getInfoCode());
		__bean.setProjectCode(getProjectCode());
		__bean.setBusinessType(getBusinessType());
		__bean.setProjectType(getProjectType());
		__bean.setQuotationFiles(getQuotationFiles());
		__bean.setQuotationStatus(getQuotationStatus());
		__bean.setDisableType(getDisableType());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setContractId(getContractId());
		__bean.setUpdateTime(getUpdateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getOutQuotationId() == null ? "" : getOutQuotationId());
		sb.append(",");
		sb.append(getQuotationNumber() == null ? "" : getQuotationNumber());
		sb.append(",");
		sb.append(getQuotationName() == null ? "" : getQuotationName());
		sb.append(",");
		sb.append(getMoneySum() == null ? "" : getMoneySum());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getBusinessType() == null ? "" : getBusinessType());
		sb.append(",");
		sb.append(getProjectType() == null ? "" : getProjectType());
		sb.append(",");
		sb.append(getQuotationFiles() == null ? "" : getQuotationFiles());
		sb.append(",");
		sb.append(getQuotationStatus() == null ? "" : getQuotationStatus());
		sb.append(",");
		sb.append(getDisableType() == null ? "" : getDisableType());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getUpdateTime() == null ? "" : sdf.format(getUpdateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOutQuotation o) {
		return __out_quotation_id == null ? -1 : __out_quotation_id.compareTo(o.getOutQuotationId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__out_quotation_id);
		hash = 97 * hash + Objects.hashCode(this.__quotation_number);
		hash = 97 * hash + Objects.hashCode(this.__quotation_name);
		hash = 97 * hash + Objects.hashCode(this.__money_sum);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__project_type);
		hash = 97 * hash + Objects.hashCode(this.__quotation_files);
		hash = 97 * hash + Objects.hashCode(this.__quotation_status);
		hash = 97 * hash + Objects.hashCode(this.__disable_type);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__update_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOutQuotation o = (BaseOutQuotation)obj;
		if(!Objects.equals(this.__out_quotation_id, o.getOutQuotationId())) return false;
		if(!Objects.equals(this.__quotation_number, o.getQuotationNumber())) return false;
		if(!Objects.equals(this.__quotation_name, o.getQuotationName())) return false;
		if(!Objects.equals(this.__money_sum, o.getMoneySum())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__project_type, o.getProjectType())) return false;
		if(!Objects.equals(this.__quotation_files, o.getQuotationFiles())) return false;
		if(!Objects.equals(this.__quotation_status, o.getQuotationStatus())) return false;
		if(!Objects.equals(this.__disable_type, o.getDisableType())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__update_time, o.getUpdateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getOutQuotationId() != null) sb.append(__wrapNumber(count++, "outQuotationId", getOutQuotationId()));
		if(getQuotationNumber() != null) sb.append(__wrapString(count++, "quotationNumber", getQuotationNumber()));
		if(getQuotationName() != null) sb.append(__wrapString(count++, "quotationName", getQuotationName()));
		if(getMoneySum() != null) sb.append(__wrapDecimal(count++, "moneySum", getMoneySum()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getBusinessType() != null) sb.append(__wrapNumber(count++, "businessType", getBusinessType()));
		if(getProjectType() != null) sb.append(__wrapNumber(count++, "projectType", getProjectType()));
		if(getQuotationFiles() != null) sb.append(__wrapString(count++, "quotationFiles", getQuotationFiles()));
		if(getQuotationStatus() != null) sb.append(__wrapNumber(count++, "quotationStatus", getQuotationStatus()));
		if(getDisableType() != null) sb.append(__wrapNumber(count++, "disableType", getDisableType()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getUpdateTime() != null) sb.append(__wrapDate(count++, "updateTime", getUpdateTime()));
		if(getDetailOutDesignConsideration() != null)  sb.append(__wrapList(count++, "detailOutDesignConsideration", getDetailOutDesignConsideration()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getOutQuotationId() != null) res.put("outQuotationId", getOutQuotationId());
		if(getQuotationNumber() != null) res.put("quotationNumber", getQuotationNumber());
		if(getQuotationName() != null) res.put("quotationName", getQuotationName());
		if(getMoneySum() != null) res.put("moneySum", getMoneySum());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getInfoCode() != null) res.put("infoCode", getInfoCode());
		if(getProjectCode() != null) res.put("projectCode", getProjectCode());
		if(getBusinessType() != null) res.put("businessType", getBusinessType());
		if(getProjectType() != null) res.put("projectType", getProjectType());
		if(getQuotationFiles() != null) res.put("quotationFiles", getQuotationFiles());
		if(getQuotationStatus() != null) res.put("quotationStatus", getQuotationStatus());
		if(getDisableType() != null) res.put("disableType", getDisableType());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getUpdateTime() != null) res.put("updateTime", getUpdateTime());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("outQuotationId")) != null) setOutQuotationId(__getInt(val)); 
		if((val = values.get("quotationNumber")) != null) setQuotationNumber(__getString(val));
		if((val = values.get("quotationName")) != null) setQuotationName(__getString(val));
		if((val = values.get("moneySum")) != null) setMoneySum(__getDecimal(val));  
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val)); 
		if((val = values.get("quotationFiles")) != null) setQuotationFiles(__getString(val));
		if((val = values.get("quotationStatus")) != null) setQuotationStatus(__getInt(val)); 
		if((val = values.get("disableType")) != null) setDisableType(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("updateTime")) != null) setUpdateTime(__getDate(val)); 
		if((val = values.get("detailOutDesignConsideration")) != null) setDetailOutDesignConsideration(__getList(val, BaseOutDesignConsideration.newInstance()));
	}

	protected java.lang.Integer  __out_quotation_id ;
	protected java.lang.String  __quotation_number ;
	protected java.lang.String  __quotation_name ;
	protected java.math.BigDecimal  __money_sum ;
	protected java.util.Date  __create_time ;
	protected java.lang.String  __info_code ;
	protected java.lang.String  __project_code ;
	protected java.lang.Integer  __business_type ;
	protected java.lang.Integer  __project_type ;
	protected java.lang.String  __quotation_files ;
	protected java.lang.Integer  __quotation_status ;
	protected java.lang.Integer  __disable_type ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.util.Date  __update_time ;
	protected java.util.List<BaseOutDesignConsideration> __detailOutDesignConsideration = null;
}
