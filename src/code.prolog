% ob/2 finds everything that is an object, regardless (not constrained to) of type
% it returns the Object UUID and the Object Type UUID
ob(X,Y) :-
	'8701860C-F92A-495B-A0BF-C76316DE647C'(X,Y).

nm(X,Y) :-
	'ADFD9D7F-A05F-4DB3-8B40-C7813D3900DC'(X,Y).
abbr(X,Y) :-
	'1117CCE0-1A5D-11E3-8B81-0A0027000000'(X,Y).
def(X,Y) :-
	'2120B840-1A5D-11E3-9BFD-0A0027000000'(X,Y).
%descriptor describes object
desc(X,Y) :-
	'89184770-1A5C-11E3-9DFC-0A0027000000'(X,Y).
% classifies: classifier classified
% classification classifies object
cl(X,Y) :-
	'9A2CD86A-FF9F-415C-9DED-1D86CB6710E9'(X,Y).

% classification classifies object
scheme(X) :-
	ob(X,'E138A197-7645-4B90-A6EB-B9C61DBA08D1').

% scope includes object
scope(X) :-
	ob(X,'A912E940-1AF7-11E3-96BD-0A0027000000').

% domain/2 is used to find the domains of a scheme -> domain(X,UUID)
% also, finds the scheme of a domain -> domain(UUID,Y)
domain(X,Z) :-
	scheme(Z),'400B08AB-786D-45D4-AFD7-34933CA6131F'(X,Z).

% supertp/3 finds the super type(s) of a concept. it does this by
% finding the subject type(s) of the partitioning relationship type(s)
supertp(X,Y,Z) :-
	domain(X,Y),cl(Y,Z).

% attrs/4 is a shortcut to get to the local classification relationships/attributes of a type
% (the type needs to go in X)
attrs(N,X,Y,Z) :-
	nm(X,N),cl(Y,X),nm(Y,Z).

lang(X,Y) :-
	'3B5AD420-22FF-11E3-80E8-E0F847277696'(X,Y).

eng(X) :-
	lang(X,'3B65D0A0-22FF-11E3-80E8-E0F847277696').

lemmasynset(X,Y) :-
	'3B365C30-22FF-11E3-80E8-E0F847277696'(X,Y).

synsetnumber(X,Y) :-
	'61E5F500-23B5-11E3-8F69-E0F847277696'(X,Y).
	
look(Y,Definition) :-
	nm(X,Y),lemmasynset(X,Number),synsetnumber(Synset,Number),def(Synset,Definition).

pap(X) :-
	lang(X,'3B60C790-22FF-11E3-80E8-E0F847277696').

aru(X) :-
	'3B6BC410-22FF-11E3-80E8-E0F847277696'(X,'3B6D98D0-22FF-11E3-80E8-E0F847277696').

cur(X) :-
	'3B6BC410-22FF-11E3-80E8-E0F847277696'(X,'3B6D23A0-22FF-11E3-80E8-E0F847277696').

aru_official(X) :-
	'3B6E3510-22FF-11E3-80E8-E0F847277696'(X,'3B70CD20-22FF-11E3-80E8-E0F847277696').

cur_official(X) :-
	'3B6E3510-22FF-11E3-80E8-E0F847277696'(X,'3B6FBBB0-22FF-11E3-80E8-E0F847277696').

por(X) :-
	lang(X,'3B644A00-22FF-11E3-80E8-E0F847277696').

spa(X) :-
	lang(X,'3B64BF30-22FF-11E3-80E8-E0F847277696').

cat(X) :-
	lang(X,'3B5F19E0-22FF-11E3-80E8-E0F847277696').

glg(X) :-
	lang(X,'3B697A20-22FF-11E3-80E8-E0F847277696').

cmn(X) :-
	lang(X,'3B631180-22FF-11E3-80E8-E0F847277696').

eus(X) :-
	lang(X,'3B6693F0-22FF-11E3-80E8-E0F847277696').

verb(X):-
	'3B374690-22FF-11E3-80E8-E0F847277696'(X,'3B38A620-22FF-11E3-80E8-E0F847277696').

noun(X):-
	'3B374690-22FF-11E3-80E8-E0F847277696'(X,'3B43F0C0-22FF-11E3-80E8-E0F847277696').

adjective(X):-
	'3B374690-22FF-11E3-80E8-E0F847277696'(X,'3B3A7AE0-22FF-11E3-80E8-E0F847277696').

adverb(X):-
	'3B374690-22FF-11E3-80E8-E0F847277696'(X,'3B3C0180-22FF-11E3-80E8-E0F847277696').

interjection(X):-
	'3B374690-22FF-11E3-80E8-E0F847277696'(X,'3B417FC0-22FF-11E3-80E8-E0F847277696').

article(X):-
	'3B374690-22FF-11E3-80E8-E0F847277696'(X,'3B42B840-22FF-11E3-80E8-E0F847277696').

dan(X):-
	lang(X,'3B655B70-22FF-11E3-80E8-E0F847277696').

fas(X):-
	lang(X,'3B673030-22FF-11E3-80E8-E0F847277696').

fin(X):-
	lang(X,'3B681A90-22FF-11E3-80E8-E0F847277696').

fra(X):-
	lang(X,'3B68B6D0-22FF-11E3-80E8-E0F847277696').

ind(X):-
	lang(X,'3B5B7060-22FF-11E3-80E8-E0F847277696').

ita(X):-
	lang(X,'3B5D6C30-22FF-11E3-80E8-E0F847277696').

jpn(X):-
	lang(X,'3B5FDD30-22FF-11E3-80E8-E0F847277696').

nno(X):-
	lang(X,'3B618AE0-22FF-11E3-80E8-E0F847277696').

nob(X):-
	lang(X,'3B627540-22FF-11E3-80E8-E0F847277696').

pol(X):-
	lang(X,'3B63ADC0-22FF-11E3-80E8-E0F847277696').

tha(X):-
	lang(X,'3B5C5AC0-22FF-11E3-80E8-E0F847277696').

zsm(X):-
	lang(X,'3B5E5690-22FF-11E3-80E8-E0F847277696').

