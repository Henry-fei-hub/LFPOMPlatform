package pomplatform.business.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import delicacy.system.bean.BaseSystemProcess;
import delicacy.system.bean.BaseSystemProcessDepartment;

public class BaseSystemProcessWithS extends BaseSystemProcess 
{

	public static BaseSystemProcessWithS newInstance(){
		return new BaseSystemProcessWithS();
	}

	@Override
	public BaseSystemProcessWithS make(){
		BaseSystemProcessWithS b = new BaseSystemProcessWithS();
		return b;
	}

	public List<BaseSystemProcessDepartment> getDetailSystemProcessDepartment() {
		return this.__detail_system_process_departments;
	}

	public void setDetailSystemProcessDepartment( List<BaseSystemProcessDepartment> value ) {
		this.__detail_system_process_departments = value;
	}

	public BaseSystemProcess toBase(){
		BaseSystemProcess base = new BaseSystemProcess();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseSystemProcess base){
		base.cloneCopy(this);
	}

	public static List<BaseSystemProcess> getBaseList(List<BaseSystemProcessWithS> beans) {
		List<BaseSystemProcess> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseSystemProcessWithS bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseSystemProcessWithS> getBeanList(List<BaseSystemProcess> beans) {
		List<BaseSystemProcessWithS> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseSystemProcess bean : beans) {
			BaseSystemProcessWithS val = new BaseSystemProcessWithS();
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
		count = sb.length(); sb.append(__wrapList(count, "detailSystemProcessDepartment", getDetailSystemProcessDepartment()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailSystemProcessDepartment")) != null) setDetailSystemProcessDepartment(__getList(val, BaseSystemProcessDepartment.newInstance()));
	}

	protected List<BaseSystemProcessDepartment> __detail_system_process_departments ; 
}
