package pomplatform.project.handler;

import org.apache.log4j.Logger;
import pomplatform.project.bean.BasepreProjectRecordRemark;
import pomplatform.project.bean.ConditionpreProjectRecordRemark;
import pomplatform.project.query.QuerypreProjectRecordRemark;
import pomplatform.soutdesignconsiderationoor.handler.SoutdesignconsiderationoorHandler;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;

public class preProjectRecordRemarkHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(preProjectRecordRemarkHandler.class);

	public static BaseCollection<BasepreProjectRecordRemark> executeQuerypreProjectRecordRemark(ConditionpreProjectRecordRemark c, KeyValuePair[] replacements ) throws Exception {
		QuerypreProjectRecordRemark dao = new QuerypreProjectRecordRemark();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasepreProjectRecordRemark> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionpreProjectRecordRemark c = new ConditionpreProjectRecordRemark();
		c.setDataFromJSON(creteria);
		BaseCollection<BasepreProjectRecordRemark> result = executeQuerypreProjectRecordRemark(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasepreProjectRecordRemark> result;
		ConditionpreProjectRecordRemark c = new ConditionpreProjectRecordRemark();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerypreProjectRecordRemark dao = new QuerypreProjectRecordRemark();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		/*if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}*/
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasepreProjectRecordRemark.EXITPORT_CAPTIONS);
			String infoCode = "";
			List<BasepreProjectRecordRemark> list=result.getCollections();
			for(BasepreProjectRecordRemark bean : list) {
				if(BaseHelpUtils.getString(bean.getInfoCode()).equals(infoCode)) {
					bean.setDepartmentId(null);
					bean.setProjectSalesTeam(null);
					bean.setApplyEmployeeId(null);
					bean.setRegisterDate(null);
					bean.setInfoCode(null);
					bean.setProjectName(null);
					bean.setBusinessType(null);
					bean.setIsOriginal(null);
					bean.setCustomerName(null);
					bean.setProvince(null);
					bean.setCity(null);
					bean.setContactName(null);
					bean.setContactPhone(null);
					bean.setEstimateTheDesignAreas(null);
					bean.setGrade(null);
					bean.setProjectLeader(null);
					bean.setProjectManager(null);
					bean.setWinRate(null);
					bean.setProjectOrigination(null);
					bean.setProjectOriginationRemark(null);
				}else {
					infoCode = bean.getInfoCode();
				}
				ps.println(bean.toCSVString());
			}

		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


