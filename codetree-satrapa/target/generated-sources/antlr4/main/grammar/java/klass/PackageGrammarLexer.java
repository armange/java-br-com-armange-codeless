// Generated from PackageGrammar.g4 by ANTLR 4.4
package main.grammar.java.klass;
package br.com.armange.codetree.satrapa.grammar.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PackageGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, SUB_PACKAGE=2, WS=3, LC_LETTER=4, NUMBER=5, UNDERSCORE=6;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'"
	};
	public static final String[] ruleNames = {
		"T__0", "SUB_PACKAGE", "WS", "UC_LETTER", "LC_LETTER", "NUMBER", "UNDERSCORE"
	};


	public PackageGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PackageGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\b=\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\3\3\3\3\3\7\3"+
		"\27\n\3\f\3\16\3\32\13\3\3\3\6\3\35\n\3\r\3\16\3\36\3\3\3\3\3\3\6\3$\n"+
		"\3\r\3\16\3%\3\3\6\3)\n\3\r\3\16\3*\5\3-\n\3\3\4\6\4\60\n\4\r\4\16\4\61"+
		"\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\2\2\t\3\3\5\4\7\5\t\2\13\6\r"+
		"\7\17\b\3\2\7\4\2\13\13\"\"\3\2C\\\3\2c|\3\2\62;\3\2aaB\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\3\21\3\2"+
		"\2\2\5,\3\2\2\2\7/\3\2\2\2\t\65\3\2\2\2\13\67\3\2\2\2\r9\3\2\2\2\17;\3"+
		"\2\2\2\21\22\7\60\2\2\22\4\3\2\2\2\23\24\5\17\b\2\24\25\5\r\7\2\25\27"+
		"\3\2\2\2\26\23\3\2\2\2\27\32\3\2\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31\34"+
		"\3\2\2\2\32\30\3\2\2\2\33\35\5\13\6\2\34\33\3\2\2\2\35\36\3\2\2\2\36\34"+
		"\3\2\2\2\36\37\3\2\2\2\37-\3\2\2\2 !\5\17\b\2!\"\5\r\7\2\"$\3\2\2\2# "+
		"\3\2\2\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2\2&-\3\2\2\2\')\5\13\6\2(\'\3\2\2"+
		"\2)*\3\2\2\2*(\3\2\2\2*+\3\2\2\2+-\3\2\2\2,\30\3\2\2\2,#\3\2\2\2,(\3\2"+
		"\2\2-\6\3\2\2\2.\60\t\2\2\2/.\3\2\2\2\60\61\3\2\2\2\61/\3\2\2\2\61\62"+
		"\3\2\2\2\62\63\3\2\2\2\63\64\b\4\2\2\64\b\3\2\2\2\65\66\t\3\2\2\66\n\3"+
		"\2\2\2\678\t\4\2\28\f\3\2\2\29:\t\5\2\2:\16\3\2\2\2;<\t\6\2\2<\20\3\2"+
		"\2\2\t\2\30\36%*,\61\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}