package com.springuy.portaldatransparencia.framework;

import javax.net.ssl.HttpsURLConnection;

interface ConnectionService {

    HttpsURLConnection connect(String urlParameter);

}
