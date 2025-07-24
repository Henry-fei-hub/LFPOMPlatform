package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseReimbursementPackageDetail;
import com.pomplatform.db.dao.ReimbursementPackageDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ReimbursementPackageDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ReimbursementPackageDetailHandler.class);

	public static BaseReimbursementPackageDetail getReimbursementPackageDetailById( 
		java.lang.Integer reimbursement_package_detail_id
	) throws Exception
	{
		ReimbursementPackageDetail dao = new ReimbursementPackageDetail();
		dao.setReimbursementPackageDetailId(reimbursement_package_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isReimbursementPackageDetailExists( com.pomplatform.db.bean.BaseReimbursementPackageDetail bean, String additional ) throws Exception {

		ReimbursementPackageDetail dao = new ReimbursementPackageDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countReimbursementPackageDetail( com.pomplatform.db.bean.BaseReimbursementPackageDetail bean, String additional ) throws Exception {

		ReimbursementPackageDetail dao = new ReimbursementPackageDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseReimbursementPackageDetail> queryReimbursementPackageDetail( com.pomplatform.db.bean.BaseReimbursementPackageDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ReimbursementPackageDetail dao = new ReimbursementPackageDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseReimbursementPackageDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseReimbursementPackageDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseReimbursementPackageDetail addToReimbursementPackageDetail ( BaseReimbursementPackageDetail reimbursementpackagedetail )  throws Exception {
		return addToReimbursementPackageDetail ( reimbursementpackagedetail , false);
	}

	public static BaseReimbursementPackageDetail addToReimbursementPackageDetail ( BaseReimbursementPackageDetail reimbursementpackagedetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ReimbursementPackageDetail dao = new ReimbursementPackageDetail();
		dao.setDataFromBase(reimbursementpackagedetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseReimbursementPackageDetail addUpdateReimbursementPackageDetail ( BaseReimbursementPackageDetail reimbursementpackagedetail ) throws Exception {
		return addUpdateReimbursementPackageDetail ( reimbursementpackagedetail , false);
	}

	public static BaseReimbursementPackageDetail addUpdateReimbursementPackageDetail ( BaseReimbursementPackageDetail reimbursementpackagedetail, boolean singleTransaction  ) throws Exception {
		if(reimbursementpackagedetail.getReimbursementPackageDetailId() == null) return addToReimbursementPackageDetail(reimbursementpackagedetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ReimbursementPackageDetail dao = new ReimbursementPackageDetail();
		dao.setDataFromBase(reimbursementpackagedetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(reimbursementpackagedetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteReimbursementPackageDetail ( BaseReimbursementPackageDetail bean ) throws Exception {
		ReimbursementPackageDetail dao = new ReimbursementPackageDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseReimbursementPackageDetail updateReimbursementPackageDetail ( BaseReimbursementPackageDetail reimbursementpackagedetail ) throws Exception {
		ReimbursementPackageDetail dao = new ReimbursementPackageDetail();
		dao.setReimbursementPackageDetailId( reimbursementpackagedetail.getReimbursementPackageDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(reimbursementpackagedetail);
			result = dao.update();
		}
		return result == 1 ? reimbursementpackagedetail : null ;
	}

	public static BaseReimbursementPackageDetail updateReimbursementPackageDetailDirect( BaseReimbursementPackageDetail reimbursementpackagedetail ) throws Exception {
		ReimbursementPackageDetail dao = new ReimbursementPackageDetail();
		int result = 0;
		dao.setDataFromBase(reimbursementpackagedetail);
		result = dao.update();
		return result == 1 ? reimbursementpackagedetail : null ;
	}

	public static int setDeleteConditions(BaseReimbursementPackageDetail bean, ReimbursementPackageDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getReimbursementPackageDetailId() != null) {
			dao.setConditionReimbursementPackageDetailId("=", bean.getReimbursementPackageDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getReimbursementPackageId() != null) {
				dao.setConditionReimbursementPackageId("=", bean.getReimbursementPackageId());
				count++;
			}
			if(bean.getProcessTypeId() != null) {
				dao.setConditionProcessTypeId("=", bean.getProcessTypeId());
				count++;
			}
			if(bean.getProcessId() != null) {
				dao.setConditionProcessId("=", bean.getProcessId());
				count++;
			}
			if(bean.getBusinessId() != null) {
				dao.setConditionBusinessId("=", bean.getBusinessId());
				count++;
			}
			if(bean.getProcessInstanceId() != null) {
				dao.setConditionProcessInstanceId("=", bean.getProcessInstanceId());
				count++;
			}
			if(bean.getCode() != null) {
				dao.setConditionCode("=", bean.getCode());
				count++;
			}
			if(bean.getDrafter() != null) {
				dao.setConditionDrafter("=", bean.getDrafter());
				count++;
			}
			if(bean.getPayFor() != null) {
				dao.setConditionPayFor("=", bean.getPayFor());
				count++;
			}
			if(bean.getEmployeeOrCompanyId() != null) {
				dao.setConditionEmployeeOrCompanyId("=", bean.getEmployeeOrCompanyId());
				count++;
			}
			if(bean.getPayeeName() != null) {
				dao.setConditionPayeeName("=", bean.getPayeeName());
				count++;
			}
			if(bean.getSelfBankName() != null) {
				dao.setConditionSelfBankName("=", bean.getSelfBankName());
				count++;
			}
			if(bean.getSelfBankAccount() != null) {
				dao.setConditionSelfBankAccount("=", bean.getSelfBankAccount());
				count++;
			}
			if(bean.getProcessBillListId() != null) {
				dao.setConditionProcessBillListId("=", bean.getProcessBillListId());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
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
			if(bean.getPayType() != null) {
				dao.setConditionPayType("=", bean.getPayType());
				count++;
			}
			if(bean.getPersonnelBusinessId() != null) {
				dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
				count++;
			}
			if(bean.getEmployeeFundIssuanceId() != null) {
				dao.setConditionEmployeeFundIssuanceId("=", bean.getEmployeeFundIssuanceId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseReimbursementPackageDetail bean, ReimbursementPackageDetail dao){
		int count = 0;
		if(bean.getReimbursementPackageDetailId() != null) {
			dao.setConditionReimbursementPackageDetailId("=", bean.getReimbursementPackageDetailId());
			count++;
		}
		if(bean.getReimbursementPackageId() != null) {
			dao.setConditionReimbursementPackageId("=", bean.getReimbursementPackageId());
			count++;
		}
		if(bean.getProcessTypeId() != null) {
			dao.setConditionProcessTypeId("=", bean.getProcessTypeId());
			count++;
		}
		if(bean.getProcessId() != null) {
			dao.setConditionProcessId("=", bean.getProcessId());
			count++;
		}
		if(bean.getBusinessId() != null) {
			dao.setConditionBusinessId("=", bean.getBusinessId());
			count++;
		}
		if(bean.getProcessInstanceId() != null) {
			dao.setConditionProcessInstanceId("=", bean.getProcessInstanceId());
			count++;
		}
		if(bean.getCode() != null) {
			if(bean.getCode().indexOf("%") >= 0)
				dao.setConditionCode("like", bean.getCode());
			else
				dao.setConditionCode("=", bean.getCode());
			count++;
		}
		if(bean.getDrafter() != null) {
			dao.setConditionDrafter("=", bean.getDrafter());
			count++;
		}
		if(bean.getPayFor() != null) {
			dao.setConditionPayFor("=", bean.getPayFor());
			count++;
		}
		if(bean.getEmployeeOrCompanyId() != null) {
			dao.setConditionEmployeeOrCompanyId("=", bean.getEmployeeOrCompanyId());
			count++;
		}
		if(bean.getPayeeName() != null) {
			if(bean.getPayeeName().indexOf("%") >= 0)
				dao.setConditionPayeeName("like", bean.getPayeeName());
			else
				dao.setConditionPayeeName("=", bean.getPayeeName());
			count++;
		}
		if(bean.getSelfBankName() != null) {
			if(bean.getSelfBankName().indexOf("%") >= 0)
				dao.setConditionSelfBankName("like", bean.getSelfBankName());
			else
				dao.setConditionSelfBankName("=", bean.getSelfBankName());
			count++;
		}
		if(bean.getSelfBankAccount() != null) {
			if(bean.getSelfBankAccount().indexOf("%") >= 0)
				dao.setConditionSelfBankAccount("like", bean.getSelfBankAccount());
			else
				dao.setConditionSelfBankAccount("=", bean.getSelfBankAccount());
			count++;
		}
		if(bean.getAmount() != null) {
			dao.setConditionAmount("=", bean.getAmount());
			count++;
		}
		if(bean.getPaymentAmount() != null) {
			dao.setConditionPaymentAmount("=", bean.getPaymentAmount());
			count++;
		}
		if(bean.getStrikeABalanceAmount() != null) {
			dao.setConditionStrikeABalanceAmount("=", bean.getStrikeABalanceAmount());
			count++;
		}
		if(bean.getProcessBillListId() != null) {
			dao.setConditionProcessBillListId("=", bean.getProcessBillListId());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getUpdateTime() != null) {
			dao.setConditionUpdateTime(">=", bean.getUpdateTime());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
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
		if(bean.getPayType() != null) {
			dao.setConditionPayType("=", bean.getPayType());
			count++;
		}
		if(bean.getPersonnelBusinessId() != null) {
			dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
			count++;
		}
		if(bean.getEmployeeFundIssuanceId() != null) {
			dao.setConditionEmployeeFundIssuanceId("=", bean.getEmployeeFundIssuanceId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseReimbursementPackageDetail bean = new BaseReimbursementPackageDetail();
		bean.setDataFromJSON(json);
		ReimbursementPackageDetail dao = new ReimbursementPackageDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseReimbursementPackageDetail> rlist = new BaseCollection<>();
		BaseReimbursementPackageDetail bean = new BaseReimbursementPackageDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ReimbursementPackageDetail dao = new ReimbursementPackageDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseReimbursementPackageDetail> result = dao.conditionalLoad(addtion);
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
		BaseReimbursementPackageDetail bean = new BaseReimbursementPackageDetail();
		bean.setDataFromJSON(json);
		ReimbursementPackageDetail dao = new ReimbursementPackageDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseReimbursementPackageDetail bean = new BaseReimbursementPackageDetail();
		bean.setDataFromJSON(json);
		ReimbursementPackageDetail dao = new ReimbursementPackageDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseReimbursementPackageDetail bean = new BaseReimbursementPackageDetail();
		bean.setDataFromJSON(json);
		ReimbursementPackageDetail dao = new ReimbursementPackageDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseReimbursementPackageDetail bean = new BaseReimbursementPackageDetail();
		bean.setDataFromJSON(json);
		ReimbursementPackageDetail dao = new ReimbursementPackageDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


