package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProductInquiryDetail;
import com.pomplatform.db.dao.ProductInquiryDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProductInquiryDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProductInquiryDetailHandler.class);

	public static BaseProductInquiryDetail getProductInquiryDetailById( 
		java.lang.Integer product_inquiry_detail_id
	) throws Exception
	{
		ProductInquiryDetail dao = new ProductInquiryDetail();
		dao.setProductInquiryDetailId(product_inquiry_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProductInquiryDetailExists( com.pomplatform.db.bean.BaseProductInquiryDetail bean, String additional ) throws Exception {

		ProductInquiryDetail dao = new ProductInquiryDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProductInquiryDetail( com.pomplatform.db.bean.BaseProductInquiryDetail bean, String additional ) throws Exception {

		ProductInquiryDetail dao = new ProductInquiryDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProductInquiryDetail> queryProductInquiryDetail( com.pomplatform.db.bean.BaseProductInquiryDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProductInquiryDetail dao = new ProductInquiryDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProductInquiryDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProductInquiryDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProductInquiryDetail addToProductInquiryDetail ( BaseProductInquiryDetail productinquirydetail )  throws Exception {
		return addToProductInquiryDetail ( productinquirydetail , false);
	}

	public static BaseProductInquiryDetail addToProductInquiryDetail ( BaseProductInquiryDetail productinquirydetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProductInquiryDetail dao = new ProductInquiryDetail();
		dao.setDataFromBase(productinquirydetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProductInquiryDetail addUpdateProductInquiryDetail ( BaseProductInquiryDetail productinquirydetail ) throws Exception {
		return addUpdateProductInquiryDetail ( productinquirydetail , false);
	}

	public static BaseProductInquiryDetail addUpdateProductInquiryDetail ( BaseProductInquiryDetail productinquirydetail, boolean singleTransaction  ) throws Exception {
		if(productinquirydetail.getProductInquiryDetailId() == null) return addToProductInquiryDetail(productinquirydetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProductInquiryDetail dao = new ProductInquiryDetail();
		dao.setDataFromBase(productinquirydetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(productinquirydetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProductInquiryDetail ( BaseProductInquiryDetail bean ) throws Exception {
		ProductInquiryDetail dao = new ProductInquiryDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProductInquiryDetail updateProductInquiryDetail ( BaseProductInquiryDetail productinquirydetail ) throws Exception {
		ProductInquiryDetail dao = new ProductInquiryDetail();
		dao.setProductInquiryDetailId( productinquirydetail.getProductInquiryDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(productinquirydetail);
			result = dao.update();
		}
		return result == 1 ? productinquirydetail : null ;
	}

	public static BaseProductInquiryDetail updateProductInquiryDetailDirect( BaseProductInquiryDetail productinquirydetail ) throws Exception {
		ProductInquiryDetail dao = new ProductInquiryDetail();
		int result = 0;
		dao.setDataFromBase(productinquirydetail);
		result = dao.update();
		return result == 1 ? productinquirydetail : null ;
	}

	public static int setDeleteConditions(BaseProductInquiryDetail bean, ProductInquiryDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProductInquiryDetailId() != null) {
			dao.setConditionProductInquiryDetailId("=", bean.getProductInquiryDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProductInquiryTotalId() != null) {
				dao.setConditionProductInquiryTotalId("=", bean.getProductInquiryTotalId());
				count++;
			}
			if(bean.getProductId() != null) {
				dao.setConditionProductId("=", bean.getProductId());
				count++;
			}
			if(bean.getProductName() != null) {
				dao.setConditionProductName("=", bean.getProductName());
				count++;
			}
			if(bean.getProductModel() != null) {
				dao.setConditionProductModel("=", bean.getProductModel());
				count++;
			}
			if(bean.getProductNumber() != null) {
				dao.setConditionProductNumber("=", bean.getProductNumber());
				count++;
			}
			if(bean.getProductUnit() != null) {
				dao.setConditionProductUnit("=", bean.getProductUnit());
				count++;
			}
			if(bean.getPreTechnicalIndicator() != null) {
				dao.setConditionPreTechnicalIndicator("=", bean.getPreTechnicalIndicator());
				count++;
			}
			if(bean.getProductSpecification() != null) {
				dao.setConditionProductSpecification("=", bean.getProductSpecification());
				count++;
			}
			if(bean.getInquiryTechnicalIndicator() != null) {
				dao.setConditionInquiryTechnicalIndicator("=", bean.getInquiryTechnicalIndicator());
				count++;
			}
			if(bean.getPersonInCharge() != null) {
				dao.setConditionPersonInCharge("=", bean.getPersonInCharge());
				count++;
			}
			if(bean.getCreateEmployeeId() != null) {
				dao.setConditionCreateEmployeeId("=", bean.getCreateEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getSupplierId() != null) {
				dao.setConditionSupplierId("=", bean.getSupplierId());
				count++;
			}
			if(bean.getPersonnelBusinessId() != null) {
				dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
				count++;
			}
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
			if(bean.getIsPass() != null) {
				dao.setConditionIsPass("=", bean.getIsPass());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProductInquiryDetail bean, ProductInquiryDetail dao){
		int count = 0;
		if(bean.getProductInquiryDetailId() != null) {
			dao.setConditionProductInquiryDetailId("=", bean.getProductInquiryDetailId());
			count++;
		}
		if(bean.getProductInquiryTotalId() != null) {
			dao.setConditionProductInquiryTotalId("=", bean.getProductInquiryTotalId());
			count++;
		}
		if(bean.getProductId() != null) {
			dao.setConditionProductId("=", bean.getProductId());
			count++;
		}
		if(bean.getProductName() != null) {
			if(bean.getProductName().indexOf("%") >= 0)
				dao.setConditionProductName("like", bean.getProductName());
			else
				dao.setConditionProductName("=", bean.getProductName());
			count++;
		}
		if(bean.getProductModel() != null) {
			if(bean.getProductModel().indexOf("%") >= 0)
				dao.setConditionProductModel("like", bean.getProductModel());
			else
				dao.setConditionProductModel("=", bean.getProductModel());
			count++;
		}
		if(bean.getProductNumber() != null) {
			dao.setConditionProductNumber("=", bean.getProductNumber());
			count++;
		}
		if(bean.getProductUnit() != null) {
			if(bean.getProductUnit().indexOf("%") >= 0)
				dao.setConditionProductUnit("like", bean.getProductUnit());
			else
				dao.setConditionProductUnit("=", bean.getProductUnit());
			count++;
		}
		if(bean.getPreTechnicalIndicator() != null) {
			if(bean.getPreTechnicalIndicator().indexOf("%") >= 0)
				dao.setConditionPreTechnicalIndicator("like", bean.getPreTechnicalIndicator());
			else
				dao.setConditionPreTechnicalIndicator("=", bean.getPreTechnicalIndicator());
			count++;
		}
		if(bean.getProductSpecification() != null) {
			if(bean.getProductSpecification().indexOf("%") >= 0)
				dao.setConditionProductSpecification("like", bean.getProductSpecification());
			else
				dao.setConditionProductSpecification("=", bean.getProductSpecification());
			count++;
		}
		if(bean.getInquiryTechnicalIndicator() != null) {
			if(bean.getInquiryTechnicalIndicator().indexOf("%") >= 0)
				dao.setConditionInquiryTechnicalIndicator("like", bean.getInquiryTechnicalIndicator());
			else
				dao.setConditionInquiryTechnicalIndicator("=", bean.getInquiryTechnicalIndicator());
			count++;
		}
		if(bean.getPersonInCharge() != null) {
			dao.setConditionPersonInCharge("=", bean.getPersonInCharge());
			count++;
		}
		if(bean.getCreateEmployeeId() != null) {
			dao.setConditionCreateEmployeeId("=", bean.getCreateEmployeeId());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
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
		if(bean.getSupplierId() != null) {
			dao.setConditionSupplierId("=", bean.getSupplierId());
			count++;
		}
		if(bean.getPersonnelBusinessId() != null) {
			dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
			count++;
		}
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		if(bean.getIsPass() != null) {
			dao.setConditionIsPass("=", bean.getIsPass());
			count++;
		}
		if(bean.getTaxPoints() != null) {
			dao.setConditionTaxPoints("=", bean.getTaxPoints());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProductInquiryDetail bean = new BaseProductInquiryDetail();
		bean.setDataFromJSON(json);
		ProductInquiryDetail dao = new ProductInquiryDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProductInquiryDetail> rlist = new BaseCollection<>();
		BaseProductInquiryDetail bean = new BaseProductInquiryDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProductInquiryDetail dao = new ProductInquiryDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProductInquiryDetail> result = dao.conditionalLoad(addtion);
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
		BaseProductInquiryDetail bean = new BaseProductInquiryDetail();
		bean.setDataFromJSON(json);
		ProductInquiryDetail dao = new ProductInquiryDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProductInquiryDetail bean = new BaseProductInquiryDetail();
		bean.setDataFromJSON(json);
		ProductInquiryDetail dao = new ProductInquiryDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProductInquiryDetail bean = new BaseProductInquiryDetail();
		bean.setDataFromJSON(json);
		ProductInquiryDetail dao = new ProductInquiryDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProductInquiryDetail bean = new BaseProductInquiryDetail();
		bean.setDataFromJSON(json);
		ProductInquiryDetail dao = new ProductInquiryDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


