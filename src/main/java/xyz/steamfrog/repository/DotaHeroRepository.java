package xyz.steamfrog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.steamfrog.pojo.DotaHeroDO;

public interface DotaHeroRepository extends JpaRepository<DotaHeroDO,Long> {
}
