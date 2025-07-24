package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePaymentTemplate;
import com.pomplatform.db.dao.PaymentTemplate;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PaymentTemplateHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PaymentTemplateHandler.class);

	public static BasePaymentTemplate getPaymentTemplateById( 
		java.lang.Integer payment_template_id
	) throws Exception
	{
		PaymentTemplate dao = new PaymentTemplate();
		dao.setPaymentTemplateId(payment_template_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPaymentTemplateExists( com.pomplatform.db.bean.BasePaymentTemplate bean, String additional ) throws Exception {

		PaymentTemplate dao = new PaymentTemplate();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPaymentTemplate( com.pomplatform.db.bean.BasePaymentTemplate bean, String additional ) throws Exception {

		PaymentTemplate dao = new PaymentTemplate();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePaymentTemplate> queryPaymentTemplate( com.pomplatform.db.bean.BasePaymentTemplate bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PaymentTemplate dao = new PaymentTemplate();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePaymentTemplate> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePaymentTemplate> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePaymentTemplate addToPaymentTemplate ( BasePaymentTemplate paymenttemplate )  throws Exception {
		return addToPaymentTemplate ( paymenttemplate , false);
	}

	public static BasePaymentTemplate addToPaymentTemplate ( BasePaymentTemplate paymenttemplate, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PaymentTemplate dao = new PaymentTemplate();
		dao.setDataFromBase(paymenttemplate);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePaymentTemplate addUpdatePaymentTemplate ( BasePaymentTemplate paymenttemplate ) throws Exception {
		return addUpdatePaymentTemplate ( paymenttemplate , false);
	}

	public static BasePaymentTemplate addUpdatePaymentTemplate ( BasePaymentTemplate paymenttemplate, boolean singleTransaction  ) throws Exception {
		if(paymenttemplate.getPaymentTemplateId() == null) return addToPaymentTemplate(paymenttemplate);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PaymentTemplate dao = new PaymentTemplate();
		dao.setDataFromBase(paymenttemplate);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(paymenttemplate); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePaymentTemplate ( BasePaymentTemplate bean ) throws Exception {
		PaymentTemplate dao = new PaymentTemplate();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePaymentTemplate updatePaymentTemplate ( BasePaymentTemplate paymenttemplate ) throws Exception {
		PaymentTemplate dao = new PaymentTemplate();
		dao.setPaymentTemplateId( paymenttemplate.getPaymentTemplateId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(paymenttemplate);
			result = dao.update();
		}
		return result == 1 ? paymenttemplate : null ;
	}

	public static BasePaymentTemplate updatePaymentTemplateDirect( BasePaymentTemplate paymenttemplate ) throws Exception {
		PaymentTemplate dao = new PaymentTemplate();
		int result = 0;
		dao.setDataFromBase(paymenttemplate);
		result = dao.update();
		return result == 1 ? paymenttemplate : null ;
	}

	public static int setDeleteConditions(BasePaymentTemplate bean, PaymentTemplate dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPaymentTemplateId() != null) {
			dao.setConditionPaymentTemplateId("=", bean.getPaymentTemplateId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getTemplateName() != null) {
				dao.setConditionTemplateName("=", bean.getTemplateName());
				count++;
			}
			if(bean.getPaymentCycle() != null) {
				dao.setConditionPaymentCycle("=", bean.getPaymentCycle());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getOperatorId() != null) {
				dao.setConditionOperatorId("=", bean.getOperatorId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePaymentTemplate bean, PaymentTemplate dao){
		int count = 0;
		if(bean.getPaymentTemplateId() != null) {
			dao.setConditionPaymentTemplateId("=", bean.getPaymentTemplateId());
			count++;
		}
		if(bean.getTemplateName() != null) {
			if(bean.getTemplateName().indexOf("%") >= 0)
				dao.setConditionTemplateName("like", bean.getTemplateName());
			else
				dao.setConditionTemplateName("=", bean.getTemplateName());
			count++;
		}
		if(bean.getPaymentCycle() != null) {
			dao.setConditionPaymentCycle("=", bean.getPaymentCycle());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getOperatorId() != null) {
			dao.setConditionOperatorId("=", bean.getOperatorId());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePaymentTemplate bean = new BasePaymentTemplate();
		bean.setDataFromJSON(json);
		PaymentTemplate dao = new PaymentTemplate();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePaymentTemplate> rlist = new BaseCollection<>();
		BasePaymentTemplate bean = new BasePaymentTemplate();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PaymentTemplate dao = new PaymentTemplate();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePaymentTemplate> result = dao.conditionalLoad(addtion);
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
		BasePaymentTemplate bean = new BasePaymentTemplate();
		bean.setDataFromJSON(json);
		PaymentTemplate dao = new PaymentTemplate();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePaymentTemplate bean = new BasePaymentTemplate();
		bean.setDataFromJSON(json);
		PaymentTemplate dao = new PaymentTemplate();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePaymentTemplate bean = new BasePaymentTemplate();
		bean.setDataFromJSON(json);
		PaymentTemplate dao = new PaymentTemplate();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePaymentTemplate bean = new BasePaymentTemplate();
		bean.setDataFromJSON(json);
		PaymentTemplate dao = new PaymentTemplate();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


