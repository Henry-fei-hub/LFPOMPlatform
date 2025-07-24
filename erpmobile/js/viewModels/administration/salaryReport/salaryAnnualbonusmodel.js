define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojmodel'],
	function (oj, ko, $, dl) {
		SalaryAnnualBonusListModel = oj.Model.extend({
			parse: dl.parseModel,
			idAttribute: 'employeeId'
		});

		SalaryAnnualBonusListCollection = oj.Collection.extend({
			model: new SalaryAnnualBonusListModel(),
			parse: dl.parseCollection,
			fetchSize: 15,
			customPagingOptions: dl.parsePaging,
			queryAction: 'NQ_SalaryAnnualbonus',
			createAction: 'ST_DeveloperWithC',
			updateAction: 'ST_DeveloperWithC',
			removeAction: 'ST_DeveloperWithC'
		});

	}
);


