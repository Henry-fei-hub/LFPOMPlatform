package pomplatform.preProjects.bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.pomplatform.db.bean.BasePreProject;
import com.pomplatform.db.bean.BaseMainProjectBusinessType;
import com.pomplatform.db.bean.BaseMainProjectSpecialty;
import com.pomplatform.db.bean.BaseMainProjectCompetitionUnit;

public class BasePreProjectWithMmm extends BasePreProject 
{

	public static BasePreProjectWithMmm newInstance(){
		return new BasePreProjectWithMmm();
	}

	@Override
	public BasePreProjectWithMmm make(){
		BasePreProjectWithMmm b = new BasePreProjectWithMmm();
		return b;
	}

	public List<BaseMainProjectBusinessType> getDetailMainProjectBusinessType() {
		return this.__detail_main_project_business_types;
	}

	public void setDetailMainProjectBusinessType( List<BaseMainProjectBusinessType> value ) {
		this.__detail_main_project_business_types = value;
	}

	public List<BaseMainProjectSpecialty> getDetailMainProjectSpecialty() {
		return this.__detail_main_project_specialty;
	}

	public void setDetailMainProjectSpecialty( List<BaseMainProjectSpecialty> value ) {
		this.__detail_main_project_specialty = value;
	}

	public List<BaseMainProjectCompetitionUnit> getDetailMainProjectCompetitionUnit() {
		return this.__detail_main_project_competition_units;
	}

	public void setDetailMainProjectCompetitionUnit( List<BaseMainProjectCompetitionUnit> value ) {
		this.__detail_main_project_competition_units = value;
	}

	public BasePreProject toBase(){
		BasePreProject base = new BasePreProject();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BasePreProject base){
		base.cloneCopy(this);
	}

	public static List<BasePreProject> getBaseList(List<BasePreProjectWithMmm> beans) {
		List<BasePreProject> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BasePreProjectWithMmm bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BasePreProjectWithMmm> getBeanList(List<BasePreProject> beans) {
		List<BasePreProjectWithMmm> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BasePreProject bean : beans) {
			BasePreProjectWithMmm val = new BasePreProjectWithMmm();
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
		count = sb.length(); sb.append(__wrapList(count, "detailMainProjectBusinessType", getDetailMainProjectBusinessType()));
		count = sb.length(); sb.append(__wrapList(count, "detailMainProjectSpecialty", getDetailMainProjectSpecialty()));
		count = sb.length(); sb.append(__wrapList(count, "detailMainProjectCompetitionUnit", getDetailMainProjectCompetitionUnit()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailMainProjectBusinessType")) != null) setDetailMainProjectBusinessType(__getList(val, BaseMainProjectBusinessType.newInstance()));
		if((val = values.get("detailMainProjectSpecialty")) != null) setDetailMainProjectSpecialty(__getList(val, BaseMainProjectSpecialty.newInstance()));
		if((val = values.get("detailMainProjectCompetitionUnit")) != null) setDetailMainProjectCompetitionUnit(__getList(val, BaseMainProjectCompetitionUnit.newInstance()));
	}

	protected List<BaseMainProjectBusinessType> __detail_main_project_business_types ; 
	protected List<BaseMainProjectSpecialty> __detail_main_project_specialty ; 
	protected List<BaseMainProjectCompetitionUnit> __detail_main_project_competition_units ; 
}
