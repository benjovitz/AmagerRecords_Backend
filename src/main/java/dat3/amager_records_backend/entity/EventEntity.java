package dat3.amager_records_backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import dat3.amager_records_backend.dto.EventRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class EventEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String title;

  private String description;

  @Lob
  @Column(name = "image", columnDefinition = "MEDIUMBLOB")
  private byte[] image;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private LocalDateTime dateTime;

  @JsonFormat(pattern = "yyyy-MM-dd")
  @CreationTimestamp
  private LocalDate created;

  public EventEntity(EventRequest e) {
    this.title = e.getTitle();
    this.description = e.getDescription();
    this.dateTime = e.getDateTime();
    this.image = e.getImage();
  }
}
