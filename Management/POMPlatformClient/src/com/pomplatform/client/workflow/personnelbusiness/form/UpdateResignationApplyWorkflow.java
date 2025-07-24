package com.pomplatform.client.workflow.personnelbusiness.form;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractWizadPage;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
public class UpdateResignationApplyWorkflow extends AbstractProcessPanel
{
	private static final Logger logger = Logger.getLogger("");
	private String processName;
	private boolean needToChangeProjectManage = false;
	private boolean integralStatus = false;
	private boolean borrowMoneyStatus = false;
	private VLayout mainLayout;
	private VLayout warning;
	private WorkHandoverPanel panel2;

	/**
	 * 人事专员
	 */
	private String processName1 = "人事专员";

	/**
	 * 申请人
	 */
	private String processName2 = "申请人";

	@Override
	public void load() {
		if(getBusinessId() == null) return;
		Map params = new HashMap();
		params.put("personnelBusinessId", getBusinessId());
		DBDataSource.callOperation("NQ_ResignationApply", "find", new DSCallback() {
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
		boolean status = true;
		if(getCustomerOperation() != 0) return true;
		for(AbstractWizadPage wp : __pages){
			if(!wp.checkData()){
				status = false;
			}
		}
		return status;
	}

	@Override
	public int getPageCount(){
		return 1;
	}
	
	@Override
	public void initComponents() {
		setWidth100();
		setHeight100();
		__pages = getPages();
		mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		mainLayout.setBackgroundColor("#fff");
		
		__pageNum = getPageCount();
        customLayout = new HLayout();
        customLayout.setWidth100();
        customLayout.setHeight100();
        customLayout.setPadding(5);
        customLayout.addMember(__pages.get(getCurrentPage()));
        mainLayout.addMember(customLayout);
		if(null != processName && processName.indexOf(processName1) >= 0){
			FormItem[] items = __pages.get(0).getFormItemArray();
			for(FormItem item : items){
				if(item.getName().equals("departmentId") || item.getName().equals("companyId") || item.getName().equals("dutyId") || item.getName().equals("startDate") || item.getName().equals("endDate") ){
					item.setDisabled(false);
					item.setCanEdit(true);
					item.show();
				}
			}
		}
		//申请人
		else if (null != processName && processName.indexOf(processName2) >= 0) {

		}
		addMember(mainLayout);
	
	}
	
	@Override
	public List<AbstractWizadPage> getPages(){
		SC.debugger();
		__pageMode = PAGE_DISPLAY_NAV;
		setCallback(new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				// 请在此编写成功保存后要做的工作
			}
		});
		List<AbstractWizadPage> res = new ArrayList<>();
		ResignationApplyUpdateForm panel = new ResignationApplyUpdateForm(processName);
		panel.setProcessName(processName);
		res.add(panel);
		/*panel2 = new WorkHandoverPanel(1);
		res.add(panel2);*/
		return res;
	}

	@Override
	public void refreshPageData() {
		super.refreshPageData();
//		Record record = getData();
//		if (null != record) {
//			panel2.setBusinessId(record.getAttributeAsInt("personnelBusinessId"));
//			panel2.setEmployeeId(record.getAttributeAsInt("employeeId"));
//			panel2.startEdit();
//		}
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}
	
}

