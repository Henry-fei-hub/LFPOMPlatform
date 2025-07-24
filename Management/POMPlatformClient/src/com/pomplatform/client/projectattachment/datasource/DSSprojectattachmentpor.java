package com.pomplatform.client.projectattachment.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSprojectattachmentpor extends DBDataSource {

    public static DSSprojectattachmentpor instance = null;

    public static DSSprojectattachmentpor getInstance() {
        if (instance == null) {
            instance = new DSSprojectattachmentpor("DSSprojectattachmentpor");
        }
        return instance;
    }

    private final DataSourceIntegerField projectAttachmentIdField;
    private final DataSourceIntegerField projectIdField;
    private final DataSourceIntegerField stageIdField;
    private final DataSourceDateTimeField uploadTimeField;
    private final DataSourceLinkField attachmentFileField;
    private final DataSourceTextField remarkField;

    public DSSprojectattachmentpor(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("Sprojectattachmentpor");

        projectAttachmentIdField = new DataSourceIntegerField("projectAttachmentId", "主键编码");
        projectAttachmentIdField.setLength(11);
        projectAttachmentIdField.setPrimaryKey(true);
        projectAttachmentIdField.setRequired(true);
        projectAttachmentIdField.setHidden(true);

        projectIdField = new DataSourceIntegerField("projectId", "项目名称");
        projectIdField.setLength(11);
        projectIdField.setRequired(false);
        projectIdField.setHidden(false);
//        KeyValueManager.loadValueMap("projects",projectIdField);
        KeyValueManager.loadValueMap("projects", projectIdField);

        stageIdField = new DataSourceIntegerField("stageId", "项目阶段");
        stageIdField.setLength(11);
        stageIdField.setPrimaryKey(true);
        stageIdField.setRequired(true);
        stageIdField.setHidden(false);
        stageIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));

        uploadTimeField = new DataSourceDateTimeField("uploadTime", "上传时间");
        uploadTimeField.setRequired(false);
        uploadTimeField.setHidden(false);

        attachmentFileField = new DataSourceLinkField("attachmentFile", "附件");
        attachmentFileField.setLength(128);
        attachmentFileField.setRequired(false);
        attachmentFileField.setHidden(false);

        remarkField = new DataSourceTextField("remark", "备注");
        remarkField.setLength(512);
        remarkField.setRequired(false);
        remarkField.setHidden(false);

        setFields(projectAttachmentIdField, projectIdField, stageIdField, uploadTimeField, attachmentFileField, remarkField);
    }

}
