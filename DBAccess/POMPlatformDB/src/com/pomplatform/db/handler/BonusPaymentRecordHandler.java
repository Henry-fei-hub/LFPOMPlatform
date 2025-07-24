package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseBonusPaymentRecord;
import com.pomplatform.db.dao.BonusPaymentRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class BonusPaymentRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(BonusPaymentRecordHandler.class);

	public static BaseBonusPaymentRecord getBonusPaymentRecordById( 
		java.lang.Integer bonus_payment_record_id
	) throws Exception
	{
		BonusPaymentRecord dao = new BonusPaymentRecord();
		dao.setBonusPaymentRecordId(bonus_payment_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isBonusPaymentRecordExists( com.pomplatform.db.bean.BaseBonusPaymentRecord bean, String additional ) throws Exception {

		BonusPaymentRecord dao = new BonusPaymentRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countBonusPaymentRecord( com.pomplatform.db.bean.BaseBonusPaymentRecord bean, String additional ) throws Exception {

		BonusPaymentRecord dao = new BonusPaymentRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseBonusPaymentRecord> queryBonusPaymentRecord( com.pomplatform.db.bean.BaseBonusPaymentRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		BonusPaymentRecord dao = new BonusPaymentRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseBonusPaymentRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseBonusPaymentRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseBonusPaymentRecord addToBonusPaymentRecord ( BaseBonusPaymentRecord bonuspaymentrecord )  throws Exception {
		return addToBonusPaymentRecord ( bonuspaymentrecord , false);
	}

	public static BaseBonusPaymentRecord addToBonusPaymentRecord ( BaseBonusPaymentRecord bonuspaymentrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		BonusPaymentRecord dao = new BonusPaymentRecord();
		dao.setDataFromBase(bonuspaymentrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseBonusPaymentRecord addUpdateBonusPaymentRecord ( BaseBonusPaymentRecord bonuspaymentrecord ) throws Exception {
		return addUpdateBonusPaymentRecord ( bonuspaymentrecord , false);
	}

	public static BaseBonusPaymentRecord addUpdateBonusPaymentRecord ( BaseBonusPaymentRecord bonuspaymentrecord, boolean singleTransaction  ) throws Exception {
		if(bonuspaymentrecord.getBonusPaymentRecordId() == null) return addToBonusPaymentRecord(bonuspaymentrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		BonusPaymentRecord dao = new BonusPaymentRecord();
		dao.setDataFromBase(bonuspaymentrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(bonuspaymentrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteBonusPaymentRecord ( BaseBonusPaymentRecord bean ) throws Exception {
		BonusPaymentRecord dao = new BonusPaymentRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseBonusPaymentRecord updateBonusPaymentRecord ( BaseBonusPaymentRecord bonuspaymentrecord ) throws Exception {
		BonusPaymentRecord dao = new BonusPaymentRecord();
		dao.setBonusPaymentRecordId( bonuspaymentrecord.getBonusPaymentRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(bonuspaymentrecord);
			result = dao.update();
		}
		return result == 1 ? bonuspaymentrecord : null ;
	}

	public static BaseBonusPaymentRecord updateBonusPaymentRecordDirect( BaseBonusPaymentRecord bonuspaymentrecord ) throws Exception {
		BonusPaymentRecord dao = new BonusPaymentRecord();
		int result = 0;
		dao.setDataFromBase(bonuspaymentrecord);
		result = dao.update();
		return result == 1 ? bonuspaymentrecord : null ;
	}

	public static int setDeleteConditions(BaseBonusPaymentRecord bean, BonusPaymentRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getBonusPaymentRecordId() != null) {
			dao.setConditionBonusPaymentRecordId("=", bean.getBonusPaymentRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getApplicant() != null) {
				dao.setConditionApplicant("=", bean.getApplicant());
				count++;
			}
			if(bean.getState() != null) {
				dao.setConditionState("=", bean.getState());
				count++;
			}
			if(bean.getAuditor() != null) {
				dao.setConditionAuditor("=", bean.getAuditor());
				count++;
			}
			if(bean.getOpinion() != null) {
				dao.setConditionOpinion("=", bean.getOpinion());
				count++;
			}
			if(bean.getIsLevelTwo() != null) {
				dao.setConditionIsLevelTwo("=", bean.getIsLevelTwo());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseBonusPaymentRecord bean, BonusPaymentRecord dao){
		int count = 0;
		if(bean.getBonusPaymentRecordId() != null) {
			dao.setConditionBonusPaymentRecordId("=", bean.getBonusPaymentRecordId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getPayIntegral() != null) {
			dao.setConditionPayIntegral("=", bean.getPayIntegral());
			count++;
		}
		if(bean.getPayDate() != null) {
			dao.setConditionPayDate(">=", bean.getPayDate());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getApplicant() != null) {
			dao.setConditionApplicant("=", bean.getApplicant());
			count++;
		}
		if(bean.getApplyTime() != null) {
			dao.setConditionApplyTime(">=", bean.getApplyTime());
			count++;
		}
		if(bean.getState() != null) {
			dao.setConditionState("=", bean.getState());
			count++;
		}
		if(bean.getAuditor() != null) {
			dao.setConditionAuditor("=", bean.getAuditor());
			count++;
		}
		if(bean.getAuditingTime() != null) {
			dao.setConditionAuditingTime(">=", bean.getAuditingTime());
			count++;
		}
		if(bean.getOpinion() != null) {
			if(bean.getOpinion().indexOf("%") >= 0)
				dao.setConditionOpinion("like", bean.getOpinion());
			else
				dao.setConditionOpinion("=", bean.getOpinion());
			count++;
		}
		if(bean.getIsLevelTwo() != null) {
			dao.setConditionIsLevelTwo("=", bean.getIsLevelTwo());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseBonusPaymentRecord bean = new BaseBonusPaymentRecord();
		bean.setDataFromJSON(json);
		BonusPaymentRecord dao = new BonusPaymentRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseBonusPaymentRecord> rlist = new BaseCollection<>();
		BaseBonusPaymentRecord bean = new BaseBonusPaymentRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		BonusPaymentRecord dao = new BonusPaymentRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseBonusPaymentRecord> result = dao.conditionalLoad(addtion);
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
		BaseBonusPaymentRecord bean = new BaseBonusPaymentRecord();
		bean.setDataFromJSON(json);
		BonusPaymentRecord dao = new BonusPaymentRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseBonusPaymentRecord bean = new BaseBonusPaymentRecord();
		bean.setDataFromJSON(json);
		BonusPaymentRecord dao = new BonusPaymentRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseBonusPaymentRecord bean = new BaseBonusPaymentRecord();
		bean.setDataFromJSON(json);
		BonusPaymentRecord dao = new BonusPaymentRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseBonusPaymentRecord bean = new BaseBonusPaymentRecord();
		bean.setDataFromJSON(json);
		BonusPaymentRecord dao = new BonusPaymentRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


