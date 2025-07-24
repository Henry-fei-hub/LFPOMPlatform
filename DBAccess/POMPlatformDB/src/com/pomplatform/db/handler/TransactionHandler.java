package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseTransaction;
import com.pomplatform.db.dao.Transaction;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class TransactionHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(TransactionHandler.class);

	public static BaseTransaction getTransactionById( 
		java.lang.Integer transaction_id
	) throws Exception
	{
		Transaction dao = new Transaction();
		dao.setTransactionId(transaction_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isTransactionExists( com.pomplatform.db.bean.BaseTransaction bean, String additional ) throws Exception {

		Transaction dao = new Transaction();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countTransaction( com.pomplatform.db.bean.BaseTransaction bean, String additional ) throws Exception {

		Transaction dao = new Transaction();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseTransaction> queryTransaction( com.pomplatform.db.bean.BaseTransaction bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		Transaction dao = new Transaction();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseTransaction> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseTransaction> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseTransaction addToTransaction ( BaseTransaction transaction )  throws Exception {
		return addToTransaction ( transaction , false);
	}

	public static BaseTransaction addToTransaction ( BaseTransaction transaction, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		Transaction dao = new Transaction();
		dao.setDataFromBase(transaction);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseTransaction addUpdateTransaction ( BaseTransaction transaction ) throws Exception {
		return addUpdateTransaction ( transaction , false);
	}

	public static BaseTransaction addUpdateTransaction ( BaseTransaction transaction, boolean singleTransaction  ) throws Exception {
		if(transaction.getTransactionId() == null) return addToTransaction(transaction);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		Transaction dao = new Transaction();
		dao.setDataFromBase(transaction);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(transaction); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteTransaction ( BaseTransaction bean ) throws Exception {
		Transaction dao = new Transaction();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseTransaction updateTransaction ( BaseTransaction transaction ) throws Exception {
		Transaction dao = new Transaction();
		dao.setTransactionId( transaction.getTransactionId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(transaction);
			result = dao.update();
		}
		return result == 1 ? transaction : null ;
	}

	public static BaseTransaction updateTransactionDirect( BaseTransaction transaction ) throws Exception {
		Transaction dao = new Transaction();
		int result = 0;
		dao.setDataFromBase(transaction);
		result = dao.update();
		return result == 1 ? transaction : null ;
	}

	public static int setDeleteConditions(BaseTransaction bean, Transaction dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getTransactionId() != null) {
			dao.setConditionTransactionId("=", bean.getTransactionId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getAccount() != null) {
				dao.setConditionAccount("=", bean.getAccount());
				count++;
			}
			if(bean.getAccountId() != null) {
				dao.setConditionAccountId("=", bean.getAccountId());
				count++;
			}
			if(bean.getTransactionType() != null) {
				dao.setConditionTransactionType("=", bean.getTransactionType());
				count++;
			}
			if(bean.getTransactionAbstract() != null) {
				dao.setConditionTransactionAbstract("=", bean.getTransactionAbstract());
				count++;
			}
			if(bean.getDebitCreditFlag() != null) {
				dao.setConditionDebitCreditFlag("=", bean.getDebitCreditFlag());
				count++;
			}
			if(bean.getSequenceNumber() != null) {
				dao.setConditionSequenceNumber("=", bean.getSequenceNumber());
				count++;
			}
			if(bean.getProcessInstanceId() != null) {
				dao.setConditionProcessInstanceId("=", bean.getProcessInstanceId());
				count++;
			}
			if(bean.getBusinessName() != null) {
				dao.setConditionBusinessName("=", bean.getBusinessName());
				count++;
			}
			if(bean.getUsage() != null) {
				dao.setConditionUsage("=", bean.getUsage());
				count++;
			}
			if(bean.getReferenceId() != null) {
				dao.setConditionReferenceId("=", bean.getReferenceId());
				count++;
			}
			if(bean.getBusinessAbstract() != null) {
				dao.setConditionBusinessAbstract("=", bean.getBusinessAbstract());
				count++;
			}
			if(bean.getOtherAbstract() != null) {
				dao.setConditionOtherAbstract("=", bean.getOtherAbstract());
				count++;
			}
			if(bean.getPaymentAccountArea() != null) {
				dao.setConditionPaymentAccountArea("=", bean.getPaymentAccountArea());
				count++;
			}
			if(bean.getPaymentAccount() != null) {
				dao.setConditionPaymentAccount("=", bean.getPaymentAccount());
				count++;
			}
			if(bean.getPaymentAccountName() != null) {
				dao.setConditionPaymentAccountName("=", bean.getPaymentAccountName());
				count++;
			}
			if(bean.getPaymentAccountBranchId() != null) {
				dao.setConditionPaymentAccountBranchId("=", bean.getPaymentAccountBranchId());
				count++;
			}
			if(bean.getPaymentAccountBranchName() != null) {
				dao.setConditionPaymentAccountBranchName("=", bean.getPaymentAccountBranchName());
				count++;
			}
			if(bean.getPaymentAccountBranchAddress() != null) {
				dao.setConditionPaymentAccountBranchAddress("=", bean.getPaymentAccountBranchAddress());
				count++;
			}
			if(bean.getParentAccountArea() != null) {
				dao.setConditionParentAccountArea("=", bean.getParentAccountArea());
				count++;
			}
			if(bean.getParentAccount() != null) {
				dao.setConditionParentAccount("=", bean.getParentAccount());
				count++;
			}
			if(bean.getParentAccountName() != null) {
				dao.setConditionParentAccountName("=", bean.getParentAccountName());
				count++;
			}
			if(bean.getInformationFlag() != null) {
				dao.setConditionInformationFlag("=", bean.getInformationFlag());
				count++;
			}
			if(bean.getHasAttachment() != null) {
				dao.setConditionHasAttachment("=", bean.getHasAttachment());
				count++;
			}
			if(bean.getAttachmentFlag() != null) {
				dao.setConditionAttachmentFlag("=", bean.getAttachmentFlag());
				count++;
			}
			if(bean.getCheckNo() != null) {
				dao.setConditionCheckNo("=", bean.getCheckNo());
				count++;
			}
			if(bean.getReversalFlag() != null) {
				dao.setConditionReversalFlag("=", bean.getReversalFlag());
				count++;
			}
			if(bean.getExtendAbstract() != null) {
				dao.setConditionExtendAbstract("=", bean.getExtendAbstract());
				count++;
			}
			if(bean.getTransactionAnalysisCode() != null) {
				dao.setConditionTransactionAnalysisCode("=", bean.getTransactionAnalysisCode());
				count++;
			}
			if(bean.getBusinessPaymentOrderId() != null) {
				dao.setConditionBusinessPaymentOrderId("=", bean.getBusinessPaymentOrderId());
				count++;
			}
			if(bean.getEnterpriseId() != null) {
				dao.setConditionEnterpriseId("=", bean.getEnterpriseId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseTransaction bean, Transaction dao){
		int count = 0;
		if(bean.getTransactionId() != null) {
			dao.setConditionTransactionId("=", bean.getTransactionId());
			count++;
		}
		if(bean.getAccount() != null) {
			if(bean.getAccount().indexOf("%") >= 0)
				dao.setConditionAccount("like", bean.getAccount());
			else
				dao.setConditionAccount("=", bean.getAccount());
			count++;
		}
		if(bean.getAccountId() != null) {
			dao.setConditionAccountId("=", bean.getAccountId());
			count++;
		}
		if(bean.getTransactionTime() != null) {
			dao.setConditionTransactionTime(">=", bean.getTransactionTime());
			count++;
		}
		if(bean.getValueOfDate() != null) {
			dao.setConditionValueOfDate(">=", bean.getValueOfDate());
			count++;
		}
		if(bean.getTransactionType() != null) {
			dao.setConditionTransactionType("=", bean.getTransactionType());
			count++;
		}
		if(bean.getTransactionAbstract() != null) {
			if(bean.getTransactionAbstract().indexOf("%") >= 0)
				dao.setConditionTransactionAbstract("like", bean.getTransactionAbstract());
			else
				dao.setConditionTransactionAbstract("=", bean.getTransactionAbstract());
			count++;
		}
		if(bean.getDebitAmount() != null) {
			dao.setConditionDebitAmount("=", bean.getDebitAmount());
			count++;
		}
		if(bean.getCreditAmount() != null) {
			dao.setConditionCreditAmount("=", bean.getCreditAmount());
			count++;
		}
		if(bean.getDebitCreditFlag() != null) {
			if(bean.getDebitCreditFlag().indexOf("%") >= 0)
				dao.setConditionDebitCreditFlag("like", bean.getDebitCreditFlag());
			else
				dao.setConditionDebitCreditFlag("=", bean.getDebitCreditFlag());
			count++;
		}
		if(bean.getBalance() != null) {
			dao.setConditionBalance("=", bean.getBalance());
			count++;
		}
		if(bean.getSequenceNumber() != null) {
			if(bean.getSequenceNumber().indexOf("%") >= 0)
				dao.setConditionSequenceNumber("like", bean.getSequenceNumber());
			else
				dao.setConditionSequenceNumber("=", bean.getSequenceNumber());
			count++;
		}
		if(bean.getProcessInstanceId() != null) {
			if(bean.getProcessInstanceId().indexOf("%") >= 0)
				dao.setConditionProcessInstanceId("like", bean.getProcessInstanceId());
			else
				dao.setConditionProcessInstanceId("=", bean.getProcessInstanceId());
			count++;
		}
		if(bean.getBusinessName() != null) {
			if(bean.getBusinessName().indexOf("%") >= 0)
				dao.setConditionBusinessName("like", bean.getBusinessName());
			else
				dao.setConditionBusinessName("=", bean.getBusinessName());
			count++;
		}
		if(bean.getUsage() != null) {
			if(bean.getUsage().indexOf("%") >= 0)
				dao.setConditionUsage("like", bean.getUsage());
			else
				dao.setConditionUsage("=", bean.getUsage());
			count++;
		}
		if(bean.getReferenceId() != null) {
			if(bean.getReferenceId().indexOf("%") >= 0)
				dao.setConditionReferenceId("like", bean.getReferenceId());
			else
				dao.setConditionReferenceId("=", bean.getReferenceId());
			count++;
		}
		if(bean.getBusinessAbstract() != null) {
			if(bean.getBusinessAbstract().indexOf("%") >= 0)
				dao.setConditionBusinessAbstract("like", bean.getBusinessAbstract());
			else
				dao.setConditionBusinessAbstract("=", bean.getBusinessAbstract());
			count++;
		}
		if(bean.getOtherAbstract() != null) {
			if(bean.getOtherAbstract().indexOf("%") >= 0)
				dao.setConditionOtherAbstract("like", bean.getOtherAbstract());
			else
				dao.setConditionOtherAbstract("=", bean.getOtherAbstract());
			count++;
		}
		if(bean.getPaymentAccountArea() != null) {
			if(bean.getPaymentAccountArea().indexOf("%") >= 0)
				dao.setConditionPaymentAccountArea("like", bean.getPaymentAccountArea());
			else
				dao.setConditionPaymentAccountArea("=", bean.getPaymentAccountArea());
			count++;
		}
		if(bean.getPaymentAccount() != null) {
			if(bean.getPaymentAccount().indexOf("%") >= 0)
				dao.setConditionPaymentAccount("like", bean.getPaymentAccount());
			else
				dao.setConditionPaymentAccount("=", bean.getPaymentAccount());
			count++;
		}
		if(bean.getPaymentAccountName() != null) {
			if(bean.getPaymentAccountName().indexOf("%") >= 0)
				dao.setConditionPaymentAccountName("like", bean.getPaymentAccountName());
			else
				dao.setConditionPaymentAccountName("=", bean.getPaymentAccountName());
			count++;
		}
		if(bean.getPaymentAccountBranchId() != null) {
			if(bean.getPaymentAccountBranchId().indexOf("%") >= 0)
				dao.setConditionPaymentAccountBranchId("like", bean.getPaymentAccountBranchId());
			else
				dao.setConditionPaymentAccountBranchId("=", bean.getPaymentAccountBranchId());
			count++;
		}
		if(bean.getPaymentAccountBranchName() != null) {
			if(bean.getPaymentAccountBranchName().indexOf("%") >= 0)
				dao.setConditionPaymentAccountBranchName("like", bean.getPaymentAccountBranchName());
			else
				dao.setConditionPaymentAccountBranchName("=", bean.getPaymentAccountBranchName());
			count++;
		}
		if(bean.getPaymentAccountBranchAddress() != null) {
			if(bean.getPaymentAccountBranchAddress().indexOf("%") >= 0)
				dao.setConditionPaymentAccountBranchAddress("like", bean.getPaymentAccountBranchAddress());
			else
				dao.setConditionPaymentAccountBranchAddress("=", bean.getPaymentAccountBranchAddress());
			count++;
		}
		if(bean.getParentAccountArea() != null) {
			if(bean.getParentAccountArea().indexOf("%") >= 0)
				dao.setConditionParentAccountArea("like", bean.getParentAccountArea());
			else
				dao.setConditionParentAccountArea("=", bean.getParentAccountArea());
			count++;
		}
		if(bean.getParentAccount() != null) {
			if(bean.getParentAccount().indexOf("%") >= 0)
				dao.setConditionParentAccount("like", bean.getParentAccount());
			else
				dao.setConditionParentAccount("=", bean.getParentAccount());
			count++;
		}
		if(bean.getParentAccountName() != null) {
			if(bean.getParentAccountName().indexOf("%") >= 0)
				dao.setConditionParentAccountName("like", bean.getParentAccountName());
			else
				dao.setConditionParentAccountName("=", bean.getParentAccountName());
			count++;
		}
		if(bean.getInformationFlag() != null) {
			if(bean.getInformationFlag().indexOf("%") >= 0)
				dao.setConditionInformationFlag("like", bean.getInformationFlag());
			else
				dao.setConditionInformationFlag("=", bean.getInformationFlag());
			count++;
		}
		if(bean.getHasAttachment() != null) {
			if(bean.getHasAttachment().indexOf("%") >= 0)
				dao.setConditionHasAttachment("like", bean.getHasAttachment());
			else
				dao.setConditionHasAttachment("=", bean.getHasAttachment());
			count++;
		}
		if(bean.getAttachmentFlag() != null) {
			if(bean.getAttachmentFlag().indexOf("%") >= 0)
				dao.setConditionAttachmentFlag("like", bean.getAttachmentFlag());
			else
				dao.setConditionAttachmentFlag("=", bean.getAttachmentFlag());
			count++;
		}
		if(bean.getCheckNo() != null) {
			if(bean.getCheckNo().indexOf("%") >= 0)
				dao.setConditionCheckNo("like", bean.getCheckNo());
			else
				dao.setConditionCheckNo("=", bean.getCheckNo());
			count++;
		}
		if(bean.getReversalFlag() != null) {
			if(bean.getReversalFlag().indexOf("%") >= 0)
				dao.setConditionReversalFlag("like", bean.getReversalFlag());
			else
				dao.setConditionReversalFlag("=", bean.getReversalFlag());
			count++;
		}
		if(bean.getExtendAbstract() != null) {
			if(bean.getExtendAbstract().indexOf("%") >= 0)
				dao.setConditionExtendAbstract("like", bean.getExtendAbstract());
			else
				dao.setConditionExtendAbstract("=", bean.getExtendAbstract());
			count++;
		}
		if(bean.getTransactionAnalysisCode() != null) {
			if(bean.getTransactionAnalysisCode().indexOf("%") >= 0)
				dao.setConditionTransactionAnalysisCode("like", bean.getTransactionAnalysisCode());
			else
				dao.setConditionTransactionAnalysisCode("=", bean.getTransactionAnalysisCode());
			count++;
		}
		if(bean.getBusinessPaymentOrderId() != null) {
			if(bean.getBusinessPaymentOrderId().indexOf("%") >= 0)
				dao.setConditionBusinessPaymentOrderId("like", bean.getBusinessPaymentOrderId());
			else
				dao.setConditionBusinessPaymentOrderId("=", bean.getBusinessPaymentOrderId());
			count++;
		}
		if(bean.getEnterpriseId() != null) {
			if(bean.getEnterpriseId().indexOf("%") >= 0)
				dao.setConditionEnterpriseId("like", bean.getEnterpriseId());
			else
				dao.setConditionEnterpriseId("=", bean.getEnterpriseId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseTransaction bean = new BaseTransaction();
		bean.setDataFromJSON(json);
		Transaction dao = new Transaction();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseTransaction> rlist = new BaseCollection<>();
		BaseTransaction bean = new BaseTransaction();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		Transaction dao = new Transaction();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseTransaction> result = dao.conditionalLoad(addtion);
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
		BaseTransaction bean = new BaseTransaction();
		bean.setDataFromJSON(json);
		Transaction dao = new Transaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseTransaction bean = new BaseTransaction();
		bean.setDataFromJSON(json);
		Transaction dao = new Transaction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseTransaction bean = new BaseTransaction();
		bean.setDataFromJSON(json);
		Transaction dao = new Transaction();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseTransaction bean = new BaseTransaction();
		bean.setDataFromJSON(json);
		Transaction dao = new Transaction();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


