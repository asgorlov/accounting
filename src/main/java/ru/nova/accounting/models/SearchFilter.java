package ru.nova.accounting.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class SearchFilter {
    private Calendar date;
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SearchFilter)) return false;

        SearchFilter that = (SearchFilter) o;

        if (!Objects.equals(date, that.date)) return false;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
