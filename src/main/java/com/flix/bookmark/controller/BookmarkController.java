package com.flix.bookmark.controller;

import com.flix.bookmark.dto.BookmarkDto;
import com.flix.bookmark.service.BookmarkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookmarks")
public class BookmarkController {

    private final BookmarkService bookmarkService;

    public BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    @PostMapping("/save")
    public void shortenUrl(@RequestBody BookmarkDto bookmark) {
        bookmarkService.shortenUrl(bookmark.url(), bookmark.name());
    }

    @GetMapping("/bookmark")
    public BookmarkDto getBookmark(@RequestParam String name) {
        return bookmarkService.getBookmark(name);
    }

    @GetMapping("/all")
    public List<String> getAll() {
        return bookmarkService.getAll();
    }
}
