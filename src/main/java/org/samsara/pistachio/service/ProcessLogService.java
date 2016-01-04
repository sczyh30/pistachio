package org.samsara.pistachio.service;

import org.samsara.pistachio.entity.ProcessStatus;
import org.samsara.pistachio.mapper.ProcessStatusMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Samsara Pistachio
 * Process Log Service
 * @author sczyh30
 * @since 0.3
 */
@Transactional
@Service("processLogService")
public class ProcessLogService {

    @Resource
    private ProcessStatusMapper mapper;

    /**
     * Insert process log of user
     * @param status status entity
     * @return if the process is ok
     */
    public boolean insertUserLog(ProcessStatus status) {
        return mapper.insert(status);
    }

}
