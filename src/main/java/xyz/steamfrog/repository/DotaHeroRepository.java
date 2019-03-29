package xyz.steamfrog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.steamfrog.pojo.DotaHero;

public interface DotaHeroRepository extends JpaRepository<DotaHero,Long> {
}
