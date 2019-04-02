package at.fhv.oo;

public class Stack {
    private int[] _stack;
    private int _sp = 0;


    public Stack(int n) {
        _stack = new int[n];
    }

    public void push(int value) {
        if (!isFull()) {
            _stack[_sp] = value;
            _sp++;
        }
    }

    public boolean isFull() {
        if (_sp >= _stack.length) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (_sp <= 0) {
        	return true;
        }
        return false;
    }

    public int pop() {
        if (!isEmpty()) {
            return _stack[--_sp];
        }
        return _sp;
    }
}

