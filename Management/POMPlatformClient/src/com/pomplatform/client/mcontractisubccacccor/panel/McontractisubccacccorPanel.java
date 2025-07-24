package com.pomplatform.client.mcontractisubccacccor.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.pomplatform.client.mcontractisubccacccor.datasource.DSMcontractisubccacccor;
import com.pomplatform.client.mcontractisubccacccor.form.McontractisubccacccorSearchForm;
import com.pomplatform.client.mcontractisubccacccor.form.McontractisubccacccorViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.widgets.form.SearchForm;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class McontractisubccacccorPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			McontractisubccacccorPanel cm = new McontractisubccacccorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Mcontractisubccacccor";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needPagenation = false;
        __needControl = false;
        __needViewPage = false;
	}

	@Override
	public void initComponents() {

		resultGrid.setSelectionType(SelectionStyle.SINGLE);
		resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
	}
	
	@Override
	public void commonQuery() {
		if(null != searchForm && !isUpdate()){
			searchForm.hide();
		}
        Map condition = generateCriteria();
        if (condition == null) {
            return;
        }
        if (searchForm != null) {
            searchButton.setIcon("loading38.gif");
        }
        DBDataSource ds = (DBDataSource) getDataSource();
        String operationName = ds.getActionMode() + ds.getActionName();
        final LoadingWindow loading = new LoadingWindow();
        DBDataSource.callOperation(operationName, "find", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
            	loading.destroy();
                if (searchForm != null) {
                    searchButton.setIcon("[SKIN]/actions/search.png");
                }
                if (dsResponse.getStatus() >= 0) {
                    resultGrid.setData(dsResponse.getData());
                    afterDataReceived(dsResponse.getData());
                    if (isNeedPagenation() && pager != null) {
                        if (currentPage == 1) {
                            totalPages = dsResponse.getAttributeAsInt("totalPages");
                            pager.getTotalPages().setContents(String.valueOf(totalPages));
                        }
                    }
                    //设置选中数据
                    if(null != getContractId()){
                    	AdvancedCriteria adCriteria = new AdvancedCriteria();
                    	adCriteria.addCriteria("contractId", getContractId());
                    	int rowNum = resultGrid.findIndex(adCriteria);
                    	resultGrid.selectSingleRecord(rowNum);
                    }
                } else {
                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
                }
                if (showPagination() && pager != null) {
                    pager.getCurrentPage().setContents(String.valueOf(currentPage));
                }
            }
        });
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
				detail.setTitle("Mcontractisubccacccor"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				McontractisubccacccorViewer detailForm = new McontractisubccacccorViewer();
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
		criteria.put("addtionalCondition", "order by contract_id");
//		criteria.put("departmentId", ClientUtil.getDepartmentId());
		if(!isUpdate() && null != getContractId()){
			criteria.put("contractId", getContractId());
		}
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		if(isUpdate()){
			return new McontractisubccacccorSearchForm();
		}else{
			return null;
		}
	}

	@Override
	public DataSource getDataSource() {
		return DSMcontractisubccacccor.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 50;
	}
	
	public DelicacyListGrid getGird(){
		return resultGrid;
	}
	
	private Integer contractId;

	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}
	
	private boolean isUpdate = true;

	public boolean isUpdate() {
		return isUpdate;
	}

	public void setUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
	
}

