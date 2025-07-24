package pomplatform.workflow.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.pomplatform.db.bean.BaseReimbursementInvoiceInformation;
import com.pomplatform.db.dao.ReimbursementInvoiceInformation;

import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.MapUtils;

public class ReimbursementInvoiceUtils {

	@SuppressWarnings("unchecked")
	public static void saveOrUpdateReimbusementInvoiceData(Set<Integer> oriDetailIdSet, int businessId, int processType,
			List<Map<String, Integer>> mainListData, Map<String, Object> invoiceListMap, int operateType) throws SQLException {
//		System.out.println("mainListData.size =================== " + mainListData.size());
//		System.out.println("invoiceListMap.size =================== " + invoiceListMap.size());
//		for (String a : invoiceListMap.keySet()) {
//			System.out.println(" key = " + a + "--- value =" + MapUtils.toJSONString((Map)invoiceListMap.get(a)));
//		}
		ReimbursementInvoiceInformation dao = new ReimbursementInvoiceInformation();
		// 处理已经被删除的费用分摊详情发票数据表
		if(operateType == 2 && null != oriDetailIdSet && oriDetailIdSet.size() > 0) {
			Set<Integer> deleteIdSet = new HashSet<>();
			Set<Integer> checkIdSet = new HashSet<>();
			for (Map<String, Integer> map : mainListData) {
				Integer detailId = map.get("detailId");
				checkIdSet.add(detailId);
			}
			for (Integer intkey : oriDetailIdSet) {
				if(!checkIdSet.contains(intkey)) {
					deleteIdSet.add(intkey);
				}
			}
			// 删除已经被删除费用分拆明细相关联的发票数据
			if(deleteIdSet.size() > 0) {
				dao.setConditionBusinessId("=", businessId);
				dao.setConditionProcessType("=", processType);
				dao.addCondition(BaseReimbursementInvoiceInformation.CS_DETAIL_ID, "in", deleteIdSet.toArray());
				dao.conditionalDelete();
			}
		}
		
		Date currentDate = new Date();
		
		if(null != invoiceListMap && mainListData.size() > 0) {
			List<BaseReimbursementInvoiceInformation> list = new ArrayList<>();
			for (Map<String, Integer> map : mainListData) {
				String invoiceLinkKey = BaseHelpUtils.getStringValue(map, "invoiceLinkKey");
				Integer detailId = map.get("detailId");
				System.out.println(" invoiceLinkKey ---- detailId  " + invoiceLinkKey + " --- " + detailId);
				if (null != invoiceLinkKey) {
					if (invoiceListMap.containsKey(invoiceLinkKey)) {
						Map tmpMap = (Map) invoiceListMap.get(invoiceLinkKey);
						System.out.println(" tmpMap  " + tmpMap.size());
						System.out.println(" tmpMap.containsKey(\"invoiceList\")=== " +  tmpMap.containsKey("invoiceList"));
						if (tmpMap.containsKey("invoiceList")) {
							if(operateType == 2) {// 修改
								dao.clear();
								dao.setConditionBusinessId("=", businessId);
								dao.setConditionProcessType("=", processType);
								dao.setConditionDetailId("=", detailId);
								dao.conditionalDelete();
							}
							List<BaseReimbursementInvoiceInformation> tmpList = GenericBase.__getList(
									tmpMap.get("invoiceList"), BaseReimbursementInvoiceInformation.newInstance());
							if(null != tmpList && tmpList.size() > 0) {
								for (BaseReimbursementInvoiceInformation baseReimbursementInvoiceInformation : tmpList) {
									baseReimbursementInvoiceInformation.setBusinessId(businessId);
									baseReimbursementInvoiceInformation.setProcessType(processType);
									baseReimbursementInvoiceInformation.setDetailId(detailId);
									baseReimbursementInvoiceInformation.setCreateTime(currentDate);
								}
								list.addAll(tmpList);
							}
						}
					}
				}
			}
			if(list.size() > 0) {
				dao.clear();
				dao.save(list);
			}
		}
	}
}
