package code.caio.webserverjava.dtos;

import code.caio.webserverjava.models.UserModel;

public class UserDTO {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    private Long id;
    private String login;

    public UserDTO(UserModel user) {
        this.id = user.getId();
        this.login = user.getLogin();
    }

    static public UserDTO covertUserToDTO(UserModel user){
        return new UserDTO(user);
    }
}
