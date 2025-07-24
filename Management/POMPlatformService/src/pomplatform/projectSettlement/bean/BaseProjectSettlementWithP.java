package pomplatform.projectSettlement.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pomplatform.db.bean.BaseEmployee;
import com.pomplatform.db.bean.BaseProjectSettlement;
import com.pomplatform.db.bean.BaseProjectSettlementDetail;

public class BaseProjectSettlementWithP extends BaseProjectSettlement 
{

	public static BaseProjectSettlementWithP newInstance(){
		return new BaseProjectSettlementWithP();
	}

	@Override
	public BaseProjectSettlementWithP make(){
		BaseProjectSettlementWithP b = new BaseProjectSettlementWithP();
		return b;
	}

	public List<BaseProjectSettlementDetail> getDetailProjectSettlementDetail() {
		return this.__detail_project_settlement_details;
	}

	public void setDetailProjectSettlementDetail( List<BaseProjectSettlementDetail> value ) {
		this.__detail_project_settlement_details = value;
	}

	public String getOurEmployees() {
		return ourEmployees;
	}

	public void setOurEmployees(String ourEmployees) {
		this.ourEmployees = ourEmployees;
	}

	public BaseProjectSettlement toBase(){
		BaseProjectSettlement base = new BaseProjectSettlement();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseProjectSettlement base){
		base.cloneCopy(this);
	}

	public static List<BaseProjectSettlement> getBaseList(List<BaseProjectSettlementWithP> beans) {
		List<BaseProjectSettlement> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseProjectSettlementWithP bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseProjectSettlementWithP> getBeanList(List<BaseProjectSettlement> beans) {
		List<BaseProjectSettlementWithP> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseProjectSettlement bean : beans) {
			BaseProjectSettlementWithP val = new BaseProjectSettlementWithP();
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
		count = sb.length(); sb.append(__wrapList(count, "detailProjectSettlementDetail", getDetailProjectSettlementDetail()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailProjectSettlementDetail")) != null) setDetailProjectSettlementDetail(__getList(val, BaseProjectSettlementDetail.newInstance()));
	}

	protected List<BaseProjectSettlementDetail> __detail_project_settlement_details ; 
	protected String ourEmployees ="";
}
