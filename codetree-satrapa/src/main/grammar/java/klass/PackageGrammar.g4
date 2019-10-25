grammar PackageGrammar;
import FormattingArtifact;

packages            : SUB_PACKAGE+
                    | (SUB_PACKAGE '.')+ SUB_PACKAGE
                    ;
                    
SUB_PACKAGE         : (UNDERSCORE NUMBER)* LC_LETTER+
                    | (UNDERSCORE NUMBER)+
                    | LC_LETTER+
                    ;