CREATE TABLE prodspecification
(
  productid integer,
  model character varying(20),
  CONSTRAINT prodspecification_productid_fkey FOREIGN KEY (productid)
      REFERENCES product (productid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE prodspecification
  OWNER TO admin;


CREATE TABLE product
(
  productid integer NOT NULL,
  productname character varying(30),
  price integer,
  brand character varying(20),
  imgpath character varying(500),
  CONSTRAINT product_pkey PRIMARY KEY (productid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE product
  OWNER TO admin;


CREATE TABLE roles
(
  roleid integer NOT NULL,
  rolename character varying(20),
  CONSTRAINT roles_pkey PRIMARY KEY (roleid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE roles
  OWNER TO admin;


REATE TABLE users
(
  username character varying(30),
  userid integer NOT NULL,
  password character varying(10),
  email character varying(20),
  roleid integer,
  CONSTRAINT users_pkey PRIMARY KEY (userid),
  CONSTRAINT users_roleid_fkey FOREIGN KEY (roleid)
      REFERENCES roles (roleid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE users
  OWNER TO admin;
