package xyz.steamfrog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import xyz.steamfrog.pojo.SteamUserDO;
import xyz.steamfrog.service.SteamUserService;

@RestController
public class SteamUserInfoController {
  @Autowired
  private SteamUserService steamUserService;

  @GetMapping("/steam/user/{steamId}")
  public SteamUserDO findBySteamId(@PathVariable Long steamId){
      return steamUserService.findSteamUserInfoBySteamId(steamId,true);
  }
}
