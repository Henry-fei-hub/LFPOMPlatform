package com.pomplatform.client.project.panel;

import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.pomplatform.client.project.datasource.DSTrackTalentsMinimumArrangement;
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
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

public class TrackTalentsMinimumArrangementPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			TrackTalentsMinimumArrangementPanel cm = new TrackTalentsMinimumArrangementPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "TrackTalentsMinimumArrangement";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needPagenation = false;
	}

	@Override
	public void initComponents() {
		resultGrid.setCanEdit(true);
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		ListGridField[] fields = new ListGridField[11];
		int idx = 0;
		fields[idx] = new ListGridField("trackTalentsMinimumArrangementId");
		fields[idx].setCanEdit(false);
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new ListGridField("plateId");
		idx ++;
		fields[idx] = new ListGridField("projectType");
		idx ++;
		fields[idx] = new ListGridField("minAmount");
		idx ++;
		fields[idx] = new ListGridField("maxAmount");
		idx ++;
		fields[idx] = new ListGridField("highDesigner");
		idx ++;
		fields[idx] = new ListGridField("middleDesigner");
		idx ++;
		fields[idx] = new ListGridField("initialDesigner");
		idx ++;
		fields[idx] = new ListGridField("operateEmployeeId");
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new ListGridField("operateTime");
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new ListGridField("remark");
		idx ++;
		resultGrid.setFields(fields);
		resultGrid.setShowFilterEditor(true);
		resultGrid.setFilterOnKeypress(true);
		IButton newButton = new IButton("新建");
		controlLayout.addMember(newButton);
		newButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				resultGrid.startEditingNew();
			}
		});

		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				final int rowNumModified = event.getRowNum();
				int minAmount = BaseHelpUtils.getIntValue(resultGrid.getRecord((event.getRowNum())).getAttribute("minAmount"));
				int maxAmount = BaseHelpUtils.getIntValue(resultGrid.getRecord((event.getRowNum())).getAttribute("maxAmount"));
				if(maxAmount > minAmount){
					Map params = resultGrid.getRecord(event.getRowNum()).toMap();
					params.put("operateEmployeeId",ClientUtil.getEmployeeId());
					params.put("operateTime",new Date());
					DBDataSource.callOperation("ST_TrackTalentsMinimumArrangement", "saveOrUpdate", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() < 0) {
								ClientUtil.displayErrorMessage(dsResponse);
							}else {
								DBDataSource.copyRecord(dsResponse.getData()[0], resultGrid.getRecord(rowNumModified));
								resultGrid.redraw();
							}
						}
					});
				}
				else{
					SC.say("最小金额不能大于最大金额！");
				}
			}
		});

		IButton removeButton = new IButton("删除");
		controlLayout.addMember(removeButton);
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("Please select a data to remove.");
				}
				SC.ask("提示","您确认要删除吗?", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if(value){
							final ListGridRecord selected = resultGrid.getSelectedRecord();
							DBDataSource.callOperation("ST_TrackTalentsMinimumArrangement", "delete", selected.toMap(), new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() < 0) {
										ClientUtil.displayErrorMessage(dsResponse);
									} else {
										int indexNum = resultGrid.getRowNum(selected);
										resultGrid.removeData(selected);
										resultGrid.selectSingleRecord(indexNum);
									}
								}
							});
						}
					}
				});
			}
		});

		commonQuery();
	}


	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSTrackTalentsMinimumArrangement.getInstance();
	}


}

