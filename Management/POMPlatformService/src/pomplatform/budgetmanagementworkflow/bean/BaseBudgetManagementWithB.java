package pomplatform.budgetmanagementworkflow.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BaseBudgetManagement;
import com.pomplatform.db.bean.BaseBudgetManagementDetail;

public class BaseBudgetManagementWithB extends BaseBudgetManagement 
{

	public static BaseBudgetManagementWithB newInstance(){
		return new BaseBudgetManagementWithB();
	}

	@Override
	public BaseBudgetManagementWithB make(){
		BaseBudgetManagementWithB b = new BaseBudgetManagementWithB();
		return b;
	}

	public List<BaseBudgetManagementDetail> getDetailBudgetManagementDetail() {
		return this.__detail_budget_management_detail;
	}

	public void setDetailBudgetManagementDetail( List<BaseBudgetManagementDetail> value ) {
		this.__detail_budget_management_detail = value;
	}

	public BaseBudgetManagement toBase(){
		BaseBudgetManagement base = new BaseBudgetManagement();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseBudgetManagement base){
		base.cloneCopy(this);
	}

	public static List<BaseBudgetManagement> getBaseList(List<BaseBudgetManagementWithB> beans) {
		List<BaseBudgetManagement> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseBudgetManagementWithB bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseBudgetManagementWithB> getBeanList(List<BaseBudgetManagement> beans) {
		List<BaseBudgetManagementWithB> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseBudgetManagement bean : beans) {
			BaseBudgetManagementWithB val = new BaseBudgetManagementWithB();
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
		count = sb.length(); sb.append(__wrapList(count, "detailBudgetManagementDetail", getDetailBudgetManagementDetail()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailBudgetManagementDetail")) != null) setDetailBudgetManagementDetail(__getList(val, BaseBudgetManagementDetail.newInstance()));
	}

	protected List<BaseBudgetManagementDetail> __detail_budget_management_detail ; 
}
