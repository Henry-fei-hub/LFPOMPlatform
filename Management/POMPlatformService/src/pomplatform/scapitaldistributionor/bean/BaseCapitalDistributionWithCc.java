package pomplatform.scapitaldistributionor.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BaseCapitalDistribution;
import com.pomplatform.db.bean.BaseCapitalDistributionLinkDepartment;
import com.pomplatform.db.bean.BaseCapitalDistributionLinkSubContract;

public class BaseCapitalDistributionWithCc extends BaseCapitalDistribution 
{

	public static BaseCapitalDistributionWithCc newInstance(){
		return new BaseCapitalDistributionWithCc();
	}

	@Override
	public BaseCapitalDistributionWithCc make(){
		BaseCapitalDistributionWithCc b = new BaseCapitalDistributionWithCc();
		return b;
	}

	public List<BaseCapitalDistributionLinkDepartment> getDetailCapitalDistributionLinkDepartment() {
		return this.__detail_capital_distribution_link_departments;
	}

	public void setDetailCapitalDistributionLinkDepartment( List<BaseCapitalDistributionLinkDepartment> value ) {
		this.__detail_capital_distribution_link_departments = value;
	}

	public List<BaseCapitalDistributionLinkSubContract> getDetailCapitalDistributionLinkSubContract() {
		return this.__detail_capital_distribution_link_sub_contracts;
	}

	public void setDetailCapitalDistributionLinkSubContract( List<BaseCapitalDistributionLinkSubContract> value ) {
		this.__detail_capital_distribution_link_sub_contracts = value;
	}

	public BaseCapitalDistribution toBase(){
		BaseCapitalDistribution base = new BaseCapitalDistribution();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseCapitalDistribution base){
		base.cloneCopy(this);
	}

	public static List<BaseCapitalDistribution> getBaseList(List<BaseCapitalDistributionWithCc> beans) {
		List<BaseCapitalDistribution> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseCapitalDistributionWithCc bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseCapitalDistributionWithCc> getBeanList(List<BaseCapitalDistribution> beans) {
		List<BaseCapitalDistributionWithCc> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseCapitalDistribution bean : beans) {
			BaseCapitalDistributionWithCc val = new BaseCapitalDistributionWithCc();
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
		count = sb.length(); sb.append(__wrapList(count, "detailCapitalDistributionLinkDepartment", getDetailCapitalDistributionLinkDepartment()));
		count = sb.length(); sb.append(__wrapList(count, "detailCapitalDistributionLinkSubContract", getDetailCapitalDistributionLinkSubContract()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailCapitalDistributionLinkDepartment")) != null) setDetailCapitalDistributionLinkDepartment(__getList(val, BaseCapitalDistributionLinkDepartment.newInstance()));
		if((val = values.get("detailCapitalDistributionLinkSubContract")) != null) setDetailCapitalDistributionLinkSubContract(__getList(val, BaseCapitalDistributionLinkSubContract.newInstance()));
	}

	protected List<BaseCapitalDistributionLinkDepartment> __detail_capital_distribution_link_departments ; 
	protected List<BaseCapitalDistributionLinkSubContract> __detail_capital_distribution_link_sub_contracts ; 
}
