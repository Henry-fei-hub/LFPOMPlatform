package pomplatform.contract.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseShowOldProjectRevenue extends GenericBase implements BaseFactory<BaseShowOldProjectRevenue>, Comparable<BaseShowOldProjectRevenue> 
{


	public static BaseShowOldProjectRevenue newInstance(){
		return new BaseShowOldProjectRevenue();
	}

	@Override
	public BaseShowOldProjectRevenue make(){
		BaseShowOldProjectRevenue b = new BaseShowOldProjectRevenue();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_PALTE_ID = "palte_id" ;
	public final static java.lang.String CS_IS_FINISH = "is_finish" ;

	public final static java.lang.String ALL_CAPTIONS = "合同编号,订单编号,订单名,订单的营收,归属的部门Id,是否完结（1完结，2.没有完结）";

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
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

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.lang.Integer getPalteId() {
		return this.__palte_id;
	}

	public void setPalteId( java.lang.Integer value ) {
		this.__palte_id = value;
	}

	public java.lang.Integer getIsFinish() {
		return this.__is_finish;
	}

	public void setIsFinish( java.lang.Integer value ) {
		this.__is_finish = value;
	}

	public void cloneCopy(BaseShowOldProjectRevenue __bean){
		__bean.setContractCode(getContractCode());
		__bean.setProjectCode(getProjectCode());
		__bean.setProjectName(getProjectName());
		__bean.setAmount(getAmount());
		__bean.setPalteId(getPalteId());
		__bean.setIsFinish(getIsFinish());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strContractCode = delicacy.system.executor.SelectValueCache.getSelectValue("plate_records", String.valueOf(getContractCode()));
		sb.append(strContractCode == null ? "" : strContractCode);
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getPalteId() == null ? "" : getPalteId());
		sb.append(",");
		sb.append(getIsFinish() == null ? "" : getIsFinish());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseShowOldProjectRevenue o) {
		return __contract_code == null ? -1 : __contract_code.compareTo(o.getContractCode());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__palte_id);
		hash = 97 * hash + Objects.hashCode(this.__is_finish);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseShowOldProjectRevenue o = (BaseShowOldProjectRevenue)obj;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__palte_id, o.getPalteId())) return false;
		if(!Objects.equals(this.__is_finish, o.getIsFinish())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getPalteId() != null) sb.append(__wrapNumber(count++, "palteId", getPalteId()));
		if(getIsFinish() != null) sb.append(__wrapNumber(count++, "isFinish", getIsFinish()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("palteId")) != null) setPalteId(__getInt(val)); 
		if((val = values.get("isFinish")) != null) setIsFinish(__getInt(val)); 
	}

	protected java.lang.String  __contract_code ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __project_name ;
	protected java.math.BigDecimal  __amount ;
	protected java.lang.Integer  __palte_id ;
	protected java.lang.Integer  __is_finish ;
}
