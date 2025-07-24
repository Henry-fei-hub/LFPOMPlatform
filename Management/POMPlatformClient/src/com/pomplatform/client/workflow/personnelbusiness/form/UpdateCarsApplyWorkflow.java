package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractWizadPage;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class UpdateCarsApplyWorkflow extends AbstractProcessPanel
{
	private static final Logger logger = Logger.getLogger("");
	private String processName;
	private VLayout mainLayout;
	/**
	 * 行政文员
	 */
	private String processName_1 = "行政文员";

	@Override
	public void load() {
		if(getBusinessId() == null) return;
		Map params = new HashMap();
		params.put("personnelBusinessId", getBusinessId());
		DBDataSource.callOperation("NQ_CarsApply", "find", new DSCallback() {
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
		if(getCustomerOperation() == 0 && null != processName && processName.equals(processName_1)){
			//行政文员同意用车申请的情况下，需要填几个必填项
			if(null == data.get("subType")){
				SC.say("请选择内部派车/外部专车");
				return false;
			}
			if(ClientUtil.checkAndGetIntValue(data.get("subType")) == 0){
				//内部派车，需要选择车子信息和司机
				if(null == data.get("targetProvince") || null == data.get("contactPerson")){
					SC.say("请选择车辆信息和司机");
					return false;
				}
			}
		}
		boolean status = true;
		for(AbstractWizadPage wp : __pages){
			if(!wp.checkData()){
				status = false;
			}
		}
		return status;
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
		if(null != processName && processName.equals(processName_1)){
			FormItem[] items = __pages.get(0).getFormItemArray();
			for(FormItem item : items){
				if(item.getName().equals("subType")){
					item.show();
				}else if(item.getName().equals("reason")){
					item.setColSpan(2);
				}
			}
		}
		addMember(mainLayout);
	
	}

	@Override
	public int getPageCount(){
		return 1;
	}

	@Override
	public List<AbstractWizadPage> getPages(){
		setCallback(new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				// 请在此编写成功保存后要做的工作
			}
		});
		List<AbstractWizadPage> res = new ArrayList<>();
		res.add(new CarsApplyUpdateForm());
		return res;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}
}

