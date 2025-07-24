package delicacy.solr;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

public class SolrUtils {
	public static final String SOLR_URL = "http://120.76.211.72:8998/solr/pre_projects";

	public static SolrClient getHttpSolrClient() {
		return new HttpSolrClient.Builder(SOLR_URL).withConnectionTimeout(1000).withSocketTimeout(6000).build();
	}
}
