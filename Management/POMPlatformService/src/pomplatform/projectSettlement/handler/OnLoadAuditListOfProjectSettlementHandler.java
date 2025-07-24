package pomplatform.projectSettlement.handler;

import org.apache.log4j.Logger;
import pomplatform.projectSettlement.bean.BaseOnLoadAuditListOfProjectSettlement;
import pomplatform.projectSettlement.bean.ConditionOnLoadAuditListOfProjectSettlement;
import pomplatform.projectSettlement.query.QueryOnLoadAuditListOfProjectSettlement;
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

public class OnLoadAuditListOfProjectSettlementHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadAuditListOfProjectSettlementHandler.class);

	public static BaseCollection<BaseOnLoadAuditListOfProjectSettlement> executeQueryOnLoadAuditListOfProjectSettlement(ConditionOnLoadAuditListOfProjectSettlement c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadAuditListOfProjectSettlement dao = new QueryOnLoadAuditListOfProjectSettlement();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadAuditListOfProjectSettlement> result = dao.runQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadAuditListOfProjectSettlement c = new ConditionOnLoadAuditListOfProjectSettlement();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadAuditListOfProjectSettlement> result = executeQueryOnLoadAuditListOfProjectSettlement(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadAuditListOfProjectSettlement> result;
		ConditionOnLoadAuditListOfProjectSettlement c = new ConditionOnLoadAuditListOfProjectSettlement();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadAuditListOfProjectSettlement dao = new QueryOnLoadAuditListOfProjectSettlement();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadAuditListOfProjectSettlement.ALL_CAPTIONS);
			for(BaseOnLoadAuditListOfProjectSettlement b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


