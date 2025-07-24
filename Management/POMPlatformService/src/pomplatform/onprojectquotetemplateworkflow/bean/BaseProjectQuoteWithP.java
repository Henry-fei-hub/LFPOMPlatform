package pomplatform.onprojectquotetemplateworkflow.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BaseProjectQuote;
import com.pomplatform.db.bean.BaseProjectQuoteDetail;

public class BaseProjectQuoteWithP extends BaseProjectQuote 
{

	public static BaseProjectQuoteWithP newInstance(){
		return new BaseProjectQuoteWithP();
	}

	@Override
	public BaseProjectQuoteWithP make(){
		BaseProjectQuoteWithP b = new BaseProjectQuoteWithP();
		return b;
	}

	public List<BaseProjectQuoteDetail> getDetailProjectQuoteDetail() {
		return this.__detail_project_quote_details;
	}

	public void setDetailProjectQuoteDetail( List<BaseProjectQuoteDetail> value ) {
		this.__detail_project_quote_details = value;
	}

	public BaseProjectQuote toBase(){
		BaseProjectQuote base = new BaseProjectQuote();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseProjectQuote base){
		base.cloneCopy(this);
	}

	public static List<BaseProjectQuote> getBaseList(List<BaseProjectQuoteWithP> beans) {
		List<BaseProjectQuote> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseProjectQuoteWithP bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseProjectQuoteWithP> getBeanList(List<BaseProjectQuote> beans) {
		List<BaseProjectQuoteWithP> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseProjectQuote bean : beans) {
			BaseProjectQuoteWithP val = new BaseProjectQuoteWithP();
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
		count = sb.length(); sb.append(__wrapList(count, "detailProjectQuoteDetail", getDetailProjectQuoteDetail()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailProjectQuoteDetail")) != null) setDetailProjectQuoteDetail(__getList(val, BaseProjectQuoteDetail.newInstance()));
	}

	protected List<BaseProjectQuoteDetail> __detail_project_quote_details ; 
}
