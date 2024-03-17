package com.salihcanhiz.finalcase.entity;

import com.salihcanhiz.finalcase.enums.Rate;
import com.salihcanhiz.finalcase.general.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "COMMENT")
public class Comment extends BaseEntity {

    @SequenceGenerator(name = "Comment", sequenceName = "COMMENT_ID_SEQ")
    @Id
    @GeneratedValue(generator = "Comment",strategy = GenerationType.SEQUENCE)
   private Long id;

   @Column (name = "RESTAURANT_ID")
   private String restaurantId;

   @Column(name ="TEXT",length = 255)
   private String text;

   @Enumerated(EnumType.STRING)
   @Column(name = "RATE" , length = 30)
   private Rate rate;

}
