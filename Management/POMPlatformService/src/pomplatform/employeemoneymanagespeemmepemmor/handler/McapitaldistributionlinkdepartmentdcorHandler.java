package pomplatform.employeemoneymanagespeemmepemmor.handler;

import org.apache.log4j.Logger;
import pomplatform.employeemoneymanagespeemmepemmor.bean.BaseMcapitaldistributionlinkdepartmentdcor;
import pomplatform.employeemoneymanagespeemmepemmor.bean.ConditionMcapitaldistributionlinkdepartmentdcor;
import pomplatform.employeemoneymanagespeemmepemmor.query.QueryMcapitaldistributionlinkdepartmentdcor;
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

public class McapitaldistributionlinkdepartmentdcorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(McapitaldistributionlinkdepartmentdcorHandler.class);

	public static BaseCollection<BaseMcapitaldistributionlinkdepartmentdcor> executeQueryMcapitaldistributionlinkdepartmentdcor(ConditionMcapitaldistributionlinkdepartmentdcor c, KeyValuePair[] replacements ) throws Exception {
		QueryMcapitaldistributionlinkdepartmentdcor dao = new QueryMcapitaldistributionlinkdepartmentdcor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMcapitaldistributionlinkdepartmentdcor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMcapitaldistributionlinkdepartmentdcor c = new ConditionMcapitaldistributionlinkdepartmentdcor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMcapitaldistributionlinkdepartmentdcor> result = executeQueryMcapitaldistributionlinkdepartmentdcor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMcapitaldistributionlinkdepartmentdcor> result;
		ConditionMcapitaldistributionlinkdepartmentdcor c = new ConditionMcapitaldistributionlinkdepartmentdcor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMcapitaldistributionlinkdepartmentdcor dao = new QueryMcapitaldistributionlinkdepartmentdcor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMcapitaldistributionlinkdepartmentdcor.ALL_CAPTIONS);
			for(BaseMcapitaldistributionlinkdepartmentdcor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


