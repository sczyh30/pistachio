package org.samsara.pistachio.controller;

import org.samsara.pistachio.entity.RequestError;
import org.samsara.pistachio.service.BookSearchService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Samsara Pistachio
 * Book search api controller<br>
 * @author sczyh30
 */
@RestController
public class BookSearchController {

    public static final int API_SEARCH_ACCURATE_BY_NAME = 1;
    public static final int API_SEARCH_ACCURATE_BY_AUTHOR = 2;
    public static final int API_SEARCH_ACCURATE_BY_PUBLISHER = 3;

    public static final int API_SEARCH_VAGUE_BY_NAME = 11;
    public static final int API_SEARCH_VAGUE_BY_AUTHOR = 12;
    public static final int API_SEARCH_VAGUE_BY_PUBLISHER = 13;

    @Resource
    private BookSearchService searchService;

    /**
     * Route of search api<br>
     * URL:<pre><code>/api/search</code></pre><br>
     * Method: <strong>GET</strong>
     * @param type search type
     * @param q query text
     * @return the result
     */
    @RequestMapping(value = "/api/search", method = RequestMethod.GET)
    public Object searchBy(@RequestParam(value = "type") int type,
                           @RequestParam(value = "q") String q) {
        //TODO: should return some info
        switch (type) {
            case API_SEARCH_ACCURATE_BY_NAME:
                return searchService.getByName(q);
            case API_SEARCH_ACCURATE_BY_AUTHOR:
                return searchService.getAllBooksByAuthor(q);
            case API_SEARCH_VAGUE_BY_AUTHOR:
                return searchService.getAllBooksByVgAuthor(q);
            case API_SEARCH_VAGUE_BY_NAME:
                return searchService.getAllBooksByVgName(q);
            default:
                return new RequestError();
        }
    }
}
