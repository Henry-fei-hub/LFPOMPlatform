package pomplatform.plateproductionvalue.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BaseProductionValueCoefficientType;
import com.pomplatform.db.bean.BaseProductionValueCoefficient;

public class BaseProductionValueCoefficientTypeWithP extends BaseProductionValueCoefficientType 
{

	public static BaseProductionValueCoefficientTypeWithP newInstance(){
		return new BaseProductionValueCoefficientTypeWithP();
	}

	@Override
	public BaseProductionValueCoefficientTypeWithP make(){
		BaseProductionValueCoefficientTypeWithP b = new BaseProductionValueCoefficientTypeWithP();
		return b;
	}

	public List<BaseProductionValueCoefficient> getDetailProductionValueCoefficient() {
		return this.__detail_production_value_coefficients;
	}

	public void setDetailProductionValueCoefficient( List<BaseProductionValueCoefficient> value ) {
		this.__detail_production_value_coefficients = value;
	}

	public BaseProductionValueCoefficientType toBase(){
		BaseProductionValueCoefficientType base = new BaseProductionValueCoefficientType();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseProductionValueCoefficientType base){
		base.cloneCopy(this);
	}

	public static List<BaseProductionValueCoefficientType> getBaseList(List<BaseProductionValueCoefficientTypeWithP> beans) {
		List<BaseProductionValueCoefficientType> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseProductionValueCoefficientTypeWithP bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseProductionValueCoefficientTypeWithP> getBeanList(List<BaseProductionValueCoefficientType> beans) {
		List<BaseProductionValueCoefficientTypeWithP> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseProductionValueCoefficientType bean : beans) {
			BaseProductionValueCoefficientTypeWithP val = new BaseProductionValueCoefficientTypeWithP();
			val.getDataFromBase(bean);
			result.add(val);
		}
		return result;
	}

	@Override
	public String toJSONString() {

		int count = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		count = sb.length(); sb.append(__wrapList(count, "detailProductionValueCoefficient", getDetailProductionValueCoefficient()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailProductionValueCoefficient")) != null) setDetailProductionValueCoefficient(__getList(val, BaseProductionValueCoefficient.newInstance()));
	}

	protected List<BaseProductionValueCoefficient> __detail_production_value_coefficients ; 
}
