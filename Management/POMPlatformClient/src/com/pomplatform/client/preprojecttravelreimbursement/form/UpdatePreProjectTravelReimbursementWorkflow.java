package com.pomplatform.client.preprojecttravelreimbursement.form;

import static com.delicacy.client.ui.GenericWizadWindow.BACKGROUND_COLOR;
import static com.delicacy.client.ui.GenericWizadWindow.BORDER_STYLE;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.workflow.panel.ProcessBillListApplyPanel;
import com.pomplatform.client.workflow.projectTravelReimbursement.form.TravelReimbursementDetail;
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

public class UpdatePreProjectTravelReimbursementWorkflow extends AbstractProcessPanel {
	
	private String processName;

	@Override
	public void load() {
		if (getBusinessId() == null)
			return;
		Map params = new HashMap();
		params.put("travelReimbursementId", getBusinessId());
		DBDataSource.callOperation("NQ_PreProjectTravelReimbursement", "find", new DSCallback() {
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
		boolean flag =  true;
		List<AbstractWizadPage> pageList = __pages;
		for (AbstractWizadPage abstractWizadPage : pageList) {
			if(!abstractWizadPage.checkData()){
				flag = false;
				break;
			}
		}
		return flag;
	}

	@Override
	public int getPageCount() {
		return 4;
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
		final PreProjectTravelReimbursementUpdateForm main = new PreProjectTravelReimbursementUpdateForm();
		main.setProcessId(getProcessId());
		res.add(main);
		final TravelReimbursementDetail detail = new TravelReimbursementDetail();
		detail.setMainInfoPage(main);
		detail.setTitle("前期项目差旅报销费用清单");
		detail.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
		res.add(detail);
		final TravelReimbursementLinkMainProjectDetail link = new TravelReimbursementLinkMainProjectDetail(processName);
		link.setMainInfoPage(main);
		link.setTitle("费用分拆");
		link.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
		link.setProcessType(9);
		res.add(link);
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
		final ProcessBillListApplyPanel pblPanel = new ProcessBillListApplyPanel(getProcessName());
		pblPanel.setProcessType(9);
		pblPanel.setMainInfoPage(main);
		pblPanel.setTitle("账单流水");
		pblPanel.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
		res.add(pblPanel);
		main.setPblPanel(pblPanel);
		return res;
	}

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
			HLayout hLayout = new HLayout();
			hLayout.setWidth100();
			hLayout.setHeight100();
			hLayout.setPadding(5);
			HLayout hLeft = new HLayout();
			hLeft.setWidth("30%");
			hLeft.setHeight100();
			hLeft.setPadding(5);
			HLayout hRight = new HLayout();
			hRight.setWidth("70%");
			hRight.setHeight100();
			hRight.setPadding(5);
			VLayout vRight = new VLayout();
			vRight.setWidth100();
			vRight.setHeight100();
			vRight.setPadding(5);
			int i = 0;
			for (AbstractWizadPage __page : __pages) {
				if (i == 0) {
					hLeft.addMember(__page);
				} else {
					vRight.addMember(__page);
				}
				i++;
			}
			hRight.addMember(vRight);
			hLayout.addMember(hLeft);
			hLayout.addMember(hRight);
			mainLayout.addMember(hLayout);
			break;
		}
		addMember(mainLayout);
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

}
