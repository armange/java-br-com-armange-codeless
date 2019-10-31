grammar ArrayInit;
@header {package br.com.armange.starter;}


init    : '{' value (',' value)* '}' ;
value   : init
        | INT
        ;
INT     : [0-9]+ ;
WS      : [ \t\r\n]+ -> skip ;