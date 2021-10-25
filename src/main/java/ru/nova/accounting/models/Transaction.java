package ru.nova.accounting.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Date date;
    private String type;
    private int value;
    private String comment;
    private String iconUrl;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;

        Transaction that = (Transaction) o;

        if (value != that.value) return false;
        if (!id.equals(that.id)) return false;
        if (!Objects.equals(date, that.date)) return false;
        if (!Objects.equals(type, that.type)) return false;
        if (!Objects.equals(comment, that.comment)) return false;
        return Objects.equals(iconUrl, that.iconUrl);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + value;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (iconUrl != null ? iconUrl.hashCode() : 0);
        return result;
    }
}
