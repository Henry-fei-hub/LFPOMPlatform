package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseInvoiceExpres;
import com.pomplatform.db.dao.InvoiceExpres;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class InvoiceExpresHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(InvoiceExpresHandler.class);

	public static BaseInvoiceExpres getInvoiceExpresById( 
		java.lang.Integer invoice_express_id
	) throws Exception
	{
		InvoiceExpres dao = new InvoiceExpres();
		dao.setInvoiceExpressId(invoice_express_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isInvoiceExpresExists( com.pomplatform.db.bean.BaseInvoiceExpres bean, String additional ) throws Exception {

		InvoiceExpres dao = new InvoiceExpres();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countInvoiceExpres( com.pomplatform.db.bean.BaseInvoiceExpres bean, String additional ) throws Exception {

		InvoiceExpres dao = new InvoiceExpres();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseInvoiceExpres> queryInvoiceExpres( com.pomplatform.db.bean.BaseInvoiceExpres bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		InvoiceExpres dao = new InvoiceExpres();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseInvoiceExpres> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseInvoiceExpres> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseInvoiceExpres addToInvoiceExpres ( BaseInvoiceExpres invoiceexpres )  throws Exception {
		return addToInvoiceExpres ( invoiceexpres , false);
	}

	public static BaseInvoiceExpres addToInvoiceExpres ( BaseInvoiceExpres invoiceexpres, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		InvoiceExpres dao = new InvoiceExpres();
		dao.setDataFromBase(invoiceexpres);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseInvoiceExpres addUpdateInvoiceExpres ( BaseInvoiceExpres invoiceexpres ) throws Exception {
		return addUpdateInvoiceExpres ( invoiceexpres , false);
	}

	public static BaseInvoiceExpres addUpdateInvoiceExpres ( BaseInvoiceExpres invoiceexpres, boolean singleTransaction  ) throws Exception {
		if(invoiceexpres.getInvoiceExpressId() == null) return addToInvoiceExpres(invoiceexpres);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		InvoiceExpres dao = new InvoiceExpres();
		dao.setDataFromBase(invoiceexpres);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(invoiceexpres); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteInvoiceExpres ( BaseInvoiceExpres bean ) throws Exception {
		InvoiceExpres dao = new InvoiceExpres();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseInvoiceExpres updateInvoiceExpres ( BaseInvoiceExpres invoiceexpres ) throws Exception {
		InvoiceExpres dao = new InvoiceExpres();
		dao.setInvoiceExpressId( invoiceexpres.getInvoiceExpressId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(invoiceexpres);
			result = dao.update();
		}
		return result == 1 ? invoiceexpres : null ;
	}

	public static BaseInvoiceExpres updateInvoiceExpresDirect( BaseInvoiceExpres invoiceexpres ) throws Exception {
		InvoiceExpres dao = new InvoiceExpres();
		int result = 0;
		dao.setDataFromBase(invoiceexpres);
		result = dao.update();
		return result == 1 ? invoiceexpres : null ;
	}

	public static int setDeleteConditions(BaseInvoiceExpres bean, InvoiceExpres dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getInvoiceExpressId() != null) {
			dao.setConditionInvoiceExpressId("=", bean.getInvoiceExpressId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getInfoCode() != null) {
				dao.setConditionInfoCode("=", bean.getInfoCode());
				count++;
			}
			if(bean.getProjectCode() != null) {
				dao.setConditionProjectCode("=", bean.getProjectCode());
				count++;
			}
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getContractCode() != null) {
				dao.setConditionContractCode("=", bean.getContractCode());
				count++;
			}
			if(bean.getContactId() != null) {
				dao.setConditionContactId("=", bean.getContactId());
				count++;
			}
			if(bean.getTel() != null) {
				dao.setConditionTel("=", bean.getTel());
				count++;
			}
			if(bean.getMailingAddress() != null) {
				dao.setConditionMailingAddress("=", bean.getMailingAddress());
				count++;
			}
			if(bean.getCourierType() != null) {
				dao.setConditionCourierType("=", bean.getCourierType());
				count++;
			}
			if(bean.getCourierNumber() != null) {
				dao.setConditionCourierNumber("=", bean.getCourierNumber());
				count++;
			}
			if(bean.getSignStatus() != null) {
				dao.setConditionSignStatus("=", bean.getSignStatus());
				count++;
			}
			if(bean.getSignName() != null) {
				dao.setConditionSignName("=", bean.getSignName());
				count++;
			}
			if(bean.getSignReceipt() != null) {
				dao.setConditionSignReceipt("=", bean.getSignReceipt());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getType() != null) {
				dao.setConditionType("=", bean.getType());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseInvoiceExpres bean, InvoiceExpres dao){
		int count = 0;
		if(bean.getInvoiceExpressId() != null) {
			dao.setConditionInvoiceExpressId("=", bean.getInvoiceExpressId());
			count++;
		}
		if(bean.getInfoCode() != null) {
			if(bean.getInfoCode().indexOf("%") >= 0)
				dao.setConditionInfoCode("like", bean.getInfoCode());
			else
				dao.setConditionInfoCode("=", bean.getInfoCode());
			count++;
		}
		if(bean.getProjectCode() != null) {
			if(bean.getProjectCode().indexOf("%") >= 0)
				dao.setConditionProjectCode("like", bean.getProjectCode());
			else
				dao.setConditionProjectCode("=", bean.getProjectCode());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getContractCode() != null) {
			if(bean.getContractCode().indexOf("%") >= 0)
				dao.setConditionContractCode("like", bean.getContractCode());
			else
				dao.setConditionContractCode("=", bean.getContractCode());
			count++;
		}
		if(bean.getContactId() != null) {
			dao.setConditionContactId("=", bean.getContactId());
			count++;
		}
		if(bean.getTel() != null) {
			if(bean.getTel().indexOf("%") >= 0)
				dao.setConditionTel("like", bean.getTel());
			else
				dao.setConditionTel("=", bean.getTel());
			count++;
		}
		if(bean.getMailingAddress() != null) {
			if(bean.getMailingAddress().indexOf("%") >= 0)
				dao.setConditionMailingAddress("like", bean.getMailingAddress());
			else
				dao.setConditionMailingAddress("=", bean.getMailingAddress());
			count++;
		}
		if(bean.getCourierType() != null) {
			dao.setConditionCourierType("=", bean.getCourierType());
			count++;
		}
		if(bean.getCourierNumber() != null) {
			if(bean.getCourierNumber().indexOf("%") >= 0)
				dao.setConditionCourierNumber("like", bean.getCourierNumber());
			else
				dao.setConditionCourierNumber("=", bean.getCourierNumber());
			count++;
		}
		if(bean.getCourierDate() != null) {
			dao.setConditionCourierDate(">=", bean.getCourierDate());
			count++;
		}
		if(bean.getSignStatus() != null) {
			dao.setConditionSignStatus("=", bean.getSignStatus());
			count++;
		}
		if(bean.getSignName() != null) {
			if(bean.getSignName().indexOf("%") >= 0)
				dao.setConditionSignName("like", bean.getSignName());
			else
				dao.setConditionSignName("=", bean.getSignName());
			count++;
		}
		if(bean.getSignReceipt() != null) {
			if(bean.getSignReceipt().indexOf("%") >= 0)
				dao.setConditionSignReceipt("like", bean.getSignReceipt());
			else
				dao.setConditionSignReceipt("=", bean.getSignReceipt());
			count++;
		}
		if(bean.getSignDate() != null) {
			dao.setConditionSignDate(">=", bean.getSignDate());
			count++;
		}
		if(bean.getOperator() != null) {
			dao.setConditionOperator("=", bean.getOperator());
			count++;
		}
		if(bean.getCreateDate() != null) {
			dao.setConditionCreateDate(">=", bean.getCreateDate());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getType() != null) {
			dao.setConditionType("=", bean.getType());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseInvoiceExpres bean = new BaseInvoiceExpres();
		bean.setDataFromJSON(json);
		InvoiceExpres dao = new InvoiceExpres();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseInvoiceExpres> rlist = new BaseCollection<>();
		BaseInvoiceExpres bean = new BaseInvoiceExpres();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		InvoiceExpres dao = new InvoiceExpres();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseInvoiceExpres> result = dao.conditionalLoad(addtion);
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
		BaseInvoiceExpres bean = new BaseInvoiceExpres();
		bean.setDataFromJSON(json);
		InvoiceExpres dao = new InvoiceExpres();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseInvoiceExpres bean = new BaseInvoiceExpres();
		bean.setDataFromJSON(json);
		InvoiceExpres dao = new InvoiceExpres();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseInvoiceExpres bean = new BaseInvoiceExpres();
		bean.setDataFromJSON(json);
		InvoiceExpres dao = new InvoiceExpres();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseInvoiceExpres bean = new BaseInvoiceExpres();
		bean.setDataFromJSON(json);
		InvoiceExpres dao = new InvoiceExpres();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


