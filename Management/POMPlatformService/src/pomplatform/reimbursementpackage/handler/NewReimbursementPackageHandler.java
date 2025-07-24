package pomplatform.reimbursementpackage.handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.GenericQuery;
import pomplatform.common.utils.StaticUtils;
import pomplatform.reimbursementpackage.bean.BaseBorrowMoneyStatus2;
import pomplatform.reimbursementpackage.bean.BaseNewReimbursementPackage;
import pomplatform.reimbursementpackage.bean.BaseNormalReimbursementStatus2;
import pomplatform.reimbursementpackage.bean.BasePayMoneyStatus2;
import pomplatform.reimbursementpackage.bean.BaseTravelReimbursementStatus2;
import pomplatform.reimbursementpackage.bean.ConditionBorrowMoneyStatus2;
import pomplatform.reimbursementpackage.bean.ConditionNewReimbursementPackage;
import pomplatform.reimbursementpackage.bean.ConditionNormalReimbursementStatus2;
import pomplatform.reimbursementpackage.bean.ConditionPayMoneyStatus2;
import pomplatform.reimbursementpackage.bean.ConditionTravelReimbursementStatus2;
import pomplatform.reimbursementpackage.query.QueryBorrowMoneyStatus2;
import pomplatform.reimbursementpackage.query.QueryNormalReimbursementStatus2;
import pomplatform.reimbursementpackage.query.QueryPayMoneyStatus2;
import pomplatform.reimbursementpackage.query.QueryTravelReimbursementStatus2;

public class NewReimbursementPackageHandler implements GenericQuery {

	private static final Logger __logger = Logger.getLogger(NewReimbursementPackageHandler.class);

	static class ProcessInstanceIdComparator implements Comparator {  
        public int compare(Object object1, Object object2) {// 实现接口中的方法  
        	BaseNewReimbursementPackage p1 = (BaseNewReimbursementPackage) object1; // 强制转换  
        	BaseNewReimbursementPackage p2 = (BaseNewReimbursementPackage) object2;  
            return new Double(p1.getProcessInstanceId()).compareTo(new Double(p2.getProcessInstanceId()));  
        }  
    } 
	
	@Override
	public String find(String creteria) throws Exception {
		List<BaseNewReimbursementPackage> list = new ArrayList<>();
		ConditionNewReimbursementPackage c = new ConditionNewReimbursementPackage();
		c.setDataFromJSON(creteria);
		//如果流程类型为空，则查出所有
		if (null == c.getProcessType()) {
			getNormalReimbursementData(creteria, list);
			getTravelReimbursementData(creteria, list);
			getBorrowMoneyData(creteria, list);
			getPayMoneyData(creteria, list);
		} else {
			switch (c.getProcessType()) {
			//日常报销
			case StaticUtils.PROCESS_TYPE_2:
			case StaticUtils.PROCESS_TYPE_3:
			case StaticUtils.PROCESS_TYPE_8:
			case StaticUtils.PROCESS_TYPE_10:
				getNormalReimbursementData(creteria, list);
				break;
			//差旅报销
			case StaticUtils.PROCESS_TYPE_4:
			case StaticUtils.PROCESS_TYPE_5:
			case StaticUtils.PROCESS_TYPE_9:
				getTravelReimbursementData(creteria, list);
				break;
			//借款申请
			case StaticUtils.PROCESS_TYPE_6:
				getBorrowMoneyData(creteria, list);
				break;
			//预付款申请	
			case StaticUtils.PROCESS_TYPE_7:
				getPayMoneyData(creteria, list);
				break;
			default:
				break;
			}
		}
		//排序
		Collections.sort(list, new ProcessInstanceIdComparator());
		//去重
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).getCode().equals(list.get(i + 1).getCode())) {
				list.remove(i);
			}
		}
		BaseCollection<BaseNewReimbursementPackage> result = new BaseCollection<>();
		result.setCollections(list);
		return result.toJSON(null);
	}
		
		 

	// 获取日常报销数据
	public void getNormalReimbursementData(String creteria, List<BaseNewReimbursementPackage> list) throws Exception {
		ConditionNormalReimbursementStatus2 condition = new ConditionNormalReimbursementStatus2();
		condition.setDataFromJSON(creteria);
		QueryNormalReimbursementStatus2 dao = new QueryNormalReimbursementStatus2();
		if(null == condition.getProcessType()){
			condition.setProcessType(StaticUtils.PROCESS_TYPE_2);
			queryNormalReimbursementData(condition, dao, list);
			condition.setProcessType(StaticUtils.PROCESS_TYPE_3);
			queryNormalReimbursementData(condition, dao, list);
			condition.setProcessType(StaticUtils.PROCESS_TYPE_8);
			queryNormalReimbursementData(condition, dao, list);
			condition.setProcessType(StaticUtils.PROCESS_TYPE_10);
			queryNormalReimbursementData(condition, dao, list);
		}else{
			queryNormalReimbursementData(condition, dao, list);
		}
		
	}
	
	public void queryNormalReimbursementData(ConditionNormalReimbursementStatus2 condition, QueryNormalReimbursementStatus2 dao, List<BaseNewReimbursementPackage> list) throws Exception{
		BaseCollection<BaseNormalReimbursementStatus2> result = dao.executeQuery(null, condition);
		if (null != result && null != result.getCollections()) {
			List<BaseNormalReimbursementStatus2> tempList = result.getCollections();
			for (BaseNormalReimbursementStatus2 obj : tempList) {
				BaseNewReimbursementPackage bean = new BaseNewReimbursementPackage();
				bean.setDataFromJSON("{"+obj.toJSONString()+"}");
				list.add(bean);
			}
		}
	}

	// 获取差旅报销数据
	public void getTravelReimbursementData(String creteria, List<BaseNewReimbursementPackage> list) throws Exception {
		ConditionTravelReimbursementStatus2 condition = new ConditionTravelReimbursementStatus2();
		condition.setDataFromJSON(creteria);
		QueryTravelReimbursementStatus2 dao = new QueryTravelReimbursementStatus2();
		if(null == condition.getProcessType()){
			condition.setProcessType(StaticUtils.PROCESS_TYPE_4);
			queryTravelReimbursementData(condition, dao, list);
			condition.setProcessType(StaticUtils.PROCESS_TYPE_5);
			queryTravelReimbursementData(condition, dao, list);
			condition.setProcessType(StaticUtils.PROCESS_TYPE_9);
			queryTravelReimbursementData(condition, dao, list);
		}else{
			queryTravelReimbursementData(condition, dao, list);
		}
	}
	
	public void queryTravelReimbursementData(ConditionTravelReimbursementStatus2 condition, QueryTravelReimbursementStatus2 dao, List<BaseNewReimbursementPackage> list) throws Exception{
		BaseCollection<BaseTravelReimbursementStatus2> result = dao.executeQuery(null, condition);
		if (null != result && null != result.getCollections()) {
			List<BaseTravelReimbursementStatus2> tempList = result.getCollections();
			for (BaseTravelReimbursementStatus2 obj : tempList) {
				BaseNewReimbursementPackage bean = new BaseNewReimbursementPackage();
				bean.setDataFromJSON("{"+obj.toJSONString()+"}");
				list.add(bean);
			}
		}
	}

	// 获取借款申请数据
	public void getBorrowMoneyData(String creteria, List<BaseNewReimbursementPackage> list) throws Exception {
		ConditionBorrowMoneyStatus2 condition = new ConditionBorrowMoneyStatus2();
		condition.setDataFromJSON(creteria);
		if(null == condition.getProcessType()){
			condition.setProcessType(StaticUtils.PROCESS_TYPE_6);
		}
		QueryBorrowMoneyStatus2 dao = new QueryBorrowMoneyStatus2();
		BaseCollection<BaseBorrowMoneyStatus2> result = dao.executeQuery(null, condition);
		if (null != result && null != result.getCollections()) {
			List<BaseBorrowMoneyStatus2> tempList = result.getCollections();
			for (BaseBorrowMoneyStatus2 obj : tempList) {
				BaseNewReimbursementPackage bean = new BaseNewReimbursementPackage();
				bean.setDataFromJSON("{"+obj.toJSONString()+"}");
				list.add(bean);
			}
		}
	}

	// 获取预付款申请数据
	public void getPayMoneyData(String creteria, List<BaseNewReimbursementPackage> list) throws Exception {
		ConditionPayMoneyStatus2 condition = new ConditionPayMoneyStatus2();
		condition.setDataFromJSON(creteria);
		if(null == condition.getProcessType()){
			condition.setProcessType(StaticUtils.PROCESS_TYPE_7);
		}
		QueryPayMoneyStatus2 dao = new QueryPayMoneyStatus2();
		BaseCollection<BasePayMoneyStatus2> result = dao.executeQuery(null, condition);
		if (null != result && null != result.getCollections()) {
			List<BasePayMoneyStatus2> tempList = result.getCollections();
			for (BasePayMoneyStatus2 obj : tempList) {
				BaseNewReimbursementPackage bean = new BaseNewReimbursementPackage();
				bean.setDataFromJSON("{"+obj.toJSONString()+"}");
				list.add(bean);
			}
		}
	}

}
