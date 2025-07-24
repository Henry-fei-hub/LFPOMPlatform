define(['ojs/ojcore', 'knockout', 'jquery', 'ojs/ojknockout',
	'ojs/ojinputtext', 'ojs/ojformlayout', 'ojs/ojselectcombobox', 'ojs/ojswitch'],
function(oj, ko, $) { 
	function ProjectStageTemplateNewModel(params) {
		self = this;
		self._labelEdge = ko.pureComputed(function() {
			return dl.lgScreen() ? "start" : "top";
		}, self);

		self._maxColumns = ko.pureComputed(function() {
			if(dl.lgScreen()) return 3;
			if(dl.mdScreen()) return 2;
			return 1;
		}, self);

		self.viewModelName = 'ProjectStageTemplate';
		self.parentViewModel = params;
		if(dl.isNullOrUndefined(self.parentViewModel.details)) self.parentViewModel.details = [];
		var thisViewModel = {name: 'ProjectStageTemplate', data: self, detailType: dl._DETAILTYPE_ADD};
		dl.addViewModelToParentDetails(self.parentViewModel.details, thisViewModel);

		self.setDataToControls = function () {
			var selectedItem = dl.getNamedSelectedData(self.viewModelName);
			if (selectedItem !== null) {
				dl.copyDataToControls(selectedItem, self);
			}
		};

		self.setEditValues= function (val) {
			dl.putNewCreatedData(self.viewModelName, val);
		};

		self.getEditValues= function () {
			return dl.getAllModelData(self);
		};

		self.setDefaultValues = function () {
		};

		self.__projectStageTemplateId = ko.observable();
		self.__projectStageTemplateId.dataType = 'integer';
		self.__projectStageTemplateName = ko.observable();
		self.__projectStageTemplateName.dataType = 'string';
		self.__plateId = ko.observable();
		self.__plateId.dataType = 'integer';
		self.__projectId = ko.observable();
		self.__projectId.dataType = 'integer';
		self.__projectType = ko.observable();
		self.__projectType.dataType = 'integer';
		self.__remark = ko.observable();
		self.__remark.dataType = 'string';

		self.handleActivated = function (info) {
			console.log('handle ProjectStageTemplate Activated --- '+ self.parentViewModel.viewModelName);
		};

		self.handleAttached = function (info) {
			console.log('handle ProjectStageTemplate Attached --- '+ self.parentViewModel.viewModelName);
		};

		self.handleBindingsApplied = function (info) {
			console.log('handle ProjectStageTemplate BindingsApplied --- '+ self.parentViewModel.viewModelName);
		};

		self.handleDetached = function (info) {
			console.log('handle ProjectStageTemplate Detached --- '+ self.parentViewModel.viewModelName);
		};

		self.setDefaultValues();
	}
	return ProjectStageTemplateNewViewModel;
});
