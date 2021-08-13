package common;


public class ListNodeEpi<T> {
    public T data;
    public ListNodeEpi<T> next;

    public ListNodeEpi(T i, Object o) {
        this.data = i;
        this.next = (ListNodeEpi<T>) o;
    }

}
