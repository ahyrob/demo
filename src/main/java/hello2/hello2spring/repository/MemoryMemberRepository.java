package hello2.hello2spring.repository;

import hello2.hello2spring.domain.Member;

import java.util.*;
// 회원 도메인 리포지토리 만들기
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }


    @Override
    public Optional<Member> finById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> finaAll() {
        return new ArrayList<>(store.values());
    }
}
