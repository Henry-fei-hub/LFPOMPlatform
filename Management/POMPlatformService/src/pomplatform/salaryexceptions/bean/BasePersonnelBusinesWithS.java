package pomplatform.salaryexceptions.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.bean.BaseSalaryException;

public class BasePersonnelBusinesWithS extends BasePersonnelBusines 
{

	public static BasePersonnelBusinesWithS newInstance(){
		return new BasePersonnelBusinesWithS();
	}

	@Override
	public BasePersonnelBusinesWithS make(){
		BasePersonnelBusinesWithS b = new BasePersonnelBusinesWithS();
		return b;
	}

	public List<BaseSalaryException> getDetailSalaryException() {
		return this.__detail_salary_exceptions;
	}

	public void setDetailSalaryException( List<BaseSalaryException> value ) {
		this.__detail_salary_exceptions = value;
	}

	public BasePersonnelBusines toBase(){
		BasePersonnelBusines base = new BasePersonnelBusines();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BasePersonnelBusines base){
		base.cloneCopy(this);
	}

	public static List<BasePersonnelBusines> getBaseList(List<BasePersonnelBusinesWithS> beans) {
		List<BasePersonnelBusines> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BasePersonnelBusinesWithS bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BasePersonnelBusinesWithS> getBeanList(List<BasePersonnelBusines> beans) {
		List<BasePersonnelBusinesWithS> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BasePersonnelBusines bean : beans) {
			BasePersonnelBusinesWithS val = new BasePersonnelBusinesWithS();
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
		count = sb.length(); sb.append(__wrapList(count, "detailSalaryException", getDetailSalaryException()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailSalaryException")) != null) setDetailSalaryException(__getList(val, BaseSalaryException.newInstance()));
	}

	protected List<BaseSalaryException> __detail_salary_exceptions ; 
}
