package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.attachment.datasource.DSOnAttachmentLinkContractReceivables;
import com.pomplatform.client.attachment.datasource.DSOnAttachmentLinkInvoiceApplys;
import com.pomplatform.client.attachment.datasource.DSOnAttachmentLinkInvoices;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSAttachementApply;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.SplitPane;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.viewer.DetailViewerField;

public class AttachmentApplyViewer extends AbstractDetailViewer {
	
	private final DelicacyListGrid alrGrid = new DelicacyListGrid();
	private final DelicacyListGrid aliaGrid = new DelicacyListGrid();
	private final DelicacyListGrid aliGrid = new DelicacyListGrid();
	
	private SectionStack detailStack;
	

	public AttachmentApplyViewer() {
	}

	@Override
	public void initComponents() {
		setWidth100();
		setHeight100();
		setLayoutMargin(5);
		setMembersMargin(5);
		setBackgroundColor("azure");
		setBorder("1px solid gray");
		setCanSelectText(true);
		int horizontalPercent = getHorizontalPercent();
		// 如果没有定义字段分组，或者就一个组
		List<ListGrid> grids = getDetailListGrids();
		List<String> names = getDetailNames();
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
		} 
		switch (getLayoutMode()) {
		case COMPONENT_LAYOUT_NORMAL:
			HLayout mainLayout = new HLayout();
			VLayout left = new VLayout();
			left.setCanSelectText(true);
			left.setHeight100();
			left.setPadding(5);
			left.setMembersMargin(10);
			int ii = 0;
			for (DetailViewer detailViewer : detailViewers) {
				if (getGroupCount() > 0 && getIsGroup()) {
					detailViewer.setIsGroup(true);
					detailViewer.setCanSelectText(true);
					detailViewer.setGroupTitle(gcs.get(ii++).getGroupCaption());
				}
				left.addMember(detailViewer);
			}
			if (getDetailCount() > 0) {
				// left.setShowResizeBar(true);
				if (horizontalPercent == 0) {
					left.setWidth("25%");
				} else {
					left.setWidth(String.valueOf((horizontalPercent / 10) * 10) + "%");
				}
			} else {
				// left.setShowResizeBar(false);
				left.setWidth100();
			}
			left.setOverflow(Overflow.AUTO);
			mainLayout.addMember(left);
			if (getDetailCount() > 0) {
				if (getDetailCount() == 1) {
					ListGrid grid = grids.get(0);
					grid.setCanDragSelectText(true);
					grid.setHeight100();
					if (horizontalPercent == 0) {
						grid.setWidth("75%");
					} else {
						grid.setWidth(String.valueOf(((100 - horizontalPercent) / 10) * 10) + "%");
					}
					mainLayout.addMember(grid);
				} else {
				    detailStack = new SectionStack();
					detailStack.setCanSelectText(true);
					detailStack.setHeight100();
					if (horizontalPercent == 0) {
						detailStack.setWidth("75%");
					} else {
						detailStack.setWidth(String.valueOf(((100 - horizontalPercent) / 10) * 10) + "%");
					}
					detailStack.setVisibilityMode(VisibilityMode.MULTIPLE);
					for (int i = 0; i < getDetailCount(); i++) {
						SectionStackSection detailSection = new SectionStackSection(names.get(i));
						detailSection.addItem(grids.get(i));
						detailSection.setExpanded(true);
						detailStack.addSection(detailSection);
					}
					mainLayout.addMember(detailStack);
				}
			}
			if (getDetailCount() > 0)
				addMember(mainLayout);
			else
				addMember(left);
			break;
		}
		alrGrid.setDataSource(DSOnAttachmentLinkContractReceivables.getInstance());
		aliaGrid.setDataSource(DSOnAttachmentLinkInvoiceApplys.getInstance());
		aliGrid.setDataSource(DSOnAttachmentLinkInvoices.getInstance());
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "确认函申请";
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

	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	public void viewDetailData() {
		Record selected = getRecord();
		if(!selected.getAttributeAsBoolean("isRemoteCity")){
			detailStack.hide();
		}
		Object val;
		java.util.Map condition = null;
		condition = new HashMap();
		condition.put("contractId", selected.getAttribute("projectId"));
		condition.put("personnelBusinessId", selected.getAttribute("personnelBusinessId"));
		DBDataSource.callOperation("NQ_OnAttachmentLinkContractReceivables", "find", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					alrGrid.setData(dsResponse.getData());
				}
			}
		});
		DBDataSource.callOperation("NQ_OnAttachmentLinkInvoiceApplys", "find", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					aliaGrid.setData(dsResponse.getData());
				}
			}
		});
		DBDataSource.callOperation("NQ_OnAttachmentLinkInvoices", condition, new DSCallback() {

			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					aliGrid.setData(dsResponse.getData());
				}
			}
		});
	}

	@Override
	public DataSource getMainDataSource() {
		return DSAttachementApply.getInstance();
	}

	@Override
	public int getDetailCount() {
		return 3;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(alrGrid);
		res.add(aliaGrid);
		res.add(aliGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("确认函与合同阶段");
		res.add("确认函与联系人");
		res.add("确认函与发票");
		return res;
	}

}
