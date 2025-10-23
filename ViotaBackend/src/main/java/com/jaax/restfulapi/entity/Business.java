package com.jaax.restfulapi.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity //lo marca como entidad o objeto para que entre a la base de datos
@Table(name = "bussnies") //nombre de la tabla donde vamos a guardar
@Data // genera automaticamente get, set, toString, equals y hashcode
@AllArgsConstructor // genera constructor con todos los atributos
@NoArgsConstructor // genera constructor con cero atributos
@Builder // usa patron de diseño builder (no se que monda es eso)
public class Business {
    @Id // declaramos primary key para la bd
    @GeneratedValue(strategy = GenerationType.AUTO)//hace el incremento automatico de la primary jey
    private Long id;
    private String name;
    private String address;
    private String telephone;
    private String type;
    private String owner;

//    private Long id;
//    @NotBlank(message = "Please add the name")
//    private String name;
//    private String floor;
//    @Length(min = 4, max = 10)
//    private String code;
}
