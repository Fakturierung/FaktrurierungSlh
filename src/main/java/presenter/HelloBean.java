package presenter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("hello")
@RequestScoped
public class HelloBean {

	public String sayHello(){
		return "Hallo TEST";
	}
	
}
