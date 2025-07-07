/**
 * 
 */
package ort.topicqucsts.asr.nlp.models;

import org.topicquests.asr.nlp.api.IDocument;
import org.topicquests.asr.nlp.api.IResult;

import com.google.gson.JsonArray;

import ort.topicqucsts.asr.nlp.HarvestEnvironment;
import ort.topicqucsts.asr.nlp.api.IDocumentModel;

/**
 * 
 */
public class DocumentModel implements IDocumentModel {
	private HarvestEnvironment environment;

	/**
	 * 
	 */
	public DocumentModel(HarvestEnvironment env) {
		environment = env;
	}

	@Override
	public IResult putDocument(IDocument d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult getDocument(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult getDocumentByPMID(String pmid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult getDocumentByPMCID(String pmcid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult getDocumentByISBN(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult getDocumentByDOI(String doi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult getDocumentNouns(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult getDocumentVerbs(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult getDocumentNounTFIDF(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult getDocumentVerbTFIDF(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult setDocumentPMID(long id, String pmid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult setDocumentPMCID(long id, String pmcid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult setDocumentISBN(long id, String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult setDocumentDOI(long id, String doi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult setDocumentNounTFIDFs(long id, JsonArray tfidfs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult setDocumentVerbTFIDFs(long id, JsonArray tfidfs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult addDocumentNounTFIDF(long id, long otherDocId, double tfidf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult addDocumentVerbTFIDF(long id, long otherDocId, double tfidf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IResult updateDocument(IDocument d) {
		// TODO Auto-generated method stub
		return null;
	}

}
