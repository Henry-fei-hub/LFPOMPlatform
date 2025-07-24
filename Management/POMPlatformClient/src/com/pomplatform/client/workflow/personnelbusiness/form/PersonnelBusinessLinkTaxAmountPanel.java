package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.MapUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSPersonnelBusinessLinkTaxAmount;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PersonnelBusinessLinkTaxAmountPanel extends AbstractWizadPage {

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid(true);
	private AbstractWizadPage mainInfoPage;
	
	private Integer contractId;
	
	public PersonnelBusinessLinkTaxAmountPanel() {
		initPanel();
	}
	
	public void initPanel(){
		__dataGrid = grid;

		HLayout mainLayout = new HLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();

		ListGridField[] fields = new ListGridField[2];
		int idx = 0;
		fields[idx] = new ListGridField("companyId");
		idx++;
		fields[idx] = new ListGridField("taxAmount");
		
		grid.setCanRemoveRecords(true);
		grid.setCanEdit(true);
		grid.setHeaderHeight(60);
		grid.setHeaderSpans(new HeaderSpan[] { new HeaderSpan("报税详情", new String[] { "companyId", "taxAmount"}) });
		grid.setFields(fields);
		grid.setCanEdit(false);
		grid.setDataSource(DSPersonnelBusinessLinkTaxAmount.getInstance());
		grid.setAutoFitFieldWidths(false);
		mainLayout.addMember(grid);

		VLayout controlLayout = new VLayout();
		controlLayout.setHeight100();
		controlLayout.setWidth(60);
		controlLayout.setLayoutTopMargin(30);
		controlLayout.setLayoutLeftMargin(5);
		controlLayout.setLayoutRightMargin(5);
		controlLayout.setMembersMargin(10);
		
		IButton addBtn = new IButton("新增");
		addBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				grid.startEditingNew();
				
			}
		});
		controlLayout.addMember(addBtn);
		mainLayout.addMember(controlLayout);
		addMember(mainLayout);
	
	}
	

	@Override
	public void startEdit() {
		if (getPageMode() != PAGE_MODE_UPDATE)
			return;
		reloadDetailTableData();
	}

	public void reloadDetailTableData() {
		Map condition = new HashMap();
		Object personnelBusinessId = -1;
		if(null != getRecord() && null != getRecord().getAttribute("personnelBusinessId")){
			personnelBusinessId = getRecord().getAttribute("personnelBusinessId");
		}
		condition.put("personnelBusinessId", personnelBusinessId);
		DBDataSource.callOperation("ST_PersonnelBusinessLinkTaxAmount", "find", condition, new DSCallback() {
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
//		if(isVisible()){
//			AdvancedCriteria ad = new AdvancedCriteria();
//			ad.addCriteria("flagType", 2);
//			if(grid.findAll(ad).length <= 0){
//				SC.say("请添加确认函与发票的绑定");
//				return false;
//			}
//		}
		return true;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("detailAttachmentLinkInvoices");
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
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailPersonnelBusinessLinkTaxAmount");
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

	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

}
