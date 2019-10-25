lexer grammar FormattingArtifact;

@header {package br.com.armange.codetree.satrapa.grammar.parser;}

WS                  : [ \t]+ -> skip ;

fragment
UC_LETTER           : [A-Z] ;
LC_LETTER           : [a-z] ;
NUMBER              : [0-9] ;
UNDERSCORE          : [_];