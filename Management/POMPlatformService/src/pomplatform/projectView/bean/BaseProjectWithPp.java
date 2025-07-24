package pomplatform.projectView.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectEmployee;
import com.pomplatform.db.bean.BaseProjectCost;

public class BaseProjectWithPp extends BaseProject 
{

	public static BaseProjectWithPp newInstance(){
		return new BaseProjectWithPp();
	}

	@Override
	public BaseProjectWithPp make(){
		BaseProjectWithPp b = new BaseProjectWithPp();
		return b;
	}

	public List<BaseProjectEmployee> getDetailProjectEmployee() {
		return this.__detail_project_employees;
	}

	public void setDetailProjectEmployee( List<BaseProjectEmployee> value ) {
		this.__detail_project_employees = value;
	}

	public List<BaseProjectCost> getDetailProjectCost() {
		return this.__detail_project_cost;
	}

	public void setDetailProjectCost( List<BaseProjectCost> value ) {
		this.__detail_project_cost = value;
	}

	public BaseProject toBase(){
		BaseProject base = new BaseProject();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseProject base){
		base.cloneCopy(this);
	}

	public static List<BaseProject> getBaseList(List<BaseProjectWithPp> beans) {
		List<BaseProject> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseProjectWithPp bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseProjectWithPp> getBeanList(List<BaseProject> beans) {
		List<BaseProjectWithPp> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseProject bean : beans) {
			BaseProjectWithPp val = new BaseProjectWithPp();
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
		count = sb.length(); sb.append(__wrapList(count, "detailProjectCost", getDetailProjectCost()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailProjectEmployee")) != null) setDetailProjectEmployee(__getList(val, BaseProjectEmployee.newInstance()));
		if((val = values.get("detailProjectCost")) != null) setDetailProjectCost(__getList(val, BaseProjectCost.newInstance()));
	}

	protected List<BaseProjectEmployee> __detail_project_employees ; 
	protected List<BaseProjectCost> __detail_project_cost ; 
}
