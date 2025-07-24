
"use strict";
define(['ojs/ojcore', 'jquery'],
        function (oj, $) {
            /**
             * @private
             */
            var __scope = {};

            /**
             * @private
             */
            var __oldVal = __scope['sc'];
            var sc = __scope['sc'] =
                    {
                        'build': "0",
                        'revision': "00000",
                        'noConflict': function ()
                        {
                            __scope['sc'] = __oldVal;
                        }

                    };

            sc.alert = function (msg, callback) {
                sc.generateHtml("alert", msg);
                sc.btnOk(callback);
            };
            sc.confirm = function (msg, callback, cancelBack) {
                sc.generateHtml("confirm", msg);
                sc.btnOk(callback);
                sc.btnNo(cancelBack);
            };
            sc.prompt = function (msg, callback, cancelBack, el) {
                sc.generateHtml("prompt", msg, null, null, el);
                sc.btnOk(callback);
                sc.btnNo(cancelBack);
            };
            sc.setPromptValue = function (val) {
                $("#sc_msgbox_input_value").val(val);
            };
            sc.customConfirm = function (msg, confirmStr, cancelStr, callback, cancelBack) {
                sc.generateHtml("confirm", msg, confirmStr, cancelStr);
                sc.btnOk(callback);
                sc.btnNo(cancelBack);
            };

            sc.isNullOrUndefined = function (val) {
                if (val === undefined)
                    return true;
                if (val === null)
                    return true;
                return false;
            };

                       //生成Html
            sc.generateHtml = function (type, msg, _confirm, _cancel, el) {
                var _html = "";
                if(sc.isNullOrUndefined(_confirm))
                    _confirm = "确认";
                if(sc.isNullOrUndefined(_cancel))
                    _cancel = "取消";
                var _msg = sc.isNullOrUndefined(msg) ? "is sure？" : msg;
                _html += '<div id="mb_box"></div><div id="mb_con"><div>';
                _html += '<div id="mb_msg">' + _msg + '</div><div id="mb_btnbox">';

                if (type === "alert") {
                    _html += "<input id=\"mb_btn_ok_alert\" type=\"button\" value=\"" + _confirm + "\" />";
                } else if (type === "confirm") {
                    _html += "<input id=\"mb_btn_ok\" type=\"button\" value=\"" + _confirm + "\" />";
                    _html += "<input id=\"mb_btn_no\" type=\"button\" value=\"" + _cancel + "\" />";
                } else if(type === "prompt"){
                    _html += "<input id=\"sc_msgbox_input_value\" type=\"text\" /></br>";
                    _html += "<input id=\"mb_btn_ok_prompt\" type=\"button\" value=\"" + _confirm + "\" />";
                    _html += "<input id=\"mb_btn_no_prompt\" type=\"button\" value=\"" + _cancel + "\" />";
                }
                _html += '</div></div></div>';

                //必须先将_html添加到body，再设置Css样式
                if(sc.isNullOrUndefined(el)){
                    $("body").append(_html);
                }else{
                    $(el).append(_html); 
                }
               
                sc.generateCss();
            };

            //生成Css
            sc.generateCss = function () {
                $("#sc_msgbox_input_value").css({
                    height: '28px',
                    lineHeight: '28px',
                    textAlign: 'center',
                    border: '1px solid #ccc',
                    borderRadius: '4px',
                    display: 'block',
                    width: '90%',
                    marginLeft: '5%'
                });

                $("#mb_box").css({
                    width: '100%',
                    height: '100%',
                    zIndex: '999998',
                    position: 'fixed',
                    filter: 'Alpha(opacity=60)',
                    backgroundColor: 'black',
                    top: '0',
                    left: '0',
                    opacity: '0.6'
                });

                $("#mb_con").css({
                    zIndex: '999999',
                    minHeight: '160px',
                    width: '400px',
                    position: 'fixed',
                    backgroundColor: 'White',
                    borderRadius: '8px',
                    display: 'flex',
                    alignItems: 'center',
                    justifyContent: 'center'
                });

                $("#mb_msg").css({
                    padding: '20px 5px',
                    lineHeight: '20px',
                    textAlign: 'center',
                    fontSize: '16px',
                    wordBreak: 'break-all'
                });

                $("#mb_btnbox").css({margin: '0px 0 10px 0', textAlign: 'center'});
                $("#mb_btn_ok_alert").css({
                    cursor: 'pointer;width: 80px',
                    width: '80px',
                    height: '28px',
                    lineHeight: '28px',
                    textAlign: 'center',
                    border: '1px solid #fa9632',
                    background: '#fa9632',
                    borderRadius: '8px',
                    color: '#fff'

                });

                $("#mb_btn_ok_prompt").css({
                    cursor: 'pointer;width: 80px',
                    width: '80px',
                    height: '28px',
                    lineHeight: '28px',
                    textAlign: 'center',
                    border: '1px solid #fa9632',
                    background: '#fa9632',
                    borderRadius: '8px',
                    color: '#fff'

                });

                $("#mb_btn_ok").css({
                    cursor: 'pointer;width: 80px',
                    width: '80px',
                    height: '28px',
                    lineHeight: '28px',
                    textAlign: 'center',
                    border: '1px solid #fa9632',
                    background: '#fa9632',
                    borderRadius: '8px',
                    marginRigth: '10px',
                    color: '#fff'

                });
                $("#mb_btn_no").css({
                    cursor: 'pointer',
                    width: '80px',
                    height: '28px',
                    lineHeight: '28px',
                    textAlign: 'center',
                    border: '1px solid #eee',
                    background: '#eee',
                    borderRadius: '8px',
                    marginLeft: '10px',
                    color: '#333'
                });

                $("#mb_btn_no_prompt").css({
                    cursor: 'pointer',
                    width: '80px',
                    height: '28px',
                    lineHeight: '28px',
                    textAlign: 'center',
                    border: '1px solid #eee',
                    background: '#eee',
                    borderRadius: '8px',
                    marginLeft: '25px',
                    color: '#333'
                });

                var _widht = document.documentElement.clientWidth; //屏幕宽
                var _height = document.documentElement.clientHeight; //屏幕高

                var boxWidth = $("#mb_con").width();
                var boxHeight = $("#mb_con").height();

                //让提示框居中
                $("#mb_con").css({top: (_height - boxHeight) / 2 + "px", left: (_widht - boxWidth) / 2 + "px"});
            };


            //确定按钮事件
            sc.btnOk = function (callback) {
                $("#mb_btn_ok").click(function () {
                    $("#mb_box,#mb_con").remove();
                    if (!sc.isNullOrUndefined(callback) && typeof (callback) === 'function') {
                        callback();
                    }
                });
                $("#mb_btn_ok_alert").click(function () {
                    $("#mb_box,#mb_con").remove();
                    if (!sc.isNullOrUndefined(callback) && typeof (callback) === 'function') {
                        callback();
                    }
                });
                $("#mb_btn_ok_prompt").click(function () {
                    //获取文本框值
                     var value = $("#sc_msgbox_input_value").val();
                    $("#mb_box,#mb_con").remove();
                    if (!sc.isNullOrUndefined(callback) && typeof (callback) === 'function') {
                        callback(value);
                    }
                });
            };

            //取消按钮事件
            sc.btnNo = function (callback) {
                $("#mb_btn_no").click(function () {
                    $("#mb_box,#mb_con").remove();
                    if (!sc.isNullOrUndefined(callback) && typeof (callback) === 'function') {
                        callback();
                    }
                });
                $("#mb_btn_no_prompt").click(function () {
                    $("#mb_box,#mb_con").remove();
                    if (!sc.isNullOrUndefined(callback) && typeof (callback) === 'function') {
                        callback();
                    }
                });
            };
            return sc;
        });



