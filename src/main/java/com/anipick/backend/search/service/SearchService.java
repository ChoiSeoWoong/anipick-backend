package com.anipick.backend.search.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anipick.backend.anime.dto.AnimeItemDto;
import com.anipick.backend.common.dto.CursorDto;
import com.anipick.backend.search.dto.PersonItemDto;
import com.anipick.backend.search.dto.SearchAnimePageDto;
import com.anipick.backend.search.dto.SearchPersonPageDto;
import com.anipick.backend.search.dto.SearchStudioPageDto;
import com.anipick.backend.search.dto.StudioItemDto;
import com.anipick.backend.search.mapper.SearchMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchService {
	private final SearchMapper mapper;

	public SearchAnimePageDto findSearchAnimes(String query, Long lastId, Long size) {

		long totalCount = mapper.countSearchAnime(query);
		long personCount = mapper.countSearchPerson(query);
		long studioCount = mapper.countSearchStudio(query);

		List<AnimeItemDto> items = mapper.selectSearchAnimes(query, lastId, size);

		Long nextId;

		if (items.isEmpty()) {
			nextId = null;
		} else {
			nextId = items.getLast().getAnimeId();
		}

		CursorDto cursor = CursorDto.of(nextId);

		return new SearchAnimePageDto(totalCount, personCount, studioCount, cursor, items);
	}

	public SearchPersonPageDto findSearchPersons(String query, Long lastId, Long size) {
		long totalCount = mapper.countSearchPerson(query);
		long animeCount = mapper.countSearchAnime(query);
		long studioCount = mapper.countSearchStudio(query);

		List<PersonItemDto> items = mapper.selectSearchPersons(query, lastId, size);

		Long nextId;

		if (items.isEmpty()) {
			nextId = null;
		} else {
			nextId = items.getLast().getPersonId();
		}

		CursorDto cursor = CursorDto.of(nextId);

		return new SearchPersonPageDto(totalCount, animeCount, studioCount, cursor, items);
	}

	public SearchStudioPageDto findSearchStudios(String query, Long lastId, Long size) {
		long totalCount = mapper.countSearchStudio(query);
		long animeCount = mapper.countSearchAnime(query);
		long personCount = mapper.countSearchPerson(query);

		List<StudioItemDto> items = mapper.selectSearchStudios(query, lastId, size);

		Long nextId;

		if (items.isEmpty()) {
			nextId = null;
		} else {
			nextId = items.getLast().getStudioId();
		}

		CursorDto cursor = CursorDto.of(nextId);

		return new SearchStudioPageDto(totalCount, animeCount, personCount, cursor, items);
	}
}
