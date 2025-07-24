package pomplatform.attentionsupplierinfo.handler;

import org.apache.log4j.Logger;
import pomplatform.attentionsupplierinfo.bean.BaseAttentionSupplierInfo;
import pomplatform.attentionsupplierinfo.bean.ConditionAttentionSupplierInfo;
import pomplatform.attentionsupplierinfo.query.QueryAttentionSupplierInfo;
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

public class AttentionSupplierInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(AttentionSupplierInfoHandler.class);

	public static BaseCollection<BaseAttentionSupplierInfo> executeQueryAttentionSupplierInfo(ConditionAttentionSupplierInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryAttentionSupplierInfo dao = new QueryAttentionSupplierInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseAttentionSupplierInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionAttentionSupplierInfo c = new ConditionAttentionSupplierInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseAttentionSupplierInfo> result = executeQueryAttentionSupplierInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseAttentionSupplierInfo> result;
		ConditionAttentionSupplierInfo c = new ConditionAttentionSupplierInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryAttentionSupplierInfo dao = new QueryAttentionSupplierInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseAttentionSupplierInfo.ALL_CAPTIONS);
			for(BaseAttentionSupplierInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


