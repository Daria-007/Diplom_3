package pageObjests;

public class User {
    private String email;
    private String password;
    private String name;

    public static User create(String email, String password, String name){
        return new User(email,password, name);
    }
    public User(String email, String password, String name){
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
