package pomplatform.goodsreceive.handler;

import org.apache.log4j.Logger;
import pomplatform.goodsreceive.bean.BaseGoodsreceive;
import pomplatform.goodsreceive.bean.ConditionGoodsreceive;
import pomplatform.goodsreceive.query.QueryGoodsreceive;
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

public class GoodsreceiveHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(GoodsreceiveHandler.class);

	public static BaseCollection<BaseGoodsreceive> executeQueryGoodsreceive(ConditionGoodsreceive c, KeyValuePair[] replacements ) throws Exception {
		QueryGoodsreceive dao = new QueryGoodsreceive();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseGoodsreceive> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionGoodsreceive c = new ConditionGoodsreceive();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseGoodsreceive> result = executeQueryGoodsreceive(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseGoodsreceive> result;
		ConditionGoodsreceive c = new ConditionGoodsreceive();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryGoodsreceive dao = new QueryGoodsreceive();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGoodsreceive.ALL_CAPTIONS);
			for(BaseGoodsreceive b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


