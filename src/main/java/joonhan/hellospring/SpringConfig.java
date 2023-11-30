package joonhan.hellospring;

import joonhan.hellospring.repository.JpaMemberRepository;
import joonhan.hellospring.repository.MemberRepository;
import joonhan.hellospring.repository.MemoryMemberRepository;
import joonhan.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {

        return new JpaMemberRepository(em);
    }
}
