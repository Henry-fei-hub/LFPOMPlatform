define(['ojs/ojcore', 'knockout', 'jquery', 'diagramLayouts/DemoGridLayout',
    'ojs/ojknockout', 'ojs/ojbutton', 'ojs/ojdiagram', 'ojs/ojjsondiagramdatasource' , 'dl/commclient','dl/workflow'], function (oj, ko, $, layout) {
    function model(data) {
        var colorHandler = new oj.ColorAttributeGroupHandler();
        var self = this;
        this.onDrop1 = function (event, ui) {
            onDrop(event, ui, self.nodes1, true);
        };
        this.onDrop2 = function (event, ui) {
            onDrop(event, ui, self.nodes2, false);
        };
        this.onLinkDrop = function (event, ui) {
            onDrop(event, ui, self.nodes2, false);
        };
        function onDrop(event, ui, nodes, linkCleanUp) {
            var diagramData = event.dataTransfer.getData('text/nodes1') || event.dataTransfer.getData('text/nodes2');
            var newNodeId;
            // create new node
            if (diagramData) {
                var dataContext = JSON.parse(diagramData)[0];
                //remove specific node from from it's current location
                self.nodes1.remove(function (s) {
                    return s.id === dataContext.id
                });
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
                newNodeId = dataContext.data.id;
                nodes.push(dataContext.data);
            }
            if (ui.nodeContext) {
                var startNodeId = ui.nodeContext.id;
                self.links2.push(createLink('L' + startNodeId + '_' + newNodeId, startNodeId, newNodeId));
            } else if (ui.linkContext) {
                var linkId = ui.linkContext.id,
                        startNode = ui.linkContext.data.startNode,
                        endNode = ui.linkContext.data.endNode;
                self.links2.remove(function (s) {
                    return s.id === linkId
                });
                self.links2.push(createLink('L' + startNode + '_' + newNodeId, startNode, newNodeId));
                self.links2.push(createLink('L' + newNodeId + '_' + endNode, newNodeId, endNode));
            }
        }
        ;
        function createNode(prefix, index, category, color) {
//            var shape = category == 0 ? 'square' : category == 1 ? 'circle' : 'human';
            var shape = category == 0 ? '/css/images/insider_add.png' : category == 1 ? '/css/images/auditor_add.png' : '/css/images/operator_add.png';
            return {
                id: prefix + index,
                label: prefix + index + '文字',
                shortDesc: 'Node ' + prefix + index + ', category ' + category,
//                icon: {color: color, width: 40, height: 40, shape: shape},
                icon: {color: color, width: 64, height: 64, source: shape},
                x: index * 70 + 15, y: index * 70 + 15
            };
        }
        function createLink(index, startId, endId) {
            return {
                id: 'L' + index,
                shortDesc: 'Link L' + index + ', connects ' + startId + ' to ' + endId,
                startNode: startId,
                endNode: endId, width: 2,
                startConnectorType: 'none', endConnectorType: 'arrow'
//                style:'dot'
            };
        }
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
            var labelLayout = {
                'x': nodeBounds.x + nodePos.x + .5 * (nodeBounds.w),
                'y': nodeBounds.y + nodePos.y + .5 * (nodeBounds.h),
                'halign': 'center',
                'valign': 'middle'
            };
            return labelLayout;
        }
        ;

        function linkPathFunc(layoutContext, link) {
            var node1 = layoutContext.getNodeById(link.getStartId());
            var node2 = layoutContext.getNodeById(link.getEndId());
            var n1Pos = node1.getPosition(), n2Pos = node2.getPosition();
            var n1Bounds = node1.getBounds(), n2Bounds = node2.getBounds();
            var startX = n1Pos.x + .5 * n1Bounds.w;
            var startY = n1Pos.y + .5 * n1Bounds.h;
            var endX = n2Pos.x + .5 * n2Bounds.w;
            var endY = n2Pos.y + .5 * n2Bounds.h;
//        node1 = node1.getData();
//        node1.X = node1.x;
//        node1.Y = node1.y;
//        node2 = node2.getData();
//        node2.X = node2.x;
//        node2.Y = node2.y;
//            var startPoint = dl.getNextConnectPoint(node1, node2);
//            var endPoint = dl.getPreviousConnectPoint(node2, node1);
//            var res = [];
//            res.push(startPoint.x);
//            res.push(startPoint.y);
//            return [startPoint.x, startPoint.y, endPoint.x, endPoint.y];
            return [startX, startY, endX, endY];
        }
        ;

        this.nodes1 = ko.observableArray(generateNodes('A', 12));
        this.nodes2 = ko.observableArray(generateNodes('B', 3));
        this.links2 = ko.observableArray(generateLinks('B', 2));
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
                    if (layoutContext.getCurrentViewport()) {
                        return layoutContext.getCurrentViewport();
                    } else
                        return layoutContext.getComponentSize();
                }
            })
        }, this);

    }
    return new model();
});