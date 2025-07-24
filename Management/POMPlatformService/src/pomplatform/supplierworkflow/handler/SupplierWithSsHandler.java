package pomplatform.supplierworkflow.handler;


import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.TimeSpanCalculator;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.supplierworkflow.bean.BaseSupplierWithSs;
import pomplatform.supplierworkflow.dao.SupplierWithSs;

public class SupplierWithSsHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(SupplierWithSsHandler.class);

	public static BaseSupplierWithSs getSupplierWithSsById( java.lang.Integer supplier_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BaseSupplierWithSs result;
			SupplierWithSs dao = new SupplierWithSs();
			dao.setSupplierId(supplier_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get SupplierWithSs By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isSupplierWithSsExists( pomplatform.supplierworkflow.bean.BaseSupplierWithSs bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			SupplierWithSs dao = new SupplierWithSs();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query SupplierWithSs List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countSupplierWithSs( pomplatform.supplierworkflow.bean.BaseSupplierWithSs bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			SupplierWithSs dao = new SupplierWithSs();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query SupplierWithSs List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BaseSupplierWithSs> querySupplierWithSs( BaseSupplierWithSs bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			SupplierWithSs dao = new SupplierWithSs();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BaseSupplierWithSs> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BaseSupplierWithSs> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query SupplierWithSs List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseSupplierWithSs addToSupplierWithSs ( BaseSupplierWithSs supplierwithss ) {
		return addToSupplierWithSs ( supplierwithss , false);
	}

	public static BaseSupplierWithSs addToSupplierWithSs ( BaseSupplierWithSs supplierwithss, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			SupplierWithSs dao = new SupplierWithSs();
			dao.setDataFromBase(supplierwithss);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to SupplierWithSs time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseSupplierWithSs addUpdateSupplierWithSs ( BaseSupplierWithSs supplierwithss ) {
		return addUpdateSupplierWithSs ( supplierwithss , false);
	}

	public static BaseSupplierWithSs addUpdateSupplierWithSs ( BaseSupplierWithSs supplierwithss, boolean singleTransaction  ) {
		if(supplierwithss.getSupplierId() == null) return addToSupplierWithSs(supplierwithss);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			SupplierWithSs dao = new SupplierWithSs();
			dao.setDataFromBase(supplierwithss);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(supplierwithss); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to SupplierWithSs time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseSupplierWithSs deleteSupplierWithSs ( BaseSupplierWithSs bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			SupplierWithSs dao = new SupplierWithSs();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete SupplierWithSs time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseSupplierWithSs updateSupplierWithSs ( BaseSupplierWithSs supplierwithss ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			SupplierWithSs dao = new SupplierWithSs();
			dao.setSupplierId( supplierwithss.getSupplierId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(supplierwithss);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update SupplierWithSs time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? supplierwithss : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseSupplierWithSs updateSupplierWithSsDirect( BaseSupplierWithSs supplierwithss ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			SupplierWithSs dao = new SupplierWithSs();
			int result = 0;
			dao.setDataFromBase(supplierwithss);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update SupplierWithSs time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? supplierwithss : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BaseSupplierWithSs bean, SupplierWithSs dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSupplierId() != null) {
			dao.setSupplierId(bean.getSupplierId());
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
		}
		return count;
	}

	public static int setConditions(BaseSupplierWithSs bean, SupplierWithSs dao){
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseSupplierWithSs bean = new BaseSupplierWithSs();
		bean.setDataFromJSON(json);
		SupplierWithSs dao = new SupplierWithSs();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSupplierWithSs> rlist = new BaseCollection<>();
		BaseSupplierWithSs bean = new BaseSupplierWithSs();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SupplierWithSs dao = new SupplierWithSs();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSupplierWithSs> result = dao.conditionalLoadExt(addtion);
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
		BaseSupplierWithSs bean = new BaseSupplierWithSs();
		bean.setDataFromJSON(json);
		SupplierWithSs dao = new SupplierWithSs();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSupplierWithSs bean = new BaseSupplierWithSs();
		bean.setDataFromJSON(json);
		int num = 0;
		SupplierWithSs dao = new SupplierWithSs();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSupplierWithSs bean = new BaseSupplierWithSs();
		bean.setDataFromJSON(json);
		SupplierWithSs dao = new SupplierWithSs();
		ThreadConnection.beginTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSupplierWithSs bean = new BaseSupplierWithSs();
		bean.setDataFromJSON(json);
		SupplierWithSs dao = new SupplierWithSs();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

}


