package pomplatform.workflow.personnelbusiness.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.bean.BaseCarCostAllocation;

public class BasePersonnelBusinesWithC extends BasePersonnelBusines 
{

	public static BasePersonnelBusinesWithC newInstance(){
		return new BasePersonnelBusinesWithC();
	}

	@Override
	public BasePersonnelBusinesWithC make(){
		BasePersonnelBusinesWithC b = new BasePersonnelBusinesWithC();
		return b;
	}

	public List<BaseCarCostAllocation> getDetailCarCostAllocation() {
		return this.__detail_car_cost_allocations;
	}

	public void setDetailCarCostAllocation( List<BaseCarCostAllocation> value ) {
		this.__detail_car_cost_allocations = value;
	}

	public BasePersonnelBusines toBase(){
		BasePersonnelBusines base = new BasePersonnelBusines();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BasePersonnelBusines base){
		base.cloneCopy(this);
	}

	public static List<BasePersonnelBusines> getBaseList(List<BasePersonnelBusinesWithC> beans) {
		List<BasePersonnelBusines> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BasePersonnelBusinesWithC bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BasePersonnelBusinesWithC> getBeanList(List<BasePersonnelBusines> beans) {
		List<BasePersonnelBusinesWithC> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BasePersonnelBusines bean : beans) {
			BasePersonnelBusinesWithC val = new BasePersonnelBusinesWithC();
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
		count = sb.length(); sb.append(__wrapList(count, "detailCarCostAllocation", getDetailCarCostAllocation()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailCarCostAllocation")) != null) setDetailCarCostAllocation(__getList(val, BaseCarCostAllocation.newInstance()));
	}

	protected List<BaseCarCostAllocation> __detail_car_cost_allocations ; 
}
