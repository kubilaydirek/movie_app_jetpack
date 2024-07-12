package com.kolaysoft.basicmovieapp.data.model

data class MovieItem(
    val movieComingSoon: Boolean,
    val movieTitle: String,
    val movieYear: String,
    val movieRate: String,
    val movieReleased: String,
    val movieGenre: String,
    val movieDirector: String,
    val movieWriter: String,
    val movieActors: String,
    val moviePlot: String,
    val movieLanguage: String,
    val movieCountry: String,
    val movieAwards: String,
    val moviePoster: String,
    val movieMetaScore: String,
    val movieImdbRating: String,
    val movieImdbVotes: String,
    val movieImdbID: String,
    val movieType: String,
    val movieImages: List<String>
)

