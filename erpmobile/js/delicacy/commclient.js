/* global dl */
"use strict";
define(['ojs/ojcore', 'knockout', 'jquery', 'dl/msgbox', 'jquery-cookie', 'ojs/ojmodel', 'ojs/ojknockout', 'ojs/ojvalidation-datetime', 'ojs/ojvalidation-number', 'ojs/ojrouter', 'ojs/ojmoduleanimations'],
        function (oj, ko, $, sc) {
            /**
             * @private
             */
            var __scope = {};
            if (typeof window !== 'undefined')
            {
                __scope = window;
            } else if (typeof self !== 'undefined')
            {
                __scope = self;
            }

            /**
             * @private
             */
            var __oldVal = __scope['dl'];
            var dl = __scope['dl'] =
                    {
                        'version': "0.0.1",
                        'build': "0",
                        'revision': "00000",
                        'noConflict': function ()
                        {
                            __scope['dl'] = __oldVal;
                        }
                    };
            dl._SERVERURL = "/DelicacyServlet";
            dl._UPLOADURL = "/FileUpload";
            dl._LOCALURL = "http://127.0.0.1:6137/DelicacyServlet";
            dl._JSONPSERVER = "http://127.0.0.1:6137/DelicacyServlet";
            dl._KEYVALUEMANAGERSERICE = "NQ_DomainValue";
            dl._GLOBALDOMAINNAME = "DomainValue_JD";
            dl._USERINFO = "USERINFO";
            dl._DOMAINUPDATETIME = "DOMAINUPDATETIME";
            // Detail Page Type - 0 - Add 
            dl._DETAILTYPE_ADD = 0;
            // Detail Page Type - 1 - Update 
            dl._DETAILTYPE_UPDATE = 1;
            // Detail Page Type - 2 - Table 
            dl._DETAILTYPE_TABLE = 2;
            // 全局变量，用来保存换存在客户端的所有下拉数据选项
            dl._KEYVALUE = {};
            // 全局变量，部门树
            dl._DEPARTMENTTREE = {};
            // Media queries for repsonsive layouts
            dl.mQuery = oj.ResponsiveUtils.getFrameworkQuery(oj.ResponsiveUtils.FRAMEWORK_QUERY_KEY.SM_ONLY);
            dl.smScreen = oj.ResponsiveKnockoutUtils.createMediaQueryObservable(dl.mQuery);
            dl.mdQuery = oj.ResponsiveUtils.getFrameworkQuery(oj.ResponsiveUtils.FRAMEWORK_QUERY_KEY.MD_ONLY);
            dl.mdScreen = oj.ResponsiveKnockoutUtils.createMediaQueryObservable(dl.mdQuery);
            dl.lgQuery = oj.ResponsiveUtils.getFrameworkQuery(oj.ResponsiveUtils.FRAMEWORK_QUERY_KEY.LG_UP);
            dl.lgScreen = oj.ResponsiveKnockoutUtils.createMediaQueryObservable(dl.lgQuery);
            dl._OPRERATORID = 'OPRERATORID';//员工ID  cookie名称
            dl._OPRERATORDEPARTMENTID = "OPRERATORDEPARTMENTID";
            dl._OPRERATORNO = "OPRERATORNNO";
            dl._OPRERATORNAME = "OPRERATORNAME";
            dl._OPRERATORPLATEID = "OPRERATORPLATEID";
            dl._OPRERATORROLETYPEID = "OPRERATORROLETYPEID";
            dl._APPLICATIONID = "APPLICATIONID";
            dl._COMPANYID = "COMPANYID";
            dl._COMPANYNO = "COMPANYNO";
            dl._HEADIMG = "HEADIMG";
            dl._FUNCTIONLIST = "FUNCTIONLIST";
            dl._KO_HEAD_IMG = ko.observable();
            dl._LOADSELECTIONDONE = ko.observable(false);
            dl._LOCAL_FILE_SERVICE = "LocalFileService";
            dl._IS_PC = "isPC";
            dl._HAVE_WORKSPACE = "haveWorkspace";
            //全局变量 数据监听显示
            dl._WORKFLOW_CHANGE_LISTENER = ko.observable(false);
            //个人设置中心数据监听，该值变动，则刷新个人设置中心的数据
            dl._PERSONAL_SETTING_CHANGE_LISTENER = ko.observable(false);
            //文件同步进度的worker是否启动
            dl._START_FILE_SYNCH_PROGRESS_WORKER = ko.observable(false);
            //           listView下拉数据
            dl.fetchSize = 20;
            // 文件同步状态监听
            dl._FILE_SYNCH_PROGRESS_STATUS_LISTENER = ko.observable(0);


            dl.moduleAnimation = function () {
                return oj.ModuleAnimations["coverStart"];
            };

            dl.isLogin = function () {
                if (dl.isNullOrUndefined(dl.getCookie(dl._OPRERATORID)) || dl.isNullOrUndefined(dl.getCookie(dl._OPRERATORDEPARTMENTID))) {
                    //当从cookie里面没有找到用户数据时从localStorage中找到且设置到cookie中
                    dl.cpUserInfoFromLsToCookie();
                    //如果从localStorage中也没有找到数据则表示为没有登录
                    if (dl.isNullOrUndefined(dl.getCookie(dl._OPRERATORID)) || dl.isNullOrUndefined(dl.getCookie(dl._OPRERATORDEPARTMENTID))) {
                        return false;
                    } else {
                        return true;
                    }
                } else {
                    return true;
                }
            };

            dl.checkIsWechat = function () {
                var ua = navigator.userAgent.toLowerCase();
                if (ua.match(/MicroMessenger/i) == "micromessenger") {
                    return true;
                } else {
                    return false;
                }
            };

            dl.redirectLogout = function () {
                var storage = localStorage;
                storage.removeItem(dl._USERINFO);
                dl.delCookie(dl._OPRERATORID);
                dl.delCookie(dl._OPRERATORDEPARTMENTID);
                dl.delCookie(dl._COMPANYID);
                dl.delCookie(dl._COMPANYNO);
                dl.delCookie(dl._OPRERATORPLATEID);
                dl.delCookie(dl._OPRERATORNO);
                dl.delCookie(dl._OPRERATORNAME);
                dl.delCookie(dl._HEADIMG);
                dl.delCookie(dl._COMPANYNO);
                if (dl.isPC()) {
                    if (dl.checkIsWechat()) {
                        dl.getGlobalModule({name: 'login', params: '', cacheKey: 'login'});
                    } else {
                        window.location.href = "login.html";
                    }
                } else {
                    if (dl.checkIsWechat()) {
                        dl.getGlobalModule({name: 'login', params: '', cacheKey: 'login'});
                    }
                }
            };

            //获取定义登陆员工信息
            dl.getEmployeeId = function () {
                if (dl.isNullOrUndefined(dl.getCookie(dl._OPRERATORID))) {
                    dl.redirectLogout();
                    return null;
                } else {
                    return Number(dl.getCookie(dl._OPRERATORID));
                }
            };

            dl.getEmployeeNo = function () {
                if (dl.isNullOrUndefined(dl.getCookie(dl._OPRERATORNO))) {
                    dl.redirectLogout();
                    return null;
                } else {
                    return dl.getCookie(dl._OPRERATORNO);
                }
            };

            dl.getEmployeeName = function () {
                if (dl.isNullOrUndefined(dl.getCookie(dl._OPRERATORNAME))) {
                    dl.redirectLogout();
                    return null;
                } else {
                    return decodeURIComponent(dl.getCookie(dl._OPRERATORNAME));
                }
            };

            dl.getDepartmentId = function () {
                if (dl.isNullOrUndefined(dl.getCookie(dl._OPRERATORDEPARTMENTID))) {
                    dl.redirectLogout();
                    return null;
                } else {
                    return Number(dl.getCookie(dl._OPRERATORDEPARTMENTID));
                }
            };
            dl.getCompanyId = function () {
                if (dl.isNullOrUndefined(dl.getCookie(dl._COMPANYID))) {
                    dl.redirectLogout();
                    return null;
                } else {
                    return Number(dl.getCookie(dl._COMPANYID));
                }
            };

            dl.getCompanyNo = function () {
                if (dl.isNullOrUndefined(dl.getCookie(dl._COMPANYNO))) {
                    return null;
                } else {
                    return parseInt(dl.getCookie(dl._COMPANYNO));
                }
            };

            dl.getPlateId = function () {
                if (dl.isNullOrUndefined(dl.getCookie(dl._OPRERATORPLATEID))) {
                    dl.redirectLogout();
                    return null;
                } else {
                    return Number(dl.getCookie(dl._OPRERATORPLATEID));
                }
            };

            dl.getHeadImg = function () {
                var headImg = dl.getCookie(dl._HEADIMG);
                if (!dl.isNullOrUndefined(headImg)) {
                    dl._KO_HEAD_IMG(headImg);
                    return dl._KO_HEAD_IMG();
                } else {
                    return "images/morenImg.jpeg";
                }
            };

            dl.setHeadImg = function (headImg) {
                dl._KO_HEAD_IMG(headImg);
                return dl._KO_HEAD_IMG();
            };

            dl.getPhoto = function (imgPath) {
                if (dl.isNullOrUndefined(imgPath)) {
                    return "images/morenImg.jpeg";
                } else {
                    return "https://erp.jaid.cn" + imgPath;
                }
            };

            dl.setEmployeeId = function (val) {
                dl.setCookie(dl._OPRERATORID, val);
            };

            dl.cpUserInfoFromLsToCookie = function () {
                var storage = localStorage;
                if (storage) {
                    var userInfo = storage.getItem(dl._USERINFO);
                    if (!dl.isNullOrUndefined(userInfo)) {
                        userInfo = JSON.parse(userInfo);
                        dl.setUserInfo(userInfo);
                    }
                }
            };

            dl.setUserInfoToLocalStorage = function (userInfo) {
                var storage = localStorage;
                if (!dl.isNullOrUndefined(userInfo)) {
                    storage.setItem(dl._USERINFO, JSON.stringify(userInfo));
                }
            };

            dl.setUserInfo = function (userInfo) {
                if (!dl.isNullOrUndefined(userInfo.employeeId)) {
                    dl.setCookie(dl._OPRERATORID, userInfo.employeeId);
                }
                if (!dl.isNullOrUndefined(userInfo.departmentId)) {
                    dl.setCookie(dl._OPRERATORDEPARTMENTID, userInfo.departmentId);
                }
                if (!dl.isNullOrUndefined(userInfo.companyId)) {
                    dl.setCookie(dl._COMPANYID, userInfo.companyId);
                }
                if (!dl.isNullOrUndefined(userInfo.companyNo)) {
                    dl.setCookie(dl._COMPANYNO, userInfo.companyNo);
                }
                if (!dl.isNullOrUndefined(userInfo.plateId)) {
                    dl.setCookie(dl._OPRERATORPLATEID, userInfo.plateId);
                }
                if (!dl.isNullOrUndefined(userInfo.employeeNo)) {
                    dl.setCookie(dl._OPRERATORNO, userInfo.employeeNo);
                }
                if (!dl.isNullOrUndefined(userInfo.employeeName)) {
                    dl.setCookie(dl._OPRERATORNAME, userInfo.employeeName);
                }
                if (!dl.isNullOrUndefined(userInfo.photo)) {
                    dl.setCookie(dl._HEADIMG, userInfo.photo);
                }
                if (!dl.isNullOrUndefined(userInfo.functions)) {
                    window.localStorage.setItem(dl._FUNCTIONLIST, userInfo.functions);
                }
            };

            dl.checkIsHavePermission = function (functionCode) {
                var codeStr = window.localStorage.getItem(dl._FUNCTIONLIST);
                if (dl.isNullOrEmpty(codeStr)) {
                    return false;
                }
                var codeArr = codeStr.split(",");
                for (var i = 0; i < codeArr.length; i++) {
                    if (codeArr[i] === functionCode) {
                        return true;
                    }
                }
                return false;
            };

            dl.logout = function () {
                sc.confirm("确定退出登录?", function () {
                    var storage = localStorage;
                    storage.removeItem(dl._USERINFO);
                    dl.delCookie(dl._OPRERATORID);
                    dl.delCookie(dl._OPRERATORDEPARTMENTID);
                    dl.delCookie(dl._COMPANYID);
                    dl.delCookie(dl._COMPANYNO);
                    dl.delCookie(dl._OPRERATORPLATEID);
                    dl.delCookie(dl._OPRERATORNO);
                    dl.delCookie(dl._OPRERATORNAME);
                    dl.delCookie(dl._HEADIMG);
                    dl.delCookie(dl._COMPANYNO);
                    window.location.href = "login.html";
                });
            };
            dl.mobileLogout = function () {
                sc.confirm("确定退出登录吗?", function () {
                    var storage = localStorage;
                    storage.removeItem(dl._USERINFO);
                    dl.delCookie(dl._OPRERATORID);
                    dl.delCookie(dl._OPRERATORDEPARTMENTID);
                    dl.delCookie(dl._COMPANYID);
                    dl.delCookie(dl._COMPANYNO);
                    dl.delCookie(dl._OPRERATORPLATEID);
                    dl.delCookie(dl._OPRERATORNO);
                    dl.delCookie(dl._OPRERATORNAME);
                    dl.delCookie(dl._HEADIMG);
                    dl.delCookie(dl._COMPANYNO);
                    dl.getGlobalModule({'name': 'login'});
                });
            };
            dl.isPC = function () {
                var storage = window.localStorage;
                var flag = storage.getItem(dl._IS_PC);
                if (null !== flag)
                    return flag;
                var userAgentInfo = navigator.userAgent;
                var Agents = ["Android", "iPhone",
                    "SymbianOS", "Windows Phone",
                    "iPad", "iPod"];
                var flag = true;
                for (var v = 0; v < Agents.length; v++) {
                    if (userAgentInfo.indexOf(Agents[v]) > 0) {
                        flag = false;
                        break;
                    }
                }
                storage.setItem(dl._IS_PC, flag);
                return flag;
            };

            dl.isWindows = function () {
                if (navigator.platform.indexOf("Win") === 0)
                    return true;
                return false;
            };

            /*
             * 全局数据交换
             */
            dl._EXCHANGEDDATA = [];
            dl._GLOBALMODULEDATA = [];
//            保存路径的数组
            dl._PAGESTACK = [];
            dl._HEADERSTACK = [];
//           入栈page
            dl.pushPageStack = function (val) {
                dl._PAGESTACK.push(val);
            };
//             出栈
            dl.popPageStack = function () {
                return dl._PAGESTACK.pop();
            };
//           入栈 header
            dl.pushHeader = function (val) {
                dl._HEADERSTACK.push(val);
            };
//             出栈
            dl.popHeader = function () {
                return dl._HEADERSTACK.pop();
            };

            dl.setCookie = function (name, value) {
                $.cookie(name, value, {expires: 30, path: '/'});
            };

            dl.delCookie = function (name) {
                $.cookie(name, '', {expires: -1});
            };

            dl.getCookie = function (name) {
                return $.cookie(name);
            };

            dl.hasNamedData = function (name) {
                for (var i = 0; i < dl._EXCHANGEDDATA.length; i++) {
                    var o = dl._EXCHANGEDDATA[i];
                    if (o.name === name)
                        return true;
                }
                return false;
            };

            dl.getNamedData = function (name) {
                for (var i = 0; i < dl._EXCHANGEDDATA.length; i++) {
                    var o = dl._EXCHANGEDDATA[i];
                    if (o.name === name)
                        return o;
                }
                return null;
            };

            dl.getNamedSelectedData = function (name) {
                for (var i = 0; i < dl._EXCHANGEDDATA.length; i++) {
                    var o = dl._EXCHANGEDDATA[i];
                    if (o.name === name)
                        return o.selectedItem;
                }
                return null;
            };

            dl.putSelectedItem = function (name, selectedItem) {
                var o = dl.getNamedData(name);
                if (dl.isNullOrUndefined(o)) {
                    o = {};
                    o['name'] = name;
                    dl._EXCHANGEDDATA.push(o);
                }
                o['selectedItem'] = selectedItem;
            };

            dl.putNewCreatedData = function (name, newCreatedData) {
                var o = dl.getNamedData(name);
                if (dl.isNullOrUndefined(o)) {
                    o = {};
                    o['name'] = name;
                    dl._EXCHANGEDDATA.push(o);
                }
                if (dl.isNullOrUndefined(o['newCreatedData']))
                    o['newCreatedData'] = {};
                dl.copyProperties(newCreatedData, o['newCreatedData']);
                o['lastOperation'] = 'new';
            };

            dl.putUpdatedData = function (name, updatedData) {
                var o = dl.getNamedData(name);
                if (dl.isNullOrUndefined(o)) {
                    o = {};
                    o['name'] = name;
                    dl._EXCHANGEDDATA.push(o);
                }
                if (dl.isNullOrUndefined(o['updatedData']))
                    o['updatedData'] = {};
                dl.copyProperties(updatedData, o['updatedData']);
                o['lastOperation'] = 'update';
            };

            dl.isDataNewCreated = function (name) {
                var o = dl.getNamedData(name);
                if (dl.isNullOrUndefined(o)) {
                    return false;
                } else {
                    var lastOperation = o['lastOperation'];
                    if (dl.isNullOrUndefined(lastOperation))
                        return false;
                    if (lastOperation === 'new')
                        return true;
                    else
                        return false;
                }
            };

            dl.isDataUpdated = function (name) {
                var o = dl.getNamedData(name);
                if (dl.isNullOrUndefined(o)) {
                    return false;
                } else {
                    var lastOperation = o['lastOperation'];
                    if (dl.isNullOrUndefined(lastOperation))
                        return false;
                    if (lastOperation === 'update')
                        return true;
                    else
                        return false;
                }
            };

            /**
             * 发起申请流程
             * @param {type} instanceData 当前节点数据详情数据
             * @param {type} self
             * @returns {undefined}
             */
            dl.submitNewCreatWork = function (instanceData, self) {
                var par = instanceData;
                par.userData = self.getValues();
                if (!self.checkData(par.userData)) {
                    return;
                }
                var actionTmp = "EP_NewCreateWorkFlow";
                dl.callOperation(actionTmp, '', par, self.workCallback);
            };

            /**
             * 审批流程的方法
             * @param {type} approvalment 审批结果   0:同意 1:驳回 2:回退 3:转交
             * @param {type} instanceData 当前节点数据详情数据
             * @param {type} self  
             * @param {type} processComment  审批意见
             * @param {type} additionalApprovalment 转交人
             * @returns {undefined}
             */
            dl.submitApprovalWork = function (approvalment, instanceData, self, processComment, additionalApprovalment) {
                var par = instanceData;
                if (Number(approvalment) === 3) {
                    if (dl.isNullOrUndefined(additionalApprovalment)) { //转交人
//                        sc.alert("请添加审批人");
                        return;
                    }
                    par.additionalApprovalment = additionalApprovalment;
                }
                //par 当前节点数据详情数据
                par.userData = self.getValues();
                par.approvalment = approvalment;
                if (!dl.isNullOrUndefined(processComment)) {
                    par.processComment = processComment;
                }
                if (instanceData.activityType === 3 || instanceData.activityType === 4) {//处理节点
                    if (!self.checkData(par.userData)) {
                        return;
                    }
                } else if (instanceData.activityType === 2) {//审批节点
                }
//               把页面信息提交后台
                //任务池与单节点提交方法区别
                var actionTmp = 'EP_WorkFlowActivityProcessor';
                if (!dl.isNullOrUndefined(instanceData['processPooledTaskId']) && instanceData['processPooledTaskId'] > 0) {
                    actionTmp = "EP_WorkFlowPooledTaskProcessor";
                } else if (!dl.isNullOrUndefined(instanceData['systemProcessAttentionId']) && instanceData['systemProcessAttentionId'] > 0) {
                    actionTmp = "EP_AttentionProcessor";
                } else if (!dl.isNullOrUndefined(instanceData['systemProcessApplyId']) && instanceData['systemProcessApplyId'] > 0) {
                    actionTmp = "EP_NewCreateWorkFlow";
                }

                dl.callOperation(actionTmp, '', par, self.workCallback);
            };

            // 用于oj.Model和oj.Collection底层后台服务通讯
            oj.sync = function (method, collection, options) {
                if (collection.beforeAjax && typeof collection.beforeAjax === 'function') {
                    collection.beforeAjax(options);
                }
                $.ajax({url: dl.isNullOrUndefined(collection.url) ? dl._SERVERURL : collection.url,
                    // The name of the callback parameter, as specified by the YQL service
//                    jsonp: "callback",
                    // Tell jQuery we're expecting JSONP
                    dataType: "json",
                    type: "POST",
                    data: {action: collection.queryAction,
                        subaction: dl.getSubaction(method),
                        content: dl.packageCondition(collection, options),
                        currentPage: dl.calculateCurrentPage(options),
                        pageSize: options.fetchSize
                    },
                    success: function (resp) {
                        if (collection.afterAjax && typeof collection.afterAjax === 'function') {
                            collection.afterAjax(resp);
                        }
//                        resp = decodeURIComponent(resp);
//                        var jsono = JSON.parse(resp);
                        var jsono = resp;
                        if (jsono.ResultSet.status === 0)
                            options['success'](jsono);
                        else
                            options['error'](this, 500, jsono.ResultSet.errors);
                    }
                });
            };
            dl.errorProcess = function (xhr, status, error) {
                console.log(error);
            };

            // 执行通用的后台数据服务调用
            // operationName: 后台服务名
            // subaction: 主要用于单表操作的类型，find -- 查询， save -- 新建， update -- 修改， delete -- 删除
            // data: 发往后台的数据
            // callback: 操作完成后的数据处理程序
            // observableVar：操作完成后需要设置的Knockout变量
            dl.callOperation = function (operationName, subaction, data, callback, observableVar) {
                if (subaction === null || subaction === undefined || subaction === '') {
                    subaction = 'find';
                }
                var sendData = {action: operationName, subaction: subaction};
                if (data === null || data === undefined) {
                    data = {};
                }
                sendData.content = encodeURIComponent(JSON.stringify(data));
                $.ajax({url: dl._SERVERURL,
//                    jsonp: "callback",
                    // Tell jQuery we're expecting JSONP
                    dataType: "json",
                    type: "POST",
                    data: sendData,
                    success: function (resp) {
//                        resp = decodeURIComponent(resp);
//                        var jsono = JSON.parse(resp);
                        var jsono = resp;
                        callback(jsono, observableVar);
                    }
                });
            };

            dl.callSyncOperation = function (operationName, subaction, data, callback, observableVar) {
                if (subaction === null || subaction === undefined || subaction === '') {
                    subaction = 'find';
                }
                var sendData = {action: operationName, subaction: subaction};
                if (data === null || data === undefined) {
                    data = {};
                }
                sendData.content = encodeURIComponent(JSON.stringify(data));
                $.ajax({url: dl._SERVERURL,
                    async: false,
                    dataType: "json",
                    type: "POST",
                    data: sendData,
                    success: function (resp) {
                        resp = decodeURIComponent(resp);
//                        var jsono = JSON.parse(resp);
                        var jsono = resp;
                        callback(jsono, observableVar);
                    }
                });
            };

            dl.callSpecifiedJSONP = function (urlAddress, operationName,
                    subaction, data, callback, observableVar) {
                if (dl.isNullOrEmpty(subaction)) {
                    subaction = 'find';
                }
                var sendData = {
                    action: operationName,
                    subaction: subaction
                };
                if (dl.isNullOrUndefined(data)) {
                    data = {};
                }
                sendData.content = encodeURIComponent(JSON.stringify(data));
                $.ajax({
                    url: urlAddress,
                    jsonp: "callback",
                    dataType: "jsonp",
                    data: sendData,
                    success: function (resp) {
                        resp = decodeURIComponent(resp.replace(/\+/g, " "));
                        resp = JSON.parse(resp);
                        callback(resp, observableVar);
                    }
                });
            };

            dl.callJSONPSuccessProcessor = function (resp, callback,
                    observableVar) {
                resp = decodeURIComponent(resp.replace(/\+/g, " "));
                var s = "";
                for (var i = 0; i < resp.length; i++) {
                    if (resp[i] === '\n' || resp[i] === '\\')
                        continue;
                    s += resp[i];
                }
                var jsono = JSON.parse(resp);
                callback(jsono, observableVar);
            };

            dl.callJSONP = function (operationName, subaction, data, callback,
                    observableVar) {
                if (dl.isNullOrEmpty(subaction)) {
                    subaction = 'find';
                }
                var sendData = {
                    action: operationName,
                    subaction: subaction
                };
                if (dl.isNullOrUndefined(data)) {
                    data = {};
                }
                sendData.content = encodeURIComponent(JSON.stringify(data));
                $.ajax({
                    url: dl._JSONPSERVER,
                    jsonp: "callback",
                    dataType: "jsonp",
                    data: sendData,
                    success: function (resp) {
                        console.log(operationName + ' ' + resp.length);
                        dl.callJSONPSuccessProcessor(resp, callback,
                                observableVar);
                    }
                });
            };

            dl.callJSONPWithError = function (operationName, subaction, data, callback, errorProcess) {
                if (dl.isNullOrEmpty(subaction)) {
                    subaction = 'find';
                }
                var sendData = {
                    action: operationName,
                    subaction: subaction
                };
                if (dl.isNullOrUndefined(data)) {
                    data = {};
                }
                sendData.content = encodeURIComponent(JSON.stringify(data));
                $.ajax({
                    type: "GET",
                    url: dl._JSONPSERVER,
                    jsonp: "callback",
                    dataType: "jsonp",
                    data: sendData,
                    timeout: 50000,
                    cache: false,
                    success: function (resp, statusText, xhr) {
                        console.log(operationName + ' ' + resp.length);
                        dl.jsonpResponseProcess(resp, callback);
                    },
                    error: function (xhr, setting, errorMessage) {
                        errorProcess(xhr, setting, errorMessage);
                    }
                });
            };

            dl.generateURL = function () {
                return location.protocol + '//' + location.hostname + ':' + location.port;
            };

            dl.jsonpResponseProcess = function (resp, callback) {
                callback(resp);
            };
            /*
             * 将修改/新建/搜索对话页面注册到当前ViewModel
             * @param {type} details 如果是修改/新建，则注册到当前ViewModel的details数组中
             *                        如果是搜索，则放入searchforms数组中
             * @param {type} needToAdd 需要注册的ViewModel
             * @returns {undefined}
             */
            dl.addViewModelToParentDetails = function (details, needToAdd) {
                var found = false;
                for (var i = 0; i < details.length; i++) {
                    if (details[i].name === needToAdd.name) {
                        details[i].data = needToAdd.data;
                        found = true;
                    }
                }
                if (!found)
                    details.push(needToAdd);
            };

            dl.addChildrenToTreeParent = function (treeRoot, treeData) {
                var parentNode = dl.findTreeNodeById(treeRoot, treeData);
                if (!dl.isNullOrUndefined(parentNode)) {
                    parentNode.children = treeData[0].children;
                }
            };

            dl.findTreeNodeById = function (parentNode, currentNode) {
                if (!dl.isNullOrEmpty(parentNode) && parentNode instanceof Array) {
                    for (var i = 0; i < parentNode.length; i++) {
                        var pn = parentNode[i];
                        if (pn.id === currentNode[0].id) {
                            return pn;
                        } else {
                            var childData = pn.children;
                            if (!dl.isNullOrUndefined(childData)) {
                                var childData = dl.findTreeNodeById(childData, currentNode);
                                if (dl.isNullOrUndefined(childData)) {
                                    continue;
                                } else {
                                    return childData;
                                }
                            }
                        }
                    }
                }
                return null;
            };
////            变换globalModule  初始是注册页面模块login
//            dl.getGlobalModule = ko.observable({name: 'loginCheck', params: '', cacheKey: 'loginCheck'});


            // 通过id在d里面找到此id的数据 返回数据（数据在d.attr里）  递归
            dl.findMenuDataByID = function (id, d) {
                if (dl.isNullOrUndefined(d))
                    return null;
                if (d instanceof Array) {
                    for (var i = 0; i < d.length; i++) {
                        if (d[i].id == id)
                            return d[i].attr;
                        if (d[i].children) {
                            var res = dl.findMenuDataByID(id, d[i].children);
                            if (!dl.isNullOrUndefined(res))
                                return res;
                        }
                    }
                } else {
                    if (d.id == id)
                        return d.attr;
                }
                return null;
            };
            //通过特定的属性名称与值找到需要的某个对象值 (列表) 数据为数组
            dl.findCurrentDataByAttr = function (val, attributeName, data) {
                if (dl.isNullOrUndefined(data))
                    return null;
                if (data instanceof Array) {
                    for (var i = 0; i < data.length; i++) {
                        if (data[i][attributeName] == val)
                            return data[i];
                    }
                } else {
                    if (data[attributeName] == val)
                        return data;
                }
                return null;
            };
            //渲染后台数据时要用的
            //日期转换格式

            dl.dateOptions = {pattern: 'yyyy-MM-dd'};
            dl.dateConverterFactory = oj.Validation.converterFactory("datetime");
            dl.dateConverter = dl.dateConverterFactory.createConverter(dl.dateOptions);

            dl.dateOptionsCh = {pattern: 'yyyy年MM月dd日'};
            dl.dateConverterFactoryCh = oj.Validation.converterFactory("datetime");
            dl.dateConverterCh = dl.dateConverterFactoryCh.createConverter(dl.dateOptionsCh);
            //日期时间转换
            dl.datetimeOptions = {pattern: 'yyyy-MM-dd HH:mm:ss'};
            dl.datetimeConverterFactory = oj.Validation.converterFactory("datetime");
            dl.datetimeConverter = dl.datetimeConverterFactory.createConverter(dl.datetimeOptions);

            dl.dateViewOptions = {pattern: 'yy年MM月dd日'};
            dl.dateViewConverterFactory = oj.Validation.converterFactory("datetime");
            dl.dateViewConverter = dl.dateViewConverterFactory.createConverter(dl.dateViewOptions);
            //时间格式
            dl.timeOptions = {pattern: 'HH:mm:ss'};
            dl.timeConverterFactory = oj.Validation.converterFactory("datetime");
            dl.timeConverter = dl.timeConverterFactory.createConverter(dl.timeOptions);
            //货币格式转换
            dl.converterFactory = oj.Validation.converterFactory("number");
            dl.currencyOptions =
                    {
                        style: "currency",
                        currency: "CNY",
                        currencyDisplay: "symbol"
                    };
            dl.currencyConverter = dl.converterFactory.createConverter(
                    dl.currencyOptions);
            //数字转化格式
            dl.numberOptions = {pattern: "###,###,###,##0.00"};
            dl.ncf = oj.Validation.converterFactory(oj.ConverterFactory.CONVERTER_TYPE_NUMBER);
            dl.numberConverter = dl.ncf.createConverter(dl.numberOptions);

            dl.copyProperties = function (source, dest) {
                if (dl.isNullOrEmpty(source))
                    return;
                if (dl.isNullOrUndefined(dest))
                    dest = {};
                for (var p in source) {
                    dest[p] = source[p];
                }
            };


            /**
             * 获取页面查询参数返回一个对象
             * @returns
             */
            dl.getUrlArgObject = function (queryString) {
                var args = new Object();
                var queryFullStr = dl.isNullOrUndefined(queryString) ? location.search : queryString;
                var originalQuery;
                if (dl.isNullOrEmpty(queryFullStr))
                    return args;
                originalQuery = decodeURIComponent(queryFullStr.substring(1));
                if (originalQuery.indexOf("=") === -1)
                    return args;

                var pairs = originalQuery.split("&");//在&处断开  
                for (var i = 0; i < pairs.length; i++) {
                    var pos = pairs[i].indexOf('=');//查找name=value  
                    if (pos === -1) {//如果没有找到就跳过  
                        continue;
                    }
                    var argname = pairs[i].substring(0, pos);//提取name  
                    var value = pairs[i].substring(pos + 1);//提取value  
                    args[argname] = decodeURIComponent(value);//存为属性  
                }
                return args;//返回对象  
            };

            /*
             * 返回到指定名称的页面
             * @param {type} pageName
             * @returns {undefined}
             */
            dl.backToNamedPage = function (pageName) {
                if (dl._PAGESTACK.length === 0)
                    return;
                for (var i = dl._PAGESTACK.length - 1; i >= 0; i--) {
                    if (dl._PAGESTACK[i].name == pageName) {
                        dl.getGlobalModule(dl.popPageStack());
                        dl.headerTitle(dl.popHeader());
                        return;
                    } else {
                        dl.popPageStack();
                        dl.popHeader();
                    }
                }
            };
            //      功能页的按钮的返回事件
            dl.backToClick = function (event, ui) {
//               拿到数组最后一个值即上一次点击时渲染的module  

                dl.getGlobalModule(dl.popPageStack());
                dl.headerTitle(dl.popHeader());
            };

//          功能页header 
            dl.headerTitle = ko.observable("");

            dl.getAllDetailPages = function (details, detailType) {
                var res = [];
                for (var i = 0; i < details.length; i++) {
                    if (detailType === details[i].detailType) {
                        res.push(details[i]);
                    }
                }
                return res;
            };
            /*
             * 获取指定类型的详细页个数
             * @param {type} details
             * @param {type} detailType
             * @returns {Array|commclientL#6.getAllDetailCount.res}
             */
            dl.getAllDetailCount = function (details, detailType) {
                var res = 0;
                for (var i = 0; i < details.length; i++) {
                    if (detailType === details[i].detailType) {
                        res++;
                    }
                }
                return res;
            };
            /*
             * 把当前ViewModel选中的数据拷贝到注册的修改对话框/新建对话框
             * @param {type} vm当前的ViewModel
             * @param {type} isupdate 是否为修改对话框/新建对话框
             * @returns {undefined}
             */
            dl.copyAllDetailDataToControls = function (vm, detailType) {
                for (var i = 0; i < vm.details.length; i++) {
                    if (detailType !== vm.details[i].detailType)
                        continue;
                    if (!vm.details[i].data)
                        continue;
                    vm.details[i].data.setDataToControls();
                }
            };

            dl.executeCopyNamedPageDataBack = function (vm, detailName) {
                for (var i = 0; i < vm.details.length; i++) {
                    if (vm.details[i].name === detailName) {
                        if (!vm.details[i].data)
                            return;
                        vm.details[i].data.setDataFromControls();
                        return;
                    }
                }
            };
            /*
             * 把所有注册到该ViewModel的修改/新建对话框中的数据拷贝到
             * 当前ViewModel的currentData中
             * @param {type} vm当前的ViewModel
             * @param {type} isupdate 是否为修改对话框/新建对话框
             * @returns {undefined}
             */
            dl.copyAllDetailDataFromControls = function (vm, detailType) {
                for (var i = 0; i < vm.details.length; i++) {
                    if (vm.details[i].detailType !== detailType)
                        continue;
                    if (!vm.details[i].data)
                        continue;
                    vm.details[i].data.setDataFromControls();
                }
            };
            /*
             * 把所有注册到该ViewModel里的搜索条件表单数据拷贝到当前的
             * searchData中，如果没有注册的搜索对话框就说明没有查询条件
             */
            dl.copyAllSearchDataFromControls = function (vm) {
                if (dl.isNullOrUndefined(vm.searchforms))
                    return;
                for (var i = 0; i < vm.searchforms.length; i++) {
                    vm.searchforms[i].data.setDataFromControls();
                }
            };

            /*
             * 动态地设置下拉框的选项数据从后台的查询中
             * @param {operationName} 后台查询的名称
             * @param {condition} 查询条件数据
             * @param {observableVar} 下拉框对应的options的knockout变量
             */
            dl.setOptionsFromQuery = function (operationName, condition, observableVar) {
                dl.callOperation(operationName, '', condition, dl.setOptionsToObservable, observableVar);
            };

            /*
             * 从上述查询结果中把数据设置到下拉框对应的options的knockout变量
             * @param {response} 后台返回的数据
             * @param {observableVar} 下拉框对应的options的knockout变量
             */
            dl.setOptionsToObservable = function (response, observableVar) {
                var arr = dl.parseCollection(response);
                var res = [];
                for (var i = 0; i < arr.length; i++) {
                    var obj = arr[i];
                    if (obj.keyColumn)
                        res.push({value: obj.keyColumn, label: obj.valueColumn});
                    else
                        res.push(obj);
                }
                observableVar(res);
            };
            /*
             * NQ_DomainValue的返回数据处理函数
             * 将返回结果首先保存到localStorage里面
             * 然后再将结果解析到全局变量中，以后所有客户端程序都可以使用
             */
            dl.keyValueCallback = function (resp) {
                var arr = dl.parseCollection(resp);
                var storage = localStorage;
                if (storage) {
                    storage.setItem(dl._GLOBALDOMAINNAME, JSON.stringify(resp));
                    var d = new Date();
                    storage.setItem(dl._DOMAINUPDATETIME, d.toJSON());
                }
                dl.genaretDropdownValues(arr);
            };
            /*
             * 将结果解析到全局变量中，以后所有客户端程序都可以使用
             */
            dl.genaretDropdownValues = function (arr) {

                for (var i = 0; i < arr.length; i++) {
                    var obj = arr[i];
                    if (dl._KEYVALUE[obj.tableName] === undefined) {
                        dl._KEYVALUE[obj.tableName] = {};
                        dl._KEYVALUE[obj.tableName].status = 0;
                        dl._KEYVALUE[obj.tableName].data = [];
                        dl._KEYVALUE[obj.tableName].lastUpdateTime = new Date();
                    } else {
                        if (dl._KEYVALUE[obj.tableName].status !== 0) {
                            dl._KEYVALUE[obj.tableName].status = 0;
                            dl._KEYVALUE[obj.tableName].data = [];
                            dl._KEYVALUE[obj.tableName].lastUpdateTime = new Date();
                        }
                    }
                    var noption = {value: obj.keyColumn, label: obj.valueColumn};
                    if (obj.conditionColumn)
                        noption.parent = obj.conditionColumn;
                    dl._KEYVALUE[obj.tableName].data.push(noption);
                }
                for (var opt in dl._KEYVALUE) {
                    if (dl._KEYVALUE.hasOwnProperty(opt)) {
                        dl._KEYVALUE[opt].status = 1;
                    }
                }
                if (arr.length > 0) {
                    dl._LOADSELECTIONDONE(true);
                }
            };
            /*
             * 判断数组中是否包含了指定的元素
             */
            dl.isArrayContains = function (arr, e) {
                for (var a in arr)
                    if (a === e)
                        return true;
                return false;
            };
            /*
             * 
             * @param {type} vm
             * @returns {unresolved}
             */
            dl.getAllModelData = function (vm) {
                var res = {};
                for (var prop in vm) {
                    if (!vm.hasOwnProperty(prop))
                        continue;
                    if (!ko.isObservable(vm[prop]))
                        continue;
                    if (prop.substr(0, 2) !== '__')
                        continue;
                    var val = vm[prop];
                    if (dl.isNullOrUndefined(val))
                        continue;
                    var n = prop.substring(2);
                    res[n] = vm[prop]();
                }
                return res;
            };

            /*
             * 拷贝ViewModel中选中的数据到某表单中
             * source ViewModel中的当前数据currentData
             * dest 修改/新建表单的ViewModel
             */
            dl.copyDataToControls = function (source, dest) {
                for (var prop in dest) {
                    if (!dest.hasOwnProperty(prop))
                        continue;
                    if (!ko.isObservable(dest[prop]))
                        continue;
                    if (prop.substr(0, 2) !== '__')
                        continue;
                    var n = prop.substring(2);
                    if (dest[prop].dataType === 'boolean') {
                        dest[prop]([]);
                        if (!dl.isNullOrUndefined(source[n]) && source[n]) {
                            dest[prop]().push(n);
                        }
                    } else {
                        if (!dl.isNullOrUndefined(source[n]))
                            dest[prop](source[n]);
                        else
                            dest[prop](null);
                    }
                }
            };
            /*
             * 拷贝ViewModel中选中的数据从某表单中
             * source ViewModel中的当前数据currentData
             * dest 修改/新建表单的ViewModel
             */
            dl.copyDataFromControls = function (source, dest) {
                for (var prop in dest) {
                    if (!dest.hasOwnProperty(prop))
                        continue;
                    if (!ko.isObservable(dest[prop]))
                        continue;
                    if (prop.substr(0, 2) !== '__')
                        continue;
                    var n = prop.substring(2);
                    if (dest[prop].dataType === 'boolean') {
                        var val = dest[prop]();
                        if (!dl.isNullOrUndefined(val)) {
                            if (val === true || val === false)
                                source[n] = val;
                            else
                                delete source[n];
                        }
                    } else {
                        var val = dest[prop]();
                        if (!dl.isNullOrUndefined(val)) {
                            if (val instanceof Array) {
                                if (val.length > 0)
                                    source[n] = val[0];
                            } else
                                source[n] = val;
                        }
                    }
                }
            };

            dl.processInlineData = function (src) {
                var res = {};
                for (var prop in src) {
                    if (src[prop] instanceof Array) {
                        if (src[prop].length > 0)
                            res[prop] = src[prop][0];
                    } else
                        res[prop] = src[prop];
                }
                return res;
            };

            dl.removeNullAttributeFromObject = function (o) {
                for (var prop in o) {
                    if (dl.isNullOrUndefined(o[prop]))
                        delete o[prop];
                }
            };
            /*
             * 实现类似于java中StringBuilder功能
             * @param {type} value
             * @returns {commclientL#6.dl.StringBuilder}
             */
            dl.StringBuilder = function (value)
            {
                this.strings = new Array("");
                this.append(value);
            };

            /*
             * 往StringBuilder中添加数据
             */
            dl.StringBuilder.prototype.append = function (value)
            {
                if (value)
                {
                    this.strings.push(value);
                }
            };

            /*
             * 清除当前的StringBuilder对象
             */
            dl.StringBuilder.prototype.clear = function ()
            {
                this.strings.length = 1;
            };

            /*
             * 将当前的StringBuilder对象转化成字符串
             */
            dl.StringBuilder.prototype.toString = function ()
            {
                return this.strings.join("");
            };
            /*
             * 解析从后台返回的数据，主要是针对日期型的数据进行处理
             */
            dl.parseValueFromService = function (val) {
                if (!(typeof (val) === 'string'))
                    return val;
                if (val.length >= 18 && val.substr(0, 8) === '__DATE__') {
//                    console.log("------------------------------------------");
                    var s = val.substring(8);
//                    console.log(s);
                    var d = new Date();
                    d.setTime(Number(s));
//                    console.log(d.getTime());
//                    console.log('Timezone'+d.getTimezoneOffset());
                    d.setTime(d.getTime() - d.getTimezoneOffset() * 60000);
                    return d.toISOString();
                } else
                    return val;
            };
            /*
             * 实现oj.Model中数据的解析工作
             */
            dl.parseModel = function (response) {
                var res = {};
                for (var prop in response) {
                    if (!response.hasOwnProperty(prop))
                        continue;
                    res[prop] = dl.parseValueFromService(response[prop]);
                }
                return res;
            };
            /*
             * 判断是否为空或者undefined
             */
            dl.isNullOrUndefined = function (val) {
                if (val === undefined)
                    return true;
                if (val === null)
                    return true;
                return false;
            };
            /*
             * 从下拉框数据中构建树
             */
            dl.generateTree = function (keyName, rootId) {
                var res = dl.findTreeNode(keyName, rootId);
                if (res === null || res.length === 0)
                    return {};
                var root = res[0];
                dl.generateTreeNode(keyName, root);
                return root;
            };
            // 递归生成树节点，下拉数据名和父级节点代码
            dl.generateTreeNode = function (keyName, parent) {
                var foundNodes = dl.findTreeNode(keyName, parent.value);
                if (foundNodes !== null && foundNodes.length > 0) {
                    for (var i = 0; i < foundNodes.length; i++) {
                        dl.generateTreeNode(keyName, foundNodes[i]);
                    }
                    parent.children = foundNodes;
                }
            };
            // 根据下拉数据选项的名字和编码获取显示数据，用于表格单元的数据转换显示
            dl.getLabelByValue = function (keyName, val) {
                if (dl._LOADSELECTIONDONE()) {
                }
                var res = '';
                var obj = dl._KEYVALUE[keyName];
                if (obj === undefined || obj === null || obj.length === 0)
                    return res;
                var arr = obj.data;
                if (arr === undefined || arr === null || arr.length === 0)
                    return res;
                for (var i = 0; i < arr.length; i++) {
                    if (arr[i].value == val) {
                        res = arr[i].label;
                        break;
                    }
                }
                return res;
            };

            dl.getDirectValueFromServer = function (keyName, val) {
                var res = dl.getLabelByValue(keyName, val);
                if (dl.isNullOrEmpty(res)) {
                    var condition = {
                        'selectId': keyName
                    };
                    dl.callSyncOperation("NQ_DomainValue", "find", condition, function (response) {
                        var dataArra = dl.parseCollection(response);
                        dl.genaretDropdownValues(dataArra);
                        res = dl.getLabelByValue(keyName, val);
                    });
                }
                return res;
            };

            // 根据父级编码获取下拉数据，比如根据省编码获得市的下拉数据
            dl.getOptionsByParent = function (keyName, parent, isNumber) {
                var res = [];
                var obj = dl._KEYVALUE[keyName];
                if (obj === undefined || obj === null || obj.length === 0)
                    return res;
                var arr = obj.data;
                if (arr === undefined || arr === null || arr.length === 0)
                    return res;
                for (var i = 0; i < arr.length; i++) {
                    if (parent == arr[i].parent) {
                        if (!isNumber)
                            res.put({value: arr[i].value, label: arr[i].label});
                        else {
                            var num = Number(arr[i].value);
                            if (isNaN(num))
                                res.push({value: arr[i].value, label: arr[i].label});
                            else
                                res.push({value: num, label: o.label});
                        }
                    }
                }
                return res;
            };
            // 获取当前DataGrid选中的数据
            dl.getCurrentDataGridSelectedData = function (domName, coll) {
                var selected = $(domName).ojDataGrid("option", "selection");
                if (selected === null || selected.length === 0)
                    return;
                var d = selected[0];
                var rowKey = d['startKey']['row'];
                var reservedFetchSize = coll.fetchSize;
                coll.fetchSize = -1;
                var rowData = coll.get(rowKey, {deferred: false});
                coll.fetchSize = reservedFetchSize;
                d.data = rowData;
                return d;
            };
            dl.getAllDataGridSelectedData = function (domName, coll) {
                var selected = $(domName).ojDataGrid("option", "selection");
                if (selected === null || selected.length === 0)
                    return [];
                var reservedFetchSize = coll.fetchSize;
                coll.fetchSize = -1;
                for (var i = 0; i < selected.length; i++) {
                    var d = selected[i];
                    var rowKey = d['startKey']['row'];
                    var rowData = coll.get(rowKey, {deferred: false});
                    d.data = rowData;
                }
                coll.fetchSize = reservedFetchSize;
                return selected;
            };

            dl.getDataGridSelectedData = function (domName) {
                var selected = $(domName).ojDataGrid("option", "selection");
                if (selected === null || selected.length === 0)
                    return [];
                return selected;
            };
            // 获取当前Table选中的数据
            dl.getCurrentTableSelectedData = function (domName, coll) {
                var selected = $(domName).ojTable("option", "selection");
                if (selected === null || selected.length === 0)
                    return;
                var d = selected[0];
                var rowKey = d['startKey']['row'];
                var reservedFetchSize = coll.fetchSize;
                coll.fetchSize = -1;
                var rowData = coll.get(rowKey, {deferred: false});
                coll.fetchSize = reservedFetchSize;
                return rowData;
            };
            // 根据下拉数据的名字获取下拉数据
            dl.getOptionsByName = function (keyName, isNumber) {
                if (dl._LOADSELECTIONDONE()) {
                }
                var res = [];
                var obj = dl._KEYVALUE[keyName];
                if (obj === undefined || obj === null || obj.length === 0)
                    return res;
                var arr = obj.data;
                if (arr === undefined || arr === null || arr.length === 0)
                    return res;
                if (!isNumber)
                    return arr;
                for (var i = 0; i < arr.length; i++) {
                    var o = arr[i];
                    var num = Number(o.value);
                    if (isNaN(num))
                        res.push(o);
                    else
                        res.push({value: num, label: o.label});
                }
                return res;
            };
            // 根据父节点编码查找子节点数据
            dl.findTreeNode = function (keyName, parentId) {

                var obj = dl._KEYVALUE[keyName];
                if (obj === undefined || obj === null || obj.length === 0)
                    return null;
                var arr = obj.data;
                if (arr === undefined || arr === null || arr.length === 0)
                    return null;
                var res = [];
                for (var i = 0; i < arr.length; i++) {
                    if (parentId == arr[i].parent) {
                        res.push({value: arr[i].value, label: arr[i].label});
                    }
                }
                return res;
            };
            // 打印树
            dl.printTreeNode = function (node, sp) {
                console.log(sp + 'value-->' + node.value + ' label-->' + node.label);
                if (node.children) {
                    sp += '\t';
                    for (var i = 0; i < node.children.length; i++) {
                        dl.printTreeNode(node.children[i], sp);
                    }
                }
            };
//    new Worker('js/DomainLoader.js');
            // 获取后台服务的列表数据
            dl.parseCollection = function (response) {
                return response['ResultSet']['Result'];
            };
            //获取后台的返回状态值
            dl.getResponseStatus = function (response) {
                return response['ResultSet']['status'];
            };
            //获取后台错误信息
            dl.getResponseErrors = function (response) {
                return response['ResultSet']['errors'];
            };
            //获取后台自定义信息
            dl.getResponseUserData = function (response) {
                return response['ResultSet']['userData'];
            };
            // 解析返回的分页数据信息，按照符合JET的方式返回
            dl.parsePaging = function (resp) {

                var res = {};
                if (resp.ResultSet.currentPage <= 1) {
                    res.totalResults = resp.ResultSet.totalResultsAvailable;
                }

                res.limit = resp.ResultSet.recordNumber;
                res.count = resp.ResultSet.recordNumber;
                res.offset = resp.ResultSet.currentPage === 0 ? 0 : (resp.ResultSet.currentPage - 1) * resp.ResultSet.pageLines;
                res.hasMore = resp.ResultSet.currentPage !== resp.ResultSet.totalPages;
                return res;
            };
            // JET在分页装载数据时给出的参数是startIndex和fetchSize
            // 此函数用于计算Delicacy后台服务能够识别的格式
            dl.calculateCurrentPage = function (options) {
                if (options.fetchSize === undefined)
                    return 0;
                var fetchSize = options.fetchSize;
                var startIndex = options.startIndex === undefined ? options.context === undefined ? 0 : options.context.offset : options.startIndex;
                var res = Math.round(startIndex / fetchSize);
                return res + 1;
            };
            // 将分页信息和条件信息打包
            dl.packageCondition = function (collection, ops) {
                var cond = {};
                if (collection.generateCondition && typeof collection.generateCondition === 'function') {
                    cond = collection.generateCondition();
                }

                for (var prop in ops) {
                    if (ops.hasOwnProperty(prop) && prop !== 'context') {
                        cond[prop] = ops[prop];
                    }
                }
                dl.removeNullAttributeFromObject(cond);
                cond['currentPage'] = dl.calculateCurrentPage(ops);
                cond['pageLines'] = ops.fetchSize;
                var scond = JSON.stringify(cond);
                console.log(scond);
                scond = encodeURI(scond);
                return scond;
            };
            // 根据JET传入的操作类型生成Delicacy后台服务的标准操作动作
            dl.getSubaction = function (method) {
                if (method === 'read')
                    return 'find';
                if (method === 'create')
                    return 'save';
                if (method === 'update')
                    return 'update';
                if (method === 'delete')
                     return 'delete';
                return 'find';
            };

            dl.dateOptions = {pattern: 'yyyy-MM-dd'};
            dl.dateConverterFactory = oj.Validation.converterFactory("datetime");
            dl.dateConverter = dl.dateConverterFactory.createConverter(dl.dateOptions);

            dl.converterFactory = oj.Validation.converterFactory("number");
            dl.currencyOptions =
                    {
                        style: "currency",
                        currency: "CNY",
                        currencyDisplay: "symbol"
                    };
            dl.currencyConverter = dl.converterFactory.createConverter(
                    dl.currencyOptions);

            dl.numberOptions = {pattern: "###,###,###,##0.00"};
            dl.ncf = oj.Validation.converterFactory(oj.ConverterFactory.CONVERTER_TYPE_NUMBER);
            dl.numberConverter = dl.ncf.createConverter(dl.numberOptions);

            /*
             * 调用指定地址的JSONP
             * @param {type} url
             * @param {type} operationName
             * @param {type} subaction
             * @param {type} data
             * @param {type} callback
             * @param {type} observableVar
             * @returns {undefined}
             */
            dl.callSpecificJSONP = function (url, operationName, subaction, data, callback, observableVar) {
                if (dl.isNullOrEmpty(subaction)) {
                    subaction = 'find';
                }
                var sendData = {action: operationName, subaction: subaction};
                if (dl.isNullOrUndefined(data)) {
                    data = {};
                }
                sendData.content = encodeURIComponent(JSON.stringify(data));
                $.ajax({url: url,
                    jsonp: "callback",
                    dataType: "jsonp",
                    data: sendData,
                    success: function (resp) {
                        console.log(operationName + ' ' + resp.length);
                        dl.callJSONPSuccessProcessor(resp, callback, observableVar);
                    }
                });
            };
            /*
             * 跨域的Ajax调用
             */
            dl.callJSONP = function (operationName, subaction, data, callback, observableVar) {
                if (dl.isNullOrEmpty(subaction)) {
                    subaction = 'find';
                }
                var sendData = {action: operationName, subaction: subaction};
                if (dl.isNullOrUndefined(data)) {
                    data = {};
                }
                sendData.content = encodeURIComponent(JSON.stringify(data));
                $.ajax({url: dl._JSONPSERVER,
                    jsonp: "callback",
                    dataType: "jsonp",
                    data: sendData,
                    success: function (resp) {
                        console.log(operationName + ' ' + resp.length);
                        dl.callJSONPSuccessProcessor(resp, callback, observableVar);
                    }
                });
            };
            dl.callJSONPSuccessProcessor = function (resp, callback, observableVar) {
                var val = JSON.parse(decodeURIComponent(resp));
                callback(val, observableVar);
            };

            //              我的代办里的图标 50多种
            dl.iconArr = ['oj-navigationlist-item-icon demo-home-icon-24 demo-icon-font-24', 'oj-navigationlist-item-icon demo-home-icon-24 demo-icon-font-24', 'iconfont icon-icon-test1', 'iconfont icon-richangfeiyongbaoxiao', 'iconfont icon-chuchai', 'iconfont icon-chucha',
                'iconfont icon-jiekuan', 'iconfont icon-fukuantongzhi', 'iconfont icon-feiyongbaoxiaodan', 'iconfont icon-chalvfeiyongbaoxiao', 'iconfont icon-feiyongbaoxiaodan', //10
                'iconfont icon-huikuanfangshi', 'iconfont icon-qingjiajiaban', 'iconfont icon-qingjiajiaban', 'iconfont icon-lvxingwaichu', 'iconfont icon-kaoqin1',
                'iconfont icon-waichujihua', 'iconfont icon-jiaban1', 'iconfont icon-feiji800', 'iconfont icon-chucha2', //20
                'iconfont icon-chucha1', 'iconfont icon-zhufang', 'iconfont icon-yanqi', 'iconfont icon-rukuguanli', 'iconfont icon-yuangongruzhi',
                'iconfont icon-yuangonglizhi', 'iconfont icon-zhuanzhengdiaogangzhuangang', 'iconfont icon-querenhetongquerenhetongqueding', 'iconfont icon-huankuan-xianxing', 'iconfont icon-zhuanzheng', //30
                'iconfont icon-diaoxinjiaxin', 'iconfont icon-wupinshenqing-copy', 'oj-navigationlist-item-icon demo-home-icon-24 demo-icon-font-24', 'iconfont icon-che1', 'iconfont icon-mingpian',
                'iconfont icon-yinzhang', 'iconfont icon-caigoudingdan', 'iconfont icon-xinzi', 'oj-navigationlist-item-icon demo-home-icon-24 demo-icon-font-24', 'iconfont icon-jiangdichengben', //40
                'iconfont icon-network', 'iconfont icon-woyaohuankuan', 'iconfont icon-querenhetongquerenhetongqueding', 'iconfont icon-lixiang', 'iconfont icon-close', 'iconfont icon-gongzitiao-',
                'iconfont icon-zhuandanzhong', '', '', '', '', //50
                'iconfont icon-yusuandan', 'iconfont icon-yusuandan', 'iconfont icon-yusuandan', 'iconfont icon-yusuandan', 'iconfont icon-yusuandan',
                'iconfont icon-baojia', 'demo-home-icon-24 demo-icon-font-24', 'iconfont icon-weibiaoti--', 'iconfont icon-peixun3', 'demo-home-icon-24 demo-icon-font-24', //60
                'iconfont icon-quanxian', 'iconfont icon-hetongxuqianshenqing', 'iconfont icon-jiangjinguize', 'iconfont icon-hetong', '',
                '', '', '', '', '', //70
                'iconfont icon-yinzhang', 'iconfont icon-qiyeshenqingqianrutiaodang', 'iconfont icon-duanluobiaoshi', 'iconfont icon-zhongbiao', 'iconfont icon-baojiadan',
                'iconfont icon-zhongbiao','iconfont icon-zhongbiao', 'iconfont icon-daochutupian',  'iconfont icon-tuandui', 'iconfont icon-jingfeibaozhang',  //80
                'iconfont icon-dilanxianxingiconyihuifu_huabanfuben', 'iconfont icon-zhijiandan-', 'iconfont icon-zhijiandan-', 'iconfont icon-gongshiluru'
            ];
            /*
             * 判断一个值是否是未定义/空值/空字符串/空数组
             * @param {type} val
             * @returns {Boolean}
             */
            dl.isNullOrEmpty = function (val) {
                if (val === undefined)
                    return true;
                if (val === null)
                    return true;
                if (val.length === 0)
                    return true;
                return false;
            };
            /*
             /*
             * 
             */
            dl.lzw_encode = function (s) {
                var dict = {};
                var data = (s + "").split("");
                var out = [];
                var currChar;
                var phrase = data[0];
                var code = 256;
                for (var i = 1; i < data.length; i++) {
                    currChar = data[i];
                    if (dict[phrase + currChar] !== null) {
                        phrase += currChar;
                    } else {
                        out.push(phrase.length > 1 ? dict[phrase] : phrase.charCodeAt(0));
                        dict[phrase + currChar] = code;
                        code++;
                        phrase = currChar;
                    }
                }
                out.push(phrase.length > 1 ? dict[phrase] : phrase.charCodeAt(0));
                for (var i = 0; i < out.length; i++) {
                    out[i] = String.fromCharCode(out[i]);
                }
                return out.join("");
            };
            /*
             * 
             */
            dl.lzw_decode = function (s) {
                var dict = {};
                var data = (s + "").split("");
                var currChar = data[0];
                var oldPhrase = currChar;
                var out = [currChar];
                var code = 256;
                var phrase;
                for (var i = 1; i < data.length; i++) {
                    var currCode = data[i].charCodeAt(0);
                    if (currCode < 256) {
                        phrase = data[i];
                    } else {
                        phrase = dict[currCode] ? dict[currCode] : (oldPhrase + currChar);
                    }
                    out.push(phrase);
                    currChar = phrase.charAt(0);
                    dict[code] = oldPhrase + currChar;
                    code++;
                    oldPhrase = phrase;
                }
                return out.join("");
            };
            // 执行装载下拉框选项数据的装入
            if (localStorage) {
                var storedDropdownValues = localStorage.getItem(dl._GLOBALDOMAINNAME);
                var domainUpdateTime = localStorage.getItem(dl._DOMAINUPDATETIME);
                if (storedDropdownValues && domainUpdateTime) {
                    var updateTime = Date.parse(domainUpdateTime);
                    var currentTime = new Date();
                    var dropObj = JSON.parse(storedDropdownValues);
                    var dropArray = [];
                    if (!Array.isArray(dropObj)) {
                        dropArray = dl.parseCollection(dropObj);
                    } else {
                        dropArray = dropObj;
                    }
                    dl.genaretDropdownValues(dropArray);
                } else
                    dl.callOperation(dl._KEYVALUEMANAGERSERICE, '', {loadOnStartup: true}, dl.keyValueCallback);
            } else
                dl.callOperation(dl._KEYVALUEMANAGERSERICE, '', {loadOnStartup: true}, dl.keyValueCallback);

            var domainworker = new Worker('js/delicacy/clientworker.js?v=20190624');
            domainworker.onmessage = function (event) {
                var data = event.data;
                for (var i in data) {
                    dl._KEYVALUE[i] = data[i];
                }
                dl._LOADSELECTIONDONE(true);
            };

            var usdomainworker = new Worker('js/delicacy/usclientworker.js');
            usdomainworker.onmessage = function (event) {
                var jsonObj = JSON.parse(event.data);
                var data = jsonObj['mobile'];
                for (var i in data) {
                    dl._KEYVALUE[i] = data[i];
                }
                dl._LOADSELECTIONDONE(true);
            };

            // 获取地址栏指定参数信息值
            dl.getUrlParamItemValue = function (item, paramsStr) {
                return dl.getUrlArgObject(paramsStr)[item];
            };

            dl.getUserId = function () {
                return $.cookie("userId");
            };

            dl.formatFileSize = function (fileSize) {
                if (fileSize === 0)
                    return "0B";
                fileSize = fileSize / 1024;
                if (fileSize < 1024) {
                    return fileSize.toFixed(2) + "K";
                }
                fileSize = fileSize / 1024;
                if (fileSize < 1024) {
                    return fileSize.toFixed(2) + "M";
                }
                fileSize = fileSize / 1024;
                if (fileSize < 1024) {
                    return fileSize.toFixed(2) + "G";
                } else {
                    return (fileSize / 1024).toFixed(2) + "T";
                }
            };

            dl.getFileIconByFileExtension = function (fileExtension) {
                if (dl.isNullOrUndefined(fileExtension)) {
                    return -1;//未知文件类型
                }
                fileExtension = fileExtension.toLowerCase();
                if (fileExtension === 'txt')
                    return 1;//文本txt
                if (fileExtension === 'pdf')
                    return 2;//PDF
                if ($.inArray(fileExtension, ['xlsx', 'xlsm', 'xlsb', 'xls', 'xltx', 'xltm', 'xlt', 'csv', 'xlam', 'xla']) >= 0)
                    return 3;//表格excel
                if ($.inArray(fileExtension, ['docx', 'docm', 'doc', 'dotx', 'dotm', 'dot']) >= 0)
                    return 4;//文档word
                if ($.inArray(fileExtension, ['jpg', 'jpeg', 'png', 'gif', 'bmp']) >= 0)
                    return 5;//图片
                if (fileExtension === 'mp3')
                    return 6;//音频文件
                if ($.inArray(fileExtension, ['ppt', 'pptx', 'pptm', 'potx', 'potm', 'pot', 'ppsx', 'ppsm', 'pps', 'ppam', 'ppa']) >= 0)
                    return 7;//ppt
                if ($.inArray(fileExtension, ['dwg', 'dwt', 'dxf', 'dws']) >= 0)
                    return 8;//autoCad
                if (fileExtension === 'exe')
                    return 9;//exe
                if ($.inArray(fileExtension, ['zip', 'rar', '7z', 'bzip2', 'gzip', 'tar', 'wim', 'xz', 'arj', 'z']) >= 0)
                    return 10;//压缩文件
                if ($.inArray(fileExtension, ['aiff', 'avi', 'mov', 'mpeg', 'mpg', 'qt', 'ram', 'viv', 'dat', 'ra', 'rm', 'rmvb', 'wmv', 'asf', 'vob', 'mp4', 'flv']) >= 0)
                    return 11;//视频
                return -1;//未知文件类型
            };
            return dl;
        });


