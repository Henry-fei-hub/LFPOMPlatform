package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseInvoiceType;
import com.pomplatform.db.dao.InvoiceType;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class InvoiceTypeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(InvoiceTypeHandler.class);

	public static BaseInvoiceType getInvoiceTypeById( 
		java.lang.Integer invoice_type_id
	) throws Exception
	{
		InvoiceType dao = new InvoiceType();
		dao.setInvoiceTypeId(invoice_type_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isInvoiceTypeExists( com.pomplatform.db.bean.BaseInvoiceType bean, String additional ) throws Exception {

		InvoiceType dao = new InvoiceType();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countInvoiceType( com.pomplatform.db.bean.BaseInvoiceType bean, String additional ) throws Exception {

		InvoiceType dao = new InvoiceType();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseInvoiceType> queryInvoiceType( com.pomplatform.db.bean.BaseInvoiceType bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		InvoiceType dao = new InvoiceType();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseInvoiceType> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseInvoiceType> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseInvoiceType addToInvoiceType ( BaseInvoiceType invoicetype )  throws Exception {
		return addToInvoiceType ( invoicetype , false);
	}

	public static BaseInvoiceType addToInvoiceType ( BaseInvoiceType invoicetype, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		InvoiceType dao = new InvoiceType();
		dao.setDataFromBase(invoicetype);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseInvoiceType addUpdateInvoiceType ( BaseInvoiceType invoicetype ) throws Exception {
		return addUpdateInvoiceType ( invoicetype , false);
	}

	public static BaseInvoiceType addUpdateInvoiceType ( BaseInvoiceType invoicetype, boolean singleTransaction  ) throws Exception {
		if(invoicetype.getInvoiceTypeId() == null) return addToInvoiceType(invoicetype);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		InvoiceType dao = new InvoiceType();
		dao.setDataFromBase(invoicetype);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(invoicetype); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteInvoiceType ( BaseInvoiceType bean ) throws Exception {
		InvoiceType dao = new InvoiceType();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseInvoiceType updateInvoiceType ( BaseInvoiceType invoicetype ) throws Exception {
		InvoiceType dao = new InvoiceType();
		dao.setInvoiceTypeId( invoicetype.getInvoiceTypeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(invoicetype);
			result = dao.update();
		}
		return result == 1 ? invoicetype : null ;
	}

	public static BaseInvoiceType updateInvoiceTypeDirect( BaseInvoiceType invoicetype ) throws Exception {
		InvoiceType dao = new InvoiceType();
		int result = 0;
		dao.setDataFromBase(invoicetype);
		result = dao.update();
		return result == 1 ? invoicetype : null ;
	}

	public static int setDeleteConditions(BaseInvoiceType bean, InvoiceType dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getInvoiceTypeId() != null) {
			dao.setConditionInvoiceTypeId("=", bean.getInvoiceTypeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getTypeName() != null) {
				dao.setConditionTypeName("=", bean.getTypeName());
				count++;
			}
			if(bean.getSubtractRemark() != null) {
				dao.setConditionSubtractRemark("=", bean.getSubtractRemark());
				count++;
			}
			if(bean.getTaxRate() != null) {
				dao.setConditionTaxRate("=", bean.getTaxRate());
				count++;
			}
			if(bean.getCreator() != null) {
				dao.setConditionCreator("=", bean.getCreator());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseInvoiceType bean, InvoiceType dao){
		int count = 0;
		if(bean.getInvoiceTypeId() != null) {
			dao.setConditionInvoiceTypeId("=", bean.getInvoiceTypeId());
			count++;
		}
		if(bean.getTypeName() != null) {
			if(bean.getTypeName().indexOf("%") >= 0)
				dao.setConditionTypeName("like", bean.getTypeName());
			else
				dao.setConditionTypeName("=", bean.getTypeName());
			count++;
		}
		if(bean.getSubtractRemark() != null) {
			if(bean.getSubtractRemark().indexOf("%") >= 0)
				dao.setConditionSubtractRemark("like", bean.getSubtractRemark());
			else
				dao.setConditionSubtractRemark("=", bean.getSubtractRemark());
			count++;
		}
		if(bean.getTaxRate() != null) {
			dao.setConditionTaxRate("=", bean.getTaxRate());
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseInvoiceType bean = new BaseInvoiceType();
		bean.setDataFromJSON(json);
		InvoiceType dao = new InvoiceType();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseInvoiceType> rlist = new BaseCollection<>();
		BaseInvoiceType bean = new BaseInvoiceType();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		InvoiceType dao = new InvoiceType();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseInvoiceType> result = dao.conditionalLoad(addtion);
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
		BaseInvoiceType bean = new BaseInvoiceType();
		bean.setDataFromJSON(json);
		InvoiceType dao = new InvoiceType();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseInvoiceType bean = new BaseInvoiceType();
		bean.setDataFromJSON(json);
		InvoiceType dao = new InvoiceType();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseInvoiceType bean = new BaseInvoiceType();
		bean.setDataFromJSON(json);
		InvoiceType dao = new InvoiceType();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseInvoiceType bean = new BaseInvoiceType();
		bean.setDataFromJSON(json);
		InvoiceType dao = new InvoiceType();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


