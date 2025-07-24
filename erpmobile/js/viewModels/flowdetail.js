define(['ojs/ojcore', 'knockout', 'jquery', 'diagramLayouts/DemoGridLayout', 'diagramLayouts/DemoLayoutSupport',
    'ojs/ojknockout', 'ojs/ojbutton', 'ojs/ojdiagram', 'ojs/ojjsondiagramdatasource', 'ojs/ojmenu', 'ojs/ojradioset', 'ojs/ojlabel', 'dl/commclient', 'dl/workflow'], function (oj, ko, $, layout, support) {
    function flowDetailViewModel(params) {
        var conditionNode;
        var conditionLink;
        var auditObjectEmployee = "指定人员";
        var auditObjectRole = "指定角色";
        var auditObjectDepartmentRole = "指定部门下角色";
        var timeOutHour = "小时";
        var timeOutDay = "天";
        var timeOutWeek = "周";
        var nodePrefix = "N";
        var linkPrefix = "L";
        var nodeId = 1;
        var colorHandler = new oj.ColorAttributeGroupHandler();
        var self = this;
        self.viewModelName = 'flowdetail';
        self.parentViewModel = params.data;
        if (dl.isNullOrUndefined(self.parentViewModel.details))
            self.parentViewModel.details = [];
        var thisViewModel = {name: 'flowdetail', data: self, detailType: self.parentViewModel.getCurrentDetailPageType()};
        dl.addViewModelToParentDetails(self.parentViewModel.details, thisViewModel);

        self.setDataToControls = function () {
//            if (self.parentViewModel.currentData) {
//                dl.copyDataToControls(self.parentViewModel.currentData.data.attributes, self);
//            }
        };

        self.setDataFromControls = function () {
            if (!self.parentViewModel.currentData) {
                self.parentViewModel.currentData = {};
                self.parentViewModel.currentData.data = {};
                self.parentViewModel.currentData.data.attributes = {};
            }
            var linkArr = [];
            for (var key in self.links2()) {
                var link = {};
                for(var prop in self.links2()[key]){
                    if(!self.links2()[key].hasOwnProperty(prop))
                        continue;
                    switch(prop){
                        case "startNode":
                            link.processActivityId = self.links2()[key][prop].substring(1);
                            break;
                        case "endNode":
                            link.toProcessActivityId = self.links2()[key][prop].substring(1);
                            break;
                        case "label":
                            link.condition = self.links2()[key][prop];
                            break;
                        default:
                            link[prop] = self.links2()[key][prop];
                            break;
                    }
                }
                linkArr.push(link);
            }
            var nodeArr = [];
            for (var key in self.nodes2()) {
                var node = self.nodes2()[key];
                var nodeData = {};
                for (var prop in node) {
                    if (!node.hasOwnProperty(prop))
                        continue;
                    if (!dl.isNullOrUndefined(node[prop])) {
                        switch (prop) {
                            case "X":
                                nodeData.posx = node[prop];
                                break;
                            case "Y":
                                nodeData.posy = node[prop];
                                break;
                            case "id":
                                nodeData.activitySerialNo = node[prop].substring(1);
                                break;
                            default:
                                nodeData[prop] = node[prop];
                                break;
                        }
                    }
                }
                nodeArr.push(nodeData);
            }
            self.parentViewModel.currentData.data.attributes["detailSystemProcessLink"] = linkArr;
            self.parentViewModel.currentData.data.attributes["detailSystemProcessActivity"] = nodeArr;
//            nodeData.posx = node.X;
//            nodeData.posy = node.Y;
//            nodeData.activitySerialNo = node.id.substring(1);
//            nodeData.activityType = node.activityType;
//            if (node.activityName !== undefined) {
//                nodeData.activityName = node.activityName;
//            }
//            if (node.executeName !== undefined) {
//                nodeData.executeName = node.executeName;
//            }
//            if (node.poolType !== undefined) {
//                nodeData.poolType = node.poolType;
//            }
//            if (node.ifAllowOver !== undefined) {
//                nodeData.ifAllowOver = node.ifAllowOver;
//            }
//            if (node.auditObject !== undefined) {
//                nodeData.auditObject = node.auditObject;
//            }
//            if (node.employeeId !== undefined) {
//                nodeData.employeeId = node.employeeId;
//            }
//            if (node.departmentId !== undefined) {
//                nodeData.departmentId = node.departmentId;
//            }
//            if (node.roleId !== undefined) {
//                nodeData.roleId = node.roleId;
//            }
//            if (node.timeOut !== undefined) {
//                nodeData.timeOut = node.timeOut;
//            }
//            if (node.timeOutAction !== undefined) {
//                nodeData.timeOutAction = node.timeOutAction;
//            }
        };

        self.activityName = ko.observable();
        self.executeName = ko.observable();
        self.poolType = ko.observable();
        self.ifAllowOver = ko.observable();
        self.auditObject = ko.observable();
        self.employeeId = ko.observable();
        self.departmentId = ko.observable();
        self.roleId = ko.observable();
        self.timeOut = ko.observable();
        self.timeOutAction = ko.observable();
        self.auditObject.subscribe(function () {
            if (self.auditObject() === auditObjectEmployee) {
                $("#flowdetail-departmentId-div").hide();
                $("#flowdetail-roleId-div").hide();
                $("#flowdetail-employeeId-div").parent().show();
            } else if (self.auditObject() === auditObjectRole) {
                $("#flowdetail-employeeId-div").parent().hide();
                $("#flowdetail-departmentId-div").hide();
                $("#flowdetail-roleId-div").show();
            } else if (self.auditObject() === auditObjectDepartmentRole) {
                $("#flowdetail-employeeId-div").parent().hide();
                $("#flowdetail-departmentId-div").show();
                $("#flowdetail-roleId-div").show();
            }
        });
        this.onDrop1 = function (event, ui) {
//            onDrop(event, ui, self.nodes1, true);
        };
        this.onDrop2 = function (event, ui) {
            onDrop(event, ui, self.nodes2, false);
        };
        this.onLinkDrop = function (event, ui) {
            onDrop(event, ui, self.nodes2, false);
        };
        this.nodeRendererFunc = function (context) {
            var color = context.state.selected ? 'red' : context.data.color;
            var stroke = context.state.selected || context.state.hovered ? 3 : 1;
            var radius = context.state.hovered ? 30 :
                    context.state.selected ? 20 : 10;
            var rootElement = context.rootElement;
//            if (!rootElement) {// initial rendering - create an svg element with a node content in it
//                var nodeId = context.data['id'];
//                rootElement = createSVG('nodeSvg' + nodeId);
//                group = addGroup(rootElement, 'topGroup' + nodeId);
//                addRect(group, 'rect' + nodeId);
//                addPath(group, color, 'M50,50 h-37 a37,37 0 1,0 37,-37 z');
//                addPath(group, 'yellow', 'M45,45 v-37 a37,37 0 0,0 -37,37 z');
//                addCircle(group, color, stroke, radius);
//            } else {// modification case - apply custom treatment to the node
//                var group = $(rootElement).children()[0];
//                var circle = $(group).children()[3];
//                circle.setAttributeNS(null, "fill", color);
//                circle.setAttributeNS(null, "stroke-width", stroke);
//                circle.setAttributeNS(null, "r", radius);
//            }
            // uncomment to apply default hover affect in addition to custom hover effect
            // context.renderDefaultHover();
            return {"": "1"};
        };

        this.tttt = function (event, ui) {
            console.log(event);
            console.log(ui);
        };
        function onDrop(event, ui, nodes, linkCleanUp) {
            var diagramData = event.dataTransfer.getData('text/nodes1') || event.dataTransfer.getData('text/nodes2');
            var newNodeId;
            // create new node
            if (diagramData) {
                var dataContext = JSON.parse(diagramData)[0];
                if (event.dataTransfer.getData('text/nodes1') !== "") {
                    dataContext.data.id = 'N' + nodeId;
                    dataContext.id = dataContext.data.id;
                    if (dataContext.data.activityType === 2) {
                        dataContext.data.icon.source = dl.ICON_PROFIX + dl.ICON_APPROVAL_NORMAL;
                    } else if (dataContext.data.activityType === 3) {
                        dataContext.data.icon.source = dl.ICON_PROFIX + dl.ICON_PROCESS_NORMAL;
                    } else {
                        dataContext.data.icon.source = dl.ICON_PROFIX + dl.ICON_ATTENTION_NORMAL;
                    }
                    dataContext.data.label = dataContext.data.label + dataContext.data.id;
                    dataContext.data.shortDesc = 'Node N' + nodeId,
                            nodeId = nodeId + 1;
                }
                //remove specific node from from it's current location
//                self.nodes1.remove(function (s) {
//                    return s.id === dataContext.id
//                });
                self.nodes2.remove(function (s) {
                    return s.id === dataContext.id
                });
                if (linkCleanUp)
                    self.links2.remove(function (s) {
                        return s.startNode === dataContext.id || s.endNode === dataContext.id
                    });
                //add node to the target
                dataContext.data.x = ui.nodeContext ? ui.x + 100 : ui.x;
                dataContext.data.y = ui.y;
                dataContext.data.labelPosition = {x: dataContext.data.x, y: dataContext.data.y + dl.ICON_SIZE};
                newNodeId = dataContext.data.id;
                nodes.push(dataContext.data);
                if (ui.nodeContext) {
                    var startNodeId = ui.nodeContext.id;
                    if(dataContext.data.activityType === 2 || dataContext.data.activityType === 3){
                        var startNum = 0;
                        var endNum = 0;
                        var realStartNode;
                        var realEndNode;
                        for(var linkKey in self.links2()){
                            if(self.links2()[linkKey].endNode === startNodeId){
                                for(var nodeKey in self.nodes2()){
                                    if(self.nodes2()[nodeKey].id === self.links2()[linkKey].startNode){
                                        if(self.nodes2()[nodeKey].activityType !== 4){
                                            startNum = startNum + 1;
                                            realStartNode = self.links2()[linkKey].startNode;
                                        }
                                        break;
                                    }
                                }
                            }
                            if(self.links2()[linkKey].startNode === startNodeId){
                                for(var nodeKey in self.nodes2()){
                                    if(self.nodes2()[nodeKey].id === self.links2()[linkKey].endNode){
                                        if(self.nodes2()[nodeKey].activityType !== 4){
                                            endNum = endNum + 1;
                                            realEndNode = self.links2()[linkKey].endNode;
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                        if(startNum === 1 && endNum === 1){
                            if (canCreateLink(realStartNode, newNodeId) && canCreateLink(newNodeId, realEndNode)) {
                                self.links2.push(createLink('L' + realStartNode + '_' + newNodeId, realStartNode, newNodeId, label));
                                self.links2.push(createLink('L' + newNodeId + '_' + realEndNode, newNodeId, realEndNode));
                            }
                        }
                    }else{
                        if (canCreateLink(startNodeId, newNodeId)) {
                            self.links2.push(createLink('L' + startNodeId + '_' + newNodeId, startNodeId, newNodeId));
                        }
                    }
                } else if (ui.linkContext) {
                    var linkId = ui.linkContext.id,
                            startNode = ui.linkContext.data.startNode,
                            endNode = ui.linkContext.data.endNode;
                    var label = ui.linkContext.data.label;
                    if (canCreateLink(startNodeId, newNodeId) && canCreateLink(newNodeId, endNode)) {
                        self.links2.remove(function (s) {
                            return s.id === linkId;
                        });
                        self.links2.push(createLink('L' + startNode + '_' + newNodeId, startNode, newNodeId, label));
                        self.links2.push(createLink('L' + newNodeId + '_' + endNode, newNodeId, endNode));
                    }
                } else {
                    if (event.currentTarget.id === 'diagram2') {
                        var distance = 99999;
                        for (var key in self.nodes2()) {
                            var node = self.nodes2()[key];
                            if (node.id === 'N0' || node.id === 'N999') {
                                continue;
                            }
                        }
                        var link;
                        var startNode;
                        var endNode;
                        var status = true;
                        for (var key in self.links2()) {
                            var tempLink = self.links2()[key];
                            if (tempLink.startNode === newNodeId || tempLink.endNode === newNodeId) {
                                status = false;
                                break;
                            }
                            var linkStartNode = getNodeFromNodes2ById(self.links2()[key].startNode);
                            var linkEndNode = getNodeFromNodes2ById(self.links2()[key].endNode);
                            var x = (linkStartNode.X + linkEndNode.X) / 2 - dataContext.data.x;
                            var y = (linkStartNode.Y + linkEndNode.Y) / 2 - dataContext.data.y;
                            var tempDistance = Math.sqrt(x * x + y * y);
                            console.log(linkStartNode);
                            console.log(linkEndNode);
                            if (tempDistance < distance) {
                                distance = tempDistance;
                                startNode = linkStartNode.id;
                                endNode = linkEndNode.id;
                                link = self.links2()[key];
                            }
                        }
                        if (status && canCreateLink(startNode, newNodeId) && canCreateLink(newNodeId, endNode)) {
                            self.links2.push(createLink('L' + startNode + '_' + newNodeId, startNode, newNodeId));
                            self.links2.push(createLink('L' + newNodeId + '_' + endNode, newNodeId, endNode));
                        }
                    }
                }
            }
        }
        ;
        self.condition = ko.observable();

        self.linkOKHandle = function () {
            if (self.condition() !== undefined) {
                conditionLink.label = self.condition();
                self.links2.remove(function (s) {
                    return s.id === conditionLink.id;
                });
                self.links2.push(conditionLink);
            }
            document.querySelector("#dialogLink").close();
        };

        self.linkCancleHandle = function () {
            document.querySelector("#dialogLink").close();
        };

        /**
         * 节点属性编辑页面确定按钮点击事件
         * @returns {undefined}
         */
        self.nodeOKHandle = function () {
            if (self.activityName() !== undefined) {
                conditionNode.label = self.activityName();
                conditionNode.activityName = self.activityName();
            }
            if (self.executeName() !== undefined) {
                conditionNode.executeName = self.executeName();
            }
            conditionNode.poolType = self.poolType() === undefined && self.employeeId()[0] === undefined ? 0 : self.poolType()[0];
            conditionNode.ifAllowOver = self.ifAllowOver();
            conditionNode.auditObject = self.auditObject();
            if (conditionNode.auditObject !== undefined) {
                if (conditionNode.auditObject === auditObjectEmployee) {
                    conditionNode.employeeId = self.employeeId() === undefined && self.employeeId()[0] === undefined ? 0 : self.employeeId()[0];
                    conditionNode.departmentId = 0;
                    conditionNode.roleId = 0;
                } else if (conditionNode.auditObject === auditObjectRole) {
                    conditionNode.employeeId = 0;
                    conditionNode.departmentId = 0;
                    conditionNode.roleId = self.roleId() === undefined ? 0 : self.roleId()[0];
                } else if (conditionNode.auditObject === auditObjectDepartmentRole) {
                    conditionNode.employeeId = 0;
                    conditionNode.departmentId = self.departmentId() === undefined ? 0 : self.departmentId()[0];
                    conditionNode.roleId = self.roleId() === undefined ? 0 : self.roleId()[0];
                }
            }
            conditionNode.timeOut = self.timeOut();
            if (conditionNode.timeOut === timeOutHour) {
                conditionNode.timeOutAction = self.timeOutAction() === undefined ? 0 : self.timeOutAction();
            } else if (conditionNode.timeOut === timeOutDay) {
                conditionNode.timeOutAction = self.timeOutAction() === undefined ? 0 : self.timeOutAction() * 24;
            } else if (conditionNode.timeOut === timeOutWeek) {
                conditionNode.timeOutAction = self.timeOutAction() === undefined ? 0 : self.timeOutAction() * 24 * 7;
            }
            self.nodes2.remove(function (s) {
                return s.id === conditionNode.id;
            });
            self.nodes2.push(conditionNode);
            document.querySelector("#dialogNode").close();
        };

        self.nodeCancleHandle = function () {
            document.querySelector("#dialogNode").close();
        };


        function getNodeFromNodes2ById(nodeId) {
            for (var key in self.nodes2()) {
                if (self.nodes2()[key].id === nodeId) {
                    return self.nodes2()[key];
                }
            }
        }

        function initDrawPanelNode(prefix, count) {
            var nodes = [];
            for (var i = 0; i < count; i++) {
                var shape = i === 0 ? dl.ICON_PROFIX + dl.ICON_START : dl.ICON_PROFIX + dl.ICON_END;
                var node = {
                    id: prefix + (i === 0 ? 0 : 999),
                    label: i === 0 ? '发起人' : '结束',
                    shortDesc: 'Node ' + prefix + (i === 0 ? 0 : 999),
//                icon: {color: color, width: 40, height: 40, shape: shape},
                    icon: {width: dl.ICON_SIZE, height: dl.ICON_SIZE, source: shape},
                    x: i * 340 + 15, y: i * 70 + 15,
                    activityType: i
                };
                node.labelPosition = {x: node.x, y: node.y + dl.ICON_SIZE};
                nodes.push(node);
            }
            return nodes;
        }
        function initDrawPanelLink() {
            var links = [];
            var link = {
                id: 'L' + 0,
                shortDesc: 'Link L' + 0 + ', connects ' + 'N0' + ' to ' + 'N999',
                startNode: 'N0',
                endNode: 'N999', width: 2,
                startConnectorType: 'none', endConnectorType: 'arrow'
//                style:'dot'
            };
            links.push(link);
            return links;
        }
        function initUpdateDrawPanelNode() {
            var nodes = [];
            var arr = self.parentViewModel.currentData.data.attributes["detailSystemProcessActivity"];
            for (var key in arr) {
                var node = {};
                var shape;
                for (var prop in arr[key]) {
                    if (!dl.isNullOrUndefined(arr[key][prop])) {
                        switch (prop) {
                            case "posx":
                                node.x = arr[key][prop];
                                node.X = arr[key][prop];
                                break;
                            case "posy":
                                node.y = arr[key][prop];
                                node.Y = arr[key][prop];
                                break;
                            case "activityType":
                                if (arr[key][prop] !== 0 && arr[key][prop] !== 1 && arr[key].activitySerialNo > nodeId) {
                                    nodeId = arr[key].activitySerialNo + 1;
                                }
                                if (arr[key][prop] === 0) {
                                    shape = dl.ICON_PROFIX + dl.ICON_START;
                                    node.label = "发起人";
                                } else if (arr[key][prop] === 1) {
                                    shape = dl.ICON_PROFIX + dl.ICON_END;
                                    node.label = "结束";
                                } else if (arr[key][prop] === 2) {
                                    shape = dl.ICON_PROFIX + dl.ICON_APPROVAL_NORMAL;
                                } else if (arr[key][prop] === 3) {
                                    shape = dl.ICON_PROFIX + dl.ICON_PROCESS_NORMAL;
                                } else if (arr[key][prop] === 4) {
                                    shape = dl.ICON_PROFIX + dl.ICON_ATTENTION_NORMAL;
                                }
                                node[prop] = arr[key][prop];
                                break;
                            case "activityName":
                                node.label = arr[key][prop];
                                node[prop] = arr[key][prop];
                                break;
                            case "activitySerialNo":
                                node.id = nodePrefix + arr[key][prop];
                                node.shortDesc = node.id;
                                break;
                            case "timeOutAction":
                                if (arr[key][prop] === 0) {
                                    node.timeOut = timeOutHour;
                                } else {
                                    if (arr[key][prop] % (24 * 7) === 0) {
                                        node.timeOut = timeOutWeek;
                                    } else if (arr[key][prop] % (24) === 0) {
                                        node.timeOut = timeOutDay;
                                    } else {
                                        node.timeOut = timeOutHour;
                                    }
                                }
                                node[prop] = arr[key][prop];
                                break;
                            default:
                                node[prop] = arr[key][prop];
                                break;
                        }
                    }
                }
                node.icon = {width: dl.ICON_SIZE, height: dl.ICON_SIZE, source: shape};
                node.labelPosition = {x: node.x, y: node.y + dl.ICON_SIZE};
                if (node.employeeId > 0) {
                    node.auditObject = auditObjectEmployee;
                } else if (node.departmentId > 0) {
                    node.auditObject = auditObjectDepartmentRole;
                } else if (node.roleId > 0) {
                    node.auditObject = auditObjectRole;
                }
                nodes.push(node);
            }
            return nodes;
        }
        function initUpdateDrawPanelLink() {
            var links = [];
            var arr = self.parentViewModel.currentData.data.attributes["detailSystemProcessLink"];
            for (var key in arr) {
                var link = {};
                link.startNode = nodePrefix + arr[key].processActivityId;
                link.endNode = nodePrefix + arr[key].toProcessActivityId;
                link.id = linkPrefix + "_" + link.startNode + "_" + link.endNode;
                link.shortDesc = link.id;
                if (arr[key].condition !== undefined) {
                    link.label = arr[key].condition;
                }
                if (arr[key].processId !== undefined) {
                    link.processId = arr[key].processId;
                }
                if (arr[key].processLinkId !== undefined) {
                    link.processLinkId = arr[key].processLinkId;
                }
                link.width = 2;
                link.startConnectorType = "none";
                link.endConnectorType = "arrow";
                for (var item in self.parentViewModel.currentData.data.attributes["detailSystemProcessActivity"]) {
                    if (self.parentViewModel.currentData.data.attributes["detailSystemProcessActivity"][item].activitySerialNo === arr[key].toProcessActivityId &&
                            self.parentViewModel.currentData.data.attributes["detailSystemProcessActivity"][item].activityType === 4) {
                        link.style = "dot";
                        break;
                    }
                }
                links.push(link);
            }
            return links;
        }
        function createNode(prefix, index, category, color) {
//            var shape = category == 0 ? 'square' : category == 1 ? 'circle' : 'human';
            var shape = category === 0 ? '/css/images/auditor_add.png' : category == 1 ? '/css/images/operator_add.png' : '/css/images/insider_add.png';
            return {
                id: prefix + index,
                label: category === 0 ? '审核人' : category == 1 ? '处理人' : '知会人',
                activityType: category === 0 ? 2 : category == 1 ? 3 : 4,
                category: category,
//                shortDesc: 'Node ' + prefix + index,
//                icon: {color: color, width: 40, height: 40, shape: shape},
                icon: {color: color, width: 64, height: 64, source: shape},
                x: index * 70 + 15, y: category * 70 + 15
            };
        }
        function createLink(index, startId, endId, label, ) {
            var link = {};
            link.id = 'L' + index;
            link.shortDesc = 'Link L' + index + ', connects ' + startId + ' to ' + endId;
            link.startNode = startId;
            link.endNode = endId;
            link.width = 2;
            link.label = label;
            link.startConnectorType = 'none';
            link.endConnectorType = 'arrow';
            for (var key in self.nodes2()) {
                if (self.nodes2()[key].id === endId) {
                    if (self.nodes2()[key].activityType === 4) {
                        link.style = 'dot';
                    }
                    break;
                }
            }
            return link;
        }
//        function generateNodes(prefix, count) {
//            var nodes = [];
//            for (var i = 0; i < count; i++) {
//                var category = i % 3; //3 categories of nodes
//                nodes.push(createNode(prefix, i, category, colorHandler.getValue(category)));
//            }
//            return nodes;
//        };
        function generateNodes(prefix, count) {
            var nodes = [];
            for (var i = 0; i < count; i++) {
                var category = i % 3; //3 categories of nodes
                nodes.push(createNode(prefix, i, category, colorHandler.getValue(category)));
            }
            return nodes;
        }
        ;
        function generateLinks(prefix, count) {
            var links = [];
            for (var i = 0; i < count; i++) {
                links.push(createLink(i, prefix + i, prefix + (i + 1)));
            }
            return links;
        }
        ;

        function labelLayoutFunc(layoutContext, node) {
            var nodeBounds = node.getContentBounds();
            var nodePos = node.getPosition();
            console.log(node._data.icon.labelPosition);
            var labelLayout = {
                'x': nodeBounds.x + nodePos.x + .5 * (nodeBounds.w),
//                'y': nodeBounds.y + nodePos.y + .5 * (nodeBounds.h),
//                'x':node._data.labelPosition.x,
                'y': node._data.labelPosition.y,
                'halign': 'center'
//                'valign': 'middle'
            };
            return labelLayout;
        }
        ;

        function linkPathFunc(layoutContext, link) {
            var node1 = layoutContext.getNodeById(link.getStartId());
            var node2 = layoutContext.getNodeById(link.getEndId());
            if (node1 === node2) {
                return;
            }
            var n1Pos = node1.getPosition(), n2Pos = node2.getPosition();
            var n1Bounds = node1.getBounds(), n2Bounds = node2.getBounds();
//            var startX = n1Pos.x + .5 * n1Bounds.w;
//            var startY = n1Pos.y + .5 * n1Bounds.h;
//            var endX = n2Pos.x + .5 * n2Bounds.w;
//            var endY = n2Pos.y + .5 * n2Bounds.h;
            node1 = node1.getData();
            node1.X = node1.x;
            node1.Y = node1.y;
            node2 = node2.getData();
            node2.X = node2.x;
            node2.Y = node2.y;
            var startPoint = dl.getNextConnectPoint(node1, node2);
            var endPoint = dl.getPreviousConnectPoint(node2, node1);
//            var res = [];
//            res.push(startPoint.x);
//            res.push(startPoint.y);
            return [startPoint.x, startPoint.y, endPoint.x, endPoint.y];
//            return [startX, startY, endX, endY];
        }
        ;

        this.nodes1 = ko.observableArray(generateNodes('N', 3));
        if (self.parentViewModel.getCurrentDetailPageType() === dl._DETAILTYPE_UPDATE) {
            this.nodes2 = ko.observableArray(initUpdateDrawPanelNode('N', 2));
            this.links2 = ko.observableArray(initUpdateDrawPanelLink());
        } else {
            this.nodes2 = ko.observableArray(initDrawPanelNode('N', 2));
            this.links2 = ko.observableArray(initDrawPanelLink());
        }
        this.data1 = ko.pureComputed(function () {
            return new oj.JsonDiagramDataSource({'nodes': self.nodes1()});
        });
        this.data2 = ko.pureComputed(function () {
            return new oj.JsonDiagramDataSource({'nodes': self.nodes2(), 'links': self.links2()});
        });
        this.gridLayout = layout.gridLayout();
        this.dropLayout = ko.pureComputed(function () {
            return oj.DiagramUtils.getLayout({
                'nodes': this.nodes2(),
                'links': this.links2(),
                'nodeDefaults': {'labelLayout': labelLayoutFunc},
                'linkDefaults': {'path': linkPathFunc},
                'viewport': function (layoutContext) {
                    for (var li = 0; li < layoutContext.getLinkCount(); li++) {
                        var link = layoutContext.getLinkByIndex(li);
                        var endpoints = support.getEndpoints(layoutContext, link);

                        var startX = endpoints[0].x;
                        var startY = endpoints[0].y;
                        var endX = endpoints[1].x;
                        var endY = endpoints[1].y;
                        link.setPoints([startX, startY, endX, endY]);
                        //center label on link
                        var labelBounds = link.getLabelBounds();
                        if (labelBounds) {
                            var labelX = startX + 0.5 * (endX - startX);
                            var labelY = startY + 0.5 * (endY - startY - labelBounds.h);
                            link.setLabelPosition({'x': labelX, 'y': labelY});
                            link.setLabelRotationAngle((endY - startY) / (endX - startX));
                            link.setLabelValign("baseline");
                            link.setLabelRotationPoint({x: 196, y: 277});
                            console.log(link.getLabelRotationPoint());
                            console.log(link.getLabelRotationAngle());
                            link.setLabelHalign("center");
                        }
                    }
                    if (layoutContext.getCurrentViewport()) {
                        return layoutContext.getCurrentViewport();
                    } else
                        return layoutContext.getComponentSize();
                }
            });
        }, this);
        this.selectedMenuItem = ko.observable("(None selected yet)");
        this.beforeOpenFunction = function (event) {
            var target = event.detail.originalEvent.target;
            var diagram = document.getElementById("diagram2");
            var context = diagram.getContextByNode(target);
            node = null, link = null;
            if (context != null) {
                if (context.subId == "oj-diagram-node")
                    node = diagram.getNode(context["index"]);
                else if (context.subId == "oj-diagram-link")
                    link = diagram.getLink(context["index"]);
            }
        };

        function canCreateLink(startNode, endNode, concurrent) {
            if (startNode === endNode) {
                return false;
            }
            for (var key in self.links2()) {
                if (self.links2()[key].startNode === startNode && self.links2()[key].endNode === endNode) {
                    return false;
                }
            }
            return true;
        }

        this.menuItemAction = function (event) {
            var text = event.target.textContent;
            if (node) {
                if (node.id === 'N0' || node.id === 'N999') {
                    return;
                }
                if (text === '删除') {
                    self.nodes2.remove(function (s) {
                        return s.id === node.id;
                    });
                    var startNode = [];
                    var endNode = [];
                    for (var key in self.links2()) {
                        if (self.links2()[key].startNode === node.id) {
                            endNode.push(self.links2()[key].endNode);
                        }
                        if (self.links2()[key].endNode === node.id) {
                            startNode.push(self.links2()[key].startNode);
                        }
                    }
                    var label;
                    if (startNode.length === 1 && endNode.length > 1) {
                        //一对多
                        for (var key in endNode) {
                            for (var linkKey in self.links2()) {
                                if (self.links2()[linkKey].startNode === node.id && self.links2()[linkKey].endNode === endNode[key] && canCreateLink(startNode[0], endNode[key])) {
                                    self.links2.push(createLink('L' + startNode[0] + '_' + endNode[key], startNode[0], endNode[key], self.links2()[linkKey].label));
                                }
                            }
                        }
                    } else if (startNode.length > 1 && endNode.length === 1) {
                        //多对一
                        for (var linkKey in self.links2()) {
                            if (self.links2()[linkKey].startNode === node.id && self.links2()[linkKey].endNode === endNode[0]) {
                                label = self.links2()[linkKey].label;
                            }
                        }
                        for (var key in startNode) {
                            if (canCreateLink(startNode[key], endNode[0])) {
                                self.links2.push(createLink('L' + startNode[key] + '_' + endNode[0], startNode[key], endNode[0], label));
                            }
                        }
                    } else if (startNode.length > 0 && endNode.length > 0) {
                        if (startNode.length === 1 && endNode.length === 1) {
                            for (var linkKey in self.links2()) {
                                if (self.links2()[linkKey].startNode === node.id && self.links2()[linkKey].endNode === endNode[0]) {
                                    label = self.links2()[linkKey].label;
                                }
                            }
                        }
                        if (canCreateLink(startNode[0], endNode[0])) {
                            self.links2.push(createLink('L' + startNode[0] + '_' + endNode[0], startNode[0], endNode[0], label));
                        }
                    }
                    self.links2.remove(function (s) {
                        return s.startNode === node.id || s.endNode === node.id;
                    });
                } else if (text === '属性') {
                    conditionNode = undefined;
                    conditionLink = undefined;
                    self.condition(undefined);
                    for (var key in self.nodes2()) {
                        if (self.nodes2()[key].id === node.id) {
                            conditionNode = self.nodes2()[key];
                        }
                    }
                    console.log("选中的节点的属性：");
                    console.log(conditionNode);
                    if (conditionNode !== undefined) {
                        self.activityName(conditionNode.activityName);
                        self.executeName(conditionNode.executeName);
                        if (conditionNode.poolType === undefined) {
                            self.poolType(0);
                        } else {
                            self.poolType(conditionNode.poolType);
                        }
                        if (conditionNode.ifAllowOver !== undefined) {
                            self.ifAllowOver(conditionNode.ifAllowOver);
                        } else {
                            self.ifAllowOver(false);
                        }
                        self.ifAllowOver();
                        if (conditionNode.auditObject !== undefined) {
                            self.auditObject(conditionNode.auditObject);
                        } else {
                            self.auditObject(auditObjectEmployee);
                        }
                        if (conditionNode.auditObject === auditObjectEmployee) {
                            self.employeeId(conditionNode.employeeId);
                            self.departmentId(undefined);
                            self.roleId(undefined);
                        } else if (conditionNode.auditObject === auditObjectRole) {
                            self.employeeId(undefined);
                            self.departmentId(undefined);
                            self.roleId(conditionNode.roleId);
                        } else if (conditionNode.auditObject === auditObjectDepartmentRole) {
                            self.employeeId(undefined);
                            self.departmentId(conditionNode.departmentId);
                            self.roleId(conditionNode.roleId);
                        } else {
                            self.employeeId(null);
                            self.departmentId(undefined);
                            self.roleId(undefined);
                        }
                        if (conditionNode.timeOut !== undefined) {
                            self.timeOut(conditionNode.timeOut);
                        } else {
                            self.timeOut(timeOutHour);
                        }
                        if (conditionNode.timeOut === timeOutHour) {
                            self.timeOutAction(conditionNode.timeOutAction === undefined ? 0 : conditionNode.timeOutAction);
                        } else if (conditionNode.timeOut === timeOutDay) {
                            self.timeOutAction(conditionNode.timeOutAction === undefined ? 0 : conditionNode.timeOutAction / 24);
                        } else if (conditionNode.timeOut === timeOutWeek) {
                            self.timeOutAction(conditionNode.timeOutAction === undefined ? 0 : conditionNode.timeOutAction / 24 / 7);
                        } else {
                            self.timeOutAction(undefined);
                        }
                        document.querySelector("#dialogLink").close();
                        document.querySelector("#dialogNode").open();
                    }
                }
            } else if (link) {
                if (text === '删除') {
                    self.links2.remove(function (s) {
                        return s.id === link.id;
                    });
                } else if (text === '属性') {
                    conditionNode = undefined;
                    conditionLink = link;
                    self.condition(undefined);
                    document.querySelector("#dialogNode").close();
                    document.querySelector("#dialogLink").open();
                }
//              this.selectedMenuItem(text + " from Link " + link.id);
            } else {
                if (text === '删除') {
                    self.links2.remove(function (s) {
                        return s.id;
                    });
                    self.nodes2.remove(function (s) {
                        return s.id !== 'N0' && s.id !== 'N999';
                    });
                    self.links2.push(createLink('L0', 'N0', 'N999'));
                }
            }
        };
    }
    return flowDetailViewModel;
});