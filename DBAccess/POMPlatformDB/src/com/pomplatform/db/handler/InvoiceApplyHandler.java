package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseInvoiceApply;
import com.pomplatform.db.dao.InvoiceApply;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class InvoiceApplyHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(InvoiceApplyHandler.class);

	public static BaseInvoiceApply getInvoiceApplyById( 
		java.lang.Integer invoice_apply_id
	) throws Exception
	{
		InvoiceApply dao = new InvoiceApply();
		dao.setInvoiceApplyId(invoice_apply_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isInvoiceApplyExists( com.pomplatform.db.bean.BaseInvoiceApply bean, String additional ) throws Exception {

		InvoiceApply dao = new InvoiceApply();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countInvoiceApply( com.pomplatform.db.bean.BaseInvoiceApply bean, String additional ) throws Exception {

		InvoiceApply dao = new InvoiceApply();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseInvoiceApply> queryInvoiceApply( com.pomplatform.db.bean.BaseInvoiceApply bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		InvoiceApply dao = new InvoiceApply();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseInvoiceApply> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseInvoiceApply> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseInvoiceApply addToInvoiceApply ( BaseInvoiceApply invoiceapply )  throws Exception {
		return addToInvoiceApply ( invoiceapply , false);
	}

	public static BaseInvoiceApply addToInvoiceApply ( BaseInvoiceApply invoiceapply, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		InvoiceApply dao = new InvoiceApply();
		dao.setDataFromBase(invoiceapply);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseInvoiceApply addUpdateInvoiceApply ( BaseInvoiceApply invoiceapply ) throws Exception {
		return addUpdateInvoiceApply ( invoiceapply , false);
	}

	public static BaseInvoiceApply addUpdateInvoiceApply ( BaseInvoiceApply invoiceapply, boolean singleTransaction  ) throws Exception {
		if(invoiceapply.getInvoiceApplyId() == null) return addToInvoiceApply(invoiceapply);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		InvoiceApply dao = new InvoiceApply();
		dao.setDataFromBase(invoiceapply);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(invoiceapply); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteInvoiceApply ( BaseInvoiceApply bean ) throws Exception {
		InvoiceApply dao = new InvoiceApply();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseInvoiceApply updateInvoiceApply ( BaseInvoiceApply invoiceapply ) throws Exception {
		InvoiceApply dao = new InvoiceApply();
		dao.setInvoiceApplyId( invoiceapply.getInvoiceApplyId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(invoiceapply);
			result = dao.update();
		}
		return result == 1 ? invoiceapply : null ;
	}

	public static BaseInvoiceApply updateInvoiceApplyDirect( BaseInvoiceApply invoiceapply ) throws Exception {
		InvoiceApply dao = new InvoiceApply();
		int result = 0;
		dao.setDataFromBase(invoiceapply);
		result = dao.update();
		return result == 1 ? invoiceapply : null ;
	}

	public static int setDeleteConditions(BaseInvoiceApply bean, InvoiceApply dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getInvoiceApplyId() != null) {
			dao.setConditionInvoiceApplyId("=", bean.getInvoiceApplyId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getApplicantId() != null) {
				dao.setConditionApplicantId("=", bean.getApplicantId());
				count++;
			}
			if(bean.getApplicantDeparmentId() != null) {
				dao.setConditionApplicantDeparmentId("=", bean.getApplicantDeparmentId());
				count++;
			}
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getInvoiceType() != null) {
				dao.setConditionInvoiceType("=", bean.getInvoiceType());
				count++;
			}
			if(bean.getCompanyName() != null) {
				dao.setConditionCompanyName("=", bean.getCompanyName());
				count++;
			}
			if(bean.getDutyParagraph() != null) {
				dao.setConditionDutyParagraph("=", bean.getDutyParagraph());
				count++;
			}
			if(bean.getCustomerName() != null) {
				dao.setConditionCustomerName("=", bean.getCustomerName());
				count++;
			}
			if(bean.getCustomerPhone() != null) {
				dao.setConditionCustomerPhone("=", bean.getCustomerPhone());
				count++;
			}
			if(bean.getRegisteredAddress() != null) {
				dao.setConditionRegisteredAddress("=", bean.getRegisteredAddress());
				count++;
			}
			if(bean.getBankName() != null) {
				dao.setConditionBankName("=", bean.getBankName());
				count++;
			}
			if(bean.getBankAccount() != null) {
				dao.setConditionBankAccount("=", bean.getBankAccount());
				count++;
			}
			if(bean.getApplyRemark() != null) {
				dao.setConditionApplyRemark("=", bean.getApplyRemark());
				count++;
			}
			if(bean.getOperatorId() != null) {
				dao.setConditionOperatorId("=", bean.getOperatorId());
				count++;
			}
			if(bean.getOperatorRemark() != null) {
				dao.setConditionOperatorRemark("=", bean.getOperatorRemark());
				count++;
			}
			if(bean.getInvoiceApplyStatus() != null) {
				dao.setConditionInvoiceApplyStatus("=", bean.getInvoiceApplyStatus());
				count++;
			}
			if(bean.getQq() != null) {
				dao.setConditionQq("=", bean.getQq());
				count++;
			}
			if(bean.getEmail() != null) {
				dao.setConditionEmail("=", bean.getEmail());
				count++;
			}
			if(bean.getLandline() != null) {
				dao.setConditionLandline("=", bean.getLandline());
				count++;
			}
			if(bean.getFax() != null) {
				dao.setConditionFax("=", bean.getFax());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseInvoiceApply bean, InvoiceApply dao){
		int count = 0;
		if(bean.getInvoiceApplyId() != null) {
			dao.setConditionInvoiceApplyId("=", bean.getInvoiceApplyId());
			count++;
		}
		if(bean.getApplicantId() != null) {
			dao.setConditionApplicantId("=", bean.getApplicantId());
			count++;
		}
		if(bean.getApplicantDeparmentId() != null) {
			dao.setConditionApplicantDeparmentId("=", bean.getApplicantDeparmentId());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getInvoiceType() != null) {
			dao.setConditionInvoiceType("=", bean.getInvoiceType());
			count++;
		}
		if(bean.getCompanyName() != null) {
			if(bean.getCompanyName().indexOf("%") >= 0)
				dao.setConditionCompanyName("like", bean.getCompanyName());
			else
				dao.setConditionCompanyName("=", bean.getCompanyName());
			count++;
		}
		if(bean.getDutyParagraph() != null) {
			if(bean.getDutyParagraph().indexOf("%") >= 0)
				dao.setConditionDutyParagraph("like", bean.getDutyParagraph());
			else
				dao.setConditionDutyParagraph("=", bean.getDutyParagraph());
			count++;
		}
		if(bean.getCustomerName() != null) {
			if(bean.getCustomerName().indexOf("%") >= 0)
				dao.setConditionCustomerName("like", bean.getCustomerName());
			else
				dao.setConditionCustomerName("=", bean.getCustomerName());
			count++;
		}
		if(bean.getCustomerPhone() != null) {
			if(bean.getCustomerPhone().indexOf("%") >= 0)
				dao.setConditionCustomerPhone("like", bean.getCustomerPhone());
			else
				dao.setConditionCustomerPhone("=", bean.getCustomerPhone());
			count++;
		}
		if(bean.getRegisteredAddress() != null) {
			if(bean.getRegisteredAddress().indexOf("%") >= 0)
				dao.setConditionRegisteredAddress("like", bean.getRegisteredAddress());
			else
				dao.setConditionRegisteredAddress("=", bean.getRegisteredAddress());
			count++;
		}
		if(bean.getBankName() != null) {
			if(bean.getBankName().indexOf("%") >= 0)
				dao.setConditionBankName("like", bean.getBankName());
			else
				dao.setConditionBankName("=", bean.getBankName());
			count++;
		}
		if(bean.getBankAccount() != null) {
			if(bean.getBankAccount().indexOf("%") >= 0)
				dao.setConditionBankAccount("like", bean.getBankAccount());
			else
				dao.setConditionBankAccount("=", bean.getBankAccount());
			count++;
		}
		if(bean.getApplyTime() != null) {
			dao.setConditionApplyTime(">=", bean.getApplyTime());
			count++;
		}
		if(bean.getApplySumMoney() != null) {
			dao.setConditionApplySumMoney("=", bean.getApplySumMoney());
			count++;
		}
		if(bean.getApplyRemark() != null) {
			if(bean.getApplyRemark().indexOf("%") >= 0)
				dao.setConditionApplyRemark("like", bean.getApplyRemark());
			else
				dao.setConditionApplyRemark("=", bean.getApplyRemark());
			count++;
		}
		if(bean.getOperatorId() != null) {
			dao.setConditionOperatorId("=", bean.getOperatorId());
			count++;
		}
		if(bean.getOperatorTime() != null) {
			dao.setConditionOperatorTime(">=", bean.getOperatorTime());
			count++;
		}
		if(bean.getOperatorRemark() != null) {
			if(bean.getOperatorRemark().indexOf("%") >= 0)
				dao.setConditionOperatorRemark("like", bean.getOperatorRemark());
			else
				dao.setConditionOperatorRemark("=", bean.getOperatorRemark());
			count++;
		}
		if(bean.getInvoiceApplyStatus() != null) {
			dao.setConditionInvoiceApplyStatus("=", bean.getInvoiceApplyStatus());
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
		if(bean.getQq() != null) {
			if(bean.getQq().indexOf("%") >= 0)
				dao.setConditionQq("like", bean.getQq());
			else
				dao.setConditionQq("=", bean.getQq());
			count++;
		}
		if(bean.getEmail() != null) {
			if(bean.getEmail().indexOf("%") >= 0)
				dao.setConditionEmail("like", bean.getEmail());
			else
				dao.setConditionEmail("=", bean.getEmail());
			count++;
		}
		if(bean.getLandline() != null) {
			if(bean.getLandline().indexOf("%") >= 0)
				dao.setConditionLandline("like", bean.getLandline());
			else
				dao.setConditionLandline("=", bean.getLandline());
			count++;
		}
		if(bean.getFax() != null) {
			if(bean.getFax().indexOf("%") >= 0)
				dao.setConditionFax("like", bean.getFax());
			else
				dao.setConditionFax("=", bean.getFax());
			count++;
		}
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseInvoiceApply bean = new BaseInvoiceApply();
		bean.setDataFromJSON(json);
		InvoiceApply dao = new InvoiceApply();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseInvoiceApply> rlist = new BaseCollection<>();
		BaseInvoiceApply bean = new BaseInvoiceApply();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		InvoiceApply dao = new InvoiceApply();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseInvoiceApply> result = dao.conditionalLoad(addtion);
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
		BaseInvoiceApply bean = new BaseInvoiceApply();
		bean.setDataFromJSON(json);
		InvoiceApply dao = new InvoiceApply();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseInvoiceApply bean = new BaseInvoiceApply();
		bean.setDataFromJSON(json);
		InvoiceApply dao = new InvoiceApply();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseInvoiceApply bean = new BaseInvoiceApply();
		bean.setDataFromJSON(json);
		InvoiceApply dao = new InvoiceApply();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseInvoiceApply bean = new BaseInvoiceApply();
		bean.setDataFromJSON(json);
		InvoiceApply dao = new InvoiceApply();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


