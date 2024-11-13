package agora.webproject.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor //생성자 자동 생성(Lombok)
@NoArgsConstructor //매개변수 없는 기본 생성자 자동 생성(Lombok)
@Builder //Builder 패턴으로 객체 생성
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "id")

    private String username;
    private String password;
    private String email;
}
