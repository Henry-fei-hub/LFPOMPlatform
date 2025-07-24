"use strict";

define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient'],
        function (oj, ko, $, dl) {
            dl.ACTIVITY_SERIAL_NO = "activitySerialNo";
            dl.ACTIVITY_ID = "activityId";
            dl.ACTIVITY_ATTENTION_ID = "systemProcessAttentionId";
            dl.ACTIVITY_TYPE = "activityType";
            dl.EMPLOYEE_ID = "employeeId";
            dl.BUSINESS_NAME = "backViewName";
            dl.ACTIVITY_STATUS = "status";
            dl.ACTIVITY_START = "start";
            dl.ACTIVITY_END = "end";
            dl.ACTIVITY_APPROVAL = "approval";
            dl.ACTIVITY_PROCESSOR = "processor";
            dl.ACTIVITY_ATTENTION = "attention";
            dl.DETAIL_ACTIVITY = "detailSystemProcessActivity";
            dl.DETAIL_LINK = "detailSystemProcessLink";
            dl.ICON_SIZE = 64;
            dl.ARROW_SIZE = 8;
            dl.ICON_APPROVAL_NORMAL = "auditor_normal.png";
            dl.ICON_APPROVAL_ACTIVE = "auditor_active.png";
            dl.ICON_PROCESS_NORMAL = "operator_normal.png";
            dl.ICON_PROCESS_ACTIVE = "operator_active.png";
            dl.ICON_ATTENTION_NORMAL = "insider_normal.png";
            dl.ICON_ATTENTION_ACTIVE = "insider_active.png";
            dl.ICON_START = "start.png";
            dl.ICON_END = "stop.png";
            dl.ICON_PROFIX = "/css/images/";

            dl.processNodeDefault = function () {
                var res = {};
                res.linkDefaults = {startConnectorType: 'circle', endConnectorType: 'arrow', width: 4};
                res.nodeDefaults = {};

                res.nodeDefaults.icon = {width: 64, height: 64, shape: 'circle'};
                return res;
            };

            dl.nodeRenderer = function (context) {
                var rootElement = context.rootElement;
                if (!rootElement) {
                    var nodeId = context.data['id'];
                    rootElement = dl.createSVG(64, 64);
                    var group = dl.addGroup(rootElement, 'topGroup' + nodeId);
                    dl.addImage(group, context.data.icon.source, 0, 0, 64, 64);
                }
                return rootElement;
            };

            dl.diagramLayout = function (context) {
                var viewport = context.getComponentSize();
                var startX = viewport.x + 10;
                var startY = viewport.y + 10;
                var maxX = viewport.x + viewport.w;
                var maxY = viewport.y + viewport.h;
                var direction = 0;
                var hasAttention = false;

                for (var i = 0; i < context.getNodeCount(); i++) {
                    var node = context.getNodeByIndex(i);
                    var nodeData = node.getData();
                    if (nodeData.id.charAt(0) !== 'N')
                        continue;
                    nodeData.X = startX;
                    nodeData.Y = startY;
                    node.setPosition({x: startX, y: startY});
                    node.setLabelPosition({x: startX, y: startY + dl.ICON_SIZE + 2});
                    if (!dl.isNullOrEmpty(nodeData.attentions)) {
                        var ax = 0, ay = startY + dl.ICON_SIZE * 2 + 28;
                        var num = nodeData.attentions.length;
                        if (num === 1)
                            ax = startX;
                        else if (num === 2) {
                            ax = startX - (dl.ICON_SIZE + 28) / 2;
                        } else {
                            ax = startX - ((num + 1) / 2 * dl.ICON_SIZE + 28);
                        }
                        for (var j = 0; j < num; j++) {
                            var attentionNode = context.getNodeById(nodeData.attentions[j].id);
                            var aData = attentionNode.getData();
                            aData.X = ax;
                            aData.Y = ay;
                            attentionNode.setPosition({x: ax, y: ay});
                            attentionNode.setLabelPosition({x: ax, y: ay + dl.ICON_SIZE + 2});
                            ax += dl.ICON_SIZE + 28;
                        }
                        hasAttention = true;
                    }
                    if (direction === 0)
                        startX += dl.ICON_SIZE * 2;
                    else
                        startX -= dl.ICON_SIZE * 2;
                    if (startX > maxX) {
                        direction = 1;
                        if (!dl.isNullOrEmpty(nodeData.attentions))
                            startX -= dl.ICON_SIZE * 3;
                        else
                            startX -= dl.ICON_SIZE * 2;
                        if (hasAttention) {
                            startY += dl.ICON_SIZE * 4 + 28;
                        } else {
                            startY += dl.ICON_SIZE * 2 + 28;
                        }
                        hasAttention = false;
                    }
                    if (startX < 10) {
                        direction = 0;
                        if (!dl.isNullOrEmpty(nodeData.attentions))
                            startX += dl.ICON_SIZE * 3;
                        else
                            startX += dl.ICON_SIZE * 2;

                        if (hasAttention) {
                            startY += dl.ICON_SIZE * 4 + 28;
                        } else {
                            startY += dl.ICON_SIZE * 2 + 28;
                        }
                        hasAttention = false;
                    }
                }
                for (var i = 0; i < context.getLinkCount(); i++) {
                    var link = context.getLinkByIndex(i);
                    var node1 = context.getNodeById(link.getData().startNode);
                    var node2 = context.getNodeById(link.getData().endNode);
                    var startPoint = dl.getNextConnectPoint(node1.getData(), node2.getData());
                    var endPoint = dl.getPreviousConnectPoint(node2.getData(), node1.getData());
                    var res = [];
                    res.push('M');
                    res.push(startPoint.x);
                    res.push(startPoint.y);
                    res.push('L');
                    res.push(endPoint.x);
                    res.push(endPoint.y);
                    link.setPoints(res);
                }
            };

            dl.generateDiagramData = function (processInfo) {
                var diagramData = {};
                var processInstance = processInfo['processInstance'];
                var activities = processInstance['activities'];
                var nodes = [];
                var attentionNodes = [];
                for (var i = 0; i < activities.length; i++) {
                    var node = dl.generateActivityNode(activities[i]);
                    nodes.push(node);
                    var attentionNodes = dl.generateAttentionNodes(activities[i]);
                    if (attentionNodes.length > 0) {
                        node.attentions = attentionNodes;
                    }
                }
                var links = [];
                for (var i = 1; i < nodes.length; i++) {
                    links.push(dl.generateActivityLink(nodes[i - 1], nodes[i]));
                    if (dl.isNullOrEmpty(nodes[i].attentions))
                        continue;
                    for (var j = 0; j < nodes[i].attentions.length; j++)
                        links.push(dl.generateAttentionLink(nodes[i], nodes[i].attentions[j]));
                }
                for (var i = 0; i < nodes.length; i++) {
                    if (dl.isNullOrEmpty(nodes[i].attentions))
                        continue;
                    for (var j = 0; j < nodes[i].attentions.length; j++) {
                        nodes.push(nodes[i].attentions[j]);
                    }
                }
                diagramData.nodes = nodes;
                diagramData.links = links;
                return diagramData;
            };

            dl.generateAttentionLink = function (node1, node2) {
                var link = {};
                link.id = 'AL' + node1.id.substring(1) + node2.id.substring(1);
                link.startNode = node1.id;
                link.endNode = node2.id;
                link.style = 'dot';
                return link;
            };

            dl.generateActivityLink = function (node1, node2) {
                var link = {};
                link.id = 'L' + node1.id.substring(1) + node2.id.substring(1);
                link.startNode = node1.id;
                link.endNode = node2.id;
                return link;
            };


            dl.generateAttentionNodes = function (a) {
                var nodes = [];
                var attentions = a['attentions'];
                if (!dl.isNullOrUndefined(attentions) && attentions.length > 0) {
                    for (var i = 0; i < attentions.length; i++) {
                        var b = attentions[i];
                        var node = {};
                        var attentionId = b[dl.ACTIVITY_ATTENTION_ID];
                        node.id = 'A' + attentionId;
                        var status = a[dl.ACTIVITY_STATUS];
                        node.icon = {};
                        if (status === 1) {
                            node.icon.source = dl.ICON_ATTENTION_ACTIVE;
                        } else {
                            node.icon.source = dl.ICON_ATTENTION_NORMAL;
                        }
                        node.icon.source = dl.ICON_PROFIX + node.icon.source;
                        var employeeId = b[dl.EMPLOYEE_ID];
                        var businessName = b[dl.BUSINESS_NAME];
                        node.label = '知会人: ' + dl.generateEmployeeName(employeeId, businessName);
                        node.shortDesc = '';
                        nodes.push(node);
                    }
                }
                return nodes;
            };

            dl.generateActivityNode = function (a) {
                var node = {};
                var activityId = a[dl.ACTIVITY_ID];
                node.id = 'N' + activityId;
                var activityType = a[dl.ACTIVITY_TYPE];
                var status = a[dl.ACTIVITY_STATUS];

                node.icon = {};
                if (status === 1) {
                    switch (activityType) {
                        case 0:
                            node.icon.source = dl.ICON_START;
                            break;
                        case 1:
                            node.icon.source = dl.ICON_END;
                            break;
                        case 2:
                            node.icon.source = dl.ICON_APPROVAL_ACTIVE;
                            break;
                        case 3:
                            node.icon.source = dl.ICON_PROCESS_ACTIVE;
                            break;
                        case 4:
                            node.icon.source = dl.ICON_ATTENTION_ACTIVE;
                            break;
                        default:
                            node.icon.source = dl.ICON_APPROVAL_ACTIVE;
                            break;
                    }
                } else {
                    switch (activityType) {
                        case 0:
                            node.icon.source = dl.ICON_START;
                            break;
                        case 1:
                            node.icon.source = dl.ICON_END;
                            break;
                        case 2:
                            node.icon.source = dl.ICON_APPROVAL_NORMAL;
                            break;
                        case 3:
                            node.icon.source = dl.ICON_PROCESS_NORMAL;
                            break;
                        case 4:
                            node.icon.source = dl.ICON_ATTENTION_NORMAL;
                            break;
                        default:
                            node.icon.source = dl.ICON_APPROVAL_NORMAL;
                            break;
                    }
                }
                node.icon.source = dl.ICON_PROFIX + node.icon.source;
                var employeeId = a[dl.EMPLOYEE_ID];
                var businessName = a[dl.BUSINESS_NAME];
                node.label = dl.generateEmployeeName(employeeId, businessName);
                if (dl.isNullOrUndefined(node.label))
                    node.label = '';
                if (activityType === 0)
                    node.label = '申请人: ' + node.label;
                else if (activityType === 1)
                    node.label = '';
                else
                    node.label = node.label + ' ' + dl.generateActivityStatusLable(activityType, status);
                node.shortDesc = dl.generateProcessNodeComment(a);
                return node;
            };

            dl.generateEmployeeName = function (employeeId, businessName) {
                if (dl.isNullOrEmpty(employeeId) || employeeId == 0) {
                    return businessName;
                } else {
                    var employeeName = dl.getLabelByValue('employees', employeeId);
                    if (dl.isNullOrEmpty(employeeName))
                        return businessName;
                    else
                        return employeeName;
                }
            };

            dl.generateActivityStatusLable = function (at, as) {
                switch (at) {
                    case 0:
                        return "申请人";
                    case 1:
                        return "";
                    case 2:
                    case 3:
                    switch (as) {
                        case 2:
                            return "通过";
                        case 3:
                            return "驳回";
                        case 5:
                            return "回退";
                        case 6:
                            return "转交";
                        default:
                            return "";
                    }
                }
                return "";
            };

            dl.generateProcessNodeComment = function (a) {
                var sb = new dl.StringBuilder();
                var startTime = dl.parseValueFromService(a['instanceActivityStartTime']);
                if (!dl.isNullOrEmpty(startTime)) {
                    sb.append("开始时间：");
                    sb.append(dl.datetimeConverter.format(startTime));
                    sb.append(' ');
                }
                var operateTime = dl.parseValueFromService(a['operateTime']);
                if (!dl.isNullOrEmpty(operateTime)) {
                    sb.append("处理时间：");
                    sb.append(dl.datetimeConverter.format(operateTime));
                    sb.append(' ');
                }
                var attentions = a['attentions'];
                var tasks = a['tasks'];
                var poolType = a['poolType'];
                if (dl.isNullOrUndefined(poolType))
                    poolType = 0;
                if (!dl.isNullOrUndefined(attentions) && attentions.length > 0) {
                    sb.append("知会人：");
                    for (var i = 0; i < attentions.length; i++) {
                        if (i > 0)
                            sb.append(",");
                        sb.append(dl.generateEmployeeName(attentions[i][dl.EMPLOYEE_ID], ''));
                    }
                    sb.append(' ');
                }
                if (!dl.isNullOrUndefined(tasks) && tasks.length > 0) {
                    if (poolType == 0) {
                        sb.append("本流程将由：");
                        for (var i = 0; i < tasks.length; i++) {
                            if (i > 0)
                                sb.append(",");
                            sb.append(dl.generateEmployeeName(tasks[i][dl.EMPLOYEE_ID], ''));
                        }
                        sb.append(" 任意一人来处理 ");
                    } else {
                        sb.append("本流程将由：");
                        for (var i = 0; i < tasks.length; i++) {
                            if (i > 0)
                                sb.append(",");
                            sb.append(dl.generateEmployeeName(tasks[i][dl.EMPLOYEE_ID], ''));
                        }
                        sb.append(" 都同意才算通过，目前：");
                        for (var i = 0; i < tasks.length; i++) {
                            if (i > 0)
                                sb.append(",");
                            sb.append(dl.generateEmployeeName(tasks[i][dl.EMPLOYEE_ID], ''));
                            sb.append(" ");
                            sb.append(tasks[i]['status'] === 2 ? "通过" : "未通过");
                        }
                        sb.append(' ');
                    }
                }
                var comment = a["processComment"];
                if (!dl.isNullOrEmpty(comment)) {
                    sb.append("处理意见：");
                    sb.append(comment);
                    sb.append(' ');
                }
                return sb.toString();
            };

            dl.getNextConnectPoint = function (node1, node2) {
                if (dl.isNullOrUndefined(node2)) {
                    return {x: node1.X + dl.ICON_SIZE, y: node1.Y + dl.ICON_SIZE / 2};
                } else {
                    var px1 = node1.X, py1 = node1.Y;
                    var px2 = px1 + dl.ICON_SIZE, py2 = py1 + dl.ICON_SIZE;
                    var pcx1 = (px1 + px2) / 2, pcy1 = (py1 + py2) / 2;
                    var nx1 = node2.X, ny1 = node2.Y;
                    var nx2 = nx1 + dl.ICON_SIZE, ny2 = ny1 + dl.ICON_SIZE;
                    var ncx1 = (nx1 + nx2) / 2, ncy1 = (ny1 + ny2) / 2;
                    var dx1 = Math.abs(nx1 - pcx1);
                    var dy1 = Math.abs(ny1 - pcy1);
                    var miny1 = pcy1 - dx1;
                    var maxy1 = pcy1 + dx1;
                    var minx1 = pcx1 - dy1;
                    var maxx1 = pcx1 + dy1;
                    if (nx1 > px2 && ny1 >= miny1 && ny1 <= maxy1) {
                        return {x: px2, y: pcy1};
                    } else if (px1 > nx2 && ny1 >= miny1 && ny1 <= maxy1) {
                        return {x: px1, y: pcy1};
                    } else if (ny1 > py2 && nx1 >= minx1 && nx1 <= maxx1) {
                        return {x: pcx1, y: py2};
                    } else {
                        return {x: pcx1, y: py1};
                    }
                }
            };

            dl.getPreviousConnectPoint = function (node1, node2) {
                if (dl.isNullOrUndefined(node2)) {
                    return {x: node1.X, y: node1.Y + dl.ICON_SIZE / 2};
                } else {
                    var px1 = node1.X, py1 = node1.Y;
                    var px2 = px1 + dl.ICON_SIZE, py2 = py1 + dl.ICON_SIZE;
                    var pcx1 = (px1 + px2) / 2, pcy1 = (py1 + py2) / 2;
                    var nx1 = node2.X, ny1 = node2.Y;
                    var nx2 = nx1 + dl.ICON_SIZE, ny2 = ny1 + dl.ICON_SIZE;
                    var ncx1 = (nx1 + nx2) / 2, ncy1 = (ny1 + ny2) / 2;
                    var dx1 = Math.abs(nx1 - pcx1);
                    var dy1 = Math.abs(ny1 - pcy1);
                    var miny1 = pcy1 - dx1;
                    var maxy1 = pcy1 + dx1;
                    var minx1 = pcx1 - dy1;
                    var maxx1 = pcx1 + dy1;
                    if (nx1 > px2 && ny1 >= miny1 && ny1 <= maxy1) {
                        return {x: px2 + dl.ARROW_SIZE, y: pcy1};
                    } else if (px1 > nx2 && ny1 >= miny1 && ny1 <= maxy1) {
                        return {x: px1 - dl.ARROW_SIZE, y: pcy1};
                    } else if (ny1 > py2 && nx1 >= minx1 && nx1 <= maxx1) {
                        return {x: pcx1, y: py2 + dl.ARROW_SIZE};
                    } else {
                        return {x: pcx1, y: py1 - dl.ARROW_SIZE};
                    }
                }
            };

            dl.createSVG = function (width, height) {
                var svg = document.createElementNS('http://www.w3.org/2000/svg', 'svg');
                svg.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:xlink", "http://www.w3.org/1999/xlink");
                svg.setAttributeNS(null, 'width', width);
                svg.setAttributeNS(null, 'height', height);
                svg.setAttributeNS(null, 'viewBox', "0 0 " + width + ' ' + height);
                return svg;
            };

            dl.addImage = function (p, url, x, y, w, h) {
                var image = document.createElementNS('http://www.w3.org/2000/svg', 'image');
                image.setAttributeNS('http://www.w3.org/1999/xlink', 'href', url);
                image.setAttributeNS(null, 'x', x);
                image.setAttributeNS(null, 'y', y);
                image.setAttributeNS(null, 'height', h);
                image.setAttributeNS(null, 'width', w);
                $(p).append(image);
                return image;
            };

            dl.addGroup = function (parent, id) {
                var group = document.createElementNS('http://www.w3.org/2000/svg', 'g');
                group.setAttributeNS(null, 'id', id);
                $(parent).append(group);
                return group;
            };

            dl.addText = function (parent, t) {
                var text = document.createElementNS('http://www.w3.org/2000/svg', 'text');
                text.innerHTML = t;
                $(parent).append(text);
                return text;
            };

            //知会一键阅读
            dl.attentionBatchReadWork = function (processType, self, id) {
                var currentEmployeeId;
                if (dl.isNullOrUndefined(id)) {
                    currentEmployeeId = dl.getEmployeeId();
                } else {
                    currentEmployeeId = id;
                }
                if (!dl.isNullOrUndefined(processType) && !dl.isNullOrUndefined(currentEmployeeId)) {
                    var condition = {
                        processType: processType,
                        employeeId: currentEmployeeId
                    };
                    dl.callOperation("EP_AttentionBatchProcessor", '', condition, self.batchReadCallback);
                }
            };

            //页面跳转
            //processType 流程类型
            dl.getProcessPageName = function (processType, activityType) {
                var pageName;
                if (!dl.isNullOrUndefined(processType) && !dl.isNullOrUndefined(activityType)) {
                    switch (Number(processType)) {
                        case 2://项目日常
                            pageName = "reimbursement/NormalReimbursementWithProject";
                            break;
                        case 3: //普通日常
                            pageName = "reimbursement/CommonNormalReimbursement";
                            break;
                        case 4: //项目差旅
                            pageName = "reimbursement/ProjectTravelReimbursement";
                            break;
                        case 5: //普通差旅
                            pageName = "reimbursement/CommonTravelReimbursement";
                            break;
                        case 6: //借款申请
                            pageName = "reimbursement/BorrowMoneyApplication";
                            break;
                        case 7: //预付款申请
                            pageName = "reimbursement/PrePaymentApplication";
                            break;
                        case 8: //前期项目日常报销
                            pageName = "reimbursement/PreProjectNormalReimbursement";
                            break;
                        case 9: //前期项目差旅报销
                            pageName = "reimbursement/PreProjectTravelReimbursement";
                            break;
//                        case 11: //回款分配
//                            pageName = "reimbursement/capitalDistributionsApply";
//                            break;
                        case 13: //请假申请
                            pageName = "personnel/leave/leaveApply";
                            break;
                        case 14: //非项目出差申请
                            pageName = "personnel/travel/travelApply";
                            break;
                        case 18: //项目出差申请
                            pageName = "personnel/travel/travelApply";
                            break;
                        case 15: //打卡申请
                            pageName = "personnel/fillcheck/fillcheckApply";
                            break;
                        case 16: //外出申请
                            pageName = "personnel/stayaway/stayawayApply";
                            break;
                        case 17: //加班申请
                            pageName = "personnel/overtime/overtimeApply";
                            break;
                        case 21: //项目派驻申请
                            pageName = "personnel/projectAccredit/projectAccreditApply";
                            break;
                        case 24: //入职申请
                            pageName = "personnel/entry/entryApply";
                            break;
                        case 25: //离职申请
                            pageName = "personnel/quit/quitApply";
                            break;
                        case 26: //转岗申请
                            pageName = "personnel/transfer/transferApply";
                            break;
                        case 28: //员工还款申请
                            pageName = "reimbursement/repayMoneyApply";
                            break;
                        case 29: //转正申请
                            pageName = "personnel/becomeFormalStaff/becomeFormalStaffApply";
                            break;
                        case 30: //调薪申请
                            pageName = "administration/SalaryAdjust/SalaryAdjustApply";
                            break;
                        case 31: //物品领用申请
                            pageName = "administration/goods/goodsApply";
                            break;
                        case 33: //用车申请
                            pageName = "administration/car/carApply";
                            break;
                        case 34: //名片申请
                            pageName = "administration/businessCard/businessCardApply";
                            break;
                        case 35: //刻章申请
                            pageName = "administration/stampCarving/stampCarvingApply";
                            break;
                        case 36: //采购申请
                            pageName = "administration/purchase/purchaseApply";
                            break;
                        case 37: //薪资发放申请
                            pageName = "administration/salaryReport/salaryReportApply";
                            break;
                        case 39: //成本调节
                            pageName = "operation_processor/costAdjustment/costAdjustmentApply";
                            break;
                        case 40: //网络权限申请
                            pageName = "personnel/networkAuthority/networkAuthorityApply";
                            break;
                        case 41: //外部公司还款申请
                            pageName = "personnel/outsideCompanyRepayments/outsideCompanyRepaymentsApply";
                            break;
                        case 42: //项目报备申请
                            pageName = "operation_processor/preProjects/preProjectsApply";
                            break;
                        case 43: //前期项目立项申请
                            pageName = "operation_processor/bePreProjects/bePreProjects";
                            break;
                        case 44: //前期项目关闭申请
                            pageName = "operation_processor/closePreProjects/closePreProjects";
                            break;
//                        case 45: //工资异常申请
//                            pageName = "personnel/abnormalWages/abnormalWagesApply";
//                            break;
                        case 52: //预算单立项
                            pageName = "reimbursement/BudgetManagementApply";
                            break;
                        case 53: //供应商入库
                            pageName = "operation_processor/SupplierComeIn/SupplierComeInApply";
                            break;
                        case 73: //落标申请
                            pageName = "operation_processor/failInAtender/failInAtenderApply";
                            break;
                        case 75: //报价单审核申请
                            pageName = "operation_processor/qutQuotation/qutQuotationApply";
                            break;
                        case 80: //经费结算申请
                            pageName = "operation_processor/projectSettlementProcess/projectSettlementProcessApply";
                            break;
                        case 76: //可分配阶段申请
                            pageName = "operation_processor/projectStagesProcess/projectStagesProcessApply";
                            break;
                        case 78: //我的出图
                            pageName = "myWork/outputDrawing/outputDrawingApply";
                            break;
                        case 79: //团队组建申请
                            pageName = "operation_processor/projectEmployeeProcess/projectEmployeeProcessApply";
                            break;
                        case 81: //配合申请
                            pageName = "myWork/cooperate/cooperateApply";
                            break;
                        case 82: //结算申请
                            pageName = "myWork/settlement/settlementApply";
                            break;
                                case 84: //我的工时
                            pageName = "personnel/workTime/workTimeApply";
                            break;
                    }
                }
                if (!dl.isNullOrUndefined(pageName) && Number(activityType) > 0) {
                    if (Number(activityType) === 1) {//列表页面
                        pageName += "List";
                    } else if (Number(activityType) === 2) {//审批页面
                        pageName += "View";
                    } else if (Number(activityType) === 3) {//处理页面
                        if (Number(processType) === 52) {
                            pageName += "Update";
                        } else {
                            pageName += "View";
                        }
                    } else if (Number(activityType) === 4) {//知会页面
                        pageName += "Attention";
                    }
                }
                return pageName;
            };
        }


);


