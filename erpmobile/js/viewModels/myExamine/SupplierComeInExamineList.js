
define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojcollectiontabledatasource'],
        function (oj, ko, $, dl) {

            function SupplierComeInExamineListViewModel(params) {
                var self = this;
                self.viewModelName = 'SupplierComeInExamineListViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();
                self.normalData = ko.observable();
                
                self.goPage = function (type, businessId) {
                    var processType = params.processType;
                    var pageName;
                    var id = businessId; //业务主键
//                  每个报销特有businessId
                    var d = dl.findCurrentDataByAttr(id, 'businessId', self.normalData());
                    if (dl.isNullOrUndefined(d)) {
                        return;
                    }
                    pageName = dl.getProcessPageName(processType, 2);
                    if (dl.isNullOrUndefined(pageName)) {
                        return;
                    }
                    //表示从我的已审过去的
                    d['pageFlag'] = 1;
                    self.rowData = d;
                     
                    //把每次点击的module存在数组中 也不是单纯的模块名
                    dl.pushPageStack({name: "myExamine/SupplierComeInExamineList", params: self.parentViewModel});
                    dl.getGlobalModule({name: pageName, params: self});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle(dl.headerTitle());
                };

                self.iClicked = function (data, event) {
                    self.normalData(data);
                    var target = event.currentTarget;
                    var id = target.id; //业务主键
                    self.goPage(1, id);
                };
            
                self.returnTitle = function (data) {
                 if(data['processType'] == 53 ||  data['processTypeName'].indexOf('供应商入库')>=0){
                        return  data['supplierName'] + '('+ data['supplierContact']+')';
                    }
                };

                self.processString = function (ss) {
                    var s = "";
                    for (var i = 0; i < ss.length; i++) {
                        if (ss[i] === '+')
                            s += ' ';
                        else
                            s += ss[i];
                    }
                    return s;
                };

              
                //                放查询条件
                self.searchData = {
                    employeeId: dl.getEmployeeId(),
                        'processType':self.parentViewModel.processType,
                         keyValues:[{key:'spia.status =?', value:'spia.status =? and spia.status in (2,3,4,5,6)'},
                                   {key:'sppt.status =?', value:'sppt.status =? and sppt.status in (2,3,4,5,6)'}]
                };
                SupplierComeInApplyListModel = oj.Model.extend({
                    parse: dl.parseModel,
                    idAttribute: 'processInstanceActivityId'
                });

                SupplierComeInApplyListCollection = oj.Collection.extend({
                    model: new SupplierComeInApplyListModel(),
                    parse: dl.parseCollection,
                    fetchSize: 10,
                    customPagingOptions: dl.parsePaging,
                    queryAction: 'NQ_AuditSupplierInfo',
                    url: dl._SERVERURL
                });
                self.collection = new SupplierComeInApplyListCollection();
                self.dataSource = new oj.CollectionTableDataSource(self.collection);
                self.collection.generateCondition = function () {
                    return self.searchData;
                };


                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                    // Implement if needed
                };


                self.handleAttached = function (info) {
                 
                };



                self.handleBindingsApplied = function (info) {

                    // Implement if needed
                };


                self.handleDetached = function (info) {
                    // Implement if needed
                };

            }
            return SupplierComeInExamineListViewModel;
        }
);


