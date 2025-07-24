define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojpagingtabledatasource', 'ojs/ojrouter', 'ojs/ojdialog', 'ojs/ojbutton', 'ojs/ojknockout', 'ojs/ojmodel',
    'ojs/ojdatagrid', 'ojs/ojpagingcontrol', 'ojs/ojcollectiondatagriddatasource', 'ojs/ojpagingdatagriddatasource',
    'ojs/ojconveyorbelt', 'dl/workflow', 'ojs/ojdiagram', 'ojs/ojjsondiagramdatasource'],
        function (oj, ko, $, dl) {
            function testFlowViewModel(params) {
                var self = this;
                self.viewModelName = 'testflow';
                self.parentViewModel = params;
                if (dl.isNullOrUndefined(self.parentViewModel.details))
                    self.parentViewModel.details = [];
                var thisViewModel = {name: 'testflow', data: self, detailType: dl._DETAILTYPE_TABLE};
                dl.addViewModelToParentDetails(self.parentViewModel.details, thisViewModel);

                self.currentData = null;
                self.dialogId = '#projecttestDialog';
                self.previousId = '#btn-previous';
                self.nextId = '#btn-next';
                self.currentDetailPageNo = 0;
                self.currentEditMode = 0;

                self.saveCallback = function (resp) {
                    $(self.dialogId).ojDialog("close");
//                    var arr = dl.parseCollection(resp);
//                    var res = dl.parseModel(arr[0]);
//                    self.currentData.data.attributes = res;
//                    if (self.currentEditMode === 1)
//                        self.collection.add(res, {at: 0});
//                    $(self.dialogId).ojDialog("close");
//                    var currentPage = self.projecttestDatasource.getPage();
//                    $(self.pagingId).ojPagingControl('page', currentPage);
//                    $(self.dataGridId).ojDataGrid("option", "selection", [self.currentData]);
                };

                self.getCurrentEditPages = function () {
                    return dl.getAllDetailPages(self.details, self.getCurrentDetailPageType());
                };

                self.getCellTemplate = function (cellContext) {
                    var mode = cellContext['mode'];
                    if (mode === 'edit')
                        return 'projecttestEditTemplate';
                    else if (mode === 'navigation')
                        return 'projecttestDisplayTemplate';
                };

                self.getCellClassName = function (cellContext) {
                    var key = cellContext['keys']['column'];
                    return 'oj-helper-justify-content-flex-start';
                };

                self.buttonProcess = function () {
                    var editPages = self.getCurrentEditPages();
                    if (self.currentDetailPageNo > 0)
                        $(self.previousId).ojButton("option", "disabled", false);
                    else
                        $(self.previousId).ojButton("option", "disabled", true);
                    if (self.currentDetailPageNo < editPages.length - 1)
                        $(self.nextId).ojButton("option", "disabled", false);
                    else
                        $(self.nextId).ojButton("option", "disabled", true);
                };

                self.nextClick = function (data, event) {
                    var editPages = self.getCurrentEditPages();
                    if (self.currentDetailPageNo < editPages.length - 1) {
                        var pageName = editPages[self.currentDetailPageNo].name;
                        dl.executeCopyNamedPageDataBack(self, pageName);
                        self.currentDetailPageNo++;
                        pageName = editPages[self.currentDetailPageNo].name;
                        self.currentEditPage({name: pageName, params: {data: self}, cacheKey: pageName});
                    }
                    self.buttonProcess();
                };

                self.previousClick = function (data, event) {
                    var editPages = self.getCurrentEditPages();
                    if (self.currentDetailPageNo > 0) {
                        var pageName = editPages[self.currentDetailPageNo].name;
                        dl.executeCopyNamedPageDataBack(self, pageName);
                        self.currentDetailPageNo--;
                        pageName = editPages[self.currentDetailPageNo].name;
                        self.currentEditPage({name: pageName, params: {data: self}, cacheKey: pageName});
                    }
                    self.buttonProcess();
                };

                self.cancelClick = function (data, event) {
                    $(self.dialogId).ojDialog("close");
                };

                self.okClick = function (data, event) {
                    dl.copyAllDetailDataFromControls(self, self.getCurrentDetailPageType());
                    if (self.currentEditMode === 0) {
                        dl.callOperation("EP_ModifyProcessorDefinition", 'update', self.currentData.data.attributes, self.saveCallback);
                    } else {
                        dl.callOperation("EP_NewProcessorDefinition", 'save', self.currentData.data.attributes, self.saveCallback);
                    }
//                    dl.callOperation(self.collection.updateAction, self.currentEditMode === 0 ? 'update' : 'save', self.currentData.data.attributes, self.saveCallback);
                };

                self.getCurrentDetailPageType = function () {
                    return self.currentEditMode === 0 ? dl._DETAILTYPE_UPDATE : dl._DETAILTYPE_ADD;
                };

                self.setCurrentDetailPage = function () {
                    var editPages = self.getCurrentEditPages();
                    var pageName = editPages[self.currentDetailPageNo].name;
                    self.currentEditPage({name: pageName, params: {data: self}, cacheKey: pageName});
                    self.buttonProcess();
                };

                self.addprojecttestClick = function (data, evt) {
                    self.currentDetailPageNo = 0;
                    self.currentEditMode = 1;
                    self.setCurrentDetailPage();
                    $(self.dialogId).ojDialog("open");
                };


                self.modifyprojecttestClick = function (data, evt) {
                    self.currentDetailPageNo = 0;
                    self.currentEditMode = 0;
                    self.setCurrentDetailPage();
                    dl.copyAllDetailDataToControls(self, self.getCurrentDetailPageType());
                    $(self.dialogId).ojDialog("open");
                };

                self.selectionChanged = function (event, ui) {
                    if (ui.option !== 'selection')
                        return;
                    if (dl.isNullOrUndefined(ui.value))
                        return;
                    if (ui.value.length === 0)
                        return;
                    var reservedFetchSize = self.collection.fetchSize;
                    self.collection.fetchSize = -1;
                    var key = ui.value[0].startKey.row;
                    var rowData = self.collection.get(key, {deferred: false});
                    self.collection.fetchSize = reservedFetchSize;
                    if (dl.isNullOrUndefined(self.currentData))
                        self.currentData = {};
                    self.currentData.startIndex = ui.value[0].startIndex;
                    self.currentData.endIndex = ui.value[0].endIndex;
                    self.currentData.startKey = ui.value[0].startKey;
                    self.currentData.endKey = ui.value[0].endKey;
                    self.currentData.data = rowData;
                };

                self.handleEditEnd = oj.DataCollectionEditUtils.basicHandleEditEnd;
                self.editMode = 'none';
                self.handleEdit = function (event, ui) {
                };

                self.details = [
                    {name: 'updateflow', detailType: dl._DETAILTYPE_UPDATE},
                    {name: 'flowdetail', detailType: dl._DETAILTYPE_UPDATE},
                    {name: 'newflow', detailType: dl._DETAILTYPE_ADD},
                    {name: 'flowdetail', detailType: dl._DETAILTYPE_ADD}
                ];

                var initeditPages = self.getCurrentEditPages();
                var initpageName = initeditPages[self.currentDetailPageNo].name;
                self.currentEditPage = ko.observable({name: initpageName, params: {data: self}, cacheKey: initpageName});

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
//                    dl.callJSONP('EP_GetProcessInstance', '', {processInstanceId: 4683}, self.getProcessInstanceCallback);
                };

                self.handleBindingsApplied = function (info) {
                    $(self.dataGridId).on({'ojoptionchange': self.selectionChanged});
                };

                self.handleDetached = function (info) {
                };

                self.getProcessInstanceCallback = function (resp) {
//                    var arr = dl.parseCollection(resp);
//                    var res = dl.parseModel(arr[0]);
//                    self.diagramData(new oj.JsonDiagramDataSource(dl.generateDiagramData(res)));
                };

                self.diagramData = ko.observable();

                self.diagramDefaults = {
                    linkDefaults: {
                        startConnectorType: 'none', endConnectorType: 'arrow', width: 5
                    },
                    nodeDefaults: {
                        icon: {
                            width: 64, height: 64,
                            source: '/css/images/start.png'

                        }
                    }
                };

                self.diagramResize = function (data, event) {
                    $('#diagram').ojDiagram('refresh');
                }

            }
            return testFlowViewModel;
        }
);
