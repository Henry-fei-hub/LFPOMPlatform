package pomplatform.purchase.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BasePaymentTemplate;
import com.pomplatform.db.bean.BasePaymentTemplateDetail;

public class BasePaymentTemplateWithP extends BasePaymentTemplate 
{

	public static BasePaymentTemplateWithP newInstance(){
		return new BasePaymentTemplateWithP();
	}

	@Override
	public BasePaymentTemplateWithP make(){
		BasePaymentTemplateWithP b = new BasePaymentTemplateWithP();
		return b;
	}

	public List<BasePaymentTemplateDetail> getDetailPaymentTemplateDetail() {
		return this.__detail_payment_template_details;
	}

	public void setDetailPaymentTemplateDetail( List<BasePaymentTemplateDetail> value ) {
		this.__detail_payment_template_details = value;
	}

	public BasePaymentTemplate toBase(){
		BasePaymentTemplate base = new BasePaymentTemplate();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BasePaymentTemplate base){
		base.cloneCopy(this);
	}

	public static List<BasePaymentTemplate> getBaseList(List<BasePaymentTemplateWithP> beans) {
		List<BasePaymentTemplate> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BasePaymentTemplateWithP bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BasePaymentTemplateWithP> getBeanList(List<BasePaymentTemplate> beans) {
		List<BasePaymentTemplateWithP> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BasePaymentTemplate bean : beans) {
			BasePaymentTemplateWithP val = new BasePaymentTemplateWithP();
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
		count = sb.length(); sb.append(__wrapList(count, "detailPaymentTemplateDetail", getDetailPaymentTemplateDetail()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailPaymentTemplateDetail")) != null) setDetailPaymentTemplateDetail(__getList(val, BasePaymentTemplateDetail.newInstance()));
	}

	protected List<BasePaymentTemplateDetail> __detail_payment_template_details ; 
}
