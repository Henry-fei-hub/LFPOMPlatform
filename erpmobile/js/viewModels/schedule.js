define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojpagingtabledatasource', 'ojs/ojrouter', 'ojs/ojdialog', 'ojs/ojbutton', 'ojs/ojradioset',
    'ojs/ojswitch', 'ojs/ojknockout', 'ojs/ojmodel', 'ojs/ojnavigationlist',
    'promise', 'ojs/ojdatagrid', 'ojs/ojpagingcontrol', 'ojs/ojcollectiondatagriddatasource', 'ojs/ojpagingdatagriddatasource',
    'ojs/ojconveyorbelt', 'dl/workflow', 'ojs/ojdiagram', 'ojs/ojjsondiagramdatasource'],
        function (oj, ko, $, dl) {
            function scheduleViewModel(params) {
                var self = this;
                self.schedule = ko.observable('流程进度');
                self.parentViewModel = params;
                self.diagramData = ko.observable();
                self.selectedItem = ko.observable("home");
                self.day = ko.observable();
                self.commentArr = ko.observableArray();
                self.poolArr = ko.observableArray();
                self.applyId = ko.observable();
                self.createTime = ko.observable();
                //判断字符是否为空的方法
                self.isEmpty = function (obj) {
                    if (typeof obj == "undefined" || obj == null || obj == "" || obj == []) {
                        return true;
                    } else {
                        return false;
                    }
                }
                self.getProcessInstanceCallback = function (resp) {
                    var arr = dl.parseCollection(resp);
                    var res = dl.parseModel(arr[0]);
                    var activitiesArr = res.processInstance.activities;
                    console.info(activitiesArr);
                    for (var i = 0; i < activitiesArr.length; i++) {
                        if (activitiesArr[i].activityType == 0) {
//                            发起节点
                            activitiesArr[i].statusName = '发起申请';
                            activitiesArr[i].operateTime = activitiesArr[i].instanceActivityCreateTime;
                            activitiesArr[i].color = '#333';
                        } else if (activitiesArr[i].activityType == 1) {
//                            结束节点
                            activitiesArr[i].statusName = '结束';
//                            activitiesArr.splice(i, 1);
                        } else {
                            if (activitiesArr[i].status == 1) {
//                            审批中节点
                                activitiesArr[i].statusName = '审批中';
                                activitiesArr[i].operateTime = activitiesArr[i].instanceActivityStartTime;
//                            获取时间
                                var nowdata = new Date().getTime();
                                var startDate = activitiesArr[i].instanceActivityStartTime;
                                if (startDate.length >= 18 && startDate.substr(0, 8) === '__DATE__') {
                                    var startDate = startDate.substring(8);
                                    var date = (nowdata - startDate) / 86400000;
                                    var day = Math.floor((nowdata - startDate) / 86400000);
                                    var hour = Math.floor(date / 3600000);
                                    self.day('已等待' + day + '天' + hour + '小时');
                                }
                                ;
                                activitiesArr[i].color = '#C89965';

                            } else if (activitiesArr[i].status == 2) {
//                            已审批节点
                                activitiesArr[i].statusName = '已同意';
                                activitiesArr[i].color = 'cadetblue';
                            } else if (activitiesArr[i].status == 3) {
//                            已驳回节点
                                activitiesArr[i].statusName = '已驳回';
                                activitiesArr[i].color = 'crimson';
                            } else if (activitiesArr[i].status == 4) {
//                            回退到发起人
//                            节点
                                activitiesArr[i].statusName = '回退到发起人';
                                activitiesArr[i].color = 'bisque';
                            } else if (activitiesArr[i].status == 5) {
//                            已驳回节点
                                activitiesArr[i].statusName = '回退';
                                activitiesArr[i].color = 'chocolate';
                            } else if (activitiesArr[i].status == 6) {
//                            回退到发起人
//                            节点
                                activitiesArr[i].statusName = '转交';
                                activitiesArr[i].color = 'seagreen';
                            }
                        }
                    }
                    ;
                    console.info(activitiesArr);
                    self.commentArr(activitiesArr);
                    self.diagramData(new oj.JsonDiagramDataSource(dl.generateDiagramData(res)));
                    console.log(self.commentArr());
                    return self.commentArr();
                };
                self.show = function (data, event) {
                    $('#content .home').show();
                    $('#content .blogs').hide();
                };
                self.showyj = function (data, event) {
                    $('#content .home').hide();
                    $('#content .blogs').show();
                };
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
                self.handleActivated = function (info) {
                    // Implement if needed
                };


                self.handleAttached = function (info) {
                    // Implement if needed
                    dl.callOperation('EP_GetProcessInstance', '', {processInstanceId: self.parentViewModel.processInstanceId}, self.getProcessInstanceCallback);

                };


                self.handleBindingsApplied = function (info) {
                    // Implement if needed
                };

                self.handleDetached = function (info) {
                    // Implement if needed
                };
            }

            return scheduleViewModel;
        }
);
