package com.springuy.portaldatransparencia.framework;

import java.lang.reflect.Type;

public interface Consumer {

    <T> T retrieveData(String urlParameter, Type typeOfT);

}
