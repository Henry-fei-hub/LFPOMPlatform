package pomplatform.cwd.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pomplatform.db.bean.BaseCompanyWorkplace;
import com.pomplatform.db.bean.BaseCompanyWorkplaceServer;


public class BaseCompanyWorkplaceWithC extends BaseCompanyWorkplace 
{

	public static BaseCompanyWorkplaceWithC newInstance(){
		return new BaseCompanyWorkplaceWithC();
	}

	@Override
	public BaseCompanyWorkplaceWithC make(){
		BaseCompanyWorkplaceWithC b = new BaseCompanyWorkplaceWithC();
		return b;
	}

	public List<BaseCompanyWorkplaceServer> getDetailCompanyWorkplaceServer() {
		return this.__detail_company_workplace_servers;
	}

	public void setDetailCompanyWorkplaceServer( List<BaseCompanyWorkplaceServer> value ) {
		this.__detail_company_workplace_servers = value;
	}

	public BaseCompanyWorkplace toBase(){
		BaseCompanyWorkplace base = new BaseCompanyWorkplace();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseCompanyWorkplace base){
		base.cloneCopy(this);
	}

	public static List<BaseCompanyWorkplace> getBaseList(List<BaseCompanyWorkplaceWithC> beans) {
		List<BaseCompanyWorkplace> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseCompanyWorkplaceWithC bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseCompanyWorkplaceWithC> getBeanList(List<BaseCompanyWorkplace> beans) {
		List<BaseCompanyWorkplaceWithC> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseCompanyWorkplace bean : beans) {
			BaseCompanyWorkplaceWithC val = new BaseCompanyWorkplaceWithC();
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
		count = sb.length(); sb.append(__wrapList(count, "detailCompanyWorkplaceServer", getDetailCompanyWorkplaceServer()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailCompanyWorkplaceServer")) != null) setDetailCompanyWorkplaceServer(__getList(val, BaseCompanyWorkplaceServer.newInstance()));
	}

	protected List<BaseCompanyWorkplaceServer> __detail_company_workplace_servers ; 
}
