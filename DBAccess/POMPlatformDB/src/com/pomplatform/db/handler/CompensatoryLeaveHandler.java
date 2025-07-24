package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseCompensatoryLeave;
import java.util.List;
import com.pomplatform.db.dao.CompensatoryLeave;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class CompensatoryLeaveHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CompensatoryLeaveHandler.class);

	public static BaseCompensatoryLeave getCompensatoryLeaveById( 
		java.lang.Integer compensatory_leave_id
	) throws Exception
	{
		CompensatoryLeave dao = new CompensatoryLeave();
		dao.setCompensatoryLeaveId(compensatory_leave_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCompensatoryLeaveExists( com.pomplatform.db.bean.BaseCompensatoryLeave bean, String additional ) throws Exception {

		CompensatoryLeave dao = new CompensatoryLeave();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCompensatoryLeave( com.pomplatform.db.bean.BaseCompensatoryLeave bean, String additional ) throws Exception {

		CompensatoryLeave dao = new CompensatoryLeave();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCompensatoryLeave> queryCompensatoryLeave( com.pomplatform.db.bean.BaseCompensatoryLeave bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CompensatoryLeave dao = new CompensatoryLeave();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCompensatoryLeave> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCompensatoryLeave> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCompensatoryLeave addToCompensatoryLeave ( BaseCompensatoryLeave compensatoryleave )  throws Exception {
		return addToCompensatoryLeave ( compensatoryleave , false);
	}

	public static BaseCompensatoryLeave addToCompensatoryLeave ( BaseCompensatoryLeave compensatoryleave, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CompensatoryLeave dao = new CompensatoryLeave();
		dao.setDataFromBase(compensatoryleave);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCompensatoryLeave addUpdateCompensatoryLeave ( BaseCompensatoryLeave compensatoryleave ) throws Exception {
		return addUpdateCompensatoryLeave ( compensatoryleave , false);
	}

	public static BaseCompensatoryLeave addUpdateCompensatoryLeave ( BaseCompensatoryLeave compensatoryleave, boolean singleTransaction  ) throws Exception {
		if(compensatoryleave.getCompensatoryLeaveId() == null) return addToCompensatoryLeave(compensatoryleave);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CompensatoryLeave dao = new CompensatoryLeave();
		dao.setDataFromBase(compensatoryleave);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(compensatoryleave); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCompensatoryLeave ( BaseCompensatoryLeave bean ) throws Exception {
		CompensatoryLeave dao = new CompensatoryLeave();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCompensatoryLeave updateCompensatoryLeave ( BaseCompensatoryLeave compensatoryleave ) throws Exception {
		CompensatoryLeave dao = new CompensatoryLeave();
		dao.setCompensatoryLeaveId( compensatoryleave.getCompensatoryLeaveId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(compensatoryleave);
			result = dao.update();
		}
		return result == 1 ? compensatoryleave : null ;
	}

	public static BaseCompensatoryLeave updateCompensatoryLeaveDirect( BaseCompensatoryLeave compensatoryleave ) throws Exception {
		CompensatoryLeave dao = new CompensatoryLeave();
		int result = 0;
		dao.setDataFromBase(compensatoryleave);
		result = dao.update();
		return result == 1 ? compensatoryleave : null ;
	}

	public static int setDeleteConditions(BaseCompensatoryLeave bean, CompensatoryLeave dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCompensatoryLeaveId() != null) {
			dao.setConditionCompensatoryLeaveId("=", bean.getCompensatoryLeaveId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getYear() != null) {
				dao.setConditionYear("=", bean.getYear());
				count++;
			}
			if(bean.getMonth() != null) {
				dao.setConditionMonth("=", bean.getMonth());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getBusinessId() != null) {
				dao.setConditionBusinessId("=", bean.getBusinessId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCompensatoryLeave bean, CompensatoryLeave dao){
		int count = 0;
		if(bean.getCompensatoryLeaveId() != null) {
			dao.setConditionCompensatoryLeaveId("=", bean.getCompensatoryLeaveId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getYear() != null) {
			dao.setConditionYear("=", bean.getYear());
			count++;
		}
		if(bean.getMonth() != null) {
			dao.setConditionMonth("=", bean.getMonth());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getBusinessId() != null) {
			dao.setConditionBusinessId("=", bean.getBusinessId());
			count++;
		}
		if(bean.getTotalCompensatoryLeave() != null) {
			dao.setConditionTotalCompensatoryLeave("=", bean.getTotalCompensatoryLeave());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCompensatoryLeave bean = new BaseCompensatoryLeave();
		bean.setDataFromJSON(json);
		CompensatoryLeave dao = new CompensatoryLeave();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCompensatoryLeave> rlist = new BaseCollection<>();
		BaseCompensatoryLeave bean = new BaseCompensatoryLeave();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CompensatoryLeave dao = new CompensatoryLeave();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCompensatoryLeave> result = dao.conditionalLoad(addtion);
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
		BaseCompensatoryLeave bean = new BaseCompensatoryLeave();
		bean.setDataFromJSON(json);
		CompensatoryLeave dao = new CompensatoryLeave();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCompensatoryLeave bean = new BaseCompensatoryLeave();
		bean.setDataFromJSON(json);
		CompensatoryLeave dao = new CompensatoryLeave();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCompensatoryLeave bean = new BaseCompensatoryLeave();
		bean.setDataFromJSON(json);
		CompensatoryLeave dao = new CompensatoryLeave();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCompensatoryLeave bean = new BaseCompensatoryLeave();
		bean.setDataFromJSON(json);
		CompensatoryLeave dao = new CompensatoryLeave();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


