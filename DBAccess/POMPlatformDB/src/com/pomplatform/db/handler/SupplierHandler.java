package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSupplier;
import com.pomplatform.db.dao.Supplier;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SupplierHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SupplierHandler.class);

	public static BaseSupplier getSupplierById( 
		java.lang.Integer supplier_id
	) throws Exception
	{
		Supplier dao = new Supplier();
		dao.setSupplierId(supplier_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSupplierExists( com.pomplatform.db.bean.BaseSupplier bean, String additional ) throws Exception {

		Supplier dao = new Supplier();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSupplier( com.pomplatform.db.bean.BaseSupplier bean, String additional ) throws Exception {

		Supplier dao = new Supplier();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSupplier> querySupplier( com.pomplatform.db.bean.BaseSupplier bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		Supplier dao = new Supplier();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSupplier> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSupplier> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSupplier addToSupplier ( BaseSupplier supplier )  throws Exception {
		return addToSupplier ( supplier , false);
	}

	public static BaseSupplier addToSupplier ( BaseSupplier supplier, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		Supplier dao = new Supplier();
		dao.setDataFromBase(supplier);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSupplier addUpdateSupplier ( BaseSupplier supplier ) throws Exception {
		return addUpdateSupplier ( supplier , false);
	}

	public static BaseSupplier addUpdateSupplier ( BaseSupplier supplier, boolean singleTransaction  ) throws Exception {
		if(supplier.getSupplierId() == null) return addToSupplier(supplier);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		Supplier dao = new Supplier();
		dao.setDataFromBase(supplier);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(supplier); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSupplier ( BaseSupplier bean ) throws Exception {
		Supplier dao = new Supplier();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSupplier updateSupplier ( BaseSupplier supplier ) throws Exception {
		Supplier dao = new Supplier();
		dao.setSupplierId( supplier.getSupplierId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(supplier);
			result = dao.update();
		}
		return result == 1 ? supplier : null ;
	}

	public static BaseSupplier updateSupplierDirect( BaseSupplier supplier ) throws Exception {
		Supplier dao = new Supplier();
		int result = 0;
		dao.setDataFromBase(supplier);
		result = dao.update();
		return result == 1 ? supplier : null ;
	}

	public static int setDeleteConditions(BaseSupplier bean, Supplier dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSupplierId() != null) {
			dao.setConditionSupplierId("=", bean.getSupplierId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getSupplierName() != null) {
				dao.setConditionSupplierName("=", bean.getSupplierName());
				count++;
			}
			if(bean.getSupplierContact() != null) {
				dao.setConditionSupplierContact("=", bean.getSupplierContact());
				count++;
			}
			if(bean.getSupplierPhone() != null) {
				dao.setConditionSupplierPhone("=", bean.getSupplierPhone());
				count++;
			}
			if(bean.getSupplierEmail() != null) {
				dao.setConditionSupplierEmail("=", bean.getSupplierEmail());
				count++;
			}
			if(bean.getSupplierType() != null) {
				dao.setConditionSupplierType("=", bean.getSupplierType());
				count++;
			}
			if(bean.getSupplierMainBusinessType() != null) {
				dao.setConditionSupplierMainBusinessType("=", bean.getSupplierMainBusinessType());
				count++;
			}
			if(bean.getSupplierScopeSupply() != null) {
				dao.setConditionSupplierScopeSupply("=", bean.getSupplierScopeSupply());
				count++;
			}
			if(bean.getSocialCreditCode() != null) {
				dao.setConditionSocialCreditCode("=", bean.getSocialCreditCode());
				count++;
			}
			if(bean.getSupplier_province() != null) {
				dao.setConditionSupplier_province("=", bean.getSupplier_province());
				count++;
			}
			if(bean.getSupplier_city() != null) {
				dao.setConditionSupplier_city("=", bean.getSupplier_city());
				count++;
			}
			if(bean.getSupplierBankAddress() != null) {
				dao.setConditionSupplierBankAddress("=", bean.getSupplierBankAddress());
				count++;
			}
			if(bean.getSupplierAddress() != null) {
				dao.setConditionSupplierAddress("=", bean.getSupplierAddress());
				count++;
			}
			if(bean.getProductionCycle() != null) {
				dao.setConditionProductionCycle("=", bean.getProductionCycle());
				count++;
			}
			if(bean.getLogisticsCycle() != null) {
				dao.setConditionLogisticsCycle("=", bean.getLogisticsCycle());
				count++;
			}
			if(bean.getSupplierBoss() != null) {
				dao.setConditionSupplierBoss("=", bean.getSupplierBoss());
				count++;
			}
			if(bean.getContractScopeTime() != null) {
				dao.setConditionContractScopeTime("=", bean.getContractScopeTime());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
			if(bean.getSupplierOrigin() != null) {
				dao.setConditionSupplierOrigin("=", bean.getSupplierOrigin());
				count++;
			}
			if(bean.getSupplierStatus() != null) {
				dao.setConditionSupplierStatus("=", bean.getSupplierStatus());
				count++;
			}
			if(bean.getIsUse() != null) {
				dao.setConditionIsUse("=", bean.getIsUse());
				count++;
			}
			if(bean.getReceiveUnitManageId() != null) {
				dao.setConditionReceiveUnitManageId("=", bean.getReceiveUnitManageId());
				count++;
			}
			if(bean.getAgreementType() != null) {
				dao.setConditionAgreementType("=", bean.getAgreementType());
				count++;
			}
			if(bean.getAgreementSignAddress() != null) {
				dao.setConditionAgreementSignAddress("=", bean.getAgreementSignAddress());
				count++;
			}
			if(bean.getFileId() != null) {
				dao.setConditionFileId("=", bean.getFileId());
				count++;
			}
			if(bean.getTeamSize() != null) {
				dao.setConditionTeamSize("=", bean.getTeamSize());
				count++;
			}
			if(bean.getAreasExpertise() != null) {
				dao.setConditionAreasExpertise("=", bean.getAreasExpertise());
				count++;
			}
			if(bean.getAttachmentName() != null) {
				dao.setConditionAttachmentName("=", bean.getAttachmentName());
				count++;
			}
			if(bean.getAttachment() != null) {
				dao.setConditionAttachment("=", bean.getAttachment());
				count++;
			}
			if(bean.getCreateEmployeeId() != null) {
				dao.setConditionCreateEmployeeId("=", bean.getCreateEmployeeId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSupplier bean, Supplier dao){
		int count = 0;
		if(bean.getSupplierId() != null) {
			dao.setConditionSupplierId("=", bean.getSupplierId());
			count++;
		}
		if(bean.getSupplierName() != null) {
			if(bean.getSupplierName().indexOf("%") >= 0)
				dao.setConditionSupplierName("like", bean.getSupplierName());
			else
				dao.setConditionSupplierName("=", bean.getSupplierName());
			count++;
		}
		if(bean.getSupplierContact() != null) {
			if(bean.getSupplierContact().indexOf("%") >= 0)
				dao.setConditionSupplierContact("like", bean.getSupplierContact());
			else
				dao.setConditionSupplierContact("=", bean.getSupplierContact());
			count++;
		}
		if(bean.getSupplierPhone() != null) {
			if(bean.getSupplierPhone().indexOf("%") >= 0)
				dao.setConditionSupplierPhone("like", bean.getSupplierPhone());
			else
				dao.setConditionSupplierPhone("=", bean.getSupplierPhone());
			count++;
		}
		if(bean.getSupplierEmail() != null) {
			if(bean.getSupplierEmail().indexOf("%") >= 0)
				dao.setConditionSupplierEmail("like", bean.getSupplierEmail());
			else
				dao.setConditionSupplierEmail("=", bean.getSupplierEmail());
			count++;
		}
		if(bean.getSupplierType() != null) {
			dao.setConditionSupplierType("=", bean.getSupplierType());
			count++;
		}
		if(bean.getSupplierMainBusinessType() != null) {
			dao.setConditionSupplierMainBusinessType("=", bean.getSupplierMainBusinessType());
			count++;
		}
		if(bean.getSupplierScopeSupply() != null) {
			if(bean.getSupplierScopeSupply().indexOf("%") >= 0)
				dao.setConditionSupplierScopeSupply("like", bean.getSupplierScopeSupply());
			else
				dao.setConditionSupplierScopeSupply("=", bean.getSupplierScopeSupply());
			count++;
		}
		if(bean.getSocialCreditCode() != null) {
			if(bean.getSocialCreditCode().indexOf("%") >= 0)
				dao.setConditionSocialCreditCode("like", bean.getSocialCreditCode());
			else
				dao.setConditionSocialCreditCode("=", bean.getSocialCreditCode());
			count++;
		}
		if(bean.getSupplier_province() != null) {
			dao.setConditionSupplier_province("=", bean.getSupplier_province());
			count++;
		}
		if(bean.getSupplier_city() != null) {
			dao.setConditionSupplier_city("=", bean.getSupplier_city());
			count++;
		}
		if(bean.getSupplierBankAddress() != null) {
			if(bean.getSupplierBankAddress().indexOf("%") >= 0)
				dao.setConditionSupplierBankAddress("like", bean.getSupplierBankAddress());
			else
				dao.setConditionSupplierBankAddress("=", bean.getSupplierBankAddress());
			count++;
		}
		if(bean.getSupplierAddress() != null) {
			if(bean.getSupplierAddress().indexOf("%") >= 0)
				dao.setConditionSupplierAddress("like", bean.getSupplierAddress());
			else
				dao.setConditionSupplierAddress("=", bean.getSupplierAddress());
			count++;
		}
		if(bean.getProductionCycle() != null) {
			dao.setConditionProductionCycle("=", bean.getProductionCycle());
			count++;
		}
		if(bean.getLogisticsCycle() != null) {
			dao.setConditionLogisticsCycle("=", bean.getLogisticsCycle());
			count++;
		}
		if(bean.getSupplierBoss() != null) {
			if(bean.getSupplierBoss().indexOf("%") >= 0)
				dao.setConditionSupplierBoss("like", bean.getSupplierBoss());
			else
				dao.setConditionSupplierBoss("=", bean.getSupplierBoss());
			count++;
		}
		if(bean.getContractSigningTime() != null) {
			dao.setConditionContractSigningTime(">=", bean.getContractSigningTime());
			count++;
		}
		if(bean.getContractScopeTime() != null) {
			if(bean.getContractScopeTime().indexOf("%") >= 0)
				dao.setConditionContractScopeTime("like", bean.getContractScopeTime());
			else
				dao.setConditionContractScopeTime("=", bean.getContractScopeTime());
			count++;
		}
		if(bean.getContractScopeTimeStart() != null) {
			dao.setConditionContractScopeTimeStart(">=", bean.getContractScopeTimeStart());
			count++;
		}
		if(bean.getContractScopeTimeEnd() != null) {
			dao.setConditionContractScopeTimeEnd(">=", bean.getContractScopeTimeEnd());
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
		if(bean.getSupplierOrigin() != null) {
			if(bean.getSupplierOrigin().indexOf("%") >= 0)
				dao.setConditionSupplierOrigin("like", bean.getSupplierOrigin());
			else
				dao.setConditionSupplierOrigin("=", bean.getSupplierOrigin());
			count++;
		}
		if(bean.getSupplierStatus() != null) {
			dao.setConditionSupplierStatus("=", bean.getSupplierStatus());
			count++;
		}
		if(bean.getIsUse() != null) {
			dao.setConditionIsUse("=", bean.getIsUse());
			count++;
		}
		if(bean.getReceiveUnitManageId() != null) {
			dao.setConditionReceiveUnitManageId("=", bean.getReceiveUnitManageId());
			count++;
		}
		if(bean.getAgreementType() != null) {
			dao.setConditionAgreementType("=", bean.getAgreementType());
			count++;
		}
		if(bean.getAgreementSignTime() != null) {
			dao.setConditionAgreementSignTime(">=", bean.getAgreementSignTime());
			count++;
		}
		if(bean.getAgreementSignAddress() != null) {
			if(bean.getAgreementSignAddress().indexOf("%") >= 0)
				dao.setConditionAgreementSignAddress("like", bean.getAgreementSignAddress());
			else
				dao.setConditionAgreementSignAddress("=", bean.getAgreementSignAddress());
			count++;
		}
		if(bean.getFileId() != null) {
			dao.setConditionFileId("=", bean.getFileId());
			count++;
		}
		if(bean.getTeamSize() != null) {
			dao.setConditionTeamSize("=", bean.getTeamSize());
			count++;
		}
		if(bean.getAreasExpertise() != null) {
			dao.setConditionAreasExpertise("=", bean.getAreasExpertise());
			count++;
		}
		if(bean.getAttachmentName() != null) {
			if(bean.getAttachmentName().indexOf("%") >= 0)
				dao.setConditionAttachmentName("like", bean.getAttachmentName());
			else
				dao.setConditionAttachmentName("=", bean.getAttachmentName());
			count++;
		}
		if(bean.getAttachment() != null) {
			if(bean.getAttachment().indexOf("%") >= 0)
				dao.setConditionAttachment("like", bean.getAttachment());
			else
				dao.setConditionAttachment("=", bean.getAttachment());
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseSupplier bean = new BaseSupplier();
		bean.setDataFromJSON(json);
		Supplier dao = new Supplier();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSupplier> rlist = new BaseCollection<>();
		BaseSupplier bean = new BaseSupplier();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		Supplier dao = new Supplier();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSupplier> result = dao.conditionalLoad(addtion);
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
		BaseSupplier bean = new BaseSupplier();
		bean.setDataFromJSON(json);
		Supplier dao = new Supplier();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSupplier bean = new BaseSupplier();
		bean.setDataFromJSON(json);
		Supplier dao = new Supplier();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSupplier bean = new BaseSupplier();
		bean.setDataFromJSON(json);
		Supplier dao = new Supplier();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSupplier bean = new BaseSupplier();
		bean.setDataFromJSON(json);
		Supplier dao = new Supplier();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


