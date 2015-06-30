package be.vdab;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
//@RequestScoped  = 1 nieuwe fortune die per request gemaakt , en hij blijft ook voor die request/ @SessionScoped per session.
public class FortuneController {
    @Inject
    private FortuneRepository fortuneRepository;

    public String saySomethingCool() {
        List<Fortune> fortunes = fortuneRepository.findAll();
        return fortunes.get((int) (Math.random() * fortunes.size())).getMessage();
    }
}
