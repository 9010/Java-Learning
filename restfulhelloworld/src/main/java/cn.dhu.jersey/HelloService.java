package cn.dhu.jersey;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("hello")
public class HelloService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hi(){
        System.out.println("Got it!");
        return "Got it!";
    }
}
