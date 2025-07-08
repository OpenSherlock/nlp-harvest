SET ROLE tq_admin;

CREATE SEQUENCE IF NOT EXISTS public.docux_id_seq
    AS bigint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE IF NOT EXISTS public.document (
	id 			BIGINT PRIMARY KEY NOT NULL DEFAULT nextval('public.docux_id_seq'::regclass),
	title		TEXT NOT NULL,
	data 		TEXT NOT NULL, -- json document metadata
	typ			TEXT NOT NULL,  -- one of 'conv' or 'doc
	pmcid		TEXT,
	pmid		TEXT,
	isProcessed boolean DEFAULT false,
	inProgress  boolean DEFAULT false

);

CREATE INDEX IF NOT EXISTS document_idx ON public.document (id, typ, title);

CREATE TABLE IF NOT EXISTS public.doc_id (
	id 			BIGINT NOT NULL REFERENCES  public.document (id),
	doc_id		TEXT NOT NULL
);

CREATE INDEX IF NOT EXISTS doc_id_idx ON public.doc_id (id, doc_id);



CREATE TABLE IF NOT EXISTS public.paragraph_id ( 
	doc_id		BIGINT NOT NULL REFERENCES  public.document (id),
	para_id		BIGINT NOT NULL
);

CREATE INDEX IF NOT EXISTS doc_para_idx ON public.paragraph_id (doc_id);

CREATE TABLE IF NOT EXISTS public.keyword ( 
	doc_id		BIGINT NOT NULL REFERENCES  public.document (id),
	keyword		TEXT NOT NULL
);

CREATE INDEX IF NOT EXISTS keyword_idx ON public.keyword (doc_id);




