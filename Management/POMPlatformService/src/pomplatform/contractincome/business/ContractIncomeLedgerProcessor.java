package pomplatform.contractincome.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseContractIncomeLedger;
import com.pomplatform.db.bean.BaseInvoice;
import com.pomplatform.db.dao.ContractIncomeLedger;
import com.pomplatform.db.dao.Invoice;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.common.KeyValuePair;
import delicacy.date.util.DateUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.common.utils.StaticUtils;
import pomplatform.contractincome.bean.BaseContractIncomeBasicInfo;
import pomplatform.contractincome.bean.BaseGetContractStageByInvoice;
import pomplatform.contractincome.bean.BaseGetInvoiceContactsInfo;
import pomplatform.contractincome.bean.ConditionContractIncomeBasicInfo;
import pomplatform.contractincome.bean.ConditionGetContractStageByInvoice;
import pomplatform.contractincome.bean.ConditionGetInvoiceContactsInfo;
import pomplatform.contractincome.query.QueryContractIncomeBasicInfo;
import pomplatform.contractincome.query.QueryGetContractStageByInvoice;
import pomplatform.contractincome.query.QueryGetInvoiceContactsInfo;

public class ContractIncomeLedgerProcessor implements GenericProcessor{
	
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(params, "optType");
        switch(optType) {
        case "generateNewData":
        	return generateNewData(params);
        case "onOrUpLock":
        	return onOrUpLock(params);
    	default:
    		return null;
        }
	}

	public String generateNewData(Map<String, Object> params) throws Exception {
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		int year = BaseHelpUtils.getIntValue(params.get("ledgerYear"));
		int month = BaseHelpUtils.getIntValue(params.get("ledgerMonth"));
		ContractIncomeLedger dao = new ContractIncomeLedger();
		dao.setConditionLedgerYear("=", year);
		dao.setConditionLedgerMonth("=", month);
		List<BaseContractIncomeLedger> originalList = dao.conditionalLoad();
		//存储当月已经锁定的合同ID，在后续的操作中，这些合同将不参与计算
		StringBuilder sb = new StringBuilder();
		Map<Integer, BaseContractIncomeLedger> map = new HashMap<>();
		boolean hasHistoryData = false;
		if(null != originalList && !originalList.isEmpty()) {
			hasHistoryData = true;
			for(BaseContractIncomeLedger bean : originalList) {
				if(bean.getIsLocked()) {
					if(sb.length() > 0) {
						sb.append(",");
					}
					sb.append(bean.getContractId());
				}else {
					map.put(bean.getContractId(), bean);
				}
			}
		}
		Invoice invoiceDao = new Invoice();
		invoiceDao.unsetSelectFlags();
		invoiceDao.setSelectContractId(true);
		invoiceDao.setSelectInvoiceAmount(true);
		invoiceDao.setSelectInvoiceDate(true);
		invoiceDao.setSelectCapitalAmount(true);
		invoiceDao.setSelectIsCapital(true);
		invoiceDao.setSelectInvoiceId(true);
		invoiceDao.setSelectInvoiceNumber(true);
		invoiceDao.setConditionSign("=", StaticUtils.INVOICE_STATUS_1);
		invoiceDao.setConditionContractId(">", 0);
		Date startDate = DateUtil.createFirstDayOfMonth(year, month);
		Date endDate = DateUtil.getFirstDayOfNextMonth(startDate);
		List<BaseInvoice> allInvoiceList = invoiceDao.conditionalLoad(String.format("(is_capital != 1 or (is_capital = 1 and invoice_date >= '%1$s' and invoice_date < '%2$s')) order by invoice_date", DateUtil.formatDateTimeString(startDate), DateUtil.formatDateTimeString(endDate)));
		Map<Integer, List<BaseInvoice>> invoiceMap = new HashMap<>();
		if(null != allInvoiceList && !allInvoiceList.isEmpty()) {
			for(BaseInvoice bean : allInvoiceList) {
				List<BaseInvoice> invoiceList = invoiceMap.get(bean.getContractId());
				if(null == invoiceList) {
					invoiceList = new ArrayList<>();
				}
				invoiceList.add(bean);
				invoiceMap.put(bean.getContractId(), invoiceList);
			}
		}
		ConditionContractIncomeBasicInfo condition = new ConditionContractIncomeBasicInfo();
		condition.setCopyIncomeLedger(false);
		condition.setStartDate(startDate);
		condition.setEndDate(endDate);
		condition.setProjectType(StaticUtils.PROJECT_TYPE_16);
		if(sb.length() > 0) {
			KeyValuePair keyValue = new KeyValuePair();
			keyValue.setKey("a.copy_income_ledger = ?");
			keyValue.setValue("a.copy_income_ledger = ? and a.contract_id not in (" + sb.toString() + ") ");
			KeyValuePair[] keyValues = new KeyValuePair[1];
			keyValues[0] = keyValue;
			condition.setKeyValues(keyValues);
		}
		QueryContractIncomeBasicInfo query = new QueryContractIncomeBasicInfo();
		BaseCollection<BaseContractIncomeBasicInfo> collection = query.executeQuery(condition.getKeyValues(), condition);
		List<BaseContractIncomeLedger> newDataList = new ArrayList<>(); 
		if(null != collection && null != collection.getCollections() && !collection.getCollections().isEmpty()) {
			List<BaseContractIncomeBasicInfo> basicInfoList = collection.getCollections();
			for(BaseContractIncomeBasicInfo info : basicInfoList) {
				Integer contractId = info.getContractId();
				boolean newData = true;
				BaseContractIncomeLedger newBean = new BaseContractIncomeLedger();
				BaseContractIncomeLedger originalBean = null;
				if(hasHistoryData) {
					originalBean = map.get(contractId);
					if(null != originalBean) {
						originalBean.cloneCopy(newBean);
						newData = false;
					}
				}
				newBean.setDataFromMap(info.toMap());
				BigDecimal invoiceAmount = BigDecimal.ZERO;
				if(newBean.getContractCode().indexOf("999999999") < 0) {
					List<BaseInvoice> invoiceList = invoiceMap.get(contractId);
					if(null != invoiceList && !invoiceList.isEmpty()) {
						StringBuilder invoiceSB = new StringBuilder();
						for(BaseInvoice invoice : invoiceList) {
							if(invoiceSB.length() > 0) {
								invoiceSB.append(",");
							}
							invoiceSB.append(invoice.getInvoiceId());
							if(BaseHelpUtils.isNullOrEmpty(newBean.getInvoiceDate())) {
								newBean.setInvoiceDate(DateUtil.formatDateString(invoice.getInvoiceDate()));
							}else {
								newBean.setInvoiceDate(newBean.getInvoiceDate() + " " + DateUtil.formatDateString(invoice.getInvoiceDate()));
							}
							if(BaseHelpUtils.isNullOrEmpty(newBean.getInvoiceNumber())) {
								newBean.setInvoiceNumber(invoice.getInvoiceNumber());
							}else {
								newBean.setInvoiceNumber(newBean.getInvoiceNumber() + " " + invoice.getInvoiceNumber());
							}
						}
						if(invoiceSB.length() > 0) {
							//阶段信息
							ConditionGetContractStageByInvoice stageCondition = new ConditionGetContractStageByInvoice();
							KeyValuePair stageKV = new KeyValuePair();
							stageKV.setKey("where a.invoice_id = ?");
							stageKV.setValue("where a.invoice_id = ? and a.invoice_id in (" + invoiceSB.toString() + ")");
							KeyValuePair[] stageKVs = new KeyValuePair[1];
							stageKVs[0] = stageKV;
							QueryGetContractStageByInvoice stageQuery = new QueryGetContractStageByInvoice();
							BaseCollection<BaseGetContractStageByInvoice> stageCollection = stageQuery.executeQuery(stageKVs, stageCondition);
							if(null != stageCollection && null != stageCollection.getCollections() && !stageCollection.getCollections().isEmpty()) {
								List<BaseGetContractStageByInvoice> stageList = stageCollection.getCollections();
								StringBuilder stageSB = new StringBuilder();
								for(BaseGetContractStageByInvoice stage : stageList) {
									boolean isParentNode = BaseHelpUtils.getIntValue(stage.getParentId()) == 0 ? true : false;
									if(stageSB.length() > 0) {
										if(isParentNode) {
											stageSB.append("]; ");
										}else {
											stageSB.append(" ");
										}
									}
									stageSB.append(stage.getReceivableName());
									if(isParentNode) {
										stageSB.append("[");
									}
								}
								newBean.setInvoiceStage(stageSB.toString());
							}
							//联系人信息
							ConditionGetInvoiceContactsInfo contactsCondition = new ConditionGetInvoiceContactsInfo();
							KeyValuePair ciKV = new KeyValuePair();
							ciKV.setKey("where a.invoice_id = ?");
							ciKV.setValue("where a.invoice_id = ? and a.invoice_id in (" + invoiceSB.toString() + ")");
							KeyValuePair[] ciKVArr = new KeyValuePair[1];
							ciKVArr[0] = ciKV;
							QueryGetInvoiceContactsInfo contactsQuery = new QueryGetInvoiceContactsInfo();
							BaseCollection<BaseGetInvoiceContactsInfo> contactsBC = contactsQuery.executeQuery(ciKVArr, contactsCondition);
							if(null != contactsBC && null != contactsBC.getCollections() && !contactsBC.getCollections().isEmpty()) {
								List<BaseGetInvoiceContactsInfo> contactsList = contactsBC.getCollections();
								StringBuilder contactsSB = new StringBuilder();
								for(BaseGetInvoiceContactsInfo contacts : contactsList) {
									StringBuilder tempSB = new StringBuilder();
									tempSB.append(contacts.getCustomerName());
									if(!BaseHelpUtils.isNullOrEmpty(contacts.getCustomerPhone()) && !Objects.equals(BaseHelpUtils.getString(contacts.getCustomerPhone()).toLowerCase(), "xxx") && !Objects.equals(BaseHelpUtils.getString(contacts.getCustomerPhone()).toLowerCase(), "xx") && !Objects.equals(contacts.getCustomerPhone(), "000")) {
										tempSB.append(" 联系电话:").append(contacts.getCustomerPhone());
									}
									if(!BaseHelpUtils.isNullOrEmpty(contacts.getEmail()) && !Objects.equals(BaseHelpUtils.getString(contacts.getEmail()).toLowerCase(), "xxx") && !Objects.equals(BaseHelpUtils.getString(contacts.getEmail()).toLowerCase(), "xx") && !Objects.equals(contacts.getEmail(), "000")) {
										tempSB.append(" 邮箱:").append(contacts.getEmail());
									}
									if(!BaseHelpUtils.isNullOrEmpty(contacts.getLandline()) && !Objects.equals(BaseHelpUtils.getString(contacts.getLandline()).toLowerCase(), "xxx") && !Objects.equals(BaseHelpUtils.getString(contacts.getLandline()).toLowerCase(), "xx") && !Objects.equals(contacts.getLandline(), "000")) {
										tempSB.append(" 座机:").append(contacts.getLandline());
									}
									if(!BaseHelpUtils.isNullOrEmpty(contacts.getFax()) && !Objects.equals(BaseHelpUtils.getString(contacts.getFax()).toLowerCase(), "xxx") && !Objects.equals(BaseHelpUtils.getString(contacts.getFax()).toLowerCase(), "xx") && !Objects.equals(contacts.getFax(), "000")) {
										tempSB.append(" 传真:").append(contacts.getFax());
									}
									if(contactsSB.length() > 0) {
										if(contactsSB.toString().indexOf(tempSB.toString()) < 0) {
											//联系人去重
											contactsSB.append("; ").append(tempSB.toString());
										}
									}else {
										contactsSB.append(tempSB.toString());
									}
								}
								newBean.setContacts(contactsSB.toString());
							}
						}
					}
				}
				newBean.setInvoiceAmount(invoiceAmount);
				newBean.setIsLocked(false);
				newBean.setLedgerYear(year);
				newBean.setLedgerMonth(month);
				if(newData) {
					newBean.setCreateTime(new Date());
					newDataList.add(newBean);
				}else {
					newBean.setUpdateTime(new Date());
					dao.clear();
					dao.setDataFromBase(originalBean);
					dao.clearModifiedFlags();
					dao.setDataFromBase(newBean);
					dao.update();
				}
			}
		}
		if(!newDataList.isEmpty()) {
			dao.clear();
			dao.save(newDataList);
		}
		return bc.toJSON();
	}
	
	/**
	 * 
	 * @Title: 
	 * @Description: 加锁或解锁
	 * @param @param result
	 * @param @return
	 * @param @throws Exception    
	 * @return String   
	 * @throws
	 */
	@SuppressWarnings("rawtypes")
	private String onOrUpLock(Map result) throws Exception{
		BaseCollection bc = new BaseCollection<>();
		int status = -1 ;
		@SuppressWarnings("unchecked")
		String lockoper=BaseHelpUtils.getString(result.get("status"));
		String value=BaseHelpUtils.getString(result.get("values"));
		Integer[] intArr = new Integer[0];
	    if(BaseHelpUtils.isNullOrEmpty(value)){
	    	throw new Exception("获取数据失败"); 
	    }else{
	        String[] valueArr = value.split(",");
	        intArr = new Integer[valueArr.length];
	        for (int i = 0; i < valueArr.length; i++) {
	            intArr[i] = Integer.parseInt(valueArr[i]);
	        }
	        ContractIncomeLedger  dao=new ContractIncomeLedger();
	        dao.addCondition(BaseContractIncomeLedger.CS_CONTRACT_INCOME_LEDGER_ID, "in", intArr);
	        if(lockoper.equals("onlock")) {
	        	dao.setIsLocked(true);
	        }else if(lockoper.equals("uplock")) {
	        	dao.setIsLocked(false);
	        }else {
	        	throw new Exception("找不到操作类型！"); 
	        }
	        dao.conditionalUpdate();
	    }
		status=1;
		return bc.toJSON(status,"");
	}
	
	
	public static void main(String[] args) {
		try {
			ContractIncomeLedgerProcessor a = new ContractIncomeLedgerProcessor();
			Map<String, Object> params = new HashMap<>();
			params.put("ledgerYear", 2018);
			params.put("ledgerMonth", 12);
			a.generateNewData(params);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
