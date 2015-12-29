package org.samsara.pistachio.mapper;

import org.samsara.pistachio.entity.ProcessStatus;

import java.util.List;

/**
 * Samsara Pistachio
 * Process status mapper interface
 * @author sczyh30
 */
public interface ProcessStatusMapper {

    /**
     * Remove a process record
     * @param psid process id
     * @return the status
     */
    boolean remove(String psid);

    /**
     * Insert a process record
     * @param record record entity
     * @return the status
     */
    boolean insert(ProcessStatus record);

    /**
     * Get the record by PSID
     * @param psid process id
     * @return the process entity
     */
    ProcessStatus getByPSID(String psid);

    /**
     * Get all records
     * @return the process entity list
     */
    List<ProcessStatus> getAll();

    /**
     * Get the process list by user id
     * @param user_id user id
     * @return the process entity list
     */
    List<ProcessStatus> getByUser(int user_id);

    /**
     * Update
     * @param record the process entity
     * @return the status
     */
    int update(ProcessStatus record);

    int insertSelective(ProcessStatus record);
}