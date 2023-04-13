package Symbol.Excuses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Symbol.Excuses.entity.Excuse;

@Repository
public interface ExcuseRepository extends JpaRepository<Excuse, Long>{}