package com.pomplatform.client.platereportrecorddetail.panel;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;

public class TestPanel extends HLayout  implements HasHandlers {
	private static final Logger logger = Logger.getLogger("");
	private final CheckboxItem isProjectItem;
	private final ComboBoxItem projectItem;
	private final LinkedHashMap<Integer, String> projectMap;
	private final IButton searchButton;
	final DynamicForm form = new DynamicForm();
	

	public TestPanel() {
		isProjectItem = new CheckboxItem("isProject", "是否項目報銷？");
		isProjectItem.addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				if (isProjectItem.getValueAsBoolean()) {
					form.getItem("projectId").show();
				} else {
					form.getItem("projectId").hide();
				}

			}
		});
		projectItem = new ComboBoxItem("projectId", "項目名稱");
		projectItem.setChangeOnKeypress(false);
		projectItem.setHidden(true);
		projectMap = new LinkedHashMap<>();
		projectMap.put(1, "測試數據1");
		projectMap.put(2, "測試數據2");
		projectItem.setValueMap(projectMap);
		searchButton = new IButton("搜索", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Map<String, Object> map = new HashMap<>();
				String value = projectItem.getValueAsString();
				logger.info("搜索框的值为："+value);
				if (null != value && value.length() > 0) {
					map.put("projectName", value);
					DBDataSource.callOperation("EP_GetProjectByProjectName", map, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() >= 0) {
								Record[] record = dsResponse.getData();
								projectMap.clear();
								for(Record obj : record){
									projectMap.put(obj.getAttributeAsInt("projectId"), obj.getAttribute("projectName"));
								}
								projectItem.setValueMap(projectMap);
								for(Integer i : projectMap.keySet()){
									logger.info(projectMap.get(i));
								}
								logger.info("大功告成！！！");
							} else {
								SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
							}
						}
					});
				}
			}
		});
		
		form.setNumCols(2);
		form.setAlign(Alignment.CENTER);
		form.setWidth("90%");
		form.setHeight100();
		form.setItems(isProjectItem,projectItem);
		addMember(form);
		addMember(searchButton);
	}

}
