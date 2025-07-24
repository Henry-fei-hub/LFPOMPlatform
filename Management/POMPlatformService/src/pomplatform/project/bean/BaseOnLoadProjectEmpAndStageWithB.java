package pomplatform.project.bean;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import com.pomplatform.db.bean.BaseBudgetManagement;
import com.pomplatform.db.bean.BaseBudgetManagementDetail;

import delicacy.common.GenericBase;
import pomplatform.budgetmanagementworkflow.bean.BaseBudgetManagementWithB;
import delicacy.common.BaseFactory;

public class BaseOnLoadProjectEmpAndStageWithB extends BaseOnLoadProjectEmpAndStage 
{


	public static BaseOnLoadProjectEmpAndStageWithB newInstance(){
		return new BaseOnLoadProjectEmpAndStageWithB();
	}

	@Override
	public BaseOnLoadProjectEmpAndStageWithB make(){
		BaseOnLoadProjectEmpAndStageWithB b = new BaseOnLoadProjectEmpAndStageWithB();
		return b;
	}
	
	public List<BaseOnLoadProjectEmpAndStageListDetail> getStageDetail() {
		return __stage_detail;
	}

	public void setStageDetail(List<BaseOnLoadProjectEmpAndStageListDetail> __stage_detail) {
		this.__stage_detail = __stage_detail;
	}


	public BaseOnLoadProjectEmpAndStage toBase(){
		BaseOnLoadProjectEmpAndStage base = new BaseOnLoadProjectEmpAndStage();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseOnLoadProjectEmpAndStage base){
		base.cloneCopy(this);
	}

	public static List<BaseOnLoadProjectEmpAndStage> getBaseList(List<BaseOnLoadProjectEmpAndStageWithB> beans) {
		List<BaseOnLoadProjectEmpAndStage> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseOnLoadProjectEmpAndStageWithB bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseOnLoadProjectEmpAndStage> getBeanList(List<BaseOnLoadProjectEmpAndStageWithB> beans) {
		List<BaseOnLoadProjectEmpAndStage> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseOnLoadProjectEmpAndStageWithB bean : beans) {
			BaseOnLoadProjectEmpAndStageWithB val = new BaseOnLoadProjectEmpAndStageWithB();
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
		count = sb.length(); sb.append(__wrapList(count, "stageDetail", getStageDetail()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("stageDetail")) != null) setStageDetail(__getList(val, BaseOnLoadProjectEmpAndStageListDetail.newInstance()));
	}


	protected List<BaseOnLoadProjectEmpAndStageListDetail> __stage_detail ; 
}
