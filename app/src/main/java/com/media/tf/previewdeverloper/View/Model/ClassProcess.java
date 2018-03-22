package com.media.tf.previewdeverloper.View.Model;

/**
 * Created by Windows 8.1 Ultimate on 17/03/2018.
 */

public class ClassProcess {
    String title, dricption;
    int linkimg;

    public String getTitle() {
        return title;
    }

    public ClassProcess(String title, String dricption, int linkimg) {
        this.title = title;
        this.dricption = dricption;
        this.linkimg = linkimg;
    }

    public String getDricption() {
        return dricption;
    }

    public int getLinkimg() {
        return linkimg;
    }
}
