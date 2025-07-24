package pomplatform.equipment.handler;

import org.apache.log4j.Logger;
import pomplatform.equipment.bean.BaseMequipmenttypeedeeeor;
import pomplatform.equipment.bean.ConditionMequipmenttypeedeeeor;
import pomplatform.equipment.query.QueryMequipmenttypeedeeeor;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pomplatform.equipment.bean.BaseMequipmentrecordedeor;
import pomplatform.equipment.bean.ConditionMequipmentrecordedeor;
import pomplatform.equipment.query.QueryMequipmentrecordedeor;
import delicacy.common.BaseCollection;

public class MequipmenttypeedeeeorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MequipmenttypeedeeeorHandler.class);

	public static BaseCollection<BaseMequipmenttypeedeeeor> executeQueryMequipmenttypeedeeeor(ConditionMequipmenttypeedeeeor c, KeyValuePair[] replacements ) throws Exception {
		QueryMequipmenttypeedeeeor dao = new QueryMequipmenttypeedeeeor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMequipmenttypeedeeeor> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMequipmenttypeedeeeor c = new ConditionMequipmenttypeedeeeor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMequipmenttypeedeeeor> result = executeQueryMequipmenttypeedeeeor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMequipmenttypeedeeeor> result;
		ConditionMequipmenttypeedeeeor c = new ConditionMequipmenttypeedeeeor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMequipmenttypeedeeeor dao = new QueryMequipmenttypeedeeeor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMequipmenttypeedeeeor.ALL_CAPTIONS);
			for(BaseMequipmenttypeedeeeor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


