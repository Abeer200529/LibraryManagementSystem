package org.lms.repo;

import org.lms.entities.IssueRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRecordRepo extends JpaRepository<IssueRecord, Integer> {
}
