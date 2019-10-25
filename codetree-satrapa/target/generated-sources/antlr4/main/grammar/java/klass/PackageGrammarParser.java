// Generated from PackageGrammar.g4 by ANTLR 4.4
package main.grammar.java.klass;
package br.com.armange.codetree.satrapa.grammar.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PackageGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, SUB_PACKAGE=2, WS=3, LC_LETTER=4, NUMBER=5, UNDERSCORE=6;
	public static final String[] tokenNames = {
		"<INVALID>", "'.'", "SUB_PACKAGE", "WS", "LC_LETTER", "NUMBER", "UNDERSCORE"
	};
	public static final int
		RULE_packages = 0;
	public static final String[] ruleNames = {
		"packages"
	};

	@Override
	public String getGrammarFileName() { return "PackageGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PackageGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class PackagesContext extends ParserRuleContext {
		public TerminalNode SUB_PACKAGE(int i) {
			return getToken(PackageGrammarParser.SUB_PACKAGE, i);
		}
		public List<TerminalNode> SUB_PACKAGE() { return getTokens(PackageGrammarParser.SUB_PACKAGE); }
		public PackagesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packages; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PackageGrammarListener ) ((PackageGrammarListener)listener).enterPackages(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PackageGrammarListener ) ((PackageGrammarListener)listener).exitPackages(this);
		}
	}

	public final PackagesContext packages() throws RecognitionException {
		PackagesContext _localctx = new PackagesContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_packages);
		int _la;
		try {
			int _alt;
			setState(14);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2); match(SUB_PACKAGE);
					}
					}
					setState(5); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==SUB_PACKAGE );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(9); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(7); match(SUB_PACKAGE);
						setState(8); match(T__0);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(11); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(13); match(SUB_PACKAGE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\b\23\4\2\t\2\3\2"+
		"\6\2\6\n\2\r\2\16\2\7\3\2\3\2\6\2\f\n\2\r\2\16\2\r\3\2\5\2\21\n\2\3\2"+
		"\2\2\3\2\2\2\24\2\20\3\2\2\2\4\6\7\4\2\2\5\4\3\2\2\2\6\7\3\2\2\2\7\5\3"+
		"\2\2\2\7\b\3\2\2\2\b\21\3\2\2\2\t\n\7\4\2\2\n\f\7\3\2\2\13\t\3\2\2\2\f"+
		"\r\3\2\2\2\r\13\3\2\2\2\r\16\3\2\2\2\16\17\3\2\2\2\17\21\7\4\2\2\20\5"+
		"\3\2\2\2\20\13\3\2\2\2\21\3\3\2\2\2\5\7\r\20";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}