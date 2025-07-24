package pomplatform.tablemaintain.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BasegetAllTables extends GenericBase implements BaseFactory<BasegetAllTables>, Comparable<BasegetAllTables> 
{


	public static BasegetAllTables newInstance(){
		return new BasegetAllTables();
	}

	@Override
	public BasegetAllTables make(){
		BasegetAllTables b = new BasegetAllTables();
		return b;
	}

	public final static java.lang.String CS_SCHEMANAME = "schemaname" ;
	public final static java.lang.String CS_TABLENAME = "tablename" ;
	public final static java.lang.String CS_TABLEOWNER = "tableowner" ;
	public final static java.lang.String CS_TABLESPACE = "tablespace" ;
	public final static java.lang.String CS_HASINDEXES = "hasindexes" ;
	public final static java.lang.String CS_HASRULES = "hasrules" ;
	public final static java.lang.String CS_HASTRIGGERS = "hastriggers" ;
	public final static java.lang.String CS_ROWSECURITY = "rowsecurity" ;

	public final static java.lang.String ALL_CAPTIONS = "schemaname,tablename,tableowner,tablespace,hasindexes,hasrules,hastriggers,rowsecurity";

	public java.lang.String getSchemaname() {
		return this.__schemaname;
	}

	public void setSchemaname( java.lang.String value ) {
		this.__schemaname = value;
	}

	public java.lang.String getTablename() {
		return this.__tablename;
	}

	public void setTablename( java.lang.String value ) {
		this.__tablename = value;
	}

	public java.lang.String getTableowner() {
		return this.__tableowner;
	}

	public void setTableowner( java.lang.String value ) {
		this.__tableowner = value;
	}

	public java.lang.String getTablespace() {
		return this.__tablespace;
	}

	public void setTablespace( java.lang.String value ) {
		this.__tablespace = value;
	}

	public java.lang.Boolean getHasindexes() {
		return this.__hasindexes;
	}

	public void setHasindexes( java.lang.Boolean value ) {
		this.__hasindexes = value;
	}

	public java.lang.Boolean getHasrules() {
		return this.__hasrules;
	}

	public void setHasrules( java.lang.Boolean value ) {
		this.__hasrules = value;
	}

	public java.lang.Boolean getHastriggers() {
		return this.__hastriggers;
	}

	public void setHastriggers( java.lang.Boolean value ) {
		this.__hastriggers = value;
	}

	public java.lang.Boolean getRowsecurity() {
		return this.__rowsecurity;
	}

	public void setRowsecurity( java.lang.Boolean value ) {
		this.__rowsecurity = value;
	}

	public void cloneCopy(BasegetAllTables __bean){
		__bean.setSchemaname(getSchemaname());
		__bean.setTablename(getTablename());
		__bean.setTableowner(getTableowner());
		__bean.setTablespace(getTablespace());
		__bean.setHasindexes(getHasindexes());
		__bean.setHasrules(getHasrules());
		__bean.setHastriggers(getHastriggers());
		__bean.setRowsecurity(getRowsecurity());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSchemaname() == null ? "" : getSchemaname());
		sb.append(",");
		sb.append(getTablename() == null ? "" : getTablename());
		sb.append(",");
		sb.append(getTableowner() == null ? "" : getTableowner());
		sb.append(",");
		sb.append(getTablespace() == null ? "" : getTablespace());
		sb.append(",");
		sb.append(getHasindexes() == null ? "" : getHasindexes());
		sb.append(",");
		sb.append(getHasrules() == null ? "" : getHasrules());
		sb.append(",");
		sb.append(getHastriggers() == null ? "" : getHastriggers());
		sb.append(",");
		sb.append(getRowsecurity() == null ? "" : getRowsecurity());
		return sb.toString();
	}

	@Override
	public int compareTo(BasegetAllTables o) {
		return __schemaname == null ? -1 : __schemaname.compareTo(o.getSchemaname());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__schemaname);
		hash = 97 * hash + Objects.hashCode(this.__tablename);
		hash = 97 * hash + Objects.hashCode(this.__tableowner);
		hash = 97 * hash + Objects.hashCode(this.__tablespace);
		hash = 97 * hash + Objects.hashCode(this.__hasindexes);
		hash = 97 * hash + Objects.hashCode(this.__hasrules);
		hash = 97 * hash + Objects.hashCode(this.__hastriggers);
		hash = 97 * hash + Objects.hashCode(this.__rowsecurity);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasegetAllTables o = (BasegetAllTables)obj;
		if(!Objects.equals(this.__schemaname, o.getSchemaname())) return false;
		if(!Objects.equals(this.__tablename, o.getTablename())) return false;
		if(!Objects.equals(this.__tableowner, o.getTableowner())) return false;
		if(!Objects.equals(this.__tablespace, o.getTablespace())) return false;
		if(!Objects.equals(this.__hasindexes, o.getHasindexes())) return false;
		if(!Objects.equals(this.__hasrules, o.getHasrules())) return false;
		if(!Objects.equals(this.__hastriggers, o.getHastriggers())) return false;
		if(!Objects.equals(this.__rowsecurity, o.getRowsecurity())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSchemaname() != null) sb.append(__wrapString(count++, "schemaname", getSchemaname()));
		if(getTablename() != null) sb.append(__wrapString(count++, "tablename", getTablename()));
		if(getTableowner() != null) sb.append(__wrapString(count++, "tableowner", getTableowner()));
		if(getTablespace() != null) sb.append(__wrapString(count++, "tablespace", getTablespace()));
		if(getHasindexes() != null) sb.append(__wrapBoolean(count++, "hasindexes", getHasindexes()));
		if(getHasrules() != null) sb.append(__wrapBoolean(count++, "hasrules", getHasrules()));
		if(getHastriggers() != null) sb.append(__wrapBoolean(count++, "hastriggers", getHastriggers()));
		if(getRowsecurity() != null) sb.append(__wrapBoolean(count++, "rowsecurity", getRowsecurity()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getSchemaname() != null) res.put("schemaname", getSchemaname());
		if(getTablename() != null) res.put("tablename", getTablename());
		if(getTableowner() != null) res.put("tableowner", getTableowner());
		if(getTablespace() != null) res.put("tablespace", getTablespace());
		if(getHasindexes() != null) res.put("hasindexes", getHasindexes());
		if(getHasrules() != null) res.put("hasrules", getHasrules());
		if(getHastriggers() != null) res.put("hastriggers", getHastriggers());
		if(getRowsecurity() != null) res.put("rowsecurity", getRowsecurity());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("schemaname")) != null) setSchemaname(__getString(val));
		if((val = values.get("tablename")) != null) setTablename(__getString(val));
		if((val = values.get("tableowner")) != null) setTableowner(__getString(val));
		if((val = values.get("tablespace")) != null) setTablespace(__getString(val));
		if((val = values.get("hasindexes")) != null) setHasindexes(__getBoolean(val));
		if((val = values.get("hasrules")) != null) setHasrules(__getBoolean(val));
		if((val = values.get("hastriggers")) != null) setHastriggers(__getBoolean(val));
		if((val = values.get("rowsecurity")) != null) setRowsecurity(__getBoolean(val));
	}

	protected java.lang.String  __schemaname ;
	protected java.lang.String  __tablename ;
	protected java.lang.String  __tableowner ;
	protected java.lang.String  __tablespace ;
	protected java.lang.Boolean  __hasindexes ;
	protected java.lang.Boolean  __hasrules ;
	protected java.lang.Boolean  __hastriggers ;
	protected java.lang.Boolean  __rowsecurity ;
}
