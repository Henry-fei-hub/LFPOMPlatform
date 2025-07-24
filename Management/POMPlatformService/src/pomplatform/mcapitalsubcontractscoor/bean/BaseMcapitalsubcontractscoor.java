package pomplatform.mcapitalsubcontractscoor.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMcapitalsubcontractscoor extends GenericBase implements BaseFactory<BaseMcapitalsubcontractscoor>, Comparable<BaseMcapitalsubcontractscoor> 
{


	public static BaseMcapitalsubcontractscoor newInstance(){
		return new BaseMcapitalsubcontractscoor();
	}

	@Override
	public BaseMcapitalsubcontractscoor make(){
		BaseMcapitalsubcontractscoor b = new BaseMcapitalsubcontractscoor();
		return b;
	}

	public final static java.lang.String CS_SUB_CONTRACT_ID = "sub_contract_id" ;
	public final static java.lang.String CS_SUB_CONTRACT_CODE = "sub_contract_code" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_SUB_CONTRACT_NAME = "sub_contract_name" ;
	public final static java.lang.String CS_CAPITAL_ID = "capital_id" ;
	public final static java.lang.String CS_CAPITAL_SUB_CONTRACT_ID = "capital_sub_contract_id" ;
	public final static java.lang.String CS_MONEY = "money" ;
	public final static java.lang.String CS_CREAT_TIME = "creat_time" ;
	public final static java.lang.String CS_OPERATOR_ID = "operator_id" ;

	public final static java.lang.String ALL_CAPTIONS = "子订单编码,子合同编号,项目编号,子合同名称  充当了区域,回款编码,主键,金额,创建时间,操作人";

	public java.lang.Integer getSubContractId() {
		return this.__sub_contract_id;
	}

	public void setSubContractId( java.lang.Integer value ) {
		this.__sub_contract_id = value;
	}

	public java.lang.String getSubContractCode() {
		return this.__sub_contract_code;
	}

	public void setSubContractCode( java.lang.String value ) {
		this.__sub_contract_code = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getSubContractName() {
		return this.__sub_contract_name;
	}

	public void setSubContractName( java.lang.String value ) {
		this.__sub_contract_name = value;
	}

	public java.lang.Integer getCapitalId() {
		return this.__capital_id;
	}

	public void setCapitalId( java.lang.Integer value ) {
		this.__capital_id = value;
	}

	public java.lang.Integer getCapitalSubContractId() {
		return this.__capital_sub_contract_id;
	}

	public void setCapitalSubContractId( java.lang.Integer value ) {
		this.__capital_sub_contract_id = value;
	}

	public java.math.BigDecimal getMoney() {
		return this.__money;
	}

	public void setMoney( java.math.BigDecimal value ) {
		this.__money = value;
	}

	public java.util.Date getCreatTime() {
		return this.__creat_time;
	}

	public void setCreatTime( java.util.Date value ) {
		this.__creat_time = value;
	}

	public java.lang.Integer getOperatorId() {
		return this.__operator_id;
	}

	public void setOperatorId( java.lang.Integer value ) {
		this.__operator_id = value;
	}

	public void cloneCopy(BaseMcapitalsubcontractscoor __bean){
		__bean.setSubContractId(getSubContractId());
		__bean.setSubContractCode(getSubContractCode());
		__bean.setProjectCode(getProjectCode());
		__bean.setSubContractName(getSubContractName());
		__bean.setCapitalId(getCapitalId());
		__bean.setCapitalSubContractId(getCapitalSubContractId());
		__bean.setMoney(getMoney());
		__bean.setCreatTime(getCreatTime());
		__bean.setOperatorId(getOperatorId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSubContractId() == null ? "" : getSubContractId());
		sb.append(",");
		sb.append(getSubContractCode() == null ? "" : getSubContractCode());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getSubContractName() == null ? "" : getSubContractName());
		sb.append(",");
		sb.append(getCapitalId() == null ? "" : getCapitalId());
		sb.append(",");
		sb.append(getCapitalSubContractId() == null ? "" : getCapitalSubContractId());
		sb.append(",");
		sb.append(getMoney() == null ? "" : getMoney());
		sb.append(",");
		sb.append(getCreatTime() == null ? "" : sdf.format(getCreatTime()));
		sb.append(",");
		sb.append(getOperatorId() == null ? "" : getOperatorId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMcapitalsubcontractscoor o) {
		return __capital_sub_contract_id == null ? -1 : __capital_sub_contract_id.compareTo(o.getCapitalSubContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__sub_contract_id);
		hash = 97 * hash + Objects.hashCode(this.__sub_contract_code);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__sub_contract_name);
		hash = 97 * hash + Objects.hashCode(this.__capital_id);
		hash = 97 * hash + Objects.hashCode(this.__capital_sub_contract_id);
		hash = 97 * hash + Objects.hashCode(this.__money);
		hash = 97 * hash + Objects.hashCode(this.__creat_time);
		hash = 97 * hash + Objects.hashCode(this.__operator_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMcapitalsubcontractscoor o = (BaseMcapitalsubcontractscoor)obj;
		if(!Objects.equals(this.__sub_contract_id, o.getSubContractId())) return false;
		if(!Objects.equals(this.__sub_contract_code, o.getSubContractCode())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__sub_contract_name, o.getSubContractName())) return false;
		if(!Objects.equals(this.__capital_id, o.getCapitalId())) return false;
		if(!Objects.equals(this.__capital_sub_contract_id, o.getCapitalSubContractId())) return false;
		if(!Objects.equals(this.__money, o.getMoney())) return false;
		if(!Objects.equals(this.__creat_time, o.getCreatTime())) return false;
		if(!Objects.equals(this.__operator_id, o.getOperatorId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSubContractId() != null) sb.append(__wrapNumber(count++, "subContractId", getSubContractId()));
		if(getSubContractCode() != null) sb.append(__wrapString(count++, "subContractCode", getSubContractCode()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getSubContractName() != null) sb.append(__wrapString(count++, "subContractName", getSubContractName()));
		if(getCapitalId() != null) sb.append(__wrapNumber(count++, "capitalId", getCapitalId()));
		if(getCapitalSubContractId() != null) sb.append(__wrapNumber(count++, "capitalSubContractId", getCapitalSubContractId()));
		if(getMoney() != null) sb.append(__wrapDecimal(count++, "money", getMoney()));
		if(getCreatTime() != null) sb.append(__wrapDate(count++, "creatTime", getCreatTime()));
		if(getOperatorId() != null) sb.append(__wrapNumber(count++, "operatorId", getOperatorId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("subContractId")) != null) setSubContractId(__getInt(val)); 
		if((val = values.get("subContractCode")) != null) setSubContractCode(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("subContractName")) != null) setSubContractName(__getString(val));
		if((val = values.get("capitalId")) != null) setCapitalId(__getInt(val)); 
		if((val = values.get("capitalSubContractId")) != null) setCapitalSubContractId(__getInt(val)); 
		if((val = values.get("money")) != null) setMoney(__getDecimal(val));  
		if((val = values.get("creatTime")) != null) setCreatTime(__getDate(val)); 
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
	}

	protected java.lang.Integer  __sub_contract_id ;
	protected java.lang.String  __sub_contract_code ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __sub_contract_name ;
	protected java.lang.Integer  __capital_id ;
	protected java.lang.Integer  __capital_sub_contract_id ;
	protected java.math.BigDecimal  __money ;
	protected java.util.Date  __creat_time ;
	protected java.lang.Integer  __operator_id ;
}
