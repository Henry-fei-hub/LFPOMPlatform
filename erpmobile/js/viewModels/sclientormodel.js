define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojmodel'],
        function (oj, ko, $, dl) {
            SclientorModel = oj.Model.extend({
                parse: dl.parseModel,
                idAttribute: 'employeeId'
            });

            SclientorCollection = oj.Collection.extend({
                model: new SclientorModel(),
                parse: dl.parseCollection,
                fetchSize: 8,
                customPagingOptions: dl.parsePaging,
                options: {error: dl.errorProcess},
                queryAction: 'ST_Employee',
                createAction: 'ST_Employee',
                updateAction: 'ST_Employee',
                removeAction: 'ST_Employee'
            });

        }
);
