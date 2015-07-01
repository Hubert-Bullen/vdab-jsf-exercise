package be.vdab;

import be.vdab.domain.User;
import be.vdab.repository.UserRepository;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by Hyuberuto on 30/06/15.
 */

@Named
@RequestScoped
public class UserController {

    private User user;

    @Inject
    private UserRepository userRepository;


    @PostConstruct
    public void init(){
        String stringId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        if(stringId != null && !stringId.equals("")) {
            // Edit mode
            int id = Integer.parseInt(stringId);
            user = userRepository.findById(id);
        } else {
            // Create mode
            user = new User();
        }

    }
    //TODO editing an existing user still makes a new one , fix this!



    public List getAll(){
        return userRepository.findAll();
    }

    public void save(){
        userRepository.saveUser(user);

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
