
define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'ojs/ojbutton', 'ojs/ojlegend', 'ojs/ojchart', 'ojs/ojtoolbar'],
        function (oj, ko, $, dl) {

            function chartViewModel(params) {
                console.log(this);
                var self = this;
                self.viewModelName = 'chartViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.item = ko.observable("");
                self.isNode = ko.observable('0');


                // Attribute Groups Handler for Consistent Coloring
                var attrGroups = new oj.ColorAttributeGroupHandler();

                // Categories
                var categories = ["a", "b", "c", "d", "e"];
                var timegories = ["a1", "b1", "c1", "d1", "e1"];
                // Chart Data
                var categoricalSeries = [{items: []}];
                var categoricalSeriesItems = categoricalSeries[0].items;
                categoricalSeriesItems.push({value: 100, color: attrGroups.getValue(categories[0]), categories: [categories[0]]});
                categoricalSeriesItems.push({value: 200, color: attrGroups.getValue(categories[1]), categories: [categories[1]]});
                categoricalSeriesItems.push({value: 300, color: attrGroups.getValue(categories[2]), categories: [categories[2]]});
                categoricalSeriesItems.push({value: 400, color: attrGroups.getValue(categories[3]), categories: [categories[3]]});
                categoricalSeriesItems.push({value: 500, color: attrGroups.getValue(categories[4]), categories: [categories[4]]});

                var timeSeries = [
                    {name: timegories[0], items: [114, 62, 70, 176, 66]},
                    {name: timegories[1], items: [150, 38, 146, 54, 42]},
                    {name: timegories[2], items: [134, 22, 130, 32, 26]},
                    {name: timegories[3], items: [18, 16, 14,122, 10]},
                    {name: timegories[4], items: [131, 2, 13, 3, 2]}
                ];

                var timeGroups = ['1980s', '1990s', '2000s', '2010s', '2020s'];
                
                var pieSeries = [{name: categories[0], items: [42]},
                    {name: categories[1], items: [55]},
                    {name: categories[2], items: [36]},
                    {name: categories[3], items: [10]},
                    {name: categories[4], items: [5]}];

                var bubbleSeries = [{name: categories[0], items: [{x: 15, y: 25, z: 5}, {x: 25, y: 30, z: 12}]},
                    {name: categories[1], items: [{x: 15, y: 15, z: 8}, {x: 20, y: 35, z: 14}]},
                    {name: categories[2], items: [{x: 10, y: 10, z: 8}, {x: 18, y: 55, z: 10}]},
                    {name: categories[3], items: [{x: 8, y: 20, z: 6}, {x: 11, y: 30, z: 8}]},
                    {name: categories[4], items: [{x: 25, y: 45, z: 12}, {x: 40, y: 55, z: 35}]}];


                self.categoricalSeriesValue = ko.observableArray(categoricalSeries);
                self.categoricalGroupsValue = ko.observableArray(categories);
                self.timeSeriesValue = ko.observableArray(timeSeries);
                self.timeGroupsValue = ko.observableArray(timeGroups);
                self.pieSeriesValue = ko.observableArray(pieSeries);
                self.bubbleSeriesValue = ko.observableArray(bubbleSeries);

                // Legend Data
                var legendSections = [{items: []}];
                var legendItems = legendSections[0].items;
                for (var categoryIndex = 0; categoryIndex < categories.length; categoryIndex++) {
                    var category = categories[categoryIndex];
                    legendItems.push({text: category, color: attrGroups.getValue(category), shortDesc: "Filter: " + category});
                }

                self.legendSections = ko.observableArray(legendSections);
                
                    // Legend1 Data
                var legend2Sections = [{items: []}];
                var legend2Items = legend2Sections[0].items;
                for (var categoryIndex = 0; categoryIndex < categories.length; categoryIndex++) {
                    var timegory = timegories[categoryIndex];
                    legend2Items.push({text: timegory, color: attrGroups.getValue(timegory), shortDesc: "Filter: " + timegory});
                }

                self.legend2Sections = ko.observableArray(legend2Sections);
                
                
                self.handleActivated = function (info) {
                    // Implement if needed
                };


                self.handleAttached = function (info) {
                };



                self.handleBindingsApplied = function (info) {

                    // Implement if needed
                };


                self.handleDetached = function (info) {
                    // Implement if needed
                };
            }

            return new chartViewModel();
        }
);


