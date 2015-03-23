package it.unimore.awd;

import Classes.User;
import com.google.gson.Gson;
import org.restlet.data.MediaType;
import org.restlet.resource.ClientResource;

import java.io.IOException;

public class DomoWrapper {
    private String uri;
    private String scope;

    public DomoWrapper(){
        this.uri="http://domoshades-apis.appspot.com/api";
        this.scope="";
    }

    /** TODO: Change return types **/
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

}
