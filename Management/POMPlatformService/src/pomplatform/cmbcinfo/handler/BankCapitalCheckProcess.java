package pomplatform.cmbcinfo.handler;

import java.io.StringReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseBankCapitalCheckLink;
import com.pomplatform.db.bean.BaseCapital;
import com.pomplatform.db.bean.BaseCardManage;
import com.pomplatform.db.bean.BaseCmbcTransInfo;
import com.pomplatform.db.bean.BaseCompanyRecord;
import com.pomplatform.db.dao.BankCapitalCheckLink;
import com.pomplatform.db.dao.Capital;
import com.pomplatform.db.dao.CardManage;
import com.pomplatform.db.dao.CmbcTransInfo;
import com.pomplatform.db.dao.CompanyRecord;
import com.pomplatform.db.dao.ReceiveUnitManage;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.common.KeyValuePair;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.cmbcinfo.bean.BaseMcmbctransinfolinktattlor;
import pomplatform.cmbcinfo.bean.ConditionMcmbctransinfolinktattlor;
import pomplatform.cmbcinfo.query.QueryMcmbctransinfolinktattlor;
import pomplatform.itemCollection.custom.query.CustomItemCollectionHandler;

public class BankCapitalCheckProcess implements GenericProcessor {

	private final static SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMddHHmmss");

	/**
	 * 收入
	 */
	private final static int LINK_TYPE_ONE = 1;

	/**
	 * 支出
	 */
	private final static int LINK_TYPE_TWO = 2;

	/**
	 * 1:cmbc_trans_info
	 */
	private final static int BUSINESS_TYPE_ONE = 1;

	/**
	 * 2:capitals
	 */
	private final static int BUSINESS_TYPE_TWO = 2;

	// 收款绑定
	private final static String RECEIVE_BIND = "receivebind";
	// 支出绑定
	private final static String PAY_BIND = "payBind";
	// 根据绑定code与交易类型获取交易流水
	private final static String GET_TRANSINFO_BY_CODE = "getTransinfoByCode";
	// 根据绑定code与交易类型获取收入支出流水
	private final static String GET_CAPITAL_BY_CODE = "getCapitalByCode";
	// 银行流水流入资金表
	private final static String CMB_TRANS_TO_CAPITAL = "cmbTransToCapital";
	// 解绑
	private final static String RECEIVE_UNBIND = "receiveUnbind";
	// 自动绑定银行流水与ERP流水
	private final static String AUTO_BIND_TRANS_AND_CAPITALS = "autoBindTransAndCapitals";

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		String optType = BaseHelpUtils.getStringValue(result, "opt_type");
		if (!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(optType)) {
			switch (optType) {
			case RECEIVE_BIND:
				return receivebind(result);
			case PAY_BIND:
				return payBind(result);
			case GET_TRANSINFO_BY_CODE:
				return getTransinfoByCode(result);
			case GET_CAPITAL_BY_CODE:
				return getCapitalByCode(result);
			case CMB_TRANS_TO_CAPITAL:
				return cmbTransToCapital(result);
			case RECEIVE_UNBIND:
				return receiveUnbind(result);
			case AUTO_BIND_TRANS_AND_CAPITALS:
				return autoBindTransAndCapitals(result);
			}
		}
		return null;
	}

	/**
	 * 付款核对绑定
	 * @param params
	 * @return
	 * @throws Exception
	 */
	private String payBind(Map<String, Object> params) throws Exception {
		int status = 1;
		String errorMsg = "";
		String transInfoIds = BaseHelpUtils.getStringValue(params, "transInfoIds");
		String capitalIds = BaseHelpUtils.getStringValue(params, "capitalIds");
		Integer employeeId = BaseHelpUtils.getIntValue(params, "employeeId");

		if (!BaseHelpUtils.isNullOrEmpty(transInfoIds) && !BaseHelpUtils.isNullOrEmpty(capitalIds)) {
			BankCapitalCheckLink bcckDao = new BankCapitalCheckLink();
			StringBuilder sql = new StringBuilder();
			sql.append("(").append(BaseBankCapitalCheckLink.CS_BUSINESS_ID).append(" in (").append(transInfoIds)
					.append(") and ").append(BaseBankCapitalCheckLink.CS_BUSINESS_TYPE).append("=1").append(") or (")
					.append(BaseBankCapitalCheckLink.CS_BUSINESS_ID).append(" in (").append(capitalIds).append(") and ")
					.append(BaseBankCapitalCheckLink.CS_BUSINESS_TYPE).append("=2").append(") and ")
					.append(BaseBankCapitalCheckLink.CS_LINK_TYPE).append("=2");
			if (bcckDao.countRows(sql.toString()) <= 0) {
				Date currentDate = new Date();
				String[] transInfoIdArra = transInfoIds.split(",");
				String[] capitalIdArra = capitalIds.split(",");
				// 生成唯一识别code作为标定表示
				String code = SDF.format(currentDate) + "-"
						+ String.format("%03d", (transInfoIdArra.length + capitalIdArra.length)) + "-" + employeeId;
				List<BaseBankCapitalCheckLink> list = new ArrayList<>();
				for (String string : transInfoIdArra) {
					BaseBankCapitalCheckLink bean = new BaseBankCapitalCheckLink();
					bean.setBusinessId(BaseHelpUtils.getIntValue(string));
					bean.setBusinessType(BUSINESS_TYPE_ONE);
					bean.setCode(code);
					bean.setCreateTime(currentDate);
					bean.setOperator(employeeId);
					bean.setLinkType(LINK_TYPE_TWO);
					list.add(bean);
				}
				for (String string : capitalIdArra) {
					BaseBankCapitalCheckLink bean = new BaseBankCapitalCheckLink();
					bean.setBusinessId(BaseHelpUtils.getIntValue(string));
					bean.setBusinessType(BUSINESS_TYPE_TWO);
					bean.setCode(code);
					bean.setCreateTime(currentDate);
					bean.setOperator(employeeId);
					bean.setLinkType(LINK_TYPE_TWO);
					list.add(bean);
				}
				if (list.size() > 0) {
					bcckDao.clear();
					bcckDao.save(list);
				}
			} else {
				status = -1;
				errorMsg = "选中的数据包含已经绑定的数据, 请重新选择！";
			}

		} else {
			status = -1;
		}
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(status, errorMsg);
	}
	
	private String receiveUnbind(Map<String, Object> params) throws Exception {
		int status = 1;
		String errorMsg = "";
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		String code = BaseHelpUtils.getStringValue(params, "code");
		if (!BaseHelpUtils.isNullOrEmpty(code)) {
			BankCapitalCheckLink dao = new BankCapitalCheckLink();
			dao.setConditionCode("=", code);
			dao.conditionalDelete();
		} else {
			status = 1;
			errorMsg = "参数错误 code =" + code;
		}
		return bc.toJSON(status, errorMsg);
	}

	private String cmbTransToCapital(Map<String, Object> params) throws Exception {
		List<Map<String, Object>> list = (List<Map<String, Object>>) params.get("list");

		if (list.size() > 0) {
			int employeeId = BaseHelpUtils.getIntValue(params, "employeeId");
			Date currentDate = new Date();
			String prefix = SDF.format(currentDate);
			int index = 1;
			Capital ciDao = new Capital();
			BankCapitalCheckLink linkDao = new BankCapitalCheckLink();
			CardManage cmDao = new CardManage();
			cmDao.setConditionObjectType("=", 2);

			ReceiveUnitManage rumDao = new ReceiveUnitManage();
			for (Map<String, Object> map : list) {
				String code = prefix + "-" + String.format("%03d", index) + "-" + employeeId;

				BaseMcmbctransinfolinktattlor ctiBean = new BaseMcmbctransinfolinktattlor();
				ctiBean.setDataFromMap(map);

				// 设置账单流水收入数据
				BaseCapital bean = new BaseCapital();

				// 设置付款方数据
				String otherBankAccount = ctiBean.getRpyacc();
				String otherBankName = ctiBean.getRpybnk();
				String otherName = ctiBean.getRpynam();
				String otherBankAddress = ctiBean.getRpyadr();
				bean.setOtherBankAccount(otherBankAccount);
				bean.setOtherBankName(otherBankName);
				bean.setOtherName(otherName);
				if (!BaseHelpUtils.isNullOrEmpty(otherBankAccount)) {
					rumDao.clear();
					rumDao.setConditionBankAccount("=", otherBankAccount, " or ");
					rumDao.setConditionBankName("=", otherName, " or ");
					if (rumDao.countRows() <= 0) {
						rumDao.setBankAccount(otherBankAccount);
						rumDao.setBankName(otherBankName);
						rumDao.setReceiveUnit(otherName);
						rumDao.setReceiveUnitAddress(otherBankAddress);
						rumDao.setOperateEmployeeId(employeeId);
						rumDao.setOperateTime(currentDate);
						rumDao.save();
					}
				}

				if (null != map.get("moneyAttribute")) {
					bean.setMoneyAttribute(BaseHelpUtils.getIntValue(map, "moneyAttribute"));
				}
				if (null != map.get("capitalRemark")) {
					bean.setRemark(BaseHelpUtils.getStringValue(map, "capitalRemark"));
				}
				if (null != map.get("contractId")) {
					int contractId = BaseHelpUtils.getIntValue(map, "contractId");
					if(contractId > 0){
						bean.setContractId(contractId);
					}
				}
				cmDao.setConditionBankAccount("=", ctiBean.getBankAccount());
				// 设置收款方信息
				bean.setSelfName(ctiBean.getCompanyRecordId());
				bean.setSelfBankAccount(ctiBean.getBankAccount());
				if (null != cmDao.executeQueryOneRow()) {
					bean.setSelfName(cmDao.getObjectId());
					bean.setSelfBankName(cmDao.getBankAddress());
				}
				bean.setHappenDate(ctiBean.getTransDate());
				bean.setCreateDate(currentDate);
				bean.setOperator(employeeId);
				bean.setCapitalType(1);// 类型收入
				bean.setBorrowMoney(ctiBean.getTrsamtc());
				bean.setExchangeRate(new BigDecimal("1"));
				bean.setOriginalCurrency(ctiBean.getTrsamtc());
				ciDao.setDataFromBase(bean);
				ciDao.save();
				
				//绑定合同
				if(null != ciDao.getContractId() && ciDao.getContractId() > 0 ){
					Map<String, Object> bindMap = new HashMap<>();
					bindMap.put("ids", ciDao.getCapitalId());
					bindMap.put("contractId", ciDao.getContractId());
					bindMap.put("operator", employeeId);
					CustomItemCollectionHandler.bingContract(bindMap);

				}
				
				// 设置关联数据
				List<BaseBankCapitalCheckLink> linkList = new ArrayList<>();
				BaseBankCapitalCheckLink linkOne = new BaseBankCapitalCheckLink();
				linkOne.setCreateTime(currentDate);
				linkOne.setCode(code);
				linkOne.setBusinessId(ctiBean.getCmbcTransInfoId());
				linkOne.setBusinessType(BUSINESS_TYPE_ONE);
				linkOne.setOperator(employeeId);
				linkOne.setLinkType(LINK_TYPE_ONE);

				BaseBankCapitalCheckLink linkTwo = new BaseBankCapitalCheckLink();
				linkTwo.setCreateTime(currentDate);
				linkTwo.setCode(code);
				linkTwo.setBusinessId(ciDao.getCapitalId());
				linkTwo.setBusinessType(BUSINESS_TYPE_TWO);
				linkTwo.setOperator(employeeId);
				linkTwo.setLinkType(LINK_TYPE_ONE);

				linkList.add(linkOne);
				linkList.add(linkTwo);
				linkDao.save(linkList);

				index++;
			}
		}

		return null;
	}

	private String getCapitalByCode(Map<String, Object> params) throws Exception {
		int status = 1;
		String errorMsg = null;
		String code = BaseHelpUtils.getStringValue(params, "code");
		int linkType = BaseHelpUtils.getIntValue(params, "linkType");
		BaseCollection<BaseCapital> bc = new BaseCollection<>();
		if (linkType > 0) {
			BankCapitalCheckLink bcclDao = new BankCapitalCheckLink();
			if (BaseHelpUtils.isNullOrEmpty(code)) {
				int capitalId = BaseHelpUtils.getIntValue(params, "capitalId");
				if (capitalId > 0) {
					bcclDao.setConditionBusinessId("=", capitalId);
					bcclDao.setConditionBusinessType("=", BUSINESS_TYPE_TWO);
					bcclDao.setConditionLinkType("=", linkType);
					if (null != bcclDao.executeQueryOneRow()) {
						code = bcclDao.getCode();
					}
				}
			}
			if (!BaseHelpUtils.isNullOrEmpty(code)) {
				Capital cDao = new Capital();
				StringBuilder sql = new StringBuilder();
				sql.append(BaseCapital.CS_CAPITAL_ID)
						.append(" in (SELECT business_id FROM bank_capital_check_links WHERE business_type = 2 AND code = '")
						.append(code).append("')");
				List<BaseCapital> list = cDao.conditionalLoad(sql.toString());
				bc.setCollections(list);
			} else {
				status = -1;
			}
		} else {
			status = -1;
		}

		return bc.toJSON(status, errorMsg);
	}

	public static String getTransinfoByCode(Map<String, Object> params) throws Exception {
		int status = 1;
		String errorMsg = null;
		String code = BaseHelpUtils.getStringValue(params, "code");
		int linkType = BaseHelpUtils.getIntValue(params, "linkType");
		BaseCollection<BaseMcmbctransinfolinktattlor> bc = new BaseCollection<>();
		if (linkType > 0) {
			BankCapitalCheckLink bcclDao = new BankCapitalCheckLink();
			if (BaseHelpUtils.isNullOrEmpty(code)) {
				int transInfoId = BaseHelpUtils.getIntValue(params, "transInfoId");
				if (transInfoId > 0) {
					bcclDao.setConditionBusinessId("=", transInfoId);
					bcclDao.setConditionBusinessType("=", BUSINESS_TYPE_ONE);
					bcclDao.setConditionLinkType("=", linkType);
					if (null != bcclDao.executeQueryOneRow()) {
						code = bcclDao.getCode();
					}
				}
			}
			if (!BaseHelpUtils.isNullOrEmpty(code)) {
				CmbcTransInfo ctiDao = new CmbcTransInfo();
				StringBuilder sql = new StringBuilder();
				sql.append(BaseCmbcTransInfo.CS_CMBC_TRANS_INFO_ID)
						.append(" in (SELECT business_id FROM bank_capital_check_links WHERE business_type = 1 AND code = '")
						.append(code).append("')");
				List<BaseCmbcTransInfo> list = ctiDao.conditionalLoad(sql.toString());
				List<BaseMcmbctransinfolinktattlor> transList = new ArrayList<>();
				CardManage crDao = new CardManage();
				crDao.setConditionObjectType("=", 2);
				List<BaseCardManage> crList = crDao.conditionalLoad();
				CompanyRecord companyRecordDao = new CompanyRecord();
				List<BaseCompanyRecord> companyRecordList = companyRecordDao.conditionalLoad();

				for (BaseCmbcTransInfo baseCmbcTransInfo : list) {
					BaseMcmbctransinfolinktattlor bean = new BaseMcmbctransinfolinktattlor();
					bean.setDataFromJSON(baseCmbcTransInfo.toJSON());
					bean.setTransDate(baseCmbcTransInfo.getTransDate());
					int companyId = getCompanyIdByBankaccount(crList, baseCmbcTransInfo.getBankAccount());
					bean.setCompanyRecordId(companyId);
					bean.setAccnam(getCompanyNameByBankaccount(companyRecordList, companyId));
					transList.add(bean);
				}

				bc.setCollections(transList);
			} else {
				status = -1;
			}
		} else {
			status = -1;
		}

		return bc.toJSON(status, errorMsg);

	}

	private String receivebind(Map<String, Object> params) throws Exception {
		int status = 1;
		String errorMsg = "";
		String transInfoIds = BaseHelpUtils.getStringValue(params, "transInfoIds");
		String capitalIds = BaseHelpUtils.getStringValue(params, "capitalIds");
		Integer employeeId = BaseHelpUtils.getIntValue(params, "employeeId");

		if (!BaseHelpUtils.isNullOrEmpty(transInfoIds) && !BaseHelpUtils.isNullOrEmpty(capitalIds)) {
			BankCapitalCheckLink bcckDao = new BankCapitalCheckLink();
			StringBuilder sql = new StringBuilder();
			sql.append("(").append(BaseBankCapitalCheckLink.CS_BUSINESS_ID).append(" in (").append(transInfoIds)
					.append(") and ").append(BaseBankCapitalCheckLink.CS_BUSINESS_TYPE).append("=1").append(") or (")
					.append(BaseBankCapitalCheckLink.CS_BUSINESS_ID).append(" in (").append(capitalIds).append(") and ")
					.append(BaseBankCapitalCheckLink.CS_BUSINESS_TYPE).append("=2").append(") and ")
					.append(BaseBankCapitalCheckLink.CS_LINK_TYPE).append("=1");
			if (bcckDao.countRows(sql.toString()) <= 0) {
				Date currentDate = new Date();
				String[] transInfoIdArra = transInfoIds.split(",");
				String[] capitalIdArra = capitalIds.split(",");
				// 生成唯一识别code作为标定表示
				String code = SDF.format(currentDate) + "-"
						+ String.format("%03d", (transInfoIdArra.length + capitalIdArra.length)) + "-" + employeeId;
				List<BaseBankCapitalCheckLink> list = new ArrayList<>();
				for (String string : transInfoIdArra) {
					BaseBankCapitalCheckLink bean = new BaseBankCapitalCheckLink();
					bean.setBusinessId(BaseHelpUtils.getIntValue(string));
					bean.setBusinessType(BUSINESS_TYPE_ONE);
					bean.setCode(code);
					bean.setCreateTime(currentDate);
					bean.setOperator(employeeId);
					bean.setLinkType(LINK_TYPE_ONE);
					list.add(bean);
				}
				for (String string : capitalIdArra) {
					BaseBankCapitalCheckLink bean = new BaseBankCapitalCheckLink();
					bean.setBusinessId(BaseHelpUtils.getIntValue(string));
					bean.setBusinessType(BUSINESS_TYPE_TWO);
					bean.setCode(code);
					bean.setCreateTime(currentDate);
					bean.setOperator(employeeId);
					bean.setLinkType(LINK_TYPE_ONE);
					list.add(bean);
				}
				if (list.size() > 0) {
					bcckDao.clear();
					bcckDao.save(list);
				}
			} else {
				status = -1;
				errorMsg = "选中的数据包含已经绑定的数据, 请重新选择！";
			}

		} else {
			status = -1;
		}
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(status, errorMsg);
	}

	public static Integer getCompanyIdByBankaccount(List<BaseCardManage> list, String bankAccount) {
		for (BaseCardManage baseCardManage : list) {
			if (baseCardManage.getBankAccount().equals(bankAccount)) {
				return baseCardManage.getObjectId();
			}
		}
		return null;
	}

	public static String getCompanyNameByBankaccount(List<BaseCompanyRecord> list, Integer objectId) {
		for (BaseCompanyRecord baseCompanyRecord : list) {
			if (Objects.equals(baseCompanyRecord.getCompanyRecordId(), objectId)) {
				return baseCompanyRecord.getCompanyName();
			}
		}
		return null;
	}
	
	public static String autoBindTransAndCapitals(Map<String, Object> params) throws Exception{
		Date startDate = GenericBase.__getDate(params.get("minTransDate"));
		Date endDate = GenericBase.__getDate(params.get("maxTransDate"));
		int linkType = BaseHelpUtils.getIntValue(params, "linkType");
		int transType = BaseHelpUtils.getIntValue(params, "transType");
		int employeeId = BaseHelpUtils.getIntValue(params, "employeeId");
		if((linkType == 1 || linkType == 2) && (transType == 1 || transType == 2)){//1: 收入    2:支出
			//查询出未进行绑定的数据
			ConditionMcmbctransinfolinktattlor c = new ConditionMcmbctransinfolinktattlor();
			c.setMinTransDate(startDate);
			c.setMaxTransDate(endDate);
			c.setLinkType(linkType);
			c.setTransType(transType);
			
			KeyValuePair kv = new KeyValuePair();
			kv.setKey("link_num > ?");
			kv.setValue("link_num > ? and link_num isnull");
			
			KeyValuePair [] keyvalues = new KeyValuePair[1];
			keyvalues[0] = kv;
			
			c.setKeyValues(keyvalues);
			
			
			QueryMcmbctransinfolinktattlor dao = new QueryMcmbctransinfolinktattlor();
			dao.setCurrentPage(c.getCurrentPage());
			dao.setPageLines(c.getPageLines());
			BaseCollection<BaseMcmbctransinfolinktattlor> result = dao.executeQuery( c.getKeyValues(), c) ;
			List<BaseMcmbctransinfolinktattlor> list = result.getCollections();
			if(list.size() > 0){
				Date currentDate = new Date();
				BankCapitalCheckLink cclDao = new BankCapitalCheckLink();
				Capital cDao = new Capital();
				int num = 0;
				List<BaseBankCapitalCheckLink> linkList = new ArrayList<>();
				for (BaseMcmbctransinfolinktattlor baseMcmbctransinfolinktattlor : list) {
					if(null != baseMcmbctransinfolinktattlor.getTrsamtc()){
						StringBuilder sb = new StringBuilder();
						sb.append(BaseCapital.CS_HAPPEN_DATE)
							.append(" > '")
							.append(baseMcmbctransinfolinktattlor.getEtydat())
							.append(" 00:00:01' and ")
							.append(BaseCapital.CS_HAPPEN_DATE)
							.append(" < '")
							.append(baseMcmbctransinfolinktattlor.getEtydat())
							.append(" 23:59:59'");
						cDao.clear();
						cDao.setConditionCapitalType("=", 1);
						cDao.setConditionBorrowMoney("=", baseMcmbctransinfolinktattlor.getTrsamtc());
						cDao.setConditionSelfBankAccount("=", baseMcmbctransinfolinktattlor.getBankAccount());
						BaseCapital cBean = cDao.executeQueryOneRow(sb.toString());
						if(null != cBean){
							cclDao.clear();
							cclDao.setConditionLinkType("=", linkType);
							cclDao.setConditionBusinessType("=", 2);
							cclDao.setConditionBusinessId("=", cBean.getCapitalId());
							if(!cclDao.isExist()){
								num ++;
								// 生成唯一识别code作为标定表示
								String code = SDF.format(currentDate) + "-"
										+ String.format("%03d", 2) + "-" + num + "-" + employeeId;
								BaseBankCapitalCheckLink transBean = new BaseBankCapitalCheckLink();
								transBean.setBusinessId(baseMcmbctransinfolinktattlor.getCmbcTransInfoId());
								transBean.setBusinessType(BUSINESS_TYPE_ONE);
								transBean.setCode(code);
								transBean.setCreateTime(currentDate);
								transBean.setOperator(employeeId);
								transBean.setLinkType(linkType);
								linkList.add(transBean);
								
								BaseBankCapitalCheckLink capitalBean = new BaseBankCapitalCheckLink();
								capitalBean.setBusinessId(cBean.getCapitalId());
								capitalBean.setBusinessType(BUSINESS_TYPE_TWO);
								capitalBean.setCode(code);
								capitalBean.setCreateTime(currentDate);
								capitalBean.setOperator(employeeId);
								capitalBean.setLinkType(linkType);
								linkList.add(capitalBean);
								
							}
						}
						
					}
				}
				cclDao.save(linkList);
			}
			
		}
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(1, null);
	}

	public static void main(String[] args) throws Exception {
		// Map<String, Object> params = new HashMap<>();
		// params.put("transInfoIds", "4,3");
		// params.put("employeeId", 1);
		// params.put("capitalIds", "5,6");
		// new BankCapitalCheckProcess().receivebind(params);
		// CardManage d = new CardManage();
		// d.setConditionObjectType("=", 2);
		// List<BaseCardManage> list = d.conditionalLoad();
		// System.out.println(getCompanyIdByBankaccount(list,
		// "814482506410001"));
//		Map<String, Object> params = new HashMap<>();
//		params.put("code", "20180129160721-000-0");
//		params.put("linkType", 1);
//		System.out.println(getTransinfoByCode(params));
		Map<String, Object> params = new HashMap<>();
		params.put("linkType", 1);
		params.put("transType", 1);
		System.out.println(autoBindTransAndCapitals(params));
	}
}
