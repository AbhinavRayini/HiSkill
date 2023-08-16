package com.hv.hiskill.exception;

public class ManagerNotFoundException  extends RuntimeException{
    public ManagerNotFoundException(String Message)
    {
        super(Message);
    }
}
