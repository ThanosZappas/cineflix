package gr.android.cineflix.data.networkServices;

import gr.android.cineflix.data.model.details.reviews.MovieDetailsReviewApiResponse;
import gr.android.cineflix.data.model.details.basicDetails.MovieDetailsRemote;
import gr.android.cineflix.data.model.home.MovieApiResponse;
import gr.android.cineflix.data.model.details.credits.MovieCreditsResponse;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MovieApiService {

    @GET("/3/movie/popular")
    Observable<MovieApiResponse> getPopularMovies();

    @GET("/3/movie/{movie_id}")
    Observable<MovieDetailsRemote> getMovieById(@Path("movie_id") Integer movie_id);

    @GET("/3/movie/{movie_id}/reviews")
    Observable<MovieDetailsReviewApiResponse> getReviewsById(@Path("movie_id") Integer movie_id);

    @GET("/3/movie/{movie_id}/similar")
    Observable<MovieApiResponse> getSimilarMovies(@Path("movie_id") Integer movie_id);

    @GET("/3/movie/{movie_id}/credits")
    Observable<MovieCreditsResponse> getMovieCredits(@Path("movie_id") Integer movie_id);
}
