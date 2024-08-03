import API.UserAPI;
import org.junit.Test;

public class UserTest {
    UserAPI userAPI = new UserAPI();

    @Test
    public void userCreateController() throws InterruptedException {

        userAPI.userCreate();
        Thread.sleep(3000);
       // userAPI.userUpdate("Mesut");
      //  userAPI.getUserInfo("MstBskn");
        userAPI.userDelete("MstBskn");
        userAPI.userLogin();
    }
}
