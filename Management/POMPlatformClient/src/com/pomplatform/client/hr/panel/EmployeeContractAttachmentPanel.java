package com.pomplatform.client.hr.panel;

import com.delicacy.client.data.*;
import com.delicacy.client.ui.*;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.specialdeduction.panel.SpecialDeductionCopyPanel;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.pomplatform.client.hr.datasource.DSEmployeeContractAttachment;
import com.pomplatform.client.hr.form.EmployeeContractAttachmentSearchForm;
import com.pomplatform.client.hr.form.EmployeeContractAttachmentViewer;
import com.pomplatform.client.hr.form.NewEmployeeContractAttachmentForm;
import com.pomplatform.client.hr.form.UpdateEmployeeContractAttachmentForm;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Logger;

public class EmployeeContractAttachmentPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			EmployeeContractAttachmentPanel cm = new EmployeeContractAttachmentPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "EmployeeContractAttachment";
		}

	}

	@Override
	public void init(){
		resultGrid = new DelicacyListGrid() {  
            @Override  
            protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {  
        		 if (record.getAttributeAsInt("willEnd") == 1) { //如果合同即将到期，设置颜色为红色
        			 return "color: red;";
                 }else if(record.getAttributeAsInt("willEnd") == 2){//如果合同已过期，设置颜色为灰色
                	 return "color: gray;";
                 }else {  
                     return super.getCellCSSText(record, rowNum, colNum);  
                 }  
            }  
        };
    	resultGrid.setDataSource(getDataSource());
    	resultGrid.setShowRowNumbers(true);
    	resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
        __layoutMode = LayoutConstant.LEFTRIGHT;
        __detailCanvas = new ArrayList<>();
        __controlPosition = LayoutConstant.RIGHT;
        __needPagenation = true;
        __needControl = true;
        __needViewPage = true;
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		IButton addButton = new IButton("新建");
		controlLayout.addMember(addButton);
		addButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}
					@Override
					public void onSuccess() {
						NewEmployeeContractAttachmentForm detailForm = new NewEmployeeContractAttachmentForm();
						detailForm.setTitle("新建");
						detailForm.addDataEditedHandler(new DataEditedHandler(){
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.initComponents();
						detailForm.setWidth("60%");
						detailForm.setHeight("70%");
						detailForm.startEdit();
						detailForm.centerInPage();
						detailForm.show();
					}
				});
			}
		});
		IButton editButton = new IButton("修改");
		controlLayout.addMember(editButton);
		editButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){ SC.say("请选择一条数据修改"); return;}
						final ListGridRecord selected1 = resultGrid.getSelectedRecord();
//						if(!BaseHelpUtils.isNullOrEmpty(selected1.getAttribute("signType")) && 
//								!BaseHelpUtils.isNullOrEmpty(selected1.getAttribute("contractType"))){
//							int signType = selected1.getAttributeAsInt("signType");
//							int contractType = selected1.getAttributeAsInt("contractType");
//							if(signType == 0 && contractType == 0){
//								SC.say("新签的劳动合同附件请在职员管理修改");
//								return;
//							}
//						}
						UpdateEmployeeContractAttachmentForm detailForm = new UpdateEmployeeContractAttachmentForm();
						detailForm.setTitle("修改");
						detailForm.addDataEditedHandler(new DataEditedHandler(){
							@Override
							public void onDataEdited(DataEditEvent event) {
								SC.say("提示","修改成功");
								commonQuery();
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.setRecord(selected1);
						detailForm.setCurrentPage(getCurrentPage());
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setWidth("60%");
						detailForm.setHeight("70%");
						detailForm.centerInPage();
						detailForm.show();
						setCurrentPage(detailForm.getCurrentPage());
					}
				});
			}
		});

		IButton renewButton = new IButton("劳动合同续签");
		controlLayout.addMember(renewButton);
		renewButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				if(!resultGrid.anySelected()){
					SC.say("请选择一条数据");
					return;
				}
				Record record = resultGrid.getSelectedRecord();
				NewProcessWindow window = new NewProcessWindow();
				window.setTitle("劳动合同续签流程");
				window.setData(record);
				window.setWidth("60%");
				window.setHeight("80%");
				Map<String, String> processIdMap = PomPlatformClientUtil
						.getUserProcessId(PomPlatformClientUtil.PARENT_PROCESS_TYPE_2);
				Integer value = ClientUtil.checkAndGetIntValue(processIdMap.get("Labor_contract_renewal"));
				window.setProcessId(value);
				window.setLayoutMode(0);
				window.initComponents();
				window.show();
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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("EmployeeContractAttachment"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				EmployeeContractAttachmentViewer detailForm = new EmployeeContractAttachmentViewer();
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
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new EmployeeContractAttachmentSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSEmployeeContractAttachment.getInstance();
	}

	@Override
	public void afterDataReceived(Record[] data) {
		if(!BaseHelpUtils.isNullOrEmpty(data)){
			String url = "";
			for(Record e : data){
				if(!BaseHelpUtils.isNullOrEmpty(e.getAttribute("attachmentUrl"))){
					url = BaseHelpUtils.getString(e.getAttribute("attachmentUrl"));
					e.setAttribute("attachmentUrl", linkHTML(url,"预览/下载附件"));
				}
			}
		}
	}
}

