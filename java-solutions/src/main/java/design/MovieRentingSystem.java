package design;

import java.util.*;

/**
 * @author FLIGHT
 * <p>
 * 1912. Design Movie Rental System
 * <p>
 * You have a movie renting company consisting of n shops.
 * You want to implement a renting system that supports searching for, booking, and returning movies.
 * The system should also support generating a report of the currently rented movies.
 * <p>
 * Each movie is given as a 2D integer array entries where
 * entries[i] = [shopi, moviei, pricei] indicates that there is a copy of movie moviei at shop shopi with a rental price of pricei.
 * Each shop carries at most one copy of a movie moviei.
 * <p>
 * The system should support the following functions:
 * <p>
 * Search: Finds the cheapest 5 shops that have an unrented copy of a given movie.
 * The shops should be sorted by price in ascending order, and in case of a tie,
 * the one with the smaller shopi should appear first.
 * If there are less than 5 matching shops, then all of them should be returned.
 * If no shop has an unrented copy, then an empty list should be returned.
 * <p>
 * Rent: Rents an unrented copy of a given movie from a given shop.
 * Drop: Drops off a previously rented copy of a given movie at a given shop.
 * Report: Returns the cheapest 5 rented movies (possibly of the same movie ID) as a 2D list res
 * where res[j] = [shopj, moviej] describes that the jth cheapest rented movie moviej was rented from the shop shopj.
 * The movies in res should be sorted by price in ascending order, and in case of a tie,
 * the one with the smaller shopj should appear first, and if there is still tie,
 * the one with the smaller moviej should appear first.
 * If there are fewer than 5 rented movies, then all of them should be returned.
 * If no movies are currently being rented, then an empty list should be returned.
 * Implement the MovieRentingSystem class:
 * <p>
 * MovieRentingSystem(int n, int[][] entries) Initializes the MovieRentingSystem object with n shops and the movies in entries.
 * List<Integer> search(int movie) Returns a list of shops that have an unrented copy of the given movie as described above.
 * void rent(int shop, int movie) Rents the given movie from the given shop.
 * void drop(int shop, int movie) Drops off a previously rented movie at the given shop.
 * List<List<Integer>> report() Returns a list of cheapest rented movies as described above.
 * Note: The test cases will be generated such that rent will only be called if the shop has an unrented copy of the movie,
 * and drop will only be called if the shop had previously rented out the movie.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["MovieRentingSystem", "search", "rent", "rent", "report", "drop", "search"]
 * [[3, [[0, 1, 5], [0, 2, 6], [0, 3, 7], [1, 1, 4], [1, 2, 7], [2, 1, 5]]], [1], [0, 1], [1, 2], [], [1, 2], [2]]
 * Output
 * [null, [1, 0, 2], null, null, [[0, 1], [1, 2]], null, [0, 1]]
 * <p>
 * Explanation
 * MovieRentingSystem movieRentingSystem = new MovieRentingSystem(3, [[0, 1, 5], [0, 2, 6], [0, 3, 7], [1, 1, 4], [1, 2, 7], [2, 1, 5]]);
 * movieRentingSystem.search(1);  // return [1, 0, 2], Movies of ID 1 are unrented at shops 1, 0, and 2.
 * Shop 1 is cheapest; shop 0 and 2 are the same price, so order by shop number.
 * movieRentingSystem.rent(0, 1); // Rent movie 1 from shop 0. Unrented movies at shop 0 are now [2,3].
 * movieRentingSystem.rent(1, 2); // Rent movie 2 from shop 1. Unrented movies at shop 1 are now [1].
 * movieRentingSystem.report();   // return [[0, 1], [1, 2]]. Movie 1 from shop 0 is cheapest, followed by movie 2 from shop 1.
 * movieRentingSystem.drop(1, 2); // Drop off movie 2 at shop 1. Unrented movies at shop 1 are now [1,2].
 * movieRentingSystem.search(2);  // return [0, 1]. Movies of ID 2 are unrented at shops 0 and 1. Shop 0 is cheapest, followed by shop 1.
 */
public class MovieRentingSystem {

  private final Map<Integer, TreeSet<MovieInfo>> unrented = new HashMap<>();

  private final TreeSet<MovieInfo> rented = new TreeSet<>(
    Comparator.comparing(MovieInfo::price).thenComparing(MovieInfo::shop).thenComparing(MovieInfo::movie)
  );

  private final Map<Integer, Map<Integer, MovieInfo>> movieToShopToInfo = new HashMap<>();

  public MovieRentingSystem(int n, int[][] entries) {
    for (int[] entry : entries) {
      MovieInfo movieInfo = MovieInfo.createFromEntry(entry);
      TreeSet<MovieInfo> movieInfoSet = unrented.computeIfAbsent(
        movieInfo.movie,
        p -> new TreeSet<>(Comparator.comparing(MovieInfo::price).thenComparing(MovieInfo::shop)));

      movieInfoSet.add(movieInfo);
      movieToShopToInfo.computeIfAbsent(movieInfo.movie(), p -> new HashMap<>()).put(movieInfo.shop(), movieInfo);
    }

  }

  public List<Integer> search(int movie) {
    if (!unrented.containsKey(movie))
      return Collections.emptyList();

    return unrented.get(movie).stream()
      .limit(5)
      .map(MovieInfo::shop)
      .toList();
  }

  public void rent(int shop, int movie) {
    MovieInfo movieInfo = movieToShopToInfo.get(movie).get(shop);
    unrented.get(movie).remove(movieInfo);
    rented.add(movieInfo);
  }

  public void drop(int shop, int movie) {
    MovieInfo movieInfo = movieToShopToInfo.get(movie).get(shop);
    rented.remove(movieInfo);
    unrented.get(movie).add(movieInfo);
  }

  public List<List<Integer>> report() {
    return rented.stream()
      .limit(5)
      .map(info -> List.of(info.shop(), info.movie()))
      .toList();
  }

  private record MovieInfo(int movie, int shop, int price) {
    public static MovieInfo createFromEntry(int[] entry) {
      return new MovieInfo(entry[1], entry[0], entry[2]);
    }
  }
}
