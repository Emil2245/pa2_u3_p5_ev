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
        personaConsumer.acceptar("Profesor");

        //lambda
        IPersonaConsumer<String> consumerLambda = cadena -> System.out.println("Se inserta: "+cadena);

        //Predicate
        System.out.println("Predicate--------------------");
        IPersonaPredicate<Integer> predicateLambda = numero-> numero.compareTo(6)==0;
        IPersonaPredicate<String> predicateLambda2 = palabra -> palabra.contains("E");
        System.out.println(predicateLambda.evaluar(6));
        System.out.println(predicateLambda2.evaluar("Emil"));

        System.out.println("Function--------------------");
        IPersonaFunction<String, Integer> functionLambda = numero ->{
            numero = numero + Integer.valueOf(699);
            String numString= numero.toString();
            return numString;
        };
        System.out.println(functionLambda.aplicar(40));

        IPersonaFunction<Empleado,Ciudadano> function = ciudadano->{
          Empleado empleado = new Empleado();
          empleado.setNombreCompleto(ciudadano.getNombre()+" "+ciudadano.getAplellido());
          if (ciudadano.getProvincia().compareTo("pichincha")==0)
              empleado.setPais("Ecuador");
          return empleado;
        };

        Ciudadano ciudadano = new Ciudadano();
        ciudadano.setAplellido("Verkade");
        ciudadano.setNombre("Emil");
        ciudadano.setProvincia("Pich");

        Empleado empleado = function.aplicar(ciudadano);
        System.out.println(empleado);

        //UnaryOperator
        System.out.println("Unary Operator--------------------");
        IPersonaUnitaryOperator<Integer> unaryLambda = num -> num + num*2;
        System.out.println(unaryLambda.modificar(14));

        System.out.println("Unary Operator Funtion--------------------");
        IPersonaUniaryOperatorFunction<Integer> unaryOperator2 = numero-> numero*2;
        System.out.println(unaryOperator2);


        //Metodos Referenciados
        System.out.println("Metodos Referenciados--------------------");
        System.out.println("Supplier Referenciado--------------------");
        MetodosReferenciados metodosReferenciados = new MetodosReferenciados();
        IPersonaSupplier<String> supplier = metodosReferenciados::obtenerId;
        System.out.println(supplier.getid());

        System.out.println("Consumer Referenciado--------------------");
        IPersonaConsumer<String> consumerReferenciado = metodosReferenciados::procesar;
        consumerReferenciado.acceptar("e");

        System.out.println("Predicate Referenciado--------------------");
        IPersonaPredicate<Integer> predicateInteger= metodosReferenciados::evaluar;
        IPersonaPredicate<String> predicateString = metodosReferenciados::evaluar;

        System.out.println(predicateInteger.evaluar(4));
        System.out.println(predicateString.evaluar("E"));

        System.out.println("Function Referenciado--------------------");
        IPersonaFunction<Ciudadano,Empleado> iPersonaFunction = metodosReferenciados::cambiar;
        System.out.println(iPersonaFunction.aplicar(empleado));

        System.out.println("UnaryOp Referenciado--------------------");
        IPersonaUnitaryOperator<Empleado> unary3 = metodosReferenciados::procesar;
        System.out.println(unary3);




    }
}
