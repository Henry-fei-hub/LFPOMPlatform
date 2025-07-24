

_SERVERURL =  "/DelicacyServlet";
_LOCALURL = "http://127.0.0.1:6137/DelicacyServlet";
_KEYVALUEMANAGERSERICE = "NQ_DomainValue";
_GLOBALDOMAINNAME = "JANDAVALUE";
_DOMAINUPDATETIME = "DOMAINUPDATETIME";

// 全局变量，用来保存换存在客户端的所有下拉数据选项
_KEYVALUE = {};

_CALLBACK_FUNCTIONS = [];

addCallbackFunction = function (funcName) {
    _CALLBACK_FUNCTIONS.push({functionName: funcName, status: 0});
}

changeCallbackFunctionToComplete = function (funcName) {
    for (var i = 0; i < _CALLBACK_FUNCTIONS.length; i++) {
        if (_CALLBACK_FUNCTIONS[i].functionName === funcName) {
            _CALLBACK_FUNCTIONS[i].status = 1;
            break;
        }
    }
}

removeCompletedCallbacks = function () {
    for (var i = 0; i < _CALLBACK_FUNCTIONS.length; i++) {
        if (_CALLBACK_FUNCTIONS[i].status === 0)
            continue;
        delete self[_CALLBACK_FUNCTIONS[i].functionName];
    }
}

// 执行通用的后台数据服务调用
// operationName: 后台服务名
// subaction: 主要用于单表操作的类型，find -- 查询， save -- 新建， update -- 修改， delete -- 删除
// data: 发往后台的数据
// callback: 操作完成后的数据处理程序
// observableVar：操作完成后需要设置的Knockout变量
callOperation = function (operationName, subaction, data, callback) {
    console.log('begin to load data background ...' + Date.now());
    if (subaction === null || subaction === undefined || subaction === '') {
        subaction = 'find';
    }
    var callbackName = 'delicacy' + Math.round(Math.random() * 1000000) + Date.now();
    addCallbackFunction(callbackName);
    self[callbackName] = function (resp) {
        var jsonName;
        if (resp.indexOf("&&&") > 0) {
            var ress = resp.split("&&&");
            jsonName = ress[0];
            resp = decodeURIComponent(ress[1]);
        } else {
            resp = decodeURIComponent(resp);
        }
        console.log(resp.length);
        var s = "";
        for (var i = 0; i < resp.length; i++) {
            if (resp[i] === '\n')
                continue;
            s += resp[i];
        }

        var jsono = JSON.parse(s);
        callback(jsono);
        changeCallbackFunctionToComplete(jsonName);
    };

    if (data === null || data === undefined) {
        data = {};
    }

    var sb = new StringBuilder();
    sb.append(_SERVERURL);
    sb.append('?callback=');
    sb.append(callbackName);
    sb.append('&action=');
    sb.append(operationName);
    sb.append('&subaction=');
    sb.append(subaction);
    sb.append('&content=');
    sb.append(encodeURIComponent(JSON.stringify(data)));
    var url = sb.toString();

    importScripts(url);

};

StringBuilder = function (value)
{
    this.strings = new Array("");
    this.append(value);
};

// Appends the given value to the end of this instance.
StringBuilder.prototype.append = function (value)
{
    if (value)
    {
        this.strings.push(value);
    }
};

// Clears the string buffer
StringBuilder.prototype.clear = function ()
{
    this.strings.length = 1;
};

// Converts this instance to a String.
StringBuilder.prototype.toString = function ()
{
    return this.strings.join("");
};

keyValueCallback = function (resp) {
    var arr = parseCollection(resp);
    genaretDropdownValues(arr);
    console.log('send data to the main ...' + Date.now());
    postMessage(_KEYVALUE);
};

pausecomp = function (millis)
{
    var date = new Date();
    var curDate = null;
    do {
        curDate = new Date();
    } while (curDate - date < millis);
};

parseCollection = function (response) {
    return response['ResultSet']['Result'];
};

genaretDropdownValues = function (arr) {
    for (var i = 0; i < arr.length; i++) {
        var obj = arr[i];
        if (_KEYVALUE[obj.tableName] === undefined) {
            _KEYVALUE[obj.tableName] = {};
            _KEYVALUE[obj.tableName].status = 0;
            _KEYVALUE[obj.tableName].data = [];
            _KEYVALUE[obj.tableName].lastUpdateTime = new Date();
        } else {
            if (_KEYVALUE[obj.tableName].status !== 0) {
                _KEYVALUE[obj.tableName].status = 0;
                _KEYVALUE[obj.tableName].data = [];
                _KEYVALUE[obj.tableName].lastUpdateTime = new Date();
            }
        }
        var noption = {value: obj.keyColumn, label: obj.valueColumn};
        if (obj.conditionColumn)
            noption.parent = obj.conditionColumn;
        _KEYVALUE[obj.tableName].data.push(noption);
    }
    for (var opt in _KEYVALUE) {
        if (_KEYVALUE.hasOwnProperty(opt)) {
            _KEYVALUE[opt].status = 1;
        }
    }
};

for (var i = 0; i < 1; i++) {
    callOperation(_KEYVALUEMANAGERSERICE, '', {loadOnStartup: true}, keyValueCallback);
    pausecomp(10000);
}




