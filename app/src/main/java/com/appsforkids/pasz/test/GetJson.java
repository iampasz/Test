package com.appsforkids.pasz.test;

import java.util.ArrayList;

public interface GetJson {
    ArrayList<AudioFile> getJson(String result);
    void noAnswer(Boolean answer);
}
