package com.anipick.backend.anime.mapper;

import java.util.List;

import com.anipick.backend.anime.domain.Anime;
import com.anipick.backend.anime.domain.AnimeCharacterRole;
import com.anipick.backend.anime.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AnimeMapper {
	List<AnimeIdTitleImgItemDto> selectUpcomingSeasonAnimes(RangeDateRequestDto rangeDateRequestDto);

	long countComingSoon(ComingSoonRequestDto comingSoonRequestDto);

	List<ComingSoonItemBasicDto> selectComingSoonLatestAnimes(ComingSoonRequestDto comingSoonRequestDto);

	List<ComingSoonItemPopularityDto> selectComingSoonPopularityAnimes(ComingSoonRequestDto comingSoonRequestDto);

	List<ComingSoonItemBasicDto> selectComingSoonStartDateAnimes(ComingSoonRequestDto comingSoonRequestDto);

	Anime selectAnimeByAnimeId(@Param("animeId") Long animeId);

	void updatePlusReviewCount(@Param("animeId") Long animeId);

	void updateMinusReviewCount(@Param("animeId") Long animeId);

	List<AnimeDetailInfoReviewsItemDto> selectAnimeDetailInfoReviews(AnimeDetailInfoReviewsRequestDto reviewsRequestDto);

	long selectAnimeReviewCount(@Param("animeId") Long animeId);
  
	AnimeDetailInfoItemDto selectAnimeInfoDetail(
			@Param(value = "animeId") Long animeId,
			@Param(value = "userId") Long userId
  );
  
	List<AnimeItemDto> selectAnimeInfoRecommendationsByAnimeId(
			@Param("animeId") Long animeId,
			@Param("size") int size
  );
  
  List<AnimeDateItemDto> selectAnimeInfoSeriesByAnimeId(
			@Param("animeId") Long animeId,
			@Param("size") int size
  );
  
	List<AnimeCharacterActorItemDto> selectAnimeInfoCharacterActors(
			@Param("animeId") Long animeId,
			@Param("size") int size
  );
  
	void updateReviewAverageScore(
			@Param("animeId") Long animeId,
			@Param("reviewAverageScore") Double reviewAverageScore
	);

	List<AnimeCharacterActorResultDto> selectAnimeCharacterActors(
        @Param(value = "animeId") Long animeId,
        @Param(value = "lastId") Long lastId,
        @Param(value = "lastValue") AnimeCharacterRole lastValue,
        @Param(value = "size") int size
    );

	List<AnimeItemDto> selectRecommendationsByAnimeId(
			@Param(value = "animeId") Long animeId,
			@Param(value = "lastId") Long lastId,
			@Param(value = "size") int size
	);

	long countSeriesAnime(@Param(value = "animeId") Long animeId);

	List<AnimeDateItemDto> selectSeriesByAnimeId(
			@Param(value = "animeId") Long animeId,
			@Param(value = "lastId") Long lastId,
			@Param(value = "size") int size
	);
}
