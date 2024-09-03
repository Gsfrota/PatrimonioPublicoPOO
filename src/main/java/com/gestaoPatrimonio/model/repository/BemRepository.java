import java.util.List;
import java.util.Optional;

public interface BemRepository {
    void save(Bem bem);

    Optional<Bem> findById(int id);

    List<Bem> findAll();

    void update(Bem bem);

    void delete(int id);

    List<Bem> findBySetor(Setor setor);
}