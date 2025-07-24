/* global decodeURIComponent */
define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient','dl/msgbox',  'dl/workflow', 'dl/Desjs', 'ojs/ojknockout', 'ojs/ojinputtext'],
        function (oj, ko, $, dl ,sc) {

            function LoginViewModel() {
                var self = this;
                
                self.CORP_ID = "wwc498e84af28dbf9a";
                self.AGENTID = 1000009;
                
                /**
                 * 获取url的传入参数转成对象
                 * @returns {Object}
                 */
                self.getUrlArgObject = function () {
                    var args = new Object();
                    var queryFullStr = location.search;
                    if (!dl.isNullOrUndefined(queryFullStr) && decodeURIComponent(queryFullStr).indexOf("=") !== -1) {
                        var query = decodeURIComponent(location.search.substring(1));//获取查询串  
                        var pairs = query.split("&");//在&处断开  
                        for (var i = 0; i < pairs.length; i++) {
                            var pos = pairs[i].indexOf('=');//查找name=value  
                            if (pos === -1) {//如果没有找到就跳过  
                                continue;
                            }
                            var argname = pairs[i].substring(0, pos);//提取name  
                            var value = pairs[i].substring(pos + 1);//提取value  
                            args[argname] = decodeURIComponent(value);//存为属性  
                        }
                    }
                    return args;//返回对象  
                };

                
                self.checkIsWechat = function(){
                    var ua = navigator.userAgent.toLowerCase();
                    if(ua.match(/MicroMessenger/i) == "micromessenger") {
                        return true;
                    } else {
                        return false;
                    }
                };
                
                self.checkLogin = function(){
                    var paramObj = self.getUrlArgObject();
                    var flag = false;
                    if(dl.isLogin()){
                        flag = true;
                        if(!dl.isNullOrUndefined(paramObj['state'])){
                            self.goPage(paramObj);
                        }else{
                            dl.getGlobalModule({name: 'home', params: ''});
                        }
                    }else{
                        //当没有登录且为企业微信登录 且 没有企业微信参数的时候  进行oauth2的验证 
                        if(self.checkIsWechat()){
                           if (dl.isNullOrUndefined(paramObj['code']) || dl.isNullOrUndefined(paramObj['state'])) {
                               var redirectUri = encodeURIComponent("https://2001.cube-architects.com/minindex.html");
                               var gourl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + self.CORP_ID + "&redirect_uri=" + redirectUri 
                                                + "&response_type=code&scope=snsapi_base&agentid=" + self.AGENTID + "&state=" + paramObj['state']
                                                + "&connect_redirect=1#wechat_redirect";
                               window.location.replace(gourl);
                               flag = true;
                           }
                        }
                    }
                    return flag;
                };

               //登录情况剖析
               //企业微信端登录 
               //1:控制台登录  state=STATE 或没有 state参数
               //2:企业微信通知登录  state=type_1__id_193141   后期改版为 state=msgType_2__id_193141
               //3:拷贝企业微信登录链接登录  state=processInstanceId_33439__msgType_1
               
               //直接非企业微信端(普通浏览器)输入地址/点击链接进行登录
               
               //情景处理  (以后所有的进入链接改为  直接进入 erp网页端  第一步不进行oauth2的验证回调)
               //进入ERP手机端口  进行登录验证  
               //1:成功则根据state参数进入指定的页面 没有state参数 则进入首页
               //2:不成功(没有登录情况)  
               // 企业微信端打开  
               // (1)如果是企业微信端打开 在拥有code参数和state参数的情况下视为从企业微信回调过来 直接进入用户信息查询设置登录状态
               // (2)在没有用户code或state参数的情况下 则将本网页当前的state参数传入 企业微信oauth2地址进行验证回调到erp这边进行再回到第2步的判断(回调过来的地址会带入code和state参数)
               // 非企业微信打开
               // (1)直接进入到登录页面
                self.handleActivated = function (info) {
                    if(self.checkLogin()){
                        return;
                    }
                    var paramObj = self.getUrlArgObject();
                    if (!dl.isNullOrUndefined(paramObj)) {
                        //从微信访问登录的参数   code用来获取登录的用户信息, 没有进行邮箱与手机信息的获取   
                        //state格式 state=id_1__type_1
                        //state 最大长度为128个字节
                        if (!dl.isNullOrUndefined(paramObj['code']) && !dl.isNullOrUndefined(paramObj['state'])) {
                            var condition = {
                                code: paramObj['code'],
                                opt_type: 'checkUserinfoByCode'
                            };
                            dl.callOperation("EP_CheckUserinfoToLogin", "", condition, function (response) {
                                if (response.ResultSet.status >= 0) {
                                    var userInfo = dl.parseCollection(response)[0];
                                    dl.setUserInfo(userInfo);
                                    //设置用户数据到LocalStorage中
                                    dl.setUserInfoToLocalStorage(userInfo);
                                    //进入报销详情  需要传入的参数  统一为  rowData
                                    self.goPage(paramObj);
                                } else {
                                    dl.getGlobalModule({name: 'login', params: '', cacheKey: 'login'});
                                }
                            });
                        } else {
                            dl.getGlobalModule({name: 'login', params: '', cacheKey: 'login'});
                        }
                    } else {
                        dl.getGlobalModul({name: 'login', params: '', cacheKey: 'login'});
                    }
                };
                
                
                self.goPage = function(paramObj){
                    var state = paramObj['state'];
                    var pairs = state.split("__");
                    var params = new Object();
                    for (var i = 0; i < pairs.length; i++) {
                        var pos = pairs[i].indexOf('_');//查找name=value  
                        if (pos === -1) {//如果没有找到就跳过  
                            continue;
                        }
                        var argname = pairs[i].substring(0, pos);//提取name  
                        var value = pairs[i].substring(pos + 1);//提取value  
                        params[argname] = decodeURIComponent(value);//存为属性  
                    }
                     var msgType = params['msgType'];// 1:PC端生成的复制链接 2:ERP自动发送的审批通知
                     var type = params['type'];
                     if(!dl.isNullOrUndefined(msgType)){
                        msgType = Number(msgType);
                        type = Number(type);
                        if(msgType === 1){//pc端定义的复制链接
                            self.customMsgApproveClick(params);
                        }else if(msgType === 2){
                            //点击ERP  auto通知
                            self.selfClickErpMsg(params);
                        }else if(msgType === 3){
                            //扫描培训会议或物品领用的二维码
                            if(type ===1){ 
                                dl.getGlobalModule({name: 'management/training', params: params, cacheKey: ''});
                                dl.pushPageStack({name: 'home', params: '', cacheKey: 'home'});
                                dl.pushHeader('ERP');
                                dl.headerTitle("培训管理"); 
                            }else if(type === 2){
                                //扫描进入物品领用的界面
                                dl.getGlobalModule({name: 'management/goods', params: params, cacheKey: ''});
                                dl.pushPageStack({name: 'home', params: '', cacheKey: 'home'});
                                dl.pushHeader('ERP');
                                dl.headerTitle("物品领用");
                            }
                            
                        }
                     }else{
                        //点击ERP  auto通知
                        self.selfClickErpMsg(params);
                     }
                };
                
                self.customMsgApproveClick = function(params){
                    if(dl.isNullOrUndefined(params['processInstanceId'])){
                        dl.getGlobalModule({name: 'home', params: '', cacheKey: 'home'});
                    }else{
                        var condition = {
                              opt_type: 'checkProcessByProcessInstanceId',
                              employeeId: dl.getEmployeeId(),
                              processInstanceId: params['processInstanceId']
                        };
                         dl.callOperation("EP_CheckUserinfoToLogin", "", condition, function (response) {
                             if(response.ResultSet.recordNumber > 0){
                                var data = dl.parseCollection(response);
                                self.rowData = data[0];
                                var pageName = dl.getProcessPageName(self.rowData['processType'], self.rowData['activityType']);
                                if (dl.isNullOrUndefined(pageName)) {
                                    dl.getGlobalModule({name: 'home', params: '', cacheKey: 'home'});
                                } else {
                                    dl.getGlobalModule({name: pageName, params: self, cacheKey: pageName});
                                    dl.pushPageStack({name: 'home', params: '', cacheKey: 'home'});
                                    dl.pushHeader('ERP');
                                    dl.headerTitle(self.getTitle(self.rowData['processType']));
                                }
                             }else{
                                 alert(response.ResultSet.errors);
                                 dl.getGlobalModule({name: 'home', params: '', cacheKey: 'home'});
                             }
                         });
                    }
                };
                
                self.selfClickErpMsg = function(params){
                    if (dl.isNullOrUndefined(params['id']) || dl.isNullOrUndefined(params['type'])) {
                        dl.getGlobalModule({name: 'home', params: '', cacheKey: 'home', cacheKey: 'home'});
                    } else {
                        var condition = {
                            currentPage: 0,
                            pageLines: 1
                        };
                        var action;
                        if (Number(params['type']) === 1) {//单个审批
                            action = 'ST_SystemProcessInstanceActivity';
                            condition['processInstanceActivityId'] = params['id'];
                        } else if (Number(params['type']) === 2) {//任务池审批
                            action = 'ST_SystemProcessPooledTask';
                            condition['processPooledTaskId'] = params['id'];
                        }
                        //查找出当前节点的详情数据
                        dl.callOperation(action, 'find', condition, function (response) {
                            if (response.ResultSet.status >= 0) {
                                var data = dl.parseCollection(response);
                                self.rowData = data[0];
                                if (dl.isNullOrUndefined(self.rowData)) {
                                    dl.getGlobalModule({name: 'home', params: '', cacheKey: 'home'});
                                } else {
                                    if (Number(self.rowData['status']) === 1) {
                                        //防止越权审批 需要进行节点人与登录人的判断
                                        if (dl.getEmployeeId() === self.rowData['employeeId']) {
                                            var pageName = dl.getProcessPageName(self.rowData['processType'], self.rowData['activityType']);
                                            if (dl.isNullOrUndefined(pageName)) {
                                                sc.alert('此流程手机端不支持审批，请移至电脑审批。')
                                                dl.getGlobalModule({name: 'home', params: '', cacheKey: 'home'});
                                            } else {
                                                dl.getGlobalModule({name: pageName, params: self, cacheKey: pageName});
                                                dl.pushPageStack({name: 'home', params: '', cacheKey: 'home'});
                                                dl.pushHeader('ERP');
                                                dl.headerTitle(self.getTitle(self.rowData['processType']));
                                            }
                                        }else{
                                            alert("请勿越权处理流程!");
                                            dl.getGlobalModule({name: 'home', params: '', cacheKey: 'home'});
                                        }
                                    } else {//当不为可审批状态的时候提示
                                        alert("该事项已处理!");
                                        dl.getGlobalModule({name: 'home', params: '', cacheKey: 'home'});
                                    }

                                }
                            } else {
                                dl.getGlobalModule({name: 'home', params: '', cacheKey: 'home'});
                            }
                        });
                    }
                };

                self.getTitle = function (processType) {
                    var title;
                    if (!dl.isNullOrUndefined(processType)) {
                        switch (Number(processType)) {
                            case 2://项目日常
                                title = "项目日常";
                                break;
                            case 3: //普通日常
                                title = "普通日常";
                                break;
                            case 4: //项目差旅
                                title = "项目差旅";
                                break;
                            case 5: //普通差旅
                                title = "普通差旅";
                                break;
                            case 6: //借款申请
                                title = "借款申请";
                                break;
                            case 7: //预付款申请
                                title = "预付款申请";
                                break;
                            case 8: //前期项目日常报销
                                title = "前期项目日常报销";
                                break;
                            case 9: //前期项目差旅报销
                                title = "前期项目差旅报销";
                                break;
                            default:
                                title = dl.getLabelByValue('employees', self.rowData['employeeId']) + self.rowData['businessName'];
                                break;
                        }
                    }
                    return title;
                };


                self.handleAttached = function (info) {
                    // Implement if needed
                };


                self.handleBindingsApplied = function (info) {
                    // Implement if needed
                };


                self.handleDetached = function (info) {
                    // Implement if needed
                };
            }


            return new LoginViewModel();
        }
);
