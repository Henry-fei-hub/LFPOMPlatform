package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseFiveInsuranceOneGold;
import com.pomplatform.db.dao.FiveInsuranceOneGold;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class FiveInsuranceOneGoldHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(FiveInsuranceOneGoldHandler.class);

	public static BaseFiveInsuranceOneGold getFiveInsuranceOneGoldById( 
		java.lang.Integer five_insurance_one_gold_id
	) throws Exception
	{
		FiveInsuranceOneGold dao = new FiveInsuranceOneGold();
		dao.setFiveInsuranceOneGoldId(five_insurance_one_gold_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isFiveInsuranceOneGoldExists( com.pomplatform.db.bean.BaseFiveInsuranceOneGold bean, String additional ) throws Exception {

		FiveInsuranceOneGold dao = new FiveInsuranceOneGold();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countFiveInsuranceOneGold( com.pomplatform.db.bean.BaseFiveInsuranceOneGold bean, String additional ) throws Exception {

		FiveInsuranceOneGold dao = new FiveInsuranceOneGold();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseFiveInsuranceOneGold> queryFiveInsuranceOneGold( com.pomplatform.db.bean.BaseFiveInsuranceOneGold bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		FiveInsuranceOneGold dao = new FiveInsuranceOneGold();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseFiveInsuranceOneGold> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseFiveInsuranceOneGold> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseFiveInsuranceOneGold addToFiveInsuranceOneGold ( BaseFiveInsuranceOneGold fiveinsuranceonegold )  throws Exception {
		return addToFiveInsuranceOneGold ( fiveinsuranceonegold , false);
	}

	public static BaseFiveInsuranceOneGold addToFiveInsuranceOneGold ( BaseFiveInsuranceOneGold fiveinsuranceonegold, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		FiveInsuranceOneGold dao = new FiveInsuranceOneGold();
		dao.setDataFromBase(fiveinsuranceonegold);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseFiveInsuranceOneGold addUpdateFiveInsuranceOneGold ( BaseFiveInsuranceOneGold fiveinsuranceonegold ) throws Exception {
		return addUpdateFiveInsuranceOneGold ( fiveinsuranceonegold , false);
	}

	public static BaseFiveInsuranceOneGold addUpdateFiveInsuranceOneGold ( BaseFiveInsuranceOneGold fiveinsuranceonegold, boolean singleTransaction  ) throws Exception {
		if(fiveinsuranceonegold.getFiveInsuranceOneGoldId() == null) return addToFiveInsuranceOneGold(fiveinsuranceonegold);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		FiveInsuranceOneGold dao = new FiveInsuranceOneGold();
		dao.setDataFromBase(fiveinsuranceonegold);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(fiveinsuranceonegold); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteFiveInsuranceOneGold ( BaseFiveInsuranceOneGold bean ) throws Exception {
		FiveInsuranceOneGold dao = new FiveInsuranceOneGold();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseFiveInsuranceOneGold updateFiveInsuranceOneGold ( BaseFiveInsuranceOneGold fiveinsuranceonegold ) throws Exception {
		FiveInsuranceOneGold dao = new FiveInsuranceOneGold();
		dao.setFiveInsuranceOneGoldId( fiveinsuranceonegold.getFiveInsuranceOneGoldId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(fiveinsuranceonegold);
			result = dao.update();
		}
		return result == 1 ? fiveinsuranceonegold : null ;
	}

	public static BaseFiveInsuranceOneGold updateFiveInsuranceOneGoldDirect( BaseFiveInsuranceOneGold fiveinsuranceonegold ) throws Exception {
		FiveInsuranceOneGold dao = new FiveInsuranceOneGold();
		int result = 0;
		dao.setDataFromBase(fiveinsuranceonegold);
		result = dao.update();
		return result == 1 ? fiveinsuranceonegold : null ;
	}

	public static int setDeleteConditions(BaseFiveInsuranceOneGold bean, FiveInsuranceOneGold dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getFiveInsuranceOneGoldId() != null) {
			dao.setConditionFiveInsuranceOneGoldId("=", bean.getFiveInsuranceOneGoldId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
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
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
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
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseFiveInsuranceOneGold bean, FiveInsuranceOneGold dao){
		int count = 0;
		if(bean.getFiveInsuranceOneGoldId() != null) {
			dao.setConditionFiveInsuranceOneGoldId("=", bean.getFiveInsuranceOneGoldId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
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
		if(bean.getTotalFund() != null) {
			dao.setConditionTotalFund("=", bean.getTotalFund());
			count++;
		}
		if(bean.getUnitTotalFund() != null) {
			dao.setConditionUnitTotalFund("=", bean.getUnitTotalFund());
			count++;
		}
		if(bean.getPersonalTotalFund() != null) {
			dao.setConditionPersonalTotalFund("=", bean.getPersonalTotalFund());
			count++;
		}
		if(bean.getTotalInsurance() != null) {
			dao.setConditionTotalInsurance("=", bean.getTotalInsurance());
			count++;
		}
		if(bean.getUnitTotalInsurance() != null) {
			dao.setConditionUnitTotalInsurance("=", bean.getUnitTotalInsurance());
			count++;
		}
		if(bean.getPersonalTotalInsurance() != null) {
			dao.setConditionPersonalTotalInsurance("=", bean.getPersonalTotalInsurance());
			count++;
		}
		if(bean.getUnitPension() != null) {
			dao.setConditionUnitPension("=", bean.getUnitPension());
			count++;
		}
		if(bean.getUnitMedicalInsurance() != null) {
			dao.setConditionUnitMedicalInsurance("=", bean.getUnitMedicalInsurance());
			count++;
		}
		if(bean.getUnitLargeMedicalInsurance() != null) {
			dao.setConditionUnitLargeMedicalInsurance("=", bean.getUnitLargeMedicalInsurance());
			count++;
		}
		if(bean.getUnitInjuryInsurance() != null) {
			dao.setConditionUnitInjuryInsurance("=", bean.getUnitInjuryInsurance());
			count++;
		}
		if(bean.getUnitUnemploymentInsurance() != null) {
			dao.setConditionUnitUnemploymentInsurance("=", bean.getUnitUnemploymentInsurance());
			count++;
		}
		if(bean.getUnitGiveBirthInsurance() != null) {
			dao.setConditionUnitGiveBirthInsurance("=", bean.getUnitGiveBirthInsurance());
			count++;
		}
		if(bean.getPersonalPension() != null) {
			dao.setConditionPersonalPension("=", bean.getPersonalPension());
			count++;
		}
		if(bean.getPersonalMedicalInsurance() != null) {
			dao.setConditionPersonalMedicalInsurance("=", bean.getPersonalMedicalInsurance());
			count++;
		}
		if(bean.getPersonalLargeMedicalInsurance() != null) {
			dao.setConditionPersonalLargeMedicalInsurance("=", bean.getPersonalLargeMedicalInsurance());
			count++;
		}
		if(bean.getPersonalSeriousIllInsurance() != null) {
			dao.setConditionPersonalSeriousIllInsurance("=", bean.getPersonalSeriousIllInsurance());
			count++;
		}
		if(bean.getPersonalUnemploymentInsurance() != null) {
			dao.setConditionPersonalUnemploymentInsurance("=", bean.getPersonalUnemploymentInsurance());
			count++;
		}
		if(bean.getPersonalHeating() != null) {
			dao.setConditionPersonalHeating("=", bean.getPersonalHeating());
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
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
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
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getUnitDisabilityInsurance() != null) {
			dao.setConditionUnitDisabilityInsurance("=", bean.getUnitDisabilityInsurance());
			count++;
		}
		if(bean.getAccumulationFundGolePaymentBase() != null) {
			dao.setConditionAccumulationFundGolePaymentBase("=", bean.getAccumulationFundGolePaymentBase());
			count++;
		}
		if(bean.getAccumulationFundGoleCompanyPaymentRatio() != null) {
			dao.setConditionAccumulationFundGoleCompanyPaymentRatio("=", bean.getAccumulationFundGoleCompanyPaymentRatio());
			count++;
		}
		if(bean.getAccumulationFundGoleIndividualPaymentRatio() != null) {
			dao.setConditionAccumulationFundGoleIndividualPaymentRatio("=", bean.getAccumulationFundGoleIndividualPaymentRatio());
			count++;
		}
		if(bean.getUnitPensionPaymentBase() != null) {
			dao.setConditionUnitPensionPaymentBase("=", bean.getUnitPensionPaymentBase());
			count++;
		}
		if(bean.getUnitPensionPaymentRatio() != null) {
			dao.setConditionUnitPensionPaymentRatio("=", bean.getUnitPensionPaymentRatio());
			count++;
		}
		if(bean.getUnitMedicalInsurancePaymentBase() != null) {
			dao.setConditionUnitMedicalInsurancePaymentBase("=", bean.getUnitMedicalInsurancePaymentBase());
			count++;
		}
		if(bean.getUnitMedicalInsurancePaymentRatio() != null) {
			dao.setConditionUnitMedicalInsurancePaymentRatio("=", bean.getUnitMedicalInsurancePaymentRatio());
			count++;
		}
		if(bean.getUnitInjuryInsuranceBase() != null) {
			dao.setConditionUnitInjuryInsuranceBase("=", bean.getUnitInjuryInsuranceBase());
			count++;
		}
		if(bean.getUnitInjuryInsuranceRatio() != null) {
			dao.setConditionUnitInjuryInsuranceRatio("=", bean.getUnitInjuryInsuranceRatio());
			count++;
		}
		if(bean.getUnitUnemploymentInsurancePaymentBase() != null) {
			dao.setConditionUnitUnemploymentInsurancePaymentBase("=", bean.getUnitUnemploymentInsurancePaymentBase());
			count++;
		}
		if(bean.getUnitUnemploymentInsurancePaymentRatio() != null) {
			dao.setConditionUnitUnemploymentInsurancePaymentRatio("=", bean.getUnitUnemploymentInsurancePaymentRatio());
			count++;
		}
		if(bean.getUnitGiveBirthInsurancePaymentBase() != null) {
			dao.setConditionUnitGiveBirthInsurancePaymentBase("=", bean.getUnitGiveBirthInsurancePaymentBase());
			count++;
		}
		if(bean.getUnitGiveBirthInsurancePaymentRatio() != null) {
			dao.setConditionUnitGiveBirthInsurancePaymentRatio("=", bean.getUnitGiveBirthInsurancePaymentRatio());
			count++;
		}
		if(bean.getPersonalPensionPaymentRatio() != null) {
			dao.setConditionPersonalPensionPaymentRatio("=", bean.getPersonalPensionPaymentRatio());
			count++;
		}
		if(bean.getPersonalMedicalInsurancePaymentRatio() != null) {
			dao.setConditionPersonalMedicalInsurancePaymentRatio("=", bean.getPersonalMedicalInsurancePaymentRatio());
			count++;
		}
		if(bean.getPersonalUnemploymentInsurancePaymentRatio() != null) {
			dao.setConditionPersonalUnemploymentInsurancePaymentRatio("=", bean.getPersonalUnemploymentInsurancePaymentRatio());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseFiveInsuranceOneGold bean = new BaseFiveInsuranceOneGold();
		bean.setDataFromJSON(json);
		FiveInsuranceOneGold dao = new FiveInsuranceOneGold();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseFiveInsuranceOneGold> rlist = new BaseCollection<>();
		BaseFiveInsuranceOneGold bean = new BaseFiveInsuranceOneGold();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		FiveInsuranceOneGold dao = new FiveInsuranceOneGold();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseFiveInsuranceOneGold> result = dao.conditionalLoad(addtion);
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
		BaseFiveInsuranceOneGold bean = new BaseFiveInsuranceOneGold();
		bean.setDataFromJSON(json);
		FiveInsuranceOneGold dao = new FiveInsuranceOneGold();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseFiveInsuranceOneGold bean = new BaseFiveInsuranceOneGold();
		bean.setDataFromJSON(json);
		FiveInsuranceOneGold dao = new FiveInsuranceOneGold();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseFiveInsuranceOneGold bean = new BaseFiveInsuranceOneGold();
		bean.setDataFromJSON(json);
		FiveInsuranceOneGold dao = new FiveInsuranceOneGold();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseFiveInsuranceOneGold bean = new BaseFiveInsuranceOneGold();
		bean.setDataFromJSON(json);
		FiveInsuranceOneGold dao = new FiveInsuranceOneGold();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


