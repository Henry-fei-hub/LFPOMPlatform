package pomplatform.ht.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BaseOutQuotation;
import com.pomplatform.db.bean.BaseOutDesignConsideration;

public class BaseOutQuotationWithO extends BaseOutQuotation 
{

	public static BaseOutQuotationWithO newInstance(){
		return new BaseOutQuotationWithO();
	}

	@Override
	public BaseOutQuotationWithO make(){
		BaseOutQuotationWithO b = new BaseOutQuotationWithO();
		return b;
	}

	public List<BaseOutDesignConsideration> getDetailOutDesignConsideration() {
		return this.__detail_out_design_considerations;
	}

	public void setDetailOutDesignConsideration( List<BaseOutDesignConsideration> value ) {
		this.__detail_out_design_considerations = value;
	}

	public BaseOutQuotation toBase(){
		BaseOutQuotation base = new BaseOutQuotation();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseOutQuotation base){
		base.cloneCopy(this);
	}

	public static List<BaseOutQuotation> getBaseList(List<BaseOutQuotationWithO> beans) {
		List<BaseOutQuotation> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseOutQuotationWithO bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseOutQuotationWithO> getBeanList(List<BaseOutQuotation> beans) {
		List<BaseOutQuotationWithO> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseOutQuotation bean : beans) {
			BaseOutQuotationWithO val = new BaseOutQuotationWithO();
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
		count = sb.length(); sb.append(__wrapList(count, "detailOutDesignConsideration", getDetailOutDesignConsideration()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailOutDesignConsideration")) != null) setDetailOutDesignConsideration(__getList(val, BaseOutDesignConsideration.newInstance()));
	}

	protected List<BaseOutDesignConsideration> __detail_out_design_considerations ; 
}
