package com.example.demo2.repo;

import com.example.demo2.entity.Member;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MemberRepository extends PagingAndSortingRepository<Member, Long> {
}
