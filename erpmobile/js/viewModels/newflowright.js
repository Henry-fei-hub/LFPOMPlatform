
define(['ojs/ojcore', 'knockout', 'jquery', 'ojs/ojknockout', 'promise',
    'ojs/ojtable', 'ojs/ojrowexpander', 'ojs/ojflattenedtreetabledatasource', 'ojs/ojjsontreedatasource', 'dl/commclient'],
        function (oj, ko, $)
        {
            function newFlowRightViewModel(params)
            {
                var self = this;
                var originalData;
                self.viewModelName = 'newflowright';
                self.parentViewModel = params.data;
                if (dl.isNullOrUndefined(self.parentViewModel.details))
                    self.parentViewModel.details = [];
                var thisViewModel = {name: 'newflowright', data: self, detailType: self.parentViewModel.getCurrentDetailPageType};
                dl.addViewModelToParentDetails(self.parentViewModel.details, thisViewModel);
                self.setDataToControls = function () {
                    if (self.parentViewModel.currentData) {
                        dl.copyDataToControls(self.parentViewModel.currentData.data.attributes, self);
                    }
                };

                self.setDataFromControls = function () {
                    if (!self.parentViewModel.currentData) {
                        self.parentViewModel.currentData = {};
                        self.parentViewModel.currentData.data = {};
                        self.parentViewModel.currentData.data.attributes = {};
                    }
                    var departmentIdArr = [];
                    self.parentViewModel.currentData.data.attributes["detailSystemProcessDepartment"] = self.getData(0, undefined, departmentIdArr);
//                    dl.copyDataFromControls(self.parentViewModel.currentData.data.attributes, self);
                };

                self.getData = function (parent, data, departmentIdArr) {
                    if (data === undefined) {
                        data = self.data();
                    }
                    for (var key in data) {
                        if (data[key].attr.parentId === parent) {
                            if (data[key].attr.enabled === true) {
                                if (self.parentViewModel.getCurrentDetailPageType === dl._DETAILTYPE_UPDATE && !dl.isNullOrUndefined(originalData)) {
                                    var found = false;
                                    for (var item in originalData) {
                                        if (originalData[item].departmentId === data[key].attr.departmentId) {
                                            found = true;
                                            departmentIdArr.push(originalData[item]);
                                            break;
                                        }
                                    }
                                    if (!found) {
                                        departmentIdArr.push({"departmentId": data[key].attr.departmentId});
                                    }
                                } else {
                                    departmentIdArr.push({"departmentId": data[key].attr.departmentId});
                                }
                            }
                            if (data[key].children !== undefined && data[key].children.length > 0) {
                                self.getData(data[key].id, data[key].children, departmentIdArr);
                            }
                        } else {
                            if (data[key].children !== undefined && data[key].children.length > 0) {
                                self.tree(parent, data[key].children, departmentIdArr);
                            }
                        }
                    }
                    return departmentIdArr;
                };
                self.data = ko.observableArray();
                self.dataSource = ko.observable();

//                self.options = {
////                    'rowHeader': 'departmentName',
//                    'rowHeader': 'departmentId',
//                    expanded: 'all',
//                    'columns': ['managerId', 'parentId', 'departmentId']
////                    'columns': ['managerId', 'parentId']
//                };
                self.options = {expanded: 'all', refresh: true};
                self.tree = function (parent, data, status) {
                    if (data === undefined) {
                        data = self.data();
                    }
                    for (var key in data) {
                        if (data[key].attr.parentId === parent) {
                            data[key].attr.enabled = status;
                            if (data[key].children !== undefined && data[key].children.length > 0) {
                                self.tree(data[key].id, data[key].children, status);
                            }
                        } else {
                            if (data[key].children !== undefined && data[key].children.length > 0) {
                                self.tree(parent, data[key].children, status);
                            }
                        }
                    }
//                    self.dataSource(new oj.FlattenedTreeTableDataSource(
//                            new oj.FlattenedTreeDataSource(new oj.JsonTreeDataSource(data), self.options)));
                };

                self.updatePanelFirstLoadTree = function (parent, data, departments) {
                    if (data === undefined) {
                        data = self.data();
                    }
                    var num = 0;
                    for (var key in data) {
                        if (data[key].attr.parentId === parent) {
                            if (data[key].attr.enabled === false) {
                                var found = false;
                                for (var pro in departments) {
                                    if (departments[pro].departmentId === data[key].attr.id) {
                                        found = true;
                                        delete departments[pro];
                                        if (data[key].children !== undefined && data[key].children.length > 0) {
                                            if (self.updatePanelFirstLoadTree(data[key].id, data[key].children, departments) === data[key].children.length) {
                                                data[key].attr.enabled = true;
                                                num = num + 1;
                                                continue;
                                            }
                                        } else {
                                            data[key].attr.enabled = true;
                                            num = num + 1;
                                            continue;
                                        }
                                    }
                                }
                                if (!found) {
                                    if (data[key].children !== undefined && data[key].children.length > 0) {
                                        self.updatePanelFirstLoadTree(data[key].id, data[key].children, departments);
                                    }
                                }
                            }
                        } else {
                            if (data[key].children !== undefined && data[key].children.length > 0) {
                                self.updatePanelFirstLoadTree(parent, data[key].children, departments);
                            }
                        }
                    }
                    return num;
                };

                self.rowRenderer = function (data) {
                    return oj.KnockoutTemplateUtils.getRenderer('row_template', true);
                };
                self.datareceived = function (data) {
                    self.tree(0, data, false);
                    self.data(data);
                    if (self.parentViewModel.getCurrentDetailPageType === dl._DETAILTYPE_UPDATE && !dl.isNullOrUndefined(self.parentViewModel.currentData)) {
                        originalData = self.parentViewModel.currentData.data.attributes.detailSystemProcessDepartment;
                        var departments = [];
                        for (var key in originalData) {
                            departments[key] = originalData[key];
                        }
                        self.updatePanelFirstLoadTree(0, self.data(), departments);
                    }
                    self.dataSource(new oj.FlattenedTreeTableDataSource(
                            new oj.FlattenedTreeDataSource(new oj.JsonTreeDataSource(self.data()), self.options)));
                };
                self.myclick = function (data, event) {
                    var allcheckboxes = $("input[id ^= '__']");
                    allcheckboxes.each(function (index, element) {
                    });
                };

                self.testClick = function (data, event) {
//                   var allcheckboxes = $("input[id ^= '"+event.target.id+"']");
//                   var a = {key: 1, depth: 0, index: 0, parent: null};
//                   a.subId = event.target.id.substring(2);
//                var subId = $( "#row_header_template" ).ojRowExpander( "getNodeBySubId", a );
//                    $("input[id ^= '__1']").attr("checked", true);
//                    $("input[id ^= '__1']").attr("checked", false);
//                    self.dataSource;
//                    console.log(self.data());
//                    self.dataSource().collapse(57);
//                    self.data()[0].children[1].attr.enabled = false;
//                    self.data()[0].attr.enabled = false;
                    self.tree(data.departmentId, self.data(), !data.enabled);
                    oj.TableDataSource.superclass.handleEvent.call(self.dataSource(), oj.TableDataSource.EventType['REFRESH'], null);
//                    data.enabled = false;
//                    data.enabled = !data.enabled;
//                    self.dataSource()._nodeSetList[0].nodeSet.m_nodeSet.m_nodeSet.m_nodes[0].attr.enabled = (self.dataSource()._nodeSetList[0].nodeSet.m_nodeSet.m_nodeSet.m_nodes[0].attr.enabled);
//                    self.tree(data.departmentId, self.dataSource()._nodeSetList[0].nodeSet.m_nodeSet.m_nodeSet.m_nodes[0].attr.enabled, !data.enabled);
                };
                dl.callOperation("EP_GenerateDepartmentTree", '', {}, self.datareceived);

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
            return newFlowRightViewModel;
        });