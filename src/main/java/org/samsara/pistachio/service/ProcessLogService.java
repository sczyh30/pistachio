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

    public boolean insertUserLog() {
        ProcessStatus status = new ProcessStatus();
        return mapper.insert(status);
    }

}
