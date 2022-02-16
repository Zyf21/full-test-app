package com.sectors.testbackend.reposiories;

import com.sectors.testbackend.entity.Record;
;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
}
