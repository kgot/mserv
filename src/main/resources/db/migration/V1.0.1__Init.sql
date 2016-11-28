CREATE TABLE kino_draw (
  id BIGINT NOT NULL AUTO_INCREMENT,
  draw_no BIGINT,
  draw_time DATETIME,
  n01 SMALLINT,
  n02 SMALLINT,
  n03 SMALLINT,
  n04 SMALLINT,
  n05 SMALLINT,
  n06 SMALLINT,
  n07 SMALLINT,
  n08 SMALLINT,
  n09 SMALLINT,
  n10 SMALLINT,
  n11 SMALLINT,
  n12 SMALLINT,
  n13 SMALLINT,
  n14 SMALLINT,
  n15 SMALLINT,
  n16 SMALLINT,
  n17 SMALLINT,
  n18 SMALLINT,
  n19 SMALLINT,
  n20 SMALLINT,
  PRIMARY KEY (id),
  UNIQUE (draw_no),
  INDEX (draw_time)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;