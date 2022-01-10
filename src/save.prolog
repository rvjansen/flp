forall(clause(p(X), Body), write_clause(p(X) :- Body)).
write_clause(Head :- true) :-
    !,
    \+ \+ ( numbervars(Head, 1, _, [singletons(true)]),
              write_term(current_output, Head, [ full_stop(true), newline(true), numbervars(true), quoted(true)]) ).
write_clause(Head :- Body) :-
    \+ \+ ( numbervars((Head:- Body), 1, _, [singletons(true)]),
              write_term(current_output, (Head :- Body), [ full_stop(true), newline(true), numbervars(true), quoted(true)]) ).
