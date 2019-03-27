package xyz.steamfrog;

import com.ibasco.agql.protocols.valve.steam.webapi.interfaces.SteamUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.steamfrog.service.SteamUserService;

/**
 * SteamUserServiceTest
 *
 * @author Clevo
 * @date 2019/3/25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class})
@EnableAutoConfiguration
public class SteamUserServiceTest {

    @Autowired
    SteamUserService steamUserService;

    @Autowired
    SteamUser steamUser;

    @Test
    public void find(){
        steamUserService.findSteamUserInfoBySteamId(76561198085354613L,true);
    }

}
