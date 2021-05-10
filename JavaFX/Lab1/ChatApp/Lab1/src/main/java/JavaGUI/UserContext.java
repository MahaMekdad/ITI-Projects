package JavaGUI;

import javafx.scene.image.ImageView;

public class UserContext {

    private String username;

    private ImageView userImg;

    private static UserContext userContextInstance = new UserContext();

    private UserContext(){};

    public static UserContext getUserContext(){
        return userContextInstance;
    }

    public void setUsername(String username){
        username = this.username;
    }

    public void setUserImg(ImageView userImg){
        userImg = this.userImg;
    }

    public String getUsername(){
        return username;
    }

    public ImageView getUserImg(){
        return userImg;
    }
}
