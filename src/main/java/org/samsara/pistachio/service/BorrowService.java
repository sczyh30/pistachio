package org.samsara.pistachio.service;

import org.samsara.pistachio.mapper.BorrowStatusMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Samsara Pistachio Service
 * Book borrow service
 * @author sczyh30
 */
@Service(value = "borrowService")
public class BorrowService {

    @Resource
    BorrowStatusMapper mapper;



}
