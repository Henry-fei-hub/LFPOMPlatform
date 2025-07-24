package pomplatform.workflow.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseBusinessCategory extends GenericBase implements BaseFactory<BaseBusinessCategory>, Comparable<BaseBusinessCategory>
{


	public static BaseBusinessCategory newInstance(){
		return new BaseBusinessCategory();
	}

	@Override
	public BaseBusinessCategory make(){
		BaseBusinessCategory b = new BaseBusinessCategory();
		return b;
	}

	public final static String CS_BUSINESS_CATEGORY_ID = "business_category_id" ;
	public final static String CS_BUSINESS_CATEGORY_NAME = "business_category_name" ;
	public final static String CS_BUSINESS_CATEGORY_CODE = "business_category_code" ;
	public final static String CS_PARENT_ID = "parent_id" ;

	public final static String ALL_CAPTIONS = "主键编码,业务类别名称,业务类别编码,父类编码（没有父类id则为0）";

	public Integer getBusinessCategoryId() {
		return this.__business_category_id;
	}

	public void setBusinessCategoryId( Integer value ) {
		this.__business_category_id = value;
	}

	public String getBusinessCategoryName() {
		return this.__business_category_name;
	}

	public void setBusinessCategoryName( String value ) {
		this.__business_category_name = value;
	}

	public String getBusinessCategoryCode() {
		return this.__business_category_code;
	}

	public void setBusinessCategoryCode( String value ) {
		this.__business_category_code = value;
	}

	public Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( Integer value ) {
		this.__parent_id = value;
	}

	public void cloneCopy(BaseBusinessCategory __bean){
		__bean.setBusinessCategoryId(getBusinessCategoryId());
		__bean.setBusinessCategoryName(getBusinessCategoryName());
		__bean.setBusinessCategoryCode(getBusinessCategoryCode());
		__bean.setParentId(getParentId());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getBusinessCategoryId() == null ? "" : getBusinessCategoryId());
		sb.append(",");
		sb.append(getBusinessCategoryName() == null ? "" : getBusinessCategoryName());
		sb.append(",");
		sb.append(getBusinessCategoryCode() == null ? "" : getBusinessCategoryCode());
		sb.append(",");
		sb.append(getParentId() == null ? "" : getParentId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseBusinessCategory o) {
		return __business_category_id == null ? -1 : __business_category_id.compareTo(o.getBusinessCategoryId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__business_category_id);
		hash = 97 * hash + Objects.hashCode(this.__business_category_name);
		hash = 97 * hash + Objects.hashCode(this.__business_category_code);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseBusinessCategory o = (BaseBusinessCategory)obj;
		if(!Objects.equals(this.__business_category_id, o.getBusinessCategoryId())) return false;
		if(!Objects.equals(this.__business_category_name, o.getBusinessCategoryName())) return false;
		if(!Objects.equals(this.__business_category_code, o.getBusinessCategoryCode())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getBusinessCategoryId() != null) sb.append(__wrapNumber(count++, "businessCategoryId", getBusinessCategoryId()));
		if(getBusinessCategoryName() != null) sb.append(__wrapString(count++, "businessCategoryName", getBusinessCategoryName()));
		if(getBusinessCategoryCode() != null) sb.append(__wrapString(count++, "businessCategoryCode", getBusinessCategoryCode()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getBusinessCategoryId() != null) res.put("businessCategoryId", getBusinessCategoryId());
		if(getBusinessCategoryName() != null) res.put("businessCategoryName", getBusinessCategoryName());
		if(getBusinessCategoryCode() != null) res.put("businessCategoryCode", getBusinessCategoryCode());
		if(getParentId() != null) res.put("parentId", getParentId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("businessCategoryId")) != null) setBusinessCategoryId(__getInt(val));
		if((val = values.get("businessCategoryName")) != null) setBusinessCategoryName(__getString(val));
		if((val = values.get("businessCategoryCode")) != null) setBusinessCategoryCode(__getString(val));
		if((val = values.get("parentId")) != null) setParentId(__getInt(val));
	}

	protected Integer  __business_category_id ;
	protected String  __business_category_name ;
	protected String  __business_category_code ;
	protected Integer  __parent_id ;
}
