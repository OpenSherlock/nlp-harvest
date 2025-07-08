/**
 * 
 */
package ort.topicqucsts.asr.nlp.db;

import java.sql.ResultSet;

import org.topicquests.pg.PostgresConnectionFactory;
import org.topicquests.pg.api.IPostgresConnection;
import org.topicquests.support.ResultPojo;
import org.topicquests.support.api.IResult;

import ort.topicqucsts.asr.nlp.HarvestEnvironment;
import ort.topicqucsts.asr.nlp.api.IDataProvider;
import ort.topicqucsts.asr.nlp.api.ISQL;

/**
 * 
 */
public class DataProvider implements IDataProvider {
	private HarvestEnvironment environment;
	private PostgresConnectionFactory dbDriver = null;

	/**
	 * 
	 */
	public DataProvider(HarvestEnvironment env) {
		environment = env;
		dbDriver = environment.getDatabaseDriver();
	}

	@Override
	public IResult putDoc(String docId, String pmid, String pmcid, String title, String metadataJson, String docType) {
		IResult result = new ResultPojo();
		String sql = ISQL.PUT_PM_DOCUMENT;
		IPostgresConnection conn = null;
	    IResult r = new ResultPojo();
	    try {
	    	conn = dbDriver.getConnection();
			//r = conn.beginTransaction();
			//conn.setProxyRole(r);
			//title, data, typ
			Object [] vals = new Object [5];
			vals[0] = title;
			vals[1] = pmid;
			vals[2] = pmcid;
			vals[3] = metadataJson;
			vals[4] = docType;
			conn.executeSelect(sql, r, vals);
		    if (r.hasError())
				result.addErrorString(r.getErrorString());
		    ResultSet rs = (ResultSet)r.getResultObject();
		    if (rs != null) {
		    	if (rs.next()) {
		    		long id = rs.getLong("id");
		    		if (docId != null) {
			    		vals = new Object[2];
			    		vals[0] = id;
			    		vals[1] = docId;
			    		sql = ISQL.INSERT_DOC_ID;
			    		conn.executeSQL(sql,r,vals);
					    if (r.hasError())
							result.addErrorString(r.getErrorString());
		    		}
		    		result.setResultObject(new Long(id));
		    	}
		    		
		    }
		} catch (Exception e) {
			environment.logError(e.getMessage(), e);
			result.addErrorString(e.getMessage());
			e.printStackTrace();
		}
	    //conn.endTransaction(r);
	    conn.closeConnection(r);
		if (r.hasError())
			result.addErrorString(r.getErrorString());		
		return result;
	}

	@Override
	public IResult addParagraphId(long docId, long paraId) {
		IResult result = new ResultPojo();
		String sql = ISQL.ADD_PARA_ID;
		IPostgresConnection conn = null;
	    IResult r = new ResultPojo();
	    try {
	    	conn = dbDriver.getConnection();
			//r = conn.beginTransaction();
			//conn.setProxyRole(r);
			//doc_id, para_id
			Object [] vals = new Object [2];
			vals[0] = docId;
			vals[1] = paraId;
			conn.executeSQL(sql, r, vals);
		    if (r.hasError())
				result.addErrorString(r.getErrorString());
		} catch (Exception e) {
			environment.logError(e.getMessage(), e);
			result.addErrorString(e.getMessage());
			e.printStackTrace();
		}
	    //conn.endTransaction(r);
	    conn.closeConnection(r);
		if (r.hasError())
			result.addErrorString(r.getErrorString());		
		return result;
	}

	@Override
	public IResult addKeyword(long docId, String keyword) {
		IResult result = new ResultPojo();
		String sql = ISQL.ADD_KEYWORD;
		IPostgresConnection conn = null;
	    IResult r = new ResultPojo();
	    try {
	    	conn = dbDriver.getConnection();
			//r = conn.beginTransaction();
			//conn.setProxyRole(r);
			//doc_id, keyword
			Object [] vals = new Object [2];
			vals[0] = docId;
			vals[1] = keyword;
			conn.executeSQL(sql, r, vals);
		    if (r.hasError())
				result.addErrorString(r.getErrorString());
		} catch (Exception e) {
			environment.logError(e.getMessage(), e);
			result.addErrorString(e.getMessage());
			e.printStackTrace();
		}
	    //conn.endTransaction(r);
	    conn.closeConnection(r);
		if (r.hasError())
			result.addErrorString(r.getErrorString());		
		return result;
	}

	@Override
	public IResult putParagraph(long docId, String anaphorJson) {
		IResult result = new ResultPojo();
		String sql = ISQL.PUT_PARAGRAPH;
		IPostgresConnection conn = null;
	    IResult r = new ResultPojo();
	    try {
	    	conn = dbDriver.getConnection();
			//r = conn.beginTransaction();
			//conn.setProxyRole(r);
			//doc_id, data
			Object [] vals = new Object [2];
			vals[0] = docId;
			vals[1] = anaphorJson;
			conn.executeSelect(sql, r, vals);
		    if (r.hasError())
				result.addErrorString(r.getErrorString());
		    ResultSet rs = (ResultSet)r.getResultObject();
		    if (rs != null) {
		    	if (rs.next())
		    		result.setResultObject(new Long(rs.getLong("id")));
		    }
		} catch (Exception e) {
			environment.logError(e.getMessage(), e);
			result.addErrorString(e.getMessage());
			e.printStackTrace();
		}
	    //conn.endTransaction(r);
	    conn.closeConnection(r);
		if (r.hasError())
			result.addErrorString(r.getErrorString());
		return result;
	}

	@Override
	public IResult addSentenceId(long paraId, long sentId) {
		IResult result = new ResultPojo();
		String sql = ISQL.ADD_SENT_ID;
		IPostgresConnection conn = null;
	    IResult r = new ResultPojo();
	    try {
	    	conn = dbDriver.getConnection();
			//r = conn.beginTransaction();
			//conn.setProxyRole(r);
			//ddoc_id, sent_id
			Object [] vals = new Object [2];
			vals[0] = paraId;
			vals[1] = sentId;
			conn.executeSQL(sql, r, vals);
		    if (r.hasError())
				result.addErrorString(r.getErrorString());
		} catch (Exception e) {
			environment.logError(e.getMessage(), e);
			result.addErrorString(e.getMessage());
			e.printStackTrace();
		}
	    //conn.endTransaction(r);
	    conn.closeConnection(r);
		if (r.hasError())
			result.addErrorString(r.getErrorString());		
		return result;
	}

	@Override
	public IResult putSentence(long docId, long paraId, String text) {
		IResult result = new ResultPojo();
		String sql = ISQL.PUT_SENTENCE;
		IPostgresConnection conn = null;
	    IResult r = new ResultPojo();
	    try {
	    	conn = dbDriver.getConnection();
			//r = conn.beginTransaction();
			//conn.setProxyRole(r);
			//doc_id, para_id, text
			Object [] vals = new Object [3];
			vals[0] = docId;
			vals[1] = paraId;
			vals[2] = text;
			conn.executeSelect(sql, r, vals);
		    if (r.hasError())
				result.addErrorString(r.getErrorString());
		    ResultSet rs = (ResultSet)r.getResultObject();
		    if (rs != null) {
		    	if (rs.next())
		    		result.setResultObject(new Long(rs.getLong("id")));
		    }
		} catch (Exception e) {
			environment.logError(e.getMessage(), e);
			result.addErrorString(e.getMessage());
			e.printStackTrace();
		}
	    //conn.endTransaction(r);
	    conn.closeConnection(r);
		if (r.hasError())
			result.addErrorString(r.getErrorString());		
		return result;
	}

	@Override
	public IResult existsDocumentByID(String docId) {
		IResult result = new ResultPojo();
		result.setResultObject(new Boolean(false)); // default
		String sql = ISQL.EXIST_BY_ID;
		IPostgresConnection conn = null;
	    IResult r = new ResultPojo();
	    try {
	    	conn = dbDriver.getConnection();
			//r = conn.beginTransaction();
			//conn.setProxyRole(r);
			//doc_id, data
			Object [] vals = new Object [1];
			vals[0] = docId;
			conn.executeSelect(sql, r, vals);
		    if (r.hasError())
				result.addErrorString(r.getErrorString());
		    ResultSet rs = (ResultSet)r.getResultObject();
		    if (rs != null && rs.next()) 
		    	result.setResultObject(new Boolean(true));
		    
		} catch (Exception e) {
			environment.logError(e.getMessage(), e);
			result.addErrorString(e.getMessage());
			e.printStackTrace();
		}
	    //conn.endTransaction(r);
	    conn.closeConnection(r);
		if (r.hasError())
			result.addErrorString(r.getErrorString());
		return result;	
	}

	@Override
	public IResult existsDocumentByTitle(String title) {
		IResult result = new ResultPojo();
		result.setResultObject(new Boolean(false)); // default
		String sql = ISQL.EXIST_BY_TITLE;
		IPostgresConnection conn = null;
	    IResult r = new ResultPojo();
	    try {
	    	conn = dbDriver.getConnection();
			//r = conn.beginTransaction();
			//conn.setProxyRole(r);
			//doc_id, data
			Object [] vals = new Object [1];
			vals[0] = title;
			conn.executeSelect(sql, r, vals);
		    if (r.hasError())
				result.addErrorString(r.getErrorString());
		    ResultSet rs = (ResultSet)r.getResultObject();
		    if (rs != null && rs.next()) 
		    	result.setResultObject(new Boolean(true));
		    
		} catch (Exception e) {
			environment.logError(e.getMessage(), e);
			result.addErrorString(e.getMessage());
			e.printStackTrace();
		}
	    //conn.endTransaction(r);
	    conn.closeConnection(r);
		if (r.hasError())
			result.addErrorString(r.getErrorString());
		return result;
	}


}
