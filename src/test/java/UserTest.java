import API.UserAPI;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

public class UserTest {
    UserAPI userAPI = new UserAPI();

    @Test
    public void userCreateController() throws InterruptedException, JsonProcessingException {

        userAPI.userCreate();
        Thread.sleep(3000);
        //userAPI.userUpdate("MesutBis");
        userAPI.getUserInfo("MesutBis");
        userAPI.userDelete("MesutBis");
        userAPI.userLogin();
    }
}
