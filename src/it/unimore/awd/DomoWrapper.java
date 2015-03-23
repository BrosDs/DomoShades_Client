package it.unimore.awd;

import Classes.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.restlet.data.MediaType;
import org.restlet.resource.ClientResource;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

public class DomoWrapper {
    private String uri;
    private String scope;

    public DomoWrapper(){
        this.uri="http://domoshades-apis.appspot.com/api";
        this.scope="";
    }


    /** User Functions **/
    public User getUser(String email) throws IOException {
        this.scope="/user?email="+email;
        ClientResource cr = new ClientResource(uri+scope);
        String returnString = cr.get(MediaType.APPLICATION_JSON).getText();
        if(returnString==null)
            return null;
        Gson gson = new Gson();
        return gson.fromJson(returnString,User.class);
    }

    public User putUser(String email, String first_name, String last_name, String profile_pic) throws IOException {
        this.scope="/user?email="+email+"&first_name="+first_name+"&last_name="+last_name+"&profile_pic="+profile_pic;
        ClientResource cr = new ClientResource(uri+scope);
        String returnString = cr.put(User.class).getText();
        if(returnString==null)
            return null;
        Gson gson = new Gson();
        return gson.fromJson(returnString,User.class);
    }

    public User deleteUser(String email) throws IOException {
        this.scope="/user?email="+email;
        ClientResource cr = new ClientResource(uri+scope);
        String returnString = cr.delete().getText();
        if(returnString==null)
            return null;
        Gson gson = new Gson();
        return gson.fromJson(returnString,User.class);
    }

    /** Home functions **/

    public List<Home> getHomesByUser(String owner) throws IOException {
        this.scope="/home?owner="+owner;
        ClientResource cr = new ClientResource(uri+scope);
        String returnString = cr.get(MediaType.APPLICATION_JSON).getText();
        if(returnString.equals("[]"))
            return null;
        Gson gson = new Gson();
        TypeToken<List<Home>> token = new TypeToken<List<Home>>(){};
        return gson.fromJson(returnString,token.getType());
    }

    public Home putHome(String owner, String description, String city, int cap, String country, String address) throws IOException {
        this.scope= String.format("/home?owner=%s&description=%s&city=%s&cap=%s&country=%s&address=%s", owner, URLEncoder.encode(description, "UTF-8"), URLEncoder.encode(city,"UTF-8"), cap, URLEncoder.encode(country,"UTF-8"), URLEncoder.encode(address,"UTF-8"));
        ClientResource cr = new ClientResource(uri+scope);
        System.out.println(uri+scope);
        String returnString = cr.put(Home.class).getText();
        if(returnString.equals("[]"))
            return null;
        Gson gson = new Gson();
        return gson.fromJson(returnString,Home.class);
    }

    public List<Home> deleteHome(String owner, String id) throws IOException {
        this.scope="/home?owner="+owner+"&id="+id;
        ClientResource cr = new ClientResource(uri+scope);
        String returnString = cr.delete().getText();
        if(returnString.equals("[]"))
            return null;
        Gson gson = new Gson();
        TypeToken<List<Home>> token = new TypeToken<List<Home>>(){};
        return gson.fromJson(returnString,token.getType());
    }

    /** Floor Functions **/

    public List<Floor> getFloorsByHome(String owner, String home) throws IOException {
        this.scope=String.format("/floor?owner=%s&home=%s", owner,home);
        ClientResource cr = new ClientResource(uri+scope);
        String returnString = cr.get(MediaType.APPLICATION_JSON).getText();
        if(returnString.equals("[]"))
            return null;
        Gson gson = new Gson();
        TypeToken<List<Floor>> token = new TypeToken<List<Floor>>(){};
        return gson.fromJson(returnString,token.getType());
    }


    public Floor putFloor(String owner, String home, String id, String type, String canvas) throws IOException {
        this.scope=String.format("/floor?owner=%s&home=%s&id=%s&type=%s&canvas=%s", owner,home,id,type,canvas);
        ClientResource cr = new ClientResource(uri+scope);
        System.out.println(uri+scope);
        String returnString = cr.put(Floor.class).getText();
        if(returnString.equals("[]"))
            return null;
        Gson gson = new Gson();
        return gson.fromJson(returnString,Floor.class);
    }

    public List<Floor> deleteFloor(String owner, String home, String id) throws IOException {
        this.scope=String.format("/floor?owner=%s&home=%s&id=%s", owner,home,id);
        ClientResource cr = new ClientResource(uri+scope);
        System.out.println(uri+scope);
        String returnString = cr.delete().getText();
        if(returnString.equals("[]"))
            return null;
        Gson gson = new Gson();
        TypeToken<List<Floor>> token = new TypeToken<List<Floor>>(){};
        return gson.fromJson(returnString,token.getType());
    }

    /** Room functions **/

    public List<Room> getRoomsByFloor(String owner, String home, String id) throws IOException {
        this.scope=String.format("/room?owner=%s&home=%s&id=%s", owner,home,id);
        ClientResource cr = new ClientResource(uri+scope);
        String returnString = cr.get(MediaType.APPLICATION_JSON).getText();
        if(returnString.equals("[]"))
            return null;
        Gson gson = new Gson();
        TypeToken<List<Room>> token = new TypeToken<List<Room>>(){};
        return gson.fromJson(returnString,token.getType());
    }

    public Room putRoom(String owner, String home, String id, String room_id, String name) throws IOException {
        this.scope=String.format("/room?owner=%s&home=%s&id=%s&room_id=%s&name=%s", owner,home,id,room_id,name);
        ClientResource cr = new ClientResource(uri+scope);
        String returnString = cr.put(Room.class).getText();
        if(returnString.equals("[]"))
            return null;
        Gson gson = new Gson();
        return gson.fromJson(returnString,Room.class);
    }

    public List<Room> deleteRoom(String owner, String home, String id, String room_id) throws IOException {
        this.scope=String.format("/room?owner=%s&home=%s&id=%s&room_id=%s", owner,home,id,room_id);
        ClientResource cr = new ClientResource(uri+scope);
        String returnString = cr.delete().getText();
        if(returnString.equals("[]"))
            return null;
        Gson gson = new Gson();
        TypeToken<List<Room>> token = new TypeToken<List<Room>>(){};
        return gson.fromJson(returnString,token.getType());
    }

    /** Window functions **/

    public List<Window> getWindowsOfRoom(String owner, String home, String id, String room_id) throws IOException {
        this.scope=String.format("/window?owner=%s&home=%s&id=%s&room_id=%s", owner,home,id,room_id);
        ClientResource cr = new ClientResource(uri+scope);
        String returnString = cr.get(MediaType.APPLICATION_JSON).getText();
        if(returnString.equals("[]"))
            return null;
        Gson gson = new Gson();
        TypeToken<List<Window>> token = new TypeToken<List<Window>>(){};
        return gson.fromJson(returnString,token.getType());
    }


    public Window putWindow(String owner, String home, String id, String room_id, String window_id) throws IOException {
        this.scope=String.format("/window?owner=%s&home=%s&id=%s&room_id=%s&window_id=%s", owner,home,id,room_id,window_id);
        ClientResource cr = new ClientResource(uri+scope);
        String returnString = cr.put(Window.class).getText();
        if(returnString.equals("[]"))
            return null;
        Gson gson = new Gson();
        return gson.fromJson(returnString,Window.class);
    }

    public List<Window> deleteWindow(String owner, String home, String id, String room_id, String window_id) throws IOException {
        this.scope=String.format("/window?owner=%s&home=%s&id=%s&room_id=%s&window_id=%s", owner,home,id,room_id,window_id);
        ClientResource cr = new ClientResource(uri+scope);
        String returnString = cr.delete().getText();
        if(returnString.equals("[]"))
            return null;
        Gson gson = new Gson();
        TypeToken<List<Window>> token = new TypeToken<List<Window>>(){};
        return gson.fromJson(returnString,token.getType());
    }
}
