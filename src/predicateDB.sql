-- predicates db for papiamento dictionary
drop table if exists predicate;
create table predicate
(
  predicate  char(38) not null,
  subject    char(38) not null,
  object     varchar(5000) not null,
  eff_dt     timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
  end_dt     timestamp with time zone NOT NULL DEFAULT 'infinity'	
);
