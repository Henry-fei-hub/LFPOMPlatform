package com.pomplatform.client.workflow.companyCommonNormalReimbursement.form;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.workflow.commonNormalReimbursement.datasource.DSNormalReimbursementLinkDepartment;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class CompanyNormalReimbursementLinkDepartmentPanel extends AbstractWizadPage {

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid(true);
	private AbstractWizadPage mainInfoPage;

	public CompanyNormalReimbursementLinkDepartmentPanel() {

		__dataGrid = grid;

		HLayout normalReimbursementLinkDepartments = new HLayout();
		normalReimbursementLinkDepartments.setWidth100();
		normalReimbursementLinkDepartments.setHeight100();

		ListGridField[] fields = new ListGridField[2];
		int idx = 0;
		fields[idx] = new ListGridField("departmentId");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("amount");
		grid.setHeaderHeight(60);
		grid.setHeaderSpans(new HeaderSpan[] { new HeaderSpan("费用分拆<font style=\"color:red; font-weight:bold\">【如有增值税专用发票，进项税必填，其他发票无需填写】</font>", new String[] { "departmentId", "amount" }) });
		grid.setFields(fields);
		grid.setShowGridSummary(true);
		grid.setCanEdit(false);
		grid.setDataSource(DSNormalReimbursementLinkDepartment.getInstance());
		grid.setAutoFitFieldWidths(false);
		normalReimbursementLinkDepartments.addMember(grid);

		VLayout normalReimbursementLinkDepartmentsControls = new VLayout();
		normalReimbursementLinkDepartmentsControls.setHeight100();
		normalReimbursementLinkDepartmentsControls.setWidth(60);
		normalReimbursementLinkDepartmentsControls.setLayoutTopMargin(30);
		normalReimbursementLinkDepartmentsControls.setLayoutLeftMargin(5);
		normalReimbursementLinkDepartmentsControls.setLayoutRightMargin(5);
		normalReimbursementLinkDepartmentsControls.setMembersMargin(10);
		normalReimbursementLinkDepartments.addMember(normalReimbursementLinkDepartmentsControls);
		addMember(normalReimbursementLinkDepartments);
		IButton normalReimbursementLinkDepartmentsNewButton = new IButton("新增部门");
		normalReimbursementLinkDepartmentsNewButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (null != mainInfoPage) {
					FormItem amountItem = mainInfoPage.findNamedItem("amount");
					FormItem departmentItem = mainInfoPage.findNamedItem("departmentId");
					if (null != amountItem && null != departmentItem && null != amountItem.getValue()
							&& null != departmentItem.getValue()) {
						// 获取当前可以被分拆的金额总额
						BigDecimal amount = new BigDecimal(amountItem.getValue().toString());
						ListGridRecord[] records = grid.getRecords();
						if (null != records) {
							for (ListGridRecord record : records) {
								if (null != record.getAttribute("amount")) {
									amount = amount.subtract(new BigDecimal(record.getAttribute("amount")));
								}
							}
						}
						if (amount.compareTo(BigDecimal.ZERO) <= 0) {
							SC.warn("提示", "报销金额必须大于0才能添加部门");
							return;
						}
						final int departmentId = ClientUtil.checkAndGetIntValue(departmentItem.getValue());
						PopupWindow window = new PopupWindow();
						window.setWidth("30%");
						window.setHeight("35%");
						window.centerInPage();
						window.setTitle("新增报销部门");
						CompanyNormalReimbursementLinkDepartmentPopupPanel panel = new CompanyNormalReimbursementLinkDepartmentPopupPanel(
								false);
						panel.startEdit(null, amount, false);
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
					} else {
						SC.warn("提示", "没有填写报销人或者报销金额");
					}
				}
			}
		});
		IButton normalReimbursementLinkDepartmentsUpdateButton = new IButton("修改部门");
		normalReimbursementLinkDepartmentsUpdateButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (null != mainInfoPage && null != grid.getSelectedRecord()) {
					FormItem amountItem = mainInfoPage.findNamedItem("amount");
					FormItem departmentItem = mainInfoPage.findNamedItem("departmentId");
					if (null != amountItem && null != departmentItem && null != amountItem.getValue()
							&& null != departmentItem.getValue()) {
						// 获取当前可以被分拆的金额总额
						BigDecimal amount = new BigDecimal(amountItem.getValue().toString());
						ListGridRecord[] records = grid.getRecords();
						if (null != records) {
							for (ListGridRecord record : records) {
								if (null != record.getAttribute("amount")) {
									amount = amount.subtract(new BigDecimal(record.getAttribute("amount")));
								}
							}
						}
						ListGridRecord selected = grid.getSelectedRecord();
						final int departmentId = ClientUtil.checkAndGetIntValue(departmentItem.getValue());
						final int rowNo = grid.getRowNum(grid.getSelectedRecord());
						PopupWindow window = new PopupWindow();
						window.setWidth("30%");
						window.setHeight("35%");
						window.centerInPage();
						window.setTitle("修改报销部门");
						CompanyNormalReimbursementLinkDepartmentPopupPanel panel = new CompanyNormalReimbursementLinkDepartmentPopupPanel(
								true);
						selected.setAttribute("leftAmount", amount);
						panel.startEdit(selected, amount, true);
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
					} else {
						SC.warn("提示", "没有填写报销人或者报销金额");
					}
				}
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
		if (getPageMode() != PAGE_MODE_UPDATE)
			return;
		reloadDetailTableData();
	}

	public void reloadDetailTableData() {
		Map condition = new HashMap();
		condition.put("projectNormalReimbursementId", getRecord().getAttribute("projectNormalReimbursementId"));
		DBDataSource.callOperation("ST_NormalReimbursementLinkDepartment", "find", condition, new DSCallback() {
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
		BigDecimal amount = BigDecimal.ZERO;
		BigDecimal inputTax = BigDecimal.ZERO;
		for (ListGridRecord r : grid.getRecords()) {
			__logger.info(MapUtils.convertRecordToMap(grid.getDataSource(), r).toString());
			amount = amount.add(BaseHelpUtils.getBigDecimalValue(r.getAttributeAsObject("amount")));
			inputTax = inputTax.add(BaseHelpUtils.getBigDecimalValue(r.getAttributeAsObject("inputTax")));
		}
		if(inputTax.compareTo(BigDecimal.ZERO) > 0 && amount.compareTo(BigDecimal.ZERO) > 0) {
			// 进项税不能超过报销总额的16%
			if(inputTax.compareTo(amount.multiply(new BigDecimal(0.16))) > 0) {
				SC.say("进项税不能超过报销总额的16%");
				return false;
			}
		}
		return true;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("detailNormalReimbursementLinkDepartment");
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
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailNormalReimbursementLinkDepartment");
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

	public AbstractWizadPage getMainInfoPage() {
		return mainInfoPage;
	}

	public void setMainInfoPage(AbstractWizadPage mainInfoPage) {
		this.mainInfoPage = mainInfoPage;
	}

	public void reDrawGrid() {
		if (null != grid)
			this.grid.redraw();
	}

}
