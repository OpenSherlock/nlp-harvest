SET ROLE tq_admin;


-- we are storing sentences as a JSONObject
CREATE TABLE IF NOT EXISTS public.sentence (
	id 		BIGINT PRIMARY KEY NOT NULL DEFAULT nextval('docux_id_seq'::regclass),
	para_id	BIGINT NOT NULL Default -1 REFERENCES  public.paragraph (id),
	doc_id	BIGINT NOT NULL Default -1 REFERENCES  public.document (id),
	text 	TEXT NOT NULL	-- json
);

CREATE INDEX IF NOT EXISTS sentence_idx ON public.sentence (id, para_id, doc_id);

CREATE TABLE IF NOT EXISTS public.statement (
	id 		BIGINT PRIMARY KEY NOT NULL DEFAULT nextval('docux_id_seq'::regclass),
	para_id	BIGINT NOT NULL Default -1 REFERENCES  public.paragraph (id),
	sent_id	BIGINT NOT NULL Default -1 REFERENCES  public.sentence (id),
	text 	TEXT NOT NULL	-- json
);

CREATE INDEX IF NOT EXISTS statement_idx ON public.statement (id, para_id, sent_id);
