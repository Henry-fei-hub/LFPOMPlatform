package pomplatform.costallocation.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BaseResetCost;
import com.pomplatform.db.bean.BaseCostAllocation;

public class BaseResetCostWithC extends BaseResetCost 
{

	public static BaseResetCostWithC newInstance(){
		return new BaseResetCostWithC();
	}

	@Override
	public BaseResetCostWithC make(){
		BaseResetCostWithC b = new BaseResetCostWithC();
		return b;
	}

	public List<BaseCostAllocation> getDetailCostAllocation() {
		return this.__detail_cost_allocations;
	}

	public void setDetailCostAllocation( List<BaseCostAllocation> value ) {
		this.__detail_cost_allocations = value;
	}

	public BaseResetCost toBase(){
		BaseResetCost base = new BaseResetCost();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseResetCost base){
		base.cloneCopy(this);
	}

	public static List<BaseResetCost> getBaseList(List<BaseResetCostWithC> beans) {
		List<BaseResetCost> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseResetCostWithC bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseResetCostWithC> getBeanList(List<BaseResetCost> beans) {
		List<BaseResetCostWithC> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseResetCost bean : beans) {
			BaseResetCostWithC val = new BaseResetCostWithC();
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
		count = sb.length(); sb.append(__wrapList(count, "detailCostAllocation", getDetailCostAllocation()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailCostAllocation")) != null) setDetailCostAllocation(__getList(val, BaseCostAllocation.newInstance()));
	}

	protected List<BaseCostAllocation> __detail_cost_allocations ; 
}
