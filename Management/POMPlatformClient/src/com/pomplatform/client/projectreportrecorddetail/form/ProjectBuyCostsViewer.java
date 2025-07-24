package com.pomplatform.client.projectreportrecorddetail.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.data.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.pomplatform.client.designer.panel.DesignerProjectPanel;
import com.pomplatform.client.projectreportrecorddetail.datasource.DSProjectBuyCosts;
import com.pomplatform.client.projectview.datasource.DSProjectCost;
import com.pomplatform.client.projectview.datasource.DSProjectEmployee;

public class ProjectBuyCostsViewer extends AbstractDetailViewer
{


	private SearchForm __parentSearchForm;
	private static final Logger logger = Logger.getLogger("");
	private final DelicacyListGrid projectEmployeesGrid = new DelicacyListGrid();
	private final DelicacyListGrid projectCostGrid = new DelicacyListGrid();

	public ProjectBuyCostsViewer() {
	}

	@Override
	public void initComponents() {
		super.initComponents();
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
		projectEmployeesGrid.addDoubleClickHandler(new DoubleClickHandler() {
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
		});
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
				}else{
					SC.say("该条记录没有报销流程可以查看");
				}
			}
		});
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
		List<GroupColumn> gcs = new ArrayList<GroupColumn>();
		return gcs;
	}

	@Override
	public void load() {
		if(getBusinessId() == null) return;
		Map params = new HashMap();
		params.put("projectId", getBusinessId());
		DBDataSource.callOperation("NQ_ProjectBuyCosts", "find", new DSCallback() {
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
		Record selected = grid.getSelectedRecord();
		//获取项目积分
        BigDecimal projectIntegral = BaseHelpUtils.getBigDecimalValue(selected.getAttribute("projectIntegral"));
		Map<String,Object> condition = null;
		condition = new HashMap<>();
		//获取项目id
		int projectId = selected.getAttributeAsInt("projectId");
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
		condition = new HashMap<>();
		condition.put("projectId", projectId);
		DBDataSource.callOperation("NQ_SearchProjectCostSum", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					projectCostGrid.setData(dsResponse.getData());
				}
			}
		});
	}

	public void viewDetailData(){
	}

	@Override
	public DataSource getMainDataSource() {
		return DSProjectBuyCosts.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 2;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(projectEmployeesGrid);
		res.add(projectCostGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("项目成员");
		res.add("项目经费");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}
	
}

