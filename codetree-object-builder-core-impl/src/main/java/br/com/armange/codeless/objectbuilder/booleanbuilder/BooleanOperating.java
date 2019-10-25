package br.com.armange.codeless.objectbuilder.booleanbuilder;

class BooleanOperating {

    private final LogicOperator logicOperator;
    private Boolean value;
    
    BooleanOperating() {
        this.logicOperator = null;
    }
    
    <T> BooleanOperating(
            final ClosureOperating<T> binaryOperatingClosure, 
            final T binaryOperating) {
        this.logicOperator = binaryOperatingClosure.getLogicOperator();
        this.value = binaryOperatingClosure.getOperatingClosure().apply(binaryOperating);
    }

    BooleanOperating reduce(final BooleanOperating booleanOperating) {
        if (this.value == null) {
            this.value = booleanOperating.value;
        } else {
            switch(booleanOperating.logicOperator) {
            case AND:
                this.value = this.value && booleanOperating.value;
                break;
            case OR:
                this.value = this.value || booleanOperating.value;
                break;
            default:
                this.value = this.value ^ booleanOperating.value;
            }
        }
        
        return this;
    }
    
    LogicOperator getLogicOperator() {
        return logicOperator;
    }

    Boolean getValue() {
        return value;
    }
}
