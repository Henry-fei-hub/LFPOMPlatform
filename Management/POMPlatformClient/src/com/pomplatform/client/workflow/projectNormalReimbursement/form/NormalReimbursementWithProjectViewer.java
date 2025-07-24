package com.pomplatform.client.workflow.projectNormalReimbursement.form;

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
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.aboutreimbursementpayseq.datasource.DSAboutReimbursementPayseq;
import com.pomplatform.client.memployeemoneymanageeeedcieftrcvmmor.panel.MemployeemoneymanageeeedcieftrcvmmorPanel;
import com.pomplatform.client.spaymoneymanagemmcor.panel.SpaymoneymanagemmcorPanel;
import com.pomplatform.client.sprocessbilllistpppor.datasource.DSSprocessbilllistpppor;
import com.pomplatform.client.workflow.projectNormalReimbursement.datasource.DSNormalReimbursementLinkProject;
import com.pomplatform.client.workflow.projectNormalReimbursement.datasource.DSNormalReimbursementWithProject;
import com.pomplatform.client.workflow.projectNormalReimbursement.datasource.DSProjectNormalReimbursementDetail;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.fields.DataSourceLinkField;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.SplitPane;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.viewer.DetailViewer;

public class NormalReimbursementWithProjectViewer extends AbstractDetailViewer
{


	private final DelicacyListGrid projectNormalReimbursementDetailsGrid = new DelicacyListGrid();
	private final DelicacyListGrid normalReimbursementLinkProjectsGrid = new DelicacyListGrid();
	private final DelicacyListGrid processBillListGrid = new DelicacyListGrid();
	private SearchForm __parentSearchForm;
	private String processName;
	private Integer processType;
	private final Logger __logger = Logger.getLogger("");
	private SplitPane mainPane;
	private DelicacyListGrid bdDetailGrid = new DelicacyListGrid();
	public NormalReimbursementWithProjectViewer() {
	}

	@Override
	public void initComponents() {
		//super.initComponents();
		/**
		 * 针对预算业务需求
		 * 对父类initComponents()部分属性重写
		 */
		setWidth100();
		setHeight100();
		setLayoutMargin(5);
		setMembersMargin(5);
		setBackgroundColor("azure");
		setBorder("1px solid gray");
		setCanSelectText(true);
		List<GroupColumn> gcs = getGroupColumnNames();
		DetailViewer mainView = new DetailViewer();
		mainView.setCanSelectText(true);
		mainView.setHeight100();
		mainView.setWidth100();
		mainView.setWrapValues(true);
		mainView.setKeepInParentRect(true);
		mainView.setDataSource(getMainDataSource());
		detailViewers.add(mainView);

		mainPane = new SplitPane();
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
		left.setOverflow(Overflow.AUTO);
		mainPane.setNavigationPane(left);

		addMember(mainPane);
		
		
		projectNormalReimbursementDetailsGrid.setDataSource(DSProjectNormalReimbursementDetail.getInstance());
		projectNormalReimbursementDetailsGrid.addDoubleClickHandler(new DoubleClickHandler(){
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("");
				detail.setWidth(700); detail.setHeight(500); 
				ProjectNormalReimbursementDetailViewer viewer = new ProjectNormalReimbursementDetailViewer();
				viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
				viewer.initComponents();
				viewer.viewSelectedData((ListGrid)event.getSource());
				detail.setContent(viewer);
				detail.centerInPage();detail.show();
			}
		});
		normalReimbursementLinkProjectsGrid.setDataSource(DSNormalReimbursementLinkProject.getInstance());
		normalReimbursementLinkProjectsGrid.addDoubleClickHandler(new DoubleClickHandler(){
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("");
				detail.setWidth(700); detail.setHeight(500); 
				NormalReimbursementLinkProjectViewer viewer = new NormalReimbursementLinkProjectViewer();
				viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
				viewer.initComponents();
				viewer.viewSelectedData((ListGrid)event.getSource());
				detail.setContent(viewer);
				detail.centerInPage();detail.show();
			}
		});
		processBillListGrid.setDataSource(DSSprocessbilllistpppor.getInstance());
		processBillListGrid.setSelectionType(SelectionStyle.SINGLE);
		if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.VIEW_ALL_MONEY)){
			processBillListGrid.addDoubleClickHandler(new DoubleClickHandler() {
				
				@Override
				public void onDoubleClick(DoubleClickEvent event) {
					if(processBillListGrid.anySelected()){
						Record record = processBillListGrid.getSelectedRecord();
						int payFor = record.getAttributeAsInt("payFor");
						PopupWindow window = new PopupWindow();
						window.setWidth100();
						window.setHeight100();
						window.centerInPage();
						
						if(payFor == 1){//个人
							window.setTitle("个人借款信息");
							MemployeemoneymanageeeedcieftrcvmmorPanel panel = new MemployeemoneymanageeeedcieftrcvmmorPanel();
							panel.initData(record);
							window.addItem(panel);
						}else{//收款单位
							window.setTitle("单位预付款信息");
							SpaymoneymanagemmcorPanel panel = new SpaymoneymanagemmcorPanel();
							panel.initData(record);
							window.addItem(panel);
						}
						window.show();
					}
				}
			});
		}
		
		bdDetailGrid.setAlign(Alignment.CENTER);
		bdDetailGrid.setAutoFitFieldWidths(true);
		int a = 0;
		ListGridField[] aFields = new ListGridField[9];
		aFields[a] = new ListGridField("budgetAttachmentId", "附件id");
		aFields[a].setCanEdit(false);
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("budgetManagementId", "预算管理Id");
		aFields[a].setCanEdit(false);
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("attachmentName", "附件名称");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("fileUrl", "路径");
		DataSourceLinkField link = new DataSourceLinkField();
		aFields[a].setCanEdit(false);
		aFields[a].setLinkText("预算文件下载/预览");
		a++;
		aFields[a] = new ListGridField("payAmount", "<span style='color:red;'>申请付款金额</span>");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("reimbursementAmount", "<span style='color:red;'>报销金额</span>");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("reverseAmount", "<span style='color:red;'>冲账金额</span>");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("budgetContractAmount", "合同预算金额");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("budgetContractAmountUse", "合同已付金额");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("budgetContractAmountRest", "合同剩余金额");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("payPercent", "付款比例");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("receiveUnitManageId", "供应商");
		aFields[a].setAlign(Alignment.CENTER);
//		aFields[a].setValueMap(KeyValueManager.getValueMap("receive_unit_manages_company"));
		KeyValueManager.loadValueMap("receive_unit_manages_company",aFields[a]);
		aFields[a].setShowGridSummary(false);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("bddType", "预算类别");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("uploadEmployeeId", "上传人员");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setValueMap(KeyValueManager.getValueMap("employees"));
		aFields[a].setShowGridSummary(false);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("uploadTime", "上传时间");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("projectId", "项目名称");
//		aFields[a].setValueMap(KeyValueManager.getValueMap("projects"));
		KeyValueManager.loadValueMap("projects",aFields[a]);
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("uploadRemark", "备注");
		aFields[a].setType(ListGridFieldType.TEXT);
		aFields[a].setCanEdit(false);
		bdDetailGrid.setDataSource(DSAboutReimbursementPayseq.getInstance());
		bdDetailGrid.setFields(aFields);
		bdDetailGrid.setShowGridSummary(true);
		bdDetailGrid.setSelectionType(SelectionStyle.SINGLE);
		
	}

	@Override
	public int getHorizontalPercent() {
		return 40;
	}

	@Override
	public String getName() {
		return "项目日常报销";
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
		if(getBusinessId() == null) return;
		Map params = new HashMap();
		params.put("projectNormalReimbursementId", getBusinessId());
		DBDataSource.callOperation("NQ_NormalReimbursementWithProject", "find", new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					for(DetailViewer v : detailViewers){
						v.setData(dsResponse.getData());
						if(dsResponse.getData().length == 0) continue;
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
	public void viewSelectedData(ListGrid grid){
		super.viewSelectedData(grid);
		setRecord(grid.getSelectedRecord());
		viewDetailData();
	}

	public void viewDetailData(){
		Record selected = getRecord();
		// 获取预算管理id
		List<ListGrid> grids = getDetailListGrids();
		List<String> names = getDetailNames();
		int horizontalPercent = getHorizontalPercent();
		int budgetManagementId = BaseHelpUtils.getIntValue(selected.getAttribute("budgetManagementId"));
		if (budgetManagementId > 0) {
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
			for (int i = 0; i < getDetailCount()-1; i++) {

				SectionStackSection detailSection = new SectionStackSection(names.get(i));
				detailSection.addItem(grids.get(i));
				detailSection.setExpanded(true);
				detailStack.addSection(detailSection);
			}
			mainPane.setListPane(detailStack);
		}
				
		Object val;
		Map condition = null;
		Map parentSearch = __parentSearchForm == null ? new HashMap() : __parentSearchForm.getValues();
		condition = new HashMap();
		condition.put("projectNormalReimbursementId", selected.getAttributeAsString("projectNormalReimbursementId"));
		DBDataSource.callOperation("ST_ProjectNormalReimbursementDetail", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					projectNormalReimbursementDetailsGrid.setData(dsResponse.getData());
				}
			}
		});
		condition = new HashMap();
		condition.put("projectNormalReimbursementId", selected.getAttributeAsString("projectNormalReimbursementId"));
		DBDataSource.callOperation("ST_NormalReimbursementLinkProject", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					normalReimbursementLinkProjectsGrid.setData(dsResponse.getData());
				}
			}
		});
		condition = new HashMap<>();
		condition.put("opt_type", "getBillListByBusinessidProcesstype");
		condition.put("businessId", selected.getAttributeAsString("projectNormalReimbursementId"));
		condition.put("processType", getProcessType());
		DBDataSource.callOperation("EP_CustomSprocessbilllistppporProcess", condition, new DSCallback() {

			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					processBillListGrid.setData(dsResponse.getData());
				}
			}
		});
		
		// 获取预算附件ID
		int budgetAttachmentId = BaseHelpUtils.getIntValue(selected.getAttribute("budgetAttachmentId"));
		// 获取付款序列ID
		int paymentSequenceId = BaseHelpUtils.getIntValue(selected.getAttribute("paymentSequenceId"));
		if (budgetManagementId > 0&&budgetAttachmentId>0&&paymentSequenceId>0) {
			Map<String, Object> map = new HashMap<>();
			map.put("budgetManagementId", budgetManagementId);
			map.put("budgetAttachmentId", budgetAttachmentId);
			map.put("paymentSequenceId", paymentSequenceId);
			DBDataSource.callOperation("NQ_AboutReimbursementPayseq", "find", map, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if (dsResponse.getStatus() >= 0) {
						Record[] records = dsResponse.getData();
						if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0) {
							Record record = records[0];
							//获取付款金额
							BigDecimal payAmount=BaseHelpUtils.getBigDecimalValue(record.getAttribute("payAmount")); 
							//获取冲账金额
							BigDecimal  reverseAmount=BaseHelpUtils.getBigDecimalValue(record.getAttribute("reverseAmount"));
							//获取报销金额
							BigDecimal  reimbursementAmount=BaseHelpUtils.getBigDecimalValue(record.getAttribute("reimbursementAmount"));
							//获取还款金额
							BigDecimal  returnAmount=BaseHelpUtils.getBigDecimalValue(record.getAttribute("returnAmount"));
							ListGridField[] fields =  bdDetailGrid.getFields();
							for(ListGridField e : fields) {
								String name = e.getName();
								if(name.equals("payAmount") && payAmount.compareTo(BigDecimal.ZERO) <= 0) {
									e.setHidden(true);
								}else if(name.equals("reverseAmount") && reverseAmount.compareTo(BigDecimal.ZERO) <= 0) {
									e.setHidden(true);
								}else if(name.equals("reimbursementAmount") && reimbursementAmount.compareTo(BigDecimal.ZERO) <= 0) {
									e.setHidden(true);
								}else if(name.equals("returnAmount") && returnAmount.compareTo(BigDecimal.ZERO) <= 0) {
									e.setHidden(true);
								}
							}
							
							bdDetailGrid.setFields(fields);
							bdDetailGrid.redraw();
							bdDetailGrid.setData(records);
						}
					} else {
						SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
					}
				}
			});
		}
	}

	@Override
	public DataSource getMainDataSource() {
		return DSNormalReimbursementWithProject.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 4;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(projectNormalReimbursementDetailsGrid);
		res.add(normalReimbursementLinkProjectsGrid);
		res.add(processBillListGrid);
		res.add(bdDetailGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("费用明细清单");
		res.add("每个项目分担的费用");
		res.add("账单流水");
		res.add("预算付款序列");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public Integer getProcessType() {
		return processType;
	}

	public void setProcessType(Integer processType) {
		this.processType = processType;
	}

}

