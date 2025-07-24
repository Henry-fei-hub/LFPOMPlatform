define(['ojs/ojcore', 'knockout', 'jquery','ojs/ojmodel','dl/commclient'],
	function (oj, ko, $) {
		ProjectStageTemplateModel = oj.Model.extend({
			parse: dl.parseModel,
			idAttribute: 'projectStageTemplateId'
		});

		ProjectStageTemplateCollection = oj.Collection.extend({
			model: new ProjectStageTemplateModel(),
			parse: dl.parseCollection,
			fetchSize: 15,
			customPagingOptions: dl.parsePaging,
			queryAction: 'ST_ProjectStageTemplate',
			createAction: 'ST_ProjectStageTemplate',
			updateAction: 'ST_ProjectStageTemplate',
			removeAction: 'ST_ProjectStageTemplate'
		});

	}
);
