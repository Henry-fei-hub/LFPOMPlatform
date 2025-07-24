package com.pomplatform.client.supplierworkflow.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.sreceiveunitmanagemmror.datasource.DSSreceiveunitmanagemmror;
import com.pomplatform.client.supplierworkflow.datasource.DSSupplierComeIn;
import com.pomplatform.client.supplierworkflow.datasource.DSSupplierCooperation;
import com.pomplatform.client.supplierworkflow.datasource.DSSupplierDetail;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.SplitPane;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.viewer.DetailViewer;

public class SupplierComeInViewer extends AbstractDetailViewer
{


	private DelicacyListGrid detailGrid;
	private DelicacyListGrid coopGrid;
	private DelicacyListGrid receiveGrid;
	private SearchForm __parentSearchForm;
	private SplitPane mainPane;


	public SupplierComeInViewer() {
	}

	@Override
	public void initComponents() {
		//super.initComponents();
		//supplierDetailGrid.setDataSource(DSSupplierDetail.getInstance());
		//supplierCooperationGrid.setDataSource(DSSupplierCooperation.getInstance());
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
		
		detailGrid = new DelicacyListGrid();
		ListGridField[] fields = new ListGridField[5];
		int idx = 0;
		fields[idx] = new ListGridField("supplierDetailId","供应商详情ID");
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new ListGridField("supplierId","供应商ID");
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new ListGridField("projectName","项目名称");
		fields[idx].setAlign(Alignment.CENTER);
		fields[idx].setWidth("35%");
		idx ++;
		fields[idx] = new ListGridField("projectAddress","项目地址");
		fields[idx].setAlign(Alignment.CENTER);
		fields[idx].setWidth("35%");
		idx ++;
		fields[idx] = new ListGridField("supplierDuty","主要负责内容");
		fields[idx].setAlign(Alignment.CENTER);
		fields[idx].setWidth("35%");
		detailGrid.setDataSource(DSSupplierDetail.getInstance());
		detailGrid.setFields(fields);
		detailGrid.setAutoFitFieldWidths(false);
		detailGrid.setCanEdit(false);
		detailGrid.setSelectionType(SelectionStyle.SINGLE);
		detailGrid.setHeight100();
		detailGrid.setWidth100();

		coopGrid= new DelicacyListGrid();
		ListGridField[] field = new ListGridField[5];
		int id = 0;
		field[id] = new ListGridField("supplierCooperationiId");
		field[id].setCanEdit(false);
		field[id].setHidden(true);
		id ++;
		field[id] = new ListGridField("supplierId");
		field[id].setCanEdit(false);
		field[id].setHidden(true);
		id ++;
		field[id] = new ListGridField("projectName","合作的项目名称");
		field[id].setWidth("25%");
		field[id].setAutoFitWidth(false);
		field[id].setAlign(Alignment.CENTER);
		id ++;
		field[id] = new ListGridField("projectLeader","J&A负责人");
		ComboBoxItem employeeItem = new ComboBoxItem();
		employeeItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		field[id].setEditorProperties(employeeItem);
		KeyValueManager.loadValueMap("employees", field[id]);
		field[id].setWidth("20%");
		field[id].setAlign(Alignment.CENTER);
		id ++;
		field[id] = new ListGridField("supplierEvaluate","供应商评价");
		field[id].setAlign(Alignment.CENTER);
		field[id].setWidth("35%");
		coopGrid.setDataSource(DSSupplierCooperation.getInstance());
		coopGrid.setFields(field);
		coopGrid.setAutoFitFieldWidths(false);
		coopGrid.setCanEdit(false);
		coopGrid.setSelectionType(SelectionStyle.SINGLE);
		coopGrid.setHeight100();
		coopGrid.setWidth100();

		receiveGrid= new DelicacyListGrid();
		ListGridField[] fieldss = new ListGridField[5];
		int ids = 0;
		fieldss[ids] = new ListGridField("receiveUnitManageId");
		fieldss[ids].setHidden(true);
		ids ++;
		fieldss[ids] = new ListGridField("receiveUnit","收款单位");
		fieldss[ids].setWidth("25%");
		ids ++;
		fieldss[ids] = new ListGridField("bankAccount","银行账号");
		fieldss[ids].setWidth("25%");
		ids ++;
		fieldss[ids] = new ListGridField("bankName","开户行");
		fieldss[ids].setWidth("25%");
		ids ++;
		fieldss[ids] = new ListGridField("receiveUnitAddress","收款单位所在地");
		fieldss[ids].setWidth("25%");
		ids ++;
		fieldss[ids] = new ListGridField("operateEmployeeId","操作人");
		fieldss[ids].setWidth("25%");
		KeyValueManager.loadValueMap("employees", fieldss[ids]);
		ids ++;
		fieldss[ids] = new ListGridField("operateTime","操作时间");
		fieldss[ids].setWidth("25%");
		receiveGrid.setDataSource(DSSreceiveunitmanagemmror.getInstance());
		receiveGrid.setFields(fieldss);
		receiveGrid.setAutoFitFieldWidths(false);
		receiveGrid.setCanEdit(false);
		receiveGrid.setSelectionType(SelectionStyle.SINGLE);
		receiveGrid.setHeight100();
		receiveGrid.setWidth100();
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "供应商详情";
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
		params.put("supplierId", getBusinessId());
		DBDataSource.callOperation("NQ_SupplierComeIn", "find", new DSCallback() {
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
		Object val;
		java.util.Map condition = null;
		java.util.Map parentSearch = __parentSearchForm == null ? new java.util.HashMap() : __parentSearchForm.getValues();
		condition = new java.util.HashMap();
		condition.put("supplierId", selected.getAttributeAsString("supplierId"));
		List<ListGrid> grids = getDetailListGrids();
		List<String> names = getDetailNames();
		int horizontalPercent = getHorizontalPercent();
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



		DBDataSource.callOperation("ST_SupplierDetail", "find",condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					detailGrid.setData(dsResponse.getData());
				}
			}
		});
		DBDataSource.callOperation("ST_SupplierCooperation","find",condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					coopGrid.setData(dsResponse.getData());
				} else {
					SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
				}
			}
		});

		condition.put("addtionalCondition", "ORDER BY receive_unit_manage_id desc");
		DBDataSource.callOperation("ST_ReceiveUnitManage","find",condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record record=dsResponse.getData()[0];
					RecordList recordlist=new RecordList();
					recordlist.add(record);
					receiveGrid.setData(recordlist);
				} else {
					SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
				}
			}
		});
	}

	@Override
	public DataSource getMainDataSource() {
		return DSSupplierComeIn.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 3;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(detailGrid);
		res.add(coopGrid);
		res.add(receiveGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("供应商详情");
		res.add("与JA合作过的项目");
		res.add("相关的供应商收款单位");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}


}

