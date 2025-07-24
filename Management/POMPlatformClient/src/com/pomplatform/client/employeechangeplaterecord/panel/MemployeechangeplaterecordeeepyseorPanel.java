package com.pomplatform.client.employeechangeplaterecord.panel;

import java.util.Map;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.employeechangeplaterecord.datasource.DSMemployeechangeplaterecordeeepyseor;
import com.pomplatform.client.employeechangeplaterecord.form.MemployeechangeplaterecordeeepyseorSearchForm;
import com.pomplatform.client.employeechangeplaterecord.form.MemployeechangeplaterecordeeepyseorViewer;
import com.pomplatform.client.employeechangeplaterecord.form.UpdateEmployeeChangePlateForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class MemployeechangeplaterecordeeepyseorPanel extends AbstractSearchPanel {

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            MemployeechangeplaterecordeeepyseorPanel cm = new MemployeechangeplaterecordeeepyseorPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "Memployeechangeplaterecordeeepyseor";
        }

    }

    @Override
    public void initComponents() {
        resultGrid.setShowRowNumbers(true);
        resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                showDetail();
            }
        });
        IButton downLoadButton = PermissionControl.createPermissionButton("导出", ERPPermissionStatic.EMPLOYEE_PLATE_RECORD_DOWNLOAD_BUTTON);
        controlLayout.addMember(downLoadButton);
        downLoadButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Map condition = generateCriteria();
                ClientUtil.departmentParameterProcess(condition);
                DBDataSource.downloadFile("DW_Memployeechangeplaterecordeeepyseor", condition);
            }
        });
        
        IButton updateButton = new IButton("更新");
		controlLayout.addMember(updateButton);
		updateButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}

					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("请选择一条数据修改");
							return;
						}
						final ListGridRecord selected1 = resultGrid.getSelectedRecord();
						UpdateEmployeeChangePlateForm detailForm = new UpdateEmployeeChangePlateForm();
						detailForm.setTitle("修改");
						detailForm.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.setRecord(selected1);
						detailForm.setCurrentPage(getCurrentPage());
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setWidth("50%");
						detailForm.setHeight("50%");
						detailForm.centerInPage();
						detailForm.show();
						setCurrentPage(detailForm.getCurrentPage());
					}
				});
			}
		});
		
		IButton deleteButton = new IButton("删除");
		controlLayout.addMember(deleteButton);
		deleteButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				SC.ask("提示", "确认要删除吗?", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						// TODO Auto-generated method stub
							if (value) {
								Map<String,Object> map = resultGrid.getSelectedRecord().toMap();
								DBDataSource.callOperation("ST_EmployeeChangePlateRecord", "delete", map, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										commonQuery();
										SC.say("删除成功!");
									}
								});
							}
						}
					});
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
                detail.setTitle("职员每月所属业务部门记录");
                detail.setWidth100();
                detail.setHeight100();
                MemployeechangeplaterecordeeepyseorViewer detailForm = new MemployeechangeplaterecordeeepyseorViewer();
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
        criteria.put("addtionalCondition", "order by employee_change_plate_record_id");
        return true;
    }

    @Override
    public SearchForm generateSearchForm() {
        return new MemployeechangeplaterecordeeepyseorSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSMemployeechangeplaterecordeeepyseor.getInstance();
    }

}
