/**
 * 
 */
package org.topicqucsts.asr.nlp.api;

import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 */
public interface IDataProvider {

	///////////////////
	// docunents
	///////////////////
	
	/**
	 * Will return docId
	 * @param docId can be {@code null}
	 * @param pmid 
	 * @param pmcid 
	 * @param title
	 * @param metadataJson
	 * @param docType 
	 * @return
	 */
	IResult putDoc(String docId, String pmid, String pmcid, String title, String metadataJson, String docType);
	
	IResult addParagraphId (long docId,  long paraId);
	
	IResult addKeyword(long docId, String keyword);
	
	/**
	 * Returns boolean
	 * @param docId
	 * @return
	 */
	IResult existsDocumentByID(String docId);
	
	/**
	 * Returns boolean
	 * @param title
	 * @return
	 */
	IResult existsDocumentByTitle(String title);
	
	///////////////////
	// paragraphs
	///////////////////
	
	/**
	 * Will return paraId
	 * @param docId
	 * @param anaphorJson
	 * @return
	 */
	IResult putParagraph(long docId, String anaphorJson);
	
	IResult addSentenceId(long paraId, long sentId);
	///////////////////
	// sentences
	///////////////////

	/**
	 * Will return sentId
	 * @param docId
	 * @param paraId
	 * @param text
	 * @return
	 */
	IResult putSentence(long docId, long paraId, String text);

}
