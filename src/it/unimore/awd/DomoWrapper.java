package it.unimore.awd;

import Classes.User;
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
    public void getUser(String email){
        this.scope="/user?email="+email;
        try {
            new ClientResource(uri+scope).get().write(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void putUser(String email, String first_name, String last_name, String profile_pic){
        this.scope="/user?email="+email+"&first_name="+first_name+"&last_name="+last_name+"&profile_pic="+profile_pic;
        try {
            new ClientResource(uri+scope).put(User.class).write(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String email){
        this.scope="/user?email="+email;
        try {
            new ClientResource(uri+scope).delete().write(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
