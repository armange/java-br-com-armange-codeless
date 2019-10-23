package br.com.armange.codeless.objectbuilder.booleanbuilder;

import java.util.function.Function;

class ClosureOperating<T> {

    private final LogicOperator logicOperator;
    private final Function<T, Boolean> operatingClosure;
    
    ClosureOperating(final LogicOperator logicOperator, final Function<T, Boolean> operation) {
        this.logicOperator = logicOperator;
        this.operatingClosure = operation;
    }

    LogicOperator getLogicOperator() {
        return logicOperator;
    }

    Function<T, Boolean> getOperatingClosure() {
        return operatingClosure;
    }
}
