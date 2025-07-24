define(['ojs/ojcore', 'knockout', 'jquery', 'ojs/ojselectcombobox', 'ojs/ojinputtext', 'ojs/ojcheckboxset', 'ojs/ojdatetimepicker', 'ojs/ojinputnumber','dl/commclient'],
	function (oj, ko, $) {
		function SearchSsystemprocessporViewModel(params){
			var self = this;
			self.viewModelName = 'searchssystemprocesspor';
			self.parentViewModel = params.data;
			if(dl.isNullOrUndefined(self.parentViewModel.searchforms)) self.parentViewModel.searchforms = [];
			var thisViewModel = {name: 'searchssystemprocesspor', data: self};
			dl.addViewModelToParentDetails(self.parentViewModel.searchforms, thisViewModel);

			self.setDataToControls = function () {
				if (self.parentViewModel.searchData) {
					dl.copyDataToControls(self.parentViewModel.searchData, self);
				}
			};

			self.setDataFromControls = function () {
				if (!self.parentViewModel.searchData) {
					self.parentViewModel.searchData = {};
				}
				dl.copyDataFromControls(self.parentViewModel.searchData, self);
			};

			self.setDefaultValues = function () {
				self.__processTypeId(0);
			};

			self.__processTypeId = ko.observable();
			self.__processTypeId.dataType = 'integer';

			self.handleActivated = function (info) {
			};

			self.handleAttached = function (info) {
			};

			self.handleBindingsApplied = function (info) {
				self.setDataToControls();
			};

			self.handleDetached = function (info) {
				self.setDataFromControls();
			};

			self.setDefaultValues();
		}
		return SearchSsystemprocessporViewModel;
	}
);
