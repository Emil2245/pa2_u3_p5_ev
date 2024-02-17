package com.uce.edu.avanzada.pa2_u3_p5_ev;

import com.uce.edu.avanzada.pa2_u3_p5_ev.funcional.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Supplier--------------------");
        //clase
        IPersonaSupplier<String> supplierClase = new PersonaSupplierImpl();
        System.out.println(supplierClase.getid());

        //lambda
        IPersonaSupplier<String> supplierLambda = () -> {
            String cedula = "0943580394";
            return cedula + "canton";
        };
        System.out.println(supplierLambda.getid());

        //lambda 2
        IPersonaSupplier<String> supplierLambda2 = () -> "0943580394" + "pais";
        System.out.println(supplierLambda2.getid());

        //
        IPersonaSupplier<Integer> supplierLambda3 = () -> {
            Integer valor = Integer.valueOf(100);
            valor = valor * Integer.valueOf(55);
            return valor;
        };
        System.out.println(supplierLambda3.getid());

        //
        System.out.println("Consumer--------------------");
        //clase
        IPersonaConsumer<String> personaConsumer = new PersonaConsumerImpl();
        personaConsumer.accept("Profesor");

        //lambda
        IPersonaConsumer<String> consumerLambda = cadena -> System.out.println("Se inserta: "+cadena);

        //Predicate
        System.out.println("Predicate--------------------");
        IPersonaPredicate<Integer> predicateLambda = numero-> numero.compareTo(6)==0;
        IPersonaPredicate<String> predicateLambda2 = palabra -> palabra.contains("E");
        System.out.println(predicateLambda.evaluar(6));
        System.out.println(predicateLambda2.evaluar("Emil"));

        System.out.println("Predicate--------------------");





        //Metodos Referenciados

    }
}
