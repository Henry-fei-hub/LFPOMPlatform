package pomplatform.contract.business;

import com.pomplatform.db.bean.BaseContractDistribution;
import com.pomplatform.db.bean.BasePlateAccountRecord;
import com.pomplatform.db.dao.ContractDistribution;
import com.pomplatform.db.dao.PlateAccountRecord;
import delicacy.common.*;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import org.apache.log4j.Logger;
import pomplatform.common.utils.StaticUtils;
import pomplatform.contract.bean.BaseGetContractActualMoneyByPlateIdAndBusinessType;
import pomplatform.contract.bean.BaseSumPlateContractDistribution;
import pomplatform.contract.bean.ConditionGetContractActualMoneyByPlateIdAndBusinessType;
import pomplatform.contract.bean.ConditionSumPlateContractDistribution;
import pomplatform.contract.query.QueryGetContractActualMoneyByPlateIdAndBusinessType;
import pomplatform.contract.query.QuerySumPlateContractDistribution;

import javax.servlet.http.HttpServletRequest;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.*;

public class ContractDistributionProcessor implements GenericProcessor {
	/**
	 * 营销中心
	 */
	private final int PLATE_14 = 14;
	/**
	 * 大连营销部
	 */
	private final int PLATE_32 = 32;
	/**
	 * 北京营销部
	 */
	private final int PLATE_33 = 33;
	/**
	 * 上海营销部
	 */
	private final int PLATE_34 = 34;
	/**
	 * 轨道交通拓展部
	 */
	private final int PLATE_35 = 35;
	/**
	 * 商业商务1部
	 */
	private final int PLATE_36 = 36;
	/**
	 * 商业商务2部
	 */
	private final int PLATE_37 = 37;
	/**
	 * 商业商务3部
	 */
	private final int PLATE_38 = 38;
	/**
	 * 酒店办公商务1部
	 */
	private final int PLATE_39 = 39;
	/**
	 * 酒店办公商务2部
	 */
	private final int PLATE_40 = 40;
	/**
	 * 品牌部
	 */
	private final int PLATE_41 = 41;
	/**
	 * 合约部
	 */
	private final int PLATE_42 = 42;
	/**
	 * 综合部
	 */
	private final int PLATE_43 = 43;
	
	private BigDecimal ten_million = new BigDecimal("10000000");
	private BigDecimal twenty_million = new BigDecimal("20000000");
	private BigDecimal thirty_million = new BigDecimal("30000000");
	private BigDecimal forty_million = new BigDecimal("40000000");
	private BigDecimal fifty_million = new BigDecimal("50000000");
	private BigDecimal sixty_million = new BigDecimal("60000000");
	private BigDecimal seventy_million = new BigDecimal("70000000");
    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(params, "optType");
		switch (optType) {
		case "calculateAmount":
			return calculateAmount(params);
		case "saveContractDistribution":
			return saveContractDistribution(params);
		default:
			return null;
		}
    }
    
    /**
     * 计算营销二级账户可以得到的提成
     * @return
     * @throws Exception 
     */
    public String calculateAmount(Map<String, Object> params) throws Exception{
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	int plateId = BaseHelpUtils.getIntValue(params.get("plateId"));
    	int contractId = BaseHelpUtils.getIntValue(params.get("contractId"));
    	int businessType = BaseHelpUtils.getIntValue(params.get("businessType"));
    	BigDecimal actualMoney = BaseHelpUtils.getBigDecimalValue(params.get("actualMoney"));
    	if(plateId > 0 && contractId > 0){
    		ContractDistribution cd = new ContractDistribution();
    		cd.setConditionPlateId("=", plateId);
    		cd.setConditionContractId("=", contractId);
    		cd.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
    		if(cd.countRows() > 0){
    			//该业务部门已经在该合同有提成了，无需再算
    			return bc.toJSON(0, cd.executeQueryOneRow().getAmount()+"");
    		}else{
    			switch(plateId){
    			case PLATE_41:
    			case PLATE_42:
    				return bc.toJSON(0, "0");
    			case PLATE_35:
					switch (businessType) {
					case StaticUtils.BUSINESS_TYPE_4:
						// 累进算法1
						BigDecimal sum = sumPlateContractDistribution(contractId, plateId, businessType, true);
						return bc.toJSON(0, algorithm_01(sum, actualMoney) + "");
					default:
						return bc.toJSON(0, "0");
					}
    			case PLATE_43:
    				switch(businessType){
    				case StaticUtils.BUSINESS_TYPE_4:
//    					累进算法2
    					BigDecimal sum1 = sumPlateContractDistribution(contractId, plateId, businessType, true);
						return bc.toJSON(0, algorithm_02(sum1, actualMoney) + "");
    				case StaticUtils.BUSINESS_TYPE_1:
    				case StaticUtils.BUSINESS_TYPE_2:
    				case StaticUtils.BUSINESS_TYPE_3:
    				case StaticUtils.BUSINESS_TYPE_5:
    				case StaticUtils.BUSINESS_TYPE_6:
    				case StaticUtils.BUSINESS_TYPE_7:
    				case StaticUtils.BUSINESS_TYPE_8:
    				case StaticUtils.BUSINESS_TYPE_91:
    				case StaticUtils.BUSINESS_TYPE_99:
//    					累进算法3
    					BigDecimal sum2 = sumPlateContractDistribution(contractId, plateId, StaticUtils.BUSINESS_TYPE_4, false);
    					return bc.toJSON(0, algorithm_03(sum2, actualMoney) + "");
    				default:
    					return bc.toJSON(0, "0");
    				}
    			default:
    				switch(businessType){
    				case StaticUtils.BUSINESS_TYPE_1:
//    					商业 0.85%
    					return bc.toJSON(0, actualMoney.multiply(new BigDecimal("0.0085")).setScale(2, BigDecimal.ROUND_DOWN)+"");
    				case StaticUtils.BUSINESS_TYPE_2:
    				case StaticUtils.BUSINESS_TYPE_3:
    				case StaticUtils.BUSINESS_TYPE_5:
    				case StaticUtils.BUSINESS_TYPE_6:
    				case StaticUtils.BUSINESS_TYPE_7:
    				case StaticUtils.BUSINESS_TYPE_8:
    				case StaticUtils.BUSINESS_TYPE_91:
    				case StaticUtils.BUSINESS_TYPE_99:
//    					酒店、办公、医养、公共建筑、综合体、住宅、采买、其他 0.95%
    					return bc.toJSON(0, actualMoney.multiply(new BigDecimal("0.0095")).setScale(2, BigDecimal.ROUND_DOWN)+"");
    				default:
    					return bc.toJSON(0, "0");
    				}
    			}
    		}
    	}
    	return null;
    }
    
    
	public String saveContractDistribution(Map<String, Object> params) throws Exception {
		List<BaseContractDistribution> list = GenericBase.__getList(params.get("details"),
				BaseContractDistribution.newInstance());
		int contractId = BaseHelpUtils.getIntValue(params.get("contractId"));
		int businessType = BaseHelpUtils.getIntValue(params.get("businessType"));
		int operator = BaseHelpUtils.getIntValue(params.get("operator"));
		ThreadConnection.beginTransaction();
		ContractDistribution contractDistributionDao = new ContractDistribution();
		contractDistributionDao.setConditionContractId("=", contractId);
		contractDistributionDao.setConditionBusinessType("=", businessType);
		contractDistributionDao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
		// 加载原有的数据
		List<BaseContractDistribution> originalList = contractDistributionDao.conditionalLoad();
		// 记录回款涉及的订单的最终变动积分
		if (list != null) {
			// need to delete list.
			List<BaseContractDistribution> needToDeleteList = new ArrayList<>();
			// need to add list.
			List<BaseContractDistribution> needToAddList = new ArrayList<>();
			// find the record that exists in the original list and update.
			for (BaseContractDistribution bean : list) {
				boolean found = false;
				// 从原有的数据集合中循环取数据，比对主键，主键一致的：更新；没找到的：新增；
				for (BaseContractDistribution originalBean : originalList) {
					// 如果主键一致，则直接修改数据
					if (bean.compareTo(originalBean) == 0) {
						found = true;
						contractDistributionDao.clear();
						contractDistributionDao.setDataFromBase(originalBean);
						contractDistributionDao.clearModifiedFlags();
						updateContractDistributionData(contractDistributionDao, bean, operator);
						break;
					}
				}
				if (!found) {
					needToAddList.add(bean);
				}
			}
			// 找出需要删除的数据
			for (BaseContractDistribution originalBean : originalList) {
				boolean foundNeedToDelete = false;
				for (BaseContractDistribution bean : list) {
					if (bean.compareTo(originalBean) == 0) {
						foundNeedToDelete = true;
						break;
					}
				}
				if (!foundNeedToDelete)
					needToDeleteList.add(originalBean);
			}
			// process need-to-add list
			for (BaseContractDistribution bean : needToAddList) {
				contractDistributionDao.setPrimaryKeyFromBase(bean);
				if (contractDistributionDao.isPrimaryKeyNull()) {
					contractDistributionDao.clearCurrentData();
					contractDistributionDao.setDataFromBase(bean);
					contractDistributionDao.save();
					saveContractDistributionData(contractDistributionDao.generateBase(), operator, businessType);
				} else {
					if (contractDistributionDao.load()) {
						updateContractDistributionData(contractDistributionDao, bean, operator);
					} else {
						contractDistributionDao.clearCurrentData();
						contractDistributionDao.setDataFromBase(bean);
						contractDistributionDao.save();
						saveContractDistributionData(contractDistributionDao.generateBase(), operator, businessType);
					}
				}
			}
			// process need-to-delete list
			for (BaseContractDistribution bean : needToDeleteList) {
				deleteContractDistribution(bean, operator);
			}
		} else {
			// if current list is empty, then delete all original list.
			for (BaseContractDistribution bean : originalList) {
				deleteContractDistribution(bean, operator);
			}
		}
		contractDistributionDao.clear();
		contractDistributionDao.setConditionContractId("=", contractId);
		contractDistributionDao.setConditionBusinessType("<>", businessType);
		contractDistributionDao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
		//删除业态对不上的数据
		List<BaseContractDistribution> originalDeleteList = contractDistributionDao.conditionalLoad();
		if(null != originalDeleteList && !originalDeleteList.isEmpty()){
			for(BaseContractDistribution bean: originalDeleteList){
				deleteContractDistribution(bean, operator);
			}
		}
		ThreadConnection.commit();
		BaseCollection bc = new BaseCollection<>();
		return bc.toJSON();
	}
    
	public void updateContractDistributionData(ContractDistribution contractDistributionDao, BaseContractDistribution bean, int operator) throws Exception{
		BigDecimal amount = contractDistributionDao.getAmount();
		BaseContractDistribution originalBean = contractDistributionDao.generateBase();
//		Date recordDate = originalBean.getContractDate();
		contractDistributionDao.setDataFromBase(bean);
		ColumnChangedData plateIdData = contractDistributionDao.getColumnChangedData(BaseContractDistribution.CS_PLATE_ID);
		List<BasePlateAccountRecord> list = new ArrayList<>();
		contractDistributionDao.update();
		if(null != plateIdData){
			Date date = new Date();
			contractDistributionDao.setOperator(operator);
			contractDistributionDao.setUpdateTime(date);
			//换了业务部门，则需要修改原有的部门账户数据
			BasePlateAccountRecord record1 = new BasePlateAccountRecord();
			record1.setBusinessId(contractDistributionDao.getContractDistributionId());
			record1.setBusinessTypeId(StaticUtils.PLATE_ACCOUNT_BUSINESS_TYPE_25);
			record1.setPlateId(PLATE_14);
			record1.setIntegral(amount);
			record1.setOperateEmployeeId(operator);
			record1.setOperateTime(date);
			record1.setRecordDate(date);
			record1.setRemark("修改团队");
			list.add(record1);
			BasePlateAccountRecord record2 = new BasePlateAccountRecord();
			record1.cloneCopy(record2);
			record2.setPlateId(BaseHelpUtils.getIntValue(plateIdData.getOriginal()));
			record2.setBusinessTypeId(StaticUtils.PLATE_ACCOUNT_BUSINESS_TYPE_26);
			list.add(record2);
			BasePlateAccountRecord record3 = new BasePlateAccountRecord();
			record1.cloneCopy(record3);
			record3.setBusinessTypeId(StaticUtils.PLATE_ACCOUNT_BUSINESS_TYPE_26);
			record3.setIntegral(contractDistributionDao.getAmount());
			BasePlateAccountRecord record4 = new BasePlateAccountRecord();
			record3.cloneCopy(record4);
			record4.setPlateId(contractDistributionDao.getPlateId());
			record4.setBusinessTypeId(StaticUtils.PLATE_ACCOUNT_BUSINESS_TYPE_25);
			int businessType = contractDistributionDao.getBusinessType();
			Integer contractId = contractDistributionDao.getContractId();
			contractDistributionDao.clear();
			contractDistributionDao.setConditionContractId("=", contractId);
			contractDistributionDao.setConditionPlateId("=", record4.getPlateId());
			if(contractDistributionDao.countRows() == 1){
				record3.setRecordDate(bean.getContractDate());
				record4.setRecordDate(bean.getContractDate());
			}
			list.add(record3);
			list.add(record4);
			switch(originalBean.getPlateId()){
			case PLATE_35:
				switch(businessType){
				case StaticUtils.BUSINESS_TYPE_4:
//    			累进算法1
					reContractDistributionCalculate(list, bean, operator, 1, 1);
					break;
				default:
					break;
				}
			case PLATE_43:
				switch(businessType){
				case StaticUtils.BUSINESS_TYPE_4:
//				累进算法2
					reContractDistributionCalculate(list, bean, operator, 2, 1);
					break;
				case StaticUtils.BUSINESS_TYPE_1:
				case StaticUtils.BUSINESS_TYPE_2:
				case StaticUtils.BUSINESS_TYPE_3:
				case StaticUtils.BUSINESS_TYPE_5:
				case StaticUtils.BUSINESS_TYPE_6:
				case StaticUtils.BUSINESS_TYPE_7:
				case StaticUtils.BUSINESS_TYPE_8:
				case StaticUtils.BUSINESS_TYPE_91:
				case StaticUtils.BUSINESS_TYPE_99:
//				累进算法3
					reContractDistributionCalculate(list, bean, operator, 3, 1);
					break;
				default:
					break;
				}
			default:
				break;
			}
			PlateAccountRecord dao = new PlateAccountRecord();
			dao.save(list);
		}
	}
    public void saveContractDistributionData(BaseContractDistribution bean, int operator, int businessType) throws Exception{
    	ContractDistribution dao = new ContractDistribution();
    	dao.setConditionContractId("=", bean.getContractId());
    	dao.setConditionPlateId("=", bean.getPlateId());
    	//第一次分配，存的是合同的签订日期
    	Date recordDate = bean.getContractDate();
    	if(dao.countRows() > 1){
    		//后续无论什么操作，都是以操作时间为准
    		recordDate = new Date();
    	}
    	int plateId = bean.getPlateId();
    	int contractDistributionId = bean.getContractDistributionId();
    	Date date = new Date();
    	List<BasePlateAccountRecord> list = new ArrayList<>();
    	BasePlateAccountRecord record = new BasePlateAccountRecord();
    	record.setPlateId(plateId);
    	record.setBusinessId(contractDistributionId);
    	record.setBusinessTypeId(StaticUtils.PLATE_ACCOUNT_BUSINESS_TYPE_25);
    	record.setIntegral(bean.getAmount());
    	record.setRecordDate(recordDate);
    	record.setOperateEmployeeId(operator);
    	record.setOperateTime(date);
    	record.setRemark("分配团队提成");
    	list.add(record);
    	BasePlateAccountRecord copyRecord = new BasePlateAccountRecord();
    	record.cloneCopy(copyRecord);
    	copyRecord.setPlateId(PLATE_14);
    	copyRecord.setBusinessTypeId(StaticUtils.PLATE_ACCOUNT_BUSINESS_TYPE_26);
    	list.add(copyRecord);
    	PlateAccountRecord recordDao = new PlateAccountRecord();
    	recordDao.save(list);
    }
    /**
     * @param bean
     * @param operator
     * @return
     * @throws Exception
     */
    public void deleteContractDistribution(BaseContractDistribution bean, int operator) throws Exception{
    	int plateId = BaseHelpUtils.getIntValue(bean.getPlateId());
    	int businessType = BaseHelpUtils.getIntValue(bean.getBusinessType());
    	int contractDistributionId = BaseHelpUtils.getIntValue(bean.getContractDistributionId());
    	Date date = new Date();
    	List<BasePlateAccountRecord> list = new ArrayList<>();
    	ContractDistribution cdDao = new ContractDistribution();
    	cdDao.setConditionContractDistributionId("=", contractDistributionId);
    	cdDao.setDeleteFlag(StaticUtils.HAS_DELETE);
    	cdDao.setUpdateTime(date);
    	cdDao.conditionalUpdate();
    	BasePlateAccountRecord record = new BasePlateAccountRecord();
    	record.setPlateId(PLATE_14);
    	record.setBusinessId(contractDistributionId);
    	record.setBusinessTypeId(StaticUtils.PLATE_ACCOUNT_BUSINESS_TYPE_25);
    	record.setIntegral(bean.getAmount());
    	record.setRecordDate(date);
    	record.setOperateEmployeeId(operator);
    	record.setOperateTime(date);
    	record.setRemark("删除提成");
    	list.add(record);
    	BasePlateAccountRecord copyRecord = new BasePlateAccountRecord();
    	record.cloneCopy(copyRecord);
    	copyRecord.setPlateId(plateId);
    	copyRecord.setBusinessTypeId(StaticUtils.PLATE_ACCOUNT_BUSINESS_TYPE_26);
    	list.add(copyRecord);
    	switch(plateId){
    	case PLATE_35:
    		switch(businessType){
    		case StaticUtils.BUSINESS_TYPE_4:
//    			累进算法1
    			reContractDistributionCalculate(list, bean, operator, 1, 2);
    			break;
			default:
				break;
    		}
    	case PLATE_43:
    		switch(businessType){
    		case StaticUtils.BUSINESS_TYPE_4:
//				累进算法2
    			reContractDistributionCalculate(list, bean, operator, 2, 2);
				break;
			case StaticUtils.BUSINESS_TYPE_1:
			case StaticUtils.BUSINESS_TYPE_2:
			case StaticUtils.BUSINESS_TYPE_3:
			case StaticUtils.BUSINESS_TYPE_5:
			case StaticUtils.BUSINESS_TYPE_6:
			case StaticUtils.BUSINESS_TYPE_7:
			case StaticUtils.BUSINESS_TYPE_8:
			case StaticUtils.BUSINESS_TYPE_91:
			case StaticUtils.BUSINESS_TYPE_99:
//				累进算法3
				reContractDistributionCalculate(list, bean, operator, 3, 2);
				break;
			default:
				break;
    		}
		default:
			break;
    	}
    	PlateAccountRecord recordDao = new PlateAccountRecord();
    	recordDao.save(list);
    }
    
    /**
     * 删除或修改提成，涉及到累进算法的需要调用这个方法
     * @param function 1:累进算法1；   2:累进算法2；   3:累进算法3；
     * @param type 1:update执行的本方法     2:delete执行的本方法
     * @return
     * @throws Exception
     */
    public void reContractDistributionCalculate(List<BasePlateAccountRecord> list, BaseContractDistribution bean, int operator, int function, int type) throws Exception{
    	int contractDistributionId = bean.getContractDistributionId();
    	int plateId = bean.getPlateId();
    	int businessType = bean.getBusinessType();
    	int contractId = bean.getContractId();
    	//根据业务部门和业务类型，找到合同的实际参与分配金额，默认为actual_money,如果actual_money为空，则为sign_money_sum
    	ConditionGetContractActualMoneyByPlateIdAndBusinessType actualCondition = new ConditionGetContractActualMoneyByPlateIdAndBusinessType();
    	actualCondition.setPlateId(plateId);
    	QueryGetContractActualMoneyByPlateIdAndBusinessType actualQuery = new QueryGetContractActualMoneyByPlateIdAndBusinessType();
    	BaseCollection<BaseGetContractActualMoneyByPlateIdAndBusinessType> actualBc = null;
    	KeyValuePair[] keyValues = new KeyValuePair[1];
		KeyValuePair keyValue = new KeyValuePair();
		if(plateId == PLATE_43 && businessType != StaticUtils.BUSINESS_TYPE_4){
			keyValue.setKey("where plate_id =");
			keyValue.setValue("where business_type != " + StaticUtils.BUSINESS_TYPE_4 + " and plate_id =");
			keyValues[0] = keyValue;
			actualBc = actualQuery.executeQuery(keyValues, actualCondition);
		}else{
			actualCondition.setBusinessType(businessType);
			actualBc = actualQuery.executeQuery(null, actualCondition);
		}
    	if(null != actualBc && null != actualBc.getCollections() && !actualBc.getCollections().isEmpty()){
    		Map<Integer, BigDecimal> map = new HashMap<>();
    		for(BaseGetContractActualMoneyByPlateIdAndBusinessType obj : actualBc.getCollections()){
    			if(null != obj.getContractId()){
	    			if(null != obj.getActualMoney()){
	    				map.put(obj.getContractId(), obj.getActualMoney());
	    			}else if(null != obj.getSigningMoneySum()){
	    				map.put(obj.getContractId(), obj.getSigningMoneySum());
	    			}
    			}
    		}
    		Date date = new Date();
    		ConditionSumPlateContractDistribution condition = new ConditionSumPlateContractDistribution();
    		condition.setPlateId(plateId);
    		condition.setContractId(contractId);
    		keyValues = new KeyValuePair[1];
    		keyValue = new KeyValuePair();
    		keyValue.setKey("and a.business_type");
    		if(plateId == PLATE_43 && businessType != StaticUtils.BUSINESS_TYPE_4){
    			keyValue.setValue("and a.business_type != " + StaticUtils.BUSINESS_TYPE_4 + " and a." + BaseContractDistribution.CS_CONTRACT_DISTRIBUTION_ID + " < " + contractDistributionId + " and a.business_type");
    		}else{
    			condition.setBusinessType(businessType);
    			keyValue.setValue("and a." + BaseContractDistribution.CS_CONTRACT_DISTRIBUTION_ID + " < " + contractDistributionId + " and a.business_type");
    		}
    		keyValues[0] = keyValue;
    		QuerySumPlateContractDistribution query = new QuerySumPlateContractDistribution();
    		BaseCollection<BaseSumPlateContractDistribution> bc = query.executeQuery(keyValues, condition);
    		BigDecimal sum = BigDecimal.ZERO;
    		if(null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty() && null != bc.getCollections().get(0).getAmount()){
    			sum = bc.getCollections().get(0).getAmount();
    		}
    		ContractDistribution cdDao = new ContractDistribution();
    		cdDao.setConditionContractDistributionId(">", contractDistributionId);
        	cdDao.setConditionDeleteFlag("=", 0);
        	cdDao.setConditionPlateId("=", plateId);
        	StringBuilder customSql = new StringBuilder();
        	if(plateId == PLATE_43 && businessType != StaticUtils.BUSINESS_TYPE_4){
        		customSql.append(BaseContractDistribution.CS_BUSINESS_TYPE).append(" != ").append(StaticUtils.BUSINESS_TYPE_4);
        	}else{
        		cdDao.setConditionBusinessType("=", businessType);
        	}
        	customSql.append(" order by ").append(BaseContractDistribution.CS_CONTRACT_DISTRIBUTION_ID);
        	List<BaseContractDistribution> cdList = cdDao.conditionalLoad(customSql.toString());
    		for(BaseContractDistribution obj : cdList){
    			BasePlateAccountRecord record1 = new BasePlateAccountRecord();
    			record1.setPlateId(PLATE_14);
    	    	record1.setBusinessId(obj.getContractDistributionId());
    	    	record1.setBusinessTypeId(StaticUtils.PLATE_ACCOUNT_BUSINESS_TYPE_25);
    	    	record1.setIntegral(obj.getAmount());
    	    	record1.setRecordDate(date);
    	    	record1.setOperateEmployeeId(operator);
    	    	record1.setOperateTime(date);
    	    	if(type == 1){
    	    		record1.setRemark("修改提成的团队重新计算数据");
    	    	}else if(type == 2){
    	    		record1.setRemark("删除提成重新计算数据");
    	    	}
    	    	list.add(record1);
    	    	BasePlateAccountRecord record2 = new BasePlateAccountRecord();
    	    	record1.cloneCopy(record2);
    	    	record2.setPlateId(plateId);
    	    	record2.setBusinessTypeId(StaticUtils.PLATE_ACCOUNT_BUSINESS_TYPE_26);
    	    	list.add(record2);
    	    	BigDecimal amount = BigDecimal.ZERO;
    	    	if(function == 1){
    	    		amount = algorithm_01(sum, map.get(obj.getContractId()));
    	    	}else if(function == 2){
    	    		amount = algorithm_02(sum, map.get(obj.getContractId()));
    	    	}else if(function == 3){
    	    		amount = algorithm_03(sum, map.get(obj.getContractId()));
    	    	}
    	    	sum = sum.add(map.get(obj.getContractId()));
    	    	obj.setAmount(amount);
    	    	obj.setUpdateTime(date);
    	    	obj.setOperator(operator);
    	    	cdDao.clear();
    	    	cdDao.setDataFromBase(obj);
    	    	cdDao.update();
    	    	BasePlateAccountRecord record3 = new BasePlateAccountRecord();
    	    	record1.cloneCopy(record3);
    	    	record3.setBusinessTypeId(StaticUtils.PLATE_ACCOUNT_BUSINESS_TYPE_26);
    	    	record3.setIntegral(amount);
    	    	BasePlateAccountRecord record4 = new BasePlateAccountRecord();
    	    	record3.cloneCopy(record4);
    	    	record4.setPlateId(plateId);
    	    	record4.setBusinessTypeId(StaticUtils.PLATE_ACCOUNT_BUSINESS_TYPE_25);
    	    	list.add(record3);
    	    	list.add(record4);
    		}
    	
    	}
    }
    
    public BigDecimal sumPlateContractDistribution(int contractId, int plateId, int businessType, boolean includeBusinessType) throws Exception{
    	BigDecimal sum = BigDecimal.ZERO;
    	ConditionSumPlateContractDistribution condition = new ConditionSumPlateContractDistribution();
    	condition.setContractId(contractId);
    	condition.setPlateId(plateId);
    	QuerySumPlateContractDistribution query = new QuerySumPlateContractDistribution();
    	BaseCollection<BaseSumPlateContractDistribution> bc = null;
    	if(includeBusinessType){
    		condition.setBusinessType(businessType);
    		bc = query.executeQuery(null, condition);
    	}else{
    		KeyValuePair kv = new KeyValuePair();
    		kv.setKey("and a.delete_flag = 0");
    		kv.setValue("and a.delete_flag = 0 and a.business_type != " + businessType);
    		KeyValuePair[] keyValue = new KeyValuePair[1];
    		keyValue[0] = kv;
    		bc = query.executeQuery(keyValue, condition);
    	}
    	if(null != bc.getCollections() && !bc.getCollections().isEmpty() && null != bc.getCollections().get(0).getAmount()){
    		sum = bc.getCollections().get(0).getAmount();
    	}
    	return sum;
    }

    public BigDecimal algorithm_01(BigDecimal sum, BigDecimal signMoney){
    	BigDecimal amount = BigDecimal.ZERO;
    	if(sum.compareTo(ten_million) < 0){
    		if(sum.add(signMoney).compareTo(ten_million) <= 0){
    			amount = amount.add(signMoney.multiply(new BigDecimal("0.0005")).setScale(2, BigDecimal.ROUND_DOWN));
    		}else{
    			amount = amount.add((ten_million.subtract(sum).abs()).multiply(new BigDecimal("0.0005")).setScale(2, BigDecimal.ROUND_DOWN));
    			amount = amount.add(algorithm_01(ten_million, sum.add(signMoney).subtract(ten_million)));
    		}
    	}
    	if(sum.compareTo(ten_million) >= 0 && sum.compareTo(twenty_million) < 0){
    		if(sum.add(signMoney).compareTo(twenty_million) <= 0){
    			amount = amount.add(signMoney.multiply(new BigDecimal("0.0010")).setScale(2, BigDecimal.ROUND_DOWN));
    		}else{
    			amount = amount.add((twenty_million.subtract(sum).abs()).multiply(new BigDecimal("0.0010")).setScale(2, BigDecimal.ROUND_DOWN));
    			amount = amount.add(algorithm_01(twenty_million, sum.add(signMoney).subtract(twenty_million)));
    		}
    	}
    	if(sum.compareTo(twenty_million) >= 0 && sum.compareTo(thirty_million) < 0){
    		if(sum.add(signMoney).compareTo(thirty_million) <= 0){
    			amount = amount.add(signMoney.multiply(new BigDecimal("0.0015")).setScale(2, BigDecimal.ROUND_DOWN));
    		}else{
    			amount = amount.add((thirty_million.subtract(sum).abs()).multiply(new BigDecimal("0.0015")).setScale(2, BigDecimal.ROUND_DOWN));
    			amount = amount.add(algorithm_01(thirty_million, sum.add(signMoney).subtract(thirty_million)));
    		}
    	}
    	if(sum.compareTo(thirty_million) >= 0 && sum.compareTo(forty_million) < 0){
    		if(sum.add(signMoney).compareTo(forty_million) <= 0){
    			amount = amount.add(signMoney.multiply(new BigDecimal("0.0030")).setScale(2, BigDecimal.ROUND_DOWN));
    		}else{
    			amount = amount.add((forty_million.subtract(sum).abs()).multiply(new BigDecimal("0.0030")).setScale(2, BigDecimal.ROUND_DOWN));
    			amount = amount.add(algorithm_01(forty_million, sum.add(signMoney).subtract(forty_million)));
    		}
    	}
    	if(sum.compareTo(forty_million) >= 0 && sum.compareTo(fifty_million) < 0){
    		if(sum.add(signMoney).compareTo(fifty_million) <= 0){
    			amount = amount.add(signMoney.multiply(new BigDecimal("0.0050")).setScale(2, BigDecimal.ROUND_DOWN));
    		}else{
    			amount = amount.add((fifty_million.subtract(sum).abs()).multiply(new BigDecimal("0.0050")).setScale(2, BigDecimal.ROUND_DOWN));
    			amount = amount.add(algorithm_01(fifty_million, sum.add(signMoney).subtract(fifty_million)));
    		}
    	}
    	if(sum.compareTo(fifty_million) >= 0 && sum.compareTo(sixty_million) < 0){
    		if(sum.add(signMoney).compareTo(sixty_million) <= 0){
    			amount = amount.add(signMoney.multiply(new BigDecimal("0.0060")).setScale(2, BigDecimal.ROUND_DOWN));
    		}else{
    			amount = amount.add((sixty_million.subtract(sum).abs()).multiply(new BigDecimal("0.0060")).setScale(2, BigDecimal.ROUND_DOWN));
    			amount = amount.add(algorithm_01(sixty_million, sum.add(signMoney).subtract(sixty_million)));
    		}
    	}
    	if(sum.compareTo(sixty_million) >= 0){
			amount = amount.add(signMoney.multiply(new BigDecimal("0.0070")).setScale(2, BigDecimal.ROUND_DOWN));
    	}
    	return amount;
    }
    
    public BigDecimal algorithm_02(BigDecimal sum, BigDecimal signMoney){
    	BigDecimal amount = BigDecimal.ZERO;
    	if(sum.compareTo(ten_million) < 0){
    		if(sum.add(signMoney).compareTo(ten_million) <= 0){
    			amount = amount.add(signMoney.multiply(new BigDecimal("0.0005")).setScale(2, BigDecimal.ROUND_DOWN));
    		}else{
    			amount = amount.add((ten_million.subtract(sum).abs()).multiply(new BigDecimal("0.0005")).setScale(2, BigDecimal.ROUND_DOWN));
    			amount = amount.add(algorithm_02(ten_million, sum.add(signMoney).subtract(ten_million)));
    		}
    	}
    	if(sum.compareTo(ten_million) >= 0 && sum.compareTo(twenty_million) < 0){
    		if(sum.add(signMoney).compareTo(twenty_million) <= 0){
    			amount = amount.add(signMoney.multiply(new BigDecimal("0.0010")).setScale(2, BigDecimal.ROUND_DOWN));
    		}else{
    			amount = amount.add((twenty_million.subtract(sum).abs()).multiply(new BigDecimal("0.0010")).setScale(2, BigDecimal.ROUND_DOWN));
    			amount = amount.add(algorithm_02(twenty_million, sum.add(signMoney).subtract(twenty_million)));
    		}
    	}
    	if(sum.compareTo(twenty_million) >= 0 && sum.compareTo(thirty_million) < 0){
    		if(sum.add(signMoney).compareTo(thirty_million) <= 0){
    			amount = amount.add(signMoney.multiply(new BigDecimal("0.0015")).setScale(2, BigDecimal.ROUND_DOWN));
    		}else{
    			amount = amount.add((thirty_million.subtract(sum).abs()).multiply(new BigDecimal("0.0015")).setScale(2, BigDecimal.ROUND_DOWN));
    			amount = amount.add(algorithm_02(thirty_million, sum.add(signMoney).subtract(thirty_million)));
    		}
    	}
    	if(sum.compareTo(thirty_million) >= 0 && sum.compareTo(forty_million) < 0){
    		if(sum.add(signMoney).compareTo(forty_million) <= 0){
    			amount = amount.add(signMoney.multiply(new BigDecimal("0.0025")).setScale(2, BigDecimal.ROUND_DOWN));
    		}else{
    			amount = amount.add((forty_million.subtract(sum).abs()).multiply(new BigDecimal("0.0025")).setScale(2, BigDecimal.ROUND_DOWN));
    			amount = amount.add(algorithm_02(forty_million, sum.add(signMoney).subtract(forty_million)));
    		}
    	}
    	if(sum.compareTo(forty_million) >= 0 && sum.compareTo(fifty_million) < 0){
    		if(sum.add(signMoney).compareTo(fifty_million) <= 0){
    			amount = amount.add(signMoney.multiply(new BigDecimal("0.0035")).setScale(2, BigDecimal.ROUND_DOWN));
    		}else{
    			amount = amount.add((fifty_million.subtract(sum).abs()).multiply(new BigDecimal("0.0035")).setScale(2, BigDecimal.ROUND_DOWN));
    			amount = amount.add(algorithm_02(fifty_million, sum.add(signMoney).subtract(fifty_million)));
    		}
    	}
    	if(sum.compareTo(fifty_million) >= 0 && sum.compareTo(sixty_million) < 0){
    		if(sum.add(signMoney).compareTo(sixty_million) <= 0){
    			amount = amount.add(signMoney.multiply(new BigDecimal("0.0045")).setScale(2, BigDecimal.ROUND_DOWN));
    		}else{
    			amount = amount.add((sixty_million.subtract(sum).abs()).multiply(new BigDecimal("0.0045")).setScale(2, BigDecimal.ROUND_DOWN));
    			amount = amount.add(algorithm_02(sixty_million, sum.add(signMoney).subtract(sixty_million)));
    		}
    	}
    	if(sum.compareTo(sixty_million) >= 0 && sum.compareTo(seventy_million) < 0){
    		if(sum.add(signMoney).compareTo(seventy_million) <= 0){
    			amount = amount.add(signMoney.multiply(new BigDecimal("0.0050")).setScale(2, BigDecimal.ROUND_DOWN));
    		}else{
    			amount = amount.add((seventy_million.subtract(sum).abs()).multiply(new BigDecimal("0.0050")).setScale(2, BigDecimal.ROUND_DOWN));
    			amount = amount.add(algorithm_02(seventy_million, sum.add(signMoney).subtract(seventy_million)));
    		}
    	}
    	if(sum.compareTo(seventy_million) >= 0){
			amount = amount.add(signMoney.multiply(new BigDecimal("0.0060")).setScale(2, BigDecimal.ROUND_DOWN));
    	}
    	return amount;
    }
    
    public BigDecimal algorithm_03(BigDecimal sum, BigDecimal signMoney){
    	BigDecimal amount = BigDecimal.ZERO;
    	if(sum.compareTo(ten_million) < 0){
    		if(sum.add(signMoney).compareTo(ten_million) <= 0){
    			amount = amount.add(signMoney.multiply(new BigDecimal("0.0020")).setScale(2, BigDecimal.ROUND_DOWN));
    		}else{
    			amount = amount.add((ten_million.subtract(sum).abs()).multiply(new BigDecimal("0.0020")).setScale(2, BigDecimal.ROUND_DOWN));
    			amount = amount.add(algorithm_03(ten_million, sum.add(signMoney).subtract(ten_million)));
    		}
    	}
    	if(sum.compareTo(ten_million) >= 0 && sum.compareTo(twenty_million) < 0){
    		if(sum.add(signMoney).compareTo(twenty_million) <= 0){
    			amount = amount.add(signMoney.multiply(new BigDecimal("0.0030")).setScale(2, BigDecimal.ROUND_DOWN));
    		}else{
    			amount = amount.add((twenty_million.subtract(sum).abs()).multiply(new BigDecimal("0.0030")).setScale(2, BigDecimal.ROUND_DOWN));
    			amount = amount.add(algorithm_03(twenty_million, sum.add(signMoney).subtract(twenty_million)));
    		}
    	}
    	if(sum.compareTo(twenty_million) >= 0){
    		amount = amount.add(signMoney.multiply(new BigDecimal("0.0040")).setScale(2, BigDecimal.ROUND_DOWN));
    	}
    	return amount;
    }
    
    public static void main(String[] args) {
		try{
			ContractDistributionProcessor c = new ContractDistributionProcessor();
//			c.execute("{\"optType\":\"calculateAmount\",\"plateId\":43,\"contractId\":790,\"businessType\":\"4\",\"signMoney\":60000000}", null);
			c.execute("{\"details\":[{\"contractDistributionId\":404,\"contractId2\":742,\"contractId\":742,\"signingMoneySum\":3986000,\"actualMoney\":3986000,\"businessType\":4,\"plateId\":35,\"amount\":1993,\"operator\":0,\"contractDate\":1502899200000}],\"optType\":\"saveContractDistribution\",\"contractId\":\"742\",\"businessType\":\"4\",\"operator\":\"463\"}", null);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
