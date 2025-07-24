define(['ojs/ojcore', 'knockout', 'jquery','ojs/ojmodel','dl/commclient'],
	function (oj, ko, $) {
		SsystemprocessporModel = oj.Model.extend({
			parse: dl.parseModel,
			idAttribute: 'processId'
		});

		SsystemprocessporCollection = oj.Collection.extend({
			model: new SsystemprocessporModel(),
			parse: dl.parseCollection,
			fetchSize: 15,
			customPagingOptions: dl.parsePaging,
			queryAction: 'NQ_Ssystemprocesspor',
			createAction: 'ST_SystemProcess',
			updateAction: 'ST_SystemProcess',
			removeAction: 'ST_SystemProcess'
		});

	}
);
