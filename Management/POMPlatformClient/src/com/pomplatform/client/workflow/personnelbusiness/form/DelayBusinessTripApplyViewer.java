package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSBusinessTripApply;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSDelayBusinessTripApply;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.SplitPane;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.viewer.DetailViewerField;

public class DelayBusinessTripApplyViewer extends AbstractDetailViewer {
	
	protected DetailViewer rightDetailView = new DetailViewer();
	
	private Integer processType;

	public DelayBusinessTripApplyViewer() {
	}

	@Override
	public void initComponents() {
		Label leftLabel = new Label((this.processType == 19 ? "延期" : "更改行程") + "申请信息");
		leftLabel.setHeight("25");
		leftLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER );
		Label rightLabel = new Label("原始申请信息");
		rightLabel.setHeight("25");
		rightLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER );
		setWidth100();
		setHeight100();
//		setLayoutMargin(5);
		setMembersMargin(5);
		setBackgroundColor("azure");
		setBorder("1px solid gray");
		setCanSelectText(true);
		// 如果没有定义字段分组，或者就一个组
		List<GroupColumn> gcs = getGroupColumnNames();
		if (getGroupCount() <= 1) {
			// 那么就是用一个DetailViewer就够了
			DetailViewer mainView = new DetailViewer();
			mainView.setCanSelectText(true);
			mainView.setHeight100();
			mainView.setWidth100();
			mainView.setWrapValues(true);

			mainView.setKeepInParentRect(true);
			// mainView.setWrapLabel(true);
			// 如果有一个分组，就需要给这个DetailViewer增加显示的字段
			if (getGroupCount() == 1) {
				GroupColumn gc = gcs.get(0);
				DetailViewerField[] dvfs = new DetailViewerField[gc.getColumnNames().size()];
				for (int i = 0; i < gc.getColumnNames().size(); i++) {
					dvfs[i] = new DetailViewerField(gc.getColumnNames().get(i));

				}
				mainView.setFields(dvfs);
			}
			mainView.setDataSource(getMainDataSource());
			detailViewers.add(mainView);
		} else {
			for (int i = 0; i < getGroupCount(); i++) {
				DetailViewer viewers = new DetailViewer();
				viewers.setCanSelectText(true);
				// viewers.setWrapLabel(true);
				viewers.setWrapValues(true);
				GroupColumn gc = gcs.get(i);
				DetailViewerField[] dvfs = new DetailViewerField[gc.getColumnNames().size()];
				for (int k = 0; k < gc.getColumnNames().size(); k++) {
					dvfs[k] = new DetailViewerField(gc.getColumnNames().get(k));
				}
				viewers.setDataSource(getMainDataSource());
				viewers.setFields(dvfs);
				detailViewers.add(viewers);
			}
		}
		SplitPane mainPane = new SplitPane();
		mainPane.setCanSelectText(true);
		mainPane.setShowListToolStrip(false);
		VLayout left = new VLayout();
		left.setCanSelectText(true);
		left.setHeight100();
		left.setPadding(5);
		left.setMembersMargin(10);
		left.addMember(leftLabel);
		int ii = 0;
		for (DetailViewer detailViewer : detailViewers) {
			if (getGroupCount() > 0 && getIsGroup()) {
				detailViewer.setIsGroup(true);
				detailViewer.setCanSelectText(true);
				detailViewer.setGroupTitle(gcs.get(ii++).getGroupCaption());
			}
			left.addMember(detailViewer);
		}
		left.setWidth("50%");
		left.setOverflow(Overflow.AUTO);
		left.setBorder("1px solid gray");
		mainPane.setNavigationPane(left);
		VLayout right = new VLayout();
		right.setWidth("50%");
		right.setHeight100();
		right.setPadding(5);
		right.setMembersMargin(10);
		
		rightDetailView.setWidth100();
		rightDetailView.setHeight100();
		rightDetailView.setDataSource(DSBusinessTripApply.getInstance());
		rightDetailView.setWrapValues(true);
		rightDetailView.setKeepInParentRect(true);
		right.addMember(rightLabel);
		right.addMember(rightDetailView);
		addMember(right);
		addMember(left);
		
	}
	
	@Override
	public void viewRecord(Record r) {
		viewRecord(r, true);
		setParentData(r);
	}
	
	private void setParentData(Record r){
		Map<String, Object> params = new HashMap<>();
		params.put("personnelBusinessId", r.getAttributeAsInt("parentId"));
		params.put("opt_type", "getPersonnelBusinessById");
		DBDataSource.callOperation("EP_CustomPersonnelBusinessProcess", params, new DSCallback() {

			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() > 0) {
					rightDetailView.setData(dsResponse.getData());
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
		return "出差申请";
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
		if (getBusinessId() == null)
			return;
		Map params = new HashMap();
		params.put("personnelBusinessId", getBusinessId());
		DBDataSource.callOperation("NQ_BusinessTripApply", "find", new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					for (DetailViewer v : detailViewers) {
						rightDetailView.setData(dsResponse.getData());
						rightDetailView.redraw();
						v.setData(dsResponse.getData());
						if (dsResponse.getData().length == 0)
							continue;
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
	public void viewSelectedData(ListGrid grid) {
		super.viewSelectedData(grid);
		setRecord(grid.getSelectedRecord());
		viewDetailData();
	}

	public void viewDetailData() {
	}

	@Override
	public DataSource getMainDataSource() {
		DSDelayBusinessTripApply ds = DSDelayBusinessTripApply.getInstance();
		if(this.processType == 19){
			ds.getField("address").setHidden(true);
			ds.getField("plan").setHidden(true);
			ds.getField("transportation").setHidden(true);
		} else {
			ds.getField("address").setHidden(false);
			ds.getField("plan").setHidden(false);
			ds.getField("transportation").setHidden(false);
		}
		return ds;
	}

	@Override
	public int getDetailCount() {
		return 0;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		return res;
	}

	public Integer getProcessType() {
		return processType;
	}

	public void setProcessType(Integer processType) {
		this.processType = processType;
	}

}
