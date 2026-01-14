package iducs202012068.javaweb.fundmentals.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Blog {
    private long id;
    private String title;
    private String content;
    private String author;
    private String email;
}
