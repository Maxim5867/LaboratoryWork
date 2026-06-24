package autopark.interfaces;

public interface Searchable<T> {
    boolean matches(String query);
}
