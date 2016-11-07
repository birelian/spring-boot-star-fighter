package net.birelian.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class StarFighter extends ModelItem {

    private static final long serialVersionUID = 5448518077813233172L;

    public StarFighter(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column
    private Integer length;

    @Column
    private Integer width;

    @Column
    private Integer height;

}
