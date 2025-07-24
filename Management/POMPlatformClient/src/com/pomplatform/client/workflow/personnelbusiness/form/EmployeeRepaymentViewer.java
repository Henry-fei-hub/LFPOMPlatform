package com.pomplatform.client.workflow.personnelbusiness.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.aboutreimbursementpayseq.datasource.DSAboutReimbursementPayseq;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSEmployeeRepayment;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.fields.DataSourceLinkField;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.viewer.DetailViewer;

public class EmployeeRepaymentViewer extends AbstractDetailViewer {

	private SearchForm __parentSearchForm;
	private final Logger __logger = Logger.getLogger("");
	private final DelicacyListGrid bdDetailGrid = new DelicacyListGrid();
	private TabSet mainTab;
	private Tab tab;

	public EmployeeRepaymentViewer() {
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
		mainTab = new TabSet();
		tab=new Tab();
		tab = new Tab(getName());
		tab.setPane(detailViewers.get(0));
		mainTab.addTab(tab);

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
		aFields[a] = new ListGridField("payAmount", "<span style='color:red;'>付款金额</span>");
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
		aFields[a] = new ListGridField("returnAmount", "<span style='color:red;'>还款金额</span>");
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
		return 0;
	}

	@Override
	public String getName() {
		return "基本情况";
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
		DBDataSource.callOperation("NQ_Spersonnelbusinesppor", "find", new DSCallback() {
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
		super.viewSelectedData(grid);
		setRecord(grid.getSelectedRecord());
		viewDetailData();
	}

	public void viewDetailData() {
		Record selected = getRecord();
		// 获取预算管理id
		List<ListGrid> grids = getDetailListGrids();
		List<String> names = getDetailNames();
		int horizontalPercent = getHorizontalPercent();
		int budgetManagementId = BaseHelpUtils.getIntValue(selected.getAttribute("budgetManagementId"));
		if (budgetManagementId > 0) {
			for (int i = 0; i < getDetailCount(); i++) {
				tab = new Tab(names.get(i));
				tab.setPane(grids.get(i));
				mainTab.addTab(tab);
			}
			List<Canvas> canvasPanels = getCanvasPanels();
			if(!BaseHelpUtils.isNullOrEmpty(canvasPanels) && canvasPanels.size() > 0){
				List<String> canvasPanelNames = getCanvasPanelNames();
				int canvasPanelsCount = canvasPanelNames.size();
				for(int i = 0;i<canvasPanels.size();i++){
					tab = new Tab(canvasPanelsCount<=i?"":canvasPanelNames.get(i));
					tab.setPane(canvasPanels.get(i));
					mainTab.addTab(tab);
				}
			}
			addMember(mainTab);
		} else {
			addMember(mainTab);
		}

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
								}
								else if(name.equals("returnAmount") && returnAmount.compareTo(BigDecimal.ZERO) <= 0) {
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
		return DSEmployeeRepayment.getInstance();
	}

	@Override
	public int getDetailCount() {
		return 1;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(bdDetailGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("预算付款序列");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm(SearchForm value) {
		this.__parentSearchForm = value;
	}

}
