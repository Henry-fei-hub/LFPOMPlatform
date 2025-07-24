package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePreProjectReimbursementNumber;
import com.pomplatform.db.dao.PreProjectReimbursementNumber;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PreProjectReimbursementNumberHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PreProjectReimbursementNumberHandler.class);

	public static BasePreProjectReimbursementNumber getPreProjectReimbursementNumberById( 
		java.lang.Integer pre_project_reimbursement_number_id
	) throws Exception
	{
		PreProjectReimbursementNumber dao = new PreProjectReimbursementNumber();
		dao.setPreProjectReimbursementNumberId(pre_project_reimbursement_number_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPreProjectReimbursementNumberExists( com.pomplatform.db.bean.BasePreProjectReimbursementNumber bean, String additional ) throws Exception {

		PreProjectReimbursementNumber dao = new PreProjectReimbursementNumber();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPreProjectReimbursementNumber( com.pomplatform.db.bean.BasePreProjectReimbursementNumber bean, String additional ) throws Exception {

		PreProjectReimbursementNumber dao = new PreProjectReimbursementNumber();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePreProjectReimbursementNumber> queryPreProjectReimbursementNumber( com.pomplatform.db.bean.BasePreProjectReimbursementNumber bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PreProjectReimbursementNumber dao = new PreProjectReimbursementNumber();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePreProjectReimbursementNumber> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePreProjectReimbursementNumber> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePreProjectReimbursementNumber addToPreProjectReimbursementNumber ( BasePreProjectReimbursementNumber preprojectreimbursementnumber )  throws Exception {
		return addToPreProjectReimbursementNumber ( preprojectreimbursementnumber , false);
	}

	public static BasePreProjectReimbursementNumber addToPreProjectReimbursementNumber ( BasePreProjectReimbursementNumber preprojectreimbursementnumber, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PreProjectReimbursementNumber dao = new PreProjectReimbursementNumber();
		dao.setDataFromBase(preprojectreimbursementnumber);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePreProjectReimbursementNumber addUpdatePreProjectReimbursementNumber ( BasePreProjectReimbursementNumber preprojectreimbursementnumber ) throws Exception {
		return addUpdatePreProjectReimbursementNumber ( preprojectreimbursementnumber , false);
	}

	public static BasePreProjectReimbursementNumber addUpdatePreProjectReimbursementNumber ( BasePreProjectReimbursementNumber preprojectreimbursementnumber, boolean singleTransaction  ) throws Exception {
		if(preprojectreimbursementnumber.getPreProjectReimbursementNumberId() == null) return addToPreProjectReimbursementNumber(preprojectreimbursementnumber);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PreProjectReimbursementNumber dao = new PreProjectReimbursementNumber();
		dao.setDataFromBase(preprojectreimbursementnumber);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(preprojectreimbursementnumber); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePreProjectReimbursementNumber ( BasePreProjectReimbursementNumber bean ) throws Exception {
		PreProjectReimbursementNumber dao = new PreProjectReimbursementNumber();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePreProjectReimbursementNumber updatePreProjectReimbursementNumber ( BasePreProjectReimbursementNumber preprojectreimbursementnumber ) throws Exception {
		PreProjectReimbursementNumber dao = new PreProjectReimbursementNumber();
		dao.setPreProjectReimbursementNumberId( preprojectreimbursementnumber.getPreProjectReimbursementNumberId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(preprojectreimbursementnumber);
			result = dao.update();
		}
		return result == 1 ? preprojectreimbursementnumber : null ;
	}

	public static BasePreProjectReimbursementNumber updatePreProjectReimbursementNumberDirect( BasePreProjectReimbursementNumber preprojectreimbursementnumber ) throws Exception {
		PreProjectReimbursementNumber dao = new PreProjectReimbursementNumber();
		int result = 0;
		dao.setDataFromBase(preprojectreimbursementnumber);
		result = dao.update();
		return result == 1 ? preprojectreimbursementnumber : null ;
	}

	public static int setDeleteConditions(BasePreProjectReimbursementNumber bean, PreProjectReimbursementNumber dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPreProjectReimbursementNumberId() != null) {
			dao.setConditionPreProjectReimbursementNumberId("=", bean.getPreProjectReimbursementNumberId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCustomNumber() != null) {
				dao.setConditionCustomNumber("=", bean.getCustomNumber());
				count++;
			}
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
			if(bean.getProjectManager() != null) {
				dao.setConditionProjectManager("=", bean.getProjectManager());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getPreProjectType() != null) {
				dao.setConditionPreProjectType("=", bean.getPreProjectType());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getPreBusinessType() != null) {
				dao.setConditionPreBusinessType("=", bean.getPreBusinessType());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePreProjectReimbursementNumber bean, PreProjectReimbursementNumber dao){
		int count = 0;
		if(bean.getPreProjectReimbursementNumberId() != null) {
			dao.setConditionPreProjectReimbursementNumberId("=", bean.getPreProjectReimbursementNumberId());
			count++;
		}
		if(bean.getCustomNumber() != null) {
			if(bean.getCustomNumber().indexOf("%") >= 0)
				dao.setConditionCustomNumber("like", bean.getCustomNumber());
			else
				dao.setConditionCustomNumber("=", bean.getCustomNumber());
			count++;
		}
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		if(bean.getProjectManager() != null) {
			dao.setConditionProjectManager("=", bean.getProjectManager());
			count++;
		}
		if(bean.getOperator() != null) {
			dao.setConditionOperator("=", bean.getOperator());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getPreProjectType() != null) {
			dao.setConditionPreProjectType("=", bean.getPreProjectType());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getPreBusinessType() != null) {
			dao.setConditionPreBusinessType("=", bean.getPreBusinessType());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePreProjectReimbursementNumber bean = new BasePreProjectReimbursementNumber();
		bean.setDataFromJSON(json);
		PreProjectReimbursementNumber dao = new PreProjectReimbursementNumber();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePreProjectReimbursementNumber> rlist = new BaseCollection<>();
		BasePreProjectReimbursementNumber bean = new BasePreProjectReimbursementNumber();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PreProjectReimbursementNumber dao = new PreProjectReimbursementNumber();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePreProjectReimbursementNumber> result = dao.conditionalLoad(addtion);
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
		BasePreProjectReimbursementNumber bean = new BasePreProjectReimbursementNumber();
		bean.setDataFromJSON(json);
		PreProjectReimbursementNumber dao = new PreProjectReimbursementNumber();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePreProjectReimbursementNumber bean = new BasePreProjectReimbursementNumber();
		bean.setDataFromJSON(json);
		PreProjectReimbursementNumber dao = new PreProjectReimbursementNumber();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePreProjectReimbursementNumber bean = new BasePreProjectReimbursementNumber();
		bean.setDataFromJSON(json);
		PreProjectReimbursementNumber dao = new PreProjectReimbursementNumber();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePreProjectReimbursementNumber bean = new BasePreProjectReimbursementNumber();
		bean.setDataFromJSON(json);
		PreProjectReimbursementNumber dao = new PreProjectReimbursementNumber();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


