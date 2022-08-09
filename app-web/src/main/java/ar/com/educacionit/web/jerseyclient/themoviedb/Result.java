
package ar.com.educacionit.web.jerseyclient.themoviedb;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"adult",
"backdrop_path",
"genre_ids",
"id",
"original_language",
"original_title",
"overview",
"popularity",
"poster_path",
"release_date",
"title",
"video",
"vote_average",
"vote_count"
})
public class Result {

	@JsonProperty("adult")
	public Boolean adult;
	@JsonProperty("backdrop_path")
	public String backdropPath;
	@JsonProperty("genre_ids")
	public List<Integer> genreIds = new ArrayList<Integer>();
	@JsonProperty("id")
	public Integer id;
	@JsonProperty("original_language")
	public String originalLanguage;
	@JsonProperty("original_title")
	public String originalTitle;
	@JsonProperty("overview")
	public String overview;
	@JsonProperty("popularity")
	public Double popularity;
	@JsonProperty("poster_path")
	public String posterPath;
	@JsonProperty("release_date")
	public String releaseDate;
	@JsonProperty("title")
	public String title;
	@JsonProperty("video")
	public Boolean video;
	@JsonProperty("vote_average")
	public Double voteAverage;
	@JsonProperty("vote_count")
	public Integer voteCount;

	
	public Boolean getAdult() {
		return adult;
	}


	public void setAdult(Boolean adult) {
		this.adult = adult;
	}


	public String getBackdropPath() {
		return backdropPath;
	}


	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}


	public List<Integer> getGenreIds() {
		return genreIds;
	}


	public void setGenreIds(List<Integer> genreIds) {
		this.genreIds = genreIds;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getOriginalLanguage() {
		return originalLanguage;
	}


	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}


	public String getOriginalTitle() {
		return originalTitle;
	}


	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}


	public String getOverview() {
		return overview;
	}


	public void setOverview(String overview) {
		this.overview = overview;
	}


	public Double getPopularity() {
		return popularity;
	}


	public void setPopularity(Double popularity) {
		this.popularity = popularity;
	}


	public String getPosterPath() {
		return posterPath;
	}


	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}


	public String getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Boolean getVideo() {
		return video;
	}


	public void setVideo(Boolean video) {
		this.video = video;
	}


	public Double getVoteAverage() {
		return voteAverage;
	}


	public void setVoteAverage(Double voteAverage) {
		this.voteAverage = voteAverage;
	}


	public Integer getVoteCount() {
		return voteCount;
	}


	public void setVoteCount(Integer voteCount) {
		this.voteCount = voteCount;
	}


	@Override
	public String toString() {
		return "Result [adult=" + adult + ", backdropPath=" + backdropPath + ", genreIds=" + genreIds + ", id=" + id
				+ ", originalLanguage=" + originalLanguage + ", originalTitle=" + originalTitle + ", overview="
				+ overview + ", popularity=" + popularity + ", posterPath=" + posterPath + ", releaseDate="
				+ releaseDate + ", title=" + title + ", video=" + video + ", voteAverage=" + voteAverage
				+ ", voteCount=" + voteCount + "]";
	}

}
