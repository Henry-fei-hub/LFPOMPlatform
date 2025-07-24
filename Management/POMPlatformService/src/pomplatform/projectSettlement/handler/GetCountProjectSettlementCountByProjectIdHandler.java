package pomplatform.projectSettlement.handler;

import org.apache.log4j.Logger;
import pomplatform.projectSettlement.bean.BaseGetCountProjectSettlementCountByProjectId;
import pomplatform.projectSettlement.bean.ConditionGetCountProjectSettlementCountByProjectId;
import pomplatform.projectSettlement.query.QueryGetCountProjectSettlementCountByProjectId;
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

public class GetCountProjectSettlementCountByProjectIdHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(GetCountProjectSettlementCountByProjectIdHandler.class);

	public static BaseCollection<BaseGetCountProjectSettlementCountByProjectId> executeQueryGetCountProjectSettlementCountByProjectId(ConditionGetCountProjectSettlementCountByProjectId c, KeyValuePair[] replacements ) throws Exception {
		QueryGetCountProjectSettlementCountByProjectId dao = new QueryGetCountProjectSettlementCountByProjectId();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseGetCountProjectSettlementCountByProjectId> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionGetCountProjectSettlementCountByProjectId c = new ConditionGetCountProjectSettlementCountByProjectId();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseGetCountProjectSettlementCountByProjectId> result = executeQueryGetCountProjectSettlementCountByProjectId(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseGetCountProjectSettlementCountByProjectId> result;
		ConditionGetCountProjectSettlementCountByProjectId c = new ConditionGetCountProjectSettlementCountByProjectId();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryGetCountProjectSettlementCountByProjectId dao = new QueryGetCountProjectSettlementCountByProjectId();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGetCountProjectSettlementCountByProjectId.ALL_CAPTIONS);
			for(BaseGetCountProjectSettlementCountByProjectId b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


