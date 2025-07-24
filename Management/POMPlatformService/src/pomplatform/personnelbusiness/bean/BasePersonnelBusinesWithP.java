package pomplatform.personnelbusiness.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.bean.BaseProjectEmployee;

public class BasePersonnelBusinesWithP extends BasePersonnelBusines 
{

	public static BasePersonnelBusinesWithP newInstance(){
		return new BasePersonnelBusinesWithP();
	}

	@Override
	public BasePersonnelBusinesWithP make(){
		BasePersonnelBusinesWithP b = new BasePersonnelBusinesWithP();
		return b;
	}

	public List<BaseProjectEmployee> getDetailProjectEmployee() {
		return this.__detail_project_employees;
	}

	public void setDetailProjectEmployee( List<BaseProjectEmployee> value ) {
		this.__detail_project_employees = value;
	}

	public BasePersonnelBusines toBase(){
		BasePersonnelBusines base = new BasePersonnelBusines();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BasePersonnelBusines base){
		base.cloneCopy(this);
	}

	public static List<BasePersonnelBusines> getBaseList(List<BasePersonnelBusinesWithP> beans) {
		List<BasePersonnelBusines> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BasePersonnelBusinesWithP bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BasePersonnelBusinesWithP> getBeanList(List<BasePersonnelBusines> beans) {
		List<BasePersonnelBusinesWithP> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BasePersonnelBusines bean : beans) {
			BasePersonnelBusinesWithP val = new BasePersonnelBusinesWithP();
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
		count = sb.length(); sb.append(__wrapList(count, "detailProjectEmployee", getDetailProjectEmployee()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailProjectEmployee")) != null) setDetailProjectEmployee(__getList(val, BaseProjectEmployee.newInstance()));
	}

	protected List<BaseProjectEmployee> __detail_project_employees ; 
}
