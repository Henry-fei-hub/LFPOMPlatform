package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseOutputAccountDetail;
import java.util.List;
import com.pomplatform.db.dao.OutputAccountDetail;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class OutputAccountDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(OutputAccountDetailHandler.class);

	public static BaseOutputAccountDetail getOutputAccountDetailById( 
		java.lang.Integer output_account_detail_id
	) throws Exception
	{
		OutputAccountDetail dao = new OutputAccountDetail();
		dao.setOutputAccountDetailId(output_account_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isOutputAccountDetailExists( com.pomplatform.db.bean.BaseOutputAccountDetail bean, String additional ) throws Exception {

		OutputAccountDetail dao = new OutputAccountDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countOutputAccountDetail( com.pomplatform.db.bean.BaseOutputAccountDetail bean, String additional ) throws Exception {

		OutputAccountDetail dao = new OutputAccountDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseOutputAccountDetail> queryOutputAccountDetail( com.pomplatform.db.bean.BaseOutputAccountDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		OutputAccountDetail dao = new OutputAccountDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseOutputAccountDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseOutputAccountDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseOutputAccountDetail addToOutputAccountDetail ( BaseOutputAccountDetail outputaccountdetail )  throws Exception {
		return addToOutputAccountDetail ( outputaccountdetail , false);
	}

	public static BaseOutputAccountDetail addToOutputAccountDetail ( BaseOutputAccountDetail outputaccountdetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		OutputAccountDetail dao = new OutputAccountDetail();
		dao.setDataFromBase(outputaccountdetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseOutputAccountDetail addUpdateOutputAccountDetail ( BaseOutputAccountDetail outputaccountdetail ) throws Exception {
		return addUpdateOutputAccountDetail ( outputaccountdetail , false);
	}

	public static BaseOutputAccountDetail addUpdateOutputAccountDetail ( BaseOutputAccountDetail outputaccountdetail, boolean singleTransaction  ) throws Exception {
		if(outputaccountdetail.getOutputAccountDetailId() == null) return addToOutputAccountDetail(outputaccountdetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		OutputAccountDetail dao = new OutputAccountDetail();
		dao.setDataFromBase(outputaccountdetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(outputaccountdetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteOutputAccountDetail ( BaseOutputAccountDetail bean ) throws Exception {
		OutputAccountDetail dao = new OutputAccountDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseOutputAccountDetail updateOutputAccountDetail ( BaseOutputAccountDetail outputaccountdetail ) throws Exception {
		OutputAccountDetail dao = new OutputAccountDetail();
		dao.setOutputAccountDetailId( outputaccountdetail.getOutputAccountDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(outputaccountdetail);
			result = dao.update();
		}
		return result == 1 ? outputaccountdetail : null ;
	}

	public static BaseOutputAccountDetail updateOutputAccountDetailDirect( BaseOutputAccountDetail outputaccountdetail ) throws Exception {
		OutputAccountDetail dao = new OutputAccountDetail();
		int result = 0;
		dao.setDataFromBase(outputaccountdetail);
		result = dao.update();
		return result == 1 ? outputaccountdetail : null ;
	}

	public static int setDeleteConditions(BaseOutputAccountDetail bean, OutputAccountDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getOutputAccountDetailId() != null) {
			dao.setConditionOutputAccountDetailId("=", bean.getOutputAccountDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getOutputAccountRecordId() != null) {
				dao.setConditionOutputAccountRecordId("=", bean.getOutputAccountRecordId());
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
			if(bean.getIsYearFinalAccount() != null) {
				dao.setConditionIsYearFinalAccount("=", bean.getIsYearFinalAccount());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseOutputAccountDetail bean, OutputAccountDetail dao){
		int count = 0;
		if(bean.getOutputAccountDetailId() != null) {
			dao.setConditionOutputAccountDetailId("=", bean.getOutputAccountDetailId());
			count++;
		}
		if(bean.getOutputAccountRecordId() != null) {
			dao.setConditionOutputAccountRecordId("=", bean.getOutputAccountRecordId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getAccountIntegral() != null) {
			dao.setConditionAccountIntegral("=", bean.getAccountIntegral());
			count++;
		}
		if(bean.getStartDate() != null) {
			dao.setConditionStartDate(">=", bean.getStartDate());
			count++;
		}
		if(bean.getEndDate() != null) {
			dao.setConditionEndDate(">=", bean.getEndDate());
			count++;
		}
		if(bean.getAccountDate() != null) {
			dao.setConditionAccountDate(">=", bean.getAccountDate());
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
		if(bean.getIsYearFinalAccount() != null) {
			dao.setConditionIsYearFinalAccount("=", bean.getIsYearFinalAccount());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseOutputAccountDetail bean = new BaseOutputAccountDetail();
		bean.setDataFromJSON(json);
		OutputAccountDetail dao = new OutputAccountDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseOutputAccountDetail> rlist = new BaseCollection<>();
		BaseOutputAccountDetail bean = new BaseOutputAccountDetail();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		OutputAccountDetail dao = new OutputAccountDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseOutputAccountDetail> result = dao.conditionalLoad(addtion);
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
		BaseOutputAccountDetail bean = new BaseOutputAccountDetail();
		bean.setDataFromJSON(json);
		OutputAccountDetail dao = new OutputAccountDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseOutputAccountDetail bean = new BaseOutputAccountDetail();
		bean.setDataFromJSON(json);
		OutputAccountDetail dao = new OutputAccountDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseOutputAccountDetail bean = new BaseOutputAccountDetail();
		bean.setDataFromJSON(json);
		OutputAccountDetail dao = new OutputAccountDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseOutputAccountDetail bean = new BaseOutputAccountDetail();
		bean.setDataFromJSON(json);
		OutputAccountDetail dao = new OutputAccountDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


