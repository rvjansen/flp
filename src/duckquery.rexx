/* rexx */
i6stem=''; i6stem=i6stem
i6stem[0]=2
o6utstem=''
i6stem[1]='.open words.db'
i6stem[2]='select predicate from predicate;'
address system 'duckdb' with -
  input stem i6stem -
  output stem o6utstem

say o6utstem.1

