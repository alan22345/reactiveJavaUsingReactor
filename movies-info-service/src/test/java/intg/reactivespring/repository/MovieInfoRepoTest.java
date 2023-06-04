package reactivespring.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;
import reactivespring.domain.MovieInfo;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@ActiveProfiles("test")
class MovieInfoRepoTest {

    @Autowired
    MovieInfoRepo movieInfoRepo;

    @BeforeEach
    void setUp(){
        List<MovieInfo> movieInfoList = List.of(new MovieInfo(null, "Batman Begins",
                        2005, List.of("Christian Bale", "Michael Cane"), LocalDate.parse("2005-06-15")),
                new MovieInfo(null, "The Dark Knight",
                        2008, List.of("Christian Bale", "HeathLedger"), LocalDate.parse("2008-07-18")),
                new MovieInfo("abc", "Dark Knight Rises",
                        2012, List.of("Christian Bale", "Tom Hardy"), LocalDate.parse("2012-07-20")));

        movieInfoRepo.saveAll(movieInfoList).blockLast();
    }

    @AfterEach
    void tearDown() {
        movieInfoRepo.deleteAll().block();
    }

    @Test
    void findAll(){
        Flux<MovieInfo> moviesInfoFlux = movieInfoRepo.findAll();

        StepVerifier.create(moviesInfoFlux)
                .expectNextCount(3)
                .verifyComplete();
    }
}