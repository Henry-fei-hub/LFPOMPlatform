package pomplatform.companyarea.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BaseCompanyArea;
import com.pomplatform.db.bean.BaseCompanyRecord;
import com.pomplatform.db.bean.BaseArea;

public class BaseCompanyAreaWithCa extends BaseCompanyArea 
{

	public static BaseCompanyAreaWithCa newInstance(){
		return new BaseCompanyAreaWithCa();
	}

	@Override
	public BaseCompanyAreaWithCa make(){
		BaseCompanyAreaWithCa b = new BaseCompanyAreaWithCa();
		return b;
	}

	public List<BaseCompanyRecord> getDetailCompanyRecord() {
		return this.__detail_company_records;
	}

	public void setDetailCompanyRecord( List<BaseCompanyRecord> value ) {
		this.__detail_company_records = value;
	}

	public List<BaseArea> getDetailArea() {
		return this.__detail_areas;
	}

	public void setDetailArea( List<BaseArea> value ) {
		this.__detail_areas = value;
	}

	public BaseCompanyArea toBase(){
		BaseCompanyArea base = new BaseCompanyArea();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseCompanyArea base){
		base.cloneCopy(this);
	}

	public static List<BaseCompanyArea> getBaseList(List<BaseCompanyAreaWithCa> beans) {
		List<BaseCompanyArea> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseCompanyAreaWithCa bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseCompanyAreaWithCa> getBeanList(List<BaseCompanyArea> beans) {
		List<BaseCompanyAreaWithCa> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseCompanyArea bean : beans) {
			BaseCompanyAreaWithCa val = new BaseCompanyAreaWithCa();
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
		count = sb.length(); sb.append(__wrapList(count, "detailCompanyRecord", getDetailCompanyRecord()));
		count = sb.length(); sb.append(__wrapList(count, "detailArea", getDetailArea()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailCompanyRecord")) != null) setDetailCompanyRecord(__getList(val, BaseCompanyRecord.newInstance()));
		if((val = values.get("detailArea")) != null) setDetailArea(__getList(val, BaseArea.newInstance()));
	}

	protected List<BaseCompanyRecord> __detail_company_records ; 
	protected List<BaseArea> __detail_areas ; 
}
