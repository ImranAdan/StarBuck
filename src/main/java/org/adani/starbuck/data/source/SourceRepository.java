package org.adani.starbuck.data.source;

import org.adani.starbuck.domain.source.Source;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;

@EnableJpaRepositories
public interface SourceRepository extends PagingAndSortingRepository<Source, Long> {

    Source findByName(String name);

}
