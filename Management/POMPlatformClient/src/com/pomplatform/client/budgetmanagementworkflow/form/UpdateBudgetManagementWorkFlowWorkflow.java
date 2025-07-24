package com.pomplatform.client.budgetmanagementworkflow.form;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.AbstractProcessPanel;

import static com.delicacy.client.ui.GenericWizadWindow.BACKGROUND_COLOR;
import static com.delicacy.client.ui.GenericWizadWindow.BORDER_STYLE;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.HashMap;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class UpdateBudgetManagementWorkFlowWorkflow extends AbstractProcessPanel
{
	private static Logger __logger = Logger.getLogger("");
	private HLayout hRight;

	private HLayout hLeft;

	@Override
	public void initComponents() {
		//设置页面属性
		setWidth100();
		setHeight100();

		__pages = getPages();
		for (AbstractWizadPage __page : __pages) {
			if (__page.getPageMode() != AbstractWizadPage.PAGE_MODE_ADD) {
				setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
			}
			__page.setBorder(BORDER_STYLE);
			__page.setPadding(5);
			__page.setBackgroundColor(BACKGROUND_COLOR);
		}
		VLayout mainLayout = new VLayout();
		mainLayout.setOverflow(Overflow.HIDDEN);
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		switch (__pageMode) {
		case PAGE_DISPLAY_NAV:
			__pageNum = getPageCount();
			customLayout = new HLayout();
			customLayout.setWidth100();
			customLayout.setHeight100();
			customLayout.setPadding(5);
			customLayout.addMember(__pages.get(getCurrentPage()));
			mainLayout.addMember(customLayout);
			break;
		default:
			__pageNum = 1;
			HLayout hLayout = new HLayout();
			hLayout.setWidth100();
			hLayout.setHeight100();
			hLayout.setPadding(5);
			hLeft = new HLayout();
			hLeft.setWidth("60%");
			hLeft.setHeight100();
			hLeft.setPadding(5);
			hRight = new HLayout();
			hRight.setWidth("40%");
			hRight.setHeight100();
			hRight.setPadding(5);
			VLayout vRight = new VLayout();
			vRight.setWidth100();
			vRight.setHeight100();
			vRight.setPadding(5);
			int i = 0;
			for (AbstractWizadPage __page : __pages) {
				if(i == 0){
					hLeft.addMember(__page);
				}else{
					vRight.addMember(__page);
				}
				i++;
			}
			hRight.addMember(vRight);
			hRight.hide();
			hLayout.addMember(hLeft);
			hLayout.addMember(hRight);
			mainLayout.addMember(hLayout);
			break;
		}
		addMember(mainLayout);
	}
	@Override
	public void load() {
		if(getBusinessId() == null) return;
		Map params = new HashMap();
		params.put("budgetManagementId", getBusinessId());
		DBDataSource.callOperation("NQ_BudgetManagementWorkFlow", "find", new DSCallback() {
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
	public List<AbstractWizadPage> getPages(){
		setCallback(new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				// Please code the program after save sucessfully.
			}
		});
		List<AbstractWizadPage> res = new ArrayList<>();
		BudgetManagementWorkFlowUpdateForm panel=new BudgetManagementWorkFlowUpdateForm();
		panel.addDataEditedHandler(new DataEditedHandler() {

			@Override
			public void onDataEdited(DataEditEvent event) {
				Record record = event.getData();
				if(record.getAttributeAsBoolean("flag")){
					hRight.show();
				}else{
					hRight.hide();
				}
				DataEditEvent dee = new DataEditEvent();
				dee.setData(record);
				fireEvent(dee);
			}
		});
		BudgetManagementLinkProcessPanel alrPanel = new BudgetManagementLinkProcessPanel(false);//修改
		alrPanel.setUpdatePanel(panel);
		res.add(panel);
		res.add(alrPanel);
		return res;
	}


}

