package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseWorkingHour;
import java.util.List;
import com.pomplatform.db.dao.WorkingHour;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class WorkingHourHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(WorkingHourHandler.class);

	public static BaseWorkingHour getWorkingHourById( 
		java.lang.Integer working_hour_id
	) throws Exception
	{
		WorkingHour dao = new WorkingHour();
		dao.setWorkingHourId(working_hour_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isWorkingHourExists( com.pomplatform.db.bean.BaseWorkingHour bean, String additional ) throws Exception {

		WorkingHour dao = new WorkingHour();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countWorkingHour( com.pomplatform.db.bean.BaseWorkingHour bean, String additional ) throws Exception {

		WorkingHour dao = new WorkingHour();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseWorkingHour> queryWorkingHour( com.pomplatform.db.bean.BaseWorkingHour bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		WorkingHour dao = new WorkingHour();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseWorkingHour> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseWorkingHour> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseWorkingHour addToWorkingHour ( BaseWorkingHour workinghour )  throws Exception {
		return addToWorkingHour ( workinghour , false);
	}

	public static BaseWorkingHour addToWorkingHour ( BaseWorkingHour workinghour, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		WorkingHour dao = new WorkingHour();
		dao.setDataFromBase(workinghour);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseWorkingHour addUpdateWorkingHour ( BaseWorkingHour workinghour ) throws Exception {
		return addUpdateWorkingHour ( workinghour , false);
	}

	public static BaseWorkingHour addUpdateWorkingHour ( BaseWorkingHour workinghour, boolean singleTransaction  ) throws Exception {
		if(workinghour.getWorkingHourId() == null) return addToWorkingHour(workinghour);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		WorkingHour dao = new WorkingHour();
		dao.setDataFromBase(workinghour);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(workinghour); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteWorkingHour ( BaseWorkingHour bean ) throws Exception {
		WorkingHour dao = new WorkingHour();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseWorkingHour updateWorkingHour ( BaseWorkingHour workinghour ) throws Exception {
		WorkingHour dao = new WorkingHour();
		dao.setWorkingHourId( workinghour.getWorkingHourId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(workinghour);
			result = dao.update();
		}
		return result == 1 ? workinghour : null ;
	}

	public static BaseWorkingHour updateWorkingHourDirect( BaseWorkingHour workinghour ) throws Exception {
		WorkingHour dao = new WorkingHour();
		int result = 0;
		dao.setDataFromBase(workinghour);
		result = dao.update();
		return result == 1 ? workinghour : null ;
	}

	public static int setDeleteConditions(BaseWorkingHour bean, WorkingHour dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getWorkingHourId() != null) {
			dao.setConditionWorkingHourId("=", bean.getWorkingHourId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getProjectCode() != null) {
				dao.setConditionProjectCode("=", bean.getProjectCode());
				count++;
			}
			if(bean.getProjectName() != null) {
				dao.setConditionProjectName("=", bean.getProjectName());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getEmployeeNo() != null) {
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
				count++;
			}
			if(bean.getEmployeeName() != null) {
				dao.setConditionEmployeeName("=", bean.getEmployeeName());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getIsLock() != null) {
				dao.setConditionIsLock("=", bean.getIsLock());
				count++;
			}
			if(bean.getPersonnelBusinessId() != null) {
				dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseWorkingHour bean, WorkingHour dao){
		int count = 0;
		if(bean.getWorkingHourId() != null) {
			dao.setConditionWorkingHourId("=", bean.getWorkingHourId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getProjectCode() != null) {
			if(bean.getProjectCode().indexOf("%") >= 0)
				dao.setConditionProjectCode("like", bean.getProjectCode());
			else
				dao.setConditionProjectCode("=", bean.getProjectCode());
			count++;
		}
		if(bean.getProjectName() != null) {
			if(bean.getProjectName().indexOf("%") >= 0)
				dao.setConditionProjectName("like", bean.getProjectName());
			else
				dao.setConditionProjectName("=", bean.getProjectName());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getEmployeeNo() != null) {
			if(bean.getEmployeeNo().indexOf("%") >= 0)
				dao.setConditionEmployeeNo("like", bean.getEmployeeNo());
			else
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
			count++;
		}
		if(bean.getEmployeeName() != null) {
			if(bean.getEmployeeName().indexOf("%") >= 0)
				dao.setConditionEmployeeName("like", bean.getEmployeeName());
			else
				dao.setConditionEmployeeName("=", bean.getEmployeeName());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getWorkHour() != null) {
			dao.setConditionWorkHour("=", bean.getWorkHour());
			count++;
		}
		if(bean.getWorkDate() != null) {
			dao.setConditionWorkDate(">=", bean.getWorkDate());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getIsLock() != null) {
			dao.setConditionIsLock("=", bean.getIsLock());
			count++;
		}
		if(bean.getPersonnelBusinessId() != null) {
			dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseWorkingHour bean = new BaseWorkingHour();
		bean.setDataFromJSON(json);
		WorkingHour dao = new WorkingHour();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseWorkingHour> rlist = new BaseCollection<>();
		BaseWorkingHour bean = new BaseWorkingHour();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		WorkingHour dao = new WorkingHour();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseWorkingHour> result = dao.conditionalLoad(addtion);
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
		BaseWorkingHour bean = new BaseWorkingHour();
		bean.setDataFromJSON(json);
		WorkingHour dao = new WorkingHour();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseWorkingHour bean = new BaseWorkingHour();
		bean.setDataFromJSON(json);
		WorkingHour dao = new WorkingHour();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseWorkingHour bean = new BaseWorkingHour();
		bean.setDataFromJSON(json);
		WorkingHour dao = new WorkingHour();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseWorkingHour bean = new BaseWorkingHour();
		bean.setDataFromJSON(json);
		WorkingHour dao = new WorkingHour();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


