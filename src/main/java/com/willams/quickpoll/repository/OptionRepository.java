package com.willams.quickpoll.repository;

import com.willams.quickpoll.model.Option;
import org.springframework.data.repository.CrudRepository;

public interface OptionRepository extends CrudRepository<Option, Long> {

}
