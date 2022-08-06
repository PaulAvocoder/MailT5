package java.paul.galomzik.mailt5.Repository;

import java.paul.galomzik.mailt5.Model.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {
    List<Message> findAll();
}
