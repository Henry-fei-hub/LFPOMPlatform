define(['ojs/ojcore', 'knockout', 'jquery','ojs/ojmodel','dl/commclient'],
	function (oj, ko, $) {
		DeveloperListModel = oj.Model.extend({
			parse: dl.parseModel,
			idAttribute: 'employeeName'
		});

		DeveloperListCollection = oj.Collection.extend({
			model: new DeveloperListModel(),
			parse: dl.parseCollection,
			fetchSize: 15,
			customPagingOptions: dl.parsePaging,
			queryAction: 'NQ_OnSalaryTotalData',
			createAction: 'ST_DeveloperWithC',
			updateAction: 'ST_DeveloperWithC',
			removeAction: 'ST_DeveloperWithC'
		});

	}
);


