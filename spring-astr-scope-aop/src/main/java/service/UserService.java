package service;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
// A differenza di singleton (il default) lo scope prototype
// crea un istanza diversa dell'oggetto ogni volta che ne viene richiesto uno
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UserService {

    public UserService() {
        System.out.println("Creata nuova istanza di UserService");
    }
}
