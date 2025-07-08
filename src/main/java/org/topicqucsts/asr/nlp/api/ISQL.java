/**
 * 
 */
package org.topicqucsts.asr.nlp.api;

/**
 * 
 */
public interface ISQL {
	public static final String

	PUT_PM_DOCUMENT =
			"iNSERT INTO public.document (title, pmid,pmcid, data, typ) "
			+ "VALUES(?, ?, ?, ?, ?) RETURNING id",
	INSERT_DOC_ID =
		"INSERT INTO public.doc_id (id, doc_id) VALUES(?, ?)",
	ADD_PARA_ID =
		"iNSERT INTO public.paragraph_id (doc_id, para_id) VALUES(?, ?)",
		
	ADD_KEYWORD =
		"iNSERT INTO public.keyword (doc_id, keyword) VALUES(?, ?)",
		
	EXIST_BY_ID =
		"SELECT id FROM public.doc_id WHERE doc_id=?",

	EXIST_BY_TITLE =
		"SELECT id FROM public.document WHERE title=?",

	PUT_PARAGRAPH =
		"iNSERT INTO public.paragraph (doc_id, data) VALUES(?, ?) RETURNING id",
	ADD_SENT_ID =
		"iNSERT INTO public.sentence_id (para_id, sent_id) VALUES(?, ?)",
	PUT_SENTENCE =
		"iNSERT INTO public.sentence (doc_id, para_id, text) VALUES(?, ?, ?) RETURNING id";
}
