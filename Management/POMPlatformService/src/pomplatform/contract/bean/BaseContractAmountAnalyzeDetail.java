package pomplatform.contract.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseContractAmountAnalyzeDetail extends GenericBase implements BaseFactory<BaseContractAmountAnalyzeDetail>, Comparable<BaseContractAmountAnalyzeDetail> 
{


	public static BaseContractAmountAnalyzeDetail newInstance(){
		return new BaseContractAmountAnalyzeDetail();
	}

	@Override
	public BaseContractAmountAnalyzeDetail make(){
		BaseContractAmountAnalyzeDetail b = new BaseContractAmountAnalyzeDetail();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_DATE = "contract_date" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_PLATE_NAME = "plate_name" ;
	public final static java.lang.String CS_SHEET_AMOUNT = "sheet_amount" ;

	public final static java.lang.String ALL_CAPTIONS = "主订单编码,合同编号,合同签订日期,订单编号,订单名称,业务部门,订单合同金额";
	public final static java.lang.String CAPTIONS = "合同编号,合同签订日期,订单编号,订单名称,业务部门,订单合同金额";
	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.util.Date getContractDate() {
		return this.__contract_date;
	}

	public void setContractDate( java.util.Date value ) {
		this.__contract_date = value;
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

	public java.lang.String getPlateName() {
		return this.__plate_name;
	}

	public void setPlateName( java.lang.String value ) {
		this.__plate_name = value;
	}

	public java.math.BigDecimal getSheetAmount() {
		return this.__sheet_amount;
	}

	public void setSheetAmount( java.math.BigDecimal value ) {
		this.__sheet_amount = value;
	}

	public void cloneCopy(BaseContractAmountAnalyzeDetail __bean){
		__bean.setContractId(getContractId());
		__bean.setContractCode(getContractCode());
		__bean.setContractDate(getContractDate());
		__bean.setProjectCode(getProjectCode());
		__bean.setProjectName(getProjectName());
		__bean.setPlateName(getPlateName());
		__bean.setSheetAmount(getSheetAmount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
/*		String strContractId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractId()));
		sb.append(strContractId == null ? "" : strContractId);
		sb.append(",");*/
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getContractDate() == null ? "" : sdf.format(getContractDate()));
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getPlateName() == null ? "" : getPlateName());
		sb.append(",");
		sb.append(getSheetAmount() == null ? "" : getSheetAmount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseContractAmountAnalyzeDetail o) {
		return __contract_id == null ? -1 : __contract_id.compareTo(o.getContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_date);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__plate_name);
		hash = 97 * hash + Objects.hashCode(this.__sheet_amount);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseContractAmountAnalyzeDetail o = (BaseContractAmountAnalyzeDetail)obj;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_date, o.getContractDate())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__plate_name, o.getPlateName())) return false;
		if(!Objects.equals(this.__sheet_amount, o.getSheetAmount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractDate() != null) sb.append(__wrapDate(count++, "contractDate", getContractDate()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getPlateName() != null) sb.append(__wrapString(count++, "plateName", getPlateName()));
		if(getSheetAmount() != null) sb.append(__wrapDecimal(count++, "sheetAmount", getSheetAmount()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractDate")) != null) setContractDate(__getDate(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("plateName")) != null) setPlateName(__getString(val));
		if((val = values.get("sheetAmount")) != null) setSheetAmount(__getDecimal(val));  
	}

	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __contract_code ;
	protected java.util.Date  __contract_date ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.String  __plate_name ;
	protected java.math.BigDecimal  __sheet_amount ;
}
