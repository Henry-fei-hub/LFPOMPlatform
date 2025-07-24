package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCustomer;
import com.pomplatform.db.dao.Customer;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CustomerHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CustomerHandler.class);

	public static BaseCustomer getCustomerById( 
		java.lang.Integer customer_id
	) throws Exception
	{
		Customer dao = new Customer();
		dao.setCustomerId(customer_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCustomerExists( com.pomplatform.db.bean.BaseCustomer bean, String additional ) throws Exception {

		Customer dao = new Customer();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCustomer( com.pomplatform.db.bean.BaseCustomer bean, String additional ) throws Exception {

		Customer dao = new Customer();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCustomer> queryCustomer( com.pomplatform.db.bean.BaseCustomer bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		Customer dao = new Customer();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCustomer> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCustomer> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCustomer addToCustomer ( BaseCustomer customer )  throws Exception {
		return addToCustomer ( customer , false);
	}

	public static BaseCustomer addToCustomer ( BaseCustomer customer, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		Customer dao = new Customer();
		dao.setDataFromBase(customer);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCustomer addUpdateCustomer ( BaseCustomer customer ) throws Exception {
		return addUpdateCustomer ( customer , false);
	}

	public static BaseCustomer addUpdateCustomer ( BaseCustomer customer, boolean singleTransaction  ) throws Exception {
		if(customer.getCustomerId() == null) return addToCustomer(customer);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		Customer dao = new Customer();
		dao.setDataFromBase(customer);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(customer); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCustomer ( BaseCustomer bean ) throws Exception {
		Customer dao = new Customer();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCustomer updateCustomer ( BaseCustomer customer ) throws Exception {
		Customer dao = new Customer();
		dao.setCustomerId( customer.getCustomerId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(customer);
			result = dao.update();
		}
		return result == 1 ? customer : null ;
	}

	public static BaseCustomer updateCustomerDirect( BaseCustomer customer ) throws Exception {
		Customer dao = new Customer();
		int result = 0;
		dao.setDataFromBase(customer);
		result = dao.update();
		return result == 1 ? customer : null ;
	}

	public static int setDeleteConditions(BaseCustomer bean, Customer dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCustomerId() != null) {
			dao.setConditionCustomerId("=", bean.getCustomerId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCustomerName() != null) {
				dao.setConditionCustomerName("=", bean.getCustomerName());
				count++;
			}
			if(bean.getCompanyAddress() != null) {
				dao.setConditionCompanyAddress("=", bean.getCompanyAddress());
				count++;
			}
			if(bean.getWebSite() != null) {
				dao.setConditionWebSite("=", bean.getWebSite());
				count++;
			}
			if(bean.getCompanyMobile() != null) {
				dao.setConditionCompanyMobile("=", bean.getCompanyMobile());
				count++;
			}
			if(bean.getCompanyFax() != null) {
				dao.setConditionCompanyFax("=", bean.getCompanyFax());
				count++;
			}
			if(bean.getCompanyStockCode() != null) {
				dao.setConditionCompanyStockCode("=", bean.getCompanyStockCode());
				count++;
			}
			if(bean.getPostCode() != null) {
				dao.setConditionPostCode("=", bean.getPostCode());
				count++;
			}
			if(bean.getCompanyProvince() != null) {
				dao.setConditionCompanyProvince("=", bean.getCompanyProvince());
				count++;
			}
			if(bean.getCompanyCity() != null) {
				dao.setConditionCompanyCity("=", bean.getCompanyCity());
				count++;
			}
			if(bean.getCustomerType() != null) {
				dao.setConditionCustomerType("=", bean.getCustomerType());
				count++;
			}
			if(bean.getCustomerLevel() != null) {
				dao.setConditionCustomerLevel("=", bean.getCustomerLevel());
				count++;
			}
			if(bean.getType() != null) {
				dao.setConditionType("=", bean.getType());
				count++;
			}
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
				count++;
			}
			if(bean.getIsSure() != null) {
				dao.setConditionIsSure("=", bean.getIsSure());
				count++;
			}
			if(bean.getIsWarehous() != null) {
				dao.setConditionIsWarehous("=", bean.getIsWarehous());
				count++;
			}
			if(bean.getIsApplyQuote() != null) {
				dao.setConditionIsApplyQuote("=", bean.getIsApplyQuote());
				count++;
			}
			if(bean.getCompanyParentName() != null) {
				dao.setConditionCompanyParentName("=", bean.getCompanyParentName());
				count++;
			}
			if(bean.getCompanyParentAddress() != null) {
				dao.setConditionCompanyParentAddress("=", bean.getCompanyParentAddress());
				count++;
			}
			if(bean.getCompanyChildName() != null) {
				dao.setConditionCompanyChildName("=", bean.getCompanyChildName());
				count++;
			}
			if(bean.getCompanyEmployeeNum() != null) {
				dao.setConditionCompanyEmployeeNum("=", bean.getCompanyEmployeeNum());
				count++;
			}
			if(bean.getCompanyNature() != null) {
				dao.setConditionCompanyNature("=", bean.getCompanyNature());
				count++;
			}
			if(bean.getCompanyQualification() != null) {
				dao.setConditionCompanyQualification("=", bean.getCompanyQualification());
				count++;
			}
			if(bean.getCompanyOrganizational() != null) {
				dao.setConditionCompanyOrganizational("=", bean.getCompanyOrganizational());
				count++;
			}
			if(bean.getCompanyBrief() != null) {
				dao.setConditionCompanyBrief("=", bean.getCompanyBrief());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getReportEmployeeId() != null) {
				dao.setConditionReportEmployeeId("=", bean.getReportEmployeeId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCustomer bean, Customer dao){
		int count = 0;
		if(bean.getCustomerId() != null) {
			dao.setConditionCustomerId("=", bean.getCustomerId());
			count++;
		}
		if(bean.getCustomerName() != null) {
			if(bean.getCustomerName().indexOf("%") >= 0)
				dao.setConditionCustomerName("like", bean.getCustomerName());
			else
				dao.setConditionCustomerName("=", bean.getCustomerName());
			count++;
		}
		if(bean.getCompanyAddress() != null) {
			if(bean.getCompanyAddress().indexOf("%") >= 0)
				dao.setConditionCompanyAddress("like", bean.getCompanyAddress());
			else
				dao.setConditionCompanyAddress("=", bean.getCompanyAddress());
			count++;
		}
		if(bean.getWebSite() != null) {
			if(bean.getWebSite().indexOf("%") >= 0)
				dao.setConditionWebSite("like", bean.getWebSite());
			else
				dao.setConditionWebSite("=", bean.getWebSite());
			count++;
		}
		if(bean.getCompanyMobile() != null) {
			if(bean.getCompanyMobile().indexOf("%") >= 0)
				dao.setConditionCompanyMobile("like", bean.getCompanyMobile());
			else
				dao.setConditionCompanyMobile("=", bean.getCompanyMobile());
			count++;
		}
		if(bean.getCompanyFax() != null) {
			if(bean.getCompanyFax().indexOf("%") >= 0)
				dao.setConditionCompanyFax("like", bean.getCompanyFax());
			else
				dao.setConditionCompanyFax("=", bean.getCompanyFax());
			count++;
		}
		if(bean.getCompanyStockCode() != null) {
			if(bean.getCompanyStockCode().indexOf("%") >= 0)
				dao.setConditionCompanyStockCode("like", bean.getCompanyStockCode());
			else
				dao.setConditionCompanyStockCode("=", bean.getCompanyStockCode());
			count++;
		}
		if(bean.getPostCode() != null) {
			if(bean.getPostCode().indexOf("%") >= 0)
				dao.setConditionPostCode("like", bean.getPostCode());
			else
				dao.setConditionPostCode("=", bean.getPostCode());
			count++;
		}
		if(bean.getCompanyProvince() != null) {
			if(bean.getCompanyProvince().indexOf("%") >= 0)
				dao.setConditionCompanyProvince("like", bean.getCompanyProvince());
			else
				dao.setConditionCompanyProvince("=", bean.getCompanyProvince());
			count++;
		}
		if(bean.getCompanyCity() != null) {
			if(bean.getCompanyCity().indexOf("%") >= 0)
				dao.setConditionCompanyCity("like", bean.getCompanyCity());
			else
				dao.setConditionCompanyCity("=", bean.getCompanyCity());
			count++;
		}
		if(bean.getCustomerType() != null) {
			dao.setConditionCustomerType("=", bean.getCustomerType());
			count++;
		}
		if(bean.getCustomerLevel() != null) {
			dao.setConditionCustomerLevel("=", bean.getCustomerLevel());
			count++;
		}
		if(bean.getType() != null) {
			dao.setConditionType("=", bean.getType());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
			count++;
		}
		if(bean.getIsSure() != null) {
			dao.setConditionIsSure("=", bean.getIsSure());
			count++;
		}
		if(bean.getIsWarehous() != null) {
			dao.setConditionIsWarehous("=", bean.getIsWarehous());
			count++;
		}
		if(bean.getIsApplyQuote() != null) {
			dao.setConditionIsApplyQuote("=", bean.getIsApplyQuote());
			count++;
		}
		if(bean.getCompanyParentName() != null) {
			if(bean.getCompanyParentName().indexOf("%") >= 0)
				dao.setConditionCompanyParentName("like", bean.getCompanyParentName());
			else
				dao.setConditionCompanyParentName("=", bean.getCompanyParentName());
			count++;
		}
		if(bean.getCompanyParentAddress() != null) {
			if(bean.getCompanyParentAddress().indexOf("%") >= 0)
				dao.setConditionCompanyParentAddress("like", bean.getCompanyParentAddress());
			else
				dao.setConditionCompanyParentAddress("=", bean.getCompanyParentAddress());
			count++;
		}
		if(bean.getCompanyChildName() != null) {
			if(bean.getCompanyChildName().indexOf("%") >= 0)
				dao.setConditionCompanyChildName("like", bean.getCompanyChildName());
			else
				dao.setConditionCompanyChildName("=", bean.getCompanyChildName());
			count++;
		}
		if(bean.getCompanyEmployeeNum() != null) {
			dao.setConditionCompanyEmployeeNum("=", bean.getCompanyEmployeeNum());
			count++;
		}
		if(bean.getCompanySetup() != null) {
			dao.setConditionCompanySetup(">=", bean.getCompanySetup());
			count++;
		}
		if(bean.getCompanyNature() != null) {
			if(bean.getCompanyNature().indexOf("%") >= 0)
				dao.setConditionCompanyNature("like", bean.getCompanyNature());
			else
				dao.setConditionCompanyNature("=", bean.getCompanyNature());
			count++;
		}
		if(bean.getCompanyQualification() != null) {
			if(bean.getCompanyQualification().indexOf("%") >= 0)
				dao.setConditionCompanyQualification("like", bean.getCompanyQualification());
			else
				dao.setConditionCompanyQualification("=", bean.getCompanyQualification());
			count++;
		}
		if(bean.getCompanyOrganizational() != null) {
			if(bean.getCompanyOrganizational().indexOf("%") >= 0)
				dao.setConditionCompanyOrganizational("like", bean.getCompanyOrganizational());
			else
				dao.setConditionCompanyOrganizational("=", bean.getCompanyOrganizational());
			count++;
		}
		if(bean.getCompanyBrief() != null) {
			if(bean.getCompanyBrief().indexOf("%") >= 0)
				dao.setConditionCompanyBrief("like", bean.getCompanyBrief());
			else
				dao.setConditionCompanyBrief("=", bean.getCompanyBrief());
			count++;
		}
		if(bean.getOperateEmployeeId() != null) {
			dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
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
		if(bean.getReportEmployeeId() != null) {
			dao.setConditionReportEmployeeId("=", bean.getReportEmployeeId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCustomer bean = new BaseCustomer();
		bean.setDataFromJSON(json);
		Customer dao = new Customer();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCustomer> rlist = new BaseCollection<>();
		BaseCustomer bean = new BaseCustomer();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		Customer dao = new Customer();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCustomer> result = dao.conditionalLoad(addtion);
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
		BaseCustomer bean = new BaseCustomer();
		bean.setDataFromJSON(json);
		Customer dao = new Customer();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCustomer bean = new BaseCustomer();
		bean.setDataFromJSON(json);
		Customer dao = new Customer();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCustomer bean = new BaseCustomer();
		bean.setDataFromJSON(json);
		Customer dao = new Customer();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCustomer bean = new BaseCustomer();
		bean.setDataFromJSON(json);
		Customer dao = new Customer();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


