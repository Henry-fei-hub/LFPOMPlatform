package pomplatform.bonusPayment.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseBonusPaymentRecord;
import com.pomplatform.db.bean.BasePlateRecord;
import com.pomplatform.db.bean.BaseSalaryOfBonus;
import com.pomplatform.db.dao.BonusPaymentDetail;
import com.pomplatform.db.dao.BonusPaymentRecord;
import com.pomplatform.db.dao.PlateRecord;
import com.pomplatform.db.dao.SalaryOfBonus;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.bonusPayment.bean.BaseBonusPaymentDetail;
import pomplatform.bonusPayment.bean.BaseLoadEmployeeForSendBonus;
import pomplatform.bonusPayment.bean.BaseLoadEmployeeForSendBonusTwo;
import pomplatform.bonusPayment.bean.BasePrepareBonusPaymentApplyInfo;
import pomplatform.bonusPayment.bean.ConditionLoadEmployeeForSendBonus;
import pomplatform.bonusPayment.bean.ConditionLoadEmployeeForSendBonusTwo;
import pomplatform.bonusPayment.bean.ConditionPrepareBonusPaymentApplyInfo;
import pomplatform.bonusPayment.query.QueryLoadEmployeeForSendBonus;
import pomplatform.bonusPayment.query.QueryLoadEmployeeForSendBonusTwo;
import pomplatform.bonusPayment.query.QueryPrepareBonusPaymentApplyInfo;
import pomplatform.common.utils.StaticUtils;
import pomplatform.projectCost.bean.BaseGetUnsettledProjectCost;
import pomplatform.projectCost.bean.ConditionGetUnsettledProjectCost;
import pomplatform.projectCost.query.QueryGetUnsettledProjectCost;

public class BonusPaymentProcessor implements GenericProcessor {

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		BaseCollection<BaseBonusPaymentDetail> bc = new BaseCollection<>();
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			JSON parser = new JSON(new StringReader(creteria));
			Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
			String opt_type = BaseHelpUtils.getString(params.get("opt_type"));
			switch (opt_type) {
			case "prepareApplyInfo":
				return prepareApplyInfo(params);
			case "apply":// 奖金发放申请
				return apply(params);
			case "prepareAuditInfo":// 查询奖金发放审核信息
				return prepareAuditInfo(params);
			case "agreeApply":
				return agreeApply(params);
			case "disagreeApply":
				return disagreeApply(params);
			case "applyEmployees":
				return applyEmployees(params);
			case "applyEmployeeData":
				return applyEmployeeData(params);
			case "findPlateLevel":
				return findPlateLevel(params);
			case "updateSetData":
				return updateSetData(params);
			case "updataFlag":
				return updataFlag(params);
			default:
				return bc.toJSON(-1, null);
			}
		}
		return bc.toJSON(-1, null);
	}

	/**
	 * 
	 * @param params
	 * @return
	 * @throws SQLException 
	 */
	private String findPlateLevel(Map<String, Object> params) throws SQLException {
		String arr = BaseHelpUtils.getString(params.get("arr"));
		String[] plates = arr.split(",");
		PlateRecord dao = new PlateRecord();
		BasePlateRecord bean = new BasePlateRecord();
		List<BasePlateRecord> result = new ArrayList<>();
		List<BasePlateRecord> result2 = new ArrayList<>();
		BaseCollection<BasePlateRecord> bc = new BaseCollection<>();
		for(int i = 0;i < plates.length;i++){
			dao.clear();
			dao.setConditionPlateId("=", BaseHelpUtils.getIntValue(plates[i]));
			dao.setConditionPlateType("=", 3);
			bean = dao.executeQueryOneRow();
			if(!BaseHelpUtils.isNullOrEmpty(bean)){
				int parentId = bean.getParentId();
				if(parentId == 0){
					result.add(bean);
				}else{
					result2.add(bean);
				}
			}
		}
		if(!BaseHelpUtils.isNullOrEmpty(result)){
			bc.setCollections(result);
			return bc.toJSON(0,"");
		}else{
			bc.setCollections(result2);
			return bc.toJSON(0,"");
		}
	}

	/**
	 *  保存本次奖金发放的总记录以及本次奖金发放所涉及到的每一个员工的奖金发放详情
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public String applyEmployeeData(Map<String, Object> params) throws Exception {
		BaseCollection<BaseBonusPaymentDetail> bc = new BaseCollection<>();
		ThreadConnection.beginTransaction();
		BonusPaymentRecord recordDao = new BonusPaymentRecord();
		//查看该部门是否有未审核的申请，如有，则不能再提出申请
		recordDao.setConditionState("=", StaticUtils.BONUS_PAYMENT_NO_DEAL);
		recordDao.setConditionPlateId("=", BaseHelpUtils.getIntValue(params.get("plateId")));
		if (recordDao.countRows() == 0) {
			Date date = new Date();
			//奖金发放申请记录表
			BaseBonusPaymentRecord bean = new BaseBonusPaymentRecord();
			bean.setDataFromMap(params);
			//该季度最后一天
			Date lastDate = DateUtil.getLastDay(bean.getPayDate());
			bean.setPayDate(lastDate);
			recordDao.clear();
			recordDao.setDataFromBase(bean);
			recordDao.setApplyTime(date);
			recordDao.save();
			//获取发放奖金的人员及发放奖金
			List<com.pomplatform.db.bean.BaseBonusPaymentDetail> list = GenericBase.__getList(
					params.get("bonusPaymentDetails"), com.pomplatform.db.bean.BaseBonusPaymentDetail.newInstance());
			int recordId = recordDao.getBonusPaymentRecordId();
			if (!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0) {
				List<com.pomplatform.db.bean.BaseBonusPaymentDetail> saveList = new ArrayList<>(); 
				for (com.pomplatform.db.bean.BaseBonusPaymentDetail obj : list) {
					BigDecimal payIntegral = BaseHelpUtils.getBigDecimalValue(obj.getPayIntegral());
					if(payIntegral.compareTo(BigDecimal.ZERO) > 0){
						obj.setBonusPaymentRecordId(recordId);
						obj.setPayDate(lastDate);
						saveList.add(obj);
					}
				}
				BonusPaymentDetail detailDao = new BonusPaymentDetail();
				detailDao.save(saveList);
			}
			ThreadConnection.commit();
			return bc.toJSON();
		} else {
			return bc.toJSON(-1, "请不要重复提交奖金发放申请信息");
		}
	}
	
	
	/**
	 * 查找该季度可发奖金的人员
	 * @param params
	 * @return
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	private String applyEmployees(Map<String, Object> params) throws SQLException, ParseException{
		//获取业务部门
		int plateId = BaseHelpUtils.getIntValue(params.get("plateId"));
		//获取日期 
		Date date = GenericBase.__getDate(params.get("payDate"));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 2);
		//获取该季度第一天
		Date startDate = DateUtil.getFirstDay(calendar.getTime());
		//获取该季度的最后一天
		Date endDate = DateUtil.getLastDay(date);
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		
		BonusPaymentRecord dao = new BonusPaymentRecord();
		dao.setConditionPlateId("=", plateId);
		dao.setConditionState("=", StaticUtils.BONUS_PAYMENT_NO_DEAL);
		if(dao.countRows() > 0){
			return bc.toJSON(-2, "有未审核的申请待处理，请审核后再进行申请");
		}
		dao.clear();
		dao.setConditionPayDate("=",endDate);
		dao.setConditionPlateId("=", plateId);
		if(dao.countRows() > 0){
			return bc.toJSON(-5, "该季度已申请过奖金发放，无法再次申请");
		}
		
		PlateRecord pdao = new PlateRecord();
		pdao.setConditionPlateId("=", plateId);
		BasePlateRecord pList = pdao.executeQueryOneRow();
		if(!BaseHelpUtils.isNullOrEmpty(pList)){
			int parentId = pList.getParentId();
			//判断是否一级部门在申请奖金发放，如果是，则加载已提交的二级部门的申请
			if(parentId == 0){
				QueryLoadEmployeeForSendBonusTwo q = new QueryLoadEmployeeForSendBonusTwo();
				ConditionLoadEmployeeForSendBonusTwo c = new ConditionLoadEmployeeForSendBonusTwo();
				c.setPlateId(plateId);
				c.setState(0);
				c.setPayDate(endDate);
				BaseCollection<BaseLoadEmployeeForSendBonusTwo> pbean = q.executeQuery(null, c);
				if(!BaseHelpUtils.isNullOrEmpty(pbean) && pbean.getCollections().size() > 0){
					Map<Integer,BigDecimal> integralMap = new HashMap<>();
					//加载该部门下的二级部门的部门实时余额 
					pdao.clear();
					pdao.setConditionParentId("=",plateId);
					List<BasePlateRecord> integralList = pdao.conditionalLoad();
					List<Map<Integer,BigDecimal>> integralLists = new ArrayList<>();
					if(!BaseHelpUtils.isNullOrEmpty(integralList) && integralList.size() > 0){
						for(BasePlateRecord iObj : integralList){
							AccountManageProcess process = new AccountManageProcess();
							integralMap = process.getLeftIntegralOfPlate(iObj.getPlateId());
							integralLists.add(integralMap);
						}
					}
					integralMap = new HashMap<>();
					Map<Integer,BigDecimal> listMap = new HashMap<>();
					for(int i = 0;i < integralLists.size();i++){
						listMap = integralLists.get(i);
						integralMap.putAll(listMap);
					}
					pbean.setUserData(integralMap);
					return pbean.toJSON(0,null);
				}else{
					return bc.toJSON(-3, "该季度尚未有部门提交奖金发放申请");
				}
			}else{//二级部门加载可发放奖金的人员
				QueryLoadEmployeeForSendBonus query = new QueryLoadEmployeeForSendBonus();
				ConditionLoadEmployeeForSendBonus condition = new ConditionLoadEmployeeForSendBonus();
				condition.setPlateId(plateId);
				condition.setStartDate(startDate);
				BaseCollection<BaseLoadEmployeeForSendBonus> list = query.executeQuery(null, condition);
				if(!BaseHelpUtils.isNullOrEmpty(list)){
					return list.toJSON(0,null);
				}else{
					return list.toJSON(-1,"该业务部门在该季度没有可发放奖金的人员");
				}
			}
		}else{
			return bc.toJSON(-4, "找不到该部门"); 
		}
	}


	public String prepareApplyInfo(Map<String, Object> params) throws Exception {
		BaseCollection<BaseBonusPaymentDetail> bc = new BaseCollection<>();
		int plateId = BaseHelpUtils.getIntValue(params.get("plateId"));
		if(plateId <= 0) {
			throw new SQLException("加载异常：获取业务部门失败");
		}
		// 判断该业务部门是否有未处理的奖金发放记录，如果有，则不加载数据
		BonusPaymentRecord dao = new BonusPaymentRecord();
		dao.setConditionState("=", StaticUtils.BONUS_PAYMENT_NO_DEAL);
		dao.setConditionPlateId("=", plateId);
		if (dao.countRows() > 0) {
			throw new SQLException("加载异常：您有未处理的奖金发放记录");
		}
		
		Date date = DateUtil.getLastDay(new Date(BaseHelpUtils.getLongValue(params.get("payDate"))));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 2);
		Date resignationDate = DateUtil.getFirstDay(calendar.getTime());
		//检查是否有未结算的项目成本
		ConditionGetUnsettledProjectCost projectCostCondition = new ConditionGetUnsettledProjectCost();
		projectCostCondition.setPlateId(plateId);
		projectCostCondition.setEndDate(DateUtil.getFirstDayOfNextMonth(date));
		QueryGetUnsettledProjectCost projectCostQuery = new QueryGetUnsettledProjectCost();
		BaseCollection<BaseGetUnsettledProjectCost> projectCostCollection = projectCostQuery.executeQuery(null, projectCostCondition);
		if(null != projectCostCollection && null != projectCostCollection.getCollections() && !projectCostCollection.getCollections().isEmpty()){
			throw new SQLException("您所在的业务部门尚有部分项目成本没有结算，故暂无法申请发放奖金");
		}
		ConditionPrepareBonusPaymentApplyInfo condition = new ConditionPrepareBonusPaymentApplyInfo();
		condition.setEndDate(date);
		condition.setPlateId(plateId);
		condition.setResignationDate(resignationDate);
		QueryPrepareBonusPaymentApplyInfo query = new QueryPrepareBonusPaymentApplyInfo();
		BaseCollection<BasePrepareBonusPaymentApplyInfo> collection = query.executeQuery(null, condition);
		if(null != collection){
			
			Employee eDao =new  Employee();
			
			List<BasePrepareBonusPaymentApplyInfo> infoList = collection.getCollections();
			if (null != infoList && !infoList.isEmpty()) {
				List<BaseBonusPaymentDetail> list = new ArrayList<>();
				BigDecimal defaultPercent = new BigDecimal(100);
				for (BasePrepareBonusPaymentApplyInfo obj : infoList) {
					if (obj.getAchieveIntegral().compareTo(BigDecimal.ZERO) > 0 || obj.getStatus().equals(StaticUtils.EMPLOYEE_DIMISSION)) {
						eDao.clear();
						eDao.setConditionEmployeeId("=", obj.getEmployeeId());
						BaseEmployee executeQueryOneRow = eDao.executeQueryOneRow();
						
						BaseBonusPaymentDetail bean = new BaseBonusPaymentDetail();
						bean.setPlateId(obj.getPlateId());
						bean.setEmployeeId(obj.getEmployeeId());
						bean.setEmployeeNo(obj.getEmployeeNo());
						bean.setEmployeeName(obj.getEmployeeName());
						bean.setAchieveIntegral(BaseHelpUtils.format(obj.getAchieveIntegral(), 2));
						bean.setPayPercent(defaultPercent);
						bean.setPayIntegral(bean.getAchieveIntegral());
						bean.setLeftIntegral(BigDecimal.ZERO);
						bean.setStatus(obj.getStatus());
						bean.setPayDate(date);
						bean.setDepartmentId(executeQueryOneRow.getDepartmentId());
						list.add(bean);
					}else if(obj.getAchieveIntegral().compareTo(BigDecimal.ZERO) < 0){
						throw new SQLException(String.format("您所在的业务部门员工(%1$s)需进行积分借款操作，故暂无法申请发放奖金",obj.getEmployeeName()));
					}
				}
				if(list.isEmpty()){
					throw new SQLException("加载异常：该部门下没有可发放奖金的人员");
				}
				Map<Integer, BaseBonusPaymentDetail> map = new HashMap<>();
				for(BaseBonusPaymentDetail obj : list){
					map.put(obj.getEmployeeId(), obj);
				}
				List<BaseBonusPaymentDetail> result = new ArrayList<>();
				for(Integer key : map.keySet()){
					if(map.get(key).getAchieveIntegral().compareTo(BigDecimal.ZERO) > 0){
						result.add(map.get(key));
					}
				}
				bc.setCollections(result);
			}
		}
		return bc.toJSON(0, null);
	}

	// 保存本次奖金发放的总记录以及本次奖金发放所涉及到的每一个员工的奖金发放详情
	@SuppressWarnings("unchecked")
	public String apply(Map<String, Object> params) throws Exception {
		BaseCollection<BaseBonusPaymentDetail> bc = new BaseCollection<>();
		ThreadConnection.beginTransaction();
		Employee eDao =new Employee();
		BonusPaymentRecord recordDao = new BonusPaymentRecord();
		recordDao.setConditionState("=", StaticUtils.BONUS_PAYMENT_NO_DEAL);
		recordDao.setConditionPlateId("=", BaseHelpUtils.getIntValue(params.get("plateId")));
		if (recordDao.countRows() == 0) {
			Date date = new Date();
			BaseBonusPaymentRecord bean = new BaseBonusPaymentRecord();
			bean.setDataFromMap(params);
			bean.setPayDate(DateUtil.getLastDay(bean.getPayDate()));
			recordDao.clear();
			recordDao.setDataFromBase(bean);
			recordDao.setApplyTime(date);
			recordDao.save();
			List<com.pomplatform.db.bean.BaseBonusPaymentDetail> list = GenericBase.__getList(
					params.get("bonusPaymentDetails"), com.pomplatform.db.bean.BaseBonusPaymentDetail.newInstance());
			int recordId = recordDao.getBonusPaymentRecordId();
			BigDecimal sum = BigDecimal.ZERO;
			if (null != list) {
				List<com.pomplatform.db.bean.BaseBonusPaymentDetail> saveList = new ArrayList<>(); 
				for (com.pomplatform.db.bean.BaseBonusPaymentDetail obj : list) {
					if(BaseHelpUtils.getBigDecimalValue(obj.getPayPercent()).compareTo(BigDecimal.ZERO) > 0){
						sum = sum.add(BaseHelpUtils.getBigDecimalValue(obj.getPayIntegral()));
						obj.setBonusPaymentRecordId(recordId);
						String employeeNo = obj.getEmployeeNo();
						eDao.clear();
						eDao.setConditionEmployeeNo("=", employeeNo);
						BaseEmployee executeQueryOneRow = eDao.executeQueryOneRow();
						obj.setDepartmentId(BaseHelpUtils.getIntValue(executeQueryOneRow.getDepartmentId()));
						saveList.add(obj);
					}
				}
				recordDao.clear();
				recordDao.setConditionBonusPaymentRecordId("=", recordId);
				recordDao.setPayIntegral(sum);
				recordDao.conditionalUpdate();
				BonusPaymentDetail detailDao = new BonusPaymentDetail();
				detailDao.save(saveList);
			}
			ThreadConnection.commit();
			return bc.toJSON();
		} else {
			return bc.toJSON(-1, "请不要重复提交奖金发放申请信息");
		}
	}

	/**
	 * 查询出奖金发放审核页面的审核信息
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public String prepareAuditInfo(Map<String, Object> params) throws Exception {
		BaseCollection<com.pomplatform.db.bean.BaseBonusPaymentDetail> bc = new BaseCollection<>();
		int id = BaseHelpUtils.getIntValue(params.get("bonusPaymentRecordId"));
		BonusPaymentDetail dao = new BonusPaymentDetail();
		dao.setConditionBonusPaymentRecordId("=", id);
		List<com.pomplatform.db.bean.BaseBonusPaymentDetail> list = dao.conditionalLoad();
		bc.setCollections(list);
		return bc.toJSON();
	}

	/**
	 * 同意通过奖金发放申请
	 */
	@SuppressWarnings("rawtypes")
	public  String agreeApply(Map<String, Object> params) throws Exception {
		BaseCollection bc = new BaseCollection();
		int id = BaseHelpUtils.getIntValue(params.get("bonusPaymentRecordId"));
		BonusPaymentRecord recordDao = new BonusPaymentRecord();
		// 判断该申请是否处于未审核阶段
		recordDao.setConditionBonusPaymentRecordId("=", id);
		recordDao.setConditionState("=", StaticUtils.BONUS_PAYMENT_NO_DEAL);
		BaseBonusPaymentRecord bean = recordDao.executeQueryOneRow();
		// 未审核阶段，则进行审核通过的操作
		if (null != bean) {
			ThreadConnection.beginTransaction();
			recordDao.clear();
			// 通过本次奖金发放申请总记录的审核
			recordDao.setConditionBonusPaymentRecordId("=", id);
			recordDao.setAuditor(BaseHelpUtils.getIntValue(params.get("auditor")));
			recordDao.setState(StaticUtils.BONUS_PAYMENT_AGREE);
			recordDao.setOpinion("通过审核");
			recordDao.setAuditingTime(new Date());
			recordDao.conditionalUpdate();
			
			// 通过本次奖金发放申请详情（每个员工）的审核
			BonusPaymentDetail detailDao = new BonusPaymentDetail();
			detailDao.setConditionBonusPaymentRecordId("=", id);
			detailDao.setState(StaticUtils.BONUS_PAYMENT_AGREE);
			detailDao.conditionalUpdate();
			detailDao.clear();
			detailDao.setConditionBonusPaymentRecordId("=", id);
			detailDao.unsetSelectFlags();
			detailDao.setSelectBonusPaymentDetailId(true);
			detailDao.setSelectPlateId(true);
			detailDao.setSelectEmployeeId(true);
			detailDao.setSelectPayIntegral(true);
			detailDao.setSelectPayDate(true);
			detailDao.setSelectSendNumber(true);
			detailDao.setSelectFirstIntegral(true);
			detailDao.setSelectSecondIntegral(true);
			detailDao.setSelectThirdIntegral(true);
			List<com.pomplatform.db.bean.BaseBonusPaymentDetail> list = detailDao.conditionalLoad();
			
			recordDao.setBonusPaymentRecordId(id);
			int plateId = 0;
			Date payDate = null;
			String remark = "";
			if(recordDao.load()){
				plateId = recordDao.getPlateId();
				payDate = recordDao.getPayDate();
				remark = recordDao.getRemark()+"(营销提成奖金发放)";
			}
			QueryLoadEmployeeForSendBonusTwo q = new QueryLoadEmployeeForSendBonusTwo();
			ConditionLoadEmployeeForSendBonusTwo c = new ConditionLoadEmployeeForSendBonusTwo();
			c.setPlateId(plateId);
			c.setPayDate(payDate);
			c.setState(StaticUtils.BONUS_PAYMENT_NO_DEAL);
			BaseCollection<BaseLoadEmployeeForSendBonusTwo> llist = q.executeQuery(null, c);
			if(!BaseHelpUtils.isNullOrEmpty(llist) && llist.getCollections().size() > 0){//说明有营销的二级部门提交申请,所以入部门账户
				for(BaseLoadEmployeeForSendBonusTwo e : llist.getCollections()){
					int recordId = e.getBonusPaymentRecordId();
					recordDao.clear();
					recordDao.setBonusPaymentRecordId(recordId);
					if(recordDao.load()){
						recordDao.setAuditor(BaseHelpUtils.getIntValue(params.get("auditor")));
						recordDao.setState(StaticUtils.BONUS_PAYMENT_AGREE);
						recordDao.setOpinion("通过审核");
						recordDao.setAuditingTime(new Date());
						recordDao.update();
					}
					detailDao.clear();
					detailDao.setConditionBonusPaymentRecordId("=", recordId);
					detailDao.setState(StaticUtils.BONUS_PAYMENT_AGREE);
					detailDao.conditionalUpdate();
				}
				if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
					for(com.pomplatform.db.bean.BaseBonusPaymentDetail ee : list){
						int savePlateId = ee.getPlateId();
						BigDecimal saveIntegral = ee.getPayIntegral();
						int saveBusinessId = ee.getBonusPaymentDetailId();
						AccountManageProcess.onSavePlateAccount(savePlateId, saveBusinessId, AccountManageProcess.PLATE_BT_PERFORMANCE_BONUS, saveIntegral, new Date(), remark, -1);
					}
				}
			}else{
				// 通过审核后，将当月份各位发了奖金员工的employee_report_records表中的数据更新：①奖金发放的值增加
				// ②总的价值积分减少
				if (null != list && !list.isEmpty()) {
					Employee eDao=new Employee();
					SalaryOfBonus sDao = new SalaryOfBonus();
					for (com.pomplatform.db.bean.BaseBonusPaymentDetail obj : list) {
						//获取发放次数
						int sendNumber=BaseHelpUtils.getIntValue(obj.getSendNumber());
						//获取人员id
						int employeeId = obj.getEmployeeId();

						eDao.clear();
						int plateIds=0;
						int departmentId=0;
						int companyId=0;
						eDao.setEmployeeId(employeeId);
						String employeeName = "";
						if(eDao.load()) {
							plateIds=eDao.getPlateId();
							departmentId=eDao.getDepartmentId();
							companyId=eDao.getCompanyId();
							employeeName = BaseHelpUtils.getString(eDao.getEmployeeName());
						}else {
							throw new SQLException("找不到人员信息");
						}

						if(sendNumber>0) {
							int businessId = obj.getBonusPaymentDetailId();
							//获取日期
							Date recordDate = obj.getPayDate();
							//验证发放总金额是否等于每一次发放的累加金额
							//获取总发放金额
							BigDecimal payIntegral = BaseHelpUtils.getBigDecimalValue(obj.getPayIntegral());
							//获取第一次发放金额
							BigDecimal  firstIntegral = BaseHelpUtils.getBigDecimalValue(obj.getFirstIntegral());
							//获取第二次发放金额
							BigDecimal  secondIntegral = BaseHelpUtils.getBigDecimalValue(obj.getSecondIntegral());
							//获取第三次发放金额
							BigDecimal  thirdIntegral = BaseHelpUtils.getBigDecimalValue(obj.getThirdIntegral());
							BigDecimal totalIntegral = firstIntegral.add(secondIntegral).add(thirdIntegral);
							if(payIntegral.compareTo(totalIntegral) != 0) {//说明不相等
								throw new SQLException(String.format("操作异常：发放总金额(%1$s)不等于每一次发放的累加金额(%2$s)", payIntegral,totalIntegral));
							}

							//设置第二次发放日期，及在第一次发放日期延后一个月
							Date secondDate = DateUtil.getNextMonth(recordDate);
							//设置第三次发放日期，及在第二次发放日期延后一个月
							Date thirdDate = DateUtil.getNextMonth(secondDate);

							if(firstIntegral.compareTo(BigDecimal.ZERO) > 0) {
								BigDecimal  shouldTax=getShouldTax(firstIntegral);
								BigDecimal factBonus=firstIntegral.subtract(shouldTax);

								sDao.clear();
								sDao.setShouldBonus(BaseHelpUtils.getString(firstIntegral));//应该奖金
								sDao.setShouldTax(BaseHelpUtils.getString(shouldTax));//个税
								sDao.setFactBonus(BaseHelpUtils.getString(factBonus));//实发奖金
								sDao.setRecordDate(recordDate);
								sDao.setEmployeeId(employeeId);
								sDao.setYear(DateUtil.getYear(recordDate));
								sDao.setMonth(DateUtil.getMonth(recordDate));
								sDao.setPlateId(plateIds);
								sDao.setDepartmentId(departmentId);
								sDao.setCompanyId(companyId);
								sDao.setFlag(2);
								sDao.save();
							}

							if(secondIntegral.compareTo(BigDecimal.ZERO) > 0) {
								BigDecimal  shouldTaxTwo=getShouldTax(secondIntegral);
								BigDecimal factBonusTwo=firstIntegral.subtract(shouldTaxTwo);

								sDao.clear();
								sDao.setShouldBonus(BaseHelpUtils.getString(secondIntegral));//应该奖金
								sDao.setShouldTax(BaseHelpUtils.getString(shouldTaxTwo));//个税
								sDao.setFactBonus(BaseHelpUtils.getString(factBonusTwo));//实发奖金
								sDao.setRecordDate(secondDate);
								sDao.setEmployeeId(employeeId);
								sDao.setYear(DateUtil.getYear(secondDate));
								sDao.setMonth(DateUtil.getMonth(secondDate));
								sDao.setPlateId(plateIds);
								sDao.setDepartmentId(departmentId);
								sDao.setCompanyId(companyId);
								sDao.setFlag(2);
								sDao.save();
							}

							if(thirdIntegral.compareTo(BigDecimal.ZERO) > 0) {
								BigDecimal  shouldTaxThree=getShouldTax(thirdIntegral);
								BigDecimal factBonusThree=firstIntegral.subtract(shouldTaxThree);

								sDao.clear();
								sDao.setShouldBonus(BaseHelpUtils.getString(thirdIntegral));//应该奖金
								sDao.setShouldTax(BaseHelpUtils.getString(shouldTaxThree));//个税
								sDao.setFactBonus(BaseHelpUtils.getString(factBonusThree));//实发奖金
								sDao.setRecordDate(thirdDate);
								sDao.setEmployeeId(employeeId);
								sDao.setYear(DateUtil.getYear(thirdDate));
								sDao.setMonth(DateUtil.getMonth(thirdDate));
								sDao.setPlateId(plateIds);
								sDao.setDepartmentId(departmentId);
								sDao.setCompanyId(companyId);
								sDao.setFlag(2);
								sDao.save();

							}
							//奖金发放入个人账户表
							AccountManageProcess.onSaveEmployeeAccount(employeeId, businessId, AccountManageProcess.EMP_BT_BONUS_SEND, payIntegral, recordDate,"",-1);
						}else {
							throw new SQLException(String.format("操作异常：获取职员(%1$s)发放次数失败！", employeeName));
						}
					}
				}
			}
			ThreadConnection.commit();
			return bc.toJSON();
		} else {
			// 该申请已经被审核过了，无需重复审核
			return bc.toJSON(-1, "请不要进行重复审核");
		}
	}

	/**
	 * 驳回奖金发放申请
	 */
	@SuppressWarnings("rawtypes")
	public String disagreeApply(Map<String, Object> params) throws Exception {
		BaseCollection bc = new BaseCollection();
		int id = BaseHelpUtils.getIntValue(params.get("bonusPaymentRecordId"));
		BonusPaymentRecord recordDao = new BonusPaymentRecord();
		// 判断该申请是否处于未审核阶段
		recordDao.setConditionBonusPaymentRecordId("=", id);
		recordDao.setConditionState("=", StaticUtils.BONUS_PAYMENT_NO_DEAL);
		// 未审核阶段，则进行驳回申请的操作
		if (recordDao.countRows() > 0) {
			ThreadConnection.beginTransaction();
			recordDao.clear();
			recordDao.setConditionBonusPaymentRecordId("=", id);
			recordDao.setAuditor(BaseHelpUtils.getIntValue(params.get("auditor")));
			recordDao.setState(StaticUtils.BONUS_PAYMENT_DISAGREE);
			recordDao.setOpinion("审核失败：" + BaseHelpUtils.getString(params.get("opinion")));
			recordDao.setAuditingTime(new Date());
			recordDao.conditionalUpdate();
			BonusPaymentDetail detailDao = new BonusPaymentDetail();
			detailDao.setConditionBonusPaymentRecordId("=", id);
			detailDao.setState(StaticUtils.BONUS_PAYMENT_DISAGREE);
			detailDao.conditionalUpdate();
			
			int plateId = 0;
			Date payDate = null;
			recordDao.setBonusPaymentRecordId(id);
			if(recordDao.load()){
				plateId = recordDao.getPlateId();
				payDate = recordDao.getPayDate();
			}
			QueryLoadEmployeeForSendBonusTwo q = new QueryLoadEmployeeForSendBonusTwo();
			ConditionLoadEmployeeForSendBonusTwo c = new ConditionLoadEmployeeForSendBonusTwo();
			c.setPlateId(plateId);
			c.setPayDate(payDate);
			c.setState(StaticUtils.BONUS_PAYMENT_NO_DEAL);
			BaseCollection<BaseLoadEmployeeForSendBonusTwo> llist = q.executeQuery(null, c);
			if(!BaseHelpUtils.isNullOrEmpty(llist) && llist.getCollections().size() > 0){//说明有营销的二级部门提交申请
				for(BaseLoadEmployeeForSendBonusTwo e : llist.getCollections()){
					int recordId = e.getBonusPaymentRecordId();
					recordDao.clear();
					recordDao.setBonusPaymentRecordId(recordId);
					if(recordDao.load()){
						recordDao.setAuditor(BaseHelpUtils.getIntValue(params.get("auditor")));
						recordDao.setState(StaticUtils.BONUS_PAYMENT_DISAGREE);
						recordDao.setOpinion("审核失败：" + BaseHelpUtils.getString(params.get("opinion")));
						recordDao.setAuditingTime(new Date());
						recordDao.update();
					}
					detailDao.clear();
					detailDao.setConditionBonusPaymentRecordId("=", recordId);
					detailDao.setState(StaticUtils.BONUS_PAYMENT_DISAGREE);
					detailDao.conditionalUpdate();
				}
			}
			ThreadConnection.commit();
			return bc.toJSON();
		} else {
			// 该申请已经被审核过了，无需重复审核
			return bc.toJSON(-1, "请不要进行重复审核");
		}
	}
	
	public static  BigDecimal  getShouldTax(BigDecimal shouldTaxAchieve) {
		BigDecimal taxTotal = BigDecimal.ZERO;
		if(shouldTaxAchieve.compareTo(BigDecimal.valueOf(3000)) <= 0){
			taxTotal = shouldTaxAchieve.multiply(BigDecimal.valueOf(0.03)).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
		}else if(shouldTaxAchieve.compareTo(BigDecimal.valueOf(12000)) <= 0){
			taxTotal = (shouldTaxAchieve.multiply(BigDecimal.valueOf(0.1)).subtract(BigDecimal.valueOf(210))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
		}else if(shouldTaxAchieve.compareTo(BigDecimal.valueOf(25000)) <= 0){
			taxTotal = (shouldTaxAchieve.multiply(BigDecimal.valueOf(0.2)).subtract(BigDecimal.valueOf(1410))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
		}else if(shouldTaxAchieve.compareTo(BigDecimal.valueOf(35000)) <= 0){
			taxTotal = (shouldTaxAchieve.multiply(BigDecimal.valueOf(0.25)).subtract(BigDecimal.valueOf(2660))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
		}else if(shouldTaxAchieve.compareTo(BigDecimal.valueOf(55000)) <= 0){
			taxTotal = (shouldTaxAchieve.multiply(BigDecimal.valueOf(0.3)).subtract(BigDecimal.valueOf(4410))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
		}else if(shouldTaxAchieve.compareTo(BigDecimal.valueOf(80000)) <= 0){
			taxTotal = (shouldTaxAchieve.multiply(BigDecimal.valueOf(0.35)).subtract(BigDecimal.valueOf(7160))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
		}else if(shouldTaxAchieve.compareTo(BigDecimal.valueOf(80000)) > 0){
			taxTotal = (shouldTaxAchieve.multiply(BigDecimal.valueOf(0.45)).subtract(BigDecimal.valueOf(15160))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
		}
		return  taxTotal;
	}
	
	
	/**
	 * 修改应发奖金日期
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws ParseException 
	 */
	public String updateSetData(Map<String,Object> params) throws SQLException, ParseException {
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		int status =-1 ;
		//获取修改日期
		Date updateDate=new Date(BaseHelpUtils.getLongValue(params.get("updateDate")));
		String value=BaseHelpUtils.getString(params.get("values"));
		if(BaseHelpUtils.isNullOrEmpty(value)){
			throw new SQLException("错误：获取主键数据失败"); 
		}else{
			SalaryOfBonus dao=new SalaryOfBonus();
			Integer[] intArr = new Integer[0];
			String[] valueArr = value.split(",");
	        intArr = new Integer[valueArr.length];
	        for (int i = 0; i < valueArr.length; i++) {
	            intArr[i] = Integer.parseInt(valueArr[i]);
	        }
	        dao.addCondition(BaseSalaryOfBonus.CS_SALARY_OF_BONUS_ID, "in", intArr);
	        dao.setRecordDate(updateDate);
	        dao.setYear(DateUtil.getYear(updateDate));
	        dao.setMonth(DateUtil.getMonth(updateDate));
	        dao.conditionalUpdate();
		}
		status=0;
		return bc.toJSON(status,"");
	}
	
	
	/**
	 * 已发奖金转化为应发奖金
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws ParseException 
	 */
	public String updataFlag(Map<String,Object> params) throws SQLException, ParseException {
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		int status =-1 ;
		String value=BaseHelpUtils.getString(params.get("values"));
		if(BaseHelpUtils.isNullOrEmpty(value)){
			throw new SQLException("错误：获取主键数据失败"); 
		}else{
			SalaryOfBonus dao=new SalaryOfBonus();
			Integer[] intArr = new Integer[0];
			String[] valueArr = value.split(",");
	        intArr = new Integer[valueArr.length];
	        for (int i = 0; i < valueArr.length; i++) {
	            intArr[i] = Integer.parseInt(valueArr[i]);
	        }
	        dao.addCondition(BaseSalaryOfBonus.CS_SALARY_OF_BONUS_ID, "in", intArr);
	        dao.setFlag(1);
	        dao.conditionalUpdate();
		}
		status=0;
		return bc.toJSON(status,"");
	}
	
	
}
