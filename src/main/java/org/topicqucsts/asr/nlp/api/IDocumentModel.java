/**
 * 
 */
package org.topicqucsts.asr.nlp.api;

import org.topicquests.asr.nlp.api.IDocument;
import org.topicquests.support.api.IResult;

import com.google.gson.JsonArray;

/**
 * @author jackpark
 *
 */
public interface IDocumentModel {
	public static final String
		GET_PMCID_TYPE		= "gpmcid",
		GET_PMID_TYPE		= "gpmid",
		GET_ISBN_TYPE		= "getisbn",
		GET_DOI_TYPE		= "getdoi",
		GET_NOUNS_TYPE		= "getnouns",
		GET_VERBS_TYPE		= "getverbs",
		GET_NOUN_TFIDF_TYPE	= "getntfidf",
		GET_VERB_TFIDF_TYPE	= "getvtfidf",
		SET_PMID_TYPE		= "setpmid",
		SET_PMCID_TYPE		= "setpmcid",
		SET_ISBN_TYPE		= "setisbn",
		SET_DOI_TYPE		= "setdoi",
		SET_NOUN_TFIDF_TYPE	= "setntfidf",
		SET_VERB_TFIDF_TYPE	= "setvtfidf",
		ADD_NOUN_TFIDF_TYPE	= "addntfidf",
		ADD_VERB_TFIDF_TYPE	= "addvtfidf";

	
	/**
	 * @param d
	 * @param listener
	 * @param code
	 */
	IResult putDocument(IDocument d);
	
	IResult getDocument(long id);
	
	IResult getDocumentByPMID(String pmid);
	IResult getDocumentByPMCID(String pmcid);
	IResult getDocumentByISBN(String isbn);
	IResult getDocumentByDOI(String doi);
	
	/**
	 * Returns array of {docId, nounId, count} or {@code null} ????
	 * @param id
	 * @return
	 */
	IResult getDocumentNouns(long id);
	/**
	 * Returns array of {docId, verbId, count} or {@code null}
	 * @param id
	 * @return
	 */
	IResult getDocumentVerbs(long id);
	/**
	 * Computes TFIDF on nouns<br/>
	 * Returns array of {docId, otherDocId, double} or {@code null}
	 * @param id
	 * @return
	 */
	IResult getDocumentNounTFIDF(long id);
	/**
	 * Computes TFIDF on verbs<br/>
	 * Returns array of {docId, otherDocId, double} or {@code null}
	 * @param id
	 * @return
	 */
	IResult getDocumentVerbTFIDF(long id);
	
	/////////////
	// sets use putFinished callback
	/////////////
	IResult setDocumentPMID(long id, String pmid);
	IResult setDocumentPMCID(long id, String pmcid);
	IResult setDocumentISBN(long id, String isbn);
	IResult setDocumentDOI(long id, String doi);
	
	IResult setDocumentNounTFIDFs(long id, JsonArray tfidfs);
	IResult setDocumentVerbTFIDFs(long id, JsonArray tfidfs);
	IResult addDocumentNounTFIDF(long id, long otherDocId, double tfidf);
	IResult addDocumentVerbTFIDF(long id, long otherDocId, double tfidf);


	IResult updateDocument(IDocument d);
}
