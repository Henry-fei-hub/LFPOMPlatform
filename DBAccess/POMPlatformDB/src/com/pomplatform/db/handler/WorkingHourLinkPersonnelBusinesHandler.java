package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseWorkingHourLinkPersonnelBusines;
import java.util.List;
import com.pomplatform.db.dao.WorkingHourLinkPersonnelBusines;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class WorkingHourLinkPersonnelBusinesHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(WorkingHourLinkPersonnelBusinesHandler.class);

	public static BaseWorkingHourLinkPersonnelBusines getWorkingHourLinkPersonnelBusinesById( 
		java.lang.Integer working_hour_link_personnel_business_id
	) throws Exception
	{
		WorkingHourLinkPersonnelBusines dao = new WorkingHourLinkPersonnelBusines();
		dao.setWorkingHourLinkPersonnelBusinessId(working_hour_link_personnel_business_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isWorkingHourLinkPersonnelBusinesExists( com.pomplatform.db.bean.BaseWorkingHourLinkPersonnelBusines bean, String additional ) throws Exception {

		WorkingHourLinkPersonnelBusines dao = new WorkingHourLinkPersonnelBusines();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countWorkingHourLinkPersonnelBusines( com.pomplatform.db.bean.BaseWorkingHourLinkPersonnelBusines bean, String additional ) throws Exception {

		WorkingHourLinkPersonnelBusines dao = new WorkingHourLinkPersonnelBusines();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseWorkingHourLinkPersonnelBusines> queryWorkingHourLinkPersonnelBusines( com.pomplatform.db.bean.BaseWorkingHourLinkPersonnelBusines bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		WorkingHourLinkPersonnelBusines dao = new WorkingHourLinkPersonnelBusines();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseWorkingHourLinkPersonnelBusines> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseWorkingHourLinkPersonnelBusines> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseWorkingHourLinkPersonnelBusines addToWorkingHourLinkPersonnelBusines ( BaseWorkingHourLinkPersonnelBusines workinghourlinkpersonnelbusines )  throws Exception {
		return addToWorkingHourLinkPersonnelBusines ( workinghourlinkpersonnelbusines , false);
	}

	public static BaseWorkingHourLinkPersonnelBusines addToWorkingHourLinkPersonnelBusines ( BaseWorkingHourLinkPersonnelBusines workinghourlinkpersonnelbusines, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		WorkingHourLinkPersonnelBusines dao = new WorkingHourLinkPersonnelBusines();
		dao.setDataFromBase(workinghourlinkpersonnelbusines);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseWorkingHourLinkPersonnelBusines addUpdateWorkingHourLinkPersonnelBusines ( BaseWorkingHourLinkPersonnelBusines workinghourlinkpersonnelbusines ) throws Exception {
		return addUpdateWorkingHourLinkPersonnelBusines ( workinghourlinkpersonnelbusines , false);
	}

	public static BaseWorkingHourLinkPersonnelBusines addUpdateWorkingHourLinkPersonnelBusines ( BaseWorkingHourLinkPersonnelBusines workinghourlinkpersonnelbusines, boolean singleTransaction  ) throws Exception {
		if(workinghourlinkpersonnelbusines.getWorkingHourLinkPersonnelBusinessId() == null) return addToWorkingHourLinkPersonnelBusines(workinghourlinkpersonnelbusines);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		WorkingHourLinkPersonnelBusines dao = new WorkingHourLinkPersonnelBusines();
		dao.setDataFromBase(workinghourlinkpersonnelbusines);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(workinghourlinkpersonnelbusines); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteWorkingHourLinkPersonnelBusines ( BaseWorkingHourLinkPersonnelBusines bean ) throws Exception {
		WorkingHourLinkPersonnelBusines dao = new WorkingHourLinkPersonnelBusines();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseWorkingHourLinkPersonnelBusines updateWorkingHourLinkPersonnelBusines ( BaseWorkingHourLinkPersonnelBusines workinghourlinkpersonnelbusines ) throws Exception {
		WorkingHourLinkPersonnelBusines dao = new WorkingHourLinkPersonnelBusines();
		dao.setWorkingHourLinkPersonnelBusinessId( workinghourlinkpersonnelbusines.getWorkingHourLinkPersonnelBusinessId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(workinghourlinkpersonnelbusines);
			result = dao.update();
		}
		return result == 1 ? workinghourlinkpersonnelbusines : null ;
	}

	public static BaseWorkingHourLinkPersonnelBusines updateWorkingHourLinkPersonnelBusinesDirect( BaseWorkingHourLinkPersonnelBusines workinghourlinkpersonnelbusines ) throws Exception {
		WorkingHourLinkPersonnelBusines dao = new WorkingHourLinkPersonnelBusines();
		int result = 0;
		dao.setDataFromBase(workinghourlinkpersonnelbusines);
		result = dao.update();
		return result == 1 ? workinghourlinkpersonnelbusines : null ;
	}

	public static int setDeleteConditions(BaseWorkingHourLinkPersonnelBusines bean, WorkingHourLinkPersonnelBusines dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getWorkingHourLinkPersonnelBusinessId() != null) {
			dao.setConditionWorkingHourLinkPersonnelBusinessId("=", bean.getWorkingHourLinkPersonnelBusinessId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPersonnelBusinessId() != null) {
				dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
				count++;
			}
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseWorkingHourLinkPersonnelBusines bean, WorkingHourLinkPersonnelBusines dao){
		int count = 0;
		if(bean.getWorkingHourLinkPersonnelBusinessId() != null) {
			dao.setConditionWorkingHourLinkPersonnelBusinessId("=", bean.getWorkingHourLinkPersonnelBusinessId());
			count++;
		}
		if(bean.getPersonnelBusinessId() != null) {
			dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getWorkHour() != null) {
			dao.setConditionWorkHour("=", bean.getWorkHour());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseWorkingHourLinkPersonnelBusines bean = new BaseWorkingHourLinkPersonnelBusines();
		bean.setDataFromJSON(json);
		WorkingHourLinkPersonnelBusines dao = new WorkingHourLinkPersonnelBusines();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseWorkingHourLinkPersonnelBusines> rlist = new BaseCollection<>();
		BaseWorkingHourLinkPersonnelBusines bean = new BaseWorkingHourLinkPersonnelBusines();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		WorkingHourLinkPersonnelBusines dao = new WorkingHourLinkPersonnelBusines();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseWorkingHourLinkPersonnelBusines> result = dao.conditionalLoad(addtion);
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
		BaseWorkingHourLinkPersonnelBusines bean = new BaseWorkingHourLinkPersonnelBusines();
		bean.setDataFromJSON(json);
		WorkingHourLinkPersonnelBusines dao = new WorkingHourLinkPersonnelBusines();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseWorkingHourLinkPersonnelBusines bean = new BaseWorkingHourLinkPersonnelBusines();
		bean.setDataFromJSON(json);
		WorkingHourLinkPersonnelBusines dao = new WorkingHourLinkPersonnelBusines();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseWorkingHourLinkPersonnelBusines bean = new BaseWorkingHourLinkPersonnelBusines();
		bean.setDataFromJSON(json);
		WorkingHourLinkPersonnelBusines dao = new WorkingHourLinkPersonnelBusines();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseWorkingHourLinkPersonnelBusines bean = new BaseWorkingHourLinkPersonnelBusines();
		bean.setDataFromJSON(json);
		WorkingHourLinkPersonnelBusines dao = new WorkingHourLinkPersonnelBusines();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


