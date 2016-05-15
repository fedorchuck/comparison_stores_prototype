CREATE TABLE product
(
  id serial NOT NULL,
  name text NOT NULL,
  CONSTRAINT product_pkey PRIMARY KEY (id)
)
WITH (
OIDS=FALSE
);
CREATE TABLE store
(
  id serial NOT NULL,
  name text NOT NULL,
  CONSTRAINT store_pkey PRIMARY KEY (id)
)
WITH (
OIDS=FALSE
);
CREATE TABLE storyOfChangePrice
(
  id serial NOT NULL,
  m1 DOUBLE PRECISION,
  m2 DOUBLE PRECISION,
  m3 DOUBLE PRECISION,
  m4 DOUBLE PRECISION,
  CONSTRAINT storyOfChangePrice_pkey PRIMARY KEY (id)
)
WITH (
OIDS=FALSE
);