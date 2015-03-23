package it.unimore.awd;

import Classes.Home;
import Classes.User;
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

    public User getUser(String email) throws IOException {
        this.scope="/user?email="+email;
        ClientResource cr = new ClientResource(uri+scope);
        String returnString = cr.get(MediaType.APPLICATION_JSON).getText();
        if(returnString==null)
            return null;
        Gson gson = new Gson();
        User user = gson.fromJson(returnString,User.class);
        return user;
    }

    public User putUser(String email, String first_name, String last_name, String profile_pic) throws IOException {
        this.scope="/user?email="+email+"&first_name="+first_name+"&last_name="+last_name+"&profile_pic="+profile_pic;
        ClientResource cr = new ClientResource(uri+scope);
        String returnString = cr.put(User.class).getText();
        if(returnString==null)
            return null;
        Gson gson = new Gson();
        User user = gson.fromJson(returnString,User.class);
        return user;
    }

    public User deleteUser(String email) throws IOException {
        this.scope="/user?email="+email;
        ClientResource cr = new ClientResource(uri+scope);
        String returnString = cr.delete().getText();
        if(returnString==null)
            return null;
        Gson gson = new Gson();
        User user = gson.fromJson(returnString,User.class);
        return user;
    }

    public List<Home> getHomeList(String owner) throws IOException {
        this.scope="/home?owner="+owner;
        ClientResource cr = new ClientResource(uri+scope);
        String returnString = cr.get(MediaType.APPLICATION_JSON).getText();
        if(returnString.equals("[]"))
            return null;
        Gson gson = new Gson();
        TypeToken<List<Home>> token = new TypeToken<List<Home>>(){};
        List<Home> home = gson.fromJson(returnString,token.getType());
        return home;
    }

    public Home putHome(String owner, String description, String city, int cap, String country, String address) throws IOException {
        this.scope= String.format("/home?owner=%s&description=%s&city=%s&cap=%s&country=%s&address=%s", owner, URLEncoder.encode(description, "UTF-8"), URLEncoder.encode(city,"UTF-8"), cap, URLEncoder.encode(country,"UTF-8"), URLEncoder.encode(address,"UTF-8"));
        ClientResource cr = new ClientResource(uri+scope);
        System.out.println(uri+scope);
        String returnString = cr.put(Home.class).getText();
        if(returnString.equals("[]"))
            return null;
        Gson gson = new Gson();
        Home home = gson.fromJson(returnString,Home.class);
        return home;
    }

    /**
     * /home? owner=owner_email_address&
     *        id=home_id_number
     */
    public List<Home> deleteHome(String owner, String id) throws IOException {
        this.scope="/home?owner="+owner+"&id="+id;
        ClientResource cr = new ClientResource(uri+scope);
        String returnString = cr.delete().getText();
        if(returnString.equals("[]"))
            return null;
        Gson gson = new Gson();
        TypeToken<List<Home>> token = new TypeToken<List<Home>>(){};
        List<Home> home = gson.fromJson(returnString,token.getType());
        return home;
    }
}
