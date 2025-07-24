package pomplatform.tablemaintain.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseTableMaintain extends GenericBase implements BaseFactory<BaseTableMaintain>, Comparable<BaseTableMaintain> 
{


	public static BaseTableMaintain newInstance(){
		return new BaseTableMaintain();
	}

	@Override
	public BaseTableMaintain make(){
		BaseTableMaintain b = new BaseTableMaintain();
		return b;
	}

	public final static java.lang.String CS_TABLE_MAINTAIN_ID = "table_maintain_id" ;
	public final static java.lang.String CS_TABLE_NAME = "table_name" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "数据库表维护主键,数据库名称,备注";

	public java.lang.Integer getTableMaintainId() {
		return this.__table_maintain_id;
	}

	public void setTableMaintainId( java.lang.Integer value ) {
		this.__table_maintain_id = value;
	}

	public java.lang.String getTableName() {
		return this.__table_name;
	}

	public void setTableName( java.lang.String value ) {
		this.__table_name = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseTableMaintain __bean){
		__bean.setTableMaintainId(getTableMaintainId());
		__bean.setTableName(getTableName());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getTableMaintainId() == null ? "" : getTableMaintainId());
		sb.append(",");
		sb.append(getTableName() == null ? "" : getTableName());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseTableMaintain o) {
		return __table_maintain_id == null ? -1 : __table_maintain_id.compareTo(o.getTableMaintainId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__table_maintain_id);
		hash = 97 * hash + Objects.hashCode(this.__table_name);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseTableMaintain o = (BaseTableMaintain)obj;
		if(!Objects.equals(this.__table_maintain_id, o.getTableMaintainId())) return false;
		if(!Objects.equals(this.__table_name, o.getTableName())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getTableMaintainId() != null) sb.append(__wrapNumber(count++, "tableMaintainId", getTableMaintainId()));
		if(getTableName() != null) sb.append(__wrapString(count++, "tableName", getTableName()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getTableMaintainId() != null) res.put("tableMaintainId", getTableMaintainId());
		if(getTableName() != null) res.put("tableName", getTableName());
		if(getRemark() != null) res.put("remark", getRemark());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("tableMaintainId")) != null) setTableMaintainId(__getInt(val)); 
		if((val = values.get("tableName")) != null) setTableName(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __table_maintain_id ;
	protected java.lang.String  __table_name ;
	protected java.lang.String  __remark ;
}
