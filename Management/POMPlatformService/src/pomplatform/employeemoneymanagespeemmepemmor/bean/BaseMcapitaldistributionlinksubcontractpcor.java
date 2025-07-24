package pomplatform.employeemoneymanagespeemmepemmor.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMcapitaldistributionlinksubcontractpcor extends GenericBase implements BaseFactory<BaseMcapitaldistributionlinksubcontractpcor>, Comparable<BaseMcapitaldistributionlinksubcontractpcor> 
{


	public static BaseMcapitaldistributionlinksubcontractpcor newInstance(){
		return new BaseMcapitaldistributionlinksubcontractpcor();
	}

	@Override
	public BaseMcapitaldistributionlinksubcontractpcor make(){
		BaseMcapitaldistributionlinksubcontractpcor b = new BaseMcapitaldistributionlinksubcontractpcor();
		return b;
	}

	public final static java.lang.String CS_CAPITAL_DISTRIBUTION_LINK_SUB_CONTRACT_ID = "capital_distribution_link_sub_contract_id" ;
	public final static java.lang.String CS_CAPITAL_DISTRIBUTION_ID = "capital_distribution_id" ;
	public final static java.lang.String CS_SUB_CONTRACT_ID = "sub_contract_id" ;
	public final static java.lang.String CS_MONEY = "money" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_CAPITAL_ID = "capital_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,回款分配编码,订单编码,金额,订单编号,订单名称,收款主键(手动分配回款使用),创建时间";

	public java.lang.Integer getCapitalDistributionLinkSubContractId() {
		return this.__capital_distribution_link_sub_contract_id;
	}

	public void setCapitalDistributionLinkSubContractId( java.lang.Integer value ) {
		this.__capital_distribution_link_sub_contract_id = value;
	}

	public java.lang.Integer getCapitalDistributionId() {
		return this.__capital_distribution_id;
	}

	public void setCapitalDistributionId( java.lang.Integer value ) {
		this.__capital_distribution_id = value;
	}

	public java.lang.Integer getSubContractId() {
		return this.__sub_contract_id;
	}

	public void setSubContractId( java.lang.Integer value ) {
		this.__sub_contract_id = value;
	}

	public java.math.BigDecimal getMoney() {
		return this.__money;
	}

	public void setMoney( java.math.BigDecimal value ) {
		this.__money = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.Integer getCapitalId() {
		return this.__capital_id;
	}

	public void setCapitalId( java.lang.Integer value ) {
		this.__capital_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public void cloneCopy(BaseMcapitaldistributionlinksubcontractpcor __bean){
		__bean.setCapitalDistributionLinkSubContractId(getCapitalDistributionLinkSubContractId());
		__bean.setCapitalDistributionId(getCapitalDistributionId());
		__bean.setSubContractId(getSubContractId());
		__bean.setMoney(getMoney());
		__bean.setContractCode(getContractCode());
		__bean.setProjectName(getProjectName());
		__bean.setCapitalId(getCapitalId());
		__bean.setCreateTime(getCreateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCapitalDistributionLinkSubContractId() == null ? "" : getCapitalDistributionLinkSubContractId());
		sb.append(",");
		sb.append(getCapitalDistributionId() == null ? "" : getCapitalDistributionId());
		sb.append(",");
		sb.append(getSubContractId() == null ? "" : getSubContractId());
		sb.append(",");
		sb.append(getMoney() == null ? "" : getMoney());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getCapitalId() == null ? "" : getCapitalId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMcapitaldistributionlinksubcontractpcor o) {
		return __capital_distribution_link_sub_contract_id == null ? -1 : __capital_distribution_link_sub_contract_id.compareTo(o.getCapitalDistributionLinkSubContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__capital_distribution_link_sub_contract_id);
		hash = 97 * hash + Objects.hashCode(this.__capital_distribution_id);
		hash = 97 * hash + Objects.hashCode(this.__sub_contract_id);
		hash = 97 * hash + Objects.hashCode(this.__money);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__capital_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMcapitaldistributionlinksubcontractpcor o = (BaseMcapitaldistributionlinksubcontractpcor)obj;
		if(!Objects.equals(this.__capital_distribution_link_sub_contract_id, o.getCapitalDistributionLinkSubContractId())) return false;
		if(!Objects.equals(this.__capital_distribution_id, o.getCapitalDistributionId())) return false;
		if(!Objects.equals(this.__sub_contract_id, o.getSubContractId())) return false;
		if(!Objects.equals(this.__money, o.getMoney())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__capital_id, o.getCapitalId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCapitalDistributionLinkSubContractId() != null) sb.append(__wrapNumber(count++, "capitalDistributionLinkSubContractId", getCapitalDistributionLinkSubContractId()));
		if(getCapitalDistributionId() != null) sb.append(__wrapNumber(count++, "capitalDistributionId", getCapitalDistributionId()));
		if(getSubContractId() != null) sb.append(__wrapNumber(count++, "subContractId", getSubContractId()));
		if(getMoney() != null) sb.append(__wrapDecimal(count++, "money", getMoney()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getCapitalId() != null) sb.append(__wrapNumber(count++, "capitalId", getCapitalId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("capitalDistributionLinkSubContractId")) != null) setCapitalDistributionLinkSubContractId(__getInt(val)); 
		if((val = values.get("capitalDistributionId")) != null) setCapitalDistributionId(__getInt(val)); 
		if((val = values.get("subContractId")) != null) setSubContractId(__getInt(val)); 
		if((val = values.get("money")) != null) setMoney(__getDecimal(val));  
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("capitalId")) != null) setCapitalId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __capital_distribution_link_sub_contract_id ;
	protected java.lang.Integer  __capital_distribution_id ;
	protected java.lang.Integer  __sub_contract_id ;
	protected java.math.BigDecimal  __money ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.Integer  __capital_id ;
	protected java.util.Date  __create_time ;
}
