package reactivespring.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactivespring.domain.MovieInfo;

@Repository
public interface MovieInfoRepo extends ReactiveMongoRepository<MovieInfo, String> {

}
