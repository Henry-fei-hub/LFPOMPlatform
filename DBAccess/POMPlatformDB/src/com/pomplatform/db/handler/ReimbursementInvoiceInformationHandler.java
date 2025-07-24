package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseReimbursementInvoiceInformation;
import com.pomplatform.db.dao.ReimbursementInvoiceInformation;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ReimbursementInvoiceInformationHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ReimbursementInvoiceInformationHandler.class);

	public static BaseReimbursementInvoiceInformation getReimbursementInvoiceInformationById( 
		java.lang.Integer reimbursement_invoice_information_id
	) throws Exception
	{
		ReimbursementInvoiceInformation dao = new ReimbursementInvoiceInformation();
		dao.setReimbursementInvoiceInformationId(reimbursement_invoice_information_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isReimbursementInvoiceInformationExists( com.pomplatform.db.bean.BaseReimbursementInvoiceInformation bean, String additional ) throws Exception {

		ReimbursementInvoiceInformation dao = new ReimbursementInvoiceInformation();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countReimbursementInvoiceInformation( com.pomplatform.db.bean.BaseReimbursementInvoiceInformation bean, String additional ) throws Exception {

		ReimbursementInvoiceInformation dao = new ReimbursementInvoiceInformation();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseReimbursementInvoiceInformation> queryReimbursementInvoiceInformation( com.pomplatform.db.bean.BaseReimbursementInvoiceInformation bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ReimbursementInvoiceInformation dao = new ReimbursementInvoiceInformation();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseReimbursementInvoiceInformation> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseReimbursementInvoiceInformation> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseReimbursementInvoiceInformation addToReimbursementInvoiceInformation ( BaseReimbursementInvoiceInformation reimbursementinvoiceinformation )  throws Exception {
		return addToReimbursementInvoiceInformation ( reimbursementinvoiceinformation , false);
	}

	public static BaseReimbursementInvoiceInformation addToReimbursementInvoiceInformation ( BaseReimbursementInvoiceInformation reimbursementinvoiceinformation, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ReimbursementInvoiceInformation dao = new ReimbursementInvoiceInformation();
		dao.setDataFromBase(reimbursementinvoiceinformation);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseReimbursementInvoiceInformation addUpdateReimbursementInvoiceInformation ( BaseReimbursementInvoiceInformation reimbursementinvoiceinformation ) throws Exception {
		return addUpdateReimbursementInvoiceInformation ( reimbursementinvoiceinformation , false);
	}

	public static BaseReimbursementInvoiceInformation addUpdateReimbursementInvoiceInformation ( BaseReimbursementInvoiceInformation reimbursementinvoiceinformation, boolean singleTransaction  ) throws Exception {
		if(reimbursementinvoiceinformation.getReimbursementInvoiceInformationId() == null) return addToReimbursementInvoiceInformation(reimbursementinvoiceinformation);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ReimbursementInvoiceInformation dao = new ReimbursementInvoiceInformation();
		dao.setDataFromBase(reimbursementinvoiceinformation);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(reimbursementinvoiceinformation); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteReimbursementInvoiceInformation ( BaseReimbursementInvoiceInformation bean ) throws Exception {
		ReimbursementInvoiceInformation dao = new ReimbursementInvoiceInformation();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseReimbursementInvoiceInformation updateReimbursementInvoiceInformation ( BaseReimbursementInvoiceInformation reimbursementinvoiceinformation ) throws Exception {
		ReimbursementInvoiceInformation dao = new ReimbursementInvoiceInformation();
		dao.setReimbursementInvoiceInformationId( reimbursementinvoiceinformation.getReimbursementInvoiceInformationId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(reimbursementinvoiceinformation);
			result = dao.update();
		}
		return result == 1 ? reimbursementinvoiceinformation : null ;
	}

	public static BaseReimbursementInvoiceInformation updateReimbursementInvoiceInformationDirect( BaseReimbursementInvoiceInformation reimbursementinvoiceinformation ) throws Exception {
		ReimbursementInvoiceInformation dao = new ReimbursementInvoiceInformation();
		int result = 0;
		dao.setDataFromBase(reimbursementinvoiceinformation);
		result = dao.update();
		return result == 1 ? reimbursementinvoiceinformation : null ;
	}

	public static int setDeleteConditions(BaseReimbursementInvoiceInformation bean, ReimbursementInvoiceInformation dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getReimbursementInvoiceInformationId() != null) {
			dao.setConditionReimbursementInvoiceInformationId("=", bean.getReimbursementInvoiceInformationId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProcessType() != null) {
				dao.setConditionProcessType("=", bean.getProcessType());
				count++;
			}
			if(bean.getBusinessId() != null) {
				dao.setConditionBusinessId("=", bean.getBusinessId());
				count++;
			}
			if(bean.getDetailId() != null) {
				dao.setConditionDetailId("=", bean.getDetailId());
				count++;
			}
			if(bean.getInvoiceType() != null) {
				dao.setConditionInvoiceType("=", bean.getInvoiceType());
				count++;
			}
			if(bean.getInvoiceCode() != null) {
				dao.setConditionInvoiceCode("=", bean.getInvoiceCode());
				count++;
			}
			if(bean.getInvoiceNumber() != null) {
				dao.setConditionInvoiceNumber("=", bean.getInvoiceNumber());
				count++;
			}
			if(bean.getTaxRate() != null) {
				dao.setConditionTaxRate("=", bean.getTaxRate());
				count++;
			}
			if(bean.getSubtractRemark() != null) {
				dao.setConditionSubtractRemark("=", bean.getSubtractRemark());
				count++;
			}
			if(bean.getCreator() != null) {
				dao.setConditionCreator("=", bean.getCreator());
				count++;
			}
			if(bean.getInvoiceQuantity() != null) {
				dao.setConditionInvoiceQuantity("=", bean.getInvoiceQuantity());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseReimbursementInvoiceInformation bean, ReimbursementInvoiceInformation dao){
		int count = 0;
		if(bean.getReimbursementInvoiceInformationId() != null) {
			dao.setConditionReimbursementInvoiceInformationId("=", bean.getReimbursementInvoiceInformationId());
			count++;
		}
		if(bean.getProcessType() != null) {
			dao.setConditionProcessType("=", bean.getProcessType());
			count++;
		}
		if(bean.getBusinessId() != null) {
			dao.setConditionBusinessId("=", bean.getBusinessId());
			count++;
		}
		if(bean.getDetailId() != null) {
			dao.setConditionDetailId("=", bean.getDetailId());
			count++;
		}
		if(bean.getInvoiceType() != null) {
			dao.setConditionInvoiceType("=", bean.getInvoiceType());
			count++;
		}
		if(bean.getInvoiceCode() != null) {
			if(bean.getInvoiceCode().indexOf("%") >= 0)
				dao.setConditionInvoiceCode("like", bean.getInvoiceCode());
			else
				dao.setConditionInvoiceCode("=", bean.getInvoiceCode());
			count++;
		}
		if(bean.getInvoiceNumber() != null) {
			if(bean.getInvoiceNumber().indexOf("%") >= 0)
				dao.setConditionInvoiceNumber("like", bean.getInvoiceNumber());
			else
				dao.setConditionInvoiceNumber("=", bean.getInvoiceNumber());
			count++;
		}
		if(bean.getTotalAmount() != null) {
			dao.setConditionTotalAmount("=", bean.getTotalAmount());
			count++;
		}
		if(bean.getTaxRate() != null) {
			dao.setConditionTaxRate("=", bean.getTaxRate());
			count++;
		}
		if(bean.getTaxAmount() != null) {
			dao.setConditionTaxAmount("=", bean.getTaxAmount());
			count++;
		}
		if(bean.getSubtractAmount() != null) {
			dao.setConditionSubtractAmount("=", bean.getSubtractAmount());
			count++;
		}
		if(bean.getSubtractRemark() != null) {
			if(bean.getSubtractRemark().indexOf("%") >= 0)
				dao.setConditionSubtractRemark("like", bean.getSubtractRemark());
			else
				dao.setConditionSubtractRemark("=", bean.getSubtractRemark());
			count++;
		}
		if(bean.getCreator() != null) {
			dao.setConditionCreator("=", bean.getCreator());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getInvoiceQuantity() != null) {
			dao.setConditionInvoiceQuantity("=", bean.getInvoiceQuantity());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseReimbursementInvoiceInformation bean = new BaseReimbursementInvoiceInformation();
		bean.setDataFromJSON(json);
		ReimbursementInvoiceInformation dao = new ReimbursementInvoiceInformation();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseReimbursementInvoiceInformation> rlist = new BaseCollection<>();
		BaseReimbursementInvoiceInformation bean = new BaseReimbursementInvoiceInformation();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ReimbursementInvoiceInformation dao = new ReimbursementInvoiceInformation();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseReimbursementInvoiceInformation> result = dao.conditionalLoad(addtion);
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
		BaseReimbursementInvoiceInformation bean = new BaseReimbursementInvoiceInformation();
		bean.setDataFromJSON(json);
		ReimbursementInvoiceInformation dao = new ReimbursementInvoiceInformation();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseReimbursementInvoiceInformation bean = new BaseReimbursementInvoiceInformation();
		bean.setDataFromJSON(json);
		ReimbursementInvoiceInformation dao = new ReimbursementInvoiceInformation();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseReimbursementInvoiceInformation bean = new BaseReimbursementInvoiceInformation();
		bean.setDataFromJSON(json);
		ReimbursementInvoiceInformation dao = new ReimbursementInvoiceInformation();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseReimbursementInvoiceInformation bean = new BaseReimbursementInvoiceInformation();
		bean.setDataFromJSON(json);
		ReimbursementInvoiceInformation dao = new ReimbursementInvoiceInformation();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


