package pomplatform.ht2.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BaseFormalContract;
import com.pomplatform.db.bean.BaseOutDesignConsideration;

public class BaseFormalContractWithO extends BaseFormalContract 
{

	public static BaseFormalContractWithO newInstance(){
		return new BaseFormalContractWithO();
	}

	@Override
	public BaseFormalContractWithO make(){
		BaseFormalContractWithO b = new BaseFormalContractWithO();
		return b;
	}

	public List<BaseOutDesignConsideration> getDetailOutDesignConsideration() {
		return this.__detail_out_design_considerations;
	}

	public void setDetailOutDesignConsideration( List<BaseOutDesignConsideration> value ) {
		this.__detail_out_design_considerations = value;
	}

	public BaseFormalContract toBase(){
		BaseFormalContract base = new BaseFormalContract();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseFormalContract base){
		base.cloneCopy(this);
	}

	public static List<BaseFormalContract> getBaseList(List<BaseFormalContractWithO> beans) {
		List<BaseFormalContract> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseFormalContractWithO bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseFormalContractWithO> getBeanList(List<BaseFormalContract> beans) {
		List<BaseFormalContractWithO> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseFormalContract bean : beans) {
			BaseFormalContractWithO val = new BaseFormalContractWithO();
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
