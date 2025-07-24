package pomplatform.purchase.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BaseProduct;
import com.pomplatform.db.bean.BaseProductAttribute;

public class BaseProductWithP extends BaseProduct 
{

	public static BaseProductWithP newInstance(){
		return new BaseProductWithP();
	}

	@Override
	public BaseProductWithP make(){
		BaseProductWithP b = new BaseProductWithP();
		return b;
	}

	public List<BaseProductAttribute> getDetailProductAttribute() {
		return this.__detail_product_attributes;
	}

	public void setDetailProductAttribute( List<BaseProductAttribute> value ) {
		this.__detail_product_attributes = value;
	}

	public BaseProduct toBase(){
		BaseProduct base = new BaseProduct();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseProduct base){
		base.cloneCopy(this);
	}

	public static List<BaseProduct> getBaseList(List<BaseProductWithP> beans) {
		List<BaseProduct> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseProductWithP bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseProductWithP> getBeanList(List<BaseProduct> beans) {
		List<BaseProductWithP> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseProduct bean : beans) {
			BaseProductWithP val = new BaseProductWithP();
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
		count = sb.length(); sb.append(__wrapList(count, "detailProductAttribute", getDetailProductAttribute()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailProductAttribute")) != null) setDetailProductAttribute(__getList(val, BaseProductAttribute.newInstance()));
	}

	protected List<BaseProductAttribute> __detail_product_attributes ; 
}
