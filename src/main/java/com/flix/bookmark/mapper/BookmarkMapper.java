package com.flix.bookmark.mapper;

import com.flix.bookmark.dto.BookmarkDto;
import com.flix.bookmark.entity.Bookmark;

public record BookmarkMapper(String name, String url) {

    public static BookmarkDto bookmarkDto(Bookmark bookmark) {
        return new BookmarkDto(bookmark.getName(), bookmark.getUrl());
    }
}
