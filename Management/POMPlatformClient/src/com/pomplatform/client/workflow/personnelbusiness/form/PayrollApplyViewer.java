package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.pomplatform.client.payment.panel.OnSalaryAnnualBonusByCompanyPanel;
import com.pomplatform.client.payment.panel.OnSalaryAnnualBonusByPlatePanel;
import com.pomplatform.client.payment.panel.OnSalaryBonusTotalDataPanel;
import com.pomplatform.client.payment.panel.OnSalaryDepartmentBonusByPlatePanel;
import com.pomplatform.client.payment.panel.OnSalaryPlateBonusByPlatePanel;
import com.pomplatform.client.payment.panel.OnSalaryReportByCompanyPanel;
import com.pomplatform.client.payment.panel.OnSalaryReportByPlatePanel;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSPayrollApply;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.SplitPane;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.viewer.DetailViewerField;

public class PayrollApplyViewer extends AbstractDetailViewer {
	
	private VLayout right = new VLayout();
	private VLayout left = new VLayout();
	

	public PayrollApplyViewer() {
	}

	@Override
	public void initComponents() {
		Label rightLabel = new Label("薪资或奖金详细");
		rightLabel.setHeight("25");
		rightLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER );
		setWidth100();
		setHeight100();
//		setLayoutMargin(5);
		setMembersMargin(5);
		setBackgroundColor("azure");
		setBorder("1px solid gray");
		setCanSelectText(true);
		// 如果没有定义字段分组，或者就一个组
		List<GroupColumn> gcs = getGroupColumnNames();
		if (getGroupCount() <= 1) {
			// 那么就是用一个DetailViewer就够了
			DetailViewer mainView = new DetailViewer();
			mainView.setCanSelectText(true);
			mainView.setHeight100();
			mainView.setWidth100();
			mainView.setWrapValues(true);

			mainView.setKeepInParentRect(true);
			// mainView.setWrapLabel(true);
			// 如果有一个分组，就需要给这个DetailViewer增加显示的字段
			if (getGroupCount() == 1) {
				GroupColumn gc = gcs.get(0);
				DetailViewerField[] dvfs = new DetailViewerField[gc.getColumnNames().size()];
				for (int i = 0; i < gc.getColumnNames().size(); i++) {
					dvfs[i] = new DetailViewerField(gc.getColumnNames().get(i));

				}
				mainView.setFields(dvfs);
			}
			mainView.setDataSource(getMainDataSource());
			detailViewers.add(mainView);
		} else {
			for (int i = 0; i < getGroupCount(); i++) {
				DetailViewer viewers = new DetailViewer();
				viewers.setCanSelectText(true);
				// viewers.setWrapLabel(true);
				viewers.setWrapValues(true);
				GroupColumn gc = gcs.get(i);
				DetailViewerField[] dvfs = new DetailViewerField[gc.getColumnNames().size()];
				for (int k = 0; k < gc.getColumnNames().size(); k++) {
					dvfs[k] = new DetailViewerField(gc.getColumnNames().get(k));
				}
				viewers.setDataSource(getMainDataSource());
				viewers.setFields(dvfs);
				detailViewers.add(viewers);
			}
		}
		SplitPane mainPane = new SplitPane();
		mainPane.setCanSelectText(true);
		mainPane.setShowListToolStrip(false);
		
		left.setCanSelectText(true);
		left.setHeight100();
		left.setPadding(5);
		left.setMembersMargin(10);
		int ii = 0;
		for (DetailViewer detailViewer : detailViewers) {
			if (getGroupCount() > 0 && getIsGroup()) {
				detailViewer.setIsGroup(true);
				detailViewer.setCanSelectText(true);
				detailViewer.setGroupTitle(gcs.get(ii++).getGroupCaption());
			}
			left.addMember(detailViewer);
		}
		left.setWidth(222);
		left.setOverflow(Overflow.AUTO);
		left.setBorder("1px solid gray");
		mainPane.setNavigationPane(left);
		
//		right.setWidth("80%");
		right.setHeight100();
		right.setPadding(5);
		right.setMembersMargin(10);
		
//		rightDetailView.setWidth100();
//		rightDetailView.setHeight100();
//		rightDetailView.setDataSource(DSSpersonnelbusinesppor.getInstance());
//		rightDetailView.setWrapValues(true);
//		rightDetailView.setKeepInParentRect(true);
		right.addMember(rightLabel);
		addMember(left);
		addMember(right);
		
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "薪资发放申请";
	}

	@Override
	public int getGroupCount() {
		return 0;
	}

	@Override
	public List<GroupColumn> getGroupColumnNames() {
		List<GroupColumn> gcs = new ArrayList<GroupColumn>();
		return gcs;
	}

	@Override
	public void load() {
		if (getBusinessId() == null)
			return;
		Map params = new HashMap();
		params.put("personnelBusinessId", getBusinessId());
		DBDataSource.callOperation("ST_PersonnelBusines", "find", new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					for (DetailViewer v : detailViewers) {
						v.setData(dsResponse.getData());
						if (dsResponse.getData().length == 0)
							continue;
						v.selectRecord(0);
						v.redraw();
					}
					setRecord(dsResponse.getData()[0]);
					viewDetailData();
				}
			}
		});
	}

	@Override
	public void viewSelectedData(ListGrid grid) {
		SC.debugger();
		super.viewSelectedData(grid);
		setRecord(grid.getSelectedRecord());
		viewDetailData();
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	public void viewDetailData() {
		Record selected = getRecord();
		Object val;
		java.util.Map condition = null;
		int year = getRecord().getAttributeAsInt("companyProvince");
		int month = getRecord().getAttributeAsInt("targetProvince");
		int type = getRecord().getAttributeAsInt("type");
		int personnelBusinessId =  getRecord().getAttributeAsInt("personnelBusinessId");
		//根据不同的任务审批显示不同的界面
		if(processName.contains("人资部")){
			if(type == 1){//薪资
				OnSalaryReportByCompanyPanel panel = new OnSalaryReportByCompanyPanel();
				panel.initPanel(null, year, month);
				panel.commonQuery();
				right.addMember(panel);
			}else if(type == 2){//奖金
				OnSalaryBonusTotalDataPanel panel = new OnSalaryBonusTotalDataPanel();
				panel.initPanel(null, year, month);
				panel.setPersonnelBusinessId(personnelBusinessId);
				panel.commonQuery();
				right.addMember(panel);
			}else if(type == 3){
				OnSalaryAnnualBonusByCompanyPanel panel= new OnSalaryAnnualBonusByCompanyPanel();
				panel.initPanel(null, year, personnelBusinessId);
				panel.commonQuery();
				right.addMember(panel);
			}
			
		}else if(processName.contains("部门分管")){
			if(type == 1){
				OnSalaryReportByPlatePanel panel = new OnSalaryReportByPlatePanel();
				panel.initSearchData(1, year, month);
				right.addMember(panel);
			}else if(type == 2){
				OnSalaryPlateBonusByPlatePanel panel = new OnSalaryPlateBonusByPlatePanel();
				panel.setPersonnelBusinessId(personnelBusinessId);
				panel.initSearchData(1, year, month);
				right.addMember(panel);
			}else if(type == 3){
				OnSalaryAnnualBonusByPlatePanel panel = new OnSalaryAnnualBonusByPlatePanel();
				panel.initSearchData(1, year, personnelBusinessId, null);
				right.addMember(panel);
			}
			
		}else if(processName.contains("总经理") || processName.contains("财务经理")){
			if(type == 1){
				OnSalaryReportByCompanyPanel panel = new OnSalaryReportByCompanyPanel();
				panel.initPanel(processName, year, month);
				panel.commonQuery();
				right.addMember(panel);
			}else if(type == 2){
				OnSalaryBonusTotalDataPanel panel = new OnSalaryBonusTotalDataPanel();
				panel.initPanel(processName, year, month);
				panel.commonQuery();
				right.addMember(panel);
			}else if(type == 3){
				OnSalaryAnnualBonusByCompanyPanel panel= new OnSalaryAnnualBonusByCompanyPanel();
				panel.initPanel(processName, year, personnelBusinessId);
				panel.commonQuery();
				right.addMember(panel);
			}
		}else if(processName.contains("报税会计")){
			if(type == 1){
				OnSalaryReportByCompanyPanel panel = new OnSalaryReportByCompanyPanel();
				panel.initPanel(null, year, month);
				panel.commonQuery();
				right.addMember(panel);
			}else if(type == 2){
				OnSalaryBonusTotalDataPanel panel = new OnSalaryBonusTotalDataPanel();
				panel.initPanel(null, year, month);
				panel.commonQuery();
				right.addMember(panel);
			}else if(type == 3){
				OnSalaryAnnualBonusByCompanyPanel panel= new OnSalaryAnnualBonusByCompanyPanel();
				panel.initPanel(processName, year, personnelBusinessId);
				panel.commonQuery();
				right.addMember(panel);
			}
		}else{
			left.setWidth100();
			right.hide();
//			OnSalaryReportByPlatePanel panel = new OnSalaryReportByPlatePanel();
//			panel.initSearchData(1, year, month);
//			right.addMember(panel);
		}
//		condition = new HashMap();
//		condition.put("contractId", selected.getAttribute("projectId"));
//		condition.put("personnelBusinessId", selected.getAttribute("personnelBusinessId"));
//		DBDataSource.callOperation("NQ_OnAttachmentLinkContractReceivables", "find", condition, new DSCallback() {
//			@Override
//			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//				if (dsResponse.getStatus() >= 0) {
//					alrGrid.setData(dsResponse.getData());
//				}
//			}
//		});
	}

	@Override
	public DataSource getMainDataSource() {
		return DSPayrollApply.getInstance();
	}

	@Override
	public int getDetailCount() {
		return 0;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		return res;
	}
	
	private String processName;


	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}
	
}
