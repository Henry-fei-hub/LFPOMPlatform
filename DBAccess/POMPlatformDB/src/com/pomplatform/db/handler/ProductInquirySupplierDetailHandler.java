package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProductInquirySupplierDetail;
import com.pomplatform.db.dao.ProductInquirySupplierDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProductInquirySupplierDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProductInquirySupplierDetailHandler.class);

	public static BaseProductInquirySupplierDetail getProductInquirySupplierDetailById( 
		java.lang.Integer product_inquiry_supplier_detail_id
	) throws Exception
	{
		ProductInquirySupplierDetail dao = new ProductInquirySupplierDetail();
		dao.setProductInquirySupplierDetailId(product_inquiry_supplier_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProductInquirySupplierDetailExists( com.pomplatform.db.bean.BaseProductInquirySupplierDetail bean, String additional ) throws Exception {

		ProductInquirySupplierDetail dao = new ProductInquirySupplierDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProductInquirySupplierDetail( com.pomplatform.db.bean.BaseProductInquirySupplierDetail bean, String additional ) throws Exception {

		ProductInquirySupplierDetail dao = new ProductInquirySupplierDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProductInquirySupplierDetail> queryProductInquirySupplierDetail( com.pomplatform.db.bean.BaseProductInquirySupplierDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProductInquirySupplierDetail dao = new ProductInquirySupplierDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProductInquirySupplierDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProductInquirySupplierDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProductInquirySupplierDetail addToProductInquirySupplierDetail ( BaseProductInquirySupplierDetail productinquirysupplierdetail )  throws Exception {
		return addToProductInquirySupplierDetail ( productinquirysupplierdetail , false);
	}

	public static BaseProductInquirySupplierDetail addToProductInquirySupplierDetail ( BaseProductInquirySupplierDetail productinquirysupplierdetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProductInquirySupplierDetail dao = new ProductInquirySupplierDetail();
		dao.setDataFromBase(productinquirysupplierdetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProductInquirySupplierDetail addUpdateProductInquirySupplierDetail ( BaseProductInquirySupplierDetail productinquirysupplierdetail ) throws Exception {
		return addUpdateProductInquirySupplierDetail ( productinquirysupplierdetail , false);
	}

	public static BaseProductInquirySupplierDetail addUpdateProductInquirySupplierDetail ( BaseProductInquirySupplierDetail productinquirysupplierdetail, boolean singleTransaction  ) throws Exception {
		if(productinquirysupplierdetail.getProductInquirySupplierDetailId() == null) return addToProductInquirySupplierDetail(productinquirysupplierdetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProductInquirySupplierDetail dao = new ProductInquirySupplierDetail();
		dao.setDataFromBase(productinquirysupplierdetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(productinquirysupplierdetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProductInquirySupplierDetail ( BaseProductInquirySupplierDetail bean ) throws Exception {
		ProductInquirySupplierDetail dao = new ProductInquirySupplierDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProductInquirySupplierDetail updateProductInquirySupplierDetail ( BaseProductInquirySupplierDetail productinquirysupplierdetail ) throws Exception {
		ProductInquirySupplierDetail dao = new ProductInquirySupplierDetail();
		dao.setProductInquirySupplierDetailId( productinquirysupplierdetail.getProductInquirySupplierDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(productinquirysupplierdetail);
			result = dao.update();
		}
		return result == 1 ? productinquirysupplierdetail : null ;
	}

	public static BaseProductInquirySupplierDetail updateProductInquirySupplierDetailDirect( BaseProductInquirySupplierDetail productinquirysupplierdetail ) throws Exception {
		ProductInquirySupplierDetail dao = new ProductInquirySupplierDetail();
		int result = 0;
		dao.setDataFromBase(productinquirysupplierdetail);
		result = dao.update();
		return result == 1 ? productinquirysupplierdetail : null ;
	}

	public static int setDeleteConditions(BaseProductInquirySupplierDetail bean, ProductInquirySupplierDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProductInquirySupplierDetailId() != null) {
			dao.setConditionProductInquirySupplierDetailId("=", bean.getProductInquirySupplierDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getSupplierId() != null) {
				dao.setConditionSupplierId("=", bean.getSupplierId());
				count++;
			}
			if(bean.getProductInquiryDetailId() != null) {
				dao.setConditionProductInquiryDetailId("=", bean.getProductInquiryDetailId());
				count++;
			}
			if(bean.getPriorityLevel() != null) {
				dao.setConditionPriorityLevel("=", bean.getPriorityLevel());
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
			if(bean.getSupplierContactId() != null) {
				dao.setConditionSupplierContactId("=", bean.getSupplierContactId());
				count++;
			}
			if(bean.getIsSelect() != null) {
				dao.setConditionIsSelect("=", bean.getIsSelect());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProductInquirySupplierDetail bean, ProductInquirySupplierDetail dao){
		int count = 0;
		if(bean.getProductInquirySupplierDetailId() != null) {
			dao.setConditionProductInquirySupplierDetailId("=", bean.getProductInquirySupplierDetailId());
			count++;
		}
		if(bean.getSupplierId() != null) {
			dao.setConditionSupplierId("=", bean.getSupplierId());
			count++;
		}
		if(bean.getProductInquiryDetailId() != null) {
			dao.setConditionProductInquiryDetailId("=", bean.getProductInquiryDetailId());
			count++;
		}
		if(bean.getProductPrice() != null) {
			dao.setConditionProductPrice("=", bean.getProductPrice());
			count++;
		}
		if(bean.getTotalPrice() != null) {
			dao.setConditionTotalPrice("=", bean.getTotalPrice());
			count++;
		}
		if(bean.getTaxPoints() != null) {
			dao.setConditionTaxPoints("=", bean.getTaxPoints());
			count++;
		}
		if(bean.getPriorityLevel() != null) {
			dao.setConditionPriorityLevel("=", bean.getPriorityLevel());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getInquiryDate() != null) {
			dao.setConditionInquiryDate(">=", bean.getInquiryDate());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getOperatorId() != null) {
			dao.setConditionOperatorId("=", bean.getOperatorId());
			count++;
		}
		if(bean.getSupplierContactId() != null) {
			dao.setConditionSupplierContactId("=", bean.getSupplierContactId());
			count++;
		}
		if(bean.getIsSelect() != null) {
			dao.setConditionIsSelect("=", bean.getIsSelect());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProductInquirySupplierDetail bean = new BaseProductInquirySupplierDetail();
		bean.setDataFromJSON(json);
		ProductInquirySupplierDetail dao = new ProductInquirySupplierDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProductInquirySupplierDetail> rlist = new BaseCollection<>();
		BaseProductInquirySupplierDetail bean = new BaseProductInquirySupplierDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProductInquirySupplierDetail dao = new ProductInquirySupplierDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProductInquirySupplierDetail> result = dao.conditionalLoad(addtion);
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
		BaseProductInquirySupplierDetail bean = new BaseProductInquirySupplierDetail();
		bean.setDataFromJSON(json);
		ProductInquirySupplierDetail dao = new ProductInquirySupplierDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProductInquirySupplierDetail bean = new BaseProductInquirySupplierDetail();
		bean.setDataFromJSON(json);
		ProductInquirySupplierDetail dao = new ProductInquirySupplierDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProductInquirySupplierDetail bean = new BaseProductInquirySupplierDetail();
		bean.setDataFromJSON(json);
		ProductInquirySupplierDetail dao = new ProductInquirySupplierDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProductInquirySupplierDetail bean = new BaseProductInquirySupplierDetail();
		bean.setDataFromJSON(json);
		ProductInquirySupplierDetail dao = new ProductInquirySupplierDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


