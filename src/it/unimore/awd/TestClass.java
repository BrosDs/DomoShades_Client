package it.unimore.awd;

import Classes.*;

import java.io.IOException;
import java.util.List;

public class TestClass {
    public static void main(String[] args) throws IOException {
        DomoWrapper domoWrapper = new DomoWrapper();
        String owner;
        String home;
        String id;
        String room_id;
        String window_id;

        /** Cleanup iniziale*/
        //domoWrapper.deleteUser("brosds@gmail.com");


        /** User */
        System.out.println(domoWrapper.putUser("brosds@gmail.com","Dario","Stabili","http://dummy.pic/ture"));
        System.out.println(domoWrapper.putUser("lukegalli@gmail.com","Luca","Gallinari","http://dummy.pic/ture"));

        User usr = domoWrapper.getUser("brosds@gmail.com");
        owner=usr.getEmail();

        System.out.println(domoWrapper.deleteUser("lukegalli@gmail.com"));

        /** Home */
        System.out.println(domoWrapper.putHome(owner,"Casa Mantova","Mantova",46031,"San Biagio","Via G. Verdi, 6"));
        System.out.println(domoWrapper.putHome(owner,"Casa Modena","Modena",42100,"Modena","Strada Vignolese, 925"));


        List<Home> hl = domoWrapper.getHomesByUser("brosds@gmail.com");
        if(hl==null)
            System.out.println("No Home retrieved");
        else
            for(Home h : hl){
                System.out.println(h.toString());
            }

        home = hl.get((hl != null ? hl.size() : 0) -1).getId().toString();
        hl = domoWrapper.deleteHome(owner, home);

        home = hl.get(0).getId().toString();

        /** Floor */
        System.out.println(domoWrapper.putFloor(owner,home,"1","0","Piano Terra"));
        System.out.println(domoWrapper.putFloor(owner,home,"2","1","Primo Piano"));

        List<Floor> lf = domoWrapper.getFloorsByHome(owner,home);
        if(lf==null)
            System.out.println("No Floor in this home");
        else
            for(Floor f : lf)
                System.out.println(f);

        id = lf.get((lf != null ? lf.size() : 0) -1).getId().toString();
        lf = domoWrapper.deleteFloor(owner,home,id);

        id = lf.get(0).getId().toString();

        System.out.println(domoWrapper.putRoom(owner,home,id,"1","Bagno"));
        System.out.println(domoWrapper.putRoom(owner,home,id,"2","Cucina"));
        System.out.println(domoWrapper.putRoom(owner,home,id,"3","Sala"));
        System.out.println(domoWrapper.putRoom(owner,home,id,"4","Terrazzo"));

         List<Room> lr = domoWrapper.getRoomsByFloor(owner,home,id);
         for(Room r : lr){
            System.out.println(r);
         }

        room_id = lr.get(lr.size()-1).getRoomNum().toString();
        lr = domoWrapper.deleteRoom(owner,home,id,room_id);
        room_id = lr.get(0).getRoomNum().toString();


        System.out.println(domoWrapper.putWindow(owner,home,id,room_id,"1"));
        System.out.println(domoWrapper.putWindow(owner,home,id,room_id,"2"));
        System.out.println(domoWrapper.putWindow(owner,home,id,room_id,"3"));
        System.out.println(domoWrapper.putWindow(owner,home,id,room_id,"4"));


        List<Window> lw = domoWrapper.getWindowsOfRoom(owner, home, id, room_id);
        for(Window r : lw){
            System.out.println(r);
        }

        window_id = lw.get(lw.size()-1).getWindowId().toString();
        lw = domoWrapper.deleteWindow(owner,home,id,room_id,window_id);
        window_id = lw.get(0).getWindowId().toString();


        System.out.println(domoWrapper.putRule(owner,home,id,room_id,window_id,"Prova Regola 1",2,"10:30","12:30",80));
        System.out.println(domoWrapper.putRule(owner,home,id,room_id,window_id,"Prova Regola 2",4,"12:30","14:30",85));
        System.out.println(domoWrapper.putRule(owner,home,id,room_id,window_id,"Prova Regola 3",6,"14:30","16:30",90));
        System.out.println(domoWrapper.putRule(owner,home,id,room_id,window_id,"Prova Regola 4",8,"16:30","18:30",95));



        System.out.println(domoWrapper.deleteRule(owner,home,id,room_id,window_id,"Prova Regola 1",2,"10:30","12:30",80));
        System.out.println(domoWrapper.deleteRule(owner,home,id,room_id,window_id,"Prova Regola 2",4,"12:30","14:30",85));
        System.out.println(domoWrapper.deleteRule(owner,home,id,room_id,window_id,"Prova Regola 3",6,"14:30","16:30",90));
        System.out.println(domoWrapper.deleteRule(owner,home,id,room_id,window_id,"Prova Regola 4",8,"16:30","18:30",95));



    }
}
