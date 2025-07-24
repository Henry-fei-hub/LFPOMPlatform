define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojrouter', 'dl/Desjs', 'ojs/ojknockout', 'ojs/ojinputtext'],
        function (oj, ko, $, dl) {

            function LoginViewModel() {
                var self = this;
                self.nameValue = ko.observable('');
                self.passwordsValue = ko.observable('');

                self.loginClicked = function (data, event) {
                    var name = data.nameValue();
                    var passwords = data.passwordsValue();
                    var params = {
                        employeeNo: name,
                        employeePassword: passwords,
                        applicationId: 1
                    };
                    var dd = new DE();
                    dd.init("19770922");
                    var encParams = dd.ENC(JSON.stringify(params));
                    self.callOperation("EP_EmployeeLogin", "login", encParams, self.datareceived);

                };
                self.callOperation = function (operationName, subaction, data, callback, observableVar) {
                    if (subaction === null || subaction === undefined || subaction === '') {
                        subaction = 'find';
                    }
                    var sendData = {action: operationName, subaction: subaction};
                    if (data === null || data === undefined) {
                        data = {};
                    }
                    sendData.content = encodeURIComponent(data);
                    $.ajax({url: dl._SERVERURL,
//                        jsonp: "callback",
                        // Tell jQuery we're expecting JSONP
                        dataType: "json",
                        type: "POST",
                        data: sendData,
                        success: function (resp) {
//                            resp = decodeURIComponent(resp);
//                            var jsono =JSON.parse(resp) ;
                            var jsono = resp;
                            callback(jsono, observableVar);
                        }
                    });
                };

                self.datareceived = function (response) {
                    if (response.ResultSet.status >= 0) {
                        //  localStorage.setItem('nameId', name);
                        var userInfo = dl.parseCollection(response)[0];
                        dl.setUserInfo(userInfo);
                        dl.setUserInfoToLocalStorage(userInfo);
                        dl.getGlobalModule({name: 'home', params: self});
                    } else {
                        alert(response.ResultSet.errors);
                    }
                };

                self.handleActivated = function (info) {
                    // Implement if needed
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