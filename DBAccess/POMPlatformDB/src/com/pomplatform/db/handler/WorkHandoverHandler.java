package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseWorkHandover;
import com.pomplatform.db.dao.WorkHandover;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class WorkHandoverHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(WorkHandoverHandler.class);

	public static BaseWorkHandover getWorkHandoverById( 
		java.lang.Integer work_handover_id
	) throws Exception
	{
		WorkHandover dao = new WorkHandover();
		dao.setWorkHandoverId(work_handover_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isWorkHandoverExists( com.pomplatform.db.bean.BaseWorkHandover bean, String additional ) throws Exception {

		WorkHandover dao = new WorkHandover();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countWorkHandover( com.pomplatform.db.bean.BaseWorkHandover bean, String additional ) throws Exception {

		WorkHandover dao = new WorkHandover();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseWorkHandover> queryWorkHandover( com.pomplatform.db.bean.BaseWorkHandover bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		WorkHandover dao = new WorkHandover();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseWorkHandover> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseWorkHandover> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseWorkHandover addToWorkHandover ( BaseWorkHandover workhandover )  throws Exception {
		return addToWorkHandover ( workhandover , false);
	}

	public static BaseWorkHandover addToWorkHandover ( BaseWorkHandover workhandover, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		WorkHandover dao = new WorkHandover();
		dao.setDataFromBase(workhandover);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseWorkHandover addUpdateWorkHandover ( BaseWorkHandover workhandover ) throws Exception {
		return addUpdateWorkHandover ( workhandover , false);
	}

	public static BaseWorkHandover addUpdateWorkHandover ( BaseWorkHandover workhandover, boolean singleTransaction  ) throws Exception {
		if(workhandover.getWorkHandoverId() == null) return addToWorkHandover(workhandover);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		WorkHandover dao = new WorkHandover();
		dao.setDataFromBase(workhandover);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(workhandover); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteWorkHandover ( BaseWorkHandover bean ) throws Exception {
		WorkHandover dao = new WorkHandover();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseWorkHandover updateWorkHandover ( BaseWorkHandover workhandover ) throws Exception {
		WorkHandover dao = new WorkHandover();
		dao.setWorkHandoverId( workhandover.getWorkHandoverId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(workhandover);
			result = dao.update();
		}
		return result == 1 ? workhandover : null ;
	}

	public static BaseWorkHandover updateWorkHandoverDirect( BaseWorkHandover workhandover ) throws Exception {
		WorkHandover dao = new WorkHandover();
		int result = 0;
		dao.setDataFromBase(workhandover);
		result = dao.update();
		return result == 1 ? workhandover : null ;
	}

	public static int setDeleteConditions(BaseWorkHandover bean, WorkHandover dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getWorkHandoverId() != null) {
			dao.setConditionWorkHandoverId("=", bean.getWorkHandoverId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getType() != null) {
				dao.setConditionType("=", bean.getType());
				count++;
			}
			if(bean.getLinkId() != null) {
				dao.setConditionLinkId("=", bean.getLinkId());
				count++;
			}
			if(bean.getName() != null) {
				dao.setConditionName("=", bean.getName());
				count++;
			}
			if(bean.getContent() != null) {
				dao.setConditionContent("=", bean.getContent());
				count++;
			}
			if(bean.getFromEmployeeId() != null) {
				dao.setConditionFromEmployeeId("=", bean.getFromEmployeeId());
				count++;
			}
			if(bean.getToEmployeeId() != null) {
				dao.setConditionToEmployeeId("=", bean.getToEmployeeId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseWorkHandover bean, WorkHandover dao){
		int count = 0;
		if(bean.getWorkHandoverId() != null) {
			dao.setConditionWorkHandoverId("=", bean.getWorkHandoverId());
			count++;
		}
		if(bean.getType() != null) {
			dao.setConditionType("=", bean.getType());
			count++;
		}
		if(bean.getLinkId() != null) {
			dao.setConditionLinkId("=", bean.getLinkId());
			count++;
		}
		if(bean.getName() != null) {
			if(bean.getName().indexOf("%") >= 0)
				dao.setConditionName("like", bean.getName());
			else
				dao.setConditionName("=", bean.getName());
			count++;
		}
		if(bean.getContent() != null) {
			if(bean.getContent().indexOf("%") >= 0)
				dao.setConditionContent("like", bean.getContent());
			else
				dao.setConditionContent("=", bean.getContent());
			count++;
		}
		if(bean.getFromEmployeeId() != null) {
			dao.setConditionFromEmployeeId("=", bean.getFromEmployeeId());
			count++;
		}
		if(bean.getToEmployeeId() != null) {
			dao.setConditionToEmployeeId("=", bean.getToEmployeeId());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseWorkHandover bean = new BaseWorkHandover();
		bean.setDataFromJSON(json);
		WorkHandover dao = new WorkHandover();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseWorkHandover> rlist = new BaseCollection<>();
		BaseWorkHandover bean = new BaseWorkHandover();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		WorkHandover dao = new WorkHandover();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseWorkHandover> result = dao.conditionalLoad(addtion);
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
		BaseWorkHandover bean = new BaseWorkHandover();
		bean.setDataFromJSON(json);
		WorkHandover dao = new WorkHandover();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseWorkHandover bean = new BaseWorkHandover();
		bean.setDataFromJSON(json);
		WorkHandover dao = new WorkHandover();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseWorkHandover bean = new BaseWorkHandover();
		bean.setDataFromJSON(json);
		WorkHandover dao = new WorkHandover();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseWorkHandover bean = new BaseWorkHandover();
		bean.setDataFromJSON(json);
		WorkHandover dao = new WorkHandover();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


