CREATE TABLE public.hospitalenquiry
(
    pid integer NOT NULL,
    pname character varying COLLATE pg_catalog."default",
    age integer,
    gender character varying COLLATE pg_catalog."default",
    address character varying COLLATE pg_catalog."default",
    problem character varying COLLATE pg_catalog."default",
    doctor character varying COLLATE pg_catalog."default",
    contactnumber integer,
    wardnumber integer,
    CONSTRAINT hospitalenquiry_pkey PRIMARY KEY (pid)
)

TABLESPACE pg_default;

ALTER TABLE public.hospitalenquiry
    OWNER to postgres;