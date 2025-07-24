package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeTechnicalTitle;
import com.pomplatform.db.dao.EmployeeTechnicalTitle;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeeTechnicalTitleHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeTechnicalTitleHandler.class);

	public static BaseEmployeeTechnicalTitle getEmployeeTechnicalTitleById( 
		java.lang.Integer employee_technical_title_id
	) throws Exception
	{
		EmployeeTechnicalTitle dao = new EmployeeTechnicalTitle();
		dao.setEmployeeTechnicalTitleId(employee_technical_title_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeTechnicalTitleExists( com.pomplatform.db.bean.BaseEmployeeTechnicalTitle bean, String additional ) throws Exception {

		EmployeeTechnicalTitle dao = new EmployeeTechnicalTitle();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeTechnicalTitle( com.pomplatform.db.bean.BaseEmployeeTechnicalTitle bean, String additional ) throws Exception {

		EmployeeTechnicalTitle dao = new EmployeeTechnicalTitle();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeTechnicalTitle> queryEmployeeTechnicalTitle( com.pomplatform.db.bean.BaseEmployeeTechnicalTitle bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeTechnicalTitle dao = new EmployeeTechnicalTitle();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeTechnicalTitle> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeTechnicalTitle> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeTechnicalTitle addToEmployeeTechnicalTitle ( BaseEmployeeTechnicalTitle employeetechnicaltitle )  throws Exception {
		return addToEmployeeTechnicalTitle ( employeetechnicaltitle , false);
	}

	public static BaseEmployeeTechnicalTitle addToEmployeeTechnicalTitle ( BaseEmployeeTechnicalTitle employeetechnicaltitle, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeTechnicalTitle dao = new EmployeeTechnicalTitle();
		dao.setDataFromBase(employeetechnicaltitle);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeTechnicalTitle addUpdateEmployeeTechnicalTitle ( BaseEmployeeTechnicalTitle employeetechnicaltitle ) throws Exception {
		return addUpdateEmployeeTechnicalTitle ( employeetechnicaltitle , false);
	}

	public static BaseEmployeeTechnicalTitle addUpdateEmployeeTechnicalTitle ( BaseEmployeeTechnicalTitle employeetechnicaltitle, boolean singleTransaction  ) throws Exception {
		if(employeetechnicaltitle.getEmployeeTechnicalTitleId() == null) return addToEmployeeTechnicalTitle(employeetechnicaltitle);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeTechnicalTitle dao = new EmployeeTechnicalTitle();
		dao.setDataFromBase(employeetechnicaltitle);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeetechnicaltitle); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeTechnicalTitle ( BaseEmployeeTechnicalTitle bean ) throws Exception {
		EmployeeTechnicalTitle dao = new EmployeeTechnicalTitle();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeTechnicalTitle updateEmployeeTechnicalTitle ( BaseEmployeeTechnicalTitle employeetechnicaltitle ) throws Exception {
		EmployeeTechnicalTitle dao = new EmployeeTechnicalTitle();
		dao.setEmployeeTechnicalTitleId( employeetechnicaltitle.getEmployeeTechnicalTitleId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeetechnicaltitle);
			result = dao.update();
		}
		return result == 1 ? employeetechnicaltitle : null ;
	}

	public static BaseEmployeeTechnicalTitle updateEmployeeTechnicalTitleDirect( BaseEmployeeTechnicalTitle employeetechnicaltitle ) throws Exception {
		EmployeeTechnicalTitle dao = new EmployeeTechnicalTitle();
		int result = 0;
		dao.setDataFromBase(employeetechnicaltitle);
		result = dao.update();
		return result == 1 ? employeetechnicaltitle : null ;
	}

	public static int setDeleteConditions(BaseEmployeeTechnicalTitle bean, EmployeeTechnicalTitle dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeTechnicalTitleId() != null) {
			dao.setConditionEmployeeTechnicalTitleId("=", bean.getEmployeeTechnicalTitleId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getTechnicalTitles() != null) {
				dao.setConditionTechnicalTitles("=", bean.getTechnicalTitles());
				count++;
			}
			if(bean.getTechnicalSpecialty() != null) {
				dao.setConditionTechnicalSpecialty("=", bean.getTechnicalSpecialty());
				count++;
			}
			if(bean.getTechnicalLevel() != null) {
				dao.setConditionTechnicalLevel("=", bean.getTechnicalLevel());
				count++;
			}
			if(bean.getAttachment() != null) {
				dao.setConditionAttachment("=", bean.getAttachment());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEmployeeTechnicalTitle bean, EmployeeTechnicalTitle dao){
		int count = 0;
		if(bean.getEmployeeTechnicalTitleId() != null) {
			dao.setConditionEmployeeTechnicalTitleId("=", bean.getEmployeeTechnicalTitleId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getTechnicalTitles() != null) {
			if(bean.getTechnicalTitles().indexOf("%") >= 0)
				dao.setConditionTechnicalTitles("like", bean.getTechnicalTitles());
			else
				dao.setConditionTechnicalTitles("=", bean.getTechnicalTitles());
			count++;
		}
		if(bean.getTechnicalSpecialty() != null) {
			if(bean.getTechnicalSpecialty().indexOf("%") >= 0)
				dao.setConditionTechnicalSpecialty("like", bean.getTechnicalSpecialty());
			else
				dao.setConditionTechnicalSpecialty("=", bean.getTechnicalSpecialty());
			count++;
		}
		if(bean.getTechnicalLevel() != null) {
			if(bean.getTechnicalLevel().indexOf("%") >= 0)
				dao.setConditionTechnicalLevel("like", bean.getTechnicalLevel());
			else
				dao.setConditionTechnicalLevel("=", bean.getTechnicalLevel());
			count++;
		}
		if(bean.getAssessmentTime() != null) {
			dao.setConditionAssessmentTime(">=", bean.getAssessmentTime());
			count++;
		}
		if(bean.getAttachment() != null) {
			if(bean.getAttachment().indexOf("%") >= 0)
				dao.setConditionAttachment("like", bean.getAttachment());
			else
				dao.setConditionAttachment("=", bean.getAttachment());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseEmployeeTechnicalTitle bean = new BaseEmployeeTechnicalTitle();
		bean.setDataFromJSON(json);
		EmployeeTechnicalTitle dao = new EmployeeTechnicalTitle();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeTechnicalTitle> rlist = new BaseCollection<>();
		BaseEmployeeTechnicalTitle bean = new BaseEmployeeTechnicalTitle();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeTechnicalTitle dao = new EmployeeTechnicalTitle();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeTechnicalTitle> result = dao.conditionalLoad(addtion);
		rlist.setCollections(result);
		rlist.setTotalPages(dao.getTotalPages());
		rlist.setCurrentPage(dao.getCurrentPage());
		rlist.setPageLines(dao.getPageLines());
		rlist.setTotalLines(dao.getTotalLines());
		rlist.setRecordNumber(result.size());
		return rlist.toJSON(null);
	}

	@Override
	public String save(String json) throws Exception{
		BaseEmployeeTechnicalTitle bean = new BaseEmployeeTechnicalTitle();
		bean.setDataFromJSON(json);
		EmployeeTechnicalTitle dao = new EmployeeTechnicalTitle();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeTechnicalTitle bean = new BaseEmployeeTechnicalTitle();
		bean.setDataFromJSON(json);
		EmployeeTechnicalTitle dao = new EmployeeTechnicalTitle();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeTechnicalTitle bean = new BaseEmployeeTechnicalTitle();
		bean.setDataFromJSON(json);
		EmployeeTechnicalTitle dao = new EmployeeTechnicalTitle();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeTechnicalTitle bean = new BaseEmployeeTechnicalTitle();
		bean.setDataFromJSON(json);
		EmployeeTechnicalTitle dao = new EmployeeTechnicalTitle();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


