package com.pomplatform.client.projectTemplate.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.viewer.DetailViewerField;
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
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.util.SC;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.pomplatform.client.designer.panel.DesignerProjectPanel;
import com.pomplatform.client.project.datasource.DSProjectChangeEmployee;
import com.pomplatform.client.projectStageTemplate.datasource.DSSprojectstagetemplateor;
import com.pomplatform.client.projectTemplate.datasource.DSSprojecttemplateor;
import com.pomplatform.client.projectattachment.datasource.DSSprojectattachmentpor;
import com.pomplatform.client.projectattachment.form.SprojectattachmentporViewer;
import com.pomplatform.client.projectemployeeadvanceeachpersondetail.panel.ProjectEmployeeAdvanceEachPersonDetailPanel;
import com.pomplatform.client.projectview.datasource.DSProjectCost;
import com.pomplatform.client.projectview.datasource.DSProjectEmployee;
import com.pomplatform.client.projectview.datasource.DSSprojectView;
import com.pomplatform.client.projectview.form.ProjectCostViewer;
import com.pomplatform.client.settle.datasource.DSSprojectsettlementpor;
import com.pomplatform.client.settle.form.SprojectsettlementporViewer;
import com.pomplatform.client.sprojectadvancerecord.datasource.DSSProjectAdvanceRecord;
import com.pomplatform.client.sprojectemployeeadvancerecordpor.datasource.DSSProjectEmployeeAdvanceRecordpor;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;

public class SprojecttemplateorViewer extends AbstractDetailViewer{
	
	
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
	
	//新增
	private DelicacyListGrid projectTemplateGrid = new DelicacyListGrid();
	private DelicacyListGrid projectStageTemplateGrid = new DelicacyListGrid();
	
	private SearchForm __parentSearchForm;
	private int projectTemplateId;
	int roleID = ClientUtil.getRoleId();
	private final String layoutGroupStyle = "2px solid #555555;border-top-width:22px;border-radius:5px;";

	public SprojecttemplateorViewer() {
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
			
		
			
			for (int i = 0; i < getDetailCount(); i++) {
				tab = new Tab(names.get(i));
				if(i == 1){//项目阶段成员明细
					tab.setPane(projectStageEmployeesGrid);
				}else if(i == 5){//项目补贴明细
					tab.setPane(advanceLayout);
				}else{
					tab.setPane(grids.get(i));
				}
				mainTab.addTab(tab);
			}
			addMember(mainTab);
			break;
		}
		
		
		
		int ptIdx = 0;
		ListGridField[] ptFields = new ListGridField[4];
		ptFields[ptIdx] = new ListGridField("projectTemplateId");
		ptFields[ptIdx].setWidth("10%");
		ptIdx++;
		ptFields[ptIdx] = new ListGridField("projectTemplateName");
		ptFields[ptIdx].setWidth("10%");
		ptIdx++;
		ptFields[ptIdx] = new ListGridField("projectType");
		ptFields[ptIdx].setWidth("10%");
		ptFields[ptIdx].setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
		ptIdx++;
		ptFields[ptIdx] = new ListGridField("plateId");
		ptFields[ptIdx].setWidth("10%");
		ptFields[ptIdx].setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		ptIdx++;
		ptFields[ptIdx] = new ListGridField("businessType");
		ptFields[ptIdx].setWidth("60%");
		ptFields[ptIdx].setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		projectTemplateGrid.setFields(ptFields);
		projectTemplateGrid.setShowGridSummary(true);
		
		projectTemplateGrid.setDataSource(DSSprojecttemplateor.getInstance());
		projectTemplateGrid.setShowRowNumbers(true);
		projectTemplateGrid.setAutoFitFieldWidths(false);
		
		int pssIdx = 0;
		ListGridField[] pssFields = new ListGridField[6];
		pssFields[pssIdx] = new ListGridField("projectStageTemplateId");
		pssFields[pssIdx].setWidth("10%");
		pssIdx++;
		pssFields[pssIdx] = new ListGridField("stageId");
		pssFields[pssIdx].setWidth("10%");
		pssIdx++;
		pssFields[pssIdx] = new ListGridField("percent");
		pssFields[pssIdx].setWidth("10%");
		pssIdx++;
		pssFields[pssIdx] = new ListGridField("stageName");
		pssFields[pssIdx].setWidth("10%");
		pssIdx++;
		pssFields[pssIdx] = new ListGridField("projectTemplateName");
		pssFields[pssIdx].setWidth("10%");
		pssIdx++;
		pssFields[pssIdx] = new ListGridField("projectTemplateId");
		pssFields[pssIdx].setWidth("10%");
		pssIdx++;
		pssFields[pssIdx] = new ListGridField("projectAmount");
		pssFields[pssIdx].setWidth("40%");
		projectStageTemplateGrid.setFields(pssFields);
		projectStageTemplateGrid.setShowGridSummary(true);
		
		projectStageTemplateGrid.setDataSource(DSSprojectstagetemplateor.getInstance());
		projectStageTemplateGrid.setShowRowNumbers(true);
		projectStageTemplateGrid.setAutoFitFieldWidths(true);
		
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
		Map<String,Object> condition = null;
		SC.debugger();
		projectTemplateId = BaseHelpUtils.getIntValue(selected.getAttribute("projectTemplateId"));
		
		///1111
		condition = new java.util.HashMap();
		condition.put("projectTemplateId", projectTemplateId);
		DBDataSource.callOperation("ST_ProjectTemplate", "find", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					
					projectTemplateGrid.setData(dsResponse.getData());
				}
			}
		});
		
				condition = new java.util.HashMap();
				condition.put("projectTemplateId", projectTemplateId);
				DBDataSource.callOperation("ST_ProjectStageTemplate", "find", condition, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							projectStageTemplateGrid.setData(dsResponse.getData());
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
//		return DSSprojectView.getInstance();
		return DSSprojecttemplateor.getInstance();
	}

	@Override
	public int getDetailCount() {
		return 1;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<>();
/*		res.add(projectEmployeesGrid);
		res.add(projectStageEmployeesGrid);
		res.add(projectCostGrid);
		res.add(projectSettlementGrid);
		res.add(projectAttachmentGrid);
		res.add(projectAdvanceGrid);
		res.add(projectContractChangeGrid);*/
//		res.add(projectTemplateGrid);
		res.add(projectStageTemplateGrid);
		return res;
	}
	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<>();
/*		res.add("项目成员");
		res.add("项目阶段成员明细");
		res.add("项目经费");
		res.add("结算信息");
		res.add("确认函明细");
		res.add("项目补贴明细");
		res.add("项目合同变更");*/
//		res.add("项目模板");
		res.add("项目阶段明细");
		return res;
	}
	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm(SearchForm value) {
		this.__parentSearchForm = value;
	}
	
}

