package xyz.steamfrog.config.agql;

import com.ibasco.agql.protocols.valve.steam.webapi.SteamWebApiClient;
import com.ibasco.agql.protocols.valve.steam.webapi.interfaces.SteamUser;
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
  public SteamWebApiClient getSteamWebApiClient() {
    return new SteamWebApiClient(steamWebApiKey);
  }

  @Bean
  public SteamUser getSteamUser() {
    return new SteamUser(getSteamWebApiClient());
  }

}
