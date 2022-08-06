package java.paul.galomzik.mailt5.Model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(schema = "public", name = "messages")
public class Message {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "increment")
    private Integer id;

    private String senderName;
    private String receiverName;
    private String message;
    private Status status;
    private String topic;
}
