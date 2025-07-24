package com.pomplatform.client.client.workflow.specialdeduction.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.data.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.GenericViewWindow;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.client.workflow.specialdeduction.datasource.DSSpecialDeductionInformation;
import com.pomplatform.client.client.workflow.specialdeduction.datasource.DSSpecialDeductionRecordWithS;
import com.pomplatform.client.specialdeduction.datasource.DSSspecialdeductiondetailor;
import com.pomplatform.client.specialdeduction.datasource.SpecialDeductionInformation1;

public class SpecialDeductionInformationViewer extends AbstractDetailViewer
{


	private final DelicacyListGrid specialDeductionDetailsGrid = new DelicacyListGrid();
	private SearchForm __parentSearchForm;
	private DelicacyListGrid grid = new DelicacyListGrid(true);
	private HLayout allLayout;
	private VLayout leftLayout;
	private VLayout rightLayout;
	private VLayout contactLayout;
	private VLayout gridLayout;
	private DelicacyListGrid specialDeductionInformation1 =new DelicacyListGrid();
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	public SpecialDeductionInformationViewer() {
	}

	@Override
	public void initComponents() {
		super.initComponents();
		
		specialDeductionInformation1.setHeaderHeight(60); 
		specialDeductionInformation1.setDataSource(DSSspecialdeductiondetailor.getInstance());
		specialDeductionInformation1.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("专项信息", new String[] {"specialDeductionDetailId","parentId","specialDeductionTypeId","num","singleChild","educationType","educationStage",
				   "city","houseFirst","deductionPercentage","amount","startDate"
				   ,"endDate"})
	    });
		ListGridField[] fields = new ListGridField[18];
		int idx = 0;
		fields[idx] = new ListGridField("specialDeductionDetailId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("parentId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("specialDeductionTypeId",shouldNotBeNull+"专项类型");
		fields[idx].setShowGridSummary(false);
		fields[idx].setValueMap(KeyValueManager.getValueMap("system_dictionary_223"));
		fields[idx].setCanEdit(false);
		idx++;
		fields[idx] = new ListGridField("startDate",shouldNotBeNull+"起始时间");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("endDate",shouldNotBeNull+"结束时间");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("num","子女人数/老人人数");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("singleChild","是否独生子女");
		fields[idx].setValueMap(KeyValueManager.getValueMap("system_dictionary_200"));
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("educationType","继续教育类型");
		fields[idx].setShowGridSummary(false);
		fields[idx].setValueMap(KeyValueManager.getValueMap("system_dictionary_221"));
		idx++;
		fields[idx] = new ListGridField("educationStage","教育阶段");
		fields[idx].setShowGridSummary(false);
		fields[idx].setValueMap(KeyValueManager.getValueMap("system_dictionary_218"));
		idx++;
		fields[idx] = new ListGridField("city","租房城市");
		idx++;
		fields[idx] = new ListGridField("houseFirst","是否首套房");
		fields[idx].setValueMap(KeyValueManager.getValueMap("system_dictionary_200"));
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("deductionPercentage",shouldNotBeNull+"本人扣除比例（%）");
//		fields[idx].setValueMap(KeyValueManager.getValueMap("system_dictionary_224"));
		fields[idx].setFormat("##,###,##0.00");
		fields[idx].setDefaultValue(100);
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("amount","扣除金额");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);
		specialDeductionInformation1.setFields(fields);
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "SpecialDeductionInformation";
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
		params.put("specialDeductionRecordId", getBusinessId());
		DBDataSource.callOperation("NQ_SpecialDeductionInformation", "find", new DSCallback() {
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
		java.util.Map condition = new java.util.HashMap();
		Integer attributeAsInt = selected.getAttributeAsInt("specialDeductionRecordId");
		condition.put("parentId", attributeAsInt);
		DBDataSource.callOperation("ST_SpecialDeductionDetail", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					specialDeductionInformation1.setData(dsResponse.getData());
				}
			}
		});
	}

	@Override
	public DataSource getMainDataSource() {
		return DSSpecialDeductionInformation.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 1;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(specialDeductionInformation1);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("detailSspecialdeductiondetail");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}


}

