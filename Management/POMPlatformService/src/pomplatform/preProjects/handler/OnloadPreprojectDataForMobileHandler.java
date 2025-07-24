package pomplatform.preProjects.handler;

import org.apache.log4j.Logger;
import pomplatform.preProjects.bean.BaseOnloadPreprojectDataForMobile;
import pomplatform.preProjects.bean.ConditionOnloadPreprojectDataForMobile;
import pomplatform.preProjects.query.QueryOnloadPreprojectDataForMobile;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;

public class OnloadPreprojectDataForMobileHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnloadPreprojectDataForMobileHandler.class);

	public static BaseCollection<BaseOnloadPreprojectDataForMobile> executeQueryOnloadPreprojectDataForMobile(ConditionOnloadPreprojectDataForMobile c, KeyValuePair[] replacements ) throws Exception {
		QueryOnloadPreprojectDataForMobile dao = new QueryOnloadPreprojectDataForMobile();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnloadPreprojectDataForMobile> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnloadPreprojectDataForMobile c = new ConditionOnloadPreprojectDataForMobile();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnloadPreprojectDataForMobile> result = executeQueryOnloadPreprojectDataForMobile(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnloadPreprojectDataForMobile> result;
		ConditionOnloadPreprojectDataForMobile c = new ConditionOnloadPreprojectDataForMobile();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnloadPreprojectDataForMobile dao = new QueryOnloadPreprojectDataForMobile();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnloadPreprojectDataForMobile.ALL_CAPTIONS);
			for(BaseOnloadPreprojectDataForMobile b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


