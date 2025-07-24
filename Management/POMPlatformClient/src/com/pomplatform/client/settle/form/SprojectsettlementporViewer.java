package com.pomplatform.client.settle.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.pomplatform.client.settle.datasource.DSProjectSettlementDetail;
import com.pomplatform.client.settle.datasource.DSSprojectsettlementpor;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class SprojectsettlementporViewer extends AbstractDetailViewer {
	private final static Logger __logger = Logger.getLogger("");
    private DelicacyListGrid projectSettlementDetailsGrid = new DelicacyListGrid(){
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
    private SearchForm __parentSearchForm;

    public SprojectsettlementporViewer() {
    }

    @Override
    public void initComponents() {
        super.initComponents();
        projectSettlementDetailsGrid.setAutoFitFieldWidths(false);
        projectSettlementDetailsGrid.setShowRowNumbers(true);
        projectSettlementDetailsGrid.setShowGridSummary(true);
        projectSettlementDetailsGrid.setDataSource(DSProjectSettlementDetail.getInstance());
        projectSettlementDetailsGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                GenericViewWindow detail = new GenericViewWindow();
                detail.setTitle("设计师结算明细");
                detail.setWidth100();
                detail.setHeight100();
                ProjectSettlementDetailViewer viewer = new ProjectSettlementDetailViewer();
                viewer.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_NORMAL);
                viewer.initComponents();
                viewer.viewSelectedData((ListGrid) event.getSource());
                detail.setContent(viewer);
                detail.centerInPage();
                detail.show();
            }
        });
    }

    @Override
    public int getHorizontalPercent() {
        return 46;
    }

    @Override
    public String getName() {
        return "项目结算";
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

    @SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	@Override
    public void viewSelectedData(ListGrid grid) {
        super.viewSelectedData(grid);
        Record selected = grid.getSelectedRecord();
        Object val;
        //获取这一次结算的总的确认积分和分摊的成本
        BigDecimal totalAmount = BaseHelpUtils.getBigDecimalValue(selected.getAttribute("totalAmount"));
        BigDecimal totalCost = BaseHelpUtils.getBigDecimalValue(selected.getAttribute("totalCost"));
        java.util.Map condition = null;
        java.util.Map parentSearch = __parentSearchForm == null ? new java.util.HashMap() : __parentSearchForm.getValues();
        condition = new java.util.HashMap();
        condition.put("settlementId", selected.getAttributeAsString("settlementId"));
        DBDataSource.callOperation("ST_ProjectSettlementDetail", "find", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                	Record[] records = dsResponse.getData();
                	if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
                		for(Record e : records){
                			//获取分配积分
                			BigDecimal realAmount = BaseHelpUtils.getBigDecimalValue(e.getAttribute("realAmount"));
                			//计算分配积分占比=分配积分/这一次总分配积分
                			BigDecimal realAmountPercent = totalAmount.compareTo(BigDecimal.ZERO) != 0?realAmount.multiply(BigDecimal.valueOf(100)).divide(totalAmount,2,BigDecimal.ROUND_DOWN):BigDecimal.ZERO;
                			//获取分摊成本
                			BigDecimal projectCost = BaseHelpUtils.getBigDecimalValue(e.getAttribute("projectCost"));
                			//计算分摊成本占比=分摊成本/这一次总分摊的成本
                			BigDecimal projectCostPercent = totalCost.compareTo(BigDecimal.ZERO) != 0?projectCost.multiply(BigDecimal.valueOf(100)).divide(totalCost,2,BigDecimal.ROUND_DOWN):BigDecimal.ZERO;
                			e.setAttribute("realAmountPercent", realAmountPercent);
                			e.setAttribute("projectCostPercent", projectCostPercent);
                		}
                	}
                    projectSettlementDetailsGrid.setData(records);
                }
            }
        });
    }

    @Override
    public DataSource getMainDataSource() {
        return DSSprojectsettlementpor.getInstance();
    }

    @Override
    public int getDetailCount() {
        return 1;
    }

    @Override
    public List<ListGrid> getDetailListGrids() {
        List<ListGrid> res = new ArrayList<>();
        res.add(projectSettlementDetailsGrid);
        return res;
    }

    @Override
    public List<String> getDetailNames() {
        List<String> res = new ArrayList<>();
        res.add("项目成员");
        return res;
    }

    public SearchForm getParentSearchForm() {
        return this.__parentSearchForm;
    }

    public void setParentSearchForm(SearchForm value) {
        this.__parentSearchForm = value;
    }

}
