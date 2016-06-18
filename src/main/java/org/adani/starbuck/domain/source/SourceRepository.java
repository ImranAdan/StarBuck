package org.adani.starbuck.domain.source;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SourceRepository extends PagingAndSortingRepository<Source, Long> {

    Source findByName(String name);

    List<Source> findAllByType(Pageable pageable, SourceType type);
}
