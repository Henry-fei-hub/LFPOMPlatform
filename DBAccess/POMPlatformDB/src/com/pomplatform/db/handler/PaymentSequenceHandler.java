package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePaymentSequence;
import com.pomplatform.db.dao.PaymentSequence;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PaymentSequenceHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PaymentSequenceHandler.class);

	public static BasePaymentSequence getPaymentSequenceById( 
		java.lang.Integer payment_sequence_id
	) throws Exception
	{
		PaymentSequence dao = new PaymentSequence();
		dao.setPaymentSequenceId(payment_sequence_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPaymentSequenceExists( com.pomplatform.db.bean.BasePaymentSequence bean, String additional ) throws Exception {

		PaymentSequence dao = new PaymentSequence();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPaymentSequence( com.pomplatform.db.bean.BasePaymentSequence bean, String additional ) throws Exception {

		PaymentSequence dao = new PaymentSequence();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePaymentSequence> queryPaymentSequence( com.pomplatform.db.bean.BasePaymentSequence bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PaymentSequence dao = new PaymentSequence();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePaymentSequence> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePaymentSequence> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePaymentSequence addToPaymentSequence ( BasePaymentSequence paymentsequence )  throws Exception {
		return addToPaymentSequence ( paymentsequence , false);
	}

	public static BasePaymentSequence addToPaymentSequence ( BasePaymentSequence paymentsequence, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PaymentSequence dao = new PaymentSequence();
		dao.setDataFromBase(paymentsequence);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePaymentSequence addUpdatePaymentSequence ( BasePaymentSequence paymentsequence ) throws Exception {
		return addUpdatePaymentSequence ( paymentsequence , false);
	}

	public static BasePaymentSequence addUpdatePaymentSequence ( BasePaymentSequence paymentsequence, boolean singleTransaction  ) throws Exception {
		if(paymentsequence.getPaymentSequenceId() == null) return addToPaymentSequence(paymentsequence);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PaymentSequence dao = new PaymentSequence();
		dao.setDataFromBase(paymentsequence);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(paymentsequence); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePaymentSequence ( BasePaymentSequence bean ) throws Exception {
		PaymentSequence dao = new PaymentSequence();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePaymentSequence updatePaymentSequence ( BasePaymentSequence paymentsequence ) throws Exception {
		PaymentSequence dao = new PaymentSequence();
		dao.setPaymentSequenceId( paymentsequence.getPaymentSequenceId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(paymentsequence);
			result = dao.update();
		}
		return result == 1 ? paymentsequence : null ;
	}

	public static BasePaymentSequence updatePaymentSequenceDirect( BasePaymentSequence paymentsequence ) throws Exception {
		PaymentSequence dao = new PaymentSequence();
		int result = 0;
		dao.setDataFromBase(paymentsequence);
		result = dao.update();
		return result == 1 ? paymentsequence : null ;
	}

	public static int setDeleteConditions(BasePaymentSequence bean, PaymentSequence dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPaymentSequenceId() != null) {
			dao.setConditionPaymentSequenceId("=", bean.getPaymentSequenceId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getBudgetManagementId() != null) {
				dao.setConditionBudgetManagementId("=", bean.getBudgetManagementId());
				count++;
			}
			if(bean.getBudgetAttachmentId() != null) {
				dao.setConditionBudgetAttachmentId("=", bean.getBudgetAttachmentId());
				count++;
			}
			if(bean.getPayStatus() != null) {
				dao.setConditionPayStatus("=", bean.getPayStatus());
				count++;
			}
			if(bean.getPsRemark() != null) {
				dao.setConditionPsRemark("=", bean.getPsRemark());
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
			if(bean.getReceiveUnitManageId() != null) {
				dao.setConditionReceiveUnitManageId("=", bean.getReceiveUnitManageId());
				count++;
			}
			if(bean.getProcessBillListId() != null) {
				dao.setConditionProcessBillListId("=", bean.getProcessBillListId());
				count++;
			}
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getBindStatus() != null) {
				dao.setConditionBindStatus("=", bean.getBindStatus());
				count++;
			}
			if(bean.getPayType() != null) {
				dao.setConditionPayType("=", bean.getPayType());
				count++;
			}
			if(bean.getIsLock() != null) {
				dao.setConditionIsLock("=", bean.getIsLock());
				count++;
			}
			if(bean.getPayFor() != null) {
				dao.setConditionPayFor("=", bean.getPayFor());
				count++;
			}
			if(bean.getPayName() != null) {
				dao.setConditionPayName("=", bean.getPayName());
				count++;
			}
			if(bean.getReimbursementCode() != null) {
				dao.setConditionReimbursementCode("=", bean.getReimbursementCode());
				count++;
			}
			if(bean.getProcessType() != null) {
				dao.setConditionProcessType("=", bean.getProcessType());
				count++;
			}
			if(bean.getProcessId() != null) {
				dao.setConditionProcessId("=", bean.getProcessId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePaymentSequence bean, PaymentSequence dao){
		int count = 0;
		if(bean.getPaymentSequenceId() != null) {
			dao.setConditionPaymentSequenceId("=", bean.getPaymentSequenceId());
			count++;
		}
		if(bean.getBudgetManagementId() != null) {
			dao.setConditionBudgetManagementId("=", bean.getBudgetManagementId());
			count++;
		}
		if(bean.getBudgetAttachmentId() != null) {
			dao.setConditionBudgetAttachmentId("=", bean.getBudgetAttachmentId());
			count++;
		}
		if(bean.getPayAmount() != null) {
			dao.setConditionPayAmount("=", bean.getPayAmount());
			count++;
		}
		if(bean.getPayDate() != null) {
			dao.setConditionPayDate(">=", bean.getPayDate());
			count++;
		}
		if(bean.getPayStatus() != null) {
			dao.setConditionPayStatus("=", bean.getPayStatus());
			count++;
		}
		if(bean.getPsRemark() != null) {
			if(bean.getPsRemark().indexOf("%") >= 0)
				dao.setConditionPsRemark("like", bean.getPsRemark());
			else
				dao.setConditionPsRemark("=", bean.getPsRemark());
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
		if(bean.getReceiveUnitManageId() != null) {
			dao.setConditionReceiveUnitManageId("=", bean.getReceiveUnitManageId());
			count++;
		}
		if(bean.getProcessBillListId() != null) {
			dao.setConditionProcessBillListId("=", bean.getProcessBillListId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getBindStatus() != null) {
			dao.setConditionBindStatus("=", bean.getBindStatus());
			count++;
		}
		if(bean.getPayType() != null) {
			dao.setConditionPayType("=", bean.getPayType());
			count++;
		}
		if(bean.getIsLock() != null) {
			dao.setConditionIsLock("=", bean.getIsLock());
			count++;
		}
		if(bean.getReimbursementAmount() != null) {
			dao.setConditionReimbursementAmount("=", bean.getReimbursementAmount());
			count++;
		}
		if(bean.getReverseAmount() != null) {
			dao.setConditionReverseAmount("=", bean.getReverseAmount());
			count++;
		}
		if(bean.getApplyPayDate() != null) {
			dao.setConditionApplyPayDate(">=", bean.getApplyPayDate());
			count++;
		}
		if(bean.getReturnAmount() != null) {
			dao.setConditionReturnAmount("=", bean.getReturnAmount());
			count++;
		}
		if(bean.getPayFor() != null) {
			dao.setConditionPayFor("=", bean.getPayFor());
			count++;
		}
		if(bean.getPayName() != null) {
			if(bean.getPayName().indexOf("%") >= 0)
				dao.setConditionPayName("like", bean.getPayName());
			else
				dao.setConditionPayName("=", bean.getPayName());
			count++;
		}
		if(bean.getReimbursementCode() != null) {
			if(bean.getReimbursementCode().indexOf("%") >= 0)
				dao.setConditionReimbursementCode("like", bean.getReimbursementCode());
			else
				dao.setConditionReimbursementCode("=", bean.getReimbursementCode());
			count++;
		}
		if(bean.getProcessType() != null) {
			dao.setConditionProcessType("=", bean.getProcessType());
			count++;
		}
		if(bean.getProcessId() != null) {
			dao.setConditionProcessId("=", bean.getProcessId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePaymentSequence bean = new BasePaymentSequence();
		bean.setDataFromJSON(json);
		PaymentSequence dao = new PaymentSequence();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePaymentSequence> rlist = new BaseCollection<>();
		BasePaymentSequence bean = new BasePaymentSequence();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PaymentSequence dao = new PaymentSequence();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePaymentSequence> result = dao.conditionalLoad(addtion);
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
		BasePaymentSequence bean = new BasePaymentSequence();
		bean.setDataFromJSON(json);
		PaymentSequence dao = new PaymentSequence();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePaymentSequence bean = new BasePaymentSequence();
		bean.setDataFromJSON(json);
		PaymentSequence dao = new PaymentSequence();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePaymentSequence bean = new BasePaymentSequence();
		bean.setDataFromJSON(json);
		PaymentSequence dao = new PaymentSequence();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePaymentSequence bean = new BasePaymentSequence();
		bean.setDataFromJSON(json);
		PaymentSequence dao = new PaymentSequence();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


