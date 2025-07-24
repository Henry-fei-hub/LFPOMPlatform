package com.pomplatform.client.workflow.form;

import static com.delicacy.client.ui.GenericWizadWindow.BACKGROUND_COLOR;
import static com.delicacy.client.ui.GenericWizadWindow.BORDER_STYLE;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractWizadPage;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class NewProjectTravelReimbursementWorkflow extends AbstractProcessPanel {
	
	@Override
	public void initComponents() {
		// 设置页面属性
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
			VLayout vl = new VLayout();
			vl.setWidth100();
			vl.setHeight100();
			vl.setPadding(5);
			boolean bigger = false;
			for (AbstractWizadPage __page : __pages) {
				if(bigger){
					__page.setHeight("50%");
				}else{
					__page.setHeight("50%");
					bigger = true;
				}
				vl.addMember(__page);
			}
			mainLayout.addMember(vl);
			break;
		}
		addMember(mainLayout);
	}

	@Override
	public void load() {
		if (getBusinessId() == null)
			return;
		Map params = new HashMap();
		params.put("travelReimbursementId", getBusinessId());
		DBDataSource.callOperation("NQ_ProjectTravelReimbursement", "find", new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					setData(dsResponse.getData()[0]);
					if (__pages == null)
						__pages = getPages();
					for (AbstractWizadPage wp : __pages) {
						wp.setRecord(getData());
						wp.startEdit();
					}
				}
			}
		});
	}

	@Override
	public boolean checkData(Map data) {
		return true;
	}

	@Override
	public int getPageCount() {
		return 2;
	}

	@Override
	public List<AbstractWizadPage> getPages() {
		setCallback(new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				// 请在此编写成功保存后要做的工作
			}
		});
		List<AbstractWizadPage> res = new ArrayList<>();
		final ProjectTravelReimbursementNewForm main = new ProjectTravelReimbursementNewForm();
		main.setProcessId(getProcessId());
		res.add(main);
		final TravelReimbursementDetailTravelReimbursementDetail detail = new TravelReimbursementDetailTravelReimbursementDetail();
		detail.setMainInfoPage(main);
		res.add(detail);
		detail.getDataGrid().addEditCompleteHandler(new EditCompleteHandler() {
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				FormItem item = main.findNamedItem("amount");
				if (null != item) {
					BigDecimal amount = BigDecimal.ZERO;
					ListGridRecord[] data = detail.getDataGrid().getRecords();
					if (data == null || data.length == 0) {
						item.setValue(amount);
						return;
					}
					for (ListGridRecord r : data) {
						if (null != r.getAttribute("sum")) {
							amount = amount.add(new BigDecimal(r.getAttribute("sum")));
						}
					}
					item.setValue(amount);
					item.fireEvent(new ChangedEvent(null));
				}
			}
		});
		return res;
	}

}
