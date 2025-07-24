package com.pomplatform.client.workflow.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.workflow.panel.ProcessBillListApplyBorrowMoneyPanel;
import com.pomplatform.client.workflow.panel.ProcessBillListApplyPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;

public class NewEmployeeBorrowMoneyByWorkflowWorkflow extends AbstractProcessPanel
{
	private static final Logger __logger = Logger.getLogger("");

	@Override
	public void load() {
		if(getBusinessId() == null) return;
		Map<String,Object> params = new HashMap<>();
		params.put("employeeMoneyManageId", getBusinessId());
		DBDataSource.callOperation("NQ_EmployeeBorrowMoneyByWorkflow", "find", new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					setData(dsResponse.getData()[0]);
					if(__pages == null) __pages = getPages();
					for(AbstractWizadPage wp : __pages) { wp.setRecord(getData()); wp.startEdit(); }
				}
			}
		});
	}
	
	@Override
	public boolean checkData(Map data){
		boolean flag =  true;
		List<AbstractWizadPage> pageList = __pages;
		for (AbstractWizadPage abstractWizadPage : pageList) {
			if(!abstractWizadPage.checkData()){
				flag = false;
				break;
			}
		}
		return flag;
//		//获取当次借款金额
//		double borrowMoney = BaseHelpUtils.getDoubleValue(data.get("borrowMoney"));
//		//获取当次可借款金额
//		double canBorrowMoney = BaseHelpUtils.getDoubleValue(data.get("canBorrowMoney"));
//		//如果当次借款金额大于可借款金额，则不允许提交
//		if(borrowMoney > canBorrowMoney){
//			SC.say("提示","您当次借款金额("+borrowMoney+")不可大于可借款金额("+canBorrowMoney+")");
//			return false;
//		}else{
//			return true;
//		}
//		return true;
	}

	@Override
	public int getPageCount(){
		return 1;
	}

	@Override
	public List<AbstractWizadPage> getPages(){
		//获取在发放总表传过来的数据
		Record record = getData();
		setCallback(new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				// 请在此编写成功保存后要做的工作
			}
		});
		Record budgetRecord=getData();//预算单传过来的record
		List<AbstractWizadPage> res = new ArrayList<>();
		EmployeeBorrowMoneyByWorkflowNewForm panel = new EmployeeBorrowMoneyByWorkflowNewForm();
		if (null != record) {
			int employeeFundIssuanceId = BaseHelpUtils.getIntValue(record.getAttribute("employeeFundIssuanceId"));
			panel.setEmployeeFundIssuanceId(employeeFundIssuanceId);
		}
		panel.setBudgetRecord(budgetRecord);
		panel.setProcessId(getProcessId());
		res.add(panel);
		final ProcessBillListApplyPanel pblPanel = new ProcessBillListApplyPanel(null, 6);
		pblPanel.setRecord(record);
		pblPanel.setProcessType(6);
		pblPanel.setBudgetRecord(budgetRecord);
		pblPanel.setMainInfoPage(panel);
		pblPanel.setTitle("账单流水");
		res.add(pblPanel);
		return res;
	}
}

