package com.fo.up.core.pdf;

import lombok.Data;

@Data
public class PdfTextModel {

    public PdfTextModel() {
        
    }

    public PdfTextModel(Integer fontSize, Integer left, Integer bottom, String text) {
        super();
        this.fontSize = fontSize;
        this.left = left;
        this.bottom = bottom;
        this.text = text;
    }

    private Integer fontSize;
    // 距离 page 左侧距离
    private Integer left;
    // 距离 page 底部距离
    private Integer bottom;
    // 内容
    private String text;
}
