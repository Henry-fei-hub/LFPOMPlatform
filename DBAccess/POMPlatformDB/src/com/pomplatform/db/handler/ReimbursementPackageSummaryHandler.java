package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseReimbursementPackageSummary;
import com.pomplatform.db.dao.ReimbursementPackageSummary;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ReimbursementPackageSummaryHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ReimbursementPackageSummaryHandler.class);

	public static BaseReimbursementPackageSummary getReimbursementPackageSummaryById( 
		java.lang.Integer reimbursement_package_summary_id
	) throws Exception
	{
		ReimbursementPackageSummary dao = new ReimbursementPackageSummary();
		dao.setReimbursementPackageSummaryId(reimbursement_package_summary_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isReimbursementPackageSummaryExists( com.pomplatform.db.bean.BaseReimbursementPackageSummary bean, String additional ) throws Exception {

		ReimbursementPackageSummary dao = new ReimbursementPackageSummary();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countReimbursementPackageSummary( com.pomplatform.db.bean.BaseReimbursementPackageSummary bean, String additional ) throws Exception {

		ReimbursementPackageSummary dao = new ReimbursementPackageSummary();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseReimbursementPackageSummary> queryReimbursementPackageSummary( com.pomplatform.db.bean.BaseReimbursementPackageSummary bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ReimbursementPackageSummary dao = new ReimbursementPackageSummary();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseReimbursementPackageSummary> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseReimbursementPackageSummary> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseReimbursementPackageSummary addToReimbursementPackageSummary ( BaseReimbursementPackageSummary reimbursementpackagesummary )  throws Exception {
		return addToReimbursementPackageSummary ( reimbursementpackagesummary , false);
	}

	public static BaseReimbursementPackageSummary addToReimbursementPackageSummary ( BaseReimbursementPackageSummary reimbursementpackagesummary, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ReimbursementPackageSummary dao = new ReimbursementPackageSummary();
		dao.setDataFromBase(reimbursementpackagesummary);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseReimbursementPackageSummary addUpdateReimbursementPackageSummary ( BaseReimbursementPackageSummary reimbursementpackagesummary ) throws Exception {
		return addUpdateReimbursementPackageSummary ( reimbursementpackagesummary , false);
	}

	public static BaseReimbursementPackageSummary addUpdateReimbursementPackageSummary ( BaseReimbursementPackageSummary reimbursementpackagesummary, boolean singleTransaction  ) throws Exception {
		if(reimbursementpackagesummary.getReimbursementPackageSummaryId() == null) return addToReimbursementPackageSummary(reimbursementpackagesummary);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ReimbursementPackageSummary dao = new ReimbursementPackageSummary();
		dao.setDataFromBase(reimbursementpackagesummary);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(reimbursementpackagesummary); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteReimbursementPackageSummary ( BaseReimbursementPackageSummary bean ) throws Exception {
		ReimbursementPackageSummary dao = new ReimbursementPackageSummary();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseReimbursementPackageSummary updateReimbursementPackageSummary ( BaseReimbursementPackageSummary reimbursementpackagesummary ) throws Exception {
		ReimbursementPackageSummary dao = new ReimbursementPackageSummary();
		dao.setReimbursementPackageSummaryId( reimbursementpackagesummary.getReimbursementPackageSummaryId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(reimbursementpackagesummary);
			result = dao.update();
		}
		return result == 1 ? reimbursementpackagesummary : null ;
	}

	public static BaseReimbursementPackageSummary updateReimbursementPackageSummaryDirect( BaseReimbursementPackageSummary reimbursementpackagesummary ) throws Exception {
		ReimbursementPackageSummary dao = new ReimbursementPackageSummary();
		int result = 0;
		dao.setDataFromBase(reimbursementpackagesummary);
		result = dao.update();
		return result == 1 ? reimbursementpackagesummary : null ;
	}

	public static int setDeleteConditions(BaseReimbursementPackageSummary bean, ReimbursementPackageSummary dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getReimbursementPackageSummaryId() != null) {
			dao.setConditionReimbursementPackageSummaryId("=", bean.getReimbursementPackageSummaryId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getReimbursementPackageId() != null) {
				dao.setConditionReimbursementPackageId("=", bean.getReimbursementPackageId());
				count++;
			}
			if(bean.getMoneyAttribute() != null) {
				dao.setConditionMoneyAttribute("=", bean.getMoneyAttribute());
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
			if(bean.getOtherName() != null) {
				dao.setConditionOtherName("=", bean.getOtherName());
				count++;
			}
			if(bean.getOtherBankName() != null) {
				dao.setConditionOtherBankName("=", bean.getOtherBankName());
				count++;
			}
			if(bean.getOtherBankAccount() != null) {
				dao.setConditionOtherBankAccount("=", bean.getOtherBankAccount());
				count++;
			}
			if(bean.getIsCompleted() != null) {
				dao.setConditionIsCompleted("=", bean.getIsCompleted());
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
			if(bean.getCmbcPaymentId() != null) {
				dao.setConditionCmbcPaymentId("=", bean.getCmbcPaymentId());
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

	public static int setConditions(BaseReimbursementPackageSummary bean, ReimbursementPackageSummary dao){
		int count = 0;
		if(bean.getReimbursementPackageSummaryId() != null) {
			dao.setConditionReimbursementPackageSummaryId("=", bean.getReimbursementPackageSummaryId());
			count++;
		}
		if(bean.getReimbursementPackageId() != null) {
			dao.setConditionReimbursementPackageId("=", bean.getReimbursementPackageId());
			count++;
		}
		if(bean.getMoneyAttribute() != null) {
			dao.setConditionMoneyAttribute("=", bean.getMoneyAttribute());
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
		if(bean.getOtherName() != null) {
			dao.setConditionOtherName("=", bean.getOtherName());
			count++;
		}
		if(bean.getOtherBankName() != null) {
			if(bean.getOtherBankName().indexOf("%") >= 0)
				dao.setConditionOtherBankName("like", bean.getOtherBankName());
			else
				dao.setConditionOtherBankName("=", bean.getOtherBankName());
			count++;
		}
		if(bean.getOtherBankAccount() != null) {
			if(bean.getOtherBankAccount().indexOf("%") >= 0)
				dao.setConditionOtherBankAccount("like", bean.getOtherBankAccount());
			else
				dao.setConditionOtherBankAccount("=", bean.getOtherBankAccount());
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
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getUpdateTime() != null) {
			dao.setConditionUpdateTime(">=", bean.getUpdateTime());
			count++;
		}
		if(bean.getIsCompleted() != null) {
			dao.setConditionIsCompleted("=", bean.getIsCompleted());
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
		if(bean.getCmbcPaymentId() != null) {
			dao.setConditionCmbcPaymentId("=", bean.getCmbcPaymentId());
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
		BaseReimbursementPackageSummary bean = new BaseReimbursementPackageSummary();
		bean.setDataFromJSON(json);
		ReimbursementPackageSummary dao = new ReimbursementPackageSummary();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseReimbursementPackageSummary> rlist = new BaseCollection<>();
		BaseReimbursementPackageSummary bean = new BaseReimbursementPackageSummary();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ReimbursementPackageSummary dao = new ReimbursementPackageSummary();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseReimbursementPackageSummary> result = dao.conditionalLoad(addtion);
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
		BaseReimbursementPackageSummary bean = new BaseReimbursementPackageSummary();
		bean.setDataFromJSON(json);
		ReimbursementPackageSummary dao = new ReimbursementPackageSummary();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseReimbursementPackageSummary bean = new BaseReimbursementPackageSummary();
		bean.setDataFromJSON(json);
		ReimbursementPackageSummary dao = new ReimbursementPackageSummary();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseReimbursementPackageSummary bean = new BaseReimbursementPackageSummary();
		bean.setDataFromJSON(json);
		ReimbursementPackageSummary dao = new ReimbursementPackageSummary();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseReimbursementPackageSummary bean = new BaseReimbursementPackageSummary();
		bean.setDataFromJSON(json);
		ReimbursementPackageSummary dao = new ReimbursementPackageSummary();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


