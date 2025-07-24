package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCmbcPayment;
import com.pomplatform.db.dao.CmbcPayment;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CmbcPaymentHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CmbcPaymentHandler.class);

	public static BaseCmbcPayment getCmbcPaymentById( 
		java.lang.Integer cmbc_payment_id
	) throws Exception
	{
		CmbcPayment dao = new CmbcPayment();
		dao.setCmbcPaymentId(cmbc_payment_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCmbcPaymentExists( com.pomplatform.db.bean.BaseCmbcPayment bean, String additional ) throws Exception {

		CmbcPayment dao = new CmbcPayment();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCmbcPayment( com.pomplatform.db.bean.BaseCmbcPayment bean, String additional ) throws Exception {

		CmbcPayment dao = new CmbcPayment();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCmbcPayment> queryCmbcPayment( com.pomplatform.db.bean.BaseCmbcPayment bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CmbcPayment dao = new CmbcPayment();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCmbcPayment> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCmbcPayment> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCmbcPayment addToCmbcPayment ( BaseCmbcPayment cmbcpayment )  throws Exception {
		return addToCmbcPayment ( cmbcpayment , false);
	}

	public static BaseCmbcPayment addToCmbcPayment ( BaseCmbcPayment cmbcpayment, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CmbcPayment dao = new CmbcPayment();
		dao.setDataFromBase(cmbcpayment);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCmbcPayment addUpdateCmbcPayment ( BaseCmbcPayment cmbcpayment ) throws Exception {
		return addUpdateCmbcPayment ( cmbcpayment , false);
	}

	public static BaseCmbcPayment addUpdateCmbcPayment ( BaseCmbcPayment cmbcpayment, boolean singleTransaction  ) throws Exception {
		if(cmbcpayment.getCmbcPaymentId() == null) return addToCmbcPayment(cmbcpayment);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CmbcPayment dao = new CmbcPayment();
		dao.setDataFromBase(cmbcpayment);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cmbcpayment); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCmbcPayment ( BaseCmbcPayment bean ) throws Exception {
		CmbcPayment dao = new CmbcPayment();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCmbcPayment updateCmbcPayment ( BaseCmbcPayment cmbcpayment ) throws Exception {
		CmbcPayment dao = new CmbcPayment();
		dao.setCmbcPaymentId( cmbcpayment.getCmbcPaymentId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cmbcpayment);
			result = dao.update();
		}
		return result == 1 ? cmbcpayment : null ;
	}

	public static BaseCmbcPayment updateCmbcPaymentDirect( BaseCmbcPayment cmbcpayment ) throws Exception {
		CmbcPayment dao = new CmbcPayment();
		int result = 0;
		dao.setDataFromBase(cmbcpayment);
		result = dao.update();
		return result == 1 ? cmbcpayment : null ;
	}

	public static int setDeleteConditions(BaseCmbcPayment bean, CmbcPayment dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCmbcPaymentId() != null) {
			dao.setConditionCmbcPaymentId("=", bean.getCmbcPaymentId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getType() != null) {
				dao.setConditionType("=", bean.getType());
				count++;
			}
			if(bean.getYurref() != null) {
				dao.setConditionYurref("=", bean.getYurref());
				count++;
			}
			if(bean.getTotalNum() != null) {
				dao.setConditionTotalNum("=", bean.getTotalNum());
				count++;
			}
			if(bean.getReimbursementPackageId() != null) {
				dao.setConditionReimbursementPackageId("=", bean.getReimbursementPackageId());
				count++;
			}
			if(bean.getPayStatus() != null) {
				dao.setConditionPayStatus("=", bean.getPayStatus());
				count++;
			}
			if(bean.getPayResult() != null) {
				dao.setConditionPayResult("=", bean.getPayResult());
				count++;
			}
			if(bean.getErrorMsg() != null) {
				dao.setConditionErrorMsg("=", bean.getErrorMsg());
				count++;
			}
			if(bean.getSuccessTotalNum() != null) {
				dao.setConditionSuccessTotalNum("=", bean.getSuccessTotalNum());
				count++;
			}
			if(bean.getReqnbr() != null) {
				dao.setConditionReqnbr("=", bean.getReqnbr());
				count++;
			}
			if(bean.getDbtacc() != null) {
				dao.setConditionDbtacc("=", bean.getDbtacc());
				count++;
			}
			if(bean.getDbtbbk() != null) {
				dao.setConditionDbtbbk("=", bean.getDbtbbk());
				count++;
			}
			if(bean.getTrstyp() != null) {
				dao.setConditionTrstyp("=", bean.getTrstyp());
				count++;
			}
			if(bean.getTrstypName() != null) {
				dao.setConditionTrstypName("=", bean.getTrstypName());
				count++;
			}
			if(bean.getNusage() != null) {
				dao.setConditionNusage("=", bean.getNusage());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCmbcPayment bean, CmbcPayment dao){
		int count = 0;
		if(bean.getCmbcPaymentId() != null) {
			dao.setConditionCmbcPaymentId("=", bean.getCmbcPaymentId());
			count++;
		}
		if(bean.getType() != null) {
			dao.setConditionType("=", bean.getType());
			count++;
		}
		if(bean.getYurref() != null) {
			if(bean.getYurref().indexOf("%") >= 0)
				dao.setConditionYurref("like", bean.getYurref());
			else
				dao.setConditionYurref("=", bean.getYurref());
			count++;
		}
		if(bean.getTotalAmount() != null) {
			dao.setConditionTotalAmount("=", bean.getTotalAmount());
			count++;
		}
		if(bean.getTotalNum() != null) {
			dao.setConditionTotalNum("=", bean.getTotalNum());
			count++;
		}
		if(bean.getReimbursementPackageId() != null) {
			dao.setConditionReimbursementPackageId("=", bean.getReimbursementPackageId());
			count++;
		}
		if(bean.getPayStatus() != null) {
			dao.setConditionPayStatus("=", bean.getPayStatus());
			count++;
		}
		if(bean.getPayResult() != null) {
			dao.setConditionPayResult("=", bean.getPayResult());
			count++;
		}
		if(bean.getErrorMsg() != null) {
			if(bean.getErrorMsg().indexOf("%") >= 0)
				dao.setConditionErrorMsg("like", bean.getErrorMsg());
			else
				dao.setConditionErrorMsg("=", bean.getErrorMsg());
			count++;
		}
		if(bean.getEpttim() != null) {
			dao.setConditionEpttim(">=", bean.getEpttim());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getSuccessTotalAmount() != null) {
			dao.setConditionSuccessTotalAmount("=", bean.getSuccessTotalAmount());
			count++;
		}
		if(bean.getSuccessTotalNum() != null) {
			dao.setConditionSuccessTotalNum("=", bean.getSuccessTotalNum());
			count++;
		}
		if(bean.getReqnbr() != null) {
			if(bean.getReqnbr().indexOf("%") >= 0)
				dao.setConditionReqnbr("like", bean.getReqnbr());
			else
				dao.setConditionReqnbr("=", bean.getReqnbr());
			count++;
		}
		if(bean.getDbtacc() != null) {
			if(bean.getDbtacc().indexOf("%") >= 0)
				dao.setConditionDbtacc("like", bean.getDbtacc());
			else
				dao.setConditionDbtacc("=", bean.getDbtacc());
			count++;
		}
		if(bean.getDbtbbk() != null) {
			if(bean.getDbtbbk().indexOf("%") >= 0)
				dao.setConditionDbtbbk("like", bean.getDbtbbk());
			else
				dao.setConditionDbtbbk("=", bean.getDbtbbk());
			count++;
		}
		if(bean.getTrstyp() != null) {
			if(bean.getTrstyp().indexOf("%") >= 0)
				dao.setConditionTrstyp("like", bean.getTrstyp());
			else
				dao.setConditionTrstyp("=", bean.getTrstyp());
			count++;
		}
		if(bean.getTrstypName() != null) {
			if(bean.getTrstypName().indexOf("%") >= 0)
				dao.setConditionTrstypName("like", bean.getTrstypName());
			else
				dao.setConditionTrstypName("=", bean.getTrstypName());
			count++;
		}
		if(bean.getNusage() != null) {
			if(bean.getNusage().indexOf("%") >= 0)
				dao.setConditionNusage("like", bean.getNusage());
			else
				dao.setConditionNusage("=", bean.getNusage());
			count++;
		}
		if(bean.getOprdat() != null) {
			dao.setConditionOprdat(">=", bean.getOprdat());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCmbcPayment bean = new BaseCmbcPayment();
		bean.setDataFromJSON(json);
		CmbcPayment dao = new CmbcPayment();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCmbcPayment> rlist = new BaseCollection<>();
		BaseCmbcPayment bean = new BaseCmbcPayment();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CmbcPayment dao = new CmbcPayment();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCmbcPayment> result = dao.conditionalLoad(addtion);
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
		BaseCmbcPayment bean = new BaseCmbcPayment();
		bean.setDataFromJSON(json);
		CmbcPayment dao = new CmbcPayment();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCmbcPayment bean = new BaseCmbcPayment();
		bean.setDataFromJSON(json);
		CmbcPayment dao = new CmbcPayment();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCmbcPayment bean = new BaseCmbcPayment();
		bean.setDataFromJSON(json);
		CmbcPayment dao = new CmbcPayment();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCmbcPayment bean = new BaseCmbcPayment();
		bean.setDataFromJSON(json);
		CmbcPayment dao = new CmbcPayment();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


