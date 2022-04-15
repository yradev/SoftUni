package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Agent;

// TODO:
@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
    Agent findAgentByFirstName(String firstName);
}
