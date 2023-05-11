package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        /*이게 스프링컨테이너라고 생각하면 된다. AnnotationConfigApplicationContext의 파라미터에는 설정 정보가 담긴 class(AppConfig.class)를 매개변수로 주면 되는데,
        이때, 스프링컨테이너에는 @Bean으로 등록된 메소드의 이름으로 저장이 된다. -> key = 메소드이름, value = 반환 되는 객체 인스턴스타입
         */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //첫번째 파라미터는 AppConfig에 @Bean으로 등록된 메소드 이름을 주고, 두번 째 매개변수는 반환 타입..?
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP); //Long 타입이라서 1L
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member ="+member.getName());
        System.out.println("find Member ="+findMember.getName());
    }
}
