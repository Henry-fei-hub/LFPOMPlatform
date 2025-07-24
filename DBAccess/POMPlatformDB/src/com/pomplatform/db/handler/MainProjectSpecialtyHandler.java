package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseMainProjectSpecialty;
import java.util.List;
import com.pomplatform.db.dao.MainProjectSpecialty;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class MainProjectSpecialtyHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(MainProjectSpecialtyHandler.class);

	public static BaseMainProjectSpecialty getMainProjectSpecialtyById( 
		java.lang.Integer main_project_specialty_id
	) throws Exception
	{
		MainProjectSpecialty dao = new MainProjectSpecialty();
		dao.setMainProjectSpecialtyId(main_project_specialty_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isMainProjectSpecialtyExists( com.pomplatform.db.bean.BaseMainProjectSpecialty bean, String additional ) throws Exception {

		MainProjectSpecialty dao = new MainProjectSpecialty();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countMainProjectSpecialty( com.pomplatform.db.bean.BaseMainProjectSpecialty bean, String additional ) throws Exception {

		MainProjectSpecialty dao = new MainProjectSpecialty();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseMainProjectSpecialty> queryMainProjectSpecialty( com.pomplatform.db.bean.BaseMainProjectSpecialty bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		MainProjectSpecialty dao = new MainProjectSpecialty();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseMainProjectSpecialty> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseMainProjectSpecialty> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseMainProjectSpecialty addToMainProjectSpecialty ( BaseMainProjectSpecialty mainprojectspecialty )  throws Exception {
		return addToMainProjectSpecialty ( mainprojectspecialty , false);
	}

	public static BaseMainProjectSpecialty addToMainProjectSpecialty ( BaseMainProjectSpecialty mainprojectspecialty, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		MainProjectSpecialty dao = new MainProjectSpecialty();
		dao.setDataFromBase(mainprojectspecialty);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseMainProjectSpecialty addUpdateMainProjectSpecialty ( BaseMainProjectSpecialty mainprojectspecialty ) throws Exception {
		return addUpdateMainProjectSpecialty ( mainprojectspecialty , false);
	}

	public static BaseMainProjectSpecialty addUpdateMainProjectSpecialty ( BaseMainProjectSpecialty mainprojectspecialty, boolean singleTransaction  ) throws Exception {
		if(mainprojectspecialty.getMainProjectSpecialtyId() == null) return addToMainProjectSpecialty(mainprojectspecialty);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		MainProjectSpecialty dao = new MainProjectSpecialty();
		dao.setDataFromBase(mainprojectspecialty);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(mainprojectspecialty); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteMainProjectSpecialty ( BaseMainProjectSpecialty bean ) throws Exception {
		MainProjectSpecialty dao = new MainProjectSpecialty();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseMainProjectSpecialty updateMainProjectSpecialty ( BaseMainProjectSpecialty mainprojectspecialty ) throws Exception {
		MainProjectSpecialty dao = new MainProjectSpecialty();
		dao.setMainProjectSpecialtyId( mainprojectspecialty.getMainProjectSpecialtyId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(mainprojectspecialty);
			result = dao.update();
		}
		return result == 1 ? mainprojectspecialty : null ;
	}

	public static BaseMainProjectSpecialty updateMainProjectSpecialtyDirect( BaseMainProjectSpecialty mainprojectspecialty ) throws Exception {
		MainProjectSpecialty dao = new MainProjectSpecialty();
		int result = 0;
		dao.setDataFromBase(mainprojectspecialty);
		result = dao.update();
		return result == 1 ? mainprojectspecialty : null ;
	}

	public static int setDeleteConditions(BaseMainProjectSpecialty bean, MainProjectSpecialty dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getMainProjectSpecialtyId() != null) {
			dao.setConditionMainProjectSpecialtyId("=", bean.getMainProjectSpecialtyId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
			if(bean.getSpecialtyId() != null) {
				dao.setConditionSpecialtyId("=", bean.getSpecialtyId());
				count++;
			}
			if(bean.getPreProjectId() != null) {
				dao.setConditionPreProjectId("=", bean.getPreProjectId());
				count++;
			}
			if(bean.getRegistrationSealEmployeeId() != null) {
				dao.setConditionRegistrationSealEmployeeId("=", bean.getRegistrationSealEmployeeId());
				count++;
			}
			if(bean.getIsOutsourcing() != null) {
				dao.setConditionIsOutsourcing("=", bean.getIsOutsourcing());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseMainProjectSpecialty bean, MainProjectSpecialty dao){
		int count = 0;
		if(bean.getMainProjectSpecialtyId() != null) {
			dao.setConditionMainProjectSpecialtyId("=", bean.getMainProjectSpecialtyId());
			count++;
		}
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		if(bean.getSpecialtyId() != null) {
			dao.setConditionSpecialtyId("=", bean.getSpecialtyId());
			count++;
		}
		if(bean.getPreProjectId() != null) {
			dao.setConditionPreProjectId("=", bean.getPreProjectId());
			count++;
		}
		if(bean.getRegistrationSealEmployeeId() != null) {
			dao.setConditionRegistrationSealEmployeeId("=", bean.getRegistrationSealEmployeeId());
			count++;
		}
		if(bean.getIsOutsourcing() != null) {
			dao.setConditionIsOutsourcing("=", bean.getIsOutsourcing());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseMainProjectSpecialty bean = new BaseMainProjectSpecialty();
		bean.setDataFromJSON(json);
		MainProjectSpecialty dao = new MainProjectSpecialty();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseMainProjectSpecialty> rlist = new BaseCollection<>();
		BaseMainProjectSpecialty bean = new BaseMainProjectSpecialty();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		MainProjectSpecialty dao = new MainProjectSpecialty();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseMainProjectSpecialty> result = dao.conditionalLoad(addtion);
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
		BaseMainProjectSpecialty bean = new BaseMainProjectSpecialty();
		bean.setDataFromJSON(json);
		MainProjectSpecialty dao = new MainProjectSpecialty();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseMainProjectSpecialty bean = new BaseMainProjectSpecialty();
		bean.setDataFromJSON(json);
		MainProjectSpecialty dao = new MainProjectSpecialty();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseMainProjectSpecialty bean = new BaseMainProjectSpecialty();
		bean.setDataFromJSON(json);
		MainProjectSpecialty dao = new MainProjectSpecialty();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseMainProjectSpecialty bean = new BaseMainProjectSpecialty();
		bean.setDataFromJSON(json);
		MainProjectSpecialty dao = new MainProjectSpecialty();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


