package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseAnnoucement;
import com.pomplatform.db.dao.Annoucement;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class AnnoucementHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(AnnoucementHandler.class);

	public static BaseAnnoucement getAnnoucementById( 
		java.lang.Integer annoucement_id
	) throws Exception
	{
		Annoucement dao = new Annoucement();
		dao.setAnnoucementId(annoucement_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isAnnoucementExists( com.pomplatform.db.bean.BaseAnnoucement bean, String additional ) throws Exception {

		Annoucement dao = new Annoucement();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countAnnoucement( com.pomplatform.db.bean.BaseAnnoucement bean, String additional ) throws Exception {

		Annoucement dao = new Annoucement();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseAnnoucement> queryAnnoucement( com.pomplatform.db.bean.BaseAnnoucement bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		Annoucement dao = new Annoucement();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseAnnoucement> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseAnnoucement> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseAnnoucement addToAnnoucement ( BaseAnnoucement annoucement )  throws Exception {
		return addToAnnoucement ( annoucement , false);
	}

	public static BaseAnnoucement addToAnnoucement ( BaseAnnoucement annoucement, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		Annoucement dao = new Annoucement();
		dao.setDataFromBase(annoucement);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseAnnoucement addUpdateAnnoucement ( BaseAnnoucement annoucement ) throws Exception {
		return addUpdateAnnoucement ( annoucement , false);
	}

	public static BaseAnnoucement addUpdateAnnoucement ( BaseAnnoucement annoucement, boolean singleTransaction  ) throws Exception {
		if(annoucement.getAnnoucementId() == null) return addToAnnoucement(annoucement);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		Annoucement dao = new Annoucement();
		dao.setDataFromBase(annoucement);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(annoucement); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteAnnoucement ( BaseAnnoucement bean ) throws Exception {
		Annoucement dao = new Annoucement();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseAnnoucement updateAnnoucement ( BaseAnnoucement annoucement ) throws Exception {
		Annoucement dao = new Annoucement();
		dao.setAnnoucementId( annoucement.getAnnoucementId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(annoucement);
			result = dao.update();
		}
		return result == 1 ? annoucement : null ;
	}

	public static BaseAnnoucement updateAnnoucementDirect( BaseAnnoucement annoucement ) throws Exception {
		Annoucement dao = new Annoucement();
		int result = 0;
		dao.setDataFromBase(annoucement);
		result = dao.update();
		return result == 1 ? annoucement : null ;
	}

	public static int setDeleteConditions(BaseAnnoucement bean, Annoucement dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getAnnoucementId() != null) {
			dao.setConditionAnnoucementId("=", bean.getAnnoucementId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
			if(bean.getCustomerId() != null) {
				dao.setConditionCustomerId("=", bean.getCustomerId());
				count++;
			}
			if(bean.getAnnoucementTitle() != null) {
				dao.setConditionAnnoucementTitle("=", bean.getAnnoucementTitle());
				count++;
			}
			if(bean.getAnnoucementContent() != null) {
				dao.setConditionAnnoucementContent("=", bean.getAnnoucementContent());
				count++;
			}
			if(bean.getAnnoucementEmployeeIds() != null) {
				dao.setConditionAnnoucementEmployeeIds("=", bean.getAnnoucementEmployeeIds());
				count++;
			}
			if(bean.getAnnoucementEmployeeNames() != null) {
				dao.setConditionAnnoucementEmployeeNames("=", bean.getAnnoucementEmployeeNames());
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
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseAnnoucement bean, Annoucement dao){
		int count = 0;
		if(bean.getAnnoucementId() != null) {
			dao.setConditionAnnoucementId("=", bean.getAnnoucementId());
			count++;
		}
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		if(bean.getCustomerId() != null) {
			dao.setConditionCustomerId("=", bean.getCustomerId());
			count++;
		}
		if(bean.getAnnoucementTitle() != null) {
			if(bean.getAnnoucementTitle().indexOf("%") >= 0)
				dao.setConditionAnnoucementTitle("like", bean.getAnnoucementTitle());
			else
				dao.setConditionAnnoucementTitle("=", bean.getAnnoucementTitle());
			count++;
		}
		if(bean.getAnnoucementContent() != null) {
			if(bean.getAnnoucementContent().indexOf("%") >= 0)
				dao.setConditionAnnoucementContent("like", bean.getAnnoucementContent());
			else
				dao.setConditionAnnoucementContent("=", bean.getAnnoucementContent());
			count++;
		}
		if(bean.getAnnoucementTime() != null) {
			dao.setConditionAnnoucementTime(">=", bean.getAnnoucementTime());
			count++;
		}
		if(bean.getAnnoucementEmployeeIds() != null) {
			if(bean.getAnnoucementEmployeeIds().indexOf("%") >= 0)
				dao.setConditionAnnoucementEmployeeIds("like", bean.getAnnoucementEmployeeIds());
			else
				dao.setConditionAnnoucementEmployeeIds("=", bean.getAnnoucementEmployeeIds());
			count++;
		}
		if(bean.getAnnoucementEmployeeNames() != null) {
			if(bean.getAnnoucementEmployeeNames().indexOf("%") >= 0)
				dao.setConditionAnnoucementEmployeeNames("like", bean.getAnnoucementEmployeeNames());
			else
				dao.setConditionAnnoucementEmployeeNames("=", bean.getAnnoucementEmployeeNames());
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
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseAnnoucement bean = new BaseAnnoucement();
		bean.setDataFromJSON(json);
		Annoucement dao = new Annoucement();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseAnnoucement> rlist = new BaseCollection<>();
		BaseAnnoucement bean = new BaseAnnoucement();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		Annoucement dao = new Annoucement();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseAnnoucement> result = dao.conditionalLoad(addtion);
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
		BaseAnnoucement bean = new BaseAnnoucement();
		bean.setDataFromJSON(json);
		Annoucement dao = new Annoucement();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseAnnoucement bean = new BaseAnnoucement();
		bean.setDataFromJSON(json);
		Annoucement dao = new Annoucement();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseAnnoucement bean = new BaseAnnoucement();
		bean.setDataFromJSON(json);
		Annoucement dao = new Annoucement();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseAnnoucement bean = new BaseAnnoucement();
		bean.setDataFromJSON(json);
		Annoucement dao = new Annoucement();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


