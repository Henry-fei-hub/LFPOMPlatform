package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePmSpecial;
import com.pomplatform.db.dao.PmSpecial;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PmSpecialHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PmSpecialHandler.class);

	public static BasePmSpecial getPmSpecialById( 
		java.lang.Integer pm_special_id
	) throws Exception
	{
		PmSpecial dao = new PmSpecial();
		dao.setPmSpecialId(pm_special_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPmSpecialExists( com.pomplatform.db.bean.BasePmSpecial bean, String additional ) throws Exception {

		PmSpecial dao = new PmSpecial();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPmSpecial( com.pomplatform.db.bean.BasePmSpecial bean, String additional ) throws Exception {

		PmSpecial dao = new PmSpecial();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePmSpecial> queryPmSpecial( com.pomplatform.db.bean.BasePmSpecial bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PmSpecial dao = new PmSpecial();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePmSpecial> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePmSpecial> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePmSpecial addToPmSpecial ( BasePmSpecial pmspecial )  throws Exception {
		return addToPmSpecial ( pmspecial , false);
	}

	public static BasePmSpecial addToPmSpecial ( BasePmSpecial pmspecial, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PmSpecial dao = new PmSpecial();
		dao.setDataFromBase(pmspecial);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePmSpecial addUpdatePmSpecial ( BasePmSpecial pmspecial ) throws Exception {
		return addUpdatePmSpecial ( pmspecial , false);
	}

	public static BasePmSpecial addUpdatePmSpecial ( BasePmSpecial pmspecial, boolean singleTransaction  ) throws Exception {
		if(pmspecial.getPmSpecialId() == null) return addToPmSpecial(pmspecial);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PmSpecial dao = new PmSpecial();
		dao.setDataFromBase(pmspecial);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(pmspecial); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePmSpecial ( BasePmSpecial bean ) throws Exception {
		PmSpecial dao = new PmSpecial();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePmSpecial updatePmSpecial ( BasePmSpecial pmspecial ) throws Exception {
		PmSpecial dao = new PmSpecial();
		dao.setPmSpecialId( pmspecial.getPmSpecialId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(pmspecial);
			result = dao.update();
		}
		return result == 1 ? pmspecial : null ;
	}

	public static BasePmSpecial updatePmSpecialDirect( BasePmSpecial pmspecial ) throws Exception {
		PmSpecial dao = new PmSpecial();
		int result = 0;
		dao.setDataFromBase(pmspecial);
		result = dao.update();
		return result == 1 ? pmspecial : null ;
	}

	public static int setDeleteConditions(BasePmSpecial bean, PmSpecial dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPmSpecialId() != null) {
			dao.setConditionPmSpecialId("=", bean.getPmSpecialId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getSpecialCode() != null) {
				dao.setConditionSpecialCode("=", bean.getSpecialCode());
				count++;
			}
			if(bean.getSpecialName() != null) {
				dao.setConditionSpecialName("=", bean.getSpecialName());
				count++;
			}
			if(bean.getIsDel() != null) {
				dao.setConditionIsDel("=", bean.getIsDel());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePmSpecial bean, PmSpecial dao){
		int count = 0;
		if(bean.getPmSpecialId() != null) {
			dao.setConditionPmSpecialId("=", bean.getPmSpecialId());
			count++;
		}
		if(bean.getSpecialCode() != null) {
			if(bean.getSpecialCode().indexOf("%") >= 0)
				dao.setConditionSpecialCode("like", bean.getSpecialCode());
			else
				dao.setConditionSpecialCode("=", bean.getSpecialCode());
			count++;
		}
		if(bean.getSpecialName() != null) {
			if(bean.getSpecialName().indexOf("%") >= 0)
				dao.setConditionSpecialName("like", bean.getSpecialName());
			else
				dao.setConditionSpecialName("=", bean.getSpecialName());
			count++;
		}
		if(bean.getIsDel() != null) {
			dao.setConditionIsDel("=", bean.getIsDel());
			count++;
		}
		if(bean.getOperateEmployeeId() != null) {
			dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
			count++;
		}
		if(bean.getOperateTime() != null) {
			dao.setConditionOperateTime(">=", bean.getOperateTime());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePmSpecial bean = new BasePmSpecial();
		bean.setDataFromJSON(json);
		PmSpecial dao = new PmSpecial();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePmSpecial> rlist = new BaseCollection<>();
		BasePmSpecial bean = new BasePmSpecial();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PmSpecial dao = new PmSpecial();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePmSpecial> result = dao.conditionalLoad(addtion);
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
		BasePmSpecial bean = new BasePmSpecial();
		bean.setDataFromJSON(json);
		PmSpecial dao = new PmSpecial();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePmSpecial bean = new BasePmSpecial();
		bean.setDataFromJSON(json);
		PmSpecial dao = new PmSpecial();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePmSpecial bean = new BasePmSpecial();
		bean.setDataFromJSON(json);
		PmSpecial dao = new PmSpecial();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePmSpecial bean = new BasePmSpecial();
		bean.setDataFromJSON(json);
		PmSpecial dao = new PmSpecial();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


