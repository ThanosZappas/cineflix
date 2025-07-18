package gr.android.cineflix.di;

import android.app.Application;

import androidx.room.Room;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import gr.android.cineflix.domain.repoInterfaces.MovieDetailsRepository;
import gr.android.cineflix.data.repo.MovieDetailsRepositoryImpl;
import gr.android.cineflix.data.repo.MovieRepositoryImpl;
import gr.android.cineflix.data.networkServices.MovieApiService;
import gr.android.cineflix.data.database.MovieDao;
import gr.android.cineflix.data.database.MovieDatabase;
import gr.android.cineflix.domain.repoInterfaces.MovieRepository;

@Module
@InstallIn(SingletonComponent.class)
public abstract class AppModule {

    @Provides
    public static MovieDatabase provideMovieDatabase(Application application) {
        return Room.databaseBuilder(application, MovieDatabase.class, "movie_db")
                .build();
    }

    @Provides
    public static MovieDao provideMovieDao(MovieDatabase database) {
        return database.movieDao();
    }

    @Provides
    public static MovieRepository provideMovieRepository(MovieApiService apiService, MovieDao movieDao) {
        return new MovieRepositoryImpl(apiService, movieDao);
    }

    @Provides
    public static MovieDetailsRepository provideMovieDetailsRepository(MovieApiService apiService) {
        return new MovieDetailsRepositoryImpl(apiService);
    }
}

