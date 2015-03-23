package it.unimore.awd;

import java.io.IOException;

public class TestClass {
    public static void main(String[] args) throws IOException {
        DomoWrapper domoWrapper = new DomoWrapper();
        String owner = "brosds@gmail.com";
        String home = "5741031244955648";
        String id = "2";
        String room_id = "3";

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


        /** Floor Usage example

        // PUT
         System.out.println(domoWrapper.putFloor(owner,home,"2","0","piano terra"));



        //GET
        List<Floor> lf = domoWrapper.getFloorsByHome(owner,home);
        if(lf==null)
            System.out.println("No Floor in this home");
        else
            for(Floor f : lf)
                System.out.println(f);


        // DELETE
        lf = domoWrapper.deleteFloor(owner,home,id);

        if(lf==null)
            System.out.println("No Floor in this home");
        else
            for(Floor f : lf)
                System.out.println(f);
        */

        /** Room usage example
         System.out.println(domoWrapper.putRoom(owner,home,id,"1","Bagno"));
         System.out.println(domoWrapper.putRoom(owner,home,id,"2","Cucina"));
         System.out.println(domoWrapper.putRoom(owner,home,id,"3","Sala"));
         System.out.println(domoWrapper.putRoom(owner,home,id,"4","Terrazzo"));

         List<Room> lr = domoWrapper.getRoomsByFloor(owner,home,id);
         for(Room r : lr){
         System.out.println(r);
         }

         lr = domoWrapper.deleteRoom(owner,home,id,"4");

         for(Room r : lr){
         System.out.println(r);
         }

         **/

        /** Window usage example
        System.out.println(domoWrapper.putWindow(owner,home,id,room_id,"1"));
        System.out.println(domoWrapper.putWindow(owner,home,id,room_id,"2"));
        System.out.println(domoWrapper.putWindow(owner,home,id,room_id,"3"));
        System.out.println(domoWrapper.putWindow(owner,home,id,room_id,"4"));



        List<Window> lr = domoWrapper.getWindowsOfRoom(owner, home, id, room_id);
        for(Window r : lr){
            System.out.println(r);
        }

        lr = domoWrapper.deleteWindow(owner, home, id, room_id, "4");

        for(Window r : lr){
            System.out.println(r);
        }
        **/
    }
}
