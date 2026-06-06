package com.flix.bookmark.service;

import com.flix.bookmark.dto.BookmarkDto;
import com.flix.bookmark.entity.Bookmark;
import com.flix.bookmark.mapper.BookmarkMapper;
import com.flix.bookmark.repository.BookmarkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    public BookmarkService(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    public void shortenUrl(String url, String name) {
        bookmarkRepository.save(Bookmark.builder().url(url).name(name).build());
    }

    public BookmarkDto getBookmark(String name) {
        Bookmark found = bookmarkRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Bookmark not found"));

        return BookmarkMapper.bookmarkDto(found);
    }

    public List<String> getAll() {
        return bookmarkRepository.findAll().stream().map(Bookmark::getName).toList();
    }
}
