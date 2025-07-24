package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseAnnualLeave;
import java.util.List;
import com.pomplatform.db.dao.AnnualLeave;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class AnnualLeaveHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(AnnualLeaveHandler.class);

	public static BaseAnnualLeave getAnnualLeaveById( 
		java.lang.Integer annual_leave_id
	) throws Exception
	{
		AnnualLeave dao = new AnnualLeave();
		dao.setAnnualLeaveId(annual_leave_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isAnnualLeaveExists( com.pomplatform.db.bean.BaseAnnualLeave bean, String additional ) throws Exception {

		AnnualLeave dao = new AnnualLeave();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countAnnualLeave( com.pomplatform.db.bean.BaseAnnualLeave bean, String additional ) throws Exception {

		AnnualLeave dao = new AnnualLeave();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseAnnualLeave> queryAnnualLeave( com.pomplatform.db.bean.BaseAnnualLeave bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		AnnualLeave dao = new AnnualLeave();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseAnnualLeave> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseAnnualLeave> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseAnnualLeave addToAnnualLeave ( BaseAnnualLeave annualleave )  throws Exception {
		return addToAnnualLeave ( annualleave , false);
	}

	public static BaseAnnualLeave addToAnnualLeave ( BaseAnnualLeave annualleave, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		AnnualLeave dao = new AnnualLeave();
		dao.setDataFromBase(annualleave);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseAnnualLeave addUpdateAnnualLeave ( BaseAnnualLeave annualleave ) throws Exception {
		return addUpdateAnnualLeave ( annualleave , false);
	}

	public static BaseAnnualLeave addUpdateAnnualLeave ( BaseAnnualLeave annualleave, boolean singleTransaction  ) throws Exception {
		if(annualleave.getAnnualLeaveId() == null) return addToAnnualLeave(annualleave);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		AnnualLeave dao = new AnnualLeave();
		dao.setDataFromBase(annualleave);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(annualleave); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteAnnualLeave ( BaseAnnualLeave bean ) throws Exception {
		AnnualLeave dao = new AnnualLeave();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseAnnualLeave updateAnnualLeave ( BaseAnnualLeave annualleave ) throws Exception {
		AnnualLeave dao = new AnnualLeave();
		dao.setAnnualLeaveId( annualleave.getAnnualLeaveId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(annualleave);
			result = dao.update();
		}
		return result == 1 ? annualleave : null ;
	}

	public static BaseAnnualLeave updateAnnualLeaveDirect( BaseAnnualLeave annualleave ) throws Exception {
		AnnualLeave dao = new AnnualLeave();
		int result = 0;
		dao.setDataFromBase(annualleave);
		result = dao.update();
		return result == 1 ? annualleave : null ;
	}

	public static int setDeleteConditions(BaseAnnualLeave bean, AnnualLeave dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getAnnualLeaveId() != null) {
			dao.setConditionAnnualLeaveId("=", bean.getAnnualLeaveId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeNo() != null) {
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getSecretaryYear() != null) {
				dao.setConditionSecretaryYear("=", bean.getSecretaryYear());
				count++;
			}
			if(bean.getLengthOfService() != null) {
				dao.setConditionLengthOfService("=", bean.getLengthOfService());
				count++;
			}
			if(bean.getYear() != null) {
				dao.setConditionYear("=", bean.getYear());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseAnnualLeave bean, AnnualLeave dao){
		int count = 0;
		if(bean.getAnnualLeaveId() != null) {
			dao.setConditionAnnualLeaveId("=", bean.getAnnualLeaveId());
			count++;
		}
		if(bean.getEmployeeNo() != null) {
			if(bean.getEmployeeNo().indexOf("%") >= 0)
				dao.setConditionEmployeeNo("like", bean.getEmployeeNo());
			else
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getSecretaryYear() != null) {
			dao.setConditionSecretaryYear("=", bean.getSecretaryYear());
			count++;
		}
		if(bean.getLengthOfService() != null) {
			dao.setConditionLengthOfService("=", bean.getLengthOfService());
			count++;
		}
		if(bean.getTotalAnnualLeave() != null) {
			dao.setConditionTotalAnnualLeave("=", bean.getTotalAnnualLeave());
			count++;
		}
		if(bean.getUsageAmountAnnual() != null) {
			dao.setConditionUsageAmountAnnual("=", bean.getUsageAmountAnnual());
			count++;
		}
		if(bean.getRemainingAmountAnnual() != null) {
			dao.setConditionRemainingAmountAnnual("=", bean.getRemainingAmountAnnual());
			count++;
		}
		if(bean.getYear() != null) {
			dao.setConditionYear("=", bean.getYear());
			count++;
		}
		if(bean.getTotalWealfareLeave() != null) {
			dao.setConditionTotalWealfareLeave("=", bean.getTotalWealfareLeave());
			count++;
		}
		if(bean.getUsageAmountWealfare() != null) {
			dao.setConditionUsageAmountWealfare("=", bean.getUsageAmountWealfare());
			count++;
		}
		if(bean.getRemainingAmountWealfare() != null) {
			dao.setConditionRemainingAmountWealfare("=", bean.getRemainingAmountWealfare());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseAnnualLeave bean = new BaseAnnualLeave();
		bean.setDataFromJSON(json);
		AnnualLeave dao = new AnnualLeave();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseAnnualLeave> rlist = new BaseCollection<>();
		BaseAnnualLeave bean = new BaseAnnualLeave();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		AnnualLeave dao = new AnnualLeave();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseAnnualLeave> result = dao.conditionalLoad(addtion);
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
		BaseAnnualLeave bean = new BaseAnnualLeave();
		bean.setDataFromJSON(json);
		AnnualLeave dao = new AnnualLeave();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseAnnualLeave bean = new BaseAnnualLeave();
		bean.setDataFromJSON(json);
		AnnualLeave dao = new AnnualLeave();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseAnnualLeave bean = new BaseAnnualLeave();
		bean.setDataFromJSON(json);
		AnnualLeave dao = new AnnualLeave();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseAnnualLeave bean = new BaseAnnualLeave();
		bean.setDataFromJSON(json);
		AnnualLeave dao = new AnnualLeave();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


