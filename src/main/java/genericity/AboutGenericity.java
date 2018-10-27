package genericity;

public class AboutGenericity<E> {
    E element;
    E[] eleArray;

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public E[] getEleArray() {
        return eleArray;
    }

    public void setEleArray(E[] eleArray) {
        this.eleArray = eleArray;
    }
}
