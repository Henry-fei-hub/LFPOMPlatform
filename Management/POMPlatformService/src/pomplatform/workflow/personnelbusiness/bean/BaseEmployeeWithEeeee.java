package pomplatform.workflow.personnelbusiness.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pomplatform.db.bean.BaseEmployeeEducationInformation;
import com.pomplatform.db.bean.BaseEmployeeFamilyInformation;
import com.pomplatform.db.bean.BaseEmployeeRewardExperience;
import com.pomplatform.db.bean.BaseEmployeeTechnicalTitle;
import com.pomplatform.db.bean.BaseEmployeeWorkExperience;

import delicacy.system.bean.BaseEmployee;

public class BaseEmployeeWithEeeee extends BaseEmployee 
{

	public static BaseEmployeeWithEeeee newInstance(){
		return new BaseEmployeeWithEeeee();
	}

	@Override
	public BaseEmployeeWithEeeee make(){
		BaseEmployeeWithEeeee b = new BaseEmployeeWithEeeee();
		return b;
	}

	public List<BaseEmployeeEducationInformation> getDetailEmployeeEducationInformation() {
		return this.__detail_employee_education_informations;
	}

	public void setDetailEmployeeEducationInformation( List<BaseEmployeeEducationInformation> value ) {
		this.__detail_employee_education_informations = value;
	}

	public List<BaseEmployeeFamilyInformation> getDetailEmployeeFamilyInformation() {
		return this.__detail_employee_family_informations;
	}

	public void setDetailEmployeeFamilyInformation( List<BaseEmployeeFamilyInformation> value ) {
		this.__detail_employee_family_informations = value;
	}

	public List<BaseEmployeeRewardExperience> getDetailEmployeeRewardExperience() {
		return this.__detail_employee_reward_experiences;
	}

	public void setDetailEmployeeRewardExperience( List<BaseEmployeeRewardExperience> value ) {
		this.__detail_employee_reward_experiences = value;
	}

	public List<BaseEmployeeWorkExperience> getDetailEmployeeWorkExperience() {
		return this.__detail_employee_work_experiences;
	}

	public void setDetailEmployeeWorkExperience( List<BaseEmployeeWorkExperience> value ) {
		this.__detail_employee_work_experiences = value;
	}

	public List<BaseEmployeeTechnicalTitle> getDetailEmployeeTechnicalTitle() {
		return this.__detail_employee_technical_titles;
	}

	public void setDetailEmployeeTechnicalTitle( List<BaseEmployeeTechnicalTitle> value ) {
		this.__detail_employee_technical_titles = value;
	}

	public BaseEmployee toBase(){
		BaseEmployee base = new BaseEmployee();
		cloneCopy(base);
		return base;
	}

	public void getDataFromBase(BaseEmployee base){
		base.cloneCopy(this);
	}

	public static List<BaseEmployee> getBaseList(List<BaseEmployeeWithEeeee> beans) {
		List<BaseEmployee> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseEmployeeWithEeeee bean : beans) {
			result.add(bean.toBase());
		}
		return result;
	}

	public static List<BaseEmployeeWithEeeee> getBeanList(List<BaseEmployee> beans) {
		List<BaseEmployeeWithEeeee> result = new ArrayList<>();
		if(beans == null || beans.isEmpty()) return result;
		for(BaseEmployee bean : beans) {
			BaseEmployeeWithEeeee val = new BaseEmployeeWithEeeee();
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
		count = sb.length(); sb.append(__wrapList(count, "detailEmployeeEducationInformation", getDetailEmployeeEducationInformation()));
		count = sb.length(); sb.append(__wrapList(count, "detailEmployeeFamilyInformation", getDetailEmployeeFamilyInformation()));
		count = sb.length(); sb.append(__wrapList(count, "detailEmployeeRewardExperience", getDetailEmployeeRewardExperience()));
		count = sb.length(); sb.append(__wrapList(count, "detailEmployeeWorkExperience", getDetailEmployeeWorkExperience()));
		count = sb.length(); sb.append(__wrapList(count, "detailEmployeeTechnicalTitle", getDetailEmployeeTechnicalTitle()));
		return sb.toString() ;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if((val = values.get("detailEmployeeEducationInformation")) != null) setDetailEmployeeEducationInformation(__getList(val, BaseEmployeeEducationInformation.newInstance()));
		if((val = values.get("detailEmployeeFamilyInformation")) != null) setDetailEmployeeFamilyInformation(__getList(val, BaseEmployeeFamilyInformation.newInstance()));
		if((val = values.get("detailEmployeeRewardExperience")) != null) setDetailEmployeeRewardExperience(__getList(val, BaseEmployeeRewardExperience.newInstance()));
		if((val = values.get("detailEmployeeWorkExperience")) != null) setDetailEmployeeWorkExperience(__getList(val, BaseEmployeeWorkExperience.newInstance()));
		if((val = values.get("detailEmployeeTechnicalTitle")) != null) setDetailEmployeeTechnicalTitle(__getList(val, BaseEmployeeTechnicalTitle.newInstance()));
	}

	protected List<BaseEmployeeEducationInformation> __detail_employee_education_informations ; 
	protected List<BaseEmployeeFamilyInformation> __detail_employee_family_informations ; 
	protected List<BaseEmployeeRewardExperience> __detail_employee_reward_experiences ; 
	protected List<BaseEmployeeWorkExperience> __detail_employee_work_experiences ; 
	protected List<BaseEmployeeTechnicalTitle> __detail_employee_technical_titles ; 
}
