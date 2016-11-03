package net.birelian.repository;

import net.birelian.model.StarFighter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarFighterRepository extends JpaRepository<StarFighter, Integer> {
}
