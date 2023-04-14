package org.beta.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoLogRepository  extends JpaRepository<VideoLog, String> {
}
