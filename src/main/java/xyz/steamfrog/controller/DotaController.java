package xyz.steamfrog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.steamfrog.service.DotaService;

@RestController
public class DotaController {

  @Autowired
  private DotaService dotaService;

  @RequestMapping("/dota2/match/{steamId}")
  public Object getLatestMatch(@PathVariable Long steamId){
    return dotaService.findLatestDota2Match(steamId);
  }

  @RequestMapping("/dota2/match/detail/{matchId}")
  public Object getMatchDetail(@PathVariable Long matchId){
    return dotaService.getMatchDetails(matchId);
  }
}
