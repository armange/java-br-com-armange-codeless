package br.com.armange.codeless.objectbuilder.booleanbuilder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BooleanBuilder<T> {
    
    private Queue<ClosureOperating<T>> queue = new LinkedList<>();
    
    public BooleanBuilder(final Function<T, Boolean> initialClosure) {
        queue.add(new ClosureOperating<>(null, initialClosure));
    }
    
    public BooleanBuilder(final BooleanBuilder<T> booleanBuilder) {
        queue.add(new ClosureOperating<>(null, booleanBuilder::build));
    }
    
    public BooleanBuilder<T> and(final Function<T, Boolean> initialClosure) {
        queue.add(new ClosureOperating<>(LogicOperator.AND, initialClosure));
        
        return this;
    }
    
    public BooleanBuilder<T> or(final Function<T, Boolean> initialClosure) {
        queue.add(new ClosureOperating<>(LogicOperator.OR, initialClosure));
        
        return this;
    }
    
    public BooleanBuilder<T> xor(final Function<T, Boolean> initialClosure) {
        queue.add(new ClosureOperating<>(LogicOperator.XOR, initialClosure));
        
        return this;
    }
    
    public BooleanBuilder<T> and(final BooleanBuilder<T> booleanBuilder) {
        queue.add(new ClosureOperating<>(LogicOperator.AND, booleanBuilder::build));
        
        return this;
    }
    
    public BooleanBuilder<T> or(final BooleanBuilder<T> booleanBuilder) {
        queue.add(new ClosureOperating<>(LogicOperator.OR, booleanBuilder::build));
        
        return this;
    }
    
    public BooleanBuilder<T> xor(final BooleanBuilder<T> booleanBuilder) {
        queue.add(new ClosureOperating<>(LogicOperator.XOR, booleanBuilder::build));
        
        return this;
    }
    
    public boolean build(final T binaryOperating) {
        return queue
            .stream()
            .collect(
                    Collectors.reducing(
                            new BooleanOperating(), 
                            c -> new BooleanOperating(c, binaryOperating), 
                            (a, b) -> a.reduce(b)))
            .getValue();
    }
    
    public static <T> BooleanBuilder<T> grouping(final Function<T, Boolean> initialClosure) {
        return new BooleanBuilder<T>(initialClosure);
    }
    
    public static <T> BooleanBuilder<T> grouping(
            final Class<T> closureType, 
            final Function<T, Boolean> initialClosure) {
        return new BooleanBuilder<T>(initialClosure);
    }
    
    public static void main(String[] args) {
        final BooleanBuilder<String> teste = new BooleanBuilder<String>(s -> s.contains("a"))
                .and(s -> s.contains("w"))
                .or(s -> s.contains("e"));
        
        boolean b1 = teste.build("abv");
        boolean b2 = teste.build("anc");
        boolean b3 = teste.build("xnz");
        boolean b4 = teste.build("xnc");
        boolean b5 = teste.build("xbc");
        
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
        System.out.println(b5);
        
        final BooleanBuilder<String> teste2 = new 
                BooleanBuilder<String>(
                        grouping(String.class, s -> s.contains("a")).or(s -> s.contains("b")))
                    .and(grouping(String.class, s -> s.contains("y")).or(s -> s.contains("z")));
        
        boolean b6 = teste2.build("abv");
        boolean b7 = teste2.build("xyc");
        boolean b8 = teste2.build("ayz");
        boolean b9 = teste2.build("bzc");
        boolean b10 = teste2.build("abyz");
        
        System.out.println(b6 == false ? "OK" : "Err");
        System.out.println(b7 == false ? "OK" : "Err");
        System.out.println(b8 == true ? "OK" : "Err");
        System.out.println(b9 == true ? "OK" : "Err");
        System.out.println(b10 == true ? "OK" : "Err");
    }
}
