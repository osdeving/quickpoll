package com.willams.quickpoll.repository;

import com.willams.quickpoll.model.Poll;
import org.springframework.data.repository.CrudRepository;

public interface PollRepository extends CrudRepository<Poll, Long> {

}
