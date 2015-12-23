package org.samsara.pistachio.controller;

import org.samsara.pistachio.entity.RequestError;
import org.samsara.pistachio.mapper.BookInfoMapper;
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
    private BookInfoMapper infoMapper;

    @RequestMapping(value = "/api/search", method = RequestMethod.GET)
    public Object searchBy(@RequestParam(value = "type") int type,
                           @RequestParam(value = "q") String q) {
        switch (type) {
            case API_SEARCH_ACCURATE_BY_NAME:
                return infoMapper.getByName(q);
            case API_SEARCH_ACCURATE_BY_AUTHOR:
                return infoMapper.getAllByAuthor(q);
            case API_SEARCH_VAGUE_BY_AUTHOR:
                return infoMapper.getAllByVgAuthor(q);
            case API_SEARCH_VAGUE_BY_NAME:
                return infoMapper.getAllByVgName(q);
            default:
                return new RequestError();
        }
    }
}
