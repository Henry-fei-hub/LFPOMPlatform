package pomplatform.mainProjectInfo.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BaseProjectNormalReimbursement;
import com.pomplatform.db.bean.BaseProjectNormalReimbursementDetail;
import com.pomplatform.db.bean.BaseNormalReimbursementLinkProject;
import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.bean.BaseProject;

public class BasePersonnelBusinessWithProject extends BasePersonnelBusines 
{

	public static BasePersonnelBusinessWithProject newInstance(){
		return new BasePersonnelBusinessWithProject();
	}

	@Override
	public BasePersonnelBusinessWithProject make(){
		BasePersonnelBusinessWithProject b = new BasePersonnelBusinessWithProject();
		return b;
	}

	public BasePersonnelBusines toBase(){
		BasePersonnelBusines base = new BasePersonnelBusines();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BasePersonnelBusines base){
		base.cloneCopy(this);
	}

//	public static List<BasePersonnelBusines> getBaseList(List<BasePersonnelBusines> beans) {
//		List<BasePersonnelBusines> result = new ArrayList<>();
//		if(beans == null || beans.isEmpty()) return result;
//		for(BasePersonnelBusines bean : beans) {
//			result.add(bean.toBase());
//		}
//		return result;
//	}

	public static List<BasePersonnelBusinessWithProject> getBeanList(List<BasePersonnelBusines> beans) {
		List<BasePersonnelBusinessWithProject> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BasePersonnelBusines bean : beans) {
			BasePersonnelBusinessWithProject val = new BasePersonnelBusinessWithProject();
			val.getDataFromBase(bean);
			result.add(val);
		}
		return result;
	}

	public List<BaseProject> getProjectRecords() {
		return __project_records;
	}

	public void setProjectRecords(List<BaseProject> __project_records) {
		this.__project_records = __project_records;
	}

	@Override
	public java.lang.String toJSONString() {

		int count = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		count = sb.length(); sb.append(__wrapList(count, "projectRecords", getProjectRecords()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("projectRecords")) != null) setProjectRecords(__getList(val, BaseProject.newInstance()));
	}

	protected List<BaseProject> __project_records ; 
	
	
	
}
