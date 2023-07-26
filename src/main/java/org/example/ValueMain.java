package org.example;

public class ValueMain {
    public static void main(String[] args) {

        int a = 10;
        int b = 10;

        System.out.println("(a == b) = " + (a == b));

        Address address1 = new Address("city", "street", "100000");
        Address address2 = new Address("city", "street", "100000");

        System.out.println("(address1 instanceof Address) = " + (address1 instanceof Address));
        System.out.println("address2.equals(address1) = " + address2.equals(address1));

        

    }
}
