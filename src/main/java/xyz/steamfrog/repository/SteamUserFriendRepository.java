package xyz.steamfrog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.steamfrog.pojo.SteamUserFriendDO;

/**
 * SteamUserFriendRepository
 *
 * @author Clevo
 * @date 2019/3/27
 */
public interface SteamUserFriendRepository extends JpaRepository<SteamUserFriendDO,Long> {
}
