# The Papiament[o|u|s] Repository

This is a short explanation how the code works.

## The facts file
The central repository is a file containing Prolog dyadic
predicates. It is called __facts.pl__ - most of the time, for casual query
use, we load a compiled version called __facts.qlf__. This compiled format is proprietary to SWI Prolog.

The compilation can be done by starting swipl and run a
```prolog
qcompile(facts).
```
this takes a few minutes and returns __True.__ This file can be read into a Prolog workspace in a few seconds, with
```
swipl -f facts
```
We then can ask questions using __swipl__, but due to the fact that Prolog only returns the next result and we have to press the ';' key, we use the __KBServer__ server process and the __srepl__ read-evaluate-print loop processor.  

## PostgreSQL table

When KBServer starts up, it reads a table, called *predicates*, writes it to a file called factsTest.pl and *consults* that. The KBClients API can then remotely been used (over RMI) to query and update the Prolog theory.
```SQL
create table predicate
(
  predicate  char(38) not null,
  subject    char(38) not null,
  object     varchar(5000) not null,
  eff_dt     timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
  end_dt     timestamp with time zone NOT NULL DEFAULT 'infinity'	
);
```
The table is *effective dated* so we also can keep older values (that have moved out of the validity window) in it; deletes are logical deletes.
__Predicate__ and __Subject__ are always UUID's; __Object__ can contain descriptors and can be longer. The __DataAccess__ singleton object knows all about the database and handles all SQL.

# Prolog queries
The metamodel is composed of dyadic (binary) relationships and contains the domain model and also the instances of it. The __tree.class__ program lists the model. The file __code.prolog__ contains the rules and predicates to work with the model.

Relationships between __lemmata__ are taken from *WordNet*, *MultiWordnet* and other sources - the words from Papiamanto are from the official government sources for the islands of Aruba and Curaçao.

## Some examples of Prolog queries
