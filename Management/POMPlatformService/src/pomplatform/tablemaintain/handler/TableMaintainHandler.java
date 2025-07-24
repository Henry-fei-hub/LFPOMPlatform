package pomplatform.tablemaintain.handler;

import org.apache.log4j.Logger;
import pomplatform.tablemaintain.bean.BaseTableMaintain;
import pomplatform.tablemaintain.bean.ConditionTableMaintain;
import pomplatform.tablemaintain.query.QueryTableMaintain;
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

public class TableMaintainHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(TableMaintainHandler.class);

	public static BaseCollection<BaseTableMaintain> executeQueryTableMaintain(ConditionTableMaintain c, KeyValuePair[] replacements ) throws Exception {
		QueryTableMaintain dao = new QueryTableMaintain();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseTableMaintain> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionTableMaintain c = new ConditionTableMaintain();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseTableMaintain> result = executeQueryTableMaintain(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseTableMaintain> result;
		ConditionTableMaintain c = new ConditionTableMaintain();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryTableMaintain dao = new QueryTableMaintain();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseTableMaintain.ALL_CAPTIONS);
			for(BaseTableMaintain b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


