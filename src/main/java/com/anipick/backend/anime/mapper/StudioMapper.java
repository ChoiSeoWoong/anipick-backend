package com.anipick.backend.anime.mapper;

import com.anipick.backend.search.dto.StudioItemDto;
import com.anipick.backend.studio.dto.StudioAnimeItemDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudioMapper {
    List<StudioItemDto> selectStudiosByAnimeId(@Param(value = "animeId") Long animeId);

    String selectStudioNameByStudioId(@Param(value = "studioId") Long studioId);

    List<StudioAnimeItemDto> selectAnimesOfStudio(
            @Param(value = "studioId") Long studioId,
            @Param(value = "lastId") Long lastId,
            @Param(value = "lastValue") Long lastValue,
            @Param(value = "size") int size
    );
}
