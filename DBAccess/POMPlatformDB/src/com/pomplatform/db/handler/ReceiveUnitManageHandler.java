package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseReceiveUnitManage;
import java.util.List;
import com.pomplatform.db.dao.ReceiveUnitManage;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class ReceiveUnitManageHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ReceiveUnitManageHandler.class);

	public static BaseReceiveUnitManage getReceiveUnitManageById( 
		java.lang.Integer receive_unit_manage_id
	) throws Exception
	{
		ReceiveUnitManage dao = new ReceiveUnitManage();
		dao.setReceiveUnitManageId(receive_unit_manage_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isReceiveUnitManageExists( com.pomplatform.db.bean.BaseReceiveUnitManage bean, String additional ) throws Exception {

		ReceiveUnitManage dao = new ReceiveUnitManage();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countReceiveUnitManage( com.pomplatform.db.bean.BaseReceiveUnitManage bean, String additional ) throws Exception {

		ReceiveUnitManage dao = new ReceiveUnitManage();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseReceiveUnitManage> queryReceiveUnitManage( com.pomplatform.db.bean.BaseReceiveUnitManage bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ReceiveUnitManage dao = new ReceiveUnitManage();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseReceiveUnitManage> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseReceiveUnitManage> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseReceiveUnitManage addToReceiveUnitManage ( BaseReceiveUnitManage receiveunitmanage )  throws Exception {
		return addToReceiveUnitManage ( receiveunitmanage , false);
	}

	public static BaseReceiveUnitManage addToReceiveUnitManage ( BaseReceiveUnitManage receiveunitmanage, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ReceiveUnitManage dao = new ReceiveUnitManage();
		dao.setDataFromBase(receiveunitmanage);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseReceiveUnitManage addUpdateReceiveUnitManage ( BaseReceiveUnitManage receiveunitmanage ) throws Exception {
		return addUpdateReceiveUnitManage ( receiveunitmanage , false);
	}

	public static BaseReceiveUnitManage addUpdateReceiveUnitManage ( BaseReceiveUnitManage receiveunitmanage, boolean singleTransaction  ) throws Exception {
		if(receiveunitmanage.getReceiveUnitManageId() == null) return addToReceiveUnitManage(receiveunitmanage);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ReceiveUnitManage dao = new ReceiveUnitManage();
		dao.setDataFromBase(receiveunitmanage);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(receiveunitmanage); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteReceiveUnitManage ( BaseReceiveUnitManage bean ) throws Exception {
		ReceiveUnitManage dao = new ReceiveUnitManage();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseReceiveUnitManage updateReceiveUnitManage ( BaseReceiveUnitManage receiveunitmanage ) throws Exception {
		ReceiveUnitManage dao = new ReceiveUnitManage();
		dao.setReceiveUnitManageId( receiveunitmanage.getReceiveUnitManageId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(receiveunitmanage);
			result = dao.update();
		}
		return result == 1 ? receiveunitmanage : null ;
	}

	public static BaseReceiveUnitManage updateReceiveUnitManageDirect( BaseReceiveUnitManage receiveunitmanage ) throws Exception {
		ReceiveUnitManage dao = new ReceiveUnitManage();
		int result = 0;
		dao.setDataFromBase(receiveunitmanage);
		result = dao.update();
		return result == 1 ? receiveunitmanage : null ;
	}

	public static int setDeleteConditions(BaseReceiveUnitManage bean, ReceiveUnitManage dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getReceiveUnitManageId() != null) {
			dao.setConditionReceiveUnitManageId("=", bean.getReceiveUnitManageId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getReceiveUnit() != null) {
				dao.setConditionReceiveUnit("=", bean.getReceiveUnit());
				count++;
			}
			if(bean.getBankAccount() != null) {
				dao.setConditionBankAccount("=", bean.getBankAccount());
				count++;
			}
			if(bean.getBankName() != null) {
				dao.setConditionBankName("=", bean.getBankName());
				count++;
			}
			if(bean.getReceiveUnitAddress() != null) {
				dao.setConditionReceiveUnitAddress("=", bean.getReceiveUnitAddress());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
			if(bean.getOrigin() != null) {
				dao.setConditionOrigin("=", bean.getOrigin());
				count++;
			}
			if(bean.getReceiveUnitType() != null) {
				dao.setConditionReceiveUnitType("=", bean.getReceiveUnitType());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getSalaryType() != null) {
				dao.setConditionSalaryType("=", bean.getSalaryType());
				count++;
			}
			if(bean.getProvince() != null) {
				dao.setConditionProvince("=", bean.getProvince());
				count++;
			}
			if(bean.getCity() != null) {
				dao.setConditionCity("=", bean.getCity());
				count++;
			}
			if(bean.getBankAddress() != null) {
				dao.setConditionBankAddress("=", bean.getBankAddress());
				count++;
			}
			if(bean.getReceiveUnitPhone() != null) {
				dao.setConditionReceiveUnitPhone("=", bean.getReceiveUnitPhone());
				count++;
			}
			if(bean.getSwiftCode() != null) {
				dao.setConditionSwiftCode("=", bean.getSwiftCode());
				count++;
			}
			if(bean.getCountryId() != null) {
				dao.setConditionCountryId("=", bean.getCountryId());
				count++;
			}
			if(bean.getCountryCode() != null) {
				dao.setConditionCountryCode("=", bean.getCountryCode());
				count++;
			}
			if(bean.getPassport() != null) {
				dao.setConditionPassport("=", bean.getPassport());
				count++;
			}
			if(bean.getBankId() != null) {
				dao.setConditionBankId("=", bean.getBankId());
				count++;
			}
			if(bean.getAccountType() != null) {
				dao.setConditionAccountType("=", bean.getAccountType());
				count++;
			}
			if(bean.getIsUse() != null) {
				dao.setConditionIsUse("=", bean.getIsUse());
				count++;
			}
			if(bean.getSupplierId() != null) {
				dao.setConditionSupplierId("=", bean.getSupplierId());
				count++;
			}
			if(bean.getVoucherType() != null) {
				dao.setConditionVoucherType("=", bean.getVoucherType());
				count++;
			}
			if(bean.getFundraisingProjectTypeId() != null) {
				dao.setConditionFundraisingProjectTypeId("=", bean.getFundraisingProjectTypeId());
				count++;
			}
			if(bean.getSupplierType() != null) {
				dao.setConditionSupplierType("=", bean.getSupplierType());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseReceiveUnitManage bean, ReceiveUnitManage dao){
		int count = 0;
		if(bean.getReceiveUnitManageId() != null) {
			dao.setConditionReceiveUnitManageId("=", bean.getReceiveUnitManageId());
			count++;
		}
		if(bean.getReceiveUnit() != null) {
			if(bean.getReceiveUnit().indexOf("%") >= 0)
				dao.setConditionReceiveUnit("like", bean.getReceiveUnit());
			else
				dao.setConditionReceiveUnit("=", bean.getReceiveUnit());
			count++;
		}
		if(bean.getBankAccount() != null) {
			if(bean.getBankAccount().indexOf("%") >= 0)
				dao.setConditionBankAccount("like", bean.getBankAccount());
			else
				dao.setConditionBankAccount("=", bean.getBankAccount());
			count++;
		}
		if(bean.getBankName() != null) {
			if(bean.getBankName().indexOf("%") >= 0)
				dao.setConditionBankName("like", bean.getBankName());
			else
				dao.setConditionBankName("=", bean.getBankName());
			count++;
		}
		if(bean.getReceiveUnitAddress() != null) {
			if(bean.getReceiveUnitAddress().indexOf("%") >= 0)
				dao.setConditionReceiveUnitAddress("like", bean.getReceiveUnitAddress());
			else
				dao.setConditionReceiveUnitAddress("=", bean.getReceiveUnitAddress());
			count++;
		}
		if(bean.getOperateEmployeeId() != null) {
			dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
			count++;
		}
		if(bean.getOperateTime() != null) {
			dao.setConditionOperateTime(">=", bean.getOperateTime());
			count++;
		}
		if(bean.getOrigin() != null) {
			dao.setConditionOrigin("=", bean.getOrigin());
			count++;
		}
		if(bean.getReceiveUnitType() != null) {
			dao.setConditionReceiveUnitType("=", bean.getReceiveUnitType());
			count++;
		}
		if(bean.getCompanyId() != null) {
			if(bean.getCompanyId().indexOf("%") >= 0)
				dao.setConditionCompanyId("like", bean.getCompanyId());
			else
				dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getSalaryType() != null) {
			dao.setConditionSalaryType("=", bean.getSalaryType());
			count++;
		}
		if(bean.getProvince() != null) {
			dao.setConditionProvince("=", bean.getProvince());
			count++;
		}
		if(bean.getCity() != null) {
			dao.setConditionCity("=", bean.getCity());
			count++;
		}
		if(bean.getBankAddress() != null) {
			if(bean.getBankAddress().indexOf("%") >= 0)
				dao.setConditionBankAddress("like", bean.getBankAddress());
			else
				dao.setConditionBankAddress("=", bean.getBankAddress());
			count++;
		}
		if(bean.getReceiveUnitPhone() != null) {
			if(bean.getReceiveUnitPhone().indexOf("%") >= 0)
				dao.setConditionReceiveUnitPhone("like", bean.getReceiveUnitPhone());
			else
				dao.setConditionReceiveUnitPhone("=", bean.getReceiveUnitPhone());
			count++;
		}
		if(bean.getSwiftCode() != null) {
			if(bean.getSwiftCode().indexOf("%") >= 0)
				dao.setConditionSwiftCode("like", bean.getSwiftCode());
			else
				dao.setConditionSwiftCode("=", bean.getSwiftCode());
			count++;
		}
		if(bean.getCountryId() != null) {
			dao.setConditionCountryId("=", bean.getCountryId());
			count++;
		}
		if(bean.getCountryCode() != null) {
			if(bean.getCountryCode().indexOf("%") >= 0)
				dao.setConditionCountryCode("like", bean.getCountryCode());
			else
				dao.setConditionCountryCode("=", bean.getCountryCode());
			count++;
		}
		if(bean.getPassport() != null) {
			if(bean.getPassport().indexOf("%") >= 0)
				dao.setConditionPassport("like", bean.getPassport());
			else
				dao.setConditionPassport("=", bean.getPassport());
			count++;
		}
		if(bean.getBankId() != null) {
			dao.setConditionBankId("=", bean.getBankId());
			count++;
		}
		if(bean.getAccountType() != null) {
			dao.setConditionAccountType("=", bean.getAccountType());
			count++;
		}
		if(bean.getIsUse() != null) {
			dao.setConditionIsUse("=", bean.getIsUse());
			count++;
		}
		if(bean.getSupplierId() != null) {
			dao.setConditionSupplierId("=", bean.getSupplierId());
			count++;
		}
		if(bean.getVoucherType() != null) {
			dao.setConditionVoucherType("=", bean.getVoucherType());
			count++;
		}
		if(bean.getFundraisingProjectTypeId() != null) {
			dao.setConditionFundraisingProjectTypeId("=", bean.getFundraisingProjectTypeId());
			count++;
		}
		if(bean.getSupplierType() != null) {
			dao.setConditionSupplierType("=", bean.getSupplierType());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseReceiveUnitManage bean = new BaseReceiveUnitManage();
		bean.setDataFromJSON(json);
		ReceiveUnitManage dao = new ReceiveUnitManage();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseReceiveUnitManage> rlist = new BaseCollection<>();
		BaseReceiveUnitManage bean = new BaseReceiveUnitManage();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ReceiveUnitManage dao = new ReceiveUnitManage();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseReceiveUnitManage> result = dao.conditionalLoad(addtion);
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
		BaseReceiveUnitManage bean = new BaseReceiveUnitManage();
		bean.setDataFromJSON(json);
		ReceiveUnitManage dao = new ReceiveUnitManage();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseReceiveUnitManage bean = new BaseReceiveUnitManage();
		bean.setDataFromJSON(json);
		ReceiveUnitManage dao = new ReceiveUnitManage();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseReceiveUnitManage bean = new BaseReceiveUnitManage();
		bean.setDataFromJSON(json);
		ReceiveUnitManage dao = new ReceiveUnitManage();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseReceiveUnitManage bean = new BaseReceiveUnitManage();
		bean.setDataFromJSON(json);
		ReceiveUnitManage dao = new ReceiveUnitManage();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


