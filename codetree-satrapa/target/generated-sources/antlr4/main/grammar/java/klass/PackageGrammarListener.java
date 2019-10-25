// Generated from PackageGrammar.g4 by ANTLR 4.4
package main.grammar.java.klass;
package br.com.armange.codetree.satrapa.grammar.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PackageGrammarParser}.
 */
public interface PackageGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PackageGrammarParser#packages}.
	 * @param ctx the parse tree
	 */
	void enterPackages(@NotNull PackageGrammarParser.PackagesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PackageGrammarParser#packages}.
	 * @param ctx the parse tree
	 */
	void exitPackages(@NotNull PackageGrammarParser.PackagesContext ctx);
}