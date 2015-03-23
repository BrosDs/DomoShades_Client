package it.unimore.awd;

import java.io.IOException;

public class TestClass {
    public static void main(String[] args) throws IOException {
        DomoWrapper domoWrapper = new DomoWrapper();

        /** User usage example
        // GET
        User user = domoWrapper.getUser("brosds@gmail.com");
        if(user == null)
            System.out.println("No User retrieved");
        else
            System.out.println(user);

        // PUT
        System.out.println(domoWrapper.putUser("brosds@gmail.com","Dario","Stabili","http://dummy.pic/ture"));

        // DELETE
        System.out.println(domoWrapper.deleteUser("brosds@gmail.com"));

        */

        /** Home usage example

         // PUT
        System.out.println(domoWrapper.putHome("brosds@gmail.com","Casa Mantova","Mantova",46031,"San Biagio","Via G. Verdi, 6"));

         // GET
        List<Home> hl = domoWrapper.getHomeList("brosds@gmail.com");
        if(hl==null)
            System.out.println("No Home retrieved");
        else
            System.out.println(hl.size());

         //DELETE
        hl = domoWrapper.deleteHome("brosds@gmail.com", "5668600916475904");

        if(hl==null)
            System.out.println("Empty home list");
        else
            System.out.println(hl.size());
         */




    }
}
