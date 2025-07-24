package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePaymentTemplateDetail;
import com.pomplatform.db.dao.PaymentTemplateDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PaymentTemplateDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PaymentTemplateDetailHandler.class);

	public static BasePaymentTemplateDetail getPaymentTemplateDetailById( 
		java.lang.Integer payment_template_detail_id
	) throws Exception
	{
		PaymentTemplateDetail dao = new PaymentTemplateDetail();
		dao.setPaymentTemplateDetailId(payment_template_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPaymentTemplateDetailExists( com.pomplatform.db.bean.BasePaymentTemplateDetail bean, String additional ) throws Exception {

		PaymentTemplateDetail dao = new PaymentTemplateDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPaymentTemplateDetail( com.pomplatform.db.bean.BasePaymentTemplateDetail bean, String additional ) throws Exception {

		PaymentTemplateDetail dao = new PaymentTemplateDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePaymentTemplateDetail> queryPaymentTemplateDetail( com.pomplatform.db.bean.BasePaymentTemplateDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PaymentTemplateDetail dao = new PaymentTemplateDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePaymentTemplateDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePaymentTemplateDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePaymentTemplateDetail addToPaymentTemplateDetail ( BasePaymentTemplateDetail paymenttemplatedetail )  throws Exception {
		return addToPaymentTemplateDetail ( paymenttemplatedetail , false);
	}

	public static BasePaymentTemplateDetail addToPaymentTemplateDetail ( BasePaymentTemplateDetail paymenttemplatedetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PaymentTemplateDetail dao = new PaymentTemplateDetail();
		dao.setDataFromBase(paymenttemplatedetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePaymentTemplateDetail addUpdatePaymentTemplateDetail ( BasePaymentTemplateDetail paymenttemplatedetail ) throws Exception {
		return addUpdatePaymentTemplateDetail ( paymenttemplatedetail , false);
	}

	public static BasePaymentTemplateDetail addUpdatePaymentTemplateDetail ( BasePaymentTemplateDetail paymenttemplatedetail, boolean singleTransaction  ) throws Exception {
		if(paymenttemplatedetail.getPaymentTemplateDetailId() == null) return addToPaymentTemplateDetail(paymenttemplatedetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PaymentTemplateDetail dao = new PaymentTemplateDetail();
		dao.setDataFromBase(paymenttemplatedetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(paymenttemplatedetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePaymentTemplateDetail ( BasePaymentTemplateDetail bean ) throws Exception {
		PaymentTemplateDetail dao = new PaymentTemplateDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePaymentTemplateDetail updatePaymentTemplateDetail ( BasePaymentTemplateDetail paymenttemplatedetail ) throws Exception {
		PaymentTemplateDetail dao = new PaymentTemplateDetail();
		dao.setPaymentTemplateDetailId( paymenttemplatedetail.getPaymentTemplateDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(paymenttemplatedetail);
			result = dao.update();
		}
		return result == 1 ? paymenttemplatedetail : null ;
	}

	public static BasePaymentTemplateDetail updatePaymentTemplateDetailDirect( BasePaymentTemplateDetail paymenttemplatedetail ) throws Exception {
		PaymentTemplateDetail dao = new PaymentTemplateDetail();
		int result = 0;
		dao.setDataFromBase(paymenttemplatedetail);
		result = dao.update();
		return result == 1 ? paymenttemplatedetail : null ;
	}

	public static int setDeleteConditions(BasePaymentTemplateDetail bean, PaymentTemplateDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPaymentTemplateDetailId() != null) {
			dao.setConditionPaymentTemplateDetailId("=", bean.getPaymentTemplateDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPaymentTemplateId() != null) {
				dao.setConditionPaymentTemplateId("=", bean.getPaymentTemplateId());
				count++;
			}
			if(bean.getPaymentName() != null) {
				dao.setConditionPaymentName("=", bean.getPaymentName());
				count++;
			}
			if(bean.getDelayDay() != null) {
				dao.setConditionDelayDay("=", bean.getDelayDay());
				count++;
			}
			if(bean.getOrderNum() != null) {
				dao.setConditionOrderNum("=", bean.getOrderNum());
				count++;
			}
			if(bean.getPaymentCondition() != null) {
				dao.setConditionPaymentCondition("=", bean.getPaymentCondition());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePaymentTemplateDetail bean, PaymentTemplateDetail dao){
		int count = 0;
		if(bean.getPaymentTemplateDetailId() != null) {
			dao.setConditionPaymentTemplateDetailId("=", bean.getPaymentTemplateDetailId());
			count++;
		}
		if(bean.getPaymentTemplateId() != null) {
			dao.setConditionPaymentTemplateId("=", bean.getPaymentTemplateId());
			count++;
		}
		if(bean.getPaymentName() != null) {
			if(bean.getPaymentName().indexOf("%") >= 0)
				dao.setConditionPaymentName("like", bean.getPaymentName());
			else
				dao.setConditionPaymentName("=", bean.getPaymentName());
			count++;
		}
		if(bean.getDelayDay() != null) {
			dao.setConditionDelayDay("=", bean.getDelayDay());
			count++;
		}
		if(bean.getOrderNum() != null) {
			dao.setConditionOrderNum("=", bean.getOrderNum());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getPaymentCondition() != null) {
			if(bean.getPaymentCondition().indexOf("%") >= 0)
				dao.setConditionPaymentCondition("like", bean.getPaymentCondition());
			else
				dao.setConditionPaymentCondition("=", bean.getPaymentCondition());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getPaymentRatio() != null) {
			dao.setConditionPaymentRatio("=", bean.getPaymentRatio());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePaymentTemplateDetail bean = new BasePaymentTemplateDetail();
		bean.setDataFromJSON(json);
		PaymentTemplateDetail dao = new PaymentTemplateDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePaymentTemplateDetail> rlist = new BaseCollection<>();
		BasePaymentTemplateDetail bean = new BasePaymentTemplateDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PaymentTemplateDetail dao = new PaymentTemplateDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePaymentTemplateDetail> result = dao.conditionalLoad(addtion);
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
		BasePaymentTemplateDetail bean = new BasePaymentTemplateDetail();
		bean.setDataFromJSON(json);
		PaymentTemplateDetail dao = new PaymentTemplateDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePaymentTemplateDetail bean = new BasePaymentTemplateDetail();
		bean.setDataFromJSON(json);
		PaymentTemplateDetail dao = new PaymentTemplateDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePaymentTemplateDetail bean = new BasePaymentTemplateDetail();
		bean.setDataFromJSON(json);
		PaymentTemplateDetail dao = new PaymentTemplateDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePaymentTemplateDetail bean = new BasePaymentTemplateDetail();
		bean.setDataFromJSON(json);
		PaymentTemplateDetail dao = new PaymentTemplateDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


