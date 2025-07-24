package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseContractCommissionDetail;
import com.pomplatform.db.dao.ContractCommissionDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ContractCommissionDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ContractCommissionDetailHandler.class);

	public static BaseContractCommissionDetail getContractCommissionDetailById( 
		java.lang.Integer contract_commission_detail_id
	) throws Exception
	{
		ContractCommissionDetail dao = new ContractCommissionDetail();
		dao.setContractCommissionDetailId(contract_commission_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isContractCommissionDetailExists( com.pomplatform.db.bean.BaseContractCommissionDetail bean, String additional ) throws Exception {

		ContractCommissionDetail dao = new ContractCommissionDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countContractCommissionDetail( com.pomplatform.db.bean.BaseContractCommissionDetail bean, String additional ) throws Exception {

		ContractCommissionDetail dao = new ContractCommissionDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseContractCommissionDetail> queryContractCommissionDetail( com.pomplatform.db.bean.BaseContractCommissionDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ContractCommissionDetail dao = new ContractCommissionDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseContractCommissionDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseContractCommissionDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseContractCommissionDetail addToContractCommissionDetail ( BaseContractCommissionDetail contractcommissiondetail )  throws Exception {
		return addToContractCommissionDetail ( contractcommissiondetail , false);
	}

	public static BaseContractCommissionDetail addToContractCommissionDetail ( BaseContractCommissionDetail contractcommissiondetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ContractCommissionDetail dao = new ContractCommissionDetail();
		dao.setDataFromBase(contractcommissiondetail);
		int result = dao.save(false);
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseContractCommissionDetail addUpdateContractCommissionDetail ( BaseContractCommissionDetail contractcommissiondetail ) throws Exception {
		return addUpdateContractCommissionDetail ( contractcommissiondetail , false);
	}

	public static BaseContractCommissionDetail addUpdateContractCommissionDetail ( BaseContractCommissionDetail contractcommissiondetail, boolean singleTransaction  ) throws Exception {
		if(contractcommissiondetail.getContractCommissionDetailId() == null) return addToContractCommissionDetail(contractcommissiondetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ContractCommissionDetail dao = new ContractCommissionDetail();
		dao.setDataFromBase(contractcommissiondetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(contractcommissiondetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save(false);
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteContractCommissionDetail ( BaseContractCommissionDetail bean ) throws Exception {
		ContractCommissionDetail dao = new ContractCommissionDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseContractCommissionDetail updateContractCommissionDetail ( BaseContractCommissionDetail contractcommissiondetail ) throws Exception {
		ContractCommissionDetail dao = new ContractCommissionDetail();
		dao.setContractCommissionDetailId( contractcommissiondetail.getContractCommissionDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(contractcommissiondetail);
			result = dao.update();
		}
		return result == 1 ? contractcommissiondetail : null ;
	}

	public static BaseContractCommissionDetail updateContractCommissionDetailDirect( BaseContractCommissionDetail contractcommissiondetail ) throws Exception {
		ContractCommissionDetail dao = new ContractCommissionDetail();
		int result = 0;
		dao.setDataFromBase(contractcommissiondetail);
		result = dao.update();
		return result == 1 ? contractcommissiondetail : null ;
	}

	public static int setDeleteConditions(BaseContractCommissionDetail bean, ContractCommissionDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getContractCommissionDetailId() != null) {
			dao.setConditionContractCommissionDetailId("=", bean.getContractCommissionDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractCode() != null) {
				dao.setConditionContractCode("=", bean.getContractCode());
				count++;
			}
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getYear() != null) {
				dao.setConditionYear("=", bean.getYear());
				count++;
			}
			if(bean.getMonth() != null) {
				dao.setConditionMonth("=", bean.getMonth());
				count++;
			}
			if(bean.getContractName() != null) {
				dao.setConditionContractName("=", bean.getContractName());
				count++;
			}
			if(bean.getBillingRatio() != null) {
				dao.setConditionBillingRatio("=", bean.getBillingRatio());
				count++;
			}
			if(bean.getIsOriginal() != null) {
				dao.setConditionIsOriginal("=", bean.getIsOriginal());
				count++;
			}
			if(bean.getIsSubProject() != null) {
				dao.setConditionIsSubProject("=", bean.getIsSubProject());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseContractCommissionDetail bean, ContractCommissionDetail dao){
		int count = 0;
		if(bean.getContractCommissionDetailId() != null) {
			dao.setConditionContractCommissionDetailId("=", bean.getContractCommissionDetailId());
			count++;
		}
		if(bean.getContractCode() != null) {
			if(bean.getContractCode().indexOf("%") >= 0)
				dao.setConditionContractCode("like", bean.getContractCode());
			else
				dao.setConditionContractCode("=", bean.getContractCode());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getYear() != null) {
			dao.setConditionYear("=", bean.getYear());
			count++;
		}
		if(bean.getMonth() != null) {
			dao.setConditionMonth("=", bean.getMonth());
			count++;
		}
		if(bean.getRate() != null) {
			dao.setConditionRate("=", bean.getRate());
			count++;
		}
		if(bean.getContractName() != null) {
			if(bean.getContractName().indexOf("%") >= 0)
				dao.setConditionContractName("like", bean.getContractName());
			else
				dao.setConditionContractName("=", bean.getContractName());
			count++;
		}
		if(bean.getBillingRatio() != null) {
			if(bean.getBillingRatio().indexOf("%") >= 0)
				dao.setConditionBillingRatio("like", bean.getBillingRatio());
			else
				dao.setConditionBillingRatio("=", bean.getBillingRatio());
			count++;
		}
		if(bean.getAmount() != null) {
			dao.setConditionAmount("=", bean.getAmount());
			count++;
		}
		if(bean.getIsOriginal() != null) {
			dao.setConditionIsOriginal("=", bean.getIsOriginal());
			count++;
		}
		if(bean.getIsSubProject() != null) {
			dao.setConditionIsSubProject("=", bean.getIsSubProject());
			count++;
		}
		if(bean.getTotalRate() != null) {
			dao.setConditionTotalRate("=", bean.getTotalRate());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseContractCommissionDetail bean = new BaseContractCommissionDetail();
		bean.setDataFromJSON(json);
		ContractCommissionDetail dao = new ContractCommissionDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseContractCommissionDetail> rlist = new BaseCollection<>();
		BaseContractCommissionDetail bean = new BaseContractCommissionDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ContractCommissionDetail dao = new ContractCommissionDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseContractCommissionDetail> result = dao.conditionalLoad(addtion);
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
		BaseContractCommissionDetail bean = new BaseContractCommissionDetail();
		bean.setDataFromJSON(json);
		ContractCommissionDetail dao = new ContractCommissionDetail();
		dao.setDataFromBase(bean);
		int num = dao.save(false);
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseContractCommissionDetail bean = new BaseContractCommissionDetail();
		bean.setDataFromJSON(json);
		ContractCommissionDetail dao = new ContractCommissionDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseContractCommissionDetail bean = new BaseContractCommissionDetail();
		bean.setDataFromJSON(json);
		ContractCommissionDetail dao = new ContractCommissionDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseContractCommissionDetail bean = new BaseContractCommissionDetail();
		bean.setDataFromJSON(json);
		ContractCommissionDetail dao = new ContractCommissionDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(false); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


