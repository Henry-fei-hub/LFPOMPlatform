package com.pomplatform.client.projectview.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.pomplatform.client.project.datasource.DSProjectChangeEmployee;
import com.pomplatform.client.project.datasource.DSProjectStage;
import com.pomplatform.client.projectattachment.datasource.DSSprojectattachmentpor;
import com.pomplatform.client.projectattachment.form.SprojectattachmentporViewer;
import com.pomplatform.client.projectemployeeadvanceeachpersondetail.panel.ProjectEmployeeAdvanceEachPersonDetailPanel;
import com.pomplatform.client.projectview.datasource.DSProjectCost;
import com.pomplatform.client.projectview.datasource.DSProjectEmployee;
import com.pomplatform.client.projectview.datasource.DSSprojectView;
import com.pomplatform.client.settle.datasource.DSSprojectsettlementpor;
import com.pomplatform.client.settle.form.SprojectsettlementporViewer;
import com.pomplatform.client.sprojectadvancerecord.datasource.DSSProjectAdvanceRecord;
import com.pomplatform.client.sprojectemployeeadvancerecordpor.datasource.DSSProjectEmployeeAdvanceRecordpor;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.SplitPane;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.viewer.DetailViewerField;

public class SprojectViewViewer extends AbstractDetailViewer {
	private static final Logger logger = Logger.getLogger("");
	//定义map来存放每个阶段的对象值
	private Map<Integer,Record> stageMap = new HashMap<>();
	private final DelicacyListGrid projectEmployeesGrid = new DelicacyListGrid();
	private final DelicacyListGrid projectCostGrid = new DelicacyListGrid();
	private final DelicacyListGrid projectSettlementGrid = new DelicacyListGrid(){
		@Override
		protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
			//获取结算状态
    		int settlementStatus = BaseHelpUtils.getIntValue(record.getAttribute("settlementStatus"));
			if (settlementStatus == 1) {
				return "color: blue;";
			}else if(settlementStatus == 3){ 
				return "color: #ABABAB;";
			}else {
				return super.getCellCSSText(record, rowNum, colNum);
			}
		}
	};
	private final DelicacyListGrid projectAttachmentGrid = new DelicacyListGrid();
//	private final DelicacyListGrid projectIntegralTransferGrid = new DelicacyListGrid();
//	private final DelicacyListGrid projectIntegralChangeGrid = new DelicacyListGrid();
//	private final DelicacyListGrid projectIntegralAssignGrid = new DelicacyListGrid();
	private final DelicacyListGrid projectAdvanceGrid = new DelicacyListGrid();
	private final DelicacyListGrid projectAdvanceRecordGrid = new DelicacyListGrid();
	private DelicacyListGrid projectContractChangeGrid = new DelicacyListGrid();
	private DelicacyListGrid projectStageEmployeesGrid = new DelicacyListGrid();
	private final DelicacyListGrid employeeGrid = new DelicacyListGrid(); 
    private DelicacyListGrid projectStagesGrid = new DelicacyListGrid();
	private SearchForm __parentSearchForm;
	private int projectId;
	int roleID = ClientUtil.getRoleId();
	private final String layoutGroupStyle = "2px solid #555555;border-top-width:22px;border-radius:5px;";

	public SprojectViewViewer() {
	}

	@Override
	public void initComponents() {
//		super.initComponents();
		setWidth100();
		setHeight100();
		setLayoutMargin(5);
		setMembersMargin(5);
		setBackgroundColor("azure");
		setBorder("1px solid gray");
		setCanSelectText(true);
		int horizontalPercent = getHorizontalPercent();
		// 如果没有定义字段分组，或者就一个组
		List<ListGrid> grids = getDetailListGrids();
		List<String> names = getDetailNames();
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
		switch (getLayoutMode()) {
		case COMPONENT_LAYOUT_NORMAL:
			SplitPane mainPane = new SplitPane();
			mainPane.setCanSelectText(true);
			mainPane.setShowListToolStrip(false);
			VLayout left = new VLayout();
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
			if (getDetailCount() > 0) {
				// left.setShowResizeBar(true);
				if (horizontalPercent == 0) {
					left.setWidth("50%");
				} else {
					left.setWidth(String.valueOf((horizontalPercent / 10) * 10) + "%");
				}
			} else {
				// left.setShowResizeBar(false);
				left.setWidth100();
			}
			left.setOverflow(Overflow.AUTO);
			mainPane.setNavigationPane(left);

			if (getDetailCount() > 0) {
				if (getDetailCount() == 1) {
					ListGrid grid = grids.get(0);
					grid.setCanDragSelectText(true);
					grid.setHeight100();
					if (horizontalPercent == 0) {
						grid.setWidth("50%");
					} else {
						grid.setWidth(String.valueOf(((100 - horizontalPercent) / 10) * 10) + "%");
					}
					mainPane.setListPane(grid);
				} else {
					SectionStack detailStack = new SectionStack();
					detailStack.setCanSelectText(true);
					detailStack.setHeight100();
					if (horizontalPercent == 0) {
						detailStack.setWidth("50%");
					} else {
						detailStack.setWidth(String.valueOf(((100 - horizontalPercent) / 10) * 10) + "%");
					}
					detailStack.setVisibilityMode(VisibilityMode.MULTIPLE);
					for (int i = 0; i < getDetailCount(); i++) {

						SectionStackSection detailSection = new SectionStackSection(names.get(i));
						detailSection.addItem(grids.get(i));
						detailSection.setExpanded(true);
						detailStack.addSection(detailSection);
					}
					mainPane.setListPane(detailStack);
				}
			}
			if (getDetailCount() > 0)
				addMember(mainPane);
			else
				addMember(left);
			break;
		case COMPONENT_LAYOUT_TOPBOTTOM:
			VLayout global = new VLayout();
			global.setCanSelectText(true);
			VLayout left1 = new VLayout();
			left1.setCanSelectText(true);
			left1.setHeight100();
			left1.setPadding(5);
			left1.setMembersMargin(10);
			int ii1 = 0;
			for (DetailViewer detailViewer : detailViewers) {
				if (getGroupCount() > 0 && getIsGroup()) {
					detailViewer.setCanSelectText(true);
					detailViewer.setIsGroup(true);
					detailViewer.setGroupTitle(gcs.get(ii1++).getGroupCaption());
				}
				left1.addMember(detailViewer);
			}
			if (getDetailCount() > 0) {
				left1.setShowResizeBar(true);
				if (horizontalPercent == 0) {
					left1.setWidth("50%");
				} else {
					left1.setWidth(String.valueOf((horizontalPercent / 10) * 10) + "%");
				}
			} else {
				left1.setShowResizeBar(false);
				left1.setWidth100();
			}
			global.addMember(left1);
			if (getDetailCount() > 0) {
				if (getDetailCount() == 1) {
					ListGrid grid = grids.get(0);
					grid.setHeight100();
					grid.setCanSelectText(true);
					if (horizontalPercent == 0) {
						grid.setWidth("50%");
					} else {
						grid.setWidth(String.valueOf(((100 - horizontalPercent) / 10) * 10) + "%");
					}
					global.addMember(grid);
				} else {
					SectionStack detailStack = new SectionStack();
					detailStack.setCanSelectText(true);
					detailStack.setHeight100();
					if (horizontalPercent == 0) {
						detailStack.setWidth("50%");
					} else {
						detailStack.setWidth(String.valueOf(((100 - horizontalPercent) / 10) * 10) + "%");
					}
					detailStack.setVisibilityMode(VisibilityMode.MULTIPLE);
					for (int i = 0; i < getDetailCount(); i++) {

						SectionStackSection detailSection = new SectionStackSection(names.get(i));
						detailStack.addSection(detailSection);
						detailSection.addItem(grids.get(i));
						detailSection.setExpanded(true);
					}
					global.addMember(detailStack);
				}
			}
			addMember(global);
			break;
		case COMPONENT_LAYOUT_TAB:
			TabSet mainTab = new TabSet();
			Tab tab;
			if (getGroupCount() == 0) {
				tab = new Tab(getName());
				tab.setPane(detailViewers.get(0));
				mainTab.addTab(tab);
			} else {
				for (int i = 0; i < getGroupCount(); i++) {
					tab = new Tab(gcs.get(i).getGroupCaption());
					tab.setPane(detailViewers.get(i));
					mainTab.addTab(tab);
				}
			}
			
			VLayout advanceLayout = new VLayout();
			advanceLayout.setMembersMargin(30);
			
			
			employeeGrid.setAutoFitFieldWidths(false);
			employeeGrid.setShowGridSummary(true);
			int index = 0;
			ListGridField[] fields = new ListGridField[5];
			fields[index] = new ListGridField("mainProjectEmployeeId");
			fields[index].setHidden(true);
			index++;
			fields[index] = new ListGridField("relation","角色");
			fields[index].setValueMap(KeyValueManager.getValueMap("system_dictionary_158"));
			fields[index].setWidth("30%");
			index++;
			fields[index] = new ListGridField("employeeNo","职员编号");
			fields[index].setWidth("20%");
			index++;
			fields[index] = new ListGridField("employeeId","职员姓名");
			fields[index].setWidth("20%");
			fields[index].setValueMap(KeyValueManager.getValueMap("employees"));
			index++;
			fields[index] = new ListGridField("plateId","业务部门");
			fields[index].setWidth("30%");
			fields[index].setValueMap(KeyValueManager.getValueMap("plate_records"));		
			employeeGrid.setFields(fields);
			
			//项目成员补贴明细
			VLayout employeeAdvanceLayout = new VLayout(10);
			employeeAdvanceLayout.setWidth100();
			employeeAdvanceLayout.setHeight("50%");
			employeeAdvanceLayout.setIsGroup(true);
			employeeAdvanceLayout.setGroupTitle("项目成员补贴明细");
			employeeAdvanceLayout.setGroupBorderCSS(layoutGroupStyle);
			employeeAdvanceLayout.setGroupLabelBackgroundColor("#555555");
			employeeAdvanceLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
			employeeAdvanceLayout.addMember(projectAdvanceGrid);
			
			//项目补贴次数明细
			VLayout projectAdvanceLayout = new VLayout(10);
			projectAdvanceLayout.setWidth100();
			projectAdvanceLayout.setHeight("50%");
			projectAdvanceLayout.setIsGroup(true);
			projectAdvanceLayout.setGroupTitle("项目补贴次数明细");
			projectAdvanceLayout.setGroupBorderCSS(layoutGroupStyle);
			projectAdvanceLayout.setGroupLabelBackgroundColor("#555555");
			projectAdvanceLayout.setGroupLabelStyleName("layoutGroupTitleStyle");
			projectAdvanceLayout.addMember(projectAdvanceRecordGrid);
			
			advanceLayout.addMember(projectAdvanceLayout);
			advanceLayout.addMember(employeeAdvanceLayout);
			
			projectStageEmployeesGrid = new DelicacyListGrid();
			projectStageEmployeesGrid.setAutoFitFieldWidths(false);
			projectStageEmployeesGrid.setHeaderHeight(100); 
			projectStageEmployeesGrid.setShowRowNumbers(true);
			projectStageEmployeesGrid.setShowGridSummary(true);
			
			for (int i = 0; i < getDetailCount(); i++) {
				tab = new Tab(names.get(i));
				if(i == 2){//项目阶段成员明细
					tab.setPane(projectStageEmployeesGrid);
				}else if(i == 6){//项目补贴明细
					tab.setPane(advanceLayout);
				}else{
					tab.setPane(grids.get(i));
				}
				mainTab.addTab(tab);
			}
			addMember(mainTab);
			break;
		}
		
		projectStagesGrid.setAutoFitFieldWidths(false);
		projectStagesGrid.setHeaderHeight(100); 
		projectStagesGrid.setShowRowNumbers(true);
		projectStagesGrid.setShowGridSummary(true);
		projectStagesGrid.setDataSource(DSProjectStage.getInstance());

		projectEmployeesGrid.setDataSource(DSProjectEmployee.getInstance());
		int peIdx = 0;
		ListGridField[] fields = new ListGridField[12];
		fields[peIdx] = new ListGridField("employeeId");
		fields[peIdx].setShowGridSummary(false);
		fields[peIdx].setWidth("10%");
		peIdx++;
		fields[peIdx] = new ListGridField("designPhase");
		fields[peIdx].setShowGridSummary(false);
		fields[peIdx].setWidth("10%");
		peIdx++;
		fields[peIdx] = new ListGridField("planIntegral");
		fields[peIdx].setWidth("10%");
		peIdx++;
		fields[peIdx] = new ListGridField("planIntegralPercent");
		fields[peIdx].setWidth("10%");
		peIdx++;
		fields[peIdx] = new ListGridField("realIntegral");
		fields[peIdx].setWidth("10%");
		peIdx++;
		fields[peIdx] = new ListGridField("realIntegralPercent");
		fields[peIdx].setWidth("10%");
		peIdx++;
		fields[peIdx] = new ListGridField("cost");
		fields[peIdx].setWidth("10%");
		peIdx++;
		fields[peIdx] = new ListGridField("costPercent");
		fields[peIdx].setWidth("10%");
		peIdx++;
		fields[peIdx] = new ListGridField("settlement");
		fields[peIdx].setWidth("10%");
		peIdx++;
		fields[peIdx] = new ListGridField("startDate");
		fields[peIdx].setWidth("10%");
		fields[peIdx].setShowGridSummary(false);
		peIdx++;
		fields[peIdx] = new ListGridField("endDate");
		fields[peIdx].setWidth("10%");
		fields[peIdx].setShowGridSummary(false);
		peIdx++;
		fields[peIdx] = new ListGridField("workContent");
		fields[peIdx].setShowGridSummary(false);
		fields[peIdx].setWidth("20%");
		projectEmployeesGrid.setShowRowNumbers(true);
		projectEmployeesGrid.setFields(fields);
		projectEmployeesGrid.setShowGridSummary(true);
/*		projectEmployeesGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				ListGridRecord[] selected = projectEmployeesGrid.getSelectedRecords();
				String employeeId = selected[0].getAttribute("employeeId");
				String employeeName = KeyValueManager.getValueMap("employees").get(employeeId);
				PopupWindow pw = new PopupWindow();
				DesignerProjectPanel myselfProject = new DesignerProjectPanel();
				myselfProject.setEmployeeId(ClientUtil.checkAndGetIntValue(employeeId));
				pw.addItem(myselfProject.getViewPanel());
				pw.setTitle(employeeName + "参与的项目");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
				myselfProject.commonQuery();
			}
		});*/

		projectCostGrid.setDataSource(DSProjectCost.getInstance());
		int pcIdx = 0;
		ListGridField[] pcFields = new ListGridField[4];
		pcFields[pcIdx] = new ListGridField("employeeId");
		pcFields[pcIdx].setShowGridSummary(false);
		pcFields[pcIdx].setWidth("20%");
		pcIdx++;
		pcFields[pcIdx] = new ListGridField("amount");
		pcFields[pcIdx].setWidth("20%");
		pcIdx++;
		pcFields[pcIdx] = new ListGridField("costType");
		pcFields[pcIdx].setShowGridSummary(false);
		pcFields[pcIdx].setWidth("20%");
		pcIdx++;
		pcFields[pcIdx] = new ListGridField("costDate");
		pcFields[pcIdx].setShowGridSummary(false);
		pcFields[pcIdx].setWidth("40%");
		projectCostGrid.setShowRowNumbers(true);
		projectCostGrid.setFields(pcFields);
		projectCostGrid.setShowGridSummary(true);
		projectCostGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if(!projectCostGrid.anySelected()){
					SC.say("请选择一条数据");
				}
				Record selected = projectCostGrid.getSelectedRecords()[0];
				//如果是报销流转过来的数据，则看报销单的内容
				if(ClientUtil.checkAndGetIntValue(selected.getAttribute("processInstanceId")) > 0 && ClientUtil.checkAndGetIntValue(selected.getAttribute("processId")) > 0 && ClientUtil.checkAndGetIntValue(selected.getAttribute("processType")) > 0){
					ViewProcessWindow Reimbursement = new ViewProcessWindow();
	                Reimbursement.setWidth("80%");
	                Reimbursement.setHeight("80%");
	                Reimbursement.setLayoutMode(0);
	                Reimbursement.setInstanceData(selected);
	                Reimbursement.initComponents();
	                Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
	                Reimbursement.show();
				}else{//否则，直接显示成本基本信息
					GenericViewWindow detail = new GenericViewWindow();
					detail.setTitle("项目经费");
					detail.setWidth100();
					detail.setHeight100();
					ProjectCostViewer viewer = new ProjectCostViewer();
					viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
					viewer.initComponents();
					viewer.viewSelectedData((ListGrid) event.getSource());
					detail.setContent(viewer);
					detail.centerInPage();
					detail.show();
				}
			}
		});
		projectSettlementGrid.setDataSource(DSSprojectsettlementpor.getInstance());
		int psIdx = 0;
		ListGridField[] psFields = new ListGridField[8];
		psFields[psIdx] = new ListGridField("employeeId");
		psFields[psIdx].setShowGridSummary(false);
		psFields[psIdx].setWidth("10%");
		psIdx++;
		psFields[psIdx] = new ListGridField("totalAmount");
		psFields[psIdx].setWidth("10%");
		psIdx++;
		psFields[psIdx] = new ListGridField("totalCost");
		psFields[psIdx].setWidth("10%");
		psIdx++;
		psFields[psIdx] = new ListGridField("settlementAmount");
		psFields[psIdx].setWidth("10%");
		psIdx++;
		psFields[psIdx] = new ListGridField("leftAmount");
		psFields[psIdx].setWidth("10%");
		psIdx++;
		psFields[psIdx] = new ListGridField("settlementDate");
		psFields[psIdx].setShowGridSummary(false);
		psFields[psIdx].setWidth("10%");
		psIdx++;
		psFields[psIdx] = new ListGridField("settlementStatus");
		psFields[psIdx].setShowGridSummary(false);
		psFields[psIdx].setWidth("10%");
		psIdx++;
		psFields[psIdx] = new ListGridField("remark");
		psFields[psIdx].setShowGridSummary(false);
		psFields[psIdx].setWidth("40%");
		projectSettlementGrid.setShowRowNumbers(true);
		projectSettlementGrid.setFields(psFields);
		projectSettlementGrid.setShowGridSummary(true);
		projectSettlementGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("结算信息");
				detail.setWidth100();
				detail.setHeight100();
				SprojectsettlementporViewer viewer = new SprojectsettlementporViewer();
				if (Browser.getIsDesktop()) {
					viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
				} else {
					viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
				}
				viewer.initComponents();
				viewer.viewSelectedData((ListGrid) event.getSource());
				detail.setContent(viewer);
				detail.centerInPage();
				detail.show();
			}
		});
		projectAttachmentGrid.setDataSource(DSSprojectattachmentpor.getInstance());
		projectAttachmentGrid.setShowRowNumbers(true);
		projectAttachmentGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("确认函明细");
				detail.setWidth100();
				detail.setHeight100();
				SprojectattachmentporViewer viewer = new SprojectattachmentporViewer();
				if (Browser.getIsDesktop()) {
					viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
				} else {
					viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
				}
				viewer.initComponents();
				viewer.viewSelectedData((ListGrid) event.getSource());
				detail.setContent(viewer);
				detail.centerInPage();
				detail.show();
			}
		});
//		projectIntegralTransferGrid.setDataSource(DSMprojectintegraltransferrecord.getInstance());
//		projectIntegralTransferGrid.setShowRowNumbers(true);
//		projectIntegralTransferGrid.addDoubleClickHandler(new DoubleClickHandler() {
//			@Override
//			public void onDoubleClick(DoubleClickEvent event) {
//				GenericViewWindow detail = new GenericViewWindow();
//				detail.setTitle("项目积分转移明细");
//				detail.setWidth100();
//				detail.setHeight100();
//				MprojectintegraltransferrecordViewer viewer = new MprojectintegraltransferrecordViewer();
//				if (Browser.getIsDesktop()) {
//					viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
//				} else {
//					viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
//				}
//				viewer.initComponents();
//				viewer.viewSelectedData((ListGrid) event.getSource());
//				detail.setContent(viewer);
//				detail.centerInPage();
//				detail.show();
//			}
//		});
//		projectIntegralChangeGrid.setDataSource(DSMprojectintegralchangerecord.getInstance());
//		projectIntegralChangeGrid.setShowRowNumbers(true);
//		projectIntegralChangeGrid.addDoubleClickHandler(new DoubleClickHandler() {
//			@Override
//			public void onDoubleClick(DoubleClickEvent event) {
//				GenericViewWindow detail = new GenericViewWindow();
//				detail.setTitle("项目积分调整明细");
//				detail.setWidth100();
//				detail.setHeight100();
//				MprojectintegralchangerecordViewer viewer = new MprojectintegralchangerecordViewer();
//				if (Browser.getIsDesktop()) {
//					viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
//				} else {
//					viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
//				}
//				viewer.initComponents();
//				viewer.viewSelectedData((ListGrid) event.getSource());
//				detail.setContent(viewer);
//				detail.centerInPage();
//				detail.show();
//			}
//		});
		// 高管和事业部负责人
//		if (RoleDefinition.ROLE_MANAGEMENT_TEAM == roleID || RoleDefinition.ROLE_DEPARTMENT_DIRECTOR == roleID) {
//			projectIntegralAssignGrid.hide();
//		}
//		projectIntegralAssignGrid.setDataSource(DSSprojectIntegralAssign.getInstance());
//		projectIntegralAssignGrid.setShowRowNumbers(true);
//		projectIntegralAssignGrid.addDoubleClickHandler(new DoubleClickHandler() {
//			@Override
//			public void onDoubleClick(DoubleClickEvent event) {
//				GenericViewWindow detail = new GenericViewWindow();
//				detail.setTitle("项目积分发放明细");
//				detail.setWidth100();
//				detail.setHeight100();
//				SprojectIntegralAssignViewer viewer = new SprojectIntegralAssignViewer();
//				if (Browser.getIsDesktop()) {
//					viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
//				} else {
//					viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
//				}
//				viewer.initComponents();
//				viewer.viewSelectedData((ListGrid) event.getSource());
//				detail.setContent(viewer);
//				detail.centerInPage();
//				detail.show();
//			}
//		});
		projectAdvanceGrid.setDataSource(DSSProjectEmployeeAdvanceRecordpor.getInstance());
		int paIdx = 0;
		ListGridField[] paFields = new ListGridField[3];
		paFields[paIdx] = new ListGridField("projectId");
		paFields[paIdx].setShowGridSummary(false);
		paFields[paIdx].setWidth("60%");
		paIdx++;
		paFields[paIdx] = new ListGridField("employeeId");
		paFields[paIdx].setShowGridSummary(false);
		paFields[paIdx].setWidth("20%");
		paIdx++;
		paFields[paIdx] = new ListGridField("advanceIntegral");
		paFields[paIdx].setWidth("20%");
		projectAdvanceGrid.setShowRowNumbers(true);
		projectAdvanceGrid.setFields(paFields);
		projectAdvanceGrid.setShowGridSummary(true);
		projectAdvanceGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if (projectAdvanceGrid.anySelected()) {
					Record record = projectAdvanceGrid.getSelectedRecords()[0];
					String employeeId = record.getAttribute("employeeId");
					String employeeName = KeyValueManager.getValueMap("employees").get(employeeId);
					PopupWindow pw = new PopupWindow();
					ProjectEmployeeAdvanceEachPersonDetailPanel panel = new ProjectEmployeeAdvanceEachPersonDetailPanel();
					panel.setEmployeeId(ClientUtil.checkAndGetIntValue(employeeId));
					panel.setProjectId(ClientUtil.checkAndGetIntValue(record.getAttribute("projectId")));
					pw.addItem(panel.getViewPanel());
					pw.setTitle(employeeName + "项目补贴明细");
					pw.setWidth100();
					pw.setHeight100();
					pw.centerInPage();
					pw.show();
					panel.commonQuery();
				}
			}
		});
		
		projectAdvanceRecordGrid.setDataSource(DSSProjectAdvanceRecord.getInstance());
		projectAdvanceRecordGrid.setShowRowNumbers(true);
		int parIdx = 0;
		ListGridField[] parFields = new ListGridField[6];
		parFields[parIdx] = new ListGridField("plateId");
		parFields[parIdx].setWidth("10%");
		parIdx++;
		parFields[parIdx] = new ListGridField("projectId");
		parFields[parIdx].setWidth("10%");
		parIdx++;
		parFields[parIdx] = new ListGridField("advanceIntegral");
		parFields[parIdx].setWidth("10%");
		parIdx++;
		parFields[parIdx] = new ListGridField("leftIntegral");
		parFields[parIdx].setWidth("10%");
		parIdx++;
		parFields[parIdx] = new ListGridField("advanceDate");
		parFields[parIdx].setWidth("10%");
		parIdx++;
		parFields[parIdx] = new ListGridField("flag","补贴来源");
		parFields[parIdx].setWidth("10%");
		parFields[parIdx].setValueMap(KeyValueManager.getValueMap("system_dictionary_143"));
		parIdx++;
		parFields[parIdx] = new ListGridField("remark");
		parFields[parIdx].setWidth("40%");
		projectAdvanceRecordGrid.setFields(parFields);
		projectAdvanceRecordGrid.setShowGridSummary(true);
		
		projectContractChangeGrid.setDataSource(DSProjectChangeEmployee.getInstance());
		projectContractChangeGrid.setShowRowNumbers(true);
		projectContractChangeGrid.setAutoFitFieldWidths(false);
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "项目信息";
	}

	@Override
	public int getGroupCount() {
		return 0;
	}

	@Override
	public List<GroupColumn> getGroupColumnNames() {
		List<GroupColumn> gcs = new ArrayList<>();
		return gcs;
	}

	@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
	@Override
	public void viewSelectedData(ListGrid grid) {
		super.viewSelectedData(grid);
		Record selected = grid.getSelectedRecord();
		//获取项目积分
        BigDecimal projectIntegral = BaseHelpUtils.getBigDecimalValue(selected.getAttribute("projectIntegral"));
		Map<String,Object> condition = null;
		java.util.Map parentSearch = __parentSearchForm == null ? new java.util.HashMap()
				: __parentSearchForm.getValues();
		condition = new java.util.HashMap();
		SC.debugger();
		projectId = BaseHelpUtils.getIntValue(selected.getAttribute("projectId"));
		condition.put("projectId", projectId);
		DBDataSource.callOperation("NQ_MprojectemployeeForQuery", "find", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
                	if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
                		BigDecimal totalRealIntegral = BigDecimal.ZERO;
                		BigDecimal totalCost = BigDecimal.ZERO;
                		for(Record obj : records){
                			//计算项目成员 确认积分总和
                			if(!BaseHelpUtils.isNullOrEmpty(obj.getAttribute("realIntegral"))){
                				totalRealIntegral = totalRealIntegral.add(BaseHelpUtils.getBigDecimalValue(obj.getAttribute("realIntegral")));
                			}
                			//计算项目成员 项目成本总和
                			if(!BaseHelpUtils.isNullOrEmpty(obj.getAttribute("cost"))){
                				totalCost = totalCost.add(BaseHelpUtils.getBigDecimalValue(obj.getAttribute("cost")));
                			}
                		}
                		for(Record e : records){
                			//获取预分配积分
                			BigDecimal planIntegral = BaseHelpUtils.getBigDecimalValue(e.getAttribute("planIntegral"));
                			//设置预分配积分占比=预分配积分/项目积分
                			BigDecimal planIntegralPercent = (projectIntegral.compareTo(BigDecimal.ZERO) != 0)?(planIntegral.multiply(BigDecimal.valueOf(100)).divide(projectIntegral,2,BigDecimal.ROUND_DOWN)):BigDecimal.ZERO;
                			e.setAttribute("planIntegralPercent",planIntegralPercent);
                			
                			//计算确认积分占比 = 个人确认积分/项目成员确认积分总和
                			BigDecimal realIntegralPercent = (totalRealIntegral.compareTo(BigDecimal.ZERO) != 0) ? BaseHelpUtils.getBigDecimalValue(e.getAttribute("realIntegral")).multiply(BigDecimal.valueOf(100)).divide(totalRealIntegral,2,BigDecimal.ROUND_DOWN) : BigDecimal.ZERO;
                			e.setAttribute("realIntegralPercent", realIntegralPercent);
                			
                			//计算项目成本占比 = 个人项目成本/项目成员项目成本总和
                			BigDecimal costPercent = (totalCost.compareTo(BigDecimal.ZERO) != 0) ? BaseHelpUtils.getBigDecimalValue(e.getAttribute("cost")).multiply(BigDecimal.valueOf(100)).divide(totalCost,2,BigDecimal.ROUND_DOWN) : BigDecimal.ZERO;
                			e.setAttribute("costPercent", costPercent);
                		}
                	}
					projectEmployeesGrid.setData(dsResponse.getData());
				}
			}
		});
		
		
		Map<String,Object> params = new HashMap<>();
		params.put("projectId", projectId);
		DBDataSource.callOperation("NQ_SearchMainProjectEmployeeDataByProjectId", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					employeeGrid.setData(dsResponse.getData());
				}
			}
		});
		
		
		condition = new java.util.HashMap();
		condition.put("projectId", projectId);
		DBDataSource.callOperation("NQ_OnLoadProjectStageSettlement", "find", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					if(!BaseHelpUtils.isNullOrEmpty(records)){
						int len = records.length;
						DataSource gridDataSource = new DataSource();
						DataSourceTextField employeeIdField = new DataSourceTextField("employeeId","项目成员Id");
						employeeIdField.setHidden(true);
						gridDataSource.addField(employeeIdField);
						
						DataSourceTextField employeeNoField = new DataSourceTextField("employeeNo","员工编号");
						gridDataSource.addField(employeeNoField);
						
						DataSourceTextField employeeNameField = new DataSourceTextField("employeeName","员工姓名");
						gridDataSource.addField(employeeNameField);
						
						DataSourceTextField gradeIdField = new DataSourceTextField("gradeId","职级");
						gradeIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_3"));
						gridDataSource.addField(gradeIdField);
						
						HeaderSpan[] headerSpanArr = new HeaderSpan[len+1];
						for(int i = 0;i<len;i++){
							Record record = records[i];
							int stageId = BaseHelpUtils.getIntValue(record.getAttribute("stageId"));
							stageMap.put(stageId,record);
							String stageName = BaseHelpUtils.getString(record.getAttribute("stageName"));
							DataSourceFloatField planField = new DataSourceFloatField();
							planField.setName("planIntegral_"+stageId);
							planField.setTitle("预分配积分");
							planField.setLength(18);
							planField.setDecimalPad(2);
							planField.setFormat("#,###,###,###,##0.00");
							planField.setEmptyDisplayValue("0");
							gridDataSource.addField(planField);
							DataSourceTextField percentField = new DataSourceTextField();
							percentField.setName("percent_"+stageId);
							percentField.setTitle("占比(%)");
							percentField.setEmptyDisplayValue("0");
							gridDataSource.addField(percentField);
							DataSourceFloatField sureField = new DataSourceFloatField();
							sureField.setName("sureIntegral_"+stageId);
							sureField.setTitle("确认积分");
							sureField.setLength(18);
							sureField.setDecimalPad(2);
							sureField.setFormat("#,###,###,###,##0.00");
							sureField.setEmptyDisplayValue("0");
							gridDataSource.addField(sureField);
							//获取每个阶段的占比和积分
							BigDecimal percent = BaseHelpUtils.getBigDecimalValue(record.getAttribute("percent"));
							BigDecimal projectAmount = BaseHelpUtils.getBigDecimalValue(record.getAttribute("projectAmount"));
							HeaderSpan headerSpan = new HeaderSpan(stageName+"<br />阶段占比："+percent+"%<br />阶段积分："+projectAmount+"", new String[] {"planIntegral_"+stageId,"percent_"+stageId,"sureIntegral_"+stageId});
							headerSpan.setHeight(60);
							headerSpanArr[i] = headerSpan;
						}
						//添加合计
						DataSourceFloatField planTotalField = new DataSourceFloatField("planTotal","预分配积分");
						planTotalField.setLength(18);
						planTotalField.setDecimalPad(2);
						planTotalField.setFormat("#,###,###,###,##0.00");
						planTotalField.setEmptyDisplayValue("0");
						gridDataSource.addField(planTotalField);
						
						DataSourceFloatField sureTotalField = new DataSourceFloatField("sureTotal","确认积分");
						sureTotalField.setLength(18);
						sureTotalField.setDecimalPad(2);
						sureTotalField.setFormat("#,###,###,###,##0.00");
						sureTotalField.setEmptyDisplayValue("0");
						gridDataSource.addField(sureTotalField);
						HeaderSpan headerSpan = new HeaderSpan("合计", new String[] {"planTotal","sureTotal"});
						headerSpan.setHeight(60);
						headerSpanArr[len] = headerSpan;
						
						projectStageEmployeesGrid.setHeaderSpans(headerSpanArr);
						projectStageEmployeesGrid.setDataSource(gridDataSource);
						//加载项目成员信息
						getEmpData(projectId);
						//判断是否匹配标准人员数
					}
				}
			}
		});
		
		
		condition = new java.util.HashMap();
		//根据订单的项目编号去项目表取项目id，去成本表取成本
		String projectCode = BaseHelpUtils.getString(selected.getAttribute("projectCode"));
		if(!BaseHelpUtils.isNullOrEmpty(projectCode)) {
			condition.clear();
			condition.put("projectCode", projectCode);
			DBDataSource.callOperation("ST_MainProject", "find", condition, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if (dsResponse.getStatus() >= 0) {
						Record[] records = dsResponse.getData();
						if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0) {
							Record r = records[0];
							//获取项目id
							Map<String,Integer> params = new HashMap<>();
							params.put("projectId", BaseHelpUtils.getIntValue(r.getAttribute("mainProjectId")));
							DBDataSource.callOperation("ST_ProjectCost", "find", params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() >= 0) {
										projectCostGrid.setData(dsResponse.getData());
									}
								}
							});
						}
					}
				}
			});
		}
		condition = new java.util.HashMap();
		condition.put("projectId", projectId);
		DBDataSource.callOperation("NQ_Sprojectsettlementpor", "find", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					projectSettlementGrid.setData(dsResponse.getData());
				}
			}
		});
		condition = new java.util.HashMap();
		condition.put("projectId", projectId);
		DBDataSource.callOperation("NQ_Sprojectattachmentpor", "find", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					projectAttachmentGrid.setData(dsResponse.getData());
				}
			}
		});
		
        condition = new java.util.HashMap();
        condition.put("projectId",projectId);
        DBDataSource.callOperation("ST_Project", "find", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0 && dsResponse.getData().length > 0) {
					Record record = dsResponse.getData()[0];
					int contractId = BaseHelpUtils.getIntValue(record.getAttribute("contractId"));
					Map map = new HashMap<>();
					map.put("contractId", contractId);
					DBDataSource.callOperation("ST_ProjectStage", "find", map, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() >= 0) {
								projectStagesGrid.setData(dsResponse.getData());
							}
						}
					});
				}
            }
        });
		
//		condition = new java.util.HashMap();
//		condition.put("fromProjectId", projectId);
//		DBDataSource.callOperation("NQ_Mprojectintegraltransferrecord", "find", condition, new DSCallback() {
//			@Override
//			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//				if (dsResponse.getStatus() >= 0) {
//					projectIntegralTransferGrid.setData(dsResponse.getData());
//				}
//			}
//		});
//		condition = new java.util.HashMap();
//		condition.put("projectId", projectId);
//		DBDataSource.callOperation("NQ_Mprojectintegralchangerecord", "find", condition, new DSCallback() {
//			@Override
//			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//				if (dsResponse.getStatus() >= 0) {
//					projectIntegralChangeGrid.setData(dsResponse.getData());
//				}
//			}
//		});
//		condition = new java.util.HashMap();
//		condition.put("projectId", projectId);
//		DBDataSource.callOperation("NQ_SprojectIntegralAssign", "find", condition, new DSCallback() {
//			@Override
//			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//				if (dsResponse.getStatus() >= 0) {
//					projectIntegralAssignGrid.setData(dsResponse.getData());
//				}
//			}
//		});
		condition = new java.util.HashMap();
		condition.put("projectId", projectId);
		DBDataSource.callOperation("NQ_SProjectEmployeeAdvanceRecordpor", "find", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					projectAdvanceGrid.setData(dsResponse.getData());
				}
			}
		});
		
		condition = new java.util.HashMap();
		condition.put("projectId", projectId);
		condition.put("addtionalCondition", "order by advance_date desc");
		DBDataSource.callOperation("ST_ProjectAdvanceRecord", "find", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					projectAdvanceRecordGrid.setData(dsResponse.getData());
				}
			}
		});
		
		condition = new java.util.HashMap();
		condition.put("projectId", projectId);
		List<Map<String,String>> keyvalues = new ArrayList<>();
		Map<String, String> kv = new HashMap<>();
		kv.put("key", "0.0 as integral from project_employees a");
		kv.put("value", "a.integral from project_contract_employees a");
		keyvalues.add(kv);
		condition.put("keyValues", keyvalues);
		DBDataSource.callOperation("NQ_OnLoadProjectChangeEmployee", "find", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] recordsOne = dsResponse.getData();
					Map<String,Object> param = new HashMap<>();
					param.put("projectId", projectId);
					param.put("isCompleted", Boolean.TRUE);
					//获取部门分摊的积分
					DBDataSource.callOperation("ST_ProjectContractChange", "find", param, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() >= 0) {
								Record[] records = dsResponse.getData();
								BigDecimal plateIntegral = BigDecimal.ZERO;
								if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
									for(Record record : records){
										plateIntegral = plateIntegral.add(BaseHelpUtils.getBigDecimalValue(record.getAttribute("plateIntegral")));
									}
								}
								int len = recordsOne.length;
								if(!BaseHelpUtils.isNullOrEmpty(recordsOne) && len > 0){
									Record[] datas = new Record[len+1];
									BigDecimal integral = BigDecimal.ZERO;
									int i = 0;
									for(Record record : recordsOne){
										datas[i] = record;
										integral = integral.add(BaseHelpUtils.getBigDecimalValue(record.getAttribute("integral")));
										i++;
									}
									Record record = new Record();
									record.setAttribute("employeeNo","汇总:成员承担积分("+integral+"),部门承担积分("+plateIntegral+")");
									datas[i] = record;
									projectContractChangeGrid.setData(datas);
								}
							}
						}
					});
				}
			}
		});
	}
	
	//加载成员列表信息
	public void getEmpData(int projectId){
		Map<String,Object> condition = new HashMap<>();
		condition.put("projectId",projectId);
		DBDataSource.callOperation("NQ_OnLoadProjectEmpAndStageInfo", "find", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
						//定义map来存放每个成员的数据集
						Map<Integer,Record> map = new HashMap<>();
						for(Record e : records){
							//获取职员Id
							int employeeId = BaseHelpUtils.getIntValue(e.getAttribute("employeeId"));
							//获取阶段Id
							int stageId = BaseHelpUtils.getIntValue(e.getAttribute("stageId"));
							//获取该成员在阶段上的预分配积分
							BigDecimal planIntegral = BaseHelpUtils.getBigDecimalValue(e.getAttribute("planIntegral"));
							//获取该成员在阶段上已经确认的积分
							BigDecimal sureIntegral = BaseHelpUtils.getBigDecimalValue(e.getAttribute("sureIntegral"));
							Record record = map.get(employeeId);
							if(BaseHelpUtils.isNullOrEmpty(record)){
								record = new Record();
								record.setAttribute("employeeId", employeeId);
								record.setAttribute("employeeNo",e.getAttribute("employeeNo"));
								record.setAttribute("employeeName",e.getAttribute("employeeName"));
								record.setAttribute("gradeId", e.getAttribute("gradeId"));
							}
							record.setAttribute("planIntegral_"+stageId,planIntegral);
							record.setAttribute("sureIntegral_"+stageId,sureIntegral);
							//获取当前阶段积分
							Record stageRe = stageMap.get(stageId);
							if(!BaseHelpUtils.isNullOrEmpty(stageRe)){
								BigDecimal stageIntegral = BaseHelpUtils.getBigDecimalValue(stageRe.getAttribute("projectAmount"));
								if(stageIntegral.compareTo(BigDecimal.ZERO) > 0){
									BigDecimal percent = planIntegral.multiply(BigDecimal.valueOf(100)).divide(stageIntegral, 2,BigDecimal.ROUND_DOWN);
									record.setAttribute("percent_"+stageId,percent);
								}
							}
							BigDecimal planTotal = BaseHelpUtils.getBigDecimalValue(record.getAttribute("planTotal"));
							record.setAttribute("planTotal",planTotal.add(planIntegral));
							BigDecimal sureTotal = BaseHelpUtils.getBigDecimalValue(record.getAttribute("sureTotal"));
							record.setAttribute("sureTotal",sureTotal.add(sureIntegral));
							map.put(employeeId,record);
						}
						int size = map.size();
						if(size > 0){
							Record[] resultData = new Record[size];
							int i = 0;
							for(Integer empId : map.keySet()){
								resultData[i] = map.get(empId);
								i++;
							}
							projectStageEmployeesGrid.setData(resultData);
						}
					}
					ListGridField field = projectStageEmployeesGrid.getField("employeeId");
					if (field != null) {
						field.setAutoFreeze(true);
					}
				}
			}
		});
	}

	@Override
	public DataSource getMainDataSource() {
		return DSSprojectView.getInstance();
	}

	@Override
	public int getDetailCount() {
		return 9;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<>();
		res.add(employeeGrid);
		res.add(projectEmployeesGrid);
		res.add(projectStageEmployeesGrid);
		res.add(projectCostGrid);
		res.add(projectSettlementGrid);
		res.add(projectAttachmentGrid);
//		res.add(projectIntegralTransferGrid);
//		res.add(projectIntegralChangeGrid);
//		res.add(projectIntegralAssignGrid);
		res.add(projectAdvanceGrid);
		res.add(projectContractChangeGrid);
        res.add(projectStagesGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<>();
		res.add("项目相关人员");
		res.add("项目成员");
		res.add("项目阶段成员明细");
		res.add("项目经费");
		res.add("结算信息");
		res.add("确认函明细");
//		res.add("项目积分转移明细");
//		res.add("项目积分调整明细");
//		res.add("项目积分发放明细");
		res.add("项目补贴明细");
		res.add("项目合同变更");
        res.add("设计阶段");
		return res;
	}
	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm(SearchForm value) {
		this.__parentSearchForm = value;
	}

}
