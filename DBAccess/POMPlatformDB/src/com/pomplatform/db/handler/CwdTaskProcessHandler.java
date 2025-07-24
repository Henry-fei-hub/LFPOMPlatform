package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdTaskProcess;
import com.pomplatform.db.dao.CwdTaskProcess;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdTaskProcessHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdTaskProcessHandler.class);

	public static BaseCwdTaskProcess getCwdTaskProcessById( 
		java.lang.Integer cwd_task_process_id
	) throws Exception
	{
		CwdTaskProcess dao = new CwdTaskProcess();
		dao.setCwdTaskProcessId(cwd_task_process_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdTaskProcessExists( com.pomplatform.db.bean.BaseCwdTaskProcess bean, String additional ) throws Exception {

		CwdTaskProcess dao = new CwdTaskProcess();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdTaskProcess( com.pomplatform.db.bean.BaseCwdTaskProcess bean, String additional ) throws Exception {

		CwdTaskProcess dao = new CwdTaskProcess();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdTaskProcess> queryCwdTaskProcess( com.pomplatform.db.bean.BaseCwdTaskProcess bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdTaskProcess dao = new CwdTaskProcess();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdTaskProcess> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdTaskProcess> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdTaskProcess addToCwdTaskProcess ( BaseCwdTaskProcess cwdtaskprocess )  throws Exception {
		return addToCwdTaskProcess ( cwdtaskprocess , false);
	}

	public static BaseCwdTaskProcess addToCwdTaskProcess ( BaseCwdTaskProcess cwdtaskprocess, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdTaskProcess dao = new CwdTaskProcess();
		dao.setDataFromBase(cwdtaskprocess);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdTaskProcess addUpdateCwdTaskProcess ( BaseCwdTaskProcess cwdtaskprocess ) throws Exception {
		return addUpdateCwdTaskProcess ( cwdtaskprocess , false);
	}

	public static BaseCwdTaskProcess addUpdateCwdTaskProcess ( BaseCwdTaskProcess cwdtaskprocess, boolean singleTransaction  ) throws Exception {
		if(cwdtaskprocess.getCwdTaskProcessId() == null) return addToCwdTaskProcess(cwdtaskprocess);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdTaskProcess dao = new CwdTaskProcess();
		dao.setDataFromBase(cwdtaskprocess);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdtaskprocess); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdTaskProcess ( BaseCwdTaskProcess bean ) throws Exception {
		CwdTaskProcess dao = new CwdTaskProcess();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdTaskProcess updateCwdTaskProcess ( BaseCwdTaskProcess cwdtaskprocess ) throws Exception {
		CwdTaskProcess dao = new CwdTaskProcess();
		dao.setCwdTaskProcessId( cwdtaskprocess.getCwdTaskProcessId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdtaskprocess);
			result = dao.update();
		}
		return result == 1 ? cwdtaskprocess : null ;
	}

	public static BaseCwdTaskProcess updateCwdTaskProcessDirect( BaseCwdTaskProcess cwdtaskprocess ) throws Exception {
		CwdTaskProcess dao = new CwdTaskProcess();
		int result = 0;
		dao.setDataFromBase(cwdtaskprocess);
		result = dao.update();
		return result == 1 ? cwdtaskprocess : null ;
	}

	public static int setDeleteConditions(BaseCwdTaskProcess bean, CwdTaskProcess dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCwdTaskProcessId() != null) {
			dao.setConditionCwdTaskProcessId("=", bean.getCwdTaskProcessId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProcessType() != null) {
				dao.setConditionProcessType("=", bean.getProcessType());
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
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getCompanyNo() != null) {
				dao.setConditionCompanyNo("=", bean.getCompanyNo());
				count++;
			}
			if(bean.getCwdTaskManageId() != null) {
				dao.setConditionCwdTaskManageId("=", bean.getCwdTaskManageId());
				count++;
			}
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
			if(bean.getProcessStatus() != null) {
				dao.setConditionProcessStatus("=", bean.getProcessStatus());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
			if(bean.getTitle() != null) {
				dao.setConditionTitle("=", bean.getTitle());
				count++;
			}
			if(bean.getDocumentType() != null) {
				dao.setConditionDocumentType("=", bean.getDocumentType());
				count++;
			}
			if(bean.getBasicFileType() != null) {
				dao.setConditionBasicFileType("=", bean.getBasicFileType());
				count++;
			}
			if(bean.getSpecialtyId() != null) {
				dao.setConditionSpecialtyId("=", bean.getSpecialtyId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdTaskProcess bean, CwdTaskProcess dao){
		int count = 0;
		if(bean.getCwdTaskProcessId() != null) {
			dao.setConditionCwdTaskProcessId("=", bean.getCwdTaskProcessId());
			count++;
		}
		if(bean.getProcessType() != null) {
			dao.setConditionProcessType("=", bean.getProcessType());
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
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getCompanyNo() != null) {
			if(bean.getCompanyNo().indexOf("%") >= 0)
				dao.setConditionCompanyNo("like", bean.getCompanyNo());
			else
				dao.setConditionCompanyNo("=", bean.getCompanyNo());
			count++;
		}
		if(bean.getCwdTaskManageId() != null) {
			dao.setConditionCwdTaskManageId("=", bean.getCwdTaskManageId());
			count++;
		}
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		if(bean.getProcessStatus() != null) {
			dao.setConditionProcessStatus("=", bean.getProcessStatus());
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
		if(bean.getCompleteTime() != null) {
			dao.setConditionCompleteTime(">=", bean.getCompleteTime());
			count++;
		}
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
			count++;
		}
		if(bean.getTitle() != null) {
			if(bean.getTitle().indexOf("%") >= 0)
				dao.setConditionTitle("like", bean.getTitle());
			else
				dao.setConditionTitle("=", bean.getTitle());
			count++;
		}
		if(bean.getDocumentType() != null) {
			dao.setConditionDocumentType("=", bean.getDocumentType());
			count++;
		}
		if(bean.getBasicFileType() != null) {
			dao.setConditionBasicFileType("=", bean.getBasicFileType());
			count++;
		}
		if(bean.getSpecialtyId() != null) {
			dao.setConditionSpecialtyId("=", bean.getSpecialtyId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCwdTaskProcess bean = new BaseCwdTaskProcess();
		bean.setDataFromJSON(json);
		CwdTaskProcess dao = new CwdTaskProcess();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdTaskProcess> rlist = new BaseCollection<>();
		BaseCwdTaskProcess bean = new BaseCwdTaskProcess();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdTaskProcess dao = new CwdTaskProcess();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdTaskProcess> result = dao.conditionalLoad(addtion);
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
		BaseCwdTaskProcess bean = new BaseCwdTaskProcess();
		bean.setDataFromJSON(json);
		CwdTaskProcess dao = new CwdTaskProcess();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdTaskProcess bean = new BaseCwdTaskProcess();
		bean.setDataFromJSON(json);
		CwdTaskProcess dao = new CwdTaskProcess();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdTaskProcess bean = new BaseCwdTaskProcess();
		bean.setDataFromJSON(json);
		CwdTaskProcess dao = new CwdTaskProcess();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdTaskProcess bean = new BaseCwdTaskProcess();
		bean.setDataFromJSON(json);
		CwdTaskProcess dao = new CwdTaskProcess();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


