package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BaseOnLoadPersonnelFlowDetail;
import pomplatform.workflow.bean.ConditionOnLoadPersonnelFlowDetail;
import pomplatform.workflow.query.QueryOnLoadPersonnelFlowDetail;
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

public class OnLoadPersonnelFlowDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadPersonnelFlowDetailHandler.class);

	public static BaseCollection<BaseOnLoadPersonnelFlowDetail> executeQueryOnLoadPersonnelFlowDetail(ConditionOnLoadPersonnelFlowDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadPersonnelFlowDetail dao = new QueryOnLoadPersonnelFlowDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadPersonnelFlowDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadPersonnelFlowDetail c = new ConditionOnLoadPersonnelFlowDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadPersonnelFlowDetail> result = executeQueryOnLoadPersonnelFlowDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadPersonnelFlowDetail> result;
		ConditionOnLoadPersonnelFlowDetail c = new ConditionOnLoadPersonnelFlowDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadPersonnelFlowDetail dao = new QueryOnLoadPersonnelFlowDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadPersonnelFlowDetail.ALL_CAPTIONS);
			for(BaseOnLoadPersonnelFlowDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


