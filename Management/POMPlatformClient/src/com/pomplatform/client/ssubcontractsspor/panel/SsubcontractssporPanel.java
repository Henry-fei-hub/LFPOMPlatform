package com.pomplatform.client.ssubcontractsspor.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ssubcontractsspor.datasource.DSSsubcontractsspor;
import com.pomplatform.client.ssubcontractsspor.form.SsubcontractssporSearchForm;
import com.pomplatform.client.ssubcontractsspor.form.SsubcontractssporViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class SsubcontractssporPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			SsubcontractssporPanel cm = new SsubcontractssporPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Ssubcontractsspor";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needPagenation = false;
        __needViewPage = false;
	}

	@Override
	public void initComponents() {
		resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		IButton addButton = new IButton("添加");
        controlLayout.addMember(addButton);
        addButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	ListGridRecord [] selectRecords =  resultGrid.getSelectedRecords();
            	ListGridRecord [] existRecords = subcontractGrid.getRecords();
            	for (ListGridRecord __selectRecord : selectRecords) {
            		boolean flag = true;
            		int subContractId = __selectRecord.getAttributeAsInt("subContractId");
            		for (ListGridRecord __existRecord : existRecords) {
            			int __subContractId = __existRecord.getAttributeAsInt("subContractId");
            			if(subContractId == __subContractId){
            				flag = false;
            				break;
            			}
    				}
            		if(flag){
            			subcontractGrid.addData(__selectRecord);
            		}
				}
            }
        });
		commonQuery();
	}

	public void showDetail() {
		GWT.runAsync(new RunAsyncCallback() {
			@Override
			public void onFailure(Throwable reason) {
				SC.say("failure to download code");
			}

			@Override
			public void onSuccess() {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("Ssubcontractsspor");
				detail.setWidth100();
				detail.setHeight100();
				SsubcontractssporViewer detailForm = new SsubcontractssporViewer();
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
		criteria.put("addtionalCondition", "order by sub_contract_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new SsubcontractssporSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSSsubcontractsspor.getInstance();
	}
	
    
    @Override
    public int getSearchFormHeight() {
        return 60;
    }
    
	public DelicacyListGrid subcontractGrid;
}
