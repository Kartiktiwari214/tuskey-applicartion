package com.app.taskey.repository;

import com.app.taskey.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task , Long> {
}
