package dat3.amager_records_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Lob
    @Column(name = "image", columnDefinition = "MEDIUMBLOB")
    private byte[] img;
    private String textField;
    private String headline;
    @OneToOne
    private EventEntity event;
    /*
    @OneToMany(mappedBy = "news",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Vinyl> vinyls;

    public void addVinyl(Vinyl v){
        if(vinyls ==null){
            vinyls =new ArrayList<>();
        }
        vinyls.add(v);
    }
      public News(String img, String textField, String headline, Vinyl vinyl){
        this.img = img;
        this.textField = textField;
        this.headline = headline;
        this.vinyl = vinyl;
    }
     */
    public News(byte[] img, String textField, String headline, EventEntity event){
        this.img = img;
        this.textField = textField;
        this.headline = headline;
        this.event = event;
    }



    public News(byte[] img, String textField, String headline){
        this.img = img;
        this.textField = textField;
        this.headline = headline;

    }



}
