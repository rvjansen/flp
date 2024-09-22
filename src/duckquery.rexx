/* rexx */
instem=''; instem=instem
instem.0=3
outstem=''
instem.1='.mode column'
instem.2='.open words.db'
instem.3= "select predicate, object from predicate where object = 'aardappel' ;"

address system 'duckdb' with input stem instem. output stem outstem.

loop i=1 to outstem.0
  say '|'outstem.i'|'
end
