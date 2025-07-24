package pomplatform.employee.business;

import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeEducationInformation;
import com.pomplatform.db.dao.EmployeeEducationInformation;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import pomplatform.hr.bean.BaseForEmpManageExportData;
import pomplatform.hr.bean.ConditionForEmpManageExportData;
import pomplatform.hr.query.QueryForEmpManageExportData;

public class OnDownloadEmployeeInfo implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnDownloadEmployeeInfo.class);

	public static BaseCollection<BaseForEmpManageExportData> executeQueryEmployeeInfo(ConditionForEmpManageExportData c, KeyValuePair[] replacements ) throws Exception {
		QueryForEmpManageExportData dao = new QueryForEmpManageExportData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseForEmpManageExportData> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionForEmpManageExportData c = new ConditionForEmpManageExportData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseForEmpManageExportData> result = executeQueryEmployeeInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseForEmpManageExportData> result;
		ConditionForEmpManageExportData c = new ConditionForEmpManageExportData();
		c.setDataFromJSON(creteria);
		QueryForEmpManageExportData dao = new QueryForEmpManageExportData();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseForEmpManageExportData.EMPLOYEE_DOWNLOAD_CAPTIONS);
			EmployeeEducationInformation edao = new EmployeeEducationInformation();
			List<BaseEmployeeEducationInformation> list = null;
			for(BaseForEmpManageExportData b : result.getCollections()){
				if(b.getEmployeeId() != 0){
					edao.clear();
					edao.setConditionEmployeeId("=", b.getEmployeeId());
					list = new ArrayList<>();
					list = edao.conditionalLoad(" order by end_date desc");
					if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
						BaseEmployeeEducationInformation last = list.get(0);
						b.setGraduatedSchool(last.getGraduatedSchool());
						b.setSpecialty(last.getSpecialty());
						b.setEndDate(last.getEndDate());
					}
					ps.println(b.toCSVString());
				}
			}
			
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


