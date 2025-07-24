define(['ojs/ojcore', 'knockout', 'jquery', 'ojs/ojpagingtabledatasource', 'ojs/ojrouter', 'ojs/ojdialog', 'ojs/ojbutton', 'ojs/ojknockout', 'ojs/ojmodel',
    'promise', 'ojs/ojdatagrid', 'ojs/ojpagingcontrol', 'ojs/ojcollectiondatagriddatasource', 'ojs/ojpagingdatagriddatasource',
    'dl/commclient', 'viewModels/workflow/ssystemprocesspormodel', 'ojs/ojconveyorbelt'],
        function (oj, ko, $) {
            function SsystemprocessporViewModel(params) {
                var self = this;
                self.viewModelName = 'ssystemprocesspor';
                self.parentViewModel = params;
                if (dl.isNullOrUndefined(self.parentViewModel.details))
                    self.parentViewModel.details = [];
                var thisViewModel = {name: 'ssystemprocesspor', data: self, detailType: dl._DETAILTYPE_TABLE};
                dl.addViewModelToParentDetails(self.parentViewModel.details, thisViewModel);

                self.currentData = null;
                self.collection = new SsystemprocessporCollection();
                self.datasource = new oj.CollectionDataGridDataSource(self.collection,
                        {
//                            rowHeader: 'processId',
                            columns: ['processId', 'processTypeId', 'departmentId', 'includeDepartmentId', 'createEmployeeId', 'createTime', 'processName', 'countersign', 'holdDepartmentId', 'holdDutyId', 'description', 'enable']});
                self.ssystemprocessporDatasource = new oj.PagingDataGridDataSource(self.datasource);
                self.dataGridId = '#ssystemprocesspor-datagrid';
                self.pagingId = '#ssystemprocesspor-paging';
                self.dialogId = '#ssystemprocessporDialog';
                self.previousId = '#btn-previous';
                self.nextId = '#btn-next';
                self.currentDetailPageNo = 0;
                self.currentEditMode = 0;

                self.saveCallback = function (resp) {
                    var arr = dl.parseCollection(resp);
                    var res = dl.parseModel(arr[0]);
                    self.currentData.data.attributes = res;
                    if (self.currentEditMode === 1)
                        self.collection.add(res, {at: 0});
                    $(self.dialogId).ojDialog("close");
                    var currentPage = self.ssystemprocessporDatasource.getPage();
                    $(self.pagingId).ojPagingControl('page', currentPage);
                    $(self.dataGridId).ojDataGrid("option", "selection", [self.currentData]);
                };

                self.getCurrentEditPages = function () {
                    return dl.getAllDetailPages(self.details, self.getCurrentDetailPageType());
                };

                self.getCellTemplate = function (cellContext) {
                    var mode = cellContext['mode'];
                    if (mode === 'edit')
                        return 'ssystemprocessporEditTemplate';
                    else if (mode === 'navigation')
                        return 'ssystemprocessporDisplayTemplate';
                };

                self.getCellClassName = function (cellContext) {
                    var key = cellContext['keys']['column'];
                    if (key == 'countersign')
                        return 'oj-datagrid-cell-no-padding';
                    if (key == 'enable')
                        return 'oj-datagrid-cell-no-padding';
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
//				dl.callOperation(self.collection.updateAction, self.currentEditMode === 0 ? 'update' : 'save', self.currentData.data.attributes, self.saveCallback);
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

                self.queryssystemprocessporClick = function (data, evt) {
                    self.collection.refresh();
                    $(self.pagingId).ojPagingControl('firstpage');
                };

                self.addssystemprocessporClick = function (data, evt) {
                    self.currentDetailPageNo = 0;
                    self.currentEditMode = 1;
                    self.setCurrentDetailPage();
                    $(self.dialogId).ojDialog("open");
                };

                self.deleteCallback = function (resp) {
                    var arr = dl.parseCollection(resp);
                    var res = dl.parseModel(arr[0]);
                    self.collection.remove(res);
                    self.collection.refresh();
                };

                self.deletessystemprocessporClick = function (data, evt) {
                    dl.callOperation(self.collection.removeAction, 'delete', self.currentData.data.attributes, self.deleteCallback);
                };

                self.modifyssystemprocessporClick = function (data, evt) {
                    var processData = {};
                    dl.callOperation("ST_SystemProcessWithSs", 'find', {"processId":data.currentData.data.attributes.processId}, function(resp){
                        var arr = dl.parseCollection(resp);
                        processData = arr[0];
                        dl.callOperation("ST_SystemProcessDepartment", 'find', {"processId":data.currentData.data.attributes.processId}, function(resp){
                            var arr = dl.parseCollection(resp);
                            processData.detailSystemProcessDepartment = arr;
                            self.currentData.data.attributes = processData;
                            self.currentDetailPageNo = 0;
                            self.currentEditMode = 0;
                            self.setCurrentDetailPage();
                            dl.copyAllDetailDataToControls(self, self.getCurrentDetailPageType());
                            $(self.dialogId).ojDialog("open");
                        });
                    });
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
//                    {name: 'updateflow', detailType: dl._DETAILTYPE_UPDATE},
                    {name: 'newflow', detailType: dl._DETAILTYPE_UPDATE},
                    {name: 'flowdetail', detailType: dl._DETAILTYPE_UPDATE},
                    {name: 'newflow', detailType: dl._DETAILTYPE_ADD},
                    {name: 'flowdetail', detailType: dl._DETAILTYPE_ADD}
                ];


                self.collection.generateCondition = function () {
                    if (dl.isNullOrUndefined(self.searchforms))
                        return {};
                    for (var i = 0; i < self.searchforms.length; i++)
                        self.searchforms[i].data.setDataFromControls();
                    return self.searchData;
                };

                var initeditPages = self.getCurrentEditPages();
                var initpageName = initeditPages[self.currentDetailPageNo].name;
                self.currentEditPage = ko.observable({name: initpageName, params: {data: self}, cacheKey: initpageName});

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                };

                self.handleBindingsApplied = function (info) {
                    $(self.dataGridId).on({'ojoptionchange': self.selectionChanged});
                };

                self.handleDetached = function (info) {
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
                };
            }
            return SsystemprocessporViewModel;
        }
);
