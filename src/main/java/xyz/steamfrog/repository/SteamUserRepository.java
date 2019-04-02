package xyz.steamfrog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.steamfrog.pojo.SteamUserDO;

public interface SteamUserRepository extends JpaRepository<SteamUserDO, Long> {

  Boolean existsBySteamId(Long steamId);

  SteamUserDO findBySteamId(Long steamId);

}
