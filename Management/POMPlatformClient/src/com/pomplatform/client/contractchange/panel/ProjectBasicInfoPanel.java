package com.pomplatform.client.contractchange.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.LoadingWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.contractchange.datasource.DSProjectBasicInfo;
import com.pomplatform.client.contractchange.form.ProjectBasicInfoViewer;
import com.pomplatform.client.workflow.panel.MyPersonnelFlowDesignPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ProjectBasicInfoPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	protected ListGrid resultGrid;
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ProjectBasicInfoPanel cm = new ProjectBasicInfoPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ProjectBasicInfo";
		}

	}


	@Override
    public Canvas getViewPanel() {
        init();
        VLayout layout = new VLayout();
        layout.setWidth100();
        layout.setHeight100();
        layout.setBackgroundColor("#e2e2e2");

        VLayout resultLayout = new VLayout();
        resultLayout.setWidth100();
        resultLayout.setHeight100();
        HLayout main = new HLayout();
        main.setWidth100();
        main.setHeight100();
        resultLayout.addMember(main);
        Canvas mainCanvas = null;
        if (__layoutMode == LayoutConstant.LEFTRIGHT) {
            mainCanvas = generateHDataCanvas();
        } else {
            mainCanvas = generateVDataCanvas();
        }
        resultGrid.setCanDragSelectText(true);
        main.addMember(mainCanvas);
        layout.addMember(resultLayout);
        initComponents();
        return layout;
    }

    public Canvas generateHDataCanvas() {
        resultGrid = new ListGrid(){
        	@Override  
            protected Canvas createRecordComponent(final ListGridRecord record, Integer colNum) {  
  
                String fieldName = this.getFieldName(colNum);  
                if (fieldName.equals("icon")) {  
                    HLayout recordCanvas = new HLayout();  
                    recordCanvas.setHeight(22);  
                    recordCanvas.setWidth100();  
                    recordCanvas.setAlign(Alignment.CENTER);  
                    ImgButton refreshImg = new ImgButton();  
                    refreshImg.setShowDown(false);  
                    refreshImg.setShowRollOver(false);  
                    refreshImg.setLayoutAlign(Alignment.CENTER);  
                    refreshImg.setSrc("[SKIN]/actions/redo.png");  
                    refreshImg.setPrompt("重置订单变更信息");  
                    refreshImg.setHeight(16);  
                    refreshImg.setWidth(16);  
                    refreshImg.addClickHandler(new ClickHandler() {  
                        public void onClick(ClickEvent event) {  
                        	__LOGGER.info(event.getFiringCanvas()+"");
                            __LOGGER.info(event.getSource().toString());
                        }  
                    });  
                    recordCanvas.addMember(refreshImg);  
                    return recordCanvas;  
                } else {  
                    return null;  
                }  
  
            }  
        };
        resultGrid.setAutoFitFieldWidths(false);
        resultGrid.setVirtualScrolling(false);          
        resultGrid.setShowRecordComponents(true);          
        resultGrid.setShowRecordComponentsByCell(true);  
        resultGrid.setDataSource(getDataSource());
        resultGrid.setWidth100();
        resultGrid.setHeight100();
        resultGrid.setBorder("0px");
        return resultGrid;
    }
    
	@Override
	public void initComponents() {
		resultGrid.setShowRowNumbers(true);
	}
	
	public void commonQuery() {
        Map condition = generateCriteria();
        if (condition == null) {
            return;
        }
        DBDataSource ds = (DBDataSource) getDataSource();
        String operationName = ds.getActionMode() + ds.getActionName();
        final LoadingWindow loading = new LoadingWindow();
        DBDataSource.callOperation(operationName, "find", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
            	loading.destroy();
                if (dsResponse.getStatus() >= 0) {
                    resultGrid.setData(dsResponse.getData());
                    resultGrid.selectRecord(0);
                    afterDataReceived(dsResponse.getData());
                } else {
                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
                }
            }
        });
    }

	@Override
	public void afterDataReceived(Record[] data) {
		String showFields = null;
		if(isEdit){
			showFields = "contractCodeField,projectNameField,sheetAmountField,totalIntegralField,commonAreaField,logisticsAreaField,cadAreaField,statusField,iconField";
		}else{
			showFields = "contractCodeField,projectNameField,sheetAmountField,totalIntegralField,commonAreaField,logisticsAreaField,cadAreaField,statusField";
		}
		ClientUtil.setShowOrHiddenFields(resultGrid, showFields);
	}
	
	public void showDetail() {
		GWT.runAsync(new RunAsyncCallback() {
			@Override
			public void onFailure(Throwable reason) {
				SC.say("failure to download code");
			}
			@Override
			public void onSuccess() {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("项目积分信息"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				ProjectBasicInfoViewer detailForm = new ProjectBasicInfoViewer();
				detailForm.setParentSearchForm(searchForm);
				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
				detailForm.initComponents();
				detailForm.viewSelectedData(resultGrid);
				detail.setContent(detailForm);
				detail.centerInPage();
				detail.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("contractId", contractId);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
//		return new ProjectBasicInfoSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSProjectBasicInfo.getInstance();
	}

	private String contractId;
	private boolean isEdit;
	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public boolean isEdit() {
		return isEdit;
	}

	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}
	
}

