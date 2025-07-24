package com.pomplatform.client.reimbursementpackage.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.sprocessbilllistpppor.datasource.DSSprocessbilllistpppor;
import com.pomplatform.client.workflow.panel.AddUpdateProcessBillListPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ProcessBillListDetailPanel extends AbstractWizadPage implements HasHandlers{

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid(false);

	public ProcessBillListDetailPanel() {
		__dataGrid = grid;

		HLayout normalReimbursementLinkDepartments = new HLayout();
		normalReimbursementLinkDepartments.setWidth100();
		normalReimbursementLinkDepartments.setHeight100();

		ListGridField[] fields = new ListGridField[12];
		int idx = 0;
		fields[idx] = new ListGridField("payFor");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("payeeName");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("selfBankName");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("selfBankAccount");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("otherName");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("otherBankName");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("otherBankAccount");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("payMoney");
		idx++;
		fields[idx] = new ListGridField("balanceAmount");
		idx++;
		fields[idx] = new ListGridField("remark");
		fields[idx].setShowGridSummary(false);
//		grid.setHeaderHeight(60);
//		grid.setHeaderSpans(new HeaderSpan[] {
//				new HeaderSpan("收款信息", new String[] { "payFor", "payeeName", "selfBankName", "selfBankAccount",
//						"payMoney", "balanceAmount", "otherName", "otherBankName", "otherBankAccount", "remark" }) });
		grid.setFields(fields);
		grid.setShowGridSummary(true);
		grid.setCanEdit(false);
		grid.setDataSource(DSSprocessbilllistpppor.getInstance());
		grid.setAutoFitFieldWidths(false);
		normalReimbursementLinkDepartments.addMember(grid);

		VLayout normalReimbursementLinkDepartmentsControls = new VLayout();
		normalReimbursementLinkDepartmentsControls.setHeight100();
		normalReimbursementLinkDepartmentsControls.setWidth(60);
		normalReimbursementLinkDepartmentsControls.setLayoutTopMargin(30);
		normalReimbursementLinkDepartmentsControls.setLayoutLeftMargin(5);
		normalReimbursementLinkDepartmentsControls.setLayoutRightMargin(5);
		normalReimbursementLinkDepartmentsControls.setMembersMargin(10);
		
		if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.RP_UPDATE_BILL_LIST)){
			normalReimbursementLinkDepartments.addMember(normalReimbursementLinkDepartmentsControls);
		}
		
		addMember(normalReimbursementLinkDepartments);

		IButton normalReimbursementLinkDepartmentsNewButton = new IButton("新增");
		normalReimbursementLinkDepartmentsNewButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow window = new PopupWindow();
				window.setHeight("80%");
				window.setWidth("30%");
				window.centerInPage();
				window.setTitle("新增收款信息");
				AddUpdateProcessBillListPanel panel = new AddUpdateProcessBillListPanel(false, true,null);
				panel.startEdit(null, null, false);
				panel.setParentWindow(window);
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						Record record = event.getData();
						RecordList list = grid.getDataAsRecordList();
						list.add(record);
						grid.setData(list);
						grid.redraw();
					}
				});
				window.addItem(panel);
				window.show();
			}
		});
		IButton normalReimbursementLinkDepartmentsUpdateButton = new IButton("修改");
		normalReimbursementLinkDepartmentsUpdateButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord selected = grid.getSelectedRecord();
				final int rowNo = grid.getRowNum(grid.getSelectedRecord());
				PopupWindow window = new PopupWindow();
				window.setHeight("80%");
				window.setWidth("30%");
				window.centerInPage();
				window.setTitle("修改收款信息");
				AddUpdateProcessBillListPanel panel = new AddUpdateProcessBillListPanel(true, true,null);
				panel.startEdit(selected, null, true);
				panel.setParentWindow(window);
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						Record record = event.getData();
						RecordList list = grid.getDataAsRecordList();
						RecordList newList = new RecordList();
						int size = list.getLength();
						for (int i = 0; i < size; i++) {
							if (i == rowNo) {
								newList.add(record);
							} else {
								newList.add(list.get(i));
							}
						}
						grid.setData(newList);
						grid.redraw();
					}
				});
				window.addItem(panel);
				window.show();
			}
		});
		IButton normalReimbursementLinkDepartmentsRemoveButton = new IButton("删除所有");
		normalReimbursementLinkDepartmentsRemoveButton.setIcon("[SKIN]/actions/remove.png");
		normalReimbursementLinkDepartmentsRemoveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				grid.setData(new RecordList());
			}
		});
		normalReimbursementLinkDepartmentsControls.addMember(normalReimbursementLinkDepartmentsNewButton);
		normalReimbursementLinkDepartmentsControls.addMember(normalReimbursementLinkDepartmentsUpdateButton);
		normalReimbursementLinkDepartmentsControls.addMember(normalReimbursementLinkDepartmentsRemoveButton);
	}

	@Override
	public void startEdit() {
		reloadDetailTableData();
	}

	public void reloadDetailTableData() {
		Record record = getRecord();
		Map condition = record.toMap();
		condition.put("opt_type", "getBillListByReimbursement");
		DBDataSource.callOperation("EP_ReimbursementPackageProcessor", "getBillListByReimbursement", condition,
				new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							if (__startLoadedDetail != null)
								__startLoadedDetail.execute(dsResponse, data, dsRequest);
							grid.setData(dsResponse.getData());
							if (__endLoadedDetail != null)
								__endLoadedDetail.execute(dsResponse, data, dsRequest);
						}
					}
				});
	}

	@Override
	public boolean checkData() {
		for (ListGridRecord r : grid.getRecords()) {
			__logger.info(MapUtils.convertRecordToMap(grid.getDataSource(), r).toString());
		}
		return true;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("detailProcessBillListApply");
		return res;
	}

	@Override
	public boolean isTheValuesEmpty() {
		ListGridRecord[] rows = grid.getRecords();
		return rows == null || rows.length == 0;
	}

	@Override
	public Map getValuesAsMap() {
		Map param = new HashMap();
		ListGridRecord[] rows = grid.getRecords();
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailProcessBillListApply");
		return param;
	}

	@Override
	public String getName() {
		return "";
	}

	public DSCallback getStartLoadedDetail() {
		return this.__startLoadedDetail;
	}

	public void setStartLoadedDetail(DSCallback value) {
		this.__startLoadedDetail = value;
	}

	public DSCallback getEndLoadedDetail() {
		return this.__endLoadedDetail;
	}

	public void setEndLoadedDetail(DSCallback value) {
		this.__endLoadedDetail = value;
	}

	public DelicacyListGrid getGrid() {
		return this.grid;
	}

	public void setGrid(DelicacyListGrid value) {
		this.grid = value;
	}

	public void reDrawGrid() {
		if (null != grid)
			this.grid.redraw();
	}
	
	protected final HandlerManager handlerManager = new HandlerManager(this);
    protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();

    @Override
    public void fireEvent(GwtEvent<?> event) {
        handlerManager.fireEvent(event);
    }

    public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
        return handlerManager.addHandler(DataEditEvent.TYPE, handler);
    }
}
