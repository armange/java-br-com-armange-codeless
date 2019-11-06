package br.com.armange.codetree.satrapa.draft;

import org.apache.deltaspike.core.api.config.ConfigResolver;

public class Draft {

    public static void main(String[] args) {
        System.out.println(
                ConfigResolver
                    .resolve("br.com.armange.codetree.satrapa.v1")
                    .getValue());
        
        System.out.println(
                ConfigResolver
                    .resolve("br.com.armange.codetree.satrapa.v2")
                    .getValue());
    }
}
