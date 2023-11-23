package hello2.hello2spring.repository;

import hello2.hello2spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> finById(Long id);
    Optional<Member> findByName(String name);
    List<Member> finaAll();
}
