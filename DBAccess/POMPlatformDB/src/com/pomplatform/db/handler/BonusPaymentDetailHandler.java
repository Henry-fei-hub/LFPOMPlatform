package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseBonusPaymentDetail;
import com.pomplatform.db.dao.BonusPaymentDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class BonusPaymentDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(BonusPaymentDetailHandler.class);

	public static BaseBonusPaymentDetail getBonusPaymentDetailById( 
		java.lang.Integer bonus_payment_detail_id
	) throws Exception
	{
		BonusPaymentDetail dao = new BonusPaymentDetail();
		dao.setBonusPaymentDetailId(bonus_payment_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isBonusPaymentDetailExists( com.pomplatform.db.bean.BaseBonusPaymentDetail bean, String additional ) throws Exception {

		BonusPaymentDetail dao = new BonusPaymentDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countBonusPaymentDetail( com.pomplatform.db.bean.BaseBonusPaymentDetail bean, String additional ) throws Exception {

		BonusPaymentDetail dao = new BonusPaymentDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseBonusPaymentDetail> queryBonusPaymentDetail( com.pomplatform.db.bean.BaseBonusPaymentDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		BonusPaymentDetail dao = new BonusPaymentDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseBonusPaymentDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseBonusPaymentDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseBonusPaymentDetail addToBonusPaymentDetail ( BaseBonusPaymentDetail bonuspaymentdetail )  throws Exception {
		return addToBonusPaymentDetail ( bonuspaymentdetail , false);
	}

	public static BaseBonusPaymentDetail addToBonusPaymentDetail ( BaseBonusPaymentDetail bonuspaymentdetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		BonusPaymentDetail dao = new BonusPaymentDetail();
		dao.setDataFromBase(bonuspaymentdetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseBonusPaymentDetail addUpdateBonusPaymentDetail ( BaseBonusPaymentDetail bonuspaymentdetail ) throws Exception {
		return addUpdateBonusPaymentDetail ( bonuspaymentdetail , false);
	}

	public static BaseBonusPaymentDetail addUpdateBonusPaymentDetail ( BaseBonusPaymentDetail bonuspaymentdetail, boolean singleTransaction  ) throws Exception {
		if(bonuspaymentdetail.getBonusPaymentDetailId() == null) return addToBonusPaymentDetail(bonuspaymentdetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		BonusPaymentDetail dao = new BonusPaymentDetail();
		dao.setDataFromBase(bonuspaymentdetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(bonuspaymentdetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteBonusPaymentDetail ( BaseBonusPaymentDetail bean ) throws Exception {
		BonusPaymentDetail dao = new BonusPaymentDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseBonusPaymentDetail updateBonusPaymentDetail ( BaseBonusPaymentDetail bonuspaymentdetail ) throws Exception {
		BonusPaymentDetail dao = new BonusPaymentDetail();
		dao.setBonusPaymentDetailId( bonuspaymentdetail.getBonusPaymentDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(bonuspaymentdetail);
			result = dao.update();
		}
		return result == 1 ? bonuspaymentdetail : null ;
	}

	public static BaseBonusPaymentDetail updateBonusPaymentDetailDirect( BaseBonusPaymentDetail bonuspaymentdetail ) throws Exception {
		BonusPaymentDetail dao = new BonusPaymentDetail();
		int result = 0;
		dao.setDataFromBase(bonuspaymentdetail);
		result = dao.update();
		return result == 1 ? bonuspaymentdetail : null ;
	}

	public static int setDeleteConditions(BaseBonusPaymentDetail bean, BonusPaymentDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getBonusPaymentDetailId() != null) {
			dao.setConditionBonusPaymentDetailId("=", bean.getBonusPaymentDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getBonusPaymentRecordId() != null) {
				dao.setConditionBonusPaymentRecordId("=", bean.getBonusPaymentRecordId());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getEmployeeNo() != null) {
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
				count++;
			}
			if(bean.getEmployeeName() != null) {
				dao.setConditionEmployeeName("=", bean.getEmployeeName());
				count++;
			}
			if(bean.getState() != null) {
				dao.setConditionState("=", bean.getState());
				count++;
			}
			if(bean.getIsReturn() != null) {
				dao.setConditionIsReturn("=", bean.getIsReturn());
				count++;
			}
			if(bean.getIsLevelTwo() != null) {
				dao.setConditionIsLevelTwo("=", bean.getIsLevelTwo());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getSendNumber() != null) {
				dao.setConditionSendNumber("=", bean.getSendNumber());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseBonusPaymentDetail bean, BonusPaymentDetail dao){
		int count = 0;
		if(bean.getBonusPaymentDetailId() != null) {
			dao.setConditionBonusPaymentDetailId("=", bean.getBonusPaymentDetailId());
			count++;
		}
		if(bean.getBonusPaymentRecordId() != null) {
			dao.setConditionBonusPaymentRecordId("=", bean.getBonusPaymentRecordId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getEmployeeNo() != null) {
			if(bean.getEmployeeNo().indexOf("%") >= 0)
				dao.setConditionEmployeeNo("like", bean.getEmployeeNo());
			else
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
			count++;
		}
		if(bean.getEmployeeName() != null) {
			if(bean.getEmployeeName().indexOf("%") >= 0)
				dao.setConditionEmployeeName("like", bean.getEmployeeName());
			else
				dao.setConditionEmployeeName("=", bean.getEmployeeName());
			count++;
		}
		if(bean.getAchieveIntegral() != null) {
			dao.setConditionAchieveIntegral("=", bean.getAchieveIntegral());
			count++;
		}
		if(bean.getPayPercent() != null) {
			dao.setConditionPayPercent("=", bean.getPayPercent());
			count++;
		}
		if(bean.getPayIntegral() != null) {
			dao.setConditionPayIntegral("=", bean.getPayIntegral());
			count++;
		}
		if(bean.getLeftIntegral() != null) {
			dao.setConditionLeftIntegral("=", bean.getLeftIntegral());
			count++;
		}
		if(bean.getPayDate() != null) {
			dao.setConditionPayDate(">=", bean.getPayDate());
			count++;
		}
		if(bean.getState() != null) {
			dao.setConditionState("=", bean.getState());
			count++;
		}
		if(bean.getIsReturn() != null) {
			dao.setConditionIsReturn("=", bean.getIsReturn());
			count++;
		}
		if(bean.getIsLevelTwo() != null) {
			dao.setConditionIsLevelTwo("=", bean.getIsLevelTwo());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getFirstIntegral() != null) {
			dao.setConditionFirstIntegral("=", bean.getFirstIntegral());
			count++;
		}
		if(bean.getSecondIntegral() != null) {
			dao.setConditionSecondIntegral("=", bean.getSecondIntegral());
			count++;
		}
		if(bean.getThirdIntegral() != null) {
			dao.setConditionThirdIntegral("=", bean.getThirdIntegral());
			count++;
		}
		if(bean.getSendNumber() != null) {
			dao.setConditionSendNumber("=", bean.getSendNumber());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseBonusPaymentDetail bean = new BaseBonusPaymentDetail();
		bean.setDataFromJSON(json);
		BonusPaymentDetail dao = new BonusPaymentDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseBonusPaymentDetail> rlist = new BaseCollection<>();
		BaseBonusPaymentDetail bean = new BaseBonusPaymentDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		BonusPaymentDetail dao = new BonusPaymentDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseBonusPaymentDetail> result = dao.conditionalLoad(addtion);
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
		BaseBonusPaymentDetail bean = new BaseBonusPaymentDetail();
		bean.setDataFromJSON(json);
		BonusPaymentDetail dao = new BonusPaymentDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseBonusPaymentDetail bean = new BaseBonusPaymentDetail();
		bean.setDataFromJSON(json);
		BonusPaymentDetail dao = new BonusPaymentDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseBonusPaymentDetail bean = new BaseBonusPaymentDetail();
		bean.setDataFromJSON(json);
		BonusPaymentDetail dao = new BonusPaymentDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseBonusPaymentDetail bean = new BaseBonusPaymentDetail();
		bean.setDataFromJSON(json);
		BonusPaymentDetail dao = new BonusPaymentDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


