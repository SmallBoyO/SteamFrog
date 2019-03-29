package xyz.steamfrog.config.agql;

import com.ibasco.agql.protocols.valve.dota2.webapi.interfaces.Dota2Econ;
import com.ibasco.agql.protocols.valve.dota2.webapi.interfaces.Dota2Fantasy;
import com.ibasco.agql.protocols.valve.dota2.webapi.interfaces.Dota2Match;
import com.ibasco.agql.protocols.valve.dota2.webapi.interfaces.Dota2Stats;
import com.ibasco.agql.protocols.valve.steam.webapi.SteamWebApiClient;
import com.ibasco.agql.protocols.valve.steam.webapi.interfaces.SteamUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ASQL库引入
 *
 * @author zhanghe
 * @date 2019/3/25
 */
@Configuration
public class AsyncGameQueryLibConfiguration {

    @Value("${steamWebApiKey:test}")
    private String steamWebApiKey;

    @Bean
    public SteamWebApiClient getSteamWebApiClient(){
        return new SteamWebApiClient(steamWebApiKey);
    }

    @Bean
    public SteamUser getSteamUser(){
        return new SteamUser(getSteamWebApiClient());
    }

    @Bean
    public Dota2Econ getDota2Econ(){
        return  new Dota2Econ(getSteamWebApiClient());
    }

    @Bean
    public Dota2Fantasy getDota2Fantasy(){
        return new Dota2Fantasy(getSteamWebApiClient());
    }

    @Bean
    public Dota2Stats getDota2Stats(){
        return new Dota2Stats(getSteamWebApiClient());
    }

    @Bean
    public Dota2Match getDota2Match(){
        return new Dota2Match(getSteamWebApiClient());
    }

}
