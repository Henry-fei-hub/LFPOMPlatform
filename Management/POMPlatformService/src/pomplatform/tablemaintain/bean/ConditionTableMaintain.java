package pomplatform.tablemaintain.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionTableMaintain extends GenericCondition{

	public ConditionTableMaintain(){
		setParameterCount(2);
	}

	public java.lang.String getTableName() {
		return this.__table_name;
	}

	public void setTableName( java.lang.String value ) {
		this.__table_name = value;
	}

	public java.lang.String getRemark() {
		return this.__remark == null ? null : (this.__remark.indexOf("%") >= 0 ? this.__remark : "%"+this.__remark+"%");
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getTableName() != null) sb.append(__wrapString(1, "tableName", getTableName()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("tableName")) != null) setTableName(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getTableName() != null) res.add("tableName");
		if(getRemark() != null) res.add("remark");
		return res;
	}

	private java.lang.String __table_name = null;
	private java.lang.String __remark = null;
}

