package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProductInquiryTotal;
import com.pomplatform.db.dao.ProductInquiryTotal;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProductInquiryTotalHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProductInquiryTotalHandler.class);

	public static BaseProductInquiryTotal getProductInquiryTotalById( 
		java.lang.Integer product_inquiry_total_id
	) throws Exception
	{
		ProductInquiryTotal dao = new ProductInquiryTotal();
		dao.setProductInquiryTotalId(product_inquiry_total_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProductInquiryTotalExists( com.pomplatform.db.bean.BaseProductInquiryTotal bean, String additional ) throws Exception {

		ProductInquiryTotal dao = new ProductInquiryTotal();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProductInquiryTotal( com.pomplatform.db.bean.BaseProductInquiryTotal bean, String additional ) throws Exception {

		ProductInquiryTotal dao = new ProductInquiryTotal();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProductInquiryTotal> queryProductInquiryTotal( com.pomplatform.db.bean.BaseProductInquiryTotal bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProductInquiryTotal dao = new ProductInquiryTotal();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProductInquiryTotal> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProductInquiryTotal> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProductInquiryTotal addToProductInquiryTotal ( BaseProductInquiryTotal productinquirytotal )  throws Exception {
		return addToProductInquiryTotal ( productinquirytotal , false);
	}

	public static BaseProductInquiryTotal addToProductInquiryTotal ( BaseProductInquiryTotal productinquirytotal, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProductInquiryTotal dao = new ProductInquiryTotal();
		dao.setDataFromBase(productinquirytotal);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProductInquiryTotal addUpdateProductInquiryTotal ( BaseProductInquiryTotal productinquirytotal ) throws Exception {
		return addUpdateProductInquiryTotal ( productinquirytotal , false);
	}

	public static BaseProductInquiryTotal addUpdateProductInquiryTotal ( BaseProductInquiryTotal productinquirytotal, boolean singleTransaction  ) throws Exception {
		if(productinquirytotal.getProductInquiryTotalId() == null) return addToProductInquiryTotal(productinquirytotal);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProductInquiryTotal dao = new ProductInquiryTotal();
		dao.setDataFromBase(productinquirytotal);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(productinquirytotal); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProductInquiryTotal ( BaseProductInquiryTotal bean ) throws Exception {
		ProductInquiryTotal dao = new ProductInquiryTotal();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProductInquiryTotal updateProductInquiryTotal ( BaseProductInquiryTotal productinquirytotal ) throws Exception {
		ProductInquiryTotal dao = new ProductInquiryTotal();
		dao.setProductInquiryTotalId( productinquirytotal.getProductInquiryTotalId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(productinquirytotal);
			result = dao.update();
		}
		return result == 1 ? productinquirytotal : null ;
	}

	public static BaseProductInquiryTotal updateProductInquiryTotalDirect( BaseProductInquiryTotal productinquirytotal ) throws Exception {
		ProductInquiryTotal dao = new ProductInquiryTotal();
		int result = 0;
		dao.setDataFromBase(productinquirytotal);
		result = dao.update();
		return result == 1 ? productinquirytotal : null ;
	}

	public static int setDeleteConditions(BaseProductInquiryTotal bean, ProductInquiryTotal dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProductInquiryTotalId() != null) {
			dao.setConditionProductInquiryTotalId("=", bean.getProductInquiryTotalId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getMajorTitle() != null) {
				dao.setConditionMajorTitle("=", bean.getMajorTitle());
				count++;
			}
			if(bean.getProcessType() != null) {
				dao.setConditionProcessType("=", bean.getProcessType());
				count++;
			}
			if(bean.getReason() != null) {
				dao.setConditionReason("=", bean.getReason());
				count++;
			}
			if(bean.getEmployeeNo() != null) {
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getCreateEmployeeId() != null) {
				dao.setConditionCreateEmployeeId("=", bean.getCreateEmployeeId());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProductInquiryTotal bean, ProductInquiryTotal dao){
		int count = 0;
		if(bean.getProductInquiryTotalId() != null) {
			dao.setConditionProductInquiryTotalId("=", bean.getProductInquiryTotalId());
			count++;
		}
		if(bean.getMajorTitle() != null) {
			if(bean.getMajorTitle().indexOf("%") >= 0)
				dao.setConditionMajorTitle("like", bean.getMajorTitle());
			else
				dao.setConditionMajorTitle("=", bean.getMajorTitle());
			count++;
		}
		if(bean.getProcessType() != null) {
			dao.setConditionProcessType("=", bean.getProcessType());
			count++;
		}
		if(bean.getReason() != null) {
			if(bean.getReason().indexOf("%") >= 0)
				dao.setConditionReason("like", bean.getReason());
			else
				dao.setConditionReason("=", bean.getReason());
			count++;
		}
		if(bean.getEmployeeNo() != null) {
			if(bean.getEmployeeNo().indexOf("%") >= 0)
				dao.setConditionEmployeeNo("like", bean.getEmployeeNo());
			else
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
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
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProductInquiryTotal bean = new BaseProductInquiryTotal();
		bean.setDataFromJSON(json);
		ProductInquiryTotal dao = new ProductInquiryTotal();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProductInquiryTotal> rlist = new BaseCollection<>();
		BaseProductInquiryTotal bean = new BaseProductInquiryTotal();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProductInquiryTotal dao = new ProductInquiryTotal();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProductInquiryTotal> result = dao.conditionalLoad(addtion);
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
		BaseProductInquiryTotal bean = new BaseProductInquiryTotal();
		bean.setDataFromJSON(json);
		ProductInquiryTotal dao = new ProductInquiryTotal();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProductInquiryTotal bean = new BaseProductInquiryTotal();
		bean.setDataFromJSON(json);
		ProductInquiryTotal dao = new ProductInquiryTotal();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProductInquiryTotal bean = new BaseProductInquiryTotal();
		bean.setDataFromJSON(json);
		ProductInquiryTotal dao = new ProductInquiryTotal();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProductInquiryTotal bean = new BaseProductInquiryTotal();
		bean.setDataFromJSON(json);
		ProductInquiryTotal dao = new ProductInquiryTotal();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


