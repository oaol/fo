package com.fo.up.core.pdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.springframework.util.ResourceUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class PdfUtil {

    /**
     * 字段库路径
     */
    private static final String TTF_URI = "classpath:templates/onboard/krungsri-simple.ttf";

    private PdfUtil() {
        
    }

    /**
     * 
     * @param templateUri pdf template
     * @param targetUri target pdf location
     * @param ttf font ttf file location
     * @param contens
     * @throws IOException
     */
    public static void resetContent(String templateUri, String targetUri, String ttf, List<PdfTextModel> contens)
            throws  IOException {
        try (PDDocument document = PDDocument.load(new File(templateUri)))
        {
            log.info("pdf template uri: {}", templateUri);
            PDPage page = document.getPage(0);
            File file = ResourceUtils.getFile(TTF_URI);
            log.info("pdf ttf: {}", file.getAbsolutePath());
            PDType0Font font = PDType0Font.load(document, file);
            try (PDPageContentStream stream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, false))
            {
                for (PdfTextModel pdfTextModel : contens) {
                    stream.beginText();
                    stream.setFont(font, pdfTextModel.getFontSize());
                    // (left, bottom)
                    stream.newLineAtOffset(pdfTextModel.getLeft(), pdfTextModel.getBottom());
                    stream.showText(pdfTextModel.getText());
                    stream.endText();
                }
                stream.close();
            } catch (Exception e) {
                log.error("draw pdf error, message: {}", e.getMessage(), e);
            }
            document.save(targetUri);
        }
    }
    
    public static void main(String[] args) {
        try {
            String a = null;
            ResourceUtils.getFile(a);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
