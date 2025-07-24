package pomplatform.subjectType.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BaseSubjectType;
import com.pomplatform.db.bean.BaseSubjectDepartment;

public class BaseSubjectTypeWithS extends BaseSubjectType 
{

	public static BaseSubjectTypeWithS newInstance(){
		return new BaseSubjectTypeWithS();
	}

	@Override
	public BaseSubjectTypeWithS make(){
		BaseSubjectTypeWithS b = new BaseSubjectTypeWithS();
		return b;
	}

	public List<BaseSubjectDepartment> getDetailSubjectDepartment() {
		return this.__detail_subject_departments;
	}

	public void setDetailSubjectDepartment( List<BaseSubjectDepartment> value ) {
		this.__detail_subject_departments = value;
	}

	public BaseSubjectType toBase(){
		BaseSubjectType base = new BaseSubjectType();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseSubjectType base){
		base.cloneCopy(this);
	}

	public static List<BaseSubjectType> getBaseList(List<BaseSubjectTypeWithS> beans) {
		List<BaseSubjectType> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseSubjectTypeWithS bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseSubjectTypeWithS> getBeanList(List<BaseSubjectType> beans) {
		List<BaseSubjectTypeWithS> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseSubjectType bean : beans) {
			BaseSubjectTypeWithS val = new BaseSubjectTypeWithS();
			val.getDataFromBase(bean);
			result.add(val);
		}
		return result;
	}

	@Override
	public java.lang.String toJSONString() {

		int count = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		count = sb.length(); sb.append(__wrapList(count, "detailSubjectDepartment", getDetailSubjectDepartment()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailSubjectDepartment")) != null) setDetailSubjectDepartment(__getList(val, BaseSubjectDepartment.newInstance()));
	}

	protected List<BaseSubjectDepartment> __detail_subject_departments ; 
}
