define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/msgbox', 'dl/workflow', 'ojs/ojknockout', 'promise'],
        function (oj, ko, $, dl, sc) {
            function attachmentViewModel(params) {
                var self = this;
                self.viewModelName = 'attachmentViewModel';
                self.parentViewModel = params;
                self.src = ko.observable(params.attachment());
                self.setIframeHeight = function (id) {
                    try {
                        var iframe = document.getElementById(id);
                        if (iframe.attachEvent) {
                            iframe.attachEvent("onload", function () {
                                iframe.height = iframe.contentWindow.document.documentElement.scrollHeight;
                            });
                            return;
                        } else {
                            iframe.onload = function () {
                                iframe.height = iframe.contentDocument.body.scrollHeight;
                            };
                            return;
                        }
                    } catch (e) {
                        console.warn('setIframeHeight Error');
                    }
                };
                self.setIframeContent = function (id) {
                    try {
                        var iframe = document.getElementById(id);
                        if (iframe.attachEvent) {
                            iframe.attachEvent("onload", function () {
                                console.log(iframe.contentWindow.document.body.innerHTML);
                               document.getElementById("iframeInner").innerHTML=iframe.contentWindow.document.body.innerHTML;
                            });
                            return;
                        } else {
                            iframe.onload = function () {
                               document.getElementById("iframeInner").innerHTML=iframe.contentDocument.body.innerHTML;
                            };
                            return;
                        }
                    } catch (e) {
                        console.warn('setIframeHeight Error');
                    }
                };
                self.handleActivated = function (info) {
                };
                self.handleAttached = function (info) {
//                       self.setIframeHeight('media');
//                    self.setIframeContent('media');
                };
                self.handleBindingsApplied = function (info) {
//                    document.getElementById('media').onload = function () {
//                        debugger;
//                               document.getElementById("iframeInner").innerHTML=iframe.contentDocument.body.innerHTML;
//                            };       
                };
                self.handleDetached = function (info) {
                };
            }
            return attachmentViewModel;
        }
);




