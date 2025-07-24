package com.pomplatform.client.preprojects.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMainProjectCompetitionUnit extends DBDataSource
{


	public static DSMainProjectCompetitionUnit instance = null;

	public static DSMainProjectCompetitionUnit getInstance() {
		if(instance == null) {
			instance = new DSMainProjectCompetitionUnit("DSMainProjectCompetitionUnit");
		}
		return instance;
	}

	private final DataSourceIntegerField mainProjectCompetitionUnitIdField;
	private final DataSourceIntegerField mainProjectIdField;
	private final DataSourceIntegerField competitionUnitIdField;

	public DSMainProjectCompetitionUnit(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("MainProjectCompetitionUnit");


		mainProjectCompetitionUnitIdField = new DataSourceIntegerField("mainProjectCompetitionUnitId", "主键编码");
		mainProjectCompetitionUnitIdField.setLength(11);
		mainProjectCompetitionUnitIdField.setPrimaryKey(true);
		mainProjectCompetitionUnitIdField.setRequired(true);
		mainProjectCompetitionUnitIdField.setHidden(false);


		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "前期项目id");
		mainProjectIdField.setLength(11);
		mainProjectIdField.setRequired(false);
		mainProjectIdField.setHidden(false);


		competitionUnitIdField = new DataSourceIntegerField("competitionUnitId", "竞争单位");
		competitionUnitIdField.setLength(11);
		competitionUnitIdField.setRequired(false);
		competitionUnitIdField.setHidden(false);


		setFields(mainProjectCompetitionUnitIdField, mainProjectIdField, competitionUnitIdField);
	}


}

